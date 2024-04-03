package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.auto.value.AutoValue;

public interface InstallIdProvider {

    @AutoValue
    public static abstract class InstallIds {
        public static InstallIds create(String str, @Nullable String str2) {
            return new AutoValue_InstallIdProvider_InstallIds(str, str2);
        }

        @VisibleForTesting(otherwise = 3)
        public static InstallIds createWithoutFid(String str) {
            return create(str, (String) null);
        }

        @NonNull
        public abstract String getCrashlyticsInstallId();

        @Nullable
        public abstract String getFirebaseInstallationId();
    }

    InstallIds getInstallIds();
}
