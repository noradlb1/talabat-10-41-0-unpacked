package com.talabat.restaurants.v2.data.vendors;

import JsonModels.Request.RestaurantReq;
import androidx.exifinterface.media.ExifInterface;
import com.talabat.core.experiment.data.Experiments;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.observability.tracker.TimeTrackerImplementation;
import com.talabat.observability.tracker.TimeTrackerKt;
import com.talabat.restaurants.v2.data.InMemoryCache;
import com.talabat.restaurants.v2.data.vendors.VendorsApi;
import com.talabat.restaurants.v2.domain.utils.GetExternalExperimentsUseCase;
import io.reactivex.Single;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.RestuarntListResponse;
import mt.d;
import mt.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016JF\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0017H\u0002J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00142\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/talabat/restaurants/v2/data/vendors/VendorsRepositoryImpl;", "Lcom/talabat/restaurants/v2/data/vendors/VendorsRepository;", "vendorsApi", "Lcom/talabat/restaurants/v2/data/vendors/VendorsApi;", "getExternalExperimentsUseCase", "Lcom/talabat/restaurants/v2/domain/utils/GetExternalExperimentsUseCase;", "tracker", "Lcom/talabat/observability/tracker/TimeTrackerImplementation;", "(Lcom/talabat/restaurants/v2/data/vendors/VendorsApi;Lcom/talabat/restaurants/v2/domain/utils/GetExternalExperimentsUseCase;Lcom/talabat/observability/tracker/TimeTrackerImplementation;)V", "getVendorsByArea", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/RestuarntListResponse;", "isForceUpdate", "", "requestBody", "LJsonModels/Request/RestaurantReq;", "getVendorsByPolygons", "apiVersion", "", "latitude", "", "longitude", "verticalIds", "", "weightSet", "getVerticalIdHeader", "getVerticalsParameter", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsRepositoryImpl implements VendorsRepository {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Lazy<InMemoryCache> inMemoryCache$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, VendorsRepositoryImpl$Companion$inMemoryCache$2.INSTANCE);
    @NotNull
    private final GetExternalExperimentsUseCase getExternalExperimentsUseCase;
    @NotNull
    private final TimeTrackerImplementation tracker;
    @NotNull
    private final VendorsApi vendorsApi;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/talabat/restaurants/v2/data/vendors/VendorsRepositoryImpl$Companion;", "", "()V", "inMemoryCache", "Lcom/talabat/restaurants/v2/data/InMemoryCache;", "getInMemoryCache", "()Lcom/talabat/restaurants/v2/data/InMemoryCache;", "inMemoryCache$delegate", "Lkotlin/Lazy;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final InMemoryCache getInMemoryCache() {
            return (InMemoryCache) VendorsRepositoryImpl.inMemoryCache$delegate.getValue();
        }
    }

    public VendorsRepositoryImpl() {
        this((VendorsApi) null, (GetExternalExperimentsUseCase) null, (TimeTrackerImplementation) null, 7, (DefaultConstructorMarker) null);
    }

    public VendorsRepositoryImpl(@NotNull VendorsApi vendorsApi2, @NotNull GetExternalExperimentsUseCase getExternalExperimentsUseCase2, @NotNull TimeTrackerImplementation timeTrackerImplementation) {
        Intrinsics.checkNotNullParameter(vendorsApi2, "vendorsApi");
        Intrinsics.checkNotNullParameter(getExternalExperimentsUseCase2, "getExternalExperimentsUseCase");
        Intrinsics.checkNotNullParameter(timeTrackerImplementation, "tracker");
        this.vendorsApi = vendorsApi2;
        this.getExternalExperimentsUseCase = getExternalExperimentsUseCase2;
        this.tracker = timeTrackerImplementation;
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendorsByArea$lambda-1  reason: not valid java name */
    public static final void m10738getVendorsByArea$lambda1(RestuarntListResponse restuarntListResponse) {
        Companion.getInMemoryCache().setVendorsResponse(restuarntListResponse);
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendorsByPolygons$lambda-0  reason: not valid java name */
    public static final void m10739getVendorsByPolygons$lambda0(VendorsRepositoryImpl vendorsRepositoryImpl, String str, RestuarntListResponse restuarntListResponse) {
        Intrinsics.checkNotNullParameter(vendorsRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(str, "$trackingEvent");
        Companion.getInMemoryCache().setVendorsResponse(restuarntListResponse);
        TimeTrackerImplementation.stopTracking$default(vendorsRepositoryImpl.tracker, str, 0, 2, (Object) null);
    }

    private final int getVerticalIdHeader(List<Integer> list) {
        Integer num;
        if (!ITalabatExperiment.DefaultImpls.getBooleanVariant$default(TalabatExperiment.INSTANCE, TalabatExperimentConstants.DYNAMIC_WEIGHTS_EXPERIMENT, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null) || list == null || (num = (Integer) CollectionsKt___CollectionsKt.firstOrNull(list)) == null) {
            return -1;
        }
        return num.intValue();
    }

    private final String getVerticalsParameter(List<Integer> list) {
        if (!ITalabatExperiment.DefaultImpls.getBooleanVariant$default(TalabatExperiment.INSTANCE, TalabatExperimentConstants.USE_VERTICAL_ID_IN_REQUEST, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null) || list == null) {
            return null;
        }
        return CollectionsKt___CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    @NotNull
    public Single<RestuarntListResponse> getVendorsByArea(boolean z11, @NotNull RestaurantReq restaurantReq) {
        Intrinsics.checkNotNullParameter(restaurantReq, "requestBody");
        Companion companion = Companion;
        if (companion.getInMemoryCache().getVendorsResponse() == null || z11) {
            Single<RestuarntListResponse> doOnSuccess = VendorsApi.DefaultImpls.getVendorsByArea$default(this.vendorsApi, 0, restaurantReq, 1, (Object) null).doOnSuccess(new e());
            Intrinsics.checkNotNullExpressionValue(doOnSuccess, "{\n            vendorsApi…              }\n        }");
            return doOnSuccess;
        }
        Single<RestuarntListResponse> just = Single.just(companion.getInMemoryCache().getVendorsResponse());
        Intrinsics.checkNotNullExpressionValue(just, "{\n            Single.jus…endorsResponse)\n        }");
        return just;
    }

    @NotNull
    public Single<RestuarntListResponse> getVendorsByPolygons(boolean z11, int i11, @NotNull String str, @NotNull String str2, @Nullable List<Integer> list, @NotNull String str3) {
        Object obj;
        List<Integer> list2 = list;
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        Intrinsics.checkNotNullParameter(str3, VendorsUrlConstantsKt.WEIGHT_SET);
        Companion companion = Companion;
        if (companion.getInMemoryCache().getVendorsResponse() == null || z11) {
            if (list2 == null || (obj = (Integer) CollectionsKt___CollectionsKt.firstOrNull(list)) == null) {
                obj = "0";
            }
            String str4 = "VENDORS_REQUEST_VL" + obj;
            TimeTrackerImplementation.startTracking$default(this.tracker, str4, 0, 2, (Object) null);
            Single<RestuarntListResponse> doOnSuccess = this.vendorsApi.getVendorsByPolygons(i11, str, str2, getVerticalIdHeader(list2), ITalabatExperiment.DefaultImpls.getStringVariant$default(TalabatExperiment.INSTANCE, TalabatExperimentConstants.USE_PERSONAL_API, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null), this.getExternalExperimentsUseCase.invoke(((Number) Experiments.withSafeExperiment$default(TalabatExperimentConstants.VL_BOOST_RANKING, Double.valueOf(0.0d), (ITalabatExperiment) null, (Function1) null, 12, (Object) null)).doubleValue(), (String) Experiments.withSafeExperiment$default(TalabatExperimentConstants.VL_DYNAMIC_RANKING, "", (ITalabatExperiment) null, (Function1) null, 12, (Object) null)), getVerticalsParameter(list2), str3).doOnSuccess(new d(this, str4));
            Intrinsics.checkNotNullExpressionValue(doOnSuccess, "{\n            val tracki…)\n            }\n        }");
            return doOnSuccess;
        }
        Single<RestuarntListResponse> just = Single.just(companion.getInMemoryCache().getVendorsResponse());
        Intrinsics.checkNotNullExpressionValue(just, "{\n            Single.jus…endorsResponse)\n        }");
        return just;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VendorsRepositoryImpl(VendorsApi vendorsApi2, GetExternalExperimentsUseCase getExternalExperimentsUseCase2, TimeTrackerImplementation timeTrackerImplementation, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new VendorsApiImpl((TalabatAPIBuilder) null, 1, (DefaultConstructorMarker) null) : vendorsApi2, (i11 & 2) != 0 ? new GetExternalExperimentsUseCase() : getExternalExperimentsUseCase2, (i11 & 4) != 0 ? TimeTrackerKt.getTimeTracker() : timeTrackerImplementation);
    }
}
