package c20;

import io.reactivex.functions.Consumer;
import library.talabat.mvp.settings.SettingsInteractor;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SettingsInteractor f24313b;

    public /* synthetic */ b(SettingsInteractor settingsInteractor) {
        this.f24313b = settingsInteractor;
    }

    public final void accept(Object obj) {
        this.f24313b.lambda$loadAppDataforLocaleChange$1((Throwable) obj);
    }
}
