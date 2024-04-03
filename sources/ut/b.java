package ut;

import androidx.lifecycle.Observer;
import com.talabat.riderinfo.presentation.activity.RiderChatDeepLinkActivity;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RiderChatDeepLinkActivity f62955a;

    public /* synthetic */ b(RiderChatDeepLinkActivity riderChatDeepLinkActivity) {
        this.f62955a = riderChatDeepLinkActivity;
    }

    public final void onChanged(Object obj) {
        this.f62955a.onRiderChatErrorStatusChanges(((Boolean) obj).booleanValue());
    }
}
