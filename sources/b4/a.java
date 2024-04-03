package b4;

import com.braze.BrazeUser;
import com.braze.events.IValueCallback;
import com.braze.ui.inappmessage.jsinterface.InAppMessageUserJavascriptInterface;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements IValueCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f38212a;

    public /* synthetic */ a(Function1 function1) {
        this.f38212a = function1;
    }

    public /* synthetic */ void onError() {
        s3.a.a(this);
    }

    public final void onSuccess(Object obj) {
        InAppMessageUserJavascriptInterface.Companion.m9217runOnUser$lambda0(this.f38212a, (BrazeUser) obj);
    }
}
