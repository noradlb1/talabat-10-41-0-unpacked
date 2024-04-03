package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import com.talabat.talabatcommon.views.vouchers.applyVoucherView.ApplyVoucherOwner;
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
@DebugMetadata(c = "com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsTmartVouchersFeatureEnabledUseCase$invoke$2", f = "IsTmartVouchersFeatureEnabledUseCase.kt", i = {}, l = {21}, m = "invokeSuspend", n = {}, s = {})
public final class IsTmartVouchersFeatureEnabledUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61622h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ IsTmartVouchersFeatureEnabledUseCase f61623i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ApplyVoucherOwner f61624j;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ApplyVoucherOwner.values().length];
            iArr[ApplyVoucherOwner.Checkout.ordinal()] = 1;
            iArr[ApplyVoucherOwner.Basket.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IsTmartVouchersFeatureEnabledUseCase$invoke$2(IsTmartVouchersFeatureEnabledUseCase isTmartVouchersFeatureEnabledUseCase, ApplyVoucherOwner applyVoucherOwner, Continuation<? super IsTmartVouchersFeatureEnabledUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f61623i = isTmartVouchersFeatureEnabledUseCase;
        this.f61624j = applyVoucherOwner;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new IsTmartVouchersFeatureEnabledUseCase$invoke$2(this.f61623i, this.f61624j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((IsTmartVouchersFeatureEnabledUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0085 A[ADDED_TO_REGION] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.f61622h
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0018
            if (r1 != r3) goto L_0x0010
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0038
        L_0x0010:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0018:
            kotlin.ResultKt.throwOnFailure(r6)
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsTmartVouchersFeatureEnabledUseCase r6 = r5.f61623i
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r6 = r6.iTalabatFeatureFlag
            kotlin.jvm.functions.Function1<java.lang.Integer, com.talabat.core.fwfprojectskeys.domain.FWFKey> r1 = com.talabat.core.featureflag.domain.flags.flagskeys.GrowthFeatureFlagConstantKt.FunWithFlagEnableTmartVouchersKey
            int r4 = com.talabat.helpers.GlobalDataModel.SelectedCountryId
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.lang.Object r1 = r1.invoke(r4)
            com.talabat.core.fwfprojectskeys.domain.FWFKey r1 = (com.talabat.core.fwfprojectskeys.domain.FWFKey) r1
            r5.f61622h = r3
            java.lang.Object r6 = r6.getFeatureFlag((com.talabat.core.fwfprojectskeys.domain.FWFKey) r1, (boolean) r2, (boolean) r2, (kotlin.coroutines.Continuation<? super java.lang.Boolean>) r5)
            if (r6 != r0) goto L_0x0038
            return r0
        L_0x0038:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsTmartVouchersFeatureEnabledUseCase r0 = r5.f61623i
            boolean r0 = r0.isDarkStore()
            if (r0 == 0) goto L_0x006b
            if (r6 == 0) goto L_0x006b
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsTmartVouchersFeatureEnabledUseCase r6 = r5.f61623i
            library.talabat.mvp.login.domain.repository.CustomerRepository r6 = r6.customerRepository
            boolean r6 = r6.isLoggedIn()
            if (r6 == 0) goto L_0x006b
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsTmartVouchersFeatureEnabledUseCase r6 = r5.f61623i
            library.talabat.mvp.login.domain.repository.CustomerRepository r6 = r6.customerRepository
            java.lang.String r6 = r6.getMobileNumber(r2)
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x0066
            r6 = r3
            goto L_0x0067
        L_0x0066:
            r6 = r2
        L_0x0067:
            if (r6 == 0) goto L_0x006b
            r6 = r3
            goto L_0x006c
        L_0x006b:
            r6 = r2
        L_0x006c:
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.ApplyVoucherOwner r0 = r5.f61624j
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsTmartVouchersFeatureEnabledUseCase r1 = r5.f61623i
            int[] r4 = com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsTmartVouchersFeatureEnabledUseCase$invoke$2.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r4[r0]
            if (r0 == r3) goto L_0x0085
            r1 = 2
            if (r0 != r1) goto L_0x007f
            r2 = r6
            goto L_0x0098
        L_0x007f:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L_0x0085:
            if (r6 == 0) goto L_0x0098
            kotlin.jvm.functions.Function0 r6 = r1.fwdDarkStoresVouchersCheckoutEnabled
            java.lang.Object r6 = r6.invoke()
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0098
            r2 = r3
        L_0x0098:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsTmartVouchersFeatureEnabledUseCase$invoke$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
