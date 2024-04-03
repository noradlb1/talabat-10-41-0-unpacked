package in;

import androidx.lifecycle.Observer;
import com.talabat.feature.nfvinvendorsearch.presentation.fragment.QCommerceFlutterFragment;
import com.talabat.feature.nfvinvendorsearch.presentation.model.NavigationCommand;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QCommerceFlutterFragment f62157a;

    public /* synthetic */ a(QCommerceFlutterFragment qCommerceFlutterFragment) {
        this.f62157a = qCommerceFlutterFragment;
    }

    public final void onChanged(Object obj) {
        this.f62157a.handleNavigationCommand((NavigationCommand) obj);
    }
}
