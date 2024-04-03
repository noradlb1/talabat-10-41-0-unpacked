package ix;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.login.ui.fragment.EnterPasswordFragment;

public final /* synthetic */ class f implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnterPasswordFragment f23702a;

    public /* synthetic */ f(EnterPasswordFragment enterPasswordFragment) {
        this.f23702a = enterPasswordFragment;
    }

    public final void onChanged(Object obj) {
        EnterPasswordFragment.m5929observeViewModel$lambda4(this.f23702a, (String) obj);
    }
}
