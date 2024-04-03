package com.talabat.core.wearable.huawei.data.di;

import com.talabat.talabatcore.cache.Cache;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class HuaweiWatchModule_Companion_DiskCacheFactory implements Factory<Cache> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final HuaweiWatchModule_Companion_DiskCacheFactory INSTANCE = new HuaweiWatchModule_Companion_DiskCacheFactory();

        private InstanceHolder() {
        }
    }

    public static HuaweiWatchModule_Companion_DiskCacheFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Cache diskCache() {
        return (Cache) Preconditions.checkNotNullFromProvides(HuaweiWatchModule.Companion.diskCache());
    }

    public Cache get() {
        return diskCache();
    }
}
