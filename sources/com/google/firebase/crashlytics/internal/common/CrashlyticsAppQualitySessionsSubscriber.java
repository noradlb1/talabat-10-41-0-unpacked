package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.sessions.api.SessionSubscriber;

public class CrashlyticsAppQualitySessionsSubscriber implements SessionSubscriber {
    @Nullable
    private String appQualitySessionId = null;
    private final DataCollectionArbiter dataCollectionArbiter;

    public CrashlyticsAppQualitySessionsSubscriber(DataCollectionArbiter dataCollectionArbiter2) {
        this.dataCollectionArbiter = dataCollectionArbiter2;
    }

    @Nullable
    public String getAppQualitySessionId() {
        return this.appQualitySessionId;
    }

    @NonNull
    public SessionSubscriber.Name getSessionSubscriberName() {
        return SessionSubscriber.Name.CRASHLYTICS;
    }

    public boolean isDataCollectionEnabled() {
        return this.dataCollectionArbiter.isAutomaticDataCollectionEnabled();
    }

    public void onSessionChanged(@NonNull SessionSubscriber.SessionDetails sessionDetails) {
        Logger logger = Logger.getLogger();
        logger.d("App Quality Sessions session changed: " + sessionDetails);
        this.appQualitySessionId = sessionDetails.getSessionId();
    }
}
