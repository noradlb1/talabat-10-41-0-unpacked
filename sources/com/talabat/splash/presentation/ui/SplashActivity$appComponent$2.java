package com.talabat.splash.presentation.ui;

import android.app.Application;
import com.talabat.helpers.TalabatApplication;
import com.talabat.splash.core.di.ApplicationComponent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/splash/core/di/ApplicationComponent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SplashActivity$appComponent$2 extends Lambda implements Function0<ApplicationComponent> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SplashActivity f61519g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplashActivity$appComponent$2(SplashActivity splashActivity) {
        super(0);
        this.f61519g = splashActivity;
    }

    @NotNull
    public final ApplicationComponent invoke() {
        Application application = this.f61519g.getApplication();
        if (application != null) {
            return ((TalabatApplication) application).getAppComponent();
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.helpers.TalabatApplication");
    }
}
