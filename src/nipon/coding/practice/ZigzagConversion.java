package nipon.coding.practice;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 *
 * @author saifulnipo
 */
public class ZigzagConversion {

    public static void main(String[] args) {
        ZigzagConversion msa = new ZigzagConversion();
        System.out.println(msa.convert("PAYPALISHIRING", 3));
        System.out.println(msa.convert("PAYPALISHIRING", 4));
        System.out.println(msa.convert("ABCD", 1));
        System.out.println(msa.convert("A", 1));
        System.out.println(msa.convert("ABC", 2));
        System.out.println(msa.convert("ABC", 3));
    }

    public String convert(String s, int numRows) {
        if (s.length() <= 1 || numRows <= 1) {
            return s;
        }


        int length = s.length(), column = (length % 2 == 0) ? (length / 2) : (length / 2) + 1;
        char[][] zigzagGround = new char[numRows][column];

        int currentRow = 0, currentColumn = 0;
        boolean downward = true, upward = false;
        for (int i = 0; i < length; i++) {

            if (currentRow < numRows && currentColumn < column) {
                zigzagGround[currentRow][currentColumn] = s.charAt(i);
            }

            if (currentRow == numRows - 1) {
                downward = false;
                upward = true;
            }

            if (currentRow == 0) {
                downward = true;
                upward = false;
            }

            if (downward) {
                currentRow++;
            }

            if (upward) {
                currentRow--;
                currentColumn++;
            }
        }

        return buildString(zigzagGround);
    }

    private String buildString(char[][] a) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (char[] chars : a) {
            for (char aChar : chars) {
                if (aChar != 0) {
                    stringBuilder.append(aChar);
                }
            }
        }
        return stringBuilder.toString();
    }
}
