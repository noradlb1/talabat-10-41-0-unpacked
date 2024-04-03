package com.talabat.talabatcommon.feature.walletPayment.repository;

import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletPaymentResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletPaymentResponse;", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentRepositoryImpl$debitWallet$1 extends Lambda implements Function1<WalletPaymentResponse, WalletPaymentResponse> {
    public static final WalletPaymentRepositoryImpl$debitWallet$1 INSTANCE = new WalletPaymentRepositoryImpl$debitWallet$1();

    public WalletPaymentRepositoryImpl$debitWallet$1() {
        super(1);
    }

    @NotNull
    public final WalletPaymentResponse invoke(@NotNull WalletPaymentResponse walletPaymentResponse) {
        Intrinsics.checkNotNullParameter(walletPaymentResponse, "it");
        return walletPaymentResponse;
    }
}
