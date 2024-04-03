package library.talabat.mvp.payfortcardlist;

import library.talabat.mvp.IGlobalListener;

public interface PayfortCardListListener extends IGlobalListener {
    void onDeleteAllSavedCardSuccess();

    void onDeleteSavedCardFail(String str);

    void onDeleteSavedCardSucess(String str, String str2);
}
