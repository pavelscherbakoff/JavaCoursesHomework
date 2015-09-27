package _4_mobile_rates;

public class ClassesHierarchy {

    static class Rate {

        int monthCost;

        int freeMinutes;
        int freeSms;

        int homeNetMinuteCost;
        int homeNetSmsCost;

        int otherNetMinuteCost;
        int otherNetSmsCost;

        int roamingMinuteCost;
        int roamingNetSmsCost;

    }

    static class Standard extends Rate {

    }

    static class HomeNet extends Rate {

    }

    static class Travelling extends Rate {

    }

    static class Unlimited extends Rate {

    }

    static class Prepaid extends Rate {

    }

    static class Prepaid100Min20Sms extends Prepaid {

    }

    static class Prepaid200Min40Sms extends Prepaid {

    }

    static class Prepaid500Min100Sms extends Prepaid {

    }

    static class Internet extends Rate {

    }

    static class Internet1GbLimit extends Internet {

    }

    static class Internet5GbLimit extends Internet {

    }

    static class InternetUnlimited extends Internet {

    }
}
