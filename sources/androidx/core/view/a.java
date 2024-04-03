package androidx.core.view;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f11533b;

    public /* synthetic */ a(View view) {
        this.f11533b = view;
    }

    public final void run() {
        ((InputMethodManager) this.f11533b.getContext().getSystemService("input_method")).showSoftInput(this.f11533b, 0);
    }
}
