package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

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
@DebugMetadata(c = "com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsBasketVouchersFeatureEnabledUseCase$invoke$2", f = "IsBasketVouchersFeatureEnabledUseCase.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {})
public final class IsBasketVouchersFeatureEnabledUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61620h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ IsBasketVouchersFeatureEnabledUseCase f61621i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IsBasketVouchersFeatureEnabledUseCase$invoke$2(IsBasketVouchersFeatureEnabledUseCase isBasketVouchersFeatureEnabledUseCase, Continuation<? super IsBasketVouchersFeatureEnabledUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f61621i = isBasketVouchersFeatureEnabledUseCase;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new IsBasketVouchersFeatureEnabledUseCase$invoke$2(this.f61621i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((IsBasketVouchersFeatureEnabledUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006d, code lost:
        if (r6 != false) goto L_0x0071;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.f61620h
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0018
            if (r1 != r2) goto L_0x0010
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0038
        L_0x0010:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0018:
            kotlin.ResultKt.throwOnFailure(r6)
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsBasketVouchersFeatureEnabledUseCase r6 = r5.f61621i
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r6 = r6.iTalabatFeatureFlag
            kotlin.jvm.functions.Function1<java.lang.Integer, com.talabat.core.fwfprojectskeys.domain.FWFKey> r1 = com.talabat.core.featureflag.domain.flags.flagskeys.GrowthFeatureFlagConstantKt.FunWithFlagEnableBasketVouchersKey
            int r4 = com.talabat.helpers.GlobalDataModel.SelectedCountryId
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.lang.Object r1 = r1.invoke(r4)
            com.talabat.core.fwfprojectskeys.domain.FWFKey r1 = (com.talabat.core.fwfprojectskeys.domain.FWFKey) r1
            r5.f61620h = r2
            java.lang.Object r6 = r6.getFeatureFlag((com.talabat.core.fwfprojectskeys.domain.FWFKey) r1, (boolean) r3, (boolean) r3, (kotlin.coroutines.Continuation<? super java.lang.Boolean>) r5)
            if (r6 != r0) goto L_0x0038
            return r0
        L_0x0038:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsBasketVouchersFeatureEnabledUseCase r0 = r5.f61621i
            boolean r0 = r0.isDarkStore()
            if (r0 != 0) goto L_0x0070
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsBasketVouchersFeatureEnabledUseCase r0 = r5.f61621i
            library.talabat.mvp.login.domain.repository.CustomerRepository r0 = r0.customerRepository
            boolean r0 = r0.isLoggedIn()
            if (r0 == 0) goto L_0x0070
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsBasketVouchersFeatureEnabledUseCase r0 = r5.f61621i
            library.talabat.mvp.login.domain.repository.CustomerRepository r0 = r0.customerRepository
            java.lang.String r0 = r0.getMobileNumber(r3)
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0064
            r0 = r2
            goto L_0x0065
        L_0x0064:
            r0 = r3
        L_0x0065:
            if (r0 == 0) goto L_0x0070
            boolean r0 = com.talabat.lib.Integration.isGemActive()
            if (r0 != 0) goto L_0x0070
            if (r6 == 0) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r2 = r3
        L_0x0071:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsBasketVouchersFeatureEnabledUseCase$invoke$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
