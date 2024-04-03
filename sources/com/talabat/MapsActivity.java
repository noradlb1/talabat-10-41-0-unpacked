package com.talabat;

import JsonModels.Request.McdBranchRequest;
import JsonModels.Response.McdBlockAddressResponse;
import JsonModels.Response.McdStreetAddressResponse;
import JsonModels.parser.UniversalGson;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.Uri;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import buisnessmodels.Cart;
import buisnessmodels.GEMEngine;
import buisnessmodels.ShowCaseViewLogic;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.gson.Gson;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.materialedittext.MaterialEditText;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.map.DaggerMapsActivityComponent;
import com.talabat.domain.address.Address;
import com.talabat.fragments.CustomAutoCompleteFragment;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.MapWrapperLayout;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.homemaphelper.CurrentLocationFetch;
import com.talabat.homemaphelper.CurrentLocationListener;
import com.talabat.location.domain.di.LocationCoreLibApi;
import com.talabat.maps.domain.CameraUpdateFactory;
import com.talabat.maps.domain.FrameworkMap;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.MapsInitializer;
import com.talabat.maps.domain.ModelsRepository;
import com.talabat.maps.domain.OnMapReadyCallback;
import com.talabat.maps.domain.di.MapsCoreLibApi;
import com.talabat.maps.domain.model.LatLng;
import com.talabat.maps.domain.model.LatLngBounds;
import com.talabat.maps.domain.model.Polygon;
import com.talabat.maps.presentation.MapContainerFragment;
import com.talabat.maputils.CurrentLocHelper;
import com.talabat.maputils.PolyUtil;
import com.talabat.restaurants.RestaurantsListScreenRefactor;
import datamodels.McdBlocks;
import datamodels.Restaurant;
import datamodels.analyticstrackermodels.AddressAnalyticsTracker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import library.talabat.gemengine.GemView;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.googlemaps.GoogleMapView;
import library.talabat.mvp.googlemaps.ITalabatMapPresenter;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import tracking.AppTracker;
import tracking.ScreenNames;
import tracking.gtm.TrackingUtils;
import ue.ab;
import ue.za;
import yq.a;

@Instrumented
public class MapsActivity extends TalabatBase implements OnMapReadyCallback, GoogleMapView, MapWrapperLayout.UpdateMapAfterUserInterection, GemView, OnGemAlertDialogClickListener, CurrentLocationListener, CustomAutoCompleteFragment.OnFragmentInteractionListener {
    private static final int ANIMATE_CAMERA_MAX_INTERVAL = 1000;
    private static final long FADE_DEFAULT_TIME = 300;
    private static final long MOVE_DEFAULT_TIME = 1000;
    private static final int PLACESSEARCH = 36;
    public static int REQUEST_CHECK_SETTINGS = 100;
    public CustomAutoCompleteFragment A;
    @Inject
    public AppVersionProvider B;
    @Inject
    public ITalabatFeatureFlag C;
    /* access modifiers changed from: private */
    public View CustonGooglesearchContainer;
    @Inject
    public LocationConfigurationRepository D;
    @Inject
    public ModelsRepository E;
    @Inject
    public LatLngFactory F;
    @Inject
    public MapsInitializer G;
    @Inject
    public SecretProvider H;
    /* access modifiers changed from: private */
    public TextView Title;
    /* access modifiers changed from: private */
    public int addressSelectionType;
    private String addressString = "";
    private AlertDialog alertDialog;
    private TextView autofillDescription;
    /* access modifiers changed from: private */
    public ImageButton backButton;
    /* access modifiers changed from: private */
    public View boardingContentView;
    /* access modifiers changed from: private */
    public boolean cameraFinished;
    /* access modifiers changed from: private */
    public Button cancelButton;
    /* access modifiers changed from: private */
    public Button confim;
    private View confirmContainer;
    private View confirmsView;
    /* access modifiers changed from: private */
    public LatLng currentGPSLocation = null;
    private View customMapView;
    private TalabatTextView deliverHere;
    private String deliveryAddressStatus = "";
    private String description;
    private ImageView dragTutorialClose;
    /* access modifiers changed from: private */
    public View dragTutorialContainer;
    private Button fullBodyButton;
    private View gemReminderView;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public CameraUpdateFactory f54322i;
    private boolean initialSlideUpAnimation = true;
    /* access modifiers changed from: private */
    public boolean isAddressFromCartOrderFlow;
    private boolean isAreaPolygonCheckNeed;
    /* access modifiers changed from: private */
    public boolean isCameraSettled;
    /* access modifiers changed from: private */
    public boolean isEditAddress;
    /* access modifiers changed from: private */
    public boolean isEditAddressFromSideMenu;
    private boolean isFromMapFirstFlow;
    /* access modifiers changed from: private */
    public boolean isFromMcdGrlFlow;
    /* access modifiers changed from: private */
    public boolean isGrlAddressEditDisabled;
    /* access modifiers changed from: private */
    public boolean isInitialMapZoom;
    /* access modifiers changed from: private */
    public boolean isLocationAwararnessPopupShown;
    /* access modifiers changed from: private */
    public boolean isLocationClicked;
    /* access modifiers changed from: private */
    public boolean isLocationPermissionAllowed;
    /* access modifiers changed from: private */
    public boolean isMapcompulsory;
    /* access modifiers changed from: private */
    public boolean isMcdSpinnerInitial = true;
    /* access modifiers changed from: private */
    public boolean isNeedShowDragTutorial;
    /* access modifiers changed from: private */
    public boolean isNewAddessCreationFromSideMenu;
    /* access modifiers changed from: private */
    public boolean isNewAddress;
    /* access modifiers changed from: private */
    public boolean isNewAddressFromCartFlow;
    /* access modifiers changed from: private */
    public boolean isNineCookiesTrackingEnabled;
    private boolean isQuick = false;
    private boolean isRegOrderFlow;
    private boolean isTalabatDeliveryAvailable;

    /* renamed from: j  reason: collision with root package name */
    public boolean f54323j;

    /* renamed from: k  reason: collision with root package name */
    public String f54324k = "";

    /* renamed from: l  reason: collision with root package name */
    public Polygon f54325l;
    public LatLng latLngmain;
    /* access modifiers changed from: private */
    public View locAwarContainer;
    /* access modifiers changed from: private */
    public LinearLayout locationBtnContainer;
    /* access modifiers changed from: private */
    public ImageView locationButton;
    private LocationManager locationManager;
    /* access modifiers changed from: private */
    public String locationMethod;
    /* access modifiers changed from: private */
    public View locationbBtnSubContainer;

    /* renamed from: m  reason: collision with root package name */
    public Polygon f54326m;
    private GemDialogSwitcher mGemDialogSwitcher;
    /* access modifiers changed from: private */
    @Nullable
    public FrameworkMap mMap;
    /* access modifiers changed from: private */
    public RelativeLayout mSearchContainer;
    private Toolbar mToolbar;
    /* access modifiers changed from: private */
    @Nullable
    public LatLng mainCameraLatlang = null;
    @Nullable
    private MapContainerFragment mapFragment;
    private String mapJourneytype = "";
    private View mapOnBoardingcontentView;
    /* access modifiers changed from: private */
    public ImageView mapPin;
    /* access modifiers changed from: private */
    public ImageView mapToolbarSearch;
    /* access modifiers changed from: private */
    public ImageView mapViewSwitchBtn;
    private View mcdArrow;
    /* access modifiers changed from: private */
    public TalabatTextView mcdBlockNoHintTxt;
    /* access modifiers changed from: private */
    public TalabatTextView mcdBlockNoTxt;
    /* access modifiers changed from: private */
    public View mcdBlockSectionContainer;
    /* access modifiers changed from: private */
    public TalabatSpinner mcdBlockSpinner;
    private Button mcdConfirmBtn;
    private RelativeLayout mcdDisableContainer;
    private Button mcdEditLocationBtn;
    /* access modifiers changed from: private */
    public View mcdFlowConfirmContainer;
    private TextView mcdFlowShowCaseTxt;
    private Button mcdKsaEditLocationBtn;
    /* access modifiers changed from: private */
    public Button mcdKsaProceedBtn;
    /* access modifiers changed from: private */
    public MaterialEditText mcdKsaStreetEdtFld;
    /* access modifiers changed from: private */
    public View mcdKsaStreetSection;
    private Button mcdProceedBtn;
    private View mcdSectionContainer;
    private Button mcdShowCaseBtn;
    /* access modifiers changed from: private */
    public View mcdShowCaseView;
    private View mcdSpinnerSectionView;
    /* access modifiers changed from: private */
    public TextView mcdStreetLabel;
    private LinearLayout myLocationCustomButtonGroup;

    /* renamed from: n  reason: collision with root package name */
    public int f54327n;
    private boolean noAreaChange;
    /* access modifiers changed from: private */
    public View normalConifirmContainer;

    /* renamed from: o  reason: collision with root package name */
    public float f54328o;
    private ImageView onBoardingGifImg;
    private Button onBoardingGotIt;
    private ImageView onBoardingStatciImg;

    /* renamed from: p  reason: collision with root package name */
    public GemFooterCartView f54329p;
    private PlacesClient placesClient;
    private boolean polygonAdded;
    private String polygonAwayAreaName;
    private Dialog popupWindow;

    /* renamed from: q  reason: collision with root package name */
    public String f54330q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f54331r;
    private boolean redirectGPSSettings;
    private boolean resPoryGonAvailable;
    /* access modifiers changed from: private */
    public TalabatTextView resetLocation;
    /* access modifiers changed from: private */
    public int restaurantId = -1;

    /* renamed from: s  reason: collision with root package name */
    public boolean f54332s;
    private int satliteViewVarient = 0;
    private Button skipBtn;

    /* renamed from: t  reason: collision with root package name */
    public String f54333t = "";
    /* access modifiers changed from: private */
    public ITalabatMapPresenter talabatMapPresenter;
    /* access modifiers changed from: private */
    public LatLng tempAddress = null;
    private double trackingDistance = 0.0d;

    /* renamed from: u  reason: collision with root package name */
    public CurrentLocationFetch f54334u;
    /* access modifiers changed from: private */
    public boolean userIntractedWithMap;
    private LatLng userSavedLocation;
    /* access modifiers changed from: private */
    public int userSelectedAreaId;
    /* access modifiers changed from: private */
    public float userSelectedZoom;

    /* renamed from: v  reason: collision with root package name */
    public boolean f54335v;
    /* access modifiers changed from: private */
    public boolean validateWithPolygon;

    /* renamed from: w  reason: collision with root package name */
    public String f54336w;
    private boolean waitLoadTutorial;

    /* renamed from: x  reason: collision with root package name */
    public AutocompleteSupportFragment f54337x = null;

    /* renamed from: y  reason: collision with root package name */
    public FragmentManager f54338y;

    /* renamed from: z  reason: collision with root package name */
    public FragmentTransaction f54339z;

    public class CustomSpinnerAdapter extends ArrayAdapter<McdBlocks> {

        /* renamed from: b  reason: collision with root package name */
        public LayoutInflater f54385b;

        public class viewHolder {

            /* renamed from: a  reason: collision with root package name */
            public TextView f54389a;

            /* renamed from: b  reason: collision with root package name */
            public View f54390b;

            private viewHolder() {
            }
        }

        public CustomSpinnerAdapter(Activity activity, int i11, int i12, List<McdBlocks> list) {
            super(activity, i11, i12, list);
        }

