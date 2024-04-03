package com.talabat.talabatcommon.feature.walletPayment.repository;

import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletDebitRequestModel;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletTopUpRequestModel;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletVerifyQRCodeRequestModel;
import com.talabat.talabatcommon.feature.walletPayment.model.response.VerifyWalletTransactionResponse;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletPaymentResponse;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletPaymentResultModel;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletTopUpSuggestionsAndLimitsResponse;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletTopUpSuggestionsAndLimitsResultModel;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletVerifyQRCodeResponse;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletVerifyQRCodeResultModel;
import com.talabat.talabatcommon.feature.walletPayment.network.VerifyQRAPI;
import com.talabat.talabatcommon.feature.walletPayment.network.WalletPaymentApi;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.platform.NetworkHandler;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00100\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001b0\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPayment/repository/WalletPaymentRepositoryImpl;", "Lcom/talabat/talabatcommon/feature/walletPayment/repository/WalletPaymentRepository;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "walletPaymentService", "Lcom/talabat/talabatcommon/feature/walletPayment/network/WalletPaymentApi;", "verifyQRService", "Lcom/talabat/talabatcommon/feature/walletPayment/network/VerifyQRAPI;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/talabatcommon/feature/walletPayment/network/WalletPaymentApi;Lcom/talabat/talabatcommon/feature/walletPayment/network/VerifyQRAPI;)V", "debitWallet", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletPaymentResponse;", "walletDebitRequestModel", "Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletDebitRequestModel;", "getVerifyWalletTransaction", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/VerifyWalletTransactionResponse;", "transactionId", "", "getWalletTopUpSuggestionsAndLimits", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletTopUpSuggestionsAndLimitsResponse;", "country", "", "topUpWallet", "walletTopUpRequestModel", "Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletTopUpRequestModel;", "verifyQRCode", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletVerifyQRCodeResponse;", "walletVerifyQRCodeRequestModel", "Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletVerifyQRCodeRequestModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentRepositoryImpl implements WalletPaymentRepository {
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull
    private final VerifyQRAPI verifyQRService;
    @NotNull
    private final WalletPaymentApi walletPaymentService;

    public WalletPaymentRepositoryImpl(@NotNull NetworkHandler networkHandler2, @NotNull WalletPaymentApi walletPaymentApi, @NotNull VerifyQRAPI verifyQRAPI) {
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(walletPaymentApi, "walletPaymentService");
        Intrinsics.checkNotNullParameter(verifyQRAPI, "verifyQRService");
        this.networkHandler = networkHandler2;
        this.walletPaymentService = walletPaymentApi;
        this.verifyQRService = verifyQRAPI;
    }

    @NotNull
    public Either<Failure, WalletPaymentResponse> debitWallet(@NotNull WalletDebitRequestModel walletDebitRequestModel) {
        Intrinsics.checkNotNullParameter(walletDebitRequestModel, "walletDebitRequestModel");
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(this.walletPaymentService.debitWallet(walletDebitRequestModel), WalletPaymentRepositoryImpl$debitWallet$1.INSTANCE, new WalletPaymentResponse((WalletPaymentResultModel) null, 1, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public Either<Failure, VerifyWalletTransactionResponse> getVerifyWalletTransaction(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "transactionId");
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(this.walletPaymentService.getVerifyWalletTransaction(str), WalletPaymentRepositoryImpl$getVerifyWalletTransaction$1.INSTANCE, new VerifyWalletTransactionResponse((Boolean) null, 1, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public Either<Failure, WalletTopUpSuggestionsAndLimitsResponse> getWalletTopUpSuggestionsAndLimits(int i11) {
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(WalletPaymentApi.DefaultImpls.getWalletTopUpSuggestionAmount$default(this.walletPaymentService, i11, 0, 2, (Object) null), WalletPaymentRepositoryImpl$getWalletTopUpSuggestionsAndLimits$1.INSTANCE, new WalletTopUpSuggestionsAndLimitsResponse((WalletTopUpSuggestionsAndLimitsResultModel) null, 1, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public Either<Failure, WalletPaymentResponse> topUpWallet(@NotNull WalletTopUpRequestModel walletTopUpRequestModel) {
        Intrinsics.checkNotNullParameter(walletTopUpRequestModel, "walletTopUpRequestModel");
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(this.walletPaymentService.topUpWallet(walletTopUpRequestModel), WalletPaymentRepositoryImpl$topUpWallet$1.INSTANCE, new WalletPaymentResponse((WalletPaymentResultModel) null, 1, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public Either<Failure, WalletVerifyQRCodeResponse> verifyQRCode(@NotNull WalletVerifyQRCodeRequestModel walletVerifyQRCodeRequestModel) {
        Intrinsics.checkNotNullParameter(walletVerifyQRCodeRequestModel, "walletVerifyQRCodeRequestModel");
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(VerifyQRAPI.DefaultImpls.verifyQRCode$default(this.verifyQRService, walletVerifyQRCodeRequestModel, 0, 0, 6, (Object) null), WalletPaymentRepositoryImpl$verifyQRCode$1.INSTANCE, new WalletVerifyQRCodeResponse((WalletVerifyQRCodeResultModel) null, 1, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
