package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.talabat.helpers.TalabatToolBarTextView;

public final class NotificationsBinding implements ViewBinding {
    @NonNull
    public final DrawerLayout drawerLayout;
    @NonNull
    public final RecyclerView listSlidemenu;
    @NonNull
    public final LinearLayout root;
    @NonNull
    private final DrawerLayout rootView;
    @NonNull
    public final TalabatToolBarImageButton sidemenuButton;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;

    private NotificationsBinding(@NonNull DrawerLayout drawerLayout2, @NonNull DrawerLayout drawerLayout3, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = drawerLayout2;
        this.drawerLayout = drawerLayout3;
        this.listSlidemenu = recyclerView;
        this.root = linearLayout;
        this.sidemenuButton = talabatToolBarImageButton;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
    }

    @NonNull
    public static NotificationsBinding bind(@NonNull View view) {
        DrawerLayout drawerLayout2 = (DrawerLayout) view;
        int i11 = R.id.list_slidemenu;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.list_slidemenu);
        if (recyclerView != null) {
            i11 = R.id.root;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.root);
            if (linearLayout != null) {
                i11 = R.id.sidemenu_button;
                TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view, R.id.sidemenu_button);
                if (talabatToolBarImageButton != null) {
                    i11 = R.id.title;
                    TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view, R.id.title);
                    if (talabatToolBarTextView != null) {
                        i11 = R.id.toolbar;
                        TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view, R.id.toolbar);
                        if (talabatToolBar != null) {
                            return new NotificationsBinding(drawerLayout2, drawerLayout2, recyclerView, linearLayout, talabatToolBarImageButton, talabatToolBarTextView, talabatToolBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static NotificationsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static NotificationsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.notifications, viewGroup, false);
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
