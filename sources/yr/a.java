package yr;

import androidx.lifecycle.Observer;
import com.talabat.helpcenter.presentation.viewState.GlobalHelpCenterViewState;
import com.talabat.helpcenter.presentation.webview.GlobalHelpCenterWebViewActivity;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GlobalHelpCenterWebViewActivity f63074a;

    public /* synthetic */ a(GlobalHelpCenterWebViewActivity globalHelpCenterWebViewActivity) {
        this.f63074a = globalHelpCenterWebViewActivity;
    }

    public final void onChanged(Object obj) {
        this.f63074a.observeGlobalHelpCenterUrlChanges((GlobalHelpCenterViewState) obj);
    }
}
