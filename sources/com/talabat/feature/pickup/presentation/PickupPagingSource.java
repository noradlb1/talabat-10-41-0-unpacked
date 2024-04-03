package com.talabat.feature.pickup.presentation;

import android.util.SparseArray;
import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import androidx.paging.rxjava2.RxPagingSource;
import buisnessmodels.FilterEngine;
import com.facebook.internal.NativeProtocol;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.pickup.data.events.ShopListLoadedEvent;
import com.talabat.feature.pickup.data.events.ShopListUpdatedEvent;
import com.talabat.feature.pickup.domain.GetPickupVendorsUseCase;
import com.talabat.feature.pickup.domain.entity.PickupVendor;
import com.talabat.feature.pickup.presentation.provider.CreditProvider;
import com.talabat.helpers.GlobalDataModel;
import datamodels.Cuisine;
import datamodels.Restaurant;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rn.g;
import rn.h;
import rn.i;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BH\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\r¢\u0006\u0002\u0010\u0012J#\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0015H\u0016¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0002J(\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u001b0\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0016J \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u001b*\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R)\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/talabat/feature/pickup/presentation/PickupPagingSource;", "Landroidx/paging/rxjava2/RxPagingSource;", "", "Ldatamodels/Restaurant;", "getPickupVendorsUseCase", "Lcom/talabat/feature/pickup/domain/GetPickupVendorsUseCase;", "tracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "creditProvider", "Lcom/talabat/feature/pickup/presentation/provider/CreditProvider;", "eventOrigin", "", "pageLoadedSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "pageNum", "", "(Lcom/talabat/feature/pickup/domain/GetPickupVendorsUseCase;Lcom/talabat/core/tracking/domain/TalabatTracker;Lcom/talabat/feature/pickup/presentation/provider/CreditProvider;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getRefreshKey", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Integer;", "getSelectedCuisines", "", "loadSingle", "Lio/reactivex/Single;", "Landroidx/paging/PagingSource$LoadResult;", "params", "Landroidx/paging/PagingSource$LoadParams;", "handleFetchedData", "Lcom/talabat/feature/pickup/domain/entity/PickupVendor;", "pageNumber", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PickupPagingSource extends RxPagingSource<Integer, Restaurant> {
    @NotNull
    private final CreditProvider creditProvider;
    @NotNull
    private final String eventOrigin;
    @NotNull
    private final GetPickupVendorsUseCase getPickupVendorsUseCase;
    @NotNull
    private final Function1<Integer, Unit> pageLoadedSuccess;
    @NotNull
    private final TalabatTracker tracker;

    public PickupPagingSource(@NotNull GetPickupVendorsUseCase getPickupVendorsUseCase2, @NotNull TalabatTracker talabatTracker, @NotNull CreditProvider creditProvider2, @NotNull String str, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(getPickupVendorsUseCase2, "getPickupVendorsUseCase");
        Intrinsics.checkNotNullParameter(talabatTracker, "tracker");
        Intrinsics.checkNotNullParameter(creditProvider2, "creditProvider");
        Intrinsics.checkNotNullParameter(str, "eventOrigin");
        Intrinsics.checkNotNullParameter(function1, "pageLoadedSuccess");
        this.getPickupVendorsUseCase = getPickupVendorsUseCase2;
        this.tracker = talabatTracker;
        this.creditProvider = creditProvider2;
        this.eventOrigin = str;
        this.pageLoadedSuccess = function1;
    }

    private final List<Integer> getSelectedCuisines() {
        SparseArray<Cuisine> sparseArray;
        FilterEngine filterEngine = GlobalDataModel.filterEngine;
        ArrayList arrayList = new ArrayList();
        if (!(filterEngine == null || (sparseArray = filterEngine.selectedCuisines) == null)) {
            int size = sparseArray.size();
            for (int i11 = 0; i11 < size; i11++) {
                sparseArray.keyAt(i11);
                arrayList.add(Integer.valueOf(sparseArray.valueAt(i11).f13848id));
            }
        }
        return arrayList;
    }

    private final PagingSource.LoadResult<Integer, Restaurant> handleFetchedData(PickupVendor pickupVendor, int i11) {
        Integer num;
        if (!pickupVendor.getVendors().isEmpty()) {
            num = Integer.valueOf(i11 + 1);
        } else {
            num = null;
        }
        return new PagingSource.LoadResult.Page(pickupVendor.getVendors(), null, num);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadSingle$lambda-1  reason: not valid java name */
    public static final void m10250loadSingle$lambda1(PickupPagingSource pickupPagingSource, int i11, List list, PickupVendor pickupVendor) {
        TalabatEvent talabatEvent;
        Intrinsics.checkNotNullParameter(pickupPagingSource, "this$0");
        Intrinsics.checkNotNullParameter(list, "$selectedCuisines");
        pickupPagingSource.pageLoadedSuccess.invoke(Integer.valueOf(i11));
        TalabatTracker talabatTracker = pickupPagingSource.tracker;
        if (list.isEmpty()) {
            talabatEvent = new ShopListLoadedEvent(pickupVendor.getVendors(), pickupPagingSource.creditProvider.get(), pickupPagingSource.eventOrigin);
        } else {
            talabatEvent = new ShopListUpdatedEvent(pickupVendor.getVendors(), pickupPagingSource.creditProvider.get(), GlobalDataModel.filterEngine.getCuisineForTracking());
        }
        talabatTracker.track(talabatEvent);
        pickupPagingSource.tracker.track(new BrazeShopListLoadedEvent());
    }

    /* access modifiers changed from: private */
    /* renamed from: loadSingle$lambda-2  reason: not valid java name */
    public static final PagingSource.LoadResult m10251loadSingle$lambda2(PickupPagingSource pickupPagingSource, int i11, PickupVendor pickupVendor) {
        Intrinsics.checkNotNullParameter(pickupPagingSource, "this$0");
        Intrinsics.checkNotNullParameter(pickupVendor, "pickupVendor");
        return pickupPagingSource.handleFetchedData(pickupVendor, i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadSingle$lambda-3  reason: not valid java name */
    public static final PagingSource.LoadResult m10252loadSingle$lambda3(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return new PagingSource.LoadResult.Error(th2);
    }

    @NotNull
    public Single<PagingSource.LoadResult<Integer, Restaurant>> loadSingle(@NotNull PagingSource.LoadParams<Integer> loadParams) {
        int i11;
        Intrinsics.checkNotNullParameter(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Integer key = loadParams.getKey();
        if (key != null) {
            i11 = key.intValue();
        } else {
            i11 = 1;
        }
        List<Integer> selectedCuisines = getSelectedCuisines();
        Single<R> onErrorReturn = this.getPickupVendorsUseCase.run(new GetPickupVendorsUseCase.Params(i11, selectedCuisines)).doOnSuccess(new g(this, i11, selectedCuisines)).map(new h(this, i11)).onErrorReturn(new i());
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "getPickupVendorsUseCase.… { LoadResult.Error(it) }");
        return onErrorReturn;
    }

    @Nullable
    public Integer getRefreshKey(@NotNull PagingState<Integer, Restaurant> pagingState) {
        Integer nextKey;
        Integer valueOf;
        Integer prevKey;
        Intrinsics.checkNotNullParameter(pagingState, "state");
        Integer anchorPosition = pagingState.getAnchorPosition();
        if (anchorPosition == null) {
            return null;
        }
        int intValue = anchorPosition.intValue();
        PagingSource.LoadResult.Page<Integer, Restaurant> closestPageToPosition = pagingState.closestPageToPosition(intValue);
        if (closestPageToPosition == null || (prevKey = closestPageToPosition.getPrevKey()) == null) {
            PagingSource.LoadResult.Page<Integer, Restaurant> closestPageToPosition2 = pagingState.closestPageToPosition(intValue);
            if (closestPageToPosition2 == null || (nextKey = closestPageToPosition2.getNextKey()) == null) {
                return null;
            }
            valueOf = Integer.valueOf(nextKey.intValue() - 1);
        } else {
            valueOf = Integer.valueOf(prevKey.intValue() + 1);
        }
        return valueOf;
    }
}
