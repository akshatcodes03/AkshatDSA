
import java.util.ArrayList;

class ProductOfNumbers {

    ArrayList<Integer> prefix = new ArrayList<>();

    // Constructor
    public ProductOfNumbers() {

        prefix.add(1);

    }

    // Add number
    public void add(int num) {

        if (num == 0) {

            prefix.clear();
            prefix.add(1);

        } 
        else {

            int last = prefix.get(prefix.size() - 1);

            prefix.add(last * num);

        }
    }

    // Product of last K numbers
    public int getProduct(int k) {

        int n = prefix.size();

        if (k >= n) {

            return 0;

        }

        return prefix.get(n - 1) / prefix.get(n - k - 1);
    }
}
