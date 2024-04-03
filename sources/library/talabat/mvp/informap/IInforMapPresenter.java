package library.talabat.mvp.informap;

import library.talabat.mvp.IGlobalPresenter;

public interface IInforMapPresenter extends IGlobalPresenter {
    void informapAddressReceived(String str, boolean z11, int i11, int i12);

    void onUrlChanged(String str);

    void setUpViews(String str);
}
