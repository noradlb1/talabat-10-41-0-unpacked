package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.TalabatTextView;
import com.talabat.gem.adapters.presentation.checkout.GemCheckoutFooterView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarButton;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.TalabatStrokeButton;

public final class CartScreenBinding implements ViewBinding {
    @NonNull
    public final LinearLayout actionButtonsLayout;
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final TalabatFillButton btnCheckout;
    @NonNull
    public final TalabatStrokeButton btnMoreItems;
    @NonNull
    public final LinearLayout buttonsHolder;
    @NonNull
    public final LinearLayout cartEmpty;
    @NonNull
    public final RelativeLayout cartFullView;
    @NonNull
    public final RecyclerView cartList;
    @NonNull
    public final TalabatButton clearCart;
    @NonNull
    public final TalabatToolBarButton deleteButton;
    @NonNull
    public final TalabatToolBarButton editCart;
    @NonNull
    public final GemCheckoutFooterView gemCartFooterView;
    @NonNull
    public final FrameLayout gemFooterLayout;
    @NonNull
    public final RelativeLayout gemFooterView;
    @NonNull
    public final FrameLayout gemFooterViewInnerLayout;
    @NonNull
    public final TalabatTextView minimumOrderText;
    @NonNull
    public final ImageView noCartItem;
    @NonNull
    public final TalabatFillButton noItemsAddItems;
    @NonNull
    public final TalabatTextView parallelBinContent;
    @NonNull
    public final ImageView parallelBinImage;
    @NonNull
    public final ProgressBar parallelBinImageProgressBar;
    @NonNull
    public final RelativeLayout parallelBinImageView;
    @NonNull
    public final TalabatTextView parallelBinMore;
    @NonNull
    public final RelativeLayout parallelBinView;
    @NonNull
    public final TalabatTextView restaurantAreaName;
    @NonNull
    public final CardView restaurantCard;
    @NonNull
    public final TalabatTextView restaurantName;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final RelativeLayout talabatToolbar;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;

