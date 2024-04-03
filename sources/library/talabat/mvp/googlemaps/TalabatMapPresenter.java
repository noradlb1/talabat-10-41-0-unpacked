package library.talabat.mvp.googlemaps;

import JsonModels.Request.McdBranchRequest;
import JsonModels.Request.McdMapAddressRequest;
import JsonModels.Response.McdBlockAddressResponse;
import JsonModels.Response.McdStoresResponse;
import JsonModels.Response.McdStreetAddressResponse;
import JsonModels.Response.McdStroesResult;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import buisnessmodels.McdMapTempAddress;
import com.android.volley.VolleyError;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.Area;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import library.talabat.mvp.homemap.HomeMapConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import tracking.AppTracker;

@Instrumented
public class TalabatMapPresenter implements ITalabatMapPresenter, TalabatMapListener {
    private float areaLocationZoom = 15.0f;
    private float countryLocationZoom = 10.0f;
    private float currentLocationZoom = 1.0f;
    boolean fromPolyGonService;
    private Address geoUpdateAddress;
    /* access modifiers changed from: private */
    public GoogleMapView googleMapView;
    private boolean isCenterCordinateAvailable;
    private boolean isEditAddressFromSideMenu;
    private boolean isFromCart;
    private boolean isGoogleMapReady;
    private boolean isMapFromSideMenu;
    private boolean isPolygonPointsAvailable;
    private boolean isUserLocationAvaliable;
    private boolean isWaitForOnBoarding;
    private boolean isWaitingUserCurrentLocation;
    ITalabatMapInteractor italabatMapInteractor;
    private final LocationConfigurationRepository locationConfigurationRepository;
    private boolean noAreaChange = false;
    private boolean pointToUserGPSLocation;
    private int selectedAreaId;
    private String selectedMcdBlockId;
    private String selectedMcdStreet;
    private boolean shouldUsePolygon;
    private boolean updateAddressValidateWithPolygon;
    private LatLng updateGeoLatLng;
    private int userAddressSelectionType;
    private LatLng userGpsCurrentLocation;
    private LatLng userSelectedTempLocation = null;
    private boolean userSelectedTempLocationAvailable;
    private boolean validateWithPolygon;
    private boolean waitForPolgonRequestCompletion;
    private boolean waitingForCurrentLocation;

    @Instrumented
    public class DrawGeoJSON extends AsyncTask implements TraceFieldInterface {
        public Trace _nr_trace;

        private DrawGeoJSON() {
        }

        public void _nr_setTrace(Trace trace) {
            try {
                this._nr_trace = trace;
            } catch (Exception unused) {
            }
        }

