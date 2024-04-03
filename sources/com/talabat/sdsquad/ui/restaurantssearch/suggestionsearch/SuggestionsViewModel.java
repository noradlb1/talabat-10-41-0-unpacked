package com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.talabat.sdsquad.core.BaseSchedulerProvider;
import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.core.UseCaseHandler;
import com.talabat.sdsquad.data.restaurantsearch.requests.ResturantSearchRequest;
import com.talabat.sdsquad.data.restaurantsearch.responses.RestaurantsSearchResponse;
import com.talabat.sdsquad.data.vendorslist.requests.VendorInfoRequest;
import com.talabat.sdsquad.domain.globalsearch.GetBranchesIdUseCase;
import com.talabat.sdsquad.domain.globalsearch.GlobalSearchUseCase;
import com.talabat.sdsquad.domain.globalsearch.ItemsSuggestionsUseCase;
import com.talabat.sdsquad.domain.vendorslist.GetVendorJsonByIdUseCase;
import com.talabat.sdsquad.domain.vendorslist.GetVendorsInfoUseCase;
import com.talabat.sdsquad.domain.vendorslist.GetVendorsUseCase;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.DishDisplayModel;
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
import lu.g;
import lu.h;
import lu.i;
import lu.j;
import lu.k;
import lu.l;
import lu.m;
import lu.n;
import lu.o;
import lu.p;
import lu.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B½\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u0007\u0012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u0007\u0012\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\n0\t0\u0007\u0012\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\t0\u0007\u0012\u001e\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\t0\u0007\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140\u0007¢\u0006\u0002\u0010\u001aJ0\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\t2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00110\nH\u0002J4\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\n0\t2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u0014H\u0002J,\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020\u00142\u0006\u0010?\u001a\u00020\u0014H\u0002J.\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u0010=\u001a\u00020$2\u0006\u0010A\u001a\u0002082\u0006\u0010B\u001a\u0002082\u0006\u00107\u001a\u000208H\u0002J\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00140\t2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J8\u0010E\u001a\u00020F2\u0006\u0010>\u001a\u00020\u00142\u0006\u0010?\u001a\u00020\u00142\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u00142\u0006\u0010G\u001a\u000208H\u0002J\u000e\u0010H\u001a\u00020\u00142\u0006\u0010I\u001a\u000208J$\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010>\u001a\u00020\u00142\u0006\u0010?\u001a\u00020\u0014H\u0002JL\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\t2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020\u00142\u0006\u0010?\u001a\u00020\u00142\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u0014H\u0002J\b\u0010L\u001a\u00020FH\u0014JF\u0010M\u001a\u00020F2\u0006\u0010>\u001a\u00020\u00142\u0006\u0010?\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u00142\u0006\u0010A\u001a\u0002082\u0006\u0010B\u001a\u0002082\u0006\u00107\u001a\u0002082\u0006\u0010;\u001a\u00020\u00142\u0006\u0010G\u001a\u000208J@\u0010N\u001a\u00020F2\u0006\u00109\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u00142\u0006\u0010?\u001a\u00020\u00142\u0006\u0010A\u001a\u0002082\u0006\u0010B\u001a\u0002082\u0006\u00107\u001a\u0002082\u0006\u0010G\u001a\u000208H\u0002R'\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\u001c8FX\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR \u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140\u0007X\u0004¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\n0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R!\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001c8FX\u0002¢\u0006\f\n\u0004\b&\u0010 \u001a\u0004\b%\u0010\u001eR!\u0010'\u001a\b\u0012\u0004\u0012\u00020$0\u001c8FX\u0002¢\u0006\f\n\u0004\b)\u0010 \u001a\u0004\b(\u0010\u001eR!\u0010*\u001a\b\u0012\u0004\u0012\u00020$0\u001c8FX\u0002¢\u0006\f\n\u0004\b,\u0010 \u001a\u0004\b+\u0010\u001eR!\u0010-\u001a\b\u0012\u0004\u0012\u00020$0\u001c8FX\u0002¢\u0006\f\n\u0004\b/\u0010 \u001a\u0004\b.\u0010\u001eR'\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u001c8FX\u0002¢\u0006\f\n\u0004\b2\u0010 \u001a\u0004\b1\u0010\u001e¨\u0006O"}, d2 = {"Lcom/talabat/sdsquad/ui/restaurantssearch/suggestionsearch/SuggestionsViewModel;", "Landroidx/lifecycle/ViewModel;", "mSchedulerProvider", "Lcom/talabat/sdsquad/core/BaseSchedulerProvider;", "mUseCaseHandler", "Lcom/talabat/sdsquad/core/UseCaseHandler;", "mVendorUseCase", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/vendorslist/GetVendorsUseCase$RequestValues;", "Lio/reactivex/Flowable;", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "mVendorInfoUseCase", "Lcom/talabat/sdsquad/domain/vendorslist/GetVendorsInfoUseCase$RequestValues;", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorInfo;", "mGlobalSearchUseCase", "Lcom/talabat/sdsquad/domain/globalsearch/GlobalSearchUseCase$RequestValues;", "Lcom/talabat/sdsquad/data/restaurantsearch/responses/RestaurantsSearchResponse;", "mBranchesIdUseCase", "Lcom/talabat/sdsquad/domain/globalsearch/GetBranchesIdUseCase$RequestValues;", "", "mItemSuggestionsUseCase", "Lcom/talabat/sdsquad/domain/globalsearch/ItemsSuggestionsUseCase$RequestValues;", "Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/displaymodels/DishDisplayModel;", "mGetVendorJsonById", "Lcom/talabat/sdsquad/domain/vendorslist/GetVendorJsonByIdUseCase$RequestValues;", "(Lcom/talabat/sdsquad/core/BaseSchedulerProvider;Lcom/talabat/sdsquad/core/UseCaseHandler;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;)V", "dishesSuggestionsList", "Landroidx/lifecycle/MutableLiveData;", "getDishesSuggestionsList", "()Landroidx/lifecycle/MutableLiveData;", "dishesSuggestionsList$delegate", "Lkotlin/Lazy;", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "showDishesSeeMore", "", "getShowDishesSeeMore", "showDishesSeeMore$delegate", "showDishesSuggestions", "getShowDishesSuggestions", "showDishesSuggestions$delegate", "showVendorsSeeMore", "getShowVendorsSeeMore", "showVendorsSeeMore$delegate", "showVendorsSuggestions", "getShowVendorsSuggestions", "showVendorsSuggestions$delegate", "vendorsSuggestionsList", "getVendorsSuggestionsList", "vendorsSuggestionsList$delegate", "buildWrapperClasses", "vendorsList", "resultList", "callSearchApi", "countryId", "", "searchTerm", "branchesId", "keyboardType", "callVendorApi", "isForceUpdate", "latitude", "longitude", "callVendorsInfoApi", "areaId", "cityId", "getBranchesId", "vendorList", "getSuggestionsDishes", "", "collectionId", "getVendorById", "id", "getVendorList", "mergeVendorsAndSearch", "onCleared", "search", "searchVendorsLocally", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SuggestionsViewModel extends ViewModel {
    @NotNull
    private final Lazy dishesSuggestionsList$delegate;
    @NotNull
    private final UseCase<GetBranchesIdUseCase.RequestValues, Flowable<String>> mBranchesIdUseCase;
    @NotNull
    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    @NotNull
    private final UseCase<GetVendorJsonByIdUseCase.RequestValues, String> mGetVendorJsonById;
    @NotNull
    private final UseCase<GlobalSearchUseCase.RequestValues, Flowable<List<RestaurantsSearchResponse>>> mGlobalSearchUseCase;
    @NotNull
    private final UseCase<ItemsSuggestionsUseCase.RequestValues, Flowable<List<DishDisplayModel>>> mItemSuggestionsUseCase;
    @NotNull
    private final BaseSchedulerProvider mSchedulerProvider;
    @NotNull
    private final UseCaseHandler mUseCaseHandler;
    @NotNull
    private final UseCase<GetVendorsInfoUseCase.RequestValues, Flowable<VendorInfo>> mVendorInfoUseCase;
    @NotNull
    private final UseCase<GetVendorsUseCase.RequestValues, Flowable<List<VendorDisplayModel>>> mVendorUseCase;
    @NotNull
    private final Lazy showDishesSeeMore$delegate;
    @NotNull
    private final Lazy showDishesSuggestions$delegate;
    @NotNull
    private final Lazy showVendorsSeeMore$delegate;
    @NotNull
    private final Lazy showVendorsSuggestions$delegate;
    @NotNull
    private final Lazy vendorsSuggestionsList$delegate;

    public SuggestionsViewModel(@NotNull BaseSchedulerProvider baseSchedulerProvider, @NotNull UseCaseHandler useCaseHandler, @NotNull UseCase<GetVendorsUseCase.RequestValues, Flowable<List<VendorDisplayModel>>> useCase, @NotNull UseCase<GetVendorsInfoUseCase.RequestValues, Flowable<VendorInfo>> useCase2, @NotNull UseCase<GlobalSearchUseCase.RequestValues, Flowable<List<RestaurantsSearchResponse>>> useCase3, @NotNull UseCase<GetBranchesIdUseCase.RequestValues, Flowable<String>> useCase4, @NotNull UseCase<ItemsSuggestionsUseCase.RequestValues, Flowable<List<DishDisplayModel>>> useCase5, @NotNull UseCase<GetVendorJsonByIdUseCase.RequestValues, String> useCase6) {
        Intrinsics.checkNotNullParameter(baseSchedulerProvider, "mSchedulerProvider");
        Intrinsics.checkNotNullParameter(useCaseHandler, "mUseCaseHandler");
        Intrinsics.checkNotNullParameter(useCase, "mVendorUseCase");
        Intrinsics.checkNotNullParameter(useCase2, "mVendorInfoUseCase");
        Intrinsics.checkNotNullParameter(useCase3, "mGlobalSearchUseCase");
        Intrinsics.checkNotNullParameter(useCase4, "mBranchesIdUseCase");
        Intrinsics.checkNotNullParameter(useCase5, "mItemSuggestionsUseCase");
        Intrinsics.checkNotNullParameter(useCase6, "mGetVendorJsonById");
        this.mSchedulerProvider = baseSchedulerProvider;
        this.mUseCaseHandler = useCaseHandler;
        this.mVendorUseCase = useCase;
        this.mVendorInfoUseCase = useCase2;
        this.mGlobalSearchUseCase = useCase3;
        this.mBranchesIdUseCase = useCase4;
        this.mItemSuggestionsUseCase = useCase5;
        this.mGetVendorJsonById = useCase6;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.showVendorsSuggestions$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, SuggestionsViewModel$showVendorsSuggestions$2.INSTANCE);
        this.showDishesSuggestions$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, SuggestionsViewModel$showDishesSuggestions$2.INSTANCE);
        this.showVendorsSeeMore$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, SuggestionsViewModel$showVendorsSeeMore$2.INSTANCE);
        this.showDishesSeeMore$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, SuggestionsViewModel$showDishesSeeMore$2.INSTANCE);
        this.vendorsSuggestionsList$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, SuggestionsViewModel$vendorsSuggestionsList$2.INSTANCE);
        this.dishesSuggestionsList$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, SuggestionsViewModel$dishesSuggestionsList$2.INSTANCE);
    }

    private final Flowable<List<DishDisplayModel>> buildWrapperClasses(List<VendorDisplayModel> list, List<RestaurantsSearchResponse> list2) {
        return (Flowable) this.mUseCaseHandler.execute(this.mItemSuggestionsUseCase, new ItemsSuggestionsUseCase.RequestValues(list, list2));
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
        return (Flowable) this.mUseCaseHandler.execute(this.mBranchesIdUseCase, new GetBranchesIdUseCase.RequestValues(list));
    }

    private final void getSuggestionsDishes(String str, String str2, int i11, String str3, String str4, int i12) {
        this.mCompositeDisposable.add(getVendorList(str, str2).map(new i(i12)).map(new j(this)).map(new k(this, str, str2, i11, str3, str4)).subscribeOn(this.mSchedulerProvider.io()).observeOn(this.mSchedulerProvider.ui()).subscribe(new l(this), new m()));
    }

    /* access modifiers changed from: private */
    /* renamed from: getSuggestionsDishes$lambda-1  reason: not valid java name */
    public static final List m10848getSuggestionsDishes$lambda1(int i11, List list) {
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
    /* renamed from: getSuggestionsDishes$lambda-2  reason: not valid java name */
    public static final Flowable m10849getSuggestionsDishes$lambda2(SuggestionsViewModel suggestionsViewModel, List list) {
        Intrinsics.checkNotNullParameter(suggestionsViewModel, "this$0");
        Intrinsics.checkNotNullParameter(list, "vendorList");
        return suggestionsViewModel.getBranchesId(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: getSuggestionsDishes$lambda-3  reason: not valid java name */
    public static final Flowable m10850getSuggestionsDishes$lambda3(SuggestionsViewModel suggestionsViewModel, String str, String str2, int i11, String str3, String str4, Flowable flowable) {
        Intrinsics.checkNotNullParameter(suggestionsViewModel, "this$0");
        Intrinsics.checkNotNullParameter(str, "$latitude");
        Intrinsics.checkNotNullParameter(str2, "$longitude");
        Intrinsics.checkNotNullParameter(str3, "$searchTerm");
        Intrinsics.checkNotNullParameter(str4, "$keyboardType");
        Intrinsics.checkNotNullParameter(flowable, "it");
        Object blockingFirst = flowable.blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "it.blockingFirst()");
        return suggestionsViewModel.mergeVendorsAndSearch(false, str, str2, i11, str3, (String) blockingFirst, str4);
    }

    /* access modifiers changed from: private */
    /* renamed from: getSuggestionsDishes$lambda-4  reason: not valid java name */
    public static final void m10851getSuggestionsDishes$lambda4(SuggestionsViewModel suggestionsViewModel, Flowable flowable) {
        Intrinsics.checkNotNullParameter(suggestionsViewModel, "this$0");
        List list = (List) flowable.blockingFirst();
        Intrinsics.checkNotNullExpressionValue(list, DefaultCardView.CARD_LIST);
        if (!list.isEmpty()) {
            MutableLiveData<Boolean> showDishesSuggestions = suggestionsViewModel.getShowDishesSuggestions();
            Boolean bool = Boolean.TRUE;
            showDishesSuggestions.setValue(bool);
            if (list.size() >= 5) {
                suggestionsViewModel.getShowDishesSeeMore().setValue(bool);
                suggestionsViewModel.getDishesSuggestionsList().setValue(list.subList(0, 5));
                return;
            }
            suggestionsViewModel.getDishesSuggestionsList().setValue(list);
            suggestionsViewModel.getShowDishesSeeMore().setValue(Boolean.FALSE);
            return;
        }
        suggestionsViewModel.getShowDishesSuggestions().setValue(Boolean.FALSE);
    }

    /* access modifiers changed from: private */
    /* renamed from: getSuggestionsDishes$lambda-5  reason: not valid java name */
    public static final void m10852getSuggestionsDishes$lambda5(Throwable th2) {
        String message = th2.getMessage();
        Intrinsics.checkNotNull(message);
        Log.e("grocery", message);
    }

    private final Flowable<List<VendorDisplayModel>> getVendorList(String str, String str2) {
        return (Flowable) this.mUseCaseHandler.execute(this.mVendorUseCase, new GetVendorsUseCase.RequestValues(false, str, str2));
    }

    private final Flowable<List<DishDisplayModel>> mergeVendorsAndSearch(boolean z11, String str, String str2, int i11, String str3, String str4, String str5) {
        Flowable<List<DishDisplayModel>> zip = Flowable.zip(callVendorApi(z11, str, str2), callVendorsInfoApi(false, 9, 2, 1), callSearchApi(i11, str3, str4, str5), new g(this));
        Intrinsics.checkNotNullExpressionValue(zip, "zip(\n            callVen…)\n            }\n        )");
        return zip;
    }

    /* access modifiers changed from: private */
    /* renamed from: mergeVendorsAndSearch$lambda-15  reason: not valid java name */
    public static final List m10853mergeVendorsAndSearch$lambda15(SuggestionsViewModel suggestionsViewModel, List list, VendorInfo vendorInfo, List list2) {
        Intrinsics.checkNotNullParameter(suggestionsViewModel, "this$0");
        Intrinsics.checkNotNullParameter(list, "t1");
        Intrinsics.checkNotNullParameter(vendorInfo, "t2");
        Intrinsics.checkNotNullParameter(list2, "t3");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            VendorDisplayModel vendorDisplayModel = (VendorDisplayModel) it.next();
            vendorDisplayModel.setBaseUrl(vendorInfo.getBaseUrl());
            vendorDisplayModel.setDecimalCount(vendorInfo.getDigitCount());
        }
        return suggestionsViewModel.buildWrapperClasses(list, list2).blockingFirst();
    }

    private final void searchVendorsLocally(String str, String str2, String str3, int i11, int i12, int i13, int i14) {
        this.mCompositeDisposable.add(Flowable.zip(callVendorApi(false, str2, str3), callVendorsInfoApi(false, i11, i12, i13), new n()).map(new o(i14)).map(new p(str)).subscribeOn(this.mSchedulerProvider.io()).observeOn(this.mSchedulerProvider.ui()).subscribe(new q(this), new h()));
    }

    /* access modifiers changed from: private */
    /* renamed from: searchVendorsLocally$lambda-11  reason: not valid java name */
    public static final List m10854searchVendorsLocally$lambda11(String str, List list) {
        Intrinsics.checkNotNullParameter(str, "$searchTerm");
        Intrinsics.checkNotNullParameter(list, "it");
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            String lowerCase = ((VendorDisplayModel) next).getVendorName().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            String lowerCase2 = str.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
            if (StringsKt__StringsJVMKt.startsWith$default(lowerCase, lowerCase2, false, 2, (Object) null)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: searchVendorsLocally$lambda-12  reason: not valid java name */
    public static final void m10855searchVendorsLocally$lambda12(SuggestionsViewModel suggestionsViewModel, List list) {
        Intrinsics.checkNotNullParameter(suggestionsViewModel, "this$0");
        Intrinsics.checkNotNullExpressionValue(list, "it");
        if (!list.isEmpty()) {
            MutableLiveData<Boolean> showVendorsSuggestions = suggestionsViewModel.getShowVendorsSuggestions();
            Boolean bool = Boolean.TRUE;
            showVendorsSuggestions.setValue(bool);
            if (list.size() >= 5) {
                suggestionsViewModel.getShowVendorsSeeMore().setValue(bool);
                suggestionsViewModel.getVendorsSuggestionsList().setValue(list.subList(0, 5));
                return;
            }
            suggestionsViewModel.getVendorsSuggestionsList().setValue(list);
            suggestionsViewModel.getShowVendorsSeeMore().setValue(Boolean.FALSE);
            return;
        }
        suggestionsViewModel.getShowVendorsSuggestions().setValue(Boolean.FALSE);
    }

    /* access modifiers changed from: private */
    /* renamed from: searchVendorsLocally$lambda-13  reason: not valid java name */
    public static final void m10856searchVendorsLocally$lambda13(Throwable th2) {
        String message = th2.getMessage();
        Intrinsics.checkNotNull(message);
        Log.e("grocery", message);
    }

    /* access modifiers changed from: private */
    /* renamed from: searchVendorsLocally$lambda-7  reason: not valid java name */
    public static final List m10857searchVendorsLocally$lambda7(List list, VendorInfo vendorInfo) {
        Intrinsics.checkNotNullParameter(list, "t1");
        Intrinsics.checkNotNullParameter(vendorInfo, "t2");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            VendorDisplayModel vendorDisplayModel = (VendorDisplayModel) it.next();
            vendorDisplayModel.setBaseUrl(vendorInfo.getBaseUrl());
            vendorDisplayModel.setDecimalCount(vendorInfo.getDigitCount());
        }
        return list;
    }

    /* access modifiers changed from: private */
    /* renamed from: searchVendorsLocally$lambda-9  reason: not valid java name */
    public static final List m10858searchVendorsLocally$lambda9(int i11, List list) {
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

    @NotNull
    public final MutableLiveData<List<DishDisplayModel>> getDishesSuggestionsList() {
        return (MutableLiveData) this.dishesSuggestionsList$delegate.getValue();
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowDishesSeeMore() {
        return (MutableLiveData) this.showDishesSeeMore$delegate.getValue();
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowDishesSuggestions() {
        return (MutableLiveData) this.showDishesSuggestions$delegate.getValue();
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowVendorsSeeMore() {
        return (MutableLiveData) this.showVendorsSeeMore$delegate.getValue();
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowVendorsSuggestions() {
        return (MutableLiveData) this.showVendorsSuggestions$delegate.getValue();
    }

    @NotNull
    public final String getVendorById(int i11) {
        return (String) this.mUseCaseHandler.execute(this.mGetVendorJsonById, new GetVendorJsonByIdUseCase.RequestValues(i11));
    }

    @NotNull
    public final MutableLiveData<List<VendorDisplayModel>> getVendorsSuggestionsList() {
        return (MutableLiveData) this.vendorsSuggestionsList$delegate.getValue();
    }

    public void onCleared() {
        this.mCompositeDisposable.dispose();
        super.onCleared();
    }

    public final void search(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, int i12, int i13, @NotNull String str4, int i14) {
        String str5 = str;
        Intrinsics.checkNotNullParameter(str, "latitude");
        String str6 = str2;
        Intrinsics.checkNotNullParameter(str2, "longitude");
        Intrinsics.checkNotNullParameter(str3, "searchTerm");
        Intrinsics.checkNotNullParameter(str4, "keyboardType");
        searchVendorsLocally(str3, str, str2, i11, i12, i13, i14);
        getSuggestionsDishes(str, str2, i13, str3, str4, i14);
    }
}
