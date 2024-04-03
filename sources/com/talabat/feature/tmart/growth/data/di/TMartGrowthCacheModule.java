package com.talabat.feature.tmart.growth.data.di;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.talabat.core.context.domain.ApplicationContext;
import dagger.Module;
import dagger.Provides;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/di/TMartGrowthCacheModule;", "", "()V", "CACHE_SIZE", "", "SUBDIRECTORY", "", "provideDiskCache", "Lcom/bumptech/glide/load/engine/cache/DiskCache;", "fileDirectory", "Ljava/io/File;", "provideFileDirectory", "context", "Landroid/content/Context;", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class TMartGrowthCacheModule {
    private static final long CACHE_SIZE = 10485760;
    @NotNull
    public static final TMartGrowthCacheModule INSTANCE = new TMartGrowthCacheModule();
    @NotNull
    private static final String SUBDIRECTORY = "tMartGrowth";

    private TMartGrowthCacheModule() {
    }

    @Nullable
    @Provides
    public final DiskCache provideDiskCache(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "fileDirectory");
        return new DiskLruCacheFactory(file.getPath(), SUBDIRECTORY, CACHE_SIZE).build();
    }

    @NotNull
    @Provides
    public final File provideFileDirectory(@NotNull @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File filesDir = context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "context.filesDir");
        return filesDir;
    }
}
