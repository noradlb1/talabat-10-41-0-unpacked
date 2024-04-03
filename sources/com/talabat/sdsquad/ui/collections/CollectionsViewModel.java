package com.talabat.sdsquad.ui.collections;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.talabat.sdsquad.core.BaseSchedulerProvider;
import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.core.UseCaseHandler;
import com.talabat.sdsquad.data.darkstors.responses.DarkStoreResponse;
import com.talabat.sdsquad.data.vendorslist.requests.VendorInfoRequest;
import com.talabat.sdsquad.data.vendorslist.response.SortTypes;
import com.talabat.sdsquad.domain.darkstores.AddDarkStoreUseCase;
import com.talabat.sdsquad.domain.darkstores.GetDarkStoreUseCase;
import com.talabat.sdsquad.domain.vendorslist.ApplyCuisineUseCase;
import com.talabat.sdsquad.domain.vendorslist.ApplyFiltersUseCase;
import com.talabat.sdsquad.domain.vendorslist.ApplySortUseCase;
import com.talabat.sdsquad.domain.vendorslist.GetVendorJsonByIdUseCase;
import com.talabat.sdsquad.domain.vendorslist.GetVendorsInfoUseCase;
import com.talabat.sdsquad.domain.vendorslist.GetVendorsUseCase;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.InlineAdDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.SwimlaneDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorCellType;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayWrapper;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorInfo;
import eu.i;
import eu.j;
import eu.k;
import eu.l;
import eu.m;
import eu.n;
import eu.o;
import eu.p;
import eu.q;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001Bë\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u0007\u0012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u0007\u0012\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007\u0012\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007\u0012\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007\u0012\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\t0\u0007\u0012\u001e\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u0019\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u0007\u0012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u0007¢\u0006\u0002\u0010\u001dJ.\u00104\u001a\b\u0012\u0004\u0012\u00020\u00170\t2\u0006\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020!2\u0006\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u001cH\u0002J,\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u00105\u001a\u00020(2\u0006\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u001cH\u0002J.\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020!2\u0006\u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020!H\u0002J\u0006\u0010=\u001a\u00020!J\u0016\u0010>\u001a\u0012\u0012\u0004\u0012\u00020!0#j\b\u0012\u0004\u0012\u00020!`$J\u0006\u0010?\u001a\u00020!J\u000e\u0010@\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020!J>\u0010B\u001a\u00020C2\u0006\u00105\u001a\u00020(2\u0006\u0010D\u001a\u00020!2\u0006\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u001c2\u0006\u00106\u001a\u00020!2\u0006\u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020!J\b\u0010E\u001a\u00020CH\u0014J\u000e\u0010F\u001a\u00020C2\u0006\u0010G\u001a\u00020!J\u001e\u0010H\u001a\u00020C2\u0016\u0010I\u001a\u0012\u0012\u0004\u0012\u00020!0#j\b\u0012\u0004\u0012\u00020!`$J\u000e\u0010J\u001a\u00020C2\u0006\u0010K\u001a\u00020!R \u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007X\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007X\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u0007X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u0019\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020!0#j\b\u0012\u0004\u0012\u00020!`$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R!\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'8FX\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010*R!\u0010-\u001a\b\u0012\u0004\u0012\u00020(0'8FX\u0002¢\u0006\f\n\u0004\b/\u0010,\u001a\u0004\b.\u0010*R'\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\n0'8FX\u0002¢\u0006\f\n\u0004\b3\u0010,\u001a\u0004\b2\u0010*¨\u0006L"}, d2 = {"Lcom/talabat/sdsquad/ui/collections/CollectionsViewModel;", "Landroidx/lifecycle/ViewModel;", "mSchedulerProvider", "Lcom/talabat/sdsquad/core/BaseSchedulerProvider;", "mUseCaseHandler", "Lcom/talabat/sdsquad/core/UseCaseHandler;", "mVendorUseCase", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/vendorslist/GetVendorsUseCase$RequestValues;", "Lio/reactivex/Flowable;", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "mVendorInfoUseCase", "Lcom/talabat/sdsquad/domain/vendorslist/GetVendorsInfoUseCase$RequestValues;", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorInfo;", "mApplyFiltersUseCase", "Lcom/talabat/sdsquad/domain/vendorslist/ApplyFiltersUseCase$RequestValues;", "mApplySortUseCase", "Lcom/talabat/sdsquad/domain/vendorslist/ApplySortUseCase$RequestValues;", "mApplyCuisineUseCase", "Lcom/talabat/sdsquad/domain/vendorslist/ApplyCuisineUseCase$RequestValues;", "mGetDarkStoreUseCase", "Lcom/talabat/sdsquad/domain/darkstores/GetDarkStoreUseCase$RequestValues;", "Lcom/talabat/sdsquad/data/darkstors/responses/DarkStoreResponse;", "mInsertDarkStoreUseCase", "Lcom/talabat/sdsquad/domain/darkstores/AddDarkStoreUseCase$RequestValues;", "mGetVendorJsonById", "Lcom/talabat/sdsquad/domain/vendorslist/GetVendorJsonByIdUseCase$RequestValues;", "", "(Lcom/talabat/sdsquad/core/BaseSchedulerProvider;Lcom/talabat/sdsquad/core/UseCaseHandler;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;)V", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "mOnCuisineId", "", "mOnFiltersIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mOnSort", "showCuisineBubble", "Landroidx/lifecycle/MutableLiveData;", "", "getShowCuisineBubble", "()Landroidx/lifecycle/MutableLiveData;", "showCuisineBubble$delegate", "Lkotlin/Lazy;", "showFilterBubble", "getShowFilterBubble", "showFilterBubble$delegate", "vendorsList", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayWrapper;", "getVendorsList", "vendorsList$delegate", "callDarkStore", "isForceUpdate", "areaId", "latitude", "longitude", "callVendorApi", "callVendorsInfoApi", "cityId", "countryId", "getAppliedCuisine", "getAppliedFilters", "getAppliedSort", "getVendorById", "id", "getVendors", "", "collectionId", "onCleared", "setAppliedCuisine", "cuisineId", "setAppliedFilter", "appliedFilters", "setAppliedSort", "appliedSort", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionsViewModel extends ViewModel {
    @NotNull
    private final UseCase<ApplyCuisineUseCase.RequestValues, List<VendorDisplayModel>> mApplyCuisineUseCase;
    @NotNull
    private final UseCase<ApplyFiltersUseCase.RequestValues, List<VendorDisplayModel>> mApplyFiltersUseCase;
    @NotNull
    private final UseCase<ApplySortUseCase.RequestValues, List<VendorDisplayModel>> mApplySortUseCase;
    @NotNull
    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    @NotNull
    private final UseCase<GetDarkStoreUseCase.RequestValues, Flowable<DarkStoreResponse>> mGetDarkStoreUseCase;
    @NotNull
    private final UseCase<GetVendorJsonByIdUseCase.RequestValues, String> mGetVendorJsonById;
    @NotNull
    private final UseCase<AddDarkStoreUseCase.RequestValues, Flowable<List<VendorDisplayModel>>> mInsertDarkStoreUseCase;
    private int mOnCuisineId;
    @NotNull
    private ArrayList<Integer> mOnFiltersIds = new ArrayList<>();
    private int mOnSort = SortTypes.RECOMMENDATION.ordinal();
    @NotNull
    private final BaseSchedulerProvider mSchedulerProvider;
    @NotNull
    private final UseCaseHandler mUseCaseHandler;
    @NotNull
    private final UseCase<GetVendorsInfoUseCase.RequestValues, Flowable<VendorInfo>> mVendorInfoUseCase;
    @NotNull
    private final UseCase<GetVendorsUseCase.RequestValues, Flowable<List<VendorDisplayModel>>> mVendorUseCase;
    @NotNull
    private final Lazy showCuisineBubble$delegate;
    @NotNull
    private final Lazy showFilterBubble$delegate;
    @NotNull
    private final Lazy vendorsList$delegate;

    public CollectionsViewModel(@NotNull BaseSchedulerProvider baseSchedulerProvider, @NotNull UseCaseHandler useCaseHandler, @NotNull UseCase<GetVendorsUseCase.RequestValues, Flowable<List<VendorDisplayModel>>> useCase, @NotNull UseCase<GetVendorsInfoUseCase.RequestValues, Flowable<VendorInfo>> useCase2, @NotNull UseCase<ApplyFiltersUseCase.RequestValues, List<VendorDisplayModel>> useCase3, @NotNull UseCase<ApplySortUseCase.RequestValues, List<VendorDisplayModel>> useCase4, @NotNull UseCase<ApplyCuisineUseCase.RequestValues, List<VendorDisplayModel>> useCase5, @NotNull UseCase<GetDarkStoreUseCase.RequestValues, Flowable<DarkStoreResponse>> useCase6, @NotNull UseCase<AddDarkStoreUseCase.RequestValues, Flowable<List<VendorDisplayModel>>> useCase7, @NotNull UseCase<GetVendorJsonByIdUseCase.RequestValues, String> useCase8) {
        Intrinsics.checkNotNullParameter(baseSchedulerProvider, "mSchedulerProvider");
        Intrinsics.checkNotNullParameter(useCaseHandler, "mUseCaseHandler");
        Intrinsics.checkNotNullParameter(useCase, "mVendorUseCase");
        Intrinsics.checkNotNullParameter(useCase2, "mVendorInfoUseCase");
        Intrinsics.checkNotNullParameter(useCase3, "mApplyFiltersUseCase");
        Intrinsics.checkNotNullParameter(useCase4, "mApplySortUseCase");
        Intrinsics.checkNotNullParameter(useCase5, "mApplyCuisineUseCase");
        Intrinsics.checkNotNullParameter(useCase6, "mGetDarkStoreUseCase");
        Intrinsics.checkNotNullParameter(useCase7, "mInsertDarkStoreUseCase");
        Intrinsics.checkNotNullParameter(useCase8, "mGetVendorJsonById");
        this.mSchedulerProvider = baseSchedulerProvider;
        this.mUseCaseHandler = useCaseHandler;
        this.mVendorUseCase = useCase;
        this.mVendorInfoUseCase = useCase2;
        this.mApplyFiltersUseCase = useCase3;
        this.mApplySortUseCase = useCase4;
        this.mApplyCuisineUseCase = useCase5;
        this.mGetDarkStoreUseCase = useCase6;
        this.mInsertDarkStoreUseCase = useCase7;
        this.mGetVendorJsonById = useCase8;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.vendorsList$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, CollectionsViewModel$vendorsList$2.INSTANCE);
        this.showFilterBubble$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, CollectionsViewModel$showFilterBubble$2.INSTANCE);
        this.showCuisineBubble$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, CollectionsViewModel$showCuisineBubble$2.INSTANCE);
    }

    private final Flowable<DarkStoreResponse> callDarkStore(boolean z11, int i11, String str, String str2) {
        Flowable<DarkStoreResponse> subscribeOn = ((Flowable) this.mUseCaseHandler.execute(this.mGetDarkStoreUseCase, new GetDarkStoreUseCase.RequestValues(z11, i11, str, str2))).subscribeOn(this.mSchedulerProvider.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "mUseCaseHandler.execute(…(mSchedulerProvider.io())");
        return subscribeOn;
    }

    private final Flowable<List<VendorDisplayModel>> callVendorApi(boolean z11, String str, String str2) {
        Flowable<List<VendorDisplayModel>> subscribeOn = ((Flowable) this.mUseCaseHandler.execute(this.mVendorUseCase, new GetVendorsUseCase.RequestValues(z11, str, str2))).subscribeOn(this.mSchedulerProvider.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "mUseCaseHandler.execute(…(mSchedulerProvider.io())");
        return subscribeOn;
    }

    private final Flowable<VendorInfo> callVendorsInfoApi(boolean z11, int i11, int i12, int i13) {
        Flowable<VendorInfo> subscribeOn = ((Flowable) this.mUseCaseHandler.execute(this.mVendorInfoUseCase, new GetVendorsInfoUseCase.RequestValues(z11, new VendorInfoRequest(i11, i12, i13)))).subscribeOn(this.mSchedulerProvider.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "mUseCaseHandler.execute(…(mSchedulerProvider.io())");
        return subscribeOn;
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendors$lambda-1  reason: not valid java name */
    public static final List m10803getVendors$lambda1(Ref.ObjectRef objectRef, Ref.IntRef intRef, List list, VendorInfo vendorInfo, DarkStoreResponse darkStoreResponse) {
        Intrinsics.checkNotNullParameter(objectRef, "$baseUrl");
        Intrinsics.checkNotNullParameter(intRef, "$decimalCount");
        Intrinsics.checkNotNullParameter(list, "t1");
        Intrinsics.checkNotNullParameter(vendorInfo, "t2");
        Intrinsics.checkNotNullParameter(darkStoreResponse, "t3");
        Thread.currentThread().getName();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            VendorDisplayModel vendorDisplayModel = (VendorDisplayModel) it.next();
            vendorDisplayModel.setBaseUrl(vendorInfo.getBaseUrl());
            vendorDisplayModel.setDecimalCount(vendorInfo.getDigitCount());
        }
        objectRef.element = vendorInfo.getBaseUrl();
        intRef.element = vendorInfo.getDigitCount();
        return list;
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendors$lambda-10  reason: not valid java name */
    public static final void m10804getVendors$lambda10(CollectionsViewModel collectionsViewModel, List list) {
        Intrinsics.checkNotNullParameter(collectionsViewModel, "this$0");
        Thread.currentThread().getName();
        collectionsViewModel.getVendorsList().setValue(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendors$lambda-11  reason: not valid java name */
    public static final void m10805getVendors$lambda11(Throwable th2) {
        Intrinsics.checkNotNull(th2.getMessage());
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendors$lambda-2  reason: not valid java name */
    public static final List m10806getVendors$lambda2(CollectionsViewModel collectionsViewModel, Ref.ObjectRef objectRef, Ref.IntRef intRef, List list) {
        Intrinsics.checkNotNullParameter(collectionsViewModel, "this$0");
        Intrinsics.checkNotNullParameter(objectRef, "$baseUrl");
        Intrinsics.checkNotNullParameter(intRef, "$decimalCount");
        Intrinsics.checkNotNullParameter(list, "it");
        return (List) ((Flowable) collectionsViewModel.mUseCaseHandler.execute(collectionsViewModel.mInsertDarkStoreUseCase, new AddDarkStoreUseCase.RequestValues(list, (String) objectRef.element, intRef.element))).blockingFirst();
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendors$lambda-4  reason: not valid java name */
    public static final List m10807getVendors$lambda4(int i11, List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        Thread.currentThread().getName();
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (((VendorDisplayModel) next).getFiltersId().contains(Integer.valueOf(i11))) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendors$lambda-5  reason: not valid java name */
    public static final List m10808getVendors$lambda5(CollectionsViewModel collectionsViewModel, List list) {
        Intrinsics.checkNotNullParameter(collectionsViewModel, "this$0");
        Intrinsics.checkNotNullParameter(list, "it");
        Thread.currentThread().getName();
        if (!collectionsViewModel.mOnFiltersIds.isEmpty()) {
            return (List) collectionsViewModel.mUseCaseHandler.execute(collectionsViewModel.mApplyFiltersUseCase, new ApplyFiltersUseCase.RequestValues(list, collectionsViewModel.mOnFiltersIds));
        }
        return list;
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendors$lambda-6  reason: not valid java name */
    public static final List m10809getVendors$lambda6(CollectionsViewModel collectionsViewModel, List list) {
        Intrinsics.checkNotNullParameter(collectionsViewModel, "this$0");
        Intrinsics.checkNotNullParameter(list, "it");
        Thread.currentThread().getName();
        return (List) collectionsViewModel.mUseCaseHandler.execute(collectionsViewModel.mApplyCuisineUseCase, new ApplyCuisineUseCase.RequestValues(list, collectionsViewModel.mOnCuisineId));
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendors$lambda-7  reason: not valid java name */
    public static final List m10810getVendors$lambda7(CollectionsViewModel collectionsViewModel, List list) {
        Intrinsics.checkNotNullParameter(collectionsViewModel, "this$0");
        Intrinsics.checkNotNullParameter(list, "it");
        Thread.currentThread().getName();
        if (!list.isEmpty()) {
            return (List) collectionsViewModel.mUseCaseHandler.execute(collectionsViewModel.mApplySortUseCase, new ApplySortUseCase.RequestValues(list, collectionsViewModel.mOnSort));
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendors$lambda-9  reason: not valid java name */
    public static final List m10811getVendors$lambda9(List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        Thread.currentThread().getName();
        if (!(!list.isEmpty())) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new VendorDisplayWrapper(VendorCellType.Vendor, (VendorDisplayModel) it.next(), (List) null, (SwimlaneDisplayModel) null, (InlineAdDisplayModel) null, 28, (DefaultConstructorMarker) null));
        }
        return arrayList;
    }

    public final int getAppliedCuisine() {
        return this.mOnCuisineId;
    }

    @NotNull
    public final ArrayList<Integer> getAppliedFilters() {
        return this.mOnFiltersIds;
    }

    public final int getAppliedSort() {
        return this.mOnSort;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowCuisineBubble() {
        return (MutableLiveData) this.showCuisineBubble$delegate.getValue();
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowFilterBubble() {
        return (MutableLiveData) this.showFilterBubble$delegate.getValue();
    }

    @NotNull
    public final String getVendorById(int i11) {
        return (String) this.mUseCaseHandler.execute(this.mGetVendorJsonById, new GetVendorJsonByIdUseCase.RequestValues(i11));
    }

    public final void getVendors(boolean z11, int i11, @NotNull String str, @NotNull String str2, int i12, int i13, int i14) {
        boolean z12;
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        MutableLiveData<Boolean> showFilterBubble = getShowFilterBubble();
        boolean z13 = false;
        if (this.mOnSort != SortTypes.RECOMMENDATION.ordinal() || (!this.mOnFiltersIds.isEmpty())) {
            z12 = true;
        } else {
            z12 = false;
        }
        showFilterBubble.setValue(Boolean.valueOf(z12));
        MutableLiveData<Boolean> showCuisineBubble = getShowCuisineBubble();
        if (this.mOnCuisineId != 0) {
            z13 = true;
        }
        showCuisineBubble.setValue(Boolean.valueOf(z13));
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        Ref.IntRef intRef = new Ref.IntRef();
        this.mCompositeDisposable.add(Flowable.zip(callVendorApi(z11, str, str2), callVendorsInfoApi(z11, i12, i13, i14), callDarkStore(z11, i12, str, str2), new i(objectRef, intRef)).map(new j(this, objectRef, intRef)).map(new k(i11)).map(new l(this)).map(new m(this)).map(new n(this)).map(new o()).subscribeOn(this.mSchedulerProvider.io()).observeOn(this.mSchedulerProvider.ui()).subscribe(new p(this), new q()));
    }

    @NotNull
    public final MutableLiveData<List<VendorDisplayWrapper>> getVendorsList() {
        return (MutableLiveData) this.vendorsList$delegate.getValue();
    }

    public void onCleared() {
        this.mCompositeDisposable.dispose();
        super.onCleared();
    }

    public final void setAppliedCuisine(int i11) {
        this.mOnCuisineId = i11;
    }

    public final void setAppliedFilter(@NotNull ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "appliedFilters");
        this.mOnFiltersIds = arrayList;
    }

    public final void setAppliedSort(int i11) {
        this.mOnSort = i11;
    }
}
