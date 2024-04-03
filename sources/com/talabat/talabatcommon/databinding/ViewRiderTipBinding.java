package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class ViewRiderTipBinding implements ViewBinding {
    @NonNull
    public final TextView riderTipViewTextView;
    @NonNull
    private final View rootView;

    private ViewRiderTipBinding(@NonNull View view, @NonNull TextView textView) {
        this.rootView = view;
        this.riderTipViewTextView = textView;
    }

    @NonNull
    public static ViewRiderTipBinding bind(@NonNull View view) {
        int i11 = R.id.riderTipViewTextView;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            return new ViewRiderTipBinding(view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewRiderTipBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.view_rider_tip, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
