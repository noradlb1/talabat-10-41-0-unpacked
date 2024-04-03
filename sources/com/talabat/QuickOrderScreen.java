package com.talabat;

import JsonModels.parser.UniversalGson;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import buisnessmodels.Cart;
import buisnessmodels.McdMapTempAddress;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder;
import com.google.gson.Gson;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.materialedittext.MaterialEditText;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.TalabatSpinner;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.buildconfig.BuildConfig;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.pinless.checkout.domain.GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase;
import com.talabat.designhelpers.CountryCode;
import com.talabat.designhelpers.CountryCodePicker;
import com.talabat.domain.address.Address;
import com.talabat.domain.location.GeoCoordinate;
import com.talabat.helpers.ApptimizeHelper;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.homemaphelper.CurrentLocationFetch;
import com.talabat.homemaphelper.CurrentLocationListener;
import com.talabat.maps.domain.CameraUpdateFactory;
import com.talabat.maps.domain.FrameworkMap;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.MapsInitializer;
import com.talabat.maps.domain.model.LatLng;
import com.talabat.maps.presentation.MapContainerFragment;
import com.talabat.maputils.CurrentLocHelper;
import com.talabat.notifications.brazemigrator.guestuser.OnQuickOrderValidatedImp;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.user.address.di.AddressesDependencyProvider;
import datamodels.Area;
import datamodels.QuickOrderInfo;
import datamodels.analyticstrackermodels.AddressAnalyticsTracker;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.jvm.functions.Function0;
import library.talabat.SharedPreferencesManager;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.addressV2.AddressPresenter;
import library.talabat.mvp.addressV2.AddressView;
import library.talabat.mvp.addressV2.IAddressPresenter;
import library.talabat.mvp.addressV2.SaveAddressEventsOrigin;
import library.talabat.mvp.addressV2.UserAddAddressScreenEventsListener;
import library.talabat.mvp.addressV2.UserAddressEventsKt;
import library.talabat.mvp.homemap.HomeMapTemp;
import library.talabat.mvp.quickorder.IQuickOrderPresenter;
import library.talabat.mvp.quickorder.QuickOrderPresenter;
import library.talabat.mvp.quickorder.QuickOrderView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tracking.AppTracker;
import tracking.ScreenNames;
import tracking.gtm.TrackingUtils;
import ue.ac;
import ue.bc;
import ue.cc;
import ue.dc;
import ue.ec;
import ue.fc;
import ue.gc;
import ue.hc;
import ue.ic;
import ue.jc;
import ue.kc;
import ue.lc;
import ue.mc;
import ue.pb;
import ue.qb;
import ue.rb;
import ue.sb;
import ue.tb;
import ue.ub;
import ue.vb;
import ue.wb;
import ue.xb;
import ue.yb;
import ue.zb;
import x00.n;
import yj.r;

@Instrumented
public class QuickOrderScreen extends TalabatBase implements QuickOrderView, LocationListener, AddressView, TalabatSpinner.OnSpinnerEventsListener, CurrentLocationListener {
    private static final boolean CONTACT_DETAILS_SHOWN = false;
    private static final int PERMISSION_REQUEST_CODE = 600;
    private static final int SELECTADDRESS = 30;
    private static final int SELECTAREA = 10;
    public static final int SELECT_ADDRESS_AUTOMATIC = 200;
    public static final int SELECT_CHECKOUT = 202;
    private final int CHOOSE_COUNTRY_CODE = 101;
    private int SELECTED_CITY = 0;
    /* access modifiers changed from: private */
    public IAddressPresenter addressPresenter;
    /* access modifiers changed from: private */
    public TalabatSpinner addressType;
    /* access modifiers changed from: private */
    public MaterialEditText addressTypeEditText;
    /* access modifiers changed from: private */
    public View addressTypeSpinnerview;
    private LatLng addressgeoCodinates;
    private ArrayList<CountryCode> allCountriesList;
    private MaterialEditText area;
    private String blockField = "";
    private boolean blockPresentInMap = false;
    private MaterialEditText city;
    private View cityView;
    private Button continue_checkout;
    private MaterialEditText directionsText;
    private MaterialEditText field1;
    /* access modifiers changed from: private */
    public TextView field1Hint;
    private View field1View;
    /* access modifiers changed from: private */
    public MaterialEditText field2;
    /* access modifiers changed from: private */
    public TextView field2Hint;
    private View field2View;
    private MaterialEditText field3;
    /* access modifiers changed from: private */
    public TextView field3Hint;
    private View field3View;
    private MaterialEditText field4;
    /* access modifiers changed from: private */
    public TextView field4Hint;
    private View field4View;
    private MaterialEditText field5;
    /* access modifiers changed from: private */
    public TextView field5Hint;
    private View field5View;
    private MaterialEditText field6;
    /* access modifiers changed from: private */
    public TextView field6Hint;
    private View field6View;
    private MaterialEditText field7;
    /* access modifiers changed from: private */
    public TextView field7Hint;
    private View field7View;
    private MaterialEditText firstName;
    /* access modifiers changed from: private */
    public TextView firstNameHint;
    private int fldCount = 0;
    private boolean fromMap = false;
    private LatLng geoCodinates;
    private String grlId;
    private String grlString;
    /* access modifiers changed from: private */
    public MaterialEditText hiddenMobile;
    /* access modifiers changed from: private */
    public MaterialEditText hiddenPhone;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public AppVersionProvider f54574i;
    private boolean isFromMapFirstFlow;
    private boolean isFromMapSkip;
    private boolean isGrlEnabled;
    private boolean isMapcompulsory;
    private boolean isNineCookiesTrackingEnabled;
    private boolean isTalabatDeliveryAvailable;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public ConfigurationLocalRepository f54575j;
    @Inject

    /* renamed from: k  reason: collision with root package name */
    public MutableLocationConfigurationRepository f54576k;
    @Inject

    /* renamed from: l  reason: collision with root package name */
    public GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase f54577l;
    private MaterialEditText lastName;
    /* access modifiers changed from: private */
    public TextView lastNameHint;
    private LocationManager locationManager;
    @Inject

    /* renamed from: m  reason: collision with root package name */
    public UserAddAddressScreenEventsListener f54578m;
    private FrameworkMap mMap;
    private LatLng mapHighlightLocation;
    private LatLng mapaddressLatlang;
    private MaterialEditText mobileCountryCode;
    private MaterialEditText mobileText;
    @Inject

    /* renamed from: n  reason: collision with root package name */
    public Function0<String> f54579n;
    private String newBlockField = "";
    private String newStreetField = "";
    @Inject

    /* renamed from: o  reason: collision with root package name */
    public ITalabatFeatureFlag f54580o;
    @Inject

    /* renamed from: p  reason: collision with root package name */
    public LatLngFactory f54581p;
    private MaterialEditText phoneCountryCode;
    private MaterialEditText phoneText;
    @Inject

    /* renamed from: q  reason: collision with root package name */
    public MapsInitializer f54582q;
    private IQuickOrderPresenter quickOrderPresenter;
    @Inject

    /* renamed from: r  reason: collision with root package name */
    public CameraUpdateFactory f54583r;
    private String redirectNavigation;

    /* renamed from: s  reason: collision with root package name */
    public String f54584s;
    /* access modifiers changed from: private */
    public int selectedAddressPosition;
    private int selectedArea = 0;
    private String selectedAreaName = "";
    private String streetField = "";
    private boolean streetPresentInMap = false;

    /* renamed from: t  reason: collision with root package name */
    public int f54585t;
    private LatLng tempMapFirstLatLng;

    /* renamed from: u  reason: collision with root package name */
    public int f54586u = 0;
    private String userSelectedCountryDialCode = "";

    /* renamed from: v  reason: collision with root package name */
    public String[] f54587v;

    /* renamed from: w  reason: collision with root package name */
    public Spinner f54588w;

    /* renamed from: x  reason: collision with root package name */
    public ArrayList<String> f54589x;

    /* renamed from: y  reason: collision with root package name */
    public CurrentLocationFetch f54590y;

    private void animateLocation(LatLng latLng) {
        if (this.mMap != null) {
            LogManager.info("location" + latLng.getLatitude() + "" + latLng.getLongitude());
            FrameworkMap frameworkMap = this.mMap;
            frameworkMap.animateCamera(this.f54583r.newLatLngZoom(latLng, frameworkMap.getMaxZoomLevel() - 5.0f));
        }
    }

