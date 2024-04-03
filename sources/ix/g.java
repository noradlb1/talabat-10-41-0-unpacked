package ix;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.login.ui.fragment.EnterPasswordFragment;

public final /* synthetic */ class g implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnterPasswordFragment f23703a;

    public /* synthetic */ g(EnterPasswordFragment enterPasswordFragment) {
        this.f23703a = enterPasswordFragment;
    }

    public final void onChanged(Object obj) {
        EnterPasswordFragment.m5930observeViewModel$lambda6(this.f23703a, (String) obj);
    }
}
