package com.talabat;

import JsonModels.Response.GEMResponse.GemAdapterRestaurant;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import buisnessmodels.GEMEngine;
import buisnessmodels.TalabatFormatter;
import com.bumptech.glide.Glide;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.geminterfaces.OnGemMinimize;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.restaurants.v2.adapters.GemVendorsAdapter;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.Gem;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.Collections;
import library.talabat.gemengine.GemView;
import tracking.AppTracker;
import tracking.ScreenNames;
import ue.e6;
import v00.a;

public class GemDialogSwitcher implements GemView {
    public static final int GEM_ALERT_DIALOG = 1;
    public static final int GEM_CONFIRMATION_DIALOG = 4;
    public static final int GEM_MULTIPLE_RESTAURANT_DIALOG = 3;
    public static final int GEM_TIMEOUT_DIALOG = 2;
    public static int selectedDialog;
    /* access modifiers changed from: private */
    public Activity activity;
    private Button addMoreItem;

    /* renamed from: b  reason: collision with root package name */
    public Handler f54061b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f54062c;
    private ImageView closeDialog;
    private TextView confirmatioDialog;
    private TextView contToChechout;
    public Dialog dialog;
    private ImageView gemLogo;
    /* access modifiers changed from: private */
    public boolean isShowing = true;
    private TextView leaveOfferButton;
    private ArrayList<Restaurant> mGemRestaurants;
    private RecyclerView mRecyclerViewRestaurants;
    private FrameLayout mRestaurantsRecyclerViewContainer;
    /* access modifiers changed from: private */
    public OnGemAlertDialogClickListener onGemAlertDialogClickListener;
    /* access modifiers changed from: private */
    public OnGemMinimize onGemMinimize;
    /* access modifiers changed from: private */
    public String presentScreenName;
    private View tier1Content;
    private TextView tier1Currency;
    private TextView tier1Discount;
    private TextView tier1Offer;
    private View tier2Content;
    private TextView tier2Currency;
    private TextView tier2Discount;
    private TextView tier2Offer;
    private View tier3Content;
    private TextView tier3Currency;
    private TextView tier3Discount;
    private TextView tier3Offer;
    private View tier4Content;
    private TextView tier4Currency;
    private TextView tier4Discount;
    private TextView tier4Offer;
    private LinearLayout tierContainer;
    private LinearLayout tierHolder;
    private ImageView timedOutTimer;
    private TextView timerText;

    public GemDialogSwitcher(Activity activity2, OnGemAlertDialogClickListener onGemAlertDialogClickListener2, String str) {
        this.activity = activity2;
        TalabatUtils.changeLocale(activity2, GlobalDataModel.SelectedLanguage);
        this.onGemAlertDialogClickListener = onGemAlertDialogClickListener2;
        this.presentScreenName = str;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$gemMultipleRestaurantView$0(GemAdapterRestaurant gemAdapterRestaurant, GemAdapterRestaurant gemAdapterRestaurant2) {
        return gemAdapterRestaurant2.status - gemAdapterRestaurant.status;
    }

    public ObjectAnimator createArrowAnimator(View view, float f11, float f12) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", new float[]{f11, f12});
        ofFloat.setDuration(400);
        ofFloat.setInterpolator(new LinearInterpolator());
        return ofFloat;
    }

