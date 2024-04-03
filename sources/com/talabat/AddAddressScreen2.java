package com.talabat;

import JsonModels.parser.UniversalGson;
import android.app.AlertDialog;
import android.app.Dialog;
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
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import buisnessmodels.GEMEngine;
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
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.pinless.checkout.domain.GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.designhelpers.CountryCode;
import com.talabat.designhelpers.CountryCodePicker;
import com.talabat.domain.address.Address;
import com.talabat.domain.location.GeoCoordinate;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
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
import com.talabat.maps.domain.ModelsRepository;
import com.talabat.maps.domain.model.LatLng;
import com.talabat.maps.domain.model.LatLngBounds;
import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.common.UserAction;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.ul.addressform.FlutterAddressFormActivity;
import datamodels.Area;
import datamodels.Restaurant;
import datamodels.analyticstrackermodels.AddressAnalyticsTracker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.functions.Function0;
import library.talabat.gemengine.GemView;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.addressV2.AddressPresenter;
import library.talabat.mvp.addressV2.AddressView;
import library.talabat.mvp.addressV2.IAddressPresenter;
import library.talabat.mvp.addressV2.SaveAddressEventsOrigin;
import library.talabat.mvp.addressV2.UserAddAddressScreenEventsListener;
import library.talabat.mvp.addressV2.UserAddressEventsKt;
import library.talabat.mvp.homemap.HomeMapTemp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tracking.AppTracker;
import tracking.ScreenNames;
import tracking.gtm.TrackingUtils;
import ue.a0;
import ue.d;
import ue.e;
import ue.f;
import ue.g;
import ue.h;
import ue.h0;
import ue.i;
import ue.j;
import ue.k;
import ue.l;
import ue.m;
import ue.o;
import ue.p;
import ue.q;
import ue.r;
import ue.s;
import ue.t;
import ue.u;
import ue.v;
import ue.w;
import ue.x;
import ue.z;
import yq.a;

@Instrumented
public class AddAddressScreen2 extends TalabatBase implements AddressView, LocationListener, TalabatSpinner.OnSpinnerEventsListener, GemView, OnGemAlertDialogClickListener, CurrentLocationListener {
    private static final int FLUTTER_ADDRESS_REQUEST_CODE = 12423532;
    private static final int GPSENABLE = 45;
    private static final String KEY_LATITUDE = "savedlatitude";
    private static final String KEY_LONGITUDE = "savedlongitude";
    private static final int PERMISSION_REQUEST_CODE = 500;
    private static final String SCREEN_NAME = "AddAddressScreen2";
    public static final int SELECT_ADDRESS_AUTOMATIC = 99;
    public static final int SELECT_ADDRESS_MANUAL = 100;
    public GemFooterCartView A;
    public CurrentLocationFetch B;
    @Inject
    public Function0<String> C;
    private final int CHOOSE_COUNTRY_CODE = 101;
    private final int SELECTAREA = 10;
    private final int SELECTCITY = 20;
    private int SELECTED_AREA = -1;
    private String SELECTED_AREA_NAME = "";
    private int SELECTED_CITY = -1;
    private String SELECTED_CITY_NAME = "";
    /* access modifiers changed from: private */
    public TextView addressNameOptionalHint;
    /* access modifiers changed from: private */
    public IAddressPresenter addressPresenter;
    /* access modifiers changed from: private */
    public TalabatSpinner addressType;
    /* access modifiers changed from: private */
    public MaterialEditText addressTypeEditText;
    /* access modifiers changed from: private */
    public View addressTypeSpinnerview;
    private ArrayList<CountryCode> allCountriesList;
    private MaterialEditText area;
    private Area[] areas;
    private View autofillAddressView;
    private ImageButton backButton;
    private String blockField = "";
    private boolean blockPresentInMap = false;
    private MaterialEditText city;
    private View cityView;
    private RelativeLayout countryCodeLayout;
    private Button deleteAddress;
    private String deliveryAddressStatus;
    private MaterialEditText directionsText;
    private String eventOrigin = null;
    /* access modifiers changed from: private */
    public MaterialEditText field1;
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
    private TextView field8Hint;
    private int fldCount = 0;
    private boolean fromMap = false;
    private View gpsView;
    private String grlId;
    private String grlString;
    /* access modifiers changed from: private */
    public MaterialEditText hiddenMobile;
    /* access modifiers changed from: private */
    public MaterialEditText hiddenPhone;
    private int hightlightCityId;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public AppVersionProvider f53497i;
    private boolean isAddAddressFromCheckout = false;
    private boolean isAddressFromCartOrderFlow;
    private boolean isCityInAddress = false;
    private boolean isCityNextClicked = false;
    private boolean isEditAddressFromCheckoutScreen;
    private boolean isEditAddressFromSideMenu;
    /* access modifiers changed from: private */
    public boolean isForEdit;
    private boolean isFromCheckout;
    private boolean isFromFlutter;
    private boolean isFromMapFirstFlow;
    private boolean isFromMcdAddressFlow;
    private boolean isGlrEnableAddNewAddress;
    private boolean isGrlEnabled;
    private boolean isMapFromSideMenu;
    private boolean isMapcompulsory;
    private boolean isNewAddressCreation;
    private boolean isNewAddressCreationGlrFlow;
    private boolean isNewAddressFromCartFlow;
    private boolean isNineCookiesTrackingEnabled;
    private boolean isOrderFlow = false;
    private boolean isTalabatDeliveryAvailable;
    private boolean isTitleCorrection;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public ConfigurationLocalRepository f53498j;
    @Inject

    /* renamed from: k  reason: collision with root package name */
    public MutableLocationConfigurationRepository f53499k;
    @Inject

    /* renamed from: l  reason: collision with root package name */
    public GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase f53500l;
    private LocationManager locationManager;
    private String locationMethod;
    @Inject

    /* renamed from: m  reason: collision with root package name */
    public UserAddAddressScreenEventsListener f53501m;
    private FrameworkMap mMap;
    private LatLng mapHighlightLocation;
    private String mapJourneytype = "";
    private LatLng mapaddressLatlang;
    /* access modifiers changed from: private */
    public TalabatTextView mobileArabicErrorText;
    private MaterialEditText mobileCountryCode;
    private MaterialEditText mobileText;
    @Inject

    /* renamed from: n  reason: collision with root package name */
    public TalabatTracker f53502n;
    private String newBlockField = "";
    private String newStreetField = "";
    private boolean noAreaChange = false;
    @Inject

    /* renamed from: o  reason: collision with root package name */
    public ITalabatFeatureFlag f53503o;
    @Inject

    /* renamed from: p  reason: collision with root package name */
    public ModelsRepository f53504p;
    private MaterialEditText phoneCountryCode;
    private MaterialEditText phoneText;
    @Inject

    /* renamed from: q  reason: collision with root package name */
    public LatLngFactory f53505q;
    @Inject

    /* renamed from: r  reason: collision with root package name */
    public MapsInitializer f53506r;
    private Button refineLocationBtn;
    private boolean resPolygonServiceEnabled;
    @Inject

    /* renamed from: s  reason: collision with root package name */
    public CameraUpdateFactory f53507s;
    private Button saveAddress;
    /* access modifiers changed from: private */
    public int selectedAddressPosition;
    private String streetField = "";
    private boolean streetPresentInMap = false;
    /* access modifiers changed from: private */
    public String suggestName = "";

    /* renamed from: t  reason: collision with root package name */
    public String f53508t;

    /* renamed from: u  reason: collision with root package name */
    public int f53509u;
    private String userSelectedCountryDialCode = "";

    /* renamed from: v  reason: collision with root package name */
    public LatLng f53510v;

    /* renamed from: w  reason: collision with root package name */
    public int f53511w = 0;

    /* renamed from: x  reason: collision with root package name */
    public String[] f53512x;

    /* renamed from: y  reason: collision with root package name */
    public ArrayList<String> f53513y;

    /* renamed from: z  reason: collision with root package name */
    public Spinner f53514z;

    private String SelectAreaName() {
        if (!TalabatUtils.isNullOrEmpty(this.SELECTED_AREA_NAME)) {
            return this.SELECTED_AREA_NAME;
        }
        return GlobalDataModel.SelectedAreaName;
    }

