package com.instabug.featuresrequest.utils;

import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;

public abstract class d {
    public static boolean a() {
        return InstabugCore.isFeatureAvailable(Feature.FEATURE_REQUESTS);
    }

    public static boolean b() {
        return InstabugCore.getFeatureState(Feature.FEATURE_REQUESTS) == Feature.State.ENABLED;
    }
}
