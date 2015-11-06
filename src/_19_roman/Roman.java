package _19_roman;

public class Roman {

    public String toRoman(int arabic) {

        if (arabic < 1 || arabic > 999)
            throw new IllegalArgumentException();

        String roman = "";

        String onesArray[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String tensArray[] = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String hundredsArray[] = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};

        int ones = arabic % 10;

        arabic = (arabic - ones) / 10;
        int tens = arabic % 10;

        arabic = (arabic - tens) / 10;
        int hundreds = arabic % 10;

        if (hundreds >= 1)
            roman += hundredsArray[hundreds - 1];

        if (tens >= 1)
            roman += tensArray[tens - 1];

        if (ones >= 1)
            roman += onesArray[ones - 1];

        return String.valueOf(roman);
    }
}