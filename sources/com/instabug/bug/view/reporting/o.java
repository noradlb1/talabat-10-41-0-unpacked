package com.instabug.bug.view.reporting;

import android.text.Editable;
import android.text.TextWatcher;

class o implements TextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x f45907b;

    public o(x xVar) {
        this.f45907b = xVar;
    }

    public void afterTextChanged(Editable editable) {
        if (this.f45907b.C != null && editable != null) {
            ((h0) this.f45907b.C).c(editable.toString());
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }
}
