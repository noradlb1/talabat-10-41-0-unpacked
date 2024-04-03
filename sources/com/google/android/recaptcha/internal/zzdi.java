package com.google.android.recaptcha.internal;

import android.content.Context;
import android.webkit.WebView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;

public final class zzdi {
    @NotNull
    public static final zzdb zza = new zzdb((DefaultConstructorMarker) null);
    public CompletableDeferred zzb;
    @NotNull
    private final WebView zzc;
    /* access modifiers changed from: private */
    @NotNull
    public final String zzd;
    /* access modifiers changed from: private */
    @NotNull
    public final Context zze;
    /* access modifiers changed from: private */
    @NotNull
    public final zzq zzf;
    /* access modifiers changed from: private */
    @NotNull
    public final String zzg;
    /* access modifiers changed from: private */
    @NotNull
    public final String zzh;
    @NotNull
    private final zzaj zzi;
    /* access modifiers changed from: private */
    @NotNull
    public final Map zzj = zzdj.zza();
    /* access modifiers changed from: private */
    @NotNull
    public final Map zzk;
    @NotNull
    private final Map zzl;
    @NotNull
    private final zzas zzm;
    /* access modifiers changed from: private */
    @NotNull
    public final zzdt zzn;
    /* access modifiers changed from: private */
    @NotNull
    public final Mutex zzo;
    @NotNull
    private final zzdc zzp;

    public zzdi(@NotNull WebView webView, @NotNull String str, @NotNull Context context, @NotNull zzq zzq, @NotNull String str2, @NotNull String str3, @NotNull zzaj zzaj, @NotNull CoroutineScope coroutineScope) {
        this.zzc = webView;
        this.zzd = str;
        this.zze = context;
        this.zzf = zzq;
        this.zzg = str2;
        this.zzh = str3;
        this.zzi = zzaj;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzk = linkedHashMap;
        this.zzl = linkedHashMap;
        this.zzm = new zzay(new zzbb(webView, coroutineScope), zzp.zzc(), context, new zzn());
        this.zzn = zzdt.zzc();
        this.zzo = MutexKt.Mutex$default(false, 1, (Object) null);
        zzdc zzdc = new zzdc(this);
        this.zzp = zzdc;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(zzdc, "RN");
        webView.setWebViewClient(new zzda(this));
    }

    private final zzh zzp(Exception exc) {
        if (exc instanceof TimeoutCancellationException) {
            return new zzh(zzf.zzc, zzd.zzj);
        }
        if (exc instanceof zzh) {
            return (zzh) exc;
        }
        return new zzh(zzf.zzc, zzd.zzu);
    }

