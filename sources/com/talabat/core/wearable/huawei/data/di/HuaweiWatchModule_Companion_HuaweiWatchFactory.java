package com.talabat.core.wearable.huawei.data.di;

import com.talabat.core.wearable.huawei.data.HuaweiWearEngineKit;
import com.talabat.core.wearable.huawei.domain.TalabatHuaweiWatch;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class HuaweiWatchModule_Companion_HuaweiWatchFactory implements Factory<TalabatHuaweiWatch> {
    private final Provider<HuaweiWearEngineKit> wearEngineKitProvider;

    public HuaweiWatchModule_Companion_HuaweiWatchFactory(Provider<HuaweiWearEngineKit> provider) {
        this.wearEngineKitProvider = provider;
    }

    public static HuaweiWatchModule_Companion_HuaweiWatchFactory create(Provider<HuaweiWearEngineKit> provider) {
        return new HuaweiWatchModule_Companion_HuaweiWatchFactory(provider);
    }

    public static TalabatHuaweiWatch huaweiWatch(HuaweiWearEngineKit huaweiWearEngineKit) {
        return (TalabatHuaweiWatch) Preconditions.checkNotNullFromProvides(HuaweiWatchModule.Companion.huaweiWatch(huaweiWearEngineKit));
    }

    public TalabatHuaweiWatch get() {
        return huaweiWatch(this.wearEngineKitProvider.get());
    }
}
