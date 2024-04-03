package com.talabat;

import JsonModels.MenuItemRM;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceItemModel;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceResponse;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Cart;
import buisnessmodels.GEMEngine;
import buisnessmodels.TalabatFormatter;
import com.android.volley.VolleyError;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.adapters.ItemChoicesRevampedAdapter;
import com.talabat.adapters.OptionalItemAdapters;
import com.talabat.adapters.RequiredItemRevampedAdapter;
import com.talabat.adapters.viewholder.RequiredItemRevampedViewHolder;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.details.DaggerItemDetailsRevampedActivityComponent;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.lib.Integration;
import com.talabat.restaurants.RestaurantsListScreenRefactor;
import com.talabat.talabatcommon.helpers.GlideApp;
import com.talabat.talabatcommon.helpers.TalabatGlideModule;
import datamodels.CartMenuItem;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import datamodels.MenuItem;
import datamodels.MenuSection;
import datamodels.Restaurant;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.inject.Inject;
import library.talabat.gemengine.GemView;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.itemdetails.IItemDetailsPresenterR;
import library.talabat.mvp.itemdetails.ItemDetailsPresenterR;
import library.talabat.mvp.itemdetails.ItemDetailsViewR;
import tracking.AppTracker;
import tracking.ScreenNames;
import ue.n9;
import ue.o9;
import ue.p9;
import ue.q9;

public class ItemDetailsRevampedActivity extends TalabatBase implements ItemDetailsViewR, View.OnClickListener, RequiredItemRevampedAdapter.OnItemSelectedListener, RequiredItemRevampedViewHolder.OnItemSelectedListener, GemView, OnGemAlertDialogClickListener, OptionalItemAdapters.OnMultipleItemsSelectorListener {
    private ProgressBar choiceSelectionProgress;
    private ImageView closePageButton;
    /* access modifiers changed from: private */
    public View contentView;
    private View gemFooterView;

    /* renamed from: i  reason: collision with root package name */
    public InputMethodManager f54256i;
    private View imageContainer;

    /* renamed from: j  reason: collision with root package name */
    public IItemDetailsPresenterR f54257j;

    /* renamed from: k  reason: collision with root package name */
    public ItemChoicesRevampedAdapter f54258k;

    /* renamed from: l  reason: collision with root package name */
    public GemFooterCartView f54259l;
    private LinearLayoutManager linearLayoutManager;

    /* renamed from: m  reason: collision with root package name */
    public ArrayList<ChoiceSection> f54260m;
    private AppBarLayout mAppBar;
    private Button mButtonAddToCart;
    /* access modifiers changed from: private */
    public CollapsingToolbarLayout mCollapseToolbar;
    /* access modifiers changed from: private */
    public TalabatEditText mEditTextSpecialRequest;
    private GemDialogSwitcher mGemDialogSwitcher;
    private ImageButton mImageButtonMinus;
    private ImageButton mImageButtonPlus;
    private ImageView mImageViewHeader;
    private RecyclerView mRecyclerViewChoicesItems;
    /* access modifiers changed from: private */
    public NestedScrollView mScrollView;
    private TalabatTextView mTextViewItemCount;
    private TalabatTextView mTextViewItemDescription;
    private TalabatTextView mTextViewItemTitle;
    private TextView mTextViewItemTitleToolbar;
    private TextView mTextViewPriceBefore;
    private TalabatTextView mTextViewPriceDetails;
    private TalabatTextView mTextViewTotalPrice;
    private Toolbar mToolBar;
    private View mViewAddToCart;

    /* renamed from: n  reason: collision with root package name */
    public String f54261n = "";
    private ImageView noHeaderCloseButton;
    private View noHeaderImageContainer;
    private ImageView noHeaderImageView;
    @Inject

    /* renamed from: o  reason: collision with root package name */
    public AppVersionProvider f54262o;
    private ArrayList<Integer> receivedChoiceIdList;
    private boolean requestForThirdLevelChoiceSent = false;
    private ArrayList<Integer> requestedThirdChoiceIdList;
    private ChoiceItem selectedChoiceItem;
    private TextView selectedchoices;
    private boolean showChoiceLabel = false;
    private View specialRequestDisabledView;
    /* access modifiers changed from: private */
    public View specialRequestView;

