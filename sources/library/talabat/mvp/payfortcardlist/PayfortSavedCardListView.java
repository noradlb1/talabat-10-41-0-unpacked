package library.talabat.mvp.payfortcardlist;

import android.content.Context;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import java.util.ArrayList;

public interface PayfortSavedCardListView {
    void deleteAllSavedCardList();

    void deleteCardFail(String str);

    Context getcontext();

    void refreshSavedCardList(ArrayList<TokenisationCreditCard> arrayList, String str);

    void savedCreditCardListLoaded(ArrayList<TokenisationCreditCard> arrayList);
}
