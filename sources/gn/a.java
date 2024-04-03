package gn;

import androidx.lifecycle.Observer;
import com.talabat.feature.nfvinvendorsearch.presentation.activity.QCommerceFlutterActivity;
import com.talabat.feature.nfvinvendorsearch.presentation.model.NavigationCommand;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QCommerceFlutterActivity f62111a;

    public /* synthetic */ a(QCommerceFlutterActivity qCommerceFlutterActivity) {
        this.f62111a = qCommerceFlutterActivity;
    }

    public final void onChanged(Object obj) {
        this.f62111a.handleNavigationCommand((NavigationCommand) obj);
    }
}
