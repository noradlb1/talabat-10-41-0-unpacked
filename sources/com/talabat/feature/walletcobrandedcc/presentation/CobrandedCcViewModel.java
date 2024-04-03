package com.talabat.feature.walletcobrandedcc.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.walletcobrandedcc.domain.model.WalletStatus;
import com.talabat.feature.walletcobrandedcc.domain.usecase.GetWalletStatusUseCase;
import com.talabat.feature.walletcobrandedcc.domain.usecase.ShowCobrandedNotificationUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import vp.a;
import vp.b;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u000e\u001a\u00020\u0015R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/walletcobrandedcc/presentation/CobrandedCcViewModel;", "Landroidx/lifecycle/ViewModel;", "showCobrandedNotificationUseCase", "Lcom/talabat/feature/walletcobrandedcc/domain/usecase/ShowCobrandedNotificationUseCase;", "getWalletStatusUseCase", "Lcom/talabat/feature/walletcobrandedcc/domain/usecase/GetWalletStatusUseCase;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Lcom/talabat/feature/walletcobrandedcc/domain/usecase/ShowCobrandedNotificationUseCase;Lcom/talabat/feature/walletcobrandedcc/domain/usecase/GetWalletStatusUseCase;Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "_showCobrandedNotification", "Landroidx/lifecycle/MutableLiveData;", "", "_walletStatus", "Lcom/talabat/feature/walletcobrandedcc/domain/model/WalletStatus;", "showCobrandedNotification", "Landroidx/lifecycle/LiveData;", "getShowCobrandedNotification", "()Landroidx/lifecycle/LiveData;", "walletStatus", "getWalletStatus", "getCcPendingApplication", "", "com_talabat_feature_wallet-cobranded-cc_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CobrandedCcViewModel extends ViewModel {
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Boolean> _showCobrandedNotification;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<WalletStatus> _walletStatus;
    /* access modifiers changed from: private */
    @NotNull
    public final GetWalletStatusUseCase getWalletStatusUseCase;
    @NotNull
    private final LiveData<Boolean> showCobrandedNotification;
    /* access modifiers changed from: private */
    @NotNull
    public final ShowCobrandedNotificationUseCase showCobrandedNotificationUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final TalabatTracker talabatTracker;
    @NotNull
    private final LiveData<WalletStatus> walletStatus;

    @Inject
    public CobrandedCcViewModel(@NotNull ShowCobrandedNotificationUseCase showCobrandedNotificationUseCase2, @NotNull GetWalletStatusUseCase getWalletStatusUseCase2, @NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(showCobrandedNotificationUseCase2, "showCobrandedNotificationUseCase");
        Intrinsics.checkNotNullParameter(getWalletStatusUseCase2, "getWalletStatusUseCase");
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.showCobrandedNotificationUseCase = showCobrandedNotificationUseCase2;
        this.getWalletStatusUseCase = getWalletStatusUseCase2;
        this.talabatTracker = talabatTracker2;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._showCobrandedNotification = mutableLiveData;
        LiveData<Boolean> map = Transformations.map(mutableLiveData, new a());
        Intrinsics.checkNotNullExpressionValue(map, "map(_showCobrandedNotification) { return@map it }");
        this.showCobrandedNotification = map;
        MutableLiveData<WalletStatus> mutableLiveData2 = new MutableLiveData<>();
        this._walletStatus = mutableLiveData2;
        LiveData<WalletStatus> map2 = Transformations.map(mutableLiveData2, new b());
        Intrinsics.checkNotNullExpressionValue(map2, "map(_walletStatus) { return@map it }");
        this.walletStatus = map2;
    }

    /* access modifiers changed from: private */
    /* renamed from: showCobrandedNotification$lambda-0  reason: not valid java name */
    public static final Boolean m10432showCobrandedNotification$lambda0(Boolean bool) {
        return bool;
    }

    /* access modifiers changed from: private */
    /* renamed from: walletStatus$lambda-1  reason: not valid java name */
    public static final WalletStatus m10433walletStatus$lambda1(WalletStatus walletStatus2) {
        return walletStatus2;
    }

    public final void getCcPendingApplication() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new CobrandedCcViewModel$getCcPendingApplication$1(this, (Continuation<? super CobrandedCcViewModel$getCcPendingApplication$1>) null), 3, (Object) null);
    }

    @NotNull
    public final LiveData<Boolean> getShowCobrandedNotification() {
        return this.showCobrandedNotification;
    }

    @NotNull
    public final LiveData<WalletStatus> getWalletStatus() {
        return this.walletStatus;
    }

    public final void showCobrandedNotification() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new CobrandedCcViewModel$showCobrandedNotification$2(this, (Continuation<? super CobrandedCcViewModel$showCobrandedNotification$2>) null), 3, (Object) null);
    }
}
