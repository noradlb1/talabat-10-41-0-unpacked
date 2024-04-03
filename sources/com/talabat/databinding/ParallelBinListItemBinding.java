package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class ParallelBinListItemBinding implements ViewBinding {
    @NonNull
    public final ImageView binImage;
    @NonNull
    public final ProgressBar binImageProgressbar;
    @NonNull
    public final TalabatTextView binText;
    @NonNull
    public final RelativeLayout imageSection;
    @NonNull
    private final CardView rootView;

    private ParallelBinListItemBinding(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull ProgressBar progressBar, @NonNull TalabatTextView talabatTextView, @NonNull RelativeLayout relativeLayout) {
        this.rootView = cardView;
        this.binImage = imageView;
        this.binImageProgressbar = progressBar;
        this.binText = talabatTextView;
        this.imageSection = relativeLayout;
    }

    @NonNull
    public static ParallelBinListItemBinding bind(@NonNull View view) {
        int i11 = R.id.bin_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.bin_image);
        if (imageView != null) {
            i11 = R.id.bin_image_progressbar;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.bin_image_progressbar);
            if (progressBar != null) {
                i11 = R.id.bin_text;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.bin_text);
                if (talabatTextView != null) {
                    i11 = R.id.image_section;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.image_section);
                    if (relativeLayout != null) {
                        return new ParallelBinListItemBinding((CardView) view, imageView, progressBar, talabatTextView, relativeLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ParallelBinListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ParallelBinListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.parallel_bin_list_item, viewGroup, false);
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
