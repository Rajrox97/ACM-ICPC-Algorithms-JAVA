import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class HeapBuilder {
    private List<Integer> data_;
    private List<Pair> swaps_;

    private class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private void writeResponse() {
        System.out.println(swaps_.size());
        for (Pair swap : swaps_) {
            System.out.println(swap.first + " " + swap.second);
        }
    }

    private void readData() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        data_ = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            data_.add(scanner.nextInt());
        }
    }

    private void generateSwaps() {
        swaps_ = new ArrayList<>();
        for (int i = data_.size() / 2; i >= 0; i--) {
            shiftDown(i);
        }
    }

    private void shiftDown(int i) {
        int minIndex = i;
        int left = 2 * i + 1;
        if (left < data_.size() && data_.get(left) < data_.get(minIndex)) {
            minIndex = left;
        }
        int right = 2 * i + 2;
        if (right < data_.size() && data_.get(right) < data_.get(minIndex)) {
            minIndex = right;
        }
        if (minIndex != i) {
            int temp = data_.get(i);
            data_.set(i, data_.get(minIndex));
            data_.set(minIndex, temp);
            swaps_.add(new Pair(i, minIndex));
            shiftDown(minIndex);
        }
    }

    public void solve() {
        readData();
        generateSwaps();
        writeResponse();
    }

    public static void main(String[] args) {
        HeapBuilder heapBuilder = new HeapBuilder();
        heapBuilder.solve();
    }
}


//By ChatGPT