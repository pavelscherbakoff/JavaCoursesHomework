package _4_mobile_rates_hierarchy;

public abstract class Internet extends BaseRate {

    public Internet() {
        homeNetMinuteCost = 1.5;
        homeNetSmsCost = 1.5;

        otherNetMinuteCost = 2.0;
        otherNetSmsCost = 2.0;

        roamingMinuteCost = 15.0;
        roamingNetSmsCost = 15.0;
    }
}
