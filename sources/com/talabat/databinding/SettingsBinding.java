package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarButton;
import com.talabat.helpers.TalabatToolBarNotificationTextView;
import com.talabat.helpers.TalabatToolBarTextView;

public final class SettingsBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView appVersionText;
    @NonNull
    public final FrameLayout countrySeperator;
    @NonNull
    public final LinearLayout countryView;
    @NonNull
    public final TalabatTextView designSystemText;
    @NonNull
    public final LinearLayout designSystemView;
    @NonNull
    public final DrawerLayout drawerLayout;
    @NonNull
    public final LinearLayout languageView;
    @NonNull
    public final RecyclerView listSlidemenu;
    @NonNull
    public final TalabatTextView logoutText;
    @NonNull
    public final LinearLayout logoutView;
    @NonNull
    public final TalabatToolBarNotificationTextView notificationBuble;
    @NonNull
    public final CardView pushnotificationView;
    @NonNull
    private final DrawerLayout rootView;
    @NonNull
    public final NestedScrollView scrollView1;
    @NonNull
    public final RelativeLayout settingsAccountInfoView;
    @NonNull
    public final RelativeLayout settingsCardPaymentView;
    @NonNull
    public final RelativeLayout settingsChangeEmailView;
    @NonNull
    public final RelativeLayout settingsChangePasswordView;
    @NonNull
    public final TalabatToolBarButton settingsLogOut;
    @NonNull
    public final CardView settingsLoggedInUserView;
    @NonNull
    public final Switch settingsNotificationSwitch;
    @NonNull
    public final RelativeLayout settingsSavedAddressesView;
    @NonNull
    public final TalabatTextView settingsSelectedCountry;
    @NonNull
    public final TalabatTextView settingsSelectedLanguage;
    @NonNull
    public final ImageButton sidemenuButton;
    @NonNull
    public final FrameLayout sidemenuButtonContainer;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;

    private SettingsBinding(@NonNull DrawerLayout drawerLayout2, @NonNull TalabatTextView talabatTextView, @NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView2, @NonNull LinearLayout linearLayout2, @NonNull DrawerLayout drawerLayout3, @NonNull LinearLayout linearLayout3, @NonNull RecyclerView recyclerView, @NonNull TalabatTextView talabatTextView3, @NonNull LinearLayout linearLayout4, @NonNull TalabatToolBarNotificationTextView talabatToolBarNotificationTextView, @NonNull CardView cardView, @NonNull NestedScrollView nestedScrollView, @NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull RelativeLayout relativeLayout3, @NonNull RelativeLayout relativeLayout4, @NonNull TalabatToolBarButton talabatToolBarButton, @NonNull CardView cardView2, @NonNull Switch switchR, @NonNull RelativeLayout relativeLayout5, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatTextView talabatTextView5, @NonNull ImageButton imageButton, @NonNull FrameLayout frameLayout2, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = drawerLayout2;
        this.appVersionText = talabatTextView;
        this.countrySeperator = frameLayout;
        this.countryView = linearLayout;
        this.designSystemText = talabatTextView2;
        this.designSystemView = linearLayout2;
        this.drawerLayout = drawerLayout3;
        this.languageView = linearLayout3;
        this.listSlidemenu = recyclerView;
        this.logoutText = talabatTextView3;
        this.logoutView = linearLayout4;
        this.notificationBuble = talabatToolBarNotificationTextView;
        this.pushnotificationView = cardView;
        this.scrollView1 = nestedScrollView;
        this.settingsAccountInfoView = relativeLayout;
        this.settingsCardPaymentView = relativeLayout2;
        this.settingsChangeEmailView = relativeLayout3;
        this.settingsChangePasswordView = relativeLayout4;
        this.settingsLogOut = talabatToolBarButton;
        this.settingsLoggedInUserView = cardView2;
        this.settingsNotificationSwitch = switchR;
        this.settingsSavedAddressesView = relativeLayout5;
        this.settingsSelectedCountry = talabatTextView4;
        this.settingsSelectedLanguage = talabatTextView5;
        this.sidemenuButton = imageButton;
        this.sidemenuButtonContainer = frameLayout2;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
    }

    @NonNull
    public static SettingsBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.app_version_text;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.app_version_text);
        if (talabatTextView != null) {
            i11 = R.id.country_seperator;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.country_seperator);
            if (frameLayout != null) {
                i11 = R.id.country_view;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.country_view);
                if (linearLayout != null) {
                    i11 = R.id.design_system_text;
                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.design_system_text);
                    if (talabatTextView2 != null) {
                        i11 = R.id.design_system_view;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.design_system_view);
                        if (linearLayout2 != null) {
                            DrawerLayout drawerLayout2 = (DrawerLayout) view2;
                            i11 = R.id.language_view;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.language_view);
                            if (linearLayout3 != null) {
                                i11 = R.id.list_slidemenu;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.list_slidemenu);
                                if (recyclerView != null) {
                                    i11 = R.id.logout_text;
                                    TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.logout_text);
                                    if (talabatTextView3 != null) {
                                        i11 = R.id.logout_view;
                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.logout_view);
                                        if (linearLayout4 != null) {
                                            i11 = R.id.notification_buble;
                                            TalabatToolBarNotificationTextView talabatToolBarNotificationTextView = (TalabatToolBarNotificationTextView) ViewBindings.findChildViewById(view2, R.id.notification_buble);
                                            if (talabatToolBarNotificationTextView != null) {
                                                i11 = R.id.pushnotification_view;
                                                CardView cardView = (CardView) ViewBindings.findChildViewById(view2, R.id.pushnotification_view);
                                                if (cardView != null) {
                                                    i11 = R.id.scrollView1;
                                                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, R.id.scrollView1);
                                                    if (nestedScrollView != null) {
                                                        i11 = R.id.settings_account_info_view;
                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.settings_account_info_view);
                                                        if (relativeLayout != null) {
                                                            i11 = R.id.settings_card_payment_view;
                                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.settings_card_payment_view);
                                                            if (relativeLayout2 != null) {
                                                                i11 = R.id.settings_change_email_view;
                                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.settings_change_email_view);
                                                                if (relativeLayout3 != null) {
                                                                    i11 = R.id.settings_change_password_view;
                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.settings_change_password_view);
                                                                    if (relativeLayout4 != null) {
                                                                        i11 = R.id.settings_log_out;
                                                                        TalabatToolBarButton talabatToolBarButton = (TalabatToolBarButton) ViewBindings.findChildViewById(view2, R.id.settings_log_out);
                                                                        if (talabatToolBarButton != null) {
                                                                            i11 = R.id.settings_logged_in_user_view;
                                                                            CardView cardView2 = (CardView) ViewBindings.findChildViewById(view2, R.id.settings_logged_in_user_view);
                                                                            if (cardView2 != null) {
                                                                                i11 = R.id.settings_notification_switch;
                                                                                Switch switchR = (Switch) ViewBindings.findChildViewById(view2, R.id.settings_notification_switch);
                                                                                if (switchR != null) {
                                                                                    i11 = R.id.settings_saved_addresses_view;
                                                                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.settings_saved_addresses_view);
                                                                                    if (relativeLayout5 != null) {
                                                                                        i11 = R.id.settings_selected_country;
                                                                                        TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.settings_selected_country);
                                                                                        if (talabatTextView4 != null) {
                                                                                            i11 = R.id.settings_selected_language;
                                                                                            TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.settings_selected_language);
                                                                                            if (talabatTextView5 != null) {
                                                                                                i11 = R.id.sidemenu_button;
                                                                                                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view2, R.id.sidemenu_button);
                                                                                                if (imageButton != null) {
                                                                                                    i11 = R.id.sidemenu_button_container;
                                                                                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.sidemenu_button_container);
                                                                                                    if (frameLayout2 != null) {
                                                                                                        i11 = R.id.title;
                                                                                                        TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                                                                        if (talabatToolBarTextView != null) {
                                                                                                            i11 = R.id.toolbar;
                                                                                                            TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                                                            if (talabatToolBar != null) {
                                                                                                                return new SettingsBinding(drawerLayout2, talabatTextView, frameLayout, linearLayout, talabatTextView2, linearLayout2, drawerLayout2, linearLayout3, recyclerView, talabatTextView3, linearLayout4, talabatToolBarNotificationTextView, cardView, nestedScrollView, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, talabatToolBarButton, cardView2, switchR, relativeLayout5, talabatTextView4, talabatTextView5, imageButton, frameLayout2, talabatToolBarTextView, talabatToolBar);
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
    public static SettingsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static SettingsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.settings, viewGroup, false);
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
