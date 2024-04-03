package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class DarkstoresBottomCartViewBinding implements ViewBinding {
    @NonNull
    public final TextView bottomCartViewCount;
    @NonNull
    public final ProgressBar bottomCartViewProgress;
    @NonNull
    public final TextView bottomCartViewTotal;
    @NonNull
    private final View rootView;

    private DarkstoresBottomCartViewBinding(@NonNull View view, @NonNull TextView textView, @NonNull ProgressBar progressBar, @NonNull TextView textView2) {
        this.rootView = view;
        this.bottomCartViewCount = textView;
        this.bottomCartViewProgress = progressBar;
        this.bottomCartViewTotal = textView2;
    }

    @NonNull
    public static DarkstoresBottomCartViewBinding bind(@NonNull View view) {
        int i11 = R.id.bottom_cart_view_count;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.bottom_cart_view_progress;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i11);
            if (progressBar != null) {
                i11 = R.id.bottom_cart_view_total;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    return new DarkstoresBottomCartViewBinding(view, textView, progressBar, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresBottomCartViewBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.darkstores_bottom_cart_view, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
