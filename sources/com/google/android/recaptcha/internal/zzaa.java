package com.google.android.recaptcha.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaClient;
import com.google.android.recaptcha.RecaptchaTasksClient;
import java.util.UUID;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class zzaa implements RecaptchaClient, RecaptchaTasksClient {
    @NotNull
    public static final zzv zza = new zzv((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static zzaa zzb;
    /* access modifiers changed from: private */
    @NotNull
    public static final String zzc = UUID.randomUUID().toString();
    /* access modifiers changed from: private */
    public static String zzd;
    /* access modifiers changed from: private */
    @NotNull
    public static final Mutex zze = MutexKt.Mutex$default(false, 1, (Object) null);
    @NotNull
    private final zzdi zzf;
    @NotNull
    private final String zzg;

    public zzaa(@NotNull zzdi zzdi, @NotNull String str) {
        this.zzf = zzdi;
        this.zzg = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: execute-0E7RQCE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m9342execute0E7RQCE(@org.jetbrains.annotations.NotNull com.google.android.recaptcha.RecaptchaAction r11, long r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.String>> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.google.android.recaptcha.internal.zzw
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.google.android.recaptcha.internal.zzw r0 = (com.google.android.recaptcha.internal.zzw) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzw r0 = new com.google.android.recaptcha.internal.zzw
            r0.<init>(r10, r14)
        L_0x0018:
            java.lang.Object r14 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0055
        L_0x0029:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r14)
            r4 = 5000(0x1388, double:2.4703E-320)
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 < 0) goto L_0x005c
            kotlinx.coroutines.CoroutineScope r14 = com.google.android.recaptcha.internal.zzp.zzb()
            kotlin.coroutines.CoroutineContext r14 = r14.getCoroutineContext()
            com.google.android.recaptcha.internal.zzx r2 = new com.google.android.recaptcha.internal.zzx
            r9 = 0
            r4 = r2
            r5 = r10
            r6 = r11
            r7 = r12
            r4.<init>(r5, r6, r7, r9)
            r0.zzc = r3
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.withContext(r14, r2, r0)
            if (r14 != r1) goto L_0x0055
            return r1
        L_0x0055:
            kotlin.Result r14 = (kotlin.Result) r14
            java.lang.Object r11 = r14.m6338unboximpl()
            return r11
        L_0x005c:
            com.google.android.recaptcha.internal.zzdi r11 = r10.zzf
            r11.zzo()
            com.google.android.recaptcha.RecaptchaException r11 = new com.google.android.recaptcha.RecaptchaException
            com.google.android.recaptcha.RecaptchaErrorCode r12 = com.google.android.recaptcha.RecaptchaErrorCode.INVALID_TIMEOUT
            r13 = 2
            r14 = 0
            r11.<init>(r12, r14, r13, r14)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzaa.m9342execute0E7RQCE(com.google.android.recaptcha.RecaptchaAction, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: execute-gIAlu-s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m9343executegIAlus(@org.jetbrains.annotations.NotNull com.google.android.recaptcha.RecaptchaAction r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.String>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.google.android.recaptcha.internal.zzy
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.google.android.recaptcha.internal.zzy r0 = (com.google.android.recaptcha.internal.zzy) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzy r0 = new com.google.android.recaptcha.internal.zzy
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.m6338unboximpl()
            goto L_0x0045
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.zzc = r3
            r2 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r5 = r4.m9342execute0E7RQCE(r5, r2, r0)
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzaa.m9343executegIAlus(com.google.android.recaptcha.RecaptchaAction, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public final Task<String> executeTask(@NotNull RecaptchaAction recaptchaAction) {
        return zzb.zza(BuildersKt__Builders_commonKt.async$default(zzp.zzb(), (CoroutineContext) null, (CoroutineStart) null, new zzz(this, recaptchaAction, 5000, (Continuation) null), 3, (Object) null));
    }

    @NotNull
    public final zzdi zzb() {
        return this.zzf;
    }

    @NotNull
    public final String zze() {
        return this.zzg;
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public final Task<String> executeTask(@NotNull RecaptchaAction recaptchaAction, long j11) {
        return zzb.zza(BuildersKt__Builders_commonKt.async$default(zzp.zzb(), (CoroutineContext) null, (CoroutineStart) null, new zzz(this, recaptchaAction, j11, (Continuation) null), 3, (Object) null));
    }
}
