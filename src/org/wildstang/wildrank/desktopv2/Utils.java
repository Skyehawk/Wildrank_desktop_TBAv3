package org.wildstang.wildrank.desktopv2;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*
 * Utils
 * ------
 * A bunch of things that are used throughout the app
 */
public class Utils {
	/*
	 * getJsonFromUrl downloads json from a given url and saves it to the data
	 * base
	 */
	public static String getJsonFromUrl(String url) {
		OkHttpClient client = new OkHttpClient();
		String tba_key = "XbxY9vzFoCOQaUlFcRkVzRrzsWR3HH76EEswH6bIqTROwPeO4e4gB9kBrzU8UDht";
		String accept_header = "application/json";
		
		Request request = new Request.Builder().url(url)
				.addHeader("accept", accept_header)
				.addHeader("X-TBA-Auth-Key", tba_key)
				.addHeader("User-Agent", "frcScouter").build();
		System.out.println(request);
		
		try {
			Response response = client.newCall(request).execute();
			return response.body().string();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
