package nx;

import androidx.lifecycle.Observer;
import com.talabat.verticals.ui.customViewLCAware.VerticalsLauncherView;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VerticalsLauncherView f24014a;

    public /* synthetic */ b(VerticalsLauncherView verticalsLauncherView) {
        this.f24014a = verticalsLauncherView;
    }

    public final void onChanged(Object obj) {
        VerticalsLauncherView.m5938observatory$lambda6(this.f24014a, (Boolean) obj);
    }
}
