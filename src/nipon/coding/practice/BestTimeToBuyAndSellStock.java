package nipon.coding.practice;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author saifulnipo
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock stock = new BestTimeToBuyAndSellStock();
        System.out.println(stock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(stock.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(stock.maxProfit(new int[]{1, 2}));
    }

    // O(n)
    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int currentProfit = Integer.MAX_VALUE, maxProfit = 0;
        for (int price : prices) {
            currentProfit = Math.min(currentProfit, price);
            maxProfit = Math.max(maxProfit, price - currentProfit);
        }
        return maxProfit;
    }

//    // O(n^2)
//    public int maxProfit(int[] prices) {
//
//        if (prices.length == 0) {
//            return 0;
//        }
//
//        int maxProfit = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                if (prices[i] < prices[j] && (prices[j] - prices[i]) > maxProfit) {
//                    maxProfit = prices[j] - prices[i];
//                }
//            }
//        }
//
//
//        return maxProfit;
//
//    }

}
