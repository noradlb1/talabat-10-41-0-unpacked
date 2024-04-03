package com.talabat.feature.referafriend.presentation.viewmodel;

import com.talabat.growth.ui.vouchers.list.VouchersListFragment;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.RedeemVoucherCodeDomainModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.RedeemVoucherCodeDomainModelKt;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures;
import com.talabat.talabatcore.exception.Failure;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.referafriend.presentation.viewmodel.ReferAFriendViewModel$redeemPromoCode$1", f = "ReferAFriendViewModel.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
public final class ReferAFriendViewModel$redeemPromoCode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f58736h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ReferAFriendViewModel f58737i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f58738j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f58739k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReferAFriendViewModel$redeemPromoCode$1(ReferAFriendViewModel referAFriendViewModel, String str, MethodChannel.Result result, Continuation<? super ReferAFriendViewModel$redeemPromoCode$1> continuation) {
        super(2, continuation);
        this.f58737i = referAFriendViewModel;
        this.f58738j = str;
        this.f58739k = result;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ReferAFriendViewModel$redeemPromoCode$1 referAFriendViewModel$redeemPromoCode$1 = new ReferAFriendViewModel$redeemPromoCode$1(this.f58737i, this.f58738j, this.f58739k, continuation);
        referAFriendViewModel$redeemPromoCode$1.L$0 = obj;
        return referAFriendViewModel$redeemPromoCode$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ReferAFriendViewModel$redeemPromoCode$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        String str;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f58736h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ReferAFriendViewModel referAFriendViewModel = this.f58737i;
            String str2 = this.f58738j;
            Result.Companion companion = Result.Companion;
            RedeemVoucherCodeUseCase redeemVoucherCodeUseCase = referAFriendViewModel.getRedeemVoucherCodeUseCase();
            int countryId = referAFriendViewModel.getConfigurationLocalRepository().selectedCountry().getCountryId();
            this.f58736h = 1;
            obj = RedeemVoucherCodeUseCase.invoke$default(redeemVoucherCodeUseCase, str2, (String) null, countryId, (Integer) null, ScreenNames.VOUCHER_WALLET_SCREEN, VouchersListFragment.VOUCHER_LIST, this, 10, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m6329constructorimpl((RedeemVoucherCodeDomainModel) obj);
        MethodChannel.Result result = this.f58739k;
        ReferAFriendViewModel referAFriendViewModel2 = this.f58737i;
        if (Result.m6336isSuccessimpl(obj2)) {
            result.success(RedeemVoucherCodeDomainModelKt.toMap((RedeemVoucherCodeDomainModel) obj2));
            referAFriendViewModel2.getSuccessRedeemPromo().postValue(Boxing.boxBoolean(true));
        }
        MethodChannel.Result result2 = this.f58739k;
        Throwable r14 = Result.m6332exceptionOrNullimpl(obj2);
        if (r14 != null) {
            if (r14 instanceof VoucherFailures) {
                VoucherFailures voucherFailures = (VoucherFailures) r14;
                Failure dataFailure = voucherFailures.getDataFailure();
                String str3 = null;
                if (dataFailure != null) {
                    str = dataFailure.getMessage();
                } else {
                    str = null;
                }
                Failure dataFailure2 = voucherFailures.getDataFailure();
                if (dataFailure2 != null) {
                    str3 = dataFailure2.getMessage();
                }
                result2.error(ReferAFriendViewModelKt.REFER_A_FRIEND_ERROR_CODE, str, str3);
            } else {
                result2.error(ReferAFriendViewModelKt.REFER_A_FRIEND_ERROR_CODE, r14.getMessage(), r14.getLocalizedMessage());
            }
        }
        return Unit.INSTANCE;
    }
}
