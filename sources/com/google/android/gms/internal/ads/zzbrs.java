package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;

public final class zzbrs {
    public static final zzbrt<zzcop> zza = zzbra.zza;
    public static final zzbrt<zzcop> zzb = zzbqy.zza;
    public static final zzbrt<zzcop> zzc = zzbqz.zza;
    public static final zzbrt<zzcop> zzd = new zzbrk();
    public static final zzbrt<zzcop> zze = new zzbrl();
    public static final zzbrt<zzcop> zzf = zzbrb.zza;
    public static final zzbrt<Object> zzg = new zzbrm();
    public static final zzbrt<zzcop> zzh = new zzbrn();
    public static final zzbrt<zzcop> zzi = zzbrc.zza;
    public static final zzbrt<zzcop> zzj = new zzbro();
    public static final zzbrt<zzcop> zzk = new zzbrp();
    public static final zzbrt<zzclh> zzl = new zzcmt();
    public static final zzbrt<zzclh> zzm = new zzcmu();
    public static final zzbrt<zzcop> zzn = new zzbqw();
    public static final zzbsh zzo = new zzbsh();
    public static final zzbrt<zzcop> zzp = new zzbrq();
    public static final zzbrt<zzcop> zzq = new zzbrr();
    public static final zzbrt<zzcop> zzr = new zzbrg();
    public static final zzbrt<zzcop> zzs = new zzbrh();
    public static final zzbrt<zzcop> zzt = new zzbri();

    public static zzbrt<zzcop> zza(zzdmd zzdmd) {
        return new zzbqx(zzdmd);
    }

