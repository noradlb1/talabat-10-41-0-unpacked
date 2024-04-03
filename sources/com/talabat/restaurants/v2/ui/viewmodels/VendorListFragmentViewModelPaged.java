package com.talabat.restaurants.v2.ui.viewmodels;

import androidx.lifecycle.ViewModelKt;
import androidx.paging.InvalidatingPagingSourceFactory;
import androidx.paging.PagingData;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.restaurants.inlineads.IAdLoader;
import com.talabat.restaurants.v2.data.vendors.FilterParamsRepository;
import com.talabat.restaurants.v2.domain.vendors.GetInlineAdsUseCase;
import com.talabat.restaurants.v2.domain.vendors.PagedUsedCase;
import datamodels.RestaurantListItemModel;
import io.reactivex.Scheduler;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tt.c;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u00020 H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR,\u0010\u001e\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001d\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0-0,¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001d\u00100\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!01¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/talabat/restaurants/v2/ui/viewmodels/VendorListFragmentViewModelPaged;", "Lcom/talabat/restaurants/v2/ui/viewmodels/VendorsListFragmentViewModel;", "ad", "Lcom/talabat/restaurants/inlineads/IAdLoader;", "filterParamsRepository", "Lcom/talabat/restaurants/v2/data/vendors/FilterParamsRepository;", "pagedUsedCase", "Lcom/talabat/restaurants/v2/domain/vendors/PagedUsedCase;", "getInlineAdsUseCase", "Lcom/talabat/restaurants/v2/domain/vendors/GetInlineAdsUseCase;", "io", "Lio/reactivex/Scheduler;", "main", "tracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "featureFlags", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getVendorsUseCase", "Lcom/talabat/restaurants/v2/domain/vendors/GetVendorsUseCase;", "getDisplayFeatureProductsUseCase", "Lcom/talabat/restaurants/v2/domain/swimlane/GetDisplayFeatureProductsUseCase;", "(Lcom/talabat/restaurants/inlineads/IAdLoader;Lcom/talabat/restaurants/v2/data/vendors/FilterParamsRepository;Lcom/talabat/restaurants/v2/domain/vendors/PagedUsedCase;Lcom/talabat/restaurants/v2/domain/vendors/GetInlineAdsUseCase;Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;Lcom/talabat/core/tracking/domain/TalabatTracker;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/restaurants/v2/domain/vendors/GetVendorsUseCase;Lcom/talabat/restaurants/v2/domain/swimlane/GetDisplayFeatureProductsUseCase;)V", "getAd", "()Lcom/talabat/restaurants/inlineads/IAdLoader;", "getFeatureFlags", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFilterParamsRepository", "()Lcom/talabat/restaurants/v2/data/vendors/FilterParamsRepository;", "getGetInlineAdsUseCase", "()Lcom/talabat/restaurants/v2/domain/vendors/GetInlineAdsUseCase;", "inlineAd", "Lkotlin/Pair;", "", "Ldatamodels/RestaurantListItemModel;", "getInlineAd", "()Lkotlin/Pair;", "setInlineAd", "(Lkotlin/Pair;)V", "getIo", "()Lio/reactivex/Scheduler;", "getMain", "getPagedUsedCase", "()Lcom/talabat/restaurants/v2/domain/vendors/PagedUsedCase;", "pagedVendors", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "getPagedVendors", "()Lkotlinx/coroutines/flow/Flow;", "source", "Landroidx/paging/InvalidatingPagingSourceFactory;", "getSource", "()Landroidx/paging/InvalidatingPagingSourceFactory;", "getTracker", "()Lcom/talabat/core/tracking/domain/TalabatTracker;", "loadVendorList", "", "verticalId", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorListFragmentViewModelPaged extends VendorsListFragmentViewModel {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    private final IAdLoader f61271ad;
    @NotNull
    private final ITalabatFeatureFlag featureFlags;
    @NotNull
    private final FilterParamsRepository filterParamsRepository;
    @NotNull
    private final GetInlineAdsUseCase getInlineAdsUseCase;
    @Nullable
    private Pair<Integer, ? extends RestaurantListItemModel> inlineAd;
    @NotNull

    /* renamed from: io  reason: collision with root package name */
    private final Scheduler f61272io;
    @NotNull
    private final Scheduler main;
    @NotNull
    private final PagedUsedCase pagedUsedCase;
    @NotNull
    private final Flow<PagingData<RestaurantListItemModel>> pagedVendors;
    @NotNull
    private final InvalidatingPagingSourceFactory<Integer, RestaurantListItemModel> source;
    @NotNull
    private final TalabatTracker tracker;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VendorListFragmentViewModelPaged(com.talabat.restaurants.inlineads.IAdLoader r14, com.talabat.restaurants.v2.data.vendors.FilterParamsRepository r15, com.talabat.restaurants.v2.domain.vendors.PagedUsedCase r16, com.talabat.restaurants.v2.domain.vendors.GetInlineAdsUseCase r17, io.reactivex.Scheduler r18, io.reactivex.Scheduler r19, com.talabat.core.tracking.domain.TalabatTracker r20, com.talabat.core.featureflag.domain.ITalabatFeatureFlag r21, com.talabat.restaurants.v2.domain.vendors.GetVendorsUseCase r22, com.talabat.restaurants.v2.domain.swimlane.GetDisplayFeatureProductsUseCase r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r13 = this;
            r0 = r24 & 2
            if (r0 == 0) goto L_0x000d
            com.talabat.restaurants.v2.data.vendors.FilterParamsRepositoryImpl r0 = new com.talabat.restaurants.v2.data.vendors.FilterParamsRepositoryImpl
            buisnessmodels.FilterEngine r1 = com.talabat.helpers.GlobalDataModel.filterEngine
            r0.<init>(r1)
            r4 = r0
            goto L_0x000e
        L_0x000d:
            r4 = r15
        L_0x000e:
            r0 = r24 & 4
            if (r0 == 0) goto L_0x0032
            com.talabat.restaurants.v2.domain.vendors.PagedUsedCaseImpl r0 = new com.talabat.restaurants.v2.domain.vendors.PagedUsedCaseImpl
            com.talabat.restaurants.v2.data.vendors.VendorsPaginatedDataSourceImpl r6 = new com.talabat.restaurants.v2.data.vendors.VendorsPaginatedDataSourceImpl
            com.talabat.core.network.network.NetworkBuilder$Companion r1 = com.talabat.core.network.network.NetworkBuilder.Companion
            com.talabat.core.network.endpoint.VendorEndPointProvider r2 = com.talabat.core.network.endpoint.VendorEndPointProvider.INSTANCE
            java.lang.String r2 = r2.getBaseUrl()
            java.lang.Class<com.talabat.restaurants.v2.data.vendors.VendorsApiPaginated> r3 = com.talabat.restaurants.v2.data.vendors.VendorsApiPaginated.class
            java.lang.Object r1 = r1.getService(r2, r3)
            com.talabat.restaurants.v2.data.vendors.VendorsApiPaginated r1 = (com.talabat.restaurants.v2.data.vendors.VendorsApiPaginated) r1
            r6.<init>(r1)
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            goto L_0x0034
        L_0x0032:
            r5 = r16
        L_0x0034:
            r0 = r24 & 8
            if (r0 == 0) goto L_0x0044
            com.talabat.restaurants.v2.domain.vendors.GetInlineAdsUseCase r0 = new com.talabat.restaurants.v2.domain.vendors.GetInlineAdsUseCase
            r8 = 0
            r9 = 0
            r10 = 6
            r11 = 0
            r6 = r0
            r7 = r14
            r6.<init>(r7, r8, r9, r10, r11)
            goto L_0x0046
        L_0x0044:
            r6 = r17
        L_0x0046:
            r0 = r24 & 16
            if (r0 == 0) goto L_0x0055
            io.reactivex.Scheduler r0 = io.reactivex.schedulers.Schedulers.io()
            java.lang.String r1 = "io()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r7 = r0
            goto L_0x0057
        L_0x0055:
            r7 = r18
        L_0x0057:
            r0 = r24 & 32
            if (r0 == 0) goto L_0x0066
            io.reactivex.Scheduler r0 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            java.lang.String r1 = "mainThread()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r8 = r0
            goto L_0x0068
        L_0x0066:
            r8 = r19
        L_0x0068:
            r2 = r13
            r3 = r14
            r9 = r20
            r10 = r21
            r11 = r22
            r12 = r23
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurants.v2.ui.viewmodels.VendorListFragmentViewModelPaged.<init>(com.talabat.restaurants.inlineads.IAdLoader, com.talabat.restaurants.v2.data.vendors.FilterParamsRepository, com.talabat.restaurants.v2.domain.vendors.PagedUsedCase, com.talabat.restaurants.v2.domain.vendors.GetInlineAdsUseCase, io.reactivex.Scheduler, io.reactivex.Scheduler, com.talabat.core.tracking.domain.TalabatTracker, com.talabat.core.featureflag.domain.ITalabatFeatureFlag, com.talabat.restaurants.v2.domain.vendors.GetVendorsUseCase, com.talabat.restaurants.v2.domain.swimlane.GetDisplayFeatureProductsUseCase, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: loadVendorList$lambda-1  reason: not valid java name */
    public static final void m10760loadVendorList$lambda1(VendorListFragmentViewModelPaged vendorListFragmentViewModelPaged, Pair pair) {
        Intrinsics.checkNotNullParameter(vendorListFragmentViewModelPaged, "this$0");
        vendorListFragmentViewModelPaged.inlineAd = pair;
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(vendorListFragmentViewModelPaged), (CoroutineContext) null, (CoroutineStart) null, new VendorListFragmentViewModelPaged$loadVendorList$1$1(vendorListFragmentViewModelPaged, (Continuation<? super VendorListFragmentViewModelPaged$loadVendorList$1$1>) null), 3, (Object) null);
    }

    @NotNull
    public final IAdLoader getAd() {
        return this.f61271ad;
    }

    @NotNull
    public final ITalabatFeatureFlag getFeatureFlags() {
        return this.featureFlags;
    }

    @NotNull
    public final FilterParamsRepository getFilterParamsRepository() {
        return this.filterParamsRepository;
    }

    @NotNull
    public final GetInlineAdsUseCase getGetInlineAdsUseCase() {
        return this.getInlineAdsUseCase;
    }

    @Nullable
    public final Pair<Integer, RestaurantListItemModel> getInlineAd() {
        return this.inlineAd;
    }

    @NotNull
    public final Scheduler getIo() {
        return this.f61272io;
    }

    @NotNull
    public final Scheduler getMain() {
        return this.main;
    }

    @NotNull
    public final PagedUsedCase getPagedUsedCase() {
        return this.pagedUsedCase;
    }

    @NotNull
    public final Flow<PagingData<RestaurantListItemModel>> getPagedVendors() {
        return this.pagedVendors;
    }

    @NotNull
    public final InvalidatingPagingSourceFactory<Integer, RestaurantListItemModel> getSource() {
        return this.source;
    }

    @NotNull
    public final TalabatTracker getTracker() {
        return this.tracker;
    }

    public void loadVendorList(int i11) {
        setVerticalId(i11);
        getLoading().setValue(Boolean.TRUE);
        getShowNoResult().setValue(Boolean.FALSE);
        if (this.filterParamsRepository.getFilterParams() == null) {
            getInlineAdDisposable().add(this.getInlineAdsUseCase.invoke(i11).subscribeOn(n()).observeOn(o()).subscribe(new c(this)));
        } else {
            this.inlineAd = null;
        }
    }

    public final void setInlineAd(@Nullable Pair<Integer, ? extends RestaurantListItemModel> pair) {
        this.inlineAd = pair;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public VendorListFragmentViewModelPaged(@org.jetbrains.annotations.NotNull com.talabat.restaurants.inlineads.IAdLoader r21, @org.jetbrains.annotations.NotNull com.talabat.restaurants.v2.data.vendors.FilterParamsRepository r22, @org.jetbrains.annotations.NotNull com.talabat.restaurants.v2.domain.vendors.PagedUsedCase r23, @org.jetbrains.annotations.NotNull com.talabat.restaurants.v2.domain.vendors.GetInlineAdsUseCase r24, @org.jetbrains.annotations.NotNull io.reactivex.Scheduler r25, @org.jetbrains.annotations.NotNull io.reactivex.Scheduler r26, @org.jetbrains.annotations.NotNull com.talabat.core.tracking.domain.TalabatTracker r27, @org.jetbrains.annotations.NotNull com.talabat.core.featureflag.domain.ITalabatFeatureFlag r28, @org.jetbrains.annotations.NotNull com.talabat.restaurants.v2.domain.vendors.GetVendorsUseCase r29, @org.jetbrains.annotations.NotNull com.talabat.restaurants.v2.domain.swimlane.GetDisplayFeatureProductsUseCase r30) {
        /*
            r20 = this;
            r15 = r20
            r14 = r21
            r13 = r22
            r12 = r23
            r11 = r24
            r10 = r25
            r9 = r26
            r8 = r27
            r7 = r28
            java.lang.String r0 = "ad"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "filterParamsRepository"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "pagedUsedCase"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "getInlineAdsUseCase"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "io"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "main"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "tracker"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "featureFlags"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "getVendorsUseCase"
            r2 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "getDisplayFeatureProductsUseCase"
            r4 = r30
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r3 = 0
            r5 = 0
            r6 = 0
            r16 = 0
            r17 = 0
            r18 = 436(0x1b4, float:6.11E-43)
            r19 = 0
            r0 = r20
            r1 = r28
            r7 = r21
            r8 = r16
            r9 = r17
            r11 = r26
            r12 = r27
            r13 = r18
            r14 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = r21
            r15.f61271ad = r0
            r0 = r22
            r15.filterParamsRepository = r0
            r0 = r23
            r15.pagedUsedCase = r0
            r0 = r24
            r15.getInlineAdsUseCase = r0
            r0 = r25
            r15.f61272io = r0
            r0 = r26
            r15.main = r0
            r0 = r27
            r15.tracker = r0
            r0 = r28
            r15.featureFlags = r0
            androidx.paging.InvalidatingPagingSourceFactory r0 = new androidx.paging.InvalidatingPagingSourceFactory
            com.talabat.restaurants.v2.ui.viewmodels.VendorListFragmentViewModelPaged$source$1 r1 = new com.talabat.restaurants.v2.ui.viewmodels.VendorListFragmentViewModelPaged$source$1
            r1.<init>(r15)
            r0.<init>(r1)
            r15.source = r0
            androidx.paging.Pager r1 = new androidx.paging.Pager
            androidx.paging.PagingConfig r2 = new androidx.paging.PagingConfig
            r3 = 50
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 62
            r10 = 0
            r21 = r2
            r22 = r3
            r23 = r4
            r24 = r5
            r25 = r6
            r26 = r7
            r27 = r8
            r28 = r9
            r29 = r10
            r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29)
            r3 = 0
            r1.<init>(r2, r3, r0)
            kotlinx.coroutines.flow.Flow r0 = r1.getFlow()
            kotlinx.coroutines.CoroutineScope r1 = androidx.lifecycle.ViewModelKt.getViewModelScope(r20)
            kotlinx.coroutines.flow.Flow r0 = androidx.paging.CachedPagingDataKt.cachedIn(r0, r1)
            com.talabat.restaurants.v2.ui.viewmodels.VendorListFragmentViewModelPaged$special$$inlined$map$1 r1 = new com.talabat.restaurants.v2.ui.viewmodels.VendorListFragmentViewModelPaged$special$$inlined$map$1
            r1.<init>(r0, r15)
            r15.pagedVendors = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurants.v2.ui.viewmodels.VendorListFragmentViewModelPaged.<init>(com.talabat.restaurants.inlineads.IAdLoader, com.talabat.restaurants.v2.data.vendors.FilterParamsRepository, com.talabat.restaurants.v2.domain.vendors.PagedUsedCase, com.talabat.restaurants.v2.domain.vendors.GetInlineAdsUseCase, io.reactivex.Scheduler, io.reactivex.Scheduler, com.talabat.core.tracking.domain.TalabatTracker, com.talabat.core.featureflag.domain.ITalabatFeatureFlag, com.talabat.restaurants.v2.domain.vendors.GetVendorsUseCase, com.talabat.restaurants.v2.domain.swimlane.GetDisplayFeatureProductsUseCase):void");
    }
}
