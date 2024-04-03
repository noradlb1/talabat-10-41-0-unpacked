package buisnessmodels.mappers;

import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.talabat.configuration.payment.TokenizedBankCard;
import com.talabat.mapper.ModelMapper;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lbuisnessmodels/mappers/TokenizedBankCardToOldTokenizedBankCardMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/configuration/payment/TokenizedBankCard;", "Lbuisnessmodels/tokenisation/TokenisationCreditCard;", "()V", "apply", "source", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class TokenizedBankCardToOldTokenizedBankCardMapper implements ModelMapper<TokenizedBankCard, TokenisationCreditCard> {
    @NotNull
    public TokenisationCreditCard apply(@NotNull TokenizedBankCard tokenizedBankCard) {
        Intrinsics.checkNotNullParameter(tokenizedBankCard, "source");
        TokenisationCreditCard tokenisationCreditCard = new TokenisationCreditCard();
        tokenisationCreditCard.token = tokenizedBankCard.getToken();
        tokenisationCreditCard.holdername = tokenizedBankCard.getHolderName();
        tokenisationCreditCard.cardnumber = tokenizedBankCard.getNumber();
        tokenisationCreditCard.cardtype = tokenizedBankCard.getType();
        int expiryMonth = tokenizedBankCard.getExpiryMonth();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(tokenizedBankCard.getExpiryYear() - 2000);
        sb2.append(expiryMonth);
        tokenisationCreditCard.expiredate = sb2.toString();
        tokenisationCreditCard.expireyear = tokenizedBankCard.getExpiryYear() - 2000;
        tokenisationCreditCard.expiremonth = tokenizedBankCard.getExpiryMonth();
        tokenisationCreditCard.isValidCard = tokenizedBankCard.isValid();
        tokenisationCreditCard.isBinDiscountValid = tokenizedBankCard.isBinDiscountValid();
        tokenisationCreditCard.message = tokenizedBankCard.getBinMessage();
        tokenisationCreditCard.binNumber = tokenizedBankCard.getBinNumber();
        tokenisationCreditCard.isForceCvv = tokenizedBankCard.isForceCvv();
        return tokenisationCreditCard;
    }
}
