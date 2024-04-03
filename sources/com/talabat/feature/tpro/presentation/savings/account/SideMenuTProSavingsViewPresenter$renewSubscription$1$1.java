package com.talabat.feature.tpro.presentation.savings.account;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase;
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
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter$renewSubscription$1$1", f = "SideMenuTProSavingsViewPresenter.kt", i = {}, l = {58, 61, 63}, m = "invokeSuspend", n = {}, s = {})
public final class SideMenuTProSavingsViewPresenter$renewSubscription$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59413h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SideMenuTProSavingsViewPresenter f59414i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ UpdateAutoRenewalUseCase.Params f59415j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ LocationConfigurationRepository f59416k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideMenuTProSavingsViewPresenter$renewSubscription$1$1(SideMenuTProSavingsViewPresenter sideMenuTProSavingsViewPresenter, UpdateAutoRenewalUseCase.Params params, LocationConfigurationRepository locationConfigurationRepository, Continuation<? super SideMenuTProSavingsViewPresenter$renewSubscription$1$1> continuation) {
        super(2, continuation);
        this.f59414i = sideMenuTProSavingsViewPresenter;
        this.f59415j = params;
        this.f59416k = locationConfigurationRepository;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SideMenuTProSavingsViewPresenter$renewSubscription$1$1 sideMenuTProSavingsViewPresenter$renewSubscription$1$1 = new SideMenuTProSavingsViewPresenter$renewSubscription$1$1(this.f59414i, this.f59415j, this.f59416k, continuation);
        sideMenuTProSavingsViewPresenter$renewSubscription$1$1.L$0 = obj;
        return sideMenuTProSavingsViewPresenter$renewSubscription$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SideMenuTProSavingsViewPresenter$renewSubscription$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0077  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.f59413h
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0027
            if (r1 == r4) goto L_0x0023
            if (r1 == r3) goto L_0x001d
            if (r1 != r2) goto L_0x0015
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0083
        L_0x0015:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001d:
            java.lang.Object r1 = r7.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006f
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0048 }
            goto L_0x0041
        L_0x0027:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
            com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter r8 = r7.f59414i
            com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase$Params r1 = r7.f59415j
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch:{ all -> 0x0048 }
            com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase r8 = r8.updateAutoRenewalUseCase     // Catch:{ all -> 0x0048 }
            r7.f59413h = r4     // Catch:{ all -> 0x0048 }
            java.lang.Object r8 = r8.invoke(r1, r7)     // Catch:{ all -> 0x0048 }
            if (r8 != r0) goto L_0x0041
            return r0
        L_0x0041:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0048 }
            java.lang.Object r8 = kotlin.Result.m6329constructorimpl(r8)     // Catch:{ all -> 0x0048 }
            goto L_0x0053
        L_0x0048:
            r8 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m6329constructorimpl(r8)
        L_0x0053:
            r1 = r8
            com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter r8 = r7.f59414i
            com.talabat.configuration.location.LocationConfigurationRepository r5 = r7.f59416k
            boolean r6 = kotlin.Result.m6336isSuccessimpl(r1)
            if (r6 == 0) goto L_0x006f
            r6 = r1
            kotlin.Unit r6 = (kotlin.Unit) r6
            r8.refresh(r5)
            r7.L$0 = r1
            r7.f59413h = r3
            java.lang.Object r8 = r8.onRenewalUpdate(r4, r7)
            if (r8 != r0) goto L_0x006f
            return r0
        L_0x006f:
            com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter r8 = r7.f59414i
            java.lang.Throwable r3 = kotlin.Result.m6332exceptionOrNullimpl(r1)
            if (r3 == 0) goto L_0x0083
            r7.L$0 = r1
            r7.f59413h = r2
            r1 = 0
            java.lang.Object r8 = r8.onRenewalUpdate(r1, r7)
            if (r8 != r0) goto L_0x0083
            return r0
        L_0x0083:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter$renewSubscription$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
