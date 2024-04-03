package library.talabat.gemengine;

import library.talabat.mvp.IGlobalPresenter;

public interface IGemPresenter extends IGlobalPresenter {
    void acceptGemOffer(String str, long j11);

    void getGemOffers(int i11, String str, String str2);

    void rejectGemOffer(String str);
}
