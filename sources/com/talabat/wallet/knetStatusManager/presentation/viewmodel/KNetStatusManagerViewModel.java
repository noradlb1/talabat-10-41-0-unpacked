package com.talabat.wallet.knetStatusManager.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import buisnessmodels.Cart;
import com.talabat.wallet.knetStatusManager.domain.business.usecase.GetKNetStatusUseCase;
import com.talabat.wallet.knetStatusManager.presentation.displaymodel.KNetStatusDisplayModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/talabat/wallet/knetStatusManager/presentation/viewmodel/KNetStatusManagerViewModel;", "Landroidx/lifecycle/ViewModel;", "getKNetStatus", "Lcom/talabat/wallet/knetStatusManager/domain/business/usecase/GetKNetStatusUseCase;", "(Lcom/talabat/wallet/knetStatusManager/domain/business/usecase/GetKNetStatusUseCase;)V", "kNetStatusDisplayModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/wallet/knetStatusManager/presentation/displaymodel/KNetStatusDisplayModel;", "getKNetStatusDisplayModel", "()Landroidx/lifecycle/MutableLiveData;", "onKNetStatusReceived", "", "cart", "Lbuisnessmodels/Cart;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class KNetStatusManagerViewModel extends ViewModel {
    /* access modifiers changed from: private */
    @NotNull
    public final GetKNetStatusUseCase getKNetStatus;
    @NotNull
    private final MutableLiveData<KNetStatusDisplayModel> kNetStatusDisplayModel = new MutableLiveData<>();

    public KNetStatusManagerViewModel(@NotNull GetKNetStatusUseCase getKNetStatusUseCase) {
        Intrinsics.checkNotNullParameter(getKNetStatusUseCase, "getKNetStatus");
        this.getKNetStatus = getKNetStatusUseCase;
    }

    @NotNull
    public final MutableLiveData<KNetStatusDisplayModel> getKNetStatusDisplayModel() {
        return this.kNetStatusDisplayModel;
    }

    public final void onKNetStatusReceived(@Nullable Cart cart) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new KNetStatusManagerViewModel$onKNetStatusReceived$1(this, cart, (Continuation<? super KNetStatusManagerViewModel$onKNetStatusReceived$1>) null), 3, (Object) null);
    }
}
