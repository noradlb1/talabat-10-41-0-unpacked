package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class zzdg extends SuspendLambda implements Function2 {
    Object zza;
    Object zzb;
    Object zzc;
    int zzd;
    final /* synthetic */ zzdi zze;
    final /* synthetic */ String zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdg(zzdi zzdi, String str, Continuation continuation) {
        super(2, continuation);
        this.zze = zzdi;
        this.zzf = str;
    }

    @NotNull
    public final Continuation create(@Nullable Object obj, @NotNull Continuation continuation) {
        return new zzdg(this.zze, this.zzf, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzdg) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.google.android.recaptcha.internal.zzdi} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.google.android.recaptcha.internal.zzdi} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.google.android.recaptcha.internal.zzdi} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: kotlinx.coroutines.sync.Mutex} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.zzd
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0021
            if (r1 == r2) goto L_0x0014
            java.lang.Object r0 = r13.zza
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0012 }
            goto L_0x0071
        L_0x0012:
            r14 = move-exception
            goto L_0x007c
        L_0x0014:
            java.lang.Object r1 = r13.zzc
            java.lang.Object r2 = r13.zzb
            java.lang.Object r4 = r13.zza
            kotlin.ResultKt.throwOnFailure(r14)
            r12 = r4
            r4 = r1
            r1 = r12
            goto L_0x003b
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r14)
            com.google.android.recaptcha.internal.zzdi r14 = r13.zze
            kotlinx.coroutines.sync.Mutex r1 = r14.zzo
            java.lang.String r4 = r13.zzf
            r13.zza = r1
            r13.zzb = r14
            r13.zzc = r4
            r13.zzd = r2
            java.lang.Object r2 = r1.lock(r3, r13)
            if (r2 == r0) goto L_0x0080
            r2 = r14
        L_0x003b:
            r14 = r2
            com.google.android.recaptcha.internal.zzdi r14 = (com.google.android.recaptcha.internal.zzdi) r14     // Catch:{ all -> 0x007a }
            java.lang.String r5 = r14.zzd     // Catch:{ all -> 0x007a }
            r14 = r2
            com.google.android.recaptcha.internal.zzdi r14 = (com.google.android.recaptcha.internal.zzdi) r14     // Catch:{ all -> 0x007a }
            java.lang.String r7 = r14.zzh     // Catch:{ all -> 0x007a }
            r14 = r2
            com.google.android.recaptcha.internal.zzdi r14 = (com.google.android.recaptcha.internal.zzdi) r14     // Catch:{ all -> 0x007a }
            java.lang.String r8 = r14.zzg     // Catch:{ all -> 0x007a }
            r14 = r2
            com.google.android.recaptcha.internal.zzdi r14 = (com.google.android.recaptcha.internal.zzdi) r14     // Catch:{ all -> 0x007a }
            android.content.Context r9 = r14.zze     // Catch:{ all -> 0x007a }
            com.google.android.recaptcha.internal.zzdi r2 = (com.google.android.recaptcha.internal.zzdi) r2     // Catch:{ all -> 0x007a }
            com.google.android.recaptcha.internal.zzq r10 = r2.zzf     // Catch:{ all -> 0x007a }
            r13.zza = r1     // Catch:{ all -> 0x007a }
            r13.zzb = r3     // Catch:{ all -> 0x007a }
            r13.zzc = r3     // Catch:{ all -> 0x007a }
            r14 = 2
            r13.zzd = r14     // Catch:{ all -> 0x007a }
            r6 = r4
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x007a }
            r11 = r13
            java.lang.Object r14 = com.google.android.recaptcha.internal.zzaz.zzb(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x007a }
            if (r14 == r0) goto L_0x0079
            r0 = r1
        L_0x0071:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0012 }
            r0.unlock(r3)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x0079:
            return r0
        L_0x007a:
            r14 = move-exception
            r0 = r1
        L_0x007c:
            r0.unlock(r3)
            throw r14
        L_0x0080:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzdg.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
