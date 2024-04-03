package library.talabat.mvp.settings;

import android.content.Context;
import com.talabat.helpers.Talabat;

public interface SettingsView extends Talabat {
    Context getContext();

    void onChangeCountryCompleted();

    void onLogout(boolean z11);

    void reloadViewForLocaleChange();
}
