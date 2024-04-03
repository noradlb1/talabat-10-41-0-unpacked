package xu;

import androidx.lifecycle.Observer;
import com.talabat.splash.presentation.ui.WelcomeVideoFragment;

public final /* synthetic */ class n implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WelcomeVideoFragment f63054a;

    public /* synthetic */ n(WelcomeVideoFragment welcomeVideoFragment) {
        this.f63054a = welcomeVideoFragment;
    }

    public final void onChanged(Object obj) {
        WelcomeVideoFragment.m10923initObserver$lambda1(this.f63054a, (Boolean) obj);
    }
}
