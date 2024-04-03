package com.talabat;

import JsonModels.Request.InforMapRequest;
import JsonModels.Request.McdBranchRequest;
import JsonModels.parser.UniversalGson;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Cart;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.buildconfig.BuildConfig;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.home.HomeScreen;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.darkstores.helper.DarkstoresDelegate;
import com.talabat.di.branding.DaggerBrandingScreenComponent;
import com.talabat.domain.address.Address;
import com.talabat.helpers.ApptimizeHelper;
import com.talabat.helpers.BitmapLruCache;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.homemaphelper.CurrentLocationFetch;
import com.talabat.homemaphelper.CurrentLocationListener;
import com.talabat.maputils.CurrentLocHelper;
import com.talabat.observability.performance.PerformanceTracker;
import com.talabat.vendormenu.presentation.flutter.MenuNavigatorController;
import com.talabat.vendormenu.presentation.flutter.MenuNavigatorModel;
import datamodels.Area;
import datamodels.City;
import datamodels.DeliveryArea;
import datamodels.Restaurant;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.branding.BrandingPresenter;
import library.talabat.mvp.branding.BrandingView;
import library.talabat.mvp.branding.IBrandingPresenter;
import library.talabat.mvp.homemap.HomeMapTemp;
import library.talabat.mvp.homemap.HomeMapUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import tracking.AppTracker;
import tracking.ScreenNames;
import ue.k0;
import ue.l0;

@Instrumented
public class BrandingScreen extends TalabatBase implements BrandingView, CurrentLocationListener {
    private static final int GPSENABLE = 36;
    private static final int INFORMAP_REQUEST = 50;
    private static final int MAP_SCREEN_SELECTION = 53;
    private static final int MCD_BLOCK_SELECTION = 51;
    private static final int MCD_LAT_LANG_SELECTION = 52;
    private static final int PERMISSION_REQUEST_CODE = 42;
    private static final int REQUEST_AREA = 40;
    private static final int REQUEST_CITY = 41;
    private static final int REQUEST_FRANCHISE = 42;
    private static final int REQUEST_FRANCHISE_MAP = 54;
    /* access modifiers changed from: private */
    public int FranchiseGrpId;
    private View MapFirstSelectionView;
    private int TbResBanchID;
    private TextView areaName;
    private TextView areaNameMf;
    private View areaView;
    private View areaViewMf;
    private ImageButton area_gps;
    private ImageButton backBtn;
    private TextView branchName;
    private TextView branchNameMf;
    private View branchView;
    private View branchViewMf;
    private RelativeLayout cartHolder;
    private ImageButton cartImage;
    private TextView cityName;
    private View cityView;
    private ImageButton city_gps;
    private TextView cuisinesText;
    private String deeplinkMigratedInfo = "";
    private int deeplinkMigratedType = -1;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public AppVersionProvider f53672i;
    /* access modifiers changed from: private */
    public IBrandingPresenter iBrandingPresenter;
    private ImageView imgBrandingChooseArea;
    private boolean isFranchiseRest;
    private boolean isMapFirstEnabled;
    private boolean isUpdateAddressSelected;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public ConfigurationLocalRepository f53673j;
    @Inject

    /* renamed from: k  reason: collision with root package name */
    public LocationConfigurationRepository f53674k;
    @Inject

    /* renamed from: l  reason: collision with root package name */
    public Navigator f53675l;
    /* access modifiers changed from: private */
    public Location location;
    /* access modifiers changed from: private */
    public LocationManager locationManager;
    @Inject

    /* renamed from: m  reason: collision with root package name */
    public ITalabatFeatureFlag f53676m;
    private RelativeLayout mBrandingInsideArea;
    private RelativeLayout mBrandingInsideAreaMf;
    private RelativeLayout mBrandingInsideBranch;
    private RelativeLayout mBrandingInsideBranchMf;
    private RelativeLayout mBrandinginsideCityView;
    private Toolbar mToolbar;
    private int mcdBhBlockBranchId;
    private String mcdResBanchID;
    @Inject

    /* renamed from: n  reason: collision with root package name */
    public DeepLinkNavigator f53677n;
    private View normalBandAreaSelectionView;

    /* renamed from: o  reason: collision with root package name */
    public ImageLoader f53678o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f53679p;
    private String restaurant;
    private NetworkImageView restaurantLogo;
    private TextView restaurantText;
    private String selectedGlrID;
    private Button showMenu;
    private Button showMenuMf;
    private ImageButton sideMenuBtn;
    private RecyclerView sideMenuList;

    private void alertToast(String str) {
        Toast.makeText(this, str, 1).show();
    }

