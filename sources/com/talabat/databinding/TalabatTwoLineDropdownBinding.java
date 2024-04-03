package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class TalabatTwoLineDropdownBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView description;
    @NonNull

    /* renamed from: name  reason: collision with root package name */
    public final TalabatTextView f58220name;
    @NonNull
    public final ImageView placesImage;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final LinearLayout textLayout;

    private TalabatTwoLineDropdownBinding(@NonNull CardView cardView, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout) {
        this.rootView = cardView;
        this.description = talabatTextView;
        this.f58220name = talabatTextView2;
        this.placesImage = imageView;
        this.textLayout = linearLayout;
    }

    @NonNull
    public static TalabatTwoLineDropdownBinding bind(@NonNull View view) {
        int i11 = R.id.description;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.description);
        if (talabatTextView != null) {
            i11 = R.id.f54872name;
            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.f54872name);
            if (talabatTextView2 != null) {
                i11 = R.id.places_image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.places_image);
                if (imageView != null) {
                    i11 = R.id.text_layout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.text_layout);
                    if (linearLayout != null) {
                        return new TalabatTwoLineDropdownBinding((CardView) view, talabatTextView, talabatTextView2, imageView, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static TalabatTwoLineDropdownBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static TalabatTwoLineDropdownBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.talabat_two_line_dropdown, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public CardView getRoot() {
        return this.rootView;
    }
}
