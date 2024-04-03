package library.talabat.mvp.payfortcardlist;

import buisnessmodels.tokenisation.TokenisationCreditCard;
import library.talabat.mvp.IGlobalInteractor;

interface IPayfortCardListIntractor extends IGlobalInteractor {
    void deleteAllSavedCard(String str);

    void deleteSavedCard(TokenisationCreditCard tokenisationCreditCard);
}
