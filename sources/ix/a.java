package ix;

import androidx.lifecycle.Observer;
import com.talabat.userandlocation.login.presentation.displaymodel.EditFieldDisplayModel;
import com.talabat.userandlocation.login.ui.fragment.EnterEmailFragment;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnterEmailFragment f23697a;

    public /* synthetic */ a(EnterEmailFragment enterEmailFragment) {
        this.f23697a = enterEmailFragment;
    }

    public final void onChanged(Object obj) {
        EnterEmailFragment.m5924observeViewModel$lambda3(this.f23697a, (EditFieldDisplayModel) obj);
    }
}
