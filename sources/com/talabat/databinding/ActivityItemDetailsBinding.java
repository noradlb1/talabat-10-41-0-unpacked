package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.TalabatEditText;
import com.talabat.TalabatTextView;

public final class ActivityItemDetailsBinding implements ViewBinding {
    @NonNull
    public final AppBarLayout appbar;
    @NonNull
    public final RelativeLayout bottomCards;
    @NonNull
    public final ImageView btnNewClose;
    @NonNull
    public final TalabatButton buttonAddToCart;
    @NonNull
    public final ImageButton buttonMinus;
    @NonNull
    public final ImageButton buttonPlus;
    @NonNull
    public final ImageView closeButton;
    @NonNull
    public final CollapsingToolbarLayout collapseToolBar;
    @NonNull
    public final RelativeLayout contentView;
    @NonNull
    public final TalabatEditText editSpecialRequest;
    @NonNull
    public final RelativeLayout gemFooterView;
    @NonNull
    public final CoordinatorLayout htabMaincontent;
    @NonNull
    public final ImageView iconComment;
    @NonNull
    public final ImageView iconNoRequest;
    @NonNull
    public final ImageView ivImageHeader;
    @NonNull
    public final RelativeLayout llAddToCart;
    @NonNull
    public final LinearLayout llItemInfo;
    @NonNull
    public final TalabatTextView noRequestContent;
    @NonNull
    public final RecyclerView recyclerViewChoicesItems;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final NestedScrollView scrollView;
    @NonNull
    public final RelativeLayout specialRequestDisabledView;
    @NonNull
    public final CardView specialRequestView;
    @NonNull
    public final TalabatTextView textCount;
    @NonNull
    public final TalabatTextView textItemDetails;
    @NonNull
    public final TalabatTextView textViewPriceDescription;
    @NonNull
    public final TalabatTextView textviewItemTitle;
    @NonNull
    public final TalabatTextView textviewTotalPrice;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final TalabatTextView tvPriceBefore;

    private ActivityItemDetailsBinding(@NonNull RelativeLayout relativeLayout, @NonNull AppBarLayout appBarLayout, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView, @NonNull TalabatButton talabatButton, @NonNull ImageButton imageButton, @NonNull ImageButton imageButton2, @NonNull ImageView imageView2, @NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull RelativeLayout relativeLayout3, @NonNull TalabatEditText talabatEditText, @NonNull RelativeLayout relativeLayout4, @NonNull CoordinatorLayout coordinatorLayout, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull RelativeLayout relativeLayout5, @NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView, @NonNull RecyclerView recyclerView, @NonNull NestedScrollView nestedScrollView, @NonNull RelativeLayout relativeLayout6, @NonNull CardView cardView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatTextView talabatTextView5, @NonNull TalabatTextView talabatTextView6, @NonNull Toolbar toolbar2, @NonNull TalabatTextView talabatTextView7) {
        this.rootView = relativeLayout;
        this.appbar = appBarLayout;
        this.bottomCards = relativeLayout2;
        this.btnNewClose = imageView;
        this.buttonAddToCart = talabatButton;
        this.buttonMinus = imageButton;
        this.buttonPlus = imageButton2;
        this.closeButton = imageView2;
        this.collapseToolBar = collapsingToolbarLayout;
        this.contentView = relativeLayout3;
        this.editSpecialRequest = talabatEditText;
        this.gemFooterView = relativeLayout4;
        this.htabMaincontent = coordinatorLayout;
        this.iconComment = imageView3;
        this.iconNoRequest = imageView4;
        this.ivImageHeader = imageView5;
        this.llAddToCart = relativeLayout5;
        this.llItemInfo = linearLayout;
        this.noRequestContent = talabatTextView;
        this.recyclerViewChoicesItems = recyclerView;
        this.scrollView = nestedScrollView;
        this.specialRequestDisabledView = relativeLayout6;
        this.specialRequestView = cardView;
        this.textCount = talabatTextView2;
        this.textItemDetails = talabatTextView3;
        this.textViewPriceDescription = talabatTextView4;
        this.textviewItemTitle = talabatTextView5;
        this.textviewTotalPrice = talabatTextView6;
        this.toolbar = toolbar2;
        this.tvPriceBefore = talabatTextView7;
    }

