package com.google.android.exoplayer2.source.dash.manifest;

import androidx.annotation.Nullable;
import com.google.common.base.Objects;

public final class BaseUrl {
    public static final int DEFAULT_DVB_PRIORITY = 1;
    public static final int DEFAULT_WEIGHT = 1;
    public static final int PRIORITY_UNSET = Integer.MIN_VALUE;
    public final int priority;
    public final String serviceLocation;
    public final String url;
    public final int weight;

    public BaseUrl(String str) {
        this(str, str, Integer.MIN_VALUE, 1);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseUrl)) {
            return false;
        }
        BaseUrl baseUrl = (BaseUrl) obj;
        if (this.priority != baseUrl.priority || this.weight != baseUrl.weight || !Objects.equal(this.url, baseUrl.url) || !Objects.equal(this.serviceLocation, baseUrl.serviceLocation)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.url, this.serviceLocation, Integer.valueOf(this.priority), Integer.valueOf(this.weight));
    }

    public BaseUrl(String str, String str2, int i11, int i12) {
        this.url = str;
        this.serviceLocation = str2;
        this.priority = i11;
        this.weight = i12;
    }
}
