package com.talabat.helpers;

public class BuildConfigType {

    public static class TALABAT_BUILD_TYPE {
        public static final String DEBUG = "debug";
        public static final String INSTRUMENTATION_TESTING_SERVER_MOCK = "mock";
        public static final String INSTRUMENTATION_TESTING_SERVER_PRODUCTION = "prod";
        public static final String RELEASE = "release";
    }

    public static boolean ThirdPartyLiveChatProductionMode() {
        return true;
    }

    public static boolean ThirdPartyToolsProductionMode() {
        return true;
    }
}