    /* access modifiers changed from: private */
    public void adjustGemFooterPosition(Rect rect) {
        View view = this.gemFooterView;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, Param.Y, new float[]{(float) (rect.bottom - view.getMeasuredHeight())});
        ofFloat.setDuration(0);
        ofFloat.start();
    }

    private void adjustSpecialRequestVisibility() {
        if (this.f54257j.disableSpecialRequest(GlobalDataModel.SELECTED.restaurant)) {
            this.specialRequestDisabledView.setVisibility(0);
            this.specialRequestView.setVisibility(8);
            return;
        }
        this.specialRequestDisabledView.setVisibility(8);
        this.specialRequestView.setVisibility(0);
    }

    private void adjustStatusIconsTint() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
    }

    private void buildUI() {
        this.mCollapseToolbar.setTitle(this.f54257j.getItemName().trim());
        this.mTextViewItemTitle.setText(this.f54257j.getItemName().trim());
        this.mTextViewItemTitleToolbar.setText(this.f54257j.getItemName().trim());
        if (TextUtils.isEmpty(this.f54257j.getItemDescription())) {
            this.mTextViewItemDescription.setVisibility(8);
        } else {
            this.mTextViewItemDescription.setText(this.f54257j.getItemDescription().trim());
            this.mTextViewItemDescription.setVisibility(0);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(GlobalDataModel.SELECTED.cartMenuItem.price);
        String str = "";
        sb2.append(str);
        this.f54261n = sb2.toString();
        if (this.f54257j.isItemHasStartPrice()) {
            GlobalDataModel.MENU.priceOnSelectionItemAvailable = true;
            this.f54261n = GlobalDataModel.SELECTED.cartMenuItem.getStartsWithPrice() + str;
            setPriceInTextViews(getString(R.string.from) + " " + this.f54257j.getItemStartPrice());
        } else if (!this.f54257j.isItemHasDiscount()) {
            setPriceInTextViews(this.f54257j.getItemPrice());
            this.mTextViewPriceBefore.setVisibility(8);
        } else if (Integration.isGemActive()) {
            this.mTextViewPriceBefore.setVisibility(8);
            this.f54261n = GlobalDataModel.SELECTED.cartMenuItem.oldPrice + str;
            setPriceInTextViews(this.f54257j.getItemOldPrice());
        } else {
            this.mTextViewPriceBefore.setText(TalabatFormatter.getInstance().getFormattedCurrency(GlobalDataModel.SELECTED.cartMenuItem.oldPrice));
            this.mTextViewPriceBefore.setVisibility(0);
            TextView textView = this.mTextViewPriceBefore;
            textView.setPaintFlags(textView.getPaintFlags() | 16);
            new GradientDrawable().setStroke(getResources().getDimensionPixelOffset(R.dimen.stroke_1dp), Color.parseColor("#fd7474"));
            setPriceInTextViews(this.f54257j.getItemPrice());
        }
        if (!TalabatUtils.isNullOrEmpty(this.f54257j.getItemImageUrl())) {
            str = this.f54257j.getItemImageUrl().substring(this.f54257j.getItemImageUrl().lastIndexOf("/") + 1).trim();
        }
        String itemImageUrlWithSize = this.f54257j.getItemImageUrlWithSize(Resources.getSystem().getDisplayMetrics().widthPixels);
        ImageView imageView = this.mImageViewHeader;
        final View view = this.imageContainer;
        if (GlobalDataModel.Apptimize.itemDetailsHeaderVariant == GlobalConstants.ITEMDETAILS.noHeaderVariation) {
            imageView = this.noHeaderImageView;
            view = this.noHeaderImageContainer;
            this.mAppBar.setVisibility(8);
            this.noHeaderCloseButton.setVisibility(0);
            this.closePageButton.setVisibility(8);
            this.noHeaderImageContainer.setVisibility(0);
            this.noHeaderImageView.setVisibility(0);
            transparentStatusAndNavigation();
        } else {
            this.mAppBar.setVisibility(0);
            this.noHeaderCloseButton.setVisibility(8);
            this.closePageButton.setVisibility(0);
            this.noHeaderImageContainer.setVisibility(8);
            this.noHeaderImageView.setVisibility(8);
        }
        if (TalabatUtils.isNullOrEmpty(str)) {
            hideImageContainer(view);
        } else if (isValidContextForGlide(this)) {
            GlideApp.with((FragmentActivity) this).clear((View) imageView);
            GlideApp.with((FragmentActivity) this).load(itemImageUrlWithSize).apply((BaseRequestOptions) TalabatGlideModule.requestOptions()).placeholder((int) R.drawable.bg_m_grocery_placeholder).listener((RequestListener) new RequestListener<Drawable>() {
                public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
                    ItemDetailsRevampedActivity.this.hideImageContainer(view);
                    return true;
                }

                public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                    if (GlobalDataModel.Apptimize.itemDetailsHeaderVariant > GlobalConstants.ITEMDETAILS.noHeaderVariation) {
                        ItemDetailsRevampedActivity.this.mCollapseToolbar.setVisibility(0);
                    }
                    return false;
                }
            }).into(imageView);
        } else {
            hideImageContainer(view);
        }
        if (this.f54257j.hasChoiceSections()) {
            this.f54260m = new ArrayList<>();
            Iterator<ChoiceSection> it = this.f54257j.getChoiceSections().iterator();
            while (it.hasNext()) {
                ChoiceSection next = it.next();
                if (next.parentItemId == GlobalDataModel.SELECTED.cartMenuItem.f13861id) {
                    this.f54260m.add(next);
                }
            }
            this.f54258k.setChoiceItems(this.f54257j.getBaseAdapterList());
            adjustAddToCartLayoutTransparency();
            this.mRecyclerViewChoicesItems.setVisibility(0);
        } else {
            this.mRecyclerViewChoicesItems.setVisibility(8);
        }
        setSelectionProgress(0);
    }

    private void closeItemDetails(final boolean z11) {
        if (this.f54257j.isChoiceSelected()) {
            new AlertDialog.Builder(this, R.style.AlertDialogTheme).setTitle((int) R.string.sure_about_closing).setMessage((int) R.string.closing_will_clear).setPositiveButton((int) R.string.back, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                    ItemDetailsRevampedActivity.this.exitAnimation(z11);
                }
            }).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                }
            }).show();
        } else {
            exitAnimation(z11);
        }
    }

    private ChoiceSection[] combineTheArrays(ChoiceSection[] choiceSectionArr, ChoiceSection[] choiceSectionArr2) {
        boolean z11;
        ArrayList arrayList = new ArrayList(Arrays.asList(choiceSectionArr));
        ArrayList arrayList2 = new ArrayList(Arrays.asList(choiceSectionArr2));
        ArrayList arrayList3 = new ArrayList();
        arrayList.addAll(arrayList2);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            Iterator it = arrayList3.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((ChoiceSection) it.next()).f13841id == ((ChoiceSection) arrayList.get(i11)).f13841id) {
                        z11 = true;
                        break;
                    }
                } else {
                    z11 = false;
                    break;
                }
            }
            if (!z11) {
                arrayList3.add((ChoiceSection) arrayList.get(i11));
            }
        }
        return (ChoiceSection[]) arrayList3.toArray(new ChoiceSection[arrayList3.size()]);
    }

    private void getMenuSectionsForTheAdapter(ChoiceItem choiceItem, ChoiceSection choiceSection, int i11) {
        this.f54258k.setChoiceItems(this.f54257j.addSectionToTheList(choiceItem.f13839id, choiceSection.f13841id));
        adjustAddToCartLayoutTransparency();
    }

    /* access modifiers changed from: private */
    public void hideImageContainer(View view) {
        view.setVisibility(8);
        showToolBar();
        if (GlobalDataModel.Apptimize.itemDetailsHeaderVariant == GlobalConstants.ITEMDETAILS.noHeaderVariation) {
            int intrinsicHeight = this.noHeaderCloseButton.getDrawable().getIntrinsicHeight();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTextViewItemTitle.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, intrinsicHeight + (((RelativeLayout.LayoutParams) this.noHeaderCloseButton.getLayoutParams()).topMargin * 2), layoutParams.rightMargin, layoutParams.bottomMargin);
            this.mTextViewItemTitle.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mTextViewItemTitle.getLayoutParams();
        layoutParams2.setMargins(layoutParams2.leftMargin, 0, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        this.mTextViewItemTitle.setLayoutParams(layoutParams2);
    }

    /* access modifiers changed from: private */
    public void hideToolBar() {
        if (GlobalDataModel.Apptimize.itemDetailsHeaderVariant > GlobalConstants.ITEMDETAILS.noHeaderVariation) {
            this.mToolBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
            this.mTextViewItemTitleToolbar.setVisibility(4);
            this.mCollapseToolbar.setContentScrimColor(getResources().getColor(R.color.transparent));
            if (this.noHeaderImageContainer.getVisibility() == 8) {
                this.mAppBar.setLifted(false);
            }
            transparentStatusAndNavigation();
        }
    }

    private void initScrollView() {
        if (GlobalDataModel.Apptimize.itemDetailsHeaderVariant > GlobalConstants.ITEMDETAILS.noHeaderVariation) {
            this.mScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    ItemDetailsRevampedActivity.this.mScrollView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    ItemDetailsRevampedActivity.this.hideToolBar();
                }
            });
            this.mScrollView.getViewTreeObserver().addOnScrollChangedListener(new q9(this));
        }
    }

    private void initToolBar() {
        setSupportActionBar(this.mToolBar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        setToolbarPaddingWithStatusBar(this.mToolBar);
    }

    private void initViews() {
        this.mScrollView = (NestedScrollView) findViewById(R.id.scroll_view);
        this.mTextViewPriceDetails = (TalabatTextView) findViewById(R.id.textView_priceDescription);
        this.mTextViewPriceBefore = (TextView) findViewById(R.id.tv_price_before);
        this.mTextViewItemTitle = (TalabatTextView) findViewById(R.id.textview_itemTitle);
        this.mTextViewItemTitleToolbar = (TextView) findViewById(R.id.textview_itemTitleToolbar);
        this.selectedchoices = (TextView) findViewById(R.id.selected_choices);
        this.choiceSelectionProgress = (ProgressBar) findViewById(R.id.selected_progress);
        this.mTextViewItemDescription = (TalabatTextView) findViewById(R.id.text_itemDetails);
        this.specialRequestView = findViewById(R.id.special_request_view);
        this.specialRequestDisabledView = findViewById(R.id.special_request_disabled_view);
        this.contentView = findViewById(R.id.content_view);
        this.gemFooterView = findViewById(R.id.gem_footer_view);
        this.mEditTextSpecialRequest = (TalabatEditText) findViewById(R.id.edit_specialRequest);
        this.closePageButton = (ImageView) findViewById(R.id.btn_new_close);
        this.mEditTextSpecialRequest.setImeOptions(6);
        this.mEditTextSpecialRequest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ItemDetailsRevampedActivity.this.specialRequestView.performClick();
            }
        });
        this.specialRequestView.setOnClickListener(new View.OnClickListener() {
            /* access modifiers changed from: private */
            public /* synthetic */ void lambda$onClick$0() {
                Rect rect = new Rect();
                ItemDetailsRevampedActivity.this.contentView.getWindowVisibleDisplayFrame(rect);
                int i11 = Resources.getSystem().getDisplayMetrics().heightPixels;
                if (((double) (i11 - rect.bottom)) > ((double) i11) * 0.15d) {
                    if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
                        ItemDetailsRevampedActivity.this.adjustGemFooterPosition(rect);
                    }
                } else if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
                    ItemDetailsRevampedActivity.this.adjustGemFooterPosition(rect);
                }
            }

            public void onClick(View view) {
                ItemDetailsRevampedActivity.this.mEditTextSpecialRequest.setFocusable(true);
                ItemDetailsRevampedActivity.this.mEditTextSpecialRequest.requestFocus();
                ItemDetailsRevampedActivity.this.mEditTextSpecialRequest.requestFocusFromTouch();
                try {
                    ItemDetailsRevampedActivity.this.f54256i.toggleSoftInput(1, 0);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                ItemDetailsRevampedActivity.this.contentView.getViewTreeObserver().addOnGlobalLayoutListener(new o(this));
            }
        });
        ImageButton imageButton = (ImageButton) findViewById(R.id.button_minus);
        this.mImageButtonMinus = imageButton;
        imageButton.setOnClickListener(this);
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.button_plus);
        this.mImageButtonPlus = imageButton2;
        imageButton2.setOnClickListener(this);
        this.mTextViewItemCount = (TalabatTextView) findViewById(R.id.text_count);
        this.mImageViewHeader = (ImageView) findViewById(R.id.iv_image_header);
        this.imageContainer = findViewById(R.id.image_container);
        this.mImageViewHeader.setOnClickListener(this);
        this.mToolBar = (Toolbar) findViewById(R.id.toolbar);
        this.mRecyclerViewChoicesItems = (RecyclerView) findViewById(R.id.recyclerView_choicesItems);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        this.linearLayoutManager = linearLayoutManager2;
        this.mRecyclerViewChoicesItems.setLayoutManager(linearLayoutManager2);
        this.mRecyclerViewChoicesItems.setFocusable(false);
        ItemChoicesRevampedAdapter itemChoicesRevampedAdapter = new ItemChoicesRevampedAdapter(this);
        this.f54258k = itemChoicesRevampedAdapter;
        itemChoicesRevampedAdapter.setOnItemSelectedListener(this);
        this.f54258k.setmSelectedChoiceListener(this);
        this.mRecyclerViewChoicesItems.setAdapter(this.f54258k);
        this.mRecyclerViewChoicesItems.setNestedScrollingEnabled(false);
        this.mCollapseToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapseToolBar);
        Button button = (Button) findViewById(R.id.button_addToCart);
        this.mButtonAddToCart = button;
        button.setOnClickListener(this);
        View findViewById = findViewById(R.id.ll_add_to_cart);
        this.mViewAddToCart = findViewById;
        findViewById.setOnClickListener(this);
        this.noHeaderCloseButton = (ImageView) findViewById(R.id.no_header_close);
        makeUiChangesForNoHeaderVersion();
        this.noHeaderImageContainer = findViewById(R.id.no_header_image_container);
        this.noHeaderImageView = (ImageView) findViewById(R.id.no_header_item_image);
        this.mTextViewTotalPrice = (TalabatTextView) findViewById(R.id.textview_totalPrice);
        this.mAppBar = (AppBarLayout) findViewById(R.id.appbar);
        this.closePageButton.setOnClickListener(new n9(this));
        this.noHeaderCloseButton.setOnClickListener(new o9(this));
        if (this.mGemDialogSwitcher == null) {
            this.mGemDialogSwitcher = new GemDialogSwitcher(this, this, getScreenName());
        }
        this.mAppBar.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new p9());
        inflateGemFooter();
        adjustSpecialRequestVisibility();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initScrollView$0() {
        if (this.mScrollView.getScrollY() >= 109) {
            this.showChoiceLabel = true;
            this.f54257j.onToolBarVisible(true);
            showToolBar();
            return;
        }
        this.showChoiceLabel = false;
        this.f54257j.onToolBarVisible(false);
        hideToolBar();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$1(View view) {
        closeItemDetails(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$2(View view) {
        closeItemDetails(false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$initViews$3(AppBarLayout appBarLayout, int i11) {
        Math.abs(i11);
        appBarLayout.getTotalScrollRange();
    }

    private void makeUiChangesForNoHeaderVersion() {
        ((ViewGroup.MarginLayoutParams) this.noHeaderCloseButton.getLayoutParams()).topMargin = getStatusBarHeight();
        ViewCompat.setElevation(this.noHeaderCloseButton, 20.0f);
        ViewCompat.setTranslationZ(this.noHeaderCloseButton, 20.0f);
        ViewCompat.setBackground(this.noHeaderCloseButton, ContextCompat.getDrawable(this, R.drawable.circle_with_shadow));
    }

    private void notifyTheAdapter() {
        ArrayList<ChoiceSection> arrayList;
        if (this.f54257j.hasChoiceSections() && (arrayList = this.f54260m) != null && arrayList.size() > 0) {
            this.f54258k.setChoiceItems(this.f54260m);
            this.mRecyclerViewChoicesItems.setVisibility(0);
        }
    }

    private void scrollRecyclerViewTo(int i11) {
        try {
            if (i11 < this.mRecyclerViewChoicesItems.getChildCount()) {
                this.mScrollView.smoothScrollTo(0, (int) (this.mRecyclerViewChoicesItems.getY() + this.mRecyclerViewChoicesItems.getChildAt(i11).getY()));
                this.linearLayoutManager.scrollToPositionWithOffset(i11, 0);
            }
        } catch (Exception unused) {
        }
    }

    private void setPriceInTextViews(String str) {
        this.mTextViewPriceDetails.setText(str);
        this.mTextViewTotalPrice.setText(str);
    }

    private void setWindowFlag(int i11, boolean z11) {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z11) {
            attributes.flags = i11 | attributes.flags;
        } else {
            attributes.flags = (~i11) & attributes.flags;
        }
        window.setAttributes(attributes);
    }

    private void showToolBar() {
        if (GlobalDataModel.Apptimize.itemDetailsHeaderVariant > GlobalConstants.ITEMDETAILS.noHeaderVariation) {
            this.mToolBar.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            this.mTextViewItemTitleToolbar.setVisibility(0);
            this.mCollapseToolbar.setContentScrimColor(getResources().getColor(R.color.white));
            if (!this.mAppBar.isLiftOnScroll()) {
                this.mAppBar.setLiftOnScroll(true);
            }
            adjustStatusIconsTint();
        }
    }

    private void showViewWithAnimation(View view) {
        if (view != null && view.getVisibility() == 8) {
            view.setAlpha(0.2f);
            view.setVisibility(0);
            view.animate().alpha(1.0f).setStartDelay(200).setDuration(700).setListener((Animator.AnimatorListener) null);
        }
    }

    private void transparentStatusAndNavigation() {
        getWindow().getDecorView().setSystemUiVisibility(PlatformPlugin.DEFAULT_SYSTEM_UI);
        setWindowFlag(67108864, false);
        getWindow().setStatusBarColor(0);
    }

    private void updateGlobalMenuModel() {
        MenuItemRM menuItemRM = GlobalDataModel.JSON.menuItemsResponseModel.menu;
        if (menuItemRM != null) {
            MenuSection[] menuSectionArr = menuItemRM.menuSection;
            if (menuSectionArr.length > 0) {
                for (MenuSection menuSection : menuSectionArr) {
                    for (MenuItem menuItem : menuSection.items) {
                        int i11 = menuItem.f13861id;
                        CartMenuItem cartMenuItem = GlobalDataModel.SELECTED.cartMenuItem;
                        if (i11 == cartMenuItem.f13861id) {
                            menuItem.choiceSections = cartMenuItem.choiceSections;
                        }
                    }
                }
            }
        }
    }

    public void adjustAddToCartLayoutTransparency() {
        if (this.f54257j.enableAddToCartButton()) {
            this.mViewAddToCart.setAlpha(1.0f);
            this.mViewAddToCart.setActivated(true);
            return;
        }
        this.mViewAddToCart.setActivated(false);
    }

    public void adjustButtonTransparency() {
        adjustAddToCartLayoutTransparency();
    }

    public void destroyPresenter() {
    }

    public void exitAnimation(boolean z11) {
        if (z11) {
            Intent intent = new Intent(this, RestaurantsListScreenRefactor.class);
            intent.setFlags(67108864);
            startActivity(intent);
            return;
        }
        ActivityCompat.finishAfterTransition(this);
    }

    public Context getGemContext() {
        return this;
    }

    public String getGemScreenType() {
        return ScreenNames.getScreenType(getScreenName());
    }

    public IGlobalPresenter getPresenter() {
        return null;
    }

    public String getScreenName() {
        return ScreenNames.ITEM_DETAILS_SCREEN;
    }

    public ChoiceSection getSelectedChoicesByIDs(int i11) {
        return this.f54257j.getSelectedChoice(i11);
    }

    public String getSpecialRequest() {
        return this.mEditTextSpecialRequest.getText().toString().trim();
    }

    public void hideChoiceNames() {
        this.selectedchoices.setVisibility(8);
    }

    public void inflateGemFooter() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            this.f54259l = new GemFooterCartView();
            if (GEMEngine.getInstance() != null) {
                GEMEngine.getInstance().startListening(this, false);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
            beginTransaction.add(this.gemFooterView.getId(), (Fragment) this.f54259l, getScreenName());
            beginTransaction.commit();
            this.gemFooterView.bringToFront();
        }
    }

    public boolean isChoiceItemSelected(int i11, int i12) {
        return this.f54257j.isChoiceItemSelectedOrNot(i11, i12);
    }

    public void itemAdded(CartMenuItem cartMenuItem) {
        exitAnimation();
    }

    public void itemSelectionChanged(ChoiceItem choiceItem, boolean z11) {
        this.f54257j.itemSelectionChanged(choiceItem, z11);
    }

    public void itemSelectionChangedPriceChange(ChoiceItem choiceItem, boolean z11) {
        this.f54257j.itemSelectionChanged(choiceItem, z11);
    }

    public void onAddMoreItemClicked() {
    }

    public void onAuthError() {
    }

    public void onBackToCheckoutPage(Dialog dialog) {
    }

    public void onBackToRestaurantMenuPage(Dialog dialog) {
    }

    public void onBackToRestaurantPage(Dialog dialog) {
        dialog.dismiss();
        closeItemDetails(true);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_addToCart /*2131427966*/:
            case R.id.ll_add_to_cart /*2131429990*/:
                this.f54257j.addToCart(this);
                return;
            case R.id.button_minus /*2131427982*/:
                this.f54257j.decreaseQuantity();
                return;
            case R.id.button_plus /*2131427985*/:
                this.f54257j.increaseQuantity();
                return;
            default:
                return;
        }
    }

    public void onCloseButtonClicked(Dialog dialog) {
        dialog.dismiss();
    }

    public void onContinueToCheckout() {
    }

    public void onCreate(@Nullable Bundle bundle) {
        DaggerItemDetailsRevampedActivityComponent.factory().create((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        try {
            setContentView((int) R.layout.activity_item_details_revamped);
            this.f54256i = (InputMethodManager) getSystemService("input_method");
            this.f54257j = new ItemDetailsPresenterR(this.f54262o, this);
            this.requestedThirdChoiceIdList = new ArrayList<>();
            this.receivedChoiceIdList = new ArrayList<>();
            initViews();
            initToolBar();
            initScrollView();
            buildUI();
            AppTracker.onNewProductChoiceOpened(this, GlobalDataModel.SELECTED.cartMenuItem, GlobalDataModel.SELECTED.restaurant, this.f54261n, "compulsory", getScreenName(), ScreenNames.getScreenType(getScreenName()));
        } catch (Exception unused) {
            finish();
        }
    }

    public void onDataError() {
        super.onDataError();
        stopLoading();
    }

    public void onError() {
    }

    public void onInterestClicked(Restaurant restaurant) {
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 != 4) {
            return super.onKeyDown(i11, keyEvent);
        }
        closeItemDetails(false);
        return true;
    }

    public void onLeaveOfferClicked(boolean z11) {
        showHideGemFooter(this.f54259l, this, false);
        if (!GlobalDataModel.GEMCONSTANTS.isGemFlow && GlobalDataModel.GEMCONSTANTS.reloadRequired) {
            GlobalDataModel.GEMCONSTANTS.reloadRequired = false;
        }
    }

    public void onMandatoryItemsNotSelected(ArrayList<Integer> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.f54258k.setNotSelectedChoices(arrayList);
            scrollRecyclerViewTo(arrayList.get(0).intValue());
        }
    }

    public void onNetworkError() {
        super.onNetworkError();
        stopLoading();
    }

    public void onNoItem() {
        exitAnimation(false);
    }

    public void onPause() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            GEMEngine.getInstance();
            GEMEngine.stopListening();
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        showHideGemFooter(this.f54259l, this, false);
        if (!GlobalDataModel.GEMCONSTANTS.isGemFlow && GlobalDataModel.GEMCONSTANTS.reloadRequired) {
            GlobalDataModel.GEMCONSTANTS.reloadRequired = false;
        }
    }

    public void onServerError(VolleyError volleyError) {
        super.onServerError(volleyError);
        stopLoading();
    }

    public void onThirdLevelChoiceAvailable(String str, ArrayList<Integer> arrayList) {
        this.f54257j.callThirdLevelChoice(str);
        this.requestForThirdLevelChoiceSent = true;
        if (this.requestedThirdChoiceIdList != null) {
            this.requestedThirdChoiceIdList = new ArrayList<>();
        }
        if (arrayList.size() > 0) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (!this.requestedThirdChoiceIdList.contains(next)) {
                    this.requestedThirdChoiceIdList.add(next);
                }
            }
        }
    }

    public void onThirdLevelChoicesReceived(SplitChoiceResponse splitChoiceResponse) {
        stopLodingPopup();
        SplitChoiceItemModel[] splitChoiceItemModelArr = splitChoiceResponse.items;
        if (splitChoiceItemModelArr != null && splitChoiceItemModelArr.length > 0) {
            for (SplitChoiceItemModel splitChoiceItemModel : splitChoiceItemModelArr) {
                ChoiceSection[] choiceSectionArr = splitChoiceItemModel.choiceSections;
                if (choiceSectionArr != null && choiceSectionArr.length > 0) {
                    CartMenuItem cartMenuItem = GlobalDataModel.SELECTED.cartMenuItem;
                    cartMenuItem.choiceSections = combineTheArrays(cartMenuItem.choiceSections, choiceSectionArr);
                    for (ChoiceSection choiceSection : splitChoiceItemModel.choiceSections) {
                        choiceSection.isSubChoice = true;
                        this.receivedChoiceIdList.add(Integer.valueOf(choiceSection.parentItemId));
                        for (ChoiceSection choiceSection2 : GlobalDataModel.SELECTED.cartMenuItem.choiceSections) {
                            Iterator<ChoiceItem> it = choiceSection2.itemChoices.iterator();
                            while (it.hasNext()) {
                                ChoiceItem next = it.next();
                                if (next.f13839id == choiceSection.parentItemId) {
                                    next.allSubChoicesLoaded = true;
                                }
                            }
                        }
                        if (this.requestedThirdChoiceIdList.contains(Integer.valueOf(choiceSection.parentItemId))) {
                            this.requestForThirdLevelChoiceSent = false;
                            this.requestedThirdChoiceIdList.remove(Integer.valueOf(choiceSection.parentItemId));
                        }
                    }
                    updateGlobalMenuModel();
                }
            }
        }
        ChoiceItem choiceItem = this.selectedChoiceItem;
        if (choiceItem != null && this.receivedChoiceIdList.contains(Integer.valueOf(choiceItem.f13839id))) {
            notifyTheAdapter();
        }
    }

    public void priceChanged(float f11) {
        String formattedCurrency = TalabatFormatter.getInstance().getFormattedCurrency(f11);
        this.mTextViewPriceDetails.setText(formattedCurrency);
        this.mTextViewTotalPrice.setText(formattedCurrency);
    }

    public void quantityChanged(String str) {
        this.mTextViewItemCount.setText(str);
    }

    public void setChoicesName(String str) {
        if (TalabatUtils.isNullOrEmpty(str) || !this.showChoiceLabel) {
            hideChoiceNames();
            return;
        }
        showViewWithAnimation(this.selectedchoices);
        this.selectedchoices.setText(str);
    }

    public void setSelectedChoiceItem(ChoiceItem choiceItem, ChoiceSection choiceSection, int i11) {
        this.selectedChoiceItem = choiceItem;
        getMenuSectionsForTheAdapter(choiceItem, choiceSection, i11);
        ChoiceItem choiceItem2 = this.selectedChoiceItem;
        if (choiceItem2.hasSubChoice && this.requestedThirdChoiceIdList.contains(Integer.valueOf(choiceItem2.f13839id))) {
            startLodingPopup();
        }
    }

    public void setSelectionProgress(int i11) {
        if (i11 == 0 || !this.showChoiceLabel) {
            this.choiceSelectionProgress.setVisibility(8);
        } else if (GlobalDataModel.Apptimize.itemDetailsHeaderVariant == GlobalConstants.ITEMDETAILS.staticHeaderWithChoicesAndProgressBar) {
            this.choiceSelectionProgress.setVisibility(0);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this.choiceSelectionProgress, "progress", new int[]{i11});
            ofInt.setInterpolator(new FastOutLinearInInterpolator());
            ofInt.setDuration(250).start();
        }
    }

    public void showGemDialog() {
    }

    public void showInAppReminder(int i11) {
        Context context = getContext();
        String string = getResources().getString(R.string.gem_order_notification);
        Toast.makeText(context, string.replace("#", "" + i11), 0).show();
    }

    public void showMaxChoicesNumberReachedDialog() {
    }

    public void showRestaurantChangePopup(final CartMenuItem cartMenuItem) {
        Cart instance = Cart.getInstance();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        String replace = getString(R.string.cart_will_be_cleared).replace("#", "\"" + instance.getRestaurant().f13873name + "\"");
        builder.setTitle((CharSequence) getString(R.string.start_new_cart));
        builder.setMessage((CharSequence) replace);
        builder.setPositiveButton((CharSequence) getString(R.string.start), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                ItemDetailsRevampedActivity itemDetailsRevampedActivity = ItemDetailsRevampedActivity.this;
                itemDetailsRevampedActivity.f54257j.changeRestaurantAndAddItem(itemDetailsRevampedActivity, cartMenuItem);
            }
        }).setNegativeButton((CharSequence) getString(R.string.cancel), (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void showTimeOutDialog() {
        if (this.mGemDialogSwitcher.isDialogShowing()) {
            onCloseButtonClicked(this.mGemDialogSwitcher.dialog);
        }
        showGemTimeOutDialog(this.mGemDialogSwitcher, this.f54259l, this, this);
    }

    public void showTimerView(boolean z11, String str) {
        this.f54259l.setTimerText(str);
    }

    public void stopLoading() {
        stopLodingPopup();
    }

    public void itemSelectionChanged(ChoiceSection choiceSection) {
        this.f54257j.addSelectedChoiceSection(choiceSection);
    }
}
