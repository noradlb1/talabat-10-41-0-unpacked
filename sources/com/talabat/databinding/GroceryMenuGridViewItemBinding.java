package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.TalabatTextView;
import com.talabat.designhelpers.LoadingHelper.LoadingIndicatorView;

public final class GroceryMenuGridViewItemBinding implements ViewBinding {
    @NonNull
    public final TalabatButton addItem;
    @NonNull
    public final LinearLayout decreaseQty;
    @NonNull
    public final OffersTagBinding discountIc;
    @NonNull
    public final RelativeLayout imageView;
    @NonNull
    public final LinearLayout increaseQty;
    @NonNull
    public final TalabatTextView itemDescription;
    @NonNull
    public final ImageView itemImg;
    @NonNull
    public final TalabatTextView itemName;
    @NonNull
    public final TalabatTextView itemPrice;
    @NonNull
    public final LoadingIndicatorView loadingPrice;
    @NonNull
    public final TalabatTextView priceBefore;
    @NonNull
    public final TalabatTextView priceExtraInfo;
    @NonNull
    public final LinearLayout priceSection;
    @NonNull
    public final RelativeLayout priceView;
    @NonNull
    public final ProgressBar progress;
    @NonNull
    public final RelativeLayout quantitySection;
    @NonNull
    public final TalabatTextView quantityText;
    @NonNull
    public final CardView rootView;
    @NonNull
    private final CardView rootView_;
    @NonNull
    public final LinearLayout textSection;

    private GroceryMenuGridViewItemBinding(@NonNull CardView cardView, @NonNull TalabatButton talabatButton, @NonNull LinearLayout linearLayout, @NonNull OffersTagBinding offersTagBinding, @NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout2, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView2, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull LoadingIndicatorView loadingIndicatorView, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatTextView talabatTextView5, @NonNull LinearLayout linearLayout3, @NonNull RelativeLayout relativeLayout2, @NonNull ProgressBar progressBar, @NonNull RelativeLayout relativeLayout3, @NonNull TalabatTextView talabatTextView6, @NonNull CardView cardView2, @NonNull LinearLayout linearLayout4) {
        this.rootView_ = cardView;
        this.addItem = talabatButton;
        this.decreaseQty = linearLayout;
        this.discountIc = offersTagBinding;
        this.imageView = relativeLayout;
        this.increaseQty = linearLayout2;
        this.itemDescription = talabatTextView;
        this.itemImg = imageView2;
        this.itemName = talabatTextView2;
        this.itemPrice = talabatTextView3;
        this.loadingPrice = loadingIndicatorView;
        this.priceBefore = talabatTextView4;
        this.priceExtraInfo = talabatTextView5;
        this.priceSection = linearLayout3;
        this.priceView = relativeLayout2;
        this.progress = progressBar;
        this.quantitySection = relativeLayout3;
        this.quantityText = talabatTextView6;
        this.rootView = cardView2;
        this.textSection = linearLayout4;
    }

    @NonNull
    public static GroceryMenuGridViewItemBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.add_item;
        TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view2, R.id.add_item);
        if (talabatButton != null) {
            i11 = R.id.decrease_qty;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.decrease_qty);
            if (linearLayout != null) {
                i11 = R.id.discountIc;
                View findChildViewById = ViewBindings.findChildViewById(view2, R.id.discountIc);
                if (findChildViewById != null) {
                    OffersTagBinding bind = OffersTagBinding.bind(findChildViewById);
                    i11 = R.id.image_view;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.image_view);
                    if (relativeLayout != null) {
                        i11 = R.id.increase_qty;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.increase_qty);
                        if (linearLayout2 != null) {
                            i11 = R.id.itemDescription;
                            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.itemDescription);
                            if (talabatTextView != null) {
                                i11 = R.id.itemImg;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.itemImg);
                                if (imageView2 != null) {
                                    i11 = R.id.itemName;
                                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.itemName);
                                    if (talabatTextView2 != null) {
                                        i11 = R.id.itemPrice;
                                        TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.itemPrice);
                                        if (talabatTextView3 != null) {
                                            i11 = R.id.loading_price;
                                            LoadingIndicatorView loadingIndicatorView = (LoadingIndicatorView) ViewBindings.findChildViewById(view2, R.id.loading_price);
                                            if (loadingIndicatorView != null) {
                                                i11 = R.id.priceBefore;
                                                TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.priceBefore);
                                                if (talabatTextView4 != null) {
                                                    i11 = R.id.priceExtraInfo;
                                                    TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.priceExtraInfo);
                                                    if (talabatTextView5 != null) {
                                                        i11 = R.id.price_section;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.price_section);
                                                        if (linearLayout3 != null) {
                                                            i11 = R.id.price_view;
                                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.price_view);
                                                            if (relativeLayout2 != null) {
                                                                i11 = R.id.progress;
                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.progress);
                                                                if (progressBar != null) {
                                                                    i11 = R.id.quantity_section;
                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.quantity_section);
                                                                    if (relativeLayout3 != null) {
                                                                        i11 = R.id.quantity_text;
                                                                        TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.quantity_text);
                                                                        if (talabatTextView6 != null) {
                                                                            CardView cardView = (CardView) view2;
                                                                            i11 = R.id.text_section;
                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.text_section);
                                                                            if (linearLayout4 != null) {
                                                                                return new GroceryMenuGridViewItemBinding(cardView, talabatButton, linearLayout, bind, relativeLayout, linearLayout2, talabatTextView, imageView2, talabatTextView2, talabatTextView3, loadingIndicatorView, talabatTextView4, talabatTextView5, linearLayout3, relativeLayout2, progressBar, relativeLayout3, talabatTextView6, cardView, linearLayout4);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static GroceryMenuGridViewItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static GroceryMenuGridViewItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.grocery_menu_grid_view_item, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public CardView getRoot() {
        return this.rootView_;
    }
}