    @NonNull
    public static ActivityItemDetailsBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.appbar;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view2, R.id.appbar);
        if (appBarLayout != null) {
            i11 = R.id.bottom_cards;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.bottom_cards);
            if (relativeLayout != null) {
                i11 = R.id.btn_new_close;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.btn_new_close);
                if (imageView != null) {
                    i11 = R.id.button_addToCart;
                    TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view2, R.id.button_addToCart);
                    if (talabatButton != null) {
                        i11 = R.id.button_minus;
                        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view2, R.id.button_minus);
                        if (imageButton != null) {
                            i11 = R.id.button_plus;
                            ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view2, R.id.button_plus);
                            if (imageButton2 != null) {
                                i11 = R.id.close_button;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.close_button);
                                if (imageView2 != null) {
                                    i11 = R.id.collapseToolBar;
                                    CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) ViewBindings.findChildViewById(view2, R.id.collapseToolBar);
                                    if (collapsingToolbarLayout != null) {
                                        RelativeLayout relativeLayout2 = (RelativeLayout) view2;
                                        i11 = R.id.edit_specialRequest;
                                        TalabatEditText talabatEditText = (TalabatEditText) ViewBindings.findChildViewById(view2, R.id.edit_specialRequest);
                                        if (talabatEditText != null) {
                                            i11 = R.id.gem_footer_view;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gem_footer_view);
                                            if (relativeLayout3 != null) {
                                                i11 = R.id.htab_maincontent;
                                                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view2, R.id.htab_maincontent);
                                                if (coordinatorLayout != null) {
                                                    i11 = R.id.icon_comment;
                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.icon_comment);
                                                    if (imageView3 != null) {
                                                        i11 = R.id.icon_no_request;
                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.icon_no_request);
                                                        if (imageView4 != null) {
                                                            i11 = R.id.iv_image_header;
                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_image_header);
                                                            if (imageView5 != null) {
                                                                i11 = R.id.ll_add_to_cart;
                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.ll_add_to_cart);
                                                                if (relativeLayout4 != null) {
                                                                    i11 = R.id.ll_item_info;
                                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_item_info);
                                                                    if (linearLayout != null) {
                                                                        i11 = R.id.no_request_content;
                                                                        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.no_request_content);
                                                                        if (talabatTextView != null) {
                                                                            i11 = R.id.recyclerView_choicesItems;
                                                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.recyclerView_choicesItems);
                                                                            if (recyclerView != null) {
                                                                                i11 = R.id.scroll_view;
                                                                                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, R.id.scroll_view);
                                                                                if (nestedScrollView != null) {
                                                                                    i11 = R.id.special_request_disabled_view;
                                                                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.special_request_disabled_view);
                                                                                    if (relativeLayout5 != null) {
                                                                                        i11 = R.id.special_request_view;
                                                                                        CardView cardView = (CardView) ViewBindings.findChildViewById(view2, R.id.special_request_view);
                                                                                        if (cardView != null) {
                                                                                            i11 = R.id.text_count;
                                                                                            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.text_count);
                                                                                            if (talabatTextView2 != null) {
                                                                                                i11 = R.id.text_itemDetails;
                                                                                                TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.text_itemDetails);
                                                                                                if (talabatTextView3 != null) {
                                                                                                    i11 = R.id.textView_priceDescription;
                                                                                                    TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.textView_priceDescription);
                                                                                                    if (talabatTextView4 != null) {
                                                                                                        i11 = R.id.textview_itemTitle;
                                                                                                        TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.textview_itemTitle);
                                                                                                        if (talabatTextView5 != null) {
                                                                                                            i11 = R.id.textview_totalPrice;
                                                                                                            TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.textview_totalPrice);
                                                                                                            if (talabatTextView6 != null) {
                                                                                                                i11 = R.id.toolbar;
                                                                                                                Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                                                                if (toolbar2 != null) {
                                                                                                                    i11 = R.id.tv_price_before;
                                                                                                                    TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_price_before);
                                                                                                                    if (talabatTextView7 != null) {
                                                                                                                        return new ActivityItemDetailsBinding(relativeLayout2, appBarLayout, relativeLayout, imageView, talabatButton, imageButton, imageButton2, imageView2, collapsingToolbarLayout, relativeLayout2, talabatEditText, relativeLayout3, coordinatorLayout, imageView3, imageView4, imageView5, relativeLayout4, linearLayout, talabatTextView, recyclerView, nestedScrollView, relativeLayout5, cardView, talabatTextView2, talabatTextView3, talabatTextView4, talabatTextView5, talabatTextView6, toolbar2, talabatTextView7);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ActivityItemDetailsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityItemDetailsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_item_details, viewGroup, false);
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
