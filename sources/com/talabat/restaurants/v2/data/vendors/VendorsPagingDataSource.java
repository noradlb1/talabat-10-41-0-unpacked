package com.talabat.restaurants.v2.data.vendors;

import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import androidx.paging.rxjava2.RxPagingSource;
import com.facebook.internal.NativeProtocol;
import com.talabat.restaurants.v2.domain.vendors.PagedUsedCase;
import datamodels.RestaurantListItemModel;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.RestaurantListResponsePaginated;
import mt.b;
import mt.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000fH\u0016¢\u0006\u0002\u0010\u0010J(\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/restaurants/v2/data/vendors/VendorsPagingDataSource;", "Landroidx/paging/rxjava2/RxPagingSource;", "", "Ldatamodels/RestaurantListItemModel;", "filterParamsRepo", "Lcom/talabat/restaurants/v2/data/vendors/FilterParamsRepository;", "pagedUseCase", "Lcom/talabat/restaurants/v2/domain/vendors/PagedUsedCase;", "verticalIds", "", "io", "Lio/reactivex/Scheduler;", "(Lcom/talabat/restaurants/v2/data/vendors/FilterParamsRepository;Lcom/talabat/restaurants/v2/domain/vendors/PagedUsedCase;Ljava/util/List;Lio/reactivex/Scheduler;)V", "getRefreshKey", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Integer;", "loadSingle", "Lio/reactivex/Single;", "Landroidx/paging/PagingSource$LoadResult;", "params", "Landroidx/paging/PagingSource$LoadParams;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsPagingDataSource extends RxPagingSource<Integer, RestaurantListItemModel> {
    @NotNull
    private final FilterParamsRepository filterParamsRepo;
    @NotNull

    /* renamed from: io  reason: collision with root package name */
    private final Scheduler f61241io;
    @NotNull
    private final PagedUsedCase pagedUseCase;
    @Nullable
    private final List<Integer> verticalIds;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VendorsPagingDataSource(com.talabat.restaurants.v2.data.vendors.FilterParamsRepository r1, com.talabat.restaurants.v2.domain.vendors.PagedUsedCase r2, java.util.List r3, io.reactivex.Scheduler r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r0 = this;
            r5 = r5 & 8
            if (r5 == 0) goto L_0x000d
            io.reactivex.Scheduler r4 = io.reactivex.schedulers.Schedulers.io()
            java.lang.String r5 = "io()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
        L_0x000d:
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurants.v2.data.vendors.VendorsPagingDataSource.<init>(com.talabat.restaurants.v2.data.vendors.FilterParamsRepository, com.talabat.restaurants.v2.domain.vendors.PagedUsedCase, java.util.List, io.reactivex.Scheduler, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: loadSingle$lambda-1  reason: not valid java name */
    public static final PagingSource.LoadResult m10736loadSingle$lambda1(VendorsPagingDataSource vendorsPagingDataSource, RestaurantListResponsePaginated restaurantListResponsePaginated) {
        Intrinsics.checkNotNullParameter(vendorsPagingDataSource, "this$0");
        Intrinsics.checkNotNullParameter(restaurantListResponsePaginated, "it");
        return VendorsPagingDataSourceKt.toLoadResult(restaurantListResponsePaginated, vendorsPagingDataSource.verticalIds);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadSingle$lambda-2  reason: not valid java name */
    public static final PagingSource.LoadResult m10737loadSingle$lambda2(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return new PagingSource.LoadResult.Error(th2);
    }

    @NotNull
    public Single<PagingSource.LoadResult<Integer, RestaurantListItemModel>> loadSingle(@NotNull PagingSource.LoadParams<Integer> loadParams) {
        int i11;
        Intrinsics.checkNotNullParameter(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Integer key = loadParams.getKey();
        if (key != null) {
            i11 = key.intValue();
        } else {
            i11 = 1;
        }
        Single<R> onErrorReturn = this.pagedUseCase.getAllVendorsPaginated(false, this.filterParamsRepo.getFilterParams(), this.verticalIds, Integer.valueOf(i11)).subscribeOn(this.f61241io).map(new b(this)).onErrorReturn(new c());
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "pagedUseCase.getAllVendo…t.Error(it)\n            }");
        return onErrorReturn;
    }

    @Nullable
    public Integer getRefreshKey(@NotNull PagingState<Integer, RestaurantListItemModel> pagingState) {
        PagingSource.LoadResult.Page<Integer, RestaurantListItemModel> closestPageToPosition;
        Intrinsics.checkNotNullParameter(pagingState, "state");
        Integer anchorPosition = pagingState.getAnchorPosition();
        if (anchorPosition == null || (closestPageToPosition = pagingState.closestPageToPosition(anchorPosition.intValue())) == null) {
            return null;
        }
        return closestPageToPosition.getPrevKey();
    }

    public VendorsPagingDataSource(@NotNull FilterParamsRepository filterParamsRepository, @NotNull PagedUsedCase pagedUsedCase, @Nullable List<Integer> list, @NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(filterParamsRepository, "filterParamsRepo");
        Intrinsics.checkNotNullParameter(pagedUsedCase, "pagedUseCase");
        Intrinsics.checkNotNullParameter(scheduler, "io");
        this.filterParamsRepo = filterParamsRepository;
        this.pagedUseCase = pagedUsedCase;
        this.verticalIds = list;
        this.f61241io = scheduler;
    }
}
