package com.google.firebase.remoteconfig.internal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class FirebaseRemoteConfigInfoImpl implements FirebaseRemoteConfigInfo {
    private final FirebaseRemoteConfigSettings configSettings;
    private final int lastFetchStatus;
    private final long lastSuccessfulFetchTimeInMillis;

    public static class Builder {
        private FirebaseRemoteConfigSettings builderConfigSettings;
        private int builderLastFetchStatus;
        private long builderLastSuccessfulFetchTimeInMillis;

        private Builder() {
        }

        public FirebaseRemoteConfigInfoImpl build() {
            return new FirebaseRemoteConfigInfoImpl(this.builderLastSuccessfulFetchTimeInMillis, this.builderLastFetchStatus, this.builderConfigSettings);
        }

        public Builder withConfigSettings(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
            this.builderConfigSettings = firebaseRemoteConfigSettings;
            return this;
        }

        public Builder withLastFetchStatus(int i11) {
            this.builderLastFetchStatus = i11;
            return this;
        }

        public Builder withLastSuccessfulFetchTimeInMillis(long j11) {
            this.builderLastSuccessfulFetchTimeInMillis = j11;
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public FirebaseRemoteConfigSettings getConfigSettings() {
        return this.configSettings;
    }

    public long getFetchTimeMillis() {
        return this.lastSuccessfulFetchTimeInMillis;
    }

    public int getLastFetchStatus() {
        return this.lastFetchStatus;
    }

    private FirebaseRemoteConfigInfoImpl(long j11, int i11, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.lastSuccessfulFetchTimeInMillis = j11;
        this.lastFetchStatus = i11;
        this.configSettings = firebaseRemoteConfigSettings;
    }
}
