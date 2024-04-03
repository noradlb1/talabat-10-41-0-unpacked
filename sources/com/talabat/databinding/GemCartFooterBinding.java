package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class GemCartFooterBinding implements ViewBinding {
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final ImageView sandTimer;
    @NonNull
    public final TalabatTextView timerTextGem;

    private GemCartFooterBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView) {
        this.rootView = relativeLayout;
        this.sandTimer = imageView;
        this.timerTextGem = talabatTextView;
    }

    @NonNull
    public static GemCartFooterBinding bind(@NonNull View view) {
        int i11 = R.id.sand_timer;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.sand_timer);
        if (imageView != null) {
            i11 = R.id.timer_text_gem;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.timer_text_gem);
            if (talabatTextView != null) {
                return new GemCartFooterBinding((RelativeLayout) view, imageView, talabatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static GemCartFooterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static GemCartFooterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.gem_cart_footer, viewGroup, false);
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
