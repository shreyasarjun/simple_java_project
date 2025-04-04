package com.example.oldapp;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

/**
 * Simple application using outdated Apache Commons Lang and HttpClient libraries
 * This code will require changes when updating to newer versions
 */
public class OldStyleApp {
    
    public static void main(String[] args) {
        OldStyleApp app = new OldStyleApp();
        app.processString("  Hello World  ");
        app.makeHttpRequest("http://example.com");
    }
    
    /**
     * Process a string using old Apache Commons Lang (v2.x)
     */
    public void processString(String input) {
        System.out.println("Original input: '" + input + "'");
        
        // Old style StringUtils methods
        String trimmed = StringUtils.strip(input);
        boolean isEmpty = StringUtils.isEmpty(input);
        boolean isAlpha = StringUtils.isAlpha(trimmed);
        
        System.out.println("Trimmed: '" + trimmed + "'");
        System.out.println("Is empty: " + isEmpty);
        System.out.println("Is alpha only: " + isAlpha);
    }
    
    /**
     * Make HTTP request using deprecated HttpClient 4.3.x API
     */
    public void makeHttpRequest(String url) {
        try {
            // This DefaultHttpClient is deprecated in newer versions
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(url);
            
            System.out.println("Making request to: " + url);
            
            // Old style response handling
            HttpResponse response = client.execute(request);
            String responseBody = EntityUtils.toString(response.getEntity());
            
            System.out.println("Response status: " + response.getStatusLine());
            System.out.println("Response length: " + responseBody.length() + " chars");
        } catch (Exception e) {
            System.err.println("Error making HTTP request: " + e.getMessage());
        }
    }
}
