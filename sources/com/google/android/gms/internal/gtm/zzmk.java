package com.google.android.gms.internal.gtm;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import net.bytebuddy.utility.JavaConstant;

public final class zzmk {
    private final String zzaec;
    @Nullable
    private final String zzajh;
    @Nullable
    private final String zzams;
    @Nullable
    private final String zzasg;
    private final boolean zzash;
    @Nullable
    private final String zzasi;

    public zzmk(String str, String str2, @Nullable String str3, boolean z11, @Nullable String str4) {
        this(str, str2, str3, z11, str4, "");
    }

    public final String getContainerId() {
        return this.zzaec;
    }

    public final String zzld() {
        return this.zzams;
    }

    public final String zzle() {
        return this.zzasg;
    }

    public final String zzlf() {
        String str = this.zzasg;
        if (str == null) {
            return this.zzaec;
        }
        String str2 = this.zzaec;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(JavaConstant.Dynamic.DEFAULT_NAME);
        sb2.append(str2);
        return sb2.toString();
    }

    public final boolean zzlg() {
        return this.zzash;
    }

    public final String zzlh() {
        return this.zzasi;
    }

    public final String zzli() {
        return this.zzajh;
    }

    private zzmk(String str, String str2, @Nullable String str3, boolean z11, @Nullable String str4, String str5) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str5);
        this.zzaec = str;
        this.zzams = str2;
        this.zzasg = str3;
        this.zzash = z11;
        this.zzasi = str4;
        this.zzajh = str5;
    }
}
