package tl;

import androidx.lifecycle.Observer;
import com.talabat.feature.darkstores.presentation.activity.DarkStoresDeepLinkActivity;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkStoresDeepLinkActivity f62913a;

    public /* synthetic */ a(DarkStoresDeepLinkActivity darkStoresDeepLinkActivity) {
        this.f62913a = darkStoresDeepLinkActivity;
    }

    public final void onChanged(Object obj) {
        this.f62913a.onValidVendor(((Boolean) obj).booleanValue());
    }
}
