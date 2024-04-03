package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_stepper.DSCollapsibleQuantityStepper;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.lists.adapters.compact.CompactSwimlaneItemButton;

public final class CompactSwimlaneItemBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout compactSwimlaneCampaign;
    @NonNull
    public final DSCollapsibleQuantityStepper compactSwimlaneCounter;
    @NonNull
    public final CompactSwimlaneItemButton compactSwimlaneItemButton;
    @NonNull
    public final ImageView compactSwimlaneItemImage;
    @NonNull
    public final TextView compactSwimlaneName;
    @NonNull
    public final TextView compactSwimlaneOldPrice;
    @NonNull
    public final TextView compactSwimlaneOutOfStock;
    @NonNull
    public final TextView compactSwimlanePrice;
    @NonNull
    public final AppCompatImageView iconPromo;
    @NonNull
    public final TextView promoTitle;
    @NonNull
    private final ConstraintLayout rootView;

    private CompactSwimlaneItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull RelativeLayout relativeLayout, @NonNull DSCollapsibleQuantityStepper dSCollapsibleQuantityStepper, @NonNull CompactSwimlaneItemButton compactSwimlaneItemButton2, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView5) {
        this.rootView = constraintLayout;
        this.compactSwimlaneCampaign = relativeLayout;
        this.compactSwimlaneCounter = dSCollapsibleQuantityStepper;
        this.compactSwimlaneItemButton = compactSwimlaneItemButton2;
        this.compactSwimlaneItemImage = imageView;
        this.compactSwimlaneName = textView;
        this.compactSwimlaneOldPrice = textView2;
        this.compactSwimlaneOutOfStock = textView3;
        this.compactSwimlanePrice = textView4;
        this.iconPromo = appCompatImageView;
        this.promoTitle = textView5;
    }

    @NonNull
    public static CompactSwimlaneItemBinding bind(@NonNull View view) {
        int i11 = R.id.compact_swimlane_campaign;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i11);
        if (relativeLayout != null) {
            i11 = R.id.compact_swimlane_counter;
            DSCollapsibleQuantityStepper dSCollapsibleQuantityStepper = (DSCollapsibleQuantityStepper) ViewBindings.findChildViewById(view, i11);
            if (dSCollapsibleQuantityStepper != null) {
                i11 = R.id.compact_swimlane_item_button;
                CompactSwimlaneItemButton compactSwimlaneItemButton2 = (CompactSwimlaneItemButton) ViewBindings.findChildViewById(view, i11);
                if (compactSwimlaneItemButton2 != null) {
                    i11 = R.id.compact_swimlane_item_image;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                    if (imageView != null) {
                        i11 = R.id.compact_swimlane_name;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView != null) {
                            i11 = R.id.compact_swimlane_old_price;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView2 != null) {
                                i11 = R.id.compact_swimlane_out_of_stock;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                                if (textView3 != null) {
                                    i11 = R.id.compact_swimlane_price;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                                    if (textView4 != null) {
                                        i11 = R.id.icon_promo;
                                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
                                        if (appCompatImageView != null) {
                                            i11 = R.id.promo_title;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i11);
                                            if (textView5 != null) {
                                                return new CompactSwimlaneItemBinding((ConstraintLayout) view, relativeLayout, dSCollapsibleQuantityStepper, compactSwimlaneItemButton2, imageView, textView, textView2, textView3, textView4, appCompatImageView, textView5);
                                            }
                                        }
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
    public static CompactSwimlaneItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CompactSwimlaneItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.compact_swimlane_item, viewGroup, false);
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
