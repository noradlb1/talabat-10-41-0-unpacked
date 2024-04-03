package com.instabug.featuresrequest.ui.addcomment;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Patterns;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.instabug.featuresrequest.R;
import com.instabug.featuresrequest.ui.FeaturesRequestActivity;
import com.instabug.featuresrequest.ui.custom.d;
import com.instabug.featuresrequest.ui.custom.x;
import com.instabug.featuresrequest.ui.custom.y;
import com.instabug.featuresrequest.utils.j;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.AttrResolver;
import com.instabug.library.util.KeyboardUtils;
import com.instabug.library.view.ViewUtils;
import lc.a;
import lc.b;
import lc.c;

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class f extends d implements a {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public i f46601d;

    /* renamed from: e  reason: collision with root package name */
    private long f46602e;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public TextInputLayout f46603f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private TextInputLayout f46604g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private TextInputLayout f46605h;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public TextInputEditText f46606i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private TextInputEditText f46607j;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public TextInputEditText f46608k;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    public View f46609l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private View f46610m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private View f46611n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private ProgressDialog f46612o;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public TextView f46613p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private TextView f46614q;

    private void N() {
        TextInputEditText textInputEditText = this.f46606i;
        if (textInputEditText != null) {
            textInputEditText.setOnFocusChangeListener(new a(this));
            TextInputEditText textInputEditText2 = this.f46607j;
            if (textInputEditText2 != null) {
                textInputEditText2.setOnFocusChangeListener(new b(this));
                TextInputEditText textInputEditText3 = this.f46608k;
                if (textInputEditText3 != null) {
                    textInputEditText3.setOnFocusChangeListener(new c(this));
                    textInputEditText3.addTextChangedListener(new d(this));
                    textInputEditText.addTextChangedListener(new e(this, textInputEditText));
                }
            }
        }
    }

    private boolean O() {
        TextInputEditText textInputEditText;
        View view = this.f46609l;
        if (getContext() == null || (textInputEditText = this.f46606i) == null || view == null) {
            return false;
        }
        if (textInputEditText.getText() == null || !TextUtils.isEmpty(this.f46606i.getText().toString())) {
            a(false, this.f46603f, view, (String) null);
            this.f46609l = view;
            return true;
        }
        a(true, this.f46603f, view, getLocalizedString(R.string.feature_request_str_add_comment_comment_empty));
        TextInputLayout textInputLayout = this.f46603f;
        if (textInputLayout != null) {
            textInputLayout.requestFocus();
        }
        view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ib_fr_add_comment_error));
        return false;
    }

    /* access modifiers changed from: private */
    public boolean P() {
        TextInputEditText textInputEditText;
        if (!(this.f46605h == null || this.f46611n == null || (textInputEditText = this.f46608k) == null || textInputEditText.getText() == null)) {
            if (TextUtils.isEmpty(this.f46608k.getText().toString()) || !Patterns.EMAIL_ADDRESS.matcher(this.f46608k.getText().toString()).matches()) {
                a(true, this.f46605h, this.f46611n, getLocalizedString(R.string.feature_request_str_add_comment_valid_email));
                this.f46608k.requestFocus();
            } else {
                a(false, this.f46605h, this.f46611n, (String) null);
                return true;
            }
        }
        return false;
    }

    public static f a(@NonNull long j11) {
        f fVar = new f();
        Bundle bundle = new Bundle();
        bundle.putLong("featureId", j11);
        fVar.setArguments(bundle);
        return fVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view, boolean z11) {
        int i11;
        View view2 = this.f46609l;
        TextInputLayout textInputLayout = this.f46603f;
        if (getContext() != null && view2 != null) {
            if (z11) {
                view2.getLayoutParams().height = ViewUtils.convertDpToPx(getContext(), 2.0f);
                if (textInputLayout == null || !textInputLayout.isErrorEnabled()) {
                    j.b(textInputLayout, SettingsManager.getInstance().getPrimaryColor());
                    i11 = SettingsManager.getInstance().getPrimaryColor();
                } else {
                    Context context = getContext();
                    int i12 = R.color.ib_fr_add_comment_error;
                    j.b(textInputLayout, ContextCompat.getColor(context, i12));
                    i11 = ContextCompat.getColor(getContext(), i12);
                }
                view2.setBackgroundColor(i11);
            } else {
                j.b(textInputLayout, SettingsManager.getInstance().getPrimaryColor());
                view2.setBackgroundColor(AttrResolver.getColor(getContext(), R.attr.ib_fr_add_comment_edit_text_underline_color));
                view2.getLayoutParams().height = ViewUtils.convertDpToPx(getContext(), 1.0f);
            }
            view2.requestLayout();
            this.f46609l = view2;
            this.f46603f = textInputLayout;
        }
    }

    /* access modifiers changed from: private */
    public void a(Boolean bool) {
        TextView textView;
        int i11;
        Resources resources;
        if (this.f46614q != null) {
            if (bool.booleanValue()) {
                this.f46614q.setEnabled(true);
                textView = this.f46614q;
                resources = getResources();
                i11 = 17170443;
            } else {
                this.f46614q.setEnabled(false);
                textView = this.f46614q;
                resources = getResources();
                i11 = 17170432;
            }
            textView.setTextColor(resources.getColor(i11));
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z11, @Nullable TextInputLayout textInputLayout, View view, @Nullable String str) {
        if (getContext() != null && textInputLayout != null) {
            if (z11) {
                textInputLayout.setErrorEnabled(true);
                textInputLayout.setError(str);
                Context context = getContext();
                int i11 = R.color.ib_fr_add_comment_error;
                j.b(textInputLayout, ContextCompat.getColor(context, i11));
                view.setBackgroundColor(ContextCompat.getColor(getContext(), i11));
                return;
            }
            j.b(textInputLayout, SettingsManager.getInstance().getPrimaryColor());
            textInputLayout.setError((CharSequence) null);
            view.setBackgroundColor((textInputLayout.getEditText() == null || !textInputLayout.getEditText().isFocused()) ? AttrResolver.getColor(getContext(), R.attr.ib_fr_add_comment_edit_text_underline_color) : SettingsManager.getInstance().getPrimaryColor());
            textInputLayout.setErrorEnabled(false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view, boolean z11) {
        View view2 = this.f46610m;
        if (getContext() != null && view2 != null) {
            if (z11) {
                view2.getLayoutParams().height = ViewUtils.convertDpToPx(getContext(), 2.0f);
                view2.setBackgroundColor(SettingsManager.getInstance().getPrimaryColor());
            } else {
                view2.setBackgroundColor(AttrResolver.getColor(getContext(), R.attr.ib_fr_add_comment_edit_text_underline_color));
                view2.getLayoutParams().height = ViewUtils.convertDpToPx(getContext(), 1.0f);
            }
            view2.requestLayout();
            this.f46610m = view2;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view, boolean z11) {
        TextInputLayout textInputLayout;
        int i11;
        View view2 = this.f46611n;
        if (getContext() != null && view2 != null && (textInputLayout = this.f46605h) != null && this.f46604g != null) {
            if (z11) {
                view2.getLayoutParams().height = ViewUtils.convertDpToPx(getContext(), 2.0f);
                if (this.f46605h.isErrorEnabled()) {
                    this.f46604g.setErrorEnabled(true);
                    TextInputLayout textInputLayout2 = this.f46605h;
                    Context context = getContext();
                    int i12 = R.color.ib_fr_add_comment_error;
                    j.b(textInputLayout2, ContextCompat.getColor(context, i12));
                    i11 = ContextCompat.getColor(getContext(), i12);
                } else {
                    this.f46604g.setErrorEnabled(false);
                    j.b(this.f46605h, SettingsManager.getInstance().getPrimaryColor());
                    i11 = SettingsManager.getInstance().getPrimaryColor();
                }
                view2.setBackgroundColor(i11);
            } else {
                j.b(textInputLayout, SettingsManager.getInstance().getPrimaryColor());
                view2.setBackgroundColor(AttrResolver.getColor(getContext(), R.attr.ib_fr_add_comment_edit_text_underline_color));
                view2.getLayoutParams().height = ViewUtils.convertDpToPx(getContext(), 1.0f);
            }
            view2.requestLayout();
            this.f46611n = view2;
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void B() {
        ProgressDialog progressDialog = this.f46612o;
        if (progressDialog != null) {
            if (progressDialog.isShowing()) {
                return;
            }
        } else if (getActivity() != null) {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setCancelable(false);
            progressDialog.setMessage(getLocalizedString(R.string.feature_request_str_adding_your_comment));
            ProgressBar progressBar = new ProgressBar(getActivity(), (AttributeSet) null, 16842871);
            progressBar.getIndeterminateDrawable().setColorFilter(SettingsManager.getInstance().getPrimaryColor(), PorterDuff.Mode.MULTIPLY);
            progressDialog.setIndeterminateDrawable(progressBar.getIndeterminateDrawable());
            this.f46612o = progressDialog;
        } else {
            return;
        }
        progressDialog.show();
    }

    public void E() {
        ProgressDialog progressDialog = this.f46612o;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f46612o.dismiss();
        }
    }

    public void G() {
        if (getActivity() != null) {
            Toast.makeText(getActivity(), R.string.feature_request_str_add_comment_error, 1).show();
        }
    }

    public void H() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    public void a(String str) {
        TextInputEditText textInputEditText = this.f46608k;
        if (textInputEditText != null) {
            textInputEditText.setText(str);
        }
    }

    public void a(boolean z11) {
        String str;
        TextInputLayout textInputLayout = this.f46605h;
        if (textInputLayout != null) {
            if (z11) {
                str = getLocalizedString(R.string.ib_email_label) + "*";
            } else {
                str = getLocalizedString(R.string.ib_email_label);
            }
            textInputLayout.setHint((CharSequence) str);
        }
    }

    public void b(String str) {
        TextInputEditText textInputEditText = this.f46607j;
        if (textInputEditText != null) {
            textInputEditText.setText(str);
        }
    }

    public String e() {
        TextInputEditText textInputEditText = this.f46607j;
        return (textInputEditText == null || textInputEditText.getText() == null) ? "" : this.f46607j.getText().toString();
    }

    public void n() {
        if (getActivity() != null && (getActivity() instanceof FeaturesRequestActivity)) {
            ((FeaturesRequestActivity) getActivity()).b();
            getActivity().onBackPressed();
        }
    }

    public int o0() {
        return R.layout.ib_fr_add_comment_fragment;
    }

    public void onClick(View view) {
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f46601d = new i(this);
        if (getArguments() != null) {
            this.f46602e = getArguments().getLong("featureId");
        }
    }

    public void onStop() {
        super.onStop();
        if (getActivity() != null) {
            KeyboardUtils.hide(getActivity());
        }
    }

    public String p0() {
        return getLocalizedString(R.string.feature_request_comments);
    }

    public y q0() {
        return new y(R.drawable.ibg_core_ic_close, R.string.close, new b(this), x.ICON);
    }

    public void r0(View view, @Nullable Bundle bundle) {
        this.f46603f = (TextInputLayout) view.findViewById(R.id.feature_request_comment_text_input_layout);
        this.f46604g = (TextInputLayout) view.findViewById(R.id.feature_request_name_text_input_layout);
        this.f46605h = (TextInputLayout) view.findViewById(R.id.feature_request_email_text_input_layout);
        this.f46606i = (TextInputEditText) view.findViewById(R.id.feature_request_comment_edittext_layout);
        TextInputLayout textInputLayout = this.f46603f;
        if (textInputLayout != null) {
            textInputLayout.setHint((CharSequence) getLocalizedString(R.string.add_feature) + "*");
        }
        this.f46607j = (TextInputEditText) view.findViewById(R.id.feature_request_name_edittext_layout);
        this.f46608k = (TextInputEditText) view.findViewById(R.id.feature_request_email_edittext_layout);
        this.f46609l = view.findViewById(R.id.feature_requests_comment_text_underline);
        this.f46610m = view.findViewById(R.id.feature_requests_name_text_underline);
        this.f46611n = view.findViewById(R.id.feature_requests_email_text_underline);
        this.f46613p = (TextView) view.findViewById(R.id.feature_request_email_disclaimer);
        j.b(this.f46603f, SettingsManager.getInstance().getPrimaryColor());
        j.b(this.f46604g, SettingsManager.getInstance().getPrimaryColor());
        j.b(this.f46605h, SettingsManager.getInstance().getPrimaryColor());
        N();
        this.f46601d.a();
        this.f46601d.d();
        this.f46614q = (TextView) d(R.string.feature_request_str_post_comment);
        a(Boolean.FALSE);
    }

    public String s() {
        TextInputEditText textInputEditText = this.f46608k;
        return (textInputEditText == null || textInputEditText.getText() == null) ? "" : this.f46608k.getText().toString();
    }

    public void u() {
        this.H.add(new y(-1, R.string.feature_request_str_post_comment, new c(this), x.TEXT));
    }

    public void z() {
        TextInputEditText textInputEditText;
        if (O()) {
            if ((!this.f46601d.e() || P()) && (textInputEditText = this.f46606i) != null && this.f46607j != null && this.f46608k != null && textInputEditText.getText() != null && this.f46607j.getText() != null && this.f46608k.getText() != null) {
                this.f46601d.a(new com.instabug.featuresrequest.models.f(this.f46602e, this.f46606i.getText().toString(), this.f46607j.getText().toString(), this.f46608k.getText().toString()));
            }
        }
    }
}
