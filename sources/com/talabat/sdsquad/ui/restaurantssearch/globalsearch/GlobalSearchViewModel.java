package com.talabat.sdsquad.ui.restaurantssearch.globalsearch;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.talabat.sdsquad.core.BaseSchedulerProvider;
import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.core.UseCaseHandler;
import com.talabat.sdsquad.data.restaurantsearch.requests.ResturantSearchRequest;
import com.talabat.sdsquad.data.restaurantsearch.responses.RestaurantsSearchResponse;
import com.talabat.sdsquad.data.vendorslist.requests.VendorInfoRequest;
import com.talabat.sdsquad.domain.globalsearch.BuildSearchWrapperUseCase;
import com.talabat.sdsquad.domain.globalsearch.GetBranchesIdUseCase;
import com.talabat.sdsquad.domain.globalsearch.GlobalSearchUseCase;
import com.talabat.sdsquad.domain.vendorslist.GetVendorJsonByIdUseCase;
import com.talabat.sdsquad.domain.vendorslist.GetVendorsInfoUseCase;
import com.talabat.sdsquad.domain.vendorslist.GetVendorsUseCase;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.GlobalSearchCellType;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.GlobalSearchDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorInfo;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ku.f;
import ku.g;
import ku.h;
import ku.i;
import ku.j;
import ku.k;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B½\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u0007\u0012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u0007\u0012\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\n0\t0\u0007\u0012\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\t0\u0007\u0012\u001e\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\t0\u0007\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140\u0007¢\u0006\u0002\u0010\u001aJ0\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\t2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110\nH\u0002J4\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\n0\t2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u0014H\u0002J,\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u0014H\u0002J.\u00106\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u00103\u001a\u00020\u001d2\u0006\u00107\u001a\u00020.2\u0006\u00108\u001a\u00020.2\u0006\u0010-\u001a\u00020.H\u0002J\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u00140\t2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0006\u0010;\u001a\u00020.J\u000e\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020.J$\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u0014H\u0002JL\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\t2\u0006\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u0014H\u0002J\b\u0010@\u001a\u00020AH\u0014J6\u0010B\u001a\u00020A2\u0006\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u00142\u0006\u0010C\u001a\u00020.R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8FX\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR \u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\t0\u0007X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140\u0007X\u0004¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\n0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R'\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\u001c8FX\u0002¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b%\u0010\u001fR!\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8FX\u0002¢\u0006\f\n\u0004\b)\u0010!\u001a\u0004\b(\u0010\u001f¨\u0006D"}, d2 = {"Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/GlobalSearchViewModel;", "Landroidx/lifecycle/ViewModel;", "mSchedulerProvider", "Lcom/talabat/sdsquad/core/BaseSchedulerProvider;", "mUseCaseHandler", "Lcom/talabat/sdsquad/core/UseCaseHandler;", "mVendorUseCase", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/vendorslist/GetVendorsUseCase$RequestValues;", "Lio/reactivex/Flowable;", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "mVendorInfoUseCase", "Lcom/talabat/sdsquad/domain/vendorslist/GetVendorsInfoUseCase$RequestValues;", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorInfo;", "mGlobalSearchUseCase", "Lcom/talabat/sdsquad/domain/globalsearch/GlobalSearchUseCase$RequestValues;", "Lcom/talabat/sdsquad/data/restaurantsearch/responses/RestaurantsSearchResponse;", "mBranchesIdUseCase", "Lcom/talabat/sdsquad/domain/globalsearch/GetBranchesIdUseCase$RequestValues;", "", "mBuildSerachWrapperUseCase", "Lcom/talabat/sdsquad/domain/globalsearch/BuildSearchWrapperUseCase$RequestValues;", "Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/displaymodels/GlobalSearchDisplayModel;", "mGetVendorJsonById", "Lcom/talabat/sdsquad/domain/vendorslist/GetVendorJsonByIdUseCase$RequestValues;", "(Lcom/talabat/sdsquad/core/BaseSchedulerProvider;Lcom/talabat/sdsquad/core/UseCaseHandler;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;)V", "dishTab", "Landroidx/lifecycle/MutableLiveData;", "", "getDishTab", "()Landroidx/lifecycle/MutableLiveData;", "dishTab$delegate", "Lkotlin/Lazy;", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "resultList", "getResultList", "resultList$delegate", "vendorTab", "getVendorTab", "vendorTab$delegate", "buildWrapperClasses", "vendorsList", "callSearchApi", "countryId", "", "searchTerm", "branchesId", "keyboardType", "callVendorApi", "isForceUpdate", "latitude", "longitude", "callVendorsInfoApi", "areaId", "cityId", "getBranchesId", "vendorList", "getDishHeaderPosition", "getVendorById", "id", "getVendorList", "mergeVenodrsAndSearch", "onCleared", "", "search", "collectionId", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlobalSearchViewModel extends ViewModel {
    @NotNull
    private final Lazy dishTab$delegate;
    @NotNull
    private final UseCase<GetBranchesIdUseCase.RequestValues, Flowable<String>> mBranchesIdUseCase;
    @NotNull
    private final UseCase<BuildSearchWrapperUseCase.RequestValues, Flowable<List<GlobalSearchDisplayModel>>> mBuildSerachWrapperUseCase;
    @NotNull
    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    @NotNull
    private final UseCase<GetVendorJsonByIdUseCase.RequestValues, String> mGetVendorJsonById;
    @NotNull
    private final UseCase<GlobalSearchUseCase.RequestValues, Flowable<List<RestaurantsSearchResponse>>> mGlobalSearchUseCase;
    @NotNull
    private final BaseSchedulerProvider mSchedulerProvider;
    @NotNull
    private final UseCaseHandler mUseCaseHandler;
    @NotNull
    private final UseCase<GetVendorsInfoUseCase.RequestValues, Flowable<VendorInfo>> mVendorInfoUseCase;
    @NotNull
    private final UseCase<GetVendorsUseCase.RequestValues, Flowable<List<VendorDisplayModel>>> mVendorUseCase;
    @NotNull
    private final Lazy resultList$delegate;
    @NotNull
    private final Lazy vendorTab$delegate;

    public GlobalSearchViewModel(@NotNull BaseSchedulerProvider baseSchedulerProvider, @NotNull UseCaseHandler useCaseHandler, @NotNull UseCase<GetVendorsUseCase.RequestValues, Flowable<List<VendorDisplayModel>>> useCase, @NotNull UseCase<GetVendorsInfoUseCase.RequestValues, Flowable<VendorInfo>> useCase2, @NotNull UseCase<GlobalSearchUseCase.RequestValues, Flowable<List<RestaurantsSearchResponse>>> useCase3, @NotNull UseCase<GetBranchesIdUseCase.RequestValues, Flowable<String>> useCase4, @NotNull UseCase<BuildSearchWrapperUseCase.RequestValues, Flowable<List<GlobalSearchDisplayModel>>> useCase5, @NotNull UseCase<GetVendorJsonByIdUseCase.RequestValues, String> useCase6) {
        Intrinsics.checkNotNullParameter(baseSchedulerProvider, "mSchedulerProvider");
        Intrinsics.checkNotNullParameter(useCaseHandler, "mUseCaseHandler");
        Intrinsics.checkNotNullParameter(useCase, "mVendorUseCase");
        Intrinsics.checkNotNullParameter(useCase2, "mVendorInfoUseCase");
        Intrinsics.checkNotNullParameter(useCase3, "mGlobalSearchUseCase");
        Intrinsics.checkNotNullParameter(useCase4, "mBranchesIdUseCase");
        Intrinsics.checkNotNullParameter(useCase5, "mBuildSerachWrapperUseCase");
        Intrinsics.checkNotNullParameter(useCase6, "mGetVendorJsonById");
        this.mSchedulerProvider = baseSchedulerProvider;
        this.mUseCaseHandler = useCaseHandler;
        this.mVendorUseCase = useCase;
        this.mVendorInfoUseCase = useCase2;
        this.mGlobalSearchUseCase = useCase3;
        this.mBranchesIdUseCase = useCase4;
        this.mBuildSerachWrapperUseCase = useCase5;
        this.mGetVendorJsonById = useCase6;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.resultList$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, GlobalSearchViewModel$resultList$2.INSTANCE);
        this.vendorTab$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, GlobalSearchViewModel$vendorTab$2.INSTANCE);
        this.dishTab$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, GlobalSearchViewModel$dishTab$2.INSTANCE);
    }

    private final Flowable<List<GlobalSearchDisplayModel>> buildWrapperClasses(List<VendorDisplayModel> list, List<RestaurantsSearchResponse> list2) {
        Flowable<List<GlobalSearchDisplayModel>> subscribeOn = ((Flowable) this.mUseCaseHandler.execute(this.mBuildSerachWrapperUseCase, new BuildSearchWrapperUseCase.RequestValues(list, list2))).subscribeOn(this.mSchedulerProvider.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "mUseCaseHandler.execute(…(mSchedulerProvider.io())");
        return subscribeOn;
    }

    private final Flowable<List<RestaurantsSearchResponse>> callSearchApi(int i11, String str, String str2, String str3) {
        Flowable<List<RestaurantsSearchResponse>> subscribeOn = ((Flowable) this.mUseCaseHandler.execute(this.mGlobalSearchUseCase, new GlobalSearchUseCase.RequestValues(i11, new ResturantSearchRequest(str, str2, str3)))).subscribeOn(this.mSchedulerProvider.io());
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

    private final Flowable<String> getBranchesId(List<VendorDisplayModel> list) {
        Flowable<String> subscribeOn = ((Flowable) this.mUseCaseHandler.execute(this.mBranchesIdUseCase, new GetBranchesIdUseCase.RequestValues(list))).subscribeOn(this.mSchedulerProvider.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "mUseCaseHandler.execute(…(mSchedulerProvider.io())");
        return subscribeOn;
    }

    private final Flowable<List<VendorDisplayModel>> getVendorList(String str, String str2) {
        Flowable<List<VendorDisplayModel>> subscribeOn = ((Flowable) this.mUseCaseHandler.execute(this.mVendorUseCase, new GetVendorsUseCase.RequestValues(false, str, str2))).subscribeOn(this.mSchedulerProvider.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "mUseCaseHandler.execute(…(mSchedulerProvider.io())");
        return subscribeOn;
    }

    private final Flowable<List<GlobalSearchDisplayModel>> mergeVenodrsAndSearch(boolean z11, String str, String str2, int i11, String str3, String str4, String str5) {
        Flowable<R> subscribeOn = Flowable.zip(callVendorApi(z11, str, str2), callVendorsInfoApi(false, 9, 2, 1), callSearchApi(i11, str3, str4, str5), new f(this)).subscribeOn(this.mSchedulerProvider.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "zip(\n            callVen…(mSchedulerProvider.io())");
        return subscribeOn;
    }

    /* access modifiers changed from: private */
    /* renamed from: mergeVenodrsAndSearch$lambda-9  reason: not valid java name */
    public static final List m10836mergeVenodrsAndSearch$lambda9(GlobalSearchViewModel globalSearchViewModel, List list, VendorInfo vendorInfo, List list2) {
        Intrinsics.checkNotNullParameter(globalSearchViewModel, "this$0");
        Intrinsics.checkNotNullParameter(list, "t1");
        Intrinsics.checkNotNullParameter(vendorInfo, "t2");
        Intrinsics.checkNotNullParameter(list2, "t3");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            VendorDisplayModel vendorDisplayModel = (VendorDisplayModel) it.next();
            vendorDisplayModel.setBaseUrl(vendorInfo.getBaseUrl());
            vendorDisplayModel.setDecimalCount(vendorInfo.getDigitCount());
        }
        return globalSearchViewModel.buildWrapperClasses(list, list2).blockingFirst();
    }

    /* access modifiers changed from: private */
    /* renamed from: search$lambda-1  reason: not valid java name */
    public static final List m10837search$lambda1(int i11, List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        if (i11 == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (((VendorDisplayModel) next).getFiltersId().contains(Integer.valueOf(i11))) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: search$lambda-2  reason: not valid java name */
    public static final Flowable m10838search$lambda2(GlobalSearchViewModel globalSearchViewModel, List list) {
        Intrinsics.checkNotNullParameter(globalSearchViewModel, "this$0");
        Intrinsics.checkNotNullParameter(list, "vendorList");
        return globalSearchViewModel.getBranchesId(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: search$lambda-3  reason: not valid java name */
    public static final Flowable m10839search$lambda3(GlobalSearchViewModel globalSearchViewModel, String str, String str2, int i11, String str3, String str4, Flowable flowable) {
        Intrinsics.checkNotNullParameter(globalSearchViewModel, "this$0");
        Intrinsics.checkNotNullParameter(str, "$latitude");
        Intrinsics.checkNotNullParameter(str2, "$longitude");
        Intrinsics.checkNotNullParameter(str3, "$searchTerm");
        Intrinsics.checkNotNullParameter(str4, "$keyboardType");
        Intrinsics.checkNotNullParameter(flowable, "it");
        Object blockingFirst = flowable.blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "it.blockingFirst()");
        return globalSearchViewModel.mergeVenodrsAndSearch(false, str, str2, i11, str3, (String) blockingFirst, str4);
    }

    /* access modifiers changed from: private */
    /* renamed from: search$lambda-6  reason: not valid java name */
    public static final void m10840search$lambda6(GlobalSearchViewModel globalSearchViewModel, Flowable flowable) {
        Object obj;
        Object obj2;
        boolean z11;
        boolean z12;
        Intrinsics.checkNotNullParameter(globalSearchViewModel, "this$0");
        List list = (List) flowable.blockingFirst();
        Intrinsics.checkNotNullExpressionValue(list, DefaultCardView.CARD_LIST);
        Iterable iterable = list;
        Iterator it = iterable.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (((GlobalSearchDisplayModel) obj2).getType() == GlobalSearchCellType.VendorHeader) {
                z12 = true;
                continue;
            } else {
                z12 = false;
                continue;
            }
            if (z12) {
                break;
            }
        }
        if (obj2 != null) {
            globalSearchViewModel.getVendorTab().setValue(Boolean.TRUE);
        }
        Iterator it2 = iterable.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (((GlobalSearchDisplayModel) next).getType() == GlobalSearchCellType.DishHeader) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                obj = next;
                break;
            }
        }
        if (obj != null) {
            globalSearchViewModel.getDishTab().setValue(Boolean.TRUE);
        }
        globalSearchViewModel.getResultList().setValue(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: search$lambda-7  reason: not valid java name */
    public static final void m10841search$lambda7(Throwable th2) {
        String message = th2.getMessage();
        Intrinsics.checkNotNull(message);
        Log.e("grocery", message);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.GlobalSearchDisplayModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.GlobalSearchDisplayModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.GlobalSearchDisplayModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.GlobalSearchDisplayModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.GlobalSearchDisplayModel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getDishHeaderPosition() {
        /*
            r6 = this;
            androidx.lifecycle.MutableLiveData r0 = r6.getResultList()
            java.lang.Object r0 = r0.getValue()
            java.util.List r0 = (java.util.List) r0
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x0031
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0014:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x002f
            java.lang.Object r3 = r0.next()
            r4 = r3
            com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.GlobalSearchDisplayModel r4 = (com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.GlobalSearchDisplayModel) r4
            com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.GlobalSearchCellType r4 = r4.getType()
            com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.GlobalSearchCellType r5 = com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.GlobalSearchCellType.DishHeader
            if (r4 != r5) goto L_0x002b
            r4 = 1
            goto L_0x002c
        L_0x002b:
            r4 = r2
        L_0x002c:
            if (r4 == 0) goto L_0x0014
            r1 = r3
        L_0x002f:
            com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.GlobalSearchDisplayModel r1 = (com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.GlobalSearchDisplayModel) r1
        L_0x0031:
            if (r1 == 0) goto L_0x0043
            androidx.lifecycle.MutableLiveData r0 = r6.getResultList()
            java.lang.Object r0 = r0.getValue()
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x0043
            int r2 = r0.indexOf(r1)
        L_0x0043:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.sdsquad.ui.restaurantssearch.globalsearch.GlobalSearchViewModel.getDishHeaderPosition():int");
    }

    @NotNull
    public final MutableLiveData<Boolean> getDishTab() {
        return (MutableLiveData) this.dishTab$delegate.getValue();
    }

    @NotNull
    public final MutableLiveData<List<GlobalSearchDisplayModel>> getResultList() {
        return (MutableLiveData) this.resultList$delegate.getValue();
    }

    @NotNull
    public final String getVendorById(int i11) {
        return (String) this.mUseCaseHandler.execute(this.mGetVendorJsonById, new GetVendorJsonByIdUseCase.RequestValues(i11));
    }

    @NotNull
    public final MutableLiveData<Boolean> getVendorTab() {
        return (MutableLiveData) this.vendorTab$delegate.getValue();
    }

    public void onCleared() {
        this.mCompositeDisposable.dispose();
        super.onCleared();
    }

    public final void search(@NotNull String str, @NotNull String str2, int i11, @NotNull String str3, @NotNull String str4, int i12) {
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        Intrinsics.checkNotNullParameter(str3, "searchTerm");
        Intrinsics.checkNotNullParameter(str4, "keyboardType");
        this.mCompositeDisposable.add(getVendorList(str, str2).map(new g(i12)).map(new h(this)).map(new i(this, str, str2, i11, str3, str4)).subscribeOn(this.mSchedulerProvider.io()).observeOn(this.mSchedulerProvider.ui()).subscribe(new j(this), new k()));
    }
}
