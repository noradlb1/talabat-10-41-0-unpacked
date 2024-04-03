package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class DarkstoresItemsCounterBinding implements ViewBinding {
    @NonNull
    public final AppCompatImageButton btnAdd;
    @NonNull
    public final TextView btnAddToCart;
    @NonNull
    public final AppCompatImageButton btnRemove;
    @NonNull
    public final LinearLayout counterLinearLayout;
    @NonNull
    public final TextView limitError;
    @NonNull
    private final View rootView;
    @NonNull
    public final TextView tvCounter;

    private DarkstoresItemsCounterBinding(@NonNull View view, @NonNull AppCompatImageButton appCompatImageButton, @NonNull TextView textView, @NonNull AppCompatImageButton appCompatImageButton2, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = view;
        this.btnAdd = appCompatImageButton;
        this.btnAddToCart = textView;
        this.btnRemove = appCompatImageButton2;
        this.counterLinearLayout = linearLayout;
        this.limitError = textView2;
        this.tvCounter = textView3;
    }

    @NonNull
    public static DarkstoresItemsCounterBinding bind(@NonNull View view) {
        int i11 = R.id.btnAdd;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i11);
        if (appCompatImageButton != null) {
            i11 = R.id.btnAddToCart;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.btnRemove;
                AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) ViewBindings.findChildViewById(view, i11);
                if (appCompatImageButton2 != null) {
                    i11 = R.id.counterLinearLayout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                    if (linearLayout != null) {
                        i11 = R.id.limit_error;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView2 != null) {
                            i11 = R.id.tvCounter;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView3 != null) {
                                return new DarkstoresItemsCounterBinding(view, appCompatImageButton, textView, appCompatImageButton2, linearLayout, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresItemsCounterBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.darkstores_items_counter, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
