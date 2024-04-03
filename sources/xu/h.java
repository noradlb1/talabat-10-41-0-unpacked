package xu;

import androidx.lifecycle.Observer;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.PermissionStatus;
import com.talabat.splash.presentation.ui.SplashActivity;

public final /* synthetic */ class h implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SplashActivity f63049a;

    public /* synthetic */ h(SplashActivity splashActivity) {
        this.f63049a = splashActivity;
    }

    public final void onChanged(Object obj) {
        SplashActivity.m10921isFetchCurrentLocReturningLoc$lambda5$lambda4(this.f63049a, (PermissionStatus) obj);
    }
}
