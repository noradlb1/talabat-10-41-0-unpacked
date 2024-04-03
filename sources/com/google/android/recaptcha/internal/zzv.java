package com.google.android.recaptcha.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class zzv {
    private zzv() {
    }

    public /* synthetic */ zzv(DefaultConstructorMarker defaultConstructorMarker) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bb A[SYNTHETIC, Splitter:B:29:0x00bb] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0120 A[Catch:{ all -> 0x0280 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0208 A[Catch:{ all -> 0x0280 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0240 A[SYNTHETIC, Splitter:B:75:0x0240] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zza(@org.jetbrains.annotations.NotNull android.app.Application r27, @org.jetbrains.annotations.NotNull java.lang.String r28, long r29, @org.jetbrains.annotations.NotNull com.google.android.recaptcha.internal.zzq r31, @org.jetbrains.annotations.Nullable android.webkit.WebView r32, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r33) throws kotlinx.coroutines.TimeoutCancellationException, com.google.android.gms.common.api.ApiException, com.google.android.recaptcha.RecaptchaException {
        /*
            r26 = this;
            r0 = r33
            boolean r1 = r0 instanceof com.google.android.recaptcha.internal.zzu
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.google.android.recaptcha.internal.zzu r1 = (com.google.android.recaptcha.internal.zzu) r1
            int r2 = r1.zzg
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.zzg = r2
            r2 = r26
            goto L_0x001e
        L_0x0017:
            com.google.android.recaptcha.internal.zzu r1 = new com.google.android.recaptcha.internal.zzu
            r2 = r26
            r1.<init>(r2, r0)
        L_0x001e:
            java.lang.Object r0 = r1.zze
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.zzg
            r5 = 3
            r6 = 1
            r7 = 2
            r8 = 0
            if (r4 == 0) goto L_0x0090
            if (r4 == r6) goto L_0x006c
            if (r4 == r7) goto L_0x004a
            if (r4 == r5) goto L_0x003a
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003a:
            java.lang.Object r3 = r1.zzb
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            java.lang.Object r1 = r1.zza
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0047 }
            goto L_0x0276
        L_0x0047:
            r0 = move-exception
            goto L_0x0282
        L_0x004a:
            com.google.android.recaptcha.internal.zzdi r4 = r1.zzi
            java.lang.Object r7 = r1.zzc
            com.google.android.recaptcha.internal.zzv r7 = (com.google.android.recaptcha.internal.zzv) r7
            kotlinx.coroutines.sync.Mutex r7 = r1.zzj
            com.google.android.recaptcha.internal.zzq r9 = r1.zzh
            java.lang.Object r10 = r1.zzb
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r1.zza
            android.app.Application r11 = (android.app.Application) r11
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0068 }
            kotlin.Result r0 = (kotlin.Result) r0     // Catch:{ all -> 0x0068 }
            java.lang.Object r0 = r0.m6338unboximpl()     // Catch:{ all -> 0x0068 }
            r13 = r7
            goto L_0x0202
        L_0x0068:
            r0 = move-exception
            r1 = r7
            goto L_0x0282
        L_0x006c:
            long r9 = r1.zzd
            java.lang.Object r4 = r1.zzc
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            kotlinx.coroutines.sync.Mutex r11 = r1.zzj
            android.webkit.WebView r11 = (android.webkit.WebView) r11
            com.google.android.recaptcha.internal.zzq r12 = r1.zzh
            java.lang.Object r13 = r1.zzb
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r1.zza
            android.app.Application r14 = (android.app.Application) r14
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = r11
            r23 = r13
            r13 = r4
            r4 = r14
            r24 = r9
            r10 = r12
            r11 = r24
            r9 = r23
            goto L_0x00b5
        L_0x0090:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlinx.coroutines.sync.Mutex r0 = com.google.android.recaptcha.internal.zzaa.zze
            r4 = r27
            r1.zza = r4
            r9 = r28
            r1.zzb = r9
            r10 = r31
            r1.zzh = r10
            r1.zzj = r8
            r1.zzc = r0
            r11 = r29
            r1.zzd = r11
            r1.zzg = r6
            java.lang.Object r13 = r0.lock(r8, r1)
            if (r13 == r3) goto L_0x0286
            r13 = r0
            r0 = r8
        L_0x00b5:
            r14 = 5000(0x1388, double:2.4703E-320)
            int r11 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r11 >= 0) goto L_0x0120
            com.google.android.recaptcha.internal.zzaf r0 = new com.google.android.recaptcha.internal.zzaf     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.internal.zzln r1 = com.google.android.recaptcha.internal.zzln.INIT_TOTAL     // Catch:{ all -> 0x0280 }
            java.lang.String r3 = com.google.android.recaptcha.internal.zzaa.zzc     // Catch:{ all -> 0x0280 }
            java.lang.String r5 = com.google.android.recaptcha.internal.zzaa.zzd     // Catch:{ all -> 0x0280 }
            if (r5 != 0) goto L_0x00ca
            r5 = r8
        L_0x00ca:
            java.lang.String r6 = com.google.android.recaptcha.internal.zzaa.zzd     // Catch:{ all -> 0x0280 }
            if (r6 != 0) goto L_0x00d1
            r6 = r8
        L_0x00d1:
            r11 = 0
            r27 = r0
            r28 = r1
            r29 = r3
            r30 = r5
            r31 = r6
            r32 = r11
            r27.<init>(r28, r29, r30, r31, r32)     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.internal.zzh r1 = new com.google.android.recaptcha.internal.zzh     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.internal.zzf r3 = com.google.android.recaptcha.internal.zzf.zzc     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.internal.zzd r5 = com.google.android.recaptcha.internal.zzd.zzU     // Catch:{ all -> 0x0280 }
            r1.<init>(r3, r5)     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.internal.zzai r3 = com.google.android.recaptcha.internal.zzai.zza     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.internal.zzr r3 = new com.google.android.recaptcha.internal.zzr     // Catch:{ all -> 0x0280 }
            r3.<init>()     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.internal.zzai.zzb(r0, r9, r3)     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.internal.zzf r3 = r1.zzb()     // Catch:{ all -> 0x0280 }
            int r3 = r3.zza()     // Catch:{ all -> 0x0280 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.internal.zzd r1 = r1.zza()     // Catch:{ all -> 0x0280 }
            int r1 = r1.zza()     // Catch:{ all -> 0x0280 }
            r5 = 0
            r27 = r0
            r28 = r3
            r29 = r1
            r30 = r4
            r31 = r10
            r32 = r5
            com.google.android.recaptcha.internal.zzai.zzd(r27, r28, r29, r30, r31, r32)     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.RecaptchaException r0 = new com.google.android.recaptcha.RecaptchaException     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.RecaptchaErrorCode r1 = com.google.android.recaptcha.RecaptchaErrorCode.INVALID_TIMEOUT     // Catch:{ all -> 0x0280 }
            r0.<init>(r1, r8, r7, r8)     // Catch:{ all -> 0x0280 }
            throw r0     // Catch:{ all -> 0x0280 }
        L_0x0120:
            java.lang.String r11 = "android.permission.INTERNET"
            int r11 = androidx.core.content.ContextCompat.checkSelfPermission(r4, r11)     // Catch:{ all -> 0x0280 }
            if (r11 != 0) goto L_0x0278
            com.google.android.recaptcha.internal.zzaa r11 = com.google.android.recaptcha.internal.zzaa.zzb     // Catch:{ all -> 0x0280 }
            if (r11 == 0) goto L_0x015f
            java.lang.String r0 = r11.zze()     // Catch:{ all -> 0x0280 }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r9)     // Catch:{ all -> 0x0280 }
            if (r0 == 0) goto L_0x013a
            goto L_0x023c
        L_0x013a:
            com.google.android.recaptcha.RecaptchaException r0 = new com.google.android.recaptcha.RecaptchaException     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.RecaptchaErrorCode r1 = com.google.android.recaptcha.RecaptchaErrorCode.INVALID_SITEKEY     // Catch:{ all -> 0x0280 }
            java.lang.String r3 = r11.zze()     // Catch:{ all -> 0x0280 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0280 }
            r4.<init>()     // Catch:{ all -> 0x0280 }
            java.lang.String r5 = "Only one site key can be used per runtime. The site key you provided "
            r4.append(r5)     // Catch:{ all -> 0x0280 }
            r4.append(r9)     // Catch:{ all -> 0x0280 }
            java.lang.String r5 = " is different than "
            r4.append(r5)     // Catch:{ all -> 0x0280 }
            r4.append(r3)     // Catch:{ all -> 0x0280 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0280 }
            r0.<init>(r1, r3)     // Catch:{ all -> 0x0280 }
            throw r0     // Catch:{ all -> 0x0280 }
        L_0x015f:
            com.google.android.recaptcha.internal.zzv r11 = com.google.android.recaptcha.internal.zzaa.zza     // Catch:{ all -> 0x0280 }
            java.util.UUID r12 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x0280 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.internal.zzaa.zzd = r12     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.internal.zzai r12 = com.google.android.recaptcha.internal.zzai.zza     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.internal.zzaf r12 = new com.google.android.recaptcha.internal.zzaf     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.internal.zzln r14 = com.google.android.recaptcha.internal.zzln.INIT_TOTAL     // Catch:{ all -> 0x0280 }
            java.lang.String r15 = com.google.android.recaptcha.internal.zzaa.zzc     // Catch:{ all -> 0x0280 }
            java.lang.String r16 = com.google.android.recaptcha.internal.zzaa.zzd     // Catch:{ all -> 0x0280 }
            if (r16 != 0) goto L_0x017e
            r16 = r8
        L_0x017e:
            java.lang.String r17 = com.google.android.recaptcha.internal.zzaa.zzd     // Catch:{ all -> 0x0280 }
            if (r17 != 0) goto L_0x0186
            r17 = r8
        L_0x0186:
            r18 = 0
            r27 = r12
            r28 = r14
            r29 = r15
            r30 = r16
            r31 = r17
            r32 = r18
            r27.<init>(r28, r29, r30, r31, r32)     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.internal.zzr r14 = new com.google.android.recaptcha.internal.zzr     // Catch:{ all -> 0x0280 }
            r14.<init>()     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.internal.zzai.zzb(r12, r9, r14)     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.internal.zzdi r12 = new com.google.android.recaptcha.internal.zzdi     // Catch:{ all -> 0x0280 }
            if (r0 != 0) goto L_0x01a8
            android.webkit.WebView r0 = new android.webkit.WebView     // Catch:{ all -> 0x0280 }
            r0.<init>(r4)     // Catch:{ all -> 0x0280 }
        L_0x01a8:
            r15 = r0
            java.lang.String r19 = com.google.android.recaptcha.internal.zzaa.zzc     // Catch:{ all -> 0x0280 }
            java.lang.String r0 = com.google.android.recaptcha.internal.zzaa.zzd     // Catch:{ all -> 0x0280 }
            if (r0 != 0) goto L_0x01b6
            r20 = r8
            goto L_0x01b8
        L_0x01b6:
            r20 = r0
        L_0x01b8:
            com.google.android.recaptcha.internal.zzao r21 = new com.google.android.recaptcha.internal.zzao     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.internal.zzaq r0 = new com.google.android.recaptcha.internal.zzaq     // Catch:{ all -> 0x0280 }
            java.lang.String r14 = r10.zzc()     // Catch:{ all -> 0x0280 }
            r0.<init>(r14)     // Catch:{ all -> 0x0280 }
            r14 = 0
            r16 = 4
            r17 = 0
            r27 = r21
            r28 = r4
            r29 = r0
            r30 = r14
            r31 = r16
            r32 = r17
            r27.<init>(r28, r29, r30, r31, r32)     // Catch:{ all -> 0x0280 }
            kotlinx.coroutines.CoroutineScope r22 = com.google.android.recaptcha.internal.zzp.zzb()     // Catch:{ all -> 0x0280 }
            r14 = r12
            r16 = r9
            r17 = r4
            r18 = r10
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ all -> 0x0280 }
            r1.zza = r4     // Catch:{ all -> 0x0280 }
            r1.zzb = r9     // Catch:{ all -> 0x0280 }
            r1.zzh = r10     // Catch:{ all -> 0x0280 }
            r1.zzj = r13     // Catch:{ all -> 0x0280 }
            r1.zzc = r11     // Catch:{ all -> 0x0280 }
            r1.zzi = r12     // Catch:{ all -> 0x0280 }
            r1.zzg = r7     // Catch:{ all -> 0x0280 }
            r14 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r0 = r12.zzg(r14, r1)     // Catch:{ all -> 0x0280 }
            if (r0 == r3) goto L_0x0277
            r11 = r4
            r4 = r12
            r23 = r10
            r10 = r9
            r9 = r23
        L_0x0202:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r0)     // Catch:{ all -> 0x0280 }
            if (r0 != 0) goto L_0x0240
            com.google.android.recaptcha.internal.zzaa r0 = new com.google.android.recaptcha.internal.zzaa     // Catch:{ all -> 0x0280 }
            r0.<init>(r4, r10)     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.internal.zzai r1 = com.google.android.recaptcha.internal.zzai.zza     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.internal.zzaf r1 = new com.google.android.recaptcha.internal.zzaf     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.internal.zzln r3 = com.google.android.recaptcha.internal.zzln.INIT_TOTAL     // Catch:{ all -> 0x0280 }
            java.lang.String r4 = com.google.android.recaptcha.internal.zzaa.zzc     // Catch:{ all -> 0x0280 }
            java.lang.String r5 = com.google.android.recaptcha.internal.zzaa.zzd     // Catch:{ all -> 0x0280 }
            if (r5 != 0) goto L_0x021e
            r5 = r8
        L_0x021e:
            java.lang.String r6 = com.google.android.recaptcha.internal.zzaa.zzd     // Catch:{ all -> 0x0280 }
            if (r6 != 0) goto L_0x0225
            r6 = r8
        L_0x0225:
            r7 = 0
            r27 = r1
            r28 = r3
            r29 = r4
            r30 = r5
            r31 = r6
            r32 = r7
            r27.<init>(r28, r29, r30, r31, r32)     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.internal.zzai.zzc(r1, r11, r9)     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.internal.zzaa.zzb = r0     // Catch:{ all -> 0x0280 }
            r11 = r0
        L_0x023c:
            r13.unlock(r8)
            return r11
        L_0x0240:
            kotlinx.coroutines.CoroutineScope r4 = com.google.android.recaptcha.internal.zzp.zzc()     // Catch:{ all -> 0x0280 }
            kotlin.coroutines.CoroutineContext r4 = r4.getCoroutineContext()     // Catch:{ all -> 0x0280 }
            kotlinx.coroutines.JobKt__JobKt.cancelChildren$default((kotlin.coroutines.CoroutineContext) r4, (java.util.concurrent.CancellationException) r8, (int) r6, (java.lang.Object) r8)     // Catch:{ all -> 0x0280 }
            kotlinx.coroutines.CoroutineScope r4 = com.google.android.recaptcha.internal.zzp.zzc()     // Catch:{ all -> 0x0280 }
            kotlin.coroutines.CoroutineContext r4 = r4.getCoroutineContext()     // Catch:{ all -> 0x0280 }
            kotlinx.coroutines.Job r4 = kotlinx.coroutines.JobKt.getJob(r4)     // Catch:{ all -> 0x0280 }
            kotlin.sequences.Sequence r4 = r4.getChildren()     // Catch:{ all -> 0x0280 }
            java.util.List r4 = kotlin.sequences.SequencesKt___SequencesKt.toList(r4)     // Catch:{ all -> 0x0280 }
            r1.zza = r13     // Catch:{ all -> 0x0280 }
            r1.zzb = r0     // Catch:{ all -> 0x0280 }
            r1.zzh = r8     // Catch:{ all -> 0x0280 }
            r1.zzj = r8     // Catch:{ all -> 0x0280 }
            r1.zzc = r8     // Catch:{ all -> 0x0280 }
            r1.zzi = r8     // Catch:{ all -> 0x0280 }
            r1.zzg = r5     // Catch:{ all -> 0x0280 }
            java.lang.Object r1 = kotlinx.coroutines.AwaitKt.joinAll((java.util.Collection<? extends kotlinx.coroutines.Job>) r4, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r1)     // Catch:{ all -> 0x0280 }
            if (r1 != r3) goto L_0x0274
            return r3
        L_0x0274:
            r3 = r0
            r1 = r13
        L_0x0276:
            throw r3     // Catch:{ all -> 0x0047 }
        L_0x0277:
            return r3
        L_0x0278:
            com.google.android.recaptcha.RecaptchaException r0 = new com.google.android.recaptcha.RecaptchaException     // Catch:{ all -> 0x0280 }
            com.google.android.recaptcha.RecaptchaErrorCode r1 = com.google.android.recaptcha.RecaptchaErrorCode.NETWORK_ERROR     // Catch:{ all -> 0x0280 }
            r0.<init>(r1, r8, r7, r8)     // Catch:{ all -> 0x0280 }
            throw r0     // Catch:{ all -> 0x0280 }
        L_0x0280:
            r0 = move-exception
            r1 = r13
        L_0x0282:
            r1.unlock(r8)
            throw r0
        L_0x0286:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzv.zza(android.app.Application, java.lang.String, long, com.google.android.recaptcha.internal.zzq, android.webkit.WebView, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
