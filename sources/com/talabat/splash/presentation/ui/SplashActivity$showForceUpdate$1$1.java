package com.talabat.splash.presentation.ui;

import com.talabat.splash.presentation.infrastructure.device.PresentationUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/talabat/splash/presentation/ui/SplashActivity$showForceUpdate$1$1", "Lcom/talabat/splash/presentation/infrastructure/device/PresentationUtils$OnAlertListener;", "onsetPositiveButtonClicked", "", "setNegativeButtonClicked", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplashActivity$showForceUpdate$1$1 implements PresentationUtils.OnAlertListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SplashActivity f61526a;

    public SplashActivity$showForceUpdate$1$1(SplashActivity splashActivity) {
        this.f61526a = splashActivity;
    }

    public void onsetPositiveButtonClicked() {
        this.f61526a.finish();
        this.f61526a.getNavigator$com_talabat_talabat_talabat().onForceUpdateRedirect(this.f61526a);
    }

    public void setNegativeButtonClicked() {
        this.f61526a.finish();
    }
}
