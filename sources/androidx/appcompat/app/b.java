package androidx.appcompat.app;

import android.view.KeyEvent;
import androidx.core.view.KeyEventDispatcher;

public final /* synthetic */ class b implements KeyEventDispatcher.Component {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppCompatDialog f641b;

    public /* synthetic */ b(AppCompatDialog appCompatDialog) {
        this.f641b = appCompatDialog;
    }

    public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return this.f641b.superDispatchKeyEvent(keyEvent);
    }
}
