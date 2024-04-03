package com.huawei.hms.location;

import android.text.TextUtils;
import com.huawei.hms.support.api.entity.location.fence.GeofenceEntity;

public interface Geofence {
    public static final int CONVERSIONS_MAX = 7;
    public static final int CONVERSIONS_MIN = 0;
    public static final long DEFAULT_DURATION = -2;
    public static final int DEFAULT_INTERVAL = 0;
    public static final int DWELL_GEOFENCE_CONVERSION = 4;
    public static final int ENTER_GEOFENCE_CONVERSION = 1;
    public static final int EXIT_GEOFENCE_CONVERSION = 2;
    public static final long GEOFENCE_NEVER_EXPIRE = -1;

    public static final class Builder {
        private int conversions = 0;
        private int dwellDelayTime = -1;
        private double latitude;
        private double longitude;
        private int notificationInterval = 0;
        private float radius;
        private String uniqueId = null;
        private long validDuration = -2;

        public Geofence build() {
            if (!TextUtils.isEmpty(this.uniqueId)) {
                int i11 = this.conversions;
                if (i11 <= 0 || i11 > 7) {
                    throw new IllegalArgumentException("invalid conversions.");
                } else if ((i11 & 4) == 0 || this.dwellDelayTime >= 0) {
                    long j11 = this.validDuration;
                    if (j11 != -2) {
                        int i12 = this.notificationInterval;
                        if (i12 >= 0) {
                            return new GeofenceEntity(this.uniqueId, i11, this.latitude, this.longitude, this.radius, j11, i12, this.dwellDelayTime);
                        }
                        throw new IllegalArgumentException("notificationInterval should be nonnegative.");
                    }
                    throw new IllegalArgumentException("validDuration not set.");
                } else {
                    throw new IllegalArgumentException("Non-negative dwellDelayTime needs to be set when conversions include DWELL_GEOFENCE_CONVERSION.");
                }
            } else {
                throw new IllegalArgumentException("uniqueId not set.");
            }
        }

        public Builder setConversions(int i11) {
            this.conversions = i11;
            return this;
        }

        public Builder setDwellDelayTime(int i11) {
            this.dwellDelayTime = i11;
            return this;
        }

        public Builder setNotificationInterval(int i11) {
            this.notificationInterval = i11;
            return this;
        }

        public Builder setRoundArea(double d11, double d12, float f11) {
            this.latitude = d11;
            this.longitude = d12;
            this.radius = f11;
            return this;
        }

        public Builder setUniqueId(String str) {
            this.uniqueId = str;
            return this;
        }

        public Builder setValidContinueTime(long j11) {
            if (j11 < 0) {
                j11 = -1;
            }
            this.validDuration = j11;
            return this;
        }
    }

    String getUniqueId();
}
