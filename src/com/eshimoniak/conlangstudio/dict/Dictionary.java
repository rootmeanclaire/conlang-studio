package com.eshimoniak.conlangstudio.dict;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

/**
 * @author Evan Shimoniak
**/
public class Dictionary {
	private String[] headers;
	private Map<String, String[]> entries;
	
	public Dictionary(String... headers) {
		this.headers = headers;
		entries = new HashMap<>();
	}
	public Dictionary(File f) {
		entries = new HashMap<>();
		
		try {
			FileInputStream is = new FileInputStream(f);
			BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String ln = in.readLine();
			
			if (ln != null) {
				headers = ln.split("(?<=[^\\\\](\\\\\\\\){0,99})\\,");
			} else {
				JOptionPane.showMessageDialog(null, "The dictionary is emptry", "Information", JOptionPane.INFORMATION_MESSAGE);
				headers = new String[0];
			}
			
			while ((ln = in.readLine()) != null) {
				String[] splitLn = ln.split("(?<=[^\\\\](\\\\\\\\){0,99})\\,");
				String[] entry = new String[headers.length - 1];
				for (int i = 0; i < entry.length; i++) {
					if (i + 1 >= splitLn.length || splitLn[i + 1].isEmpty()) {
						entry[i] = null;
					} else {
						entry[i] = splitLn[i + 1];
					}
				}
				entries.put(splitLn[0], entry);
			}
			in.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error reading dictionary file", "IO Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public int numEntries() {
		return entries.size();
	}
	
	public String[] getHeaders() {
		return headers;
	}
	public String[][] toArrays() {
		if (headers != null) {
			if (entries.size() > 0) {
				String[][] data = new String[entries.size()][headers.length];
				Iterator<Entry<String, String[]>> iter = entries.entrySet().iterator();
				
				for (int r = 0; r < data.length && iter.hasNext(); r++) {
					Map.Entry<String, String[]> entry = (Entry<String, String[]>) iter.next();
					String[] val = entry.getValue();
					data[r][0] = entry.getKey();
					for (int c = 0; c < val.length; c++) {
						if (val[c] == null) {
							data[r][c + 1] = "";
						} else {
							data[r][c + 1] = val[c];
						}
					}
				}
				
				return data;
			} else {
				String[][] data = new String[1][headers.length];
				for (int i = 0; i < headers.length; i++) {
					data[0][i] = "";
				}
				return data;
			}
		} else {
			return null;
		}
	}
	public String toFileString() {
		StringBuilder sb = new StringBuilder();
		
		if (headers.length > 0) {
			for (int i = 0; i < headers.length; i++) {
				sb.append(headers[i]);
				sb.append(',');
			}
			sb.setLength(sb.length() - 1);
			sb.append('\n');
			for (Map.Entry<String, String[]> entry : entries.entrySet()) {
				sb.append(entry.getKey());
				sb.append(',');
				for (String s : entry.getValue()) {
					if (s != null) {
						sb.append(s.replace(",", "\\,"));
					}
					sb.append(',');
				}
				sb.setLength(sb.length() - 1);
				sb.append('\n');
			}
		}
		
		return sb.toString();
	}
	
	public void addEntry(String[] entry) {
		if (entries.containsKey(entry[0])) {
			JOptionPane.showMessageDialog(null, "An entry for this " + headers[0].toLowerCase() + " already exists", "Dictionary Error", JOptionPane.ERROR_MESSAGE);
		} else {
			if (entry.length > headers.length) {
				throw new LongEntryException("Entry with length " + entry.length + " provided for slot with length " + headers.length);
			} else if (entry.length < headers.length) {
				String[] fitEntry = new String[headers.length - 1];
				for (int i = 0; i < headers.length - 1; i++) {
					fitEntry[i] = entry[i + 1];
				}
				entries.put(entry[0], fitEntry);
			} else {
				entries.put(entry[0], Arrays.copyOfRange(entry, 1, entry.length));
			}
		}
	}
	public void setEntry(String[] entry) {
		if (entry.length > headers.length) {
			throw new LongEntryException("Entry with length " + entry.length + " provided for slot with length " + headers.length);
		} else if (entry.length < headers.length) {
			String[] fitEntry = new String[headers.length - 1];
			for (int i = 0; i < headers.length - 1; i++) {
				fitEntry[i] = entry[i + 1];
			}
			entries.put(entry[0], fitEntry);
		} else {
			entries.put(entry[0], Arrays.copyOfRange(entry, 1, entry.length));
		}
	}
	public void removeEntry(String key) {
		entries.remove(key);
	}
	public Map<String, String> getEntry(String key) {
		Map<String, String> props = new HashMap<>();
		String[] storedProps = entries.get(key);
		
		for (int i = 0; i < headers.length; i++) {
			props.put(headers[i + 1], storedProps[i]);
		}
		
		return props;
	}
	public boolean hasEntry(String key) {
		return entries.containsKey(key);
	}
}