    private boolean checkPermission(Context context) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            return true;
        }
        return false;
    }

    private void chooseCountryCodeScreen() {
        Intent intent = new Intent(this, ChooseCountryCodeScreen.class);
        intent.putExtra(GlobalConstants.CHOOSE_COUNTRY_CODE.COUNTRY_DIAL_CODE, this.userSelectedCountryDialCode);
        startActivityForResult(intent, 101);
    }

    private LatLng defaultLatLang() {
        Country selectedCountry = this.f54575j.selectedCountry();
        if (selectedCountry == Country.KUWAIT) {
            return this.f54581p.createLatLng(29.375859d, 47.977405d);
        }
        if (selectedCountry == Country.KSA) {
            return this.f54581p.createLatLng(24.671666d, 46.702881d);
        }
        if (selectedCountry == Country.BAHRAIN) {
            return this.f54581p.createLatLng(26.228516d, 50.58605d);
        }
        if (selectedCountry == Country.QATAR) {
            return this.f54581p.createLatLng(25.285447d, 51.53104d);
        }
        if (selectedCountry == Country.OMAN) {
            return this.f54581p.createLatLng(23.58589d, 58.405923d);
        }
        if (selectedCountry == Country.UAE) {
            return this.f54581p.createLatLng(25.204849d, 55.270783d);
        }
        if (selectedCountry == Country.JORDAN) {
            return this.f54581p.createLatLng(31.945367d, 35.928372d);
        }
        if (selectedCountry == Country.EGYPT) {
            return this.f54581p.createLatLng(30.044422d, 31.235712d);
        }
        if (selectedCountry == Country.IRAQ) {
            return this.f54581p.createLatLng(36.190236d, 44.008696d);
        }
        return null;
    }

    private boolean getCountryCodeType(String str) {
        this.allCountriesList = new ArrayList<>();
        this.f54589x = new ArrayList<>();
        try {
            this.allCountriesList = new ArrayList<>();
            String loadJSONFromAsset = TalabatUtils.loadJSONFromAsset(getContext());
            if (loadJSONFromAsset == null || loadJSONFromAsset.length() <= 0) {
                return false;
            }
            JSONArray jSONArray = new JSONArray(loadJSONFromAsset);
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                String optString = jSONObject.optString("dialCode");
                boolean optBoolean = jSONObject.optBoolean("isGcc");
                CountryCode countryCode = new CountryCode();
                countryCode.dialCode = optString;
                countryCode.isGccCountry = optBoolean;
                this.allCountriesList.add(countryCode);
            }
            ArrayList<CountryCode> arrayList = this.allCountriesList;
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            Iterator<CountryCode> it = this.allCountriesList.iterator();
            while (it.hasNext()) {
                CountryCode next = it.next();
                if (str.equals(next.dialCode)) {
                    return next.isGccCountry;
                }
            }
            return false;
        } catch (Exception e11) {
            LogManager.logException(e11);
            return false;
        }
    }

    private void handleSelectAddressAutomatic(boolean z11, String str, String str2, boolean z12) {
        Address address;
        Object obj;
        this.f54584s = str;
        if (!TalabatUtils.isNullOrEmpty(str)) {
            Gson gson = UniversalGson.INSTANCE.gson;
            String str3 = this.f54584s;
            Class cls = Address.class;
            if (!(gson instanceof Gson)) {
                obj = gson.fromJson(str3, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson, str3, cls);
            }
            address = (Address) obj;
            address.type = this.selectedAddressPosition;
        } else {
            address = new Address();
        }
        this.isMapcompulsory = getIntent().getBooleanExtra("map_compulsory", false);
        this.isNineCookiesTrackingEnabled = getIntent().getBooleanExtra("nineCookiesEnabled", false);
        this.isTalabatDeliveryAvailable = getIntent().getBooleanExtra("talabatDeliveryAvailable", false);
        this.isFromMapSkip = z12;
        if (!TalabatUtils.isNullOrEmpty(str2)) {
            String[] split = str2.split(",");
            LatLng createLatLng = this.f54581p.createLatLng(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
            this.geoCodinates = createLatLng;
            address.latitude = createLatLng.getLatitude();
            address.longitude = this.geoCodinates.getLongitude();
            setGeoCodinates(this.geoCodinates);
        }
        this.addressPresenter.updateQuickOrderAddress();
        this.fromMap = true;
        this.blockPresentInMap = !TalabatUtils.isNullOrEmpty(address.block);
        boolean z13 = !TalabatUtils.isNullOrEmpty(address.street);
        this.streetPresentInMap = z13;
        if (this.blockPresentInMap) {
            this.blockField = address.block;
        }
        if (z13) {
            this.streetField = address.street;
        }
        this.addressPresenter.addressFromMapRecieved(address, z11, TalabatUtils.isAddressBlockEnabledCountry(), false);
        if (this.mMap != null && !z12) {
            LatLng latLng = this.geoCodinates;
            if (latLng == null && (latLng = GlobalDataModel.GEO_CORDINATES.addressPageLatLang) == null && (latLng = this.mapaddressLatlang) == null) {
                latLng = defaultLatLang();
            }
            animateLocation(latLng);
        }
        hideAddressName();
    }

    private boolean isNeedAddtionalHint(String str) {
        Country selectedCountry = this.f54575j.selectedCountry();
        if (selectedCountry == Country.KUWAIT) {
            if (str.equals("+965")) {
                return true;
            }
        } else if (selectedCountry == Country.KSA) {
            if (str.equals("+966")) {
                return true;
            }
        } else if (selectedCountry == Country.BAHRAIN) {
            if (str.equals("+973")) {
                return true;
            }
        } else if (selectedCountry == Country.OMAN) {
            if (str.equals("+968")) {
                return true;
            }
        } else if (selectedCountry == Country.QATAR) {
            if (str.equals("+974")) {
                return true;
            }
        } else if (selectedCountry == Country.UAE) {
            if (str.equals("+971")) {
                return true;
            }
        } else if (selectedCountry == Country.JORDAN) {
            if (str.equals("+962")) {
                return true;
            }
        } else if (selectedCountry != Country.IRAQ || !str.equals("+962")) {
            return false;
        } else {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        AppTracker.onGeoLocationButtonClicked(getContext());
        getLocationData();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        this.addressTypeEditText.setText("");
        this.addressTypeSpinnerview.setVisibility(0);
        this.addressType.setVisibility(0);
        this.addressType.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$10(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 5) {
            return false;
        }
        MaterialEditText materialEditText = this.lastName;
        materialEditText.setSelection(materialEditText.getText().length());
        this.lastName.requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$11(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 5) {
            return false;
        }
        MaterialEditText materialEditText = this.mobileText;
        materialEditText.setSelection(materialEditText.getText().length());
        this.mobileText.requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$12(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 5) {
            return false;
        }
        MaterialEditText materialEditText = this.phoneText;
        materialEditText.setSelection(materialEditText.getText().length());
        this.phoneText.requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$13(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 5) {
            return false;
        }
        MaterialEditText materialEditText = this.field2;
        materialEditText.setSelection(materialEditText.getText().length());
        this.field2.requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$14(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 5) {
            return false;
        }
        MaterialEditText materialEditText = this.field3;
        materialEditText.setSelection(materialEditText.getText().length());
        this.field3.requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$15(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 5) {
            return false;
        }
        if (this.fldCount == 3) {
            MaterialEditText materialEditText = this.directionsText;
            materialEditText.setSelection(materialEditText.getText().length());
            this.directionsText.requestFocus();
            return true;
        }
        MaterialEditText materialEditText2 = this.field4;
        materialEditText2.setSelection(materialEditText2.getText().length());
        this.field4.requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$16(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 5) {
            return false;
        }
        if (this.fldCount == 4) {
            MaterialEditText materialEditText = this.directionsText;
            materialEditText.setSelection(materialEditText.getText().length());
            this.directionsText.requestFocus();
            return true;
        }
        MaterialEditText materialEditText2 = this.field5;
        materialEditText2.setSelection(materialEditText2.getText().length());
        this.field5.requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$17(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 5) {
            return false;
        }
        if (this.fldCount == 5) {
            MaterialEditText materialEditText = this.directionsText;
            materialEditText.setSelection(materialEditText.getText().length());
            this.directionsText.requestFocus();
            return true;
        }
        MaterialEditText materialEditText2 = this.field6;
        materialEditText2.setSelection(materialEditText2.getText().length());
        this.field6.requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$18(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 5) {
            return false;
        }
        if (this.fldCount == 6) {
            MaterialEditText materialEditText = this.directionsText;
            materialEditText.setSelection(materialEditText.getText().length());
            this.directionsText.requestFocus();
            return true;
        }
        MaterialEditText materialEditText2 = this.field7;
        materialEditText2.setSelection(materialEditText2.getText().length());
        this.field7.requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$19(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 5) {
            return false;
        }
        MaterialEditText materialEditText = this.directionsText;
        materialEditText.setSelection(materialEditText.getText().length());
        this.directionsText.requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        this.quickOrderPresenter.continueQuickOrder(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$20(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 6) {
            return false;
        }
        this.continue_checkout.performClick();
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$21(View view) {
        GlobalDataModel.GEO_CORDINATES.saveTempZoomLevel = 0.0f;
        GlobalDataModel.HOME_SCREEN_MAP.CONFIRMED_LOCATION_AWARNESS = false;
        finish();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCreate$22(LatLng latLng) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$23(FrameworkMap frameworkMap) {
        frameworkMap.getUiSettings().setScrollGesturesEnabled(false);
        this.mMap = frameworkMap;
        LatLng latLng = GlobalDataModel.GEO_CORDINATES.addressPageLatLang;
        if (latLng == null && (latLng = this.mapaddressLatlang) == null) {
            latLng = defaultLatLang();
        }
        this.mapHighlightLocation = latLng;
        animateLocation(latLng);
        frameworkMap.setOnMapClickListener(new ec());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        showMapView(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(View view) {
        this.continue_checkout.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5(View view) {
        this.hiddenPhone.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(String str, String str2, String str3) {
        this.phoneCountryCode.setText(str2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$7(View view) {
        CountryCodePicker newInstance = CountryCodePicker.newInstance("Select Country", false);
        newInstance.setListener(new pb(this));
        newInstance.show(getSupportFragmentManager(), "COUNTRY_CODE_PICKER");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$8(View view) {
        if (TalabatUtils.isInterantionalCountryCodeVerificationEnabledCountry(this.f54575j, this.f54576k)) {
            chooseCountryCodeScreen();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$9(View view) {
        if (TalabatUtils.isInterantionalCountryCodeVerificationEnabledCountry(this.f54575j, this.f54576k)) {
            chooseCountryCodeScreen();
        }
    }

    private void locationRecieved(Location location) {
        if (!(ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0)) {
            requestPermission(this);
        }
        startLodingPopup();
        this.addressPresenter.autoFillAddress(location.getLatitude(), location.getLongitude());
        this.locationManager.removeUpdates(this);
    }

    private void onTrackAddressSubmitted(Address address) {
        int i11;
        Address address2 = address;
        try {
            GlobalDataModel.GEO_LOCATION_TRACKING.GEO_LOCATION_API_METHOD = "N/A";
            TrackingUtils trackingUtils = TrackingUtils.INSTANCE;
            int i12 = 0;
            if (address2 != null) {
                i11 = address2.cityId;
            } else {
                i11 = 0;
            }
            Integer valueOf = Integer.valueOf(i11);
            if (address2 != null) {
                i12 = address2.areaId;
            }
            Integer valueOf2 = Integer.valueOf(i12);
            String addressMethodSaved = trackingUtils.getAddressMethodSaved();
            String str = AppTracker.NotAvail;
            AddressAnalyticsTracker trackingAddressObject = trackingUtils.getTrackingAddressObject(this, false, address, valueOf, valueOf2, "cart", addressMethodSaved, ScreenNames.EXPRESSCHECKOUT, str, str, str, str, str, str, str, str, str, str, false, trackingUtils.getAddressMethodSaved());
            try {
                AppTracker.onAddressSubmitted(this, GlobalDataModel.SelectedAreaName, "" + GlobalDataModel.SelectedAreaId, trackingAddressObject);
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Exception e12) {
            e = e12;
            LogManager.logException(e);
        }
    }

    private void requestPermission(Context context) {
        pauseBannerForNextScreen();
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.ACCESS_FINE_LOCATION")) {
            Toast.makeText(context, "GPS permission allows us to access location data. Please allow in App Settings for additional functionality.", 1).show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 600);
        }
    }

    private void saveGeoCoordinatesInGlobalDataModel(LatLng latLng) {
        GlobalDataModel.GEO_CORDINATES.saveTempZoomLevel = HomeMapTemp.INSTANCE.homeMapSavedZooLevelOrDefault(1.0f);
        GlobalDataModel.GEO_CORDINATES.addressPageLatLang = latLng;
        GlobalDataModel.GEO_CORDINATES.isUserInteractedWithMapLocation = true;
    }

    private void setEditTextProperties(EditText editText, int i11) {
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i11)});
    }

    private void setUserSelectedCountryCode(String str) {
        if (!TalabatUtils.isNullOrEmpty(str)) {
            this.mobileCountryCode.setText(str);
        }
    }

    private static com.google.android.gms.maps.model.LatLng toGoogle(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return new com.google.android.gms.maps.model.LatLng(latLng.getLatitude(), latLng.getLongitude());
    }

    private static LatLng toOurs(com.google.android.gms.maps.model.LatLng latLng, LatLngFactory latLngFactory) {
        if (latLng == null) {
            return null;
        }
        return latLngFactory.createLatLng(latLng.latitude, latLng.longitude);
    }

    private void trackMapErrorShown(String str, Address address) {
        int i11;
        Address address2 = address;
        try {
            TrackingUtils trackingUtils = TrackingUtils.INSTANCE;
            int i12 = 0;
            if (address2 != null) {
                i11 = address2.cityId;
            } else {
                i11 = 0;
            }
            Integer valueOf = Integer.valueOf(i11);
            if (address2 != null) {
                i12 = address2.areaId;
            }
            Integer valueOf2 = Integer.valueOf(i12);
            String addressMethodSaved = trackingUtils.getAddressMethodSaved();
            String str2 = AppTracker.NotAvail;
            try {
                AppTracker.onAddressErrorShown(this, trackingUtils.getTrackingAddressObject(this, false, address, valueOf, valueOf2, "cart", addressMethodSaved, ScreenNames.EXPRESSCHECKOUT, str, str2, str2, str2, str2, str2, str2, str2, str2, str2, false, trackingUtils.getAddressMethodSaved()));
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Exception e12) {
            e = e12;
            LogManager.logException(e);
        }
    }

    private void usePhoneNumberHintValidation(boolean z11) {
        String str;
        MaterialEditText materialEditText = this.phoneText;
        if (z11) {
            str = getResources().getString(R.string.land_line_hint);
        } else {
            str = getResources().getString(R.string.land_line_international_hint);
        }
        materialEditText.setHint(str);
        this.phoneText.setError((CharSequence) null);
        this.phoneText.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
    }

    private int userSelectedAddressType() {
        Object obj;
        if (!TalabatUtils.isNullOrEmpty(this.f54584s)) {
            Gson gson = UniversalGson.INSTANCE.gson;
            String str = this.f54584s;
            Class cls = Address.class;
            if (!(gson instanceof Gson)) {
                obj = gson.fromJson(str, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson, str, cls);
            }
            this.selectedAddressPosition = ((Address) obj).type;
        } else {
            this.selectedAddressPosition = 1;
        }
        return this.selectedAddressPosition;
    }

    public void OnCurrentLocationPermissionStatus(@NotNull PermissionDeniedResponse permissionDeniedResponse) {
    }

    public SaveAddressEventsOrigin addressFlowOrigin() {
        return UserAddressEventsKt.eventOriginFromAddressScreenState((String) null, true, true, true, false, false, false, false, false, false, false, false);
    }

    public void clearFocusFromAllInput() {
    }

    public void compareBlockField(String str) {
        this.newBlockField = str;
    }

    public void compareStreetField(String str) {
        this.newStreetField = str;
    }

    public void deliverToCLRecived(@NotNull com.google.android.gms.maps.model.LatLng latLng) {
    }

    public void destroyPresenter() {
        this.quickOrderPresenter = null;
    }

    public void geoPolygonCenterPointAvailable(boolean z11, LatLng latLng) {
    }

    public int getAreaId() {
        return this.selectedArea;
    }

    public String getAreaName() {
        return this.selectedAreaName;
    }

    public int getCityId() {
        return this.SELECTED_CITY;
    }

    public Context getContext() {
        return this;
    }

    public boolean getCountryCodeCountryGcc() {
        if (TalabatUtils.isNullOrEmpty(this.mobileCountryCode.getText().toString()) || !isNeedAddtionalHint(this.mobileCountryCode.getText().toString())) {
            return false;
        }
        return true;
    }

    public boolean getCountryCodeCountryType() {
        return getCountryCodeType(this.mobileCountryCode.getText().toString());
    }

    public String getDirections() {
        return this.directionsText.getText().toString();
    }

    public String getFeild1() {
        return this.field1.getText().toString();
    }

    public String getFeild2() {
        return this.field2.getText().toString();
    }

    public String getFeild3() {
        return this.field3.getText().toString();
    }

    public String getFeild4() {
        return this.field4.getText().toString();
    }

    public String getFeild5() {
        return this.field5.getText().toString();
    }

    public String getFeild6() {
        return this.field6.getText().toString();
    }

    public String getFeild7() {
        return this.field7.getText().toString();
    }

    public String getFirstName() {
        return this.firstName.getText().toString();
    }

    public String getGRL() {
        return this.grlString;
    }

    public String getGRLId() {
        return this.grlId;
    }

    @Nullable
    public LatLng getGeoCodinates() {
        return this.addressgeoCodinates;
    }

    public String getLastName() {
        return this.lastName.getText().toString();
    }

    public void getLocationData() {
        if (checkPermission(this)) {
            Criteria criteria = new Criteria();
            criteria.setAccuracy(1);
            criteria.setBearingRequired(true);
            criteria.setBearingAccuracy(1);
            if (this.locationManager.isProviderEnabled("gps")) {
                startLodingPopup();
                this.locationManager.requestSingleUpdate(criteria, this, (Looper) null);
                return;
            }
            Toast.makeText(this, "Please Enable Gps And Try Again", 1).show();
            return;
        }
        requestPermission(this);
    }

    public String getMobile() {
        return this.mobileText.getText().toString();
    }

    public String getMobileDialCode() {
        return this.mobileCountryCode.getText().toString();
    }

    public String getPhone() {
        return this.phoneText.getText().toString();
    }

    public IGlobalPresenter getPresenter() {
        return this.quickOrderPresenter;
    }

    public String getScreenName() {
        return ScreenNames.EXPRESSCHECKOUT;
    }

    public void hideAddressName() {
        this.field1View.setVisibility(8);
    }

    public void isRefreshMap(boolean z11, @NotNull com.google.android.gms.maps.model.LatLng latLng) {
    }

    public void locationMismatch(String str) {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.location_mismatch_new);
        builder.setMessage(getString(R.string.address_mismatch).replace(RichContentLoadTimeRecorder.DELIMETER, GlobalDataModel.SelectedAreaName));
        builder.setPositiveButton(R.string.f54881ok, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void mapCurrentLocReceived(@NotNull com.google.android.gms.maps.model.LatLng latLng) {
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        Address address;
        Object obj;
        super.onActivityResult(i11, i12, intent);
        if (i11 == 10) {
            if (i12 == -1) {
                this.selectedArea = intent.getIntExtra(GlobalConstants.ExtraNames.SELECTED_AREA_ID, 0);
                String stringExtra = intent.getStringExtra(GlobalConstants.ExtraNames.SELECTED_AREA_NAME);
                this.selectedAreaName = stringExtra;
                this.area.setText(stringExtra);
            }
        } else if (i11 == 30) {
            if (i12 == -1) {
                boolean booleanExtra = intent.getBooleanExtra(GlobalConstants.FORCE_MAP.LOCATION_MIS_MATCH, false);
                String stringExtra2 = intent.getStringExtra("address");
                this.f54584s = stringExtra2;
                if (!TalabatUtils.isNullOrEmpty(stringExtra2)) {
                    Gson gson = UniversalGson.INSTANCE.gson;
                    String str = this.f54584s;
                    Class cls = Address.class;
                    if (!(gson instanceof Gson)) {
                        obj = gson.fromJson(str, cls);
                    } else {
                        obj = GsonInstrumentation.fromJson(gson, str, cls);
                    }
                    address = (Address) obj;
                    address.type = this.selectedAddressPosition;
                } else {
                    address = new Address();
                }
                this.isMapcompulsory = getIntent().getBooleanExtra("map_compulsory", false);
                this.isNineCookiesTrackingEnabled = getIntent().getBooleanExtra("nineCookiesEnabled", false);
                this.isTalabatDeliveryAvailable = getIntent().getBooleanExtra("talabatDeliveryAvailable", false);
                this.isFromMapSkip = intent.getBooleanExtra("skip", false);
                String stringExtra3 = intent.getStringExtra("location");
                if (!TalabatUtils.isNullOrEmpty(stringExtra3)) {
                    String[] split = stringExtra3.split(",");
                    LatLng createLatLng = this.f54581p.createLatLng(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
                    this.geoCodinates = createLatLng;
                    address.latitude = createLatLng.getLatitude();
                    address.longitude = this.geoCodinates.getLongitude();
                    setGeoCodinates(this.geoCodinates);
                }
                this.addressPresenter.updateQuickOrderAddress();
                this.fromMap = true;
                this.blockPresentInMap = !TalabatUtils.isNullOrEmpty(address.block);
                boolean z11 = !TalabatUtils.isNullOrEmpty(address.street);
                this.streetPresentInMap = z11;
                if (this.blockPresentInMap) {
                    this.blockField = address.block;
                }
                if (z11) {
                    this.streetField = address.street;
                }
                this.addressPresenter.addressFromMapRecieved(address, booleanExtra, TalabatUtils.isAddressBlockEnabledCountry(), false);
                if (this.mMap != null && !this.isFromMapSkip) {
                    LatLng latLng = this.geoCodinates;
                    if (latLng == null && (latLng = GlobalDataModel.GEO_CORDINATES.addressPageLatLang) == null && (latLng = this.mapaddressLatlang) == null) {
                        latLng = defaultLatLang();
                    }
                    animateLocation(latLng);
                }
                hideAddressName();
            }
        } else if (i11 == 200) {
            if (i12 == -1) {
                handleSelectAddressAutomatic(intent.getBooleanExtra(GlobalConstants.FORCE_MAP.LOCATION_MIS_MATCH, false), intent.getStringExtra("address"), intent.getStringExtra("location"), intent.getBooleanExtra("skip", false));
            } else if (i12 == 0) {
                finish();
            }
        } else if (i11 == 202) {
            this.quickOrderPresenter.updateMobNoAfterVerification();
        } else if (i11 == 101) {
            if (i12 == -1) {
                this.userSelectedCountryDialCode = intent.getStringExtra(GlobalConstants.CHOOSE_COUNTRY_CODE.COUNTRY_DIAL_CODE);
            }
            setUserSelectedCountryCode(this.userSelectedCountryDialCode);
            usePhoneNumberHintValidation(getCountryCodeCountryGcc());
        }
    }

    public void onAddressAddSuccess(Address address) {
        this.quickOrderPresenter.addressValidated(address);
        GlobalDataModel.GEO_CORDINATES.isRefreshBrandAddress = true;
        onTrackAddressSubmitted(address);
    }

    public void onAddressDeleteFailed(int i11, String str) {
    }

    public void onAddressEditFailed(int i11, String str, Address address) {
        stopLodingPopup();
        if (i11 == 21 || i11 == 22 || i11 == 23 || i11 == 2 || i11 == 3) {
            MaterialEditText materialEditText = this.mobileText;
            if (materialEditText != null) {
                if (TalabatUtils.isNullOrEmpty(str)) {
                    str = "";
                }
                materialEditText.setError(str);
                this.mobileText.setErrorColor(getResources().getColor(R.color.edit_text_error));
                this.mobileText.requestFocus();
                this.mobileText.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
                return;
            }
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        if (i11 == 11) {
            builder.setTitle((CharSequence) getResources().getString(R.string.address_limit_reached));
        }
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
        builder.show();
        trackMapErrorShown(str, address);
    }

    public void onAddressEditSuccess(Address address) {
        GlobalDataModel.GEO_CORDINATES.isRefreshBrandAddress = true;
        GlobalDataModel.HOME_SCREEN_MAP.CONFIRMED_LOCATION_AWARNESS = false;
        onTrackAddressSubmitted(address);
    }

    public void onAddressValidationError(int i11, String str) {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) "" + str);
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void onAddressesDeleted(String str) {
    }

    public void onAreaReceived(Area[] areaArr) {
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        GlobalDataModel.GEO_CORDINATES.saveTempZoomLevel = 0.0f;
        GlobalDataModel.HOME_SCREEN_MAP.CONFIRMED_LOCATION_AWARNESS = false;
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        r.a(this);
        super.onCreate(bundle);
        this.f54582q.initialize();
        setContentView((int) R.layout.quick_order_screen);
        ApptimizeHelper.enableGoogleSearchOptimization(BuildConfig.IS_ALPHA.booleanValue());
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        setTitle(R.id.title, getString(R.string.guest_checkout));
        setBackButton(R.id.back);
        this.redirectNavigation = getIntent().getStringExtra("redirect_navigation");
        this.isMapcompulsory = getIntent().getBooleanExtra("map_compulsory", false);
        this.isNineCookiesTrackingEnabled = getIntent().getBooleanExtra("nineCookiesEnabled", false);
        this.isTalabatDeliveryAvailable = getIntent().getBooleanExtra("talabatDeliveryAvailable", false);
        this.isGrlEnabled = getIntent().getBooleanExtra("isGlrEnabledRes", false);
        this.isFromMapFirstFlow = getIntent().getBooleanExtra("isFromHomeScreenMap", false);
        Button button = (Button) findViewById(R.id.continue_checkout_btn);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.countryCodeLayout);
        this.f54585t = Color.parseColor("#404040");
        this.firstName = (MaterialEditText) findViewById(R.id.quick_order_first_name);
        this.lastName = (MaterialEditText) findViewById(R.id.quick_order_last_name);
        this.firstNameHint = (TextView) findViewById(R.id.quick_order_first_name_text);
        this.lastNameHint = (TextView) findViewById(R.id.quick_order_last_name_text);
        View findViewById = findViewById(R.id.arrow_img);
        this.continue_checkout = (Button) findViewById(R.id.continue_checkout);
        this.area = (MaterialEditText) findViewById(R.id.etArea);
        this.city = (MaterialEditText) findViewById(R.id.etCity);
        this.cityView = findViewById(R.id.add_cityView);
        View findViewById2 = findViewById(R.id.autofill_address_mainLayout);
        this.f54588w = (Spinner) findViewById(R.id.country_code_spinner);
        this.locationManager = (LocationManager) getSystemService("location");
        if (!TalabatUtils.isMapPackageEnabledCountry(this.f54575j, this.f54576k) && (!TalabatUtils.isPartiallyMapPackageEnabledCountry() || (!this.isMapcompulsory && !this.isNineCookiesTrackingEnabled))) {
            findViewById2.setVisibility(8);
        } else if (this.isGrlEnabled) {
            findViewById2.setVisibility(8);
        } else {
            findViewById2.setVisibility(0);
        }
        findViewById(R.id.gps_view).setOnClickListener(new ac(this));
        this.addressTypeEditText = (MaterialEditText) findViewById(R.id.etAddressType);
        Button button2 = (Button) findViewById(R.id.refine_btn);
        this.addressType = (TalabatSpinner) findViewById(R.id.address_type_spinner);
        this.addressTypeSpinnerview = findViewById(R.id.address_type_spinner_view);
        CurrentLocationFetch currentLocationFetch = new CurrentLocationFetch(this, this);
        this.f54590y = currentLocationFetch;
        if (currentLocationFetch.userAllowedAllLocationPermissions(this)) {
            this.f54590y.initLocationRequest(this, CurrentLocHelper.INSTANCE.getIS_FROM_INIT_CL_BG());
            this.f54590y.fetchCurrentLocation();
        }
        View findViewById3 = findViewById(R.id.field1_view);
        this.field1View = findViewById3;
        findViewById3.setVisibility(8);
        this.field2View = findViewById(R.id.field2_view);
        this.field3View = findViewById(R.id.field3_view);
        this.field4View = findViewById(R.id.field4_view);
        this.field5View = findViewById(R.id.field5_view);
        this.field6View = findViewById(R.id.field6_view);
        this.field7View = findViewById(R.id.field7_view);
        this.field1Hint = (TextView) findViewById(R.id.address_name_optional_field_text);
        this.field2Hint = (TextView) findViewById(R.id.field2_text);
        this.field3Hint = (TextView) findViewById(R.id.field3_text);
        this.field4Hint = (TextView) findViewById(R.id.field4_text);
        this.field5Hint = (TextView) findViewById(R.id.field5_text);
        this.field6Hint = (TextView) findViewById(R.id.field6_text);
        this.field7Hint = (TextView) findViewById(R.id.field7_text);
        this.field1 = (MaterialEditText) findViewById(R.id.address_name_optional_field);
        this.field2 = (MaterialEditText) findViewById(R.id.field2);
        this.field3 = (MaterialEditText) findViewById(R.id.field3);
        this.field4 = (MaterialEditText) findViewById(R.id.field4);
        this.field5 = (MaterialEditText) findViewById(R.id.field5);
        this.field6 = (MaterialEditText) findViewById(R.id.field6);
        this.field7 = (MaterialEditText) findViewById(R.id.field7);
        this.mobileText = (MaterialEditText) findViewById(R.id.mobileEditText);
        this.mobileCountryCode = (MaterialEditText) findViewById(R.id.country_code_mobile);
        this.hiddenMobile = (MaterialEditText) findViewById(R.id.hidden_mobile_field);
        this.phoneText = (MaterialEditText) findViewById(R.id.phoneEditText);
        this.phoneCountryCode = (MaterialEditText) findViewById(R.id.country_code_phone);
        this.hiddenPhone = (MaterialEditText) findViewById(R.id.hidden_phone_field);
        this.directionsText = (MaterialEditText) findViewById(R.id.directionsEditText);
        this.hiddenMobile.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            public void onDestroyActionMode(ActionMode actionMode) {
            }

            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        this.hiddenMobile.setLongClickable(false);
        this.hiddenMobile.setTextIsSelectable(false);
        this.f54587v = new String[]{getString(R.string.house), getString(R.string.building), getString(R.string.office)};
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.talabat_spinner_item, this.f54587v);
        arrayAdapter.setDropDownViewResource(R.layout.talabat_spinner_drop_down_item);
        this.addressType.setSelection(1);
        this.selectedAddressPosition = userSelectedAddressType();
        this.addressType.setAdapter((SpinnerAdapter) arrayAdapter);
        this.addressTypeEditText.setOnClickListener(new sb(this));
        this.addressType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i11, long j11) {
                QuickOrderScreen quickOrderScreen = QuickOrderScreen.this;
                int i12 = quickOrderScreen.f54586u + 1;
                quickOrderScreen.f54586u = i12;
                if (i12 > 1) {
                    quickOrderScreen.addressTypeEditText.setText("");
                    QuickOrderScreen.this.addressTypeEditText.setText(QuickOrderScreen.this.addressType.getSelectedItem().toString());
                    QuickOrderScreen.this.addressPresenter.addressTypeSelected(i11);
                    if (!TalabatUtils.isNullOrEmpty(QuickOrderScreen.this.f54584s)) {
                        QuickOrderScreen.this.selectedAddressPosition = i11;
                    }
                    QuickOrderScreen.this.addressType.setVisibility(8);
                    QuickOrderScreen.this.addressTypeSpinnerview.setVisibility(8);
                    QuickOrderScreen.this.field2.setSelection(QuickOrderScreen.this.field2.getText().length());
                    QuickOrderScreen.this.field2.requestFocus();
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.city.setText(GlobalDataModel.SelectedCityName);
        this.continue_checkout.setOnClickListener(new vb(this));
        button2.setOnClickListener(new wb(this));
        button.setOnClickListener(new xb(this));
        setArea(GlobalDataModel.SelectedAreaName, GlobalDataModel.SelectedAreaId);
        this.firstName.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                QuickOrderScreen.this.firstNameHint.setTextColor(QuickOrderScreen.this.f54585t);
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.lastName.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                QuickOrderScreen.this.lastNameHint.setTextColor(QuickOrderScreen.this.f54585t);
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.field1.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                QuickOrderScreen.this.field1Hint.setTextColor(QuickOrderScreen.this.f54585t);
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.field2.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                QuickOrderScreen.this.field2Hint.setTextColor(QuickOrderScreen.this.f54585t);
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.field3.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                QuickOrderScreen.this.field3Hint.setTextColor(QuickOrderScreen.this.f54585t);
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.field4.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                QuickOrderScreen.this.field4Hint.setTextColor(QuickOrderScreen.this.f54585t);
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.field5.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                QuickOrderScreen.this.field5Hint.setTextColor(QuickOrderScreen.this.f54585t);
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.field6.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                QuickOrderScreen.this.field6Hint.setTextColor(QuickOrderScreen.this.f54585t);
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.field7.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                QuickOrderScreen.this.field7Hint.setTextColor(QuickOrderScreen.this.f54585t);
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.mobileText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                QuickOrderScreen.this.hiddenMobile.setText(charSequence);
                QuickOrderScreen.this.hiddenMobile.setTextColor(-1);
            }
        });
        this.mobileCountryCode.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.phoneText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                QuickOrderScreen.this.hiddenPhone.setText(charSequence);
                QuickOrderScreen.this.hiddenPhone.setTextColor(-1);
            }
        });
        this.phoneCountryCode.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.phoneText.setOnClickListener(new yb(this));
        this.phoneCountryCode.setOnClickListener(new zb(this));
        relativeLayout.setOnClickListener(new bc(this));
        this.mobileCountryCode.setOnClickListener(new cc(this));
        if (TalabatUtils.isCountryCodeVerificationEnabledCountry()) {
            relativeLayout.setVisibility(0);
            if (TalabatUtils.isInterantionalCountryCodeVerificationEnabledCountry(this.f54575j, this.f54576k)) {
                this.f54588w.setVisibility(8);
                findViewById.setVisibility(0);
                this.mobileCountryCode.setTextColor(getResources().getColor(R.color.talabat_black));
                this.mobileCountryCode.requestFocus();
            } else {
                setCountryCode();
                this.f54588w.setVisibility(8);
                findViewById.setVisibility(8);
            }
        } else {
            relativeLayout.setVisibility(8);
        }
        this.directionsText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(200)});
        this.firstName.setFocusableInTouchMode(true);
        this.firstName.requestFocus();
        this.firstName.setImeOptions(5);
        this.firstName.setOnEditorActionListener(new dc(this));
        this.lastName.setImeOptions(5);
        this.lastName.setOnEditorActionListener(new fc(this));
        this.mobileText.setImeOptions(5);
        this.mobileText.setOnEditorActionListener(new gc(this));
        this.phoneText.setImeOptions(5);
        this.phoneText.setOnEditorActionListener(new hc(this));
        this.field2.setImeOptions(5);
        this.field2.setOnEditorActionListener(new ic(this));
        this.field3.setImeOptions(5);
        this.field3.setOnEditorActionListener(new jc(this));
        this.field4.setImeOptions(5);
        this.field4.setOnEditorActionListener(new kc(this));
        this.field5.setImeOptions(5);
        this.field5.setOnEditorActionListener(new lc(this));
        this.field6.setImeOptions(5);
        this.field6.setOnEditorActionListener(new mc(this));
        this.field7.setImeOptions(5);
        this.field7.setOnEditorActionListener(new qb(this));
        this.directionsText.setOnEditorActionListener(new rb(this));
        AddressPresenter addressPresenter2 = r1;
        AddressPresenter addressPresenter3 = new AddressPresenter(this, this, AddressesDependencyProvider.INSTANCE.provideCustomerAddressesRepository(this.f54580o), Schedulers.io(), AndroidSchedulers.mainThread(), this.f54574i, this.f54575j, this.f54576k, this.f54578m, this.f54579n, this.f54580o, this.f54581p);
        this.addressPresenter = addressPresenter2;
        this.quickOrderPresenter = new QuickOrderPresenter(this.f54574i, this, new OnQuickOrderValidatedImp(getApplication()), this.f54578m, this.f54575j, this.f54576k);
        this.addressPresenter.isCheckLoadResPoryGon(true);
        this.quickOrderPresenter.setUpQuickOrderView((JSONObject) null, this.addressPresenter, "", "", this.isMapcompulsory, this.isNineCookiesTrackingEnabled, this.isTalabatDeliveryAvailable, false, this.isGrlEnabled, this.isFromMapFirstFlow);
        ((ImageButton) findViewById(R.id.back)).setOnClickListener(new tb(this));
        if (TalabatUtils.isMapPackageEnabledCountry(this.f54575j, this.f54576k) || (TalabatUtils.isPartiallyMapPackageEnabledCountry() && (this.isMapcompulsory || this.isNineCookiesTrackingEnabled))) {
            MapContainerFragment mapContainerFragment = (MapContainerFragment) getSupportFragmentManager().findFragmentById(R.id.add_autofill_address_view);
            mapContainerFragment.init((ViewGroup) null);
            mapContainerFragment.getMapAsync(new ub(this));
        }
        if (TalabatUtils.isRTL()) {
            try {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.parent_layout);
                if (linearLayout != null) {
                    linearLayout.setLayoutDirection(1);
                }
                MaterialEditText materialEditText = this.firstName;
                if (materialEditText != null) {
                    materialEditText.setTextDirection(4);
                }
                MaterialEditText materialEditText2 = this.lastName;
                if (materialEditText2 != null) {
                    materialEditText2.setTextDirection(4);
                }
                MaterialEditText materialEditText3 = this.field1;
                if (materialEditText3 != null) {
                    materialEditText3.setTextDirection(4);
                }
                MaterialEditText materialEditText4 = this.field2;
                if (materialEditText4 != null) {
                    materialEditText4.setTextDirection(4);
                }
                MaterialEditText materialEditText5 = this.field3;
                if (materialEditText5 != null) {
                    materialEditText5.setTextDirection(4);
                }
                MaterialEditText materialEditText6 = this.field4;
                if (materialEditText6 != null) {
                    materialEditText6.setTextDirection(4);
                }
                MaterialEditText materialEditText7 = this.field5;
                if (materialEditText7 != null) {
                    materialEditText7.setTextDirection(4);
                }
                MaterialEditText materialEditText8 = this.field6;
                if (materialEditText8 != null) {
                    materialEditText8.setTextDirection(4);
                }
                MaterialEditText materialEditText9 = this.field7;
                if (materialEditText9 != null) {
                    materialEditText9.setTextDirection(4);
                }
                MaterialEditText materialEditText10 = this.hiddenMobile;
                if (materialEditText10 != null) {
                    materialEditText10.setTextDirection(4);
                }
                MaterialEditText materialEditText11 = this.phoneText;
                if (materialEditText11 != null) {
                    materialEditText11.setTextDirection(4);
                }
                MaterialEditText materialEditText12 = this.phoneCountryCode;
                if (materialEditText12 != null) {
                    materialEditText12.setTextDirection(4);
                }
                MaterialEditText materialEditText13 = this.directionsText;
                if (materialEditText13 != null) {
                    materialEditText13.setTextDirection(4);
                }
                MaterialEditText materialEditText14 = this.area;
                if (materialEditText14 != null) {
                    materialEditText14.setTextDirection(4);
                }
                MaterialEditText materialEditText15 = this.city;
                if (materialEditText15 != null) {
                    materialEditText15.setTextDirection(4);
                }
                MaterialEditText materialEditText16 = this.addressTypeEditText;
                if (materialEditText16 != null) {
                    materialEditText16.setTextDirection(4);
                }
                MaterialEditText materialEditText17 = this.mobileText;
                if (materialEditText17 != null) {
                    materialEditText17.setTextDirection(4);
                }
                Spinner spinner = this.f54588w;
                if (spinner != null) {
                    spinner.setTextDirection(4);
                }
                MaterialEditText materialEditText18 = this.mobileCountryCode;
                if (materialEditText18 != null) {
                    materialEditText18.setTextDirection(4);
                }
                MaterialEditText materialEditText19 = this.hiddenPhone;
                if (materialEditText19 != null) {
                    materialEditText19.setTextDirection(4);
                }
            } catch (Exception e11) {
                LogManager.logException(e11);
            }
        }
        this.addressPresenter.onCreate();
    }

    public void onCurrentLocationReceived(@Nullable com.google.android.gms.maps.model.LatLng latLng, boolean z11, float f11) {
    }

    public void onCurrentLocationReceivedWithLowAccuracy(@NotNull com.google.android.gms.maps.model.LatLng latLng, float f11) {
    }

    public void onError() {
    }

    public void onGeoLocationDialogAccepted(boolean z11) {
    }

    public void onLocationChanged(Location location) {
        locationRecieved(location);
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onRedirectToAreaScreen() {
    }

    public void onRedirectToCheckout(QuickOrderInfo quickOrderInfo) {
        String str;
        if (this.blockPresentInMap && this.fromMap && !this.blockField.equals(this.newBlockField)) {
            AppTracker.onMapBlockUpdated(this);
        }
        if (this.streetPresentInMap && this.fromMap && !this.streetField.equals(this.newStreetField)) {
            AppTracker.onMapStreetUpdated(this);
        }
        this.fromMap = false;
        AppTracker.onCheckoutClicked(this, Cart.getInstance(), AppTracker.getRestaurantId(Cart.getInstance().getRestaurant()), Cart.getInstance().getCartItems().size(), getScreenName(), ScreenNames.getScreenType(getScreenName()));
        if ("redirect_back".equals(this.redirectNavigation)) {
            SharedPreferencesManager.getInstance().setGuestAddressFlowCompleted(true);
            setResult(-1);
            finish();
            return;
        }
        String str2 = getFirstName() + " " + getLastName();
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) quickOrderInfo);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) quickOrderInfo);
        }
        Intent intent = new Intent(this, CheckOutScreen.class);
        intent.putExtra("value", str);
        intent.putExtra("isGlrEnabledRes", this.isGrlEnabled);
        intent.putExtra("isQuick", true);
        intent.putExtra("appendedName", str2);
        startActivityForResult(intent, 202);
    }

    public void onRedirectToMapScreen(@Nullable LatLng latLng, boolean z11, boolean z12) {
        showMapView(true);
    }

    public void onResume() {
        super.onResume();
    }

    public void onSpinnerClosed() {
    }

    public void onSpinnerOpened() {
    }

    public void onStart() {
        super.onStart();
        this.addressPresenter.onScreenStart(false);
    }

    public void onStatusChanged(String str, int i11, Bundle bundle) {
    }

    public void onStop() {
        super.onStop();
    }

    public void onValidationSuccess() {
    }

    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        if (this.addressType.hasBeenOpened() && z11) {
            Editable text = this.addressTypeEditText.getText();
            if (text == null || text.toString().isEmpty()) {
                this.addressTypeEditText.setText(this.addressType.getSelectedItem().toString());
            }
            this.addressTypeSpinnerview.setVisibility(8);
        }
    }

    public void redirectToMap() {
        showMapView(true);
    }

    public void setAddressTypeText(int i11) {
    }

    public void setArea(String str, int i11) {
        this.selectedAreaName = str;
        this.selectedArea = i11;
        this.area.setText(str);
    }

    public void setCity(String str, int i11) {
        this.SELECTED_CITY = i11;
        this.city.setText(str);
    }

    public void setCount(int i11) {
        this.fldCount = i11;
    }

    public void setCountryCode() {
        this.mobileCountryCode.setVisibility(0);
        Country selectedCountry = this.f54575j.selectedCountry();
        ArrayList<CountryCode> arrayList = this.allCountriesList;
        if (arrayList != null) {
            if (arrayList.size() > 0) {
                for (int i11 = 0; i11 < this.allCountriesList.size(); i11++) {
                    if (selectedCountry == Country.KUWAIT) {
                        if (this.allCountriesList.get(i11).dialCode.equals("+965")) {
                            this.f54588w.setSelection(i11);
                            this.mobileCountryCode.setText("+965");
                        }
                    } else if (selectedCountry == Country.KSA) {
                        if (this.allCountriesList.get(i11).dialCode.equals("+966")) {
                            this.f54588w.setSelection(i11);
                            this.mobileCountryCode.setText("+966");
                        }
                    } else if (selectedCountry == Country.BAHRAIN) {
                        if (this.allCountriesList.get(i11).dialCode.equals("+973")) {
                            this.f54588w.setSelection(i11);
                            this.mobileCountryCode.setText("+973");
                        }
                    } else if (selectedCountry == Country.OMAN) {
                        if (this.allCountriesList.get(i11).dialCode.equals("+968")) {
                            this.f54588w.setSelection(i11);
                            this.mobileCountryCode.setText("+968");
                        }
                    } else if (selectedCountry == Country.QATAR) {
                        if (this.allCountriesList.get(i11).dialCode.equals("+974")) {
                            this.f54588w.setSelection(i11);
                            this.mobileCountryCode.setText("+974");
                        }
                    } else if (selectedCountry == Country.UAE) {
                        if (this.allCountriesList.get(i11).dialCode.equals("+971")) {
                            this.mobileCountryCode.setText("+971");
                            this.userSelectedCountryDialCode = "+971";
                        }
                    } else if (selectedCountry == Country.JORDAN) {
                        if (this.allCountriesList.get(i11).dialCode.equals("+962")) {
                            this.mobileCountryCode.setText("+962");
                            this.f54588w.setSelection(i11);
                        }
                    } else if (selectedCountry == Country.EGYPT && this.allCountriesList.get(i11).dialCode.equals("+20")) {
                        this.mobileCountryCode.setText("+20");
                        this.f54588w.setSelection(i11);
                    }
                }
            }
        } else if (selectedCountry == Country.KUWAIT) {
            this.mobileCountryCode.setText("+965");
        } else if (selectedCountry == Country.KSA) {
            this.mobileCountryCode.setText("+966");
        } else if (selectedCountry == Country.BAHRAIN) {
            this.mobileCountryCode.setText("+973");
        } else if (selectedCountry == Country.OMAN) {
            this.mobileCountryCode.setText("+968");
        } else if (selectedCountry == Country.QATAR) {
            this.mobileCountryCode.setText("+974");
        } else if (selectedCountry == Country.UAE) {
            this.mobileCountryCode.setText("+971");
            this.userSelectedCountryDialCode = "+971";
        } else if (selectedCountry == Country.JORDAN) {
            this.mobileCountryCode.setText("+962");
        } else if (selectedCountry == Country.EGYPT) {
            this.mobileCountryCode.setText("+20");
        } else if (selectedCountry == Country.IRAQ) {
            this.mobileCountryCode.setText("+964");
        }
    }

    public void setDefaultCountryCode() {
        setCountryCode();
    }

    public void setDirections(String str) {
        this.directionsText.setText(str);
    }

    public void setErrorFeild1(int i11) {
        this.field1.setErrorColor(getResources().getColor(R.color.edit_text_error));
        this.field1.setError(getResources().getString(R.string.required));
        this.field1.requestFocus();
        this.field1.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
    }

    public void setErrorFeild2(int i11) {
        this.field2.setErrorColor(getResources().getColor(R.color.edit_text_error));
        this.field2.setError(getResources().getString(R.string.required));
        this.field2.requestFocus();
        this.field2.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
    }

    public void setErrorFeild3(int i11) {
        this.field3.setErrorColor(getResources().getColor(R.color.edit_text_error));
        this.field3.setError(getResources().getString(R.string.required));
        this.field3.requestFocus();
        this.field3.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
    }

    public void setErrorFeild4(int i11) {
        this.field4.setErrorColor(getResources().getColor(R.color.edit_text_error));
        this.field4.setError(getResources().getString(R.string.required));
        this.field4.requestFocus();
        this.field4.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
    }

    public void setErrorFeild5(int i11) {
        this.field5.setErrorColor(getResources().getColor(R.color.edit_text_error));
        this.field5.setError(getResources().getString(R.string.required));
        this.field5.requestFocus();
        this.field5.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
    }

    public void setErrorFeild6(int i11) {
        this.field6.setErrorColor(getResources().getColor(R.color.edit_text_error));
        this.field6.setError(getResources().getString(R.string.required));
        this.field6Hint.setTextColor(getResources().getColor(R.color.edit_text_hint));
        this.field6.requestFocus();
        this.field6.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
    }

    public void setErrorFeild7(int i11) {
        this.field7.setErrorColor(getResources().getColor(R.color.edit_text_error));
        this.field7.setError(getResources().getString(R.string.required));
        this.field7Hint.setTextColor(getResources().getColor(R.color.edit_text_hint));
        this.field7.requestFocus();
        this.field7.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
    }

    public void setErrorMobileField(int i11) {
        String str;
        this.mobileText.setErrorColor(getResources().getColor(R.color.edit_text_error));
        this.mobileText.requestFocus();
        MaterialEditText materialEditText = this.mobileText;
        if (i11 == 3) {
            str = getResources().getString(R.string.uae_international_validation);
        } else {
            str = getResources().getString(R.string.required);
        }
        materialEditText.setError(str);
        this.mobileText.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
    }

    public void setErrorPhnField(int i11) {
        this.phoneText.setError(getResources().getString(R.string.required));
        this.phoneText.setErrorColor(getResources().getColor(R.color.edit_text_error));
        this.phoneText.requestFocus();
        this.phoneText.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
    }

    public void setFeild1(boolean z11, String str, boolean z12, int i11, boolean z13) {
        this.field1View.setVisibility(z11 ? 0 : 8);
        this.field1.setHint(str);
        this.field1.setFloatingLabelText(str);
        this.field1Hint.setText(str);
        setEditTextProperties(this.field1, i11);
    }

    public void setFeild2(boolean z11, String str, boolean z12, int i11, boolean z13) {
        this.field2View.setVisibility(z11 ? 0 : 8);
        this.field2.setHint(str);
        this.field2.setFloatingLabelText(str);
        this.field2Hint.setText(str);
        setEditTextProperties(this.field2, i11);
    }

    public void setFeild3(boolean z11, String str, boolean z12, int i11, boolean z13) {
        this.field3View.setVisibility(z11 ? 0 : 8);
        this.field3.setHint(str);
        this.field3.setFloatingLabelText(str);
        this.field3Hint.setText(str);
        setEditTextProperties(this.field3, i11);
    }

    public void setFeild4(boolean z11, String str, boolean z12, int i11, boolean z13) {
        this.field4View.setVisibility(z11 ? 0 : 8);
        this.field4.setHint(str);
        this.field4.setFloatingLabelText(str);
        this.field4Hint.setText(str);
        setEditTextProperties(this.field4, i11);
    }

    public void setFeild5(boolean z11, String str, boolean z12, int i11, boolean z13) {
        this.field5View.setVisibility(z11 ? 0 : 8);
        this.field5.setHint(str);
        this.field5.setFloatingLabelText(str);
        this.field5Hint.setText(str);
        setEditTextProperties(this.field5, i11);
    }

    public void setFeild6(boolean z11, String str, boolean z12, int i11, boolean z13) {
        this.field6View.setVisibility(z11 ? 0 : 8);
        this.field6.setHint(str);
        this.field6.setFloatingLabelText(str);
        this.field6Hint.setText(str);
        setEditTextProperties(this.field6, i11);
    }

    public void setFeild7(boolean z11, String str, boolean z12, int i11, boolean z13) {
        this.field7View.setVisibility(z11 ? 0 : 8);
        this.field7.setHint(str);
        this.field7.setFloatingLabelText(str);
        this.field7Hint.setText(str);
        setEditTextProperties(this.field7, i11);
    }

    public void setFirstName(String str) {
        this.firstName.setText(str);
        if (!TalabatUtils.isNullOrEmpty(str)) {
            this.firstName.setSelection(str.length());
        }
    }

    public void setFirstNameError(int i11) {
        this.firstName.setErrorColor(getResources().getColor(R.color.edit_text_error));
        this.firstName.setError(getResources().getString(R.string.required));
        this.firstName.requestFocus();
        this.firstName.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
    }

    public void setGRL(String str) {
        this.grlString = str;
    }

    public void setGeoCodinates(@Nullable LatLng latLng) {
        this.addressgeoCodinates = latLng;
    }

    public void setGoogleMapView(LatLng latLng) {
        if (latLng == null) {
            latLng = defaultLatLang();
        }
        this.mapaddressLatlang = latLng;
        GlobalDataModel.GEO_CORDINATES.addressPageLatLang = latLng;
        animateLocation(latLng);
    }

    public void setGrlId(String str) {
        this.grlId = str;
    }

    public void setLastName(String str) {
        this.lastName.setText(str);
    }

    public void setLastNameError(int i11) {
        this.lastName.setErrorColor(getResources().getColor(R.color.edit_text_error));
        this.lastName.requestFocus();
        this.lastName.setError(getResources().getString(R.string.required));
        this.lastName.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
    }

    public void setMobile(String str, String str2) {
        this.mobileText.performClick();
        this.mobileText.setText(str);
    }

    public void setMobileCountryCode(String str) {
        this.mobileCountryCode.setVisibility(0);
        this.mobileCountryCode.setText(str);
        this.userSelectedCountryDialCode = str;
    }

    public void setNonJsonFields(boolean z11) {
        if (!TalabatUtils.isNullOrEmpty(getMobile())) {
            setMobile(getMobile(), "");
        }
        if (!TalabatUtils.isNullOrEmpty(getPhone())) {
            setPhone(getMobile(), "", z11);
        }
        if (!TalabatUtils.isNullOrEmpty(getDirections())) {
            setDirections(getDirections());
        }
    }

    public void setPhone(String str, String str2, boolean z11) {
        String str3;
        this.hiddenPhone.performClick();
        this.phoneText.setText(str);
        MaterialEditText materialEditText = this.phoneText;
        if (z11) {
            str3 = getResources().getString(R.string.land_line_hint);
        } else {
            str3 = getResources().getString(R.string.land_line_international_hint);
        }
        materialEditText.setHint(str3);
        this.hiddenPhone.setText(str);
        this.hiddenPhone.setTextColor(-1);
    }

    public void setSelectedAddressType(int i11) {
        this.addressType.setSelection(i11, true);
        this.addressTypeEditText.setText(this.addressType.getSelectedItem().toString());
    }

    public void setShowCity(boolean z11) {
        if (z11) {
            this.cityView.setVisibility(0);
        } else {
            this.cityView.setVisibility(8);
        }
    }

    public void showConfirmAddressPopup() {
        if (!this.f54580o.getFeatureFlag(TalabatFeatureFlagConstants.REMOVE_CONFIRM_ADDRESS_POP_UP, false)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
            builder.setTitle((CharSequence) getString(R.string.confirm_address));
            builder.setMessage((CharSequence) getString(R.string.confirm_address_description));
            builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
            builder.show();
        }
    }

    public /* synthetic */ void showGenericErrorMessage() {
        n.a(this);
    }

    public void showMapView(boolean z11) {
        GeoCoordinate invoke = this.f54577l.invoke();
        if (!z11 || invoke == null || !TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.EXPERIMENT_PIN_LESS_CHECKOUT, false, TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            Intent intent = new Intent(this, MapsActivity.class);
            intent.putExtra("noAreaChange", true);
            if (!z11) {
                LatLng latLng = GlobalDataModel.GEO_CORDINATES.addressPageLatLang;
                if (latLng == null && (latLng = this.geoCodinates) == null) {
                    latLng = null;
                }
                if (latLng != null) {
                    intent.putExtra("location", "" + latLng.getLatitude() + "," + latLng.getLongitude());
                    intent.putExtra("isAcurate", true);
                }
            } else if (this.geoCodinates != null) {
                intent.putExtra("location", "" + this.geoCodinates.getLatitude() + "," + this.geoCodinates.getLongitude());
                intent.putExtra("isAcurate", true);
            }
            if (this.isFromMapFirstFlow && !this.isGrlEnabled && this.tempMapFirstLatLng == null) {
                saveGeoCoordinatesInGlobalDataModel(toOurs(HomeMapTemp.INSTANCE.getHomeMapSavedLatLng(), this.f54581p));
            }
            intent.putExtra("map_compulsory", this.isMapcompulsory);
            intent.putExtra("nineCookiesEnabled", this.isNineCookiesTrackingEnabled);
            intent.putExtra("talabatDeliveryAvailable", this.isTalabatDeliveryAvailable);
            intent.putExtra("address", this.f54584s);
            intent.putExtra("isAddressFromCartOrderFlow", true);
            intent.putExtra("isQuick", true);
            intent.putExtra("userSelectedAreaId", GlobalDataModel.SelectedAreaId);
            if (z11) {
                startActivityForResult(intent, 200);
            } else {
                startActivityForResult(intent, 30);
            }
        } else {
            saveGeoCoordinatesInGlobalDataModel(this.f54581p.createLatLng(invoke.getLatitude(), invoke.getLatitude()));
            handleSelectAddressAutomatic(false, "", invoke.getLatitude() + "," + invoke.getLongitude(), false);
        }
    }

    public void switchAdditionalDirectionsToLandmark() {
        CharSequence text = getText(R.string.landmark_group_number_etc);
        this.directionsText.setHint(text);
        this.directionsText.setFloatingLabelText(text);
    }

    public void switchAddressTypeToBuildingType() {
        CharSequence text = getText(R.string.building_type);
        this.addressTypeEditText.setHint(text);
        this.addressTypeEditText.setFloatingLabelText(text);
    }

    public void updateMapCompulsory(boolean z11, boolean z12, boolean z13) {
        this.isMapcompulsory = z11;
        this.isNineCookiesTrackingEnabled = z12;
        this.isTalabatDeliveryAvailable = z13;
    }

    public void updatePolygonServiceEnabled(boolean z11) {
    }

    public void updateTemapLatLang(com.google.android.gms.maps.model.LatLng latLng) {
        this.tempMapFirstLatLng = toOurs(latLng, this.f54581p);
    }

    public void onAddressValidationError(int i11, int i12) {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) "" + i12);
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void setFeild1(String str, boolean z11, boolean z12) {
        this.field1.setText(str);
        this.field1.setEnabled(z11);
    }

    public void setFeild2(String str, boolean z11, boolean z12, boolean z13) {
        this.field2.setText(str);
        if (this.isGrlEnabled) {
            if (McdMapTempAddress.getInstance().getSelectedGrlTempAddress() != null) {
                z11 = TalabatUtils.isNullOrEmpty(McdMapTempAddress.getInstance().getSelectedGrlTempAddress().street);
            }
            this.field2.setEnabled(z11);
            return;
        }
        this.field2.setFocusableInTouchMode(true);
        this.field2.setEnabled(true);
    }

    public void setFeild3(String str, boolean z11, boolean z12) {
        this.field3.setText(str);
        if (this.isGrlEnabled) {
            if (McdMapTempAddress.getInstance().getSelectedGrlTempAddress() != null) {
                z11 = TalabatUtils.isNullOrEmpty(McdMapTempAddress.getInstance().getSelectedGrlTempAddress().buildingNo);
            }
            this.field3.setEnabled(z11);
            return;
        }
        this.field3.setEnabled(true);
    }

    public void setFeild4(String str, boolean z11, boolean z12) {
        this.field4.setText(str);
        this.field4.setEnabled(z11);
    }

    public void setFeild5(String str, boolean z11, boolean z12) {
        this.field5.setText(str);
        this.field5.setEnabled(z11);
    }

    public void setFeild6(String str, boolean z11, boolean z12) {
        this.field6.setText(str);
    }

    public void setFeild7(String str, boolean z11, boolean z12) {
        this.field7.setText(str);
    }
}
