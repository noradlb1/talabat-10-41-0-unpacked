package com.instabug.bug.view.reporting;

import android.text.Editable;
import com.instabug.library.util.SimpleTextWatcher;

class u extends SimpleTextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h0 f45913b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ x f45914c;

    public u(x xVar, h0 h0Var) {
        this.f45914c = xVar;
        this.f45913b = h0Var;
    }

    public void afterTextChanged(Editable editable) {
        if (this.f45914c.getActivity() != null && this.f45913b != null && this.f45914c.f45919b != null) {
            this.f45913b.b(this.f45914c.f45919b.getText().toString());
        }
    }
}
