package library.talabat.mvp.offerslist;

import library.talabat.mvp.IGlobalPresenter;

public interface IOffersPresenter extends IGlobalPresenter {
    void loadOffersList();

    void setOffersSelected(int i11);
}
