#include <iostream>
#include <vector>
#include <climits>

using namespace std;

int minCoins(vector<int>& coins, int target) {
    int n = coins.size();
    
    // Crie um vetor para armazenar o número mínimo de moedas para alcançar cada valor de 0 a target.
    vector<int> dp(target + 1, INT_MAX);

    // O número mínimo de moedas para alcançar 0 é sempre 0.
    dp[0] = 0;

    // Preencha o vetor dp usando programação dinâmica.
    for (int i = 1; i <= target; ++i) {
        for (int j = 0; j < n; ++j) {
            if (coins[j] <= i && dp[i - coins[j]] != INT_MAX) {
                dp[i] = min(dp[i], dp[i - coins[j]] + 1);
            }
        }
    }

    // Se dp[target] ainda for INT_MAX, significa que não é possível fazer o troco.
    if (dp[target] == INT_MAX) {
        return -1;
    } else {
        return dp[target];
    }
}

int main() {
    vector<int> coins = {1, 3, 4, 5};
    int target = 7;
    
    int result = minCoins(coins, target);

    if (result == -1) {
        cout << "Não é possível fazer o troco." << endl;
    } else {
        cout << "Número mínimo de moedas: " << result << endl;
    }

    return 0;
}
