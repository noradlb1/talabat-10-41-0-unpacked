package com.talabat;

import JsonModels.MenuItemsResponseModel;
import JsonModels.PolygonEvents;
import JsonModels.Request.InforMapRequest;
import JsonModels.Request.McdBranchRequest;
import JsonModels.Response.ItemSearchResponse;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Cart;
import buisnessmodels.ChoiceLoader;
import buisnessmodels.GEMEngine;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder;
import com.google.android.material.tabs.TabLayout;
import com.talabat.adapters.restaurantslist.InstanceSearchAdapter;
import com.talabat.adapters.restaurantslist.RecentSearchAdapter;
import com.talabat.adapters.restaurantslist.SearchRestaurantsAdapter;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.buildconfig.BuildConfig;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.squads.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.darkstores.helper.DarkstoresDelegate;
import com.talabat.di.restaurantsearch.DaggerRestaurantsSearchActivityComponent;
import com.talabat.domain.address.Address;
import com.talabat.fluttercore.channels.NavigationMethodChannel;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.helpers.VerticalSearchSpaceItemDecoration;
import datamodels.QuickFilter;
import datamodels.Restaurant;
import datamodels.RestaurantsSearchWrapperClass;
import java.lang.Character;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import library.talabat.SharedPreferencesManager;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.restaurantssearch.IRestaurantsSearchPresenter;
import library.talabat.mvp.restaurantssearch.IRestaurantsSearchView;
import library.talabat.mvp.restaurantssearch.RestaurantsSearchPresenter;
import tracking.AppTracker;
import tracking.ScreenNames;
import tracking.ShopClickedEvent;
import ue.ae;
import ue.be;
import ue.ce;
import ue.wd;
import ue.xd;
import ue.yd;
import ue.zd;
import xq.b;

public class RestaurantsSearchActivity extends TalabatBase implements IRestaurantsSearchView, SearchRestaurantsAdapter.onSearchResultClicked, RecentSearchAdapter.OnRecentSearchClick, InstanceSearchAdapter.onSuggestSearchResultClicked {
    public static final String ARG_FROM_ACTIVITY = "ARG_FROM_ACTIVITY";
    public static final String ARG_POLYGON_EVENT = "ARG_POLYGON_EVENT";
    public static final String ARG_QUICK_FILTER = "ARG_QUICK_FILTER";
    private static final int INFORMAP_SELECTION = 40;
    private static final int MCD_BLOCK_SELECTION = 41;
    private static final int MCD_LAT_LANG_SELECTION = 42;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public AppVersionProvider f55031i;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<ItemSearchResponse> f55032j;

    /* renamed from: k  reason: collision with root package name */
    public String f55033k;

