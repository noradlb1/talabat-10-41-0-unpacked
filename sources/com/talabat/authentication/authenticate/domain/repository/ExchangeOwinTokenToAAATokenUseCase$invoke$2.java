package com.talabat.authentication.authenticate.domain.repository;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase$invoke$2", f = "ExchangeOwinTokenToAAATokenUseCase.kt", i = {}, l = {47, 48, 49}, m = "invokeSuspend", n = {}, s = {})
public final class ExchangeOwinTokenToAAATokenUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f55434h;

    /* renamed from: i  reason: collision with root package name */
    public int f55435i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ExchangeOwinTokenToAAATokenUseCase f55436j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f55437k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ JwtExchangeCallback f55438l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExchangeOwinTokenToAAATokenUseCase$invoke$2(ExchangeOwinTokenToAAATokenUseCase exchangeOwinTokenToAAATokenUseCase, String str, JwtExchangeCallback jwtExchangeCallback, Continuation<? super ExchangeOwinTokenToAAATokenUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f55436j = exchangeOwinTokenToAAATokenUseCase;
        this.f55437k = str;
        this.f55438l = jwtExchangeCallback;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ExchangeOwinTokenToAAATokenUseCase$invoke$2(this.f55436j, this.f55437k, this.f55438l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((ExchangeOwinTokenToAAATokenUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007d  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.f55435i
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0029
            if (r1 == r5) goto L_0x0025
            if (r1 == r4) goto L_0x001f
            if (r1 != r3) goto L_0x0017
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0095
        L_0x0017:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001f:
            java.lang.Object r1 = r8.f55434h
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0073
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0042 }
            goto L_0x003b
        L_0x0029:
            kotlin.ResultKt.throwOnFailure(r9)
            com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase r9 = r8.f55436j
            java.lang.String r1 = r8.f55437k
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x0042 }
            r8.f55435i = r5     // Catch:{ all -> 0x0042 }
            java.lang.Object r9 = r9.exchange(r1, r8)     // Catch:{ all -> 0x0042 }
            if (r9 != r0) goto L_0x003b
            return r0
        L_0x003b:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0042 }
            java.lang.Object r9 = kotlin.Result.m6329constructorimpl(r9)     // Catch:{ all -> 0x0042 }
            goto L_0x004d
        L_0x0042:
            r9 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m6329constructorimpl(r9)
        L_0x004d:
            r1 = r9
            com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase r9 = r8.f55436j
            com.talabat.authentication.authenticate.domain.repository.JwtExchangeCallback r6 = r8.f55438l
            boolean r7 = kotlin.Result.m6336isSuccessimpl(r1)
            if (r7 == 0) goto L_0x0073
            r7 = r1
            kotlin.Unit r7 = (kotlin.Unit) r7
            com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory r9 = r9.dispatchersFactory
            kotlinx.coroutines.CoroutineDispatcher r9 = r9.main()
            com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase$invoke$2$2$1 r7 = new com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase$invoke$2$2$1
            r7.<init>(r6, r2)
            r8.f55434h = r1
            r8.f55435i = r4
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r9, r7, r8)
            if (r9 != r0) goto L_0x0073
            return r0
        L_0x0073:
            com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase r9 = r8.f55436j
            com.talabat.authentication.authenticate.domain.repository.JwtExchangeCallback r4 = r8.f55438l
            java.lang.Throwable r6 = kotlin.Result.m6332exceptionOrNullimpl(r1)
            if (r6 == 0) goto L_0x0095
            com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory r9 = r9.dispatchersFactory
            kotlinx.coroutines.CoroutineDispatcher r9 = r9.main()
            com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase$invoke$2$3$1 r6 = new com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase$invoke$2$3$1
            r6.<init>(r4, r2)
            r8.f55434h = r1
            r8.f55435i = r3
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r9, r6, r8)
            if (r9 != r0) goto L_0x0095
            return r0
        L_0x0095:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase$invoke$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
