package com.google.android.recaptcha.internal;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
public final class zzaz {
    @NotNull
    public static final zzaz zza = new zzaz();
    @Nullable
    private static Set zzb;
    @Nullable
    private static Set zzc;
    @Nullable
    private static Long zzd;
    private static int zze;

    private zzaz() {
    }

    public static final void zza(@NotNull zzmi zzmi) {
        zzb = CollectionsKt___CollectionsKt.toSet(zzmi.zzf().zzi());
        zzc = CollectionsKt___CollectionsKt.toSet(zzmi.zzg().zzi());
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0152  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object zzb(@org.jetbrains.annotations.NotNull java.lang.String r16, @org.jetbrains.annotations.NotNull java.lang.String r17, @org.jetbrains.annotations.NotNull java.lang.String r18, @org.jetbrains.annotations.NotNull java.lang.String r19, @org.jetbrains.annotations.NotNull android.content.Context r20, @org.jetbrains.annotations.NotNull com.google.android.recaptcha.internal.zzq r21, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r22) {
        /*
            r0 = r16
            java.lang.String r1 = "UTF-8"
            java.util.Set r2 = zzb
            if (r2 == 0) goto L_0x0010
            java.util.Set r2 = zzc
            if (r2 != 0) goto L_0x000d
            goto L_0x0010
        L_0x000d:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0010:
            com.google.android.recaptcha.internal.zzai r2 = com.google.android.recaptcha.internal.zzai.zza     // Catch:{ Exception -> 0x0110 }
            com.google.android.recaptcha.internal.zzaf r2 = new com.google.android.recaptcha.internal.zzaf     // Catch:{ Exception -> 0x0110 }
            com.google.android.recaptcha.internal.zzln r9 = com.google.android.recaptcha.internal.zzln.FETCH_ALLOWLIST     // Catch:{ Exception -> 0x0110 }
            r8 = 0
            r3 = r2
            r4 = r9
            r5 = r18
            r6 = r19
            r7 = r19
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0110 }
            com.google.android.recaptcha.internal.zzr r3 = new com.google.android.recaptcha.internal.zzr     // Catch:{ Exception -> 0x0110 }
            r3.<init>()     // Catch:{ Exception -> 0x0110 }
            com.google.android.recaptcha.internal.zzai.zzb(r2, r0, r3)     // Catch:{ Exception -> 0x0110 }
            r2 = 0
            zzd = r2     // Catch:{ Exception -> 0x0110 }
            r3 = 0
            zze = r3     // Catch:{ Exception -> 0x0110 }
            java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x0110 }
            java.lang.String r4 = r21.zzb()     // Catch:{ Exception -> 0x0110 }
            java.lang.String r0 = java.net.URLEncoder.encode(r0, r1)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r5 = "18.2.1"
            java.lang.String r5 = java.net.URLEncoder.encode(r5, r1)     // Catch:{ Exception -> 0x0110 }
            r6 = r17
            java.lang.String r6 = java.net.URLEncoder.encode(r6, r1)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r7 = com.google.android.recaptcha.internal.zzt.zzb()     // Catch:{ Exception -> 0x0110 }
            java.lang.String r1 = java.net.URLEncoder.encode(r7, r1)     // Catch:{ Exception -> 0x0110 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0110 }
            r7.<init>()     // Catch:{ Exception -> 0x0110 }
            r7.append(r4)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r4 = "?k="
            r7.append(r4)     // Catch:{ Exception -> 0x0110 }
            r7.append(r0)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r0 = "&msv="
            r7.append(r0)     // Catch:{ Exception -> 0x0110 }
            r7.append(r5)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r0 = "&mst="
            r7.append(r0)     // Catch:{ Exception -> 0x0110 }
            r7.append(r6)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r0 = "&mov="
            r7.append(r0)     // Catch:{ Exception -> 0x0110 }
            r7.append(r1)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x0110 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0110 }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x0110 }
            long r0 = r0.getId()     // Catch:{ Exception -> 0x0110 }
            int r0 = (int) r0     // Catch:{ Exception -> 0x0110 }
            android.net.TrafficStats.setThreadStatsTag(r0)     // Catch:{ Exception -> 0x0110 }
            java.net.URLConnection r0 = r3.openConnection()     // Catch:{ Exception -> 0x0110 }
            java.net.URLConnection r0 = com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation.openConnection(r0)     // Catch:{ Exception -> 0x0110 }
            java.lang.Object r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r0)     // Catch:{ Exception -> 0x0110 }
            java.net.URLConnection r0 = (java.net.URLConnection) r0     // Catch:{ Exception -> 0x0110 }
            java.lang.String r1 = "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)     // Catch:{ Exception -> 0x0110 }
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ Exception -> 0x0110 }
            java.lang.String r1 = "GET"
            r0.setRequestMethod(r1)     // Catch:{ Exception -> 0x0110 }
            r1 = 1
            r0.setDoInput(r1)     // Catch:{ Exception -> 0x0110 }
            java.lang.String r1 = "Accept"
            java.lang.String r3 = "application/x-protobuffer"
            r0.setRequestProperty(r1, r3)     // Catch:{ Exception -> 0x0110 }
            r0.connect()     // Catch:{ Exception -> 0x0110 }
            int r1 = r0.getResponseCode()     // Catch:{ Exception -> 0x0110 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r1 != r3) goto L_0x00f0
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ Exception -> 0x0110 }
            com.google.android.recaptcha.internal.zzmi r0 = com.google.android.recaptcha.internal.zzmi.zzj(r0)     // Catch:{ Exception -> 0x0110 }
            zza(r0)     // Catch:{ Exception -> 0x0110 }
            com.google.android.recaptcha.internal.zzaf r0 = new com.google.android.recaptcha.internal.zzaf     // Catch:{ Exception -> 0x0110 }
            r8 = 0
            r3 = r0
            r4 = r9
            r5 = r18
            r6 = r19
            r7 = r19
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0110 }
            java.lang.Long r1 = zzd     // Catch:{ Exception -> 0x0110 }
            int r3 = zze     // Catch:{ Exception -> 0x0110 }
            com.google.android.recaptcha.internal.zzai.zza(r0, r1, r3)     // Catch:{ Exception -> 0x0110 }
            com.google.android.recaptcha.internal.zzaf r0 = new com.google.android.recaptcha.internal.zzaf     // Catch:{ Exception -> 0x0110 }
            r8 = 0
            r3 = r0
            r4 = r9
            r5 = r18
            r6 = r19
            r7 = r19
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0110 }
            r1 = r20
            r3 = r21
            com.google.android.recaptcha.internal.zzai.zzc(r0, r1, r3)     // Catch:{ Exception -> 0x010e }
            r15 = r2
            goto L_0x0150
        L_0x00f0:
            r1 = r20
            r3 = r21
            com.google.android.recaptcha.internal.zzh r4 = new com.google.android.recaptcha.internal.zzh     // Catch:{ Exception -> 0x010e }
            com.google.android.recaptcha.internal.zzf r5 = com.google.android.recaptcha.internal.zzf.zzk     // Catch:{ Exception -> 0x010e }
            com.google.android.recaptcha.internal.zzd r6 = new com.google.android.recaptcha.internal.zzd     // Catch:{ Exception -> 0x010e }
            int r7 = r0.getResponseCode()     // Catch:{ Exception -> 0x010e }
            r6.<init>(r7)     // Catch:{ Exception -> 0x010e }
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x010e }
            int r0 = r0.getResponseCode()     // Catch:{ Exception -> 0x010e }
            kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)     // Catch:{ Exception -> 0x010e }
            r15 = r2
            r2 = r4
            goto L_0x0150
        L_0x010e:
            r0 = move-exception
            goto L_0x0115
        L_0x0110:
            r0 = move-exception
            r1 = r20
            r3 = r21
        L_0x0115:
            boolean r2 = r0 instanceof java.net.MalformedURLException
            if (r2 == 0) goto L_0x0123
            com.google.android.recaptcha.internal.zzh r2 = new com.google.android.recaptcha.internal.zzh
            com.google.android.recaptcha.internal.zzf r4 = com.google.android.recaptcha.internal.zzf.zze
            com.google.android.recaptcha.internal.zzd r5 = com.google.android.recaptcha.internal.zzd.zzc
            r2.<init>(r4, r5)
            goto L_0x0148
        L_0x0123:
            boolean r2 = r0 instanceof com.google.android.recaptcha.internal.zzhp
            if (r2 == 0) goto L_0x0131
            com.google.android.recaptcha.internal.zzh r2 = new com.google.android.recaptcha.internal.zzh
            com.google.android.recaptcha.internal.zzf r4 = com.google.android.recaptcha.internal.zzf.zze
            com.google.android.recaptcha.internal.zzd r5 = com.google.android.recaptcha.internal.zzd.zzS
            r2.<init>(r4, r5)
            goto L_0x0148
        L_0x0131:
            boolean r2 = r0 instanceof java.io.IOException
            if (r2 == 0) goto L_0x013f
            com.google.android.recaptcha.internal.zzh r2 = new com.google.android.recaptcha.internal.zzh
            com.google.android.recaptcha.internal.zzf r4 = com.google.android.recaptcha.internal.zzf.zze
            com.google.android.recaptcha.internal.zzd r5 = com.google.android.recaptcha.internal.zzd.zzR
            r2.<init>(r4, r5)
            goto L_0x0148
        L_0x013f:
            com.google.android.recaptcha.internal.zzh r2 = new com.google.android.recaptcha.internal.zzh
            com.google.android.recaptcha.internal.zzf r4 = com.google.android.recaptcha.internal.zzf.zzb
            com.google.android.recaptcha.internal.zzd r5 = com.google.android.recaptcha.internal.zzd.zzb
            r2.<init>(r4, r5)
        L_0x0148:
            java.lang.String r4 = r0.getMessage()
            r0.toString()
            r15 = r4
        L_0x0150:
            if (r2 == 0) goto L_0x017e
            com.google.android.recaptcha.internal.zzai r0 = com.google.android.recaptcha.internal.zzai.zza
            com.google.android.recaptcha.internal.zzaf r10 = new com.google.android.recaptcha.internal.zzaf
            com.google.android.recaptcha.internal.zzln r5 = com.google.android.recaptcha.internal.zzln.FETCH_ALLOWLIST
            r9 = 0
            r4 = r10
            r6 = r18
            r7 = r19
            r8 = r19
            r4.<init>(r5, r6, r7, r8, r9)
            com.google.android.recaptcha.internal.zzf r0 = r2.zzb()
            int r0 = r0.zza()
            java.lang.String r11 = java.lang.String.valueOf(r0)
            com.google.android.recaptcha.internal.zzd r0 = r2.zza()
            int r12 = r0.zza()
            r13 = r20
            r14 = r21
            com.google.android.recaptcha.internal.zzai.zzd(r10, r11, r12, r13, r14, r15)
        L_0x017e:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzaz.zzb(java.lang.String, java.lang.String, java.lang.String, java.lang.String, android.content.Context, com.google.android.recaptcha.internal.zzq, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final boolean zzc(@NotNull String str) {
        Set set = zzb;
        if (set == null || zzc == null) {
            if (zzd == null) {
                zzd = Long.valueOf(System.currentTimeMillis());
            }
            zze++;
            return true;
        }
        Intrinsics.checkNotNull(set, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
        if (set.isEmpty()) {
            return true;
        }
        Set set2 = zzc;
        Intrinsics.checkNotNull(set2, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
        if (zzd(str, set2)) {
            return false;
        }
        return zzd(str, set);
    }

    private static final boolean zzd(String str, Set set) {
        String str2 = "";
        for (String valueOf : StringsKt__StringsKt.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null)) {
            String concat = str2.concat(String.valueOf(valueOf));
            if (set.contains(concat)) {
                return true;
            }
            str2 = concat.concat(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        }
        return false;
    }
}
