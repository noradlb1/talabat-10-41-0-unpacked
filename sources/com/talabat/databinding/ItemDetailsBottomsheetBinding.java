package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
import com.talabat.TalabatButton;
import com.talabat.TalabatEditText;
import com.talabat.TalabatTextView;

public final class ItemDetailsBottomsheetBinding implements ViewBinding {
    @NonNull
    public final TalabatButton addToBasket;
    @NonNull
    public final RelativeLayout addToBasketView;
    @NonNull
    public final ImageView additionalRequestsIcon;
    @NonNull
    public final RelativeLayout bottomCards;
    @NonNull
    public final ImageButton buttonMinus;
    @NonNull
    public final ImageButton buttonPlus;
    @NonNull
    public final ImageView closeBottomsheet;
    @NonNull
    public final TalabatEditText generalRequest;
    @NonNull
    public final RelativeLayout generalRequestDisabledView;
    @NonNull
    public final RelativeLayout generalRequestView;
    @NonNull
    public final LinearLayout headerView;
    @NonNull
    public final ImageView iconNoRequest;
    @NonNull
    public final ImageView imageHeader;
    @NonNull
    public final TalabatTextView itemDescription;
    @NonNull
    public final TalabatTextView itemName;
    @NonNull
    public final RelativeLayout itemdetailsBottomSheet;
    @NonNull
    public final TalabatTextView noRequestContent;
    @NonNull
    public final TalabatTextView oldPrice;
    @NonNull
    public final TalabatTextView price;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    public final RelativeLayout progressBarView;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TextView textCount;
    @NonNull
    public final TextView totalPrice;

    private ItemDetailsBottomsheetBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatButton talabatButton, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout3, @NonNull ImageButton imageButton, @NonNull ImageButton imageButton2, @NonNull ImageView imageView2, @NonNull TalabatEditText talabatEditText, @NonNull RelativeLayout relativeLayout4, @NonNull RelativeLayout relativeLayout5, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull RelativeLayout relativeLayout6, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatTextView talabatTextView5, @NonNull ProgressBar progressBar2, @NonNull RelativeLayout relativeLayout7, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = relativeLayout;
        this.addToBasket = talabatButton;
        this.addToBasketView = relativeLayout2;
        this.additionalRequestsIcon = imageView;
        this.bottomCards = relativeLayout3;
        this.buttonMinus = imageButton;
        this.buttonPlus = imageButton2;
        this.closeBottomsheet = imageView2;
        this.generalRequest = talabatEditText;
        this.generalRequestDisabledView = relativeLayout4;
        this.generalRequestView = relativeLayout5;
        this.headerView = linearLayout;
        this.iconNoRequest = imageView3;
        this.imageHeader = imageView4;
        this.itemDescription = talabatTextView;
        this.itemName = talabatTextView2;
        this.itemdetailsBottomSheet = relativeLayout6;
        this.noRequestContent = talabatTextView3;
        this.oldPrice = talabatTextView4;
        this.price = talabatTextView5;
        this.progressBar = progressBar2;
        this.progressBarView = relativeLayout7;
        this.textCount = textView;
        this.totalPrice = textView2;
    }

    @NonNull
    public static ItemDetailsBottomsheetBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.add_to_basket;
        TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view2, R.id.add_to_basket);
        if (talabatButton != null) {
            i11 = R.id.add_to_basket_view;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.add_to_basket_view);
            if (relativeLayout != null) {
                i11 = R.id.additional_requests_icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.additional_requests_icon);
                if (imageView != null) {
                    i11 = R.id.bottom_cards;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.bottom_cards);
                    if (relativeLayout2 != null) {
                        i11 = R.id.button_minus;
                        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view2, R.id.button_minus);
                        if (imageButton != null) {
                            i11 = R.id.button_plus;
                            ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view2, R.id.button_plus);
                            if (imageButton2 != null) {
                                i11 = R.id.close_bottomsheet;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.close_bottomsheet);
                                if (imageView2 != null) {
                                    i11 = R.id.general_request;
                                    TalabatEditText talabatEditText = (TalabatEditText) ViewBindings.findChildViewById(view2, R.id.general_request);
                                    if (talabatEditText != null) {
                                        i11 = R.id.general_request_disabled_view;
                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.general_request_disabled_view);
                                        if (relativeLayout3 != null) {
                                            i11 = R.id.general_request_view;
                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.general_request_view);
                                            if (relativeLayout4 != null) {
                                                i11 = R.id.header_view;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.header_view);
                                                if (linearLayout != null) {
                                                    i11 = R.id.icon_no_request;
                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.icon_no_request);
                                                    if (imageView3 != null) {
                                                        i11 = R.id.image_header;
                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.image_header);
                                                        if (imageView4 != null) {
                                                            i11 = R.id.item_description;
                                                            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.item_description);
                                                            if (talabatTextView != null) {
                                                                i11 = R.id.item_name;
                                                                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.item_name);
                                                                if (talabatTextView2 != null) {
                                                                    RelativeLayout relativeLayout5 = (RelativeLayout) view2;
                                                                    i11 = R.id.no_request_content;
                                                                    TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.no_request_content);
                                                                    if (talabatTextView3 != null) {
                                                                        i11 = R.id.old_price;
                                                                        TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.old_price);
                                                                        if (talabatTextView4 != null) {
                                                                            i11 = R.id.price;
                                                                            TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.price);
                                                                            if (talabatTextView5 != null) {
                                                                                i11 = R.id.progress_bar;
                                                                                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.progress_bar);
                                                                                if (progressBar2 != null) {
                                                                                    i11 = R.id.progress_bar_view;
                                                                                    RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.progress_bar_view);
                                                                                    if (relativeLayout6 != null) {
                                                                                        i11 = R.id.text_count;
                                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.text_count);
                                                                                        if (textView != null) {
                                                                                            i11 = R.id.total_price;
                                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.total_price);
                                                                                            if (textView2 != null) {
                                                                                                return new ItemDetailsBottomsheetBinding(relativeLayout5, talabatButton, relativeLayout, imageView, relativeLayout2, imageButton, imageButton2, imageView2, talabatEditText, relativeLayout3, relativeLayout4, linearLayout, imageView3, imageView4, talabatTextView, talabatTextView2, relativeLayout5, talabatTextView3, talabatTextView4, talabatTextView5, progressBar2, relativeLayout6, textView, textView2);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemDetailsBottomsheetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemDetailsBottomsheetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_details_bottomsheet, viewGroup, false);
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
