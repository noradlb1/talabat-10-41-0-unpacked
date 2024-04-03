package s1;

import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.ViewCompat;

public final /* synthetic */ class r1 implements View.OnUnhandledKeyEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewCompat.OnUnhandledKeyEventListenerCompat f11616a;

    public /* synthetic */ r1(ViewCompat.OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        this.f11616a = onUnhandledKeyEventListenerCompat;
    }

    public final boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
        return this.f11616a.onUnhandledKeyEvent(view, keyEvent);
    }
}
