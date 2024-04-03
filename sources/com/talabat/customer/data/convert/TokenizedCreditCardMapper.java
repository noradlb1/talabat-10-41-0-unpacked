package com.talabat.customer.data.convert;

import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.talabat.configuration.payment.TokenizedBankCard;
import com.talabat.mapper.ModelMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/customer/data/convert/TokenizedCreditCardMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/configuration/payment/TokenizedBankCard;", "Lbuisnessmodels/tokenisation/TokenisationCreditCard;", "()V", "apply", "source", "com_talabat_core_customer_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokenizedCreditCardMapper implements ModelMapper<TokenizedBankCard, TokenisationCreditCard> {
    @NotNull
    public TokenisationCreditCard apply(@NotNull TokenizedBankCard tokenizedBankCard) {
        Intrinsics.checkNotNullParameter(tokenizedBankCard, "source");
        TokenisationCreditCard tokenisationCreditCard = new TokenisationCreditCard();
        tokenisationCreditCard.binNumber = tokenizedBankCard.getBinNumber();
        tokenisationCreditCard.expiremonth = tokenizedBankCard.getExpiryMonth();
        tokenisationCreditCard.expireyear = tokenizedBankCard.getExpiryMonth();
        tokenisationCreditCard.holdername = tokenizedBankCard.getHolderName();
        tokenisationCreditCard.isBinDiscountValid = tokenizedBankCard.isBinDiscountValid();
        tokenisationCreditCard.isForceCvv = tokenizedBankCard.isForceCvv();
        tokenisationCreditCard.isValidCard = tokenizedBankCard.isValid();
        tokenisationCreditCard.cardnumber = tokenizedBankCard.getNumber();
        tokenisationCreditCard.token = tokenizedBankCard.getToken();
        tokenisationCreditCard.cardtype = tokenizedBankCard.getType();
        return tokenisationCreditCard;
    }
}
