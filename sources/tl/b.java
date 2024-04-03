package tl;

import androidx.lifecycle.Observer;
import com.talabat.feature.darkstores.presentation.activity.DarkStoresDeepLinkActivity;
import com.talabat.feature.darkstores.presentation.viewstate.DarkStoreViewState;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkStoresDeepLinkActivity f62914a;

    public /* synthetic */ b(DarkStoresDeepLinkActivity darkStoresDeepLinkActivity) {
        this.f62914a = darkStoresDeepLinkActivity;
    }

    public final void onChanged(Object obj) {
        this.f62914a.onDarkStoresViewStateChange((DarkStoreViewState) obj);
    }
}
