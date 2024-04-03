package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.volley.toolbox.NetworkImageView;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarNotificationTextView;
import com.talabat.helpers.TalabatToolBarTextView;

public final class BrandScreenBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final TalabatToolBarTextView brandTitle;
    @NonNull
    public final TalabatTextView brandingCuisinesText;
    @NonNull
    public final NetworkImageView brandingRestLogo;
    @NonNull
    public final TalabatTextView brandingRestaurantName;
    @NonNull
    public final TalabatToolBarImageButton cart;
    @NonNull
    public final TalabatToolBarTextView cartCount;
    @NonNull
    public final RelativeLayout cartHolder;
    @NonNull
    public final DrawerLayout drawerLayout;
    @NonNull
    public final RecyclerView listSlidemenu;
    @NonNull
    public final TalabatToolBarNotificationTextView notificationBuble;
    @NonNull
    private final DrawerLayout rootView;
    @NonNull
    public final TalabatToolBarImageButton sidemenuButton;
    @NonNull
    public final FrameLayout sidemenuButtonContainer;
    @NonNull
    public final TalabatToolBar toolbar;

    private BrandScreenBinding(@NonNull DrawerLayout drawerLayout2, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatTextView talabatTextView, @NonNull NetworkImageView networkImageView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatToolBarImageButton talabatToolBarImageButton2, @NonNull TalabatToolBarTextView talabatToolBarTextView2, @NonNull RelativeLayout relativeLayout, @NonNull DrawerLayout drawerLayout3, @NonNull RecyclerView recyclerView, @NonNull TalabatToolBarNotificationTextView talabatToolBarNotificationTextView, @NonNull TalabatToolBarImageButton talabatToolBarImageButton3, @NonNull FrameLayout frameLayout, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = drawerLayout2;
        this.back = talabatToolBarImageButton;
        this.brandTitle = talabatToolBarTextView;
        this.brandingCuisinesText = talabatTextView;
        this.brandingRestLogo = networkImageView;
        this.brandingRestaurantName = talabatTextView2;
        this.cart = talabatToolBarImageButton2;
        this.cartCount = talabatToolBarTextView2;
        this.cartHolder = relativeLayout;
        this.drawerLayout = drawerLayout3;
        this.listSlidemenu = recyclerView;
        this.notificationBuble = talabatToolBarNotificationTextView;
        this.sidemenuButton = talabatToolBarImageButton3;
        this.sidemenuButtonContainer = frameLayout;
        this.toolbar = talabatToolBar;
    }

    @NonNull
    public static BrandScreenBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.back;
        TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.back);
        if (talabatToolBarImageButton != null) {
            i11 = R.id.brand_title;
            TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.brand_title);
            if (talabatToolBarTextView != null) {
                i11 = R.id.branding_cuisines_text;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.branding_cuisines_text);
                if (talabatTextView != null) {
                    i11 = R.id.branding_rest_logo;
                    NetworkImageView networkImageView = (NetworkImageView) ViewBindings.findChildViewById(view2, R.id.branding_rest_logo);
                    if (networkImageView != null) {
                        i11 = R.id.branding_restaurant_name;
                        TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.branding_restaurant_name);
                        if (talabatTextView2 != null) {
                            i11 = R.id.cart;
                            TalabatToolBarImageButton talabatToolBarImageButton2 = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.cart);
                            if (talabatToolBarImageButton2 != null) {
                                i11 = R.id.cart_count;
                                TalabatToolBarTextView talabatToolBarTextView2 = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.cart_count);
                                if (talabatToolBarTextView2 != null) {
                                    i11 = R.id.cart_holder;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.cart_holder);
                                    if (relativeLayout != null) {
                                        DrawerLayout drawerLayout2 = (DrawerLayout) view2;
                                        i11 = R.id.list_slidemenu;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.list_slidemenu);
                                        if (recyclerView != null) {
                                            i11 = R.id.notification_buble;
                                            TalabatToolBarNotificationTextView talabatToolBarNotificationTextView = (TalabatToolBarNotificationTextView) ViewBindings.findChildViewById(view2, R.id.notification_buble);
                                            if (talabatToolBarNotificationTextView != null) {
                                                i11 = R.id.sidemenu_button;
                                                TalabatToolBarImageButton talabatToolBarImageButton3 = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.sidemenu_button);
                                                if (talabatToolBarImageButton3 != null) {
                                                    i11 = R.id.sidemenu_button_container;
                                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.sidemenu_button_container);
                                                    if (frameLayout != null) {
                                                        i11 = R.id.toolbar;
                                                        TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                        if (talabatToolBar != null) {
                                                            return new BrandScreenBinding(drawerLayout2, talabatToolBarImageButton, talabatToolBarTextView, talabatTextView, networkImageView, talabatTextView2, talabatToolBarImageButton2, talabatToolBarTextView2, relativeLayout, drawerLayout2, recyclerView, talabatToolBarNotificationTextView, talabatToolBarImageButton3, frameLayout, talabatToolBar);
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
    public static BrandScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static BrandScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.brand_screen, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public DrawerLayout getRoot() {
        return this.rootView;
    }
}
