package com.talabat.feature.tpro.presentation.helperview.mov;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.feature.subscriptions.domain.exception.ProNotEnabledFailure;
import com.talabat.feature.subscriptions.domain.model.ProVendorMov;
import com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/tpro/presentation/helperview/mov/VendorMovViewModel;", "Landroidx/lifecycle/ViewModel;", "getProMovUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetTProVendorMovUseCase;", "isNfvFlagEnabled", "Ljavax/inject/Provider;", "", "isTProUser", "tProPlanMov", "", "(Lcom/talabat/feature/subscriptions/domain/usecase/GetTProVendorMovUseCase;Ljavax/inject/Provider;ZF)V", "_failureLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "_vendorMovLiveData", "Lcom/talabat/feature/subscriptions/domain/model/ProVendorMov;", "failureLiveData", "Landroidx/lifecycle/LiveData;", "getFailureLiveData", "()Landroidx/lifecycle/LiveData;", "vendorMovLiveData", "getVendorMovLiveData", "loadVendorMov", "", "vendorId", "", "isProVendor", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorMovViewModel extends ViewModel {
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Throwable> _failureLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<ProVendorMov> _vendorMovLiveData;
    @NotNull
    private final LiveData<Throwable> failureLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final GetTProVendorMovUseCase getProMovUseCase;
    @NotNull
    private final Provider<Boolean> isNfvFlagEnabled;
    private final boolean isTProUser;
    private final float tProPlanMov;
    @NotNull
    private final LiveData<ProVendorMov> vendorMovLiveData;

    @Inject
    public VendorMovViewModel(@NotNull GetTProVendorMovUseCase getTProVendorMovUseCase, @NotNull @Named("isTproNfvEnabled") Provider<Boolean> provider, @Named("isTproUser") boolean z11, @Named("TProPlanMOV") float f11) {
        Intrinsics.checkNotNullParameter(getTProVendorMovUseCase, "getProMovUseCase");
        Intrinsics.checkNotNullParameter(provider, "isNfvFlagEnabled");
        this.getProMovUseCase = getTProVendorMovUseCase;
        this.isNfvFlagEnabled = provider;
        this.isTProUser = z11;
        this.tProPlanMov = f11;
        MutableLiveData<ProVendorMov> mutableLiveData = new MutableLiveData<>();
        this._vendorMovLiveData = mutableLiveData;
        MutableLiveData<Throwable> mutableLiveData2 = new MutableLiveData<>();
        this._failureLiveData = mutableLiveData2;
        this.vendorMovLiveData = mutableLiveData;
        this.failureLiveData = mutableLiveData2;
    }

    @NotNull
    public final LiveData<Throwable> getFailureLiveData() {
        return this.failureLiveData;
    }

    @NotNull
    public final LiveData<ProVendorMov> getVendorMovLiveData() {
        return this.vendorMovLiveData;
    }

    public final void loadVendorMov(int i11, boolean z11) {
        if (!z11 || !this.isTProUser) {
            this._failureLiveData.postValue(new ProNotEnabledFailure());
            return;
        }
        Boolean bool = this.isNfvFlagEnabled.get();
        Intrinsics.checkNotNullExpressionValue(bool, "isNfvFlagEnabled.get()");
        if (bool.booleanValue()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new VendorMovViewModel$loadVendorMov$1(this, i11, (Continuation<? super VendorMovViewModel$loadVendorMov$1>) null), 3, (Object) null);
            return;
        }
        float f11 = this.tProPlanMov;
        if (f11 > 0.0f) {
            this._vendorMovLiveData.postValue(new ProVendorMov(Float.valueOf(f11), i11, true));
        } else {
            this._failureLiveData.postValue(new ProNotEnabledFailure());
        }
    }
}
