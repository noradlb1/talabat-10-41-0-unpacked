package com.talabat.feature.bnplcore.data.repository;

import com.deliveryhero.customerchat.eventTracking.constants.ContactDetailsKeys;
import com.talabat.feature.bnplcore.data.remote.BnplApi;
import com.talabat.feature.bnplcore.data.remote.BnplOverduesResponse;
import com.talabat.feature.bnplcore.domain.model.OverdueAcknowledgeState;
import com.talabat.feature.bnplcore.domain.model.Overdues;
import com.talabat.feature.bnplcore.domain.repository.BnplRepository;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ol.a;
import ol.b;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\bH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/bnplcore/data/repository/BnplRepositoryImpl;", "Lcom/talabat/feature/bnplcore/domain/repository/BnplRepository;", "client", "Lcom/talabat/feature/bnplcore/data/remote/BnplApi;", "(Lcom/talabat/feature/bnplcore/data/remote/BnplApi;)V", "overdueAcknowledgedState", "Lcom/talabat/feature/bnplcore/domain/model/OverdueAcknowledgeState;", "getOverdueAcknowledgeState", "Lio/reactivex/Single;", "getOverdues", "Lcom/talabat/feature/bnplcore/domain/model/Overdues;", "updateOverdueAcknowledgedState", "", "overdue", "com_talabat_feature_bnpl-core_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BnplRepositoryImpl implements BnplRepository {
    @NotNull
    private final BnplApi client;
    @NotNull
    private OverdueAcknowledgeState overdueAcknowledgedState = OverdueAcknowledgeState.UNACKNOWLEDGED;

    @Inject
    public BnplRepositoryImpl(@NotNull BnplApi bnplApi) {
        Intrinsics.checkNotNullParameter(bnplApi, ContactDetailsKeys.SENT_FROM_VALUE);
        this.client = bnplApi;
    }

    /* access modifiers changed from: private */
    /* renamed from: getOverdues$lambda-0  reason: not valid java name */
    public static final Overdues m10141getOverdues$lambda0(BnplOverduesResponse bnplOverduesResponse) {
        Intrinsics.checkNotNullParameter(bnplOverduesResponse, "it");
        return bnplOverduesResponse.toOverdues();
    }

    /* access modifiers changed from: private */
    /* renamed from: getOverdues$lambda-1  reason: not valid java name */
    public static final Overdues m10142getOverdues$lambda1(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return new Overdues(0, 0.0d, 2, (DefaultConstructorMarker) null);
    }

    @NotNull
    public Single<OverdueAcknowledgeState> getOverdueAcknowledgeState() {
        Single<OverdueAcknowledgeState> just = Single.just(this.overdueAcknowledgedState);
        Intrinsics.checkNotNullExpressionValue(just, "just(overdueAcknowledgedState)");
        return just;
    }

    @NotNull
    public Single<Overdues> getOverdues() {
        Single<R> onErrorReturn = this.client.getOverdues().map(new a()).onErrorReturn(new b());
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "client.getOverdues().map…    Overdues(0)\n        }");
        return onErrorReturn;
    }

    public void updateOverdueAcknowledgedState(@NotNull OverdueAcknowledgeState overdueAcknowledgeState) {
        Intrinsics.checkNotNullParameter(overdueAcknowledgeState, "overdue");
        this.overdueAcknowledgedState = overdueAcknowledgeState;
    }
}
