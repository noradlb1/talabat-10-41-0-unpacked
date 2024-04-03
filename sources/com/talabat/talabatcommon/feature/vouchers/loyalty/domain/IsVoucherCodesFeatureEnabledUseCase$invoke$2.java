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
@DebugMetadata(c = "com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsVoucherCodesFeatureEnabledUseCase$invoke$2", f = "IsVoucherCodesFeatureEnabledUseCase.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
public final class IsVoucherCodesFeatureEnabledUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61625h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ IsVoucherCodesFeatureEnabledUseCase f61626i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IsVoucherCodesFeatureEnabledUseCase$invoke$2(IsVoucherCodesFeatureEnabledUseCase isVoucherCodesFeatureEnabledUseCase, Continuation<? super IsVoucherCodesFeatureEnabledUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f61626i = isVoucherCodesFeatureEnabledUseCase;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new IsVoucherCodesFeatureEnabledUseCase$invoke$2(this.f61626i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((IsVoucherCodesFeatureEnabledUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        if (((java.lang.Boolean) r6).booleanValue() != false) goto L_0x0057;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.f61625h
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0018
            if (r1 != r2) goto L_0x0010
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004d
        L_0x0010:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0018:
            kotlin.ResultKt.throwOnFailure(r6)
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsVoucherCodesFeatureEnabledUseCase r6 = r5.f61626i
            library.talabat.mvp.login.domain.repository.CustomerRepository r6 = r6.customerRepository
            java.lang.String r6 = r6.getMobileNumber(r3)
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x002d
            r6 = r2
            goto L_0x002e
        L_0x002d:
            r6 = r3
        L_0x002e:
            if (r6 == 0) goto L_0x0056
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsVoucherCodesFeatureEnabledUseCase r6 = r5.f61626i
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r6 = r6.iTalabatFeatureFlag
            kotlin.jvm.functions.Function1<java.lang.Integer, com.talabat.core.fwfprojectskeys.domain.FWFKey> r1 = com.talabat.core.featureflag.domain.flags.flagskeys.GrowthFeatureFlagConstantKt.FunWithFlagEnableVoucherCodesKey
            int r4 = com.talabat.helpers.GlobalDataModel.SelectedCountryId
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.lang.Object r1 = r1.invoke(r4)
            com.talabat.core.fwfprojectskeys.domain.FWFKey r1 = (com.talabat.core.fwfprojectskeys.domain.FWFKey) r1
            r5.f61625h = r2
            java.lang.Object r6 = r6.getFeatureFlag((com.talabat.core.fwfprojectskeys.domain.FWFKey) r1, (boolean) r3, (boolean) r3, (kotlin.coroutines.Continuation<? super java.lang.Boolean>) r5)
            if (r6 != r0) goto L_0x004d
            return r0
        L_0x004d:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r2 = r3
        L_0x0057:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsVoucherCodesFeatureEnabledUseCase$invoke$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
