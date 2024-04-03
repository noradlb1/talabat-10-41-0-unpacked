package com.google.android.gms.tagmanager;

import android.net.Uri;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@ShowFirstParty
@VisibleForTesting
class zzeh {
    private static zzeh zzaip;
    private volatile String zzaec = null;
    private volatile zza zzaiq = zza.zzait;
    private volatile String zzair = null;
    private volatile String zzais = null;

    public enum zza {
        zzait,
        CONTAINER,
        CONTAINER_DEBUG
    }

    private static String zzbh(String str) {
        return str.split(ContainerUtils.FIELD_DELIMITER)[0].split("=")[1];
    }

    @ShowFirstParty
    public static zzeh zziy() {
        zzeh zzeh;
        synchronized (zzeh.class) {
            if (zzaip == null) {
                zzaip = new zzeh();
            }
            zzeh = zzaip;
        }
        return zzeh;
    }

    public final String getContainerId() {
        return this.zzaec;
    }

    public final synchronized boolean zza(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        try {
            String decode = URLDecoder.decode(uri.toString(), "UTF-8");
            if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                if (decode.length() != 0) {
                    str3 = "Container preview url: ".concat(decode);
                } else {
                    str3 = new String("Container preview url: ");
                }
                zzdi.zzab(str3);
                if (decode.matches(".*?&gtm_debug=x$")) {
                    this.zzaiq = zza.CONTAINER_DEBUG;
                } else {
                    this.zzaiq = zza.CONTAINER;
                }
                this.zzais = uri.getQuery().replace("&gtm_debug=x", "");
                if (this.zzaiq == zza.CONTAINER || this.zzaiq == zza.CONTAINER_DEBUG) {
                    String valueOf = String.valueOf(this.zzais);
                    if (valueOf.length() != 0) {
                        str4 = "/r?".concat(valueOf);
                    } else {
                        str4 = new String("/r?");
                    }
                    this.zzair = str4;
                }
                this.zzaec = zzbh(this.zzais);
                return true;
            } else if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                if (decode.length() != 0) {
                    str = "Invalid preview uri: ".concat(decode);
                } else {
                    str = new String("Invalid preview uri: ");
                }
                zzdi.zzac(str);
                return false;
            } else if (!zzbh(uri.getQuery()).equals(this.zzaec)) {
                return false;
            } else {
                String valueOf2 = String.valueOf(this.zzaec);
                if (valueOf2.length() != 0) {
                    str2 = "Exit preview mode for container: ".concat(valueOf2);
                } else {
                    str2 = new String("Exit preview mode for container: ");
                }
                zzdi.zzab(str2);
                this.zzaiq = zza.zzait;
                this.zzair = null;
                return true;
            }
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    public final zza zziz() {
        return this.zzaiq;
    }

    public final String zzja() {
        return this.zzair;
    }
}