    private boolean checkPermission(Context context) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        onBackPressed();
    }

    private void navigateToHomeScreen() {
        this.f53675l.navigateTo(this, new HomeScreen(new HomeScreen.HomeScreenData(HomeScreen.NavigationTab.HOME, true)), new l0());
    }

    /* access modifiers changed from: private */
    public void requestPermission(Context context) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.ACCESS_FINE_LOCATION")) {
            Toast.makeText(context, R.string.permission_rationale, 1).show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 42);
        }
    }

    private void resetPreselectlocation() {
        this.areaNameMf.setText(R.string.set_deliver_location);
        this.areaNameMf.setTextColor(getResources().getColor(R.color.select_area_color));
        ImageView imageView = this.imgBrandingChooseArea;
        if (imageView != null) {
            imageView.setVisibility(8);
            this.imgBrandingChooseArea.setImageDrawable(getResources().getDrawable(R.drawable.selected_pin_big));
        }
        View view = this.branchViewMf;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void selectArea(Area area) {
        GlobalDataModel.SelectedAreaId = area.f13835id;
        GlobalDataModel.SelectedAreaName = area.areaName;
        this.iBrandingPresenter.areaSelected();
    }

    private void selectedAddressNotDeliveringAlert(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    private void setBranchName(String str, TextView textView) {
        if (TalabatUtils.isNullOrEmpty(str)) {
            textView.setText(R.string.choose_branch_branding);
            this.iBrandingPresenter.branchDeslected(true);
            return;
        }
        textView.setText(str);
        this.iBrandingPresenter.branchDeslected(false);
    }

    private void setBranchViewVisiblity(View view, boolean z11) {
        if (z11) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public void OnCurrentLocationPermissionStatus(@NotNull PermissionDeniedResponse permissionDeniedResponse) {
    }

    public void branchVisibility(boolean z11) {
        if (this.isMapFirstEnabled) {
            setBranchViewVisiblity(this.branchViewMf, z11);
        } else {
            setBranchViewVisiblity(this.branchView, z11);
        }
    }

    public void cityVisibility(boolean z11) {
        if (z11) {
            View view = this.cityView;
            if (view != null) {
                view.setVisibility(0);
            }
            this.areaView.setVisibility(0);
            TextView textView = this.areaNameMf;
            if (textView != null) {
                textView.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this.cityView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        this.areaView.setVisibility(0);
        TextView textView2 = this.areaNameMf;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
    }

    public void deliverToCLRecived(@NotNull LatLng latLng) {
    }

    public void destroyPresenter() {
        this.iBrandingPresenter = null;
    }

    public Context getContext() {
        return this;
    }

    public void getGpsLocation() {
        if (checkPermission(this)) {
            Criteria criteria = new Criteria();
            criteria.setAccuracy(1);
            criteria.setBearingRequired(true);
            criteria.setBearingAccuracy(1);
            if (this.locationManager.isProviderEnabled("gps")) {
                final Handler handler = new Handler(Looper.myLooper());
                final AnonymousClass11 r12 = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        BrandingScreen.this.location = location;
                        if (!(ContextCompat.checkSelfPermission(BrandingScreen.this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(BrandingScreen.this, "android.permission.ACCESS_COARSE_LOCATION") == 0)) {
                            BrandingScreen brandingScreen = BrandingScreen.this;
                            brandingScreen.requestPermission(brandingScreen);
                        }
                        BrandingScreen.this.iBrandingPresenter.locationRecieved(BrandingScreen.this.location);
                        BrandingScreen.this.locationManager.removeUpdates(this);
                        Handler handler = handler;
                        if (handler != null) {
                            handler.removeCallbacksAndMessages((Object) null);
                        }
                    }

                    public void onProviderDisabled(String str) {
                    }

                    public void onProviderEnabled(String str) {
                    }

                    public void onStatusChanged(String str, int i11, Bundle bundle) {
                    }
                };
                startLodingPopup();
                this.locationManager.requestSingleUpdate(criteria, r12, (Looper) null);
                handler.postDelayed(new Runnable() {
                    public void run() {
                        if (ContextCompat.checkSelfPermission(BrandingScreen.this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(BrandingScreen.this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                            BrandingScreen.this.locationManager.removeUpdates(r12);
                            BrandingScreen brandingScreen = BrandingScreen.this;
                            Toast.makeText(brandingScreen, brandingScreen.getResources().getString(R.string.gps_time_out), 0).show();
                            BrandingScreen.this.stopLodingPopup();
                        }
                    }
                }, 5000);
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
            builder.setTitle((CharSequence) getString(R.string.location_disabled));
            builder.setMessage((CharSequence) getString(R.string.enable_gps_description));
            builder.setPositiveButton((CharSequence) getString(R.string.settings).toUpperCase(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                    Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                    intent.addFlags(1073741824);
                    BrandingScreen.this.startActivityForResult(intent, 36);
                }
            });
            builder.setNegativeButton((CharSequence) getString(R.string.cancel).toUpperCase(), (DialogInterface.OnClickListener) null);
            builder.show();
            return;
        }
        requestPermission(this);
    }

    public IGlobalPresenter getPresenter() {
        return this.iBrandingPresenter;
    }

    public String getScreenName() {
        return ScreenNames.BRAND_SCREEN;
    }

    public void gpsToAddressResultRecieved(String str, Address address, final Area area, City city) {
        stopLodingPopup();
        if (!TalabatUtils.isNullOrEmpty(str)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
            builder.setMessage((CharSequence) str);
            builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
            builder.show();
            return;
        }
        Cart instance = Cart.getInstance();
        if (!instance.hasItems()) {
            selectArea(area);
        } else if (instance.getCartAreaId() == area.f13835id) {
            selectArea(area);
        } else {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
            String replace = getString(R.string.already_has_items_in_cart).replace("#", instance.getRestaurant().f13873name + " - " + instance.getCartAreaName());
            builder2.setTitle((int) R.string.clear_cart_alert_title);
            builder2.setMessage((CharSequence) replace);
            builder2.setPositiveButton((int) R.string.yes, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                    Cart.getInstance().clearCart(BrandingScreen.this);
                    BrandingScreen.this.selectArea(area);
                }
            });
            builder2.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null);
            builder2.show();
        }
    }

    public void isRefreshMap(boolean z11, @NotNull LatLng latLng) {
    }

    public void locationSelectionView(boolean z11) {
        this.isMapFirstEnabled = z11;
        if (z11) {
            this.normalBandAreaSelectionView.setVisibility(8);
            this.MapFirstSelectionView.setVisibility(0);
            return;
        }
        this.normalBandAreaSelectionView.setVisibility(0);
        this.MapFirstSelectionView.setVisibility(8);
    }

    public void mapCurrentLocReceived(@NotNull LatLng latLng) {
    }

    public void mcdServerError() {
        Toast.makeText(getContext(), getResources().getString(R.string.server_error_msg), 0).show();
    }

    public void navigateToFlutterMenu(int i11, String str, boolean z11) {
        MenuNavigatorController.INSTANCE.navigateToMenu(this, new MenuNavigatorModel(i11, str, GlobalDataModel.ShopClickOrigin, Boolean.valueOf(z11), -1), this.f53676m, this.f53677n, this.f53675l);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 40) {
            if (i12 == -1) {
                this.iBrandingPresenter.areaSelected();
            }
        } else if (i11 == 41) {
            if (i12 == -1) {
                this.iBrandingPresenter.citySelected();
            }
        } else if (i11 == 42) {
            if (i12 == -1) {
                this.iBrandingPresenter.branchSelected();
            }
        } else if (i11 == 36) {
            getGpsLocation();
        } else if (i11 == 50) {
            if (i12 == -1) {
                this.selectedGlrID = intent.getStringExtra(GlobalConstants.INFOR_MAP.INFORMAP_GLR_ID);
                this.TbResBanchID = intent.getIntExtra(GlobalConstants.INFOR_MAP.TB_BRANCH_ID_MENU, -1);
                this.mcdResBanchID = intent.getStringExtra(GlobalConstants.INFOR_MAP.MCD_BRANCH_ID_MENU);
                this.iBrandingPresenter.showGrlMenu(this.TbResBanchID);
            }
        } else if (i11 == 51) {
            if (i12 == -1) {
                if (intent != null) {
                    this.mcdBhBlockBranchId = intent.getIntExtra(GlobalConstants.MCD_GOOGLE_MAP.MCD_GOOGLE_MAP_BRANCH_ID, -1);
                }
                int i13 = this.mcdBhBlockBranchId;
                if (i13 > 0) {
                    this.iBrandingPresenter.ShowMcdBhMenu(i13);
                }
            }
        } else if (i11 == 52) {
            if (i12 == -1) {
                if (intent != null) {
                    this.mcdBhBlockBranchId = intent.getIntExtra(GlobalConstants.MCD_GOOGLE_MAP.MCD_GOOGLE_MAP_BRANCH_ID, -1);
                }
                int i14 = this.mcdBhBlockBranchId;
                if (i14 > 0) {
                    this.iBrandingPresenter.ShowMcdBhMenu(i14);
                }
            }
        } else if (i11 == 53) {
            if (i12 == -1) {
                if (intent != null) {
                    int intExtra = intent.getIntExtra("DeliveryAreaBranchId", -1);
                    this.isFranchiseRest = intent.getBooleanExtra(GlobalConstants.ExtraNames.IS_FRANCHISE_REST, false);
                    this.isUpdateAddressSelected = intent.getBooleanExtra(GlobalConstants.ExtraNames.IS_FRANCHISE_ADDRESS_UPDATED, false);
                    this.FranchiseGrpId = intent.getIntExtra(GlobalConstants.ExtraNames.FRANCHISE_GRP_ID, 0);
                    Boolean valueOf = Boolean.valueOf(intent.getBooleanExtra(GlobalConstants.ExtraNames.IS_FRANCHISE_SELECTED, false));
                    this.iBrandingPresenter.updateIsAreaDeliverable();
                    this.iBrandingPresenter.setUplocationView(this.isFranchiseRest, this.isUpdateAddressSelected);
                    if (this.iBrandingPresenter.checkIsFranchiseRes()) {
                        if (valueOf.booleanValue()) {
                            this.iBrandingPresenter.loadFranchiseRestBasedLocation(intExtra);
                            this.iBrandingPresenter.setFrachiseBranchName();
                        }
                        this.iBrandingPresenter.onFrnachisebranchSelected();
                        return;
                    }
                    this.iBrandingPresenter.loadMenuScreenFromMap(intExtra);
                }
            } else if (intent != null) {
                this.iBrandingPresenter.onDeselectFranchise(intent.getBooleanExtra(GlobalConstants.ExtraNames.RESET_PRE_BRANCH, false));
            }
        } else if (i11 == 54 && i12 == -1 && intent != null) {
            int intExtra2 = intent.getIntExtra("DeliveryAreaBranchId", -1);
            this.isUpdateAddressSelected = intent.getBooleanExtra(GlobalConstants.ExtraNames.IS_FRANCHISE_ADDRESS_UPDATED, false);
            this.isFranchiseRest = intent.getBooleanExtra(GlobalConstants.ExtraNames.IS_FRANCHISE_REST, false);
            this.FranchiseGrpId = intent.getIntExtra(GlobalConstants.ExtraNames.FRANCHISE_GRP_ID, 0);
            this.iBrandingPresenter.setUplocationView(this.isFranchiseRest, this.isUpdateAddressSelected);
            this.iBrandingPresenter.onFrnachisebranchSelected();
            this.iBrandingPresenter.setFrachiseBranchName();
            this.iBrandingPresenter.loadFranchiseRestBasedLocation(intExtra2);
        }
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        if (isTaskRoot()) {
            navigateToHomeScreen();
        }
        finish();
    }

    public void onCreate(Bundle bundle) {
        ApiContainer apiContainer = AndroidComponentsKt.apiContainer((Activity) this);
        DaggerBrandingScreenComponent.factory().create((ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) apiContainer.getFeature(ConfigurationRemoteCoreLibApi.class), (NavigationCoreLibApi) apiContainer.getFeature(NavigationCoreLibApi.class), (FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class), (DeepLinkCoreLibApi) apiContainer.getFeature(DeepLinkCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.brand_screen);
        try {
            this.deeplinkMigratedType = getIntent().getIntExtra(GlobalConstants.ExtraNames.MIGRATED_TYPE, -1);
            this.deeplinkMigratedInfo = getIntent().getStringExtra(GlobalConstants.ExtraNames.MIGRATED_INFO);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setToolbarPadding(this.mToolbar);
            ApptimizeHelper.enableGoogleSearchOptimization(BuildConfig.IS_ALPHA.booleanValue());
            this.cityView = findViewById(R.id.branding_view_city);
            this.sideMenuBtn = (ImageButton) findViewById(R.id.sidemenu_button);
            this.backBtn = (ImageButton) findViewById(R.id.back);
            this.areaView = findViewById(R.id.branding_view_area);
            this.branchView = findViewById(R.id.branding_branch_view);
            this.city_gps = (ImageButton) findViewById(R.id.branding_mapbutton_city);
            this.area_gps = (ImageButton) findViewById(R.id.branding_mapbutton_area);
            this.cityName = (TextView) findViewById(R.id.branding_choose_city);
            this.areaName = (TextView) findViewById(R.id.branding_choose_area);
            this.branchName = (TextView) findViewById(R.id.choose_branch);
            this.cuisinesText = (TextView) findViewById(R.id.branding_cuisines_text);
            this.showMenu = (Button) findViewById(R.id.btnShowMenu);
            this.restaurantLogo = (NetworkImageView) findViewById(R.id.branding_rest_logo);
            this.f53678o = new ImageLoader(Volley.newRequestQueue(this), new BitmapLruCache());
            this.locationManager = (LocationManager) getSystemService("location");
            this.restaurantText = (TextView) findViewById(R.id.branding_restaurant_name);
            this.mBrandinginsideCityView = (RelativeLayout) findViewById(R.id.branding_inside_city_view);
            this.mBrandingInsideArea = (RelativeLayout) findViewById(R.id.branding_inside_area);
            this.mBrandingInsideBranch = (RelativeLayout) findViewById(R.id.branding_branch_view);
            this.cartHolder = (RelativeLayout) findViewById(R.id.cart_holder);
            this.sideMenuList = (RecyclerView) findViewById(R.id.list_slidemenu);
            this.backBtn = (ImageButton) findViewById(R.id.back);
            this.sideMenuBtn = (ImageButton) findViewById(R.id.sidemenu_button);
            this.cartImage = (ImageButton) findViewById(R.id.cart);
            this.f53679p = (TextView) findViewById(R.id.cart_count);
            this.normalBandAreaSelectionView = findViewById(R.id.normal_area_selection_container);
            this.MapFirstSelectionView = findViewById(R.id.map_first_selection_continaer);
            this.mBrandingInsideAreaMf = (RelativeLayout) findViewById(R.id.branding_inside_area_mf);
            this.areaViewMf = findViewById(R.id.branding_view_area_mf);
            this.areaNameMf = (TextView) findViewById(R.id.branding_choose_area_mf);
            this.branchViewMf = findViewById(R.id.branding_branch_view_mf);
            this.branchNameMf = (TextView) findViewById(R.id.choose_branch_mf);
            this.showMenuMf = (Button) findViewById(R.id.btnShowMenu_mf);
            this.imgBrandingChooseArea = (ImageView) findViewById(R.id.branding_choose_area_image_mf);
            this.mBrandingInsideBranchMf = (RelativeLayout) findViewById(R.id.branding_branch_view_mf);
            this.sideMenuBtn.setVisibility(4);
            this.backBtn.setVisibility(0);
            this.sideMenuList.setVisibility(8);
            this.backBtn.setOnClickListener(new k0(this));
            Button button = this.showMenu;
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        BrandingScreen.this.iBrandingPresenter.showMenu();
                    }
                });
            }
            Button button2 = this.showMenuMf;
            if (button2 != null) {
                button2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        BrandingScreen.this.iBrandingPresenter.showMenuMf();
                    }
                });
            }
            BrandingPresenter brandingPresenter = new BrandingPresenter(this.f53672i, this, TalabatExperiment.INSTANCE, this.f53673j, this.f53674k);
            this.iBrandingPresenter = brandingPresenter;
            brandingPresenter.setUpViews(GlobalDataModel.restaurantDeliveryAreas);
            RelativeLayout relativeLayout = this.mBrandinginsideCityView;
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        BrandingScreen.this.iBrandingPresenter.cityButtonClicked();
                    }
                });
            }
            RelativeLayout relativeLayout2 = this.mBrandingInsideArea;
            if (relativeLayout2 != null) {
                relativeLayout2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        BrandingScreen.this.iBrandingPresenter.areaButtonClicked();
                    }
                });
            }
            RelativeLayout relativeLayout3 = this.mBrandingInsideAreaMf;
            if (relativeLayout3 != null) {
                relativeLayout3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        BrandingScreen.this.iBrandingPresenter.areaButtonClicked();
                    }
                });
            }
            RelativeLayout relativeLayout4 = this.mBrandingInsideBranch;
            if (relativeLayout4 != null) {
                relativeLayout4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        BrandingScreen.this.iBrandingPresenter.branchButtionClicked(BrandingScreen.this.FranchiseGrpId);
                    }
                });
            }
            RelativeLayout relativeLayout5 = this.mBrandingInsideBranchMf;
            if (relativeLayout5 != null) {
                relativeLayout5.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        BrandingScreen.this.iBrandingPresenter.branchButtionClicked(BrandingScreen.this.FranchiseGrpId);
                    }
                });
            }
            ImageButton imageButton = this.city_gps;
            if (imageButton != null) {
                imageButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        BrandingScreen.this.getGpsLocation();
                    }
                });
            }
            ImageButton imageButton2 = this.area_gps;
            if (imageButton2 != null) {
                imageButton2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        BrandingScreen.this.getGpsLocation();
                    }
                });
            }
            GlobalDataModel.POLYGON_TRACKING.polygonEvents = null;
            final Intent intent = new Intent(this, CartScreen.class);
            setBrandScreenCartButton(this.cartHolder, new TalabatBase.CartButtonClicked() {
                public void onCartButtonClicked() {
                    if (Cart.getInstance().hasItems()) {
                        if (GlobalDataModel.SelectedAreaId == 0) {
                            GlobalDataModel.SelectedAreaId = Cart.getInstance().getCartAreaId();
                            GlobalDataModel.SelectedAreaName = Cart.getInstance().getCartAreaName();
                            GlobalDataModel.SelectedCityId = Cart.getInstance().getCartCityId();
                            GlobalDataModel.SelectedCityName = Cart.getInstance().getCartCityName();
                        }
                        String string = BrandingScreen.this.getString(R.string.transition_view_cart_button);
                        ContextCompat.startActivity(BrandingScreen.this, intent, ActivityOptionsCompat.makeSceneTransitionAnimation(BrandingScreen.this, BrandingScreen.this.findViewById(R.id.cart_holder), string).toBundle());
                    }
                }
            });
            Restaurant restaurant2 = GlobalDataModel.SELECTED.restaurant;
            if (restaurant2 != null) {
                AppTracker.onBrandPageLoaded(this, restaurant2.f13873name, restaurant2.f13872id);
            }
        } catch (Exception unused) {
            finish();
        }
        PerformanceTracker performanceTracker = PerformanceTracker.INSTANCE;
        performanceTracker.addAppFlowTraceAttribute("appStartToInteractive", "BandScreen");
        performanceTracker.stopTrace("appStartToInteractive");
    }

    public void onCurrentLocationReceived(@Nullable LatLng latLng, boolean z11, float f11) {
    }

    public void onCurrentLocationReceivedWithLowAccuracy(@NotNull LatLng latLng, float f11) {
    }

    public void onError() {
    }

    public void onGeoLocationDialogAccepted(boolean z11) {
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 != 4) {
            return super.onKeyDown(i11, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onMigratedVendorLoaded(Restaurant restaurant2) {
        DarkstoresDelegate.Companion.onDarkstoresClicked(this, restaurant2, this.deeplinkMigratedType, this.deeplinkMigratedInfo, false, false, false, DarkstoresDelegate.DSClickOrigin.ORIGIN_HOME);
    }

    public void onRedirectToAreaScreen() {
        String str;
        if (!this.isMapFirstEnabled) {
            Gson gson = UniversalGson.INSTANCE.gson;
            DeliveryArea[] deliveryAreaArr = GlobalDataModel.restaurantDeliveryAreas;
            if (!(gson instanceof Gson)) {
                str = gson.toJson((Object) deliveryAreaArr);
            } else {
                str = GsonInstrumentation.toJson(gson, (Object) deliveryAreaArr);
            }
            Intent intent = new Intent(this, ChooseAreaScreen.class);
            intent.putExtra("deliveryAreas", true);
            intent.putExtra("filterCities", true);
            intent.putExtra("highlightCityId", GlobalDataModel.SelectedCityId);
            intent.putExtra(GlobalConstants.ExtraNames.LOADAREAFOMHOME, true);
            intent.putExtra(GlobalConstants.ExtraNames.SHOWUSERADDRESS, true);
            intent.putExtra("highlightAreaId", GlobalDataModel.SelectedAreaId);
            intent.putExtra("areas", str);
            startActivityForResult(intent, 40);
        }
    }

    public void onRedirectToCityScreen() {
        Intent intent = new Intent(this, ChooseCityScreen.class);
        intent.putExtra(GlobalConstants.ExtraNames.DELIVERY_AREA, true);
        startActivityForResult(intent, 41);
    }

    public void onRedirectToFranchiseScreen() {
        stopLodingPopup();
        startActivityForResult(new Intent(this, FranchiseSelectionScreen.class), 42);
    }

    public void onRedirectToGroceryMenuPage() {
        stopLodingPopup();
        Intent intent = new Intent(this, GroceryMenuScreen.class);
        if (this.isMapFirstEnabled) {
            intent.putExtra(GlobalConstants.ExtraNames.IS_FROM_BRAND_REORDER_MAP_FLOW, true);
        }
        startActivity(intent);
    }

    public void onRedirectToMenuPage() {
        stopLodingPopup();
        Intent intent = new Intent(this, RestaurantMenuScreenR.class);
        if (this.isMapFirstEnabled) {
            intent.putExtra(GlobalConstants.ExtraNames.IS_FROM_BRAND_REORDER_MAP_FLOW, true);
        }
        startActivity(intent);
    }

    public void onRequestError() {
        stopLodingPopup();
        Toast.makeText(this, getResources().getString(R.string.server_error_msg), 1).show();
    }

    public void onRequestPermissionsResult(int i11, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i11, strArr, iArr);
        if (i11 == 42 && iArr.length > 0 && iArr[0] == 0) {
            getGpsLocation();
        }
    }

    public void onResume() {
        super.onResume();
        setCartVisibilityHome(this.cartHolder);
    }

    public void onServerError() {
        stopLodingPopup();
        Toast.makeText(this, getResources().getString(R.string.server_error_msg), 1).show();
    }

    public void onServerError(VolleyError volleyError) {
    }

    public void onValidationError(int i11) {
        if (i11 == 15) {
            alertToast(getString(R.string.home_validation_select_area));
        } else if (i11 == 20) {
            alertToast(getString(R.string.home_validation_select_city));
        } else if (i11 == 25) {
            alertToast(getString(R.string.choose_brand));
        }
    }

    public void redirectFranchiseSelection(String str, int i11) {
        stopLodingPopup();
        Intent intent = new Intent(this, FranchiseSelectionScreen.class);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FROM_BRAND_REORDER, this.isMapFirstEnabled);
        intent.putExtra("location", str);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FROM_BRAND_RES_GRP_ID, i11);
        startActivityForResult(intent, 54);
    }

    public void redirectoChooseSavedAddressScreen(Address address) {
        Intent intent = new Intent(this, ChooseSavedAddressScreen.class);
        CurrentLocationFetch currentLocationFetch = new CurrentLocationFetch(this, this);
        if (currentLocationFetch.userAllowedAllLocationPermissions(this)) {
            currentLocationFetch.initLocationRequest(this, CurrentLocHelper.INSTANCE.getIS_FROM_INIT_CL_BG());
            currentLocationFetch.fetchCurrentLocation();
            intent.putExtra(GlobalConstants.ExtraNames.IS_FETCHING_CL, true);
        }
        intent.putExtra(GlobalConstants.ExtraNames.IS_LOAD_DELIVERY_ADDRESS, false);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FROM_BRAND_REORDER, true);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FRANCHISE_REST, this.isFranchiseRest);
        startActivityForResult(intent, 53);
        overridePendingTransition(R.anim.activity_slide_from_bottom, R.anim.nothing);
    }

    public void redirectoHomeMapScreen(boolean z11, String str, Boolean bool) {
        LatLng areaCenterLatLg;
        CurrentLocationFetch currentLocationFetch = new CurrentLocationFetch(this, this);
        if (currentLocationFetch.userAllowedAllLocationPermissions(this)) {
            currentLocationFetch.initLocationRequest(this, CurrentLocHelper.INSTANCE.getIS_FROM_SAVED_LOC());
            currentLocationFetch.fetchCurrentLocation();
        } else {
            GlobalDataModel.HOME_SCREEN_MAP.FUSED_LOCATION_FROM_HOME = null;
            GlobalDataModel.HOME_SCREEN_MAP.ADDRESS_FUSED_LOCATON = null;
        }
        String str2 = "";
        if (z11 && (areaCenterLatLg = HomeMapUtils.INSTANCE.areaCenterLatLg(GlobalDataModel.SelectedAreaId, this.f53674k)) != null) {
            str2 = str2 + areaCenterLatLg.latitude + "," + areaCenterLatLg.longitude;
        }
        Intent intent = new Intent(this, HomeScreenMap.class);
        intent.putExtra("areaLatLng", str2);
        intent.putExtra("isIgnoreCurrentLocation", z11);
        intent.putExtra("UserSelectedAddress", str);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FROM_BRAND_REORDER, true);
        intent.putExtra(GlobalConstants.ExtraNames.IS_FRANCHISE_REST, this.isFranchiseRest);
        intent.putExtra("isIgnoreSavedLoc", bool);
        startActivityForResult(intent, 53);
    }

    public void refreshCartCount() {
        super.refreshCartCount();
        Cart instance = Cart.getInstance();
        if (instance.hasItems()) {
            this.cartImage.setImageResource(R.drawable.ic_m_basket_filled);
            this.f53679p.setVisibility(0);
            this.f53679p.setTextColor(getResources().getColor(R.color.white));
            TextView textView = this.f53679p;
            textView.setText("" + instance.getCartCount());
            return;
        }
        this.cartImage.setImageResource(R.drawable.ic_m_basket_empty);
        this.f53679p.setVisibility(8);
    }

    public void selectedAddressDeliverable(boolean z11) {
        if (!z11) {
            resetPreselectlocation();
        }
    }

    public void selectedAreaDeliverable(boolean z11) {
        if (!z11) {
            resetPreselectlocation();
        }
    }

    public void setArea(String str, boolean z11, boolean z12) {
        String str2;
        if (this.isMapFirstEnabled) {
            if (TalabatUtils.isNullOrEmpty(str)) {
                ImageView imageView = this.imgBrandingChooseArea;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                this.areaNameMf.setText(R.string.set_deliver_location);
                this.imgBrandingChooseArea.setVisibility(8);
                this.areaNameMf.setTextColor(getResources().getColor(R.color.select_area_color));
            } else if (z12) {
                this.areaNameMf.setText(str);
            } else {
                ImageView imageView2 = this.imgBrandingChooseArea;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
                this.areaNameMf.setText(R.string.set_deliver_location);
            }
            if (z11 || HomeMapTemp.INSTANCE.getHomeMapSavedLatLng() != null) {
                ImageView imageView3 = this.imgBrandingChooseArea;
                if (imageView3 != null && z12) {
                    imageView3.setVisibility(0);
                    if (z11) {
                        this.imgBrandingChooseArea.setImageDrawable(getResources().getDrawable(R.drawable.ic_m_address_pin));
                        return;
                    }
                    this.imgBrandingChooseArea.setImageDrawable(getResources().getDrawable(R.drawable.ic_m_address_pin));
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                    HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
                    if (!TalabatUtils.isNullOrEmpty(homeMapTemp.getHomeMapStreetName())) {
                        str2 = homeMapTemp.getHomeMapStreetName();
                    } else {
                        str2 = "";
                    }
                    sb2.append(str2);
                    String sb3 = sb2.toString();
                    if (z12) {
                        this.areaNameMf.setText(sb3);
                        return;
                    }
                    ImageView imageView4 = this.imgBrandingChooseArea;
                    if (imageView4 != null) {
                        imageView4.setVisibility(8);
                    }
                    this.areaNameMf.setText(R.string.set_deliver_location);
                    return;
                }
                return;
            }
            ImageView imageView5 = this.imgBrandingChooseArea;
            if (imageView5 != null) {
                imageView5.setVisibility(8);
            }
        } else if (TalabatUtils.isNullOrEmpty(str)) {
            this.areaName.setText(R.string.select_your_area);
        } else {
            this.areaName.setText(str);
        }
    }

    public void setBranch(String str) {
        if (this.isMapFirstEnabled) {
            setBranchName(str, this.branchNameMf);
        } else {
            setBranchName(str, this.branchName);
        }
    }

    public void setBrandScreenCartButton(RelativeLayout relativeLayout, final TalabatBase.CartButtonClicked cartButtonClicked) {
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AppTracker.onCartClicked(BrandingScreen.this, "header");
                cartButtonClicked.onCartButtonClicked();
            }
        });
        refreshCartCount();
    }

    public void setCartVisibilityHome(RelativeLayout relativeLayout) {
        if (Cart.getInstance().hasItems()) {
            relativeLayout.setVisibility(0);
        } else {
            relativeLayout.setVisibility(8);
        }
    }

    public void setCity(String str) {
        this.cityName.setText(str);
    }

    public void setCuisines(String str) {
    }

    public void setGpsVisibility(boolean z11) {
        if (z11) {
            ImageButton imageButton = this.area_gps;
            if (imageButton != null) {
                imageButton.setVisibility(8);
            }
            ImageButton imageButton2 = this.city_gps;
            if (imageButton2 != null) {
                imageButton2.setVisibility(8);
                return;
            }
            return;
        }
        ImageButton imageButton3 = this.area_gps;
        if (imageButton3 != null) {
            imageButton3.setVisibility(8);
        }
        ImageButton imageButton4 = this.city_gps;
        if (imageButton4 != null) {
            imageButton4.setVisibility(8);
        }
    }

    public void setRestaurantFranchise(boolean z11) {
        this.isFranchiseRest = z11;
    }

    public void setRestaurantLogo(String str) {
        this.restaurantLogo.setImageUrl(str, this.f53678o);
    }

    public void setRestaurantName(String str) {
        this.restaurant = str;
        getText(R.string.brand_introduction_text).toString().replace("#", str);
        this.restaurantText.setText(str);
        setTitle(R.id.brand_title, str);
    }

    public void showBrandNotDeliverHere(String str) {
        selectedAddressNotDeliveringAlert(str);
    }

    public void showInforMap(int i11, int i12, String str) {
        Intent intent = new Intent(this, InforMapScreen.class);
        intent.putExtra(GlobalConstants.INFOR_MAP.INFORMAP_SELECTED_AREA_ID, i11);
        intent.putExtra(GlobalConstants.INFOR_MAP.RESTAURANT_ID, i12);
        intent.putExtra(GlobalConstants.INFOR_MAP.RESTAURANT_NAME, str);
        startActivityForResult(intent, 50);
    }

    public void showMcdGoogleMap(int i11, String str, Address address, int i12) {
        Intent intent = new Intent(this, MapsActivity.class);
        if (address != null && address.latitude > 0.0d && address.longitude > 0.0d) {
            intent.putExtra("location", "" + address.latitude + "," + address.longitude);
        }
        intent.putExtra("userSelectedAreaId", GlobalDataModel.SelectedAreaId);
        intent.putExtra(GlobalConstants.MCD_GOOGLE_MAP.MCD_GOOGLE_MAP_FLOW, true);
        intent.putExtra(GlobalConstants.MCD_GOOGLE_MAP.MCD_RESTAURANT_ID, i12);
        intent.putExtra("noAreaChange", true);
        if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
            startActivityForResult(intent, 51);
        } else if (TalabatUtils.isMcdLatLngEnabledCountry()) {
            startActivityForResult(intent, 52);
        }
    }

    public void showMenuWithGlrID(String str, Restaurant restaurant2, int i11) {
        InforMapRequest inforMapRequest = new InforMapRequest(str, i11, true);
        startLodingPopup();
        this.iBrandingPresenter.getGrlBasedBrach(inforMapRequest);
    }

    public void showMenuWithMcdStores(Restaurant restaurant2, int i11, Address address) {
        startLodingPopup();
        this.iBrandingPresenter.getMcdBranchIdFromBlockorLatLng(new McdBranchRequest(address, restaurant2.f13872id));
    }

    public void showSelectedAreaNotDeliveringPopup(String str) {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        AlertDialog create = builder.create();
        builder.setTitle((CharSequence) getString(R.string.out_of_delivery_area));
        builder.setMessage((CharSequence) getString(R.string.out_of_delivery_area_description).replace("$$", str).replace(RichContentLoadTimeRecorder.DELIMETER, this.restaurant));
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                dialogInterface.dismiss();
            }
        });
        if (create != null && !create.isShowing()) {
            builder.show();
        }
    }

    public void updateResGrpId(int i11) {
        this.FranchiseGrpId = i11;
    }
}
