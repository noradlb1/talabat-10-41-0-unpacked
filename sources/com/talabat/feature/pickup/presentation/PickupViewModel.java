package com.talabat.feature.pickup.presentation;

import android.util.SparseArray;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.InvalidatingPagingSourceFactory;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import buisnessmodels.FilterEngine;
import com.facebook.internal.security.CertificateUtil;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.fwfprojectskeys.domain.projects.vendorlist.VendorListRemoteConfigurationsKeys;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.pickup.data.events.PopupClicked;
import com.talabat.feature.pickup.data.events.PopupLoaded;
import com.talabat.feature.pickup.data.events.SearchBarClickedEvent;
import com.talabat.feature.pickup.data.events.ShopClickEvent;
import com.talabat.feature.pickup.data.events.braze.AppSearchedRestaurantEvent;
import com.talabat.feature.pickup.data.events.swimlanes.SwimlaneClickedEvent;
import com.talabat.feature.pickup.data.events.swimlanes.SwimlaneLoadedEvent;
import com.talabat.feature.pickup.data.events.swimlanes.SwimlanesTracking;
import com.talabat.feature.pickup.domain.GetPickupVendorsUseCase;
import com.talabat.feature.pickup.domain.entity.PickupSwimlane;
import com.talabat.feature.pickup.presentation.adapters.ValuePropBannerState;
import com.talabat.feature.pickup.presentation.entity.PickupConfig;
import com.talabat.feature.pickup.presentation.entity.SwimlaneHeaderView;
import com.talabat.feature.pickup.presentation.entity.SwimlaneHeaderViewKt;
import com.talabat.feature.pickup.presentation.provider.CreditProvider;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import datamodels.Cuisine;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rn.k;
import rn.l;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010$\u001a\u00020\u0011J\b\u0010%\u001a\u00020\u0015H\u0002J\u0006\u0010&\u001a\u00020\u0015J\u0016\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u0015J\u000e\u0010*\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u001bJ\u0006\u0010+\u001a\u00020\u0012J\u0018\u0010,\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u001b2\b\u0010-\u001a\u0004\u0018\u00010.J\b\u0010/\u001a\u000200H\u0007J\u001a\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b03022\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u00104\u001a\u00020\u0012J\u0006\u00105\u001a\u00020\u0015J\u0006\u00106\u001a\u00020\u0015J\u0006\u00107\u001a\u00020\u0015J\u0006\u00108\u001a\u00020\u0015J\u0010\u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020.H\u0002J\u000e\u0010;\u001a\u00020\u00122\u0006\u0010:\u001a\u00020.J\u000e\u0010<\u001a\u00020\u00122\u0006\u0010:\u001a\u00020.J\b\u0010=\u001a\u00020\"H\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0014¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018¨\u0006>"}, d2 = {"Lcom/talabat/feature/pickup/presentation/PickupViewModel;", "Landroidx/lifecycle/ViewModel;", "useCase", "Lcom/talabat/feature/pickup/domain/GetPickupVendorsUseCase;", "tracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "creditBalanceProvider", "Lcom/talabat/feature/pickup/presentation/provider/CreditProvider;", "configLocalRepo", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "remoteConfig", "Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;", "(Lcom/talabat/feature/pickup/domain/GetPickupVendorsUseCase;Lcom/talabat/core/tracking/domain/TalabatTracker;Lcom/talabat/feature/pickup/presentation/provider/CreditProvider;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;)V", "eventOrigin", "", "pageLoadedSuccess", "Lkotlin/Function1;", "", "", "scrollToTopLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getScrollToTopLiveData", "()Landroidx/lifecycle/MutableLiveData;", "source", "Landroidx/paging/InvalidatingPagingSourceFactory;", "Ldatamodels/Restaurant;", "swimlanesLiveData", "", "Lcom/talabat/feature/pickup/presentation/entity/SwimlaneHeaderView;", "getSwimlanesLiveData", "swimlanesViewCache", "valuePropBannerLiveData", "Lcom/talabat/feature/pickup/presentation/adapters/ValuePropBannerState;", "getValuePropBannerLiveData", "getTogglePercentage", "isCuisineFilterSelected", "isExistingPickupCustomer", "logPickupPopupClicked", "restaurant", "proceedWithPickup", "logPickupPopupLoaded", "logSearchBarClicked", "navigatingToVendorMenu", "swimlanesTracking", "Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlanesTracking;", "pickupConfig", "Lcom/talabat/feature/pickup/presentation/entity/PickupConfig;", "pickupPager", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "screenOpened", "shouldShowConfirmationPopup", "shouldShowSwimlanes", "shouldShowToggle", "shouldShowValuePropBanner", "trackSwimlanesClicked", "tracking", "trackSwimlanesLoaded", "trackSwimlanesSwiped", "valuePropBanner", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PickupViewModel extends ViewModel {
    @NotNull
    private final ConfigurationLocalRepository configLocalRepo;
    /* access modifiers changed from: private */
    @NotNull
    public final CreditProvider creditBalanceProvider;
    /* access modifiers changed from: private */
    @NotNull
    public String eventOrigin = "";
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<Integer, Unit> pageLoadedSuccess = new PickupViewModel$pageLoadedSuccess$1(this);
    @NotNull
    private final RemoteConfiguration remoteConfig;
    @NotNull
    private final MutableLiveData<Boolean> scrollToTopLiveData = new MutableLiveData<>(Boolean.FALSE);
    @NotNull
    private final InvalidatingPagingSourceFactory<Integer, Restaurant> source = new InvalidatingPagingSourceFactory<>(new PickupViewModel$source$1(this));
    @NotNull
    private final MutableLiveData<List<SwimlaneHeaderView>> swimlanesLiveData = new MutableLiveData<>(CollectionsKt__CollectionsKt.emptyList());
    /* access modifiers changed from: private */
    @NotNull
    public List<SwimlaneHeaderView> swimlanesViewCache = CollectionsKt__CollectionsKt.emptyList();
    /* access modifiers changed from: private */
    @NotNull
    public final TalabatTracker tracker;
    /* access modifiers changed from: private */
    @NotNull
    public final GetPickupVendorsUseCase useCase;
    @NotNull
    private final MutableLiveData<ValuePropBannerState> valuePropBannerLiveData = new MutableLiveData<>(ValuePropBannerState.Hidden.INSTANCE);

    @Inject
    public PickupViewModel(@NotNull GetPickupVendorsUseCase getPickupVendorsUseCase, @NotNull TalabatTracker talabatTracker, @NotNull CreditProvider creditProvider, @NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull RemoteConfiguration remoteConfiguration) {
        Intrinsics.checkNotNullParameter(getPickupVendorsUseCase, "useCase");
        Intrinsics.checkNotNullParameter(talabatTracker, "tracker");
        Intrinsics.checkNotNullParameter(creditProvider, "creditBalanceProvider");
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configLocalRepo");
        Intrinsics.checkNotNullParameter(remoteConfiguration, "remoteConfig");
        this.useCase = getPickupVendorsUseCase;
        this.tracker = talabatTracker;
        this.creditBalanceProvider = creditProvider;
        this.configLocalRepo = configurationLocalRepository;
        this.remoteConfig = remoteConfiguration;
    }

    /* access modifiers changed from: private */
    public final boolean isCuisineFilterSelected() {
        SparseArray<Cuisine> sparseArray;
        boolean z11;
        FilterEngine filterEngine = GlobalDataModel.filterEngine;
        if (filterEngine == null || (sparseArray = filterEngine.selectedCuisines) == null) {
            return false;
        }
        if (sparseArray.size() != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: screenOpened$lambda-3  reason: not valid java name */
    public static final void m10254screenOpened$lambda3(PickupViewModel pickupViewModel, List list) {
        Intrinsics.checkNotNullParameter(pickupViewModel, "this$0");
        Intrinsics.checkNotNullExpressionValue(list, "response");
        Iterable iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        int i11 = 0;
        int i12 = 0;
        for (Object next : iterable) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(i13 + CertificateUtil.DELIMITER + ((PickupSwimlane) next).getSlug());
            i12 = i13;
        }
        String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
        String joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(iterable, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, PickupViewModel$screenOpened$1$trackingStrategy$1.INSTANCE, 31, (Object) null);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Object next2 : iterable) {
            int i14 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            SwimlaneHeaderView view = SwimlaneHeaderViewKt.toView((PickupSwimlane) next2, joinToString$default, joinToString$default2, i11, list.size());
            pickupViewModel.trackSwimlanesLoaded(view.getTracking());
            arrayList2.add(view);
            i11 = i14;
        }
        pickupViewModel.swimlanesViewCache = arrayList2;
        pickupViewModel.swimlanesLiveData.postValue(arrayList2);
    }

    /* JADX WARNING: type inference failed for: r5v5, types: [java.lang.Object[], java.lang.Object] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: screenOpened$lambda-5  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m10255screenOpened$lambda5(library.talabat.com.talabatlib.VendorTagsResponse r5) {
        /*
            library.talabat.com.talabatlib.CuisinesContainer r0 = r5.getCuisines()
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x001c
            java.util.ArrayList r0 = r0.getAll()
            if (r0 == 0) goto L_0x001c
            datamodels.Cuisine[] r4 = new datamodels.Cuisine[r2]
            java.lang.Object[] r0 = r0.toArray(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            datamodels.Cuisine[] r0 = (datamodels.Cuisine[]) r0
            goto L_0x001d
        L_0x001c:
            r0 = r3
        L_0x001d:
            com.talabat.helpers.GlobalDataModel.cuisines = r0
            library.talabat.com.talabatlib.CuisinesContainer r5 = r5.getCuisines()
            if (r5 == 0) goto L_0x005c
            java.util.ArrayList r5 = r5.getPopular()
            if (r5 == 0) goto L_0x005c
            java.util.ArrayList r0 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r5, r3)
            r0.<init>(r3)
            java.util.Iterator r5 = r5.iterator()
        L_0x003a:
            boolean r3 = r5.hasNext()
            if (r3 == 0) goto L_0x0050
            java.lang.Object r3 = r5.next()
            datamodels.Cuisine r3 = (datamodels.Cuisine) r3
            int r3 = r3.f13848id
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.add(r3)
            goto L_0x003a
        L_0x0050:
            java.lang.Integer[] r5 = new java.lang.Integer[r2]
            java.lang.Object[] r5 = r0.toArray(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r1)
            r3 = r5
            java.lang.Integer[] r3 = (java.lang.Integer[]) r3
        L_0x005c:
            com.talabat.helpers.GlobalDataModel.popularCuisinesIds = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.pickup.presentation.PickupViewModel.m10255screenOpened$lambda5(library.talabat.com.talabatlib.VendorTagsResponse):void");
    }

    private final void trackSwimlanesClicked(SwimlanesTracking swimlanesTracking) {
        this.tracker.track(new SwimlaneClickedEvent(swimlanesTracking));
    }

    @NotNull
    public final MutableLiveData<Boolean> getScrollToTopLiveData() {
        return this.scrollToTopLiveData;
    }

    @NotNull
    public final MutableLiveData<List<SwimlaneHeaderView>> getSwimlanesLiveData() {
        return this.swimlanesLiveData;
    }

    public final int getTogglePercentage() {
        Integer togglePercentage = pickupConfig().getTogglePercentage();
        if (togglePercentage != null) {
            return togglePercentage.intValue();
        }
        return 15;
    }

    @NotNull
    public final MutableLiveData<ValuePropBannerState> getValuePropBannerLiveData() {
        return this.valuePropBannerLiveData;
    }

    public final boolean isExistingPickupCustomer() {
        return !this.useCase.isFirstPickupOrder();
    }

    public final void logPickupPopupClicked(@NotNull Restaurant restaurant, boolean z11) {
        Intrinsics.checkNotNullParameter(restaurant, "restaurant");
        this.tracker.track(new PopupClicked(restaurant, this.configLocalRepo.selectedCountry().getThreeLetterCode(), z11));
    }

    public final void logPickupPopupLoaded(@NotNull Restaurant restaurant) {
        Intrinsics.checkNotNullParameter(restaurant, "restaurant");
        this.useCase.incrementScreenVisits();
        this.tracker.track(new PopupLoaded(restaurant, this.configLocalRepo.selectedCountry().getThreeLetterCode()));
    }

    public final void logSearchBarClicked() {
        this.tracker.track(new SearchBarClickedEvent("pickup_vendor_list", "shop_list", "pickup_search"));
    }

    public final void navigatingToVendorMenu(@NotNull Restaurant restaurant, @Nullable SwimlanesTracking swimlanesTracking) {
        boolean z11;
        Intrinsics.checkNotNullParameter(restaurant, "restaurant");
        if (swimlanesTracking != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.useCase.incrementValuePropBannerVisits();
        this.tracker.track(new AppSearchedRestaurantEvent(restaurant));
        if (!z11) {
            this.tracker.track(new ShopClickEvent(restaurant, isCuisineFilterSelected()));
        } else if (swimlanesTracking != null) {
            trackSwimlanesClicked(swimlanesTracking);
        }
    }

    @NotNull
    @VisibleForTesting
    public final PickupConfig pickupConfig() {
        return (PickupConfig) this.remoteConfig.getRemoteConfiguration(VendorListRemoteConfigurationsKeys.PICKUP_VL_CONFIG, new PickupConfig((Integer) null, false, (String) null, false, false, false, (Map) null, 127, (DefaultConstructorMarker) null), PickupConfig.class);
    }

    @NotNull
    public final Flow<PagingData<Restaurant>> pickupPager(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "eventOrigin");
        this.eventOrigin = str;
        return CachedPagingDataKt.cachedIn(new Pager(new PagingConfig(10, 0, false, 0, 0, 0, 62, (DefaultConstructorMarker) null), null, this.source).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final void screenOpened() {
        this.useCase.getSwimlanes().subscribe(new k(this));
        this.useCase.vendorTags().subscribe(new l());
    }

    public final boolean shouldShowConfirmationPopup() {
        return this.useCase.shouldShowConfirmationPopup();
    }

    public final boolean shouldShowSwimlanes() {
        return !isCuisineFilterSelected();
    }

    public final boolean shouldShowToggle() {
        return pickupConfig().getShouldShowToggle();
    }

    public final boolean shouldShowValuePropBanner() {
        return !Intrinsics.areEqual((Object) valuePropBanner(), (Object) ValuePropBannerState.Hidden.INSTANCE);
    }

    public final void trackSwimlanesLoaded(@NotNull SwimlanesTracking swimlanesTracking) {
        Intrinsics.checkNotNullParameter(swimlanesTracking, "tracking");
        this.tracker.track(new SwimlaneLoadedEvent(swimlanesTracking, false, 2, (DefaultConstructorMarker) null));
    }

    public final void trackSwimlanesSwiped(@NotNull SwimlanesTracking swimlanesTracking) {
        Intrinsics.checkNotNullParameter(swimlanesTracking, "tracking");
        this.tracker.track(new SwimlaneLoadedEvent(swimlanesTracking, true));
    }

    @NotNull
    @VisibleForTesting
    public final ValuePropBannerState valuePropBanner() {
        boolean z11;
        String str;
        PickupConfig pickupConfig = pickupConfig();
        if (!pickupConfig.getShouldShowValuePropBanner() || isCuisineFilterSelected()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11 || (!pickupConfig.getShowValuePropBannerForCampaign() && !this.useCase.isFirstPickupOrder())) {
            return ValuePropBannerState.Hidden.INSTANCE;
        }
        String isoCode = this.configLocalRepo.selectedLanguage().getIsoCode();
        Map<String, String> valuePropModelDescText = pickupConfig.getValuePropModelDescText();
        if (valuePropModelDescText != null) {
            str = valuePropModelDescText.get(isoCode);
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        return new ValuePropBannerState.Banner(str);
    }
}
