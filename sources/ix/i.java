package ix;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.login.ui.fragment.EnterPasswordFragment;

public final /* synthetic */ class i implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnterPasswordFragment f23705a;

    public /* synthetic */ i(EnterPasswordFragment enterPasswordFragment) {
        this.f23705a = enterPasswordFragment;
    }

    public final void onChanged(Object obj) {
        EnterPasswordFragment.m5932observeViewModel$lambda8(this.f23705a, (Boolean) obj);
    }
}
