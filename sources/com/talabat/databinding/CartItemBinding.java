package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.TalabatTextView;

public final class CartItemBinding implements ViewBinding {
    @NonNull
    public final LinearLayout cartContentTextSection;
    @NonNull
    public final TalabatTextView choices;
    @NonNull
    public final LinearLayout decreaseQty;
    @NonNull
    public final TalabatButton deleteCart;
    @NonNull
    public final CheckBox deleteItem;
    @NonNull
    public final ImageView imageNotAvailable;
    @NonNull
    public final LinearLayout increaseQty;
    @NonNull
    public final RelativeLayout itemImageHolder;
    @NonNull
    public final ImageView itemLogo;
    @NonNull
    public final TalabatTextView itemName;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    public final TalabatTextView quantity;
    @NonNull
    public final RelativeLayout quantitySection;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final RelativeLayout selectorIconsLayout;
    @NonNull
    public final TalabatTextView specialRequest;
    @NonNull
    public final LinearLayout specialRequestLayout;
    @NonNull
    public final TalabatTextView totalPrice;

    private CartItemBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TalabatTextView talabatTextView, @NonNull LinearLayout linearLayout3, @NonNull TalabatButton talabatButton, @NonNull CheckBox checkBox, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout4, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView2, @NonNull TalabatTextView talabatTextView2, @NonNull ProgressBar progressBar2, @NonNull TalabatTextView talabatTextView3, @NonNull RelativeLayout relativeLayout2, @NonNull RelativeLayout relativeLayout3, @NonNull TalabatTextView talabatTextView4, @NonNull LinearLayout linearLayout5, @NonNull TalabatTextView talabatTextView5) {
        this.rootView = linearLayout;
        this.cartContentTextSection = linearLayout2;
        this.choices = talabatTextView;
        this.decreaseQty = linearLayout3;
        this.deleteCart = talabatButton;
        this.deleteItem = checkBox;
        this.imageNotAvailable = imageView;
        this.increaseQty = linearLayout4;
        this.itemImageHolder = relativeLayout;
        this.itemLogo = imageView2;
        this.itemName = talabatTextView2;
        this.progressBar = progressBar2;
        this.quantity = talabatTextView3;
        this.quantitySection = relativeLayout2;
        this.selectorIconsLayout = relativeLayout3;
        this.specialRequest = talabatTextView4;
        this.specialRequestLayout = linearLayout5;
        this.totalPrice = talabatTextView5;
    }

    @NonNull
    public static CartItemBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.cart_content_text_section;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.cart_content_text_section);
        if (linearLayout != null) {
            i11 = R.id.choices;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.choices);
            if (talabatTextView != null) {
                i11 = R.id.decrease_qty;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.decrease_qty);
                if (linearLayout2 != null) {
                    i11 = R.id.delete_cart;
                    TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view2, R.id.delete_cart);
                    if (talabatButton != null) {
                        i11 = R.id.delete_item;
                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view2, R.id.delete_item);
                        if (checkBox != null) {
                            i11 = R.id.image_not_available;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.image_not_available);
                            if (imageView != null) {
                                i11 = R.id.increase_qty;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.increase_qty);
                                if (linearLayout3 != null) {
                                    i11 = R.id.item_image_holder;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.item_image_holder);
                                    if (relativeLayout != null) {
                                        i11 = R.id.item_logo;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.item_logo);
                                        if (imageView2 != null) {
                                            i11 = R.id.item_name;
                                            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.item_name);
                                            if (talabatTextView2 != null) {
                                                i11 = R.id.progressBar;
                                                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.progressBar);
                                                if (progressBar2 != null) {
                                                    i11 = R.id.quantity;
                                                    TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.quantity);
                                                    if (talabatTextView3 != null) {
                                                        i11 = R.id.quantity_section;
                                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.quantity_section);
                                                        if (relativeLayout2 != null) {
                                                            i11 = R.id.selector_icons_layout;
                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.selector_icons_layout);
                                                            if (relativeLayout3 != null) {
                                                                i11 = R.id.special_request;
                                                                TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.special_request);
                                                                if (talabatTextView4 != null) {
                                                                    i11 = R.id.special_request_layout;
                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.special_request_layout);
                                                                    if (linearLayout4 != null) {
                                                                        i11 = R.id.total_price;
                                                                        TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.total_price);
                                                                        if (talabatTextView5 != null) {
                                                                            return new CartItemBinding((LinearLayout) view2, linearLayout, talabatTextView, linearLayout2, talabatButton, checkBox, imageView, linearLayout3, relativeLayout, imageView2, talabatTextView2, progressBar2, talabatTextView3, relativeLayout2, relativeLayout3, talabatTextView4, linearLayout4, talabatTextView5);
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
    public static CartItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CartItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.cart_item, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
