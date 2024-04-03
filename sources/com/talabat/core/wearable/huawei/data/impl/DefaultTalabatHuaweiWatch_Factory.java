package com.talabat.core.wearable.huawei.data.impl;

import com.talabat.core.wearable.huawei.data.HuaweiWearEngineKit;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DefaultTalabatHuaweiWatch_Factory implements Factory<DefaultTalabatHuaweiWatch> {
    private final Provider<HuaweiWearEngineKit> wearEngineProvider;

    public DefaultTalabatHuaweiWatch_Factory(Provider<HuaweiWearEngineKit> provider) {
        this.wearEngineProvider = provider;
    }

    public static DefaultTalabatHuaweiWatch_Factory create(Provider<HuaweiWearEngineKit> provider) {
        return new DefaultTalabatHuaweiWatch_Factory(provider);
    }

    public static DefaultTalabatHuaweiWatch newInstance(HuaweiWearEngineKit huaweiWearEngineKit) {
        return new DefaultTalabatHuaweiWatch(huaweiWearEngineKit);
    }

    public DefaultTalabatHuaweiWatch get() {
        return newInstance(this.wearEngineProvider.get());
    }
}
