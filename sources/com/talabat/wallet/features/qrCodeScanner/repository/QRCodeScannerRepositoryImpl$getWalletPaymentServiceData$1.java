package com.talabat.wallet.features.qrCodeScanner.repository;

import com.talabat.wallet.features.qrCodeScanner.model.response.WalletPaymentResponse;
import com.talabat.wallet.ui.qrCodeScanner.model.QRCodeScannerMapper;
import com.talabat.wallet.ui.qrCodeScanner.model.WalletPaymentDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/wallet/ui/qrCodeScanner/model/WalletPaymentDisplayModel;", "it", "Lcom/talabat/wallet/features/qrCodeScanner/model/response/WalletPaymentResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class QRCodeScannerRepositoryImpl$getWalletPaymentServiceData$1 extends Lambda implements Function1<WalletPaymentResponse, WalletPaymentDisplayModel> {
    public static final QRCodeScannerRepositoryImpl$getWalletPaymentServiceData$1 INSTANCE = new QRCodeScannerRepositoryImpl$getWalletPaymentServiceData$1();

    public QRCodeScannerRepositoryImpl$getWalletPaymentServiceData$1() {
        super(1);
    }

    @NotNull
    public final WalletPaymentDisplayModel invoke(@NotNull WalletPaymentResponse walletPaymentResponse) {
        Intrinsics.checkNotNullParameter(walletPaymentResponse, "it");
        return QRCodeScannerMapper.Companion.mapWalletPaymentResponse(walletPaymentResponse);
    }
}