    private final void zzq(List list, zzh zzh2) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzai zzai = zzai.zza;
            String str = this.zzg;
            String str2 = this.zzh;
            zzai.zzd(new zzaf((zzln) it.next(), str, str2, str2, (String) null), String.valueOf(zzh2.zzb().zza()), zzh2.zza().zza(), this.zze, this.zzf, (String) null);
        }
    }

    @NotNull
    public final WebView zzb() {
        return this.zzc;
    }

    @NotNull
    public final zzas zzd() {
        return this.zzm;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzf(@org.jetbrains.annotations.NotNull com.google.android.recaptcha.RecaptchaAction r12, long r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r15) {
        /*
            r11 = this;
            boolean r0 = r15 instanceof com.google.android.recaptcha.internal.zzdd
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.google.android.recaptcha.internal.zzdd r0 = (com.google.android.recaptcha.internal.zzdd) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzdd r0 = new com.google.android.recaptcha.internal.zzdd
            r0.<init>(r11, r15)
        L_0x0018:
            java.lang.Object r15 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.String r12 = r0.zze
            com.google.android.recaptcha.internal.zzdi r13 = r0.zzd
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ Exception -> 0x002d }
            goto L_0x0089
        L_0x002d:
            r14 = move-exception
            goto L_0x00ac
        L_0x0030:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r15)
            java.util.UUID r15 = java.util.UUID.randomUUID()
            java.lang.String r15 = r15.toString()
            com.google.android.recaptcha.internal.zzai r2 = com.google.android.recaptcha.internal.zzai.zza
            com.google.android.recaptcha.internal.zzaf r2 = new com.google.android.recaptcha.internal.zzaf
            com.google.android.recaptcha.internal.zzln r5 = com.google.android.recaptcha.internal.zzln.EXECUTE_TOTAL
            java.lang.String r6 = r11.zzg
            java.lang.String r7 = r11.zzh
            r9 = 0
            r4 = r2
            r8 = r15
            r4.<init>(r5, r6, r7, r8, r9)
            java.lang.String r4 = r11.zzd
            com.google.android.recaptcha.internal.zzr r5 = new com.google.android.recaptcha.internal.zzr
            r5.<init>()
            com.google.android.recaptcha.internal.zzai.zzb(r2, r4, r5)
            com.google.android.recaptcha.internal.zzaf r2 = new com.google.android.recaptcha.internal.zzaf
            com.google.android.recaptcha.internal.zzln r5 = com.google.android.recaptcha.internal.zzln.EXECUTE_NATIVE
            java.lang.String r6 = r11.zzg
            java.lang.String r7 = r11.zzh
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            java.lang.String r4 = r11.zzd
            com.google.android.recaptcha.internal.zzr r5 = new com.google.android.recaptcha.internal.zzr
            r5.<init>()
            com.google.android.recaptcha.internal.zzai.zzb(r2, r4, r5)
            com.google.android.recaptcha.internal.zzde r2 = new com.google.android.recaptcha.internal.zzde     // Catch:{ Exception -> 0x00a8 }
            r4 = 0
            r2.<init>(r12, r11, r15, r4)     // Catch:{ Exception -> 0x00a8 }
            r0.zzd = r11     // Catch:{ Exception -> 0x00a8 }
            r0.zze = r15     // Catch:{ Exception -> 0x00a8 }
            r0.zzc = r3     // Catch:{ Exception -> 0x00a8 }
            java.lang.Object r12 = kotlinx.coroutines.TimeoutKt.withTimeout(r13, r2, r0)     // Catch:{ Exception -> 0x00a8 }
            if (r12 == r1) goto L_0x00a7
            r13 = r11
            r10 = r15
            r15 = r12
            r12 = r10
        L_0x0089:
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ Exception -> 0x002d }
            com.google.android.recaptcha.internal.zzai r14 = com.google.android.recaptcha.internal.zzai.zza     // Catch:{ Exception -> 0x002d }
            com.google.android.recaptcha.internal.zzaf r14 = new com.google.android.recaptcha.internal.zzaf     // Catch:{ Exception -> 0x002d }
            com.google.android.recaptcha.internal.zzln r3 = com.google.android.recaptcha.internal.zzln.EXECUTE_TOTAL     // Catch:{ Exception -> 0x002d }
            java.lang.String r4 = r13.zzg     // Catch:{ Exception -> 0x002d }
            java.lang.String r5 = r13.zzh     // Catch:{ Exception -> 0x002d }
            r7 = 0
            r2 = r14
            r6 = r12
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x002d }
            android.content.Context r0 = r13.zze     // Catch:{ Exception -> 0x002d }
            com.google.android.recaptcha.internal.zzq r1 = r13.zzf     // Catch:{ Exception -> 0x002d }
            com.google.android.recaptcha.internal.zzai.zzc(r14, r0, r1)     // Catch:{ Exception -> 0x002d }
            java.lang.Object r12 = kotlin.Result.m6329constructorimpl(r15)     // Catch:{ Exception -> 0x002d }
            goto L_0x00d8
        L_0x00a7:
            return r1
        L_0x00a8:
            r12 = move-exception
            r14 = r12
            r13 = r11
            r12 = r15
        L_0x00ac:
            com.google.android.recaptcha.internal.zzln r15 = com.google.android.recaptcha.internal.zzln.EXECUTE_TOTAL
            java.util.List r15 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r15)
            com.google.android.recaptcha.internal.zzh r14 = r13.zzp(r14)
            r13.zzq(r15, r14)
            com.google.android.recaptcha.RecaptchaException r14 = r14.zzc()
            java.util.Map r13 = r13.zzk
            java.lang.Object r12 = r13.remove(r12)
            kotlinx.coroutines.CancellableContinuation r12 = (kotlinx.coroutines.CancellableContinuation) r12
            if (r12 == 0) goto L_0x00ce
            boolean r12 = r12.cancel(r14)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)
        L_0x00ce:
            kotlin.Result$Companion r12 = kotlin.Result.Companion
            java.lang.Object r12 = kotlin.ResultKt.createFailure(r14)
            java.lang.Object r12 = kotlin.Result.m6329constructorimpl(r12)
        L_0x00d8:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzdi.zzf(com.google.android.recaptcha.RecaptchaAction, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b5, code lost:
        if (r3.longValue() > (r11 - 2000)) goto L_0x00b7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzg(long r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.google.android.recaptcha.internal.zzdf
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.google.android.recaptcha.internal.zzdf r0 = (com.google.android.recaptcha.internal.zzdf) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzd = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzdf r0 = new com.google.android.recaptcha.internal.zzdf
            r0.<init>(r10, r13)
        L_0x0018:
            java.lang.Object r13 = r0.zzb
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzd
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            long r11 = r0.zza
            com.google.android.recaptcha.internal.zzdi r0 = r0.zze
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ Exception -> 0x002d }
            goto L_0x0078
        L_0x002d:
            r13 = move-exception
            goto L_0x0082
        L_0x002f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r13)
            com.google.android.recaptcha.internal.zzai r13 = com.google.android.recaptcha.internal.zzai.zza
            com.google.android.recaptcha.internal.zzaf r13 = new com.google.android.recaptcha.internal.zzaf
            com.google.android.recaptcha.internal.zzln r5 = com.google.android.recaptcha.internal.zzln.INIT_NATIVE
            java.lang.String r6 = r10.zzg
            java.lang.String r8 = r10.zzh
            r9 = 0
            r4 = r13
            r7 = r8
            r4.<init>(r5, r6, r7, r8, r9)
            java.lang.String r2 = r10.zzd
            com.google.android.recaptcha.internal.zzr r4 = new com.google.android.recaptcha.internal.zzr
            r4.<init>()
            com.google.android.recaptcha.internal.zzai.zzb(r13, r2, r4)
            r13 = 0
            kotlinx.coroutines.CompletableDeferred r2 = kotlinx.coroutines.CompletableDeferredKt.CompletableDeferred$default(r13, r3, r13)
            r10.zzb = r2
            kotlinx.coroutines.CompletableDeferred r2 = r10.zzm()
            int r2 = r2.hashCode()
            kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            com.google.android.recaptcha.internal.zzdh r2 = new com.google.android.recaptcha.internal.zzdh     // Catch:{ Exception -> 0x0080 }
            r2.<init>(r10, r13)     // Catch:{ Exception -> 0x0080 }
            r0.zze = r10     // Catch:{ Exception -> 0x0080 }
            r0.zza = r11     // Catch:{ Exception -> 0x0080 }
            r0.zzd = r3     // Catch:{ Exception -> 0x0080 }
            java.lang.Object r13 = kotlinx.coroutines.TimeoutKt.withTimeout(r11, r2, r0)     // Catch:{ Exception -> 0x0080 }
            if (r13 == r1) goto L_0x007f
            r0 = r10
        L_0x0078:
            kotlin.Result r13 = (kotlin.Result) r13     // Catch:{ Exception -> 0x002d }
            java.lang.Object r11 = r13.m6338unboximpl()     // Catch:{ Exception -> 0x002d }
            goto L_0x00d6
        L_0x007f:
            return r1
        L_0x0080:
            r13 = move-exception
            r0 = r10
        L_0x0082:
            r13.getMessage()
            boolean r1 = r13 instanceof kotlinx.coroutines.TimeoutCancellationException
            if (r1 == 0) goto L_0x009a
            r2 = 2
            com.google.android.recaptcha.internal.zzln[] r2 = new com.google.android.recaptcha.internal.zzln[r2]
            r4 = 0
            com.google.android.recaptcha.internal.zzln r5 = com.google.android.recaptcha.internal.zzln.INIT_TOTAL
            r2[r4] = r5
            com.google.android.recaptcha.internal.zzln r4 = com.google.android.recaptcha.internal.zzln.INIT_NETWORK
            r2[r3] = r4
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.listOf(r2)
            goto L_0x00a0
        L_0x009a:
            com.google.android.recaptcha.internal.zzln r2 = com.google.android.recaptcha.internal.zzln.INIT_TOTAL
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r2)
        L_0x00a0:
            com.google.android.recaptcha.internal.zzdc r3 = r0.zzp
            java.lang.Long r3 = r3.zza()
            if (r1 != 0) goto L_0x00a9
            goto L_0x00c1
        L_0x00a9:
            if (r3 != 0) goto L_0x00ac
            goto L_0x00b7
        L_0x00ac:
            r4 = -2000(0xfffffffffffff830, double:NaN)
            long r11 = r11 + r4
            long r3 = r3.longValue()
            int r11 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r11 <= 0) goto L_0x00c1
        L_0x00b7:
            com.google.android.recaptcha.internal.zzh r11 = new com.google.android.recaptcha.internal.zzh
            com.google.android.recaptcha.internal.zzf r12 = com.google.android.recaptcha.internal.zzf.zze
            com.google.android.recaptcha.internal.zzd r13 = com.google.android.recaptcha.internal.zzd.zzT
            r11.<init>(r12, r13)
            goto L_0x00c5
        L_0x00c1:
            com.google.android.recaptcha.internal.zzh r11 = r0.zzp(r13)
        L_0x00c5:
            r0.zzq(r2, r11)
            kotlin.Result$Companion r12 = kotlin.Result.Companion
            com.google.android.recaptcha.RecaptchaException r11 = r11.zzc()
            java.lang.Object r11 = kotlin.ResultKt.createFailure(r11)
            java.lang.Object r11 = kotlin.Result.m6329constructorimpl(r11)
        L_0x00d6:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzdi.zzg(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public final CompletableDeferred zzm() {
        CompletableDeferred completableDeferred = this.zzb;
        if (completableDeferred != null) {
            return completableDeferred;
        }
        return null;
    }

    public final void zzo() {
        zzln zzln = zzln.EXECUTE_TOTAL;
        String str = this.zzg;
        String str2 = this.zzh;
        zzaf zzaf = new zzaf(zzln, str, str2, str2, (String) null);
        zzh zzh2 = new zzh(zzf.zzc, zzd.zzU);
        zzai zzai = zzai.zza;
        zzai.zzb(zzaf, this.zzd, new zzr());
        zzai.zzd(zzaf, String.valueOf(zzh2.zzb().zza()), zzh2.zza().zza(), this.zze, this.zzf, (String) null);
    }
}
