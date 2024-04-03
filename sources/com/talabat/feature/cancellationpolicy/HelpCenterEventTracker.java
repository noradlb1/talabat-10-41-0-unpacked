package com.talabat.feature.cancellationpolicy;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterEventTracker;
import com.talabat.feature.cancellationpolicy.domain.model.CancellationPolicyEvent;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/feature/cancellationpolicy/HelpCenterEventTracker;", "Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterEventTracker;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "cancellationPolicyClicked", "", "cancellationPolicyEvent", "Lcom/talabat/feature/cancellationpolicy/domain/model/CancellationPolicyEvent;", "cancellationPolicyShown", "com_talabat_feature_helpcenter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HelpCenterEventTracker implements IHelpCenterEventTracker {
    @NotNull
    private final TalabatTracker talabatTracker;

    @Inject
    public HelpCenterEventTracker(@NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.talabatTracker = talabatTracker2;
    }

    public void cancellationPolicyClicked(@NotNull CancellationPolicyEvent cancellationPolicyEvent) {
        Intrinsics.checkNotNullParameter(cancellationPolicyEvent, "cancellationPolicyEvent");
        this.talabatTracker.track(cancellationPolicyEvent);
    }

    public void cancellationPolicyShown(@NotNull CancellationPolicyEvent cancellationPolicyEvent) {
        Intrinsics.checkNotNullParameter(cancellationPolicyEvent, "cancellationPolicyEvent");
        this.talabatTracker.track(cancellationPolicyEvent);
    }
}
