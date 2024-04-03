package pl;

import com.talabat.feature.bnplcore.domain.model.OverdueAcknowledgeState;
import com.talabat.feature.bnplcore.domain.usecase.impl.UpdateOverdueAcknowledgeStateUseCaseImpl;
import io.reactivex.functions.Action;

public final /* synthetic */ class c implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UpdateOverdueAcknowledgeStateUseCaseImpl f62789b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OverdueAcknowledgeState f62790c;

    public /* synthetic */ c(UpdateOverdueAcknowledgeStateUseCaseImpl updateOverdueAcknowledgeStateUseCaseImpl, OverdueAcknowledgeState overdueAcknowledgeState) {
        this.f62789b = updateOverdueAcknowledgeStateUseCaseImpl;
        this.f62790c = overdueAcknowledgeState;
    }

    public final void run() {
        UpdateOverdueAcknowledgeStateUseCaseImpl.m10145invoke$lambda0(this.f62789b, this.f62790c);
    }
}
