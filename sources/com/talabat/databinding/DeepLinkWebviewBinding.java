package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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

public final class DeepLinkWebviewBinding implements ViewBinding {
    @NonNull
    public final DrawerLayout drawerLayout;
    @NonNull
    public final RecyclerView listSlidemenu;
    @NonNull
    public final LinearLayout mainLayout;
    @NonNull
    public final TalabatToolBarNotificationTextView notificationBuble;
    @NonNull
    public final RelativeLayout parentLayout;
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
    @NonNull
    public final WebView webview;
    @NonNull
    public final ProgressBar webviewProgress;

    private DeepLinkWebviewBinding(@NonNull DrawerLayout drawerLayout2, @NonNull DrawerLayout drawerLayout3, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout, @NonNull TalabatToolBarNotificationTextView talabatToolBarNotificationTextView, @NonNull RelativeLayout relativeLayout, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull FrameLayout frameLayout, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar, @NonNull WebView webView, @NonNull ProgressBar progressBar) {
        this.rootView = drawerLayout2;
        this.drawerLayout = drawerLayout3;
        this.listSlidemenu = recyclerView;
        this.mainLayout = linearLayout;
        this.notificationBuble = talabatToolBarNotificationTextView;
        this.parentLayout = relativeLayout;
        this.sidemenuButton = talabatToolBarImageButton;
        this.sidemenuButtonContainer = frameLayout;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
        this.webview = webView;
        this.webviewProgress = progressBar;
    }

    @NonNull
    public static DeepLinkWebviewBinding bind(@NonNull View view) {
        DrawerLayout drawerLayout2 = (DrawerLayout) view;
        int i11 = R.id.list_slidemenu;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.list_slidemenu);
        if (recyclerView != null) {
            i11 = R.id.main_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.main_layout);
            if (linearLayout != null) {
                i11 = R.id.notification_buble;
                TalabatToolBarNotificationTextView talabatToolBarNotificationTextView = (TalabatToolBarNotificationTextView) ViewBindings.findChildViewById(view, R.id.notification_buble);
                if (talabatToolBarNotificationTextView != null) {
                    i11 = R.id.parent_layout;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.parent_layout);
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
                                        i11 = R.id.webview;
                                        WebView webView = (WebView) ViewBindings.findChildViewById(view, R.id.webview);
                                        if (webView != null) {
                                            i11 = R.id.webview_progress;
                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.webview_progress);
                                            if (progressBar != null) {
                                                return new DeepLinkWebviewBinding(drawerLayout2, drawerLayout2, recyclerView, linearLayout, talabatToolBarNotificationTextView, relativeLayout, talabatToolBarImageButton, frameLayout, talabatToolBarTextView, talabatToolBar, webView, progressBar);
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
    public static DeepLinkWebviewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DeepLinkWebviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.deep_link_webview, viewGroup, false);
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
