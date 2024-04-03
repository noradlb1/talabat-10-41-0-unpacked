package nx;

import androidx.lifecycle.Observer;
import com.talabat.verticals.ui.customViewLCAware.VerticalsLauncherView;
import com.talabat.verticals.ui.customViewLCAware.model.VerticalsViewState;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VerticalsLauncherView f24013a;

    public /* synthetic */ a(VerticalsLauncherView verticalsLauncherView) {
        this.f24013a = verticalsLauncherView;
    }

    public final void onChanged(Object obj) {
        VerticalsLauncherView.m5937observatory$lambda5(this.f24013a, (VerticalsViewState) obj);
    }
}
