package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.designhelpers.LoadingHelper.LoadingIndicatorView;

public final class CountinuousSectionItemRightImageRelativeBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout contentView;
    @NonNull
    public final ImageView discountIc;
    @NonNull
    public final RelativeLayout imageHolder;
    @NonNull
    public final ImageView itemAddedIndicator;
    @NonNull
    public final TalabatTextView itemDescription;
    @NonNull
    public final ImageView itemImg;
    @NonNull
    public final TalabatTextView itemName;
    @NonNull
    public final TalabatTextView itemPrice;
    @NonNull
    public final TalabatTextView itemQuantity;
    @NonNull
    public final LoadingIndicatorView loadingPrice;
    @NonNull
    public final TalabatTextView priceBefore;
    @NonNull
    public final TalabatTextView priceExtraInfo;
    @NonNull
    public final RelativeLayout priceInfo;
    @NonNull
    public final RelativeLayout priceView;
    @NonNull
    public final ProgressBar progress;
    @NonNull
    public final RelativeLayout rootView;
    @NonNull
    private final RelativeLayout rootView_;
    @NonNull
    public final RelativeLayout textViewHolder;
    @NonNull
    public final View viewSeparator;
    @NonNull
    public final View viewSeparatorShadowed;

    private CountinuousSectionItemRightImageRelativeBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout3, @NonNull ImageView imageView2, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView3, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull LoadingIndicatorView loadingIndicatorView, @NonNull TalabatTextView talabatTextView5, @NonNull TalabatTextView talabatTextView6, @NonNull RelativeLayout relativeLayout4, @NonNull RelativeLayout relativeLayout5, @NonNull ProgressBar progressBar, @NonNull RelativeLayout relativeLayout6, @NonNull RelativeLayout relativeLayout7, @NonNull View view, @NonNull View view2) {
        this.rootView_ = relativeLayout;
        this.contentView = relativeLayout2;
        this.discountIc = imageView;
        this.imageHolder = relativeLayout3;
        this.itemAddedIndicator = imageView2;
        this.itemDescription = talabatTextView;
        this.itemImg = imageView3;
        this.itemName = talabatTextView2;
        this.itemPrice = talabatTextView3;
        this.itemQuantity = talabatTextView4;
        this.loadingPrice = loadingIndicatorView;
        this.priceBefore = talabatTextView5;
        this.priceExtraInfo = talabatTextView6;
        this.priceInfo = relativeLayout4;
        this.priceView = relativeLayout5;
        this.progress = progressBar;
        this.rootView = relativeLayout6;
        this.textViewHolder = relativeLayout7;
        this.viewSeparator = view;
        this.viewSeparatorShadowed = view2;
    }

    @NonNull
    public static CountinuousSectionItemRightImageRelativeBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.content_view;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.content_view);
        if (relativeLayout != null) {
            i11 = R.id.discountIc;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.discountIc);
            if (imageView != null) {
                i11 = R.id.image_holder;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.image_holder);
                if (relativeLayout2 != null) {
                    i11 = R.id.item_added_indicator;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.item_added_indicator);
                    if (imageView2 != null) {
                        i11 = R.id.itemDescription;
                        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.itemDescription);
                        if (talabatTextView != null) {
                            i11 = R.id.itemImg;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.itemImg);
                            if (imageView3 != null) {
                                i11 = R.id.itemName;
                                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.itemName);
                                if (talabatTextView2 != null) {
                                    i11 = R.id.itemPrice;
                                    TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.itemPrice);
                                    if (talabatTextView3 != null) {
                                        i11 = R.id.item_quantity;
                                        TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.item_quantity);
                                        if (talabatTextView4 != null) {
                                            i11 = R.id.loading_price;
                                            LoadingIndicatorView loadingIndicatorView = (LoadingIndicatorView) ViewBindings.findChildViewById(view2, R.id.loading_price);
                                            if (loadingIndicatorView != null) {
                                                i11 = R.id.priceBefore;
                                                TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.priceBefore);
                                                if (talabatTextView5 != null) {
                                                    i11 = R.id.priceExtraInfo;
                                                    TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.priceExtraInfo);
                                                    if (talabatTextView6 != null) {
                                                        i11 = R.id.price_info;
                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.price_info);
                                                        if (relativeLayout3 != null) {
                                                            i11 = R.id.price_view;
                                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.price_view);
                                                            if (relativeLayout4 != null) {
                                                                i11 = R.id.progress;
                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.progress);
                                                                if (progressBar != null) {
                                                                    RelativeLayout relativeLayout5 = (RelativeLayout) view2;
                                                                    i11 = R.id.textView_holder;
                                                                    RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.textView_holder);
                                                                    if (relativeLayout6 != null) {
                                                                        i11 = R.id.view_separator;
                                                                        View findChildViewById = ViewBindings.findChildViewById(view2, R.id.view_separator);
                                                                        if (findChildViewById != null) {
                                                                            i11 = R.id.view_separator_shadowed;
                                                                            View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.view_separator_shadowed);
                                                                            if (findChildViewById2 != null) {
                                                                                return new CountinuousSectionItemRightImageRelativeBinding(relativeLayout5, relativeLayout, imageView, relativeLayout2, imageView2, talabatTextView, imageView3, talabatTextView2, talabatTextView3, talabatTextView4, loadingIndicatorView, talabatTextView5, talabatTextView6, relativeLayout3, relativeLayout4, progressBar, relativeLayout5, relativeLayout6, findChildViewById, findChildViewById2);
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
    public static CountinuousSectionItemRightImageRelativeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CountinuousSectionItemRightImageRelativeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.countinuous_section_item_right_image_relative, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView_;
    }
}
