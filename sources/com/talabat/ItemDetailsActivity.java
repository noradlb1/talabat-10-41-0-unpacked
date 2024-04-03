package com.talabat;

import JsonModels.MenuItemRM;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceItemModel;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceResponse;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Cart;
import buisnessmodels.GEMEngine;
import buisnessmodels.TalabatFormatter;
import com.android.volley.VolleyError;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.adapters.ItemChoicesAdapter;
import com.talabat.adapters.OptionalItemAdapters;
import com.talabat.adapters.RequiredItemAdapters;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.details.DaggerItemDetailsActivityComponent;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.RequiredItemLayout;
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
import ue.m9;
import yq.a;

public class ItemDetailsActivity extends TalabatBase implements ItemDetailsViewR, View.OnClickListener, RequiredItemAdapters.OnItemSelectedListener, RequiredItemLayout.OnItemSelectedListener, GemView, OnGemAlertDialogClickListener, OptionalItemAdapters.OnMultipleItemsSelectorListener {
    /* access modifiers changed from: private */
    public ImageView closeButton;
    /* access modifiers changed from: private */
    public ImageView closePageButton;
    /* access modifiers changed from: private */
    public View contentView;
    private View gemFooterView;

    /* renamed from: i  reason: collision with root package name */
    public InputMethodManager f54237i;

    /* renamed from: j  reason: collision with root package name */
    public IItemDetailsPresenterR f54238j;

    /* renamed from: k  reason: collision with root package name */
    public ItemChoicesAdapter f54239k;

    /* renamed from: l  reason: collision with root package name */
    public GemFooterCartView f54240l;

    /* renamed from: m  reason: collision with root package name */
    public ArrayList<ChoiceSection> f54241m;
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
    private NestedScrollView mScrollView;
    private TalabatTextView mTextViewItemCount;
    private TalabatTextView mTextViewItemDescription;
    private TalabatTextView mTextViewItemTitle;
    private TextView mTextViewPriceBefore;
    private TalabatTextView mTextViewPriceDetails;
    private TalabatTextView mTextViewTotalPrice;
    /* access modifiers changed from: private */
    public Toolbar mToolBar;
    private View mViewAddToCart;
    private View mViewItemInfo;

    /* renamed from: n  reason: collision with root package name */
    public String f54242n = "";
    @Inject

