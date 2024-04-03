package com.talabat.flutter.utils.payment;

import com.talabat.flutter.domain.paymentIntegration.PaymentCardDetail;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import java.util.Calendar;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u001a\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0018\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\n0\t*\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"DATE_SEPARATOR", "", "getWalletCardDetails", "Lcom/talabat/flutter/domain/paymentIntegration/PaymentCardDetail;", "card", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "paymentMethod", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "toMap", "", "", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FlutterPaymentExtensionsKt {
    @NotNull
    public static final String DATE_SEPARATOR = "/";

    @NotNull
    public static final PaymentCardDetail getWalletCardDetails(@NotNull WalletCardDisplayModel walletCardDisplayModel, @NotNull PaymentMethod paymentMethod) {
        Intrinsics.checkNotNullParameter(walletCardDisplayModel, "card");
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        String valueOf = String.valueOf(Calendar.getInstance().get(1));
        int value = paymentMethod.getValue();
        String tokenId = walletCardDisplayModel.getTokenId();
        String cardType = walletCardDisplayModel.getCardType();
        String expiryMonth = walletCardDisplayModel.getExpiryMonth();
        String take = StringsKt___StringsKt.take(valueOf, 2);
        String expiryYear = walletCardDisplayModel.getExpiryYear();
        return new PaymentCardDetail(value, tokenId, StringsKt___StringsKt.takeLast(walletCardDisplayModel.getCardNumber(), 4), cardType, expiryMonth + "/" + take + expiryYear);
    }

    @NotNull
    public static final Map<String, Object> toMap(@NotNull PaymentCardDetail paymentCardDetail) {
        Intrinsics.checkNotNullParameter(paymentCardDetail, "<this>");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("paymentMethod", Integer.valueOf(paymentCardDetail.getPaymentMethod())), TuplesKt.to("cardTokenId", paymentCardDetail.getCardTokenId()), TuplesKt.to(WalletNavigatorActions.EXTRA_CARD_4_DIGITS, paymentCardDetail.getCard4Digits()), TuplesKt.to("cardType", paymentCardDetail.getCardType()), TuplesKt.to("cardExpiryDate", paymentCardDetail.getCardExpiryDate()));
    }
}
