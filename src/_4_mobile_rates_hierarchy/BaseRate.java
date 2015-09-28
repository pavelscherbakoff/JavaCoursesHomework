package _4_mobile_rates_hierarchy;

public abstract class BaseRate {

    int abonentFee;

    int freeMinutes;
    int freeSms;
    int freeTraffic;

    double homeNetMinuteCost;
    double homeNetSmsCost;

    double otherNetMinuteCost;
    double otherNetSmsCost;

    double roamingMinuteCost;
    double roamingNetSmsCost;

    double traffic1MbCost;
    double roamingTraffic1MbCost;

    public BaseRate() {

        abonentFee = 0;

        freeMinutes = 0;
        freeSms = 0;
        freeTraffic = 0;

        homeNetMinuteCost = 1.0;
        homeNetSmsCost = 1.0;

        otherNetMinuteCost = 1.5;
        otherNetSmsCost = 1.5;

        roamingMinuteCost = 10.0;
        roamingNetSmsCost = 10.0;

        traffic1MbCost = 1.0;
        roamingTraffic1MbCost = 10.0;
    }
}