package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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

public final class OffersListScreenBinding implements ViewBinding {
    @NonNull
    public final DrawerLayout drawerLayout;
    @NonNull
    public final RecyclerView listSlidemenu;
    @NonNull
    public final LinearLayout noOffersView;
    @NonNull
    public final TalabatToolBarNotificationTextView notificationBuble;
    @NonNull
    public final RecyclerView offerList;
    @NonNull
    public final RelativeLayout offersLoadingLayout;
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

    private OffersListScreenBinding(@NonNull DrawerLayout drawerLayout2, @NonNull DrawerLayout drawerLayout3, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout, @NonNull TalabatToolBarNotificationTextView talabatToolBarNotificationTextView, @NonNull RecyclerView recyclerView2, @NonNull RelativeLayout relativeLayout, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull FrameLayout frameLayout, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = drawerLayout2;
        this.drawerLayout = drawerLayout3;
        this.listSlidemenu = recyclerView;
        this.noOffersView = linearLayout;
        this.notificationBuble = talabatToolBarNotificationTextView;
        this.offerList = recyclerView2;
        this.offersLoadingLayout = relativeLayout;
        this.sidemenuButton = talabatToolBarImageButton;
        this.sidemenuButtonContainer = frameLayout;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
    }

    @NonNull
    public static OffersListScreenBinding bind(@NonNull View view) {
        DrawerLayout drawerLayout2 = (DrawerLayout) view;
        int i11 = R.id.list_slidemenu;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.list_slidemenu);
        if (recyclerView != null) {
            i11 = R.id.no_offers_view;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.no_offers_view);
            if (linearLayout != null) {
                i11 = R.id.notification_buble;
                TalabatToolBarNotificationTextView talabatToolBarNotificationTextView = (TalabatToolBarNotificationTextView) ViewBindings.findChildViewById(view, R.id.notification_buble);
                if (talabatToolBarNotificationTextView != null) {
                    i11 = R.id.offer_list;
                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, R.id.offer_list);
                    if (recyclerView2 != null) {
                        i11 = R.id.offers_loading_layout;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.offers_loading_layout);
                        if (relativeLayout != null) {
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
                                            return new OffersListScreenBinding(drawerLayout2, drawerLayout2, recyclerView, linearLayout, talabatToolBarNotificationTextView, recyclerView2, relativeLayout, talabatToolBarImageButton, frameLayout, talabatToolBarTextView, talabatToolBar);
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
    public static OffersListScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static OffersListScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.offers_list_screen, viewGroup, false);
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
