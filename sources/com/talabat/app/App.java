package com.talabat.app;

import android.app.Application;
import com.google.android.exoplayer2.util.MimeTypes;
import com.talabat.app.di.CoreLibsModule;
import com.talabat.app.di.DaggerAppComponent;
import com.talabat.core.di.Api;
import com.talabat.core.di.ApiContainer;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0007H\u0016¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R9\u0010\u0005\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n0\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/talabat/app/App;", "Lcom/talabat/core/di/ApiContainer;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "mergedMap", "", "Ljava/lang/Class;", "Ljavax/inject/Provider;", "Lcom/talabat/core/di/Api;", "Lkotlin/jvm/JvmSuppressWildcards;", "getMergedMap", "()Ljava/util/Map;", "setMergedMap", "(Ljava/util/Map;)V", "getFeature", "T", "key", "(Ljava/lang/Class;)Ljava/lang/Object;", "onCreate", "", "com_talabat_app_app"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class App implements ApiContainer {
    @NotNull
    private final Application application;
    @Inject
    public Map<Class<?>, Provider<Api>> mergedMap;

    public App(@NotNull Application application2) {
        Intrinsics.checkNotNullParameter(application2, MimeTypes.BASE_TYPE_APPLICATION);
        this.application = application2;
    }

    public <T> T getFeature(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "key");
        Provider<Api> provider = getMergedMap().get(cls);
        Intrinsics.checkNotNull(provider);
        return provider.get();
    }

    @NotNull
    public final Map<Class<?>, Provider<Api>> getMergedMap() {
        Map<Class<?>, Provider<Api>> map = this.mergedMap;
        if (map != null) {
            return map;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mergedMap");
        return null;
    }

    public final void onCreate() {
        DaggerAppComponent.factory().create(new CoreLibsModule(this.application)).inject(this);
    }

    public final void setMergedMap(@NotNull Map<Class<?>, Provider<Api>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.mergedMap = map;
    }
}
