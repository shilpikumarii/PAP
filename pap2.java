import java.util.PriorityQueue;
import java.util.Collections;

public class pap2 {
  public static int remainingGifts(int[] gifts, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    for (int gift : gifts) {
      maxHeap.add(gift);
    }

    while (k-- > 0 && !maxHeap.isEmpty()) {
      int maxGifts = maxHeap.poll();
      int reducedGifts = (int) Math.floor(Math.sqrt(maxGifts));
      maxHeap.add(reducedGifts);
    }

    int totalRemaining = 0;
    while (!maxHeap.isEmpty()) {
      totalRemaining += maxHeap.poll();
    }

    return totalRemaining;
  }

  public static void main(String[] args) {
    int[] gifts = { 25, 64, 9, 4, 100 };
    int k = 4;
    System.out.println("Remaining gifts: " + remainingGifts(gifts, k));
  }
}
