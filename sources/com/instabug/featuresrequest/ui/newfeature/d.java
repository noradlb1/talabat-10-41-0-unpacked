package com.instabug.featuresrequest.ui.newfeature;

import android.text.Editable;
import android.util.Patterns;
import com.google.android.material.textfield.TextInputEditText;
import com.instabug.featuresrequest.R;
import com.instabug.featuresrequest.settings.a;
import com.instabug.library.util.SimpleTextWatcher;

class d extends SimpleTextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextInputEditText f46800b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TextInputEditText f46801c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g f46802d;

    public d(g gVar, TextInputEditText textInputEditText, TextInputEditText textInputEditText2) {
        this.f46802d = gVar;
        this.f46800b = textInputEditText;
        this.f46801c = textInputEditText2;
    }

    public void afterTextChanged(Editable editable) {
        g gVar;
        Boolean bool;
        super.afterTextChanged(editable);
        TextInputEditText textInputEditText = this.f46800b;
        if (textInputEditText != null) {
            boolean z11 = true;
            if (textInputEditText.getText() == null || !this.f46800b.getText().toString().trim().isEmpty()) {
                g gVar2 = this.f46802d;
                gVar2.a(false, gVar2.f46807d, this.f46802d.f46815l, this.f46802d.getLocalizedString(R.string.feature_requests_new_err_msg_required));
                if (a.a().f()) {
                    TextInputEditText textInputEditText2 = this.f46801c;
                    if (textInputEditText2 != null) {
                        g gVar3 = this.f46802d;
                        if (textInputEditText2.getText() == null || this.f46801c.getText().toString().trim().isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(this.f46801c.getText().toString()).matches()) {
                            z11 = false;
                        }
                        gVar3.a(Boolean.valueOf(z11));
                    }
                } else {
                    gVar = this.f46802d;
                    bool = Boolean.TRUE;
                }
            } else {
                g gVar4 = this.f46802d;
                gVar4.a(true, gVar4.f46807d, this.f46802d.f46815l, this.f46802d.getLocalizedString(R.string.feature_requests_new_err_msg_required));
                gVar = this.f46802d;
                bool = Boolean.FALSE;
            }
            gVar.a(bool);
        }
        TextInputEditText unused = this.f46802d.f46811h = this.f46800b;
    }
}
