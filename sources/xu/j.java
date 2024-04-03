package xu;

import androidx.lifecycle.Observer;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.GpsStatus;
import com.talabat.splash.presentation.ui.SplashActivity;

public final /* synthetic */ class j implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SplashActivity f63050a;

    public /* synthetic */ j(SplashActivity splashActivity) {
        this.f63050a = splashActivity;
    }

    public final void onChanged(Object obj) {
        SplashActivity.m10920isFetchCurrentLocReturningLoc$lambda5(this.f63050a, (GpsStatus) obj);
    }
}
