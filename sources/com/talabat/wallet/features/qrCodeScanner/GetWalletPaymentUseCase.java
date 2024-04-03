package com.talabat.wallet.features.qrCodeScanner;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.interactor.UseCase;
import com.talabat.wallet.features.qrCodeScanner.model.request.WalletPaymentRequestModel;
import com.talabat.wallet.features.qrCodeScanner.repository.QRCodeScannerRepository;
import com.talabat.wallet.ui.qrCodeScanner.model.WalletPaymentDisplayModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ%\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/talabat/wallet/features/qrCodeScanner/GetWalletPaymentUseCase;", "Lcom/talabat/talabatcore/interactor/UseCase;", "Lcom/talabat/wallet/ui/qrCodeScanner/model/WalletPaymentDisplayModel;", "Lcom/talabat/wallet/features/qrCodeScanner/model/request/WalletPaymentRequestModel;", "qrCodeScannerRepository", "Lcom/talabat/wallet/features/qrCodeScanner/repository/QRCodeScannerRepository;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/wallet/features/qrCodeScanner/repository/QRCodeScannerRepository;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "run", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "params", "(Lcom/talabat/wallet/features/qrCodeScanner/model/request/WalletPaymentRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetWalletPaymentUseCase extends UseCase<WalletPaymentDisplayModel, WalletPaymentRequestModel> {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final QRCodeScannerRepository qrCodeScannerRepository;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetWalletPaymentUseCase(@NotNull QRCodeScannerRepository qRCodeScannerRepository, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        super(coroutineScope, coroutineDispatcher);
        Intrinsics.checkNotNullParameter(qRCodeScannerRepository, "qrCodeScannerRepository");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.qrCodeScannerRepository = qRCodeScannerRepository;
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    @Nullable
    public Object run(@NotNull WalletPaymentRequestModel walletPaymentRequestModel, @NotNull Continuation<? super Either<? extends Failure, WalletPaymentDisplayModel>> continuation) {
        return this.qrCodeScannerRepository.getWalletPaymentServiceData(walletPaymentRequestModel);
    }
}
