package _4_mobile_rates_hierarchy;

import java.util.Comparator;

public abstract class BaseRate implements Comparable<BaseRate> {

    int abonentFee;

    int freeMinutes;
    int freeSms;
    int freeTraffic;

    double homeNetMinuteCost;
    double homeNetSmsCost;

    double otherNetMinuteCost;
    double otherNetSmsCost;

    double roamingMinuteCost;
    double roamingSmsCost;

    double traffic1MbCost;
    double roamingTraffic1MbCost;

    public BaseRate() {

        abonentFee = 0;

        freeMinutes = 0;
        freeSms = 0;
        freeTraffic = 0;

        homeNetMinuteCost = 1.0;
        homeNetSmsCost = 0.5;

        otherNetMinuteCost = 1.5;
        otherNetSmsCost = 1.0;

        roamingMinuteCost = 10.0;
        roamingSmsCost = 7.5;

        traffic1MbCost = 1.0;
        roamingTraffic1MbCost = 10.0;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " with abonent fee = " + abonentFee + ", average minute cost = " + getAverageMinuteCost() + ", average sms cost = " + getAverageSmsCost();
    }


    @Override
    public int compareTo(BaseRate otherRate) {
        return this.abonentFee - otherRate.abonentFee;
    }

    public static final Comparator<BaseRate> compareByAverageMinuteCost = new Comparator<BaseRate>() {
        public int compare(BaseRate r1, BaseRate r2) {
            if (r1.getAverageMinuteCost() > r2.getAverageMinuteCost())
                return 1;
            else if (r1.getAverageMinuteCost() < r2.getAverageMinuteCost())
                return -1;
            else
                return 0;
        }
    };

    public static final Comparator<BaseRate> compareByAverageSmsCost = new Comparator<BaseRate>() {
        public int compare(BaseRate r1, BaseRate r2) {
            if (r1.getAverageSmsCost() > r2.getAverageSmsCost())
                return 1;
            else if (r1.getAverageSmsCost() < r2.getAverageSmsCost())
                return -1;
            else
                return 0;
        }
    };

    private double getAverageSmsCost() {
        return round((homeNetSmsCost + otherNetSmsCost + roamingSmsCost) / 3, 2);
    }

    private double getAverageMinuteCost() {
        return round((homeNetMinuteCost + otherNetMinuteCost + roamingMinuteCost) / 3, 2);
    }

    private double round(double value, int places) {
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}