package xu;

import androidx.lifecycle.Observer;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.PermissionStatus;
import com.talabat.splash.presentation.ui.SplashActivity;

public final /* synthetic */ class k implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SplashActivity f63051a;

    public /* synthetic */ k(SplashActivity splashActivity) {
        this.f63051a = splashActivity;
    }

    public final void onChanged(Object obj) {
        SplashActivity.m10918getAppLaunchWithGpsLocationStatus$lambda11$lambda10(this.f63051a, (PermissionStatus) obj);
    }
}
