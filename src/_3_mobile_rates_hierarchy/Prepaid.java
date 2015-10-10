package _3_mobile_rates_hierarchy;

public abstract class Prepaid extends BaseRate {

    public Prepaid() {
        homeNetMinuteCost = 0.9;
        homeNetSmsCost = 0.8;

        otherNetMinuteCost = 1.4;
        otherNetSmsCost = 1.3;

        roamingMinuteCost = 9.0;
        roamingSmsCost = 8.0;
    }
}
