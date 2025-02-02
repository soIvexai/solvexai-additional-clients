using System;
using System.Net.Http;
using System.Threading.Tasks;

public class SolvexClient {
    private readonly HttpClient _client;
    private readonly string _apiKey;

    public SolvexClient(string apiKey) {
        _apiKey = apiKey;
        _client = new HttpClient();
    }

    public async Task<string> GetLeaderboardAsync() {
        _client.DefaultRequestHeaders.Add("Authorization", "Bearer " + _apiKey);
        var response = await _client.GetStringAsync("https://api.solvex.ai/leaderboard");
        return response;
    }
}
