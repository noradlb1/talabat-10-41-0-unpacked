package z3;

import android.view.ViewGroup;
import com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper;
import com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper$open$2;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultInAppMessageViewWrapper f44461b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f44462c;

    public /* synthetic */ i(DefaultInAppMessageViewWrapper defaultInAppMessageViewWrapper, ViewGroup viewGroup) {
        this.f44461b = defaultInAppMessageViewWrapper;
        this.f44462c = viewGroup;
    }

    public final void run() {
        DefaultInAppMessageViewWrapper$open$2.m9214onLayoutChange$lambda0(this.f44461b, this.f44462c);
    }
}
