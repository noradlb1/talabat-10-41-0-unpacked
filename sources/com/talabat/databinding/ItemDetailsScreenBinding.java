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
import android.widget.TableLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.volley.toolbox.NetworkImageView;
import com.talabat.R;
import com.talabat.TalabatEditText;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarButton;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class ItemDetailsScreenBinding implements ViewBinding {
    @NonNull
    public final ImageButton add;
    @NonNull
    public final TalabatFillButton addtocart;
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final TalabatToolBarImageButton cart;
    @NonNull
    public final TalabatToolBarTextView cartCount;
    @NonNull
    public final RelativeLayout cartHolder;
    @NonNull
    public final TableLayout choicecategoriesTablelayout;
    @NonNull
    public final LinearLayout decreaseQty;
    @NonNull
    public final LinearLayout detailsContainer;
    @NonNull
    public final TalabatToolBarButton done;
    @NonNull
    public final NetworkImageView expandedImage;
    @NonNull
    public final RelativeLayout gemFooterView;
    @NonNull
    public final RelativeLayout gemRemainderView;
    @NonNull
    public final TalabatTextView gemRemainderViewTxt;
    @NonNull
    public final ImageView imageNotAvailable;
    @NonNull
    public final FrameLayout imageSeperater;
    @NonNull
    public final LinearLayout increaseQtyPlus;
    @NonNull
    public final TalabatTextView itemDescription;
    @NonNull
    public final NetworkImageView itemImage;
    @NonNull
    public final RelativeLayout itemImageHolder;
    @NonNull
    public final TalabatTextView itemName;
    @NonNull
    public final RelativeLayout mainContainer;
    @NonNull
    public final ImageButton minus;
    @NonNull
    public final TalabatTextView oldPrice;
    @NonNull
    public final TalabatTextView price;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    public final TalabatTextView quantity;
    @NonNull
    public final CardView quantityCardView;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final NestedScrollView scrollView1;
    @NonNull
    public final TalabatEditText specialRequest;
    @NonNull
    public final CardView specialRequestCardView;
    @NonNull
    public final RelativeLayout talabatToolbar;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;
    @NonNull
    public final CardView zoomContainer;

    private ItemDetailsScreenBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageButton imageButton, @NonNull TalabatFillButton talabatFillButton, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull TalabatToolBarImageButton talabatToolBarImageButton2, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull RelativeLayout relativeLayout2, @NonNull TableLayout tableLayout, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TalabatToolBarButton talabatToolBarButton, @NonNull NetworkImageView networkImageView, @NonNull RelativeLayout relativeLayout3, @NonNull RelativeLayout relativeLayout4, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout3, @NonNull TalabatTextView talabatTextView2, @NonNull NetworkImageView networkImageView2, @NonNull RelativeLayout relativeLayout5, @NonNull TalabatTextView talabatTextView3, @NonNull RelativeLayout relativeLayout6, @NonNull ImageButton imageButton2, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatTextView talabatTextView5, @NonNull ProgressBar progressBar2, @NonNull TalabatTextView talabatTextView6, @NonNull CardView cardView, @NonNull NestedScrollView nestedScrollView, @NonNull TalabatEditText talabatEditText, @NonNull CardView cardView2, @NonNull RelativeLayout relativeLayout7, @NonNull TalabatToolBarTextView talabatToolBarTextView2, @NonNull TalabatToolBar talabatToolBar, @NonNull CardView cardView3) {
        this.rootView = relativeLayout;
        this.add = imageButton;
        this.addtocart = talabatFillButton;
        this.back = talabatToolBarImageButton;
        this.cart = talabatToolBarImageButton2;
        this.cartCount = talabatToolBarTextView;
        this.cartHolder = relativeLayout2;
        this.choicecategoriesTablelayout = tableLayout;
        this.decreaseQty = linearLayout;
        this.detailsContainer = linearLayout2;
        this.done = talabatToolBarButton;
        this.expandedImage = networkImageView;
        this.gemFooterView = relativeLayout3;
        this.gemRemainderView = relativeLayout4;
        this.gemRemainderViewTxt = talabatTextView;
        this.imageNotAvailable = imageView;
        this.imageSeperater = frameLayout;
        this.increaseQtyPlus = linearLayout3;
        this.itemDescription = talabatTextView2;
        this.itemImage = networkImageView2;
        this.itemImageHolder = relativeLayout5;
        this.itemName = talabatTextView3;
        this.mainContainer = relativeLayout6;
        this.minus = imageButton2;
        this.oldPrice = talabatTextView4;
        this.price = talabatTextView5;
        this.progressBar = progressBar2;
        this.quantity = talabatTextView6;
        this.quantityCardView = cardView;
        this.scrollView1 = nestedScrollView;
        this.specialRequest = talabatEditText;
        this.specialRequestCardView = cardView2;
        this.talabatToolbar = relativeLayout7;
        this.title = talabatToolBarTextView2;
        this.toolbar = talabatToolBar;
        this.zoomContainer = cardView3;
    }

    @NonNull
    public static ItemDetailsScreenBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.add;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view2, R.id.add);
        if (imageButton != null) {
            i11 = R.id.addtocart;
            TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.addtocart);
            if (talabatFillButton != null) {
                i11 = R.id.back;
                TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.back);
                if (talabatToolBarImageButton != null) {
                    i11 = R.id.cart;
                    TalabatToolBarImageButton talabatToolBarImageButton2 = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.cart);
                    if (talabatToolBarImageButton2 != null) {
                        i11 = R.id.cart_count;
                        TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.cart_count);
                        if (talabatToolBarTextView != null) {
                            i11 = R.id.cart_holder;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.cart_holder);
                            if (relativeLayout != null) {
                                i11 = R.id.choicecategories_tablelayout;
                                TableLayout tableLayout = (TableLayout) ViewBindings.findChildViewById(view2, R.id.choicecategories_tablelayout);
                                if (tableLayout != null) {
                                    i11 = R.id.decrease_qty;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.decrease_qty);
                                    if (linearLayout != null) {
                                        i11 = R.id.details_container;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.details_container);
                                        if (linearLayout2 != null) {
                                            i11 = R.id.done;
                                            TalabatToolBarButton talabatToolBarButton = (TalabatToolBarButton) ViewBindings.findChildViewById(view2, R.id.done);
                                            if (talabatToolBarButton != null) {
                                                i11 = R.id.expanded_image;
                                                NetworkImageView networkImageView = (NetworkImageView) ViewBindings.findChildViewById(view2, R.id.expanded_image);
                                                if (networkImageView != null) {
                                                    i11 = R.id.gem_footer_view;
                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gem_footer_view);
                                                    if (relativeLayout2 != null) {
                                                        i11 = R.id.gem_remainder_view;
                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gem_remainder_view);
                                                        if (relativeLayout3 != null) {
                                                            i11 = R.id.gem_remainder_view_txt;
                                                            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.gem_remainder_view_txt);
                                                            if (talabatTextView != null) {
                                                                i11 = R.id.image_not_available;
                                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.image_not_available);
                                                                if (imageView != null) {
                                                                    i11 = R.id.image_seperater;
                                                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.image_seperater);
                                                                    if (frameLayout != null) {
                                                                        i11 = R.id.increase_qty_plus;
                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.increase_qty_plus);
                                                                        if (linearLayout3 != null) {
                                                                            i11 = R.id.item_description;
                                                                            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.item_description);
                                                                            if (talabatTextView2 != null) {
                                                                                i11 = R.id.item_image;
                                                                                NetworkImageView networkImageView2 = (NetworkImageView) ViewBindings.findChildViewById(view2, R.id.item_image);
                                                                                if (networkImageView2 != null) {
                                                                                    i11 = R.id.item_image_holder;
                                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.item_image_holder);
                                                                                    if (relativeLayout4 != null) {
                                                                                        i11 = R.id.item_name;
                                                                                        TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.item_name);
                                                                                        if (talabatTextView3 != null) {
                                                                                            i11 = R.id.main_container;
                                                                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.main_container);
                                                                                            if (relativeLayout5 != null) {
                                                                                                i11 = R.id.minus;
                                                                                                ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view2, R.id.minus);
                                                                                                if (imageButton2 != null) {
                                                                                                    i11 = R.id.old_price;
                                                                                                    TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.old_price);
                                                                                                    if (talabatTextView4 != null) {
                                                                                                        i11 = R.id.price;
                                                                                                        TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.price);
                                                                                                        if (talabatTextView5 != null) {
                                                                                                            i11 = R.id.progressBar;
                                                                                                            ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.progressBar);
                                                                                                            if (progressBar2 != null) {
                                                                                                                i11 = R.id.quantity;
                                                                                                                TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.quantity);
                                                                                                                if (talabatTextView6 != null) {
                                                                                                                    i11 = R.id.quantity_card_view;
                                                                                                                    CardView cardView = (CardView) ViewBindings.findChildViewById(view2, R.id.quantity_card_view);
                                                                                                                    if (cardView != null) {
                                                                                                                        i11 = R.id.scrollView1;
                                                                                                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, R.id.scrollView1);
                                                                                                                        if (nestedScrollView != null) {
                                                                                                                            i11 = R.id.special_request;
                                                                                                                            TalabatEditText talabatEditText = (TalabatEditText) ViewBindings.findChildViewById(view2, R.id.special_request);
                                                                                                                            if (talabatEditText != null) {
                                                                                                                                i11 = R.id.special_request_card_view;
                                                                                                                                CardView cardView2 = (CardView) ViewBindings.findChildViewById(view2, R.id.special_request_card_view);
                                                                                                                                if (cardView2 != null) {
                                                                                                                                    i11 = R.id.talabat_toolbar;
                                                                                                                                    RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.talabat_toolbar);
                                                                                                                                    if (relativeLayout6 != null) {
                                                                                                                                        i11 = R.id.title;
                                                                                                                                        TalabatToolBarTextView talabatToolBarTextView2 = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                                                                                                        if (talabatToolBarTextView2 != null) {
                                                                                                                                            i11 = R.id.toolbar;
                                                                                                                                            TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                                                                                            if (talabatToolBar != null) {
                                                                                                                                                i11 = R.id.zoom_container;
                                                                                                                                                CardView cardView3 = (CardView) ViewBindings.findChildViewById(view2, R.id.zoom_container);
                                                                                                                                                if (cardView3 != null) {
                                                                                                                                                    return new ItemDetailsScreenBinding((RelativeLayout) view2, imageButton, talabatFillButton, talabatToolBarImageButton, talabatToolBarImageButton2, talabatToolBarTextView, relativeLayout, tableLayout, linearLayout, linearLayout2, talabatToolBarButton, networkImageView, relativeLayout2, relativeLayout3, talabatTextView, imageView, frameLayout, linearLayout3, talabatTextView2, networkImageView2, relativeLayout4, talabatTextView3, relativeLayout5, imageButton2, talabatTextView4, talabatTextView5, progressBar2, talabatTextView6, cardView, nestedScrollView, talabatEditText, cardView2, relativeLayout6, talabatToolBarTextView2, talabatToolBar, cardView3);
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
    public static ItemDetailsScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemDetailsScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_details_screen, viewGroup, false);
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