    /* renamed from: l  reason: collision with root package name */
    public int f55034l;
    /* access modifiers changed from: private */
    public RecyclerView.OnScrollListener listScrollListener = new RecyclerView.OnScrollListener() {
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            super.onScrollStateChanged(recyclerView, i11);
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            super.onScrolled(recyclerView, i11, i12);
            if (RestaurantsSearchActivity.this.mSearchResultContainer != null && RestaurantsSearchActivity.this.mSearchResultContainer.getVisibility() == 0) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                View findViewByPosition = linearLayoutManager.findViewByPosition(linearLayoutManager.findFirstVisibleItemPosition());
                if (linearLayoutManager.getItemViewType(findViewByPosition) == 3 || linearLayoutManager.getItemViewType(findViewByPosition) == 1) {
                    if (RestaurantsSearchActivity.this.mTabLayout.getTabCount() > 1 && !RestaurantsSearchActivity.this.mTabLayout.getTabAt(1).isSelected()) {
                        RestaurantsSearchActivity.this.mTabLayout.removeOnTabSelectedListener(RestaurantsSearchActivity.this.tabSelectedListener);
                        RestaurantsSearchActivity.this.mTabLayout.getTabAt(1).select();
                        RestaurantsSearchActivity.this.mTabLayout.addOnTabSelectedListener(RestaurantsSearchActivity.this.tabSelectedListener);
                    }
                } else if ((linearLayoutManager.getItemViewType(findViewByPosition) == 2 || linearLayoutManager.getItemViewType(findViewByPosition) == 0) && !RestaurantsSearchActivity.this.mTabLayout.getTabAt(0).isSelected()) {
                    RestaurantsSearchActivity.this.mTabLayout.removeOnTabSelectedListener(RestaurantsSearchActivity.this.tabSelectedListener);
                    RestaurantsSearchActivity.this.mTabLayout.getTabAt(0).select();
                    RestaurantsSearchActivity.this.mTabLayout.addOnTabSelectedListener(RestaurantsSearchActivity.this.tabSelectedListener);
                }
            }
        }
    };

    /* renamed from: m  reason: collision with root package name */
    public boolean f55035m;
    private Button mCancelButton;
    private Button mClearButton;
    private ImageView mClearSearch;
    private Button mDishesSeeMoreButton;
    private SearchRestaurantsAdapter mDishesSuggestionAdapter;
    private LinearLayout mDishesSuggestionsContainer;
    private RecyclerView mDishesSuggetionRecyclerView;
    private InstanceSearchAdapter mInstanceSearchAdapter;
    /* access modifiers changed from: private */
    public Button mInstanceSearchButton;
    private LinearLayout mInstanceSearchContainer;
    private RecyclerView mInstanceSearchRecyclerView;
    /* access modifiers changed from: private */
    public Handler mInstantSearchHandler = new Handler();
    private LinearLayout mNoRestaurantsContainer;
    private PolygonEvents mPolygonEvent;
    /* access modifiers changed from: private */
    public IRestaurantsSearchPresenter mPresenter;
    private ProgressBar mProgressBar;
    private RecentSearchAdapter mRecentAdapter;
    private LinearLayout mRecentContainer;
    private RecyclerView mRecentRecyclerView;
    private Button mRestaunatsSeeMoreButton;
    private SearchRestaurantsAdapter mRestaurantsAdapter;
    /* access modifiers changed from: private */
    public RecyclerView mRestaurantsListRecyclerView;
    private LinearLayout mRestaurantsSuggestionsContainer;
    private RecyclerView mRestaurantsSuggetionRecyclerView;
    private RelativeLayout mSearchContainer;
    private EditText mSearchEditText;
    /* access modifiers changed from: private */
    public LinearLayout mSearchResultContainer;
    private NestedScrollView mSuggestionsContainer;
    /* access modifiers changed from: private */
    public TabLayout mTabLayout;
    /* access modifiers changed from: private */
    public boolean mTabSelectionFromListScrolling = false;
    private Toolbar mToolbar;
    private LinearLayout mTrendingContainer;
    private RecyclerView mTrendingRecyclerView;

    /* renamed from: n  reason: collision with root package name */
    public String f55036n = "";
    /* access modifiers changed from: private */
    public TabLayout.OnTabSelectedListener tabSelectedListener = new TabLayout.OnTabSelectedListener() {
        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onTabSelected$0() {
            RestaurantsSearchActivity.this.mRestaurantsListRecyclerView.addOnScrollListener(RestaurantsSearchActivity.this.listScrollListener);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onTabSelected$1() {
            RestaurantsSearchActivity.this.mRestaurantsListRecyclerView.addOnScrollListener(RestaurantsSearchActivity.this.listScrollListener);
        }

        public void onTabReselected(TabLayout.Tab tab) {
        }

        public void onTabSelected(TabLayout.Tab tab) {
            if (tab.getTag() != null && !RestaurantsSearchActivity.this.mTabSelectionFromListScrolling) {
                if (((String) tab.getTag()).equalsIgnoreCase("restaurant")) {
                    RestaurantsSearchActivity.this.mRestaurantsListRecyclerView.removeOnScrollListener(RestaurantsSearchActivity.this.listScrollListener);
                    RestaurantsSearchActivity.this.mRestaurantsListRecyclerView.scrollToPosition(0);
                    new Handler().postDelayed(new w(this), 100);
                } else if (((String) tab.getTag()).equalsIgnoreCase("dish")) {
                    RestaurantsSearchActivity.this.mRestaurantsListRecyclerView.removeOnScrollListener(RestaurantsSearchActivity.this.listScrollListener);
                    ((LinearLayoutManager) RestaurantsSearchActivity.this.mRestaurantsListRecyclerView.getLayoutManager()).scrollToPositionWithOffset(RestaurantsSearchActivity.this.mPresenter.getDishesHeaderPosition(), 0);
                    new Handler().postDelayed(new x(this), 100);
                }
            }
        }

        public void onTabUnselected(TabLayout.Tab tab) {
        }
    };

    private void hideKeyboard() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.mSearchEditText.getWindowToken(), 0);
    }

    private void initInstantRecyclerView() {
        this.mInstanceSearchRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        InstanceSearchAdapter instanceSearchAdapter = new InstanceSearchAdapter(this);
        this.mInstanceSearchAdapter = instanceSearchAdapter;
        this.mInstanceSearchRecyclerView.setAdapter(instanceSearchAdapter);
        this.mInstanceSearchAdapter.setListener(this);
    }

    private void initRecentRecyclerView() {
        this.mRecentRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecentSearchAdapter recentSearchAdapter = new RecentSearchAdapter(this);
        this.mRecentAdapter = recentSearchAdapter;
        this.mRecentRecyclerView.setAdapter(recentSearchAdapter);
        this.mRecentAdapter.setListener(this);
    }

    private void initRestaurantsRecyclerView() {
        this.mRestaurantsListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRestaurantsListRecyclerView.addItemDecoration(new VerticalSearchSpaceItemDecoration(this));
        SearchRestaurantsAdapter searchRestaurantsAdapter = new SearchRestaurantsAdapter(this);
        this.mRestaurantsAdapter = searchRestaurantsAdapter;
        searchRestaurantsAdapter.setListener(this);
        this.mRestaurantsListRecyclerView.setAdapter(this.mRestaurantsAdapter);
        this.mRestaurantsListRecyclerView.addOnScrollListener(this.listScrollListener);
    }

    private void initSearch() {
        this.mSearchEditText.setOnEditorActionListener(new ce(this));
        this.mSearchEditText.addTextChangedListener(new TextWatcher() {
            /* access modifiers changed from: private */
            public /* synthetic */ void lambda$onTextChanged$0(CharSequence charSequence) {
                RestaurantsSearchActivity.this.performSearch(charSequence.toString(), false);
            }

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                String str;
                RestaurantsSearchActivity.this.mInstantSearchHandler.removeCallbacksAndMessages((Object) null);
                RestaurantsSearchActivity.this.mPresenter.onDestroy();
                if (charSequence.toString().equals("")) {
                    RestaurantsSearchActivity.this.mPresenter.getRecentSearch();
                    return;
                }
                TalabatExperiment talabatExperiment = TalabatExperiment.INSTANCE;
                TalabatExperimentConstants talabatExperimentConstants = TalabatExperimentConstants.CAN_SHOW_INSTANT_SEARCH;
                Boolean bool = BuildConfig.IS_ALPHA;
                boolean booleanValue = bool.booleanValue();
                TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy = TalabatExperimentDataSourceStrategy.APPTIMIZE;
                if (talabatExperiment.getBooleanVariant(talabatExperimentConstants, booleanValue, talabatExperimentDataSourceStrategy)) {
                    if (charSequence.toString().length() >= 2) {
                        RestaurantsSearchActivity.this.mInstantSearchHandler.postDelayed(new v(this, charSequence), 500);
                    } else if (charSequence.toString().length() == 1) {
                        RestaurantsSearchActivity.this.mPresenter.hideAllViews();
                    }
                } else if (talabatExperiment.getBooleanVariant(TalabatExperimentConstants.CAN_SHOW_DISH_SUGGESTION, bool.booleanValue(), talabatExperimentDataSourceStrategy)) {
                    RestaurantsSearchActivity restaurantsSearchActivity = RestaurantsSearchActivity.this;
                    if (restaurantsSearchActivity.isSearchTermEnglish(charSequence.toString())) {
                        str = "en-US";
                    } else {
                        str = GlobalConstants.ARABIC;
                    }
                    restaurantsSearchActivity.f55036n = str;
                    RestaurantsSearchActivity.this.mPresenter.performSuggestionsSearch(charSequence.toString(), RestaurantsSearchActivity.this.f55036n);
                } else {
                    Button A = RestaurantsSearchActivity.this.mInstanceSearchButton;
                    String string = RestaurantsSearchActivity.this.getString(R.string.search_for_suggest);
                    A.setText(Html.fromHtml(String.format(string, new Object[]{"<b>" + charSequence.toString() + "</b> "})));
                    RestaurantsSearchActivity.this.mPresenter.performInstanceSearch(charSequence.toString());
                }
            }
        });
    }

    private void initSuggestionsRestaurantsRecyclerView() {
        this.mRestaurantsSuggetionRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRestaurantsSuggetionRecyclerView.setNestedScrollingEnabled(false);
        InstanceSearchAdapter instanceSearchAdapter = new InstanceSearchAdapter(this);
        this.mInstanceSearchAdapter = instanceSearchAdapter;
        instanceSearchAdapter.setListener(this);
        this.mRestaurantsSuggetionRecyclerView.setAdapter(this.mInstanceSearchAdapter);
        this.mRestaurantsSuggetionRecyclerView.addOnScrollListener(this.listScrollListener);
    }

    private void initSuggestionsdishesRecyclerView() {
        this.mDishesSuggetionRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        SearchRestaurantsAdapter searchRestaurantsAdapter = new SearchRestaurantsAdapter(this);
        this.mDishesSuggestionAdapter = searchRestaurantsAdapter;
        searchRestaurantsAdapter.setListener(this);
        this.mDishesSuggetionRecyclerView.setAdapter(this.mDishesSuggestionAdapter);
        this.mDishesSuggetionRecyclerView.addOnScrollListener(this.listScrollListener);
    }

    private void initToolBar() {
        setSupportActionBar(this.mToolbar);
        setToolbarPadding(this.mToolbar);
        searchBarSlideLeftAnimation();
    }

    private void initUI() {
        this.mToolbar = (Toolbar) findViewById(R.id.toolbar);
        this.mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        this.mSearchResultContainer = (LinearLayout) findViewById(R.id.linearLayout_searchResultContainer);
        this.mSearchContainer = (RelativeLayout) findViewById(R.id.relativeLayout_searchContainer);
        this.mSearchEditText = (EditText) findViewById(R.id.editText_search);
        ImageView imageView = (ImageView) findViewById(R.id.imageView_clearSearch);
        this.mClearSearch = imageView;
        imageView.setOnClickListener(new wd(this));
        Button button = (Button) findViewById(R.id.button_cancel_search);
        this.mCancelButton = button;
        button.setOnClickListener(new xd(this));
        this.mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.mNoRestaurantsContainer = (LinearLayout) findViewById(R.id.linearLayout_noRestaurantContainer);
        this.mRestaurantsListRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_restaurantsList);
        this.mRecentContainer = (LinearLayout) findViewById(R.id.linearLayout_recentContainer);
        this.mRecentRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_recent);
        Button button2 = (Button) findViewById(R.id.button_clear);
        this.mClearButton = button2;
        button2.setOnClickListener(new yd(this));
        this.mTrendingContainer = (LinearLayout) findViewById(R.id.linearLayout_trendingContainer);
        this.mTrendingRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_trending);
        this.mInstanceSearchContainer = (LinearLayout) findViewById(R.id.instanceContainer);
        this.mInstanceSearchRecyclerView = (RecyclerView) findViewById(R.id.instanceSearchRecyclerView);
        Button button3 = (Button) findViewById(R.id.button_searchTerm);
        this.mInstanceSearchButton = button3;
        button3.setOnClickListener(new zd(this));
        this.mRestaurantsSuggetionRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_RestaurantsSuggestions);
        this.mDishesSuggetionRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_dishesSuggestions);
        Button button4 = (Button) findViewById(R.id.button_restaurantsSeeMore);
        this.mRestaunatsSeeMoreButton = button4;
        button4.setOnClickListener(new ae(this));
        Button button5 = (Button) findViewById(R.id.button_dishesSeeMore);
        this.mDishesSeeMoreButton = button5;
        button5.setOnClickListener(new be(this));
        this.mRestaurantsSuggestionsContainer = (LinearLayout) findViewById(R.id.restaurantsSuggestionContainer);
        this.mDishesSuggestionsContainer = (LinearLayout) findViewById(R.id.itemsSuggestionContainer);
        this.mSuggestionsContainer = (NestedScrollView) findViewById(R.id.suggestionsContainer);
    }

    private void inject() {
        DaggerRestaurantsSearchActivityComponent.factory().create((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
    }

    /* access modifiers changed from: private */
    public boolean isSearchTermEnglish(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (char of2 : str.toCharArray()) {
                if (Character.UnicodeBlock.of(of2) == Character.UnicodeBlock.ARABIC) {
                    return false;
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initSearch$0(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 3 || this.mSearchEditText.getText().toString().trim().length() < 1) {
            return false;
        }
        performSearch(this.mSearchEditText.getText().toString(), false);
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initUI$1(View view) {
        EditText editText = this.mSearchEditText;
        if (editText != null) {
            editText.setText("");
            IRestaurantsSearchPresenter iRestaurantsSearchPresenter = this.mPresenter;
            if (iRestaurantsSearchPresenter != null) {
                iRestaurantsSearchPresenter.cancelSearch();
            }
            hideList();
            hideNoResult();
            hideLoading();
            this.mPresenter.getRecentSearch();
            hideKeyboard();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initUI$2(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initUI$3(View view) {
        this.mPresenter.clearRecentSearch();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initUI$4(View view) {
        performSearch(this.mSearchEditText.getText().toString(), false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initUI$5(View view) {
        performSearch(this.mSearchEditText.getText().toString(), false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initUI$6(View view) {
        performSearch(this.mSearchEditText.getText().toString(), true);
    }

    private void navigateToDarkstores(Restaurant restaurant) {
        DarkstoresDelegate.Companion.onDarkstoresClicked(this, restaurant);
    }

    /* access modifiers changed from: private */
    public void performSearch(String str, boolean z11) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            if (!TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.CAN_SHOW_INSTANT_SEARCH, BuildConfig.IS_ALPHA.booleanValue(), TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
                hideKeyboard();
            }
            if (isSearchTermEnglish(str)) {
                str2 = "en-US";
            } else {
                str2 = GlobalConstants.ARABIC;
            }
            this.f55036n = str2;
            this.mPresenter.searchBySearchTerm(str, str2, z11);
        }
    }

    private void searchBarSlideLeftAnimation() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_left);
        loadAnimation.setDuration(400);
        loadAnimation.setFillAfter(true);
        this.mSearchContainer.startAnimation(loadAnimation);
    }

    public void addDishTab() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.tab_vendor_search, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tabName)).setText(getString(R.string.dishes));
        TabLayout.Tab newTab = this.mTabLayout.newTab();
        newTab.setCustomView(inflate);
        newTab.setTag("dish");
        this.mTabLayout.addTab(newTab);
    }

    public void addRestaurantTab() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.tab_vendor_search, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tabName)).setText(getString(R.string.restaurants_search));
        TabLayout.Tab newTab = this.mTabLayout.newTab();
        newTab.setCustomView(inflate);
        newTab.setTag("restaurant");
        this.mTabLayout.addTab(newTab);
    }

    public void destroyPresenter() {
    }

    public IGlobalPresenter getPresenter() {
        return this.mPresenter;
    }

    public String getScreenName() {
        return ScreenNames.RESTAURANS_SEARCH;
    }

    public void hideDishesSuggestionSearch() {
        LinearLayout linearLayout = this.mDishesSuggestionsContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = this.mRestaurantsSuggestionsContainer;
            if (linearLayout2 != null && linearLayout2.getVisibility() == 8) {
                showNoResult();
                hideLoading();
            }
        }
    }

    public void hideInstanceSearch() {
        this.mInstanceSearchContainer.setVisibility(8);
    }

    public void hideList() {
        if (this.mRestaurantsListRecyclerView != null) {
            this.mSearchResultContainer.setVisibility(8);
        }
    }

    public void hideLoading() {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public void hideNoResult() {
        LinearLayout linearLayout = this.mNoRestaurantsContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public void hideRecentSearch() {
        this.mRecentContainer.setVisibility(8);
    }

    public void hideRestaurantsSuggestionSearch() {
        LinearLayout linearLayout = this.mRestaurantsSuggestionsContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public void hideSuggestionSearch() {
        NestedScrollView nestedScrollView = this.mSuggestionsContainer;
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(8);
        }
    }

    public void hideTrending() {
        this.mTrendingContainer.setVisibility(8);
    }

    public void initTabLayout() {
        if (this.mTabLayout.getTabCount() > 0) {
            this.mTabLayout.removeAllTabs();
        }
        this.mTabLayout.addOnTabSelectedListener(this.tabSelectedListener);
        this.mTabLayout.setVisibility(0);
    }

    public void mcdServerError() {
        Toast.makeText(getContext(), getResources().getString(R.string.server_error_msg), 0).show();
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        int i13 = 0;
        if (i11 == 40) {
            if (i12 == -1) {
                if (intent != null) {
                    i13 = intent.getIntExtra(GlobalConstants.INFOR_MAP.TB_BRANCH_ID_MENU, -1);
                }
                if (i13 > 0) {
                    this.mPresenter.setBranchIdForSelectedRestaurant(i13);
                }
            }
        } else if (i11 == 41) {
            if (i12 == -1) {
                if (intent != null) {
                    i13 = intent.getIntExtra(GlobalConstants.MCD_GOOGLE_MAP.MCD_GOOGLE_MAP_BRANCH_ID, -1);
                }
                if (i13 > 0) {
                    this.mPresenter.setBranchIdForSelectedRestaurant(i13);
                }
            }
        } else if (i11 == 42 && i12 == -1) {
            if (intent != null) {
                i13 = intent.getIntExtra(GlobalConstants.MCD_GOOGLE_MAP.MCD_GOOGLE_MAP_BRANCH_ID, -1);
            }
            if (i13 > 0) {
                this.mPresenter.setBranchIdForSelectedRestaurant(i13);
            }
        }
    }

    public void onAuthError() {
    }

    public void onCreate(@Nullable Bundle bundle) {
        inject();
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_restaurants_search);
        this.mPolygonEvent = (PolygonEvents) getIntent().getParcelableExtra("ARG_POLYGON_EVENT");
        initUI();
        initToolBar();
        initSearch();
        TalabatExperiment talabatExperiment = TalabatExperiment.INSTANCE;
        TalabatExperimentConstants talabatExperimentConstants = TalabatExperimentConstants.CAN_SHOW_DISH_SUGGESTION;
        boolean booleanValue = BuildConfig.IS_ALPHA.booleanValue();
        TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy = TalabatExperimentDataSourceStrategy.APPTIMIZE;
        if (talabatExperiment.getBooleanVariant(talabatExperimentConstants, booleanValue, talabatExperimentDataSourceStrategy)) {
            initSuggestionsRestaurantsRecyclerView();
            initSuggestionsdishesRecyclerView();
        } else {
            initInstantRecyclerView();
        }
        initRestaurantsRecyclerView();
        initRecentRecyclerView();
        this.mPresenter = new RestaurantsSearchPresenter(this.f55031i, this, SharedPreferencesManager.getInstance(this), talabatExperiment.getBooleanVariant(TalabatExperimentConstants.CAN_SHOW_GLOBAL_SEARCH_WITHOUT_FILTER, false, talabatExperimentDataSourceStrategy));
        if (getIntent() != null && getIntent().hasExtra("ARG_FROM_ACTIVITY")) {
            if (getIntent().getStringExtra("ARG_FROM_ACTIVITY").equalsIgnoreCase("collections")) {
                this.mPresenter.setFrom(RestaurantsSearchPresenter.FromScreen.collection);
                QuickFilter quickFilter = (QuickFilter) getIntent().getParcelableExtra("ARG_QUICK_FILTER");
            } else if (getIntent().getStringExtra("ARG_FROM_ACTIVITY").equalsIgnoreCase("grocery")) {
                this.mPresenter.setFrom(RestaurantsSearchPresenter.FromScreen.grocery);
            } else {
                this.mPresenter.setFrom(RestaurantsSearchPresenter.FromScreen.list);
            }
        }
        this.mPresenter.getRecentSearch();
    }

    public void onError() {
    }

    public void onGroceryMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel) {
        String str;
        String str2;
        ArrayList<ItemSearchResponse> arrayList;
        MenuItemsResponseModel menuItemsResponseModel2 = menuItemsResponseModel;
        ChoiceLoader.startChoiceLoader(this.f55031i);
        Cart instance = Cart.getInstance();
        if (menuItemsResponseModel2 != null && instance.hasItems() && menuItemsResponseModel2.restaurant != null && instance.getRestaurant().f13873name.equals(menuItemsResponseModel2.restaurant.f13873name) && GlobalDataModel.SelectedAreaName.equals(menuItemsResponseModel2.restaurant.areaName)) {
            instance.setTgoFreeDeliveryTiers();
        }
        if (!(!GlobalDataModel.GEMCONSTANTS.isGemFlow || GEMEngine.getInstance() == null || menuItemsResponseModel2.restaurant == null)) {
            GEMEngine.getInstance().supressCouponsAndPromotion(menuItemsResponseModel2.restaurant);
            GlobalDataModel.GEMCONSTANTS.menuRestaurantId = menuItemsResponseModel2.restaurant.f13872id;
            if (GEMEngine.getInstance().shouldClearCart()) {
                Cart.getInstance().clearCart(this);
            }
        }
        Restaurant restaurant = GlobalDataModel.SELECTED.restaurant;
        String str3 = "";
        if (this.mSearchEditText.getText().toString().isEmpty()) {
            str = str3;
        } else {
            str = this.mSearchEditText.getText().toString();
        }
        if (this.mSearchEditText.getText().toString().isEmpty()) {
            str2 = str3;
        } else {
            str2 = this.mSearchEditText.getText().toString();
        }
        AppTracker.onRestaurantsClicked(this, restaurant, "", str, "", "", "shop_list", str2, this.mPolygonEvent, "N/A", (HashMap<String, String>) null, new ShopClickedEvent.EventOriginSourceDelegate(), b.l(GlobalDataModel.SELECTED.restaurant.f13872id).booleanValue(), (String) null);
        stopLodingPopup();
        Intent intent = new Intent(this, GroceryMenuScreen.class);
        if (this.f55035m && (arrayList = this.f55032j) != null && arrayList.size() > 0) {
            if (this.f55034l > 1) {
                intent.putExtra(NavigationMethodChannel.TOSCREEN, "search");
                if (this.f55036n.equalsIgnoreCase(GlobalDataModel.SelectedLanguage)) {
                    intent.putExtra("searchTerm", this.f55033k);
                } else {
                    if (!TalabatUtils.isArabic()) {
                        str3 = this.f55032j.get(0).itemNameEn;
                    } else if (this.f55032j.get(0).itemNameAr != null) {
                        str3 = this.f55032j.get(0).itemNameAr;
                    } else if (this.f55032j.get(0).itemNameEn != null) {
                        str3 = this.f55032j.get(0).itemNameEn;
                    }
                    intent.putExtra("searchTerm", str3);
                }
            } else {
                intent.putExtra("itemId", this.f55032j.get(0).itemId);
                if (this.f55036n.equalsIgnoreCase(GlobalDataModel.SelectedLanguage)) {
                    intent.putExtra("searchTerm", this.f55033k);
                }
            }
        }
        startActivity(intent);
    }

    public void onItemClick(Restaurant restaurant, ArrayList<ItemSearchResponse> arrayList, String str, int i11, String str2, int i12) {
        String str3;
        int i13;
        this.f55032j = arrayList;
        this.f55035m = true;
        if (TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.CAN_SHOW_INSTANT_SEARCH, BuildConfig.IS_ALPHA.booleanValue(), TalabatExperimentDataSourceStrategy.APPTIMIZE) || this.mDishesSuggestionsContainer.getVisibility() == 0) {
            this.mPresenter.saveSearchTerm(str2);
        }
        GlobalDataModel.ShopClickOrigin = "search";
        if (this.mSuggestionsContainer.getVisibility() == 0) {
            i11++;
        } else if (this.mPresenter.getRestaurantsCount() > 0) {
            i11--;
        }
        if (this.mSuggestionsContainer.getVisibility() == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("restaurants:");
            if (this.mRestaurantsSuggestionsContainer.getVisibility() == 0) {
                i13 = this.mInstanceSearchAdapter.getItemCount();
            } else {
                i13 = 0;
            }
            sb2.append(i13);
            sb2.append(",dishes:");
            sb2.append(this.mDishesSuggestionAdapter.getItemCount());
            str3 = sb2.toString();
        } else {
            str3 = "restaurants:" + this.mPresenter.getRestaurantsCount() + ",dishes:" + this.mPresenter.getItemsCount();
        }
        this.mPresenter.getItemPosition(arrayList.get(0));
        AppTracker.onSearchClicked(this, "shop_list", getScreenName(), this.mSearchEditText.getText().toString().trim(), str3, "dishes", i11 + "");
        this.f55033k = str;
        this.f55034l = i12;
        restaurant.itemPosition = i11;
        if (restaurant.isDarkStore || restaurant.isMigrated) {
            navigateToDarkstores(restaurant);
        } else if (restaurant.isGlrEnabled) {
            this.mPresenter.mcdMapDecisionMakerHandler(restaurant);
        } else {
            this.mPresenter.setSelectedRestaurant(restaurant);
        }
    }

    public void onMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel) {
        String str;
        String str2;
        ArrayList<ItemSearchResponse> arrayList;
        MenuItemsResponseModel menuItemsResponseModel2 = menuItemsResponseModel;
        ChoiceLoader.startChoiceLoader(this.f55031i);
        Cart instance = Cart.getInstance();
        if (menuItemsResponseModel2 != null && instance.hasItems() && menuItemsResponseModel2.restaurant != null && instance.getRestaurant().f13873name.equals(menuItemsResponseModel2.restaurant.f13873name) && GlobalDataModel.SelectedAreaName.equals(menuItemsResponseModel2.restaurant.areaName)) {
            instance.setTgoFreeDeliveryTiers();
        }
        Restaurant restaurant = GlobalDataModel.SELECTED.restaurant;
        String str3 = "";
        if (this.mSearchEditText.getText().toString().isEmpty()) {
            str = str3;
        } else {
            str = this.mSearchEditText.getText().toString();
        }
        if (this.mSearchEditText.getText().toString().isEmpty()) {
            str2 = str3;
        } else {
            str2 = this.mSearchEditText.getText().toString();
        }
        AppTracker.onRestaurantsClicked(this, restaurant, "", str, "", "", "shop_list", str2, this.mPolygonEvent, "N/A", (HashMap<String, String>) null, new ShopClickedEvent.EventOriginSourceDelegate(), b.l(GlobalDataModel.SELECTED.restaurant.f13872id).booleanValue(), (String) null);
        stopLodingPopup();
        Intent intent = new Intent(this, RestaurantMenuScreenR.class);
        if (this.f55035m && (arrayList = this.f55032j) != null && arrayList.size() > 0) {
            if (this.f55034l > 1) {
                intent.putExtra(NavigationMethodChannel.TOSCREEN, "search");
                if (this.f55036n.equalsIgnoreCase(GlobalDataModel.SelectedLanguage)) {
                    intent.putExtra("searchTerm", this.f55033k);
                } else {
                    if (!TalabatUtils.isArabic()) {
                        str3 = this.f55032j.get(0).itemNameEn;
                    } else if (this.f55032j.get(0).itemNameAr != null) {
                        str3 = this.f55032j.get(0).itemNameAr;
                    } else if (this.f55032j.get(0).itemNameEn != null) {
                        str3 = this.f55032j.get(0).itemNameEn;
                    }
                    intent.putExtra("searchTerm", str3);
                }
            } else {
                intent.putExtra("itemId", this.f55032j.get(0).itemId);
                intent.putExtra(NavigationMethodChannel.TOSCREEN, "details");
            }
        }
        startActivity(intent);
    }

    public void onRequestError() {
        stopLodingPopup();
        Toast.makeText(getContext(), getResources().getString(R.string.server_error_msg), 0).show();
    }

    public void onRestaurantClick(Restaurant restaurant, int i11) {
        String str;
        if (TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.CAN_SHOW_INSTANT_SEARCH, BuildConfig.IS_ALPHA.booleanValue(), TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            this.mPresenter.saveSearchTerm(restaurant.getName());
        }
        GlobalDataModel.ShopClickOrigin = "search";
        int i12 = 0;
        this.f55035m = false;
        if (this.mSuggestionsContainer.getVisibility() == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("restaurants:");
            sb2.append(this.mInstanceSearchAdapter.getItemCount());
            sb2.append(",dishes:");
            if (this.mDishesSuggestionsContainer.getVisibility() == 0) {
                i12 = this.mDishesSuggestionAdapter.getItemCount();
            }
            sb2.append(i12);
            str = sb2.toString();
        } else {
            str = "restaurants:" + this.mPresenter.getRestaurantsCount() + ",dishes:" + this.mPresenter.getItemsCount();
        }
        restaurant.itemPosition = i11 + 1;
        AppTracker.onSearchClicked(this, "shop_list", getScreenName(), this.mSearchEditText.getText().toString().trim(), str, StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT, restaurant.itemPosition + "");
        if (restaurant.isDarkStore || restaurant.isMigrated) {
            navigateToDarkstores(restaurant);
        } else if (restaurant.isGlrEnabled) {
            this.mPresenter.mcdMapDecisionMakerHandler(restaurant);
        } else {
            this.mPresenter.setSelectedRestaurant(restaurant);
        }
    }

    public void onServerError() {
        stopLodingPopup();
        Toast.makeText(this, getResources().getString(R.string.server_error_msg), 1).show();
    }

    public void onSuggestRestaurantClick(Restaurant restaurant, int i11) {
        this.mPresenter.saveSearchTerm(restaurant.getName());
        onRestaurantClick(restaurant, i11);
    }

    public void recentSearchClick(String str) {
        if (this.mPresenter != null) {
            this.mSearchEditText.setText(str);
            EditText editText = this.mSearchEditText;
            editText.setSelection(editText.getText().length());
            performSearch(str, false);
        }
    }

    public void selectDishTab() {
        TabLayout tabLayout = this.mTabLayout;
        if (tabLayout != null && tabLayout.getTabAt(1) != null && !this.mTabLayout.getTabAt(1).isSelected()) {
            this.mTabLayout.getTabAt(1).select();
        }
    }

    public void showAlert(int i11, String str, boolean z11) {
        String str2;
        String str3;
        String str4;
        if (i11 == 800) {
            String string = getString(R.string.restaurant_closed);
            if (z11) {
                str3 = getString(R.string.tgo_bsy_close_msg).replace(RichContentLoadTimeRecorder.DELIMETER, str);
            } else {
                str3 = getString(R.string.we_are_sorry_message).replace(RichContentLoadTimeRecorder.DELIMETER, str).replace("**", string);
            }
            if (z11) {
                str4 = getString(R.string.bsy_close_tgo_alert_title);
            } else {
                str4 = getString(R.string.restaurant) + " " + string;
            }
            if (z11) {
                str2 = getString(R.string.continue_to_restaurant);
            } else {
                str2 = getString(R.string.continue_to_restaurant);
            }
        } else {
            String string2 = getString(R.string.restaurant_busy);
            str3 = getString(R.string.we_are_sorry_message).replace(RichContentLoadTimeRecorder.DELIMETER, str).replace("**", string2);
            str2 = getString(R.string.continue_to_restaurant);
            str4 = getString(R.string.restaurant) + " " + string2;
        }
        new AlertDialog.Builder(this, R.style.AlertDialogTheme).setTitle((CharSequence) str4).setMessage((CharSequence) str3).setPositiveButton((CharSequence) str2, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                RestaurantsSearchActivity.this.mPresenter.userContinuing();
            }
        }).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
            }
        }).show();
    }

    public void showDishesSuggestionsSearch(ArrayList<RestaurantsSearchWrapperClass> arrayList, String str, boolean z11) {
        hideLoading();
        hideNoResult();
        NestedScrollView nestedScrollView = this.mSuggestionsContainer;
        if (nestedScrollView != null && this.mDishesSuggestionsContainer != null) {
            nestedScrollView.setVisibility(0);
            this.mDishesSuggestionsContainer.setVisibility(0);
            this.mDishesSuggestionAdapter.setWrapperClasses(arrayList, str);
            if (z11) {
                this.mDishesSeeMoreButton.setVisibility(0);
            } else {
                this.mDishesSeeMoreButton.setVisibility(8);
            }
        }
    }

    public void showInforMap(int i11, String str) {
        stopLodingPopup();
        Intent intent = new Intent(this, InforMapScreen.class);
        intent.putExtra(GlobalConstants.INFOR_MAP.INFORMAP_SELECTED_AREA_ID, i11);
        intent.putExtra(GlobalConstants.INFOR_MAP.RESTAURANT_NAME, str);
        startActivityForResult(intent, 40);
    }

    public void showInstanceResult(List<Restaurant> list, String str) {
        this.mInstanceSearchContainer.setVisibility(0);
        this.mInstanceSearchAdapter.setRestaurants(list, str);
    }

    public void showList(ArrayList<RestaurantsSearchWrapperClass> arrayList, String str) {
        if (!TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.CAN_SHOW_INSTANT_SEARCH, BuildConfig.IS_ALPHA.booleanValue(), TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            this.mPresenter.saveSearchTerm(this.mSearchEditText.getText().toString());
        }
        if (this.mRestaurantsListRecyclerView != null) {
            this.mSearchResultContainer.setVisibility(0);
            SearchRestaurantsAdapter searchRestaurantsAdapter = this.mRestaurantsAdapter;
            if (searchRestaurantsAdapter != null) {
                searchRestaurantsAdapter.setWrapperClasses(arrayList, str);
                this.mRestaurantsListRecyclerView.scrollToPosition(0);
            }
        }
    }

    public void showLoading() {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    public void showMcdGoogleMap(int i11, String str, Address address, int i12) {
        stopLodingPopup();
        Intent intent = new Intent(this, MapsActivity.class);
        if (address != null && address.latitude > 0.0d && address.longitude > 0.0d) {
            intent.putExtra("location", "" + address.latitude + "," + address.longitude);
        }
        intent.putExtra("userSelectedAreaId", GlobalDataModel.SelectedAreaId);
        intent.putExtra(GlobalConstants.MCD_GOOGLE_MAP.MCD_GOOGLE_MAP_FLOW, true);
        intent.putExtra("noAreaChange", true);
        intent.putExtra(GlobalConstants.MCD_GOOGLE_MAP.MCD_RESTAURANT_ID, i12);
        if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
            startActivityForResult(intent, 41);
        } else if (TalabatUtils.isMcdLatLngEnabledCountry()) {
            startActivityForResult(intent, 42);
        }
    }

    public void showMenuWithGlrID(String str, Restaurant restaurant, int i11) {
        this.mPresenter.getBranchIdFromGrl(new InforMapRequest(str, i11, true));
    }

    public void showMenuWithMcdStores(Restaurant restaurant, int i11, Address address) {
        startLodingPopup();
        this.mPresenter.getMcdBranchIdFromBlockorLatLng(new McdBranchRequest(address, restaurant.f13872id));
    }

    public void showNoResult() {
        LinearLayout linearLayout = this.mNoRestaurantsContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            AppTracker.onSearchErrorShown(this, "shop_list", getScreenName(), this.mSearchEditText.getText().toString().trim());
        }
    }

    public void showRecentSearch(ArrayList<String> arrayList) {
        this.mRecentAdapter.setRecentList(arrayList);
        this.mRecentContainer.setVisibility(0);
    }

    public void showRestaurantsSuggestionsSearch(String str, ArrayList<Restaurant> arrayList, boolean z11) {
        NestedScrollView nestedScrollView = this.mSuggestionsContainer;
        if (nestedScrollView != null && this.mRestaurantsSuggestionsContainer != null) {
            nestedScrollView.setVisibility(0);
            this.mRestaurantsSuggestionsContainer.setVisibility(0);
            this.mInstanceSearchAdapter.setRestaurants(arrayList, str);
            if (z11) {
                this.mRestaunatsSeeMoreButton.setVisibility(0);
            } else {
                this.mRestaunatsSeeMoreButton.setVisibility(8);
            }
        }
    }

    public void showSuggestionSearch() {
        NestedScrollView nestedScrollView = this.mSuggestionsContainer;
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(0);
        }
    }

    public void showTrending(ArrayList<String> arrayList) {
    }

    public void startLoadingPopup() {
        startLodingPopup();
    }
}