    public void gemAlertDialogView(final Dialog dialog2, final boolean z11) {
        dialog2.setContentView(R.layout.gem_alert);
        this.timerText = (TextView) dialog2.findViewById(R.id.time_text_view);
        this.closeDialog = (ImageView) dialog2.findViewById(R.id.imageView_close);
        TextView textView = (TextView) dialog2.findViewById(R.id.main_text_title);
        ImageView imageView = (ImageView) dialog2.findViewById(R.id.gem_logo);
        Button button = (Button) dialog2.findViewById(R.id.still_interested);
        TextView textView2 = (TextView) dialog2.findViewById(R.id.time_out_msg_txt);
        this.leaveOfferButton = (TextView) dialog2.findViewById(R.id.leaveoffer_button);
        LinearLayout linearLayout = (LinearLayout) dialog2.findViewById(R.id.timeout_main);
        LinearLayout linearLayout2 = (LinearLayout) dialog2.findViewById(R.id.gem_offer_view);
        this.timedOutTimer = (ImageView) dialog2.findViewById(R.id.sand_timer_timed_out);
        this.tier1Content = dialog2.findViewById(R.id.tier1_content);
        this.tier2Content = dialog2.findViewById(R.id.tier2_content);
        this.tier3Content = dialog2.findViewById(R.id.tier3_content);
        this.tier4Content = dialog2.findViewById(R.id.tier4_content);
        this.tier1Offer = (TextView) dialog2.findViewById(R.id.tier1_offer);
        this.tier2Offer = (TextView) dialog2.findViewById(R.id.tier2_offer);
        this.tier3Offer = (TextView) dialog2.findViewById(R.id.tier3_offer);
        this.tier4Offer = (TextView) dialog2.findViewById(R.id.tier4_offer);
        this.tier1Discount = (TextView) dialog2.findViewById(R.id.tier1_disc);
        this.tier2Discount = (TextView) dialog2.findViewById(R.id.tier2_disc);
        this.tier3Discount = (TextView) dialog2.findViewById(R.id.tier3_disc);
        this.tier4Discount = (TextView) dialog2.findViewById(R.id.tier4_disc);
        this.tier1Currency = (TextView) dialog2.findViewById(R.id.tier1_currency);
        this.tier2Currency = (TextView) dialog2.findViewById(R.id.tier2_currency);
        this.tier3Currency = (TextView) dialog2.findViewById(R.id.tier3_currency);
        this.tier4Currency = (TextView) dialog2.findViewById(R.id.tier4_currency);
        this.tierContainer = (LinearLayout) dialog2.findViewById(R.id.tier_container);
        if (z11) {
            Activity activity2 = this.activity;
            if (activity2 != null && !activity2.isFinishing()) {
                Glide.with(this.activity.getApplicationContext()).load(Integer.valueOf(R.raw.gem_gif_logo)).into(imageView);
            }
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(0);
            this.closeDialog.setVisibility(8);
            this.leaveOfferButton.setVisibility(0);
            button.setText(R.string.still_interested);
            textView.setText(R.string.sure_to_leave);
            String currencySymbol = TalabatFormatter.getInstance().getCurrencySymbol();
            if (GEMEngine.getInstance().getGems() != null && GEMEngine.getInstance().getGems().size() > 0) {
                ArrayList<Gem> gems = GEMEngine.getInstance().getGems();
                if (gems.get(0).getConditionAmount() <= 0.0f || gems.get(0).getDeductionValue() <= 0.0f) {
                    this.tier1Content.setVisibility(4);
                } else {
                    this.tier1Content.setVisibility(0);
                    this.tier1Currency.setText(currencySymbol);
                    this.tier1Offer.setText(TalabatFormatter.getInstance().getGemFormattedCurrency(gems.get(0).getConditionAmount(), true));
                    this.tier1Discount.setText(TalabatFormatter.getInstance().getGemFormattedCurrency(gems.get(0).getDeductionValue(), false));
                }
                if (gems.get(1).getConditionAmount() <= 0.0f || gems.get(1).getDeductionValue() <= 0.0f) {
                    this.tier2Content.setVisibility(4);
                } else {
                    this.tier2Content.setVisibility(0);
                    this.tier2Currency.setText(currencySymbol);
                    this.tier2Offer.setText(TalabatFormatter.getInstance().getGemFormattedCurrency(gems.get(1).getConditionAmount(), true));
                    this.tier2Discount.setText(TalabatFormatter.getInstance().getGemFormattedCurrency(gems.get(1).getDeductionValue(), false));
                }
                if (gems.get(2).getConditionAmount() <= 0.0f || gems.get(2).getDeductionValue() <= 0.0f) {
                    this.tier3Content.setVisibility(4);
                } else {
                    this.tier3Content.setVisibility(0);
                    this.tier3Currency.setText(currencySymbol);
                    this.tier3Offer.setText(TalabatFormatter.getInstance().getGemFormattedCurrency(gems.get(2).getConditionAmount(), true));
                    this.tier3Discount.setText(TalabatFormatter.getInstance().getGemFormattedCurrency(gems.get(2).getDeductionValue(), false));
                }
                if (gems.size() == 4) {
                    this.tierContainer.setWeightSum(4.0f);
                    this.tier3Content.setBackground(getGemContext().getResources().getDrawable(R.drawable.gem_layout_rounded_red));
                    this.tier4Content.setBackground(getGemContext().getResources().getDrawable(R.drawable.gem_layout_rounded_purple));
                    if (gems.get(3).getConditionAmount() <= 0.0f || gems.get(3).getDeductionValue() <= 0.0f) {
                        this.tier4Content.setVisibility(8);
                    } else {
                        this.tier4Content.setVisibility(0);
                        this.tier4Currency.setText(currencySymbol);
                        this.tier4Offer.setText(TalabatFormatter.getInstance().getGemFormattedCurrency(gems.get(3).getConditionAmount(), true));
                        this.tier4Discount.setText(TalabatFormatter.getInstance().getGemFormattedCurrency(gems.get(3).getDeductionValue(), false));
                    }
                } else {
                    this.tier3Content.setBackground(getGemContext().getResources().getDrawable(R.drawable.gem_layout_rounded_purple));
                    this.tierContainer.setWeightSum(3.0f);
                    this.tier4Content.setVisibility(8);
                }
            }
        } else {
            OnGemMinimize onGemMinimize2 = this.onGemMinimize;
            if (onGemMinimize2 != null) {
                onGemMinimize2.timeOut();
            }
            textView.setText(R.string.gem_expire);
            imageView.setImageResource(R.drawable.gem_logo_expired);
            linearLayout.setVisibility(0);
            linearLayout2.setVisibility(8);
            if (this.presentScreenName.equals("Restaurant List Screen")) {
                button.setText(R.string.gem_continue_ordering);
                this.leaveOfferButton.setVisibility(8);
                this.closeDialog.setVisibility(8);
            } else if (this.presentScreenName.equals(ScreenNames.RESTAURANTMENU) || this.presentScreenName.equals(ScreenNames.RESTAURANTMENU_SEARCH) || this.presentScreenName.equals("Cart Screen") || this.presentScreenName.equals(ScreenNames.ITEM_DETAILS_SCREEN) || this.presentScreenName.equals(ScreenNames.ITEM_CHOICE_SCREEN)) {
                button.setText(R.string.gem_back_to_restaurant_btn);
                this.leaveOfferButton.setText(R.string.gem_continue_ordering);
                this.leaveOfferButton.setVisibility(0);
                this.closeDialog.setVisibility(8);
            } else if (this.presentScreenName.equals("Checkout Screen")) {
                button.setText(R.string.gem_back_to_menu_btn);
                this.leaveOfferButton.setText(R.string.gem_continue_ordering);
                this.leaveOfferButton.setVisibility(0);
                this.closeDialog.setVisibility(8);
            } else if (this.presentScreenName.equals(ScreenNames.PAYMENT_WEBVIEW_SCREEN) || this.presentScreenName.equals(ScreenNames.CHECKOUT_DOT_COM_SCREEN_CREDIT) || this.presentScreenName.equals(ScreenNames.CHECKOUT_DOT_COM_SCREEN_DEBIT) || this.presentScreenName.equals(ScreenNames.PAYMENTERRORSCREEN)) {
                button.setText(R.string.gem_back_to_menu_btn);
                this.leaveOfferButton.setText(R.string.back_to_checkout);
                this.leaveOfferButton.setVisibility(0);
                this.closeDialog.setVisibility(8);
            } else {
                button.setText(R.string.gem_back_to_menu_btn);
                this.leaveOfferButton.setText(R.string.gem_continue_ordering);
                this.leaveOfferButton.setVisibility(0);
                this.closeDialog.setVisibility(8);
            }
            ImageView imageView2 = this.timedOutTimer;
            if (imageView2 != null) {
                shakeImage(imageView2);
            }
            if (GEMEngine.getInstance() != null) {
                GEMEngine.getInstance().rejectGem(false);
            }
        }
        this.closeDialog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GemDialogSwitcher.this.isShowing = false;
                GemDialogSwitcher.this.stopTimer();
                GemDialogSwitcher.this.onGemAlertDialogClickListener.onCloseButtonClicked(dialog2);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String str;
                GemDialogSwitcher.this.isShowing = false;
                if (z11) {
                    Activity b11 = GemDialogSwitcher.this.activity;
                    if (GEMEngine.getInstance() != null) {
                        str = GEMEngine.getInstance().getTimeInSeconds();
                    } else {
                        str = "";
                    }
                    AppTracker.onJokerResumeAccepted(b11, str, GlobalDataModel.SELECTED.restaurant);
                    dialog2.hide();
                    return;
                }
                if (GemDialogSwitcher.this.presentScreenName.equals(ScreenNames.RESTAURANTMENU) || GemDialogSwitcher.this.presentScreenName.equals(ScreenNames.RESTAURANTMENU_SEARCH) || GemDialogSwitcher.this.presentScreenName.equals("Cart Screen") || GemDialogSwitcher.this.presentScreenName.equals(ScreenNames.ITEM_DETAILS_SCREEN) || GemDialogSwitcher.this.presentScreenName.equals(ScreenNames.ITEM_CHOICE_SCREEN)) {
                    GemDialogSwitcher.this.onGemAlertDialogClickListener.onBackToRestaurantPage(dialog2);
                } else if (GemDialogSwitcher.this.presentScreenName.equals(ScreenNames.PAYMENT_WEBVIEW_SCREEN) || GemDialogSwitcher.this.presentScreenName.equals(ScreenNames.CHECKOUT_DOT_COM_SCREEN_CREDIT) || GemDialogSwitcher.this.presentScreenName.equals(ScreenNames.CHECKOUT_DOT_COM_SCREEN_DEBIT) || GemDialogSwitcher.this.presentScreenName.equals(ScreenNames.PAYMENTERRORSCREEN) || GemDialogSwitcher.this.presentScreenName.equals("Checkout Screen")) {
                    GemDialogSwitcher.this.onGemAlertDialogClickListener.onBackToRestaurantMenuPage(dialog2);
                } else {
                    GemDialogSwitcher.this.onGemAlertDialogClickListener.onBackToRestaurantMenuPage(dialog2);
                }
                dialog2.dismiss();
            }
        });
        this.leaveOfferButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String str;
                GemDialogSwitcher.this.stopTimer();
                if (z11) {
                    Activity b11 = GemDialogSwitcher.this.activity;
                    if (GEMEngine.getInstance() != null) {
                        str = GEMEngine.getInstance().getTimeInSeconds();
                    } else {
                        str = "";
                    }
                    AppTracker.onJokerResumeRejected(b11, str, GlobalDataModel.SELECTED.restaurant);
                    GemDialogSwitcher.this.onGemAlertDialogClickListener.onLeaveOfferClicked(false);
                } else if (GemDialogSwitcher.this.presentScreenName.equals(ScreenNames.PAYMENT_WEBVIEW_SCREEN) || GemDialogSwitcher.this.presentScreenName.equals(ScreenNames.CHECKOUT_DOT_COM_SCREEN_CREDIT) || GemDialogSwitcher.this.presentScreenName.equals(ScreenNames.CHECKOUT_DOT_COM_SCREEN_DEBIT) || GemDialogSwitcher.this.presentScreenName.equals(ScreenNames.PAYMENTERRORSCREEN)) {
                    GemDialogSwitcher.this.onGemAlertDialogClickListener.onBackToCheckoutPage(dialog2);
                } else {
                    GemDialogSwitcher.this.onGemAlertDialogClickListener.onLeaveOfferClicked(true);
                    dialog2.dismiss();
                }
            }
        });
    }

    public void gemConfirmationView(final Dialog dialog2) {
        dialog2.setContentView(R.layout.gem_cart_confirmation);
        this.confirmatioDialog = (TextView) dialog2.findViewById(R.id.confiramtion_dialog);
        this.closeDialog = (ImageView) dialog2.findViewById(R.id.imageView_close);
        this.addMoreItem = (Button) dialog2.findViewById(R.id.add_more_item);
        this.contToChechout = (TextView) dialog2.findViewById(R.id.continue_to_checkout);
        ImageView imageView = (ImageView) dialog2.findViewById(R.id.gem_logo);
        if (!this.activity.isFinishing()) {
            Glide.with(this.confirmatioDialog.getContext()).load(Integer.valueOf(R.raw.gem_gif_logo)).into(imageView);
        }
        if (GEMEngine.getInstance().higherGemAvailble(Cart.getInstance().getCartSubTotal(), false) != null) {
            Gem lowestGem = GEMEngine.getInstance().getLowestGem();
            TextView textView = this.confirmatioDialog;
            String string = textView.getContext().getResources().getString(R.string.with_gem_you_can_save_aed);
            String replace = string.replace(RichContentLoadTimeRecorder.DELIMETER, "" + TalabatFormatter.getInstance().getFormattedCurrency(lowestGem.getDiscount()));
            textView.setText(replace.replace("**", "" + TalabatFormatter.getInstance().getFormattedCurrency(lowestGem.getConditionAmount() - Cart.getInstance().getCartSubTotal())));
        }
        this.addMoreItem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GemDialogSwitcher.this.onGemAlertDialogClickListener.onAddMoreItemClicked();
            }
        });
        this.contToChechout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GemDialogSwitcher.this.onGemAlertDialogClickListener.onContinueToCheckout();
                dialog2.hide();
            }
        });
    }

    public void gemMultipleRestaurantView(Dialog dialog2) {
        TalabatUtils.changeLocale(dialog2.getContext(), GlobalDataModel.SelectedLanguage);
        dialog2.setContentView(R.layout.gem_multiple_rest);
        this.timerText = (TextView) dialog2.findViewById(R.id.time_text_view);
        if (GEMEngine.getInstance().getTime() != null) {
            this.timerText.setText(GEMEngine.getInstance().getTime());
        } else {
            this.timerText.setText("0:0");
        }
        this.mRecyclerViewRestaurants = (RecyclerView) dialog2.findViewById(R.id.recyclerView_restaurants);
        TextView textView = (TextView) dialog2.findViewById(R.id.textView_topTitle);
        ImageView imageView = (ImageView) dialog2.findViewById(R.id.imageView_close);
        this.closeDialog = imageView;
        imageView.setImageResource(R.drawable.ic_minimize_gem);
        this.tierHolder = (LinearLayout) dialog2.findViewById(R.id.tier_holder);
        this.tier1Content = dialog2.findViewById(R.id.tier1_content);
        this.tier2Content = dialog2.findViewById(R.id.tier2_content);
        this.tier3Content = dialog2.findViewById(R.id.tier3_content);
        this.tier4Content = dialog2.findViewById(R.id.tier4_content);
        this.tier1Offer = (TextView) dialog2.findViewById(R.id.tier1_offer);
        this.tier2Offer = (TextView) dialog2.findViewById(R.id.tier2_offer);
        this.tier3Offer = (TextView) dialog2.findViewById(R.id.tier3_offer);
        this.tier4Offer = (TextView) dialog2.findViewById(R.id.tier4_offer);
        this.tier1Discount = (TextView) dialog2.findViewById(R.id.tier1_disc);
        this.tier2Discount = (TextView) dialog2.findViewById(R.id.tier2_disc);
        this.tier3Discount = (TextView) dialog2.findViewById(R.id.tier3_disc);
        this.tier4Discount = (TextView) dialog2.findViewById(R.id.tier4_disc);
        this.tier1Currency = (TextView) dialog2.findViewById(R.id.tier1_currency);
        this.tier2Currency = (TextView) dialog2.findViewById(R.id.tier2_currency);
        this.tier3Currency = (TextView) dialog2.findViewById(R.id.tier3_currency);
        this.tier4Currency = (TextView) dialog2.findViewById(R.id.tier4_currency);
        this.gemLogo = (ImageView) dialog2.findViewById(R.id.gem_logo);
        this.mRestaurantsRecyclerViewContainer = (FrameLayout) dialog2.findViewById(R.id.frameLayout_recyclerViewContainer);
        new GemSubtitleBinder().accept((TextView) dialog2.findViewById(R.id.textView_subTitle));
        GlobalDataModel.GEMCONSTANTS.isAdDisableGem = true;
        if (Customer.getInstance().getCustomerInfo().firstName != null && !TextUtils.isEmpty(Customer.getInstance().getCustomerInfo().firstName)) {
            textView.setText(getGemContext().getString(R.string.hey) + " " + Customer.getInstance().getCustomerInfo().firstName + getGemContext().getString(R.string.you_found_gem));
        }
        this.mRestaurantsRecyclerViewContainer.setVisibility(0);
        this.mRecyclerViewRestaurants.setLayoutManager(new LinearLayoutManager(getGemContext()));
        GEMEngine.getInstance();
        ArrayList<GemAdapterRestaurant> gemRestaurants = GEMEngine.getGemRestaurants();
        if (TalabatUtils.isArabic()) {
            Collections.sort(gemRestaurants, new e6());
        }
        this.mRecyclerViewRestaurants.setAdapter(new GemVendorsAdapter(gemRestaurants, this.onGemAlertDialogClickListener));
        Activity activity2 = this.activity;
        if (activity2 != null && !activity2.isFinishing()) {
            this.gemLogo.setImageResource(R.drawable.ic_gem_logo);
        }
        String currencySymbol = TalabatFormatter.getInstance().getCurrencySymbol();
        if (GEMEngine.getInstance().getGems() != null && GEMEngine.getInstance().getGems().size() > 0) {
            ArrayList<Gem> gems = GEMEngine.getInstance().getGems();
            if (gems.get(0).getConditionAmount() <= 0.0f || gems.get(0).getDeductionValue() <= 0.0f) {
                this.tier1Content.setVisibility(4);
            } else {
                this.tier1Content.setVisibility(0);
                this.tier1Currency.setText(currencySymbol);
                this.tier1Offer.setText(String.format("%s %s", new Object[]{getGemContext().getResources().getString(R.string.gem_on), TalabatFormatter.getInstance().getGemFormattedCurrency(gems.get(0).getConditionAmount(), true)}));
                this.tier1Discount.setText(TalabatFormatter.getInstance().getGemFormattedCurrency(gems.get(0).getDeductionValue(), false));
            }
            if (gems.get(1).getConditionAmount() <= 0.0f || gems.get(1).getDeductionValue() <= 0.0f) {
                this.tier2Content.setVisibility(4);
            } else {
                this.tier2Content.setVisibility(0);
                this.tier2Currency.setText(currencySymbol);
                this.tier2Offer.setText(String.format("%s %s", new Object[]{getGemContext().getResources().getString(R.string.gem_on), TalabatFormatter.getInstance().getGemFormattedCurrency(gems.get(1).getConditionAmount(), true)}));
                this.tier2Discount.setText(TalabatFormatter.getInstance().getGemFormattedCurrency(gems.get(1).getDeductionValue(), false));
            }
            if (gems.get(2).getConditionAmount() <= 0.0f || gems.get(2).getDeductionValue() <= 0.0f) {
                this.tier3Content.setVisibility(4);
            } else {
                this.tier3Content.setVisibility(0);
                this.tier3Currency.setText(currencySymbol);
                this.tier3Offer.setText(String.format("%s %s", new Object[]{getGemContext().getResources().getString(R.string.gem_on), TalabatFormatter.getInstance().getGemFormattedCurrency(gems.get(2).getConditionAmount(), true)}));
                this.tier3Discount.setText(TalabatFormatter.getInstance().getGemFormattedCurrency(gems.get(2).getDeductionValue(), false));
            }
            if (gems.size() == 4) {
                this.tierHolder.setWeightSum(4.0f);
                this.tier3Discount.setTextColor(getGemContext().getResources().getColor(R.color.gem_card_3));
                this.tier3Currency.setTextColor(getGemContext().getResources().getColor(R.color.gem_card_3));
                this.tier4Discount.setTextColor(getGemContext().getResources().getColor(R.color.gem_card_4));
                this.tier4Currency.setTextColor(getGemContext().getResources().getColor(R.color.gem_card_4));
                if (gems.get(3).getConditionAmount() <= 0.0f || gems.get(3).getDeductionValue() <= 0.0f) {
                    this.tier4Content.setVisibility(4);
                    return;
                }
                this.tier4Content.setVisibility(0);
                this.tier4Currency.setText(currencySymbol);
                this.tier4Offer.setText(String.format("%s %s", new Object[]{getGemContext().getResources().getString(R.string.gem_on), TalabatFormatter.getInstance().getGemFormattedCurrency(gems.get(3).getConditionAmount(), true)}));
                this.tier4Discount.setText(TalabatFormatter.getInstance().getGemFormattedCurrency(gems.get(3).getDeductionValue(), false));
                return;
            }
            this.tier3Discount.setTextColor(getGemContext().getResources().getColor(R.color.gem_card_4));
            this.tier3Currency.setTextColor(getGemContext().getResources().getColor(R.color.gem_card_4));
            this.tierHolder.setWeightSum(3.0f);
            this.tier4Content.setVisibility(8);
        }
    }

    public Context getGemContext() {
        return this.activity;
    }

    public String getGemScreenType() {
        return ScreenNames.getScreenType(this.presentScreenName);
    }

    public void hideDialog() {
        Dialog dialog2 = this.dialog;
        if (dialog2 != null && dialog2.isShowing()) {
            this.dialog.hide();
        }
    }

    public void initialiseTimer() {
        Handler handler;
        Runnable runnable = this.f54062c;
        if (!(runnable == null || (handler = this.f54061b) == null)) {
            handler.removeCallbacks(runnable);
        }
        this.f54061b = null;
        this.f54062c = null;
    }

    public boolean isDialogShowing() {
        Dialog dialog2 = this.dialog;
        if (dialog2 != null) {
            return dialog2.isShowing();
        }
        return false;
    }

    public void listen() {
        if (GEMEngine.getInstance() != null) {
            GEMEngine.getInstance().startListening(this, false);
        } else {
            this.onGemAlertDialogClickListener.onCloseButtonClicked(this.dialog);
        }
    }

    public void setOnGemMinimizeListener(OnGemMinimize onGemMinimize2) {
        this.onGemMinimize = onGemMinimize2;
    }

    public void shakeImage(ImageView imageView) {
        imageView.setAnimation(AnimationUtils.loadAnimation(this.activity, R.anim.shake));
    }

    public /* synthetic */ void showGemDialog() {
        a.a(this);
    }

    public void showGemDialog(int i11, boolean z11) {
        Dialog dialog2 = new Dialog(this.activity);
        this.dialog = dialog2;
        dialog2.requestWindowFeature(1);
        this.dialog.setCancelable(false);
        if (i11 == 1) {
            gemAlertDialogView(this.dialog, true);
            AppTracker.onJokerResumeShown(this.activity, GlobalDataModel.SELECTED.restaurant, GEMEngine.getInstance() != null ? GEMEngine.getInstance().getTimeInSeconds() : "");
        } else if (i11 == 2) {
            gemAlertDialogView(this.dialog, false);
        } else if (i11 == 3) {
            gemMultipleRestaurantView(this.dialog);
            AppTracker.onJokerLightboxShown(this.activity);
        } else if (i11 != 4) {
            this.isShowing = false;
        } else {
            gemConfirmationView(this.dialog);
        }
        if (z11) {
            listen();
            startTimer();
        }
        this.closeDialog = (ImageView) this.dialog.findViewById(R.id.imageView_close);
        this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.closeDialog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GemDialogSwitcher.this.onGemMinimize.onMinimizeButtonClicked(GemDialogSwitcher.this.dialog);
                GemDialogSwitcher.this.dialog = null;
            }
        });
        this.dialog.getWindow().getAttributes().windowAnimations = R.style.PopupAnimation;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Activity activity2 = this.activity;
            if (activity2 != null && !activity2.isFinishing()) {
                this.activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                this.dialog.getWindow().setGravity(17);
                this.dialog.getWindow().setLayout((int) (((double) displayMetrics.widthPixels) * 0.99d), -2);
                this.dialog.show();
            }
        } catch (Exception e11) {
            LogManager.logException(e11);
        }
    }

    public void showInAppReminder(int i11) {
        Activity activity2 = this.activity;
        String string = activity2.getString(R.string.gem_order_notification);
        Toast.makeText(activity2, string.replace("#", "" + i11), 0).show();
    }

    public void showTimeOutDialog() {
        stopTimer();
        Dialog dialog2 = this.dialog;
        if (dialog2 != null) {
            gemAlertDialogView(dialog2, false);
        } else {
            showGemDialog(2, false);
        }
    }

    public void showTimerView(boolean z11, String str) {
        this.timerText.setText(str);
        OnGemMinimize onGemMinimize2 = this.onGemMinimize;
        if (onGemMinimize2 != null) {
            onGemMinimize2.setFloatingGemTimer(str);
        }
    }

    public void startTimer() {
        initialiseTimer();
    }

    public /* synthetic */ void stopLoading() {
        a.e(this);
    }

    public void stopTimer() {
        Handler handler;
        Runnable runnable = this.f54062c;
        if (runnable != null && (handler = this.f54061b) != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
