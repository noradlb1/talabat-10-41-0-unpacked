package com.talabat.growth.ui.vouchers.list.viewModel;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.growth.ui.vouchers.list.VouchersListFragment;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.RedeemVoucherCodeDomainModel;
import com.talabat.talabatcore.exception.Failure;
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
@DebugMetadata(c = "com.talabat.growth.ui.vouchers.list.viewModel.VouchersListViewModelImpl$redeemVoucherCode$1", f = "VouchersListViewModelImpl.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
public final class VouchersListViewModelImpl$redeemVoucherCode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f60727h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ VouchersListViewModelImpl f60728i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f60729j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f60730k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VouchersListViewModelImpl$redeemVoucherCode$1(VouchersListViewModelImpl vouchersListViewModelImpl, String str, String str2, Continuation<? super VouchersListViewModelImpl$redeemVoucherCode$1> continuation) {
        super(2, continuation);
        this.f60728i = vouchersListViewModelImpl;
        this.f60729j = str;
        this.f60730k = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        VouchersListViewModelImpl$redeemVoucherCode$1 vouchersListViewModelImpl$redeemVoucherCode$1 = new VouchersListViewModelImpl$redeemVoucherCode$1(this.f60728i, this.f60729j, this.f60730k, continuation);
        vouchersListViewModelImpl$redeemVoucherCode$1.L$0 = obj;
        return vouchersListViewModelImpl$redeemVoucherCode$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VouchersListViewModelImpl$redeemVoucherCode$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f60727h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            VouchersListViewModelImpl vouchersListViewModelImpl = this.f60728i;
            String str = this.f60729j;
            String str2 = this.f60730k;
            Result.Companion companion = Result.Companion;
            RedeemVoucherCodeUseCase access$getRedeemVoucherCodeUseCase$p = vouchersListViewModelImpl.redeemVoucherCodeUseCase;
            int countryId = vouchersListViewModelImpl.configurationLocalRepository.selectedCountry().getCountryId();
            Integer boxInt = Boxing.boxInt(IntegrationGlobalDataModel.Companion.selectedAreaId());
            this.f60727h = 1;
            obj = access$getRedeemVoucherCodeUseCase$p.invoke(str, str2, countryId, boxInt, ScreenNames.VOUCHER_WALLET_SCREEN, VouchersListFragment.VOUCHER_LIST, this);
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
        VouchersListViewModelImpl vouchersListViewModelImpl2 = this.f60728i;
        if (Result.m6336isSuccessimpl(obj2)) {
            RedeemVoucherCodeDomainModel redeemVoucherCodeDomainModel = (RedeemVoucherCodeDomainModel) obj2;
            vouchersListViewModelImpl2.getSuccessRedeemVoucher().postValue(Boxing.boxBoolean(true));
        }
        VouchersListViewModelImpl vouchersListViewModelImpl3 = this.f60728i;
        Throwable r12 = Result.m6332exceptionOrNullimpl(obj2);
        if (r12 != null) {
            vouchersListViewModelImpl3.getFailureData().postValue((Failure) r12);
        }
        return Unit.INSTANCE;
    }
}
