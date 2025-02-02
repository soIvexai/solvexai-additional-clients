package com.solvexai;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class SolvexClient {
    private String apiKey;
    private final String BASE_URL = "https://api.solvex.ai";

    public SolvexClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getLeaderboard() throws Exception {
        URL url = new URL(BASE_URL + "/leaderboard");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "Bearer " + apiKey);

        Scanner scanner = new Scanner(conn.getInputStream());
        String response = scanner.useDelimiter("\\A").next();
        scanner.close();
        return response;
    }
}
