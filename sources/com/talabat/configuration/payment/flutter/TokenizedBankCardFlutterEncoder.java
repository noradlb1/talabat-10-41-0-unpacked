package com.talabat.configuration.payment.flutter;

import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.card_tokenization.CardTokenizationPlugin;
import com.talabat.configuration.payment.TokenizedBankCard;
import com.talabat.mapper.ModelMapper;
import dagger.Reusable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/configuration/payment/flutter/TokenizedBankCardFlutterEncoder;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/configuration/payment/TokenizedBankCard;", "", "", "", "()V", "apply", "source", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class TokenizedBankCardFlutterEncoder implements ModelMapper<TokenizedBankCard, Map<String, ? extends Object>> {
    @NotNull
    public Map<String, Object> apply(@NotNull TokenizedBankCard tokenizedBankCard) {
        Intrinsics.checkNotNullParameter(tokenizedBankCard, "source");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("binMessage", tokenizedBankCard.getBinMessage()), TuplesKt.to("binNumber", tokenizedBankCard.getBinNumber()), TuplesKt.to(CardTokenizationPlugin.ARG_EXPIRY_MONTH_KEY, Integer.valueOf(tokenizedBankCard.getExpiryMonth())), TuplesKt.to(CardTokenizationPlugin.ARG_EXPIRY_YEAR_KEY, Integer.valueOf(tokenizedBankCard.getExpiryYear())), TuplesKt.to("holderName", tokenizedBankCard.getHolderName()), TuplesKt.to("isBinDiscountValid", Boolean.valueOf(tokenizedBankCard.isBinDiscountValid())), TuplesKt.to("isForceCvv", Boolean.valueOf(tokenizedBankCard.isForceCvv())), TuplesKt.to("isValid", Boolean.valueOf(tokenizedBankCard.isValid())), TuplesKt.to(CardTokenizationPlugin.ARG_NUMBER_KEY, tokenizedBankCard.getNumber()), TuplesKt.to(LegacyTokenLocalDataSourceImpl.KEY, tokenizedBankCard.getToken()), TuplesKt.to("type", tokenizedBankCard.getType()));
    }
}
