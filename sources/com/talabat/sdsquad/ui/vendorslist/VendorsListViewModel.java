package com.talabat.sdsquad.ui.vendorslist;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.talabat.sdsquad.core.BaseSchedulerProvider;
import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.core.UseCaseHandler;
import com.talabat.sdsquad.data.darkstors.responses.DarkStoreResponse;
import com.talabat.sdsquad.data.swimlanes.responses.SwimLane;
import com.talabat.sdsquad.data.vendorslist.requests.VendorInfoRequest;
import com.talabat.sdsquad.data.vendorslist.response.SortTypes;
import com.talabat.sdsquad.domain.darkstores.AddDarkStoreUseCase;
import com.talabat.sdsquad.domain.darkstores.GetDarkStoreUseCase;
import com.talabat.sdsquad.domain.inlineds.GetInlineAdsUseCase;
import com.talabat.sdsquad.domain.inlineds.InsertInlineAdUseCase;
import com.talabat.sdsquad.domain.swimlanes.AddSwimlanesUseCase;
import com.talabat.sdsquad.domain.swimlanes.GetSwimlanesUseCase;
import com.talabat.sdsquad.domain.vendorslist.ApplyCuisineUseCase;
import com.talabat.sdsquad.domain.vendorslist.ApplyFiltersUseCase;
import com.talabat.sdsquad.domain.vendorslist.ApplySortUseCase;
import com.talabat.sdsquad.domain.vendorslist.GetActiveEventUseCase;
import com.talabat.sdsquad.domain.vendorslist.GetCollectionUseCase;
import com.talabat.sdsquad.domain.vendorslist.GetVendorJsonByIdUseCase;
import com.talabat.sdsquad.domain.vendorslist.GetVendorsInfoUseCase;
import com.talabat.sdsquad.domain.vendorslist.GetVendorsUseCase;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.ActiveEventDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.InlineAdDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.SwimlaneDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorCellType;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayWrapper;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorInfo;
import com.talabat.searchdiscovery.features.vendorslist.models.responses.Ad;
import com.talabat.talabatcore.logger.LogManager;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import nu.a0;
import nu.b0;
import nu.c0;
import nu.l;
import nu.m;
import nu.n;
import nu.o;
import nu.p;
import nu.q;
import nu.r;
import nu.s;
import nu.t;
import nu.u;
import nu.v;
import nu.w;
import nu.x;
import nu.y;
import nu.z;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B¥\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u0007\u0012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u0007\u0012\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007\u0012\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007\u0012\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007\u0012\u001e\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\t0\u0007\u0012\u001e\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u0019\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\n0\t0\u0007\u0012\u001e\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\u001c\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\t0\u0007\u0012\u001e\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u001e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\n0\t0\u0007\u0012\u001e\u0010 \u001a\u001a\u0012\u0004\u0012\u00020!\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\t0\u0007\u0012\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\t0\u0007\u0012\u0018\u0010%\u001a\u0014\u0012\u0004\u0012\u00020&\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\t0\u0007\u0012\u001e\u0010(\u001a\u001a\u0012\u0004\u0012\u00020)\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u0007\u0012\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0\u0007¢\u0006\u0002\u0010-J.\u0010I\u001a\b\u0012\u0004\u0012\u00020'0\t2\u0006\u0010J\u001a\u00020=2\u0006\u0010K\u001a\u0002072\u0006\u0010L\u001a\u00020,2\u0006\u0010M\u001a\u00020,H\u0002J4\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\n0\t2\u0006\u0010K\u001a\u0002072\u0006\u0010O\u001a\u0002072\u0006\u0010L\u001a\u00020,2\u0006\u0010M\u001a\u00020,H\u0002J,\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010J\u001a\u00020=2\u0006\u0010L\u001a\u00020,2\u0006\u0010M\u001a\u00020,H\u0002J.\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u0010J\u001a\u00020=2\u0006\u0010K\u001a\u0002072\u0006\u0010R\u001a\u0002072\u0006\u0010O\u001a\u000207H\u0002J\u0006\u0010S\u001a\u00020$J\u0006\u0010T\u001a\u000207J\u0016\u0010U\u001a\u0012\u0012\u0004\u0012\u00020709j\b\u0012\u0004\u0012\u000207`:J\u0006\u0010V\u001a\u000207J\u000e\u0010W\u001a\u00020,2\u0006\u0010X\u001a\u000207J6\u0010Y\u001a\u00020Z2\u0006\u0010J\u001a\u00020=2\u0006\u0010L\u001a\u00020,2\u0006\u0010M\u001a\u00020,2\u0006\u0010K\u001a\u0002072\u0006\u0010R\u001a\u0002072\u0006\u0010O\u001a\u000207J\u001e\u0010[\u001a\u00020Z2\u0006\u0010\\\u001a\u00020,2\u0006\u0010]\u001a\u00020,2\u0006\u0010^\u001a\u000207J\b\u0010_\u001a\u00020ZH\u0002J\b\u0010`\u001a\u00020ZH\u0014J\u000e\u0010a\u001a\u00020Z2\u0006\u0010b\u001a\u000207J\u001e\u0010c\u001a\u00020Z2\u0016\u0010d\u001a\u0012\u0012\u0004\u0012\u00020709j\b\u0012\u0004\u0012\u000207`:J\u000e\u0010e\u001a\u00020Z2\u0006\u0010f\u001a\u000207R'\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\n0/8FX\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b0\u00101R&\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\u001c\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007X\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007X\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0004¢\u0006\u0002\n\u0000R \u0010\"\u001a\u0014\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R \u0010%\u001a\u0014\u0012\u0004\u0012\u00020&\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R&\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u001e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\n0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u0019\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\n0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0\u0007X\u0004¢\u0006\u0002\n\u0000R&\u0010(\u001a\u001a\u0012\u0004\u0012\u00020)\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R&\u0010 \u001a\u001a\u0012\u0004\u0012\u00020!\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u000e¢\u0006\u0002\n\u0000R\u001e\u00108\u001a\u0012\u0012\u0004\u0012\u00020709j\b\u0012\u0004\u0012\u000207`:X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u000207X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u0007X\u0004¢\u0006\u0002\n\u0000R!\u0010<\u001a\b\u0012\u0004\u0012\u00020=0/8FX\u0002¢\u0006\f\n\u0004\b?\u00103\u001a\u0004\b>\u00101R!\u0010@\u001a\b\u0012\u0004\u0012\u00020=0/8FX\u0002¢\u0006\f\n\u0004\bB\u00103\u001a\u0004\bA\u00101R!\u0010C\u001a\b\u0012\u0004\u0012\u00020=0/8FX\u0002¢\u0006\f\n\u0004\bE\u00103\u001a\u0004\bD\u00101R'\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0/8FX\u0002¢\u0006\f\n\u0004\bH\u00103\u001a\u0004\bG\u00101¨\u0006g"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/VendorsListViewModel;", "Landroidx/lifecycle/ViewModel;", "mSchedulerProvider", "Lcom/talabat/sdsquad/core/BaseSchedulerProvider;", "mUseCaseHandler", "Lcom/talabat/sdsquad/core/UseCaseHandler;", "mVendorUseCase", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/vendorslist/GetVendorsUseCase$RequestValues;", "Lio/reactivex/Flowable;", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "mVendorInfoUseCase", "Lcom/talabat/sdsquad/domain/vendorslist/GetVendorsInfoUseCase$RequestValues;", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorInfo;", "mApplyFiltersUseCase", "Lcom/talabat/sdsquad/domain/vendorslist/ApplyFiltersUseCase$RequestValues;", "mApplySortUseCase", "Lcom/talabat/sdsquad/domain/vendorslist/ApplySortUseCase$RequestValues;", "mApplyCuisineUseCase", "Lcom/talabat/sdsquad/domain/vendorslist/ApplyCuisineUseCase$RequestValues;", "mGetCollectionsUseCase", "Lcom/talabat/sdsquad/domain/vendorslist/GetCollectionUseCase$RequestValues;", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayWrapper;", "mGetSwimalnesUseCase", "Lcom/talabat/sdsquad/domain/swimlanes/GetSwimlanesUseCase$RequestValues;", "Lcom/talabat/sdsquad/data/swimlanes/responses/SwimLane;", "mAddSwimlanesUseCase", "Lcom/talabat/sdsquad/domain/swimlanes/AddSwimlanesUseCase$RequestValues;", "mGetInlineAds", "Lcom/talabat/sdsquad/domain/inlineds/GetInlineAdsUseCase$RequestValues;", "Lcom/talabat/searchdiscovery/features/vendorslist/models/responses/Ad;", "mInsertInlineAdUseCase", "Lcom/talabat/sdsquad/domain/inlineds/InsertInlineAdUseCase$RequestValues;", "mGetActiveEventUseCase", "Lcom/talabat/sdsquad/domain/vendorslist/GetActiveEventUseCase$RequestValues;", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/ActiveEventDisplayModel;", "mGetDarkStoreUseCase", "Lcom/talabat/sdsquad/domain/darkstores/GetDarkStoreUseCase$RequestValues;", "Lcom/talabat/sdsquad/data/darkstors/responses/DarkStoreResponse;", "mInsertDarkStoreUseCase", "Lcom/talabat/sdsquad/domain/darkstores/AddDarkStoreUseCase$RequestValues;", "mGetVendorJsonById", "Lcom/talabat/sdsquad/domain/vendorslist/GetVendorJsonByIdUseCase$RequestValues;", "", "(Lcom/talabat/sdsquad/core/BaseSchedulerProvider;Lcom/talabat/sdsquad/core/UseCaseHandler;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase;)V", "inLineAdsResponse", "Landroidx/lifecycle/MutableLiveData;", "getInLineAdsResponse", "()Landroidx/lifecycle/MutableLiveData;", "inLineAdsResponse$delegate", "Lkotlin/Lazy;", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "mOnCuisineId", "", "mOnFiltersIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mOnSort", "showCuisineBubble", "", "getShowCuisineBubble", "showCuisineBubble$delegate", "showFilterBubble", "getShowFilterBubble", "showFilterBubble$delegate", "showLoading", "getShowLoading", "showLoading$delegate", "vendorsList", "getVendorsList", "vendorsList$delegate", "callDarkStore", "isForceUpdate", "areaId", "latitude", "longitude", "callSwimlanesApi", "countryId", "callVendorApi", "callVendorsInfoApi", "cityId", "getActiveEvent", "getAppliedCuisine", "getAppliedFilters", "getAppliedSort", "getVendorById", "id", "getVendors", "", "insertInlineAd", "link", "image", "position", "loadInlineAd", "onCleared", "setAppliedCuisine", "cuisineId", "setAppliedFilter", "appliedFilters", "setAppliedSort", "appliedSort", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsListViewModel extends ViewModel {
    @NotNull
    private final Lazy inLineAdsResponse$delegate;
    @NotNull
    private final UseCase<AddSwimlanesUseCase.RequestValues, Flowable<List<VendorDisplayWrapper>>> mAddSwimlanesUseCase;
    @NotNull
    private final UseCase<ApplyCuisineUseCase.RequestValues, List<VendorDisplayModel>> mApplyCuisineUseCase;
    @NotNull
    private final UseCase<ApplyFiltersUseCase.RequestValues, List<VendorDisplayModel>> mApplyFiltersUseCase;
    @NotNull
    private final UseCase<ApplySortUseCase.RequestValues, List<VendorDisplayModel>> mApplySortUseCase;
    @NotNull
    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    @NotNull
    private final UseCase<GetActiveEventUseCase.RequestValues, Flowable<ActiveEventDisplayModel>> mGetActiveEventUseCase;
    @NotNull
    private final UseCase<GetCollectionUseCase.RequestValues, Flowable<List<VendorDisplayWrapper>>> mGetCollectionsUseCase;
    @NotNull
    private final UseCase<GetDarkStoreUseCase.RequestValues, Flowable<DarkStoreResponse>> mGetDarkStoreUseCase;
    @NotNull
    private final UseCase<GetInlineAdsUseCase.RequestValues, Flowable<List<Ad>>> mGetInlineAds;
    @NotNull
    private final UseCase<GetSwimlanesUseCase.RequestValues, Flowable<List<SwimLane>>> mGetSwimalnesUseCase;
    @NotNull
    private final UseCase<GetVendorJsonByIdUseCase.RequestValues, String> mGetVendorJsonById;
    @NotNull
    private final UseCase<AddDarkStoreUseCase.RequestValues, Flowable<List<VendorDisplayModel>>> mInsertDarkStoreUseCase;
    @NotNull
    private final UseCase<InsertInlineAdUseCase.RequestValues, Flowable<List<VendorDisplayWrapper>>> mInsertInlineAdUseCase;
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
    private final Lazy showLoading$delegate;
    @NotNull
    private final Lazy vendorsList$delegate;

    public VendorsListViewModel(@NotNull BaseSchedulerProvider baseSchedulerProvider, @NotNull UseCaseHandler useCaseHandler, @NotNull UseCase<GetVendorsUseCase.RequestValues, Flowable<List<VendorDisplayModel>>> useCase, @NotNull UseCase<GetVendorsInfoUseCase.RequestValues, Flowable<VendorInfo>> useCase2, @NotNull UseCase<ApplyFiltersUseCase.RequestValues, List<VendorDisplayModel>> useCase3, @NotNull UseCase<ApplySortUseCase.RequestValues, List<VendorDisplayModel>> useCase4, @NotNull UseCase<ApplyCuisineUseCase.RequestValues, List<VendorDisplayModel>> useCase5, @NotNull UseCase<GetCollectionUseCase.RequestValues, Flowable<List<VendorDisplayWrapper>>> useCase6, @NotNull UseCase<GetSwimlanesUseCase.RequestValues, Flowable<List<SwimLane>>> useCase7, @NotNull UseCase<AddSwimlanesUseCase.RequestValues, Flowable<List<VendorDisplayWrapper>>> useCase8, @NotNull UseCase<GetInlineAdsUseCase.RequestValues, Flowable<List<Ad>>> useCase9, @NotNull UseCase<InsertInlineAdUseCase.RequestValues, Flowable<List<VendorDisplayWrapper>>> useCase10, @NotNull UseCase<GetActiveEventUseCase.RequestValues, Flowable<ActiveEventDisplayModel>> useCase11, @NotNull UseCase<GetDarkStoreUseCase.RequestValues, Flowable<DarkStoreResponse>> useCase12, @NotNull UseCase<AddDarkStoreUseCase.RequestValues, Flowable<List<VendorDisplayModel>>> useCase13, @NotNull UseCase<GetVendorJsonByIdUseCase.RequestValues, String> useCase14) {
        BaseSchedulerProvider baseSchedulerProvider2 = baseSchedulerProvider;
        UseCaseHandler useCaseHandler2 = useCaseHandler;
        UseCase<GetVendorsUseCase.RequestValues, Flowable<List<VendorDisplayModel>>> useCase15 = useCase;
        UseCase<GetVendorsInfoUseCase.RequestValues, Flowable<VendorInfo>> useCase16 = useCase2;
        UseCase<ApplyFiltersUseCase.RequestValues, List<VendorDisplayModel>> useCase17 = useCase3;
        UseCase<ApplySortUseCase.RequestValues, List<VendorDisplayModel>> useCase18 = useCase4;
        UseCase<ApplyCuisineUseCase.RequestValues, List<VendorDisplayModel>> useCase19 = useCase5;
        UseCase<GetCollectionUseCase.RequestValues, Flowable<List<VendorDisplayWrapper>>> useCase20 = useCase6;
        UseCase<GetSwimlanesUseCase.RequestValues, Flowable<List<SwimLane>>> useCase21 = useCase7;
        UseCase<AddSwimlanesUseCase.RequestValues, Flowable<List<VendorDisplayWrapper>>> useCase22 = useCase8;
        UseCase<GetInlineAdsUseCase.RequestValues, Flowable<List<Ad>>> useCase23 = useCase9;
        UseCase<InsertInlineAdUseCase.RequestValues, Flowable<List<VendorDisplayWrapper>>> useCase24 = useCase10;
        UseCase<GetActiveEventUseCase.RequestValues, Flowable<ActiveEventDisplayModel>> useCase25 = useCase11;
        UseCase<GetDarkStoreUseCase.RequestValues, Flowable<DarkStoreResponse>> useCase26 = useCase12;
        Intrinsics.checkNotNullParameter(baseSchedulerProvider2, "mSchedulerProvider");
        Intrinsics.checkNotNullParameter(useCaseHandler2, "mUseCaseHandler");
        Intrinsics.checkNotNullParameter(useCase15, "mVendorUseCase");
        Intrinsics.checkNotNullParameter(useCase16, "mVendorInfoUseCase");
        Intrinsics.checkNotNullParameter(useCase17, "mApplyFiltersUseCase");
        Intrinsics.checkNotNullParameter(useCase18, "mApplySortUseCase");
        Intrinsics.checkNotNullParameter(useCase19, "mApplyCuisineUseCase");
        Intrinsics.checkNotNullParameter(useCase20, "mGetCollectionsUseCase");
        Intrinsics.checkNotNullParameter(useCase21, "mGetSwimalnesUseCase");
        Intrinsics.checkNotNullParameter(useCase22, "mAddSwimlanesUseCase");
        Intrinsics.checkNotNullParameter(useCase23, "mGetInlineAds");
        Intrinsics.checkNotNullParameter(useCase24, "mInsertInlineAdUseCase");
        Intrinsics.checkNotNullParameter(useCase25, "mGetActiveEventUseCase");
        Intrinsics.checkNotNullParameter(useCase26, "mGetDarkStoreUseCase");
        Intrinsics.checkNotNullParameter(useCase13, "mInsertDarkStoreUseCase");
        UseCase<GetVendorJsonByIdUseCase.RequestValues, String> useCase27 = useCase14;
        Intrinsics.checkNotNullParameter(useCase27, "mGetVendorJsonById");
        this.mSchedulerProvider = baseSchedulerProvider2;
        this.mUseCaseHandler = useCaseHandler2;
        this.mVendorUseCase = useCase15;
        this.mVendorInfoUseCase = useCase16;
        this.mApplyFiltersUseCase = useCase17;
        this.mApplySortUseCase = useCase18;
        this.mApplyCuisineUseCase = useCase19;
        this.mGetCollectionsUseCase = useCase20;
        this.mGetSwimalnesUseCase = useCase21;
        this.mAddSwimlanesUseCase = useCase22;
        this.mGetInlineAds = useCase23;
        this.mInsertInlineAdUseCase = useCase24;
        this.mGetActiveEventUseCase = useCase25;
        this.mGetDarkStoreUseCase = useCase26;
        this.mInsertDarkStoreUseCase = useCase13;
        this.mGetVendorJsonById = useCase27;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.vendorsList$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, VendorsListViewModel$vendorsList$2.INSTANCE);
        this.showFilterBubble$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, VendorsListViewModel$showFilterBubble$2.INSTANCE);
        this.showCuisineBubble$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, VendorsListViewModel$showCuisineBubble$2.INSTANCE);
        this.inLineAdsResponse$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, VendorsListViewModel$inLineAdsResponse$2.INSTANCE);
        this.showLoading$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, VendorsListViewModel$showLoading$2.INSTANCE);
    }

    private final Flowable<DarkStoreResponse> callDarkStore(boolean z11, int i11, String str, String str2) {
        Flowable<DarkStoreResponse> subscribeOn = ((Flowable) this.mUseCaseHandler.execute(this.mGetDarkStoreUseCase, new GetDarkStoreUseCase.RequestValues(z11, i11, str, str2))).subscribeOn(this.mSchedulerProvider.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "mUseCaseHandler.execute(…(mSchedulerProvider.io())");
        return subscribeOn;
    }

    private final Flowable<List<SwimLane>> callSwimlanesApi(int i11, int i12, String str, String str2) {
        Flowable<List<SwimLane>> subscribeOn = ((Flowable) this.mUseCaseHandler.execute(this.mGetSwimalnesUseCase, new GetSwimlanesUseCase.RequestValues(true, str, str2, String.valueOf(i11), String.valueOf(i12)))).subscribeOn(this.mSchedulerProvider.io());
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
    public static final List m10871getVendors$lambda1(Ref.ObjectRef objectRef, Ref.IntRef intRef, List list, VendorInfo vendorInfo, List list2, DarkStoreResponse darkStoreResponse) {
        Intrinsics.checkNotNullParameter(objectRef, "$baseUrl");
        Intrinsics.checkNotNullParameter(intRef, "$decimalCount");
        Intrinsics.checkNotNullParameter(list, "t1");
        Intrinsics.checkNotNullParameter(vendorInfo, "t2");
        Intrinsics.checkNotNullParameter(list2, "<anonymous parameter 2>");
        Intrinsics.checkNotNullParameter(darkStoreResponse, "<anonymous parameter 3>");
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
    public static final void m10872getVendors$lambda10(VendorsListViewModel vendorsListViewModel, Subscription subscription) {
        Intrinsics.checkNotNullParameter(vendorsListViewModel, "this$0");
        vendorsListViewModel.getShowLoading().setValue(Boolean.TRUE);
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendors$lambda-11  reason: not valid java name */
    public static final void m10873getVendors$lambda11(VendorsListViewModel vendorsListViewModel, List list) {
        Intrinsics.checkNotNullParameter(vendorsListViewModel, "this$0");
        vendorsListViewModel.loadInlineAd();
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendors$lambda-12  reason: not valid java name */
    public static final void m10874getVendors$lambda12(VendorsListViewModel vendorsListViewModel, List list) {
        Intrinsics.checkNotNullParameter(vendorsListViewModel, "this$0");
        vendorsListViewModel.getShowLoading().setValue(Boolean.FALSE);
        vendorsListViewModel.getVendorsList().setValue(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendors$lambda-13  reason: not valid java name */
    public static final void m10875getVendors$lambda13(VendorsListViewModel vendorsListViewModel, Throwable th2) {
        Intrinsics.checkNotNullParameter(vendorsListViewModel, "this$0");
        vendorsListViewModel.getShowLoading().setValue(Boolean.FALSE);
        String message = th2.getMessage();
        Intrinsics.checkNotNull(message);
        StackTraceElement[] stackTrace = th2.getStackTrace();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(message);
        sb2.append(StringUtils.LF);
        sb2.append(stackTrace);
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendors$lambda-2  reason: not valid java name */
    public static final List m10876getVendors$lambda2(VendorsListViewModel vendorsListViewModel, Ref.ObjectRef objectRef, Ref.IntRef intRef, List list) {
        Intrinsics.checkNotNullParameter(vendorsListViewModel, "this$0");
        Intrinsics.checkNotNullParameter(objectRef, "$baseUrl");
        Intrinsics.checkNotNullParameter(intRef, "$decimalCount");
        Intrinsics.checkNotNullParameter(list, "it");
        return (List) ((Flowable) vendorsListViewModel.mUseCaseHandler.execute(vendorsListViewModel.mInsertDarkStoreUseCase, new AddDarkStoreUseCase.RequestValues(list, (String) objectRef.element, intRef.element))).blockingFirst();
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendors$lambda-3  reason: not valid java name */
    public static final List m10877getVendors$lambda3(VendorsListViewModel vendorsListViewModel, List list) {
        Intrinsics.checkNotNullParameter(vendorsListViewModel, "this$0");
        Intrinsics.checkNotNullParameter(list, "it");
        if (!vendorsListViewModel.mOnFiltersIds.isEmpty()) {
            return (List) vendorsListViewModel.mUseCaseHandler.execute(vendorsListViewModel.mApplyFiltersUseCase, new ApplyFiltersUseCase.RequestValues(list, vendorsListViewModel.mOnFiltersIds));
        }
        return list;
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendors$lambda-4  reason: not valid java name */
    public static final List m10878getVendors$lambda4(VendorsListViewModel vendorsListViewModel, List list) {
        Intrinsics.checkNotNullParameter(vendorsListViewModel, "this$0");
        Intrinsics.checkNotNullParameter(list, "it");
        return (List) vendorsListViewModel.mUseCaseHandler.execute(vendorsListViewModel.mApplyCuisineUseCase, new ApplyCuisineUseCase.RequestValues(list, vendorsListViewModel.mOnCuisineId));
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendors$lambda-5  reason: not valid java name */
    public static final List m10879getVendors$lambda5(VendorsListViewModel vendorsListViewModel, List list) {
        Intrinsics.checkNotNullParameter(vendorsListViewModel, "this$0");
        Intrinsics.checkNotNullParameter(list, "it");
        if (!list.isEmpty()) {
            return (List) vendorsListViewModel.mUseCaseHandler.execute(vendorsListViewModel.mApplySortUseCase, new ApplySortUseCase.RequestValues(list, vendorsListViewModel.mOnSort));
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendors$lambda-7  reason: not valid java name */
    public static final List m10880getVendors$lambda7(List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        if (!(!list.isEmpty())) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VendorDisplayWrapper(VendorCellType.ToggleHeader, (VendorDisplayModel) null, (List) null, (SwimlaneDisplayModel) null, (InlineAdDisplayModel) null, 28, (DefaultConstructorMarker) null));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new VendorDisplayWrapper(VendorCellType.Vendor, (VendorDisplayModel) it.next(), (List) null, (SwimlaneDisplayModel) null, (InlineAdDisplayModel) null, 28, (DefaultConstructorMarker) null));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendors$lambda-8  reason: not valid java name */
    public static final List m10881getVendors$lambda8(VendorsListViewModel vendorsListViewModel, Ref.ObjectRef objectRef, List list) {
        Intrinsics.checkNotNullParameter(vendorsListViewModel, "this$0");
        Intrinsics.checkNotNullParameter(objectRef, "$baseUrl");
        Intrinsics.checkNotNullParameter(list, "it");
        UseCaseHandler useCaseHandler = vendorsListViewModel.mUseCaseHandler;
        UseCase<AddSwimlanesUseCase.RequestValues, Flowable<List<VendorDisplayWrapper>>> useCase = vendorsListViewModel.mAddSwimlanesUseCase;
        String str = (String) objectRef.element;
        if (str == null) {
            str = "";
        }
        return (List) ((Flowable) useCaseHandler.execute(useCase, new AddSwimlanesUseCase.RequestValues(list, str))).blockingFirst();
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendors$lambda-9  reason: not valid java name */
    public static final List m10882getVendors$lambda9(VendorsListViewModel vendorsListViewModel, Ref.ObjectRef objectRef, List list) {
        Intrinsics.checkNotNullParameter(vendorsListViewModel, "this$0");
        Intrinsics.checkNotNullParameter(objectRef, "$baseUrl");
        Intrinsics.checkNotNullParameter(list, "it");
        UseCaseHandler useCaseHandler = vendorsListViewModel.mUseCaseHandler;
        UseCase<GetCollectionUseCase.RequestValues, Flowable<List<VendorDisplayWrapper>>> useCase = vendorsListViewModel.mGetCollectionsUseCase;
        String str = (String) objectRef.element;
        if (str == null) {
            str = "";
        }
        return (List) ((Flowable) useCaseHandler.execute(useCase, new GetCollectionUseCase.RequestValues(list, str))).blockingFirst();
    }

    /* access modifiers changed from: private */
    /* renamed from: insertInlineAd$lambda-16  reason: not valid java name */
    public static final void m10883insertInlineAd$lambda16(Throwable th2) {
    }

    /* access modifiers changed from: private */
    /* renamed from: insertInlineAd$lambda-17  reason: not valid java name */
    public static final void m10884insertInlineAd$lambda17(Subscriber subscriber) {
    }

    /* access modifiers changed from: private */
    /* renamed from: insertInlineAd$lambda-18  reason: not valid java name */
    public static final void m10885insertInlineAd$lambda18(VendorsListViewModel vendorsListViewModel, List list) {
        boolean z11;
        Intrinsics.checkNotNullParameter(vendorsListViewModel, "this$0");
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            vendorsListViewModel.getVendorsList().setValue(list);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: insertInlineAd$lambda-19  reason: not valid java name */
    public static final void m10886insertInlineAd$lambda19(Throwable th2) {
        String message = th2.getMessage();
        LogManager.logException(new Exception("inlineAd: " + message));
    }

    private final void loadInlineAd() {
        this.mCompositeDisposable.add(((Flowable) this.mUseCaseHandler.execute(this.mGetInlineAds, new GetInlineAdsUseCase.RequestValues(true, "1"))).subscribeOn(this.mSchedulerProvider.io()).observeOn(this.mSchedulerProvider.ui()).subscribe(new l(this), new u()));
    }

    /* access modifiers changed from: private */
    /* renamed from: loadInlineAd$lambda-14  reason: not valid java name */
    public static final void m10887loadInlineAd$lambda14(VendorsListViewModel vendorsListViewModel, List list) {
        Intrinsics.checkNotNullParameter(vendorsListViewModel, "this$0");
        vendorsListViewModel.getInLineAdsResponse().setValue(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadInlineAd$lambda-15  reason: not valid java name */
    public static final void m10888loadInlineAd$lambda15(Throwable th2) {
        String message = th2.getMessage();
        LogManager.logException(new Exception("grocery: " + message));
    }

    @NotNull
    public final ActiveEventDisplayModel getActiveEvent() {
        Object blockingFirst = ((Flowable) this.mUseCaseHandler.execute(this.mGetActiveEventUseCase, new GetActiveEventUseCase.RequestValues())).subscribeOn(this.mSchedulerProvider.io()).observeOn(this.mSchedulerProvider.ui()).blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "mUseCaseHandler.execute(…         .blockingFirst()");
        return (ActiveEventDisplayModel) blockingFirst;
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
    public final MutableLiveData<List<Ad>> getInLineAdsResponse() {
        return (MutableLiveData) this.inLineAdsResponse$delegate.getValue();
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
    public final MutableLiveData<Boolean> getShowLoading() {
        return (MutableLiveData) this.showLoading$delegate.getValue();
    }

    @NotNull
    public final String getVendorById(int i11) {
        return (String) this.mUseCaseHandler.execute(this.mGetVendorJsonById, new GetVendorJsonByIdUseCase.RequestValues(i11));
    }

    public final void getVendors(boolean z11, @NotNull String str, @NotNull String str2, int i11, int i12, int i13) {
        boolean z12;
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        Ref.IntRef intRef = new Ref.IntRef();
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
        this.mCompositeDisposable.add(Flowable.zip(callVendorApi(z11, str, str2), callVendorsInfoApi(z11, i11, i12, i13), callSwimlanesApi(i11, i13, str, str2), callDarkStore(z11, i11, str, str2), new z(objectRef, intRef)).map(new c0(this, objectRef, intRef)).map(new m(this)).map(new n(this)).map(new o(this)).map(new p()).map(new q(this, objectRef)).map(new r(this, objectRef)).doOnSubscribe(new s(this)).observeOn(this.mSchedulerProvider.ui()).doOnNext(new t(this)).subscribe(new a0(this), new b0(this)));
    }

    @NotNull
    public final MutableLiveData<List<VendorDisplayWrapper>> getVendorsList() {
        return (MutableLiveData) this.vendorsList$delegate.getValue();
    }

    public final void insertInlineAd(@NotNull String str, @NotNull String str2, int i11) {
        Intrinsics.checkNotNullParameter(str, "link");
        Intrinsics.checkNotNullParameter(str2, "image");
        this.mCompositeDisposable.add(((Flowable) this.mUseCaseHandler.execute(this.mInsertInlineAdUseCase, new InsertInlineAdUseCase.RequestValues(getVendorsList().getValue(), str, str2, i11))).subscribeOn(this.mSchedulerProvider.io()).observeOn(this.mSchedulerProvider.ui()).doOnError(new v()).onExceptionResumeNext(new w()).subscribe(new x(this), new y()));
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
