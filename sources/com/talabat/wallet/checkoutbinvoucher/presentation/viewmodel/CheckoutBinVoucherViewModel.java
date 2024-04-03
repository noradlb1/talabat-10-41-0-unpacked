package com.talabat.wallet.checkoutbinvoucher.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import buisnessmodels.Cart;
import com.talabat.wallet.checkoutbinvoucher.domain.business.usecase.GetOrderVoucherUseCase;
import com.talabat.wallet.checkoutbinvoucher.domain.entity.BinVoucherCheckEligibilityModel;
import com.talabat.wallet.checkoutbinvoucher.presentation.displaymodel.CheckoutBinVoucherState;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J2\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/talabat/wallet/checkoutbinvoucher/presentation/viewmodel/CheckoutBinVoucherViewModel;", "Landroidx/lifecycle/ViewModel;", "getOrderVoucherUseCase", "Lcom/talabat/wallet/checkoutbinvoucher/domain/business/usecase/GetOrderVoucherUseCase;", "(Lcom/talabat/wallet/checkoutbinvoucher/domain/business/usecase/GetOrderVoucherUseCase;)V", "checkoutBinVoucherData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/wallet/checkoutbinvoucher/presentation/displaymodel/CheckoutBinVoucherState;", "getCheckoutBinVoucherData", "()Landroidx/lifecycle/MutableLiveData;", "isBinVoucherRequestFromBNPL", "", "()Z", "setBinVoucherRequestFromBNPL", "(Z)V", "onGetBinVoucher", "", "binVoucherCheckEligibilityModel", "Lcom/talabat/wallet/checkoutbinvoucher/domain/entity/BinVoucherCheckEligibilityModel;", "mobileNumber", "", "selectedAreaId", "", "binNumber", "cart", "Lbuisnessmodels/Cart;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutBinVoucherViewModel extends ViewModel {
    @NotNull
    private final MutableLiveData<CheckoutBinVoucherState> checkoutBinVoucherData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final GetOrderVoucherUseCase getOrderVoucherUseCase;
    private boolean isBinVoucherRequestFromBNPL;

    public CheckoutBinVoucherViewModel(@NotNull GetOrderVoucherUseCase getOrderVoucherUseCase2) {
        Intrinsics.checkNotNullParameter(getOrderVoucherUseCase2, "getOrderVoucherUseCase");
        this.getOrderVoucherUseCase = getOrderVoucherUseCase2;
    }

    @NotNull
    public final MutableLiveData<CheckoutBinVoucherState> getCheckoutBinVoucherData() {
        return this.checkoutBinVoucherData;
    }

    public final boolean isBinVoucherRequestFromBNPL() {
        return this.isBinVoucherRequestFromBNPL;
    }

    public final void onGetBinVoucher(@NotNull BinVoucherCheckEligibilityModel binVoucherCheckEligibilityModel, @NotNull String str, int i11, @Nullable String str2, @Nullable Cart cart) {
        Intrinsics.checkNotNullParameter(binVoucherCheckEligibilityModel, "binVoucherCheckEligibilityModel");
        Intrinsics.checkNotNullParameter(str, "mobileNumber");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new CheckoutBinVoucherViewModel$onGetBinVoucher$1(str2, this, binVoucherCheckEligibilityModel, str, i11, cart, (Continuation<? super CheckoutBinVoucherViewModel$onGetBinVoucher$1>) null), 3, (Object) null);
    }

    public final void setBinVoucherRequestFromBNPL(boolean z11) {
        this.isBinVoucherRequestFromBNPL = z11;
    }
}
