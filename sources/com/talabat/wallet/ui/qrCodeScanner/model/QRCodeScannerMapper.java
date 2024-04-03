package com.talabat.wallet.ui.qrCodeScanner.model;

import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.model.wallet.WalletErrorMessageModel;
import com.talabat.wallet.features.qrCodeScanner.model.response.QRCodeModel;
import com.talabat.wallet.features.qrCodeScanner.model.response.ValidateQRCodeResponse;
import com.talabat.wallet.features.qrCodeScanner.model.response.ValidateQRCodeResponseResult;
import com.talabat.wallet.features.qrCodeScanner.model.response.WalletPaymentResponse;
import com.talabat.wallet.features.qrCodeScanner.model.response.WalletPaymentResponseResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/wallet/ui/qrCodeScanner/model/QRCodeScannerMapper;", "", "()V", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QRCodeScannerMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/wallet/ui/qrCodeScanner/model/QRCodeScannerMapper$Companion;", "", "()V", "extractServerError", "", "errorList", "", "Lcom/talabat/talabatcommon/model/wallet/WalletErrorMessageModel;", "mapQRCodeValidationResponse", "Lcom/talabat/wallet/ui/qrCodeScanner/model/ValidateQRCodeDisplayModel;", "response", "Lcom/talabat/wallet/features/qrCodeScanner/model/response/ValidateQRCodeResponse;", "mapWalletPaymentResponse", "Lcom/talabat/wallet/ui/qrCodeScanner/model/WalletPaymentDisplayModel;", "Lcom/talabat/wallet/features/qrCodeScanner/model/response/WalletPaymentResponse;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String extractServerError(List<WalletErrorMessageModel> list) {
            for (WalletErrorMessageModel message : list) {
                String message2 = message.getMessage();
                if (message2 != null) {
                    return message2;
                }
            }
            return "";
        }

        @NotNull
        public final ValidateQRCodeDisplayModel mapQRCodeValidationResponse(@Nullable ValidateQRCodeResponse validateQRCodeResponse) {
            String str;
            ValidateQRCodeDisplayModel validateQRCodeDisplayModel = new ValidateQRCodeDisplayModel(false, 0.0f, 0.0f, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 2047, (DefaultConstructorMarker) null);
            if (validateQRCodeResponse != null) {
                List<WalletErrorMessageModel> responseMessages = validateQRCodeResponse.getResponseMessages();
                if (responseMessages != null) {
                    validateQRCodeDisplayModel.setServerErrorMessage(QRCodeScannerMapper.Companion.extractServerError(responseMessages));
                }
                ValidateQRCodeResponseResult result = validateQRCodeResponse.getResult();
                if (result != null) {
                    Boolean isValid = result.isValid();
                    if (isValid != null) {
                        validateQRCodeDisplayModel.setQRCodeValid(isValid.booleanValue());
                    }
                    String message = result.getMessage();
                    if (message != null) {
                        validateQRCodeDisplayModel.setQrErrorMessage(message);
                    }
                    QRCodeModel qrCode = result.getQrCode();
                    if (qrCode != null) {
                        validateQRCodeDisplayModel.setAmount(FloatKt.orZero(qrCode.getAmount()));
                        validateQRCodeDisplayModel.setDiscount(FloatKt.orZero(qrCode.getDiscount()));
                        validateQRCodeDisplayModel.setBrandId(IntKt.orZero(qrCode.getBrandId()));
                        String vendorId = qrCode.getVendorId();
                        String str2 = "";
                        if (vendorId == null) {
                            vendorId = str2;
                        }
                        validateQRCodeDisplayModel.setVendorId(vendorId);
                        String merchantName = qrCode.getMerchantName();
                        if (merchantName == null) {
                            merchantName = str2;
                        }
                        validateQRCodeDisplayModel.setMerchantName(merchantName);
                        String merchantTransactionId = qrCode.getMerchantTransactionId();
                        if (merchantTransactionId == null) {
                            merchantTransactionId = str2;
                        }
                        validateQRCodeDisplayModel.setMerchantTransactionId(merchantTransactionId);
                        Integer requestSource = qrCode.getRequestSource();
                        if (requestSource != null) {
                            str = requestSource.toString();
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            str2 = str;
                        }
                        validateQRCodeDisplayModel.setRequestSource(str2);
                    }
                }
            }
            return validateQRCodeDisplayModel;
        }

        @NotNull
        public final WalletPaymentDisplayModel mapWalletPaymentResponse(@Nullable WalletPaymentResponse walletPaymentResponse) {
            WalletPaymentDisplayModel walletPaymentDisplayModel = new WalletPaymentDisplayModel();
            if (walletPaymentResponse != null) {
                List<WalletErrorMessageModel> responseMessages = walletPaymentResponse.getResponseMessages();
                if (responseMessages != null) {
                    walletPaymentDisplayModel.setServerErrorMessage(QRCodeScannerMapper.Companion.extractServerError(responseMessages));
                }
                WalletPaymentResponseResult result = walletPaymentResponse.getResult();
                if (result != null) {
                    String message = result.getMessage();
                    String str = "";
                    if (message == null) {
                        message = str;
                    }
                    walletPaymentDisplayModel.setMessage(message);
                    String walletTransactionId = result.getWalletTransactionId();
                    if (walletTransactionId != null) {
                        str = walletTransactionId;
                    }
                    walletPaymentDisplayModel.setWalletTransactionId(str);
                    Integer walletTransactionStatus = result.getWalletTransactionStatus();
                    if (walletTransactionStatus != null) {
                        walletPaymentDisplayModel.setWalletTransactionStatus(walletTransactionStatus.intValue());
                    }
                }
            }
            return walletPaymentDisplayModel;
        }
    }
}
