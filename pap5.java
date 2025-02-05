import java.util.*;

class pap5 {
  public int coinChange(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }

    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;

    for (int coin : coins) {
      for (int i = coin; i <= amount; i++) {
        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
      }
    }

    return dp[amount] > amount ? -1 : dp[amount];
  }

  public static void main(String[] args) {
    pap5 solution = new pap5();
    int[] coins = { 1, 2, 5 };
    int amount = 11;
    System.out.println(solution.coinChange(coins, amount)); // Output: 3
  }
}
