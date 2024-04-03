package com.talabat;

import JsonModels.Response.GroceryResponse.GroceryItemsForSectionPagingInfo;
import JsonModels.Response.GroceryResponse.GroceryTagsModel;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceItemModel;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Cart;
import buisnessmodels.GEMEngine;
import buisnessmodels.TalabatFormatter;
import com.materialedittext.MaterialEditText;
import com.talabat.adapters.grocery.GroceryMenuSearchAdapter;
import com.talabat.adapters.grocery.SearchHistoryAdapter;
import com.talabat.adapters.grocery.TagsAdapter;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.grocery.DaggerGroceryMenuSearchActivityComponent;
import com.talabat.dialogs.MenuImageDialog;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.helpers.BuildConfigType;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.MiniCartLayout;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.restaurants.RestaurantsListScreenRefactor;
import com.talabat.talabatcommon.views.titleViewMoreGridView.GridSpacingItemDecoration;
import datamodels.CartMenuItem;
import datamodels.MenuItem;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import library.talabat.gemengine.GemView;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.menu_cart_item.MenuCartItemViewBase;
import library.talabat.mvp.menu_search.MenuSearchPresenter;
import org.jetbrains.annotations.NotNull;
import t10.a;
import tracking.AppTracker;
import tracking.ScreenNames;
import ue.c8;
import ue.d8;
import ue.e8;

public class GroceryMenuSearchActivity extends TalabatBase implements MenuCartItemViewBase, MiniCartLayout.OnCartClickListener, GroceryMenuSearchAdapter.OnClickedListener, View.OnClickListener, GemView, OnGemAlertDialogClickListener, SearchHistoryAdapter.onTermSelectedListener, TagsAdapter.onTagSelectedListener {
    /* access modifiers changed from: private */
    public boolean allItemsForCurrentKeywordLoaded = false;
    private MiniCartLayout cartFooterView;
    private Button clearSearchHistory;
    private boolean enableRecentSearchList;
    private boolean enableSearchWithButtonClick;
    private String filterBrands;
    /* access modifiers changed from: private */
    public int firstVisibleItem = 0;
    private View gemFooterView;

    /* renamed from: i  reason: collision with root package name */
    public MenuSearchPresenter f54185i;
    /* access modifiers changed from: private */
    public TextView itemCount;

    /* renamed from: j  reason: collision with root package name */
    public MenuItem f54186j;

    /* renamed from: k  reason: collision with root package name */
    public GemFooterCartView f54187k;
    @Inject

    /* renamed from: l  reason: collision with root package name */
    public AppVersionProvider f54188l;
    /* access modifiers changed from: private */
    public ProgressBar loadMoreItemsProgress;
    /* access modifiers changed from: private */
    public boolean loading = false;
    private GroceryMenuSearchAdapter mAdapter;
    private MaterialEditText mEditTextSearch;
    private GemDialogSwitcher mGemDialogSwitcher;
    private ImageView mImageViewClear;
    /* access modifiers changed from: private */
    public RecyclerView mRecyclerViewMenuItems;
    private Toolbar mToolbar;
    private View mViewNoItems;
    /* access modifiers changed from: private */
    public int pageNumber = 1;
    private RecyclerView recentSearchList;
    /* access modifiers changed from: private */
    public View recentSearchView;
    private View searchContainer;
    /* access modifiers changed from: private */
    public SearchHistoryAdapter searchHistoryAdapter;
    private String sortBy;
    private String sortOrder;
    /* access modifiers changed from: private */
    public TagsAdapter tagsAdapter;
    /* access modifiers changed from: private */
    public RecyclerView tagsRecyclerView;
    /* access modifiers changed from: private */
    public int totalItemCount = 0;
    private int totalPages = 0;
    private ImageView transitionImageView;
    private boolean updateRequired = true;
    /* access modifiers changed from: private */
    public int visibleItemCount = 0;

