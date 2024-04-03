package ix;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.login.ui.fragment.EnterEmailFragment;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnterEmailFragment f23698a;

    public /* synthetic */ b(EnterEmailFragment enterEmailFragment) {
        this.f23698a = enterEmailFragment;
    }

    public final void onChanged(Object obj) {
        EnterEmailFragment.m5925observeViewModel$lambda4(this.f23698a, (String) obj);
    }
}
