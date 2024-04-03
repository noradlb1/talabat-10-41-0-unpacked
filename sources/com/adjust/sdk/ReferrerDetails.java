package com.adjust.sdk;

public class ReferrerDetails {
    public Boolean googlePlayInstant;
    public long installBeginTimestampSeconds;
    public long installBeginTimestampServerSeconds;
    public String installReferrer;
    public String installVersion;
    public long referrerClickTimestampSeconds;
    public long referrerClickTimestampServerSeconds;

    public ReferrerDetails(String str, long j11, long j12) {
        this(str, j11, j12, -1, -1, (String) null, (Boolean) null);
    }

    public ReferrerDetails(String str, long j11, long j12, long j13, long j14, String str2, Boolean bool) {
        this.installReferrer = str;
        this.referrerClickTimestampSeconds = j11;
        this.installBeginTimestampSeconds = j12;
        this.referrerClickTimestampServerSeconds = j13;
        this.installBeginTimestampServerSeconds = j14;
        this.installVersion = str2;
        this.googlePlayInstant = bool;
    }
}
