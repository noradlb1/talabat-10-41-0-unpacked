package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class OffersListBottomsheetItemBinding implements ViewBinding {
    @NonNull
    public final LinearLayout imageHeaderLayout;
    @NonNull
    public final TextView offersDescription;
    @NonNull
    public final ImageView offersImage;
    @NonNull
    public final ProgressBar offersImageProgress;
    @NonNull
    public final RelativeLayout offersImageView;
    @NonNull
    public final TalabatTextView offersName;
    @NonNull
    private final RelativeLayout rootView;

    private OffersListBottomsheetItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ProgressBar progressBar, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatTextView talabatTextView) {
        this.rootView = relativeLayout;
        this.imageHeaderLayout = linearLayout;
        this.offersDescription = textView;
        this.offersImage = imageView;
        this.offersImageProgress = progressBar;
        this.offersImageView = relativeLayout2;
        this.offersName = talabatTextView;
    }

    @NonNull
    public static OffersListBottomsheetItemBinding bind(@NonNull View view) {
        int i11 = R.id.image_header_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.image_header_layout);
        if (linearLayout != null) {
            i11 = R.id.offers_description;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.offers_description);
            if (textView != null) {
                i11 = R.id.offers_image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.offers_image);
                if (imageView != null) {
                    i11 = R.id.offers_image_progress;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.offers_image_progress);
                    if (progressBar != null) {
                        i11 = R.id.offers_image_view;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.offers_image_view);
                        if (relativeLayout != null) {
                            i11 = R.id.offers_name;
                            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.offers_name);
                            if (talabatTextView != null) {
                                return new OffersListBottomsheetItemBinding((RelativeLayout) view, linearLayout, textView, imageView, progressBar, relativeLayout, talabatTextView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static OffersListBottomsheetItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static OffersListBottomsheetItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.offers_list_bottomsheet_item, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
