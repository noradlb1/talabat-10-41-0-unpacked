package com.talabat.wallet.ui.qrCodeScanner.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import com.talabat.wallet.ui.qrCodeScanner.model.ValidateQRCodeDisplayModel;
import com.talabat.wallet.ui.qrCodeScanner.model.WalletPaymentDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J`\u0010\f\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0013H&R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/talabat/wallet/ui/qrCodeScanner/viewModel/QRCodeScannerViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "validateQRCodeData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/wallet/ui/qrCodeScanner/model/ValidateQRCodeDisplayModel;", "getValidateQRCodeData", "()Landroidx/lifecycle/MutableLiveData;", "setValidateQRCodeData", "(Landroidx/lifecycle/MutableLiveData;)V", "walletPaymentData", "Lcom/talabat/wallet/ui/qrCodeScanner/model/WalletPaymentDisplayModel;", "getWalletPaymentData", "setWalletPaymentData", "getQRCodeData", "", "country", "", "qrCodeString", "", "amount", "", "cardTokenId", "card4Digits", "cardType", "vendorId", "orderId", "paymentMethod", "requestSource", "merchantTransactionId", "qrCodeVerificationString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class QRCodeScannerViewModel extends BaseViewModel {
    @NotNull
    private MutableLiveData<ValidateQRCodeDisplayModel> validateQRCodeData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WalletPaymentDisplayModel> walletPaymentData = new MutableLiveData<>();

    public abstract void getQRCodeData(int i11, @NotNull String str);

    @NotNull
    public final MutableLiveData<ValidateQRCodeDisplayModel> getValidateQRCodeData() {
        return this.validateQRCodeData;
    }

    @NotNull
    public final MutableLiveData<WalletPaymentDisplayModel> getWalletPaymentData() {
        return this.walletPaymentData;
    }

    public abstract void getWalletPaymentData(float f11, int i11, @NotNull String str, @NotNull String str2, @NotNull String str3, int i12, int i13, int i14, int i15, @NotNull String str4, @NotNull String str5);

    public final void setValidateQRCodeData(@NotNull MutableLiveData<ValidateQRCodeDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.validateQRCodeData = mutableLiveData;
    }

    public final void setWalletPaymentData(@NotNull MutableLiveData<WalletPaymentDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.walletPaymentData = mutableLiveData;
    }
}
