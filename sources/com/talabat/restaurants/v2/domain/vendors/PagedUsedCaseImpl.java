package com.talabat.restaurants.v2.domain.vendors;

import com.talabat.core.experiment.data.Experiments;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.observability.tracker.TimeTrackerImplementation;
import com.talabat.observability.tracker.TimeTrackerKt;
import com.talabat.restaurants.v2.data.vendors.AreaParams;
import com.talabat.restaurants.v2.data.vendors.FilterParams;
import com.talabat.restaurants.v2.data.vendors.VendorsPaginatedDataSource;
import com.talabat.restaurants.v2.domain.utils.GetExternalExperimentsUseCase;
import datamodels.Swimlane;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.RestaurantListResponsePaginated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pt.i;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ?\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e2\u0006\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000RJ\u0010\t\u001a8\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e0\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/talabat/restaurants/v2/domain/vendors/PagedUsedCaseImpl;", "Lcom/talabat/restaurants/v2/domain/vendors/PagedUsedCase;", "vendorsPaginatedDataSource", "Lcom/talabat/restaurants/v2/data/vendors/VendorsPaginatedDataSource;", "getExternalExperimentsUseCase", "Lcom/talabat/restaurants/v2/domain/utils/GetExternalExperimentsUseCase;", "tracker", "Lcom/talabat/observability/tracker/TimeTrackerImplementation;", "(Lcom/talabat/restaurants/v2/data/vendors/VendorsPaginatedDataSource;Lcom/talabat/restaurants/v2/domain/utils/GetExternalExperimentsUseCase;Lcom/talabat/observability/tracker/TimeTrackerImplementation;)V", "getSwimlanes", "Lkotlin/Function6;", "", "", "", "Lio/reactivex/Single;", "", "Ldatamodels/Swimlane;", "getGetSwimlanes", "()Lkotlin/jvm/functions/Function6;", "getVendors", "Lcom/talabat/restaurants/v2/domain/vendors/VendorsUseCase;", "getGetVendors", "()Lcom/talabat/restaurants/v2/domain/vendors/VendorsUseCase;", "getAllVendorsPaginated", "Llibrary/talabat/com/talabatlib/RestaurantListResponsePaginated;", "isForceUpdate", "filterParams", "Lcom/talabat/restaurants/v2/data/vendors/FilterParams;", "verticalIds", "page", "(ZLcom/talabat/restaurants/v2/data/vendors/FilterParams;Ljava/util/List;Ljava/lang/Integer;)Lio/reactivex/Single;", "CachedFirstPage", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PagedUsedCaseImpl implements PagedUsedCase {
    @NotNull
    public static final CachedFirstPage CachedFirstPage = new CachedFirstPage((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static RestaurantListResponsePaginated firstPageResponseNoFiltrationCache;
    @NotNull
    private final GetExternalExperimentsUseCase getExternalExperimentsUseCase;
    @NotNull
    private final Function6<Boolean, String, String, Integer, Integer, Integer, Single<List<Swimlane>>> getSwimlanes;
    @NotNull
    private final VendorsUseCase getVendors;
    @NotNull
    private final TimeTrackerImplementation tracker;
    @NotNull
    private final VendorsPaginatedDataSource vendorsPaginatedDataSource;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/restaurants/v2/domain/vendors/PagedUsedCaseImpl$CachedFirstPage;", "", "()V", "firstPageResponseNoFiltrationCache", "Llibrary/talabat/com/talabatlib/RestaurantListResponsePaginated;", "clearCache", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CachedFirstPage {
        private CachedFirstPage() {
        }

        public /* synthetic */ CachedFirstPage(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void clearCache() {
            PagedUsedCaseImpl.firstPageResponseNoFiltrationCache = null;
        }
    }

    public PagedUsedCaseImpl(@NotNull VendorsPaginatedDataSource vendorsPaginatedDataSource2, @NotNull GetExternalExperimentsUseCase getExternalExperimentsUseCase2, @NotNull TimeTrackerImplementation timeTrackerImplementation) {
        Intrinsics.checkNotNullParameter(vendorsPaginatedDataSource2, "vendorsPaginatedDataSource");
        Intrinsics.checkNotNullParameter(getExternalExperimentsUseCase2, "getExternalExperimentsUseCase");
        Intrinsics.checkNotNullParameter(timeTrackerImplementation, "tracker");
        this.vendorsPaginatedDataSource = vendorsPaginatedDataSource2;
        this.getExternalExperimentsUseCase = getExternalExperimentsUseCase2;
        this.tracker = timeTrackerImplementation;
        this.getVendors = new PagedUsedCaseImpl$getVendors$1();
        this.getSwimlanes = PagedUsedCaseImpl$getSwimlanes$1.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: getAllVendorsPaginated$lambda-0  reason: not valid java name */
    public static final void m10752getAllVendorsPaginated$lambda0(FilterParams filterParams, Integer num, PagedUsedCaseImpl pagedUsedCaseImpl, String str, RestaurantListResponsePaginated restaurantListResponsePaginated) {
        Intrinsics.checkNotNullParameter(pagedUsedCaseImpl, "this$0");
        Intrinsics.checkNotNullParameter(str, "$trackingEvent");
        if (filterParams == null && num != null && num.intValue() == 1) {
            firstPageResponseNoFiltrationCache = restaurantListResponsePaginated;
            TimeTrackerImplementation.stopTracking$default(pagedUsedCaseImpl.tracker, str, 0, 2, (Object) null);
        }
    }

    @NotNull
    public Single<RestaurantListResponsePaginated> getAllVendorsPaginated(boolean z11, @Nullable FilterParams filterParams, @Nullable List<Integer> list, @Nullable Integer num) {
        Object obj;
        RestaurantListResponsePaginated restaurantListResponsePaginated;
        FilterParams filterParams2 = filterParams;
        Integer num2 = num;
        if (filterParams2 != null || num2 == null || num.intValue() != 1 || (restaurantListResponsePaginated = firstPageResponseNoFiltrationCache) == null || z11) {
            if (list == null || (obj = (Integer) CollectionsKt___CollectionsKt.firstOrNull(list)) == null) {
                obj = "0";
            }
            String str = "VENDORS_FIRST_PAGE_REQUEST_VL" + obj;
            double doubleValue = ((Number) Experiments.withSafeExperiment$default(TalabatExperimentConstants.VL_BOOST_RANKING, Double.valueOf(0.0d), (ITalabatExperiment) null, (Function1) null, 12, (Object) null)).doubleValue();
            String str2 = (String) Experiments.withSafeExperiment$default(TalabatExperimentConstants.VL_DYNAMIC_RANKING, "", (ITalabatExperiment) null, (Function1) null, 12, (Object) null);
            if (filterParams2 == null && num2 != null && num.intValue() == 1) {
                TimeTrackerImplementation.startTracking$default(this.tracker, str, 0, 2, (Object) null);
            }
            Single<RestaurantListResponsePaginated> doOnSuccess = this.vendorsPaginatedDataSource.getAllVendorsPaginated(new AreaParams(String.valueOf(GlobalDataModel.RECENT_LATLONG.getLatitude()), String.valueOf(GlobalDataModel.RECENT_LATLONG.getLongitude()), GlobalDataModel.SelectedAreaId, GlobalDataModel.SelectedCountryId), filterParams, list, num, 50, this.getExternalExperimentsUseCase.invoke(doubleValue, str2)).doOnSuccess(new i(filterParams2, num2, this, str));
            Intrinsics.checkNotNullExpressionValue(doOnSuccess, "vendorsPaginatedDataSour…          }\n            }");
            return doOnSuccess;
        }
        Single<RestaurantListResponsePaginated> just = Single.just(restaurantListResponsePaginated);
        Intrinsics.checkNotNullExpressionValue(just, "just(firstPageResponseNoFiltrationCache)");
        return just;
    }

    @NotNull
    public Function6<Boolean, String, String, Integer, Integer, Integer, Single<List<Swimlane>>> getGetSwimlanes() {
        return this.getSwimlanes;
    }

    @NotNull
    public VendorsUseCase getGetVendors() {
        return this.getVendors;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PagedUsedCaseImpl(VendorsPaginatedDataSource vendorsPaginatedDataSource2, GetExternalExperimentsUseCase getExternalExperimentsUseCase2, TimeTrackerImplementation timeTrackerImplementation, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(vendorsPaginatedDataSource2, (i11 & 2) != 0 ? new GetExternalExperimentsUseCase() : getExternalExperimentsUseCase2, (i11 & 4) != 0 ? TimeTrackerKt.getTimeTracker() : timeTrackerImplementation);
    }
}
