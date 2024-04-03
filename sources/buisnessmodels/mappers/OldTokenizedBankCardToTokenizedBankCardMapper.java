package buisnessmodels.mappers;

import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.talabat.configuration.payment.TokenizedBankCard;
import com.talabat.mapper.ModelMapper;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lbuisnessmodels/mappers/OldTokenizedBankCardToTokenizedBankCardMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lbuisnessmodels/tokenisation/TokenisationCreditCard;", "Lcom/talabat/configuration/payment/TokenizedBankCard;", "()V", "apply", "source", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class OldTokenizedBankCardToTokenizedBankCardMapper implements ModelMapper<TokenisationCreditCard, TokenizedBankCard> {
    @NotNull
    public TokenizedBankCard apply(@NotNull TokenisationCreditCard tokenisationCreditCard) {
        String str;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(tokenisationCreditCard, "source");
        String str5 = tokenisationCreditCard.message;
        String str6 = str5 == null ? "" : str5;
        String str7 = tokenisationCreditCard.binNumber;
        if (str7 == null) {
            str = "";
        } else {
            str = str7;
        }
        int i11 = tokenisationCreditCard.expiremonth;
        int i12 = tokenisationCreditCard.expireyear + 2000;
        String str8 = tokenisationCreditCard.holdername;
        if (str8 == null) {
            str2 = "";
        } else {
            str2 = str8;
        }
        boolean z11 = tokenisationCreditCard.isBinDiscountValid;
        boolean z12 = tokenisationCreditCard.isForceCvv;
        boolean z13 = tokenisationCreditCard.isValidCard;
        String str9 = tokenisationCreditCard.cardnumber;
        if (str9 == null) {
            str3 = "";
        } else {
            str3 = str9;
        }
        String str10 = tokenisationCreditCard.token;
        if (str10 == null) {
            str4 = "";
        } else {
            str4 = str10;
        }
        String str11 = tokenisationCreditCard.cardtype;
        if (str11 == null) {
            str11 = "";
        }
        return new TokenizedBankCard(str6, str, i11, i12, str2, z11, z12, z13, str3, str4, str11);
    }
}
