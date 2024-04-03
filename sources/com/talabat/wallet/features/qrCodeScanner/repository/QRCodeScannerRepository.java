package com.talabat.wallet.features.qrCodeScanner.repository;

import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.wallet.features.qrCodeScanner.model.request.ValidateQRCodeRequestModel;
import com.talabat.wallet.features.qrCodeScanner.model.request.WalletPaymentRequestModel;
import com.talabat.wallet.ui.qrCodeScanner.model.ValidateQRCodeDisplayModel;
import com.talabat.wallet.ui.qrCodeScanner.model.WalletPaymentDisplayModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/wallet/features/qrCodeScanner/repository/QRCodeScannerRepository;", "", "getValidateQRCodeServiceData", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/wallet/ui/qrCodeScanner/model/ValidateQRCodeDisplayModel;", "validateQRCodeRequestModel", "Lcom/talabat/wallet/features/qrCodeScanner/model/request/ValidateQRCodeRequestModel;", "getWalletPaymentServiceData", "Lcom/talabat/wallet/ui/qrCodeScanner/model/WalletPaymentDisplayModel;", "walletPaymentRequestModel", "Lcom/talabat/wallet/features/qrCodeScanner/model/request/WalletPaymentRequestModel;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface QRCodeScannerRepository {
    @NotNull
    Either<Failure, ValidateQRCodeDisplayModel> getValidateQRCodeServiceData(@NotNull ValidateQRCodeRequestModel validateQRCodeRequestModel);

    @NotNull
    Either<Failure, WalletPaymentDisplayModel> getWalletPaymentServiceData(@NotNull WalletPaymentRequestModel walletPaymentRequestModel);
}
