package com.talabat.talabatcommon.views.wallet.checkoutpaymentmanager.data.impl;

import buisnessmodels.Customer;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.views.wallet.checkoutpaymentmanager.domain.repository.CheckoutPaymentManagerRepository;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016¨\u0006\r"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/checkoutpaymentmanager/data/impl/CheckoutPaymentManagerRepositoryImpl;", "Lcom/talabat/talabatcommon/views/wallet/checkoutpaymentmanager/domain/repository/CheckoutPaymentManagerRepository;", "()V", "getSavedCardList", "Ljava/util/ArrayList;", "Lbuisnessmodels/tokenisation/TokenisationCreditCard;", "Lkotlin/collections/ArrayList;", "setCheckoutTimeOut", "", "timeOut", "", "setSavedCardList", "savedCardList", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutPaymentManagerRepositoryImpl implements CheckoutPaymentManagerRepository {
    public void setCheckoutTimeOut(int i11) {
        GlobalDataModel.CHECKOUT.timeOut = i11;
    }

    public void setSavedCardList(@NotNull ArrayList<TokenisationCreditCard> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "savedCardList");
        Customer instance = Customer.getInstance();
        Object[] array = arrayList.toArray(new TokenisationCreditCard[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        instance.setSavedCreditCards((TokenisationCreditCard[]) array);
    }

    @NotNull
    public ArrayList<TokenisationCreditCard> getSavedCardList() {
        ArrayList<TokenisationCreditCard> savedCards = Customer.getInstance().getSavedCards();
        Intrinsics.checkNotNullExpressionValue(savedCards, "getInstance().savedCards");
        return savedCards;
    }
}
