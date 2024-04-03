package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarLinearLayoutContainer;
import com.talabat.helpers.TalabatToolBarNotificationTextView;
import com.talabat.helpers.TalabatToolBarRelativeLayoutContainer;
import com.talabat.helpers.TalabatToolBarTextView;

public final class AboutUsScreenBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout aboutUsFacebookView;
    @NonNull
    public final RelativeLayout aboutUsFaqView;
    @NonNull
    public final RelativeLayout aboutUsFeedbackView;
    @NonNull
    public final RelativeLayout aboutUsPrivacyPolicyView;
    @NonNull
    public final RelativeLayout aboutUsSocRespView;
    @NonNull
    public final RelativeLayout aboutUsTwitterView;
    @NonNull
    public final RelativeLayout aboutUsUseInstagramView;
    @NonNull
    public final RelativeLayout aboutUsUseTermsView;
    @NonNull
    public final RelativeLayout aboutUsView;
    @NonNull
    public final TalabatTextView appVersionText;
    @NonNull
    public final DrawerLayout drawerLayout;
    @NonNull
    public final RecyclerView listSlidemenu;
    @NonNull
    public final TalabatToolBarLinearLayoutContainer mainLayout;
    @NonNull
    public final NestedScrollView nestedScrollview;
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
    public final TalabatToolBarRelativeLayoutContainer versionView;

    private AboutUsScreenBinding(@NonNull DrawerLayout drawerLayout2, @NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull RelativeLayout relativeLayout3, @NonNull RelativeLayout relativeLayout4, @NonNull RelativeLayout relativeLayout5, @NonNull RelativeLayout relativeLayout6, @NonNull RelativeLayout relativeLayout7, @NonNull RelativeLayout relativeLayout8, @NonNull RelativeLayout relativeLayout9, @NonNull TalabatTextView talabatTextView, @NonNull DrawerLayout drawerLayout3, @NonNull RecyclerView recyclerView, @NonNull TalabatToolBarLinearLayoutContainer talabatToolBarLinearLayoutContainer, @NonNull NestedScrollView nestedScrollView, @NonNull TalabatToolBarNotificationTextView talabatToolBarNotificationTextView, @NonNull RelativeLayout relativeLayout10, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull FrameLayout frameLayout, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar, @NonNull TalabatToolBarRelativeLayoutContainer talabatToolBarRelativeLayoutContainer) {
        this.rootView = drawerLayout2;
        this.aboutUsFacebookView = relativeLayout;
        this.aboutUsFaqView = relativeLayout2;
        this.aboutUsFeedbackView = relativeLayout3;
        this.aboutUsPrivacyPolicyView = relativeLayout4;
        this.aboutUsSocRespView = relativeLayout5;
        this.aboutUsTwitterView = relativeLayout6;
        this.aboutUsUseInstagramView = relativeLayout7;
        this.aboutUsUseTermsView = relativeLayout8;
        this.aboutUsView = relativeLayout9;
        this.appVersionText = talabatTextView;
        this.drawerLayout = drawerLayout3;
        this.listSlidemenu = recyclerView;
        this.mainLayout = talabatToolBarLinearLayoutContainer;
        this.nestedScrollview = nestedScrollView;
        this.notificationBuble = talabatToolBarNotificationTextView;
        this.parentLayout = relativeLayout10;
        this.sidemenuButton = talabatToolBarImageButton;
        this.sidemenuButtonContainer = frameLayout;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
        this.versionView = talabatToolBarRelativeLayoutContainer;
    }

    @NonNull
    public static AboutUsScreenBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.about_us_facebook_view;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.about_us_facebook_view);
        if (relativeLayout != null) {
            i11 = R.id.about_us_faq_view;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.about_us_faq_view);
            if (relativeLayout2 != null) {
                i11 = R.id.about_us_feedback_view;
                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.about_us_feedback_view);
                if (relativeLayout3 != null) {
                    i11 = R.id.about_us_privacy_policy_view;
                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.about_us_privacy_policy_view);
                    if (relativeLayout4 != null) {
                        i11 = R.id.about_us_soc_resp_view;
                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.about_us_soc_resp_view);
                        if (relativeLayout5 != null) {
                            i11 = R.id.about_us_twitter_view;
                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.about_us_twitter_view);
                            if (relativeLayout6 != null) {
                                i11 = R.id.about_us_use_instagram_view;
                                RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.about_us_use_instagram_view);
                                if (relativeLayout7 != null) {
                                    i11 = R.id.about_us_use_terms_view;
                                    RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.about_us_use_terms_view);
                                    if (relativeLayout8 != null) {
                                        i11 = R.id.about_us_view;
                                        RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.about_us_view);
                                        if (relativeLayout9 != null) {
                                            i11 = R.id.app_version_text;
                                            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.app_version_text);
                                            if (talabatTextView != null) {
                                                DrawerLayout drawerLayout2 = (DrawerLayout) view2;
                                                i11 = R.id.list_slidemenu;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.list_slidemenu);
                                                if (recyclerView != null) {
                                                    i11 = R.id.main_layout;
                                                    TalabatToolBarLinearLayoutContainer talabatToolBarLinearLayoutContainer = (TalabatToolBarLinearLayoutContainer) ViewBindings.findChildViewById(view2, R.id.main_layout);
                                                    if (talabatToolBarLinearLayoutContainer != null) {
                                                        i11 = R.id.nested_scrollview;
                                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, R.id.nested_scrollview);
                                                        if (nestedScrollView != null) {
                                                            i11 = R.id.notification_buble;
                                                            TalabatToolBarNotificationTextView talabatToolBarNotificationTextView = (TalabatToolBarNotificationTextView) ViewBindings.findChildViewById(view2, R.id.notification_buble);
                                                            if (talabatToolBarNotificationTextView != null) {
                                                                i11 = R.id.parent_layout;
                                                                RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.parent_layout);
                                                                if (relativeLayout10 != null) {
                                                                    i11 = R.id.sidemenu_button;
                                                                    TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.sidemenu_button);
                                                                    if (talabatToolBarImageButton != null) {
                                                                        i11 = R.id.sidemenu_button_container;
                                                                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.sidemenu_button_container);
                                                                        if (frameLayout != null) {
                                                                            i11 = R.id.title;
                                                                            TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                                            if (talabatToolBarTextView != null) {
                                                                                i11 = R.id.toolbar;
                                                                                TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                                if (talabatToolBar != null) {
                                                                                    i11 = R.id.version_view;
                                                                                    TalabatToolBarRelativeLayoutContainer talabatToolBarRelativeLayoutContainer = (TalabatToolBarRelativeLayoutContainer) ViewBindings.findChildViewById(view2, R.id.version_view);
                                                                                    if (talabatToolBarRelativeLayoutContainer != null) {
                                                                                        return new AboutUsScreenBinding(drawerLayout2, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, relativeLayout8, relativeLayout9, talabatTextView, drawerLayout2, recyclerView, talabatToolBarLinearLayoutContainer, nestedScrollView, talabatToolBarNotificationTextView, relativeLayout10, talabatToolBarImageButton, frameLayout, talabatToolBarTextView, talabatToolBar, talabatToolBarRelativeLayoutContainer);
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
    public static AboutUsScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static AboutUsScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.about_us_screen, viewGroup, false);
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
