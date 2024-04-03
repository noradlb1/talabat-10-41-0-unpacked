package ix;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.login.ui.fragment.EnterEmailFragment;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnterEmailFragment f23699a;

    public /* synthetic */ c(EnterEmailFragment enterEmailFragment) {
        this.f23699a = enterEmailFragment;
    }

    public final void onChanged(Object obj) {
        EnterEmailFragment.m5926observeViewModel$lambda5(this.f23699a, (Boolean) obj);
    }
}