        private View rowview(View view, int i11) {
            viewHolder viewholder;
            View view2;
            final McdBlocks mcdBlocks = (McdBlocks) getItem(i11);
            if (view == null) {
                viewholder = new viewHolder();
                LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
                this.f54385b = layoutInflater;
                view2 = layoutInflater.inflate(R.layout.block_list_item, (ViewGroup) null, false);
                viewholder.f54389a = (TextView) view2.findViewById(R.id.block_spinner_txt);
                viewholder.f54390b = view2.findViewById(R.id.convertView);
                view2.setTag(viewholder);
            } else {
                view2 = view;
                viewholder = (viewHolder) view.getTag();
            }
            viewholder.f54389a.setText(mcdBlocks.blockId);
            viewholder.f54390b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MapsActivity.this.setMcdProceedEnable(true);
                    MapsActivity.this.mcdBlockNoTxt.setVisibility(8);
                    MapsActivity.this.mcdBlockNoHintTxt.setVisibility(0);
                    MapsActivity.this.mcdBlockNoHintTxt.setTextColor(MapsActivity.this.getResources().getColor(R.color.talabat_black));
                    MapsActivity.this.mcdBlockNoHintTxt.setText(mcdBlocks.blockId);
                    MapsActivity mapsActivity = MapsActivity.this;
                    mapsActivity.f54330q = mcdBlocks.blockId;
                    mapsActivity.mcdBlockSpinner.setVisibility(8);
                }
            });
            return view2;
        }

        public View getDropDownView(int i11, View view, ViewGroup viewGroup) {
            return rowview(view, i11);
        }

        public View getView(int i11, View view, ViewGroup viewGroup) {
            return rowview(view, i11);
        }
    }

    private void LocationMissRedirection(Address address) {
        String str;
        String str2;
        Intent intent = new Intent();
        clearAreaPolygonProperties();
        intent.putExtra("map_compulsory", this.isMapcompulsory);
        intent.putExtra("nineCookiesEnabled", this.isNineCookiesTrackingEnabled);
        intent.putExtra("isAddressFromCartOrderFlow", this.isAddressFromCartOrderFlow);
        intent.putExtra(GlobalConstants.FORCE_MAP.LOCATION_MIS_MATCH, true);
        intent.putExtra("newaddressCreation", this.isNewAddress);
        intent.putExtra("location", "" + this.latLngmain.getLatitude() + "," + this.latLngmain.getLongitude());
        intent.putExtra(GlobalConstants.FORCE_MAP.MAP_FROM_SIDEMENU, this.isNewAddessCreationFromSideMenu);
        intent.putExtra(GlobalConstants.FORCE_MAP.IS_EDIT_ADDRESS_FROM_SIDE_MENU, this.isEditAddressFromSideMenu);
        intent.putExtra(GlobalConstants.INFOR_MAP.IS_DISABLE_ADDRESS_EDIT_GRL_CART, this.isGrlAddressEditDisabled);
        intent.putExtra(GlobalConstants.INFOR_MAP.IS_MCD_KSA_UPDATE_LOCATION, true);
        intent.putExtra("skip", false);
        if (TalabatUtils.isAddressBlockEnabledCountry()) {
            Gson gson = UniversalGson.INSTANCE.gson;
            if (!(gson instanceof Gson)) {
                str2 = gson.toJson((Object) address);
            } else {
                str2 = GsonInstrumentation.toJson(gson, (Object) address);
            }
            this.addressString = str2;
            intent.putExtra("address", str2);
        } else {
            boolean z11 = this.isNewAddress;
            if (z11 && this.isAddressFromCartOrderFlow) {
                intent.putExtra("address", "");
            } else if (z11 && !this.isAddressFromCartOrderFlow) {
                Gson gson2 = UniversalGson.INSTANCE.gson;
                if (!(gson2 instanceof Gson)) {
                    str = gson2.toJson((Object) address);
                } else {
                    str = GsonInstrumentation.toJson(gson2, (Object) address);
                }
                this.addressString = str;
                if (this.isEditAddress) {
                    intent.putExtra("address", "");
                    intent.putExtra(GlobalConstants.ExtraNames.EDIT, true);
                } else {
                    intent.putExtra("address", str);
                }
            } else if (this.isQuick) {
                intent.putExtra("address", "");
            } else if (this.isEditAddress) {
                intent.putExtra(GlobalConstants.ExtraNames.EDIT, true);
                intent.putExtra("address", "");
            }
        }
        GlobalDataModel.GEO_CORDINATES.saveTempZoomLevel = this.userSelectedZoom;
        stopLodingPopup();
        setResult(-1, intent);
        AppTracker.onMapClosed(this, "");
        finish();
    }

    /* access modifiers changed from: private */
    public void animateOnBoarding() {
        this.onBoardingStatciImg.animate().alpha(0.0f);
        this.onBoardingGifImg.setVisibility(0);
        Glide.with((FragmentActivity) this).load(Integer.valueOf(R.raw.onboarding)).into(new DrawableImageViewTarget(this.onBoardingGifImg) {
            public void onResourceReady(Drawable drawable, @Nullable Transition<? super Drawable> transition) {
                if (drawable instanceof GifDrawable) {
                    ((GifDrawable) drawable).setLoopCount(1);
                }
                super.onResourceReady(drawable, transition);
            }
        });
    }

    private void animtLocationBtn(Boolean bool) {
        int i11;
        ValueAnimator valueAnimator;
        int i12;
        try {
            if (this.mapViewSwitchBtn.getVisibility() == 4) {
                this.mapViewSwitchBtn.setVisibility(0);
            }
            if (this.locationBtnContainer.getVisibility() == 4) {
                this.locationBtnContainer.setVisibility(0);
            }
            int i13 = 90;
            int i14 = 80;
            if (!GlobalDataModel.GEMCONSTANTS.isGemFlow) {
                int i15 = 62;
                if (TalabatUtils.isRTL()) {
                    if (!this.isLocationAwararnessPopupShown) {
                        i13 = 62;
                    }
                    i11 = getPixelFromDp(i13);
                } else {
                    if (this.isLocationAwararnessPopupShown) {
                        i15 = 80;
                    }
                    i11 = getPixelFromDp(i15);
                }
            } else if (TalabatUtils.isRTL()) {
                if (this.isFromMcdGrlFlow) {
                    i12 = 80;
                } else {
                    i12 = 110;
                }
                i11 = getPixelFromDp(i12);
            } else {
                boolean z11 = this.isFromMcdGrlFlow;
                i11 = getPixelFromDp(90);
            }
            if (!bool.booleanValue()) {
                valueAnimator = ValueAnimator.ofInt(new int[]{0, getPixelFromDp(i11)});
            } else if (TalabatUtils.isRTL()) {
                int[] iArr = new int[2];
                iArr[0] = getPixelFromDp(i11);
                if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
                    i14 = Opcodes.F2L;
                }
                iArr[1] = getPixelFromDp(i14);
                valueAnimator = ValueAnimator.ofInt(iArr);
            } else {
                int[] iArr2 = new int[2];
                iArr2[0] = getPixelFromDp(i11);
                if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
                    i14 = 130;
                }
                iArr2[1] = getPixelFromDp(i14);
                valueAnimator = ValueAnimator.ofInt(iArr2);
            }
            valueAnimator.setDuration(200);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    MapsActivity.this.locationBtnContainer.requestLayout();
                    ((RelativeLayout.LayoutParams) MapsActivity.this.locationBtnContainer.getLayoutParams()).setMargins(0, 0, 0, Integer.parseInt(valueAnimator.getAnimatedValue().toString()));
                }
            });
            valueAnimator.start();
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void autoCompledWidgetSelection(Place place) {
        if (place != null) {
            this.locationMethod = TrackingUtils.INSTANCE.getLocationMethodAutocomplete();
            LatLng ours = toOurs(place.getLatLng(), this.F);
            this.latLngmain = ours;
            this.userIntractedWithMap = true;
            confirmButtonEnable(ours);
            this.talabatMapPresenter.mapLoadingCompleted();
            this.isInitialMapZoom = false;
            changeCamera(this.latLngmain, 3.0f, 50.0f, 3000);
        }
    }

    private void buttonDisable(Button button) {
        if (button != null) {
            button.setVisibility(8);
        }
    }

    private void buttonEnable(Button button) {
        if (button != null) {
            button.setVisibility(0);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.talabat.maps.domain.model.CameraPosition cameraPositionBuilder(@androidx.annotation.Nullable com.talabat.maps.domain.model.LatLng r5, float r6, float r7, int r8) {
        /*
            r4 = this;
            com.talabat.maps.domain.FrameworkMap r0 = r4.mMap
            r1 = 0
            if (r0 == 0) goto L_0x0011
            float r2 = com.talabat.helpers.GlobalDataModel.GEO_CORDINATES.saveTempZoomLevel
            int r3 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x000c
            goto L_0x0015
        L_0x000c:
            float r0 = r0.getMaxZoomLevel()
            goto L_0x0013
        L_0x0011:
            r0 = 1101529088(0x41a80000, float:21.0)
        L_0x0013:
            float r2 = r0 - r6
        L_0x0015:
            r4.mainCameraLatlang = r5
            r4.f54328o = r7
            r4.f54327n = r8
            if (r5 == 0) goto L_0x001e
            goto L_0x0022
        L_0x001e:
            com.talabat.maps.domain.model.LatLng r5 = r4.defaultLatLang()
        L_0x0022:
            com.talabat.maps.domain.ModelsRepository r6 = r4.E
            com.talabat.maps.domain.model.CameraPosition$Builder r6 = r6.newCameraPositionBuilder()
            com.talabat.maps.domain.model.CameraPosition$Builder r5 = r6.target(r5)
            com.talabat.maps.domain.model.CameraPosition$Builder r5 = r5.zoom(r2)
            com.talabat.maps.domain.model.CameraPosition$Builder r5 = r5.bearing(r1)
            com.talabat.maps.domain.model.CameraPosition$Builder r5 = r5.tilt(r1)
            com.talabat.maps.domain.model.CameraPosition r5 = r5.build()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.MapsActivity.cameraPositionBuilder(com.talabat.maps.domain.model.LatLng, float, float, int):com.talabat.maps.domain.model.CameraPosition");
    }

    /* access modifiers changed from: private */
    public void changeCamera(@Nullable LatLng latLng, float f11, float f12, int i11) {
        FrameworkMap frameworkMap = this.mMap;
        if (frameworkMap != null) {
            frameworkMap.animateCamera(this.f54322i.newCameraPosition(cameraPositionBuilder(latLng, f11, f12, i11)), 1000, new FrameworkMap.CancelableCallback() {
                public void onCancel() {
                    MapsActivity.this.cameraFinished = true;
                }

                public void onFinish() {
                    MapsActivity.this.cameraFinished = true;
                }
            });
        }
    }

    private void confirmButtonClicked(LatLng latLng) {
        Object obj;
        AppTracker.onMapConfirmed(this, "");
        FrameworkMap frameworkMap = this.mMap;
        boolean z11 = false;
        if (frameworkMap != null && frameworkMap.getMapType() == FrameworkMap.MapType.MAP_TYPE_SATELLITE) {
            z11 = true;
        }
        boolean z12 = z11;
        startLodingPopup();
        if (this.isFromMcdGrlFlow) {
            startLodingPopup();
            this.talabatMapPresenter.getMcdConvertToAddress(this.userSelectedAreaId, this.restaurantId, "", true, z12, toGoogle(this.latLngmain));
        } else if (!TalabatUtils.isNullOrEmpty(this.addressString)) {
            Gson gson = UniversalGson.INSTANCE.gson;
            String str = this.addressString;
            Class cls = Address.class;
            if (!(gson instanceof Gson)) {
                obj = gson.fromJson(str, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson, str, cls);
            }
            Address address = (Address) obj;
            if (this.isNewAddress && !this.isEditAddressFromSideMenu) {
                this.talabatMapPresenter.confirmButtonPressed(toGoogle(this.latLngmain), this.isNewAddessCreationFromSideMenu, this.validateWithPolygon, this.isAddressFromCartOrderFlow, this.isEditAddressFromSideMenu, z12);
            } else if (this.isQuick) {
                this.talabatMapPresenter.confirmButtonPressed(toGoogle(this.latLngmain), this.isNewAddessCreationFromSideMenu, this.validateWithPolygon, this.isAddressFromCartOrderFlow, this.isEditAddressFromSideMenu, z12);
            } else if (this.isEditAddressFromSideMenu) {
                this.talabatMapPresenter.confirmButtonPressed(toGoogle(this.latLngmain), this.isNewAddessCreationFromSideMenu, this.validateWithPolygon, this.isAddressFromCartOrderFlow, this.isEditAddressFromSideMenu, z12);
            } else {
                this.talabatMapPresenter.updateGeoCordinates(toGoogle(this.latLngmain), address, this.validateWithPolygon, this.isEditAddressFromSideMenu, z12);
            }
            TrackingUtils trackingUtils = TrackingUtils.INSTANCE;
            this.deliveryAddressStatus = trackingUtils.getAddressMethodSaved();
            this.locationMethod = trackingUtils.getAddressMethodSaved();
        } else {
            this.talabatMapPresenter.confirmButtonPressed(toGoogle(this.latLngmain), this.isNewAddessCreationFromSideMenu, this.validateWithPolygon, this.isAddressFromCartOrderFlow, this.isEditAddressFromSideMenu, z12);
            this.deliveryAddressStatus = TrackingUtils.INSTANCE.getAddressMethodNew();
        }
    }

    /* access modifiers changed from: private */
    public void confirmButtonDesesionMaker(boolean z11, int i11) {
        boolean z12;
        if (GlobalConstants.isDrawCountryPolygon) {
            LatLng latLng = this.latLngmain;
            if (latLng != null) {
                Polygon polygon = this.f54326m;
                boolean z13 = false;
                if (polygon == null || polygon.getPoints() == null) {
                    z12 = false;
                } else {
                    z13 = true;
                    z12 = PolyUtil.containsLocation(this.latLngmain, this.f54326m.getPoints());
                }
                Polygon polygon2 = this.f54325l;
                if (polygon2 == null) {
                    confirmButtonClicked(this.latLngmain);
                } else if (polygon2.getPoints() == null) {
                    confirmButtonClicked(this.latLngmain);
                } else if (!PolyUtil.containsLocation(this.latLngmain, this.f54325l.getPoints())) {
                    showAddressOutsideCountry();
                } else if (i11 != GlobalDataModel.MAP_ADDRESS_TYPE.MANUAL_MAP_ADDRESS && !this.isFromMcdGrlFlow) {
                    confirmButtonClicked(this.latLngmain);
                } else if (!this.validateWithPolygon) {
                    confirmButtonClicked(this.latLngmain);
                } else if (!z13) {
                    confirmButtonClicked(this.latLngmain);
                } else if (z12) {
                    confirmButtonClicked(this.latLngmain);
                } else if (z13) {
                    showAddressOutsideSelectedArea();
                } else {
                    confirmButtonClicked(this.latLngmain);
                }
            } else {
                confirmButtonClicked(latLng);
            }
        } else if (this.latLngmain != null) {
            startLodingPopup();
            confirmButtonClicked(this.latLngmain);
        }
    }

    /* access modifiers changed from: private */
    public void confirmButtonEnable(LatLng latLng) {
        Button button;
        if (latLng != null && (button = this.confim) != null && this.userIntractedWithMap) {
            button.setEnabled(true);
            this.confim.setClickable(true);
            this.confim.setAlpha(1.0f);
            Button button2 = this.mcdConfirmBtn;
            if (button2 != null) {
                button2.setEnabled(true);
                this.mcdConfirmBtn.setClickable(true);
                this.mcdConfirmBtn.setAlpha(1.0f);
            }
            mapDragTutorial(false);
        } else if (!GlobalDataModel.GEO_CORDINATES.isUserInteractedWithMapLocation || !this.isCameraSettled) {
            Button button3 = this.mcdConfirmBtn;
            if (button3 != null) {
                button3.setEnabled(false);
                this.mcdConfirmBtn.setAlpha(0.5f);
                this.mcdConfirmBtn.setClickable(true);
            }
            this.confim.setEnabled(false);
            this.confim.setAlpha(0.5f);
            this.confim.setClickable(true);
            if (this.isCameraSettled && this.cameraFinished) {
                mapDragTutorial(true);
            }
        } else {
            this.confim.setEnabled(true);
            this.confim.setClickable(true);
            this.confim.setAlpha(1.0f);
            Button button4 = this.mcdConfirmBtn;
            if (button4 != null) {
                button4.setEnabled(true);
                this.mcdConfirmBtn.setClickable(true);
                this.mcdConfirmBtn.setAlpha(1.0f);
                mapDragTutorial(false);
            }
        }
    }

    private LatLngBounds countryLatLangBound() {
        if (GlobalDataModel.SelectedCountryId == Country.KUWAIT.getCountryId()) {
            LatLngFactory latLngFactory = this.F;
            return latLngFactory.createLatLngBounds(latLngFactory.createLatLng(28.408312587374258d, 46.395263671875d), this.F.createLatLng(30.261439550638762d, 48.85345458984374d));
        } else if (GlobalDataModel.SelectedCountryId == Country.KSA.getCountryId()) {
            LatLngFactory latLngFactory2 = this.F;
            return latLngFactory2.createLatLngBounds(latLngFactory2.createLatLng(5.834616165610059d, 25.3125d), this.F.createLatLng(46.31658418182218d, 66.26953125d));
        } else if (GlobalDataModel.SelectedCountryId == Country.BAHRAIN.getCountryId()) {
            LatLngFactory latLngFactory3 = this.F;
            return latLngFactory3.createLatLngBounds(latLngFactory3.createLatLng(25.611809521055477d, 50.07019042968749d), this.F.createLatLng(26.745610382199022d, 50.8282470703125d));
        } else if (GlobalDataModel.SelectedCountryId == Country.QATAR.getCountryId()) {
            LatLngFactory latLngFactory4 = this.F;
            return latLngFactory4.createLatLngBounds(latLngFactory4.createLatLng(23.96115620034201d, 50.548095703125d), this.F.createLatLng(26.61799672211676d, 51.6961669921875d));
        } else if (GlobalDataModel.SelectedCountryId == Country.OMAN.getCountryId()) {
            LatLngFactory latLngFactory5 = this.F;
            return latLngFactory5.createLatLngBounds(latLngFactory5.createLatLng(14.370833973406821d, 48.09814453125d), this.F.createLatLng(28.671310915880834d, 62.314453125d));
        } else if (GlobalDataModel.SelectedCountryId != Country.UAE.getCountryId()) {
            return null;
        } else {
            LatLngFactory latLngFactory6 = this.F;
            return latLngFactory6.createLatLngBounds(latLngFactory6.createLatLng(18.239134d, 47.746582d), this.F.createLatLng(29.806987d, 58.590088d));
        }
    }

    /* access modifiers changed from: private */
    public void currentLocationBtnClicked(boolean z11) {
        if (this.f54334u.userAllowedAllLocationPermissions(this)) {
            FrameworkMap frameworkMap = this.mMap;
            if (frameworkMap != null) {
                frameworkMap.setMyLocationEnabled(true);
                legacyHideLocationButton(true);
                ITalabatMapPresenter iTalabatMapPresenter = this.talabatMapPresenter;
                if (iTalabatMapPresenter != null) {
                    iTalabatMapPresenter.waitForCurrentLocation(false);
                }
                if (z11 && GlobalDataModel.HOME_SCREEN_MAP.REFRSH_LOCATION_FROM_BG) {
                    this.f54334u.initLocationRequest(this, CurrentLocHelper.INSTANCE.getIS_FROM_MAP_CURRENT_LOC_ADDRESS());
                    this.f54334u.fetchCurrentLocation();
                    return;
                }
                return;
            }
            return;
        }
        this.f54334u.fetchCurrentLocation();
    }

    private void currentLocationReceived(LatLng latLng) {
        this.currentGPSLocation = latLng;
        if (this.mMap != null) {
            LinearLayout linearLayout = this.locationBtnContainer;
            if (linearLayout != null) {
                this.isLocationPermissionAllowed = true;
                linearLayout.setVisibility(0);
            }
            ITalabatMapPresenter iTalabatMapPresenter = this.talabatMapPresenter;
            if (iTalabatMapPresenter != null) {
                iTalabatMapPresenter.waitForCurrentLocation(false);
                this.talabatMapPresenter.currentLocationReceived(toGoogle(latLng), this.f54324k);
            }
        }
    }

    private LatLng defaultLatLang() {
        if (GlobalDataModel.SelectedCountryId == Country.KUWAIT.getCountryId()) {
            return this.F.createLatLng(29.375859d, 47.977405d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.KSA.getCountryId()) {
            return this.F.createLatLng(24.671666d, 46.702881d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.BAHRAIN.getCountryId()) {
            return this.F.createLatLng(26.228516d, 50.58605d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.QATAR.getCountryId()) {
            return this.F.createLatLng(25.285447d, 51.53104d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.OMAN.getCountryId()) {
            return this.F.createLatLng(23.58589d, 58.405923d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.UAE.getCountryId()) {
            return this.F.createLatLng(25.204849d, 55.270783d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.JORDAN.getCountryId()) {
            return this.F.createLatLng(31.945367d, 35.928372d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.EGYPT.getCountryId()) {
            return this.F.createLatLng(30.044422d, 31.235712d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.IRAQ.getCountryId()) {
            return this.F.createLatLng(36.190236d, 44.008696d);
        }
        return this.F.createLatLng(29.375859d, 47.977405d);
    }

    private boolean dismissDialog() {
        Dialog dialog = this.popupWindow;
        if (dialog == null || !dialog.isShowing()) {
            return false;
        }
        return true;
    }

    public static float distFrom(double d11, double d12, double d13, double d14) {
        double radians = Math.toRadians(d13 - d11);
        double d15 = radians / 2.0d;
        double radians2 = Math.toRadians(d14 - d12) / 2.0d;
        double sin = (Math.sin(d15) * Math.sin(d15)) + (Math.cos(Math.toRadians(d11)) * Math.cos(Math.toRadians(d13)) * Math.sin(radians2) * Math.sin(radians2));
        return (float) (Math.atan2(Math.sqrt(sin), Math.sqrt(1.0d - sin)) * 2.0d * 6371000.0d);
    }

    private void drawAreaPolygon() {
        int i11;
        if (this.mMap != null) {
            if (this.isAddressFromCartOrderFlow || this.isNewAddressFromCartFlow || this.isQuick || this.isFromMcdGrlFlow || this.isRegOrderFlow) {
                i11 = getResources().getColor(R.color.colorSecondary);
                this.isRegOrderFlow = true;
            } else {
                this.isRegOrderFlow = false;
                i11 = 0;
            }
            this.f54326m = this.mMap.addPolygon(this.E.newPolygonOptions().addAll(toOurs(GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints, this.F)).strokeColor(i11).fillColor(0).strokeWidth(10.0f).clickable(true));
        }
    }

    private void drawPolygon() {
        FrameworkMap frameworkMap = this.mMap;
        if (frameworkMap != null) {
            this.f54325l = frameworkMap.addPolygon(this.E.newPolygonOptions().addAll(toOurs(GlobalDataModel.GEO_CORDINATES.polyGonPoints, this.F)).strokeColor(0).fillColor(0).strokeWidth(5.0f).clickable(true));
        }
    }

    private void fetchCurrentLocationRequest() {
        this.talabatMapPresenter.waitForCurrentLocation(true);
        com.google.android.gms.maps.model.LatLng latLng = GlobalDataModel.HOME_SCREEN_MAP.ADDRESS_FUSED_LOCATON;
        if (latLng == null) {
            this.f54334u.fetchCurrentLocation();
            return;
        }
        this.currentGPSLocation = toOurs(latLng, this.F);
        currentLocationReceived(toOurs(GlobalDataModel.HOME_SCREEN_MAP.ADDRESS_FUSED_LOCATON, this.F));
    }

    private int getPixelFromDp(int i11) {
        return (int) TypedValue.applyDimension(1, (float) i11, getResources().getDisplayMetrics());
    }

    /* access modifiers changed from: private */
    @NonNull
    public PlaceSelectionListener getPlaceSelectionListener() {
        return new PlaceSelectionListener() {
            public void onError(Status status) {
            }

            public void onPlaceSelected(Place place) {
                MapsActivity.this.autoCompledWidgetSelection(place);
            }
        };
    }

    private void gpsLocationSettingsAlert() {
        int i11;
        GlobalDataModel.HOME_SCREEN_MAP.REFRSH_LOCATION_FROM_BG = true;
        if (!dismissDialog()) {
            Dialog dialog = new Dialog(this, R.style.CustomStyle);
            this.popupWindow = dialog;
            dialog.requestWindowFeature(1);
            this.popupWindow.setContentView(R.layout.gps_enable_popup);
            this.popupWindow.getWindow().addFlags(4);
            this.popupWindow.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            this.popupWindow.setCancelable(false);
            this.popupWindow.setCanceledOnTouchOutside(false);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.popupWindow.getWindow().setLayout((int) (((double) displayMetrics.widthPixels) * 0.9d), -2);
            String replace = getString(R.string.gps_seetings_txt1).replace(RichContentLoadTimeRecorder.DELIMETER, getResources().getString(R.string.talabat_app_name));
            TextView textView = (TextView) this.popupWindow.findViewById(R.id.gps_steps_x1);
            TextView textView2 = (TextView) this.popupWindow.findViewById(R.id.gps_steps_2);
            ((TextView) this.popupWindow.findViewById(R.id.title)).setText(getString(R.string.gps_enable_popup_allow_location_txt));
            ((TextView) this.popupWindow.findViewById(R.id.msg_txt)).setText(getString(R.string.location_service_address_message));
            int i12 = 5;
            if (TalabatUtils.isRTL()) {
                i11 = 5;
            } else {
                i11 = 3;
            }
            textView.setGravity(i11);
            if (!TalabatUtils.isRTL()) {
                i12 = 3;
            }
            textView2.setGravity(i12);
            textView.setText(replace);
            this.popupWindow.findViewById(R.id.go_to_settings).setOnClickListener(new za(this));
            this.popupWindow.findViewById(R.id.no_thanks).setOnClickListener(new ab(this));
            this.popupWindow.show();
        }
    }

    /* access modifiers changed from: private */
    public void hideKeyBoard() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(1, 0);
    }

    /* access modifiers changed from: private */
    public void hideMapTutorail() {
        View view = this.dragTutorialContainer;
        if (view != null && this.isNeedShowDragTutorial && view.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.animation_off);
            loadAnimation.setDuration(FADE_DEFAULT_TIME);
            loadAnimation.setFillAfter(true);
            this.dragTutorialContainer.startAnimation(loadAnimation);
            this.isNeedShowDragTutorial = false;
        }
    }

    /* access modifiers changed from: private */
    public void hideMcdBlockSectionContainer() {
        this.mapToolbarSearch.setVisibility(0);
        this.mcdSectionContainer.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        this.mcdDisableContainer.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        animateSlideTo(0, this.mcdSectionContainer.getHeight());
    }

    private void inject() {
        ApiContainer apiContainer = AndroidComponentsKt.apiContainer((Activity) this);
        DaggerMapsActivityComponent.factory().create((ConfigurationRemoteCoreLibApi) apiContainer.getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class), (LocationCoreLibApi) apiContainer.getFeature(LocationCoreLibApi.class), (MapsCoreLibApi) apiContainer.getFeature(MapsCoreLibApi.class), (SecretCoreLibApi) apiContainer.getFeature(SecretCoreLibApi.class)).inject(this);
    }

    private Boolean isLocationServiceEnabled(Context context) {
        boolean z11;
        if (this.locationManager == null) {
            this.locationManager = (LocationManager) getSystemService("location");
        }
        try {
            z11 = this.locationManager.isProviderEnabled("gps");
        } catch (Exception unused) {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$gpsLocationSettingsAlert$0(View view) {
        this.popupWindow.dismiss();
        openSettings();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$gpsLocationSettingsAlert$1(View view) {
        this.popupWindow.dismiss();
    }

    private void legacyHideLocationButton(boolean z11) {
        MapContainerFragment mapContainerFragment = this.mapFragment;
        if (mapContainerFragment != null) {
            mapContainerFragment.legacyHideLocationButton(z11);
        }
    }

    private void loadMapViewTypeAptimize() {
        FrameworkMap frameworkMap = this.mMap;
        if (frameworkMap != null) {
            frameworkMap.setMapType(FrameworkMap.MapType.MAP_TYPE_NORMAL);
            ImageView imageView = this.mapViewSwitchBtn;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
        this.mapViewSwitchBtn.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void loadingMapView() {
        MapContainerFragment mapContainerFragment = (MapContainerFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        this.mapFragment = mapContainerFragment;
        mapContainerFragment.init(new MapWrapperLayout(this));
        this.mapFragment.getMapAsync(this);
        this.customMapView = this.mapFragment.getView();
        this.mapFragment.legacyHideLocationButton(false);
    }

    private void locationButtonEnable(boolean z11) {
        this.locationButton.setVisibility(0);
        if (z11) {
            this.locationButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_m_gps_off));
        } else {
            this.locationButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_m_gps_on));
        }
    }

    private void locationMissMatchResporygonDirection(Address address) {
        String str;
        Intent intent = new Intent();
        clearAreaPolygonProperties();
        intent.putExtra("map_compulsory", this.isMapcompulsory);
        intent.putExtra("nineCookiesEnabled", this.isNineCookiesTrackingEnabled);
        intent.putExtra("isAddressFromCartOrderFlow", this.isAddressFromCartOrderFlow);
        intent.putExtra(GlobalConstants.FORCE_MAP.LOCATION_MIS_MATCH, true);
        intent.putExtra("newaddressCreation", this.isNewAddress);
        intent.putExtra("location", "" + this.latLngmain.getLatitude() + "," + this.latLngmain.getLongitude());
        intent.putExtra(GlobalConstants.FORCE_MAP.IS_EDIT_ADDRESS_FROM_SIDE_MENU, this.isEditAddressFromSideMenu);
        intent.putExtra(GlobalConstants.INFOR_MAP.IS_DISABLE_ADDRESS_EDIT_GRL_CART, this.isGrlAddressEditDisabled);
        intent.putExtra(GlobalConstants.INFOR_MAP.IS_MCD_KSA_UPDATE_LOCATION, true);
        intent.putExtra("skip", false);
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) address);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) address);
        }
        this.addressString = str;
        intent.putExtra("address", str);
        GlobalDataModel.GEO_CORDINATES.saveTempZoomLevel = this.userSelectedZoom;
        stopLodingPopup();
        setResult(-1, intent);
        AppTracker.onMapClosed(this, "");
        finish();
    }

    private void mapDragTutorial(boolean z11) {
        if (!this.isNeedShowDragTutorial) {
            this.dragTutorialContainer.clearAnimation();
            this.dragTutorialContainer.setVisibility(4);
        } else if (z11) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.animation_on);
            loadAnimation.setDuration(FADE_DEFAULT_TIME);
            loadAnimation.setFillAfter(true);
            this.dragTutorialContainer.startAnimation(loadAnimation);
            this.dragTutorialContainer.setVisibility(0);
            this.dragTutorialClose.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(MapsActivity.this, R.anim.animation_off);
                    loadAnimation.setDuration(MapsActivity.FADE_DEFAULT_TIME);
                    loadAnimation.setFillAfter(true);
                    MapsActivity.this.isNeedShowDragTutorial = true;
                    MapsActivity.this.dragTutorialContainer.startAnimation(loadAnimation);
                }
            });
        } else {
            this.dragTutorialContainer.clearAnimation();
            this.dragTutorialContainer.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    public void markerWindowDecesionHandler(LatLng latLng) {
        boolean z11;
        boolean z12;
        LatLng latLng2;
        Polygon polygon = this.f54326m;
        boolean z13 = false;
        if (polygon == null || polygon.getPoints() == null) {
            z11 = false;
        } else {
            z11 = true;
        }
        LatLng latLng3 = this.userSavedLocation;
        if (latLng3 != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        com.google.android.gms.maps.model.LatLng latLng4 = GlobalDataModel.GEO_CORDINATES.areaCenterPoint;
        if (latLng4 != null) {
            z13 = true;
        }
        if (z11) {
            if (z12) {
                boolean containsLocation = PolyUtil.containsLocation(latLng3, this.f54326m.getPoints());
                latLng2 = isFindCenterOfPolygon();
                if (!containsLocation) {
                    PolyUtil.containsLocation(this.latLngmain, this.f54326m.getPoints());
                } else if (distFrom(this.userSavedLocation.getLatitude(), this.userSavedLocation.getLongitude(), latLng.getLatitude(), latLng.getLongitude()) >= ((float) GlobalConstants.centerPointRange)) {
                    latLng2 = this.userSavedLocation;
                } else {
                    latLng2 = this.userSavedLocation;
                }
            } else {
                PolyUtil.containsLocation(this.latLngmain, this.f54326m.getPoints());
                latLng2 = isFindCenterOfPolygon();
            }
        } else if (!z13) {
            latLng2 = null;
        } else if (!z12) {
            if (distFrom(latLng4.latitude, latLng4.longitude, latLng.getLatitude(), latLng.getLongitude()) >= ((float) GlobalConstants.centerPointRange)) {
                latLng2 = toOurs(GlobalDataModel.GEO_CORDINATES.areaCenterPoint, this.F);
            } else {
                latLng2 = toOurs(GlobalDataModel.GEO_CORDINATES.areaCenterPoint, this.F);
            }
        } else if (distFrom(latLng3.getLatitude(), this.userSavedLocation.getLongitude(), latLng.getLatitude(), latLng.getLongitude()) >= ((float) GlobalConstants.centerPointRange)) {
            latLng2 = toOurs(GlobalDataModel.GEO_CORDINATES.areaCenterPoint, this.F);
        } else {
            latLng2 = toOurs(GlobalDataModel.GEO_CORDINATES.areaCenterPoint, this.F);
        }
        if (((latLng2 != null && z11) || z13) && !this.polygonAdded) {
            this.polygonAdded = true;
        }
    }

    private void mcdDeliveryUnAvailableAlert(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setTitle((CharSequence) getString(R.string.info_location_mis_match));
        builder.setMessage((CharSequence) getString(R.string.mcd_delivery_unavailable).replace(RichContentLoadTimeRecorder.DELIMETER, str));
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* access modifiers changed from: private */
    public void navigateToLastKnownLocation(LatLng latLng) {
        changeCamera(latLng, 6.0f, 50.0f, 3000);
    }

    private void onLocationDialogAccepted(Boolean bool) {
        String str;
        try {
            String str2 = this.mapJourneytype;
            String str3 = "" + bool;
            String locationPromptType = TrackingUtils.INSTANCE.getLocationPromptType();
            if (bool.booleanValue()) {
                str = TrackingUtils.TrackingGpsStatus.Enabled.getValue();
            } else {
                str = TrackingUtils.TrackingGpsStatus.Disabled.getValue();
            }
            AppTracker.geolocationDialogueAccepted(this, ScreenNames.MAPS_SCREEN, str2, str3, locationPromptType, str);
        } catch (Exception unused) {
        }
    }

    private void onTrackGeoLocationRequested(String str, Address address, String str2) {
        int i11;
        int i12;
        Address address2 = address;
        TrackingUtils trackingUtils = TrackingUtils.INSTANCE;
        boolean z11 = false;
        if (address2 != null) {
            i11 = address2.cityId;
        } else {
            i11 = 0;
        }
        Integer valueOf = Integer.valueOf(i11);
        if (address2 != null) {
            i12 = address2.areaId;
        } else {
            i12 = 0;
        }
        Integer valueOf2 = Integer.valueOf(i12);
        String str3 = this.mapJourneytype;
        String str4 = AppTracker.NotAvail;
        if (address2 == null) {
            z11 = true;
        }
        AddressAnalyticsTracker trackingAddressObject = trackingUtils.getTrackingAddressObject(this, false, address, valueOf, valueOf2, str3, str4, ScreenNames.MAPS_SCREEN, str2, str4, str, str4, str4, str4, str4, str4, str4, str4, z11, this.locationMethod);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(this.trackingDistance);
        trackingAddressObject.setLocationDistance(sb2.toString());
        AppTracker.onGeolocationRequested(this, trackingAddressObject);
    }

    private void onTrackMapLoaded() {
        TrackingUtils trackingUtils = TrackingUtils.INSTANCE;
        String str = this.mapJourneytype;
        String str2 = AppTracker.NotAvail;
        String str3 = str2;
        String str4 = str2;
        String str5 = str2;
        String str6 = str2;
        String str7 = str2;
        String str8 = str2;
        String str9 = str2;
        String str10 = str2;
        AppTracker.onMapLoaded(this, trackingUtils.getTrackingAddressObject(this, true, (Address) null, (Integer) null, 0, str, str6, str7, str5, str4, str9, str3, str8, str2, str2, this.f54336w, str2, str10, true, str2));
    }

    private void openSettings() {
        this.redirectGPSSettings = true;
        GlobalDataModel.HOME_SCREEN_MAP.REFRSH_LOCATION_FROM_BG = true;
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        Uri fromParts = Uri.fromParts("package", BuildConfig.APPLICATION_ID, (String) null);
        intent.setData(fromParts);
        intent.setData(fromParts);
        startActivityForResult(intent, REQUEST_CHECK_SETTINGS);
    }

    private void reInitiateLocation() {
        if (!this.f54334u.isLoactionReequestInitied()) {
            this.f54334u.initLocationRequest(this, CurrentLocHelper.INSTANCE.getIS_FROM_MAP_CURRENT_LOC_ADDRESS());
        }
        this.f54334u.updateLocationRequestType(CurrentLocHelper.INSTANCE.getIS_FROM_MAP_CURRENT_LOC_ADDRESS());
        this.f54334u.startLocationUpdates(this);
    }

    /* access modifiers changed from: private */
    public void redirectToAddressPage(Address address) {
        String str;
        Intent intent = new Intent();
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) address);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) address);
        }
        this.addressString = str;
        clearAreaPolygonProperties();
        intent.putExtra("address", this.addressString);
        intent.putExtra("map_compulsory", this.isMapcompulsory);
        intent.putExtra("nineCookiesEnabled", this.isNineCookiesTrackingEnabled);
        intent.putExtra("isAddressFromCartOrderFlow", this.isAddressFromCartOrderFlow);
        intent.putExtra("newaddressCreation", this.isNewAddress);
        intent.putExtra(GlobalConstants.ExtraNames.EDIT, this.isEditAddress);
        intent.putExtra("location", "" + this.latLngmain.getLatitude() + "," + this.latLngmain.getLongitude());
        intent.putExtra("unserConfirmedLocation", true);
        intent.putExtra(GlobalConstants.FORCE_MAP.MAP_FROM_SIDEMENU, this.isNewAddessCreationFromSideMenu);
        intent.putExtra(GlobalConstants.INFOR_MAP.IS_DISABLE_ADDRESS_EDIT_GRL_CART, this.isGrlAddressEditDisabled);
        intent.putExtra(GlobalConstants.FORCE_MAP.IS_EDIT_ADDRESS_FROM_SIDE_MENU, this.isEditAddressFromSideMenu);
        intent.putExtra("skip", false);
        intent.putExtra(GlobalConstants.INFOR_MAP.IS_MCD_KSA_UPDATE_LOCATION, true);
        GlobalDataModel.GEO_CORDINATES.saveTempZoomLevel = this.userSelectedZoom;
        stopLodingPopup();
        setResult(-1, intent);
        AppTracker.onMapClosed(this, "");
        onTrackGeoLocationRequested("True", address, AppTracker.NotAvail);
        finish();
    }

    private void resetCustomSearch() {
        View view = this.CustonGooglesearchContainer;
        if (view != null) {
            view.setVisibility(8);
        }
        ImageButton imageButton = this.backButton;
        if (imageButton != null) {
            imageButton.setVisibility(0);
        }
        ImageView imageView = this.mapToolbarSearch;
        if (imageView != null) {
            imageView.setClickable(true);
        }
        RelativeLayout relativeLayout = this.mSearchContainer;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void searchBarSlideRightAnimation() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        loadAnimation.setDuration(FADE_DEFAULT_TIME);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                MapsActivity.this.CustonGooglesearchContainer.setVisibility(0);
                MapsActivity.this.CustonGooglesearchContainer.clearAnimation();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.CustonGooglesearchContainer.startAnimation(loadAnimation);
    }

    private void setMcdBlockStreetSectionContainer(boolean z11) {
        View view;
        View view2;
        if (z11) {
            this.mapToolbarSearch.setVisibility(4);
            if (this.initialSlideUpAnimation) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_up);
                loadAnimation.setDuration(500);
                loadAnimation.setFillAfter(true);
                this.mcdSectionContainer.startAnimation(loadAnimation);
                this.initialSlideUpAnimation = false;
            } else {
                animateSlideTo(this.mcdSectionContainer.getHeight(), 0);
            }
            this.mcdSectionContainer.setVisibility(0);
            if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                View view3 = this.mcdBlockSectionContainer;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
            } else if (TalabatUtils.isMcdLatLngEnabledCountry() && (view2 = this.mcdKsaStreetSection) != null) {
                view2.setVisibility(0);
            }
            this.mcdDisableContainer.setVisibility(0);
            this.mcdDisableContainer.animate().alpha(1.0f).setDuration(500);
            this.mcdSectionContainer.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
            this.mcdDisableContainer.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
            return;
        }
        this.mapToolbarSearch.setVisibility(0);
        this.mcdSectionContainer.setVisibility(8);
        if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
            View view4 = this.mcdBlockSectionContainer;
            if (view4 != null) {
                view4.setVisibility(0);
            }
        } else if (TalabatUtils.isMcdLatLngEnabledCountry() && (view = this.mcdKsaStreetSection) != null) {
            view.setVisibility(0);
        }
        this.mcdDisableContainer.setVisibility(8);
        this.mcdDisableContainer.animate().alpha(0.0f).setDuration(500);
    }

    /* access modifiers changed from: private */
    public void setMcdProceedEnable(boolean z11) {
        if (z11) {
            this.mcdProceedBtn.setAlpha(1.0f);
            this.mcdProceedBtn.setEnabled(true);
            return;
        }
        this.mcdProceedBtn.setAlpha(0.5f);
        this.mcdProceedBtn.setEnabled(false);
    }

    private void showAddressOutsideCountry() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setTitle((int) R.string.location_outside_country_title);
        builder.setMessage((int) R.string.location_outside_country);
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    private void showAddressOutsideSelectedArea() {
        String str;
        Object obj;
        String str2 = "";
        AppTracker.onLocationMismatch(this, str2);
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (!this.isAddressFromCartOrderFlow && !this.isNewAddressFromCartFlow && !this.isQuick && !this.isFromMcdGrlFlow) {
            builder.setTitle(R.string.location_mismatch);
            if (!TalabatUtils.isNullOrEmpty(this.addressString)) {
                Gson gson = UniversalGson.INSTANCE.gson;
                String str3 = this.addressString;
                Class cls = Address.class;
                if (!(gson instanceof Gson)) {
                    obj = gson.fromJson(str3, cls);
                } else {
                    obj = GsonInstrumentation.fromJson(gson, str3, cls);
                }
                str = getString(R.string.area_poly_mismatch_description_geo_update).replace("#", ((Address) obj).areaName);
            } else {
                str = getString(R.string.address_mismatch_description_geo_update_without_area_name);
            }
        } else if (this.resPoryGonAvailable) {
            builder.setTitle(R.string.rest_out_of_delivery_zone);
            Cart instance = Cart.getInstance();
            if (instance.getRestaurant() != null) {
                str2 = instance.getRestaurant().f13873name;
            }
            if (!TalabatUtils.isNullOrEmpty(str2)) {
                str = getString(R.string.res_poly_mismatch_description_geo_update).replace("#", str2);
            } else {
                str = getString(R.string.res_poly_mismatch_description_geo_update_without_res);
            }
        } else {
            builder.setTitle(R.string.area_polygon_location_mismatch);
            if (!TalabatUtils.isNullOrEmpty(GlobalDataModel.SelectedAreaName)) {
                str = getString(R.string.area_poly_mismatch_description_geo_update).replace("#", GlobalDataModel.SelectedAreaName);
            } else {
                str = getString(R.string.address_mismatch_description_geo_update_without_area_name);
            }
        }
        builder.setMessage(str);
        builder.setNegativeButton(R.string.close_dialog, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                AppTracker.onClosedAfterMapError(MapsActivity.this, "");
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public void slideDown() {
        if (this.locAwarContainer != null) {
            animtLocationBtn(Boolean.TRUE);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) this.locAwarContainer.getHeight());
            translateAnimation.setDuration(200);
            translateAnimation.setFillAfter(true);
            this.locAwarContainer.startAnimation(translateAnimation);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    MapsActivity.this.locAwarContainer.setVisibility(8);
                    MapsActivity.this.isLocationAwararnessPopupShown = false;
                    MapsActivity.this.normalConifirmContainer.setVisibility(0);
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
        }
    }

    private static com.google.android.gms.maps.model.LatLng toGoogle(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return new com.google.android.gms.maps.model.LatLng(latLng.getLatitude(), latLng.getLongitude());
    }

    /* access modifiers changed from: private */
    public static LatLng toOurs(com.google.android.gms.maps.model.LatLng latLng, LatLngFactory latLngFactory) {
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
            String str2 = this.mapJourneytype;
            String str3 = this.deliveryAddressStatus;
            String str4 = AppTracker.NotAvail;
            try {
                try {
                    AppTracker.onAddressErrorShown(this, trackingUtils.getTrackingAddressObject(this, false, address, valueOf, valueOf2, str2, str3, ScreenNames.MAPS_SCREEN, str, str4, str4, str4, str4, str4, str4, str4, str4, str4, false, this.locationMethod));
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
        }
    }

    public void OnCurrentLocationPermissionStatus(@NotNull PermissionDeniedResponse permissionDeniedResponse) {
        if (permissionDeniedResponse.isPermanentlyDenied()) {
            locationButtonEnable(false);
            if (this.locationBtnContainer != null) {
                animtLocationBtn(Boolean.TRUE);
                this.isLocationPermissionAllowed = false;
                this.locationBtnContainer.setVisibility(0);
                this.locationButton.setVisibility(0);
            }
            gpsLocationSettingsAlert();
        }
    }

    public void ProceedToOrder(int i11, String str) {
        stopLodingPopup();
        Intent intent = new Intent();
        intent.putExtra(GlobalConstants.MCD_GOOGLE_MAP.MCD_GOOGLE_MAP_BRANCH_ID, i11);
        intent.putExtra(GlobalConstants.MCD_GOOGLE_MAP.MCD_GOOGLE_MAP_BLOCK, str);
        intent.putExtra("isFromMcdAddressFlow", true);
        stopLodingPopup();
        setResult(-1, intent);
        finish();
    }

    public void addressNotAvailable() {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setTitle((CharSequence) getString(R.string.location_not_without_polygon_title));
        builder.setMessage((CharSequence) getString(R.string.location_not_without_polygon_message));
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                MapsActivity mapsActivity = MapsActivity.this;
                mapsActivity.navigateToLastKnownLocation(mapsActivity.mainCameraLatlang);
            }
        });
        builder.show();
        trackMapErrorShown(TrackingUtils.INSTANCE.getOutOfDeliveryZone(), (Address) null);
    }

    public void animateCamera(com.google.android.gms.maps.model.LatLng latLng, float f11, int i11, float f12, int i12) {
        this.isInitialMapZoom = false;
        if (this.mMap != null) {
            changeCamera(toOurs(latLng, this.F), f11, f12, i12);
        }
    }

    public void animateSlideTo(int i11, int i12) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mcdSectionContainer, "translationY", new float[]{(float) i11, (float) i12});
        ofFloat.setDuration(400);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MapsActivity.this.mcdBlockSectionContainer.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                    if (MapsActivity.this.mcdBlockSectionContainer != null) {
                        MapsActivity.this.mcdBlockSectionContainer.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                } else if (TalabatUtils.isMcdLatLngEnabledCountry() && MapsActivity.this.mcdKsaStreetSection != null) {
                    MapsActivity.this.mcdKsaStreetSection.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        ofFloat.start();
    }

    public void cameraAnimatorWithoutWaitPolygonValidation(com.google.android.gms.maps.model.LatLng latLng, int i11, int i12, float f11, int i13) {
        this.isInitialMapZoom = false;
        if (this.mMap != null) {
            changeCamera(toOurs(latLng, this.F), (float) i11, f11, i13);
        }
    }

    public boolean checkCurrentLocationInsideAreaPolygon(com.google.android.gms.maps.model.LatLng latLng) {
        Polygon polygon = this.f54326m;
        if (polygon == null || polygon.getPoints() == null) {
            return false;
        }
        return PolyUtil.containsLocation(toOurs(latLng, this.F), this.f54326m.getPoints());
    }

    public void clearAreaPolygonProperties() {
        if (this.isNewAddress && !this.isNewAddressFromCartFlow) {
            GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints = null;
            GlobalDataModel.GEO_CORDINATES.ValidateWithareaPolygon = false;
            GlobalDataModel.GEO_CORDINATES.areaCenterPoint = null;
        }
    }

    public void deliverToCLRecived(@NotNull com.google.android.gms.maps.model.LatLng latLng) {
    }

    public void destroyPresenter() {
        this.talabatMapPresenter = null;
    }

    public Context getContext() {
        return this;
    }

    public Context getGemContext() {
        return this;
    }

    public String getGemScreenType() {
        return ScreenNames.getScreenType(getScreenName());
    }

    public IGlobalPresenter getPresenter() {
        return this.talabatMapPresenter;
    }

    public String getScreenName() {
        return ScreenNames.MAPS_SCREEN;
    }

    public boolean gpsDeviceStatus() {
        return isLocationServiceEnabled(this).booleanValue();
    }

    public void inflateGemFooter() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            this.f54329p = new GemFooterCartView();
            if (GEMEngine.getInstance() != null) {
                GEMEngine.getInstance().startListening(this, false);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
            beginTransaction.add((int) R.id.gem_footer_view, (Fragment) this.f54329p, getScreenName());
            beginTransaction.commit();
        }
    }

    public LatLng isFindCenterOfPolygon() {
        LatLngBounds.Builder newLatLngBoundsBuilder = this.E.newLatLngBoundsBuilder();
        if (GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints == null) {
            return null;
        }
        for (int i11 = 0; i11 < GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints.size(); i11++) {
            newLatLngBoundsBuilder.include(toOurs(GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints.get(i11), this.F));
        }
        return newLatLngBoundsBuilder.build().getCenter();
    }

    public void isRefreshMap(boolean z11, @NotNull com.google.android.gms.maps.model.LatLng latLng) {
        this.currentGPSLocation = toOurs(latLng, this.F);
        ITalabatMapPresenter iTalabatMapPresenter = this.talabatMapPresenter;
        if (iTalabatMapPresenter != null) {
            iTalabatMapPresenter.waitForCurrentLocation(false);
            this.talabatMapPresenter.currentLocationReceived(latLng, this.f54324k);
        }
    }

    public void locationMismatch(Address address) {
        String str;
        AppTracker.onLocationMismatch(this, "");
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.location_mismatch);
        if (!TalabatUtils.isNullOrEmpty(GlobalDataModel.SelectedAreaName)) {
            str = getString(R.string.address_mismatch_description_geo_update).replace("#", GlobalDataModel.SelectedAreaName);
        } else {
            str = getString(R.string.address_mismatch_description_geo_update_without_area_name);
        }
        builder.setMessage(str);
        builder.setNegativeButton(R.string.close_dialog, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                AppTracker.onClosedAfterMapError(MapsActivity.this, "");
            }
        });
        builder.show();
        trackMapErrorShown(TrackingUtils.INSTANCE.getAddressMismatch(), address);
    }

    public void locationMismatchValidateWithPlygon(Address address) {
        stopLodingPopup();
        LocationMissRedirection(address);
    }

    public void locationMismatchValidateWithResPlygon(Address address) {
        stopLodingPopup();
        locationMissMatchResporygonDirection(address);
    }

    public void mapCurrentLocReceived(@NotNull com.google.android.gms.maps.model.LatLng latLng) {
        this.currentGPSLocation = toOurs(latLng, this.F);
        if (this.mMap != null) {
            if (this.f54334u.userAllowedAllLocationPermissions(this)) {
                this.mMap.setMyLocationEnabled(true);
            }
            locationButtonEnable(true);
            legacyHideLocationButton(true);
            if (GlobalDataModel.HOME_SCREEN_MAP.REFRSH_LOCATION_FROM_BG) {
                ITalabatMapPresenter iTalabatMapPresenter = this.talabatMapPresenter;
                if (iTalabatMapPresenter != null) {
                    iTalabatMapPresenter.waitForCurrentLocation(false);
                    this.locationMethod = TrackingUtils.INSTANCE.getLocationMethodLocate();
                    this.talabatMapPresenter.currentLocationReceived(latLng, this.f54324k);
                    GlobalDataModel.HOME_SCREEN_MAP.REFRSH_LOCATION_FROM_BG = false;
                }
                try {
                    androidx.appcompat.app.AlertDialog alertDialog2 = this.alertDialog;
                    if (alertDialog2 != null && alertDialog2.isShowing()) {
                        this.alertDialog.dismiss();
                    }
                } catch (Exception unused) {
                }
            } else {
                ITalabatMapPresenter iTalabatMapPresenter2 = this.talabatMapPresenter;
                if (iTalabatMapPresenter2 != null) {
                    iTalabatMapPresenter2.waitForCurrentLocation(false);
                    this.talabatMapPresenter.currentLocationReceived(latLng, this.f54324k);
                }
            }
        }
    }

    public void mapRotateSlowAnimationUtilPointingDecisionMaking(com.google.android.gms.maps.model.LatLng latLng, boolean z11, boolean z12, int i11, float f11, int i12) {
        this.isInitialMapZoom = false;
        changeCamera(toOurs(latLng, this.F), 6.0f, f11, i12);
    }

    public void mcdBlockFailed() {
        stopLodingPopup();
    }

    public void mcdDeliveryUnavaliable(String str, String str2, String str3) {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        if (TalabatUtils.isNullOrEmpty(str3)) {
            str3 = "";
        }
        builder.setTitle((CharSequence) str3);
        if (TalabatUtils.isNullOrEmpty(str)) {
            str = "";
        }
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((int) R.string.close_dialog, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void mcdFlowHideSkip() {
        this.confirmContainer.setVisibility(8);
        this.mcdFlowConfirmContainer.setVisibility(0);
    }

    public void mcdServerError() {
        Toast.makeText(getContext(), getResources().getString(R.string.server_error_msg), 0).show();
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 36) {
            if (i12 == -1) {
                String stringExtra = intent.getStringExtra("location");
                if (!TalabatUtils.isNullOrEmpty(stringExtra)) {
                    String[] split = stringExtra.split(",");
                    LatLng createLatLng = this.F.createLatLng(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
                    this.latLngmain = createLatLng;
                    this.userIntractedWithMap = true;
                    confirmButtonEnable(createLatLng);
                    this.talabatMapPresenter.mapLoadingCompleted();
                    this.isInitialMapZoom = false;
                    changeCamera(this.latLngmain, 3.0f, 50.0f, 3000);
                }
            }
        } else if (i11 != REQUEST_CHECK_SETTINGS) {
        } else {
            if (i12 == -1) {
                locationButtonEnable(true);
                reInitiateLocation();
            } else if (this.redirectGPSSettings) {
                locationButtonEnable(true);
                reInitiateLocation();
            }
        }
    }

    public /* synthetic */ void onAddMoreItemClicked() {
        a.a(this);
    }

    public void onAddressRecieved(final Address address) {
        stopLodingPopup();
        if (address != null) {
            if (this.validateWithPolygon && this.isNewAddessCreationFromSideMenu) {
                int i11 = address.areaId;
                if (i11 > 0) {
                    if (this.userSelectedAreaId != i11) {
                        AppTracker.onLocationMismatch(this, "");
                        stopLodingPopup();
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle(R.string.location_mismatch);
                        builder.setMessage(getString(R.string.add_new_mis_match_popup).replace("#", address.areaName));
                        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i11) {
                                MapsActivity mapsActivity = MapsActivity.this;
                                LatLng latLng = mapsActivity.latLngmain;
                                if (latLng != null) {
                                    AppTracker.onContinuedAfterMapError(mapsActivity, latLng.getLatitude(), MapsActivity.this.latLngmain.getLongitude(), "");
                                }
                                MapsActivity.this.redirectToAddressPage(address);
                            }
                        });
                        builder.setNegativeButton(R.string.f54880no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i11) {
                                AppTracker.onClosedAfterMapError(MapsActivity.this, "");
                                MapsActivity mapsActivity = MapsActivity.this;
                                mapsActivity.navigateToLastKnownLocation(mapsActivity.mainCameraLatlang);
                            }
                        });
                        builder.show();
                        trackMapErrorShown(TrackingUtils.INSTANCE.getAddressMismatch(), address);
                        return;
                    }
                    redirectToAddressPage(address);
                } else if (TalabatUtils.isNullOrEmpty(address.areaName) || address.areaId == 0) {
                    addressNotAvailable();
                }
            } else if (!this.isNewAddessCreationFromSideMenu || (!TalabatUtils.isNullOrEmpty(address.areaName) && address.areaId != 0)) {
                redirectToAddressPage(address);
            } else {
                addressNotAvailable();
            }
        } else if (this.validateWithPolygon && this.isNewAddessCreationFromSideMenu) {
            addressNotAvailable();
            onTrackGeoLocationRequested("False", address, getString(R.string.location_not_without_polygon_title));
        } else if (!this.isNewAddessCreationFromSideMenu || !(address == null || TalabatUtils.isNullOrEmpty(address.areaName) || address.areaId == 0)) {
            redirectToAddressPage(address);
        } else {
            addressNotAvailable();
        }
    }

    public void onAddressRecievedWithPorygon(Address address) {
        redirectToAddressPage(address);
    }

    public void onAuthError() {
    }

    public void onBackClickListener() {
        resetCustomSearch();
    }

    public void onBackPressed() {
        AppTracker.onMapSkipped(this);
        GlobalDataModel.GEO_CORDINATES.addressPageLatLang = null;
        GlobalDataModel.HOME_SCREEN_MAP.ADDRESS_FUSED_LOCATON = null;
        if (!this.isFromMcdGrlFlow) {
            ShowCaseViewLogic.getInstance().setMapOnBoarding();
            ShowCaseViewLogic.getInstance().saveToPrefs(this);
        }
        if (this.isAddressFromCartOrderFlow) {
            Intent intent = new Intent();
            intent.putExtra("isAddressFromCartOrderFlow", this.isAddressFromCartOrderFlow);
            AppTracker.onMapClosed(this, "");
            intent.putExtra(GlobalConstants.ExtraNames.EDIT, this.isEditAddress);
            intent.putExtra(GlobalConstants.FORCE_MAP.MAP_FROM_SIDEMENU, this.isNewAddessCreationFromSideMenu);
            intent.putExtra(GlobalConstants.FORCE_MAP.IS_EDIT_ADDRESS_FROM_SIDE_MENU, this.isEditAddressFromSideMenu);
            intent.putExtra("isAddressFromCartOrderFlow", this.isAddressFromCartOrderFlow);
            intent.putExtra("skip", false);
            setResult(0, intent);
            GlobalDataModel.GEO_CORDINATES.isUserInteractedWithMapLocation = false;
            finish();
        } else if (this.isNewAddress) {
            Intent intent2 = new Intent();
            intent2.putExtra("isNewAddressFromCartOrderFlow", this.isNewAddress);
            AppTracker.onMapClosed(this, "");
            intent2.putExtra(GlobalConstants.ExtraNames.EDIT, this.isEditAddress);
            intent2.putExtra(GlobalConstants.FORCE_MAP.MAP_FROM_SIDEMENU, this.isNewAddessCreationFromSideMenu);
            intent2.putExtra(GlobalConstants.FORCE_MAP.IS_EDIT_ADDRESS_FROM_SIDE_MENU, this.isEditAddressFromSideMenu);
            intent2.putExtra("isAddressFromCartOrderFlow", this.isAddressFromCartOrderFlow);
            intent2.putExtra("skip", false);
            setResult(0, intent2);
            finish();
        } else if (this.isEditAddress) {
            Intent intent3 = new Intent();
            intent3.putExtra(GlobalConstants.ExtraNames.EDIT, this.isEditAddress);
            setResult(0, intent3);
            intent3.putExtra(GlobalConstants.FORCE_MAP.MAP_FROM_SIDEMENU, this.isNewAddessCreationFromSideMenu);
            intent3.putExtra(GlobalConstants.FORCE_MAP.IS_EDIT_ADDRESS_FROM_SIDE_MENU, this.isEditAddressFromSideMenu);
            intent3.putExtra("isAddressFromCartOrderFlow", this.isAddressFromCartOrderFlow);
            intent3.putExtra("skip", false);
            intent3.putExtra(GlobalConstants.INFOR_MAP.IS_DISABLE_ADDRESS_EDIT_GRL_CART, this.isGrlAddressEditDisabled);
            AppTracker.onMapClosed(this, "");
            finish();
        } else if (this.isFromMcdGrlFlow) {
            GlobalDataModel.GEO_CORDINATES.addressPageLatLang = null;
            GlobalDataModel.GEO_CORDINATES.isUserInteractedWithMapLocation = false;
            finish();
        } else {
            super.onBackPressed();
        }
    }

    public /* synthetic */ void onBackToCheckoutPage(Dialog dialog) {
        a.b(this, dialog);
    }

    public void onBackToRestaurantMenuPage(Dialog dialog) {
        backToRestaurantMenuPage(dialog, this.mGemDialogSwitcher, "");
    }

    public void onBackToRestaurantPage(Dialog dialog) {
        dialog.dismiss();
        if (Cart.getInstance().hasItems()) {
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
            return;
        }
        finish();
        Intent intent2 = new Intent(this, RestaurantsListScreenRefactor.class);
        intent2.setFlags(67108864);
        startActivity(intent2);
    }

    public void onCloseButtonClicked(Dialog dialog) {
        dialog.dismiss();
    }

    public /* synthetic */ void onContinueToCheckout() {
        a.f(this);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(29:1|2|(1:6)|7|(2:9|(1:11)(1:12))(1:13)|14|15|(3:17|(1:19)(1:20)|21)|22|23|(1:25)(2:26|(1:28)(1:29))|30|(1:32)(1:33)|34|(2:36|(1:38))(1:39)|40|(2:44|(1:46)(12:47|(2:49|(1:51)(1:52))(1:53)|55|(2:57|(4:59|60|(2:62|63)(2:64|(1:66)(2:67|(1:69)))|70)(1:71))(1:72)|73|(1:77)|78|(1:80)(1:81)|82|(1:84)|85|89))|54|55|(0)(0)|73|75|77|78|(0)(0)|82|(0)|85|89) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x03de */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x03ef A[Catch:{ Exception -> 0x0601 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x03fd A[Catch:{ Exception -> 0x0601 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0423 A[Catch:{ Exception -> 0x0601 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0428 A[Catch:{ Exception -> 0x0601 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0438 A[Catch:{ Exception -> 0x0601 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0453 A[Catch:{ Exception -> 0x0601 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x046d A[Catch:{ Exception -> 0x0601 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x046e A[Catch:{ Exception -> 0x0601 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x049d A[Catch:{ Exception -> 0x0601 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0558 A[Catch:{ Exception -> 0x0601 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x05e4 A[Catch:{ Exception -> 0x0601 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x05ef A[Catch:{ Exception -> 0x0601 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x05f5 A[Catch:{ Exception -> 0x0601 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r12) {
        /*
            r11 = this;
            java.lang.String r0 = ""
            r11.inject()
            super.onCreate(r12)
            com.talabat.maps.domain.MapsInitializer r12 = r11.G
            r12.initialize()
            r12 = 2131624002(0x7f0e0042, float:1.8875171E38)
            r11.setContentView((int) r12)
            r12 = 2131431952(0x7f0b1210, float:1.8485648E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            androidx.appcompat.widget.Toolbar r12 = (androidx.appcompat.widget.Toolbar) r12     // Catch:{ Exception -> 0x0601 }
            r11.mToolbar = r12     // Catch:{ Exception -> 0x0601 }
            r11.setSupportActionBar(r12)     // Catch:{ Exception -> 0x0601 }
            library.talabat.mvp.googlemaps.TalabatMapPresenter r12 = new library.talabat.mvp.googlemaps.TalabatMapPresenter     // Catch:{ Exception -> 0x0601 }
            com.talabat.configuration.discovery.AppVersionProvider r1 = r11.B     // Catch:{ Exception -> 0x0601 }
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r2 = r11.C     // Catch:{ Exception -> 0x0601 }
            com.talabat.configuration.location.LocationConfigurationRepository r3 = r11.D     // Catch:{ Exception -> 0x0601 }
            r12.<init>(r1, r11, r2, r3)     // Catch:{ Exception -> 0x0601 }
            r11.talabatMapPresenter = r12     // Catch:{ Exception -> 0x0601 }
            android.content.Intent r12 = r11.getIntent()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = "noAreaChange"
            r2 = 0
            boolean r12 = r12.getBooleanExtra(r1, r2)     // Catch:{ Exception -> 0x0601 }
            r11.noAreaChange = r12     // Catch:{ Exception -> 0x0601 }
            android.content.Intent r12 = r11.getIntent()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = "isFromCheckout"
            boolean r12 = r12.getBooleanExtra(r1, r2)     // Catch:{ Exception -> 0x0601 }
            r11.f54335v = r12     // Catch:{ Exception -> 0x0601 }
            android.content.Intent r12 = r11.getIntent()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = "userSelectedAreaId"
            r3 = -1
            int r12 = r12.getIntExtra(r1, r3)     // Catch:{ Exception -> 0x0601 }
            r11.userSelectedAreaId = r12     // Catch:{ Exception -> 0x0601 }
            android.content.Intent r12 = r11.getIntent()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = "map_compulsory"
            boolean r12 = r12.getBooleanExtra(r1, r2)     // Catch:{ Exception -> 0x0601 }
            r11.isMapcompulsory = r12     // Catch:{ Exception -> 0x0601 }
            android.content.Intent r12 = r11.getIntent()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = "nineCookiesEnabled"
            boolean r12 = r12.getBooleanExtra(r1, r2)     // Catch:{ Exception -> 0x0601 }
            r11.isNineCookiesTrackingEnabled = r12     // Catch:{ Exception -> 0x0601 }
            android.content.Intent r12 = r11.getIntent()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = "address"
            java.lang.String r12 = r12.getStringExtra(r1)     // Catch:{ Exception -> 0x0601 }
            r11.addressString = r12     // Catch:{ Exception -> 0x0601 }
            android.content.Intent r12 = r11.getIntent()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = "isAddressFromCartOrderFlow"
            boolean r12 = r12.getBooleanExtra(r1, r2)     // Catch:{ Exception -> 0x0601 }
            r11.isAddressFromCartOrderFlow = r12     // Catch:{ Exception -> 0x0601 }
            android.content.Intent r12 = r11.getIntent()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = "isNewAddressFromCartOrderFlow"
            boolean r12 = r12.getBooleanExtra(r1, r2)     // Catch:{ Exception -> 0x0601 }
            r11.isNewAddressFromCartFlow = r12     // Catch:{ Exception -> 0x0601 }
            android.content.Intent r12 = r11.getIntent()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = "isForEdit"
            boolean r12 = r12.getBooleanExtra(r1, r2)     // Catch:{ Exception -> 0x0601 }
            r11.isEditAddress = r12     // Catch:{ Exception -> 0x0601 }
            android.content.Intent r12 = r11.getIntent()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = "newaddressCreation"
            boolean r12 = r12.getBooleanExtra(r1, r2)     // Catch:{ Exception -> 0x0601 }
            r11.isNewAddress = r12     // Catch:{ Exception -> 0x0601 }
            android.content.Intent r12 = r11.getIntent()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = "mapFromSideMenu"
            boolean r12 = r12.getBooleanExtra(r1, r2)     // Catch:{ Exception -> 0x0601 }
            r11.isNewAddessCreationFromSideMenu = r12     // Catch:{ Exception -> 0x0601 }
            android.content.Intent r12 = r11.getIntent()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = "addressSelectionType"
            int r12 = r12.getIntExtra(r1, r3)     // Catch:{ Exception -> 0x0601 }
            r11.addressSelectionType = r12     // Catch:{ Exception -> 0x0601 }
            android.content.Intent r12 = r11.getIntent()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = "talabatDeliveryAvailable"
            boolean r12 = r12.getBooleanExtra(r1, r2)     // Catch:{ Exception -> 0x0601 }
            r11.isTalabatDeliveryAvailable = r12     // Catch:{ Exception -> 0x0601 }
            android.content.Intent r12 = r11.getIntent()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = "isEditAddressFromSideMenu"
            boolean r12 = r12.getBooleanExtra(r1, r2)     // Catch:{ Exception -> 0x0601 }
            r11.isEditAddressFromSideMenu = r12     // Catch:{ Exception -> 0x0601 }
            android.content.Intent r12 = r11.getIntent()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = "isdisableAddressEditGrl"
            boolean r12 = r12.getBooleanExtra(r1, r2)     // Catch:{ Exception -> 0x0601 }
            r11.isGrlAddressEditDisabled = r12     // Catch:{ Exception -> 0x0601 }
            android.content.Intent r12 = r11.getIntent()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = "isQuick"
            boolean r12 = r12.getBooleanExtra(r1, r2)     // Catch:{ Exception -> 0x0601 }
            r11.isQuick = r12     // Catch:{ Exception -> 0x0601 }
            android.content.Intent r12 = r11.getIntent()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = "isAcurate"
            boolean r12 = r12.getBooleanExtra(r1, r2)     // Catch:{ Exception -> 0x0601 }
            r11.f54323j = r12     // Catch:{ Exception -> 0x0601 }
            android.content.Intent r12 = r11.getIntent()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = "location"
            java.lang.String r12 = r12.getStringExtra(r1)     // Catch:{ Exception -> 0x0601 }
            r11.f54324k = r12     // Catch:{ Exception -> 0x0601 }
            android.content.Intent r12 = r11.getIntent()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = "mcd_map_flow"
            boolean r12 = r12.getBooleanExtra(r1, r2)     // Catch:{ Exception -> 0x0601 }
            r11.isFromMcdGrlFlow = r12     // Catch:{ Exception -> 0x0601 }
            android.content.Intent r12 = r11.getIntent()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = "mcd_restaurant_id"
            int r12 = r12.getIntExtra(r1, r3)     // Catch:{ Exception -> 0x0601 }
            r11.restaurantId = r12     // Catch:{ Exception -> 0x0601 }
            android.content.Intent r12 = r11.getIntent()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = "isFromHomeScreenMap"
            boolean r12 = r12.getBooleanExtra(r1, r2)     // Catch:{ Exception -> 0x0601 }
            r11.isFromMapFirstFlow = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131427648(0x7f0b0140, float:1.8476918E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r12 = (android.widget.TextView) r12     // Catch:{ Exception -> 0x0601 }
            r11.autofillDescription = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131431378(0x7f0b0fd2, float:1.8484484E38)
            android.view.View r1 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            android.widget.Button r1 = (android.widget.Button) r1     // Catch:{ Exception -> 0x0601 }
            r11.skipBtn = r1     // Catch:{ Exception -> 0x0601 }
            r1 = 2131427660(0x7f0b014c, float:1.8476943E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x0601 }
            android.widget.ImageButton r1 = (android.widget.ImageButton) r1     // Catch:{ Exception -> 0x0601 }
            r11.backButton = r1     // Catch:{ Exception -> 0x0601 }
            r1 = 2131428027(0x7f0b02bb, float:1.8477687E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x0601 }
            android.widget.Button r1 = (android.widget.Button) r1     // Catch:{ Exception -> 0x0601 }
            r11.cancelButton = r1     // Catch:{ Exception -> 0x0601 }
            r1 = 2131430101(0x7f0b0ad5, float:1.8481893E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x0601 }
            android.widget.ImageView r1 = (android.widget.ImageView) r1     // Catch:{ Exception -> 0x0601 }
            r11.mapToolbarSearch = r1     // Catch:{ Exception -> 0x0601 }
            r1 = 2131427641(0x7f0b0139, float:1.8476904E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x0601 }
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1     // Catch:{ Exception -> 0x0601 }
            r11.mSearchContainer = r1     // Catch:{ Exception -> 0x0601 }
            r1 = 2131431915(0x7f0b11eb, float:1.8485573E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ Exception -> 0x0601 }
            r11.Title = r1     // Catch:{ Exception -> 0x0601 }
            r1 = 2131428405(0x7f0b0435, float:1.8478454E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x0601 }
            android.widget.Button r1 = (android.widget.Button) r1     // Catch:{ Exception -> 0x0601 }
            r11.confim = r1     // Catch:{ Exception -> 0x0601 }
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            android.widget.Button r12 = (android.widget.Button) r12     // Catch:{ Exception -> 0x0601 }
            r11.skipBtn = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131430020(0x7f0b0a84, float:1.848173E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            android.widget.ImageView r12 = (android.widget.ImageView) r12     // Catch:{ Exception -> 0x0601 }
            r11.locationButton = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131430021(0x7f0b0a85, float:1.8481731E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12     // Catch:{ Exception -> 0x0601 }
            r11.locationBtnContainer = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131429141(0x7f0b0715, float:1.8479946E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            r11.gemReminderView = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131431337(0x7f0b0fa9, float:1.84844E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            r11.mcdShowCaseView = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131432342(0x7f0b1396, float:1.8486439E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            com.talabat.talabatcommon.views.TalabatFillButton r12 = (com.talabat.talabatcommon.views.TalabatFillButton) r12     // Catch:{ Exception -> 0x0601 }
            r11.mcdShowCaseBtn = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131431839(0x7f0b119f, float:1.8485419E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            com.talabat.TalabatTextView r12 = (com.talabat.TalabatTextView) r12     // Catch:{ Exception -> 0x0601 }
            r11.mcdFlowShowCaseTxt = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131430100(0x7f0b0ad4, float:1.8481891E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            android.widget.ImageView r12 = (android.widget.ImageView) r12     // Catch:{ Exception -> 0x0601 }
            r11.mapPin = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131428416(0x7f0b0440, float:1.8478476E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            r11.normalConifirmContainer = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131428562(0x7f0b04d2, float:1.8478772E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12     // Catch:{ Exception -> 0x0601 }
            r11.myLocationCustomButtonGroup = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131430102(0x7f0b0ad6, float:1.8481895E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            android.widget.ImageView r12 = (android.widget.ImageView) r12     // Catch:{ Exception -> 0x0601 }
            r11.mapViewSwitchBtn = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131430133(0x7f0b0af5, float:1.8481958E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            r11.mcdFlowConfirmContainer = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131428419(0x7f0b0443, float:1.8478482E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            r11.confirmsView = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131428406(0x7f0b0436, float:1.8478456E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            com.talabat.talabatcommon.views.TalabatFillButton r12 = (com.talabat.talabatcommon.views.TalabatFillButton) r12     // Catch:{ Exception -> 0x0601 }
            r11.mcdConfirmBtn = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131428412(0x7f0b043c, float:1.8478468E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            r11.confirmContainer = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131430134(0x7f0b0af6, float:1.848196E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12     // Catch:{ Exception -> 0x0601 }
            r11.mcdSectionContainer = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131430143(0x7f0b0aff, float:1.8481979E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            r11.mcdBlockSectionContainer = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131427728(0x7f0b0190, float:1.847708E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            com.talabat.TalabatSpinner r12 = (com.talabat.TalabatSpinner) r12     // Catch:{ Exception -> 0x0601 }
            r11.mcdBlockSpinner = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131427725(0x7f0b018d, float:1.8477074E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            com.talabat.TalabatTextView r12 = (com.talabat.TalabatTextView) r12     // Catch:{ Exception -> 0x0601 }
            r11.mcdBlockNoTxt = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131430664(0x7f0b0d08, float:1.8483035E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            com.talabat.TalabatTextView r12 = (com.talabat.TalabatTextView) r12     // Catch:{ Exception -> 0x0601 }
            r11.mcdBlockNoHintTxt = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131430136(0x7f0b0af8, float:1.8481964E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            android.widget.Button r12 = (android.widget.Button) r12     // Catch:{ Exception -> 0x0601 }
            r11.mcdEditLocationBtn = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131430139(0x7f0b0afb, float:1.848197E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            android.widget.Button r12 = (android.widget.Button) r12     // Catch:{ Exception -> 0x0601 }
            r11.mcdProceedBtn = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131427729(0x7f0b0191, float:1.8477082E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            r11.mcdSpinnerSectionView = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131430135(0x7f0b0af7, float:1.8481962E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12     // Catch:{ Exception -> 0x0601 }
            r11.mcdDisableContainer = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131427727(0x7f0b018f, float:1.8477078E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            r11.mcdArrow = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131430426(0x7f0b0c1a, float:1.8482553E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            android.widget.Button r12 = (android.widget.Button) r12     // Catch:{ Exception -> 0x0601 }
            r11.onBoardingGotIt = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131428813(0x7f0b05cd, float:1.8479281E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            android.widget.Button r12 = (android.widget.Button) r12     // Catch:{ Exception -> 0x0601 }
            r11.fullBodyButton = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131430099(0x7f0b0ad3, float:1.848189E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            r11.mapOnBoardingcontentView = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131427795(0x7f0b01d3, float:1.8477216E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            r11.boardingContentView = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131428784(0x7f0b05b0, float:1.8479222E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            r11.dragTutorialContainer = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131428583(0x7f0b04e7, float:1.8478815E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            android.widget.ImageView r12 = (android.widget.ImageView) r12     // Catch:{ Exception -> 0x0601 }
            r11.dragTutorialClose = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131430425(0x7f0b0c19, float:1.848255E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            android.widget.ImageView r12 = (android.widget.ImageView) r12     // Catch:{ Exception -> 0x0601 }
            r11.onBoardingGifImg = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131430424(0x7f0b0c18, float:1.8482549E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            android.widget.ImageView r12 = (android.widget.ImageView) r12     // Catch:{ Exception -> 0x0601 }
            r11.onBoardingStatciImg = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131430138(0x7f0b0afa, float:1.8481968E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            r11.mcdKsaStreetSection = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131430141(0x7f0b0afd, float:1.8481975E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            com.materialedittext.MaterialEditText r12 = (com.materialedittext.MaterialEditText) r12     // Catch:{ Exception -> 0x0601 }
            r11.mcdKsaStreetEdtFld = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131430142(0x7f0b0afe, float:1.8481977E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            android.widget.Button r12 = (android.widget.Button) r12     // Catch:{ Exception -> 0x0601 }
            r11.mcdKsaProceedBtn = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131430140(0x7f0b0afc, float:1.8481973E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            android.widget.Button r12 = (android.widget.Button) r12     // Catch:{ Exception -> 0x0601 }
            r11.mcdKsaEditLocationBtn = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131431505(0x7f0b1051, float:1.8484741E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r12 = (android.widget.TextView) r12     // Catch:{ Exception -> 0x0601 }
            r11.mcdStreetLabel = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131430015(0x7f0b0a7f, float:1.848172E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12     // Catch:{ Exception -> 0x0601 }
            r11.locAwarContainer = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131430983(0x7f0b0e47, float:1.8483682E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            com.talabat.TalabatTextView r12 = (com.talabat.TalabatTextView) r12     // Catch:{ Exception -> 0x0601 }
            r11.resetLocation = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131432646(0x7f0b14c6, float:1.8487055E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            com.talabat.TalabatTextView r12 = (com.talabat.TalabatTextView) r12     // Catch:{ Exception -> 0x0601 }
            r11.deliverHere = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131430022(0x7f0b0a86, float:1.8481733E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            r11.locationbBtnSubContainer = r12     // Catch:{ Exception -> 0x0601 }
            r12 = 2131429187(0x7f0b0743, float:1.848004E38)
            android.view.View r12 = r11.findViewById(r12)     // Catch:{ Exception -> 0x0601 }
            r11.CustonGooglesearchContainer = r12     // Catch:{ Exception -> 0x0601 }
            boolean r12 = com.talabat.helpers.GlobalDataModel.Apptimize.CAN_SHOW_GOOGLE_AUTO_COMPLETE_WIDGET     // Catch:{ Exception -> 0x0601 }
            if (r12 == 0) goto L_0x0355
            boolean r12 = com.google.android.libraries.places.api.Places.isInitialized()     // Catch:{ Exception -> 0x0601 }
            if (r12 != 0) goto L_0x0355
            android.content.Context r12 = r11.getApplicationContext()     // Catch:{ Exception -> 0x0601 }
            com.talabat.authentication.aaa.secrets.SecretProvider r1 = r11.H     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = r1.getGoogleApiKey()     // Catch:{ Exception -> 0x0601 }
            com.google.android.libraries.places.api.Places.initialize(r12, r1)     // Catch:{ Exception -> 0x0601 }
        L_0x0355:
            android.view.View r12 = r11.CustonGooglesearchContainer     // Catch:{ Exception -> 0x0601 }
            r12.setVisibility(r2)     // Catch:{ Exception -> 0x0601 }
            com.talabat.homemaphelper.CurrentLocationFetch r12 = new com.talabat.homemaphelper.CurrentLocationFetch     // Catch:{ Exception -> 0x0601 }
            r12.<init>(r11, r11)     // Catch:{ Exception -> 0x0601 }
            r11.f54334u = r12     // Catch:{ Exception -> 0x0601 }
            com.talabat.maputils.CurrentLocHelper r1 = com.talabat.maputils.CurrentLocHelper.INSTANCE     // Catch:{ Exception -> 0x0601 }
            int r1 = r1.getIS_FROM_MAP()     // Catch:{ Exception -> 0x0601 }
            r12.initLocationRequest(r11, r1)     // Catch:{ Exception -> 0x0601 }
            android.widget.Button r12 = r11.fullBodyButton     // Catch:{ Exception -> 0x0601 }
            com.talabat.MapsActivity$1 r1 = new com.talabat.MapsActivity$1     // Catch:{ Exception -> 0x0601 }
            r1.<init>()     // Catch:{ Exception -> 0x0601 }
            r12.setOnClickListener(r1)     // Catch:{ Exception -> 0x0601 }
            android.widget.Button r12 = r11.onBoardingGotIt     // Catch:{ Exception -> 0x0601 }
            com.talabat.MapsActivity$2 r1 = new com.talabat.MapsActivity$2     // Catch:{ Exception -> 0x0601 }
            r1.<init>()     // Catch:{ Exception -> 0x0601 }
            r12.setOnClickListener(r1)     // Catch:{ Exception -> 0x0601 }
            com.talabat.TalabatTextView r12 = r11.resetLocation     // Catch:{ Exception -> 0x0601 }
            com.talabat.MapsActivity$3 r1 = new com.talabat.MapsActivity$3     // Catch:{ Exception -> 0x0601 }
            r1.<init>()     // Catch:{ Exception -> 0x0601 }
            r12.setOnClickListener(r1)     // Catch:{ Exception -> 0x0601 }
            com.talabat.TalabatTextView r12 = r11.deliverHere     // Catch:{ Exception -> 0x0601 }
            com.talabat.MapsActivity$4 r1 = new com.talabat.MapsActivity$4     // Catch:{ Exception -> 0x0601 }
            r1.<init>()     // Catch:{ Exception -> 0x0601 }
            r12.setOnClickListener(r1)     // Catch:{ Exception -> 0x0601 }
            boolean r12 = r11.isFromMcdGrlFlow     // Catch:{ Exception -> 0x0601 }
            r1 = 1
            if (r12 == 0) goto L_0x03ab
            tracking.AppTracker.onMcdMapShown(r11)     // Catch:{ Exception -> 0x0601 }
            buisnessmodels.ShowCaseViewLogic r12 = buisnessmodels.ShowCaseViewLogic.getInstance()     // Catch:{ Exception -> 0x0601 }
            boolean r12 = r12.showMcdTutPage()     // Catch:{ Exception -> 0x0601 }
            if (r12 == 0) goto L_0x03a7
            r11.waitLoadTutorial = r1     // Catch:{ Exception -> 0x0601 }
            goto L_0x03ae
        L_0x03a7:
            r11.loadingMapView()     // Catch:{ Exception -> 0x0601 }
            goto L_0x03ae
        L_0x03ab:
            r11.loadingMapView()     // Catch:{ Exception -> 0x0601 }
        L_0x03ae:
            java.lang.String r12 = r11.f54324k     // Catch:{ Exception -> 0x03de }
            boolean r12 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r12)     // Catch:{ Exception -> 0x03de }
            if (r12 == 0) goto L_0x03de
            com.talabat.maps.domain.model.LatLng r12 = com.talabat.helpers.GlobalDataModel.GEO_CORDINATES.addressPageLatLang     // Catch:{ Exception -> 0x03de }
            if (r12 == 0) goto L_0x03db
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03de }
            r12.<init>()     // Catch:{ Exception -> 0x03de }
            com.talabat.maps.domain.model.LatLng r3 = com.talabat.helpers.GlobalDataModel.GEO_CORDINATES.addressPageLatLang     // Catch:{ Exception -> 0x03de }
            double r3 = r3.getLatitude()     // Catch:{ Exception -> 0x03de }
            r12.append(r3)     // Catch:{ Exception -> 0x03de }
            java.lang.String r3 = ","
            r12.append(r3)     // Catch:{ Exception -> 0x03de }
            com.talabat.maps.domain.model.LatLng r3 = com.talabat.helpers.GlobalDataModel.GEO_CORDINATES.addressPageLatLang     // Catch:{ Exception -> 0x03de }
            double r3 = r3.getLongitude()     // Catch:{ Exception -> 0x03de }
            r12.append(r3)     // Catch:{ Exception -> 0x03de }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x03de }
            goto L_0x03dc
        L_0x03db:
            r12 = r0
        L_0x03dc:
            r11.f54324k = r12     // Catch:{ Exception -> 0x03de }
        L_0x03de:
            android.widget.LinearLayout r12 = r11.locationBtnContainer     // Catch:{ Exception -> 0x0601 }
            r12.setVisibility(r2)     // Catch:{ Exception -> 0x0601 }
            android.widget.ImageView r12 = r11.locationButton     // Catch:{ Exception -> 0x0601 }
            r12.setVisibility(r2)     // Catch:{ Exception -> 0x0601 }
            boolean r12 = r11.isNewAddressFromCartFlow     // Catch:{ Exception -> 0x0601 }
            r3 = 2132018113(0x7f1403c1, float:1.9674523E38)
            if (r12 == 0) goto L_0x03fd
            android.widget.TextView r12 = r11.Title     // Catch:{ Exception -> 0x0601 }
            android.content.res.Resources r4 = r11.getResources()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r3 = r4.getString(r3)     // Catch:{ Exception -> 0x0601 }
            r12.setText(r3)     // Catch:{ Exception -> 0x0601 }
            goto L_0x041f
        L_0x03fd:
            boolean r12 = r11.isFromMcdGrlFlow     // Catch:{ Exception -> 0x0601 }
            if (r12 == 0) goto L_0x0412
            android.widget.TextView r12 = r11.Title     // Catch:{ Exception -> 0x0601 }
            android.content.res.Resources r3 = r11.getResources()     // Catch:{ Exception -> 0x0601 }
            r4 = 2132018114(0x7f1403c2, float:1.9674526E38)
            java.lang.String r3 = r3.getString(r4)     // Catch:{ Exception -> 0x0601 }
            r12.setText(r3)     // Catch:{ Exception -> 0x0601 }
            goto L_0x041f
        L_0x0412:
            android.widget.TextView r12 = r11.Title     // Catch:{ Exception -> 0x0601 }
            android.content.res.Resources r4 = r11.getResources()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r3 = r4.getString(r3)     // Catch:{ Exception -> 0x0601 }
            r12.setText(r3)     // Catch:{ Exception -> 0x0601 }
        L_0x041f:
            boolean r12 = r11.isQuick     // Catch:{ Exception -> 0x0601 }
            if (r12 == 0) goto L_0x0428
            java.lang.String r12 = com.talabat.helpers.GlobalDataModel.SelectedAreaName     // Catch:{ Exception -> 0x0601 }
            r11.polygonAwayAreaName = r12     // Catch:{ Exception -> 0x0601 }
            goto L_0x0434
        L_0x0428:
            android.content.Intent r12 = r11.getIntent()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r3 = "isUserSelectedAreaName"
            java.lang.String r12 = r12.getStringExtra(r3)     // Catch:{ Exception -> 0x0601 }
            r11.polygonAwayAreaName = r12     // Catch:{ Exception -> 0x0601 }
        L_0x0434:
            boolean r12 = r11.noAreaChange     // Catch:{ Exception -> 0x0601 }
            if (r12 == 0) goto L_0x0453
            java.lang.String r12 = com.talabat.helpers.GlobalDataModel.SelectedAreaName     // Catch:{ Exception -> 0x0601 }
            if (r12 == 0) goto L_0x0461
            r12 = 2132017426(0x7f140112, float:1.967313E38)
            java.lang.String r12 = r11.getString(r12)     // Catch:{ Exception -> 0x0601 }
            java.lang.String r3 = "#$"
            java.lang.String r4 = com.talabat.helpers.GlobalDataModel.SelectedAreaName     // Catch:{ Exception -> 0x0601 }
            java.lang.String r12 = r12.replace(r3, r4)     // Catch:{ Exception -> 0x0601 }
            r11.description = r12     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r3 = r11.autofillDescription     // Catch:{ Exception -> 0x0601 }
            r3.setText(r12)     // Catch:{ Exception -> 0x0601 }
            goto L_0x0461
        L_0x0453:
            r12 = 2132017423(0x7f14010f, float:1.9673124E38)
            java.lang.String r12 = r11.getString(r12)     // Catch:{ Exception -> 0x0601 }
            r11.description = r12     // Catch:{ Exception -> 0x0601 }
            android.widget.TextView r3 = r11.autofillDescription     // Catch:{ Exception -> 0x0601 }
            r3.setText(r12)     // Catch:{ Exception -> 0x0601 }
        L_0x0461:
            boolean r12 = r11.isAddressFromCartOrderFlow     // Catch:{ Exception -> 0x0601 }
            if (r12 != 0) goto L_0x048a
            boolean r12 = r11.isNewAddressFromCartFlow     // Catch:{ Exception -> 0x0601 }
            if (r12 != 0) goto L_0x048a
            boolean r12 = r11.isQuick     // Catch:{ Exception -> 0x0601 }
            if (r12 == 0) goto L_0x046e
            goto L_0x048a
        L_0x046e:
            boolean r12 = r11.isNewAddessCreationFromSideMenu     // Catch:{ Exception -> 0x0601 }
            if (r12 == 0) goto L_0x0485
            java.lang.String r12 = "user_account"
            r11.mapJourneytype = r12     // Catch:{ Exception -> 0x0601 }
            boolean r12 = r11.isEditAddressFromSideMenu     // Catch:{ Exception -> 0x0601 }
            if (r12 == 0) goto L_0x0480
            int r12 = com.talabat.helpers.GlobalDataModel.MAP_ADDRESS_TYPE.AUTOMATIC_MAP_ADDRESS     // Catch:{ Exception -> 0x0601 }
            r11.addressSelectionType = r12     // Catch:{ Exception -> 0x0601 }
            goto L_0x0497
        L_0x0480:
            int r12 = com.talabat.helpers.GlobalDataModel.MAP_ADDRESS_TYPE.AUTOMATIC_MAP_ADDRESS     // Catch:{ Exception -> 0x0601 }
            r11.addressSelectionType = r12     // Catch:{ Exception -> 0x0601 }
            goto L_0x0497
        L_0x0485:
            int r12 = com.talabat.helpers.GlobalDataModel.MAP_ADDRESS_TYPE.MANUAL_MAP_ADDRESS     // Catch:{ Exception -> 0x0601 }
            r11.addressSelectionType = r12     // Catch:{ Exception -> 0x0601 }
            goto L_0x0497
        L_0x048a:
            java.lang.String r12 = "cart"
            r11.mapJourneytype = r12     // Catch:{ Exception -> 0x0601 }
            library.talabat.mvp.googlemaps.ITalabatMapPresenter r12 = r11.talabatMapPresenter     // Catch:{ Exception -> 0x0601 }
            r12.updateRestaurantpolygonServiceEnabled()     // Catch:{ Exception -> 0x0601 }
            int r12 = com.talabat.helpers.GlobalDataModel.MAP_ADDRESS_TYPE.MANUAL_MAP_ADDRESS     // Catch:{ Exception -> 0x0601 }
            r11.addressSelectionType = r12     // Catch:{ Exception -> 0x0601 }
        L_0x0497:
            boolean r12 = r11.isFromMcdGrlFlow     // Catch:{ Exception -> 0x0601 }
            r3 = 8
            if (r12 == 0) goto L_0x0558
            android.view.View r12 = r11.normalConifirmContainer     // Catch:{ Exception -> 0x0601 }
            r12.setVisibility(r2)     // Catch:{ Exception -> 0x0601 }
            android.widget.ImageView r12 = r11.mapToolbarSearch     // Catch:{ Exception -> 0x0601 }
            r12.setVisibility(r2)     // Catch:{ Exception -> 0x0601 }
            buisnessmodels.ShowCaseViewLogic r12 = buisnessmodels.ShowCaseViewLogic.getInstance()     // Catch:{ Exception -> 0x0601 }
            boolean r12 = r12.showMcdTutPage()     // Catch:{ Exception -> 0x0601 }
            if (r12 == 0) goto L_0x0539
            r11.isNeedShowDragTutorial = r1     // Catch:{ Exception -> 0x0601 }
            android.view.View r12 = r11.mcdShowCaseView     // Catch:{ Exception -> 0x0601 }
            r12.setVisibility(r2)     // Catch:{ Exception -> 0x0601 }
            int r12 = com.talabat.helpers.GlobalDataModel.SelectedCountryId     // Catch:{ Exception -> 0x0601 }
            com.talabat.configuration.country.Country r1 = com.talabat.configuration.country.Country.KSA     // Catch:{ Exception -> 0x0601 }
            int r1 = r1.getCountryId()     // Catch:{ Exception -> 0x0601 }
            java.lang.String r3 = "##"
            if (r12 != r1) goto L_0x04db
            android.widget.TextView r12 = r11.mcdFlowShowCaseTxt     // Catch:{ Exception -> 0x0601 }
            android.content.res.Resources r1 = r11.getResources()     // Catch:{ Exception -> 0x0601 }
            r4 = 2132019124(0x7f1407b4, float:1.9676574E38)
            java.lang.String r1 = r1.getString(r4)     // Catch:{ Exception -> 0x0601 }
            java.lang.String r4 = com.talabat.helpers.GlobalDataModel.SelectedAreaName     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = r1.replace(r3, r4)     // Catch:{ Exception -> 0x0601 }
            r12.setText(r1)     // Catch:{ Exception -> 0x0601 }
            goto L_0x051c
        L_0x04db:
            int r12 = com.talabat.helpers.GlobalDataModel.SelectedCountryId     // Catch:{ Exception -> 0x0601 }
            com.talabat.configuration.country.Country r1 = com.talabat.configuration.country.Country.BAHRAIN     // Catch:{ Exception -> 0x0601 }
            int r1 = r1.getCountryId()     // Catch:{ Exception -> 0x0601 }
            if (r12 != r1) goto L_0x04fc
            android.widget.TextView r12 = r11.mcdFlowShowCaseTxt     // Catch:{ Exception -> 0x0601 }
            android.content.res.Resources r1 = r11.getResources()     // Catch:{ Exception -> 0x0601 }
            r4 = 2132019116(0x7f1407ac, float:1.9676558E38)
            java.lang.String r1 = r1.getString(r4)     // Catch:{ Exception -> 0x0601 }
            java.lang.String r4 = com.talabat.helpers.GlobalDataModel.SelectedAreaName     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = r1.replace(r3, r4)     // Catch:{ Exception -> 0x0601 }
            r12.setText(r1)     // Catch:{ Exception -> 0x0601 }
            goto L_0x051c
        L_0x04fc:
            int r12 = com.talabat.helpers.GlobalDataModel.SelectedCountryId     // Catch:{ Exception -> 0x0601 }
            com.talabat.configuration.country.Country r1 = com.talabat.configuration.country.Country.JORDAN     // Catch:{ Exception -> 0x0601 }
            int r1 = r1.getCountryId()     // Catch:{ Exception -> 0x0601 }
            if (r12 != r1) goto L_0x051c
            android.widget.TextView r12 = r11.mcdFlowShowCaseTxt     // Catch:{ Exception -> 0x0601 }
            android.content.res.Resources r1 = r11.getResources()     // Catch:{ Exception -> 0x0601 }
            r4 = 2132019123(0x7f1407b3, float:1.9676572E38)
            java.lang.String r1 = r1.getString(r4)     // Catch:{ Exception -> 0x0601 }
            java.lang.String r4 = com.talabat.helpers.GlobalDataModel.SelectedAreaName     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = r1.replace(r3, r4)     // Catch:{ Exception -> 0x0601 }
            r12.setText(r1)     // Catch:{ Exception -> 0x0601 }
        L_0x051c:
            buisnessmodels.ShowCaseViewLogic r12 = buisnessmodels.ShowCaseViewLogic.getInstance()     // Catch:{ Exception -> 0x0601 }
            r12.setmcdMapTutPage()     // Catch:{ Exception -> 0x0601 }
            buisnessmodels.ShowCaseViewLogic r12 = buisnessmodels.ShowCaseViewLogic.getInstance()     // Catch:{ Exception -> 0x0601 }
            android.content.Context r1 = r11.getContext()     // Catch:{ Exception -> 0x0601 }
            r12.saveToPrefs(r1)     // Catch:{ Exception -> 0x0601 }
            android.widget.Button r12 = r11.mcdShowCaseBtn     // Catch:{ Exception -> 0x0601 }
            com.talabat.MapsActivity$5 r1 = new com.talabat.MapsActivity$5     // Catch:{ Exception -> 0x0601 }
            r1.<init>()     // Catch:{ Exception -> 0x0601 }
            r12.setOnClickListener(r1)     // Catch:{ Exception -> 0x0601 }
            goto L_0x0593
        L_0x0539:
            r11.isNeedShowDragTutorial = r1     // Catch:{ Exception -> 0x0601 }
            library.talabat.mvp.googlemaps.ITalabatMapPresenter r12 = r11.talabatMapPresenter     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = r11.f54324k     // Catch:{ Exception -> 0x0601 }
            r12.userConfirmedTempLocation(r1)     // Catch:{ Exception -> 0x0601 }
            library.talabat.mvp.googlemaps.ITalabatMapPresenter r4 = r11.talabatMapPresenter     // Catch:{ Exception -> 0x0601 }
            int r5 = r11.addressSelectionType     // Catch:{ Exception -> 0x0601 }
            boolean r6 = r11.isMapcompulsory     // Catch:{ Exception -> 0x0601 }
            boolean r7 = r11.isNineCookiesTrackingEnabled     // Catch:{ Exception -> 0x0601 }
            int r8 = r11.userSelectedAreaId     // Catch:{ Exception -> 0x0601 }
            boolean r9 = r11.isFromMcdGrlFlow     // Catch:{ Exception -> 0x0601 }
            r10 = 0
            r4.mapViewInitilise(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0601 }
            android.view.View r12 = r11.mcdShowCaseView     // Catch:{ Exception -> 0x0601 }
            r12.setVisibility(r3)     // Catch:{ Exception -> 0x0601 }
            goto L_0x0593
        L_0x0558:
            android.widget.ImageView r12 = r11.mapToolbarSearch     // Catch:{ Exception -> 0x0601 }
            r12.setVisibility(r2)     // Catch:{ Exception -> 0x0601 }
            android.view.View r12 = r11.confirmContainer     // Catch:{ Exception -> 0x0601 }
            r12.setVisibility(r2)     // Catch:{ Exception -> 0x0601 }
            android.view.View r12 = r11.mcdFlowConfirmContainer     // Catch:{ Exception -> 0x0601 }
            r12.setVisibility(r3)     // Catch:{ Exception -> 0x0601 }
            android.view.View r12 = r11.mcdShowCaseView     // Catch:{ Exception -> 0x0601 }
            r12.setVisibility(r3)     // Catch:{ Exception -> 0x0601 }
            buisnessmodels.ShowCaseViewLogic r12 = buisnessmodels.ShowCaseViewLogic.getInstance()     // Catch:{ Exception -> 0x0601 }
            r12.setMapOnBoarding()     // Catch:{ Exception -> 0x0601 }
            buisnessmodels.ShowCaseViewLogic r12 = buisnessmodels.ShowCaseViewLogic.getInstance()     // Catch:{ Exception -> 0x0601 }
            r12.saveToPrefs(r11)     // Catch:{ Exception -> 0x0601 }
            r11.isNeedShowDragTutorial = r1     // Catch:{ Exception -> 0x0601 }
            library.talabat.mvp.googlemaps.ITalabatMapPresenter r12 = r11.talabatMapPresenter     // Catch:{ Exception -> 0x0601 }
            java.lang.String r1 = r11.f54324k     // Catch:{ Exception -> 0x0601 }
            r12.userConfirmedTempLocation(r1)     // Catch:{ Exception -> 0x0601 }
            library.talabat.mvp.googlemaps.ITalabatMapPresenter r3 = r11.talabatMapPresenter     // Catch:{ Exception -> 0x0601 }
            int r4 = r11.addressSelectionType     // Catch:{ Exception -> 0x0601 }
            boolean r5 = r11.isMapcompulsory     // Catch:{ Exception -> 0x0601 }
            boolean r6 = r11.isNineCookiesTrackingEnabled     // Catch:{ Exception -> 0x0601 }
            int r7 = r11.userSelectedAreaId     // Catch:{ Exception -> 0x0601 }
            boolean r8 = r11.isFromMcdGrlFlow     // Catch:{ Exception -> 0x0601 }
            r9 = 0
            r3.mapViewInitilise(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0601 }
        L_0x0593:
            r12 = 0
            r11.confirmButtonEnable(r12)     // Catch:{ Exception -> 0x0601 }
            android.widget.Button r12 = r11.skipBtn     // Catch:{ Exception -> 0x0601 }
            com.talabat.MapsActivity$6 r1 = new com.talabat.MapsActivity$6     // Catch:{ Exception -> 0x0601 }
            r1.<init>()     // Catch:{ Exception -> 0x0601 }
            r12.setOnClickListener(r1)     // Catch:{ Exception -> 0x0601 }
            android.widget.ImageView r12 = r11.mapToolbarSearch     // Catch:{ Exception -> 0x0601 }
            com.talabat.MapsActivity$7 r1 = new com.talabat.MapsActivity$7     // Catch:{ Exception -> 0x0601 }
            r1.<init>()     // Catch:{ Exception -> 0x0601 }
            r12.setOnClickListener(r1)     // Catch:{ Exception -> 0x0601 }
            android.widget.Button r12 = r11.cancelButton     // Catch:{ Exception -> 0x0601 }
            com.talabat.MapsActivity$8 r1 = new com.talabat.MapsActivity$8     // Catch:{ Exception -> 0x0601 }
            r1.<init>()     // Catch:{ Exception -> 0x0601 }
            r12.setOnClickListener(r1)     // Catch:{ Exception -> 0x0601 }
            android.widget.Button r12 = r11.confim     // Catch:{ Exception -> 0x0601 }
            com.talabat.MapsActivity$9 r1 = new com.talabat.MapsActivity$9     // Catch:{ Exception -> 0x0601 }
            r1.<init>()     // Catch:{ Exception -> 0x0601 }
            r12.setOnClickListener(r1)     // Catch:{ Exception -> 0x0601 }
            android.widget.Button r12 = r11.mcdConfirmBtn     // Catch:{ Exception -> 0x0601 }
            com.talabat.MapsActivity$10 r1 = new com.talabat.MapsActivity$10     // Catch:{ Exception -> 0x0601 }
            r1.<init>()     // Catch:{ Exception -> 0x0601 }
            r12.setOnClickListener(r1)     // Catch:{ Exception -> 0x0601 }
            boolean r12 = com.talabat.helpers.GlobalConstants.isDrawCountryPolygon     // Catch:{ Exception -> 0x0601 }
            if (r12 == 0) goto L_0x05d6
            java.util.List<com.google.android.gms.maps.model.LatLng> r12 = com.talabat.helpers.GlobalDataModel.GEO_CORDINATES.polyGonPoints     // Catch:{ Exception -> 0x0601 }
            if (r12 != 0) goto L_0x05d6
            library.talabat.mvp.googlemaps.ITalabatMapPresenter r12 = r11.talabatMapPresenter     // Catch:{ Exception -> 0x0601 }
            r12.mapCountryPolyGonLoaded()     // Catch:{ Exception -> 0x0601 }
        L_0x05d6:
            android.widget.ImageButton r12 = r11.backButton     // Catch:{ Exception -> 0x0601 }
            com.talabat.MapsActivity$11 r1 = new com.talabat.MapsActivity$11     // Catch:{ Exception -> 0x0601 }
            r1.<init>()     // Catch:{ Exception -> 0x0601 }
            r12.setOnClickListener(r1)     // Catch:{ Exception -> 0x0601 }
            android.view.View r12 = r11.locationbBtnSubContainer     // Catch:{ Exception -> 0x0601 }
            if (r12 == 0) goto L_0x05ef
            android.widget.LinearLayout r12 = r11.locationBtnContainer     // Catch:{ Exception -> 0x0601 }
            com.talabat.MapsActivity$12 r1 = new com.talabat.MapsActivity$12     // Catch:{ Exception -> 0x0601 }
            r1.<init>()     // Catch:{ Exception -> 0x0601 }
            r12.setOnClickListener(r1)     // Catch:{ Exception -> 0x0601 }
            goto L_0x05f1
        L_0x05ef:
            r11.isLocationClicked = r2     // Catch:{ Exception -> 0x0601 }
        L_0x05f1:
            android.widget.ImageView r12 = r11.mapViewSwitchBtn     // Catch:{ Exception -> 0x0601 }
            if (r12 == 0) goto L_0x05fd
            com.talabat.MapsActivity$13 r1 = new com.talabat.MapsActivity$13     // Catch:{ Exception -> 0x0601 }
            r1.<init>()     // Catch:{ Exception -> 0x0601 }
            r12.setOnClickListener(r1)     // Catch:{ Exception -> 0x0601 }
        L_0x05fd:
            r11.inflateGemFooter()     // Catch:{ Exception -> 0x0601 }
            goto L_0x060b
        L_0x0601:
            r12 = move-exception
            r12.printStackTrace()
            tracking.AppTracker.onMapClosed(r11, r0)
            r11.finish()
        L_0x060b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.MapsActivity.onCreate(android.os.Bundle):void");
    }

    public void onCurrentLocationReceived(com.google.android.gms.maps.model.LatLng latLng, boolean z11, float f11) {
        this.currentGPSLocation = toOurs(latLng, this.F);
    }

    public void onCurrentLocationReceivedWithLowAccuracy(@NotNull com.google.android.gms.maps.model.LatLng latLng, float f11) {
        this.f54334u.startLocationUpdates(this);
    }

    public void onError() {
    }

    public void onFragmentInteraction(@NotNull Place place) {
        resetCustomSearch();
        autoCompledWidgetSelection(place);
    }

    public void onGeoCordinatesUpdated(Address address) {
        if (!this.noAreaChange || address.areaId == GlobalDataModel.SelectedAreaId || this.isNewAddessCreationFromSideMenu) {
            redirectToAddressPage(address);
        } else {
            locationMismatch(address);
        }
    }

    public void onGeoLocationDialogAccepted(boolean z11) {
        onLocationDialogAccepted(Boolean.valueOf(z11));
    }

    public /* synthetic */ void onInterestClicked(Restaurant restaurant) {
        a.g(this, restaurant);
    }

    public /* synthetic */ void onLeaveOfferClicked(boolean z11) {
        a.h(this, z11);
    }

    public void onMapReady(FrameworkMap frameworkMap) {
        String str;
        View view;
        this.mMap = frameworkMap;
        frameworkMap.getUiSettings().setMyLocationButtonEnabled(true);
        this.mMap.setLatLngBoundsForCameraTarget(countryLatLangBound());
        this.mMap.getUiSettings().setCompassEnabled(false);
        this.mMap.getUiSettings().setTiltGesturesEnabled(true);
        this.mMap.getUiSettings().setRotateGesturesEnabled(true);
        this.mMap.getUiSettings().setZoomGesturesEnabled(true);
        this.mMap.setBuildingsEnabled(true);
        if (this.mMap.getMapType() == FrameworkMap.MapType.MAP_TYPE_SATELLITE) {
            str = "plain";
        } else {
            str = "satellite";
        }
        AppTracker.onMapShown(this, "", (com.google.android.gms.maps.model.LatLng) null, str);
        if (defaultLatLang() != null) {
            this.mMap.moveCamera(this.f54322i.newLatLngZoom(defaultLatLang(), 11.0f));
        }
        this.isInitialMapZoom = true;
        this.mMap.setIndoorEnabled(false);
        ITalabatMapPresenter iTalabatMapPresenter = this.talabatMapPresenter;
        if (iTalabatMapPresenter != null) {
            iTalabatMapPresenter.mapReady(true);
            if (GlobalConstants.isDrawCountryPolygon) {
                if (GlobalDataModel.GEO_CORDINATES.polyGonPoints == null) {
                    this.talabatMapPresenter.mapCountryPolyGonLoaded();
                } else {
                    drawPolygon();
                }
            }
            animtLocationBtn(Boolean.TRUE);
            loadMapViewTypeAptimize();
            if (GlobalDataModel.GEMCONSTANTS.isGemFlow && (view = this.confirmsView) != null) {
                view.setPadding(0, 0, 0, (int) getResources().getDimension(R.dimen.map_margin));
            }
            setPaddingForGoogleLogo(this.mMap, this);
            this.mMap.setOnCameraIdleListener(new FrameworkMap.OnCameraIdleListener() {
                public void onCameraIdle() {
                    LatLng target = MapsActivity.this.mMap.getCameraPosition().getTarget();
                    MapsActivity mapsActivity = MapsActivity.this;
                    mapsActivity.latLngmain = target;
                    mapsActivity.isCameraSettled = true;
                    if (!ShowCaseViewLogic.getInstance().showOnBoarding() || !MapsActivity.this.cameraFinished || MapsActivity.this.isFromMcdGrlFlow) {
                        if (MapsActivity.this.currentGPSLocation != null) {
                            try {
                                String substring = (MapsActivity.this.currentGPSLocation.getLatitude() + "").substring(0, 6);
                                String substring2 = (MapsActivity.this.currentGPSLocation.getLongitude() + "").substring(0, 6);
                                String substring3 = (MapsActivity.this.latLngmain.getLatitude() + "").substring(0, 6);
                                String substring4 = (MapsActivity.this.latLngmain.getLongitude() + "").substring(0, 6);
                                if (substring.equals(substring3) && substring2.equals(substring4)) {
                                    MapsActivity.this.userIntractedWithMap = true;
                                    MapsActivity.this.hideMapTutorail();
                                }
                            } catch (Exception unused) {
                            }
                        }
                        MapsActivity.this.tempAddress = target;
                        if (!MapsActivity.this.isInitialMapZoom) {
                            MapsActivity mapsActivity2 = MapsActivity.this;
                            mapsActivity2.userSelectedZoom = mapsActivity2.mMap.getCameraPosition().getZoom();
                        }
                        MapsActivity mapsActivity3 = MapsActivity.this;
                        mapsActivity3.confirmButtonEnable(mapsActivity3.latLngmain);
                        MapsActivity mapsActivity4 = MapsActivity.this;
                        mapsActivity4.markerWindowDecesionHandler(mapsActivity4.latLngmain);
                        return;
                    }
                    MapsActivity.this.animateOnBoarding();
                }
            });
            this.mMap.setOnCameraMoveListener(new FrameworkMap.OnCameraMoveListener() {
                public void onCameraMove() {
                    MapsActivity.this.latLngmain = MapsActivity.this.mMap.getCameraPosition().getTarget();
                }
            });
            this.mMap.setOnCameraMoveCanceledListener(new FrameworkMap.OnCameraMoveCanceledListener() {
                public void onCameraMoveCanceled() {
                }
            });
            if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                legacyHideLocationButton(false);
                this.talabatMapPresenter.waitForCurrentLocation(false);
                this.f54336w = "plain";
                this.mMap.setMyLocationEnabled(true);
                locationButtonEnable(true);
                onTrackMapLoaded();
            }
        }
    }

    public void onPause() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            GEMEngine.getInstance();
            GEMEngine.stopListening();
        }
        if (!this.isFromMcdGrlFlow) {
            ShowCaseViewLogic.getInstance().setMapOnBoarding();
            ShowCaseViewLogic.getInstance().saveToPrefs(this);
        }
        super.onPause();
    }

    public void onResume() {
        androidx.appcompat.app.AlertDialog alertDialog2;
        super.onResume();
        showHideGemFooter(this.f54329p, this, false);
        if (GlobalDataModel.HOME_SCREEN_MAP.REFRSH_LOCATION_FROM_BG && this.f54334u.userAllowedAllLocationPermissions(this) && (alertDialog2 = this.alertDialog) != null && !alertDialog2.isShowing()) {
            this.alertDialog.dismiss();
        }
    }

    public void onStop() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            showTimerView(true, "");
        }
        if (this.isFromMcdGrlFlow) {
            AppTracker.onMcdMapClosed(this);
        }
        super.onStop();
    }

    public void onUpdateMapAfterUserInterection(boolean z11) {
        if (z11) {
            this.confirmsView.setVisibility(0);
            this.userIntractedWithMap = true;
            this.locationMethod = TrackingUtils.INSTANCE.getLocationMethodMapCoordinates();
            GlobalDataModel.GEO_CORDINATES.addressPageLatLang = this.latLngmain;
            GlobalDataModel.GEO_CORDINATES.isUserInteractedWithMapLocation = true;
            if (this.isFromMcdGrlFlow) {
                View view = this.mcdFlowConfirmContainer;
                if (view != null) {
                    view.setVisibility(0);
                    buttonDisable(this.mcdConfirmBtn);
                }
            } else {
                this.normalConifirmContainer.setVisibility(0);
                buttonDisable(this.confim);
                if (this.skipBtn.getVisibility() == 0) {
                    buttonDisable(this.skipBtn);
                }
            }
            hideMapTutorail();
            View view2 = this.locAwarContainer;
            if (view2 != null && view2.getVisibility() == 0) {
                slideDown();
            }
            this.mapPin.setImageResource(R.drawable.ic_m_map_location_pin_disabled);
            return;
        }
        this.mapPin.setImageResource(R.drawable.ic_m_map_location_pin);
        this.confirmsView.setVisibility(0);
        if (this.isFromMcdGrlFlow) {
            View view3 = this.mcdFlowConfirmContainer;
            if (view3 != null) {
                view3.setVisibility(0);
                buttonEnable(this.mcdConfirmBtn);
                return;
            }
            return;
        }
        this.normalConifirmContainer.setVisibility(0);
        this.confim.setVisibility(0);
        buttonEnable(this.confim);
        Button button = this.skipBtn;
        if (button != null) {
            button.setVisibility(8);
        }
    }

    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        if (this.mcdBlockSpinner.hasBeenOpened() && z11) {
            this.mcdBlockSpinner.setVisibility(8);
        }
    }

    public void polyGonLoaded(List<com.google.android.gms.maps.model.LatLng> list) {
        List<com.google.android.gms.maps.model.LatLng> list2 = GlobalDataModel.GEO_CORDINATES.polyGonPoints;
        if (list2 != null && list2.size() > 0) {
            drawPolygon();
        }
    }

    public void requestForCurrentLocation(boolean z11) {
        fetchCurrentLocationRequest();
    }

    public void restaurantOutSideDeliveryZone(Address address) {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((int) R.string.location_not_without_polygon_message);
        builder.setTitle((int) R.string.rest_out_of_delivery_zone);
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
        builder.show();
        trackMapErrorShown(TrackingUtils.INSTANCE.getOutOfDeliveryZone(), address);
    }

    public void setPaddingForGoogleLogo(FrameworkMap frameworkMap, Context context) {
        int i11;
        if (!GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            TalabatUtils.isArabic();
            i11 = 65;
        } else if (TalabatUtils.isArabic()) {
            i11 = 115;
        } else {
            i11 = 105;
        }
        TalabatUtils.isArabic();
        TalabatUtils.isArabic();
        frameworkMap.setPadding(0, getPixelFromDp(i11), 0, getPixelFromDp(i11));
    }

    public void showAddressNotSelectedPopup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((int) R.string.select_location);
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public /* synthetic */ void showGemDialog() {
        v00.a.a(this);
    }

    public void showInAppReminder(int i11) {
        Context context = getContext();
        String string = getResources().getString(R.string.gem_order_notification);
        Toast.makeText(context, string.replace("#", "" + i11), 0).show();
    }

    public void showMcdBlockSection(final McdBlockAddressResponse mcdBlockAddressResponse, boolean z11) {
        stopLodingPopup();
        AppTracker.onMcdBlockSelectionShown(this);
        if (this.locationButton != null) {
            View view = this.locationbBtnSubContainer;
            if (view != null) {
                view.setVisibility(4);
            }
            if (!this.isLocationPermissionAllowed) {
                this.locationButton.setVisibility(4);
            }
        }
        ImageView imageView = this.mapViewSwitchBtn;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        legacyHideLocationButton(false);
        if (z11) {
            setMcdBlockStreetSectionContainer(true);
            this.mcdBlockSpinner.setVisibility(8);
            this.mcdArrow.setVisibility(8);
            this.mcdSpinnerSectionView.setBackgroundColor(getResources().getColor(R.color.neutral_10));
            this.mcdSpinnerSectionView.setEnabled(false);
            this.mcdBlockNoTxt.setText(mcdBlockAddressResponse.McdAddress.block);
            this.mcdBlockNoTxt.setVisibility(0);
            this.mcdBlockNoHintTxt.setVisibility(8);
            this.f54330q = mcdBlockAddressResponse.McdAddress.block;
            this.f54331r = true;
            this.f54332s = false;
            setMcdProceedEnable(true);
        } else {
            McdBlocks[] mcdBlocksArr = mcdBlockAddressResponse.mcdBlocks;
            String str = "";
            if (mcdBlocksArr == null) {
                setMcdBlockStreetSectionContainer(false);
                if (!TalabatUtils.isNullOrEmpty(mcdBlockAddressResponse.McdAddress.block)) {
                    str = mcdBlockAddressResponse.McdAddress.block;
                }
                mcdDeliveryUnAvailableAlert(str);
            } else if (mcdBlocksArr.length > 0) {
                setMcdProceedEnable(false);
                if (mcdBlockAddressResponse.mcdBlocks.length > 3) {
                    this.mcdBlockSpinner.setDropDownVerticalOffset((int) getResources().getDimension(R.dimen.spinner_offset_more_count));
                } else {
                    this.mcdBlockSpinner.setDropDownVerticalOffset((int) getResources().getDimension(R.dimen.spinner_offset_less_count));
                }
                setMcdBlockStreetSectionContainer(true);
                this.mcdArrow.setVisibility(0);
                this.mcdBlockNoTxt.setVisibility(8);
                this.mcdBlockNoHintTxt.setVisibility(0);
                this.mcdSpinnerSectionView.setEnabled(true);
                this.mcdSpinnerSectionView.setBackground(getResources().getDrawable(R.drawable.roundborder_home));
                this.mcdBlockNoHintTxt.setText(getResources().getString(R.string.mcd_please_choose));
                final ArrayList arrayList = new ArrayList();
                arrayList.addAll(Arrays.asList(mcdBlockAddressResponse.mcdBlocks));
                Arrays.asList(mcdBlockAddressResponse.mcdBlocks);
                this.mcdBlockSpinner.setVisibility(8);
                ArrayList arrayList2 = new ArrayList();
                if (arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(((McdBlocks) it.next()).blockId);
                    }
                }
                new CustomSpinnerAdapter(this, R.layout.block_list_item, R.id.title, arrayList);
                this.mcdBlockSpinner.setAdapter((SpinnerAdapter) new ArrayAdapter(this, 17367049, arrayList2));
                this.mcdSpinnerSectionView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        MapsActivity.this.mcdBlockSpinner.setVisibility(0);
                        MapsActivity.this.mcdBlockSpinner.performClick();
                    }
                });
                if (arrayList2.size() == 1) {
                    this.mcdBlockSpinner.setSelection(0);
                }
                this.mcdBlockSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i11, long j11) {
                        if (MapsActivity.this.isMcdSpinnerInitial) {
                            MapsActivity.this.isMcdSpinnerInitial = false;
                            MapsActivity.this.setMcdProceedEnable(false);
                            return;
                        }
                        MapsActivity.this.setMcdProceedEnable(true);
                        MapsActivity.this.mcdBlockNoTxt.setVisibility(8);
                        MapsActivity.this.mcdBlockNoHintTxt.setVisibility(0);
                        MapsActivity.this.mcdBlockNoHintTxt.setTextColor(MapsActivity.this.getResources().getColor(R.color.talabat_black));
                        MapsActivity.this.mcdBlockNoHintTxt.setText(((McdBlocks) arrayList.get(i11)).blockId.toString());
                        MapsActivity.this.f54330q = ((McdBlocks) arrayList.get(i11)).blockId;
                        MapsActivity mapsActivity = MapsActivity.this;
                        mapsActivity.f54331r = false;
                        mapsActivity.f54332s = true;
                        mapsActivity.mcdBlockSpinner.setVisibility(8);
                    }

                    public void onNothingSelected(AdapterView<?> adapterView) {
                        MapsActivity.this.mcdBlockSpinner.setVisibility(8);
                    }
                });
            } else {
                setMcdBlockStreetSectionContainer(false);
                if (!TalabatUtils.isNullOrEmpty(mcdBlockAddressResponse.McdAddress.block)) {
                    str = mcdBlockAddressResponse.McdAddress.block;
                }
                mcdDeliveryUnAvailableAlert(str);
            }
        }
        this.mcdProceedBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!TalabatUtils.isNullOrEmpty(MapsActivity.this.f54330q)) {
                    MapsActivity.this.startLodingPopup();
                    if (mcdBlockAddressResponse.McdAddress != null && !TalabatUtils.isNullOrEmpty(MapsActivity.this.f54330q)) {
                        mcdBlockAddressResponse.McdAddress.block = MapsActivity.this.f54330q;
                    }
                    MapsActivity mapsActivity = MapsActivity.this;
                    AppTracker.onMcdProceedClicked(mapsActivity, mapsActivity.f54331r, mapsActivity.f54332s);
                    McdBranchRequest mcdBranchRequest = new McdBranchRequest(mcdBlockAddressResponse.McdAddress, MapsActivity.this.restaurantId);
                    ITalabatMapPresenter o02 = MapsActivity.this.talabatMapPresenter;
                    Address address = mcdBlockAddressResponse.McdAddress;
                    if (address == null) {
                        address = null;
                    }
                    o02.getMcdBranchIdFromBlock(address, MapsActivity.this.f54330q, mcdBranchRequest);
                }
            }
        });
        this.mcdEditLocationBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MapsActivity.this.isMcdSpinnerInitial = true;
                if (MapsActivity.this.locationButton != null && !MapsActivity.this.isLocationPermissionAllowed) {
                    MapsActivity.this.locationButton.setVisibility(0);
                }
                if (MapsActivity.this.locationbBtnSubContainer != null) {
                    MapsActivity.this.locationbBtnSubContainer.setVisibility(0);
                }
                if (MapsActivity.this.mapViewSwitchBtn != null) {
                    MapsActivity.this.mapViewSwitchBtn.setVisibility(0);
                }
                AppTracker.onMcdEditLocationClicked(MapsActivity.this);
                MapsActivity.this.hideMcdBlockSectionContainer();
            }
        });
    }

    public void showMcdStreetSelection(final McdStreetAddressResponse mcdStreetAddressResponse) {
        View view = this.locationbBtnSubContainer;
        if (view != null) {
            view.setVisibility(4);
        }
        ImageView imageView = this.locationButton;
        if (imageView != null && !this.isLocationPermissionAllowed) {
            imageView.setVisibility(4);
        }
        ImageView imageView2 = this.mapViewSwitchBtn;
        if (imageView2 != null) {
            imageView2.setVisibility(4);
        }
        stopLodingPopup();
        this.mcdKsaStreetEdtFld.setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
        setMcdBlockStreetSectionContainer(true);
        if (!TalabatUtils.isNullOrEmpty(mcdStreetAddressResponse.McdAddress.street)) {
            this.f54331r = true;
            this.mcdKsaStreetEdtFld.setFloatingLabel(0);
            this.mcdKsaStreetEdtFld.setText(mcdStreetAddressResponse.McdAddress.street);
            this.f54333t = mcdStreetAddressResponse.McdAddress.street;
            this.mcdStreetLabel.setVisibility(0);
            this.mcdKsaProceedBtn.setEnabled(true);
            this.mcdKsaProceedBtn.setAlpha(1.0f);
        } else {
            this.f54333t = "";
            this.f54331r = false;
            this.mcdKsaProceedBtn.setEnabled(false);
            this.mcdKsaProceedBtn.setAlpha(0.5f);
            this.mcdStreetLabel.setVisibility(8);
        }
        this.mcdKsaProceedBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!TalabatUtils.isNullOrEmpty(MapsActivity.this.mcdKsaStreetEdtFld.getText().toString())) {
                    Address address = mcdStreetAddressResponse.McdAddress;
                    if (address != null) {
                        address.street = MapsActivity.this.mcdKsaStreetEdtFld.getText().toString();
                        McdBranchRequest mcdBranchRequest = new McdBranchRequest(mcdStreetAddressResponse.McdAddress, MapsActivity.this.restaurantId);
                        MapsActivity.this.startLodingPopup();
                        MapsActivity mapsActivity = MapsActivity.this;
                        AppTracker.onMcdStreetProceedClicked(mapsActivity, mapsActivity.f54331r, !mapsActivity.f54333t.equals(mapsActivity.mcdKsaStreetEdtFld.getText().toString()));
                        ITalabatMapPresenter o02 = MapsActivity.this.talabatMapPresenter;
                        Address address2 = mcdStreetAddressResponse.McdAddress;
                        if (address2 == null) {
                            address2 = null;
                        }
                        o02.getMcdBranchIdFromStreet(address2, MapsActivity.this.mcdKsaStreetEdtFld.getText().toString(), mcdBranchRequest);
                        return;
                    }
                    return;
                }
                MapsActivity.this.mcdKsaStreetEdtFld.setError(MapsActivity.this.getResources().getString(R.string.required));
                MapsActivity.this.mcdKsaStreetEdtFld.setErrorColor(MapsActivity.this.getResources().getColor(R.color.talabat_red));
                MapsActivity.this.mcdKsaStreetEdtFld.requestFocus();
                MapsActivity.this.mcdKsaStreetEdtFld.setHintTextColor(-65536);
            }
        });
        this.mcdKsaEditLocationBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MapsActivity.this.locationButton != null && !MapsActivity.this.isLocationPermissionAllowed) {
                    MapsActivity.this.locationButton.setVisibility(0);
                }
                if (MapsActivity.this.locationbBtnSubContainer != null) {
                    MapsActivity.this.locationbBtnSubContainer.setVisibility(0);
                }
                if (MapsActivity.this.mapViewSwitchBtn != null) {
                    MapsActivity.this.mapViewSwitchBtn.setVisibility(0);
                }
                if (MapsActivity.this.mcdKsaStreetEdtFld.getText().toString().length() > 0) {
                    MapsActivity.this.mcdKsaStreetEdtFld.setText("");
                }
                AppTracker.onMcdEditLocationClicked(MapsActivity.this);
                MapsActivity.this.hideMcdBlockSectionContainer();
            }
        });
        this.mcdKsaStreetEdtFld.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length() > 0) {
                    MapsActivity.this.mcdKsaProceedBtn.setEnabled(true);
                    MapsActivity.this.mcdKsaProceedBtn.setAlpha(1.0f);
                    MapsActivity.this.mcdStreetLabel.setVisibility(0);
                    MapsActivity.this.mcdKsaStreetEdtFld.setFloatingLabel(0);
                    return;
                }
                MapsActivity.this.mcdKsaProceedBtn.setEnabled(false);
                MapsActivity.this.mcdKsaProceedBtn.setAlpha(0.5f);
                MapsActivity.this.mcdStreetLabel.setVisibility(8);
                MapsActivity.this.mcdKsaStreetEdtFld.setFloatingLabel(0);
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.mcdKsaStreetEdtFld.setImeOptions(6);
        this.mcdKsaStreetEdtFld.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                if (i11 != 6) {
                    return false;
                }
                MapsActivity.this.hideKeyBoard();
                return false;
            }
        });
    }

    public void showTimeOutDialog() {
        showGemTimeOutDialog(this.mGemDialogSwitcher, this.f54329p, this, this);
    }

    public void showTimerView(boolean z11, String str) {
        this.f54329p.setTimerText(str);
    }

    public /* synthetic */ void stopLoading() {
        v00.a.e(this);
    }

    public void updateButtonVisiblity(boolean z11, boolean z12) {
        this.confirmContainer.setVisibility(0);
        this.mcdFlowConfirmContainer.setVisibility(8);
        Button button = this.skipBtn;
        if (button != null) {
            button.setVisibility(8);
        }
    }

    public void updateResPoryGonAvailable(boolean z11) {
        this.resPoryGonAvailable = z11;
    }

    public void updateUserSavedLocation(com.google.android.gms.maps.model.LatLng latLng) {
        this.userSavedLocation = toOurs(latLng, this.F);
    }

    public void updateValidationType(boolean z11) {
        this.validateWithPolygon = z11;
    }

    private static List<LatLng> toOurs(List<com.google.android.gms.maps.model.LatLng> list, LatLngFactory latLngFactory) {
        ArrayList arrayList = new ArrayList();
        for (com.google.android.gms.maps.model.LatLng ours : list) {
            arrayList.add(toOurs(ours, latLngFactory));
        }
        return arrayList;
    }

    public void drawAreaPolygon(List<com.google.android.gms.maps.model.LatLng> list) {
        if (list != null && list.size() > 0) {
            drawAreaPolygon();
        }
    }
}
