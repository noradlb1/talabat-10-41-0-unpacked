package com.talabat.feature.bnplcore.domain.fake.di;

import com.talabat.feature.bnplcore.domain.BnplCoreFeatureApi;
import com.talabat.feature.bnplcore.domain.model.OverdueAcknowledgeState;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueNotificationAcknowledgeUseCase;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueUseCase;
import com.talabat.feature.bnplcore.domain.usecase.SendNavigationOptionLoadedEventUseCase;
import com.talabat.feature.bnplcore.domain.usecase.UpdateOverdueAcknowledgeStateUseCase;
import com.talabat.feature.bnplcore.domain.usecase.impl.IsUserBNPLEligibleUseCase;
import io.reactivex.Completable;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B;\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/bnplcore/domain/fake/di/FakeBnplCoreFeatureApi;", "Lcom/talabat/feature/bnplcore/domain/BnplCoreFeatureApi;", "fakeOverdueStream", "Lio/reactivex/Single;", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase$OverdueResult;", "fakeOverdueAcknowledgeStream", "Lcom/talabat/feature/bnplcore/domain/model/OverdueAcknowledgeState;", "fakeUpdateAcknowledgementStream", "Lio/reactivex/Completable;", "sendNavigationOptionLoadedEventStream", "isUserBNPLEligibleUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/impl/IsUserBNPLEligibleUseCase;", "(Lio/reactivex/Single;Lio/reactivex/Single;Lio/reactivex/Completable;Lio/reactivex/Completable;Lcom/talabat/feature/bnplcore/domain/usecase/impl/IsUserBNPLEligibleUseCase;)V", "getBnplOverduesUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase;", "getOverdueNotificationAcknowledgeUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueNotificationAcknowledgeUseCase;", "sendNavigationOptionLoadedEventUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/SendNavigationOptionLoadedEventUseCase;", "updateOverdueAcknowledgeStateUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/UpdateOverdueAcknowledgeStateUseCase;", "com_talabat_feature_bnpl-core_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FakeBnplCoreFeatureApi implements BnplCoreFeatureApi {
    /* access modifiers changed from: private */
    @NotNull
    public final Single<OverdueAcknowledgeState> fakeOverdueAcknowledgeStream;
    /* access modifiers changed from: private */
    @NotNull
    public final Single<GetOverdueUseCase.OverdueResult> fakeOverdueStream;
    /* access modifiers changed from: private */
    @NotNull
    public final Completable fakeUpdateAcknowledgementStream;
    @NotNull
    private final IsUserBNPLEligibleUseCase isUserBNPLEligibleUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final Completable sendNavigationOptionLoadedEventStream;

    public FakeBnplCoreFeatureApi(@NotNull Single<GetOverdueUseCase.OverdueResult> single, @NotNull Single<OverdueAcknowledgeState> single2, @NotNull Completable completable, @NotNull Completable completable2, @NotNull IsUserBNPLEligibleUseCase isUserBNPLEligibleUseCase2) {
        Intrinsics.checkNotNullParameter(single, "fakeOverdueStream");
        Intrinsics.checkNotNullParameter(single2, "fakeOverdueAcknowledgeStream");
        Intrinsics.checkNotNullParameter(completable, "fakeUpdateAcknowledgementStream");
        Intrinsics.checkNotNullParameter(completable2, "sendNavigationOptionLoadedEventStream");
        Intrinsics.checkNotNullParameter(isUserBNPLEligibleUseCase2, "isUserBNPLEligibleUseCase");
        this.fakeOverdueStream = single;
        this.fakeOverdueAcknowledgeStream = single2;
        this.fakeUpdateAcknowledgementStream = completable;
        this.sendNavigationOptionLoadedEventStream = completable2;
        this.isUserBNPLEligibleUseCase = isUserBNPLEligibleUseCase2;
    }

    @NotNull
    public GetOverdueUseCase getBnplOverduesUseCase() {
        return new FakeBnplCoreFeatureApi$getBnplOverduesUseCase$1(this);
    }

    @NotNull
    public GetOverdueNotificationAcknowledgeUseCase getOverdueNotificationAcknowledgeUseCase() {
        return new FakeBnplCoreFeatureApi$getOverdueNotificationAcknowledgeUseCase$1(this);
    }

    @NotNull
    public IsUserBNPLEligibleUseCase isUserBNPLEligibleUseCase() {
        return this.isUserBNPLEligibleUseCase;
    }

    @NotNull
    public SendNavigationOptionLoadedEventUseCase sendNavigationOptionLoadedEventUseCase() {
        return new FakeBnplCoreFeatureApi$sendNavigationOptionLoadedEventUseCase$1(this);
    }

    @NotNull
    public UpdateOverdueAcknowledgeStateUseCase updateOverdueAcknowledgeStateUseCase() {
        return new FakeBnplCoreFeatureApi$updateOverdueAcknowledgeStateUseCase$1(this);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FakeBnplCoreFeatureApi(io.reactivex.Single r7, io.reactivex.Single r8, io.reactivex.Completable r9, io.reactivex.Completable r10, com.talabat.feature.bnplcore.domain.usecase.impl.IsUserBNPLEligibleUseCase r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r12 = r12 & 8
            if (r12 == 0) goto L_0x000d
            io.reactivex.Completable r10 = io.reactivex.Completable.never()
            java.lang.String r12 = "never()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)
        L_0x000d:
            r4 = r10
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.bnplcore.domain.fake.di.FakeBnplCoreFeatureApi.<init>(io.reactivex.Single, io.reactivex.Single, io.reactivex.Completable, io.reactivex.Completable, com.talabat.feature.bnplcore.domain.usecase.impl.IsUserBNPLEligibleUseCase, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
