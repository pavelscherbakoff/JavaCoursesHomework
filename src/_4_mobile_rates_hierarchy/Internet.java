package _4_mobile_rates_hierarchy;

public abstract class Internet extends BaseRate {

    public Internet() {
        homeNetMinuteCost = 1.5;
        homeNetSmsCost = 1.0;

        otherNetMinuteCost = 2.0;
        otherNetSmsCost = 1.5;

        roamingMinuteCost = 15.0;
        roamingSmsCost = 10.0;
    }
}
