package com.instabug.library.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.instabug.library.R;
import com.instabug.library.core.ui.a;
import com.instabug.library.settings.SettingsManager;

public class AlertDialog extends a implements View.OnClickListener {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public TextView f52113c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public TextView f52114d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public TextView f52115e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public String f52116f;
    @Nullable
    private OnAlertViewsClickListener onAlertViewsClickListener;

    public interface OnAlertViewsClickListener {
        void onPositiveButtonClicked();
    }

    public int K() {
        return R.layout.instabug_alert_dialog;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void L(View view, Bundle bundle) {
        this.f52113c = (TextView) view.findViewById(R.id.tvMessage);
        this.f52114d = (TextView) view.findViewById(R.id.btnYes);
        this.f52115e = (TextView) view.findViewById(R.id.btnNo);
        TextView textView = this.f52114d;
        if (textView != null) {
            textView.setTextColor(SettingsManager.getInstance().getPrimaryColor());
            this.f52114d.setOnClickListener(this);
        }
        TextView textView2 = this.f52115e;
        if (textView2 != null) {
            textView2.setTextColor(SettingsManager.getInstance().getPrimaryColor());
            this.f52115e.setOnClickListener(this);
        }
        if (bundle != null) {
            this.f52116f = bundle.getString("message", this.f52116f);
        }
        TextView textView3 = this.f52113c;
        if (textView3 != null) {
            textView3.setText(this.f52116f);
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public String getMessage() {
        TextView textView = this.f52113c;
        return String.valueOf(textView != null ? textView.getText() : null);
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.btnYes) {
            OnAlertViewsClickListener onAlertViewsClickListener2 = this.onAlertViewsClickListener;
            if (onAlertViewsClickListener2 != null) {
                onAlertViewsClickListener2.onPositiveButtonClicked();
            }
        } else if (id2 == R.id.btnNo) {
            dismiss();
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("message", this.f52116f);
    }

    public void setMessage(String str) {
        TextView textView = this.f52113c;
        if (textView != null) {
            textView.setText(str);
        }
        this.f52116f = str;
    }

    public void setOnAlertViewsClickListener(@Nullable OnAlertViewsClickListener onAlertViewsClickListener2) {
        this.onAlertViewsClickListener = onAlertViewsClickListener2;
    }
}
