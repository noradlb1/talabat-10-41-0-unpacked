package c20;

import io.reactivex.functions.Action;
import library.talabat.mvp.settings.SettingsInteractor;

public final /* synthetic */ class a implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SettingsInteractor f24312b;

    public /* synthetic */ a(SettingsInteractor settingsInteractor) {
        this.f24312b = settingsInteractor;
    }

    public final void run() {
        this.f24312b.lambda$loadAppDataforLocaleChange$0();
    }
}
