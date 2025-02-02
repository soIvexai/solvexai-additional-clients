import Foundation

class SolvexClient {
    let apiKey: String
    let baseUrl = "https://api.solvex.ai"

    init(apiKey: String) {
        self.apiKey = apiKey
    }

    func getLeaderboard(completion: @escaping (String?) -> Void) {
        guard let url = URL(string: "\(baseUrl)/leaderboard") else { return }
        var request = URLRequest(url: url)
        request.setValue("Bearer \(apiKey)", forHTTPHeaderField: "Authorization")

        let task = URLSession.shared.dataTask(with: request) { data, _, _ in
            let response = data.flatMap { String(data: $0, encoding: .utf8) }
            completion(response)
        }
        task.resume()
    }
}
