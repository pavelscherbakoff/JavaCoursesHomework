package _4_mobile_rates_hierarchy;

public abstract class Prepaid extends BaseRate {

    public Prepaid() {
        homeNetMinuteCost = 0.9;
        homeNetSmsCost = 0.9;

        otherNetMinuteCost = 1.4;
        otherNetSmsCost = 1.4;

        roamingMinuteCost = 9.0;
        roamingNetSmsCost = 9.0;
    }
}
