import java.util.Arrays;

public class MinimumCoinChange {
    public static int minimumCoins(int[] coins, int target) {
        // Crie um array para armazenar as soluções parciais.
        int[] dp = new int[target + 1];
        
        // Inicialize o array com um valor alto (representando infinito) para que possamos encontrar valores mínimos.
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // O número mínimo de moedas para fazer troco de 0 é 0.
        dp[0] = 0;

        // Percorra os valores de 1 até o valor alvo.
        for (int i = 1; i <= target; i++) {
            // Percorra todas as moedas disponíveis.
            for (int coin : coins) {
                if (i >= coin) {
                    // Se o valor atual for maior ou igual ao valor da moeda,
                    // calcule o número mínimo de moedas necessário para alcançar o valor atual.
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // Se o valor final em dp[target] ainda for o valor máximo, não foi possível fazer o troco.
        if (dp[target] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[target]; // Retorna o número mínimo de moedas necessário para alcançar o valor alvo.
        }
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int target = 11;
        int result = minimumCoins(coins, target);
        System.out.println("Número mínimo de moedas: " + result);
    }
}
