package org.jpmorgan.utils;

public class TicketUtil {
    public static String getSeatNumberFromRowCol(int row, int col) {
        StringBuilder chPart = new StringBuilder();

        while (row >= 0) {
            int v = row % 26;
            char ch = (char) ('A' + v);
            chPart.append(ch);
            row = row / 26 - 1;
        }

        chPart.reverse();
        chPart.append(col + 1);

        return chPart.toString();
    }

    public static String parseSeatFromTicketNumber(String ticketNumber) {
        String[] words = ticketNumber.split(":");
        return words[1];
    }

    public static String parseShowNumberFromTicketNumber(String ticketNumber) {
        String[] words = ticketNumber.split(":");
        return words[0];
    }

    public static int[] parseRowColFromTicketSeat(String seat) {
        String normalized = seat.toUpperCase();
        StringBuilder chPart = new StringBuilder();
        StringBuilder numPart = new StringBuilder();
        int i = 0;
        while (i < normalized.length() && Character.isAlphabetic(normalized.charAt(i))) {
            chPart.append(normalized.charAt(i));
            i += 1;
        }
        while (i < normalized.length() && Character.isDigit(normalized.charAt(i))) {
            numPart.append(normalized.charAt(i));
            i += 1;
        }
        if (i < normalized.length() || chPart.isEmpty() || numPart.isEmpty()) {
            return null;
        }
        return new int[]{alphaToNum(chPart.toString()), Integer.parseInt(numPart.toString())};
    }

    static int alphaToNum(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int v = ch - 'A' + 1;
            ans += v * (Math.pow(26, s.length() - 1 - i));
        }
        return ans;
    }
}
