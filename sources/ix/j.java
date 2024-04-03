package ix;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.login.ui.fragment.EnterPasswordFragment;
import kotlin.Unit;

public final /* synthetic */ class j implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnterPasswordFragment f23706a;

    public /* synthetic */ j(EnterPasswordFragment enterPasswordFragment) {
        this.f23706a = enterPasswordFragment;
    }

    public final void onChanged(Object obj) {
        EnterPasswordFragment.m5933observeViewModel$lambda9(this.f23706a, (Unit) obj);
    }
}
