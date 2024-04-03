package com.talabat.core.safety.data;

import com.talabat.core.safety.domain.SafetyEventType;
import com.talabat.core.safety.domain.entities.SafetyAppData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.core.safety.data.DefaultSafetyAgent$sendSafetyInformation$1", f = "DefaultSafetyAgent.kt", i = {0}, l = {40, 56}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class DefaultSafetyAgent$sendSafetyInformation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f55960h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DefaultSafetyAgent f55961i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f55962j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ SafetyEventType f55963k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ SafetyAppData f55964l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultSafetyAgent$sendSafetyInformation$1(DefaultSafetyAgent defaultSafetyAgent, String str, SafetyEventType safetyEventType, SafetyAppData safetyAppData, Continuation<? super DefaultSafetyAgent$sendSafetyInformation$1> continuation) {
        super(2, continuation);
        this.f55961i = defaultSafetyAgent;
        this.f55962j = str;
        this.f55963k = safetyEventType;
        this.f55964l = safetyAppData;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DefaultSafetyAgent$sendSafetyInformation$1 defaultSafetyAgent$sendSafetyInformation$1 = new DefaultSafetyAgent$sendSafetyInformation$1(this.f55961i, this.f55962j, this.f55963k, this.f55964l, continuation);
        defaultSafetyAgent$sendSafetyInformation$1.L$0 = obj;
        return defaultSafetyAgent$sendSafetyInformation$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DefaultSafetyAgent$sendSafetyInformation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d5 A[Catch:{ all -> 0x001b }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ef  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r16) {
        /*
            r15 = this;
            r7 = r15
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r7.f55960h
            java.lang.String r9 = "errorMessage"
            java.lang.String r10 = "errorType"
            r11 = 0
            java.lang.String r12 = ""
            r13 = 2
            r14 = 1
            if (r0 == 0) goto L_0x0030
            if (r0 == r14) goto L_0x0026
            if (r0 != r13) goto L_0x001e
            kotlin.ResultKt.throwOnFailure(r16)     // Catch:{ all -> 0x001b }
            goto L_0x00d6
        L_0x001b:
            r0 = move-exception
            goto L_0x00dd
        L_0x001e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0026:
            java.lang.Object r0 = r7.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r16)     // Catch:{ all -> 0x006f }
            r0 = r16
            goto L_0x0068
        L_0x0030:
            kotlin.ResultKt.throwOnFailure(r16)
            java.lang.Object r0 = r7.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            com.talabat.core.safety.data.DefaultSafetyAgent r1 = r7.f55961i
            com.talabat.core.safety.data.repository.protection.ProtectionRepository r1 = r1.protectionRepository
            java.lang.String r1 = r1.generateNonce()
            com.talabat.core.safety.data.DefaultSafetyAgent r2 = r7.f55961i
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch:{ all -> 0x006f }
            com.talabat.core.safety.data.datasource.availability.AvailabilityCheck r3 = r2.availabilityCheck     // Catch:{ all -> 0x006f }
            boolean r3 = r3.isSafetyCheckAvailable()     // Catch:{ all -> 0x006f }
            if (r3 != 0) goto L_0x0051
            r0 = r12
            goto L_0x006a
        L_0x0051:
            com.talabat.core.safety.data.datasource.api.SafetyApi r3 = r2.safetyApi     // Catch:{ all -> 0x006f }
            com.talabat.authentication.aaa.secrets.SecretProvider r2 = r2.secretProvider     // Catch:{ all -> 0x006f }
            java.lang.String r2 = r2.getGoogleApiKey()     // Catch:{ all -> 0x006f }
            r7.L$0 = r0     // Catch:{ all -> 0x006f }
            r7.f55960h = r14     // Catch:{ all -> 0x006f }
            java.lang.Object r0 = r3.performSafetyRequest(r1, r2, r15)     // Catch:{ all -> 0x006f }
            if (r0 != r8) goto L_0x0068
            return r8
        L_0x0068:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x006f }
        L_0x006a:
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x006f }
            goto L_0x007a
        L_0x006f:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x007a:
            com.talabat.core.safety.data.DefaultSafetyAgent r1 = r7.f55961i
            java.lang.Throwable r2 = kotlin.Result.m6332exceptionOrNullimpl(r0)
            if (r2 == 0) goto L_0x00ac
            com.talabat.core.observabilityNew.domain.IObservabilityManager r1 = r1.observabilityManager
            kotlin.Pair[] r3 = new kotlin.Pair[r13]
            java.lang.Class r4 = r2.getClass()
            java.lang.String r4 = r4.getName()
            kotlin.Pair r4 = kotlin.TuplesKt.to(r10, r4)
            r3[r11] = r4
            java.lang.String r2 = r2.getMessage()
            if (r2 != 0) goto L_0x009d
            r2 = r12
        L_0x009d:
            kotlin.Pair r2 = kotlin.TuplesKt.to(r9, r2)
            r3[r14] = r2
            java.util.Map r2 = kotlin.collections.MapsKt__MapsKt.mutableMapOf(r3)
            java.lang.String r3 = "ErrorCheckingGooglePlay"
            r1.trackUnExpectedScenario(r3, r2)
        L_0x00ac:
            boolean r1 = kotlin.Result.m6335isFailureimpl(r0)
            r2 = 0
            if (r1 == 0) goto L_0x00b4
            r0 = r2
        L_0x00b4:
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x00ba
            r4 = r12
            goto L_0x00bb
        L_0x00ba:
            r4 = r0
        L_0x00bb:
            com.talabat.core.safety.data.DefaultSafetyAgent r0 = r7.f55961i
            java.lang.String r3 = r7.f55962j
            com.talabat.core.safety.domain.SafetyEventType r5 = r7.f55963k
            com.talabat.core.safety.domain.entities.SafetyAppData r6 = r7.f55964l
            com.talabat.core.safety.data.repository.shield.ShieldRepository r1 = r0.shieldRepository     // Catch:{ all -> 0x001b }
            r7.L$0 = r2     // Catch:{ all -> 0x001b }
            r7.f55960h = r13     // Catch:{ all -> 0x001b }
            r2 = r3
            r3 = r5
            r5 = r6
            r6 = r15
            java.lang.Object r0 = r1.sendSafetyResult(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x001b }
            if (r0 != r8) goto L_0x00d6
            return r8
        L_0x00d6:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x001b }
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x001b }
            goto L_0x00e7
        L_0x00dd:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x00e7:
            com.talabat.core.safety.data.DefaultSafetyAgent r1 = r7.f55961i
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r0)
            if (r0 == 0) goto L_0x011a
            com.talabat.core.observabilityNew.domain.IObservabilityManager r1 = r1.observabilityManager
            kotlin.Pair[] r2 = new kotlin.Pair[r13]
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getName()
            kotlin.Pair r3 = kotlin.TuplesKt.to(r10, r3)
            r2[r11] = r3
            java.lang.String r0 = r0.getMessage()
            if (r0 != 0) goto L_0x010a
            goto L_0x010b
        L_0x010a:
            r12 = r0
        L_0x010b:
            kotlin.Pair r0 = kotlin.TuplesKt.to(r9, r12)
            r2[r14] = r0
            java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.mutableMapOf(r2)
            java.lang.String r2 = "ErrorSendingShieldInfo"
            r1.trackUnExpectedScenario(r2, r0)
        L_0x011a:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.safety.data.DefaultSafetyAgent$sendSafetyInformation$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
