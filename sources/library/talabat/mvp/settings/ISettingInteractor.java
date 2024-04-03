package library.talabat.mvp.settings;

import library.talabat.mvp.IGlobalInteractor;

public interface ISettingInteractor extends IGlobalInteractor {
    void loadAppDataforLocaleChange();

    void logout(boolean z11);
}