    /* renamed from: o  reason: collision with root package name */
    public AppVersionProvider f54243o;
    private ArrayList<Integer> receivedChoiceIdList;
    private boolean requestForThirdLevelChoiceSent = false;
    private ArrayList<Integer> requestedThirdChoiceIdList;
    private ChoiceItem selectedChoiceItem;
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
        if (this.f54238j.disableSpecialRequest(GlobalDataModel.SELECTED.restaurant)) {
            this.specialRequestDisabledView.setVisibility(0);
            this.specialRequestView.setVisibility(8);
            return;
        }
        this.specialRequestDisabledView.setVisibility(8);
        this.specialRequestView.setVisibility(0);
    }

    private void buildUI() {
        this.mCollapseToolbar.setTitle(this.f54238j.getItemName());
        this.mTextViewItemTitle.setText(this.f54238j.getItemName());
        if (TextUtils.isEmpty(this.f54238j.getItemDescription())) {
            this.mTextViewItemDescription.setVisibility(8);
        } else {
            this.mTextViewItemDescription.setText(this.f54238j.getItemDescription().trim());
            this.mTextViewItemDescription.setVisibility(0);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(GlobalDataModel.SELECTED.cartMenuItem.price);
        String str = "";
        sb2.append(str);
        this.f54242n = sb2.toString();
        if (this.f54238j.isItemHasStartPrice()) {
            GlobalDataModel.MENU.priceOnSelectionItemAvailable = true;
            this.f54242n = GlobalDataModel.SELECTED.cartMenuItem.getStartsWithPrice() + str;
            setPriceInTextViews(getString(R.string.from) + " " + this.f54238j.getItemStartPrice());
        } else if (!this.f54238j.isItemHasDiscount()) {
            setPriceInTextViews(this.f54238j.getItemPrice());
            this.mTextViewPriceBefore.setVisibility(8);
        } else if (Integration.isGemActive()) {
            this.mTextViewPriceBefore.setVisibility(8);
            this.f54242n = GlobalDataModel.SELECTED.cartMenuItem.oldPrice + str;
            setPriceInTextViews(this.f54238j.getItemOldPrice());
        } else {
            this.mTextViewPriceBefore.setText(this.f54238j.getItemOldPrice());
            this.mTextViewPriceBefore.setVisibility(0);
            TextView textView = this.mTextViewPriceBefore;
            textView.setPaintFlags(textView.getPaintFlags() | 16);
            new GradientDrawable().setStroke(getResources().getDimensionPixelOffset(R.dimen.stroke_1dp), Color.parseColor("#fd7474"));
            setPriceInTextViews(this.f54238j.getItemPrice());
        }
        if (!TalabatUtils.isNullOrEmpty(this.f54238j.getItemImageUrl())) {
            str = this.f54238j.getItemImageUrl().substring(this.f54238j.getItemImageUrl().lastIndexOf("/") + 1).trim();
        }
        String itemImageUrlWithSize = this.f54238j.getItemImageUrlWithSize(Resources.getSystem().getDisplayMetrics().widthPixels);
        this.mImageViewHeader.setMaxHeight((Resources.getSystem().getDisplayMetrics().widthPixels * 3) / 4);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("image url = ");
        sb3.append(itemImageUrlWithSize);
        if (TalabatUtils.isNullOrEmpty(str)) {
            this.closeButton.setVisibility(0);
            this.mCollapseToolbar.setVisibility(8);
        } else if (isValidContextForGlide(this)) {
            GlideApp.with((FragmentActivity) this).clear((View) this.mImageViewHeader);
            GlideApp.with((FragmentActivity) this).load(itemImageUrlWithSize).apply(TalabatGlideModule.requestOptions().transform((Transformation<Bitmap>[]) new Transformation[]{new CenterCrop(), new RoundedCorners(getResources().getDimensionPixelSize(R.dimen.card_corner_radius))})).fitCenter().placeholder((int) R.drawable.bg_m_grocery_placeholder).listener((RequestListener) new RequestListener<Drawable>() {
                public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
                    ItemDetailsActivity.this.closeButton.setVisibility(0);
                    ItemDetailsActivity.this.mCollapseToolbar.setVisibility(8);
                    return true;
                }

                public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                    ItemDetailsActivity.this.closeButton.setVisibility(8);
                    ItemDetailsActivity.this.mCollapseToolbar.setVisibility(0);
                    return false;
                }
            }).into(this.mImageViewHeader);
        } else {
            this.closeButton.setVisibility(0);
            this.mCollapseToolbar.setVisibility(8);
        }
        if (this.f54238j.hasChoiceSections()) {
            this.f54241m = new ArrayList<>();
            Iterator<ChoiceSection> it = this.f54238j.getChoiceSections().iterator();
            while (it.hasNext()) {
                ChoiceSection next = it.next();
                if (next.parentItemId == GlobalDataModel.SELECTED.cartMenuItem.f13861id) {
                    this.f54241m.add(next);
                }
            }
            this.f54239k.setChoiceItems(this.f54238j.getBaseAdapterList());
            adjustAddToCartLayoutTransparency();
            this.mRecyclerViewChoicesItems.setVisibility(0);
            return;
        }
        this.mRecyclerViewChoicesItems.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void closeItemDetails(final boolean z11) {
        if (this.f54238j.isChoiceSelected()) {
            new AlertDialog.Builder(this, R.style.AlertDialogTheme).setTitle((int) R.string.sure_about_closing).setMessage((int) R.string.closing_will_clear).setPositiveButton((int) R.string.back, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                    ItemDetailsActivity.this.exitAnimation(z11);
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
        this.f54239k.setChoiceItems(this.f54238j.addSectionToTheList(choiceItem.f13839id, choiceSection.f13841id));
        adjustAddToCartLayoutTransparency();
    }

    private void initToolBar() {
        setSupportActionBar(this.mToolBar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        setToolbarPadding(this.mToolBar);
        this.closePageButton.setOnClickListener(new m9(this));
    }

    private void initViews() {
        this.mViewItemInfo = findViewById(R.id.ll_item_info);
        this.mScrollView = (NestedScrollView) findViewById(R.id.scroll_view);
        this.mTextViewPriceDetails = (TalabatTextView) findViewById(R.id.textView_priceDescription);
        this.mTextViewPriceBefore = (TextView) findViewById(R.id.tv_price_before);
        this.mTextViewItemTitle = (TalabatTextView) findViewById(R.id.textview_itemTitle);
        this.mTextViewItemDescription = (TalabatTextView) findViewById(R.id.text_itemDetails);
        this.specialRequestView = findViewById(R.id.special_request_view);
        this.specialRequestDisabledView = findViewById(R.id.special_request_disabled_view);
        this.contentView = findViewById(R.id.content_view);
        this.gemFooterView = findViewById(R.id.gem_footer_view);
        this.mEditTextSpecialRequest = (TalabatEditText) findViewById(R.id.edit_specialRequest);
        this.closeButton = (ImageView) findViewById(R.id.close_button);
        this.closePageButton = (ImageView) findViewById(R.id.btn_new_close);
        this.mEditTextSpecialRequest.setImeOptions(6);
        this.mEditTextSpecialRequest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ItemDetailsActivity.this.specialRequestView.performClick();
            }
        });
        this.closeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ItemDetailsActivity.this.closeItemDetails(false);
            }
        });
        this.specialRequestView.setOnClickListener(new View.OnClickListener() {
            /* access modifiers changed from: private */
            public /* synthetic */ void lambda$onClick$0() {
                Rect rect = new Rect();
                ItemDetailsActivity.this.contentView.getWindowVisibleDisplayFrame(rect);
                int i11 = Resources.getSystem().getDisplayMetrics().heightPixels;
                if (((double) (i11 - rect.bottom)) > ((double) i11) * 0.15d) {
                    if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
                        ItemDetailsActivity.this.adjustGemFooterPosition(rect);
                    }
                } else if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
                    ItemDetailsActivity.this.adjustGemFooterPosition(rect);
                }
            }

            public void onClick(View view) {
                ItemDetailsActivity.this.mEditTextSpecialRequest.setFocusable(true);
                ItemDetailsActivity.this.mEditTextSpecialRequest.requestFocus();
                ItemDetailsActivity.this.mEditTextSpecialRequest.requestFocusFromTouch();
                try {
                    ItemDetailsActivity.this.f54237i.toggleSoftInput(1, 0);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                ItemDetailsActivity.this.contentView.getViewTreeObserver().addOnGlobalLayoutListener(new n(this));
            }
        });
        ImageButton imageButton = (ImageButton) findViewById(R.id.button_minus);
        this.mImageButtonMinus = imageButton;
        imageButton.setOnClickListener(this);
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.button_plus);
        this.mImageButtonPlus = imageButton2;
        imageButton2.setOnClickListener(this);
        this.mTextViewItemCount = (TalabatTextView) findViewById(R.id.text_count);
        ImageView imageView = (ImageView) findViewById(R.id.iv_image_header);
        this.mImageViewHeader = imageView;
        imageView.setOnClickListener(this);
        this.mToolBar = (Toolbar) findViewById(R.id.toolbar);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_choicesItems);
        this.mRecyclerViewChoicesItems = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerViewChoicesItems.setFocusable(false);
        ItemChoicesAdapter itemChoicesAdapter = new ItemChoicesAdapter(this);
        this.f54239k = itemChoicesAdapter;
        itemChoicesAdapter.setOnItemSelectedListener(this);
        this.f54239k.setmSelectedChoiceListener(this);
        this.mRecyclerViewChoicesItems.setAdapter(this.f54239k);
        this.mRecyclerViewChoicesItems.setNestedScrollingEnabled(false);
        this.mCollapseToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapseToolBar);
        Button button = (Button) findViewById(R.id.button_addToCart);
        this.mButtonAddToCart = button;
        button.setOnClickListener(this);
        View findViewById = findViewById(R.id.ll_add_to_cart);
        this.mViewAddToCart = findViewById;
        findViewById.setOnClickListener(this);
        this.mTextViewTotalPrice = (TalabatTextView) findViewById(R.id.textview_totalPrice);
        this.mAppBar = (AppBarLayout) findViewById(R.id.appbar);
        if (this.mGemDialogSwitcher == null) {
            this.mGemDialogSwitcher = new GemDialogSwitcher(this, this, getScreenName());
        }
        this.mAppBar.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarLayout.OnOffsetChangedListener() {

            /* renamed from: a  reason: collision with root package name */
            public boolean f54248a = false;

            /* renamed from: b  reason: collision with root package name */
            public int f54249b = -1;

            public void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
                if (this.f54249b == -1) {
                    this.f54249b = appBarLayout.getTotalScrollRange();
                }
                if (1.0f - (((float) Math.abs(i11)) / ((float) appBarLayout.getTotalScrollRange())) == 0.0f) {
                    ItemDetailsActivity.this.mToolBar.setBackgroundColor(ContextCompat.getColor(ItemDetailsActivity.this, R.color.white));
                    ItemDetailsActivity.this.closePageButton.setImageDrawable(ItemDetailsActivity.this.getResources().getDrawable(R.drawable.ic_m_close));
                } else {
                    ItemDetailsActivity.this.mToolBar.setBackgroundColor(ContextCompat.getColor(ItemDetailsActivity.this, R.color.white_full_transparent));
                    ItemDetailsActivity.this.closePageButton.setImageDrawable(ItemDetailsActivity.this.getResources().getDrawable(R.drawable.ic_m_close_white_background));
                }
                if (this.f54249b + i11 == 0) {
                    this.f54248a = true;
                } else if (this.f54248a) {
                    this.f54248a = false;
                }
            }
        });
        inflateGemFooter();
        adjustSpecialRequestVisibility();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initToolBar$0(View view) {
        closeItemDetails(false);
    }

    private void notifyTheAdapter() {
        ArrayList<ChoiceSection> arrayList;
        if (this.f54238j.hasChoiceSections() && (arrayList = this.f54241m) != null && arrayList.size() > 0) {
            this.f54239k.setChoiceItems(this.f54241m);
            this.mRecyclerViewChoicesItems.setVisibility(0);
        }
    }

    private void setPriceInTextViews(String str) {
        this.mTextViewPriceDetails.setText(str);
        this.mTextViewTotalPrice.setText(str);
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
        if (this.f54238j.enableAddToCartButton()) {
            this.mViewAddToCart.setAlpha(1.0f);
            this.mViewAddToCart.setEnabled(true);
            return;
        }
        this.mViewAddToCart.setEnabled(false);
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
        return this.f54238j.getSelectedChoice(i11);
    }

    public String getSpecialRequest() {
        return this.mEditTextSpecialRequest.getText().toString().trim();
    }

    public void hideChoiceNames() {
    }

    public void inflateGemFooter() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            this.f54240l = new GemFooterCartView();
            if (GEMEngine.getInstance() != null) {
                GEMEngine.getInstance().startListening(this, false);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
            beginTransaction.add(this.gemFooterView.getId(), (Fragment) this.f54240l, getScreenName());
            beginTransaction.commit();
            this.gemFooterView.bringToFront();
        }
    }

    public boolean isChoiceItemSelected(int i11, int i12) {
        return this.f54238j.isChoiceItemSelectedOrNot(i11, i12);
    }

    public void itemAdded(CartMenuItem cartMenuItem) {
        exitAnimation();
    }

    public void itemSelectionChanged(ChoiceItem choiceItem, boolean z11) {
        this.f54238j.itemSelectionChanged(choiceItem, z11);
    }

    public void itemSelectionChangedPriceChange(ChoiceItem choiceItem, boolean z11) {
        this.f54238j.itemSelectionChanged(choiceItem, z11);
    }

    public /* synthetic */ void onAddMoreItemClicked() {
        a.a(this);
    }

    public void onAuthError() {
    }

    public /* synthetic */ void onBackToCheckoutPage(Dialog dialog) {
        a.b(this, dialog);
    }

    public /* synthetic */ void onBackToRestaurantMenuPage(Dialog dialog) {
        a.c(this, dialog);
    }

    public void onBackToRestaurantPage(Dialog dialog) {
        dialog.dismiss();
        closeItemDetails(true);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_addToCart /*2131427966*/:
            case R.id.ll_add_to_cart /*2131429990*/:
                this.f54238j.addToCart(this);
                return;
            case R.id.button_minus /*2131427982*/:
                this.f54238j.decreaseQuantity();
                return;
            case R.id.button_plus /*2131427985*/:
                this.f54238j.increaseQuantity();
                return;
            default:
                return;
        }
    }

    public void onCloseButtonClicked(Dialog dialog) {
        dialog.dismiss();
    }

    public /* synthetic */ void onContinueToCheckout() {
        a.f(this);
    }

    public void onCreate(@Nullable Bundle bundle) {
        DaggerItemDetailsActivityComponent.factory().create((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        try {
            setContentView((int) R.layout.activity_item_details);
            this.f54237i = (InputMethodManager) getSystemService("input_method");
            this.f54238j = new ItemDetailsPresenterR(this.f54243o, this);
            this.requestedThirdChoiceIdList = new ArrayList<>();
            this.receivedChoiceIdList = new ArrayList<>();
            initViews();
            initToolBar();
            buildUI();
            AppTracker.onNewProductChoiceOpened(this, GlobalDataModel.SELECTED.cartMenuItem, GlobalDataModel.SELECTED.restaurant, this.f54242n, "compulsory", getScreenName(), ScreenNames.getScreenType(getScreenName()));
        } catch (Exception unused) {
            finish();
        }
    }

    public void onDataError() {
        super.onDataError();
        stopLoading();
    }

    public void onDialogDismiss() {
        this.mImageViewHeader.setEnabled(true);
    }

    public void onError() {
    }

    public /* synthetic */ void onInterestClicked(Restaurant restaurant) {
        a.g(this, restaurant);
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 != 4) {
            return super.onKeyDown(i11, keyEvent);
        }
        closeItemDetails(false);
        return true;
    }

    public void onLeaveOfferClicked(boolean z11) {
        showHideGemFooter(this.f54240l, this, false);
        if (!GlobalDataModel.GEMCONSTANTS.isGemFlow && GlobalDataModel.GEMCONSTANTS.reloadRequired) {
            GlobalDataModel.GEMCONSTANTS.reloadRequired = false;
        }
    }

    public void onMandatoryItemsNotSelected(ArrayList<Integer> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.f54239k.setNotSelectedChoices(arrayList);
        }
    }

    public void onNetworkError() {
        super.onNetworkError();
        stopLoading();
    }

    public void onNoItem() {
        finish();
    }

    public void onPause() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow && GEMEngine.getInstance() != null) {
            GEMEngine.getInstance();
            GEMEngine.stopListening();
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        showHideGemFooter(this.f54240l, this, false);
        if (!GlobalDataModel.GEMCONSTANTS.isGemFlow && GlobalDataModel.GEMCONSTANTS.reloadRequired) {
            GlobalDataModel.GEMCONSTANTS.reloadRequired = false;
        }
    }

    public void onServerError(VolleyError volleyError) {
        super.onServerError(volleyError);
        stopLoading();
    }

    public void onThirdLevelChoiceAvailable(String str, ArrayList<Integer> arrayList) {
        this.f54238j.callThirdLevelChoice(str);
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
                            ArrayList<Integer> arrayList = this.requestedThirdChoiceIdList;
                            arrayList.remove(arrayList.indexOf(Integer.valueOf(choiceSection.parentItemId)));
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
    }

    public /* synthetic */ void showGemDialog() {
        v00.a.a(this);
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
                ItemDetailsActivity itemDetailsActivity = ItemDetailsActivity.this;
                itemDetailsActivity.f54238j.changeRestaurantAndAddItem(itemDetailsActivity, cartMenuItem);
            }
        }).setNegativeButton((CharSequence) getString(R.string.cancel), (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void showTimeOutDialog() {
        if (this.mGemDialogSwitcher.isDialogShowing()) {
            onCloseButtonClicked(this.mGemDialogSwitcher.dialog);
        }
        showGemTimeOutDialog(this.mGemDialogSwitcher, this.f54240l, this, this);
    }

    public void showTimerView(boolean z11, String str) {
        this.f54240l.setTimerText(str);
    }

    public void stopLoading() {
        stopLodingPopup();
    }

    public void itemSelectionChanged(ChoiceSection choiceSection) {
        this.f54238j.addSelectedChoiceSection(choiceSection);
    }
}
