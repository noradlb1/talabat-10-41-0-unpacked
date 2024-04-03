package com.talabat.wallet.features.expiringCard.repository;

import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.wallet.features.expiringCard.model.ExpiringCardModel;
import com.talabat.wallet.features.expiringCard.model.ExpiringCardResponse;
import com.talabat.wallet.features.expiringCard.network.ExpiringCardApi;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/wallet/features/expiringCard/repository/ExpiringCardRepositoryImpl;", "Lcom/talabat/wallet/features/expiringCard/repository/ExpiringCardRepository;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "expiringCardApi", "Lcom/talabat/wallet/features/expiringCard/network/ExpiringCardApi;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/wallet/features/expiringCard/network/ExpiringCardApi;)V", "getExpiringCardDetail", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/wallet/features/expiringCard/model/ExpiringCardResponse;", "country", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExpiringCardRepositoryImpl implements ExpiringCardRepository {
    @NotNull
    private final ExpiringCardApi expiringCardApi;
    @NotNull
    private final NetworkHandler networkHandler;

    public ExpiringCardRepositoryImpl(@NotNull NetworkHandler networkHandler2, @NotNull ExpiringCardApi expiringCardApi2) {
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(expiringCardApi2, "expiringCardApi");
        this.networkHandler = networkHandler2;
        this.expiringCardApi = expiringCardApi2;
    }

    @NotNull
    public Either<Failure, ExpiringCardResponse> getExpiringCardDetail(int i11) {
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(ExpiringCardApi.DefaultImpls.getExpiringCardDetail$default(this.expiringCardApi, i11, 0, 2, (Object) null), ExpiringCardRepositoryImpl$getExpiringCardDetail$1.INSTANCE, new ExpiringCardResponse((ExpiringCardModel) null, 1, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
