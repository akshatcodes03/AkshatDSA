class Solution {

    public int[] arrayRankTransform(int[] arr) {

        int[] copy = new int[arr.length];

        // Original array ko copy karo
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }

        // Copy ko sort karo
        Arrays.sort(copy);

        HashMap<Integer, Integer> box = new HashMap<>();

        int rank = 1;

        // Rank assign karo
        for (int i = 0; i < copy.length; i++) {

            if (!box.containsKey(copy[i])) {

                box.put(copy[i], rank);

                rank++;
            }
        }

        // Original array ko rank se replace karo
        for (int i = 0; i < arr.length; i++) {

            arr[i] = box.get(arr[i]);
        }

        return arr;
    }
}