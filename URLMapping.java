package motionCutWork;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class URLMapping {
	private Map<String, String> urlMap;
	private String domain;
	private static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private Random random;
	
	public URLMapping(String domain) {
		this.urlMap = new HashMap<>();
		this.domain = domain;
		this.random = new Random();
	}
	
	public String shortenURL(String longURL) {
		if(urlMap.containsValue(longURL)) {
			for(Map.Entry<String, String> entry: urlMap.entrySet()) {
				if(entry.getValue().equals(longURL)) {
					return domain + "/" + entry.getKey();
				}
			}
		}
		String shortCode = generateShortCode();
		urlMap.put(shortCode, longURL);
		return domain + "/" + shortCode;
	}
	
	public String getOriginalURL(String shortURL) {
		String shortCode = shortURL.replace(domain + "/", "");
		return urlMap.getOrDefault(shortCode, "URL not found.");
	}
	
	public String generateShortCode() {
		StringBuilder shortCode = new StringBuilder();
		for (int i = 0; i < 6; i++) {
            shortCode.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }
        return shortCode.toString();
	}
	
	public void displayURLs() {
		for (Map.Entry<String, String> entry : urlMap.entrySet()) {
            System.out.println("Short URL: " + domain + "/" + entry.getKey() + " -> Original URL: " + entry.getValue());
        }
	}
}