        public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "TalabatMapPresenter$DrawGeoJSON#doInBackground", (ArrayList<String>) null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod((Trace) null, "TalabatMapPresenter$DrawGeoJSON#doInBackground", (ArrayList<String>) null);
            }
            List<LatLng> doInBackground = doInBackground((Void[]) objArr);
            TraceMachine.exitMethod();
            return doInBackground;
        }

        public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "TalabatMapPresenter$DrawGeoJSON#onPostExecute", (ArrayList<String>) null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod((Trace) null, "TalabatMapPresenter$DrawGeoJSON#onPostExecute", (ArrayList<String>) null);
            }
            onPostExecute((List<LatLng>) (List) obj);
            TraceMachine.exitMethod();
        }

        public List<LatLng> doInBackground(Void... voidArr) {
            String str;
            JSONObject jSONObject;
            ArrayList arrayList = new ArrayList();
            try {
                TalabatMapPresenter talabatMapPresenter = TalabatMapPresenter.this;
                JSONObject jSONObject2 = new JSONObject(talabatMapPresenter.loadJSONFromAsset(talabatMapPresenter.googleMapView.getContext()));
                if (GlobalDataModel.SelectedCountryId == Country.KUWAIT.getCountryId()) {
                    jSONObject = jSONObject2.getJSONObject(HomeMapConstants.GEO_POLYGON_COUNTRY_GEOMETRY_KUWAIT);
                    str = "Kuwait";
                } else if (GlobalDataModel.SelectedCountryId == Country.KSA.getCountryId()) {
                    jSONObject = jSONObject2.getJSONObject(HomeMapConstants.GEO_POLYGON_COUNTRY_GEOMETRY_KSA);
                    str = HomeMapConstants.GEO_POLYGON_COUNTRY_KSA;
                } else if (GlobalDataModel.SelectedCountryId == Country.BAHRAIN.getCountryId()) {
                    jSONObject = jSONObject2.getJSONObject(HomeMapConstants.GEO_POLYGON_COUNTRY_GEOMETRY_BAHRAIN);
                    str = HomeMapConstants.GEO_POLYGON_COUNTRY_BAHRAIN;
                } else if (GlobalDataModel.SelectedCountryId == Country.QATAR.getCountryId()) {
                    jSONObject = jSONObject2.getJSONObject(HomeMapConstants.GEO_POLYGON_COUNTRY_GEOMETRY_QATAR);
                    str = HomeMapConstants.GEO_POLYGON_COUNTRY_QATAR;
                } else if (GlobalDataModel.SelectedCountryId == Country.OMAN.getCountryId()) {
                    jSONObject = jSONObject2.getJSONObject(HomeMapConstants.GEO_POLYGON_COUNTRY_GEOMETRY_OMAN);
                    str = HomeMapConstants.GEO_POLYGON_COUNTRY_OMAN;
                } else if (GlobalDataModel.SelectedCountryId == Country.UAE.getCountryId()) {
                    jSONObject = jSONObject2.getJSONObject(HomeMapConstants.GEO_POLYGON_COUNTRY_GEOMETRY_UAE);
                    str = HomeMapConstants.GEO_POLYGON_COUNTRY_UAE;
                } else if (GlobalDataModel.SelectedCountryId == Country.JORDAN.getCountryId()) {
                    jSONObject = jSONObject2.getJSONObject(HomeMapConstants.GEO_POLYGON_COUNTRY_GEOMETRY_JORDAN);
                    str = HomeMapConstants.GEO_POLYGON_COUNTRY_JORDAN;
                } else if (GlobalDataModel.SelectedCountryId == Country.EGYPT.getCountryId()) {
                    jSONObject = jSONObject2.getJSONObject("geometryEgypt");
                    str = "Egypt";
                } else if (GlobalDataModel.SelectedCountryId == Country.IRAQ.getCountryId()) {
                    jSONObject = jSONObject2.getJSONObject("geometryIraq");
                    str = "Iraq";
                } else {
                    str = "";
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    String string = jSONObject.getString("name");
                    if (!TextUtils.isEmpty(string) && string.equalsIgnoreCase(str)) {
                        JSONArray jSONArray = jSONObject.getJSONArray("coordinates");
                        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                            JSONArray jSONArray2 = jSONArray.getJSONArray(i11);
                            arrayList.add(new LatLng(jSONArray2.getDouble(1), jSONArray2.getDouble(0)));
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }

        public void onPostExecute(List<LatLng> list) {
            super.onPostExecute(list);
            if (list != null && list.size() > 0) {
                List<LatLng> list2 = GlobalDataModel.GEO_CORDINATES.polyGonPoints;
                if (list2 != null && list2.size() > 0) {
                    GlobalDataModel.GEO_CORDINATES.polyGonPoints.clear();
                }
                GlobalDataModel.GEO_CORDINATES.polyGonPoints = list;
                TalabatMapPresenter.this.googleMapView.polyGonLoaded(GlobalDataModel.GEO_CORDINATES.polyGonPoints);
            }
        }
    }

    public TalabatMapPresenter(AppVersionProvider appVersionProvider, GoogleMapView googleMapView2, ITalabatFeatureFlag iTalabatFeatureFlag, LocationConfigurationRepository locationConfigurationRepository2) {
        this.italabatMapInteractor = new TalabatMapInteractor(appVersionProvider, this, iTalabatFeatureFlag);
        this.googleMapView = googleMapView2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    private LatLng defaultLatLang() {
        if (GlobalDataModel.SelectedCountryId == Country.KUWAIT.getCountryId()) {
            return new LatLng(29.375859d, 47.977405d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.KSA.getCountryId()) {
            return new LatLng(24.671666d, 46.702881d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.BAHRAIN.getCountryId()) {
            return new LatLng(26.228516d, 50.58605d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.QATAR.getCountryId()) {
            return new LatLng(25.285447d, 51.53104d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.OMAN.getCountryId()) {
            return new LatLng(23.58589d, 58.405923d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.UAE.getCountryId()) {
            return new LatLng(25.204849d, 55.270783d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.JORDAN.getCountryId()) {
            return new LatLng(31.945367d, 35.928372d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.IRAQ.getCountryId()) {
            return new LatLng(36.190236d, 44.008696d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.EGYPT.getCountryId()) {
            return new LatLng(30.1229752d, 31.3025261d);
        }
        return null;
    }

    private double deg2rad(double d11) {
        return (d11 * 3.141592653589793d) / 180.0d;
    }

    private double distanceBetweenTwoCordinatesbet(double d11, double d12, double d13, double d14) {
        return rad2deg(Math.acos((Math.sin(deg2rad(d11)) * Math.sin(deg2rad(d13))) + (Math.cos(deg2rad(d11)) * Math.cos(deg2rad(d13)) * Math.cos(deg2rad(d12 - d14))))) * 60.0d * 1.1515d;
    }

    private boolean isPolygonServiceEnabledArea() {
        Cart instance = Cart.getInstance();
        if (instance.getRestaurant() != null && instance.getRestaurant().isTalabatGo) {
            for (Area next : this.locationConfigurationRepository.areas()) {
                if (next.getId() == GlobalDataModel.SelectedAreaId) {
                    this.shouldUsePolygon = next.isPolygonServiceEnabled();
                }
            }
        }
        return this.shouldUsePolygon;
    }

    /* access modifiers changed from: private */
    public String loadJSONFromAsset(Context context) {
        InputStream open;
        try {
            open = context.getAssets().open("geocoordinates.json");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            String str = new String(bArr, "UTF-8");
            open.close();
            return str;
        } catch (IOException unused) {
            return null;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private void locationReceivedDataHandler() {
        int i11;
        int i12 = 10;
        int i13 = 3;
        if (!TalabatUtils.isDrawPolygonCountry()) {
            this.googleMapView.updateValidationType(false);
            if (!(this.userSelectedTempLocation == null && this.userGpsCurrentLocation == null)) {
                i12 = 3;
            }
            this.googleMapView.animateCamera(withoutPolygonMapAnimateDecisionMarker(this.userSelectedTempLocationAvailable), (float) i12, 2500, 30.0f, 300);
        } else if ((this.isPolygonPointsAvailable || this.isCenterCordinateAvailable) && this.isGoogleMapReady) {
            this.googleMapView.updateValidationType(this.validateWithPolygon);
            mapLocationMarkerPointingEngine(GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints, GlobalDataModel.GEO_CORDINATES.areaCenterPoint, GlobalDataModel.GEO_CORDINATES.ValidateWithareaPolygon, this.userGpsCurrentLocation, this.userSelectedTempLocation);
        } else {
            this.googleMapView.updateValidationType(false);
            if (this.isWaitForOnBoarding) {
                if (this.userSelectedTempLocation == null && this.userGpsCurrentLocation == null) {
                    i13 = 2;
                }
                i11 = i13;
            } else {
                if (!(this.userSelectedTempLocation == null && this.userGpsCurrentLocation == null)) {
                    i12 = 3;
                }
                i11 = i12;
            }
            this.googleMapView.cameraAnimatorWithoutWaitPolygonValidation(withoutPolygonMapAnimateDecisionMarker(this.userSelectedTempLocationAvailable), i11, 2500, 30.0f, 300);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005c, code lost:
        if (r18 != null) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0079, code lost:
        if (r0 != null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0092, code lost:
        if (r0 != null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0095, code lost:
        r2 = 11.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ab, code lost:
        if (r18 != null) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00d6, code lost:
        if (r18 != null) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00ee, code lost:
        if (r0 != null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0106, code lost:
        if (r0 != null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
        if (r18 != null) goto L_0x005e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void mapLocationMarkerPointingEngine(java.util.List<com.google.android.gms.maps.model.LatLng> r14, com.google.android.gms.maps.model.LatLng r15, boolean r16, com.google.android.gms.maps.model.LatLng r17, com.google.android.gms.maps.model.LatLng r18) {
        /*
            r13 = this;
            r9 = r13
            r0 = r14
            r10 = r15
            r11 = r17
            boolean r1 = r9.isCenterCordinateAvailable
            r2 = 1086324736(0x40c00000, float:6.0)
            r12 = 1077936128(0x40400000, float:3.0)
            if (r1 == 0) goto L_0x0045
            boolean r3 = r9.isPolygonPointsAvailable
            if (r3 != 0) goto L_0x0045
            if (r11 == 0) goto L_0x0031
            if (r10 == 0) goto L_0x0031
            double r1 = r10.latitude
            double r3 = r10.longitude
            double r5 = r11.latitude
            double r7 = r11.longitude
            r0 = r13
            double r0 = r0.distanceBetweenTwoCordinatesbet(r1, r3, r5, r7)
            r2 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x002b
            if (r18 == 0) goto L_0x0060
            goto L_0x005e
        L_0x002b:
            if (r18 == 0) goto L_0x002f
            r10 = r18
        L_0x002f:
            r4 = r10
            goto L_0x0061
        L_0x0031:
            if (r18 == 0) goto L_0x0036
            r10 = r18
            goto L_0x003e
        L_0x0036:
            if (r10 == 0) goto L_0x0039
            goto L_0x003e
        L_0x0039:
            com.google.android.gms.maps.model.LatLng r0 = r13.defaultLatLang()
            r10 = r0
        L_0x003e:
            if (r18 == 0) goto L_0x0041
            r2 = r12
        L_0x0041:
            r5 = r2
            r4 = r10
            goto L_0x0120
        L_0x0045:
            r3 = 1093664768(0x41300000, float:11.0)
            if (r1 != 0) goto L_0x009a
            boolean r4 = r9.isPolygonPointsAvailable
            if (r4 == 0) goto L_0x009a
            library.talabat.mvp.googlemaps.GoogleMapView r1 = r9.googleMapView
            r1.drawAreaPolygon(r14)
            if (r11 == 0) goto L_0x007c
            library.talabat.mvp.googlemaps.GoogleMapView r1 = r9.googleMapView
            boolean r1 = r1.checkCurrentLocationInsideAreaPolygon(r11)
            if (r1 == 0) goto L_0x0064
            if (r18 == 0) goto L_0x0060
        L_0x005e:
            r11 = r18
        L_0x0060:
            r4 = r11
        L_0x0061:
            r5 = r12
            goto L_0x0120
        L_0x0064:
            com.google.android.gms.maps.model.LatLng r0 = r13.isFindCenterOfPolygon(r14)
            if (r18 == 0) goto L_0x006d
            r11 = r18
            goto L_0x0076
        L_0x006d:
            if (r0 == 0) goto L_0x0071
            r11 = r0
            goto L_0x0076
        L_0x0071:
            com.google.android.gms.maps.model.LatLng r1 = r13.defaultLatLang()
            r11 = r1
        L_0x0076:
            if (r18 == 0) goto L_0x0079
            goto L_0x0090
        L_0x0079:
            if (r0 == 0) goto L_0x0095
            goto L_0x0096
        L_0x007c:
            com.google.android.gms.maps.model.LatLng r0 = r13.isFindCenterOfPolygon(r14)
            if (r18 == 0) goto L_0x0085
            r11 = r18
            goto L_0x008e
        L_0x0085:
            if (r0 == 0) goto L_0x0089
            r11 = r0
            goto L_0x008e
        L_0x0089:
            com.google.android.gms.maps.model.LatLng r1 = r13.defaultLatLang()
            r11 = r1
        L_0x008e:
            if (r18 == 0) goto L_0x0092
        L_0x0090:
            r2 = r12
            goto L_0x0096
        L_0x0092:
            if (r0 == 0) goto L_0x0095
            goto L_0x0096
        L_0x0095:
            r2 = r3
        L_0x0096:
            r5 = r2
            r4 = r11
            goto L_0x0120
        L_0x009a:
            if (r1 != 0) goto L_0x00bd
            boolean r4 = r9.isPolygonPointsAvailable
            if (r4 != 0) goto L_0x00bd
            boolean r1 = r9.isGoogleMapReady
            if (r1 == 0) goto L_0x00a9
            library.talabat.mvp.googlemaps.GoogleMapView r1 = r9.googleMapView
            r1.drawAreaPolygon(r14)
        L_0x00a9:
            if (r11 == 0) goto L_0x00ae
            if (r18 == 0) goto L_0x0060
            goto L_0x005e
        L_0x00ae:
            if (r18 == 0) goto L_0x00b3
            r11 = r18
            goto L_0x00b8
        L_0x00b3:
            com.google.android.gms.maps.model.LatLng r0 = r13.defaultLatLang()
            r11 = r0
        L_0x00b8:
            if (r18 == 0) goto L_0x00bb
            goto L_0x0060
        L_0x00bb:
            r12 = r3
            goto L_0x0060
        L_0x00bd:
            if (r1 == 0) goto L_0x0109
            boolean r1 = r9.isPolygonPointsAvailable
            if (r1 == 0) goto L_0x0109
            boolean r1 = r9.isGoogleMapReady
            if (r1 == 0) goto L_0x00cc
            library.talabat.mvp.googlemaps.GoogleMapView r1 = r9.googleMapView
            r1.drawAreaPolygon(r14)
        L_0x00cc:
            if (r11 == 0) goto L_0x00f1
            library.talabat.mvp.googlemaps.GoogleMapView r1 = r9.googleMapView
            boolean r1 = r1.checkCurrentLocationInsideAreaPolygon(r11)
            if (r1 == 0) goto L_0x00d9
            if (r18 == 0) goto L_0x0060
            goto L_0x005e
        L_0x00d9:
            com.google.android.gms.maps.model.LatLng r0 = r13.isFindCenterOfPolygon(r14)
            if (r18 == 0) goto L_0x00e2
            r11 = r18
            goto L_0x00eb
        L_0x00e2:
            if (r0 == 0) goto L_0x00e6
            r11 = r0
            goto L_0x00eb
        L_0x00e6:
            com.google.android.gms.maps.model.LatLng r1 = r13.defaultLatLang()
            r11 = r1
        L_0x00eb:
            if (r18 == 0) goto L_0x00ee
            goto L_0x0090
        L_0x00ee:
            if (r0 == 0) goto L_0x0095
            goto L_0x0096
        L_0x00f1:
            com.google.android.gms.maps.model.LatLng r0 = r13.isFindCenterOfPolygon(r14)
            if (r18 == 0) goto L_0x00fa
            r11 = r18
            goto L_0x0103
        L_0x00fa:
            if (r0 == 0) goto L_0x00fe
            r11 = r0
            goto L_0x0103
        L_0x00fe:
            com.google.android.gms.maps.model.LatLng r1 = r13.defaultLatLang()
            r11 = r1
        L_0x0103:
            if (r18 == 0) goto L_0x0106
            goto L_0x0090
        L_0x0106:
            if (r0 == 0) goto L_0x0095
            goto L_0x0096
        L_0x0109:
            if (r18 == 0) goto L_0x010e
            r0 = r18
            goto L_0x0116
        L_0x010e:
            if (r11 == 0) goto L_0x0112
            r0 = r11
            goto L_0x0116
        L_0x0112:
            com.google.android.gms.maps.model.LatLng r0 = r13.defaultLatLang()
        L_0x0116:
            if (r18 == 0) goto L_0x011a
            r2 = r12
            goto L_0x011e
        L_0x011a:
            if (r11 == 0) goto L_0x011d
            goto L_0x011e
        L_0x011d:
            r2 = r3
        L_0x011e:
            r4 = r0
            r5 = r2
        L_0x0120:
            boolean r0 = r9.isGoogleMapReady
            if (r0 == 0) goto L_0x0136
            library.talabat.mvp.googlemaps.GoogleMapView r3 = r9.googleMapView
            r6 = 2500(0x9c4, float:3.503E-42)
            r7 = 1106247680(0x41f00000, float:30.0)
            r8 = 300(0x12c, float:4.2E-43)
            r3.animateCamera(r4, r5, r6, r7, r8)
            library.talabat.mvp.googlemaps.GoogleMapView r0 = r9.googleMapView
            boolean r1 = r9.validateWithPolygon
            r0.updateValidationType(r1)
        L_0x0136:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.googlemaps.TalabatMapPresenter.mapLocationMarkerPointingEngine(java.util.List, com.google.android.gms.maps.model.LatLng, boolean, com.google.android.gms.maps.model.LatLng, com.google.android.gms.maps.model.LatLng):void");
    }

    private double rad2deg(double d11) {
        return (d11 * 180.0d) / 3.141592653589793d;
    }

    private void setBlockAddress(Address address) {
        if (TalabatUtils.isNullOrEmpty(address.block)) {
            address.block = "";
        }
        if (TalabatUtils.isNullOrEmpty(address.street)) {
            address.street = "";
        }
        if (TalabatUtils.isNullOrEmpty(address.extraDirections)) {
            address.extraDirections = "";
        }
    }

    private void setGeoUpdateAddress(Address address) {
        if (TalabatUtils.isNullOrEmpty(address.block)) {
            this.geoUpdateAddress.block = "";
        } else {
            this.geoUpdateAddress.block = address.block;
        }
        if (TalabatUtils.isNullOrEmpty(address.street)) {
            this.geoUpdateAddress.street = "";
        } else {
            this.geoUpdateAddress.street = address.street;
        }
        if (TalabatUtils.isNullOrEmpty(address.extraDirections)) {
            this.geoUpdateAddress.extraDirections = "";
            return;
        }
        this.geoUpdateAddress.extraDirections = address.extraDirections;
    }

    private LatLng withoutPolygonMapAnimateDecisionMarker(boolean z11) {
        if (z11) {
            return this.userSelectedTempLocation;
        }
        return this.userGpsCurrentLocation;
    }

    public void confirmButtonPressed(LatLng latLng, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        this.isMapFromSideMenu = z11;
        this.isEditAddressFromSideMenu = z14;
        this.validateWithPolygon = z12;
        this.isFromCart = z13;
        if (latLng != null) {
            this.italabatMapInteractor.autoFillAddress(latLng);
        } else {
            this.googleMapView.showAddressNotSelectedPopup();
        }
    }

    public void currentLocationReceived(LatLng latLng, String str) {
        boolean z11 = false;
        this.isWaitingUserCurrentLocation = false;
        if (TalabatUtils.isDrawPolygonCountry()) {
            if (!TalabatUtils.isNullOrEmpty(str)) {
                String[] split = str.split(",");
                this.userSelectedTempLocation = new LatLng(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
                this.userSelectedTempLocationAvailable = true;
            }
            if (latLng != null) {
                this.userGpsCurrentLocation = latLng;
            }
            if (this.waitForPolgonRequestCompletion) {
                this.userGpsCurrentLocation = latLng;
            } else {
                locationReceivedDataHandler();
            }
            try {
                Context context = this.googleMapView.getContext();
                if (latLng != null) {
                    z11 = true;
                }
                AppTracker.gpsStatus(context, z11, this.googleMapView.gpsDeviceStatus(), "MapFirstHome");
            } catch (Exception unused) {
            }
        } else {
            this.googleMapView.updateValidationType(false);
            int i11 = 3;
            if (this.userSelectedTempLocation == null && this.userGpsCurrentLocation == null) {
                i11 = 10;
            }
            this.googleMapView.animateCamera(withoutPolygonMapAnimateDecisionMarker(this.userSelectedTempLocationAvailable), (float) i11, 2500, 40.0f, 300);
        }
    }

    public void getMcdBranchIdFromBlock(Address address, String str, McdBranchRequest mcdBranchRequest) {
        this.selectedMcdBlockId = str;
        this.italabatMapInteractor.getBranchIdFromBlock(mcdBranchRequest);
    }

    public void getMcdBranchIdFromStreet(Address address, String str, McdBranchRequest mcdBranchRequest) {
        this.selectedMcdStreet = str;
        this.italabatMapInteractor.getBranchIdFromStreet(mcdBranchRequest);
    }

    public void getMcdConvertToAddress(int i11, int i12, String str, boolean z11, boolean z12, LatLng latLng) {
        McdMapAddressRequest mcdMapAddressRequest;
        this.selectedAreaId = i11;
        if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
            this.italabatMapInteractor.getMcdBhBlockDetails(new McdMapAddressRequest(i11, "" + latLng.latitude, "" + latLng.longitude));
        } else if (TalabatUtils.isMcdLatLngEnabledCountry()) {
            if (GlobalDataModel.SelectedCountryId == Country.JORDAN.getCountryId()) {
                mcdMapAddressRequest = new McdMapAddressRequest(i11, i12, "" + latLng.latitude, "" + latLng.longitude);
            } else {
                mcdMapAddressRequest = new McdMapAddressRequest(i11, "" + latLng.latitude, "" + latLng.longitude);
            }
            this.italabatMapInteractor.getMcdLatLngAddressDetails(mcdMapAddressRequest);
        }
    }

    public LatLng isFindCenterOfPolygon(List<LatLng> list) {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        if (GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints == null) {
            return null;
        }
        for (int i11 = 0; i11 < GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints.size(); i11++) {
            builder.include(GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints.get(i11));
        }
        LatLng center = builder.build().getCenter();
        Log.e("latlang====", "" + center);
        return center;
    }

    public void mapCountryPolyGonLoaded() {
        AsyncTaskInstrumentation.execute(new DrawGeoJSON(), new Void[0]);
    }

    public void mapLoadingCompleted() {
    }

    public void mapMapMarkerPoitingDecesionHandler(int i11, int i12, boolean z11) {
        boolean z12;
        if (TalabatUtils.isDrawPolygonCountry()) {
            boolean z13 = false;
            if (GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints != null && GlobalDataModel.GEO_CORDINATES.areaCenterPoint != null) {
                this.waitForPolgonRequestCompletion = false;
                this.isWaitingUserCurrentLocation = true;
                if (GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints.size() > 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                this.isPolygonPointsAvailable = z12;
                if (GlobalDataModel.GEO_CORDINATES.areaCenterPoint != null) {
                    z13 = true;
                }
                this.isCenterCordinateAvailable = z13;
                this.validateWithPolygon = GlobalDataModel.GEO_CORDINATES.ValidateWithareaPolygon;
                if (!this.isWaitForOnBoarding) {
                    Log.e("Mapinit", "mapinitfrommapViewInitilise3");
                    this.googleMapView.requestForCurrentLocation(TalabatUtils.isDrawPolygonCountry());
                }
            } else if (i12 > 0) {
                boolean z14 = this.shouldUsePolygon;
                if (z14) {
                    this.italabatMapInteractor.fetchRestaurantPolygonJson(i12, GlobalDataModel.SelectedCountryId, z14);
                } else {
                    this.italabatMapInteractor.fetchAreaPolygonJsonGeoCenterPoint(i12, GlobalDataModel.SelectedCountryId, false);
                }
                this.waitForPolgonRequestCompletion = true;
                this.isWaitingUserCurrentLocation = true;
                if (!this.isWaitForOnBoarding) {
                    Log.e("Mapinit", "mapinitfrommapViewInitilise1");
                    this.googleMapView.requestForCurrentLocation(TalabatUtils.isDrawPolygonCountry());
                }
            } else {
                this.waitForPolgonRequestCompletion = false;
                this.isWaitingUserCurrentLocation = true;
                if (!this.isWaitForOnBoarding) {
                    Log.e("Mapinit", "mapinitfrommapViewInitilise2");
                    this.googleMapView.requestForCurrentLocation(TalabatUtils.isDrawPolygonCountry());
                }
            }
        } else if (!this.isWaitForOnBoarding) {
            Log.e("Mapinit", "mapinitfrommapViewInitilise4");
            this.googleMapView.requestForCurrentLocation(TalabatUtils.isDrawPolygonCountry());
        }
    }

    public void mapReady(boolean z11) {
        this.isGoogleMapReady = z11;
        if (this.fromPolyGonService) {
            mapLocationMarkerPointingEngine(GlobalDataModel.GEO_CORDINATES.polyGonPoints, GlobalDataModel.GEO_CORDINATES.areaCenterPoint, this.validateWithPolygon, this.userGpsCurrentLocation, this.userSelectedTempLocation);
        } else if (!this.waitForPolgonRequestCompletion) {
            locationReceivedDataHandler();
        }
    }

    public void mapViewInitilise(int i11, boolean z11, boolean z12, int i12, boolean z13, boolean z14) {
        this.fromPolyGonService = false;
        this.isWaitForOnBoarding = z14;
        if (i12 == -1) {
            i12 = 0;
        }
        if (z13) {
            this.googleMapView.mcdFlowHideSkip();
        } else {
            this.googleMapView.updateButtonVisiblity(z11, z12);
        }
        Log.e("Mapinit", "mapinitfrommapViewInitilise");
        mapMapMarkerPoitingDecesionHandler(i11, i12, true);
    }

    public void mcdBranchFailed() {
        this.googleMapView.mcdServerError();
    }

    public void mcdBranchReceived(McdStoresResponse mcdStoresResponse) {
        if (mcdStoresResponse != null) {
            McdStroesResult mcdStroesResult = mcdStoresResponse.result;
            if (mcdStroesResult.statusCode == 0) {
                McdMapTempAddress instance = McdMapTempAddress.getInstance();
                Address address = null;
                if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                    Address address2 = mcdStoresResponse.address;
                    if (address2 != null) {
                        address = address2;
                    }
                    instance.setSelectedTempBlockAddress(address);
                    instance.setSelectedMCdBhBranchId(mcdStoresResponse.tlbBranchId);
                } else if (TalabatUtils.isMcdLatLngEnabledCountry()) {
                    Address address3 = mcdStoresResponse.address;
                    if (address3 != null) {
                        address = address3;
                    }
                    instance.setSelectedTempLatLangAddress(address);
                    instance.setSelectedMCdKsBranchId(mcdStoresResponse.tlbBranchId);
                }
                this.googleMapView.ProceedToOrder(mcdStoresResponse.tlbBranchId, this.selectedMcdBlockId);
                return;
            }
            this.googleMapView.mcdDeliveryUnavaliable(mcdStroesResult.msg, this.selectedMcdBlockId, mcdStroesResult.title);
        }
    }

    public void onAreGeoPolyGonCoOrdinatesReceived(List<LatLng> list, String str, boolean z11) {
        LatLng latLng;
        this.fromPolyGonService = true;
        this.validateWithPolygon = z11;
        this.waitForPolgonRequestCompletion = false;
        GlobalDataModel.GEO_CORDINATES.ValidateWithareaPolygon = z11;
        if (!TalabatUtils.isNullOrEmpty(str)) {
            String[] split = str.split(",");
            latLng = new LatLng(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
            GlobalDataModel.GEO_CORDINATES.areaCenterPoint = latLng;
            this.isCenterCordinateAvailable = true;
        } else {
            this.isCenterCordinateAvailable = false;
            latLng = null;
        }
        LatLng latLng2 = latLng;
        if (list == null || list.size() <= 0) {
            this.isPolygonPointsAvailable = false;
        } else {
            GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints = list;
            this.isPolygonPointsAvailable = true;
        }
        mapLocationMarkerPointingEngine(list, latLng2, z11, this.userGpsCurrentLocation, this.userSelectedTempLocation);
    }

    public void onAreGeoPolyGonFailed(boolean z11) {
        if (!this.isWaitingUserCurrentLocation) {
            float f11 = 3.0f;
            if (this.userSelectedTempLocation == null && this.userGpsCurrentLocation == null) {
                f11 = 11.0f;
            }
            this.googleMapView.animateCamera((LatLng) null, f11, 2500, 30.0f, 300);
        }
    }

    public void onDataError() {
        this.googleMapView.onDataError();
    }

    public void onDestroy() {
        this.googleMapView = null;
        ITalabatMapInteractor iTalabatMapInteractor = this.italabatMapInteractor;
        if (iTalabatMapInteractor != null) {
            iTalabatMapInteractor.unregister();
        }
        this.italabatMapInteractor = null;
    }

    public void onGeoAddressRecieved(Address address) {
        if (!this.shouldUsePolygon) {
            setBlockAddress(address);
        }
        int i11 = GlobalDataModel.SelectedAreaId;
        if (i11 == 0) {
            this.googleMapView.onAddressRecieved(address);
        } else if (this.isMapFromSideMenu || this.isEditAddressFromSideMenu) {
            this.googleMapView.onAddressRecieved(address);
        } else if (!this.shouldUsePolygon || !this.isFromCart) {
            int i12 = address.areaId;
            if (i12 <= 0) {
                this.googleMapView.onAddressRecieved(address);
            } else if (i12 == i11) {
                this.googleMapView.onAddressRecieved(address);
            } else if (this.validateWithPolygon) {
                if (i11 > 0 && this.isFromCart) {
                    address.areaId = i11;
                    address.areaName = GlobalDataModel.SelectedAreaName;
                }
                this.googleMapView.locationMismatchValidateWithPlygon(address);
            } else {
                this.googleMapView.locationMismatch(address);
            }
        } else {
            int i13 = address.areaId;
            if (i13 <= 0) {
                this.googleMapView.restaurantOutSideDeliveryZone(address);
            } else if (i13 != i11) {
                GlobalDataModel.GEO_CORDINATES.isUserChangedCartArea = true;
                this.googleMapView.locationMismatchValidateWithResPlygon(address);
            } else {
                GlobalDataModel.GEO_CORDINATES.isUserChangedCartArea = false;
                this.googleMapView.onAddressRecievedWithPorygon(address);
            }
        }
    }

    public void onMcdBlockFailed() {
        this.googleMapView.mcdBlockFailed();
    }

    public void onMcdBlockReceived(McdBlockAddressResponse mcdBlockAddressResponse) {
        McdStroesResult mcdStroesResult = mcdBlockAddressResponse.result;
        if (mcdStroesResult.statusCode == 0) {
            Address address = mcdBlockAddressResponse.McdAddress;
            if (address == null) {
                this.googleMapView.showMcdBlockSection(mcdBlockAddressResponse, false);
            } else if (!TalabatUtils.isNullOrEmpty(address.block)) {
                AppTracker.onBhMcdMapResultReturned(this.googleMapView.getContext(), true, true);
                this.googleMapView.showMcdBlockSection(mcdBlockAddressResponse, true);
            } else {
                this.googleMapView.showMcdBlockSection(mcdBlockAddressResponse, false);
            }
        } else {
            this.googleMapView.mcdDeliveryUnavaliable(mcdStroesResult.msg, this.selectedMcdBlockId, mcdStroesResult.title);
        }
    }

    public void onMcdKsAddressFailed() {
    }

    public void onMcdKsAddressReceived(McdStreetAddressResponse mcdStreetAddressResponse) {
        McdStroesResult mcdStroesResult = mcdStreetAddressResponse.result;
        if (mcdStroesResult.statusCode == 0) {
            AppTracker.onBhMcdMapResultReturned(this.googleMapView.getContext(), true, true);
            this.googleMapView.showMcdStreetSelection(mcdStreetAddressResponse);
            return;
        }
        this.googleMapView.mcdDeliveryUnavaliable(mcdStroesResult.msg, this.selectedMcdBlockId, mcdStroesResult.title);
    }

    public void onNetworkError() {
        this.googleMapView.onNetworkError();
    }

    public void onServerError(VolleyError volleyError) {
        this.googleMapView.onServerError(volleyError);
    }

    public void onUpdateGeoAddressRecieved(Address address) {
        boolean z11 = this.shouldUsePolygon;
        if (!z11 || address.areaId != 0) {
            int i11 = address.areaId;
            Address address2 = this.geoUpdateAddress;
            if (i11 != address2.areaId) {
                if (z11) {
                    GlobalDataModel.GEO_CORDINATES.isUserChangedCartArea = true;
                    this.googleMapView.onAddressRecievedWithPorygon(address);
                    return;
                }
                GlobalDataModel.GEO_CORDINATES.isUserChangedCartArea = false;
                address2.latitude = address.latitude;
                address2.longitude = address.longitude;
                setGeoUpdateAddress(address);
                if (this.updateAddressValidateWithPolygon) {
                    this.googleMapView.locationMismatchValidateWithPlygon(this.geoUpdateAddress);
                } else {
                    this.googleMapView.locationMismatch(this.geoUpdateAddress);
                }
            } else if (z11) {
                GlobalDataModel.GEO_CORDINATES.isUserChangedCartArea = false;
                this.googleMapView.onAddressRecievedWithPorygon(address);
            } else {
                if (!TalabatUtils.isNullOrEmpty(address2.f58343id)) {
                    Address address3 = this.geoUpdateAddress;
                    address3.latitude = address.latitude;
                    address3.longitude = address.longitude;
                    setGeoUpdateAddress(address);
                    Customer instance = Customer.getInstance();
                    Address address4 = this.geoUpdateAddress;
                    this.geoUpdateAddress = instance.updateGeoCordinates(address4.f58343id, this.updateGeoLatLng, address4);
                }
                this.googleMapView.onGeoCordinatesUpdated(this.geoUpdateAddress);
            }
        } else {
            this.googleMapView.stopLodingPopup();
            this.googleMapView.restaurantOutSideDeliveryZone(address);
        }
    }

    public void updateGeoCordinates(LatLng latLng, Address address, boolean z11, boolean z12, boolean z13) {
        this.isEditAddressFromSideMenu = z12;
        if (latLng != null) {
            this.geoUpdateAddress = address;
            this.updateGeoLatLng = latLng;
            this.updateAddressValidateWithPolygon = z11;
            this.italabatMapInteractor.autoFillAddressGeoUpdate(latLng);
            return;
        }
        this.googleMapView.showAddressNotSelectedPopup();
    }

    public void updateRestaurantpolygonServiceEnabled() {
        boolean isPolygonServiceEnabledArea = isPolygonServiceEnabledArea();
        this.shouldUsePolygon = isPolygonServiceEnabledArea;
        this.googleMapView.updateResPoryGonAvailable(isPolygonServiceEnabledArea);
    }

    public void userConfirmedTempLocation(String str) {
        if (!TalabatUtils.isNullOrEmpty(str)) {
            String[] split = str.split(",");
            this.userSelectedTempLocation = new LatLng(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
            this.userSelectedTempLocationAvailable = true;
        }
        this.googleMapView.updateUserSavedLocation(this.userSelectedTempLocation);
    }

    public void waitForCurrentLocation(boolean z11) {
        this.waitingForCurrentLocation = z11;
    }
}
