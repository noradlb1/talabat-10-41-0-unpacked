package library.talabat.mvp.payfortcardlist;

import buisnessmodels.tokenisation.TokenisationCreditCard;
import library.talabat.mvp.IGlobalPresenter;

public interface IPayfortCardListPresenter extends IGlobalPresenter {
    void deleteSavedCardButtonClicked(TokenisationCreditCard tokenisationCreditCard);

    void loadSavedCreditCardList();

    void setUpViews();
}
