package com.google.android.gms.internal.ads;

import android.os.IBinder;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.util.zzbc;

public final class zzfey {
    public static zzbew zza(Throwable th2) {
        if (th2 instanceof zzehx) {
            zzehx zzehx = (zzehx) th2;
            return zzc(zzehx.zza(), zzehx.zzb());
        } else if (th2 instanceof zzecd) {
            if (th2.getMessage() == null) {
                return zzd(((zzecd) th2).zza(), (String) null, (zzbew) null);
            }
            return zzd(((zzecd) th2).zza(), th2.getMessage(), (zzbew) null);
        } else if (!(th2 instanceof zzbc)) {
            return zzd(1, (String) null, (zzbew) null);
        } else {
            zzbc zzbc = (zzbc) th2;
            return new zzbew(zzbc.zza(), zzfqr.zzc(zzbc.getMessage()), MobileAds.ERROR_DOMAIN, (zzbew) null, (IBinder) null);
        }
    }

    public static zzbew zzb(Throwable th2, @Nullable zzehy zzehy) {
        zzbew zzbew;
        zzbew zza = zza(th2);
        int i11 = zza.zza;
        if ((i11 == 3 || i11 == 0) && (zzbew = zza.zzd) != null && !zzbew.zzc.equals(MobileAds.ERROR_DOMAIN)) {
            zza.zzd = null;
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzge)).booleanValue() && zzehy != null) {
            zza.zze = zzehy.zza();
        }
        return zza;
    }

    public static zzbew zzc(int i11, zzbew zzbew) {
        if (i11 != 0) {
            if (i11 == 8) {
                if (((Integer) zzbgq.zzc().zzb(zzblj.zzgb)).intValue() > 0) {
                    return zzbew;
                }
                i11 = 8;
            }
            return zzd(i11, (String) null, zzbew);
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
        r3 = "No fill.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x008c, code lost:
        r2 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x008e, code lost:
        r2 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0099, code lost:
        return new com.google.android.gms.internal.ads.zzbew(r2, r3, com.google.android.gms.ads.MobileAds.ERROR_DOMAIN, r10, (android.os.IBinder) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzbew zzd(int r8, @androidx.annotation.Nullable java.lang.String r9, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzbew r10) {
        /*
            r0 = 0
            if (r9 != 0) goto L_0x0054
            int r9 = r8 + -1
            if (r8 == 0) goto L_0x0053
            java.lang.String r1 = "No fill."
            switch(r9) {
                case 1: goto L_0x0050;
                case 2: goto L_0x004e;
                case 3: goto L_0x004b;
                case 4: goto L_0x0048;
                case 5: goto L_0x0045;
                case 6: goto L_0x0042;
                case 7: goto L_0x003f;
                case 8: goto L_0x003c;
                case 9: goto L_0x0039;
                case 10: goto L_0x0036;
                case 11: goto L_0x000c;
                case 12: goto L_0x0021;
                case 13: goto L_0x001e;
                case 14: goto L_0x001b;
                case 15: goto L_0x0018;
                case 16: goto L_0x0015;
                case 17: goto L_0x0012;
                case 18: goto L_0x000f;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.String r9 = "Internal error."
            goto L_0x0054
        L_0x000f:
            java.lang.String r9 = "Ad inspector cannot be opened because it is already open."
            goto L_0x0054
        L_0x0012:
            java.lang.String r9 = "Ad inspector cannot be opened because the device is not in test mode. See https://developers.google.com/admob/android/test-ads#enable_test_devices for more information."
            goto L_0x0054
        L_0x0015:
            java.lang.String r9 = "Ad inspector failed to load."
            goto L_0x0054
        L_0x0018:
            java.lang.String r9 = "Ad inspector had an internal error."
            goto L_0x0054
        L_0x001b:
            java.lang.String r9 = "Invalid ad string."
            goto L_0x0054
        L_0x001e:
            java.lang.String r9 = "Mismatch request IDs."
            goto L_0x0054
        L_0x0021:
            com.google.android.gms.internal.ads.zzblb<java.lang.Integer> r9 = com.google.android.gms.internal.ads.zzblj.zzgf
            com.google.android.gms.internal.ads.zzblh r2 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r9 = r2.zzb(r9)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            if (r9 > 0) goto L_0x004e
            java.lang.String r9 = "The mediation adapter did not return an ad."
            goto L_0x0054
        L_0x0036:
            java.lang.String r9 = "The ad can not be shown when app is not in foreground."
            goto L_0x0054
        L_0x0039:
            java.lang.String r9 = "The ad has already been shown."
            goto L_0x0054
        L_0x003c:
            java.lang.String r9 = "The ad is not ready."
            goto L_0x0054
        L_0x003f:
            java.lang.String r9 = "A mediation adapter failed to show the ad."
            goto L_0x0054
        L_0x0042:
            java.lang.String r9 = "Invalid request: Invalid ad size."
            goto L_0x0054
        L_0x0045:
            java.lang.String r9 = "Invalid request: Invalid ad unit ID."
            goto L_0x0054
        L_0x0048:
            java.lang.String r9 = "Network error."
            goto L_0x0054
        L_0x004b:
            java.lang.String r9 = "App ID missing."
            goto L_0x0054
        L_0x004e:
            r3 = r1
            goto L_0x0055
        L_0x0050:
            java.lang.String r9 = "Invalid request."
            goto L_0x0054
        L_0x0053:
            throw r0
        L_0x0054:
            r3 = r9
        L_0x0055:
            int r9 = r8 + -1
            com.google.android.gms.internal.ads.zzbew r7 = new com.google.android.gms.internal.ads.zzbew
            if (r8 == 0) goto L_0x00d9
            r0 = 2
            r1 = 1
            r2 = 0
            r4 = 3
            switch(r9) {
                case 0: goto L_0x0091;
                case 1: goto L_0x0090;
                case 2: goto L_0x008e;
                case 3: goto L_0x008a;
                case 4: goto L_0x0088;
                case 5: goto L_0x0090;
                case 6: goto L_0x0090;
                case 7: goto L_0x0086;
                case 8: goto L_0x0088;
                case 9: goto L_0x0090;
                case 10: goto L_0x008e;
                case 11: goto L_0x0091;
                case 12: goto L_0x0071;
                case 13: goto L_0x006e;
                case 14: goto L_0x006b;
                case 15: goto L_0x0091;
                case 16: goto L_0x0090;
                case 17: goto L_0x0088;
                case 18: goto L_0x008e;
                default: goto L_0x0062;
            }
        L_0x0062:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            switch(r8) {
                case 1: goto L_0x00cd;
                case 2: goto L_0x00ca;
                case 3: goto L_0x00c7;
                case 4: goto L_0x00c4;
                case 5: goto L_0x00c1;
                case 6: goto L_0x00be;
                case 7: goto L_0x00bb;
                case 8: goto L_0x00b8;
                case 9: goto L_0x00b5;
                case 10: goto L_0x00b2;
                case 11: goto L_0x00af;
                case 12: goto L_0x00ac;
                case 13: goto L_0x00a9;
                case 14: goto L_0x00a6;
                case 15: goto L_0x00a3;
                case 16: goto L_0x00a0;
                case 17: goto L_0x009d;
                case 18: goto L_0x009a;
                default: goto L_0x0067;
            }
        L_0x0067:
            java.lang.String r8 = "AD_INSPECTOR_ALREADY_OPEN"
            goto L_0x00cf
        L_0x006b:
            r8 = 11
            goto L_0x008c
        L_0x006e:
            r8 = 10
            goto L_0x008c
        L_0x0071:
            com.google.android.gms.internal.ads.zzblb<java.lang.Integer> r8 = com.google.android.gms.internal.ads.zzblj.zzgf
            com.google.android.gms.internal.ads.zzblh r9 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r8 = r9.zzb(r8)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            if (r8 > 0) goto L_0x008e
            r8 = 9
            goto L_0x008c
        L_0x0086:
            r8 = 4
            goto L_0x008c
        L_0x0088:
            r2 = r0
            goto L_0x0091
        L_0x008a:
            r8 = 8
        L_0x008c:
            r2 = r8
            goto L_0x0091
        L_0x008e:
            r2 = r4
            goto L_0x0091
        L_0x0090:
            r2 = r1
        L_0x0091:
            java.lang.String r4 = "com.google.android.gms.ads"
            r6 = 0
            r1 = r7
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return r7
        L_0x009a:
            java.lang.String r8 = "AD_INSPECTOR_NOT_IN_TEST_MODE"
            goto L_0x00cf
        L_0x009d:
            java.lang.String r8 = "AD_INSPECTOR_FAILED_TO_LOAD"
            goto L_0x00cf
        L_0x00a0:
            java.lang.String r8 = "AD_INSPECTOR_INTERNAL_ERROR"
            goto L_0x00cf
        L_0x00a3:
            java.lang.String r8 = "INVALID_AD_STRING"
            goto L_0x00cf
        L_0x00a6:
            java.lang.String r8 = "REQUEST_ID_MISMATCH"
            goto L_0x00cf
        L_0x00a9:
            java.lang.String r8 = "MEDIATION_NO_FILL"
            goto L_0x00cf
        L_0x00ac:
            java.lang.String r8 = "INTERNAL_SHOW_ERROR"
            goto L_0x00cf
        L_0x00af:
            java.lang.String r8 = "APP_NOT_FOREGROUND"
            goto L_0x00cf
        L_0x00b2:
            java.lang.String r8 = "AD_REUSED"
            goto L_0x00cf
        L_0x00b5:
            java.lang.String r8 = "NOT_READY"
            goto L_0x00cf
        L_0x00b8:
            java.lang.String r8 = "MEDIATION_SHOW_ERROR"
            goto L_0x00cf
        L_0x00bb:
            java.lang.String r8 = "INVALID_AD_SIZE"
            goto L_0x00cf
        L_0x00be:
            java.lang.String r8 = "INVALID_AD_UNIT_ID"
            goto L_0x00cf
        L_0x00c1:
            java.lang.String r8 = "NETWORK_ERROR"
            goto L_0x00cf
        L_0x00c4:
            java.lang.String r8 = "APP_ID_MISSING"
            goto L_0x00cf
        L_0x00c7:
            java.lang.String r8 = "NO_FILL"
            goto L_0x00cf
        L_0x00ca:
            java.lang.String r8 = "INVALID_REQUEST"
            goto L_0x00cf
        L_0x00cd:
            java.lang.String r8 = "INTERNAL_ERROR"
        L_0x00cf:
            java.lang.String r10 = "Unknown SdkError: "
            java.lang.String r8 = r10.concat(r8)
            r9.<init>(r8)
            throw r9
        L_0x00d9:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfey.zzd(int, java.lang.String, com.google.android.gms.internal.ads.zzbew):com.google.android.gms.internal.ads.zzbew");
    }
}
