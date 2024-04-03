package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzehr implements zzcbm {
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0043  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzfkf zzf(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -382745961(0xffffffffe92fc297, float:-1.3280059E25)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 112202875(0x6b0147b, float:6.6233935E-35)
            if (r0 == r1) goto L_0x0020
            r1 = 714893483(0x2a9c68ab, float:2.7783795E-13)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "nativeDisplay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = r3
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "video"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = r2
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "htmlDisplay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 0
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x0043
            if (r4 == r3) goto L_0x0040
            if (r4 == r2) goto L_0x003d
            r4 = 0
            return r4
        L_0x003d:
            com.google.android.gms.internal.ads.zzfkf r4 = com.google.android.gms.internal.ads.zzfkf.zzd
            return r4
        L_0x0040:
            com.google.android.gms.internal.ads.zzfkf r4 = com.google.android.gms.internal.ads.zzfkf.NATIVE_DISPLAY
            return r4
        L_0x0043:
            com.google.android.gms.internal.ads.zzfkf r4 = com.google.android.gms.internal.ads.zzfkf.HTML_DISPLAY
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzehr.zzf(java.lang.String):com.google.android.gms.internal.ads.zzfkf");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzfkh zzj(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -1104128070(0xffffffffbe3057ba, float:-0.17220965)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 1318088141(0x4e906dcd, float:1.2115575E9)
            if (r0 == r1) goto L_0x0020
            r1 = 1988248512(0x768243c0, float:1.3210405E33)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "onePixel"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = r2
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "definedByJavascript"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = r3
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "beginToRender"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 0
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x0044
            if (r4 == r3) goto L_0x0041
            if (r4 == r2) goto L_0x003e
            com.google.android.gms.internal.ads.zzfkh r4 = com.google.android.gms.internal.ads.zzfkh.UNSPECIFIED
            return r4
        L_0x003e:
            com.google.android.gms.internal.ads.zzfkh r4 = com.google.android.gms.internal.ads.zzfkh.ONE_PIXEL
            return r4
        L_0x0041:
            com.google.android.gms.internal.ads.zzfkh r4 = com.google.android.gms.internal.ads.zzfkh.DEFINED_BY_JAVASCRIPT
            return r4
        L_0x0044:
            com.google.android.gms.internal.ads.zzfkh r4 = com.google.android.gms.internal.ads.zzfkh.BEGIN_TO_RENDER
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzehr.zzj(java.lang.String):com.google.android.gms.internal.ads.zzfkh");
    }

    private static zzfki zzk(@Nullable String str) {
        if (AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equals(str)) {
            return zzfki.NATIVE;
        }
        if ("javascript".equals(str)) {
            return zzfki.JAVASCRIPT;
        }
        return zzfki.zzc;
    }

    @Nullable
    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, @Nullable String str4, zzcbo zzcbo, zzcbn zzcbn, @Nullable String str5) {
        String str6;
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzdB)).booleanValue() || !zzfjy.zzb()) {
            return null;
        }
        zzfkj zza = zzfkj.zza("Google", str);
        zzfki zzk = zzk("javascript");
        zzfkf zzf = zzf(zzcbn.toString());
        zzfki zzfki = zzfki.zzc;
        if (zzk == zzfki) {
            zzciz.zzj("Omid html session error; Unable to parse impression owner: javascript");
            return null;
        } else if (zzf == null) {
            zzciz.zzj("Omid html session error; Unable to parse creative type: ".concat(String.valueOf(zzcbn)));
            return null;
        } else {
            zzfki zzk2 = zzk(str4);
            if (zzf == zzfkf.zzd && zzk2 == zzfki) {
                String valueOf = String.valueOf(str4);
                if (valueOf.length() != 0) {
                    str6 = "Omid html session error; Video events owner unknown for video creative: ".concat(valueOf);
                } else {
                    str6 = new String("Omid html session error; Video events owner unknown for video creative: ");
                }
                zzciz.zzj(str6);
                return null;
            }
            return ObjectWrapper.wrap(zzfka.zza(zzfkb.zza(zzf, zzj(zzcbo.toString()), zzk, zzk2, true), zzfkc.zzb(zza, webView, str5, "")));
        }
    }

    @Nullable
    public final IObjectWrapper zzb(String str, WebView webView, String str2, String str3, @Nullable String str4, String str5, zzcbo zzcbo, zzcbn zzcbn, @Nullable String str6) {
        String str7;
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzdB)).booleanValue() || !zzfjy.zzb()) {
            return null;
        }
        zzfkj zza = zzfkj.zza(str5, str);
        zzfki zzk = zzk("javascript");
        zzfki zzk2 = zzk(str4);
        zzfkf zzf = zzf(zzcbn.toString());
        zzfki zzfki = zzfki.zzc;
        if (zzk == zzfki) {
            zzciz.zzj("Omid js session error; Unable to parse impression owner: javascript");
            return null;
        } else if (zzf == null) {
            zzciz.zzj("Omid js session error; Unable to parse creative type: ".concat(String.valueOf(zzcbn)));
            return null;
        } else if (zzf == zzfkf.zzd && zzk2 == zzfki) {
            String valueOf = String.valueOf(str4);
            if (valueOf.length() != 0) {
                str7 = "Omid js session error; Video events owner unknown for video creative: ".concat(valueOf);
            } else {
                str7 = new String("Omid js session error; Video events owner unknown for video creative: ");
            }
            zzciz.zzj(str7);
            return null;
        } else {
            return ObjectWrapper.wrap(zzfka.zza(zzfkb.zza(zzf, zzj(zzcbo.toString()), zzk, zzk2, true), zzfkc.zzc(zza, webView, str6, "")));
        }
    }

    @Nullable
    public final String zzc(Context context) {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzdB)).booleanValue()) {
            return null;
        }
        return "a.1.3.3-google_20200416";
    }

    public final void zzd(IObjectWrapper iObjectWrapper, View view) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdB)).booleanValue() && zzfjy.zzb()) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (unwrap instanceof zzfka) {
                ((zzfka) unwrap).zzb(view, zzfkg.NOT_VISIBLE, "Ad overlay");
            }
        }
    }

    public final void zze(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdB)).booleanValue() && zzfjy.zzb()) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (unwrap instanceof zzfka) {
                ((zzfka) unwrap).zzc();
            }
        }
    }

    public final void zzg(IObjectWrapper iObjectWrapper, View view) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdB)).booleanValue() && zzfjy.zzb()) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (unwrap instanceof zzfka) {
                ((zzfka) unwrap).zzd(view);
            }
        }
    }

    public final void zzh(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdB)).booleanValue() && zzfjy.zzb()) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (unwrap instanceof zzfka) {
                ((zzfka) unwrap).zze();
            }
        }
    }

    public final boolean zzi(Context context) {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzdB)).booleanValue()) {
            zzciz.zzj("Omid flag is disabled");
            return false;
        } else if (zzfjy.zzb()) {
            return true;
        } else {
            zzfjy.zza(context);
            return zzfjy.zzb();
        }
    }
}
