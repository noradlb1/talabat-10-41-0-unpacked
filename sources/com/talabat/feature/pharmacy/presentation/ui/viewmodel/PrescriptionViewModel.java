package com.talabat.feature.pharmacy.presentation.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import buisnessmodels.Customer;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QCommerceFeatureFlagsKeys;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.pharmacy.model.Banner;
import com.talabat.feature.pharmacy.model.BannerData;
import com.talabat.feature.pharmacy.model.PrescriptionPlacementStatus;
import com.talabat.feature.pharmacy.model.Vendor;
import com.talabat.feature.pharmacy.tracking.PrescriptionBannerClicked;
import com.talabat.feature.pharmacy.tracking.PrescriptionBannerLoaded;
import com.talabat.feature.pharmacy.tracking.PrescriptionStatusClicked;
import com.talabat.feature.pharmacy.tracking.PrescriptionStatusLoaded;
import com.talabat.feature.pharmacy.usecases.GetPrescriptionBannerDetailsUseCase;
import com.talabat.feature.pharmacy.usecases.PharmacyPrescriptionFailures;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.location.SelectedLocationProvider;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nn.a;
import nn.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020'H\u0014J\u0010\u0010\u0011\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010\u0013J\u0016\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,J\u0016\u0010.\u001a\u00020'2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,J\u0016\u0010/\u001a\u00020'2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,J\u0016\u00100\u001a\u00020'2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u0019\u0010\u0015R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001c\u0010\u0015R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0002¢\u0006\f\n\u0004\b \u0010\u0017\u001a\u0004\b\u001f\u0010\u0015R!\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0002¢\u0006\f\n\u0004\b#\u0010\u0017\u001a\u0004\b\"\u0010\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/talabat/feature/pharmacy/presentation/ui/viewmodel/PrescriptionViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "prescriptionBannerDetailsUseCase", "Lcom/talabat/feature/pharmacy/usecases/GetPrescriptionBannerDetailsUseCase;", "schedulersFactory", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "selectedLocationProvider", "Lcom/talabat/location/SelectedLocationProvider;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;Lcom/talabat/feature/pharmacy/usecases/GetPrescriptionBannerDetailsUseCase;Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;Lcom/talabat/location/SelectedLocationProvider;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "mDisposables", "Lio/reactivex/disposables/CompositeDisposable;", "onHavePrescriptionClicked", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/feature/pharmacy/model/BannerData;", "getOnHavePrescriptionClicked", "()Landroidx/lifecycle/MutableLiveData;", "onHavePrescriptionClicked$delegate", "Lkotlin/Lazy;", "showActiveOrderPrescription", "getShowActiveOrderPrescription", "showActiveOrderPrescription$delegate", "showPharmacyPrescription", "getShowPharmacyPrescription", "showPharmacyPrescription$delegate", "showPharmacyPrescriptionV2", "getShowPharmacyPrescriptionV2", "showPharmacyPrescriptionV2$delegate", "showWorkingHours", "getShowWorkingHours", "showWorkingHours$delegate", "isPharmacyWorkingHoursEnabled", "", "loadPrescriptionInfo", "", "onCleared", "details", "trackPrescriptionCardClicked", "chainId", "", "chainName", "trackPrescriptionCardLoaded", "trackPrescriptionStatusClicked", "trackPrescriptionStatusLoaded", "com_talabat_feature_pharmacy_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrescriptionViewModel extends BaseViewModel {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private CompositeDisposable mDisposables = new CompositeDisposable();
    @NotNull
    private final Lazy onHavePrescriptionClicked$delegate;
    @NotNull
    private final GetPrescriptionBannerDetailsUseCase prescriptionBannerDetailsUseCase;
    @NotNull
    private final RxSchedulersFactory schedulersFactory;
    @NotNull
    private final SelectedLocationProvider selectedLocationProvider;
    @NotNull
    private final Lazy showActiveOrderPrescription$delegate;
    @NotNull
    private final Lazy showPharmacyPrescription$delegate;
    @NotNull
    private final Lazy showPharmacyPrescriptionV2$delegate;
    @NotNull
    private final Lazy showWorkingHours$delegate;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;
    @NotNull
    private final TalabatTracker talabatTracker;

    public PrescriptionViewModel(@NotNull TalabatTracker talabatTracker2, @NotNull GetPrescriptionBannerDetailsUseCase getPrescriptionBannerDetailsUseCase, @NotNull RxSchedulersFactory rxSchedulersFactory, @NotNull SelectedLocationProvider selectedLocationProvider2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        Intrinsics.checkNotNullParameter(getPrescriptionBannerDetailsUseCase, "prescriptionBannerDetailsUseCase");
        Intrinsics.checkNotNullParameter(rxSchedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(selectedLocationProvider2, "selectedLocationProvider");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.talabatTracker = talabatTracker2;
        this.prescriptionBannerDetailsUseCase = getPrescriptionBannerDetailsUseCase;
        this.schedulersFactory = rxSchedulersFactory;
        this.selectedLocationProvider = selectedLocationProvider2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.configurationLocalRepository = configurationLocalRepository2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.showPharmacyPrescription$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, PrescriptionViewModel$showPharmacyPrescription$2.INSTANCE);
        this.showPharmacyPrescriptionV2$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, PrescriptionViewModel$showPharmacyPrescriptionV2$2.INSTANCE);
        this.showActiveOrderPrescription$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, PrescriptionViewModel$showActiveOrderPrescription$2.INSTANCE);
        this.onHavePrescriptionClicked$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, PrescriptionViewModel$onHavePrescriptionClicked$2.INSTANCE);
        this.showWorkingHours$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, PrescriptionViewModel$showWorkingHours$2.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadPrescriptionInfo$lambda-1  reason: not valid java name */
    public static final void m10239loadPrescriptionInfo$lambda1(PrescriptionViewModel prescriptionViewModel, BannerData bannerData) {
        Intrinsics.checkNotNullParameter(prescriptionViewModel, "this$0");
        if (Customer.getInstance().isLoggedIn()) {
            if (ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(prescriptionViewModel.talabatFeatureFlag, QCommerceFeatureFlagsKeys.QCOMMERCE_PHARMACY_NEW_BANNER, false, 2, (Object) null)) {
                prescriptionViewModel.getShowPharmacyPrescriptionV2().postValue(bannerData);
            } else {
                prescriptionViewModel.getShowPharmacyPrescription().postValue(bannerData);
            }
            if (bannerData.getActiveOrder() != null) {
                prescriptionViewModel.getShowActiveOrderPrescription().postValue(bannerData);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loadPrescriptionInfo$lambda-2  reason: not valid java name */
    public static final void m10240loadPrescriptionInfo$lambda2(PrescriptionViewModel prescriptionViewModel, Throwable th2) {
        Intrinsics.checkNotNullParameter(prescriptionViewModel, "this$0");
        prescriptionViewModel.handleFailure(PharmacyPrescriptionFailures.FailToLoadBannerInfo.INSTANCE);
    }

    @NotNull
    public final MutableLiveData<BannerData> getOnHavePrescriptionClicked() {
        return (MutableLiveData) this.onHavePrescriptionClicked$delegate.getValue();
    }

    @NotNull
    public final MutableLiveData<BannerData> getShowActiveOrderPrescription() {
        return (MutableLiveData) this.showActiveOrderPrescription$delegate.getValue();
    }

    @NotNull
    public final MutableLiveData<BannerData> getShowPharmacyPrescription() {
        return (MutableLiveData) this.showPharmacyPrescription$delegate.getValue();
    }

    @NotNull
    public final MutableLiveData<BannerData> getShowPharmacyPrescriptionV2() {
        return (MutableLiveData) this.showPharmacyPrescriptionV2$delegate.getValue();
    }

    @NotNull
    public final MutableLiveData<BannerData> getShowWorkingHours() {
        return (MutableLiveData) this.showWorkingHours$delegate.getValue();
    }

    public final boolean isPharmacyWorkingHoursEnabled() {
        return this.talabatFeatureFlag.getFeatureFlag(QCommerceFeatureFlagsKeys.QCOMMERCE_PHARMACY_WORKING_HOURS, false);
    }

    public final void loadPrescriptionInfo() {
        int i11 = GlobalDataModel.SelectedCityId;
        int i12 = GlobalDataModel.SelectedAreaId;
        this.mDisposables.add(this.prescriptionBannerDetailsUseCase.invoke(Integer.valueOf(i11), Integer.valueOf(this.configurationLocalRepository.selectedCountry().getCountryId()), Integer.valueOf(i12)).subscribeOn(this.schedulersFactory.io()).observeOn(this.schedulersFactory.main()).subscribe(new a(this), new b(this)));
    }

    public void onCleared() {
        super.onCleared();
        this.mDisposables.dispose();
    }

    public final void onHavePrescriptionClicked(@Nullable BannerData bannerData) {
        String str;
        Banner banner;
        PrescriptionPlacementStatus placementStatus;
        Vendor vendor;
        String chainName;
        Vendor vendor2;
        String str2 = "";
        if (bannerData == null || (vendor2 = bannerData.getVendor()) == null || (str = vendor2.getChainId()) == null) {
            str = str2;
        }
        if (!(bannerData == null || (vendor = bannerData.getVendor()) == null || (chainName = vendor.getChainName()) == null)) {
            str2 = chainName;
        }
        trackPrescriptionCardClicked(str, str2);
        if (isPharmacyWorkingHoursEnabled()) {
            boolean z11 = false;
            if (!(bannerData == null || (banner = bannerData.getBanner()) == null || (placementStatus = banner.getPlacementStatus()) == null || !placementStatus.getEnabled())) {
                z11 = true;
            }
            if (!z11) {
                getShowWorkingHours().postValue(bannerData);
                return;
            }
        }
        getOnHavePrescriptionClicked().postValue(bannerData);
    }

    public final void trackPrescriptionCardClicked(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "chainId");
        Intrinsics.checkNotNullParameter(str2, "chainName");
        this.talabatTracker.track(new PrescriptionBannerClicked(str, str2));
    }

    public final void trackPrescriptionCardLoaded(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "chainId");
        Intrinsics.checkNotNullParameter(str2, "chainName");
        this.talabatTracker.track(new PrescriptionBannerLoaded(str, str2));
    }

    public final void trackPrescriptionStatusClicked(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "chainId");
        Intrinsics.checkNotNullParameter(str2, "chainName");
        this.talabatTracker.track(new PrescriptionStatusClicked(str, str2));
    }

    public final void trackPrescriptionStatusLoaded(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "chainId");
        Intrinsics.checkNotNullParameter(str2, "chainName");
        this.talabatTracker.track(new PrescriptionStatusLoaded(str, str2));
    }
}
