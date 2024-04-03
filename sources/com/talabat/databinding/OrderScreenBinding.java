package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarNotificationTextView;
import com.talabat.helpers.TalabatToolBarTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class OrderScreenBinding implements ViewBinding {
    @NonNull
    public final DrawerLayout drawerLayout;
    @NonNull
    public final RecyclerView listSlidemenu;
    @NonNull
    public final LinearLayout noOrderView;
    @NonNull
    public final LinearLayout notLoggedInView;
    @NonNull
    public final TalabatToolBarNotificationTextView notificationBuble;
    @NonNull
    public final RecyclerView orderList;
    @NonNull
    public final TalabatFillButton ordersScreenLogin;
    @NonNull
    public final LinearLayout progressLayout;
    @NonNull
    private final DrawerLayout rootView;
    @NonNull
    public final TalabatToolBarImageButton sidemenuButton;
    @NonNull
    public final FrameLayout sidemenuButtonContainer;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;

    private OrderScreenBinding(@NonNull DrawerLayout drawerLayout2, @NonNull DrawerLayout drawerLayout3, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TalabatToolBarNotificationTextView talabatToolBarNotificationTextView, @NonNull RecyclerView recyclerView2, @NonNull TalabatFillButton talabatFillButton, @NonNull LinearLayout linearLayout3, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull FrameLayout frameLayout, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = drawerLayout2;
        this.drawerLayout = drawerLayout3;
        this.listSlidemenu = recyclerView;
        this.noOrderView = linearLayout;
        this.notLoggedInView = linearLayout2;
        this.notificationBuble = talabatToolBarNotificationTextView;
        this.orderList = recyclerView2;
        this.ordersScreenLogin = talabatFillButton;
        this.progressLayout = linearLayout3;
        this.sidemenuButton = talabatToolBarImageButton;
        this.sidemenuButtonContainer = frameLayout;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
    }

    @NonNull
    public static OrderScreenBinding bind(@NonNull View view) {
        DrawerLayout drawerLayout2 = (DrawerLayout) view;
        int i11 = R.id.list_slidemenu;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.list_slidemenu);
        if (recyclerView != null) {
            i11 = R.id.no_order_view;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.no_order_view);
            if (linearLayout != null) {
                i11 = R.id.not_logged_in_view;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.not_logged_in_view);
                if (linearLayout2 != null) {
                    i11 = R.id.notification_buble;
                    TalabatToolBarNotificationTextView talabatToolBarNotificationTextView = (TalabatToolBarNotificationTextView) ViewBindings.findChildViewById(view, R.id.notification_buble);
                    if (talabatToolBarNotificationTextView != null) {
                        i11 = R.id.order_list;
                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, R.id.order_list);
                        if (recyclerView2 != null) {
                            i11 = R.id.orders_screen_login;
                            TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, R.id.orders_screen_login);
                            if (talabatFillButton != null) {
                                i11 = R.id.progress_layout;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.progress_layout);
                                if (linearLayout3 != null) {
                                    i11 = R.id.sidemenu_button;
                                    TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view, R.id.sidemenu_button);
                                    if (talabatToolBarImageButton != null) {
                                        i11 = R.id.sidemenu_button_container;
                                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.sidemenu_button_container);
                                        if (frameLayout != null) {
                                            i11 = R.id.title;
                                            TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view, R.id.title);
                                            if (talabatToolBarTextView != null) {
                                                i11 = R.id.toolbar;
                                                TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                if (talabatToolBar != null) {
                                                    return new OrderScreenBinding(drawerLayout2, drawerLayout2, recyclerView, linearLayout, linearLayout2, talabatToolBarNotificationTextView, recyclerView2, talabatFillButton, linearLayout3, talabatToolBarImageButton, frameLayout, talabatToolBarTextView, talabatToolBar);
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
    public static OrderScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static OrderScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.order_screen, viewGroup, false);
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
