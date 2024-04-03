package ix;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.login.presentation.displaymodel.EditFieldDisplayModel;
import com.talabat.userandlocation.login.ui.fragment.EnterPasswordFragment;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnterPasswordFragment f23701a;

    public /* synthetic */ e(EnterPasswordFragment enterPasswordFragment) {
        this.f23701a = enterPasswordFragment;
    }

    public final void onChanged(Object obj) {
        EnterPasswordFragment.m5928observeViewModel$lambda3(this.f23701a, (EditFieldDisplayModel) obj);
    }
}
