package tl;

import androidx.lifecycle.Observer;
import com.talabat.feature.darkstores.presentation.activity.DarkStoresDeepLinkActivity;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkStoresDeepLinkActivity f62915a;

    public /* synthetic */ c(DarkStoresDeepLinkActivity darkStoresDeepLinkActivity) {
        this.f62915a = darkStoresDeepLinkActivity;
    }

    public final void onChanged(Object obj) {
        this.f62915a.onDarkStoresErrorStatusChange(((Boolean) obj).booleanValue());
    }
}