    private void adjustSnackBar() {
        Cart instance = Cart.getInstance();
        if (instance == null || instance.getRestaurant() == null || instance.getRestaurant().getId() != GlobalDataModel.SELECTED.restaurant.getId()) {
            this.cartFooterView.showMiniCart(0, GlobalDataModel.SELECTED.restaurant.getDisplayDeliveryCharges(), GlobalDataModel.SELECTED.restaurant.getDisplayMinimumAmount(), getDisplayAmountForEmptyCart(), GlobalDataModel.SELECTED.restaurant.isSubscriptionAvailable());
        } else {
            this.cartFooterView.showMiniCart(instance.getCartCount(), GlobalDataModel.SELECTED.restaurant.getDisplayDeliveryCharges(), GlobalDataModel.SELECTED.restaurant.getDisplayMinimumAmount(), instance.getCartSubTotalDisplayPrice(), GlobalDataModel.SELECTED.restaurant.isSubscriptionAvailable());
        }
        if (!instance.hasItems() || !instance.isRestaurantCart(GlobalDataModel.SELECTED.restaurant)) {
            if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
                this.cartFooterView.setVisibility(8);
                this.gemFooterView.setVisibility(0);
                return;
            }
            this.cartFooterView.setVisibility(0);
            this.gemFooterView.setVisibility(8);
        } else if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            this.cartFooterView.setVisibility(8);
            this.gemFooterView.setVisibility(0);
        } else {
            this.cartFooterView.setVisibility(0);
            this.gemFooterView.setVisibility(8);
        }
    }

    private void initControls() {
        try {
            this.mToolbar = (Toolbar) findViewById(R.id.toolbar);
            View findViewById = findViewById(R.id.toolbar_background);
            this.searchContainer = findViewById;
            findViewById.setBackgroundResource(R.color.white);
            setSupportActionBar(this.mToolbar);
            this.f54185i = new MenuSearchPresenter(this.f54188l, this);
            ImageView imageView = (ImageView) findViewById(R.id.iv_clear);
            this.mImageViewClear = imageView;
            imageView.setOnClickListener(this);
            ((ImageView) findViewById(R.id.iv_back)).setOnClickListener(this);
            this.mRecyclerViewMenuItems = (RecyclerView) findViewById(R.id.rcv_menu_items);
            MiniCartLayout miniCartLayout = (MiniCartLayout) findViewById(R.id.miniCart);
            this.cartFooterView = miniCartLayout;
            miniCartLayout.setClickListener(this);
            this.gemFooterView = findViewById(R.id.gem_footer_view);
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
            new LinearLayoutManager(this, 1, false);
            this.mRecyclerViewMenuItems.setLayoutManager(gridLayoutManager);
            this.mRecyclerViewMenuItems.addItemDecoration(new GridSpacingItemDecoration(2, getResources().getDimensionPixelOffset(R.dimen.grocery_grid_view_internal_margin), 2, false));
            this.mRecyclerViewMenuItems.setNestedScrollingEnabled(false);
            this.mRecyclerViewMenuItems.setHasFixedSize(true);
            this.loadMoreItemsProgress = (ProgressBar) findViewById(R.id.linear_progressBar);
            this.recentSearchView = findViewById(R.id.recent_search_view);
            this.clearSearchHistory = (Button) findViewById(R.id.clear_search_history);
            this.recentSearchList = (RecyclerView) findViewById(R.id.recent_search_list);
            this.mViewNoItems = findViewById(R.id.view_no_items);
            MaterialEditText materialEditText = (MaterialEditText) findViewById(R.id.ed_search);
            this.mEditTextSearch = materialEditText;
            materialEditText.setShowClearButton(false);
            this.itemCount = (TextView) findViewById(R.id.item_count);
            this.tagsRecyclerView = (RecyclerView) findViewById(R.id.tags_recyclerview);
            initializeTagsRecyclerView();
            setRecyclerView();
            this.mRecyclerViewMenuItems.addOnScrollListener(new RecyclerView.OnScrollListener() {
                public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
                    super.onScrollStateChanged(recyclerView, i11);
                }

                public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
                    super.onScrolled(recyclerView, i11, i12);
                    if (i12 > 0) {
                        GroceryMenuSearchActivity.this.visibleItemCount = gridLayoutManager.getChildCount();
                        GroceryMenuSearchActivity.this.firstVisibleItem = gridLayoutManager.findFirstVisibleItemPosition();
                        if (!GroceryMenuSearchActivity.this.loading && GroceryMenuSearchActivity.this.visibleItemCount + GroceryMenuSearchActivity.this.firstVisibleItem == gridLayoutManager.getItemCount() && gridLayoutManager.getItemCount() < GroceryMenuSearchActivity.this.totalItemCount) {
                            GroceryMenuSearchActivity.this.loadMoreItemsProgress.setIndeterminate(true);
                            GroceryMenuSearchActivity.this.loadMoreItemsProgress.setVisibility(0);
                            GroceryMenuSearchActivity groceryMenuSearchActivity = GroceryMenuSearchActivity.this;
                            groceryMenuSearchActivity.f54185i.setNewPageNumber(groceryMenuSearchActivity.pageNumber);
                            GroceryMenuSearchActivity.this.loading = true;
                        }
                    }
                }
            });
            this.mEditTextSearch.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                    if (editable.length() == 0) {
                        if (GroceryMenuSearchActivity.this.tagsAdapter != null) {
                            GroceryMenuSearchActivity.this.tagsAdapter.clearSelection();
                        }
                        if (GroceryMenuSearchActivity.this.recentSearchView.getVisibility() == 0) {
                            GroceryMenuSearchActivity.this.recentSearchView.setVisibility(8);
                        }
                    }
                    if (GroceryMenuSearchActivity.this.tagsRecyclerView.getVisibility() == 0) {
                        GroceryMenuSearchActivity.this.tagsRecyclerView.setVisibility(8);
                    }
                    GroceryMenuSearchActivity.this.itemCount.setText("");
                }

                public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                }

                public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                    GroceryMenuSearchActivity.this.pageNumber = 1;
                    GroceryMenuSearchActivity.this.allItemsForCurrentKeywordLoaded = false;
                    GroceryMenuSearchActivity.this.showEmptyScreen(false);
                    if (GroceryMenuSearchActivity.this.recentSearchView.getVisibility() == 0) {
                        GroceryMenuSearchActivity.this.recentSearchView.setVisibility(8);
                    }
                }
            });
            this.f54185i.setUpSearchThreads(this.mEditTextSearch, this.pageNumber);
            if (this.enableSearchWithButtonClick) {
                this.f54185i.disableAutoSearch(true);
                this.mEditTextSearch.setOnEditorActionListener(new c8(this));
            } else {
                this.f54185i.disableAutoSearch(false);
            }
            if (this.enableRecentSearchList) {
                setSearchHistoryAdapter();
            } else {
                this.recentSearchView.setVisibility(8);
            }
            inflateGemFooter();
        } catch (Exception e11) {
            e11.printStackTrace();
            finish();
        }
    }

    private void initializeTagsRecyclerView() {
        this.tagsRecyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.tagsRecyclerView.setHasFixedSize(false);
        this.tagsRecyclerView.setItemViewCacheSize(20);
        this.tagsRecyclerView.setDrawingCacheEnabled(true);
        this.tagsRecyclerView.setDrawingCacheQuality(1048576);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initControls$0(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 3 || this.mEditTextSearch.getText().toString().trim().length() <= 0) {
            return false;
        }
        this.f54185i.setNewPageNumber(this.pageNumber);
        if (this.recentSearchView.getVisibility() == 0) {
            this.recentSearchView.setVisibility(8);
        }
        getWindow().setSoftInputMode(2);
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(textView.getWindowToken(), 0);
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setSearchHistoryAdapter$1(View view) {
        this.f54185i.clearSearchHistoryList();
        SearchHistoryAdapter searchHistoryAdapter2 = this.searchHistoryAdapter;
        if (searchHistoryAdapter2 != null) {
            searchHistoryAdapter2.setNewList(new ArrayList());
        }
        this.recentSearchView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showRestaurantChangePopup$2(Restaurant restaurant, CartMenuItem cartMenuItem, DialogInterface dialogInterface, int i11) {
        this.f54185i.changeRestaurantAndAddItem(this, restaurant, cartMenuItem);
    }

    private void onReadyToAddItem(MenuItem menuItem) {
        CartMenuItem createWithMenuItem = CartMenuItem.createWithMenuItem(menuItem);
        createWithMenuItem.setQuantity(1);
        AppTracker.onProductClicked(this, createWithMenuItem, AppTracker.getRestaurantName(GlobalDataModel.SELECTED.restaurant));
        stopLodingPopup();
        this.f54185i.addItem(GlobalDataModel.SELECTED.restaurant, createWithMenuItem);
        GlobalDataModel.MENU.AddToCartClicked = false;
    }

    private void setRecyclerView() {
        List arrayList = new ArrayList();
        if (GlobalDataModel.SELECTED.restaurant.shopType != 1) {
            arrayList = this.f54185i.getMenuItems();
        }
        GroceryMenuSearchAdapter groceryMenuSearchAdapter = this.mAdapter;
        if (groceryMenuSearchAdapter == null) {
            GroceryMenuSearchAdapter groceryMenuSearchAdapter2 = new GroceryMenuSearchAdapter(this, false);
            this.mAdapter = groceryMenuSearchAdapter2;
            groceryMenuSearchAdapter2.setMenu(arrayList);
            this.mRecyclerViewMenuItems.setAdapter(this.mAdapter);
            this.mRecyclerViewMenuItems.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 2) {
                        GroceryMenuSearchActivity.this.getWindow().setSoftInputMode(2);
                        InputMethodManager inputMethodManager = (InputMethodManager) GroceryMenuSearchActivity.this.getSystemService("input_method");
                        if (inputMethodManager != null) {
                            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                        }
                    }
                    return false;
                }
            });
        } else {
            groceryMenuSearchAdapter.setMenu(arrayList);
            this.mAdapter.notifyDataSetChanged();
        }
        this.mAdapter.setClickListener(this);
        View findViewById = findViewById(R.id.view_search_container);
        findViewById.animate().alpha(1.0f).setDuration(300).start();
        findViewById.requestFocus();
    }

    private void setSearchHistoryAdapter() {
        this.searchHistoryAdapter = new SearchHistoryAdapter(this, this);
        this.recentSearchList.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.recentSearchList.setHasFixedSize(false);
        this.recentSearchList.setItemViewCacheSize(20);
        this.recentSearchList.setDrawingCacheEnabled(true);
        this.recentSearchList.setDrawingCacheQuality(1048576);
        this.recentSearchList.setAdapter(this.searchHistoryAdapter);
        this.clearSearchHistory.setOnClickListener(new d8(this));
        this.mEditTextSearch.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 && GroceryMenuSearchActivity.this.mRecyclerViewMenuItems.getAdapter().getItemCount() == 0) {
                    ArrayList<String> recentSearchHistoryList = GroceryMenuSearchActivity.this.f54185i.getRecentSearchHistoryList();
                    if (recentSearchHistoryList == null) {
                        GroceryMenuSearchActivity.this.recentSearchView.setVisibility(8);
                    } else if (recentSearchHistoryList.size() > 0) {
                        GroceryMenuSearchActivity.this.searchHistoryAdapter.setNewList(recentSearchHistoryList);
                        GroceryMenuSearchActivity.this.recentSearchView.setVisibility(0);
                    } else {
                        GroceryMenuSearchActivity.this.recentSearchView.setVisibility(8);
                    }
                }
                return false;
            }
        });
        ArrayList<String> recentSearchHistoryList = this.f54185i.getRecentSearchHistoryList();
        if (recentSearchHistoryList == null) {
            this.recentSearchView.setVisibility(8);
        } else if (recentSearchHistoryList.size() > 0) {
            this.searchHistoryAdapter.setNewList(recentSearchHistoryList);
            this.recentSearchView.setVisibility(0);
        } else {
            this.recentSearchView.setVisibility(8);
        }
    }

    public void cartButtonClicked() {
        startActivity(new Intent(this, CartScreen.class));
    }

    public void destroyPresenter() {
    }

    public String getDisplayAmountForEmptyCart() {
        return TalabatFormatter.getInstance().getFormattedCurrency(0.0f);
    }

    public EditText getEditText() {
        return this.mEditTextSearch;
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
        return ScreenNames.GROCERYMENU_SEARCH;
    }

    public void getTagsString() {
        String str;
        TagsAdapter tagsAdapter2 = this.tagsAdapter;
        if (tagsAdapter2 != null) {
            str = tagsAdapter2.getTagNameString();
        } else {
            str = "";
        }
        this.f54185i.setTagsString(str);
    }

    public void goToCart() {
        startActivity(new Intent(this, CartScreen.class));
    }

    public void inflateGemFooter() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            this.f54187k = new GemFooterCartView();
            if (GEMEngine.getInstance() != null) {
                GEMEngine.getInstance().startListening(this, false);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
            beginTransaction.add((int) R.id.gem_footer_view, (Fragment) this.f54187k, getScreenName());
            beginTransaction.commit();
        }
    }

    public /* synthetic */ void navigateToMenuWithChoiceFlutterScreen() {
        a.a(this);
    }

    public /* synthetic */ void navigateToMenuWithChoiceNativeScreen() {
        a.b(this);
    }

    public /* synthetic */ void navigateToMenuWithoutChoiceFlutterScreen() {
        a.c(this);
    }

    public /* synthetic */ void navigateToMenuWithoutChoiceNativeScreen() {
        a.d(this);
    }

    public void noChoicesAvailable() {
        onReadyToNavigatetoItemDetails();
    }

    public /* synthetic */ void onAddMoreItemClicked() {
        yq.a.a(this);
    }

    public void onAuthError() {
    }

    public /* synthetic */ void onBackToCheckoutPage(Dialog dialog) {
        yq.a.b(this, dialog);
    }

    public /* synthetic */ void onBackToRestaurantMenuPage(Dialog dialog) {
        yq.a.c(this, dialog);
    }

    public void onBackToRestaurantPage(Dialog dialog) {
        dialog.dismiss();
        finish();
        Intent intent = new Intent(this, RestaurantsListScreenRefactor.class);
        intent.setFlags(67108864);
        startActivity(intent);
    }

    public void onCartIconClicked(int i11, ImageView imageView, String str) {
        if (!GlobalDataModel.MENU.AddToCartClicked) {
            startLodingPopup();
            GlobalDataModel.MENU.AddToCartClicked = true;
            this.transitionImageView = imageView;
            MenuItem menuItem = ((GroceryMenuSearchAdapter) this.mRecyclerViewMenuItems.getAdapter()).getMenuList().get(i11);
            this.f54186j = menuItem;
            if (!menuItem.willHaveChoices()) {
                onReadyToAddItem(this.f54186j);
            } else if (!this.f54186j.isChoicesLoaded()) {
                MenuSearchPresenter menuSearchPresenter = this.f54185i;
                if (menuSearchPresenter != null) {
                    menuSearchPresenter.getChoiceSection(this.f54186j.f13861id);
                }
            } else {
                onReadyToAddItem(this.f54186j);
            }
        }
    }

    public void onChoiceReceived(SplitChoiceItemModel splitChoiceItemModel) {
        this.f54186j.choiceSections = splitChoiceItemModel.choiceSections;
        onReadyToNavigatetoItemDetails();
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.iv_back) {
            finish();
        } else if (id2 == R.id.iv_clear) {
            this.mImageViewClear.setVisibility(8);
            this.f54185i.clearEditText();
            TagsAdapter tagsAdapter2 = this.tagsAdapter;
            if (tagsAdapter2 != null) {
                tagsAdapter2.clearSelection();
            }
            GroceryMenuSearchAdapter groceryMenuSearchAdapter = this.mAdapter;
            if (groceryMenuSearchAdapter != null) {
                groceryMenuSearchAdapter.setMenu(new ArrayList());
            }
            getWindow().setSoftInputMode(2);
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public /* synthetic */ void onCloseButtonClicked(Dialog dialog) {
        yq.a.e(this, dialog);
    }

    public /* synthetic */ void onContinueToCheckout() {
        yq.a.f(this);
    }

    public void onCreate(Bundle bundle) {
        DaggerGroceryMenuSearchActivityComponent.factory().create((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        try {
            AppTracker.onProductSearchClicked(this);
            setContentView((int) R.layout.activity_grocery_menu_search);
            boolean z11 = false;
            this.enableSearchWithButtonClick = false;
            if (!BuildConfigType.ThirdPartyToolsProductionMode()) {
                z11 = true;
            }
            this.enableRecentSearchList = z11;
            initControls();
            inflateGemFooter();
            adjustSnackBar();
            if (getIntent().hasExtra("searchTerm")) {
                String stringExtra = getIntent().getStringExtra("searchTerm");
                if (!TalabatUtils.isNullOrEmpty(stringExtra)) {
                    this.mEditTextSearch.setText(stringExtra);
                    MaterialEditText materialEditText = this.mEditTextSearch;
                    materialEditText.setSelection(materialEditText.getText().length());
                }
            }
        } catch (Exception e11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(e11.getLocalizedMessage());
        }
    }

    public void onError() {
    }

    public /* synthetic */ void onInterestClicked(Restaurant restaurant) {
        yq.a.g(this, restaurant);
    }

    public void onItemAdded(CartMenuItem cartMenuItem) {
        showSingleToast();
        Cart instance = Cart.getInstance();
        showSnackBar(1, instance.isMinimumOrderAmountPassed(), instance.getQualifyAmount(), instance.getCartCount(), instance.getRestaurant().getDisplayMinimumAmount(), instance.getCartSubTotalDisplayPrice());
    }

    public /* synthetic */ void onLeaveOfferClicked(boolean z11) {
        yq.a.h(this, z11);
    }

    public void onMaxCartItemsReached() {
        Toast.makeText(this, getString(R.string.max_cart_items), 0).show();
    }

    public void onMenuImageClicked(MenuItem menuItem, ImageView imageView) {
        GlobalDataModel.MENU.menuItem = menuItem;
        if (menuItem.hasThumbnail) {
            new MenuImageDialog().show(getSupportFragmentManager(), "Dialog Fragment");
        } else {
            onMenuItemClicked(menuItem, imageView);
        }
    }

    public void onMenuItemClicked(MenuItem menuItem, ImageView imageView) {
        if (!GlobalDataModel.MENU.ChoiceClicked) {
            startLodingPopup();
            GlobalDataModel.MENU.ChoiceClicked = true;
            this.transitionImageView = imageView;
            this.f54186j = menuItem;
            if (!menuItem.willHaveChoices()) {
                onReadyToNavigatetoItemDetails();
            } else if (!this.f54186j.isChoicesLoaded()) {
                MenuSearchPresenter menuSearchPresenter = this.f54185i;
                if (menuSearchPresenter != null) {
                    menuSearchPresenter.getChoiceSection(this.f54186j.f13861id);
                }
            } else {
                onReadyToNavigatetoItemDetails();
            }
        }
    }

    public void onNavigateToItemDetails(CartMenuItem cartMenuItem, ImageView imageView) {
        GlobalDataModel.SELECTED.cartMenuItem = cartMenuItem;
        Intent intent = new Intent(this, ItemDetailsActivity.class);
        if (imageView != null) {
            startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this, imageView, "profiledis").toBundle());
        } else {
            startActivity(intent);
        }
        stopLodingPopup();
        GlobalDataModel.MENU.ChoiceClicked = false;
    }

    public void onPause() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            GEMEngine.getInstance();
            GEMEngine.stopListening();
        }
        if (this.recentSearchView.getVisibility() == 0) {
            this.recentSearchView.setVisibility(8);
        }
        super.onPause();
    }

    public void onQuantityDecreased() {
        Cart instance = Cart.getInstance();
        showSnackBar(1, instance.isMinimumOrderAmountPassed(), instance.getQualifyAmount(), instance.getCartCount(), instance.getRestaurant().getDisplayMinimumAmount(), instance.getCartSubTotalDisplayPrice());
    }

    public void onQuantityIncreased() {
        Cart instance = Cart.getInstance();
        showSnackBar(1, instance.isMinimumOrderAmountPassed(), instance.getQualifyAmount(), instance.getCartCount(), instance.getRestaurant().getDisplayMinimumAmount(), instance.getCartSubTotalDisplayPrice());
        showSingleToast();
    }

    public void onReadyToNavigatetoItemDetails() {
        CartMenuItem createWithMenuItem = CartMenuItem.createWithMenuItem(this.f54186j);
        onNavigateToItemDetails(createWithMenuItem, this.transitionImageView);
        AppTracker.onProductClicked(this, createWithMenuItem, AppTracker.getRestaurantName(GlobalDataModel.SELECTED.restaurant));
    }

    public void onResume() {
        GlobalDataModel.MENU.AddToCartClicked = false;
        GlobalDataModel.MENU.ChoiceClicked = false;
        showHideGemFooter(this.f54187k, this, false);
        GroceryMenuSearchAdapter groceryMenuSearchAdapter = this.mAdapter;
        if (groceryMenuSearchAdapter != null) {
            groceryMenuSearchAdapter.notifyDataSetChanged();
        }
        adjustSnackBar();
        super.onResume();
    }

    public void onSearchApiCalled() {
    }

    public void onSearchHistoryChanged(ArrayList<String> arrayList) {
        SearchHistoryAdapter searchHistoryAdapter2 = this.searchHistoryAdapter;
        if (searchHistoryAdapter2 != null) {
            searchHistoryAdapter2.setNewList(arrayList);
            return;
        }
        SearchHistoryAdapter searchHistoryAdapter3 = new SearchHistoryAdapter(this, this);
        this.searchHistoryAdapter = searchHistoryAdapter3;
        searchHistoryAdapter3.setNewList(arrayList);
        this.recentSearchList.setAdapter(this.searchHistoryAdapter);
    }

    public void onSearchTermSelected(@NotNull String str) {
        this.mEditTextSearch.setText(str);
        this.mEditTextSearch.setSelection(str.length());
        this.recentSearchView.setVisibility(8);
        if (!this.enableSearchWithButtonClick) {
            getWindow().setSoftInputMode(2);
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.mEditTextSearch.getWindowToken(), 0);
        }
    }

    public void onStop() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            showTimerView(true, "");
        }
        super.onStop();
    }

    public void onTagSelected(@NotNull String str) {
        this.f54185i.clearQuery();
        this.f54185i.setNewPageNumber(1);
    }

    public void setAllItemsLoaded() {
    }

    public void setGroceryTags(GroceryTagsModel[] groceryTagsModelArr) {
        new ArrayList();
        if (groceryTagsModelArr != null) {
            List asList = Arrays.asList(groceryTagsModelArr);
            if (asList.size() > 0) {
                this.tagsRecyclerView.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(0, new GroceryTagsModel(-1, getResources().getString(R.string.all), 0));
                arrayList.addAll(asList);
                this.tagsRecyclerView.scrollToPosition(0);
                TagsAdapter tagsAdapter2 = this.tagsAdapter;
                if (tagsAdapter2 != null) {
                    tagsAdapter2.setTagsArray(arrayList);
                    this.tagsAdapter.setAllSelected(true, true);
                    return;
                }
                TagsAdapter tagsAdapter3 = new TagsAdapter(arrayList, this, this);
                this.tagsAdapter = tagsAdapter3;
                this.tagsRecyclerView.setAdapter(tagsAdapter3);
                return;
            }
            this.tagsRecyclerView.setVisibility(8);
            return;
        }
        this.tagsRecyclerView.setVisibility(8);
    }

    public void setIsUpdateRequired(boolean z11) {
        this.updateRequired = z11;
    }

    public void setItemCount(GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo) {
        this.totalItemCount = groceryItemsForSectionPagingInfo.getTotalItems();
        this.totalPages = groceryItemsForSectionPagingInfo.getTotalPages();
        this.itemCount.setText(groceryItemsForSectionPagingInfo.getTotalItems() + " " + getString(R.string.grocery_items));
    }

    public void showClearButton(boolean z11) {
        if (z11) {
            this.mImageViewClear.setVisibility(0);
        } else {
            this.mImageViewClear.setVisibility(8);
        }
    }

    public void showEmptyScreen(boolean z11) {
        if (z11) {
            AppTracker.onSearchErrorShown(this, ScreenNames.getScreenType(getScreenName()), getScreenName(), this.mEditTextSearch.getText().toString().trim());
            this.mViewNoItems.setVisibility(0);
            this.mRecyclerViewMenuItems.setVisibility(4);
            return;
        }
        this.mViewNoItems.setVisibility(4);
        this.mRecyclerViewMenuItems.setVisibility(0);
    }

    public /* synthetic */ void showGemDialog() {
        v00.a.a(this);
    }

    public void showInAppReminder(int i11) {
        Context context = getContext();
        String string = getResources().getString(R.string.gem_order_notification);
        Toast.makeText(context, string.replace("#", "" + i11), 0).show();
    }

    public void showLoading() {
        this.loadMoreItemsProgress.setVisibility(0);
    }

    public void showRestaurantChangePopup(Restaurant restaurant, CartMenuItem cartMenuItem) {
        Cart instance = Cart.getInstance();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        String replace = getString(R.string.cart_will_be_cleared).replace("#", "\"" + instance.getRestaurant().f13873name + "\"");
        builder.setTitle((CharSequence) getString(R.string.start_new_cart));
        builder.setMessage((CharSequence) replace);
        builder.setPositiveButton((CharSequence) getString(R.string.start), (DialogInterface.OnClickListener) new e8(this, restaurant, cartMenuItem));
        builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void showSingleToast() {
        Toast.makeText(this, getContext().getString(R.string.items_successfully_added), 0).show();
    }

    public void showSnackBar(int i11, boolean z11, String str, int i12, String str2, String str3) {
        this.gemFooterView.setVisibility(8);
        this.cartFooterView.setVisibility(0);
        if (Cart.getInstance() == null || Cart.getInstance().getRestaurant() == null || Cart.getInstance().getRestaurant().getId() != GlobalDataModel.SELECTED.restaurant.getId()) {
            this.cartFooterView.showMiniCart(0, GlobalDataModel.SELECTED.restaurant.getDisplayDeliveryCharges(), GlobalDataModel.SELECTED.restaurant.getDisplayMinimumAmount(), getDisplayAmountForEmptyCart(), GlobalDataModel.SELECTED.restaurant.isSubscriptionAvailable());
        } else {
            this.cartFooterView.showMiniCart(Cart.getInstance().getCartCount(), GlobalDataModel.SELECTED.restaurant.getDisplayDeliveryCharges(), GlobalDataModel.SELECTED.restaurant.getDisplayMinimumAmount(), Cart.getInstance().getCartSubTotalDisplayPrice(), GlobalDataModel.SELECTED.restaurant.isSubscriptionAvailable());
        }
    }

    public void showTimeOutDialog() {
        setRecyclerView();
        showGemTimeOutDialog(this.mGemDialogSwitcher, this.f54187k, this, this);
    }

    public void showTimerView(boolean z11, String str) {
        this.f54187k.setTimerText(str);
    }

    public void stopLoading() {
        this.loadMoreItemsProgress.setVisibility(8);
    }

    public void updateList(List<MenuItem> list, String str, int i11) {
        if (this.loading) {
            int i12 = this.pageNumber;
            if (i12 < this.totalPages || i12 == 1) {
                this.pageNumber = i12 + 1;
            }
            this.loading = false;
        } else if (i11 == 0) {
            this.pageNumber = 2;
        }
        GroceryMenuSearchAdapter groceryMenuSearchAdapter = this.mAdapter;
        if (groceryMenuSearchAdapter == null) {
            GroceryMenuSearchAdapter groceryMenuSearchAdapter2 = new GroceryMenuSearchAdapter(this, false);
            this.mAdapter = groceryMenuSearchAdapter2;
            groceryMenuSearchAdapter2.setMenu(list);
            this.mRecyclerViewMenuItems.setAdapter(this.mAdapter);
        } else if (i11 > 1) {
            List<MenuItem> existingList = groceryMenuSearchAdapter.getExistingList();
            for (MenuItem next : list) {
                if (!existingList.contains(next)) {
                    existingList.add(next);
                }
            }
            this.mAdapter.setMenu(existingList);
        } else {
            groceryMenuSearchAdapter.setMenu(list);
        }
    }
}
