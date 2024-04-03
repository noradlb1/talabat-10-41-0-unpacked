package library.talabat.mvp.accountinfo;

import JsonModels.Response.AccountInfoRM;
import library.talabat.mvp.IGlobalListener;

public interface AccountListener extends IGlobalListener {
    void onAccountUpdated(AccountInfoRM accountInfoRM);

    void onAccountUpdatingFailed(int i11, String str);

    void onKurdishNamesBlocked(String str);
}
