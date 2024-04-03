package com.google.android.recaptcha;

import android.app.Application;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.internal.zzb;
import com.google.android.recaptcha.internal.zzp;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/google/android/recaptcha/Recaptcha;", "", "()V", "getClient", "Lkotlin/Result;", "Lcom/google/android/recaptcha/RecaptchaClient;", "application", "Landroid/app/Application;", "siteKey", "", "timeout", "", "getClient-BWLJW6A", "(Landroid/app/Application;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTasksClient", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/recaptcha/RecaptchaTasksClient;", "java.com.google.android.libraries.abuse.recaptcha.enterprise_enterprise"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Recaptcha {
    @NotNull
    public static final Recaptcha INSTANCE = new Recaptcha();

    private Recaptcha() {
    }

    @NonNull
    /* renamed from: getClient-BWLJW6A$default  reason: not valid java name */
    public static /* synthetic */ Object m9338getClientBWLJW6A$default(@NonNull Recaptcha recaptcha, @NonNull Application application, @NonNull String str, long j11, @NonNull Continuation continuation, int i11, @NonNull Object obj) {
        if ((i11 & 4) != 0) {
            j11 = 10000;
        }
        return recaptcha.m9339getClientBWLJW6A(application, str, j11, continuation);
    }

    @JvmStatic
    @NotNull
    public static final Task<RecaptchaTasksClient> getTasksClient(@NonNull Application application, @NonNull String str) {
        return zzb.zza(BuildersKt__Builders_commonKt.async$default(zzp.zzb(), (CoroutineContext) null, (CoroutineStart) null, new Recaptcha$getTasksClient$1(application, str, (Continuation) null), 3, (Object) null));
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    @androidx.annotation.NonNull
    /* renamed from: getClient-BWLJW6A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m9339getClientBWLJW6A(@androidx.annotation.NonNull android.app.Application r11, @androidx.annotation.NonNull java.lang.String r12, long r13, @androidx.annotation.NonNull kotlin.coroutines.Continuation<? super kotlin.Result<? extends com.google.android.recaptcha.RecaptchaClient>> r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof com.google.android.recaptcha.Recaptcha$getClient$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.google.android.recaptcha.Recaptcha$getClient$1 r0 = (com.google.android.recaptcha.Recaptcha$getClient$1) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.Recaptcha$getClient$1 r0 = new com.google.android.recaptcha.Recaptcha$getClient$1
            r0.<init>(r10, r15)
        L_0x0018:
            java.lang.Object r15 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x0029 }
            goto L_0x0053
        L_0x0029:
            r11 = move-exception
            goto L_0x005a
        L_0x002b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r15)
            kotlin.Result$Companion r15 = kotlin.Result.Companion     // Catch:{ all -> 0x0029 }
            kotlinx.coroutines.CoroutineScope r15 = com.google.android.recaptcha.internal.zzp.zzb()     // Catch:{ all -> 0x0029 }
            kotlin.coroutines.CoroutineContext r15 = r15.getCoroutineContext()     // Catch:{ all -> 0x0029 }
            com.google.android.recaptcha.Recaptcha$getClient$2$1 r2 = new com.google.android.recaptcha.Recaptcha$getClient$2$1     // Catch:{ all -> 0x0029 }
            r9 = 0
            r4 = r2
            r5 = r11
            r6 = r12
            r7 = r13
            r4.<init>(r5, r6, r7, r9)     // Catch:{ all -> 0x0029 }
            r0.zzc = r3     // Catch:{ all -> 0x0029 }
            java.lang.Object r15 = kotlinx.coroutines.BuildersKt.withContext(r15, r2, r0)     // Catch:{ all -> 0x0029 }
            if (r15 != r1) goto L_0x0053
            return r1
        L_0x0053:
            com.google.android.recaptcha.internal.zzaa r15 = (com.google.android.recaptcha.internal.zzaa) r15     // Catch:{ all -> 0x0029 }
            java.lang.Object r11 = kotlin.Result.m6329constructorimpl(r15)     // Catch:{ all -> 0x0029 }
            goto L_0x0064
        L_0x005a:
            kotlin.Result$Companion r12 = kotlin.Result.Companion
            java.lang.Object r11 = kotlin.ResultKt.createFailure(r11)
            java.lang.Object r11 = kotlin.Result.m6329constructorimpl(r11)
        L_0x0064:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.Recaptcha.m9339getClientBWLJW6A(android.app.Application, java.lang.String, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @JvmStatic
    @NotNull
    public static final Task<RecaptchaTasksClient> getTasksClient(@NonNull Application application, @NonNull String str, long j11) {
        return zzb.zza(BuildersKt__Builders_commonKt.async$default(zzp.zzb(), (CoroutineContext) null, (CoroutineStart) null, new Recaptcha$getTasksClient$2(application, str, j11, (Continuation) null), 3, (Object) null));
    }
}
