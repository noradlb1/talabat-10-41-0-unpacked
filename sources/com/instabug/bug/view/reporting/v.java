package com.instabug.bug.view.reporting;

import android.text.Editable;
import com.instabug.library.util.SimpleTextWatcher;

class v extends SimpleTextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x f45915b;

    public v(x xVar) {
        this.f45915b = xVar;
    }

    public void afterTextChanged(Editable editable) {
        if (this.f45915b.f45918a != null) {
            String obj = this.f45915b.f45918a.getText().toString();
            if (this.f45915b.C != null) {
                ((h0) this.f45915b.C).a(obj);
            }
        }
    }
}
