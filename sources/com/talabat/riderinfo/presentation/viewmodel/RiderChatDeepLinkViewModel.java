package com.talabat.riderinfo.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.riderinfo.domain.usecase.GetRiderInfo;
import com.talabat.riderinfo.domain.usecase.StartRiderChat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/riderinfo/presentation/viewmodel/RiderChatDeepLinkViewModel;", "Landroidx/lifecycle/ViewModel;", "getRiderInfo", "Lcom/talabat/riderinfo/domain/usecase/GetRiderInfo;", "startRiderChat", "Lcom/talabat/riderinfo/domain/usecase/StartRiderChat;", "(Lcom/talabat/riderinfo/domain/usecase/GetRiderInfo;Lcom/talabat/riderinfo/domain/usecase/StartRiderChat;)V", "_progressBarStatusLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "_riderChatErrorLiveData", "progressBarStatusLiveData", "Landroidx/lifecycle/LiveData;", "getProgressBarStatusLiveData", "()Landroidx/lifecycle/LiveData;", "riderChatErrorLiveData", "getRiderChatErrorLiveData", "hideLoading", "", "onCreate", "orderId", "", "showErrorMessage", "showLoading", "com_talabat_NewArchi_RiderInfo_RiderInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderChatDeepLinkViewModel extends ViewModel {
    @NotNull
    private final MutableLiveData<Boolean> _progressBarStatusLiveData;
    @NotNull
    private final MutableLiveData<Boolean> _riderChatErrorLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final GetRiderInfo getRiderInfo;
    @NotNull
    private final LiveData<Boolean> progressBarStatusLiveData;
    @NotNull
    private final LiveData<Boolean> riderChatErrorLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final StartRiderChat startRiderChat;

    public RiderChatDeepLinkViewModel(@NotNull GetRiderInfo getRiderInfo2, @NotNull StartRiderChat startRiderChat2) {
        Intrinsics.checkNotNullParameter(getRiderInfo2, "getRiderInfo");
        Intrinsics.checkNotNullParameter(startRiderChat2, "startRiderChat");
        this.getRiderInfo = getRiderInfo2;
        this.startRiderChat = startRiderChat2;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(Boolean.FALSE);
        this._riderChatErrorLiveData = mutableLiveData;
        this.riderChatErrorLiveData = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._progressBarStatusLiveData = mutableLiveData2;
        this.progressBarStatusLiveData = mutableLiveData2;
    }

    /* access modifiers changed from: private */
    public final void hideLoading() {
        this._progressBarStatusLiveData.setValue(Boolean.FALSE);
    }

    /* access modifiers changed from: private */
    public final void showErrorMessage() {
        this._riderChatErrorLiveData.setValue(Boolean.TRUE);
    }

    /* access modifiers changed from: private */
    public final void showLoading() {
        this._progressBarStatusLiveData.setValue(Boolean.TRUE);
    }

    @NotNull
    public final LiveData<Boolean> getProgressBarStatusLiveData() {
        return this.progressBarStatusLiveData;
    }

    @NotNull
    public final LiveData<Boolean> getRiderChatErrorLiveData() {
        return this.riderChatErrorLiveData;
    }

    public final void onCreate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new RiderChatDeepLinkViewModel$onCreate$1(this, str, (Continuation<? super RiderChatDeepLinkViewModel$onCreate$1>) null), 3, (Object) null);
    }
}