    public static zzfxa<String> zzb(zzcop zzcop, String str) {
        String str2;
        Uri parse = Uri.parse(str);
        try {
            zzalt zzK = zzcop.zzK();
            if (zzK != null && zzK.zzf(parse)) {
                parse = zzK.zza(parse, zzcop.getContext(), zzcop.zzH(), zzcop.zzk());
            }
        } catch (zzalu unused) {
            if (str.length() != 0) {
                str2 = "Unable to append parameter to URL: ".concat(str);
            } else {
                str2 = new String("Unable to append parameter to URL: ");
            }
            zzciz.zzj(str2);
        }
        String zzb2 = zzchj.zzb(parse, zzcop.getContext());
        long longValue = zzbmw.zze.zze().longValue();
        if (longValue <= 0 || longValue > 214106404) {
            return zzfwq.zzi(zzb2);
        }
        zzfwh<String> zzw = zzfwh.zzw(zzcop.zzT());
        zzbrf zzbrf = zzbrf.zza;
        zzfxb zzfxb = zzcjm.zzf;
        Class<Throwable> cls = Throwable.class;
        return zzfwq.zzf(zzfwq.zzm(zzfwq.zzf(zzw, cls, zzbrf, zzfxb), new zzbrd(zzb2), zzfxb), cls, new zzbre(zzb2), zzfxb);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void zzc(com.google.android.gms.internal.ads.zzcpq r16, java.util.Map r17) {
        /*
            java.lang.String r1 = "openableIntents"
            android.content.Context r0 = r16.getContext()
            android.content.pm.PackageManager r2 = r0.getPackageManager()
            java.lang.String r0 = "data"
            r3 = r17
            java.lang.Object r0 = r3.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0103 }
            r3.<init>((java.lang.String) r0)     // Catch:{ JSONException -> 0x0103 }
            java.lang.String r0 = "intents"
            org.json.JSONArray r3 = r3.getJSONArray(r0)     // Catch:{ JSONException -> 0x00f6 }
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            r5 = 0
            r6 = r5
        L_0x0026:
            int r0 = r3.length()
            if (r6 >= r0) goto L_0x00ee
            org.json.JSONObject r0 = r3.getJSONObject(r6)     // Catch:{ JSONException -> 0x00e3 }
            java.lang.String r7 = "id"
            java.lang.String r7 = r0.optString(r7)
            java.lang.String r8 = "u"
            java.lang.String r8 = r0.optString(r8)
            java.lang.String r9 = "i"
            java.lang.String r9 = r0.optString(r9)
            java.lang.String r10 = "m"
            java.lang.String r10 = r0.optString(r10)
            java.lang.String r11 = "p"
            java.lang.String r11 = r0.optString(r11)
            java.lang.String r12 = "c"
            java.lang.String r12 = r0.optString(r12)
            java.lang.String r13 = "intent_url"
            java.lang.String r13 = r0.optString(r13)
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            if (r0 != 0) goto L_0x0080
            android.content.Intent r14 = android.content.Intent.parseUri(r13, r5)     // Catch:{ URISyntaxException -> 0x0065 }
            goto L_0x0081
        L_0x0065:
            r0 = move-exception
            r15 = r0
            java.lang.String r0 = java.lang.String.valueOf(r13)
            int r13 = r0.length()
            java.lang.String r14 = "Error parsing the url: "
            if (r13 == 0) goto L_0x0078
            java.lang.String r0 = r14.concat(r0)
            goto L_0x007d
        L_0x0078:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r14)
        L_0x007d:
            com.google.android.gms.internal.ads.zzciz.zzh(r0, r15)
        L_0x0080:
            r14 = 0
        L_0x0081:
            r0 = 1
            if (r14 != 0) goto L_0x00cd
            android.content.Intent r14 = new android.content.Intent
            r14.<init>()
            boolean r13 = android.text.TextUtils.isEmpty(r8)
            if (r13 != 0) goto L_0x0096
            android.net.Uri r8 = android.net.Uri.parse(r8)
            r14.setData(r8)
        L_0x0096:
            boolean r8 = android.text.TextUtils.isEmpty(r9)
            if (r8 != 0) goto L_0x009f
            r14.setAction(r9)
        L_0x009f:
            boolean r8 = android.text.TextUtils.isEmpty(r10)
            if (r8 != 0) goto L_0x00a8
            r14.setType(r10)
        L_0x00a8:
            boolean r8 = android.text.TextUtils.isEmpty(r11)
            if (r8 != 0) goto L_0x00b1
            r14.setPackage(r11)
        L_0x00b1:
            boolean r8 = android.text.TextUtils.isEmpty(r12)
            if (r8 != 0) goto L_0x00cd
            java.lang.String r8 = "/"
            r9 = 2
            java.lang.String[] r8 = r12.split(r8, r9)
            int r10 = r8.length
            if (r10 != r9) goto L_0x00cd
            android.content.ComponentName r9 = new android.content.ComponentName
            r10 = r8[r5]
            r8 = r8[r0]
            r9.<init>(r10, r8)
            r14.setComponent(r9)
        L_0x00cd:
            r8 = 65536(0x10000, float:9.18355E-41)
            android.content.pm.ResolveInfo r8 = r2.resolveActivity(r14, r8)
            if (r8 == 0) goto L_0x00d6
            goto L_0x00d7
        L_0x00d6:
            r0 = r5
        L_0x00d7:
            r4.put((java.lang.String) r7, (boolean) r0)     // Catch:{ JSONException -> 0x00db }
            goto L_0x00ea
        L_0x00db:
            r0 = move-exception
            r7 = r0
            java.lang.String r0 = "Error constructing openable urls response."
            com.google.android.gms.internal.ads.zzciz.zzh(r0, r7)
            goto L_0x00ea
        L_0x00e3:
            r0 = move-exception
            r7 = r0
            java.lang.String r0 = "Error parsing the intent data."
            com.google.android.gms.internal.ads.zzciz.zzh(r0, r7)
        L_0x00ea:
            int r6 = r6 + 1
            goto L_0x0026
        L_0x00ee:
            r0 = r16
            com.google.android.gms.internal.ads.zzbuk r0 = (com.google.android.gms.internal.ads.zzbuk) r0
            r0.zze(r1, r4)
            return
        L_0x00f6:
            r0 = r16
            com.google.android.gms.internal.ads.zzbuk r0 = (com.google.android.gms.internal.ads.zzbuk) r0
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            r0.zze(r1, r2)
            return
        L_0x0103:
            r0 = r16
            com.google.android.gms.internal.ads.zzbuk r0 = (com.google.android.gms.internal.ads.zzbuk) r0
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            r0.zze(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbrs.zzc(com.google.android.gms.internal.ads.zzcpq, java.util.Map):void");
    }

    public static void zzd(Map<String, String> map, zzdmd zzdmd) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzhl)).booleanValue() && map.containsKey("sc") && map.get("sc").equals("1") && zzdmd != null) {
            zzdmd.zzq();
        }
    }
}
