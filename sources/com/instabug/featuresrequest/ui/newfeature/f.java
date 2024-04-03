package com.instabug.featuresrequest.ui.newfeature;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;
import com.instabug.featuresrequest.settings.a;
import com.instabug.library.util.SimpleTextWatcher;

class f extends SimpleTextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextInputEditText f46804b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TextInputEditText f46805c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g f46806d;

    public f(g gVar, TextInputEditText textInputEditText, TextInputEditText textInputEditText2) {
        this.f46806d = gVar;
        this.f46804b = textInputEditText;
        this.f46805c = textInputEditText2;
    }

    public void afterTextChanged(Editable editable) {
        TextView textView;
        int i11;
        Boolean bool;
        g gVar;
        if (this.f46806d.C != null) {
            if (a.a().f() && !editable.toString().equals(((k) this.f46806d.C).b())) {
                if (this.f46806d.J() != null) {
                    TextInputEditText textInputEditText = this.f46804b;
                    if (!(textInputEditText == null || textInputEditText.getText() == null || this.f46804b.getText().toString().trim().isEmpty())) {
                        gVar = this.f46806d;
                        bool = Boolean.TRUE;
                    }
                } else {
                    gVar = this.f46806d;
                    bool = Boolean.FALSE;
                }
                gVar.a(bool);
            }
            if (this.f46806d.f46820q != null) {
                if (!TextUtils.isEmpty(editable.toString())) {
                    textView = this.f46806d.f46820q;
                    i11 = 8;
                } else {
                    textView = this.f46806d.f46820q;
                    i11 = 0;
                }
                textView.setVisibility(i11);
            }
            TextInputEditText unused = this.f46806d.f46814k = this.f46805c;
        }
    }
}
