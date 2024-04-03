package com.instabug.featuresrequest.ui.newfeature;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.instabug.featuresrequest.R;
import com.instabug.featuresrequest.ui.FeaturesRequestActivity;
import com.instabug.featuresrequest.ui.custom.d;
import com.instabug.featuresrequest.ui.custom.q;
import com.instabug.featuresrequest.ui.custom.x;
import com.instabug.featuresrequest.ui.custom.y;
import com.instabug.featuresrequest.utils.j;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.AttrResolver;
import com.instabug.library.util.KeyboardUtils;
import com.instabug.library.util.LocaleHelper;
import com.instabug.library.util.PlaceHolderUtils;
import com.instabug.library.view.AlertDialog;
import com.instabug.library.view.ViewUtils;
import pc.a;
import pc.b;
import pc.c;

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class g extends d implements a, AlertDialog.OnAlertViewsClickListener {
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public TextInputLayout f46807d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private TextInputLayout f46808e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private TextInputLayout f46809f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private TextInputLayout f46810g;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public TextInputEditText f46811h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private TextInputEditText f46812i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private TextInputEditText f46813j;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public TextInputEditText f46814k;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    public View f46815l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private View f46816m;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    public View f46817n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private View f46818o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private RelativeLayout f46819p;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    public TextView f46820q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private AlertDialog f46821r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    private TextView f46822s;

    private void O() {
        TextInputEditText textInputEditText = this.f46811h;
        TextInputEditText textInputEditText2 = this.f46814k;
        if (textInputEditText != null) {
            textInputEditText.setOnFocusChangeListener(new b(this));
            textInputEditText.addTextChangedListener(new d(this, textInputEditText, textInputEditText2));
        }
        TextInputEditText textInputEditText3 = this.f46812i;
        if (textInputEditText3 != null) {
            textInputEditText3.setOnFocusChangeListener(new c(this));
        }
        TextInputEditText textInputEditText4 = this.f46813j;
        if (textInputEditText4 != null) {
            textInputEditText4.setOnFocusChangeListener(new e(this));
        }
        if (textInputEditText2 != null) {
            textInputEditText2.setOnFocusChangeListener(new pc.d(this));
            textInputEditText2.addTextChangedListener(new f(this, textInputEditText, textInputEditText2));
        }
    }

    private boolean P() {
        TextInputEditText textInputEditText = this.f46811h;
        if (textInputEditText == null || this.f46812i == null || this.f46813j == null || this.f46814k == null) {
            return false;
        }
        return (textInputEditText.getText() != null && !this.f46811h.getText().toString().isEmpty()) || (this.f46812i.getText() != null && !this.f46812i.getText().toString().isEmpty()) || ((this.f46813j.getText() != null && !this.f46813j.getText().toString().isEmpty()) || (this.f46814k.getText() != null && !this.f46814k.getText().toString().isEmpty()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q() {
        if (getContext() != null) {
            InstabugCustomTextPlaceHolder.Key key = InstabugCustomTextPlaceHolder.Key.FEATURES_REQUEST_ADD_FEATURE_TOAST;
            int i11 = R.string.feature_requests_new_toast_message;
            String placeHolder = PlaceHolderUtils.getPlaceHolder(key, getLocalizedString(i11));
            RelativeLayout relativeLayout = this.f46819p;
            if (placeHolder == null) {
                placeHolder = getLocalizedString(i11);
            }
            q a11 = q.a(relativeLayout, placeHolder, 0);
            a11.e(-1);
            if (LocaleHelper.isRTL(getContext())) {
                a11.a(R.drawable.ibg_core_ic_close, 24.0f);
            } else {
                a11.b(R.drawable.ibg_core_ic_close, 24.0f);
            }
            a11.g(3000);
            View d11 = a11.d();
            d11.setBackgroundColor(getResources().getColor(R.color.ib_fr_new_feature_toast_bg));
            TextView textView = (TextView) d11.findViewById(R.id.snackbar_text);
            if (textView != null) {
                textView.setTextColor(-1);
                a11.g();
            }
        }
    }

    private void R() {
        RelativeLayout relativeLayout = this.G;
        if (relativeLayout != null) {
            relativeLayout.post(new a(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view, boolean z11) {
        View view2;
        TextInputLayout textInputLayout;
        int i11;
        if (getContext() != null && (view2 = this.f46815l) != null && (textInputLayout = this.f46807d) != null) {
            if (z11) {
                view2.getLayoutParams().height = ViewUtils.convertDpToPx(getContext(), 2.0f);
                if (this.f46807d.isErrorEnabled()) {
                    TextInputLayout textInputLayout2 = this.f46807d;
                    Context context = getContext();
                    int i12 = R.color.ib_fr_add_comment_error;
                    j.b(textInputLayout2, ContextCompat.getColor(context, i12));
                    i11 = ContextCompat.getColor(getContext(), i12);
                } else {
                    j.b(this.f46807d, SettingsManager.getInstance().getPrimaryColor());
                    i11 = SettingsManager.getInstance().getPrimaryColor();
                }
                view2.setBackgroundColor(i11);
            } else {
                j.b(textInputLayout, SettingsManager.getInstance().getPrimaryColor());
                view2.setBackgroundColor(AttrResolver.getColor(getContext(), R.attr.ib_fr_add_comment_edit_text_underline_color));
                view2.getLayoutParams().height = ViewUtils.convertDpToPx(getContext(), 1.0f);
            }
            view2.requestLayout();
            this.f46815l = view2;
        }
    }

    /* access modifiers changed from: private */
    public void a(Boolean bool) {
        TextView textView;
        int i11;
        Resources resources;
        if (this.f46822s != null) {
            if (bool.booleanValue()) {
                this.f46822s.setEnabled(true);
                textView = this.f46822s;
                resources = getResources();
                i11 = 17170443;
            } else {
                this.f46822s.setEnabled(false);
                textView = this.f46822s;
                resources = getResources();
                i11 = 17170432;
            }
            textView.setTextColor(resources.getColor(i11));
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z11, @Nullable TextInputLayout textInputLayout, @Nullable View view, @Nullable String str) {
        if (getContext() != null && textInputLayout != null && view != null) {
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
        View view2;
        int i11;
        if (getContext() != null && (view2 = this.f46816m) != null) {
            if (z11) {
                view2.getLayoutParams().height = ViewUtils.convertDpToPx(getContext(), 2.0f);
                TextInputLayout textInputLayout = this.f46808e;
                if (textInputLayout == null || !textInputLayout.isErrorEnabled()) {
                    j.b(this.f46807d, SettingsManager.getInstance().getPrimaryColor());
                    i11 = SettingsManager.getInstance().getPrimaryColor();
                } else {
                    TextInputLayout textInputLayout2 = this.f46807d;
                    Context context = getContext();
                    int i12 = R.color.ib_fr_add_comment_error;
                    j.b(textInputLayout2, ContextCompat.getColor(context, i12));
                    i11 = ContextCompat.getColor(getContext(), i12);
                }
                view2.setBackgroundColor(i11);
            } else {
                j.b(this.f46807d, SettingsManager.getInstance().getPrimaryColor());
                view2.setBackgroundColor(AttrResolver.getColor(getContext(), R.attr.ib_fr_add_comment_edit_text_underline_color));
                view2.getLayoutParams().height = ViewUtils.convertDpToPx(getContext(), 1.0f);
            }
            view2.requestLayout();
            this.f46816m = view2;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view, boolean z11) {
        View view2;
        int i11;
        if (getContext() != null && (view2 = this.f46818o) != null) {
            if (z11) {
                view2.getLayoutParams().height = ViewUtils.convertDpToPx(getContext(), 2.0f);
                TextInputLayout textInputLayout = this.f46810g;
                if (textInputLayout == null || !textInputLayout.isErrorEnabled()) {
                    TextInputLayout textInputLayout2 = this.f46809f;
                    if (textInputLayout2 != null) {
                        textInputLayout2.setErrorEnabled(false);
                    }
                    j.b(this.f46810g, SettingsManager.getInstance().getPrimaryColor());
                    i11 = SettingsManager.getInstance().getPrimaryColor();
                } else {
                    TextInputLayout textInputLayout3 = this.f46809f;
                    if (textInputLayout3 != null) {
                        textInputLayout3.setErrorEnabled(true);
                    }
                    TextInputLayout textInputLayout4 = this.f46810g;
                    Context context = getContext();
                    int i12 = R.color.ib_fr_add_comment_error;
                    j.b(textInputLayout4, ContextCompat.getColor(context, i12));
                    i11 = ContextCompat.getColor(getContext(), i12);
                }
                view2.setBackgroundColor(i11);
            } else {
                j.b(this.f46810g, SettingsManager.getInstance().getPrimaryColor());
                view2.setBackgroundColor(AttrResolver.getColor(getContext(), R.attr.ib_fr_add_comment_edit_text_underline_color));
                view2.getLayoutParams().height = ViewUtils.convertDpToPx(getContext(), 1.0f);
            }
            view2.requestLayout();
            this.f46818o = view2;
        }
    }

    public void C() {
        if (getActivity() != null) {
            ((FeaturesRequestActivity) getActivity()).d();
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @Nullable
    public String J() {
        TextInputEditText textInputEditText = this.f46814k;
        if (!(textInputEditText == null || this.f46810g == null || this.f46818o == null)) {
            if (textInputEditText.getText() == null || this.f46814k.getText().toString().trim().isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(this.f46814k.getText().toString()).matches()) {
                a(true, this.f46810g, this.f46818o, getLocalizedString(R.string.feature_request_str_add_comment_valid_email));
                this.f46814k.requestFocus();
            } else {
                this.f46814k.setError((CharSequence) null);
                a(false, this.f46810g, this.f46818o, (String) null);
                return this.f46814k.getText().toString();
            }
        }
        return null;
    }

    public void N() {
        if (P()) {
            S();
        } else if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    public void S() {
        AlertDialog alertDialog = this.f46821r;
        if (alertDialog != null && getActivity() != null && getFragmentManager() != null) {
            alertDialog.show(getActivity().getFragmentManager(), "alert");
            this.f46821r = alertDialog;
        }
    }

    public void a(String str) {
        TextInputEditText textInputEditText = this.f46814k;
        if (textInputEditText != null) {
            textInputEditText.setText(str);
        }
    }

    public void a(boolean z11) {
        String str;
        TextInputLayout textInputLayout = this.f46810g;
        if (textInputLayout != null) {
            if (z11) {
                str = getLocalizedString(R.string.ib_email_label) + "*";
            } else {
                str = getLocalizedString(R.string.ib_email_label);
            }
            textInputLayout.setHint((CharSequence) str);
        }
    }

    public void b(@StringRes int i11) {
    }

    public void b(String str) {
        TextInputEditText textInputEditText = this.f46813j;
        if (textInputEditText != null) {
            textInputEditText.setText(str);
        }
    }

    @Nullable
    public String c() {
        TextInputEditText textInputEditText = this.f46811h;
        if (!(textInputEditText == null || this.f46815l == null)) {
            if (textInputEditText.getText() == null || this.f46811h.getText().toString().trim().isEmpty()) {
                a(true, this.f46807d, this.f46815l, getLocalizedString(R.string.feature_requests_new_err_msg_required));
                this.f46811h.requestFocus();
            } else {
                a(false, this.f46807d, this.f46815l, (String) null);
                return this.f46811h.getText().toString();
            }
        }
        return null;
    }

    public String g() {
        TextInputEditText textInputEditText = this.f46813j;
        return (textInputEditText == null || textInputEditText.getText() == null) ? "" : this.f46813j.getText().toString();
    }

    public int o0() {
        return R.layout.ib_fr_new_feature_fragment;
    }

    public void onClick(View view) {
    }

    public void onPositiveButtonClicked() {
        AlertDialog alertDialog = this.f46821r;
        if (alertDialog != null && getActivity() != null) {
            getActivity().onBackPressed();
            alertDialog.dismiss();
            this.f46821r = alertDialog;
        }
    }

    public void onStop() {
        super.onStop();
        if (getActivity() != null) {
            KeyboardUtils.hide(getActivity());
        }
    }

    public void p() {
        if (getActivity() != null) {
            ((FeaturesRequestActivity) getActivity()).c();
        }
    }

    public String p0() {
        return getLocalizedString(R.string.feature_requests_new_appbar_title);
    }

    public String q() {
        TextInputEditText textInputEditText = this.f46812i;
        return (textInputEditText == null || textInputEditText.getText() == null) ? "" : this.f46812i.getText().toString();
    }

    public y q0() {
        return new y(R.drawable.ibg_core_ic_close, R.string.close, new b(this), x.ICON);
    }

    public void r() {
        if (getActivity() != null) {
            ((FeaturesRequestActivity) getActivity()).a();
        }
    }

    public void r0(View view, @Nullable Bundle bundle) {
        AlertDialog alertDialog = this.f46821r;
        if (alertDialog == null) {
            alertDialog = new AlertDialog();
            alertDialog.setMessage(getLocalizedString(R.string.feature_request_close_dialog_message));
            alertDialog.setOnAlertViewsClickListener(this);
        }
        this.f46821r = alertDialog;
        this.f46819p = (RelativeLayout) view.findViewById(R.id.relativeLayout_new_feature);
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.input_layout_title);
        this.f46807d = textInputLayout;
        if (textInputLayout != null) {
            textInputLayout.setHint((CharSequence) getLocalizedString(R.string.feature_requests_new_title) + "*");
        }
        this.f46808e = (TextInputLayout) view.findViewById(R.id.input_layout_description);
        this.f46809f = (TextInputLayout) view.findViewById(R.id.name_text_input_layout);
        TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R.id.email_text_input_layout);
        this.f46810g = textInputLayout2;
        if (textInputLayout2 != null) {
            textInputLayout2.setHint((CharSequence) getLocalizedString(R.string.ib_email_label) + "*");
        }
        this.f46811h = (TextInputEditText) view.findViewById(R.id.input_title);
        this.f46812i = (TextInputEditText) view.findViewById(R.id.input_description);
        this.f46813j = (TextInputEditText) view.findViewById(R.id.input_name);
        this.f46814k = (TextInputEditText) view.findViewById(R.id.input_email);
        this.f46815l = view.findViewById(R.id.title_underline);
        this.f46816m = view.findViewById(R.id.description_underline);
        this.f46817n = view.findViewById(R.id.name_underline);
        this.f46818o = view.findViewById(R.id.email_underline);
        this.f46820q = (TextView) view.findViewById(R.id.txtBottomHint);
        j.b(this.f46807d, SettingsManager.getInstance().getPrimaryColor());
        j.b(this.f46808e, SettingsManager.getInstance().getPrimaryColor());
        j.b(this.f46809f, SettingsManager.getInstance().getPrimaryColor());
        j.b(this.f46810g, SettingsManager.getInstance().getPrimaryColor());
        k kVar = new k(this);
        O();
        if (bundle == null) {
            R();
        }
        this.f46822s = (TextView) d(R.string.feature_requests_new_positive_button);
        a(Boolean.FALSE);
        kVar.d();
        this.C = kVar;
    }

    public void u() {
        this.H.add(new y(R.drawable.ibg_fr_shape_add_feat_button, R.string.feature_requests_new_positive_button, new c(this), x.TEXT));
    }

    public String y() {
        TextInputEditText textInputEditText = this.f46814k;
        return (textInputEditText == null || textInputEditText.getText() == null) ? "" : this.f46814k.getText().toString();
    }
}
