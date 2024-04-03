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
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Cart;
import buisnessmodels.GEMEngine;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.materialedittext.MaterialEditText;
import com.talabat.adapters.MenuAdapter;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.menu.DaggerMenuSearchActivityComponent;
import com.talabat.feature.foodcart2.domain.di.FoodCartFeatureApi;
import com.talabat.feature.nfvinvendorsearch.presentation.utils.Constants;
import com.talabat.flutter.utils.FlutterMenuBasketSavingFeatureGate;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.itemdetailsbottomsheet.ItemDetailsBottomSheet;
import com.talabat.itemdetailsbottomsheet.ItemDetailsCallbacks;
import com.talabat.lib.Integration;
import com.talabat.restaurants.RestaurantsListScreenRefactor;
import com.talabat.vendormenu.presentation.flutter.VendorItemDetailsFlutterActivity;
import com.talabat.vendormenu.presentation.flutter.VendorItemDetailsWithChoiceFlutterActivity;
import datamodels.CartMenuItem;
import datamodels.ChoiceSection;
import datamodels.MenuItem;
import datamodels.Restaurant;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import library.talabat.gemengine.GemView;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.cart.CartUtility;
import library.talabat.mvp.menu_cart_item.MenuCartItemViewBase;
import library.talabat.mvp.menu_search.MenuSearchPresenter;
import org.jetbrains.annotations.NotNull;
import tracking.AppTracker;
import tracking.ScreenNames;
import ue.cb;
import ue.db;
import yq.a;

public class MenuSearchActivity extends TalabatBase implements MenuCartItemViewBase, MenuAdapter.OnClickedListener, View.OnClickListener, GemView, OnGemAlertDialogClickListener, ItemDetailsCallbacks {
    private static boolean ANIMATION_REQUIRED = true;
    private static final int ITEM_WITHOUT_CHOICE_FLUTTER_ACTIVITY = 999;
    private Button cancelButton;
    private FlutterMenuBasketSavingFeatureGate flutterMenuFeatureGate;

    /* renamed from: i  reason: collision with root package name */
    public MenuSearchPresenter f54392i;

    /* renamed from: j  reason: collision with root package name */
    public MenuItem f54393j;

    /* renamed from: k  reason: collision with root package name */
    public GemFooterCartView f54394k;

    /* renamed from: l  reason: collision with root package name */
    public ActivityResultLauncher<Intent> f54395l;
    @Inject

    /* renamed from: m  reason: collision with root package name */
    public AppVersionProvider f54396m;
    /* access modifiers changed from: private */
    public MenuAdapter mAdapter;
    private MaterialEditText mEditTextSearch;
    private GemDialogSwitcher mGemDialogSwitcher;
    /* access modifiers changed from: private */
    public ImageView mImageViewClear;
    private RecyclerView mRecyclerViewMenuItems;
    private Toolbar mToolbar;
    private View mViewNoItems;
    @Inject

    /* renamed from: n  reason: collision with root package name */
    public CartUtility f54397n;
    @Inject

    /* renamed from: o  reason: collision with root package name */
    public ITalabatExperiment f54398o;
    private ImageView transitionImageView;

    /* access modifiers changed from: private */
    public void addItemToCartUtility(CartMenuItem cartMenuItem, int i11, String str) {
        if (this.flutterMenuFeatureGate.canShowBasketSavingInMenu()) {
            this.f54397n.addItem(cartMenuItem, i11, str);
        }
    }

