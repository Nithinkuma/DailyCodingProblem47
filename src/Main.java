import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String line = br.readLine();
        String[] strs = line.trim().split(" ");

        ArrayList<Integer> list = new ArrayList<>();
        for (String str : strs) {
            list.add(Integer.parseInt(str));
        }

        System.out.println(getMaxProfit(list));
    }

    public static int getMaxProfit(ArrayList<Integer> stockPrices) {
        int maxProfit = 0;
        int min = stockPrices.get(0);

        for (int day = 1; day < stockPrices.size(); day++) {
            int curMaxProfit = stockPrices.get(day) - min;
            maxProfit = day == 1 ? curMaxProfit : Math.max(maxProfit, curMaxProfit);
            min = Math.min(min, stockPrices.get(day));
        }

        return maxProfit;
    }
}