package library.talabat.mvp.settings;

import android.content.Context;
import library.talabat.mvp.IGlobalPresenter;

public interface ISettingsPresenter extends IGlobalPresenter {
    void changeLanguage(Context context, String str);

    boolean getNotificationPreference();

    void logout(boolean z11);

    void onCountryChanged();

    void saveNotificationPreference(boolean z11);
}