    private void handleWithChoiceActivityResult(Intent intent) {
        String str;
        String stringExtra = intent.getStringExtra("specialRequest");
        int intExtra = intent.getIntExtra(FirebaseAnalytics.Param.QUANTITY, 1);
        CartMenuItem createWithMenuItem = CartMenuItem.createWithMenuItem(this.f54393j);
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("selectedChoices");
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                createWithMenuItem.setSelectedChoicesForSection((ChoiceSection) it.next());
            }
            createWithMenuItem.allChoices = arrayList;
        }
        if (stringExtra.isEmpty()) {
            stringExtra = null;
        }
        createWithMenuItem.specialRequest = stringExtra;
        createWithMenuItem.setQuantity(intExtra);
        Cart.getInstance().setRestaurant(GlobalDataModel.SELECTED.getRestaurant(), this);
        Cart.getInstance().addItem(createWithMenuItem, this);
        onItemAdded(createWithMenuItem);
        ArrayList<ChoiceSection> arrayList2 = createWithMenuItem.selectedChoices;
        if (arrayList2 != null) {
            str = TalabatUtils.getChoicesString(arrayList2);
        } else {
            str = "";
        }
        String str2 = str;
        if (GlobalDataModel.SELECTED.getRestaurant() != null) {
            AppTracker.onItemAddedToCart(this, Cart.getInstance().getRestaurant(), createWithMenuItem, AppTracker.getRestaurantId(GlobalDataModel.SELECTED.getRestaurant()), AppTracker.getRestaurantName(GlobalDataModel.SELECTED.getRestaurant()), "product_choice", str2, createWithMenuItem.getSelectedQuantityOfMandatoryAndOptionalChoices()[0], createWithMenuItem.getSelectedQuantityOfMandatoryAndOptionalChoices()[1], ScreenNames.getScreenType(getScreenName()), getScreenName());
            addItemToCartUtility(createWithMenuItem, GlobalDataModel.SELECTED.getRestaurant().branchId, GlobalDataModel.SELECTED.getRestaurant().deliveryMode());
        }
    }

    private void initControls() {
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            this.f54392i = new MenuSearchPresenter(this.f54396m, this);
            ImageView imageView = (ImageView) findViewById(R.id.iv_clear);
            this.mImageViewClear = imageView;
            imageView.setOnClickListener(this);
            Button button = (Button) findViewById(R.id.button_cancel_search);
            this.cancelButton = button;
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MenuSearchActivity.this.finish();
                }
            });
            this.mRecyclerViewMenuItems = (RecyclerView) findViewById(R.id.rcv_menu_items);
            this.mRecyclerViewMenuItems.setLayoutManager(new LinearLayoutManager(this, 1, false));
            this.mRecyclerViewMenuItems.setNestedScrollingEnabled(false);
            this.mRecyclerViewMenuItems.setHasFixedSize(true);
            if (GlobalDataModel.SELECTED.getRestaurant() == null) {
                finish();
            } else if (GlobalDataModel.SELECTED.getRestaurant().shopType != 1) {
                setRecyclerView();
            } else if (GlobalDataModel.JSON.groceryMenuLoaded.getValue().booleanValue()) {
                setRecyclerView();
            } else {
                showLoading();
                GlobalDataModel.JSON.groceryMenuLoaded.observe(this, new cb(this));
            }
            this.mViewNoItems = findViewById(R.id.view_no_items);
            MaterialEditText materialEditText = (MaterialEditText) findViewById(R.id.ed_search);
            this.mEditTextSearch = materialEditText;
            materialEditText.setShowClearButton(false);
            this.mEditTextSearch.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                    if (editable.length() > 0) {
                        MenuSearchActivity.this.mImageViewClear.setVisibility(0);
                    } else {
                        MenuSearchActivity.this.mImageViewClear.setVisibility(8);
                    }
                }

                public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                }

                public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                    if (MenuSearchActivity.this.mAdapter != null) {
                        MenuSearchActivity.this.mAdapter.getFilter().filter(charSequence);
                    }
                }
            });
            inflateGemFooter();
        } catch (Exception e11) {
            e11.printStackTrace();
            finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initControls$1(Boolean bool) {
        if (bool.booleanValue()) {
            stopLoading();
            setRecyclerView();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(ActivityResult activityResult) {
        Intent data;
        if (activityResult.getResultCode() == -1 && (data = activityResult.getData()) != null) {
            handleWithChoiceActivityResult(data);
        }
    }

    private void searchBarSlideLeftAnimation() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.view_search_container);
        relativeLayout.setBackgroundResource(R.color.white);
        relativeLayout.setLayoutAnimationListener((Animation.AnimationListener) null);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_left);
        loadAnimation.setDuration(600);
        loadAnimation.setFillAfter(true);
        relativeLayout.startAnimation(loadAnimation);
    }

    private void setRecyclerView() {
        List<MenuItem> menuItems = this.f54392i.getMenuItems();
        MenuAdapter menuAdapter = this.mAdapter;
        if (menuAdapter == null) {
            MenuAdapter menuAdapter2 = new MenuAdapter(this, false);
            this.mAdapter = menuAdapter2;
            menuAdapter2.setMenu(menuItems);
            this.mRecyclerViewMenuItems.setAdapter(this.mAdapter);
            this.mRecyclerViewMenuItems.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 2) {
                        MenuSearchActivity.this.getWindow().setSoftInputMode(2);
                        InputMethodManager inputMethodManager = (InputMethodManager) MenuSearchActivity.this.getSystemService("input_method");
                        if (inputMethodManager != null) {
                            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                        }
                    }
                    return false;
                }
            });
        } else {
            menuAdapter.setMenu(menuItems);
            this.mAdapter.notifyDataSetChanged();
        }
        this.mAdapter.setClickListener(this);
    }

    public void destroyPresenter() {
    }

    public EditText getEditText() {
        return null;
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
        return ScreenNames.RESTAURANTMENU_SEARCH;
    }

    public void getTagsString() {
    }

    public void inflateGemFooter() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            this.f54394k = new GemFooterCartView();
            if (GEMEngine.getInstance() != null) {
                GEMEngine.getInstance().startListening(this, false);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
            beginTransaction.add((int) R.id.gem_footer_view, (Fragment) this.f54394k, getScreenName());
            beginTransaction.commit();
        }
    }

    public void navigateToMenuWithChoiceFlutterScreen() {
        int i11;
        String str;
        int i12 = 0;
        GlobalDataModel.MENU.ChoiceClicked = false;
        GlobalDataModel.SELECTED.cartMenuItem = CartMenuItem.createWithMenuItem(this.f54393j);
        Intent intent = new Intent(this, VendorItemDetailsWithChoiceFlutterActivity.class);
        intent.putExtra("branchId", this.f54392i.getmRestaurant().branchId);
        intent.putExtra("itemId", this.f54393j.f13861id);
        intent.putExtra("isGemFlow", Integration.isGemActive());
        intent.putExtra("origin", "menu_search");
        intent.putExtra(Constants.ARG_BACKGROUND_MODE, FlutterActivityLaunchConfigs.BackgroundMode.transparent.name());
        if (Cart.getInstance().getRestaurant() != null) {
            i11 = Cart.getInstance().getRestaurant().branchId;
        } else {
            i11 = -1;
        }
        intent.putExtra("cartVendorId", i11);
        if (Cart.getInstance().getRestaurant() != null) {
            str = Cart.getInstance().getRestaurant().f13873name;
        } else {
            str = "";
        }
        intent.putExtra("cartVendorName", str);
        if (Cart.getInstance().getCartItems() != null) {
            i12 = Cart.getInstance().getCartItems().size();
        }
        intent.putExtra("cartSize", i12);
        this.f54395l.launch(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void navigateToMenuWithChoiceNativeScreen() {
        startLodingPopup();
        if (!this.f54393j.isChoicesLoaded()) {
            MenuSearchPresenter menuSearchPresenter = this.f54392i;
            if (menuSearchPresenter != null) {
                menuSearchPresenter.getChoiceSection(this.f54393j.f13861id);
                return;
            }
            return;
        }
        onReadyToNavigatetoItemDetails();
    }

    @Deprecated
    public void navigateToMenuWithoutChoiceFlutterScreen() {
        Intent intent = new Intent(this, VendorItemDetailsFlutterActivity.class);
        intent.putExtra("branchId", this.f54392i.getmRestaurant().branchId);
        intent.putExtra("itemId", this.f54393j.f13861id);
        intent.putExtra("isGemFlow", Integration.isGemActive());
        intent.putExtra("origin", "menu_search");
        intent.putExtra(Constants.ARG_BACKGROUND_MODE, FlutterActivityLaunchConfigs.BackgroundMode.transparent.name());
        startActivityForResult(intent, 999);
    }

    public void navigateToMenuWithoutChoiceNativeScreen() {
        ItemDetailsBottomSheet.Companion.newInstance(CartMenuItem.createWithMenuItem(this.f54393j), GlobalDataModel.SELECTED.getRestaurant().shouldDisableSpecialRequest(), this).showDialog(getSupportFragmentManager(), "busy popup bottom sheet dialog");
    }

    public void noChoicesAvailable() {
        onReadyToNavigatetoItemDetails();
    }

    @Deprecated
    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 999 && i12 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra("specialRequest");
            int intExtra = intent.getIntExtra(FirebaseAnalytics.Param.QUANTITY, 1);
            CartMenuItem createWithMenuItem = CartMenuItem.createWithMenuItem(this.f54393j);
            createWithMenuItem.specialRequest = stringExtra;
            createWithMenuItem.setQuantity(intExtra);
            onAddToBasketClicked(createWithMenuItem);
        }
    }

    public /* synthetic */ void onAddMoreItemClicked() {
        a.a(this);
    }

    public void onAddToBasketClicked(@NotNull CartMenuItem cartMenuItem) {
        MenuSearchPresenter menuSearchPresenter = this.f54392i;
        menuSearchPresenter.addItem(menuSearchPresenter.getmRestaurant(), cartMenuItem, this);
        if (Cart.getInstance().isRestaurantCart(this.f54392i.getmRestaurant())) {
            addItemToCartUtility(cartMenuItem, this.f54392i.getmRestaurant().branchId, this.f54392i.getmRestaurant().deliveryMode());
        }
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
        finish();
        Intent intent = new Intent(this, RestaurantsListScreenRefactor.class);
        intent.setFlags(67108864);
        startActivity(intent);
    }

    public void onCartIconClicked(int i11, ImageView imageView) {
        if (!GlobalDataModel.MENU.ChoiceClicked) {
            GlobalDataModel.MENU.ChoiceClicked = true;
            this.transitionImageView = imageView;
            MenuItem menuItem = ((MenuAdapter) this.mRecyclerViewMenuItems.getAdapter()).getMenuList().get(i11);
            this.f54393j = menuItem;
            if (!menuItem.willHaveChoices()) {
                onReadyToAddItem(this.f54393j);
            }
        }
    }

    public void onChoiceReceived(SplitChoiceItemModel splitChoiceItemModel) {
        this.f54393j.choiceSections = splitChoiceItemModel.choiceSections;
        onReadyToNavigatetoItemDetails();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.iv_clear) {
            this.mEditTextSearch.setText("");
            getWindow().setSoftInputMode(2);
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public /* synthetic */ void onCloseButtonClicked(Dialog dialog) {
        a.e(this, dialog);
    }

    public /* synthetic */ void onContinueToCheckout() {
        a.f(this);
    }

    public void onCreate(Bundle bundle) {
        DaggerMenuSearchActivityComponent.factory().create((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class), (ExperimentCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ExperimentCoreLibApi.class), (FoodCartFeatureApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FoodCartFeatureApi.class)).inject(this);
        super.onCreate(bundle);
        AppTracker.onProductSearchClicked(this);
        setContentView((int) R.layout.activity_menu_search);
        initControls();
        searchBarSlideLeftAnimation();
        if (getIntent().hasExtra("searchTerm")) {
            String stringExtra = getIntent().getStringExtra("searchTerm");
            if (!TalabatUtils.isNullOrEmpty(stringExtra)) {
                this.mEditTextSearch.setText(stringExtra);
                MaterialEditText materialEditText = this.mEditTextSearch;
                materialEditText.setSelection(materialEditText.getText().length());
            }
        }
        this.f54395l = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new db(this));
        this.flutterMenuFeatureGate = new FlutterMenuBasketSavingFeatureGate(this.f54398o);
    }

    public void onError() {
    }

    public /* synthetic */ void onInterestClicked(Restaurant restaurant) {
        a.g(this, restaurant);
    }

    public void onItemAdded(CartMenuItem cartMenuItem) {
        showSingleToast();
        MenuAdapter menuAdapter = this.mAdapter;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    public /* synthetic */ void onLeaveOfferClicked(boolean z11) {
        a.h(this, z11);
    }

    public void onMaxCartItemsReached() {
    }

    public void onMenuImageClicked(int i11, ImageView imageView) {
        onMenuItemClicked(i11, imageView);
    }

    public void onMenuItemClicked(int i11, ImageView imageView) {
        if (!GlobalDataModel.MENU.ChoiceClicked) {
            GlobalDataModel.MENU.ChoiceClicked = true;
            this.transitionImageView = imageView;
            MenuItem menuItem = ((MenuAdapter) this.mRecyclerViewMenuItems.getAdapter()).getMenuList().get(i11);
            this.f54393j = menuItem;
            if (menuItem.willHaveChoices()) {
                this.f54392i.handleMenuWithChoiceClick();
                return;
            }
            if (this.f54392i.getmRestaurant() != null) {
                AppTracker.onProductClicked(this, CartMenuItem.createWithMenuItem(this.f54393j), AppTracker.getRestaurantName(this.f54392i.getmRestaurant()));
            }
            GlobalDataModel.MENU.ChoiceClicked = false;
            this.f54392i.handleMenuWithoutChoiceClick();
        }
    }

    public void onNavigateToItemDetails(CartMenuItem cartMenuItem, ImageView imageView) {
        Intent intent;
        GlobalDataModel.SELECTED.cartMenuItem = cartMenuItem;
        ANIMATION_REQUIRED = true;
        if (GlobalDataModel.Apptimize.itemDetailsHeaderVariant == GlobalConstants.ITEMDETAILS.noRevamp) {
            intent = new Intent(this, ItemDetailsActivity.class);
        } else {
            intent = new Intent(this, ItemDetailsRevampedActivity.class);
        }
        if (imageView != null) {
            startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this, imageView, "profiledis").toBundle());
            if (GlobalDataModel.Apptimize.itemDetailsHeaderVariant > GlobalConstants.ITEMDETAILS.noRevamp) {
                overridePendingTransition(R.anim.activity_slide_from_bottom, R.anim.nothing);
            }
        } else {
            startActivity(intent);
            if (GlobalDataModel.Apptimize.itemDetailsHeaderVariant > GlobalConstants.ITEMDETAILS.noRevamp) {
                overridePendingTransition(R.anim.activity_slide_from_bottom, R.anim.nothing);
            }
        }
        stopLodingPopup();
        GlobalDataModel.MENU.ChoiceClicked = false;
    }

    public void onPause() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            GEMEngine.getInstance();
            GEMEngine.stopListening();
        }
        super.onPause();
    }

    public void onReadyToAddItem(MenuItem menuItem) {
        CartMenuItem createWithMenuItem = CartMenuItem.createWithMenuItem(menuItem);
        createWithMenuItem.setQuantity(1);
        AppTracker.onProductClicked(this, createWithMenuItem, AppTracker.getRestaurantName(this.f54392i.getmRestaurant()));
        stopLodingPopup();
        MenuSearchPresenter menuSearchPresenter = this.f54392i;
        menuSearchPresenter.addItem(menuSearchPresenter.getmRestaurant(), createWithMenuItem, this);
        GlobalDataModel.MENU.ChoiceClicked = false;
    }

    public void onReadyToNavigatetoItemDetails() {
        CartMenuItem createWithMenuItem = CartMenuItem.createWithMenuItem(this.f54393j);
        onNavigateToItemDetails(createWithMenuItem, this.transitionImageView);
        AppTracker.onProductClicked(this, createWithMenuItem, AppTracker.getRestaurantName(GlobalDataModel.SELECTED.getRestaurant()));
    }

    public void onResume() {
        if (ANIMATION_REQUIRED) {
            ANIMATION_REQUIRED = false;
            MenuAdapter menuAdapter = this.mAdapter;
            if (menuAdapter != null) {
                menuAdapter.notifyDataSetChanged();
            }
        }
        showHideGemFooter(this.f54394k, this, false);
        super.onResume();
    }

    public void onSearchApiCalled() {
    }

    public void onSearchHistoryChanged(ArrayList<String> arrayList) {
    }

    public void setAllItemsLoaded() {
    }

    public void setGroceryTags(GroceryTagsModel[] groceryTagsModelArr) {
    }

    public void setIsUpdateRequired(boolean z11) {
    }

    public void setItemCount(GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo) {
    }

    public void showClearButton(boolean z11) {
    }

    public void showEmptyScreen(boolean z11) {
        if (z11) {
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
        startLodingPopup();
    }

    public void showRestaurantChangePopup(final Restaurant restaurant, final CartMenuItem cartMenuItem) {
        Cart instance = Cart.getInstance();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        String replace = getString(R.string.cart_will_be_cleared).replace("#", "\"" + instance.getRestaurant().f13873name + "\"");
        builder.setTitle((CharSequence) getString(R.string.start_new_cart));
        builder.setMessage((CharSequence) replace);
        builder.setPositiveButton((CharSequence) getString(R.string.start), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                MenuSearchActivity menuSearchActivity = MenuSearchActivity.this;
                menuSearchActivity.f54392i.changeRestaurantAndAddItem(menuSearchActivity, restaurant, cartMenuItem);
                MenuSearchActivity menuSearchActivity2 = MenuSearchActivity.this;
                CartMenuItem cartMenuItem = cartMenuItem;
                Restaurant restaurant = restaurant;
                menuSearchActivity2.addItemToCartUtility(cartMenuItem, restaurant.branchId, restaurant.deliveryMode());
            }
        });
        builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void showSingleToast() {
        MenuAdapter menuAdapter = this.mAdapter;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
        Toast.makeText(this, getContext().getString(R.string.items_successfully_added), 0).show();
    }

    public void showTimeOutDialog() {
        showGemTimeOutDialog(this.mGemDialogSwitcher, this.f54394k, this, this);
    }

    public void showTimerView(boolean z11, String str) {
        this.f54394k.setTimerText(str);
    }

    public void stopLoading() {
        stopLodingPopup();
    }

    public void updateList(List<MenuItem> list, String str, int i11) {
    }
}
