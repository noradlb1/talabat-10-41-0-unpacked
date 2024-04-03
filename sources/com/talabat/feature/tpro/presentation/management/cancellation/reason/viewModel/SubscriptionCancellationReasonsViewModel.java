package com.talabat.feature.tpro.presentation.management.cancellation.reason.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment;
import com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationReason;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionCancellationReasonsUseCase;
import com.talabat.feature.subscriptions.domain.usecase.SendCancellationFeedbackUseCase;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001a\u001a\u00020\u001bJ$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0!J\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\fR\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00108F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00108F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012¨\u0006$"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/cancellation/reason/viewModel/SubscriptionCancellationReasonsViewModel;", "Landroidx/lifecycle/ViewModel;", "getSubscriptionCancellationReasonsUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionCancellationReasonsUseCase;", "sendCancellationFeedbackUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/SendCancellationFeedbackUseCase;", "(Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionCancellationReasonsUseCase;Lcom/talabat/feature/subscriptions/domain/usecase/SendCancellationFeedbackUseCase;)V", "_reasonsData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionCancellationReason;", "_selectedItem", "", "_showOtherInput", "", "reasonsData", "Landroidx/lifecycle/LiveData;", "getReasonsData", "()Landroidx/lifecycle/LiveData;", "selectedItem", "getSelectedItem", "selectedReason", "getSelectedReason", "()Lcom/talabat/feature/subscriptions/domain/model/SubscriptionCancellationReason;", "showOtherInput", "getShowOtherInput", "loadReasons", "", "sendCancellationReason", "planId", "", "other", "onSuccess", "Lkotlin/Function0;", "setSelectedIndex", "index", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionCancellationReasonsViewModel extends ViewModel {
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<List<SubscriptionCancellationReason>> _reasonsData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<Integer> _selectedItem = new MutableLiveData<>(null);
    @NotNull
    private final MutableLiveData<Boolean> _showOtherInput = new MutableLiveData<>(Boolean.FALSE);
    /* access modifiers changed from: private */
    @NotNull
    public final GetSubscriptionCancellationReasonsUseCase getSubscriptionCancellationReasonsUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final SendCancellationFeedbackUseCase sendCancellationFeedbackUseCase;

    @Inject
    public SubscriptionCancellationReasonsViewModel(@NotNull GetSubscriptionCancellationReasonsUseCase getSubscriptionCancellationReasonsUseCase2, @NotNull SendCancellationFeedbackUseCase sendCancellationFeedbackUseCase2) {
        Intrinsics.checkNotNullParameter(getSubscriptionCancellationReasonsUseCase2, "getSubscriptionCancellationReasonsUseCase");
        Intrinsics.checkNotNullParameter(sendCancellationFeedbackUseCase2, "sendCancellationFeedbackUseCase");
        this.getSubscriptionCancellationReasonsUseCase = getSubscriptionCancellationReasonsUseCase2;
        this.sendCancellationFeedbackUseCase = sendCancellationFeedbackUseCase2;
    }

    private final SubscriptionCancellationReason getSelectedReason() {
        List value;
        Integer value2 = this._selectedItem.getValue();
        if (value2 == null || (value = this._reasonsData.getValue()) == null) {
            return null;
        }
        return (SubscriptionCancellationReason) value.get(value2.intValue());
    }

    @NotNull
    public final LiveData<List<SubscriptionCancellationReason>> getReasonsData() {
        return this._reasonsData;
    }

    @NotNull
    public final LiveData<Integer> getSelectedItem() {
        return this._selectedItem;
    }

    @NotNull
    public final LiveData<Boolean> getShowOtherInput() {
        return this._showOtherInput;
    }

    public final void loadReasons() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SubscriptionCancellationReasonsViewModel$loadReasons$1(this, (Continuation<? super SubscriptionCancellationReasonsViewModel$loadReasons$1>) null), 3, (Object) null);
    }

    public final void sendCancellationReason(@NotNull String str, @NotNull String str2, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        Intrinsics.checkNotNullParameter(str2, "other");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        SubscriptionCancellationReason selectedReason = getSelectedReason();
        if (selectedReason != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SubscriptionCancellationReasonsViewModel$sendCancellationReason$1$1(this, selectedReason, str, str2, function0, (Continuation<? super SubscriptionCancellationReasonsViewModel$sendCancellationReason$1$1>) null), 3, (Object) null);
        }
    }

    public final void setSelectedIndex(int i11) {
        this._selectedItem.postValue(Integer.valueOf(i11));
        MutableLiveData<Boolean> mutableLiveData = this._showOtherInput;
        List value = this._reasonsData.getValue();
        boolean z11 = false;
        if (value != null && i11 == CollectionsKt__CollectionsKt.getLastIndex(value)) {
            z11 = true;
        }
        mutableLiveData.postValue(Boolean.valueOf(z11));
    }
}
