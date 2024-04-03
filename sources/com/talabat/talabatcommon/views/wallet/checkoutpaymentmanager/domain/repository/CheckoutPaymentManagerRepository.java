package com.talabat.talabatcommon.views.wallet.checkoutpaymentmanager.domain.repository;

import buisnessmodels.tokenisation.TokenisationCreditCard;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\t\u001a\u00020\u00062\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000bj\b\u0012\u0004\u0012\u00020\u0004`\fH&¨\u0006\r"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/checkoutpaymentmanager/domain/repository/CheckoutPaymentManagerRepository;", "", "getSavedCardList", "", "Lbuisnessmodels/tokenisation/TokenisationCreditCard;", "setCheckoutTimeOut", "", "timeOut", "", "setSavedCardList", "savedCardList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CheckoutPaymentManagerRepository {
    @NotNull
    List<TokenisationCreditCard> getSavedCardList();

    void setCheckoutTimeOut(int i11);

    void setSavedCardList(@NotNull ArrayList<TokenisationCreditCard> arrayList);
}