    private void addTextChangeListener() {
        this.field1.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                AddAddressScreen2.this.addressNameOptionalHint.setTextColor(AddAddressScreen2.this.f53509u);
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.field2.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                AddAddressScreen2.this.field2Hint.setTextColor(AddAddressScreen2.this.f53509u);
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.field3.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                AddAddressScreen2.this.field3Hint.setTextColor(AddAddressScreen2.this.f53509u);
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.field4.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                AddAddressScreen2.this.field4Hint.setTextColor(AddAddressScreen2.this.f53509u);
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.field5.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                AddAddressScreen2.this.field5Hint.setTextColor(AddAddressScreen2.this.f53509u);
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.field6.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                AddAddressScreen2.this.field6Hint.setTextColor(AddAddressScreen2.this.f53509u);
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.field7.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                AddAddressScreen2.this.field7Hint.setTextColor(AddAddressScreen2.this.f53509u);
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.mobileText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (obj.contains(" ")) {
                    obj.replaceAll(" ", "");
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                AddAddressScreen2.this.hiddenMobile.setText(charSequence);
                AddAddressScreen2.this.hiddenMobile.setTextColor(-1);
                if (AddAddressScreen2.this.mobileArabicErrorText != null) {
                    AddAddressScreen2.this.mobileArabicErrorText.setVisibility(8);
                }
            }
        });
        this.mobileText.setOnFocusChangeListener(new o(this));
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
                AddAddressScreen2.this.hiddenPhone.setText(charSequence);
                AddAddressScreen2.this.hiddenPhone.setTextColor(-1);
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
    }

    private void animateLocation(LatLng latLng) {
        FrameworkMap frameworkMap = this.mMap;
        if (frameworkMap != null && latLng != null) {
            frameworkMap.animateCamera(this.f53507s.newLatLngZoom(latLng, frameworkMap.getMaxZoomLevel() - 5.0f));
        }
    }

    private boolean blockMatching(String str, String str2) {
        if (TalabatUtils.isNullOrEmpty(str) || TalabatUtils.isNullOrEmpty(str2) || !str.equals(str2)) {
            return false;
        }
        return true;
    }

    private boolean canChangeHouseToVilla() {
        return this.f53503o.getFeatureFlag(TalabatFeatureFlagConstants.EGYPT_ADDRESS_FORM_LABEL_CHANGES, false);
    }

    private boolean canSetIraqCountryCode(@NonNull Country country) {
        MutableLocationConfigurationRepository mutableLocationConfigurationRepository = this.f53499k;
        Country country2 = Country.IRAQ;
        return mutableLocationConfigurationRepository.shouldEnableCountry(country2) && country == country2;
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

    private void clearCart() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        String replace = getString(R.string.already_has_items_in_cart).replace("#", Cart.getInstance().getRestaurant().f13873name + " - " + Cart.getInstance().getCartAreaName());
        builder.setTitle((int) R.string.clear_cart_alert_title);
        builder.setMessage((CharSequence) replace);
        builder.setPositiveButton((int) R.string.yes, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                Cart.getInstance().clearCart(AddAddressScreen2.this);
                AddAddressScreen2.this.startLodingPopup();
                AddAddressScreen2.this.addressPresenter.deleteCurrentAddress();
            }
        });
        builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    private boolean clearCartGrlAddressIfItemAddedToCart(String str, boolean z11) {
        Address address;
        Object obj;
        if (!TalabatUtils.isNullOrEmpty(str)) {
            Gson gson = UniversalGson.INSTANCE.gson;
            Class cls = Address.class;
            if (!(gson instanceof Gson)) {
                obj = gson.fromJson(str, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson, str, cls);
            }
            address = (Address) obj;
        } else {
            address = null;
        }
        if (z11 || address == null) {
            return false;
        }
        Cart instance = Cart.getInstance();
        if (!instance.hasItems() || !instance.getRestaurant().isGlrEnabled || Customer.getInstance().getSelectedCustomerAddress() == null || !Customer.getInstance().getSelectedCustomerAddress().f58343id.equals(address.f58343id)) {
            return false;
        }
        if (TalabatUtils.isMcdInforMapEnabledCountry()) {
            if (!TalabatUtils.isNullOrEmpty(Customer.getInstance().getSelectedCustomerAddress().getGrlId()) && !TalabatUtils.isNullOrEmpty(address.getGrlId())) {
                return grlMatching(Customer.getInstance().getSelectedCustomerAddress().getGrlId(), address.getGrlId());
            }
            if (McdMapTempAddress.getInstance().getSelectedGrlTempAddress() == null || TalabatUtils.isNullOrEmpty(McdMapTempAddress.getInstance().getSelectedGrlTempAddress().getGrlId()) || TalabatUtils.isNullOrEmpty(address.getGrlId())) {
                return false;
            }
            return grlMatching(Customer.getInstance().getSelectedCustomerAddress().getGrlId(), address.getGrlId());
        } else if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
            if (!TalabatUtils.isNullOrEmpty(Customer.getInstance().getSelectedCustomerAddress().block) && !TalabatUtils.isNullOrEmpty(address.block)) {
                return blockMatching(Customer.getInstance().getSelectedCustomerAddress().block, address.block);
            }
            if (McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress() == null || TalabatUtils.isNullOrEmpty(McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress().block) || TalabatUtils.isNullOrEmpty(address.block)) {
                return false;
            }
            return blockMatching(Customer.getInstance().getSelectedCustomerAddress().block, address.block);
        } else if (TalabatUtils.isMcdLatLngEnabledCountry()) {
            return true;
        } else {
            return false;
        }
    }

    private LatLngBounds countryLatLangBound() {
        int countryId = this.f53498j.selectedCountry().getCountryId();
        if (countryId == Country.KUWAIT.getCountryId()) {
            LatLngFactory latLngFactory = this.f53505q;
            return latLngFactory.createLatLngBounds(latLngFactory.createLatLng(28.408312587374258d, 46.395263671875d), this.f53505q.createLatLng(30.261439550638762d, 48.85345458984374d));
        } else if (countryId == Country.KSA.getCountryId()) {
            LatLngFactory latLngFactory2 = this.f53505q;
            return latLngFactory2.createLatLngBounds(latLngFactory2.createLatLng(5.834616165610059d, 25.3125d), this.f53505q.createLatLng(46.31658418182218d, 66.26953125d));
        } else if (countryId == Country.BAHRAIN.getCountryId()) {
            LatLngFactory latLngFactory3 = this.f53505q;
            return latLngFactory3.createLatLngBounds(latLngFactory3.createLatLng(25.611809521055477d, 50.07019042968749d), this.f53505q.createLatLng(26.745610382199022d, 50.8282470703125d));
        } else if (countryId == Country.QATAR.getCountryId()) {
            LatLngFactory latLngFactory4 = this.f53505q;
            return latLngFactory4.createLatLngBounds(latLngFactory4.createLatLng(23.96115620034201d, 50.548095703125d), this.f53505q.createLatLng(26.61799672211676d, 51.6961669921875d));
        } else if (countryId == Country.OMAN.getCountryId()) {
            LatLngFactory latLngFactory5 = this.f53505q;
            return latLngFactory5.createLatLngBounds(latLngFactory5.createLatLng(14.370833973406821d, 48.09814453125d), this.f53505q.createLatLng(28.671310915880834d, 62.314453125d));
        } else if (countryId == Country.UAE.getCountryId()) {
            LatLngFactory latLngFactory6 = this.f53505q;
            return latLngFactory6.createLatLngBounds(latLngFactory6.createLatLng(18.239134d, 47.746582d), this.f53505q.createLatLng(29.806987d, 58.590088d));
        } else if (countryId != Country.IRAQ.getCountryId()) {
            return null;
        } else {
            LatLngFactory latLngFactory7 = this.f53505q;
            return latLngFactory7.createLatLngBounds(latLngFactory7.createLatLng(18.239134d, 47.746582d), this.f53505q.createLatLng(36.190236d, 44.008696d));
        }
    }

    private void deleteAddressAlert() {
        this.addressPresenter.onDeleteAddressPopUpShown();
        new AlertDialog.Builder(this).setTitle(R.string.delete_address).setMessage(R.string.delete_address_message).setPositiveButton(R.string.yes, new h0(this)).setNegativeButton(R.string.f54880no, new d(this)).show();
    }

    private void disableEditText(MaterialEditText materialEditText, boolean z11) {
        if (this.isGrlEnabled) {
            materialEditText.setFocusable(z11);
            materialEditText.setEnabled(z11);
            materialEditText.setFocusableInTouchMode(z11);
            materialEditText.setCursorVisible(z11);
            return;
        }
        materialEditText.setFocusableInTouchMode(true);
        materialEditText.setFocusable(true);
        materialEditText.setEnabled(true);
        materialEditText.setCursorVisible(true);
    }

    private void findViews() {
        this.backButton = (ImageButton) findViewById(R.id.back);
        this.gpsView = findViewById(R.id.gps_view);
        this.refineLocationBtn = (Button) findViewById(R.id.refine_btn);
        this.deleteAddress = (Button) findViewById(R.id.delete_address);
        this.addressTypeEditText = (MaterialEditText) findViewById(R.id.etAddressType);
        this.addressTypeSpinnerview = findViewById(R.id.address_type_spinner_view);
        this.addressType = (TalabatSpinner) findViewById(R.id.address_type_spinner);
        this.city = (MaterialEditText) findViewById(R.id.etCity);
        this.cityView = findViewById(R.id.add_cityView);
        this.area = (MaterialEditText) findViewById(R.id.etArea);
        this.saveAddress = (Button) findViewById(R.id.save_address_btn);
        this.f53514z = (Spinner) findViewById(R.id.country_code_spinner);
        this.field1View = findViewById(R.id.field1_view);
        this.field2View = findViewById(R.id.field2_view);
        this.field3View = findViewById(R.id.field3_view);
        this.field4View = findViewById(R.id.field4_view);
        this.field5View = findViewById(R.id.field5_view);
        this.field6View = findViewById(R.id.field6_view);
        this.field7View = findViewById(R.id.field7_view);
        this.addressNameOptionalHint = (TextView) findViewById(R.id.address_name_optional_field_hint);
        this.field2Hint = (TextView) findViewById(R.id.field2_text);
        this.field3Hint = (TextView) findViewById(R.id.field3_text);
        this.field4Hint = (TextView) findViewById(R.id.field4_text);
        this.field5Hint = (TextView) findViewById(R.id.field5_text);
        this.field6Hint = (TextView) findViewById(R.id.field6_text);
        this.field7Hint = (TextView) findViewById(R.id.field7_text);
        this.field8Hint = (TextView) findViewById(R.id.field8_text);
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
        this.countryCodeLayout = (RelativeLayout) findViewById(R.id.countryCodeLayout);
    }

    private boolean getCountryCodeType(String str) {
        this.allCountriesList = new ArrayList<>();
        this.f53513y = new ArrayList<>();
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
                countryCode.isGccCountry = optBoolean;
                countryCode.dialCode = optString;
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

    private boolean grlMatching(String str, String str2) {
        if (TalabatUtils.isNullOrEmpty(str) || TalabatUtils.isNullOrEmpty(str2) || !str.equals(str2)) {
            return false;
        }
        return true;
    }

    private void handleIntent() {
        this.f53509u = Color.parseColor("#404040");
        this.isFromFlutter = getIntent().getBooleanExtra("isFromFlutter", false);
        this.isForEdit = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.EDIT, false);
        this.noAreaChange = getIntent().getBooleanExtra("noAreaChange", false);
        this.eventOrigin = getIntent().getStringExtra("eventOrigin");
        this.isOrderFlow = getIntent().getBooleanExtra("isOrderFlow", false);
        this.isFromCheckout = getIntent().getBooleanExtra("isFromCheckout", false);
        this.autofillAddressView = findViewById(R.id.autofill_address_mainLayout);
        this.mobileArabicErrorText = (TalabatTextView) findViewById(R.id.arabic_error_txt);
        this.isMapcompulsory = getIntent().getBooleanExtra("map_compulsory", false);
        this.isNineCookiesTrackingEnabled = getIntent().getBooleanExtra("nineCookiesEnabled", false);
        this.isAddressFromCartOrderFlow = getIntent().getBooleanExtra("isAddressFromCartOrderFlow", false);
        this.isNewAddressFromCartFlow = getIntent().getBooleanExtra("isNewAddressFromCartOrderFlow", false);
        this.isAddAddressFromCheckout = getIntent().getBooleanExtra(GlobalConstants.FORCE_MAP.IS_ADD_ADDRESS_FROM_CHECKOUT, false);
        this.isNewAddressCreation = getIntent().getBooleanExtra("newaddressCreation", false);
        this.isMapFromSideMenu = getIntent().getBooleanExtra(GlobalConstants.FORCE_MAP.MAP_FROM_SIDEMENU, false);
        this.isTalabatDeliveryAvailable = getIntent().getBooleanExtra("talabatDeliveryAvailable", false);
        this.isEditAddressFromSideMenu = getIntent().getBooleanExtra(GlobalConstants.FORCE_MAP.IS_EDIT_ADDRESS_FROM_SIDE_MENU, false);
        this.isGrlEnabled = getIntent().getBooleanExtra("isGlrEnabledRes", false);
        this.isGlrEnableAddNewAddress = getIntent().getBooleanExtra(GlobalConstants.INFOR_MAP.IS_FROM_MCD_NEW_ADDRESS_CHECKOUT, false);
        this.isTitleCorrection = getIntent().getBooleanExtra(GlobalConstants.INFOR_MAP.IS_TITLE_CORRECTION, false);
        this.isNewAddressCreationGlrFlow = getIntent().getBooleanExtra("isNewAddressCreationFromGrlFlow", false);
        this.isFromMcdAddressFlow = getIntent().getBooleanExtra("isFromMcdAddressFlow", false);
        this.isFromMapFirstFlow = getIntent().getBooleanExtra("isFromHomeScreenMap", false);
        this.isEditAddressFromCheckoutScreen = getIntent().getBooleanExtra("isEditAddressFlowFromCheckout", false);
    }

    private void handleSelectAddressAutomatic(boolean z11, boolean z12, boolean z13, boolean z14, String str, String str2) {
        Object obj;
        Object obj2;
        this.addressPresenter.setMcdLoactionEdited(z12);
        this.isForEdit = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.EDIT, false);
        this.isNineCookiesTrackingEnabled = getIntent().getBooleanExtra("nineCookiesEnabled", false);
        this.isMapcompulsory = getIntent().getBooleanExtra("map_compulsory", false);
        this.isNineCookiesTrackingEnabled = getIntent().getBooleanExtra("nineCookiesEnabled", false);
        this.isTalabatDeliveryAvailable = getIntent().getBooleanExtra("talabatDeliveryAvailable", false);
        this.isAddressFromCartOrderFlow = getIntent().getBooleanExtra("isAddressFromCartOrderFlow", false);
        this.isNewAddressCreation = getIntent().getBooleanExtra("newaddressCreation", false);
        this.isMapFromSideMenu = z14;
        this.isEditAddressFromSideMenu = getIntent().getBooleanExtra(GlobalConstants.FORCE_MAP.IS_EDIT_ADDRESS_FROM_SIDE_MENU, false);
        Class cls = Address.class;
        Address address = null;
        if (TalabatUtils.isAddressBlockEnabledCountry()) {
            this.f53508t = str;
            if (!TalabatUtils.isNullOrEmpty(str)) {
                Gson gson = UniversalGson.INSTANCE.gson;
                String str3 = this.f53508t;
                if (!(gson instanceof Gson)) {
                    obj2 = gson.fromJson(str3, cls);
                } else {
                    obj2 = GsonInstrumentation.fromJson(gson, str3, cls);
                }
                address = (Address) obj2;
                address.type = this.selectedAddressPosition;
            }
            if (!TalabatUtils.isNullOrEmpty(str2)) {
                String[] split = str2.split(",");
                LatLng createLatLng = this.f53505q.createLatLng(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
                this.f53510v = createLatLng;
                if (!(address == null || createLatLng == null)) {
                    address.latitude = createLatLng.getLatitude();
                    address.longitude = this.f53510v.getLongitude();
                }
            }
        } else if (this.resPolygonServiceEnabled) {
            this.f53508t = str;
        } else {
            boolean z15 = this.isNewAddressCreation;
            if (z15 && this.isAddressFromCartOrderFlow) {
                this.f53508t = "";
            } else if (!z15 || this.isAddressFromCartOrderFlow || !z14) {
                this.f53508t = str;
            } else {
                this.f53508t = str;
            }
        }
        if (!TalabatUtils.isNullOrEmpty(this.f53508t)) {
            Gson gson2 = UniversalGson.INSTANCE.gson;
            String str4 = this.f53508t;
            if (!(gson2 instanceof Gson)) {
                obj = gson2.fromJson(str4, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson2, str4, cls);
            }
            address = (Address) obj;
            address.type = this.selectedAddressPosition;
        }
        if (!TalabatUtils.isNullOrEmpty(str2)) {
            String[] split2 = str2.split(",");
            LatLng createLatLng2 = this.f53505q.createLatLng(Double.parseDouble(split2[0]), Double.parseDouble(split2[1]));
            this.f53510v = createLatLng2;
            if (!(address == null || createLatLng2 == null)) {
                address.latitude = createLatLng2.getLatitude();
                address.longitude = this.f53510v.getLongitude();
            }
        }
        this.fromMap = true;
        if (address != null) {
            this.blockPresentInMap = !TalabatUtils.isNullOrEmpty(address.block);
            boolean z16 = !TalabatUtils.isNullOrEmpty(address.street);
            this.streetPresentInMap = z16;
            if (this.blockPresentInMap) {
                this.blockField = address.block;
            }
            if (z16) {
                this.streetField = address.street;
            }
        }
        this.addressPresenter.addressFromMapRecieved(address, z13, TalabatUtils.isAddressBlockEnabledCountry(), this.isEditAddressFromSideMenu);
        if (!z11) {
            LatLng latLng = this.f53510v;
            if (latLng == null && (latLng = GlobalDataModel.GEO_CORDINATES.addressPageLatLang) == null && (latLng = this.mapaddressLatlang) == null) {
                latLng = defaultLatLang();
            }
            animateLocation(latLng);
        }
    }

    private boolean isNeedAddtionalHint(String str) {
        Country selectedCountry = this.f53498j.selectedCountry();
        if (selectedCountry == Country.KUWAIT) {
            if (str.toString().equals("+965")) {
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
        } else if (selectedCountry != Country.JORDAN || !str.equals("+962")) {
            return false;
        } else {
            return true;
        }
        return false;
    }

    private boolean isSelectedCountryEgypt(@NonNull Country country) {
        MutableLocationConfigurationRepository mutableLocationConfigurationRepository = this.f53499k;
        Country country2 = Country.EGYPT;
        return mutableLocationConfigurationRepository.shouldEnableCountry(country2) && country == country2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addTextChangeListener$29(View view, boolean z11) {
        if (z11) {
            if (this.mobileText.getText().toString().length() > 0) {
                String obj = this.mobileText.getText().toString();
                if (obj.contains(" ")) {
                    this.mobileText.setText(obj.replaceAll(" ", ""));
                }
            }
        } else if (this.mobileText.getText().toString().length() > 0) {
            String obj2 = this.mobileText.getText().toString();
            if (obj2.contains(" ")) {
                this.mobileText.setText(obj2.replaceAll(" ", ""));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteAddressAlert$30(DialogInterface dialogInterface, int i11) {
        this.addressPresenter.onDeleteAddresYesClicked();
        startLodingPopup();
        this.addressPresenter.deleteCurrentAddress();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteAddressAlert$31(DialogInterface dialogInterface, int i11) {
        this.addressPresenter.onDeleteAddresNoClicked();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        this.saveAddress.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        this.addressPresenter.onDeleteAddressBtnClicked();
        if (!TalabatUtils.isMcdInforMapEnabledCountry() && !TalabatUtils.isMcdBlockMenuEnabledCountry() && !TalabatUtils.isMcdLatLngEnabledCountry()) {
            deleteAddressAlert();
        } else if (clearCartGrlAddressIfItemAddedToCart(this.f53508t, this.isAddressFromCartOrderFlow)) {
            clearCart();
        } else {
            deleteAddressAlert();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        this.addressTypeEditText.setText("");
        this.addressTypeSpinnerview.setVisibility(0);
        this.addressType.setVisibility(0);
        this.addressType.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        if (TalabatUtils.isNullOrEmpty(this.field1.getText().toString())) {
            this.field1.setText("");
        }
        this.addressPresenter.validateAndAddAddress(this.isEditAddressFromSideMenu, this.isForEdit);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$4(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 5) {
            return false;
        }
        if (this.isForEdit) {
            MaterialEditText materialEditText = this.field2;
            materialEditText.setSelection(materialEditText.getText().length());
        }
        this.field2.requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$5(Country country, TextView textView, int i11, KeyEvent keyEvent) {
        boolean z11;
        boolean z12;
        if (i11 != 5) {
            return false;
        }
        if (country == Country.UAE) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (country == Country.KSA) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12 || z11) {
            this.field2.requestFocus();
            MaterialEditText materialEditText = this.field2;
            materialEditText.setSelection(materialEditText.getText().length());
            this.isCityNextClicked = false;
        } else {
            if (this.isForEdit) {
                MaterialEditText materialEditText2 = this.field2;
                materialEditText2.setSelection(materialEditText2.getText().length());
            }
            this.field2.requestFocus();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$6(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 5) {
            return false;
        }
        this.area.requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$7(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 5) {
            return false;
        }
        this.field2.requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCreate$8(LatLng latLng) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$9(FrameworkMap frameworkMap) {
        frameworkMap.getUiSettings().setScrollGesturesEnabled(false);
        this.mMap = frameworkMap;
        frameworkMap.setLatLngBoundsForCameraTarget(countryLatLangBound());
        LatLng latLng = this.mapaddressLatlang;
        if (latLng == null) {
            latLng = defaultLatLang();
        }
        this.mapHighlightLocation = latLng;
        animateLocation(latLng);
        frameworkMap.setOnMapClickListener(new z());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setImeOptionAndEditorActionListener$20(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 6) {
            return false;
        }
        this.saveAddress.performClick();
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setImeOptionAndEditorActionListener$21(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 5) {
            return false;
        }
        if (this.isForEdit) {
            MaterialEditText materialEditText = this.field3;
            materialEditText.setSelection(materialEditText.getText().length());
        }
        this.field3.requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setImeOptionAndEditorActionListener$22(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 5) {
            return false;
        }
        if (this.fldCount == 3) {
            if (!this.directionsText.getText().toString().isEmpty()) {
                MaterialEditText materialEditText = this.directionsText;
                materialEditText.setSelection(materialEditText.getText().length());
            }
            this.directionsText.requestFocus();
            return true;
        }
        MaterialEditText materialEditText2 = this.field4;
        materialEditText2.setSelection(materialEditText2.getText().length());
        this.field4.requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setImeOptionAndEditorActionListener$23(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 5) {
            return false;
        }
        if (this.fldCount == 4) {
            if (!this.directionsText.getText().toString().isEmpty()) {
                MaterialEditText materialEditText = this.directionsText;
                materialEditText.setSelection(materialEditText.getText().length());
            }
            this.directionsText.requestFocus();
            return true;
        }
        MaterialEditText materialEditText2 = this.field5;
        materialEditText2.setSelection(materialEditText2.getText().length());
        this.field5.requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setImeOptionAndEditorActionListener$24(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 5) {
            return false;
        }
        if (this.fldCount == 5) {
            if (!this.directionsText.getText().toString().isEmpty()) {
                MaterialEditText materialEditText = this.directionsText;
                materialEditText.setSelection(materialEditText.getText().length());
            }
            this.directionsText.requestFocus();
            return true;
        }
        MaterialEditText materialEditText2 = this.field6;
        materialEditText2.setSelection(materialEditText2.getText().length());
        this.field6.requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setImeOptionAndEditorActionListener$25(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 5) {
            return false;
        }
        if (this.fldCount == 6) {
            if (!this.directionsText.getText().toString().isEmpty()) {
                MaterialEditText materialEditText = this.directionsText;
                materialEditText.setSelection(materialEditText.getText().length());
            }
            this.directionsText.requestFocus();
            return true;
        }
        MaterialEditText materialEditText2 = this.field7;
        materialEditText2.setSelection(materialEditText2.getText().length());
        this.field7.requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setImeOptionAndEditorActionListener$26(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 5) {
            return false;
        }
        MaterialEditText materialEditText = this.directionsText;
        materialEditText.setSelection(materialEditText.getText().length());
        this.directionsText.requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setImeOptionAndEditorActionListener$27(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 5) {
            return false;
        }
        if (this.isForEdit) {
            MaterialEditText materialEditText = this.mobileText;
            materialEditText.setSelection(materialEditText.getText().length());
        }
        this.mobileText.requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setImeOptionAndEditorActionListener$28(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 5) {
            return false;
        }
        if (this.isForEdit) {
            MaterialEditText materialEditText = this.phoneText;
            materialEditText.setSelection(materialEditText.getText().length());
        }
        this.phoneText.requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewOnClickListener$10(View view) {
        this.hiddenPhone.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewOnClickListener$11(String str, String str2, String str3) {
        this.phoneCountryCode.setText(str2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewOnClickListener$12(View view) {
        CountryCodePicker newInstance = CountryCodePicker.newInstance("Select Country", false);
        newInstance.setListener(new a0(this));
        newInstance.show(getSupportFragmentManager(), "COUNTRY_CODE_PICKER");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewOnClickListener$13(View view) {
        if (TalabatUtils.isInterantionalCountryCodeVerificationEnabledCountry(this.f53498j, this.f53499k)) {
            chooseCountryCodeScreen();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewOnClickListener$14(View view) {
        if (TalabatUtils.isInterantionalCountryCodeVerificationEnabledCountry(this.f53498j, this.f53499k)) {
            chooseCountryCodeScreen();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewOnClickListener$15(View view) {
        GlobalDataModel.GEO_CORDINATES.saveTempZoomLevel = 0.0f;
        GlobalDataModel.GEO_CORDINATES.isUserInteractedWithMapLocation = false;
        GlobalDataModel.HOME_SCREEN_MAP.CONFIRMED_LOCATION_AWARNESS = false;
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewOnClickListener$16(View view) {
        AppTracker.onGeoLocationButtonClicked(getContext());
        getLocationData();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewOnClickListener$17(View view) {
        if (!this.noAreaChange) {
            Intent intent = new Intent(this, ChooseCityScreen.class);
            intent.putExtra(GlobalConstants.ExtraNames.SAVE, false);
            intent.putExtra("highlightCityId", this.SELECTED_CITY);
            startActivityForResult(intent, 20);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewOnClickListener$18(View view) {
        if (!this.noAreaChange && !this.isGrlEnabled) {
            this.addressPresenter.areaButtonClicked();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewOnClickListener$19(View view) {
        preRedirectCheck();
        this.addressPresenter.showMapForSelection(false);
    }

    private void onActivityResultChooseCountryCode(int i11, Intent intent) {
        if (i11 == -1 && intent != null) {
            this.userSelectedCountryDialCode = intent.getStringExtra(GlobalConstants.CHOOSE_COUNTRY_CODE.COUNTRY_DIAL_CODE);
            intent.getStringExtra("countrycode");
            intent.getBooleanExtra(GlobalConstants.CHOOSE_COUNTRY_CODE.COUNTRY_GCC, false);
        }
        setUserSelectedCountryCode(this.userSelectedCountryDialCode);
        usePhoneNumberHintValidation(getCountryCodeCountryGcc());
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onActivityResultSelectAddressAutomatically(int r11, android.content.Intent r12) {
        /*
            r10 = this;
            r0 = -1
            java.lang.String r1 = "mapFromSideMenu"
            r2 = 0
            if (r11 != r0) goto L_0x0069
            if (r12 == 0) goto L_0x0069
            java.lang.String r11 = "location"
            java.lang.String r0 = r12.getStringExtra(r11)
            boolean r3 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r0)
            if (r3 != 0) goto L_0x0040
            java.lang.String r3 = ","
            java.lang.String[] r0 = r0.split(r3)
            com.talabat.maps.domain.LatLngFactory r3 = r10.f53505q
            r4 = r0[r2]
            double r4 = java.lang.Double.parseDouble(r4)
            r6 = 1
            r0 = r0[r6]
            double r6 = java.lang.Double.parseDouble(r0)
            com.talabat.maps.domain.model.LatLng r0 = r3.createLatLng(r4, r6)
            r10.f53510v = r0
            if (r0 == 0) goto L_0x0040
            double r3 = r0.getLatitude()
            com.talabat.maps.domain.model.LatLng r0 = r10.f53510v
            double r5 = r0.getLongitude()
            boolean r0 = r10.redirectToFlutterAddNewAddressScreen(r3, r5)
            goto L_0x0041
        L_0x0040:
            r0 = r2
        L_0x0041:
            if (r0 != 0) goto L_0x00b9
            java.lang.String r0 = "skip"
            boolean r4 = r12.getBooleanExtra(r0, r2)
            java.lang.String r0 = "is_mcd_ksa_location_updated"
            boolean r5 = r12.getBooleanExtra(r0, r2)
            java.lang.String r0 = "locationmissmatch"
            boolean r6 = r12.getBooleanExtra(r0, r2)
            boolean r7 = r12.getBooleanExtra(r1, r2)
            java.lang.String r0 = "address"
            java.lang.String r8 = r12.getStringExtra(r0)
            java.lang.String r9 = r12.getStringExtra(r11)
            r3 = r10
            r3.handleSelectAddressAutomatic(r4, r5, r6, r7, r8, r9)
            goto L_0x00b9
        L_0x0069:
            if (r11 != 0) goto L_0x00b9
            android.content.Intent r11 = r10.getIntent()
            if (r11 == 0) goto L_0x00b9
            android.content.Intent r11 = r10.getIntent()
            java.lang.String r0 = "map_compulsory"
            boolean r11 = r11.getBooleanExtra(r0, r2)
            r10.isMapcompulsory = r11
            android.content.Intent r11 = r10.getIntent()
            java.lang.String r0 = "nineCookiesEnabled"
            boolean r11 = r11.getBooleanExtra(r0, r2)
            r10.isNineCookiesTrackingEnabled = r11
            android.content.Intent r11 = r10.getIntent()
            java.lang.String r0 = "talabatDeliveryAvailable"
            boolean r11 = r11.getBooleanExtra(r0, r2)
            r10.isTalabatDeliveryAvailable = r11
            android.content.Intent r11 = r10.getIntent()
            boolean r11 = r11.getBooleanExtra(r1, r2)
            r10.isMapFromSideMenu = r11
            android.content.Intent r11 = r10.getIntent()
            java.lang.String r0 = "isEditAddressFromSideMenu"
            boolean r11 = r11.getBooleanExtra(r0, r2)
            r10.isEditAddressFromSideMenu = r11
            if (r12 == 0) goto L_0x00b6
            java.lang.String r11 = "isForEdit"
            boolean r11 = r12.getBooleanExtra(r11, r2)
            r10.isForEdit = r11
        L_0x00b6:
            r10.finish()
        L_0x00b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.AddAddressScreen2.onActivityResultSelectAddressAutomatically(int, android.content.Intent):void");
    }

    private void onActivityResultSelectAddressManually(int i11, Intent intent) {
        Address address;
        Object obj;
        if (i11 == -1 && intent != null) {
            boolean booleanExtra = intent.getBooleanExtra(GlobalConstants.FORCE_MAP.LOCATION_MIS_MATCH, false);
            this.addressPresenter.setMcdLoactionEdited(intent.getBooleanExtra(GlobalConstants.INFOR_MAP.IS_MCD_KSA_UPDATE_LOCATION, false));
            this.isForEdit = intent.getBooleanExtra(GlobalConstants.ExtraNames.EDIT, false);
            this.isNewAddressCreation = getIntent().getBooleanExtra("newaddressCreation", false);
            this.isMapcompulsory = getIntent().getBooleanExtra("map_compulsory", false);
            this.isNineCookiesTrackingEnabled = getIntent().getBooleanExtra("nineCookiesEnabled", false);
            this.isTalabatDeliveryAvailable = getIntent().getBooleanExtra("talabatDeliveryAvailable", false);
            this.isAddressFromCartOrderFlow = getIntent().getBooleanExtra("isAddressFromCartOrderFlow", false);
            this.isMapFromSideMenu = intent.getBooleanExtra(GlobalConstants.FORCE_MAP.MAP_FROM_SIDEMENU, false);
            this.isEditAddressFromSideMenu = getIntent().getBooleanExtra(GlobalConstants.FORCE_MAP.IS_EDIT_ADDRESS_FROM_SIDE_MENU, false);
            boolean booleanExtra2 = intent.getBooleanExtra("skip", false);
            String stringExtra = intent.getStringExtra("location");
            if (!TalabatUtils.isNullOrEmpty(stringExtra)) {
                String[] split = stringExtra.split(",");
                LatLng createLatLng = this.f53505q.createLatLng(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
                this.f53510v = createLatLng;
                if (createLatLng != null && redirectToFlutterAddNewAddressScreen(createLatLng.getLatitude(), this.f53510v.getLongitude())) {
                    return;
                }
            }
            if (TalabatUtils.isAddressBlockEnabledCountry()) {
                this.f53508t = intent.getStringExtra("address");
            } else if (this.resPolygonServiceEnabled) {
                this.f53508t = intent.getStringExtra("address");
            } else {
                boolean z11 = this.isNewAddressCreation;
                if (!z11 || !this.isAddressFromCartOrderFlow) {
                    if (z11 && !this.isAddressFromCartOrderFlow && this.isMapFromSideMenu) {
                        this.f53508t = intent.getStringExtra("address");
                    } else if (this.isForEdit) {
                        this.f53508t = "";
                    } else {
                        this.f53508t = intent.getStringExtra("address");
                    }
                } else if (this.isForEdit) {
                    this.f53508t = "";
                } else {
                    this.f53508t = intent.getStringExtra("address");
                }
            }
            if (!TalabatUtils.isNullOrEmpty(this.f53508t)) {
                Gson gson = UniversalGson.INSTANCE.gson;
                String str = this.f53508t;
                Class cls = Address.class;
                if (!(gson instanceof Gson)) {
                    obj = gson.fromJson(str, cls);
                } else {
                    obj = GsonInstrumentation.fromJson(gson, str, cls);
                }
                address = (Address) obj;
                address.type = this.selectedAddressPosition;
            } else {
                address = null;
            }
            this.fromMap = true;
            if (address != null) {
                this.blockPresentInMap = !TalabatUtils.isNullOrEmpty(address.block);
                boolean z12 = !TalabatUtils.isNullOrEmpty(address.street);
                this.streetPresentInMap = z12;
                if (this.blockPresentInMap) {
                    this.blockField = address.block;
                }
                if (z12) {
                    this.streetField = address.street;
                }
            }
            this.addressPresenter.addressFromMapRecieved(address, booleanExtra, TalabatUtils.isAddressBlockEnabledCountry(), this.isEditAddressFromSideMenu);
            if (!booleanExtra2) {
                LatLng latLng = this.f53510v;
                if (latLng == null && (latLng = GlobalDataModel.GEO_CORDINATES.addressPageLatLang) == null && (latLng = this.mapaddressLatlang) == null) {
                    latLng = defaultLatLang();
                }
                animateLocation(latLng);
            }
        } else if (i11 == 0 && getIntent() != null) {
            this.isMapcompulsory = getIntent().getBooleanExtra("map_compulsory", false);
            this.isNineCookiesTrackingEnabled = getIntent().getBooleanExtra("nineCookiesEnabled", false);
            this.isTalabatDeliveryAvailable = getIntent().getBooleanExtra("talabatDeliveryAvailable", false);
            this.isMapFromSideMenu = getIntent().getBooleanExtra(GlobalConstants.FORCE_MAP.MAP_FROM_SIDEMENU, false);
            this.isEditAddressFromSideMenu = getIntent().getBooleanExtra(GlobalConstants.FORCE_MAP.IS_EDIT_ADDRESS_FROM_SIDE_MENU, false);
            this.isForEdit = getIntent().getBooleanExtra("isEdit", false);
            if ((this.isAddressFromCartOrderFlow && this.isNineCookiesTrackingEnabled) || u0()) {
                finish();
            }
        }
    }

    private void onActivityResultSelectArea(int i11, Intent intent) {
        if (i11 == -1 && intent != null) {
            this.SELECTED_AREA = intent.getIntExtra(GlobalConstants.ExtraNames.SELECTED_AREA_ID, -1);
            String stringExtra = intent.getStringExtra(GlobalConstants.ExtraNames.SELECTED_AREA_NAME);
            this.SELECTED_AREA_NAME = stringExtra;
            GlobalDataModel.GEO_CORDINATES.isUserInteractedWithMapLocation = false;
            this.area.setText(stringExtra);
            MaterialEditText materialEditText = this.field2;
            materialEditText.setSelection(materialEditText.getText().length());
            this.addressPresenter.invalidateAddressLocation(this.SELECTED_AREA);
            this.hightlightCityId = intent.getIntExtra(GlobalConstants.ExtraNames.SELECTED_CITY_ID, -1);
            this.field2.setFocusableInTouchMode(true);
            this.field2.requestFocus();
            GlobalDataModel.GEO_CORDINATES.ValidateWithareaPolygon = false;
            GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints = null;
            GlobalDataModel.GEO_CORDINATES.areaCenterPoint = null;
            this.addressPresenter.mapMapMarkerPoitingDecesionHandler(this.SELECTED_AREA);
        }
    }

    private void onActivityResultSelectCity(int i11, Intent intent) {
        if (i11 == -1 && intent != null) {
            this.SELECTED_CITY = intent.getIntExtra(GlobalConstants.ExtraNames.SELECTED_CITY_ID, -1);
            this.SELECTED_CITY_NAME = intent.getStringExtra(GlobalConstants.ExtraNames.SELECTED_CITY_NAME);
            this.addressPresenter.citySelected(this.SELECTED_CITY);
            this.SELECTED_AREA = 0;
            this.SELECTED_AREA_NAME = "";
            this.city.setText(this.SELECTED_CITY_NAME);
            this.area.setText("");
            if (!this.noAreaChange && this.isCityNextClicked) {
                this.area.requestFocus();
                this.addressPresenter.areaButtonClicked();
                this.addressPresenter.inValidateCityLocation(this.SELECTED_CITY);
            }
        }
    }

    private void onTrackAddressSubmitted(Address address, String str) {
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
            String str2 = this.mapJourneytype;
            String str3 = this.deliveryAddressStatus;
            String str4 = AppTracker.NotAvail;
            try {
                AddressAnalyticsTracker trackingAddressObject = trackingUtils.getTrackingAddressObject(this, false, address, valueOf, valueOf2, str2, str3, ScreenNames.MAPS_SCREEN, str4, str4, str4, str4, str4, str4, str4, str4, str4, str4, false, str);
                try {
                    AppTracker.onAddressSubmitted(this, GlobalDataModel.SelectedAreaName, "" + GlobalDataModel.SelectedAreaId, trackingAddressObject);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
        }
    }

    private boolean redirectToFlutterAddNewAddressScreen(double d11, double d12) {
        this.f53510v = this.f53505q.createLatLng(d11, d12);
        return u0();
    }

    private void requestPermission(Context context) {
        pauseBannerForNextScreen();
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.ACCESS_FINE_LOCATION")) {
            Toast.makeText(context, R.string.permission_rationale, 1).show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 500);
        }
    }

    private void saveCoordinatesInGlobalDataModel(LatLng latLng) {
        GlobalDataModel.GEO_CORDINATES.saveTempZoomLevel = HomeMapTemp.INSTANCE.getHomeMapSavedZooLevel().floatValue();
        GlobalDataModel.GEO_CORDINATES.addressPageLatLang = latLng;
        GlobalDataModel.GEO_CORDINATES.isUserInteractedWithMapLocation = true;
    }

    private int selectAreaForMap() {
        int i11 = this.SELECTED_AREA;
        if (i11 == -1) {
            return GlobalDataModel.SelectedAreaId;
        }
        return i11;
    }

    private void setContentViewBasedOnExperiment() {
        if (TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.EXPERIMENT_ADDRESS_NICKNAME_REORDER, false, TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            setContentView((int) R.layout.add_address_nickname_at_bottom);
            this.f53502n.track(new LoadedReOrderAddressNickNameLayoutEvent(this.f53498j.selectedCountry()));
            return;
        }
        setContentView((int) R.layout.add_address);
    }

    private void setEditTextProperties(EditText editText, int i11) {
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i11)});
    }

    private void setImeOptionAndEditorActionListener() {
        this.phoneText.setImeOptions(6);
        this.phoneText.setOnEditorActionListener(new e(this));
        this.field2.setImeOptions(5);
        this.field2.setOnEditorActionListener(new f(this));
        this.field3.setImeOptions(5);
        this.field3.setOnEditorActionListener(new g(this));
        this.field4.setImeOptions(5);
        this.field4.setOnEditorActionListener(new h(this));
        this.field5.setImeOptions(5);
        this.field5.setOnEditorActionListener(new i(this));
        this.field6.setImeOptions(5);
        this.field6.setOnEditorActionListener(new j(this));
        this.field7.setImeOptions(5);
        this.field7.setOnEditorActionListener(new k(this));
        this.directionsText.setImeOptions(5);
        this.directionsText.setOnEditorActionListener(new l(this));
        this.mobileText.setOnEditorActionListener(new m(this));
    }

    private void setUserSelectedCountryCode(String str) {
        if (!TalabatUtils.isNullOrEmpty(str)) {
            this.mobileCountryCode.setText(str);
        }
    }

    private void setViewOnClickListener() {
        this.phoneText.setOnClickListener(new p(this));
        this.phoneCountryCode.setOnClickListener(new q(this));
        this.countryCodeLayout.setOnClickListener(new r(this));
        this.mobileCountryCode.setOnClickListener(new s(this));
        this.backButton.setOnClickListener(new t(this));
        this.gpsView.setOnClickListener(new u(this));
        this.city.setOnClickListener(new v(this));
        this.area.setOnClickListener(new w(this));
        this.refineLocationBtn.setOnClickListener(new x(this));
    }

    private void snapMapVisibility() {
        if (!TalabatUtils.isMapPackageEnabledCountry(this.f53498j, this.f53499k) && (!TalabatUtils.isPartiallyMapPackageEnabledCountry() || (!this.isMapcompulsory && !this.isNineCookiesTrackingEnabled))) {
            this.autofillAddressView.setVisibility(8);
        } else if (this.isGrlEnabled) {
            this.autofillAddressView.setVisibility(8);
        } else {
            this.autofillAddressView.setVisibility(0);
        }
    }

    private void sucess() {
        if (!this.isFromFlutter && (this.isOrderFlow || this.isNineCookiesTrackingEnabled || this.isMapcompulsory)) {
            Intent intent = new Intent(this, CheckOutScreen.class);
            Cart.getInstance().setCanShowLoyallyVoucherInCheckOut(true);
            intent.putExtra("isAddressFromCartOrderFlow", this.isAddressFromCartOrderFlow);
            intent.putExtra(GlobalConstants.FORCE_MAP.CHECKOUT_SUCCESS, true);
            intent.putExtra("map_compulsory", this.isMapcompulsory);
            intent.putExtra("nineCookiesEnabled", this.isNineCookiesTrackingEnabled);
            intent.putExtra("talabatDeliveryAvailable", this.isTalabatDeliveryAvailable);
            intent.putExtra(GlobalConstants.FORCE_MAP.CHECKOUT_SUCCESS, true);
            intent.putExtra("isGlrEnabledRes", this.isGrlEnabled);
            intent.putExtra("isNewAddressCreationFromGrlFlow", false);
            intent.putExtra(GlobalConstants.FORCE_MAP.CHECKOUT_SUCCESS, true);
            intent.putExtra("isEditAddressFlowFromCheckout", this.isEditAddressFromCheckoutScreen);
            intent.addFlags(67108864);
            startActivity(intent);
            finish();
        }
        Intent intent2 = new Intent();
        intent2.putExtra(GlobalConstants.FORCE_MAP.CHECKOUT_SUCCESS, true);
        intent2.putExtra("isAddressFromCartOrderFlow", this.isAddressFromCartOrderFlow);
        intent2.putExtra("map_compulsory", this.isMapcompulsory);
        intent2.putExtra("nineCookiesEnabled", this.isNineCookiesTrackingEnabled);
        intent2.putExtra("talabatDeliveryAvailable", this.isTalabatDeliveryAvailable);
        intent2.putExtra("isGlrEnabledRes", this.isGrlEnabled);
        intent2.putExtra("isNewAddressCreationFromGrlFlow", false);
        intent2.putExtra(GlobalConstants.FORCE_MAP.CHECKOUT_SUCCESS, true);
        intent2.putExtra(GlobalConstants.INFOR_MAP.IS_MCD_KSA_UPDATE_IGNORE, false);
        GlobalDataModel.HOME_SCREEN_MAP.CONFIRMED_LOCATION_AWARNESS = false;
        setResult(-1, intent2);
        finish();
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

    /* access modifiers changed from: private */
    public void trackAddressTypeClick() {
        HashMap hashMap = new HashMap();
        hashMap.put("isToEditAddress", Boolean.toString(this.isForEdit));
        hashMap.put("selectedCountryId", "" + this.f53498j.selectedCountry().getCountryId());
        hashMap.put("isEnableAddressFormLabelFeatureOn", Boolean.toString(canChangeHouseToVilla()));
        ObservabilityManager.trackEvent(SCREEN_NAME, "Building Type", UserAction.TAP, (Map<String, String>) hashMap);
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
            String str2 = this.mapJourneytype;
            String str3 = this.deliveryAddressStatus;
            String str4 = AppTracker.NotAvail;
            try {
                try {
                    AppTracker.onAddressErrorShown(this, trackingUtils.getTrackingAddressObject(this, false, address, valueOf, valueOf2, str2, str3, ScreenNames.MAPS_SCREEN, str, str4, str4, str4, str4, str4, str4, str4, str4, str4, false, this.locationMethod));
                } catch (Exception e11) {
                    e = e11;
                }
            } catch (Exception e12) {
                e = e12;
                LogManager.logException(e);
            }
        } catch (Exception e13) {
            e = e13;
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
        if (!TalabatUtils.isNullOrEmpty(this.f53508t)) {
            Gson gson = UniversalGson.INSTANCE.gson;
            String str = this.f53508t;
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
        return UserAddressEventsKt.eventOriginFromAddressScreenState(this.eventOrigin, this.isOrderFlow, this.isAddressFromCartOrderFlow, this.isNewAddressFromCartFlow, this.isMapFromSideMenu, this.isEditAddressFromSideMenu, this.isFromCheckout, this.isEditAddressFromCheckoutScreen, this.isAddAddressFromCheckout, this.isGlrEnableAddNewAddress, this.isNewAddressCreationGlrFlow, this.isFromMcdAddressFlow);
    }

    public void clearFocusFromAllInput() {
        View findViewById = findViewById(R.id.add_address_form_parent);
        if (findViewById != null) {
            findViewById.clearFocus();
        }
    }

    public void compareBlockField(String str) {
        this.newBlockField = str;
    }

    public void compareStreetField(String str) {
        this.newStreetField = str;
    }

    @Nullable
    public LatLng defaultLatLang() {
        Country selectedCountry = this.f53498j.selectedCountry();
        if (selectedCountry == Country.KUWAIT) {
            return t0();
        }
        if (selectedCountry == Country.KSA) {
            return this.f53505q.createLatLng(24.671666d, 46.702881d);
        }
        if (selectedCountry == Country.BAHRAIN) {
            return this.f53505q.createLatLng(26.228516d, 50.58605d);
        }
        if (selectedCountry == Country.QATAR) {
            return this.f53505q.createLatLng(25.285447d, 51.53104d);
        }
        if (selectedCountry == Country.OMAN) {
            return this.f53505q.createLatLng(23.58589d, 58.405923d);
        }
        if (selectedCountry == Country.UAE) {
            return this.f53505q.createLatLng(25.204849d, 55.270783d);
        }
        if (selectedCountry == Country.JORDAN) {
            return this.f53505q.createLatLng(31.945367d, 35.928372d);
        }
        if (selectedCountry == Country.EGYPT) {
            return this.f53505q.createLatLng(30.044422d, 31.235712d);
        }
        if (selectedCountry == Country.IRAQ) {
            return this.f53505q.createLatLng(36.190236d, 44.008696d);
        }
        return null;
    }

    public void deliverToCLRecived(@NotNull com.google.android.gms.maps.model.LatLng latLng) {
    }

    public void destroyPresenter() {
        this.addressPresenter = null;
    }

    public void forceRedirectToMapLogic() {
        if (!TalabatUtils.isMapPackageEnabledCountry(this.f53498j, this.f53499k)) {
            if (!TalabatUtils.isPartiallyMapPackageEnabledCountry()) {
                return;
            }
            if (!this.isMapcompulsory && !this.isNineCookiesTrackingEnabled) {
                return;
            }
        }
        this.f53508t = getIntent().getStringExtra("address");
        this.addressPresenter.showMapForSelection(this.isAddressFromCartOrderFlow);
    }

    public void geoPolygonCenterPointAvailable(boolean z11, LatLng latLng) {
    }

    public int getAreaId() {
        return this.SELECTED_AREA;
    }

    public String getAreaName() {
        return this.SELECTED_AREA_NAME;
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
        return this.directionsText.getText().toString().trim();
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

    public String getGRL() {
        return this.grlString;
    }

    public String getGRLId() {
        return this.grlId;
    }

    public Context getGemContext() {
        return this;
    }

    public String getGemScreenType() {
        return ScreenNames.getScreenType(getScreenName());
    }

    public LatLng getGeoCodinates() {
        return this.f53510v;
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
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
            builder.setTitle((CharSequence) getString(R.string.location_disabled));
            builder.setMessage((CharSequence) getString(R.string.enable_gps_description));
            builder.setPositiveButton((CharSequence) getString(R.string.settings).toUpperCase(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                    Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                    intent.addFlags(1073741824);
                    AddAddressScreen2.this.startActivityForResult(intent, 45);
                }
            });
            builder.setNegativeButton((CharSequence) getString(R.string.cancel).toUpperCase(), (DialogInterface.OnClickListener) null);
            builder.show();
            return;
        }
        requestPermission(this);
    }

    public String getMobile() {
        return this.mobileText.getText().toString().trim();
    }

    public String getMobileDialCode() {
        return this.mobileCountryCode.getText().toString();
    }

    public String getPhone() {
        return this.phoneText.getText().toString().trim();
    }

    public IGlobalPresenter getPresenter() {
        return this.addressPresenter;
    }

    public String getScreenName() {
        return ScreenNames.ADD_ADDRESS;
    }

    public void inflateGemFooter() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            this.A = new GemFooterCartView();
            if (GEMEngine.getInstance() != null) {
                GEMEngine.getInstance().startListening(this, false);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
            beginTransaction.add((int) R.id.gem_footer_view, (Fragment) this.A, getScreenName());
            beginTransaction.commit();
        }
    }

    public void isRefreshMap(boolean z11, @NotNull com.google.android.gms.maps.model.LatLng latLng) {
    }

    public void locationMismatch(String str) {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setTitle(R.string.location_mismatch);
        builder.setMessage(getString(R.string.address_mismatch_description).replace(RichContentLoadTimeRecorder.DELIMETER, GlobalDataModel.SelectedAreaName));
        builder.setPositiveButton(R.string.f54881ok, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void locationRecieved(Location location) {
        if (!(ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0)) {
            requestPermission(this);
        }
        startLodingPopup();
        this.addressPresenter.autoFillAddress(location.getLatitude(), location.getLongitude());
        this.locationManager.removeUpdates(this);
    }

    public void mapCurrentLocReceived(@NotNull com.google.android.gms.maps.model.LatLng latLng) {
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 10) {
            onActivityResultSelectArea(i12, intent);
        } else if (i11 == 20) {
            onActivityResultSelectCity(i12, intent);
        } else if (i11 == 99) {
            onActivityResultSelectAddressAutomatically(i12, intent);
        } else if (i11 == 100) {
            onActivityResultSelectAddressManually(i12, intent);
        } else if (i11 == 101) {
            onActivityResultChooseCountryCode(i12, intent);
        }
    }

    public /* synthetic */ void onAddMoreItemClicked() {
        a.a(this);
    }

    public void onAddressAddSuccess(Address address) {
        String str;
        if (getIntent().hasExtra("from")) {
            str = getIntent().getStringExtra("from");
        } else {
            str = "";
        }
        if (str.equals("Cart Screen") || this.isOrderFlow || this.isAddressFromCartOrderFlow) {
            if (this.isFromMapFirstFlow) {
                HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
                homeMapTemp.setHomeMapRedirect(false, this);
                homeMapTemp.updateAddressNotSaved(false);
            }
            Customer.getInstance().setSelectedCustomerAddress(this, address.f58343id, address.areaId);
        }
        stopLodingPopup();
        if (this.blockPresentInMap && this.fromMap && !this.blockField.equals(this.newBlockField)) {
            AppTracker.onMapBlockUpdated(this);
        }
        if (this.streetPresentInMap && this.fromMap && !this.streetField.equals(this.newStreetField)) {
            AppTracker.onMapStreetUpdated(this);
        }
        this.fromMap = false;
        sucess();
        onTrackAddressSubmitted(address, TrackingUtils.INSTANCE.getAddressMethodNew());
        Toast.makeText(this, R.string.address_saved_successfully, 0).show();
    }

    public void onAddressDeleteFailed(int i11, String str) {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage(str);
        builder.setPositiveButton(R.string.f54881ok, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void onAddressEditFailed(int i11, String str, Address address) {
        stopLodingPopup();
        if (i11 != 21 && i11 != 22 && i11 != 23 && i11 != 2 && i11 != 3) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
            builder.setMessage((CharSequence) str);
            if (i11 == 11) {
                builder.setTitle((CharSequence) getResources().getString(R.string.address_limit_reached));
            }
            builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
            builder.show();
        } else if (this.mobileText != null) {
            String str2 = "";
            if (TalabatUtils.isRTL()) {
                TalabatTextView talabatTextView = this.mobileArabicErrorText;
                if (talabatTextView != null) {
                    talabatTextView.setVisibility(0);
                    TalabatTextView talabatTextView2 = this.mobileArabicErrorText;
                    if (!TalabatUtils.isNullOrEmpty(str)) {
                        str2 = str;
                    }
                    talabatTextView2.setText(str2);
                }
            } else {
                TalabatTextView talabatTextView3 = this.mobileArabicErrorText;
                if (talabatTextView3 != null) {
                    talabatTextView3.setVisibility(0);
                }
                MaterialEditText materialEditText = this.mobileText;
                if (!TalabatUtils.isNullOrEmpty(str)) {
                    str2 = str;
                }
                materialEditText.setError(str2);
                this.mobileText.setErrorColor(getResources().getColor(R.color.edit_text_error));
            }
            this.mobileText.requestFocus();
            this.mobileText.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
        }
        trackMapErrorShown(str, address);
    }

    public void onAddressEditSuccess(Address address) {
        HomeMapTemp homeMapTemp;
        if (this.blockPresentInMap && this.fromMap && !this.blockField.equals(this.newBlockField)) {
            AppTracker.onMapBlockUpdated(this);
        }
        if (this.streetPresentInMap && this.fromMap && !this.streetField.equals(this.newStreetField)) {
            AppTracker.onMapStreetUpdated(this);
        }
        this.fromMap = false;
        if (this.isAddressFromCartOrderFlow) {
            if (this.isFromMapFirstFlow && (homeMapTemp = HomeMapTemp.INSTANCE) != null) {
                homeMapTemp.setHomeMapRedirect(false, this);
                homeMapTemp.updateAddressNotSaved(false);
            }
            Customer.getInstance().setSelectedCustomerAddress(this, address.f58343id, address.areaId);
            if (!this.isAddressFromCartOrderFlow || this.isEditAddressFromSideMenu) {
                GlobalDataModel.GEO_CORDINATES.isRefreshBrandAddress = false;
                this.mapJourneytype = ScreenNames.SCREEN_TYPE_USER_ACCOUNT;
            } else {
                GlobalDataModel.GEO_CORDINATES.isRefreshBrandAddress = true;
                this.mapJourneytype = "cart";
            }
        } else {
            this.mapJourneytype = ScreenNames.SCREEN_TYPE_USER_ACCOUNT;
        }
        onTrackAddressSubmitted(address, TrackingUtils.INSTANCE.getAddressMethodSaved());
        stopLodingPopup();
        sucess();
    }

    public void onAddressValidationError(int i11, String str) {
        stopLodingPopup();
    }

    public void onAddressesDeleted(String str) {
        stopLodingPopup();
        Customer.getInstance().RemoveCustomerAddress(str);
        Intent intent = new Intent(this, AddressList.class);
        intent.putExtra(GlobalConstants.FORCE_MAP.MAP_FROM_SIDEMENU, this.isMapFromSideMenu);
        intent.putExtra(GlobalConstants.FORCE_MAP.IS_EDIT_ADDRESS_FROM_SIDE_MENU, this.isEditAddressFromSideMenu);
        startActivity(intent.addFlags(67108864));
        finish();
        Toast.makeText(this, R.string.address_delete_success, 0).show();
    }

    public void onAreaReceived(Area[] areaArr) {
        this.areas = areaArr;
        stopLodingPopup();
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        super.onBackPressed();
        GlobalDataModel.GEO_CORDINATES.saveTempZoomLevel = 0.0f;
        GlobalDataModel.GEO_CORDINATES.isUserInteractedWithMapLocation = false;
        GlobalDataModel.HOME_SCREEN_MAP.CONFIRMED_LOCATION_AWARNESS = false;
    }

    public /* synthetic */ void onBackToCheckoutPage(Dialog dialog) {
        a.b(this, dialog);
    }

    public void onBackToRestaurantMenuPage(Dialog dialog) {
        backToRestaurantMenuPage(dialog, (GemDialogSwitcher) null, "");
    }

    public void onBackToRestaurantPage(Dialog dialog) {
        dialog.dismiss();
        finish();
        Intent intent = new Intent();
        Restaurant restaurant = GlobalDataModel.SELECTED.restaurant;
        if (restaurant != null) {
            if (restaurant.shopType == 1) {
                intent = new Intent(this, GroceryMenuScreen.class);
            } else {
                intent = new Intent(this, RestaurantMenuScreenR.class);
            }
        }
        intent.setFlags(67108864);
        startActivity(intent);
    }

    public void onCloseButtonClicked(Dialog dialog) {
        dialog.dismiss();
    }

    public /* synthetic */ void onContinueToCheckout() {
        a.f(this);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0191: MOVE  (r2v56 android.os.Bundle) = (r24v0 android.os.Bundle)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public void onCreate(android.os.Bundle r24) {
        /*
            r23 = this;
            r14 = r23
            r0 = r24
            java.lang.String r15 = "value"
            yj.a.a(r23)
            super.onCreate(r24)
            com.talabat.maps.domain.MapsInitializer r1 = r14.f53506r
            r1.initialize()
            r23.setContentViewBasedOnExperiment()
            java.lang.String r1 = "UiTestInvestigation: AddAddressScreen2 onCreate called"
            com.talabat.talabatcore.logger.LogManager.info(r1)
            r1 = 2131431952(0x7f0b1210, float:1.8485648E38)
            android.view.View r1 = r14.findViewById(r1)     // Catch:{ Exception -> 0x0581 }
            androidx.appcompat.widget.Toolbar r1 = (androidx.appcompat.widget.Toolbar) r1     // Catch:{ Exception -> 0x0581 }
            r14.setSupportActionBar(r1)     // Catch:{ Exception -> 0x0581 }
            r23.handleIntent()     // Catch:{ Exception -> 0x0581 }
            java.lang.Boolean r1 = com.talabat.core.buildconfig.BuildConfig.IS_ALPHA     // Catch:{ Exception -> 0x0581 }
            boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x0581 }
            com.talabat.helpers.ApptimizeHelper.enableGoogleSearchOptimization(r1)     // Catch:{ Exception -> 0x0581 }
            com.talabat.homemaphelper.CurrentLocationFetch r1 = new com.talabat.homemaphelper.CurrentLocationFetch     // Catch:{ Exception -> 0x0581 }
            r1.<init>(r14, r14)     // Catch:{ Exception -> 0x0581 }
            r14.B = r1     // Catch:{ Exception -> 0x0581 }
            boolean r1 = r1.userAllowedAllLocationPermissions(r14)     // Catch:{ Exception -> 0x0581 }
            if (r1 == 0) goto L_0x004f
            com.talabat.homemaphelper.CurrentLocationFetch r1 = r14.B     // Catch:{ Exception -> 0x0581 }
            com.talabat.maputils.CurrentLocHelper r2 = com.talabat.maputils.CurrentLocHelper.INSTANCE     // Catch:{ Exception -> 0x0581 }
            int r2 = r2.getIS_FROM_INIT_CL_BG()     // Catch:{ Exception -> 0x0581 }
            r1.initLocationRequest(r14, r2)     // Catch:{ Exception -> 0x0581 }
            com.talabat.homemaphelper.CurrentLocationFetch r1 = r14.B     // Catch:{ Exception -> 0x0581 }
            r1.fetchCurrentLocation()     // Catch:{ Exception -> 0x0581 }
        L_0x004f:
            r1 = 2131430531(0x7f0b0c83, float:1.8482766E38)
            android.view.View r13 = r14.findViewById(r1)     // Catch:{ Exception -> 0x0581 }
            r12 = 0
            if (r13 == 0) goto L_0x0068
            java.lang.String r1 = "input_method"
            java.lang.Object r1 = r14.getSystemService(r1)     // Catch:{ Exception -> 0x0581 }
            android.view.inputmethod.InputMethodManager r1 = (android.view.inputmethod.InputMethodManager) r1     // Catch:{ Exception -> 0x0581 }
            android.os.IBinder r2 = r13.getWindowToken()     // Catch:{ Exception -> 0x0581 }
            r1.hideSoftInputFromWindow(r2, r12)     // Catch:{ Exception -> 0x0581 }
        L_0x0068:
            r23.findViews()     // Catch:{ Exception -> 0x0581 }
            r1 = 2131431119(0x7f0b0ecf, float:1.8483958E38)
            android.view.View r1 = r14.findViewById(r1)     // Catch:{ Exception -> 0x0581 }
            r11 = r1
            android.widget.Button r11 = (android.widget.Button) r11     // Catch:{ Exception -> 0x0581 }
            r1 = 2131427630(0x7f0b012e, float:1.8476882E38)
            android.view.View r10 = r14.findViewById(r1)     // Catch:{ Exception -> 0x0581 }
            library.talabat.mvp.addressV2.AddressPresenter r9 = new library.talabat.mvp.addressV2.AddressPresenter     // Catch:{ Exception -> 0x0581 }
            com.talabat.user.address.di.AddressesDependencyProvider r1 = com.talabat.user.address.di.AddressesDependencyProvider.INSTANCE     // Catch:{ Exception -> 0x0581 }
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r2 = r14.f53503o     // Catch:{ Exception -> 0x0581 }
            com.talabat.user.address.domain.repository.CustomerAddressesRepository r4 = r1.provideCustomerAddressesRepository(r2)     // Catch:{ Exception -> 0x0581 }
            io.reactivex.Scheduler r5 = io.reactivex.schedulers.Schedulers.io()     // Catch:{ Exception -> 0x0581 }
            io.reactivex.Scheduler r6 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()     // Catch:{ Exception -> 0x0581 }
            com.talabat.configuration.discovery.AppVersionProvider r7 = r14.f53497i     // Catch:{ Exception -> 0x0581 }
            com.talabat.configuration.ConfigurationLocalRepository r8 = r14.f53498j     // Catch:{ Exception -> 0x0581 }
            com.talabat.configuration.MutableLocationConfigurationRepository r3 = r14.f53499k     // Catch:{ Exception -> 0x0581 }
            library.talabat.mvp.addressV2.UserAddAddressScreenEventsListener r2 = r14.f53501m     // Catch:{ Exception -> 0x0581 }
            kotlin.jvm.functions.Function0<java.lang.String> r1 = r14.C     // Catch:{ Exception -> 0x0581 }
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r12 = r14.f53503o     // Catch:{ Exception -> 0x0581 }
            r16 = r13
            com.talabat.maps.domain.LatLngFactory r13 = r14.f53505q     // Catch:{ Exception -> 0x0581 }
            r17 = r1
            r1 = r9
            r18 = r2
            r2 = r23
            r19 = r3
            r3 = r23
            r0 = r9
            r9 = r19
            r20 = r10
            r10 = r18
            r21 = r11
            r11 = r17
            r17 = r15
            r15 = 0
            r22 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x0581 }
            r14.addressPresenter = r0     // Catch:{ Exception -> 0x0581 }
            boolean r1 = r14.noAreaChange     // Catch:{ Exception -> 0x0581 }
            r0.setValidateArea(r1)     // Catch:{ Exception -> 0x0581 }
            library.talabat.mvp.addressV2.IAddressPresenter r0 = r14.addressPresenter     // Catch:{ Exception -> 0x0581 }
            boolean r1 = r14.isAddressFromCartOrderFlow     // Catch:{ Exception -> 0x0581 }
            r0.isCheckLoadResPoryGon(r1)     // Catch:{ Exception -> 0x0581 }
            com.talabat.AddAddressScreen2$1 r0 = new com.talabat.AddAddressScreen2$1     // Catch:{ Exception -> 0x0581 }
            r0.<init>()     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r1 = r14.hiddenMobile     // Catch:{ Exception -> 0x0581 }
            r1.setCustomSelectionActionModeCallback(r0)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.hiddenMobile     // Catch:{ Exception -> 0x0581 }
            r0.setLongClickable(r15)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.hiddenMobile     // Catch:{ Exception -> 0x0581 }
            r0.setTextIsSelectable(r15)     // Catch:{ Exception -> 0x0581 }
            boolean r0 = r14.isNewAddressCreation     // Catch:{ Exception -> 0x0581 }
            r1 = 0
            if (r0 == 0) goto L_0x00eb
            com.talabat.helpers.GlobalDataModel.GEO_CORDINATES.ValidateWithareaPolygon = r15     // Catch:{ Exception -> 0x0581 }
            com.talabat.helpers.GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints = r1     // Catch:{ Exception -> 0x0581 }
            com.talabat.helpers.GlobalDataModel.GEO_CORDINATES.polyGonPoints = r1     // Catch:{ Exception -> 0x0581 }
            com.talabat.helpers.GlobalDataModel.GEO_CORDINATES.addressPageLatLang = r1     // Catch:{ Exception -> 0x0581 }
        L_0x00eb:
            android.content.Intent r0 = r23.getIntent()     // Catch:{ Exception -> 0x0581 }
            r2 = r17
            java.lang.String r0 = r0.getStringExtra(r2)     // Catch:{ Exception -> 0x0581 }
            r14.f53508t = r0     // Catch:{ Exception -> 0x0581 }
            JsonModels.parser.UniversalGson r3 = JsonModels.parser.UniversalGson.INSTANCE     // Catch:{ Exception -> 0x0581 }
            com.google.gson.Gson r3 = r3.gson     // Catch:{ Exception -> 0x0581 }
            java.lang.Class<com.talabat.domain.address.Address> r4 = com.talabat.domain.address.Address.class
            boolean r5 = r3 instanceof com.google.gson.Gson     // Catch:{ Exception -> 0x0581 }
            if (r5 != 0) goto L_0x0106
            java.lang.Object r0 = r3.fromJson((java.lang.String) r0, r4)     // Catch:{ Exception -> 0x0581 }
            goto L_0x010a
        L_0x0106:
            java.lang.Object r0 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r3, (java.lang.String) r0, r4)     // Catch:{ Exception -> 0x0581 }
        L_0x010a:
            com.talabat.domain.address.Address r0 = (com.talabat.domain.address.Address) r0     // Catch:{ Exception -> 0x0581 }
            boolean r3 = r14.isForEdit     // Catch:{ Exception -> 0x0581 }
            java.lang.String r4 = "cart"
            r5 = 2132018203(0x7f14041b, float:1.9674706E38)
            java.lang.String r6 = "user_account"
            r7 = 8
            r8 = 2132017248(0x7f140060, float:1.967277E38)
            r9 = 2131431915(0x7f0b11eb, float:1.8485573E38)
            r10 = 4
            if (r3 == 0) goto L_0x0168
            boolean r2 = r14.isTitleCorrection     // Catch:{ Exception -> 0x0581 }
            if (r2 == 0) goto L_0x012d
            java.lang.String r2 = r14.getString(r8)     // Catch:{ Exception -> 0x0581 }
            r14.setTitle(r9, r2)     // Catch:{ Exception -> 0x0581 }
            goto L_0x0134
        L_0x012d:
            java.lang.String r2 = r14.getString(r5)     // Catch:{ Exception -> 0x0581 }
            r14.setTitle(r9, r2)     // Catch:{ Exception -> 0x0581 }
        L_0x0134:
            r14.isNewAddressCreation = r15     // Catch:{ Exception -> 0x0581 }
            com.talabat.helpers.GlobalDataModel.GEO_CORDINATES.ValidateWithareaPolygon = r15     // Catch:{ Exception -> 0x0581 }
            com.talabat.helpers.GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints = r1     // Catch:{ Exception -> 0x0581 }
            com.talabat.helpers.GlobalDataModel.GEO_CORDINATES.polyGonPoints = r1     // Catch:{ Exception -> 0x0581 }
            com.talabat.maps.domain.LatLngFactory r2 = r14.f53505q     // Catch:{ Exception -> 0x0581 }
            double r11 = r0.latitude     // Catch:{ Exception -> 0x0581 }
            double r8 = r0.longitude     // Catch:{ Exception -> 0x0581 }
            com.talabat.maps.domain.model.LatLng r2 = r2.createLatLng(r11, r8)     // Catch:{ Exception -> 0x0581 }
            r14.f53510v = r2     // Catch:{ Exception -> 0x0581 }
            boolean r2 = r14.isOrderFlow     // Catch:{ Exception -> 0x0581 }
            if (r2 != 0) goto L_0x015a
            android.widget.Button r2 = r14.deleteAddress     // Catch:{ Exception -> 0x0581 }
            r2.setVisibility(r15)     // Catch:{ Exception -> 0x0581 }
            r8 = r21
            r8.setVisibility(r7)     // Catch:{ Exception -> 0x0581 }
            r14.mapJourneytype = r6     // Catch:{ Exception -> 0x0581 }
            goto L_0x0217
        L_0x015a:
            r8 = r21
            android.widget.Button r2 = r14.deleteAddress     // Catch:{ Exception -> 0x0581 }
            r2.setVisibility(r10)     // Catch:{ Exception -> 0x0581 }
            r8.setVisibility(r15)     // Catch:{ Exception -> 0x0581 }
            r14.mapJourneytype = r4     // Catch:{ Exception -> 0x0581 }
            goto L_0x0217
        L_0x0168:
            r8 = r21
            boolean r9 = r14.isAddressFromCartOrderFlow     // Catch:{ Exception -> 0x0581 }
            if (r9 == 0) goto L_0x020e
            boolean r6 = r14.isGrlEnabled     // Catch:{ Exception -> 0x0581 }
            if (r6 != 0) goto L_0x01f0
            boolean r2 = r14.isNewAddressFromCartFlow     // Catch:{ Exception -> 0x0581 }
            if (r2 != 0) goto L_0x018d
            boolean r2 = r14.isMapcompulsory     // Catch:{ Exception -> 0x0581 }
            if (r2 == 0) goto L_0x017b
            goto L_0x018d
        L_0x017b:
            r23.forceRedirectToMapLogic()     // Catch:{ Exception -> 0x0581 }
            r2 = 2132017248(0x7f140060, float:1.967277E38)
            java.lang.String r5 = r14.getString(r2)     // Catch:{ Exception -> 0x0581 }
            r2 = 2131431915(0x7f0b11eb, float:1.8485573E38)
            r14.setTitle(r2, r5)     // Catch:{ Exception -> 0x0581 }
            goto L_0x020b
        L_0x018d:
            com.talabat.maps.domain.model.LatLng r2 = r14.f53510v     // Catch:{ Exception -> 0x0581 }
            if (r2 != 0) goto L_0x01a9
            r2 = r24
            if (r2 == 0) goto L_0x01a9
            com.talabat.maps.domain.LatLngFactory r6 = r14.f53505q     // Catch:{ Exception -> 0x0581 }
            java.lang.String r9 = "savedlatitude"
            double r11 = r2.getDouble(r9)     // Catch:{ Exception -> 0x0581 }
            java.lang.String r9 = "savedlongitude"
            double r1 = r2.getDouble(r9)     // Catch:{ Exception -> 0x0581 }
            com.talabat.maps.domain.model.LatLng r1 = r6.createLatLng(r11, r1)     // Catch:{ Exception -> 0x0581 }
            r14.f53510v = r1     // Catch:{ Exception -> 0x0581 }
        L_0x01a9:
            com.talabat.maps.domain.model.LatLng r1 = r14.f53510v     // Catch:{ Exception -> 0x0581 }
            if (r1 != 0) goto L_0x01b0
            r23.forceRedirectToMapLogic()     // Catch:{ Exception -> 0x0581 }
        L_0x01b0:
            boolean r1 = r14.isAddressFromCartOrderFlow     // Catch:{ Exception -> 0x0581 }
            if (r1 == 0) goto L_0x020b
            boolean r1 = r14.isNewAddressFromCartFlow     // Catch:{ Exception -> 0x0581 }
            if (r1 != 0) goto L_0x01e2
            android.content.Intent r1 = r23.getIntent()     // Catch:{ Exception -> 0x0581 }
            java.lang.String r2 = "isNewAddressFromCartOrderReg"
            boolean r1 = r1.getBooleanExtra(r2, r15)     // Catch:{ Exception -> 0x0581 }
            if (r1 == 0) goto L_0x01c5
            goto L_0x01e2
        L_0x01c5:
            boolean r1 = r14.isAddAddressFromCheckout     // Catch:{ Exception -> 0x0581 }
            if (r1 == 0) goto L_0x01d7
            r1 = 2132017248(0x7f140060, float:1.967277E38)
            java.lang.String r2 = r14.getString(r1)     // Catch:{ Exception -> 0x0581 }
            r1 = 2131431915(0x7f0b11eb, float:1.8485573E38)
            r14.setTitle(r1, r2)     // Catch:{ Exception -> 0x0581 }
            goto L_0x020b
        L_0x01d7:
            r1 = 2131431915(0x7f0b11eb, float:1.8485573E38)
            java.lang.String r2 = r14.getString(r5)     // Catch:{ Exception -> 0x0581 }
            r14.setTitle(r1, r2)     // Catch:{ Exception -> 0x0581 }
            goto L_0x020b
        L_0x01e2:
            r1 = 2132017248(0x7f140060, float:1.967277E38)
            java.lang.String r2 = r14.getString(r1)     // Catch:{ Exception -> 0x0581 }
            r1 = 2131431915(0x7f0b11eb, float:1.8485573E38)
            r14.setTitle(r1, r2)     // Catch:{ Exception -> 0x0581 }
            goto L_0x020b
        L_0x01f0:
            boolean r1 = r14.isGlrEnableAddNewAddress     // Catch:{ Exception -> 0x0581 }
            if (r1 == 0) goto L_0x020b
            android.content.Intent r1 = r23.getIntent()     // Catch:{ Exception -> 0x0581 }
            java.lang.String r1 = r1.getStringExtra(r2)     // Catch:{ Exception -> 0x0581 }
            r14.f53508t = r1     // Catch:{ Exception -> 0x0581 }
            r1 = 2132017248(0x7f140060, float:1.967277E38)
            java.lang.String r2 = r14.getString(r1)     // Catch:{ Exception -> 0x0581 }
            r1 = 2131431915(0x7f0b11eb, float:1.8485573E38)
            r14.setTitle(r1, r2)     // Catch:{ Exception -> 0x0581 }
        L_0x020b:
            r14.mapJourneytype = r4     // Catch:{ Exception -> 0x0581 }
            goto L_0x0217
        L_0x020e:
            r14.mapJourneytype = r6     // Catch:{ Exception -> 0x0581 }
            boolean r1 = r14.isGrlEnabled     // Catch:{ Exception -> 0x0581 }
            if (r1 != 0) goto L_0x0217
            r23.forceRedirectToMapLogic()     // Catch:{ Exception -> 0x0581 }
        L_0x0217:
            r23.snapMapVisibility()     // Catch:{ Exception -> 0x0581 }
            ue.c r1 = new ue.c     // Catch:{ Exception -> 0x0581 }
            r1.<init>(r14)     // Catch:{ Exception -> 0x0581 }
            r8.setOnClickListener(r1)     // Catch:{ Exception -> 0x0581 }
            android.widget.Button r1 = r14.deleteAddress     // Catch:{ Exception -> 0x0581 }
            ue.n r2 = new ue.n     // Catch:{ Exception -> 0x0581 }
            r2.<init>(r14)     // Catch:{ Exception -> 0x0581 }
            r1.setOnClickListener(r2)     // Catch:{ Exception -> 0x0581 }
            java.lang.String r1 = "location"
            java.lang.Object r1 = r14.getSystemService(r1)     // Catch:{ Exception -> 0x0581 }
            android.location.LocationManager r1 = (android.location.LocationManager) r1     // Catch:{ Exception -> 0x0581 }
            r14.locationManager = r1     // Catch:{ Exception -> 0x0581 }
            r1 = 3
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch:{ Exception -> 0x0581 }
            boolean r2 = r23.canChangeHouseToVilla()     // Catch:{ Exception -> 0x0581 }
            if (r2 == 0) goto L_0x0247
            r2 = 2132020454(0x7f140ce6, float:1.9679272E38)
            java.lang.String r2 = r14.getString(r2)     // Catch:{ Exception -> 0x0581 }
            goto L_0x024e
        L_0x0247:
            r2 = 2132018656(0x7f1405e0, float:1.9675625E38)
            java.lang.String r2 = r14.getString(r2)     // Catch:{ Exception -> 0x0581 }
        L_0x024e:
            r1[r15] = r2     // Catch:{ Exception -> 0x0581 }
            r2 = 2132017526(0x7f140176, float:1.9673333E38)
            java.lang.String r2 = r14.getString(r2)     // Catch:{ Exception -> 0x0581 }
            r12 = 1
            r1[r12] = r2     // Catch:{ Exception -> 0x0581 }
            r2 = 2132019305(0x7f140869, float:1.9676941E38)
            java.lang.String r2 = r14.getString(r2)     // Catch:{ Exception -> 0x0581 }
            r4 = 2
            r1[r4] = r2     // Catch:{ Exception -> 0x0581 }
            r14.f53512x = r1     // Catch:{ Exception -> 0x0581 }
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter     // Catch:{ Exception -> 0x0581 }
            java.lang.String[] r2 = r14.f53512x     // Catch:{ Exception -> 0x0581 }
            r4 = 2131624964(0x7f0e0404, float:1.8877123E38)
            r1.<init>(r14, r4, r2)     // Catch:{ Exception -> 0x0581 }
            r2 = 2131624963(0x7f0e0403, float:1.887712E38)
            r1.setDropDownViewResource(r2)     // Catch:{ Exception -> 0x0581 }
            com.talabat.TalabatSpinner r2 = r14.addressType     // Catch:{ Exception -> 0x0581 }
            r2.setAdapter((android.widget.SpinnerAdapter) r1)     // Catch:{ Exception -> 0x0581 }
            boolean r1 = r14.isForEdit     // Catch:{ Exception -> 0x0581 }
            if (r1 != 0) goto L_0x0284
            com.talabat.TalabatSpinner r1 = r14.addressType     // Catch:{ Exception -> 0x0581 }
            r1.setSelection(r12)     // Catch:{ Exception -> 0x0581 }
        L_0x0284:
            int r1 = r23.userSelectedAddressType()     // Catch:{ Exception -> 0x0581 }
            r14.selectedAddressPosition = r1     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r1 = r14.addressTypeEditText     // Catch:{ Exception -> 0x0581 }
            ue.y r2 = new ue.y     // Catch:{ Exception -> 0x0581 }
            r2.<init>(r14)     // Catch:{ Exception -> 0x0581 }
            r1.setOnClickListener(r2)     // Catch:{ Exception -> 0x0581 }
            com.talabat.TalabatSpinner r1 = r14.addressType     // Catch:{ Exception -> 0x0581 }
            com.talabat.AddAddressScreen2$2 r2 = new com.talabat.AddAddressScreen2$2     // Catch:{ Exception -> 0x0581 }
            r2.<init>()     // Catch:{ Exception -> 0x0581 }
            r1.setOnItemSelectedListener(r2)     // Catch:{ Exception -> 0x0581 }
            android.widget.Button r1 = r14.saveAddress     // Catch:{ Exception -> 0x0581 }
            ue.b0 r2 = new ue.b0     // Catch:{ Exception -> 0x0581 }
            r2.<init>(r14)     // Catch:{ Exception -> 0x0581 }
            r1.setOnClickListener(r2)     // Catch:{ Exception -> 0x0581 }
            boolean r1 = r14.noAreaChange     // Catch:{ Exception -> 0x0581 }
            if (r1 == 0) goto L_0x02d8
            com.materialedittext.MaterialEditText r1 = r14.area     // Catch:{ Exception -> 0x0581 }
            java.lang.String r2 = com.talabat.helpers.GlobalDataModel.SelectedAreaName     // Catch:{ Exception -> 0x0581 }
            r1.setText(r2)     // Catch:{ Exception -> 0x0581 }
            int r1 = com.talabat.helpers.GlobalDataModel.SelectedAreaId     // Catch:{ Exception -> 0x0581 }
            r14.SELECTED_AREA = r1     // Catch:{ Exception -> 0x0581 }
            java.lang.String r1 = com.talabat.helpers.GlobalDataModel.SelectedAreaName     // Catch:{ Exception -> 0x0581 }
            r14.SELECTED_AREA_NAME = r1     // Catch:{ Exception -> 0x0581 }
            int r1 = com.talabat.helpers.GlobalDataModel.SelectedCityId     // Catch:{ Exception -> 0x0581 }
            r14.SELECTED_CITY = r1     // Catch:{ Exception -> 0x0581 }
            java.lang.String r1 = com.talabat.helpers.GlobalDataModel.SelectedCityName     // Catch:{ Exception -> 0x0581 }
            r14.SELECTED_CITY_NAME = r1     // Catch:{ Exception -> 0x0581 }
            com.talabat.configuration.ConfigurationLocalRepository r1 = r14.f53498j     // Catch:{ Exception -> 0x0581 }
            com.talabat.configuration.MutableLocationConfigurationRepository r2 = r14.f53499k     // Catch:{ Exception -> 0x0581 }
            datamodels.Country r1 = com.talabat.helpers.TalabatUtils.getSelectedCountry(r1, r2)     // Catch:{ Exception -> 0x0581 }
            if (r1 == 0) goto L_0x02d8
            boolean r1 = r1.isCityInAddress     // Catch:{ Exception -> 0x0581 }
            if (r1 == 0) goto L_0x02d8
            com.materialedittext.MaterialEditText r1 = r14.city     // Catch:{ Exception -> 0x0581 }
            java.lang.String r2 = com.talabat.helpers.GlobalDataModel.SelectedCityName     // Catch:{ Exception -> 0x0581 }
            r1.setText(r2)     // Catch:{ Exception -> 0x0581 }
        L_0x02d8:
            boolean r1 = r14.isFromMcdAddressFlow     // Catch:{ Exception -> 0x0581 }
            if (r1 == 0) goto L_0x0341
            library.talabat.mvp.addressV2.IAddressPresenter r1 = r14.addressPresenter     // Catch:{ Exception -> 0x0581 }
            r1.setIsFromInMcdFlow()     // Catch:{ Exception -> 0x0581 }
            android.widget.Button r1 = r14.deleteAddress     // Catch:{ Exception -> 0x0581 }
            r1.setVisibility(r7)     // Catch:{ Exception -> 0x0581 }
            r8.setVisibility(r15)     // Catch:{ Exception -> 0x0581 }
            boolean r1 = r14.isNewAddressCreationGlrFlow     // Catch:{ Exception -> 0x0581 }
            if (r1 == 0) goto L_0x033b
            library.talabat.mvp.addressV2.IAddressPresenter r0 = r14.addressPresenter     // Catch:{ Exception -> 0x0581 }
            r0.setIsAddNewAddressFromGrl()     // Catch:{ Exception -> 0x0581 }
            boolean r0 = com.talabat.helpers.TalabatUtils.isMcdInforMapEnabledCountry()     // Catch:{ Exception -> 0x0581 }
            if (r0 == 0) goto L_0x0306
            library.talabat.mvp.addressV2.IAddressPresenter r0 = r14.addressPresenter     // Catch:{ Exception -> 0x0581 }
            buisnessmodels.McdMapTempAddress r1 = buisnessmodels.McdMapTempAddress.getInstance()     // Catch:{ Exception -> 0x0581 }
            com.talabat.domain.address.Address r1 = r1.getSelectedGrlTempAddress()     // Catch:{ Exception -> 0x0581 }
            r0.setUpViews(r1, r15)     // Catch:{ Exception -> 0x0581 }
            goto L_0x032d
        L_0x0306:
            boolean r0 = com.talabat.helpers.TalabatUtils.isMcdBlockMenuEnabledCountry()     // Catch:{ Exception -> 0x0581 }
            if (r0 == 0) goto L_0x031a
            library.talabat.mvp.addressV2.IAddressPresenter r0 = r14.addressPresenter     // Catch:{ Exception -> 0x0581 }
            buisnessmodels.McdMapTempAddress r1 = buisnessmodels.McdMapTempAddress.getInstance()     // Catch:{ Exception -> 0x0581 }
            com.talabat.domain.address.Address r1 = r1.getSelectedMcdBlockTempAddress()     // Catch:{ Exception -> 0x0581 }
            r0.setUpViews(r1, r15)     // Catch:{ Exception -> 0x0581 }
            goto L_0x032d
        L_0x031a:
            boolean r0 = com.talabat.helpers.TalabatUtils.isMcdLatLngEnabledCountry()     // Catch:{ Exception -> 0x0581 }
            if (r0 == 0) goto L_0x032d
            library.talabat.mvp.addressV2.IAddressPresenter r0 = r14.addressPresenter     // Catch:{ Exception -> 0x0581 }
            buisnessmodels.McdMapTempAddress r1 = buisnessmodels.McdMapTempAddress.getInstance()     // Catch:{ Exception -> 0x0581 }
            com.talabat.domain.address.Address r1 = r1.getSelectedMcdLatLangTempAddress()     // Catch:{ Exception -> 0x0581 }
            r0.setUpViews(r1, r15)     // Catch:{ Exception -> 0x0581 }
        L_0x032d:
            r0 = 2132017248(0x7f140060, float:1.967277E38)
            java.lang.String r0 = r14.getString(r0)     // Catch:{ Exception -> 0x0581 }
            r1 = 2131431915(0x7f0b11eb, float:1.8485573E38)
            r14.setTitle(r1, r0)     // Catch:{ Exception -> 0x0581 }
            goto L_0x038d
        L_0x033b:
            library.talabat.mvp.addressV2.IAddressPresenter r1 = r14.addressPresenter     // Catch:{ Exception -> 0x0581 }
            r1.setUpViews(r0, r15)     // Catch:{ Exception -> 0x0581 }
            goto L_0x038d
        L_0x0341:
            java.lang.String r0 = r14.f53508t     // Catch:{ Exception -> 0x0581 }
            if (r0 != 0) goto L_0x035c
            library.talabat.mvp.addressV2.IAddressPresenter r0 = r14.addressPresenter     // Catch:{ Exception -> 0x0581 }
            boolean r1 = r14.isEditAddressFromSideMenu     // Catch:{ Exception -> 0x0581 }
            r2 = 0
            r0.setUpViews(r2, r1)     // Catch:{ Exception -> 0x0581 }
            tracking.gtm.TrackingUtils r0 = tracking.gtm.TrackingUtils.INSTANCE     // Catch:{ Exception -> 0x0581 }
            java.lang.String r1 = r0.getAddressMethodNew()     // Catch:{ Exception -> 0x0581 }
            r14.deliveryAddressStatus = r1     // Catch:{ Exception -> 0x0581 }
            java.lang.String r0 = r0.getAddressMethodNew()     // Catch:{ Exception -> 0x0581 }
            r14.locationMethod = r0     // Catch:{ Exception -> 0x0581 }
            goto L_0x038d
        L_0x035c:
            library.talabat.mvp.addressV2.IAddressPresenter r0 = r14.addressPresenter     // Catch:{ JSONException -> 0x0381 }
            boolean r1 = r14.isEditAddressFromSideMenu     // Catch:{ JSONException -> 0x0381 }
            r2 = 0
            r0.setUpViews(r2, r1)     // Catch:{ JSONException -> 0x0381 }
            tracking.gtm.TrackingUtils r0 = tracking.gtm.TrackingUtils.INSTANCE     // Catch:{ JSONException -> 0x0381 }
            java.lang.String r1 = r0.getAddressMethodSaved()     // Catch:{ JSONException -> 0x0381 }
            r14.deliveryAddressStatus = r1     // Catch:{ JSONException -> 0x0381 }
            java.lang.String r0 = r0.getAddressMethodSaved()     // Catch:{ JSONException -> 0x0381 }
            r14.locationMethod = r0     // Catch:{ JSONException -> 0x0381 }
            library.talabat.mvp.addressV2.IAddressPresenter r0 = r14.addressPresenter     // Catch:{ JSONException -> 0x0381 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0381 }
            java.lang.String r2 = r14.f53508t     // Catch:{ JSONException -> 0x0381 }
            r1.<init>((java.lang.String) r2)     // Catch:{ JSONException -> 0x0381 }
            boolean r2 = r14.isEditAddressFromSideMenu     // Catch:{ JSONException -> 0x0381 }
            r0.setUpViewsWithJson(r1, r2)     // Catch:{ JSONException -> 0x0381 }
            goto L_0x038d
        L_0x0381:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x0581 }
            library.talabat.mvp.addressV2.IAddressPresenter r0 = r14.addressPresenter     // Catch:{ Exception -> 0x0581 }
            boolean r1 = r14.isEditAddressFromSideMenu     // Catch:{ Exception -> 0x0581 }
            r2 = 0
            r0.setUpViews(r2, r1)     // Catch:{ Exception -> 0x0581 }
        L_0x038d:
            boolean r0 = r14.isFromMapFirstFlow     // Catch:{ Exception -> 0x0581 }
            if (r0 == 0) goto L_0x03aa
            int r0 = com.talabat.helpers.GlobalDataModel.HOME_SCREEN_MAP.MAP_FRST_UPDATE_OPTION     // Catch:{ Exception -> 0x0581 }
            int r1 = com.talabat.helpers.GlobalDataModel.HOME_SCREEN_MAP.UPDATE_NOW     // Catch:{ Exception -> 0x0581 }
            if (r0 != r1) goto L_0x03aa
            com.talabat.helpers.GlobalDataModel.HOME_SCREEN_MAP.CONFIRMED_LOCATION_AWARNESS = r12     // Catch:{ Exception -> 0x0581 }
            library.talabat.mvp.addressV2.IAddressPresenter r0 = r14.addressPresenter     // Catch:{ Exception -> 0x0581 }
            android.content.Intent r1 = r23.getIntent()     // Catch:{ Exception -> 0x0581 }
            java.lang.String r2 = "showAddressConfirmation"
            boolean r1 = r1.getBooleanExtra(r2, r15)     // Catch:{ Exception -> 0x0581 }
            r0.showAddressConfiramtion(r1)     // Catch:{ Exception -> 0x0581 }
            goto L_0x03ac
        L_0x03aa:
            com.talabat.helpers.GlobalDataModel.HOME_SCREEN_MAP.CONFIRMED_LOCATION_AWARNESS = r15     // Catch:{ Exception -> 0x0581 }
        L_0x03ac:
            r23.addTextChangeListener()     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.mobileText     // Catch:{ Exception -> 0x0581 }
            android.text.Editable r1 = r0.getText()     // Catch:{ Exception -> 0x0581 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0581 }
            java.lang.String r2 = " e"
            java.lang.String r3 = ""
            java.lang.String r1 = r1.replaceAll(r2, r3)     // Catch:{ Exception -> 0x0581 }
            r0.setText(r1)     // Catch:{ Exception -> 0x0581 }
            r23.setImeOptionAndEditorActionListener()     // Catch:{ Exception -> 0x0581 }
            r23.setViewOnClickListener()     // Catch:{ Exception -> 0x0581 }
            boolean r0 = com.talabat.helpers.TalabatUtils.isCountryCodeVerificationEnabledCountry()     // Catch:{ Exception -> 0x0581 }
            if (r0 == 0) goto L_0x043f
            android.widget.RelativeLayout r0 = r14.countryCodeLayout     // Catch:{ Exception -> 0x0581 }
            r0.setVisibility(r15)     // Catch:{ Exception -> 0x0581 }
            com.talabat.configuration.ConfigurationLocalRepository r0 = r14.f53498j     // Catch:{ Exception -> 0x0581 }
            com.talabat.configuration.MutableLocationConfigurationRepository r1 = r14.f53499k     // Catch:{ Exception -> 0x0581 }
            boolean r0 = com.talabat.helpers.TalabatUtils.isInterantionalCountryCodeVerificationEnabledCountry(r0, r1)     // Catch:{ Exception -> 0x0581 }
            if (r0 == 0) goto L_0x0410
            android.widget.Spinner r0 = r14.f53514z     // Catch:{ Exception -> 0x0581 }
            r0.setVisibility(r7)     // Catch:{ Exception -> 0x0581 }
            r1 = r20
            r1.setVisibility(r15)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.mobileCountryCode     // Catch:{ Exception -> 0x0581 }
            android.content.res.Resources r1 = r23.getResources()     // Catch:{ Exception -> 0x0581 }
            r2 = 2131101196(0x7f06060c, float:1.7814795E38)
            int r1 = r1.getColor(r2)     // Catch:{ Exception -> 0x0581 }
            r0.setTextColor(r1)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.mobileCountryCode     // Catch:{ Exception -> 0x0581 }
            r0.requestFocus()     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.mobileCountryCode     // Catch:{ Exception -> 0x0581 }
            android.content.res.Resources r1 = r23.getResources()     // Catch:{ Exception -> 0x0581 }
            r2 = 2131167486(0x7f0708fe, float:1.7949247E38)
            float r1 = r1.getDimension(r2)     // Catch:{ Exception -> 0x0581 }
            int r1 = (int) r1     // Catch:{ Exception -> 0x0581 }
            r0.setPaddings(r15, r15, r1, r15)     // Catch:{ Exception -> 0x0581 }
            goto L_0x0444
        L_0x0410:
            r1 = r20
            r23.setCountryCode()     // Catch:{ Exception -> 0x0581 }
            r1.setVisibility(r7)     // Catch:{ Exception -> 0x0581 }
            android.widget.Spinner r0 = r14.f53514z     // Catch:{ Exception -> 0x0581 }
            r0.setVisibility(r7)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.mobileCountryCode     // Catch:{ Exception -> 0x0581 }
            android.content.res.Resources r1 = r23.getResources()     // Catch:{ Exception -> 0x0581 }
            r2 = 2131101205(0x7f060615, float:1.7814813E38)
            int r1 = r1.getColor(r2)     // Catch:{ Exception -> 0x0581 }
            r0.setTextColor(r1)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.mobileCountryCode     // Catch:{ Exception -> 0x0581 }
            android.content.res.Resources r1 = r23.getResources()     // Catch:{ Exception -> 0x0581 }
            r2 = 2131167485(0x7f0708fd, float:1.7949245E38)
            float r1 = r1.getDimension(r2)     // Catch:{ Exception -> 0x0581 }
            int r1 = (int) r1     // Catch:{ Exception -> 0x0581 }
            r0.setPaddings(r15, r15, r1, r15)     // Catch:{ Exception -> 0x0581 }
            goto L_0x0444
        L_0x043f:
            android.widget.RelativeLayout r0 = r14.countryCodeLayout     // Catch:{ Exception -> 0x0581 }
            r0.setVisibility(r7)     // Catch:{ Exception -> 0x0581 }
        L_0x0444:
            com.materialedittext.MaterialEditText r0 = r14.directionsText     // Catch:{ Exception -> 0x0581 }
            android.text.InputFilter[] r1 = new android.text.InputFilter[r12]     // Catch:{ Exception -> 0x0581 }
            android.text.InputFilter$LengthFilter r2 = new android.text.InputFilter$LengthFilter     // Catch:{ Exception -> 0x0581 }
            r3 = 200(0xc8, float:2.8E-43)
            r2.<init>(r3)     // Catch:{ Exception -> 0x0581 }
            r1[r15] = r2     // Catch:{ Exception -> 0x0581 }
            r0.setFilters(r1)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.field1     // Catch:{ Exception -> 0x0581 }
            r0.requestFocus()     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.field1     // Catch:{ Exception -> 0x0581 }
            r0.setFocusableInTouchMode(r12)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.field1     // Catch:{ Exception -> 0x0581 }
            android.text.Editable r1 = r0.getText()     // Catch:{ Exception -> 0x0581 }
            int r1 = r1.length()     // Catch:{ Exception -> 0x0581 }
            r0.setSelection(r1)     // Catch:{ Exception -> 0x0581 }
            boolean r0 = r14.noAreaChange     // Catch:{ Exception -> 0x0581 }
            r1 = 5
            if (r0 == 0) goto L_0x0482
            com.materialedittext.MaterialEditText r0 = r14.field1     // Catch:{ Exception -> 0x0581 }
            r0.setImeOptions(r1)     // Catch:{ Exception -> 0x0581 }
            r14.isCityNextClicked = r15     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.field1     // Catch:{ Exception -> 0x0581 }
            ue.c0 r2 = new ue.c0     // Catch:{ Exception -> 0x0581 }
            r2.<init>(r14)     // Catch:{ Exception -> 0x0581 }
            r0.setOnEditorActionListener(r2)     // Catch:{ Exception -> 0x0581 }
            goto L_0x04c5
        L_0x0482:
            com.materialedittext.MaterialEditText r0 = r14.field1     // Catch:{ Exception -> 0x0581 }
            r0.setImeOptions(r1)     // Catch:{ Exception -> 0x0581 }
            com.talabat.configuration.ConfigurationLocalRepository r0 = r14.f53498j     // Catch:{ Exception -> 0x0581 }
            com.talabat.configuration.country.Country r0 = r0.selectedCountry()     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r2 = r14.field1     // Catch:{ Exception -> 0x0581 }
            ue.d0 r3 = new ue.d0     // Catch:{ Exception -> 0x0581 }
            r3.<init>(r14, r0)     // Catch:{ Exception -> 0x0581 }
            r2.setOnEditorActionListener(r3)     // Catch:{ Exception -> 0x0581 }
            com.talabat.configuration.country.Country r2 = com.talabat.configuration.country.Country.UAE     // Catch:{ Exception -> 0x0581 }
            if (r0 != r2) goto L_0x049d
            r2 = r12
            goto L_0x049e
        L_0x049d:
            r2 = r15
        L_0x049e:
            com.talabat.configuration.country.Country r3 = com.talabat.configuration.country.Country.KSA     // Catch:{ Exception -> 0x0581 }
            if (r0 != r3) goto L_0x04a3
            r15 = r12
        L_0x04a3:
            r0 = r2 | r15
            if (r0 == 0) goto L_0x04c5
            com.materialedittext.MaterialEditText r0 = r14.city     // Catch:{ Exception -> 0x0581 }
            r0.setImeOptions(r1)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.city     // Catch:{ Exception -> 0x0581 }
            ue.e0 r2 = new ue.e0     // Catch:{ Exception -> 0x0581 }
            r2.<init>(r14)     // Catch:{ Exception -> 0x0581 }
            r0.setOnEditorActionListener(r2)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.area     // Catch:{ Exception -> 0x0581 }
            r0.setImeOptions(r1)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.area     // Catch:{ Exception -> 0x0581 }
            ue.f0 r2 = new ue.f0     // Catch:{ Exception -> 0x0581 }
            r2.<init>(r14)     // Catch:{ Exception -> 0x0581 }
            r0.setOnEditorActionListener(r2)     // Catch:{ Exception -> 0x0581 }
        L_0x04c5:
            int r0 = r14.SELECTED_CITY     // Catch:{ Exception -> 0x0581 }
            r14.hightlightCityId = r0     // Catch:{ Exception -> 0x0581 }
            com.talabat.configuration.ConfigurationLocalRepository r0 = r14.f53498j     // Catch:{ Exception -> 0x0581 }
            com.talabat.configuration.MutableLocationConfigurationRepository r2 = r14.f53499k     // Catch:{ Exception -> 0x0581 }
            boolean r0 = com.talabat.helpers.TalabatUtils.isMapPackageEnabledCountry(r0, r2)     // Catch:{ Exception -> 0x0581 }
            if (r0 != 0) goto L_0x04e1
            boolean r0 = com.talabat.helpers.TalabatUtils.isPartiallyMapPackageEnabledCountry()     // Catch:{ Exception -> 0x0581 }
            if (r0 == 0) goto L_0x04fa
            boolean r0 = r14.isMapcompulsory     // Catch:{ Exception -> 0x0581 }
            if (r0 != 0) goto L_0x04e1
            boolean r0 = r14.isNineCookiesTrackingEnabled     // Catch:{ Exception -> 0x0581 }
            if (r0 == 0) goto L_0x04fa
        L_0x04e1:
            androidx.fragment.app.FragmentManager r0 = r23.getSupportFragmentManager()     // Catch:{ Exception -> 0x0581 }
            r2 = 2131427499(0x7f0b00ab, float:1.8476616E38)
            androidx.fragment.app.Fragment r0 = r0.findFragmentById(r2)     // Catch:{ Exception -> 0x0581 }
            com.talabat.maps.presentation.MapContainerFragment r0 = (com.talabat.maps.presentation.MapContainerFragment) r0     // Catch:{ Exception -> 0x0581 }
            r2 = 0
            r0.init(r2)     // Catch:{ Exception -> 0x0581 }
            ue.g0 r2 = new ue.g0     // Catch:{ Exception -> 0x0581 }
            r2.<init>(r14)     // Catch:{ Exception -> 0x0581 }
            r0.getMapAsync(r2)     // Catch:{ Exception -> 0x0581 }
        L_0x04fa:
            boolean r0 = com.talabat.helpers.TalabatUtils.isRTL()     // Catch:{ Exception -> 0x0581 }
            if (r0 == 0) goto L_0x0578
            r2 = r22
            r2.setLayoutDirection(r12)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.field1     // Catch:{ Exception -> 0x0581 }
            r0.setTextDirection(r10)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.field2     // Catch:{ Exception -> 0x0581 }
            r0.setTextDirection(r10)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.field3     // Catch:{ Exception -> 0x0581 }
            r0.setTextDirection(r10)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.field4     // Catch:{ Exception -> 0x0581 }
            r0.setTextDirection(r10)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.field5     // Catch:{ Exception -> 0x0581 }
            r0.setTextDirection(r10)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.field6     // Catch:{ Exception -> 0x0581 }
            r0.setTextDirection(r10)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.field7     // Catch:{ Exception -> 0x0581 }
            r0.setTextDirection(r10)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.addressTypeEditText     // Catch:{ Exception -> 0x0581 }
            r0.setTextDirection(r10)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.hiddenMobile     // Catch:{ Exception -> 0x0581 }
            r0.setTextDirection(r10)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.phoneText     // Catch:{ Exception -> 0x0581 }
            r0.setTextDirection(r10)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.phoneCountryCode     // Catch:{ Exception -> 0x0581 }
            r0.setTextDirection(r10)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.directionsText     // Catch:{ Exception -> 0x0581 }
            r0.setTextDirection(r10)     // Catch:{ Exception -> 0x0581 }
            com.talabat.TalabatSpinner r0 = r14.addressType     // Catch:{ Exception -> 0x0581 }
            r0.setTextDirection(r10)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.area     // Catch:{ Exception -> 0x0581 }
            r0.setTextDirection(r10)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.city     // Catch:{ Exception -> 0x0581 }
            r0.setTextDirection(r10)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.mobileText     // Catch:{ Exception -> 0x0581 }
            r0.setTextDirection(r10)     // Catch:{ Exception -> 0x0581 }
            android.widget.Spinner r0 = r14.f53514z     // Catch:{ Exception -> 0x0581 }
            r0.setTextDirection(r10)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.mobileCountryCode     // Catch:{ Exception -> 0x0581 }
            r0.setTextDirection(r10)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.hiddenPhone     // Catch:{ Exception -> 0x0581 }
            r0.setTextDirection(r10)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.directionsText     // Catch:{ Exception -> 0x0581 }
            r0.setGravity(r1)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.mobileText     // Catch:{ Exception -> 0x0581 }
            r0.setGravity(r1)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.phoneText     // Catch:{ Exception -> 0x0581 }
            r0.setGravity(r1)     // Catch:{ Exception -> 0x0581 }
            com.materialedittext.MaterialEditText r0 = r14.hiddenPhone     // Catch:{ Exception -> 0x0581 }
            r0.setGravity(r1)     // Catch:{ Exception -> 0x0581 }
        L_0x0578:
            r23.inflateGemFooter()     // Catch:{ Exception -> 0x0581 }
            library.talabat.mvp.addressV2.IAddressPresenter r0 = r14.addressPresenter     // Catch:{ Exception -> 0x0581 }
            r0.onCreate()     // Catch:{ Exception -> 0x0581 }
            goto L_0x058b
        L_0x0581:
            r0 = move-exception
            com.talabat.talabatcore.logger.LogManager.logException(r0)
            r0.printStackTrace()
            r23.finish()
        L_0x058b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.AddAddressScreen2.onCreate(android.os.Bundle):void");
    }

    public void onCurrentLocationReceived(@Nullable com.google.android.gms.maps.model.LatLng latLng, boolean z11, float f11) {
    }

    public void onCurrentLocationReceivedWithLowAccuracy(@NotNull com.google.android.gms.maps.model.LatLng latLng, float f11) {
    }

    public void onError() {
    }

    public void onGeoLocationDialogAccepted(boolean z11) {
    }

    public /* synthetic */ void onInterestClicked(Restaurant restaurant) {
        a.g(this, restaurant);
    }

    public /* synthetic */ void onLeaveOfferClicked(boolean z11) {
        a.h(this, z11);
    }

    public void onLocationChanged(Location location) {
        locationRecieved(location);
    }

    public void onPause() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            GEMEngine.stopListening();
            showTimerView(true, "");
        }
        super.onPause();
        CurrentLocationFetch currentLocationFetch = this.B;
        if (currentLocationFetch != null && currentLocationFetch.isLoactionReequestInitied()) {
            this.B.stopLocationUpdates();
        }
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onRedirectToAreaScreen() {
        String str;
        Intent intent = new Intent(this, ChooseAreaScreen.class);
        if (this.isCityInAddress) {
            Gson gson = UniversalGson.INSTANCE.gson;
            Area[] areaArr = this.areas;
            if (!(gson instanceof Gson)) {
                str = gson.toJson((Object) areaArr);
            } else {
                str = GsonInstrumentation.toJson(gson, (Object) areaArr);
            }
            intent.putExtra("areas", str);
        }
        intent.putExtra(GlobalConstants.ExtraNames.SAVEAREA, false);
        intent.putExtra(GlobalConstants.ExtraNames.SHOWUSERADDRESS, false);
        intent.putExtra("cityIdFromAddress", true);
        intent.putExtra(GlobalConstants.ExtraNames.FORCEFILTERCITY, false);
        intent.putExtra(GlobalConstants.ExtraNames.SELECTED_CITY_ID, this.SELECTED_CITY);
        intent.putExtra("highlightAreaId", this.SELECTED_AREA);
        intent.putExtra("highlightCityId", this.hightlightCityId);
        intent.putExtra(GlobalConstants.ExtraNames.EDIT, this.isForEdit);
        startActivityForResult(intent, 10);
    }

    public void onRedirectToMapScreen(@Nullable LatLng latLng, boolean z11, boolean z12) {
        GeoCoordinate invoke = this.f53500l.invoke();
        if (!z12 || invoke == null || !TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.EXPERIMENT_PIN_LESS_CHECKOUT, false, TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            Intent intent = new Intent(this, MapsActivity.class);
            intent.putExtra("isOrderFlow", this.isOrderFlow);
            intent.putExtra("noAreaChange", this.noAreaChange);
            if (!(latLng == null || this.f53510v == null)) {
                intent.putExtra("location", "" + this.f53510v.getLatitude() + "," + this.f53510v.getLongitude());
                intent.putExtra("isAcurate", true);
            }
            if (this.isFromMapFirstFlow && !this.isGrlEnabled) {
                saveCoordinatesInGlobalDataModel(toOurs(HomeMapTemp.INSTANCE.getHomeMapSavedLatLng(), this.f53505q));
            }
            intent.putExtra("map_compulsory", this.isMapcompulsory);
            intent.putExtra("isFromCheckout", this.isFromCheckout);
            intent.putExtra("nineCookiesEnabled", this.isNineCookiesTrackingEnabled);
            intent.putExtra("talabatDeliveryAvailable", this.isTalabatDeliveryAvailable);
            intent.putExtra("address", this.f53508t);
            intent.putExtra("isNewAddressFromCartOrderFlow", this.isNewAddressFromCartFlow);
            intent.putExtra("isAddressFromCartOrderFlow", this.isAddressFromCartOrderFlow);
            intent.putExtra("newaddressCreation", this.isNewAddressCreation);
            intent.putExtra(GlobalConstants.FORCE_MAP.MAP_FROM_SIDEMENU, this.isMapFromSideMenu);
            intent.putExtra(GlobalConstants.FORCE_MAP.IS_EDIT_ADDRESS_FROM_SIDE_MENU, this.isEditAddressFromSideMenu);
            intent.putExtra("isFromHomeScreenMap", this.isFromMapFirstFlow);
            intent.putExtra("userSelectedAreaId", selectAreaForMap());
            intent.putExtra("isUserSelectedAreaName", SelectAreaName());
            intent.putExtra(GlobalConstants.ExtraNames.EDIT, this.isForEdit);
            if (z12) {
                startActivityForResult(intent, 99);
            } else {
                startActivityForResult(intent, 100);
            }
        } else {
            saveCoordinatesInGlobalDataModel(this.f53505q.createLatLng(invoke.getLatitude(), invoke.getLongitude()));
            boolean z13 = this.isMapFromSideMenu;
            handleSelectAddressAutomatic(false, false, false, z13, "", invoke.getLatitude() + "," + invoke.getLongitude());
        }
    }

    public void onRequestPermissionsResult(int i11, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i11, strArr, iArr);
        if (i11 == 500 && iArr.length > 0 && iArr[0] == 0) {
            this.addressPresenter.showMapForSelection(false);
        }
    }

    public void onResume() {
        showHideGemFooter(this.A, this, false);
        super.onResume();
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        LatLng latLng = this.f53510v;
        if (latLng != null) {
            bundle.putDouble(KEY_LATITUDE, latLng.getLatitude());
            bundle.putDouble(KEY_LONGITUDE, this.f53510v.getLongitude());
        }
        super.onSaveInstanceState(bundle);
    }

    public void onSpinnerClosed() {
        this.addressTypeSpinnerview.setVisibility(8);
    }

    public void onSpinnerOpened() {
    }

    public void onStart() {
        boolean z11;
        super.onStart();
        if (!(this instanceof FlutterAddressFormActivity)) {
            IAddressPresenter iAddressPresenter = this.addressPresenter;
            if (this.isEditAddressFromCheckoutScreen || this.isEditAddressFromSideMenu || this.isForEdit) {
                z11 = true;
            } else {
                z11 = false;
            }
            iAddressPresenter.onScreenStart(z11);
        }
    }

    public void onStatusChanged(String str, int i11, Bundle bundle) {
    }

    public void onValidationSuccess() {
        startLodingPopup();
    }

    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        if (this.addressType.hasBeenOpened() && z11) {
            if (this.addressTypeEditText.getText().toString().isEmpty()) {
                this.addressTypeEditText.setText(this.addressType.getSelectedItem().toString());
            }
            this.addressTypeSpinnerview.setVisibility(8);
        }
    }

    public void preRedirectCheck() {
        getMobile();
        getDirections();
        getPhone();
    }

    public void setAddressTypeText(int i11) {
        this.addressTypeEditText.setText(this.f53512x[i11]);
    }

    public void setArea(String str, int i11) {
        this.SELECTED_AREA_NAME = str;
        this.SELECTED_AREA = i11;
        this.area.setText(str);
    }

    public void setCity(String str, int i11) {
        this.SELECTED_CITY = i11;
        this.SELECTED_CITY_NAME = str;
        this.city.setText(str);
    }

    public void setCount(int i11) {
        this.fldCount = i11;
    }

    public void setCountryCode() {
        this.hiddenMobile.setFloatingLabelAlwaysShown(true);
        this.mobileCountryCode.setVisibility(0);
        Country selectedCountry = this.f53498j.selectedCountry();
        ArrayList<CountryCode> arrayList = this.allCountriesList;
        if (arrayList != null) {
            if (arrayList.size() > 0) {
                for (int i11 = 0; i11 < this.allCountriesList.size(); i11++) {
                    if (selectedCountry == Country.KUWAIT) {
                        if (this.allCountriesList.get(i11).dialCode.equals("+965")) {
                            this.f53514z.setSelection(i11);
                            this.mobileCountryCode.setText("+965");
                        }
                    } else if (selectedCountry == Country.KSA) {
                        if (this.allCountriesList.get(i11).dialCode.equals("+966")) {
                            this.f53514z.setSelection(i11);
                            this.mobileCountryCode.setText("+966");
                        }
                    } else if (selectedCountry == Country.BAHRAIN) {
                        if (this.allCountriesList.get(i11).dialCode.equals("+973")) {
                            this.f53514z.setSelection(i11);
                            this.mobileCountryCode.setText("+973");
                        }
                    } else if (selectedCountry == Country.OMAN) {
                        if (this.allCountriesList.get(i11).dialCode.equals("+968")) {
                            this.f53514z.setSelection(i11);
                            this.mobileCountryCode.setText("+968");
                        }
                    } else if (selectedCountry == Country.QATAR) {
                        if (this.allCountriesList.get(i11).dialCode.equals("+974")) {
                            this.f53514z.setSelection(i11);
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
                            this.f53514z.setSelection(i11);
                        }
                    } else if (isSelectedCountryEgypt(selectedCountry)) {
                        if (this.allCountriesList.get(i11).dialCode.equals("+20")) {
                            this.mobileCountryCode.setText("+20");
                            this.f53514z.setSelection(i11);
                        }
                    } else if (canSetIraqCountryCode(selectedCountry) && this.allCountriesList.get(i11).dialCode.equals("+964")) {
                        this.mobileCountryCode.setText("+964");
                        this.f53514z.setSelection(i11);
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
        } else if (isSelectedCountryEgypt(selectedCountry)) {
            this.mobileCountryCode.setText("+20");
        } else if (canSetIraqCountryCode(selectedCountry)) {
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
        this.field1.setError(getResources().getString(R.string.required));
        this.field1.setErrorColor(getResources().getColor(R.color.edit_text_error));
        this.addressNameOptionalHint.setTextColor(-65536);
        this.field1.requestFocus();
        this.field1.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
    }

    public void setErrorFeild2(int i11) {
        this.field2.setError(getResources().getString(R.string.required));
        this.field2.setErrorColor(getResources().getColor(R.color.edit_text_error));
        this.field2Hint.setTextColor(-65536);
        this.field2.requestFocus();
        this.field2.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
    }

    public void setErrorFeild3(int i11) {
        this.field3.setError(getResources().getString(R.string.required));
        this.field3.setErrorColor(getResources().getColor(R.color.edit_text_error));
        this.field3Hint.setTextColor(-65536);
        this.field3.requestFocus();
        this.field3.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
    }

    public void setErrorFeild4(int i11) {
        this.field4.setError(getResources().getString(R.string.required));
        this.field4.setErrorColor(getResources().getColor(R.color.edit_text_error));
        this.field4Hint.setTextColor(-65536);
        this.field4.requestFocus();
        this.field4.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
    }

    public void setErrorFeild5(int i11) {
        this.field5.setError(getResources().getString(R.string.required));
        this.field5.setErrorColor(getResources().getColor(R.color.edit_text_error));
        this.field5Hint.setTextColor(-65536);
        this.field5.requestFocus();
        this.field5.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
    }

    public void setErrorFeild6(int i11) {
        this.field6.setError(getResources().getString(R.string.required));
        this.field6.setErrorColor(getResources().getColor(R.color.edit_text_error));
        this.field6Hint.setTextColor(-65536);
        this.field6.requestFocus();
        this.field6.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
    }

    public void setErrorFeild7(int i11) {
        this.field7.setError(getResources().getString(R.string.required));
        this.field7.setErrorColor(getResources().getColor(R.color.edit_text_error));
        this.field7Hint.setTextColor(-65536);
        this.field7.requestFocus();
        this.field7.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
    }

    public void setErrorMobileField(int i11) {
        String str;
        String str2;
        if (TalabatUtils.isRTL()) {
            TalabatTextView talabatTextView = this.mobileArabicErrorText;
            if (talabatTextView != null) {
                talabatTextView.setVisibility(0);
                TalabatTextView talabatTextView2 = this.mobileArabicErrorText;
                if (i11 == 3) {
                    str2 = getResources().getString(R.string.uae_international_validation);
                } else {
                    str2 = getResources().getString(R.string.required);
                }
                talabatTextView2.setText(str2);
            }
        } else {
            MaterialEditText materialEditText = this.mobileText;
            if (i11 == 3) {
                str = getResources().getString(R.string.uae_international_validation);
            } else {
                str = getResources().getString(R.string.required);
            }
            materialEditText.setError(str);
            this.mobileText.setErrorColor(getResources().getColor(R.color.edit_text_error));
        }
        this.field8Hint.setTextColor(-65536);
        this.mobileText.requestFocus();
        this.mobileText.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
    }

    public void setErrorPhnField(int i11) {
        this.phoneText.setError(getResources().getString(R.string.required));
        this.phoneText.setErrorColor(getResources().getColor(R.color.edit_text_error));
        this.phoneText.requestFocus();
        this.phoneText.setHintTextColor(getResources().getColor(R.color.edit_text_hint));
        this.phoneText.setHint(getResources().getString(R.string.land_line_international_hint));
    }

    public void setFeild1(boolean z11, String str, boolean z12, int i11, boolean z13) {
        this.field1View.setVisibility(z11 ? 0 : 8);
        this.field1.setHint(str);
        this.field1.setFloatingLabelText(str);
        this.addressNameOptionalHint.setText(str);
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

    public void setGRL(String str) {
        this.grlString = str;
    }

    public void setGeoCodinates(LatLng latLng) {
        this.f53510v = latLng;
    }

    public void setGoogleMapView(@Nullable LatLng latLng) {
        LatLng latLng2;
        if (latLng != null) {
            latLng2 = latLng;
        } else {
            latLng2 = defaultLatLang();
        }
        this.mapaddressLatlang = latLng2;
        animateLocation(latLng);
    }

    public void setGrlId(String str) {
        this.grlId = str;
    }

    public void setMobile(String str, String str2) {
        this.mobileText.setText(str);
        this.hiddenMobile.setText(str);
        this.hiddenMobile.setTextColor(-1);
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
            setPhone(getPhone(), "", z11);
        }
        if (!TalabatUtils.isNullOrEmpty(getDirections())) {
            setDirections(getDirections());
        }
    }

    public void setPhone(String str, String str2, boolean z11) {
        String str3;
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
        this.isCityInAddress = z11;
        if (z11) {
            this.cityView.setVisibility(0);
        } else {
            this.cityView.setVisibility(8);
        }
    }

    public void showConfirmAddressPopup() {
        if (!this.f53503o.getFeatureFlag(TalabatFeatureFlagConstants.REMOVE_CONFIRM_ADDRESS_POP_UP, false)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
            androidx.appcompat.app.AlertDialog create = builder.create();
            builder.setTitle((CharSequence) getString(R.string.confirm_address));
            builder.setMessage((CharSequence) getString(R.string.confirm_address_description));
            builder.setPositiveButton((CharSequence) getString(R.string.f54881ok).toUpperCase(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                }
            });
            if (create != null && !create.isShowing()) {
                builder.show();
            }
        }
    }

    public /* synthetic */ void showGemDialog() {
        v00.a.a(this);
    }

    public void showGenericErrorMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage(getString(R.string.something_went_wrong));
        builder.setPositiveButton(R.string.f54881ok, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void showInAppReminder(int i11) {
        Context context = getContext();
        String string = getResources().getString(R.string.gem_order_notification);
        Toast.makeText(context, string.replace("#", "" + i11), 0).show();
    }

    public void showTimeOutDialog() {
        showGemTimeOutDialog((GemDialogSwitcher) null, this.A, this, this);
    }

    public void showTimerView(boolean z11, String str) {
        this.A.setTimerText(str);
    }

    public /* synthetic */ void stopLoading() {
        v00.a.e(this);
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

    @NonNull
    public LatLng t0() {
        return this.f53505q.createLatLng(29.375859d, 47.977405d);
    }

    public boolean u0() {
        return false;
    }

    public void updatePolygonServiceEnabled(boolean z11) {
        this.resPolygonServiceEnabled = z11;
    }

    public void onAddressValidationError(int i11, int i12) {
        String str;
        stopLodingPopup();
        if (i12 == AddressPresenter.ERRORMESSAGES.EMPTY_CITY) {
            str = getResources().getString(R.string.choose_city);
        } else {
            str = i12 == AddressPresenter.ERRORMESSAGES.EMPTY_AREA ? getResources().getString(R.string.choose_area) : "";
        }
        Toast.makeText(this, str, 0).show();
    }

    public void setFeild1(String str, boolean z11, boolean z12) {
        this.suggestName = str;
        this.field1.setText(str);
        if (z12) {
            z11 = true;
            this.field1.setEnabled(true);
        } else {
            this.field1.setEnabled(z11);
        }
        disableEditText(this.field1, z11);
    }

    public void setFeild2(String str, boolean z11, boolean z12, boolean z13) {
        this.field2.setText(str);
        if (z12) {
            z11 = true;
            this.field2.setEnabled(true);
        } else {
            this.field2.setEnabled(z11);
        }
        disableEditText(this.field2, z11);
    }

    public void setFeild3(String str, boolean z11, boolean z12) {
        this.field3.setText(str);
        if (z12) {
            z11 = true;
            this.field3.setEnabled(true);
        } else {
            this.field3.setEnabled(z11);
        }
        disableEditText(this.field3, z11);
    }

    public void setFeild4(String str, boolean z11, boolean z12) {
        this.field4.setText(str);
        if (z12) {
            z11 = true;
            this.field4.setEnabled(true);
        } else {
            this.field4.setEnabled(z11);
        }
        disableEditText(this.field4, z11);
    }

    public void setFeild5(String str, boolean z11, boolean z12) {
        this.field5.setText(str);
        if (z12) {
            z11 = true;
            this.field5.setEnabled(true);
        } else {
            this.field5.setEnabled(z11);
        }
        disableEditText(this.field5, z11);
    }

    public void setFeild6(String str, boolean z11, boolean z12) {
        this.field6.setText(str);
        if (z12) {
            z11 = true;
            this.field6.setEnabled(true);
        } else {
            this.field6.setEnabled(z11);
        }
        disableEditText(this.field6, z11);
    }

    public void setFeild7(String str, boolean z11, boolean z12) {
        this.field7.setText(str);
        if (z12) {
            z11 = true;
            this.field7.setEnabled(true);
        } else {
            this.field7.setEnabled(z11);
        }
        disableEditText(this.field7, z11);
    }
}
