package ix;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.login.ui.fragment.EnterEmailFragment;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnterEmailFragment f23700a;

    public /* synthetic */ d(EnterEmailFragment enterEmailFragment) {
        this.f23700a = enterEmailFragment;
    }

    public final void onChanged(Object obj) {
        EnterEmailFragment.m5927observeViewModel$lambda6(this.f23700a, (String) obj);
    }
}
