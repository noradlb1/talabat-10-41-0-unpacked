package com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.GetWalletPaymentOptionViewConfigUseCase;
import com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.WalletPaymentWidgetDisplayModelParam;
import com.talabat.talabatcommon.model.wallet.WalletBalanceDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentWidgetDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "isWalletBalanceServiceCompleted", "", "isCardListServiceCompleted", "invoke", "(ZLjava/lang/Boolean;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentOptionViewModelImpl$walletPaymentMode$1 extends Lambda implements Function2<Boolean, Boolean, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WalletPaymentOptionViewModelImpl f11995g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f11996h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableLiveData<Boolean> f11997i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f11998j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f11999k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f12000l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletPaymentOptionViewModelImpl$walletPaymentMode$1(WalletPaymentOptionViewModelImpl walletPaymentOptionViewModelImpl, float f11, MutableLiveData<Boolean> mutableLiveData, boolean z11, boolean z12, float f12) {
        super(2);
        this.f11995g = walletPaymentOptionViewModelImpl;
        this.f11996h = f11;
        this.f11997i = mutableLiveData;
        this.f11998j = z11;
        this.f11999k = z12;
        this.f12000l = f12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Boolean) obj).booleanValue(), (Boolean) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11, @NotNull Boolean bool) {
        Intrinsics.checkNotNullParameter(bool, "isCardListServiceCompleted");
        if (z11 && bool.booleanValue()) {
            this.f11995g.updateWalletBalance(Float.valueOf(this.f11996h));
            WalletPaymentOptionViewModelImpl walletPaymentOptionViewModelImpl = this.f11995g;
            GetWalletPaymentOptionViewConfigUseCase access$getWalletPaymentOptionViewConfigUseCase$p = walletPaymentOptionViewModelImpl.walletPaymentOptionViewConfigUseCase;
            WalletPaymentWidgetDisplayModel walletWidgetDisplayViewModel = this.f11995g.getWalletWidgetDisplayViewModel();
            float walletBalance = this.f11995g.getWalletBalance();
            WalletBalanceDisplayModel value = this.f11995g.getWalletBalanceData().getValue();
            walletPaymentOptionViewModelImpl.setWalletWidgetDisplayViewModel(access$getWalletPaymentOptionViewConfigUseCase$p.invoke(new WalletPaymentWidgetDisplayModelParam(walletWidgetDisplayViewModel, walletBalance, this.f11998j, this.f11999k, this.f12000l, value != null ? Boolean.valueOf(value.isWalletBalanceLoaded()) : null, this.f11997i.getValue(), (Boolean) null)));
            this.f11995g.getWalletWidgetConfigData().setValue(this.f11995g.getWalletWidgetDisplayViewModel());
        }
    }
}
