package com.newrelic.agent.android;

final class NewRelicConfig {
    static final String BUILD_ID = "77933121-a596-49ae-8d15-660097cccae0";
    static final String MAP_PROVIDER = "r8";
    static final String METRICS = "[agent:7.2.1, agp:7.4.2, gradle:7.6, java:11.0.11, kotlin:1.7.10, configCacheEnabled:false, variants:[debug:[minSdk:23, targetSdk:33], release:[minSdk:23, targetSdk:33]]]";
    static final Boolean OBFUSCATED = Boolean.TRUE;
    static final String VERSION = "7.2.1";

    public static String getBuildId() {
        return BUILD_ID;
    }
}
