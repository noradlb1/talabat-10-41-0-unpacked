package com.talabat.feature.pickup.data;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.feature.pickup.data.PickupApi;
import com.talabat.feature.pickup.data.entity.PickupSwimlaneDto;
import com.talabat.feature.pickup.data.entity.PickupVendorDto;
import com.talabat.feature.pickup.data.entity.PickupVendorDtoKt;
import com.talabat.feature.pickup.data.local.InMemoryDataSource;
import com.talabat.feature.pickup.domain.PickupRepository;
import com.talabat.feature.pickup.domain.entity.PickupSwimlane;
import com.talabat.feature.pickup.domain.entity.PickupVendor;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.feature.vendorTags.domain.RequestVendorTagsUseCase;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.VendorTagsResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pn.a;
import pn.b;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0001*B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ6\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00112\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u001cH\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0014H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\u0010\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020 H\u0016J\b\u0010)\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/talabat/feature/pickup/data/PickupRepositoryImpl;", "Lcom/talabat/feature/pickup/domain/PickupRepository;", "pickupApi", "Lcom/talabat/feature/pickup/data/PickupApi;", "schedulersFactory", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "vendorTagsUseCase", "Lcom/talabat/talabatcommon/feature/vendorTags/domain/RequestVendorTagsUseCase;", "prefs", "Lcom/talabat/feature/pickup/data/PickupSharedPreferences;", "localDataSource", "Lcom/talabat/feature/pickup/data/local/InMemoryDataSource;", "(Lcom/talabat/feature/pickup/data/PickupApi;Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/talabatcommon/feature/vendorTags/domain/RequestVendorTagsUseCase;Lcom/talabat/feature/pickup/data/PickupSharedPreferences;Lcom/talabat/feature/pickup/data/local/InMemoryDataSource;)V", "swimlanesObservable", "Lio/reactivex/subjects/PublishSubject;", "", "Lcom/talabat/feature/pickup/domain/entity/PickupSwimlane;", "getPickupVendors", "Lio/reactivex/Single;", "Lcom/talabat/feature/pickup/domain/entity/PickupVendor;", "kotlin.jvm.PlatformType", "pageNumber", "", "cuisineIds", "apiVersion", "getSwimlanes", "Lio/reactivex/Observable;", "getVendorTags", "Llibrary/talabat/com/talabatlib/VendorTagsResponse;", "incrementPickupVlScreenVisits", "", "incrementValuePropBannerVisits", "isFirstPickupOrder", "", "pickupVlScreenVisits", "postSwimlanes", "response", "Lcom/talabat/feature/pickup/data/entity/PickupVendorDto;", "setIsFirstPickupOrder", "valuePropBannerVisits", "Companion", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PickupRepositoryImpl implements PickupRepository {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int defaultVerticalId = 0;
    private static final int firstPageIndex = 1;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final InMemoryDataSource localDataSource;
    @NotNull
    private final PickupApi pickupApi;
    @NotNull
    private final PickupSharedPreferences prefs;
    @NotNull
    private final RxSchedulersFactory schedulersFactory;
    @NotNull
    private PublishSubject<List<PickupSwimlane>> swimlanesObservable;
    @NotNull
    private final RequestVendorTagsUseCase vendorTagsUseCase;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/pickup/data/PickupRepositoryImpl$Companion;", "", "()V", "defaultVerticalId", "", "firstPageIndex", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public PickupRepositoryImpl(@NotNull PickupApi pickupApi2, @NotNull RxSchedulersFactory rxSchedulersFactory, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull RequestVendorTagsUseCase requestVendorTagsUseCase, @NotNull PickupSharedPreferences pickupSharedPreferences, @NotNull InMemoryDataSource inMemoryDataSource) {
        Intrinsics.checkNotNullParameter(pickupApi2, "pickupApi");
        Intrinsics.checkNotNullParameter(rxSchedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(requestVendorTagsUseCase, "vendorTagsUseCase");
        Intrinsics.checkNotNullParameter(pickupSharedPreferences, "prefs");
        Intrinsics.checkNotNullParameter(inMemoryDataSource, "localDataSource");
        this.pickupApi = pickupApi2;
        this.schedulersFactory = rxSchedulersFactory;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.vendorTagsUseCase = requestVendorTagsUseCase;
        this.prefs = pickupSharedPreferences;
        this.localDataSource = inMemoryDataSource;
        PublishSubject<List<PickupSwimlane>> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create()");
        this.swimlanesObservable = create;
    }

    /* access modifiers changed from: private */
    /* renamed from: getPickupVendors$lambda-0  reason: not valid java name */
    public static final void m10242getPickupVendors$lambda0(PickupRepositoryImpl pickupRepositoryImpl, PickupVendorDto pickupVendorDto) {
        Intrinsics.checkNotNullParameter(pickupRepositoryImpl, "this$0");
        Intrinsics.checkNotNullExpressionValue(pickupVendorDto, "it");
        pickupRepositoryImpl.postSwimlanes(pickupVendorDto);
        pickupRepositoryImpl.localDataSource.setFirstPickupOrder(pickupVendorDto.isNewPickupCustomer());
    }

    /* access modifiers changed from: private */
    /* renamed from: getPickupVendors$lambda-1  reason: not valid java name */
    public static final PickupVendor m10243getPickupVendors$lambda1(PickupVendorDto pickupVendorDto) {
        Intrinsics.checkNotNullParameter(pickupVendorDto, "it");
        return PickupVendorDtoKt.toDomain(pickupVendorDto);
    }

    private final void postSwimlanes(PickupVendorDto pickupVendorDto) {
        List list;
        if (pickupVendorDto.getPageNumber() == 1) {
            Iterable swimlanes = pickupVendorDto.getSwimlanes();
            if (swimlanes != null) {
                Iterable<PickupSwimlaneDto> iterable = swimlanes;
                list = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
                for (PickupSwimlaneDto domain : iterable) {
                    list.add(PickupVendorDtoKt.toDomain(domain));
                }
            } else {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            this.swimlanesObservable.onNext(list);
            this.swimlanesObservable.onComplete();
        }
    }

    @NotNull
    public Single<PickupVendor> getPickupVendors(int i11, @Nullable List<Integer> list, int i12) {
        Single<PickupVendor> map = PickupApi.DefaultImpls.getPickupVendors$default(this.pickupApi, i12, this.configurationLocalRepository.selectedCountry().getTwoLetterCode(), String.valueOf(GlobalDataModel.RECENT_LATLONG.latitude), String.valueOf(GlobalDataModel.RECENT_LATLONG.longitude), (String) null, i11, list, 16, (Object) null).subscribeOn(this.schedulersFactory.io()).doOnSuccess(new a(this)).map(new b());
        Intrinsics.checkNotNullExpressionValue(map, "pickupApi.getPickupVendo…   .map { it.toDomain() }");
        return map;
    }

    @NotNull
    public Observable<List<PickupSwimlane>> getSwimlanes() {
        return this.swimlanesObservable;
    }

    @NotNull
    public Single<VendorTagsResponse> getVendorTags() {
        Single<VendorTagsResponse> subscribeOn = this.vendorTagsUseCase.invoke(String.valueOf(GlobalDataModel.RECENT_LATLONG.latitude), String.valueOf(GlobalDataModel.RECENT_LATLONG.longitude), (List<Integer>) CollectionsKt__CollectionsJVMKt.listOf(0), this.configurationLocalRepository.selectedCountry().getCountryId()).subscribeOn(this.schedulersFactory.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "vendorTagsUseCase.invoke…n(schedulersFactory.io())");
        return subscribeOn;
    }

    public void incrementPickupVlScreenVisits() {
        this.prefs.setPickupVlScreenVisits(this.prefs.getPickupVlScreenVisits() + 1);
    }

    public void incrementValuePropBannerVisits() {
        this.prefs.setValuePropBannerVisits(this.prefs.getValuePropBannerVisits() + 1);
    }

    public boolean isFirstPickupOrder() {
        return !this.prefs.getUserPlacedHisFirstOrder();
    }

    public int pickupVlScreenVisits() {
        return this.prefs.getPickupVlScreenVisits();
    }

    public void setIsFirstPickupOrder() {
        this.prefs.setUserPlacedHisFirstOrder(true);
    }

    public int valuePropBannerVisits() {
        return this.prefs.getValuePropBannerVisits();
    }
}
