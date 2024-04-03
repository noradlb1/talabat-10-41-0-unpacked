package com.talabat.feature.bnplcore.domain.fake.di;

import com.talabat.feature.bnplcore.domain.usecase.GetOverdueUseCase;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¨\u0006\u0005"}, d2 = {"com/talabat/feature/bnplcore/domain/fake/di/FakeBnplCoreFeatureApi$getBnplOverduesUseCase$1", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase;", "invoke", "Lio/reactivex/Single;", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase$OverdueResult;", "com_talabat_feature_bnpl-core_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FakeBnplCoreFeatureApi$getBnplOverduesUseCase$1 implements GetOverdueUseCase {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FakeBnplCoreFeatureApi f58373a;

    public FakeBnplCoreFeatureApi$getBnplOverduesUseCase$1(FakeBnplCoreFeatureApi fakeBnplCoreFeatureApi) {
        this.f58373a = fakeBnplCoreFeatureApi;
    }

    @NotNull
    public Single<GetOverdueUseCase.OverdueResult> invoke() {
        return this.f58373a.fakeOverdueStream;
    }
}
