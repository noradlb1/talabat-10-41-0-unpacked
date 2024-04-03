package library.talabat.mvp.choosesavedaddress;

import JsonModels.Request.RestGeoReverseCodingRequest;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.domain.address.Address;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.observability.ObservabilityManager;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.userandlocation.appinfo.domain.repo.AppInfoRepository;
import com.talabat.userandlocation.appinfo.domain.repo.AppInfoRepositoryKt;
import d10.a;
import d10.b;
import d10.c;
import datamodels.Country;
import datamodels.mappers.CityToOldCityMapper;
import datamodels.mappers.CountryToOldCountryMapper;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.CreateApiUrl;
import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import service.ApiHandler;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0006\u0010 \u001a\u00020!J\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010+\u001a\u00020\u001cH\u0016R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Llibrary/talabat/mvp/choosesavedaddress/ChooseSavedAddressInteractor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "Llibrary/talabat/mvp/choosesavedaddress/IChooseSavedAddressInteractor;", "chooseSavedAddressListener", "Llibrary/talabat/mvp/choosesavedaddress/ChooseSavedAddressListener;", "ioScheduler", "Lio/reactivex/Scheduler;", "mainScheduler", "appInfoRepository", "Lcom/talabat/userandlocation/appinfo/domain/repo/AppInfoRepository;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "locationConfigRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "mutableConfigurationLocalRepository", "Lcom/talabat/configuration/MutableConfigurationLocalRepository;", "(Llibrary/talabat/mvp/choosesavedaddress/ChooseSavedAddressListener;Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;Lcom/talabat/userandlocation/appinfo/domain/repo/AppInfoRepository;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/configuration/MutableConfigurationLocalRepository;)V", "ChooseSavedAddressListener", "appInfoRepositoryDisposable", "Lio/reactivex/disposables/Disposable;", "cityToOldCityMapper", "Ldatamodels/mappers/CityToOldCityMapper;", "countryToOldCountryMapper", "Ldatamodels/mappers/CountryToOldCountryMapper;", "cstAddres", "Lcom/talabat/domain/address/Address;", "loadAppInfoDisposable", "initialiseCountryPreferences", "", "loadAppinitCountrySpecficData", "selectedCountry", "Ldatamodels/Country;", "onRequestError", "Lcom/android/volley/Response$ErrorListener;", "reverseGeoCodingBasedRestaurant", "restGeoReverseCodingRequest", "LJsonModels/Request/RestGeoReverseCodingRequest;", "reverseGeoCodingBasedRestaurantDCL", "isDirect", "", "reverseGeoCodingDCL", "loc", "Lcom/google/android/gms/maps/model/LatLng;", "unregister", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChooseSavedAddressInteractor implements IGlobalInteractor, IChooseSavedAddressInteractor {
    /* access modifiers changed from: private */
    @Nullable
    public ChooseSavedAddressListener ChooseSavedAddressListener;
    @NotNull
    private final AppInfoRepository appInfoRepository;
    @NotNull
    private Disposable appInfoRepositoryDisposable;
    @NotNull
    private final CityToOldCityMapper cityToOldCityMapper;
    @NotNull
    private final CountryToOldCountryMapper countryToOldCountryMapper;
    @Nullable
    private Address cstAddres;
    @NotNull
    private final Scheduler ioScheduler;
    @NotNull
    private Disposable loadAppInfoDisposable;
    @NotNull
    private final LocationConfigurationRepository locationConfigRepository;
    @NotNull
    private final Scheduler mainScheduler;
    @NotNull
    private final MutableConfigurationLocalRepository mutableConfigurationLocalRepository;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public ChooseSavedAddressInteractor(@NotNull ChooseSavedAddressListener chooseSavedAddressListener, @NotNull Scheduler scheduler, @NotNull Scheduler scheduler2, @NotNull AppInfoRepository appInfoRepository2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull LocationConfigurationRepository locationConfigurationRepository, @NotNull MutableConfigurationLocalRepository mutableConfigurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(chooseSavedAddressListener, "chooseSavedAddressListener");
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        Intrinsics.checkNotNullParameter(scheduler2, "mainScheduler");
        Intrinsics.checkNotNullParameter(appInfoRepository2, "appInfoRepository");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigRepository");
        Intrinsics.checkNotNullParameter(mutableConfigurationLocalRepository2, "mutableConfigurationLocalRepository");
        this.ioScheduler = scheduler;
        this.mainScheduler = scheduler2;
        this.appInfoRepository = appInfoRepository2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.locationConfigRepository = locationConfigurationRepository;
        this.mutableConfigurationLocalRepository = mutableConfigurationLocalRepository2;
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "empty()");
        this.loadAppInfoDisposable = empty;
        Disposable empty2 = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty2, "empty()");
        this.appInfoRepositoryDisposable = empty2;
        CityToOldCityMapper cityToOldCityMapper2 = new CityToOldCityMapper();
        this.cityToOldCityMapper = cityToOldCityMapper2;
        this.countryToOldCountryMapper = new CountryToOldCountryMapper(cityToOldCityMapper2);
        this.ChooseSavedAddressListener = chooseSavedAddressListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: loadAppinitCountrySpecficData$lambda-0  reason: not valid java name */
    public static final void m7875loadAppinitCountrySpecficData$lambda0(ChooseSavedAddressInteractor chooseSavedAddressInteractor) {
        Intrinsics.checkNotNullParameter(chooseSavedAddressInteractor, "this$0");
        LogManager.info("ChooseSavedAddress - AppInfo Success");
        chooseSavedAddressInteractor.initialiseCountryPreferences();
        ChooseSavedAddressListener chooseSavedAddressListener = chooseSavedAddressInteractor.ChooseSavedAddressListener;
        if (chooseSavedAddressListener != null) {
            chooseSavedAddressListener.onCountrySpecificDataLoaded();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loadAppinitCountrySpecficData$lambda-1  reason: not valid java name */
    public static final void m7876loadAppinitCountrySpecficData$lambda1(ChooseSavedAddressInteractor chooseSavedAddressInteractor, Throwable th2) {
        Intrinsics.checkNotNullParameter(chooseSavedAddressInteractor, "this$0");
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        ObservabilityManager.trackUnExpectedScenario("ChooseSavedAddressInteractorAppInfoError", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", message)));
        ChooseSavedAddressListener chooseSavedAddressListener = chooseSavedAddressInteractor.ChooseSavedAddressListener;
        if (chooseSavedAddressListener != null) {
            chooseSavedAddressListener.onNetworkError();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onRequestError$lambda-2  reason: not valid java name */
    public static final void m7877onRequestError$lambda2(ChooseSavedAddressInteractor chooseSavedAddressInteractor, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(chooseSavedAddressInteractor, "this$0");
        if (volleyError instanceof ServerError) {
            ChooseSavedAddressListener chooseSavedAddressListener = chooseSavedAddressInteractor.ChooseSavedAddressListener;
            if (chooseSavedAddressListener != null) {
                chooseSavedAddressListener.onServerError(volleyError);
            }
        } else if (volleyError instanceof NetworkError) {
            ChooseSavedAddressListener chooseSavedAddressListener2 = chooseSavedAddressInteractor.ChooseSavedAddressListener;
            if (chooseSavedAddressListener2 != null) {
                chooseSavedAddressListener2.onNetworkError();
            }
        } else if (volleyError instanceof AuthFailureError) {
            ChooseSavedAddressListener chooseSavedAddressListener3 = chooseSavedAddressInteractor.ChooseSavedAddressListener;
            if (chooseSavedAddressListener3 != null) {
                chooseSavedAddressListener3.onDataError();
            }
        } else {
            volleyError.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialiseCountryPreferences() {
        /*
            r5 = this;
            com.talabat.configuration.MutableConfigurationLocalRepository r0 = r5.mutableConfigurationLocalRepository
            com.talabat.configuration.country.Country r0 = r0.selectedCountry()
            com.talabat.configuration.location.LocationConfigurationRepository r1 = r5.locationConfigRepository
            java.util.List r1 = r1.countries()
            int r2 = r0.getCountryId()
            if (r2 <= 0) goto L_0x0037
            java.util.Iterator r1 = r1.iterator()
        L_0x0016:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x008c
            java.lang.Object r2 = r1.next()
            com.talabat.configuration.location.Country r2 = (com.talabat.configuration.location.Country) r2
            com.talabat.configuration.country.Country r3 = r2.getCountry()
            int r3 = r3.getCountryId()
            int r4 = r0.getCountryId()
            if (r3 != r4) goto L_0x0016
            datamodels.mappers.CountryToOldCountryMapper r0 = r5.countryToOldCountryMapper
            datamodels.Country r0 = r0.apply((com.talabat.configuration.location.Country) r2)
            goto L_0x008d
        L_0x0037:
            com.talabat.configuration.location.LocationConfigurationRepository r0 = r5.locationConfigRepository
            com.talabat.configuration.location.LocationConfig r0 = r0.config()
            com.talabat.configuration.country.Country r0 = r0.getCountry()
            int r0 = r0.getCountryId()
            if (r0 <= 0) goto L_0x008c
            java.util.Iterator r1 = r1.iterator()
        L_0x004b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x008c
            java.lang.Object r2 = r1.next()
            com.talabat.configuration.location.Country r2 = (com.talabat.configuration.location.Country) r2
            com.talabat.configuration.country.Country r3 = r2.getCountry()
            int r3 = r3.getCountryId()
            if (r3 != r0) goto L_0x004b
            datamodels.mappers.CountryToOldCountryMapper r0 = r5.countryToOldCountryMapper
            datamodels.Country r0 = r0.apply((com.talabat.configuration.location.Country) r2)
            com.talabat.configuration.MutableConfigurationLocalRepository r1 = r5.mutableConfigurationLocalRepository
            com.talabat.configuration.country.Country r3 = r2.getCountry()
            int r3 = r3.getCountryId()
            r1.setSelectedCountry(r3)
            com.talabat.configuration.country.Country r1 = r2.getCountry()
            java.lang.String r1 = r1.getCountryName()
            com.talabat.helpers.GlobalDataModel.SelectedCountryName = r1
            library.talabat.mvp.choosesavedaddress.ChooseSavedAddressListener r1 = r5.ChooseSavedAddressListener
            if (r1 == 0) goto L_0x008d
            if (r1 == 0) goto L_0x008d
            int r2 = com.talabat.helpers.GlobalDataModel.SelectedCountryId
            java.lang.String r3 = com.talabat.helpers.GlobalDataModel.SelectedCountryName
            r1.saveCountryInPrefs(r2, r3)
            goto L_0x008d
        L_0x008c:
            r0 = 0
        L_0x008d:
            if (r0 == 0) goto L_0x009c
            buisnessmodels.TalabatFormatter r1 = buisnessmodels.TalabatFormatter.getInstance()
            java.lang.String r2 = r0.currencySymbol
            int r3 = r0.numOfDecimalPlaces
            int r0 = r0.f13845id
            r1.setFormat(r2, r3, r0)
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.choosesavedaddress.ChooseSavedAddressInteractor.initialiseCountryPreferences():void");
    }

    public void loadAppinitCountrySpecficData(@Nullable Country country) {
        Disposable subscribe = AppInfoRepositoryKt.fetchAppInfoCompletable(this.appInfoRepository, GlobalDataModel.SelectedCountryId).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new b(this), new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "appInfoRepository\n      …workError()\n            }");
        this.appInfoRepositoryDisposable = subscribe;
    }

    @NotNull
    public final Response.ErrorListener onRequestError() {
        return new a(this);
    }

    public void reverseGeoCodingBasedRestaurant(@NotNull Address address, @NotNull RestGeoReverseCodingRequest restGeoReverseCodingRequest) {
        Intrinsics.checkNotNullParameter(address, "cstAddres");
        Intrinsics.checkNotNullParameter(restGeoReverseCodingRequest, "restGeoReverseCodingRequest");
        this.cstAddres = address;
        ApiHandler.callApi().getResBasedGeoReverseCoding(AppUrls.GET_GEO_ADDRESS_BASED_RES_BRANCH, restGeoReverseCodingRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ChooseSavedAddressInteractor$reverseGeoCodingBasedRestaurant$1(this, address));
    }

    public void reverseGeoCodingBasedRestaurantDCL(@NotNull RestGeoReverseCodingRequest restGeoReverseCodingRequest, boolean z11) {
        Intrinsics.checkNotNullParameter(restGeoReverseCodingRequest, "restGeoReverseCodingRequest");
        ApiHandler.callApi().getResBasedGeoReverseCoding(AppUrls.GET_GEO_ADDRESS_BASED_RES_BRANCH, restGeoReverseCodingRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ChooseSavedAddressInteractor$reverseGeoCodingBasedRestaurantDCL$1(this, z11));
    }

    public void reverseGeoCodingDCL(@NotNull LatLng latLng, boolean z11) {
        String str;
        Intrinsics.checkNotNullParameter(latLng, "loc");
        if (GlobalDataModel.consumeNewMicroService(this.talabatFeatureFlag)) {
            str = AppUrls.GETGOOGLE_ADDRESS_MICROSERVICE;
        } else {
            str = AppUrls.GETGOOGLEADDRESSV2;
        }
        ApiHandler.Services callApi = ApiHandler.callApi();
        int i11 = GlobalDataModel.SelectedCountryId;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        double d11 = latLng.latitude;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(d11);
        double d12 = latLng.longitude;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(d12);
        callApi.getReserveGeoAddress(CreateApiUrl.createWithParameters(str, new String[]{"{countryid}", sb2.toString(), "{latitude}", sb3.toString(), "{longitude}", sb4.toString()})).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ChooseSavedAddressInteractor$reverseGeoCodingDCL$1(this, z11));
    }

    public void unregister() {
        this.appInfoRepositoryDisposable.dispose();
        this.loadAppInfoDisposable.dispose();
        this.ChooseSavedAddressListener = null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ChooseSavedAddressInteractor(library.talabat.mvp.choosesavedaddress.ChooseSavedAddressListener r11, io.reactivex.Scheduler r12, io.reactivex.Scheduler r13, com.talabat.userandlocation.appinfo.domain.repo.AppInfoRepository r14, com.talabat.core.featureflag.domain.ITalabatFeatureFlag r15, com.talabat.configuration.location.LocationConfigurationRepository r16, com.talabat.configuration.MutableConfigurationLocalRepository r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r10 = this;
            r0 = r18 & 2
            if (r0 == 0) goto L_0x000f
            io.reactivex.Scheduler r0 = io.reactivex.schedulers.Schedulers.io()
            java.lang.String r1 = "io()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r4 = r0
            goto L_0x0010
        L_0x000f:
            r4 = r12
        L_0x0010:
            r0 = r18 & 4
            if (r0 == 0) goto L_0x001f
            io.reactivex.Scheduler r0 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            java.lang.String r1 = "mainThread()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r5 = r0
            goto L_0x0020
        L_0x001f:
            r5 = r13
        L_0x0020:
            r2 = r10
            r3 = r11
            r6 = r14
            r7 = r15
            r8 = r16
            r9 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.choosesavedaddress.ChooseSavedAddressInteractor.<init>(library.talabat.mvp.choosesavedaddress.ChooseSavedAddressListener, io.reactivex.Scheduler, io.reactivex.Scheduler, com.talabat.userandlocation.appinfo.domain.repo.AppInfoRepository, com.talabat.core.featureflag.domain.ITalabatFeatureFlag, com.talabat.configuration.location.LocationConfigurationRepository, com.talabat.configuration.MutableConfigurationLocalRepository, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
