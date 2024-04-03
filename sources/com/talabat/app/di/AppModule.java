package com.talabat.app.di;

import com.talabat.core.di.Api;
import dagger.Module;
import dagger.Provides;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jm\u0010\u0003\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b0\u00042#\b\u0001\u0010\t\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b0\u00042#\b\u0001\u0010\n\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b0\u0004H\u0007¨\u0006\u000b"}, d2 = {"Lcom/talabat/app/di/AppModule;", "", "()V", "mergedMap", "", "Ljava/lang/Class;", "Ljavax/inject/Provider;", "Lcom/talabat/core/di/Api;", "Lkotlin/jvm/JvmSuppressWildcards;", "coreApis", "featureApis", "com_talabat_app_app"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class AppModule {
    @NotNull
    public static final AppModule INSTANCE = new AppModule();

    private AppModule() {
    }

    @NotNull
    @Provides
    public final Map<Class<?>, Provider<Api>> mergedMap(@NotNull @CoreApis Map<Class<?>, Provider<Api>> map, @NotNull @FeatureApis Map<Class<?>, Provider<Api>> map2) {
        Intrinsics.checkNotNullParameter(map, "coreApis");
        Intrinsics.checkNotNullParameter(map2, "featureApis");
        HashMap hashMap = new HashMap(map);
        hashMap.putAll(map2);
        return hashMap;
    }
}
