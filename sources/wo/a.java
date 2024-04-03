package wo;

import androidx.lifecycle.Observer;
import com.talabat.feature.subscriptions.domain.model.ProVendorMov;
import com.talabat.feature.tpro.presentation.helperview.mov.TProVendorMovView;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TProVendorMovView f62988a;

    public /* synthetic */ a(TProVendorMovView tProVendorMovView) {
        this.f62988a = tProVendorMovView;
    }

    public final void onChanged(Object obj) {
        this.f62988a.handleProVendorMov((ProVendorMov) obj);
    }
}
