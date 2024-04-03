package com.talabat.talabatcommon.views.wallet.walletPaymentOption.model;

import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.feature.walletPayment.model.response.VerifyWalletTransactionResponse;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletPaymentErrorType;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletPaymentResponse;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletPaymentResultModel;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletPaymentTransactionStatus;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletTopUpAmountSuggestion;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletTopUpSuggestionsAndLimitsResponse;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletTopUpSuggestionsAndLimitsResultModel;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletVerifyQRCodeResponse;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletVerifyQRCodeResultModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentMapper;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000f¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentMapper$Companion;", "", "()V", "mapVerifyWalletQRCodeResponseToDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletVerifyQRCodeDisplayModel;", "response", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletVerifyQRCodeResponse;", "mapVerifyWalletTransactionResponseToDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/VerifyWalletTransactionDisplayModel;", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/VerifyWalletTransactionResponse;", "mapWalletPaymentToDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentDisplayModel;", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletPaymentResponse;", "mapWalletTopUpSuggestionsAndLimitsToDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpSuggestionsAndLimitsDisplayModel;", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletTopUpSuggestionsAndLimitsResponse;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WalletVerifyQRCodeDisplayModel mapVerifyWalletQRCodeResponseToDisplayModel(@Nullable WalletVerifyQRCodeResponse walletVerifyQRCodeResponse) {
            WalletVerifyQRCodeResultModel result;
            WalletVerifyQRCodeDisplayModel walletVerifyQRCodeDisplayModel = new WalletVerifyQRCodeDisplayModel();
            if (!(walletVerifyQRCodeResponse == null || (result = walletVerifyQRCodeResponse.getResult()) == null)) {
                walletVerifyQRCodeDisplayModel.setStatus(BooleanKt.orFalse(result.getStatus()));
                String message = result.getMessage();
                if (message == null) {
                    message = "";
                }
                walletVerifyQRCodeDisplayModel.setMessage(message);
            }
            return walletVerifyQRCodeDisplayModel;
        }

        @NotNull
        public final VerifyWalletTransactionDisplayModel mapVerifyWalletTransactionResponseToDisplayModel(@Nullable VerifyWalletTransactionResponse verifyWalletTransactionResponse) {
            Boolean result;
            VerifyWalletTransactionDisplayModel verifyWalletTransactionDisplayModel = new VerifyWalletTransactionDisplayModel();
            if (!(verifyWalletTransactionResponse == null || (result = verifyWalletTransactionResponse.getResult()) == null)) {
                verifyWalletTransactionDisplayModel.setTransactionSuccessful(result.booleanValue());
            }
            return verifyWalletTransactionDisplayModel;
        }

        @NotNull
        public final WalletPaymentDisplayModel mapWalletPaymentToDisplayModel(@Nullable WalletPaymentResponse walletPaymentResponse) {
            WalletPaymentResultModel result;
            WalletPaymentDisplayModel walletPaymentDisplayModel = new WalletPaymentDisplayModel();
            if (!(walletPaymentResponse == null || (result = walletPaymentResponse.getResult()) == null)) {
                String redirectUrl = result.getRedirectUrl();
                String str = "";
                if (redirectUrl == null) {
                    redirectUrl = str;
                }
                walletPaymentDisplayModel.setRedirectUrl(redirectUrl);
                WalletPaymentTransactionStatus byValue = WalletPaymentTransactionStatus.Companion.getByValue(result.getWalletTransactionStatus());
                if (byValue == null) {
                    byValue = WalletPaymentTransactionStatus.NONE;
                }
                walletPaymentDisplayModel.setWalletTransactionStatus(byValue);
                String walletTransactionId = result.getWalletTransactionId();
                if (walletTransactionId == null) {
                    walletTransactionId = str;
                }
                walletPaymentDisplayModel.setWalletTransactionId(walletTransactionId);
                String errorMessage = result.getErrorMessage();
                if (errorMessage != null) {
                    str = errorMessage;
                }
                walletPaymentDisplayModel.setErrorMessage(str);
                walletPaymentDisplayModel.setErrorType(WalletPaymentErrorType.Companion.getByValue(result.getErrorCategory()));
            }
            return walletPaymentDisplayModel;
        }

        @NotNull
        public final WalletTopUpSuggestionsAndLimitsDisplayModel mapWalletTopUpSuggestionsAndLimitsToDisplayModel(@Nullable WalletTopUpSuggestionsAndLimitsResponse walletTopUpSuggestionsAndLimitsResponse) {
            Integer num;
            WalletTopUpSuggestionsAndLimitsResultModel result;
            WalletTopUpSuggestionsAndLimitsResultModel result2;
            WalletTopUpSuggestionsAndLimitsResultModel result3;
            List<WalletTopUpAmountSuggestion> topUpAmountSuggestions;
            ArrayList arrayList = new ArrayList();
            if (!(walletTopUpSuggestionsAndLimitsResponse == null || (result3 = walletTopUpSuggestionsAndLimitsResponse.getResult()) == null || (topUpAmountSuggestions = result3.getTopUpAmountSuggestions()) == null)) {
                for (WalletTopUpAmountSuggestion next : topUpAmountSuggestions) {
                    WalletTopUpAmountSuggestionDisplayModel walletTopUpAmountSuggestionDisplayModel = new WalletTopUpAmountSuggestionDisplayModel();
                    walletTopUpAmountSuggestionDisplayModel.setAmount(FloatKt.orZero(next.getTopUpAmount()));
                    walletTopUpAmountSuggestionDisplayModel.setCashBack(FloatKt.orZero(next.getTopUpCashBack()));
                    arrayList.add(walletTopUpAmountSuggestionDisplayModel);
                }
            }
            Integer num2 = null;
            if (walletTopUpSuggestionsAndLimitsResponse == null || (result2 = walletTopUpSuggestionsAndLimitsResponse.getResult()) == null) {
                num = null;
            } else {
                num = Integer.valueOf(result2.getMaxTopUpAmount());
            }
            int orZero = IntKt.orZero(num);
            if (!(walletTopUpSuggestionsAndLimitsResponse == null || (result = walletTopUpSuggestionsAndLimitsResponse.getResult()) == null)) {
                num2 = Integer.valueOf(result.getMinTopUpAmount());
            }
            return new WalletTopUpSuggestionsAndLimitsDisplayModel(arrayList, orZero, IntKt.orZero(num2));
        }
    }
}
