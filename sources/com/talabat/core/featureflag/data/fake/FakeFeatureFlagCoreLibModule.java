package com.talabat.core.featureflag.data.fake;

import com.talabat.core.featureflag.data.TalabatFeatureFlag;
import com.talabat.core.featureflag.data.datasource.IFeatureFlagDataSource;
import com.talabat.core.featureflag.data.di.FeatureFlagDataSourceModule;
import com.talabat.core.featureflag.data.di.LocalData;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/featureflag/data/fake/FakeFeatureFlagCoreLibModule;", "", "()V", "provideTalabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "localFeatureFlagDataSource", "Lcom/talabat/core/featureflag/data/datasource/IFeatureFlagDataSource;", "com_talabat_core_feature-flag_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {FeatureFlagDataSourceModule.class})
public final class FakeFeatureFlagCoreLibModule {
    @NotNull
    public static final FakeFeatureFlagCoreLibModule INSTANCE = new FakeFeatureFlagCoreLibModule();

    private FakeFeatureFlagCoreLibModule() {
    }

    @NotNull
    @Reusable
    @Provides
    public final ITalabatFeatureFlag provideTalabatFeatureFlag(@NotNull @LocalData IFeatureFlagDataSource iFeatureFlagDataSource) {
        Intrinsics.checkNotNullParameter(iFeatureFlagDataSource, "localFeatureFlagDataSource");
        return new TalabatFeatureFlag(iFeatureFlagDataSource);
    }
}
