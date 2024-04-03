package xu;

import androidx.lifecycle.Observer;
import com.talabat.splash.presentation.ui.SplashActivity;

public final /* synthetic */ class g implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SplashActivity f63048a;

    public /* synthetic */ g(SplashActivity splashActivity) {
        this.f63048a = splashActivity;
    }

    public final void onChanged(Object obj) {
        SplashActivity.m10919initObserver$lambda1(this.f63048a, (Boolean) obj);
    }
}
