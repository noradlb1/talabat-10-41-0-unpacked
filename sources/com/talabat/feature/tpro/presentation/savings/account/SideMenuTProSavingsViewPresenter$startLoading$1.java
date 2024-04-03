package com.talabat.feature.tpro.presentation.savings.account;

import com.talabat.configuration.location.LocationConfigurationRepository;
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
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter$startLoading$1", f = "SideMenuTProSavingsViewPresenter.kt", i = {}, l = {85, 86, 92, 94, 97}, m = "invokeSuspend", n = {}, s = {})
public final class SideMenuTProSavingsViewPresenter$startLoading$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59419h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SideMenuTProSavingsViewPresenter f59420i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LocationConfigurationRepository f59421j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideMenuTProSavingsViewPresenter$startLoading$1(SideMenuTProSavingsViewPresenter sideMenuTProSavingsViewPresenter, LocationConfigurationRepository locationConfigurationRepository, Continuation<? super SideMenuTProSavingsViewPresenter$startLoading$1> continuation) {
        super(2, continuation);
        this.f59420i = sideMenuTProSavingsViewPresenter;
        this.f59421j = locationConfigurationRepository;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SideMenuTProSavingsViewPresenter$startLoading$1 sideMenuTProSavingsViewPresenter$startLoading$1 = new SideMenuTProSavingsViewPresenter$startLoading$1(this.f59420i, this.f59421j, continuation);
        sideMenuTProSavingsViewPresenter$startLoading$1.L$0 = obj;
        return sideMenuTProSavingsViewPresenter$startLoading$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SideMenuTProSavingsViewPresenter$startLoading$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b0  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.f59419h
            r2 = 0
            r3 = 5
            r4 = 4
            r5 = 2
            r6 = 1
            r7 = 0
            r8 = 3
            if (r1 == 0) goto L_0x0039
            if (r1 == r6) goto L_0x0031
            if (r1 == r5) goto L_0x002d
            if (r1 == r8) goto L_0x0026
            if (r1 == r4) goto L_0x0026
            if (r1 != r3) goto L_0x001e
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00c0
        L_0x001e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0026:
            java.lang.Object r1 = r10.L$0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00a8
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x006e }
            goto L_0x0067
        L_0x0031:
            java.lang.Object r1 = r10.L$0
            com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter r1 = (com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter) r1
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x006e }
            goto L_0x004f
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter r1 = r10.f59420i
            kotlin.Result$Companion r11 = kotlin.Result.Companion     // Catch:{ all -> 0x006e }
            r10.L$0 = r1     // Catch:{ all -> 0x006e }
            r10.f59419h = r6     // Catch:{ all -> 0x006e }
            java.lang.Object r11 = r1.startShimmer(r10)     // Catch:{ all -> 0x006e }
            if (r11 != r0) goto L_0x004f
            return r0
        L_0x004f:
            com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase r11 = r1.getSavingsInfoUseCase     // Catch:{ all -> 0x006e }
            com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase$Params r6 = new com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase$Params     // Catch:{ all -> 0x006e }
            int r1 = r1.countryId     // Catch:{ all -> 0x006e }
            r6.<init>(r1)     // Catch:{ all -> 0x006e }
            r10.L$0 = r2     // Catch:{ all -> 0x006e }
            r10.f59419h = r5     // Catch:{ all -> 0x006e }
            java.lang.Object r11 = r11.invoke(r6, r10)     // Catch:{ all -> 0x006e }
            if (r11 != r0) goto L_0x0067
            return r0
        L_0x0067:
            com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo r11 = (com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo) r11     // Catch:{ all -> 0x006e }
            java.lang.Object r11 = kotlin.Result.m6329constructorimpl(r11)     // Catch:{ all -> 0x006e }
            goto L_0x0079
        L_0x006e:
            r11 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r11 = kotlin.ResultKt.createFailure(r11)
            java.lang.Object r11 = kotlin.Result.m6329constructorimpl(r11)
        L_0x0079:
            r1 = r11
            com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter r11 = r10.f59420i
            com.talabat.configuration.location.LocationConfigurationRepository r5 = r10.f59421j
            boolean r6 = kotlin.Result.m6336isSuccessimpl(r1)
            if (r6 == 0) goto L_0x00a8
            r6 = r1
            com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo r6 = (com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo) r6
            float r9 = r6.getOverallSavings()
            int r9 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x009d
            r11.cachedSavingsInfo = r6
            r10.L$0 = r1
            r10.f59419h = r8
            java.lang.Object r11 = r11.bindData(r6, r5, r10)
            if (r11 != r0) goto L_0x00a8
            return r0
        L_0x009d:
            r10.L$0 = r1
            r10.f59419h = r4
            java.lang.Object r11 = r11.hideSavingsView(r6, r10)
            if (r11 != r0) goto L_0x00a8
            return r0
        L_0x00a8:
            com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter r11 = r10.f59420i
            java.lang.Throwable r4 = kotlin.Result.m6332exceptionOrNullimpl(r1)
            if (r4 == 0) goto L_0x00c0
            com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo r4 = new com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo
            r4.<init>(r7, r7, r8, r2)
            r10.L$0 = r1
            r10.f59419h = r3
            java.lang.Object r11 = r11.hideSavingsView(r4, r10)
            if (r11 != r0) goto L_0x00c0
            return r0
        L_0x00c0:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter$startLoading$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
