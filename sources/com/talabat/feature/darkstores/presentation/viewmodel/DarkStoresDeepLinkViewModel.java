package com.talabat.feature.darkstores.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.feature.darkstores.domain.repository.DarkstoresRepository;
import com.talabat.feature.darkstores.presentation.viewstate.DarkStoreViewState;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.Restaurant;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\u0016\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tR\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006#"}, d2 = {"Lcom/talabat/feature/darkstores/presentation/viewmodel/DarkStoresDeepLinkViewModel;", "Landroidx/lifecycle/ViewModel;", "darkStoresRepository", "Lcom/talabat/feature/darkstores/domain/repository/DarkstoresRepository;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/feature/darkstores/domain/repository/DarkstoresRepository;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "_darkStoreErrorLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "_darkStoreViewStateLiveData", "Lcom/talabat/feature/darkstores/presentation/viewstate/DarkStoreViewState;", "_isValidVendorLiveData", "darkStoreErrorLiveData", "Landroidx/lifecycle/LiveData;", "getDarkStoreErrorLiveData", "()Landroidx/lifecycle/LiveData;", "darkStoreViewStateLiveData", "getDarkStoreViewStateLiveData", "isValidVendorLiveData", "fetchDarkStoreInfo", "", "fetchMigratedVendorInfo", "branchId", "", "hideLoading", "navigateToDarkStore", "restaurant", "Ldatamodels/Restaurant;", "showErrorMessage", "showLoading", "validateIfValidVendor", "isDarkStore", "isMigrated", "com_talabat_feature_darkstores_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkStoresDeepLinkViewModel extends ViewModel {
    @NotNull
    private final MutableLiveData<Boolean> _darkStoreErrorLiveData;
    @NotNull
    private final MutableLiveData<DarkStoreViewState> _darkStoreViewStateLiveData;
    @NotNull
    private final MutableLiveData<Boolean> _isValidVendorLiveData;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final LiveData<Boolean> darkStoreErrorLiveData;
    @NotNull
    private final LiveData<DarkStoreViewState> darkStoreViewStateLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final DarkstoresRepository darkStoresRepository;
    @NotNull
    private final LiveData<Boolean> isValidVendorLiveData;

    @Inject
    public DarkStoresDeepLinkViewModel(@NotNull DarkstoresRepository darkstoresRepository, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(darkstoresRepository, "darkStoresRepository");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.darkStoresRepository = darkstoresRepository;
        this.configurationLocalRepository = configurationLocalRepository2;
        Boolean bool = Boolean.FALSE;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(bool);
        this._isValidVendorLiveData = mutableLiveData;
        this.isValidVendorLiveData = mutableLiveData;
        MutableLiveData<DarkStoreViewState> mutableLiveData2 = new MutableLiveData<>(DarkStoreViewState.Hidden.INSTANCE);
        this._darkStoreViewStateLiveData = mutableLiveData2;
        this.darkStoreViewStateLiveData = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>(bool);
        this._darkStoreErrorLiveData = mutableLiveData3;
        this.darkStoreErrorLiveData = mutableLiveData3;
    }

    /* access modifiers changed from: private */
    public final void hideLoading() {
        this._darkStoreViewStateLiveData.setValue(DarkStoreViewState.Hidden.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final void navigateToDarkStore(Restaurant restaurant) {
        this._darkStoreViewStateLiveData.postValue(new DarkStoreViewState.Navigating(restaurant, this.configurationLocalRepository.selectedCountry().getCountryId()));
    }

    /* access modifiers changed from: private */
    public final void showErrorMessage() {
        this._darkStoreErrorLiveData.setValue(Boolean.TRUE);
    }

    /* access modifiers changed from: private */
    public final void showLoading() {
        this._darkStoreViewStateLiveData.setValue(DarkStoreViewState.Loading.INSTANCE);
    }

    public final void fetchDarkStoreInfo() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new DarkStoresDeepLinkViewModel$fetchDarkStoreInfo$1(this, (Continuation<? super DarkStoresDeepLinkViewModel$fetchDarkStoreInfo$1>) null), 3, (Object) null);
    }

    public final void fetchMigratedVendorInfo(@Nullable String str) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new DarkStoresDeepLinkViewModel$fetchMigratedVendorInfo$1(this, str, (Continuation<? super DarkStoresDeepLinkViewModel$fetchMigratedVendorInfo$1>) null), 3, (Object) null);
    }

    @NotNull
    public final LiveData<Boolean> getDarkStoreErrorLiveData() {
        return this.darkStoreErrorLiveData;
    }

    @NotNull
    public final LiveData<DarkStoreViewState> getDarkStoreViewStateLiveData() {
        return this.darkStoreViewStateLiveData;
    }

    @NotNull
    public final LiveData<Boolean> isValidVendorLiveData() {
        return this.isValidVendorLiveData;
    }

    public final void validateIfValidVendor(boolean z11, boolean z12) {
        boolean z13;
        if (z11 || z12) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (!z13) {
            LogManager.error$default((Throwable) null, "s in deeplink is not either ds or mv", 1, (Object) null);
            showErrorMessage();
        }
        this._isValidVendorLiveData.setValue(Boolean.valueOf(z13));
    }
}
