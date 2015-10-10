package _6_mobile_rates_hierarchy_sorting;

import _3_mobile_rates_hierarchy.*;
import java.util.ArrayList;
import java.util.Collections;

public class Sorting {

    public static void main(String[] args) {

        ArrayList<BaseRate> rates = new ArrayList<>();
        rates.add(new HomeNet());
        rates.add(new Internet1GbLimit());
        rates.add(new Internet5GbLimit());
        rates.add(new Prepaid100Min20Sms());
        rates.add(new Prepaid200Min40Sms());
        rates.add(new Standard());
        rates.add(new Travel());

        Collections.sort(rates);
        System.out.println("Sorted by abonent fee: " + rates);

        Collections.sort(rates, BaseRate.compareByAverageMinuteCost);
        System.out.println("Sorted by average minute cost: " + rates);

        Collections.sort(rates, BaseRate.compareByAverageSmsCost);
        System.out.println("Sorted by average sms cost: " + rates);
    }

}
