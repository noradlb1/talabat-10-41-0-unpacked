package com.talabat;

import com.talabat.app.App;
import com.talabat.core.di.Api;
import com.talabat.helpers.TalabatApplication;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ$\u0010\u000e\u001a\u00020\b2\u001c\u0010\u000f\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0010J\u001e\u0010\u0011\u001a\u00020\b2\u0016\u0010\u000f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\u0004\u0012\u00020\r0\u0010R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/talabat/UiTestApplication;", "Lcom/talabat/helpers/TalabatApplication;", "()V", "app", "Lcom/talabat/app/App;", "getApp", "()Lcom/talabat/app/App;", "setFeature", "", "clazz", "Ljava/lang/Class;", "api", "Ljavax/inject/Provider;", "Lcom/talabat/core/di/Api;", "setFeatures", "features", "", "setFeaturesDirect", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UiTestApplication extends TalabatApplication {
    @NotNull
    private final App app = new TestApp(this);

    @NotNull
    public App getApp() {
        return this.app;
    }

    public final void setFeature(@NotNull Class<?> cls, @NotNull Provider<Api> provider) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(provider, "api");
        ((TestApp) getApp()).setFeature(cls, provider);
    }

    public final void setFeatures(@NotNull Map<Class<?>, ? extends Provider<Api>> map) {
        Intrinsics.checkNotNullParameter(map, "features");
        ((TestApp) getApp()).setFeatures(map);
    }

    public final void setFeaturesDirect(@NotNull Map<Class<?>, ? extends Api> map) {
        Intrinsics.checkNotNullParameter(map, "features");
        ((TestApp) getApp()).setFeaturesDirect(map);
    }
}
