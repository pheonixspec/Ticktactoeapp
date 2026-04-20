public class UC4SlotToIndex {
    public static int[] toIndex(int slot) {
        int value = slot - 1;
        int row = value / 3;
        int col = value % 3;
        return new int[]{row, col};
    }

    public static void main(String[] args) {
        int[] index = toIndex(5);
        System.out.println("Row: " + index[0] + ", Col: " + index[1]);
    }
}
