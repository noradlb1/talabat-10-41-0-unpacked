package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
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

public final class ActivityItemDetailsRevampedBinding implements ViewBinding {
    @NonNull
    public final ImageView additionalRequestsIcon;
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
    public final CollapsingToolbarLayout collapseToolBar;
    @NonNull
    public final RelativeLayout contentView;
    @NonNull
    public final TalabatEditText editSpecialRequest;
    @NonNull
    public final RelativeLayout gemFooterView;
    @NonNull
    public final LinearLayout headerView;
    @NonNull
    public final CoordinatorLayout htabMaincontent;
    @NonNull
    public final ImageView iconNoRequest;
    @NonNull
    public final FrameLayout imageContainer;
    @NonNull
    public final ImageView ivImageHeader;
    @NonNull
    public final RelativeLayout llAddToCart;
    @NonNull
    public final ImageView noHeaderClose;
    @NonNull
    public final FrameLayout noHeaderImageContainer;
    @NonNull
    public final ImageView noHeaderItemImage;
    @NonNull
    public final TalabatTextView noRequestContent;
    @NonNull
    public final RecyclerView recyclerViewChoicesItems;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final NestedScrollView scrollView;
    @NonNull
    public final TextView selectedChoices;
    @NonNull
    public final ProgressBar selectedProgress;
    @NonNull
    public final RelativeLayout specialRequestDisabledView;
    @NonNull
    public final RelativeLayout specialRequestView;
    @NonNull
    public final TalabatTextView textCount;
    @NonNull
    public final TalabatTextView textItemDetails;
    @NonNull
    public final TalabatTextView textViewPriceDescription;
    @NonNull
    public final TalabatTextView textviewItemTitle;
    @NonNull
    public final TextView textviewItemTitleToolbar;
    @NonNull
    public final TalabatTextView textviewTotalPrice;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final RelativeLayout toolbarContent;
    @NonNull
    public final TalabatTextView tvPriceBefore;

    private ActivityItemDetailsRevampedBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull AppBarLayout appBarLayout, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView2, @NonNull TalabatButton talabatButton, @NonNull ImageButton imageButton, @NonNull ImageButton imageButton2, @NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull RelativeLayout relativeLayout3, @NonNull TalabatEditText talabatEditText, @NonNull RelativeLayout relativeLayout4, @NonNull LinearLayout linearLayout, @NonNull CoordinatorLayout coordinatorLayout, @NonNull ImageView imageView3, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView4, @NonNull RelativeLayout relativeLayout5, @NonNull ImageView imageView5, @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView6, @NonNull TalabatTextView talabatTextView, @NonNull RecyclerView recyclerView, @NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull ProgressBar progressBar, @NonNull RelativeLayout relativeLayout6, @NonNull RelativeLayout relativeLayout7, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatTextView talabatTextView5, @NonNull TextView textView2, @NonNull TalabatTextView talabatTextView6, @NonNull Toolbar toolbar2, @NonNull RelativeLayout relativeLayout8, @NonNull TalabatTextView talabatTextView7) {
        this.rootView = relativeLayout;
        this.additionalRequestsIcon = imageView;
        this.appbar = appBarLayout;
        this.bottomCards = relativeLayout2;
        this.btnNewClose = imageView2;
        this.buttonAddToCart = talabatButton;
        this.buttonMinus = imageButton;
        this.buttonPlus = imageButton2;
        this.collapseToolBar = collapsingToolbarLayout;
        this.contentView = relativeLayout3;
        this.editSpecialRequest = talabatEditText;
        this.gemFooterView = relativeLayout4;
        this.headerView = linearLayout;
        this.htabMaincontent = coordinatorLayout;
        this.iconNoRequest = imageView3;
        this.imageContainer = frameLayout;
        this.ivImageHeader = imageView4;
        this.llAddToCart = relativeLayout5;
        this.noHeaderClose = imageView5;
        this.noHeaderImageContainer = frameLayout2;
        this.noHeaderItemImage = imageView6;
        this.noRequestContent = talabatTextView;
        this.recyclerViewChoicesItems = recyclerView;
        this.scrollView = nestedScrollView;
        this.selectedChoices = textView;
        this.selectedProgress = progressBar;
        this.specialRequestDisabledView = relativeLayout6;
        this.specialRequestView = relativeLayout7;
        this.textCount = talabatTextView2;
        this.textItemDetails = talabatTextView3;
        this.textViewPriceDescription = talabatTextView4;
        this.textviewItemTitle = talabatTextView5;
        this.textviewItemTitleToolbar = textView2;
        this.textviewTotalPrice = talabatTextView6;
        this.toolbar = toolbar2;
        this.toolbarContent = relativeLayout8;
        this.tvPriceBefore = talabatTextView7;
    }

    @NonNull
    public static ActivityItemDetailsRevampedBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.additional_requests_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.additional_requests_icon);
        if (imageView != null) {
            i11 = R.id.appbar;
            AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view2, R.id.appbar);
            if (appBarLayout != null) {
                i11 = R.id.bottom_cards;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.bottom_cards);
                if (relativeLayout != null) {
                    i11 = R.id.btn_new_close;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.btn_new_close);
                    if (imageView2 != null) {
                        i11 = R.id.button_addToCart;
                        TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view2, R.id.button_addToCart);
                        if (talabatButton != null) {
                            i11 = R.id.button_minus;
                            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view2, R.id.button_minus);
                            if (imageButton != null) {
                                i11 = R.id.button_plus;
                                ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view2, R.id.button_plus);
                                if (imageButton2 != null) {
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
                                                i11 = R.id.header_view;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.header_view);
                                                if (linearLayout != null) {
                                                    i11 = R.id.htab_maincontent;
                                                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view2, R.id.htab_maincontent);
                                                    if (coordinatorLayout != null) {
                                                        i11 = R.id.icon_no_request;
                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.icon_no_request);
                                                        if (imageView3 != null) {
                                                            i11 = R.id.image_container;
                                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.image_container);
                                                            if (frameLayout != null) {
                                                                i11 = R.id.iv_image_header;
                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_image_header);
                                                                if (imageView4 != null) {
                                                                    i11 = R.id.ll_add_to_cart;
                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.ll_add_to_cart);
                                                                    if (relativeLayout4 != null) {
                                                                        i11 = R.id.no_header_close;
                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, R.id.no_header_close);
                                                                        if (imageView5 != null) {
                                                                            i11 = R.id.no_header_image_container;
                                                                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.no_header_image_container);
                                                                            if (frameLayout2 != null) {
                                                                                i11 = R.id.no_header_item_image;
                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view2, R.id.no_header_item_image);
                                                                                if (imageView6 != null) {
                                                                                    i11 = R.id.no_request_content;
                                                                                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.no_request_content);
                                                                                    if (talabatTextView != null) {
                                                                                        i11 = R.id.recyclerView_choicesItems;
                                                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.recyclerView_choicesItems);
                                                                                        if (recyclerView != null) {
                                                                                            i11 = R.id.scroll_view;
                                                                                            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, R.id.scroll_view);
                                                                                            if (nestedScrollView != null) {
                                                                                                i11 = R.id.selected_choices;
                                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.selected_choices);
                                                                                                if (textView != null) {
                                                                                                    i11 = R.id.selected_progress;
                                                                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.selected_progress);
                                                                                                    if (progressBar != null) {
                                                                                                        i11 = R.id.special_request_disabled_view;
                                                                                                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.special_request_disabled_view);
                                                                                                        if (relativeLayout5 != null) {
                                                                                                            i11 = R.id.special_request_view;
                                                                                                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.special_request_view);
                                                                                                            if (relativeLayout6 != null) {
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
                                                                                                                                i11 = R.id.textview_itemTitleToolbar;
                                                                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.textview_itemTitleToolbar);
                                                                                                                                if (textView2 != null) {
                                                                                                                                    i11 = R.id.textview_totalPrice;
                                                                                                                                    TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.textview_totalPrice);
                                                                                                                                    if (talabatTextView6 != null) {
                                                                                                                                        i11 = R.id.toolbar;
                                                                                                                                        Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                                                                                        if (toolbar2 != null) {
                                                                                                                                            i11 = R.id.toolbar_content;
                                                                                                                                            RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.toolbar_content);
                                                                                                                                            if (relativeLayout7 != null) {
                                                                                                                                                i11 = R.id.tv_price_before;
                                                                                                                                                TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_price_before);
                                                                                                                                                if (talabatTextView7 != null) {
                                                                                                                                                    return new ActivityItemDetailsRevampedBinding(relativeLayout2, imageView, appBarLayout, relativeLayout, imageView2, talabatButton, imageButton, imageButton2, collapsingToolbarLayout, relativeLayout2, talabatEditText, relativeLayout3, linearLayout, coordinatorLayout, imageView3, frameLayout, imageView4, relativeLayout4, imageView5, frameLayout2, imageView6, talabatTextView, recyclerView, nestedScrollView, textView, progressBar, relativeLayout5, relativeLayout6, talabatTextView2, talabatTextView3, talabatTextView4, talabatTextView5, textView2, talabatTextView6, toolbar2, relativeLayout7, talabatTextView7);
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
    public static ActivityItemDetailsRevampedBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityItemDetailsRevampedBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_item_details_revamped, viewGroup, false);
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
