package com.talabat.observability.performance;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/observability/performance/Traces;", "", "()V", "APPLICATION_CLASS_INITIALISATION", "", "APP_START_TO_INTERACTIVE", "COLLECTION_SCREEN_START_TIME", "FOOD_LIST_SCREEN_START_TIME", "GROCERY_HOME_SCREEN_START_TIME", "HOME_SCREEN_V2_TRACE", "LANDING_SCREEN_TRACE", "SPLASH_SCREEN_TRACE", "VERTICAL_CLICK_TO_VENDOR_LOADED", "com_talabat_NewArchi_Observability_Observability"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Traces {
    @NotNull
    public static final String APPLICATION_CLASS_INITIALISATION = "applicationClassInitialisation";
    @NotNull
    public static final String APP_START_TO_INTERACTIVE = "appStartToInteractive";
    @NotNull
    public static final String COLLECTION_SCREEN_START_TIME = "flutter_collection_load_time";
    @NotNull
    public static final String FOOD_LIST_SCREEN_START_TIME = "flutter_food_list_load_time";
    @NotNull
    public static final String GROCERY_HOME_SCREEN_START_TIME = "groceryHomeScreenStartTime";
    @NotNull
    public static final String HOME_SCREEN_V2_TRACE = "homeScreenV2Trace";
    @NotNull
    public static final Traces INSTANCE = new Traces();
    @NotNull
    public static final String LANDING_SCREEN_TRACE = "landingScreenTrace";
    @NotNull
    public static final String SPLASH_SCREEN_TRACE = "splashScreenTrace";
    @NotNull
    public static final String VERTICAL_CLICK_TO_VENDOR_LOADED = "verticalClickToVendorLoaded";

    private Traces() {
    }
}
