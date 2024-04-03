package com.instabug.bug.view.extrafields;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.instabug.bug.R;
import com.instabug.library.util.AttrResolver;

class e extends RecyclerView.ViewHolder {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private EditText f45836a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private TextView f45837b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private View f45838c;

    public e(View view) {
        super(view);
        if (view instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) view;
            for (int i11 = 0; i11 < linearLayout.getChildCount(); i11++) {
                View childAt = linearLayout.getChildAt(i11);
                if (childAt instanceof EditText) {
                    this.f45836a = (EditText) childAt;
                } else if (childAt instanceof TextView) {
                    this.f45837b = (TextView) childAt;
                } else {
                    this.f45838c = childAt;
                }
            }
        }
    }

    @Nullable
    public EditText a() {
        return this.f45836a;
    }

    public void a(String str) {
        TextView textView = this.f45837b;
        if (textView != null && this.f45838c != null) {
            textView.setText(str);
            this.f45838c.setBackgroundColor(ContextCompat.getColor(this.itemView.getContext(), R.color.instabug_extrafield_error));
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void b() {
        TextView textView = this.f45837b;
        if (textView != null && this.f45838c != null) {
            textView.setText((CharSequence) null);
            this.f45838c.setBackgroundColor(AttrResolver.resolveAttributeColor(this.itemView.getContext(), R.attr.ibg_bug_vus_separator_color));
        }
    }
}
