package z3;

import android.app.Activity;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.IInAppMessageViewWrapper;
import com.braze.ui.inappmessage.listeners.IWebViewClientStateListener;

public final /* synthetic */ class b implements IWebViewClientStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IInAppMessageViewWrapper f44453a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BrazeInAppMessageManager f44454b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f44455c;

    public /* synthetic */ b(IInAppMessageViewWrapper iInAppMessageViewWrapper, BrazeInAppMessageManager brazeInAppMessageManager, Activity activity) {
        this.f44453a = iInAppMessageViewWrapper;
        this.f44454b = brazeInAppMessageManager;
        this.f44455c = activity;
    }

    public final void onPageFinished() {
        BrazeInAppMessageManager.m9207displayInAppMessage$lambda7(this.f44453a, this.f44454b, this.f44455c);
    }
}
