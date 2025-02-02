<?php

class SolvexClient {
    private $apiKey;
    private $baseUrl = "https://api.solvex.ai";

    public function __construct($apiKey) {
        $this->apiKey = $apiKey;
    }

    public function getLeaderboard() {
        $ch = curl_init("{$this->baseUrl}/leaderboard");
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_HTTPHEADER, ["Authorization: Bearer {$this->apiKey}"]);
        $response = curl_exec($ch);
        curl_close($ch);
        return $response;
    }
}
?>
