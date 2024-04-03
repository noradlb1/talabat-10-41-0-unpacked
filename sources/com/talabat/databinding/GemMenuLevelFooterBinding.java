package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatStrokeButton;

public final class GemMenuLevelFooterBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView addmoreItemGem;
    @NonNull
    public final TalabatStrokeButton goToViewCart;
    @NonNull
    public final LinearLayout mainView;
    @NonNull
    public final TalabatTextView newPriceGem;
    @NonNull
    public final LinearLayout offerBg;
    @NonNull
    public final TalabatTextView oldPriceGem;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final ImageView sandTimer;
    @NonNull
    public final TalabatTextView timerTextGem;

    private GemMenuLevelFooterBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatTextView talabatTextView, @NonNull TalabatStrokeButton talabatStrokeButton, @NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView2, @NonNull LinearLayout linearLayout2, @NonNull TalabatTextView talabatTextView3, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView4) {
        this.rootView = relativeLayout;
        this.addmoreItemGem = talabatTextView;
        this.goToViewCart = talabatStrokeButton;
        this.mainView = linearLayout;
        this.newPriceGem = talabatTextView2;
        this.offerBg = linearLayout2;
        this.oldPriceGem = talabatTextView3;
        this.sandTimer = imageView;
        this.timerTextGem = talabatTextView4;
    }

    @NonNull
    public static GemMenuLevelFooterBinding bind(@NonNull View view) {
        int i11 = R.id.addmore_item_gem;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.addmore_item_gem);
        if (talabatTextView != null) {
            i11 = R.id.go_to_view_cart;
            TalabatStrokeButton talabatStrokeButton = (TalabatStrokeButton) ViewBindings.findChildViewById(view, R.id.go_to_view_cart);
            if (talabatStrokeButton != null) {
                i11 = R.id.main_view;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.main_view);
                if (linearLayout != null) {
                    i11 = R.id.new_price_gem;
                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.new_price_gem);
                    if (talabatTextView2 != null) {
                        i11 = R.id.offer_bg;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.offer_bg);
                        if (linearLayout2 != null) {
                            i11 = R.id.old_price_gem;
                            TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.old_price_gem);
                            if (talabatTextView3 != null) {
                                i11 = R.id.sand_timer;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.sand_timer);
                                if (imageView != null) {
                                    i11 = R.id.timer_text_gem;
                                    TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.timer_text_gem);
                                    if (talabatTextView4 != null) {
                                        return new GemMenuLevelFooterBinding((RelativeLayout) view, talabatTextView, talabatStrokeButton, linearLayout, talabatTextView2, linearLayout2, talabatTextView3, imageView, talabatTextView4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static GemMenuLevelFooterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static GemMenuLevelFooterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.gem_menu_level_footer, viewGroup, false);
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
