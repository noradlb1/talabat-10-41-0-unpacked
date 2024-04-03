package com.instabug.library.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.util.InstabugDateFormatter;
import org.apache.commons.lang3.StringUtils;

public class e {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f51518a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f51519b;

    /* renamed from: c  reason: collision with root package name */
    private long f51520c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f51521d;

    @NonNull
    public String toString() {
        return InstabugDateFormatter.convertUnixTimeToFormattedDate(this.f51520c, "HH:mm:ss.SSS") + " " + this.f51521d + "  " + this.f51518a + "  " + this.f51519b + StringUtils.LF;
    }

    private e(@Nullable String str, @Nullable String str2, long j11, @Nullable String str3) {
        this.f51518a = str;
        this.f51519b = str2;
        this.f51520c = j11;
        this.f51521d = str3;
    }
}