    private CartScreenBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull TalabatFillButton talabatFillButton, @NonNull TalabatStrokeButton talabatStrokeButton, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull RelativeLayout relativeLayout2, @NonNull RecyclerView recyclerView, @NonNull TalabatButton talabatButton, @NonNull TalabatToolBarButton talabatToolBarButton, @NonNull TalabatToolBarButton talabatToolBarButton2, @NonNull GemCheckoutFooterView gemCheckoutFooterView, @NonNull FrameLayout frameLayout, @NonNull RelativeLayout relativeLayout3, @NonNull FrameLayout frameLayout2, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView, @NonNull TalabatFillButton talabatFillButton2, @NonNull TalabatTextView talabatTextView2, @NonNull ImageView imageView2, @NonNull ProgressBar progressBar, @NonNull RelativeLayout relativeLayout4, @NonNull TalabatTextView talabatTextView3, @NonNull RelativeLayout relativeLayout5, @NonNull TalabatTextView talabatTextView4, @NonNull CardView cardView, @NonNull TalabatTextView talabatTextView5, @NonNull RelativeLayout relativeLayout6, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = relativeLayout;
        this.actionButtonsLayout = linearLayout;
        this.back = talabatToolBarImageButton;
        this.btnCheckout = talabatFillButton;
        this.btnMoreItems = talabatStrokeButton;
        this.buttonsHolder = linearLayout2;
        this.cartEmpty = linearLayout3;
        this.cartFullView = relativeLayout2;
        this.cartList = recyclerView;
        this.clearCart = talabatButton;
        this.deleteButton = talabatToolBarButton;
        this.editCart = talabatToolBarButton2;
        this.gemCartFooterView = gemCheckoutFooterView;
        this.gemFooterLayout = frameLayout;
        this.gemFooterView = relativeLayout3;
        this.gemFooterViewInnerLayout = frameLayout2;
        this.minimumOrderText = talabatTextView;
        this.noCartItem = imageView;
        this.noItemsAddItems = talabatFillButton2;
        this.parallelBinContent = talabatTextView2;
        this.parallelBinImage = imageView2;
        this.parallelBinImageProgressBar = progressBar;
        this.parallelBinImageView = relativeLayout4;
        this.parallelBinMore = talabatTextView3;
        this.parallelBinView = relativeLayout5;
        this.restaurantAreaName = talabatTextView4;
        this.restaurantCard = cardView;
        this.restaurantName = talabatTextView5;
        this.talabatToolbar = relativeLayout6;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
    }

    @NonNull
    public static CartScreenBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.actionButtonsLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.actionButtonsLayout);
        if (linearLayout != null) {
            i11 = R.id.back;
            TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.back);
            if (talabatToolBarImageButton != null) {
                i11 = R.id.btn_checkout;
                TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.btn_checkout);
                if (talabatFillButton != null) {
                    i11 = R.id.btn_moreItems;
                    TalabatStrokeButton talabatStrokeButton = (TalabatStrokeButton) ViewBindings.findChildViewById(view2, R.id.btn_moreItems);
                    if (talabatStrokeButton != null) {
                        i11 = R.id.buttons_holder;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.buttons_holder);
                        if (linearLayout2 != null) {
                            i11 = R.id.cart_empty;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.cart_empty);
                            if (linearLayout3 != null) {
                                i11 = R.id.cart_full_view;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.cart_full_view);
                                if (relativeLayout != null) {
                                    i11 = R.id.cartList;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.cartList);
                                    if (recyclerView != null) {
                                        i11 = R.id.clear_cart;
                                        TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view2, R.id.clear_cart);
                                        if (talabatButton != null) {
                                            i11 = R.id.delete_button;
                                            TalabatToolBarButton talabatToolBarButton = (TalabatToolBarButton) ViewBindings.findChildViewById(view2, R.id.delete_button);
                                            if (talabatToolBarButton != null) {
                                                i11 = R.id.edit_cart;
                                                TalabatToolBarButton talabatToolBarButton2 = (TalabatToolBarButton) ViewBindings.findChildViewById(view2, R.id.edit_cart);
                                                if (talabatToolBarButton2 != null) {
                                                    i11 = R.id.gemCartFooterView;
                                                    GemCheckoutFooterView gemCheckoutFooterView = (GemCheckoutFooterView) ViewBindings.findChildViewById(view2, R.id.gemCartFooterView);
                                                    if (gemCheckoutFooterView != null) {
                                                        i11 = R.id.gem_footer_layout;
                                                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.gem_footer_layout);
                                                        if (frameLayout != null) {
                                                            i11 = R.id.gem_footer_view;
                                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gem_footer_view);
                                                            if (relativeLayout2 != null) {
                                                                i11 = R.id.gem_footer_view_inner_layout;
                                                                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.gem_footer_view_inner_layout);
                                                                if (frameLayout2 != null) {
                                                                    i11 = R.id.minimum_order_text;
                                                                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.minimum_order_text);
                                                                    if (talabatTextView != null) {
                                                                        i11 = R.id.no_cart_item;
                                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.no_cart_item);
                                                                        if (imageView != null) {
                                                                            i11 = R.id.no_items_add_items;
                                                                            TalabatFillButton talabatFillButton2 = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.no_items_add_items);
                                                                            if (talabatFillButton2 != null) {
                                                                                i11 = R.id.parallel_bin_content;
                                                                                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.parallel_bin_content);
                                                                                if (talabatTextView2 != null) {
                                                                                    i11 = R.id.parallel_bin_image;
                                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.parallel_bin_image);
                                                                                    if (imageView2 != null) {
                                                                                        i11 = R.id.parallel_bin_image_progressBar;
                                                                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.parallel_bin_image_progressBar);
                                                                                        if (progressBar != null) {
                                                                                            i11 = R.id.parallel_bin_image_view;
                                                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.parallel_bin_image_view);
                                                                                            if (relativeLayout3 != null) {
                                                                                                i11 = R.id.parallel_bin_more;
                                                                                                TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.parallel_bin_more);
                                                                                                if (talabatTextView3 != null) {
                                                                                                    i11 = R.id.parallel_bin_view;
                                                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.parallel_bin_view);
                                                                                                    if (relativeLayout4 != null) {
                                                                                                        i11 = R.id.restaurantAreaName;
                                                                                                        TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.restaurantAreaName);
                                                                                                        if (talabatTextView4 != null) {
                                                                                                            i11 = R.id.restaurant_card;
                                                                                                            CardView cardView = (CardView) ViewBindings.findChildViewById(view2, R.id.restaurant_card);
                                                                                                            if (cardView != null) {
                                                                                                                i11 = R.id.restaurantName;
                                                                                                                TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.restaurantName);
                                                                                                                if (talabatTextView5 != null) {
                                                                                                                    i11 = R.id.talabat_toolbar;
                                                                                                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.talabat_toolbar);
                                                                                                                    if (relativeLayout5 != null) {
                                                                                                                        i11 = R.id.title;
                                                                                                                        TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                                                                                        if (talabatToolBarTextView != null) {
                                                                                                                            i11 = R.id.toolbar;
                                                                                                                            TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                                                                            if (talabatToolBar != null) {
                                                                                                                                return new CartScreenBinding((RelativeLayout) view2, linearLayout, talabatToolBarImageButton, talabatFillButton, talabatStrokeButton, linearLayout2, linearLayout3, relativeLayout, recyclerView, talabatButton, talabatToolBarButton, talabatToolBarButton2, gemCheckoutFooterView, frameLayout, relativeLayout2, frameLayout2, talabatTextView, imageView, talabatFillButton2, talabatTextView2, imageView2, progressBar, relativeLayout3, talabatTextView3, relativeLayout4, talabatTextView4, cardView, talabatTextView5, relativeLayout5, talabatToolBarTextView, talabatToolBar);
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
    public static CartScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CartScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.cart_screen, viewGroup, false);
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
