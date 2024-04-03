package ut;

import androidx.lifecycle.Observer;
import com.talabat.riderinfo.presentation.activity.RiderChatDeepLinkActivity;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RiderChatDeepLinkActivity f62954a;

    public /* synthetic */ a(RiderChatDeepLinkActivity riderChatDeepLinkActivity) {
        this.f62954a = riderChatDeepLinkActivity;
    }

    public final void onChanged(Object obj) {
        this.f62954a.onProgressBarStatusChanges(((Boolean) obj).booleanValue());
    }
}
