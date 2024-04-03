package ix;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.login.ui.fragment.EnterPasswordFragment;

public final /* synthetic */ class h implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnterPasswordFragment f23704a;

    public /* synthetic */ h(EnterPasswordFragment enterPasswordFragment) {
        this.f23704a = enterPasswordFragment;
    }

    public final void onChanged(Object obj) {
        EnterPasswordFragment.m5931observeViewModel$lambda7(this.f23704a, (String) obj);
    }
}
