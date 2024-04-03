package com.talabat.feature.helpcenter.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterEventTracker;
import com.talabat.feature.cancellationpolicy.domain.model.CancellationPolicyEvent;
import com.talabat.feature.cancellationpolicy.domain.model.CancellationPolicyEventKt;
import com.talabat.feature.cancellationpolicy.domain.repo.ICancellationPolicyRepository;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.SingleLiveEvent;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyViewModel;", "Landroidx/lifecycle/ViewModel;", "cancellationPolicyRepository", "Lcom/talabat/feature/cancellationpolicy/domain/repo/ICancellationPolicyRepository;", "cancellationPolicyItemDisplayMapper", "Lcom/talabat/feature/helpcenter/presentation/ICancellationPolicyItemDisplayMapper;", "helpCenterEventTracker", "Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterEventTracker;", "(Lcom/talabat/feature/cancellationpolicy/domain/repo/ICancellationPolicyRepository;Lcom/talabat/feature/helpcenter/presentation/ICancellationPolicyItemDisplayMapper;Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterEventTracker;)V", "_cancellationPolicyContent", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/SingleLiveEvent;", "Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyDisplayModel;", "cancellationPolicyContent", "Landroidx/lifecycle/LiveData;", "getCancellationPolicyContent", "()Landroidx/lifecycle/LiveData;", "cancellationPolicyClicked", "", "cancellationPolicyShown", "checkIfCancellationPolicyIsEnabled", "com_talabat_feature_helpcenter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CancellationPolicyViewModel extends ViewModel {
    /* access modifiers changed from: private */
    @NotNull
    public final SingleLiveEvent<CancellationPolicyDisplayModel> _cancellationPolicyContent;
    @NotNull
    private final LiveData<CancellationPolicyDisplayModel> cancellationPolicyContent;
    /* access modifiers changed from: private */
    @NotNull
    public final ICancellationPolicyItemDisplayMapper cancellationPolicyItemDisplayMapper;
    /* access modifiers changed from: private */
    @NotNull
    public final ICancellationPolicyRepository cancellationPolicyRepository;
    @NotNull
    private final IHelpCenterEventTracker helpCenterEventTracker;

    @Inject
    public CancellationPolicyViewModel(@NotNull ICancellationPolicyRepository iCancellationPolicyRepository, @NotNull ICancellationPolicyItemDisplayMapper iCancellationPolicyItemDisplayMapper, @NotNull IHelpCenterEventTracker iHelpCenterEventTracker) {
        Intrinsics.checkNotNullParameter(iCancellationPolicyRepository, "cancellationPolicyRepository");
        Intrinsics.checkNotNullParameter(iCancellationPolicyItemDisplayMapper, "cancellationPolicyItemDisplayMapper");
        Intrinsics.checkNotNullParameter(iHelpCenterEventTracker, "helpCenterEventTracker");
        this.cancellationPolicyRepository = iCancellationPolicyRepository;
        this.cancellationPolicyItemDisplayMapper = iCancellationPolicyItemDisplayMapper;
        this.helpCenterEventTracker = iHelpCenterEventTracker;
        SingleLiveEvent<CancellationPolicyDisplayModel> singleLiveEvent = new SingleLiveEvent<>();
        this._cancellationPolicyContent = singleLiveEvent;
        this.cancellationPolicyContent = singleLiveEvent;
    }

    public final void cancellationPolicyClicked() {
        this.helpCenterEventTracker.cancellationPolicyClicked(new CancellationPolicyEvent(CancellationPolicyEventKt.CANCELLATION_MESSAGE_CLICKED));
    }

    public final void cancellationPolicyShown() {
        this.helpCenterEventTracker.cancellationPolicyShown(new CancellationPolicyEvent(CancellationPolicyEventKt.CANCELLATION_MESSAGE_SHOWN));
    }

    public final void checkIfCancellationPolicyIsEnabled() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new CancellationPolicyViewModel$checkIfCancellationPolicyIsEnabled$1(this, (Continuation<? super CancellationPolicyViewModel$checkIfCancellationPolicyIsEnabled$1>) null), 3, (Object) null);
    }

    @NotNull
    public final LiveData<CancellationPolicyDisplayModel> getCancellationPolicyContent() {
        return this.cancellationPolicyContent;
    }
}
