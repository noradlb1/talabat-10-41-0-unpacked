package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.zzt;
import com.google.common.net.HttpHeaders;
import java.util.Map;

public final class zzcan extends zzcaq {
    private final Map<String, String> zza;
    /* access modifiers changed from: private */
    public final Context zzb;

    public zzcan(zzcop zzcop, Map<String, String> map) {
        super(zzcop, "storePicture");
        this.zza = map;
        this.zzb = zzcop.zzk();
    }

    public final void zzb() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (this.zzb == null) {
            zzg("Activity context is not available");
            return;
        }
        zzt.zzp();
        if (!new zzbkt(this.zzb).zzc()) {
            zzg("Feature is not supported by the device.");
            return;
        }
        String str7 = this.zza.get("iurl");
        if (TextUtils.isEmpty(str7)) {
            zzg("Image url cannot be empty.");
        } else if (!URLUtil.isValidUrl(str7)) {
            String valueOf = String.valueOf(str7);
            if (valueOf.length() != 0) {
                str6 = "Invalid image url: ".concat(valueOf);
            } else {
                str6 = new String("Invalid image url: ");
            }
            zzg(str6);
        } else {
            String lastPathSegment = Uri.parse(str7).getLastPathSegment();
            zzt.zzp();
            if (!TextUtils.isEmpty(lastPathSegment) && lastPathSegment.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)")) {
                Resources zzd = zzt.zzo().zzd();
                zzt.zzp();
                AlertDialog.Builder builder = new AlertDialog.Builder(this.zzb);
                if (zzd != null) {
                    str2 = zzd.getString(R.string.f35088s1);
                } else {
                    str2 = "Save image";
                }
                builder.setTitle(str2);
                if (zzd != null) {
                    str3 = zzd.getString(R.string.f35089s2);
                } else {
                    str3 = "Allow Ad to store image in Picture gallery?";
                }
                builder.setMessage(str3);
                if (zzd != null) {
                    str4 = zzd.getString(R.string.f35090s3);
                } else {
                    str4 = HttpHeaders.ACCEPT;
                }
                builder.setPositiveButton(str4, new zzcal(this, str7, lastPathSegment));
                if (zzd != null) {
                    str5 = zzd.getString(R.string.f35091s4);
                } else {
                    str5 = "Decline";
                }
                builder.setNegativeButton(str5, new zzcam(this));
                builder.create().show();
                return;
            }
            String valueOf2 = String.valueOf(lastPathSegment);
            if (valueOf2.length() != 0) {
                str = "Image type not recognized: ".concat(valueOf2);
            } else {
                str = new String("Image type not recognized: ");
            }
            zzg(str);
        }
    }
}
