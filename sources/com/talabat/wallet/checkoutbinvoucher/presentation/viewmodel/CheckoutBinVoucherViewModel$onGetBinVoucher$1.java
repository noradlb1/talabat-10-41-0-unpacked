package com.talabat.wallet.checkoutbinvoucher.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import buisnessmodels.Cart;
import com.talabat.wallet.checkoutbinvoucher.domain.business.usecase.GetOrderVoucherUseCase;
import com.talabat.wallet.checkoutbinvoucher.domain.entity.BinVoucherCheckEligibilityModel;
import com.talabat.wallet.checkoutbinvoucher.domain.entity.OrderBinNumberVoucherStatus;
import com.talabat.wallet.checkoutbinvoucher.presentation.displaymodel.CheckoutBinVoucherState;
import com.talabat.wallet.checkoutbinvoucher.presentation.viewmodel.mapper.CheckoutBinVoucherMapper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.wallet.checkoutbinvoucher.presentation.viewmodel.CheckoutBinVoucherViewModel$onGetBinVoucher$1", f = "CheckoutBinVoucherViewModel.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
public final class CheckoutBinVoucherViewModel$onGetBinVoucher$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f12527h;

    /* renamed from: i  reason: collision with root package name */
    public Object f12528i;

    /* renamed from: j  reason: collision with root package name */
    public Object f12529j;

    /* renamed from: k  reason: collision with root package name */
    public int f12530k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f12531l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ CheckoutBinVoucherViewModel f12532m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ BinVoucherCheckEligibilityModel f12533n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ String f12534o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f12535p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Cart f12536q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckoutBinVoucherViewModel$onGetBinVoucher$1(String str, CheckoutBinVoucherViewModel checkoutBinVoucherViewModel, BinVoucherCheckEligibilityModel binVoucherCheckEligibilityModel, String str2, int i11, Cart cart, Continuation<? super CheckoutBinVoucherViewModel$onGetBinVoucher$1> continuation) {
        super(2, continuation);
        this.f12531l = str;
        this.f12532m = checkoutBinVoucherViewModel;
        this.f12533n = binVoucherCheckEligibilityModel;
        this.f12534o = str2;
        this.f12535p = i11;
        this.f12536q = cart;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CheckoutBinVoucherViewModel$onGetBinVoucher$1(this.f12531l, this.f12532m, this.f12533n, this.f12534o, this.f12535p, this.f12536q, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CheckoutBinVoucherViewModel$onGetBinVoucher$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        CheckoutBinVoucherViewModel checkoutBinVoucherViewModel;
        CheckoutBinVoucherMapper checkoutBinVoucherMapper;
        MutableLiveData<CheckoutBinVoucherState> mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12530k;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.f12531l;
            if (str != null) {
                CheckoutBinVoucherViewModel checkoutBinVoucherViewModel2 = this.f12532m;
                BinVoucherCheckEligibilityModel binVoucherCheckEligibilityModel = this.f12533n;
                String str2 = this.f12534o;
                int i12 = this.f12535p;
                Cart cart = this.f12536q;
                MutableLiveData<CheckoutBinVoucherState> checkoutBinVoucherData = checkoutBinVoucherViewModel2.getCheckoutBinVoucherData();
                CheckoutBinVoucherMapper checkoutBinVoucherMapper2 = CheckoutBinVoucherMapper.INSTANCE;
                GetOrderVoucherUseCase access$getGetOrderVoucherUseCase$p = checkoutBinVoucherViewModel2.getOrderVoucherUseCase;
                this.f12527h = checkoutBinVoucherViewModel2;
                this.f12528i = checkoutBinVoucherMapper2;
                this.f12529j = checkoutBinVoucherData;
                this.f12530k = 1;
                Object invoke = access$getGetOrderVoucherUseCase$p.invoke(binVoucherCheckEligibilityModel, str2, i12, str, cart, this);
                if (invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = checkoutBinVoucherData;
                checkoutBinVoucherMapper = checkoutBinVoucherMapper2;
                Object obj2 = invoke;
                checkoutBinVoucherViewModel = checkoutBinVoucherViewModel2;
                obj = obj2;
            }
            return Unit.INSTANCE;
        } else if (i11 == 1) {
            mutableLiveData = (MutableLiveData) this.f12529j;
            checkoutBinVoucherMapper = (CheckoutBinVoucherMapper) this.f12528i;
            checkoutBinVoucherViewModel = (CheckoutBinVoucherViewModel) this.f12527h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableLiveData.postValue(checkoutBinVoucherMapper.mapToCheckoutBinVoucherState((OrderBinNumberVoucherStatus) obj));
        checkoutBinVoucherViewModel.setBinVoucherRequestFromBNPL(true);
        return Unit.INSTANCE;
    }
}
