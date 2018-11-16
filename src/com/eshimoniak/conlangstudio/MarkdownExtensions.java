package com.eshimoniak.conlangstudio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

/**
 * Custom markdown shorthands
 * @author Evan Shimoniak
**/
public class MarkdownExtensions {
	private static JSONObject pConsData;
	
	public static void init() throws IOException {
		InputStream in = MarkdownExtensions.class.getClassLoader().getResourceAsStream("res" + File.separatorChar + "pcons.json"); 
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String ln = null;
		StringBuilder sb = new StringBuilder();
		
		while ((ln = reader.readLine()) != null) {
			sb.append(ln);
		}
		pConsData = new JSONObject(sb.toString());
	}

	public static String parseMarkdownExtensions(String text) {
		Pattern p = Pattern.compile("\\\\ipaChart:.+");
		Matcher m = p.matcher(text);
		StringBuilder sb = new StringBuilder();
		int endLast = 0;
		
		while (m.find()) {
			sb.append(text.substring(endLast, m.start()));
			String[] rawConsList = m.group().replaceAll("\\\\ipaChart:", "").split("(,| )+");
			List<String> newConsList = new ArrayList<>();
			for (int i = 0; i < rawConsList.length; i++) {
				if (!rawConsList[i].isEmpty()) {
					newConsList.add(rawConsList[i]);
				}
			}
			String pulmConsListTable = pulmConsListToMdTable(newConsList.toArray(new String[newConsList.size()]));
			sb.append(pulmConsListTable);
			endLast = m.end();
		}
		
		sb.append(text.substring(endLast));
		return sb.toString();
	}
	
	public static String pulmConsListToMdTable(String[] pulmConsList) {
		StringBuilder sb = new StringBuilder();
		List<String> manners = new ArrayList<>();
		List<String> places = new ArrayList<>();
		
		for (String pConsStr : pulmConsList) {
			JSONObject pCons = pConsData.getJSONObject(pConsStr);
			String thisManner = pCons.getString("manner");
			String thisPlace = pCons.getString("place");
			if (!manners.contains(thisManner)) {
				manners.add(thisManner);
			}
			if (!places.contains(thisPlace)) {
				places.add(thisPlace);
			}
		}
		
		sb.append("||");
		for (String place : places) {
			sb.append(Util.capitalize(place));
			sb.append('|');
		}
		sb.setLength(sb.length() - 1);
		sb.append("\n|:---");
		for (int i = 0; i < manners.size(); i++) {
			sb.append("|:---:");
		}
		sb.append("\n|");
		for (String manner : manners) {
			sb.append("**" + Util.capitalize(manner) + "**|");
			for (int i = 0; i < places.size(); i++) {
				String consPair = "";
				for (String pulmConsStr : pulmConsList) {
					JSONObject pulmCons = pConsData.getJSONObject(pulmConsStr);
					if (pulmCons.get("manner").equals(manner) && pulmCons.get("place").equals(places.get(i))) {
						if (pulmCons.getBoolean("voiced")) {
							consPair += pulmConsStr;
						} else {
							consPair = pulmConsStr + ", " + consPair;
						}
					}
				}
				sb.append(consPair.replaceAll(", $", ""));
				sb.append('|');
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n|");
		}
		
		sb.setLength(sb.length() - 2);
		
		return sb.toString();
	}
}
