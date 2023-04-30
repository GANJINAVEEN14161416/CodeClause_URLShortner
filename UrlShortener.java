import java.util.HashMap;
import java.util.Random;

public class UrlShortener {
    private HashMap<String, String> keyMap; // Map to store the key and long URL
    private HashMap<String, String> valueMap;// Map to store the long URL and key
    private char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private Random rand; // Random object to generate random numbers

    private int keyLength; // Length of the shortened key

    // Constructor to initialize the object with default key length of 7
    public UrlShortener() {
        this.keyMap = new HashMap<String, String>();
        this.valueMap = new HashMap<String, String>();
        this.rand = new Random();
        this.keyLength = 7;
    }

    // Constructor to initialize the object with a custom key length
    public UrlShortener(int keyLength) {
        this.keyMap = new HashMap<String, String>();
        this.valueMap = new HashMap<String, String>();
        this.rand = new Random();
        this.keyLength = keyLength;
    }

    // Method to shorten the given URL
    public String shortenUrl(String longUrl) {
        String key = generateKey();
        keyMap.put(key, longUrl);
        valueMap.put(longUrl, key);
        return "http://short.url/" + key;
    }

    // Method to get the original URL from the shortened URL
    public String getLongUrl(String shortUrl) {
        String key = shortUrl.substring("http://short.url/".length());
        String longUrl = keyMap.get(key);
        return longUrl;
    }

    // Method to generate a random key
    private String generateKey() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keyLength; i++) {
            sb.append(chars[rand.nextInt(chars.length)]);
        }
        return sb.toString();
    }
}


class UrlShorteners {
    public static void main(String[] args) {
        UrlShortener urlShortener = new UrlShortener();
        String longUrl = "https://www.google.com/search?q=love+babbar+dsa+sheet&rlz=1C1CHBD_enIN1030IN1030&oq=love+babb&aqs=chrome.0.35i39j69i57j35i39j0i512l2j69i65j69i60l2.8799j0j7&sourceid=chrome&ie=UTF-8";
        String shortUrl = urlShortener.shortenUrl(longUrl);
        System.out.println("Shortened URL: " + shortUrl);
        System.out.println("Long URL: " + urlShortener.getLongUrl(shortUrl));
    }
}
