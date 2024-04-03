package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.huawei.hms.framework.common.ContainerUtils;
import datamodels.TypesAliasesKt;

public final class zzalt {
    private static final String[] zza = {"/aclk", "/pcs/click", "/dbm/clk"};
    private final String zzb = "ad.doubleclick.net";
    private final String[] zzc = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private final zzalp zzd;

    @Deprecated
    public zzalt(zzalp zzalp) {
        this.zzd = zzalp;
    }

    private final Uri zzg(Uri uri, String str) throws zzalu {
        uri.getClass();
        try {
            if (uri.getHost().equals(this.zzb)) {
                try {
                    if (!uri.toString().contains("dc_ms=")) {
                        String uri2 = uri.toString();
                        int indexOf = uri2.indexOf(";adurl");
                        if (indexOf != -1) {
                            int i11 = indexOf + 1;
                            return Uri.parse(uri2.substring(0, i11) + "dc_ms" + "=" + str + TypesAliasesKt.separator + uri2.substring(i11));
                        }
                        String encodedPath = uri.getEncodedPath();
                        int indexOf2 = uri2.indexOf(encodedPath);
                        return Uri.parse(uri2.substring(0, encodedPath.length() + indexOf2) + TypesAliasesKt.separator + "dc_ms" + "=" + str + TypesAliasesKt.separator + uri2.substring(indexOf2 + encodedPath.length()));
                    }
                    throw new zzalu("Parameter already exists: dc_ms");
                } catch (UnsupportedOperationException unused) {
                    throw new zzalu("Provided Uri is not in a valid state");
                }
            }
        } catch (NullPointerException unused2) {
        }
        if (uri.getQueryParameter("ms") == null) {
            String uri3 = uri.toString();
            int indexOf3 = uri3.indexOf("&adurl");
            if (indexOf3 == -1) {
                indexOf3 = uri3.indexOf("?adurl");
            }
            if (indexOf3 == -1) {
                return uri.buildUpon().appendQueryParameter("ms", str).build();
            }
            int i12 = indexOf3 + 1;
            return Uri.parse(uri3.substring(0, i12) + "ms" + "=" + str + ContainerUtils.FIELD_DELIMITER + uri3.substring(i12));
        }
        throw new zzalu("Query parameter already exists: ms");
    }

    @Deprecated
    public final Uri zza(Uri uri, Context context, View view, Activity activity) throws zzalu {
        try {
            return zzg(uri, this.zzd.zzf(context, uri.getQueryParameter("ai"), view, activity));
        } catch (UnsupportedOperationException unused) {
            throw new zzalu("Provided Uri is not in a valid state");
        }
    }

    @Deprecated
    public final Uri zzb(Uri uri, Context context) throws zzalu {
        return zzg(uri, this.zzd.zzg(context));
    }

    @Deprecated
    public final zzalp zzc() {
        return this.zzd;
    }

    @Deprecated
    public final void zzd(MotionEvent motionEvent) {
        this.zzd.zzk(motionEvent);
    }

    public final boolean zze(Uri uri) {
        if (zzf(uri)) {
            String[] strArr = zza;
            for (int i11 = 0; i11 < 3; i11++) {
                if (uri.getPath().endsWith(strArr[i11])) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean zzf(Uri uri) {
        uri.getClass();
        try {
            String host = uri.getHost();
            String[] strArr = this.zzc;
            for (int i11 = 0; i11 < 3; i11++) {
                if (host.endsWith(strArr[i11])) {
                    return true;
                }
            }
        } catch (NullPointerException unused) {
        }
        return false;
    }
}
