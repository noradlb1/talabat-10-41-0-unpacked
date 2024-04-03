package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class DarkstoresCartSpecialRequestBinding implements ViewBinding {
    @NonNull
    public final AppCompatEditText editCartSpeicalComment;
    @NonNull
    public final ImageView iconComment;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final CardView specialRequestView;
    @NonNull
    public final TextView specialTitle;

    private DarkstoresCartSpecialRequestBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatEditText appCompatEditText, @NonNull ImageView imageView, @NonNull CardView cardView, @NonNull TextView textView) {
        this.rootView = constraintLayout;
        this.editCartSpeicalComment = appCompatEditText;
        this.iconComment = imageView;
        this.specialRequestView = cardView;
        this.specialTitle = textView;
    }

    @NonNull
    public static DarkstoresCartSpecialRequestBinding bind(@NonNull View view) {
        int i11 = R.id.edit_cart_speical_comment;
        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, i11);
        if (appCompatEditText != null) {
            i11 = R.id.icon_comment;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                i11 = R.id.special_request_view;
                CardView cardView = (CardView) ViewBindings.findChildViewById(view, i11);
                if (cardView != null) {
                    i11 = R.id.special_title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView != null) {
                        return new DarkstoresCartSpecialRequestBinding((ConstraintLayout) view, appCompatEditText, imageView, cardView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresCartSpecialRequestBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresCartSpecialRequestBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_cart_special_request, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
