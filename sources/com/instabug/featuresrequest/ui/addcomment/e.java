package com.instabug.featuresrequest.ui.addcomment;

import android.text.Editable;
import android.util.Patterns;
import android.view.View;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.instabug.featuresrequest.R;
import com.instabug.library.util.SimpleTextWatcher;

class e extends SimpleTextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextInputEditText f46599b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ f f46600c;

    public e(f fVar, TextInputEditText textInputEditText) {
        this.f46600c = fVar;
        this.f46599b = textInputEditText;
    }

    public void afterTextChanged(Editable editable) {
        f fVar;
        Boolean bool;
        super.afterTextChanged(editable);
        View F0 = this.f46600c.f46609l;
        TextInputEditText G0 = this.f46600c.f46608k;
        TextInputLayout H0 = this.f46600c.f46603f;
        if (F0 != null) {
            boolean z11 = true;
            if (this.f46599b.getText() == null || !this.f46599b.getText().toString().trim().isEmpty()) {
                f fVar2 = this.f46600c;
                fVar2.a(false, H0, F0, fVar2.getLocalizedString(R.string.feature_request_str_add_comment_comment_empty));
                if (G0 == null || !this.f46600c.f46601d.e()) {
                    fVar = this.f46600c;
                    bool = Boolean.TRUE;
                } else {
                    Editable text = G0.getText();
                    f fVar3 = this.f46600c;
                    if (text == null || text.toString().trim().isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(text.toString()).matches()) {
                        z11 = false;
                    }
                    fVar3.a(Boolean.valueOf(z11));
                    TextInputEditText unused = this.f46600c.f46608k = G0;
                    TextInputLayout unused2 = this.f46600c.f46603f = H0;
                }
            } else {
                f fVar4 = this.f46600c;
                fVar4.a(true, H0, F0, fVar4.getLocalizedString(R.string.feature_request_str_add_comment_comment_empty));
                fVar = this.f46600c;
                bool = Boolean.FALSE;
            }
            fVar.a(bool);
            TextInputEditText unused3 = this.f46600c.f46608k = G0;
            TextInputLayout unused4 = this.f46600c.f46603f = H0;
        }
    }
}
