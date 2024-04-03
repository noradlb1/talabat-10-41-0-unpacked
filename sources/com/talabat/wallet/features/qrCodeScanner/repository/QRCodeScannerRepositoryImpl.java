package com.talabat.wallet.features.qrCodeScanner.repository;

import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.wallet.features.qrCodeScanner.model.request.ValidateQRCodeRequestModel;
import com.talabat.wallet.features.qrCodeScanner.model.request.WalletPaymentRequestModel;
import com.talabat.wallet.features.qrCodeScanner.model.response.ValidateQRCodeResponse;
import com.talabat.wallet.features.qrCodeScanner.model.response.ValidateQRCodeResponseResult;
import com.talabat.wallet.features.qrCodeScanner.model.response.WalletPaymentResponse;
import com.talabat.wallet.features.qrCodeScanner.model.response.WalletPaymentResponseResult;
import com.talabat.wallet.features.qrCodeScanner.network.QRCodeScannerService;
import com.talabat.wallet.features.qrCodeScanner.network.ValidateQRService;
import com.talabat.wallet.ui.qrCodeScanner.model.ValidateQRCodeDisplayModel;
import com.talabat.wallet.ui.qrCodeScanner.model.WalletPaymentDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00100\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/wallet/features/qrCodeScanner/repository/QRCodeScannerRepositoryImpl;", "Lcom/talabat/wallet/features/qrCodeScanner/repository/QRCodeScannerRepository;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "qrCodeScannerService", "Lcom/talabat/wallet/features/qrCodeScanner/network/QRCodeScannerService;", "validateQRService", "Lcom/talabat/wallet/features/qrCodeScanner/network/ValidateQRService;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/wallet/features/qrCodeScanner/network/QRCodeScannerService;Lcom/talabat/wallet/features/qrCodeScanner/network/ValidateQRService;)V", "getValidateQRCodeServiceData", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/wallet/ui/qrCodeScanner/model/ValidateQRCodeDisplayModel;", "validateQRCodeRequestModel", "Lcom/talabat/wallet/features/qrCodeScanner/model/request/ValidateQRCodeRequestModel;", "getWalletPaymentServiceData", "Lcom/talabat/wallet/ui/qrCodeScanner/model/WalletPaymentDisplayModel;", "walletPaymentRequestModel", "Lcom/talabat/wallet/features/qrCodeScanner/model/request/WalletPaymentRequestModel;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QRCodeScannerRepositoryImpl implements QRCodeScannerRepository {
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull
    private final QRCodeScannerService qrCodeScannerService;
    @NotNull
    private final ValidateQRService validateQRService;

    public QRCodeScannerRepositoryImpl(@NotNull NetworkHandler networkHandler2, @NotNull QRCodeScannerService qRCodeScannerService, @NotNull ValidateQRService validateQRService2) {
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(qRCodeScannerService, "qrCodeScannerService");
        Intrinsics.checkNotNullParameter(validateQRService2, "validateQRService");
        this.networkHandler = networkHandler2;
        this.qrCodeScannerService = qRCodeScannerService;
        this.validateQRService = validateQRService2;
    }

    @NotNull
    public Either<Failure, ValidateQRCodeDisplayModel> getValidateQRCodeServiceData(@NotNull ValidateQRCodeRequestModel validateQRCodeRequestModel) {
        Intrinsics.checkNotNullParameter(validateQRCodeRequestModel, "validateQRCodeRequestModel");
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(this.validateQRService.getValidateQRCodeServiceResponse(validateQRCodeRequestModel), QRCodeScannerRepositoryImpl$getValidateQRCodeServiceData$1.INSTANCE, new ValidateQRCodeResponse((ValidateQRCodeResponseResult) null, (List) null, 3, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public Either<Failure, WalletPaymentDisplayModel> getWalletPaymentServiceData(@NotNull WalletPaymentRequestModel walletPaymentRequestModel) {
        Intrinsics.checkNotNullParameter(walletPaymentRequestModel, "walletPaymentRequestModel");
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(this.qrCodeScannerService.fetchWalletPaymentResponse(walletPaymentRequestModel), QRCodeScannerRepositoryImpl$getWalletPaymentServiceData$1.INSTANCE, new WalletPaymentResponse((WalletPaymentResponseResult) null, (List) null, 3, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
