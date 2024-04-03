package com.talabat.gem.integration;

import androidx.annotation.NonNull;
import java.util.Map;

public interface GemAccessor {
    public static final String COMPONENT_COLLECTION = "collection";

    Map<String, String> getGemComponentState();

    @NonNull
    String getGemRemainingSecondsText();

    @NonNull
    String getGemSelectedRestaurantPositionText();

    @NonNull
    String getGemSelectedTierIndexText();

    boolean isGemActive();

    boolean isGemOffersActive();

    void onGemSessionChanged();

    void resetGemFlow();

    GemAnalyticsAccessor withGemAnalytics();
}
