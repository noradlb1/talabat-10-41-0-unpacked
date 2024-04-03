package com.google.firebase.perf.session;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.SessionVerbosity;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PerfSession implements Parcelable {
    public static final Parcelable.Creator<PerfSession> CREATOR = new Parcelable.Creator<PerfSession>() {
        public PerfSession createFromParcel(@NonNull Parcel parcel) {
            return new PerfSession(parcel);
        }

        public PerfSession[] newArray(int i11) {
            return new PerfSession[i11];
        }
    };
    private final Timer creationTime;
    private boolean isGaugeAndEventCollectionEnabled;
    private final String sessionId;

    @Nullable
    public static com.google.firebase.perf.v1.PerfSession[] buildAndSort(@NonNull List<PerfSession> list) {
        if (list.isEmpty()) {
            return null;
        }
        com.google.firebase.perf.v1.PerfSession[] perfSessionArr = new com.google.firebase.perf.v1.PerfSession[list.size()];
        com.google.firebase.perf.v1.PerfSession build = list.get(0).build();
        boolean z11 = false;
        for (int i11 = 1; i11 < list.size(); i11++) {
            com.google.firebase.perf.v1.PerfSession build2 = list.get(i11).build();
            if (z11 || !list.get(i11).isVerbose()) {
                perfSessionArr[i11] = build2;
            } else {
                perfSessionArr[0] = build2;
                perfSessionArr[i11] = build;
                z11 = true;
            }
        }
        if (!z11) {
            perfSessionArr[0] = build;
        }
        return perfSessionArr;
    }

    public static PerfSession createWithId(@NonNull String str) {
        PerfSession perfSession = new PerfSession(str.replace(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE, ""), new Clock());
        perfSession.setGaugeAndEventCollectionEnabled(shouldCollectGaugesAndEvents());
        return perfSession;
    }

    public static boolean shouldCollectGaugesAndEvents() {
        ConfigResolver instance = ConfigResolver.getInstance();
        if (!instance.isPerformanceMonitoringEnabled() || Math.random() >= instance.getSessionsSamplingRate()) {
            return false;
        }
        return true;
    }

    public com.google.firebase.perf.v1.PerfSession build() {
        PerfSession.Builder sessionId2 = com.google.firebase.perf.v1.PerfSession.newBuilder().setSessionId(this.sessionId);
        if (this.isGaugeAndEventCollectionEnabled) {
            sessionId2.addSessionVerbosity(SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS);
        }
        return (com.google.firebase.perf.v1.PerfSession) sessionId2.build();
    }

    public int describeContents() {
        return 0;
    }

    public Timer getTimer() {
        return this.creationTime;
    }

    public boolean isGaugeAndEventCollectionEnabled() {
        return this.isGaugeAndEventCollectionEnabled;
    }

    public boolean isSessionRunningTooLong() {
        if (TimeUnit.MICROSECONDS.toMinutes(this.creationTime.getDurationMicros()) > ConfigResolver.getInstance().getSessionsMaxDurationMinutes()) {
            return true;
        }
        return false;
    }

    public boolean isVerbose() {
        return this.isGaugeAndEventCollectionEnabled;
    }

    public String sessionId() {
        return this.sessionId;
    }

    public void setGaugeAndEventCollectionEnabled(boolean z11) {
        this.isGaugeAndEventCollectionEnabled = z11;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeString(this.sessionId);
        parcel.writeByte(this.isGaugeAndEventCollectionEnabled ? (byte) 1 : 0);
        parcel.writeParcelable(this.creationTime, 0);
    }

    @VisibleForTesting(otherwise = 3)
    public PerfSession(String str, Clock clock) {
        this.isGaugeAndEventCollectionEnabled = false;
        this.sessionId = str;
        this.creationTime = clock.getTime();
    }

    @VisibleForTesting
    public static boolean isVerbose(@NonNull com.google.firebase.perf.v1.PerfSession perfSession) {
        for (SessionVerbosity sessionVerbosity : perfSession.getSessionVerbosityList()) {
            if (sessionVerbosity == SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS) {
                return true;
            }
        }
        return false;
    }

    private PerfSession(@NonNull Parcel parcel) {
        boolean z11 = false;
        this.isGaugeAndEventCollectionEnabled = false;
        this.sessionId = parcel.readString();
        this.isGaugeAndEventCollectionEnabled = parcel.readByte() != 0 ? true : z11;
        this.creationTime = (Timer) parcel.readParcelable(Timer.class.getClassLoader());
    }
}
