package ue;

import com.talabat.SettingsScreen;
import com.talabat.language_selector.LanguageSelectorDialogClickListener;

public final /* synthetic */ class fe implements LanguageSelectorDialogClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SettingsScreen f57533a;

    public /* synthetic */ fe(SettingsScreen settingsScreen) {
        this.f57533a = settingsScreen;
    }

    public final void onLanguageChanged(String str) {
        this.f57533a.changeLanguage(str);
    }
}
