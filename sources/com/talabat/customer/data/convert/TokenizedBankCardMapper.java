package com.talabat.customer.data.convert;

import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.talabat.configuration.payment.TokenizedBankCard;
import com.talabat.mapper.ModelMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/customer/data/convert/TokenizedBankCardMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lbuisnessmodels/tokenisation/TokenisationCreditCard;", "Lcom/talabat/configuration/payment/TokenizedBankCard;", "()V", "apply", "source", "com_talabat_core_customer_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokenizedBankCardMapper implements ModelMapper<TokenisationCreditCard, TokenizedBankCard> {
    @NotNull
    public TokenizedBankCard apply(@NotNull TokenisationCreditCard tokenisationCreditCard) {
        TokenisationCreditCard tokenisationCreditCard2 = tokenisationCreditCard;
        Intrinsics.checkNotNullParameter(tokenisationCreditCard2, "source");
        String str = tokenisationCreditCard2.binNumber;
        int i11 = tokenisationCreditCard2.expiremonth;
        int i12 = tokenisationCreditCard2.expireyear;
        String str2 = tokenisationCreditCard2.holdername;
        Intrinsics.checkNotNullExpressionValue(str2, "source.holdername");
        boolean z11 = tokenisationCreditCard2.isBinDiscountValid;
        boolean z12 = tokenisationCreditCard2.isForceCvv;
        boolean z13 = tokenisationCreditCard2.isValidCard;
        String str3 = tokenisationCreditCard2.cardnumber;
        Intrinsics.checkNotNullExpressionValue(str3, "source.cardnumber");
        String str4 = tokenisationCreditCard2.token;
        Intrinsics.checkNotNullExpressionValue(str4, "source.token");
        String str5 = tokenisationCreditCard2.cardtype;
        Intrinsics.checkNotNullExpressionValue(str5, "source.cardtype");
        return new TokenizedBankCard((String) null, str, i11, i12, str2, z11, z12, z13, str3, str4, str5, 1, (DefaultConstructorMarker) null);
    }
}
