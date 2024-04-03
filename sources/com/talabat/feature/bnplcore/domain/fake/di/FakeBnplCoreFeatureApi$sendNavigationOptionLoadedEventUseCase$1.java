package com.talabat.feature.bnplcore.domain.fake.di;

import com.talabat.feature.bnplcore.domain.usecase.SendNavigationOptionLoadedEventUseCase;
import io.reactivex.Completable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¨\u0006\b"}, d2 = {"com/talabat/feature/bnplcore/domain/fake/di/FakeBnplCoreFeatureApi$sendNavigationOptionLoadedEventUseCase$1", "Lcom/talabat/feature/bnplcore/domain/usecase/SendNavigationOptionLoadedEventUseCase;", "invoke", "Lio/reactivex/Completable;", "eventOrigin", "", "screenName", "screenType", "com_talabat_feature_bnpl-core_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FakeBnplCoreFeatureApi$sendNavigationOptionLoadedEventUseCase$1 implements SendNavigationOptionLoadedEventUseCase {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FakeBnplCoreFeatureApi f58375a;

    public FakeBnplCoreFeatureApi$sendNavigationOptionLoadedEventUseCase$1(FakeBnplCoreFeatureApi fakeBnplCoreFeatureApi) {
        this.f58375a = fakeBnplCoreFeatureApi;
    }

    @NotNull
    public Completable invoke(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "eventOrigin");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, "screenType");
        return this.f58375a.sendNavigationOptionLoadedEventStream;
    }
}
