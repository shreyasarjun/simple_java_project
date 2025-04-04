package com.example.oldapp;

import org.apache.commons.lang3.StringUtils;  // Updated import for commons-lang3
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;  // Updated for newer HttpClient
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Updated application using modern Apache Commons Lang and HttpClient libraries
 */
public class OldStyleApp {
    private static final Logger logger = LoggerFactory.getLogger(OldStyleApp.class);
    
    public static void main(String[] args) {
        OldStyleApp app = new OldStyleApp();
        app.processString("  Hello World  ");
        app.makeHttpRequest("http://example.com");
    }
    
    /**
     * Process a string using Apache Commons Lang3
     */
    public void processString(String input) {
        logger.info("Original input: '{}'", input);
        
        // Updated StringUtils methods (API is similar but from commons-lang3)
        String trimmed = StringUtils.strip(input);
        boolean isEmpty = StringUtils.isEmpty(input);
        boolean isAlpha = StringUtils.isAlpha(trimmed);
        
        logger.info("Trimmed: '{}'", trimmed);
        logger.info("Is empty: {}", isEmpty);
        logger.info("Is alpha only: {}", isAlpha);
    }
    
    /**
     * Make HTTP request using modern HttpClient API
     */
    public void makeHttpRequest(String url) {
        try (CloseableHttpClient client = HttpClients.createDefault()) {  // Modern try-with-resources
            HttpGet request = new HttpGet(url);
            
            logger.info("Making request to: {}", url);
            
            // Modern response handling with automatic resource cleanup
            try (CloseableHttpResponse response = client.execute(request)) {
                String responseBody = EntityUtils.toString(response.getEntity());
                
                logger.info("Response status: {}", response.getStatusLine());
                logger.info("Response length: {} chars", responseBody.length());
            }
        } catch (Exception e) {
            logger.error("Error making HTTP request: {}", e.getMessage(), e);
        }
    }
}
