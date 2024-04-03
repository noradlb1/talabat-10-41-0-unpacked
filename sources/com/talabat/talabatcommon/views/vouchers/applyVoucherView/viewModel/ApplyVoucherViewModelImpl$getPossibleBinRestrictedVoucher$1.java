package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import buisnessmodels.Cart;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.BinRestrictedVoucherModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.BinRestrictionModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVouchersViewStates;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1", f = "ApplyVoucherViewModelImpl.kt", i = {}, l = {283}, m = "invokeSuspend", n = {}, s = {})
public final class ApplyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f11810h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ApplyVoucherViewModelImpl f11811i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f11812j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f11813k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f11814l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1(ApplyVoucherViewModelImpl applyVoucherViewModelImpl, String str, String str2, int i11, Continuation<? super ApplyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1> continuation) {
        super(2, continuation);
        this.f11811i = applyVoucherViewModelImpl;
        this.f11812j = str;
        this.f11813k = str2;
        this.f11814l = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ApplyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1 applyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1 = new ApplyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1(this.f11811i, this.f11812j, this.f11813k, this.f11814l, continuation);
        applyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1.L$0 = obj;
        return applyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ApplyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f11810h;
        boolean z11 = true;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ApplyVoucherViewModelImpl applyVoucherViewModelImpl = this.f11811i;
            String str = this.f11812j;
            String str2 = this.f11813k;
            int i12 = this.f11814l;
            Result.Companion companion = Result.Companion;
            CoroutineDispatcher access$getIoDispatcher$p = applyVoucherViewModelImpl.ioDispatcher;
            ApplyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1$1$1 applyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1$1$1 = new ApplyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1$1$1(applyVoucherViewModelImpl, str, str2, i12, (Continuation<? super ApplyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1$1$1>) null);
            this.f11810h = 1;
            obj = BuildersKt.withContext(access$getIoDispatcher$p, applyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1$1$1, this);
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
        obj2 = Result.m6329constructorimpl((BinRestrictedVoucherModel) obj);
        if (Result.m6336isSuccessimpl(obj2)) {
            BinRestrictedVoucherModel binRestrictedVoucherModel = (BinRestrictedVoucherModel) obj2;
            Cart instance = Cart.getInstance();
            BinRestrictionModel binRestriction = binRestrictedVoucherModel.getBinRestriction();
            if (binRestriction == null || !binRestriction.isRestricted()) {
                z11 = false;
            }
            if (z11) {
                instance.setEligibleBins(binRestrictedVoucherModel.getBinRestriction().getEligibleBins());
            } else {
                instance.setEligibleBins(CollectionsKt__CollectionsKt.emptyList());
            }
        }
        ApplyVoucherViewModelImpl applyVoucherViewModelImpl2 = this.f11811i;
        Throwable r102 = Result.m6332exceptionOrNullimpl(obj2);
        if (r102 != null) {
            applyVoucherViewModelImpl2.updateViewState(new ApplyVouchersViewStates.ApplyVouchersFailure((VoucherFailures) r102));
        }
        return Unit.INSTANCE;
    }
}
