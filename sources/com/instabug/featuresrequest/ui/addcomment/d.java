package com.instabug.featuresrequest.ui.addcomment;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;
import com.instabug.library.util.SimpleTextWatcher;

class d extends SimpleTextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f46598b;

    public d(f fVar) {
        this.f46598b = fVar;
    }

    public void afterTextChanged(Editable editable) {
        TextView textView;
        int i11;
        Boolean bool;
        f fVar;
        if (this.f46598b.f46601d != null) {
            TextInputEditText B0 = this.f46598b.f46606i;
            if (this.f46598b.f46601d.e() && !editable.toString().equals(this.f46598b.f46601d.b())) {
                if (!this.f46598b.P()) {
                    fVar = this.f46598b;
                    bool = Boolean.FALSE;
                } else if (!(B0 == null || B0.getText() == null || B0.getText().toString().trim().isEmpty())) {
                    fVar = this.f46598b;
                    bool = Boolean.TRUE;
                }
                fVar.a(bool);
            }
            if (this.f46598b.f46613p != null) {
                if (!TextUtils.isEmpty(editable.toString())) {
                    textView = this.f46598b.f46613p;
                    i11 = 8;
                } else {
                    textView = this.f46598b.f46613p;
                    i11 = 0;
                }
                textView.setVisibility(i11);
            }
        }
    }
}
