package com.google.android.gms.internal.gtm;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class zznf {
    private String zzafk = "https://www.google-analytics.com";

    private static String zzbs(String str) {
        String str2;
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException unused) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "Cannot encode the string: ".concat(valueOf);
            } else {
                str2 = new String("Cannot encode the string: ");
            }
            zzev.zzav(str2);
            return "";
        }
    }

    public final String zzb(zzmk zzmk) {
        String str;
        String str2;
        String str3 = this.zzafk;
        if (zzmk.zzlg()) {
            str = zzmk.zzlh();
        } else {
            if (!zzmk.zzli().trim().equals("")) {
                str2 = zzmk.zzli().trim();
            } else {
                str2 = "-1";
            }
            StringBuilder sb2 = new StringBuilder();
            if (zzmk.zzle() != null) {
                sb2.append(zzmk.zzle());
            } else {
                sb2.append("id");
            }
            sb2.append("=");
            sb2.append(zzbs(zzmk.getContainerId()));
            sb2.append("&pv=");
            sb2.append(zzbs(str2));
            sb2.append("&rv=5.0");
            if (zzmk.zzlg()) {
                sb2.append("&gtm_debug=x");
            }
            str = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder(String.valueOf(str3).length() + 13 + String.valueOf(str).length());
        sb3.append(str3);
        sb3.append("/gtm/android?");
        sb3.append(str);
        return sb3.toString();
    }
}
