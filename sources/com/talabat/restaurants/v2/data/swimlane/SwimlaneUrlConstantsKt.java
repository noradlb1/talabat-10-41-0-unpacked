package com.talabat.restaurants.v2.data.swimlane;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"INSTRUMENTATION_TESTING_BASE_URL", "", "PATH_VERSION", "SWIMLANE_API_VERSION", "", "URL_SWIMALNE_QA", "URL_SWIMLANE_API", "URL_SWIMLANE_PRODUCTION", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneUrlConstantsKt {
    @NotNull
    private static final String INSTRUMENTATION_TESTING_BASE_URL = "http://localhost:8000/";
    @NotNull
    public static final String PATH_VERSION = "version";
    public static final int SWIMLANE_API_VERSION = 4;
    @NotNull
    private static final String URL_SWIMALNE_QA = "https://qa.talabat.com/";
    @NotNull
    public static final String URL_SWIMLANE_API = "/restaurantapi/v{version}/swimlanes";
    @NotNull
    private static final String URL_SWIMLANE_PRODUCTION = "https://api.talabat.com/";
}
