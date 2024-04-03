package library.talabat.gemengine;

import library.talabat.mvp.IGlobalInteractor;

public interface IGemInteractor extends IGlobalInteractor {
    void acceptGem(String str, long j11);

    void cancelGem(String str);

    void getGemOffers(int i11, String str, String str2);

    void rejectGem(String str);
}
