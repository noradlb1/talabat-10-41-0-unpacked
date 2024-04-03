package com.talabat.wallet.ui.qrCodeScanner.viewModel;

import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.features.qrCodeScanner.GetValidateQRCodeUseCase;
import com.talabat.wallet.features.qrCodeScanner.GetWalletPaymentUseCase;
import com.talabat.wallet.features.qrCodeScanner.model.request.ValidateQRCodeRequestModel;
import com.talabat.wallet.features.qrCodeScanner.model.request.WalletPaymentRequestModel;
import com.talabat.wallet.ui.qrCodeScanner.model.ValidateQRCodeDisplayModel;
import com.talabat.wallet.ui.qrCodeScanner.model.WalletPaymentDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J`\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/talabat/wallet/ui/qrCodeScanner/viewModel/QRCodeScannerViewModelImpl;", "Lcom/talabat/wallet/ui/qrCodeScanner/viewModel/QRCodeScannerViewModel;", "getValidateQRCodeUseCase", "Lcom/talabat/wallet/features/qrCodeScanner/GetValidateQRCodeUseCase;", "getWalletPaymentUseCase", "Lcom/talabat/wallet/features/qrCodeScanner/GetWalletPaymentUseCase;", "(Lcom/talabat/wallet/features/qrCodeScanner/GetValidateQRCodeUseCase;Lcom/talabat/wallet/features/qrCodeScanner/GetWalletPaymentUseCase;)V", "getQRCodeData", "", "country", "", "qrCodeString", "", "getWalletPaymentData", "amount", "", "cardTokenId", "card4Digits", "cardType", "vendorId", "orderId", "paymentMethod", "requestSource", "merchantTransactionId", "qrCodeVerificationString", "handleQRCodeValidationServiceSuccess", "validateQrCodeDisplayModel", "Lcom/talabat/wallet/ui/qrCodeScanner/model/ValidateQRCodeDisplayModel;", "handleWalletPaymentServiceSuccess", "walletPaymentDisplayModel", "Lcom/talabat/wallet/ui/qrCodeScanner/model/WalletPaymentDisplayModel;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QRCodeScannerViewModelImpl extends QRCodeScannerViewModel {
    @NotNull
    private final GetValidateQRCodeUseCase getValidateQRCodeUseCase;
    @NotNull
    private final GetWalletPaymentUseCase getWalletPaymentUseCase;

    public QRCodeScannerViewModelImpl(@NotNull GetValidateQRCodeUseCase getValidateQRCodeUseCase2, @NotNull GetWalletPaymentUseCase getWalletPaymentUseCase2) {
        Intrinsics.checkNotNullParameter(getValidateQRCodeUseCase2, "getValidateQRCodeUseCase");
        Intrinsics.checkNotNullParameter(getWalletPaymentUseCase2, "getWalletPaymentUseCase");
        this.getValidateQRCodeUseCase = getValidateQRCodeUseCase2;
        this.getWalletPaymentUseCase = getWalletPaymentUseCase2;
    }

    /* access modifiers changed from: private */
    public final void handleQRCodeValidationServiceSuccess(ValidateQRCodeDisplayModel validateQRCodeDisplayModel) {
        getValidateQRCodeData().setValue(validateQRCodeDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void handleWalletPaymentServiceSuccess(WalletPaymentDisplayModel walletPaymentDisplayModel) {
        getWalletPaymentData().setValue(walletPaymentDisplayModel);
    }

    public void getQRCodeData(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "qrCodeString");
        this.getValidateQRCodeUseCase.invoke(new ValidateQRCodeRequestModel(str, Integer.valueOf(i11)), new QRCodeScannerViewModelImpl$getQRCodeData$1(this));
    }

    public void getWalletPaymentData(float f11, int i11, @NotNull String str, @NotNull String str2, @NotNull String str3, int i12, int i13, int i14, int i15, @NotNull String str4, @NotNull String str5) {
        String str6 = str;
        Intrinsics.checkNotNullParameter(str6, "cardTokenId");
        String str7 = str2;
        Intrinsics.checkNotNullParameter(str7, WalletNavigatorActions.EXTRA_CARD_4_DIGITS);
        String str8 = str3;
        Intrinsics.checkNotNullParameter(str8, "cardType");
        String str9 = str4;
        Intrinsics.checkNotNullParameter(str9, "merchantTransactionId");
        String str10 = str5;
        Intrinsics.checkNotNullParameter(str10, "qrCodeVerificationString");
        this.getWalletPaymentUseCase.invoke(new WalletPaymentRequestModel(Float.valueOf(f11), Integer.valueOf(i11), str6, str7, str8, Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), str9, str10), new QRCodeScannerViewModelImpl$getWalletPaymentData$1(this));
    }
}
