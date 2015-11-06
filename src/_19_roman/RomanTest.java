package _19_roman;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class RomanTest {

    private Roman roman;

    @Before
    public void before() {
        roman = new Roman();
    }

    @Test
    public void checkClass() {
        assertTrue(roman instanceof Roman);
    }

    @Test
    public void checkType() {
        assertTrue(roman.toRoman(1) instanceof String);
    }

    @Test
    public void checkBottomRange() {
        try {
            roman.toRoman(0);
            fail("Out of range");
        } catch (Exception ignored) {
        }
    }

    @Test
    public void checkUpperRange() {
        try {
            roman.toRoman(1000);
            fail("Out of range");
        } catch (Exception ignored) {
        }
    }

    @Test
    public void checkOneDigitNumbers() {
        assertEquals("I", roman.toRoman(1));
        assertEquals("II", roman.toRoman(2));
        assertEquals("III", roman.toRoman(3));
        assertEquals("IV", roman.toRoman(4));
        assertEquals("V", roman.toRoman(5));
        assertEquals("VI", roman.toRoman(6));
        assertEquals("VII", roman.toRoman(7));
        assertEquals("VIII", roman.toRoman(8));
        assertEquals("IX", roman.toRoman(9));
    }

    @Test
    public void checkTwoDigitNumbers() {
        assertEquals("XVII", roman.toRoman(17));
        assertEquals("XXVI", roman.toRoman(26));
        assertEquals("XXX", roman.toRoman(30));
        assertEquals("XLIX", roman.toRoman(49));
        assertEquals("LVIII", roman.toRoman(58));
        assertEquals("LXII", roman.toRoman(62));
        assertEquals("LXXI", roman.toRoman(71));
        assertEquals("LXXXV", roman.toRoman(85));
        assertEquals("XCIV", roman.toRoman(94));
    }

    @Test
    public void checkThreeDigitNumbers() {
        assertEquals("CXI", roman.toRoman(111));
        assertEquals("CCXXII", roman.toRoman(222));
        assertEquals("CCCXXXIII", roman.toRoman(333));
        assertEquals("CDXLIV", roman.toRoman(444));
        assertEquals("DLV", roman.toRoman(555));
        assertEquals("DCLXVI", roman.toRoman(666));
        assertEquals("DCCLXXVII", roman.toRoman(777));
        assertEquals("DCCCLXXXVIII", roman.toRoman(888));
        assertEquals("CMXCIX", roman.toRoman(999));
    }
}
