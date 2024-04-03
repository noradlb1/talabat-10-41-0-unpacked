package com.talabat;

import android.app.Application;
import com.google.android.exoplayer2.util.MimeTypes;
import com.talabat.app.App;
import com.talabat.core.di.Api;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ue.ke;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0007H\u0016¢\u0006\u0002\u0010\rJ \u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\bJ$\u0010\u0012\u001a\u00020\u000f2\u001c\u0010\u0013\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0014J\u001e\u0010\u0015\u001a\u00020\u000f2\u0016\u0010\u0013\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\t0\u0014R$\u0010\u0005\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/TestApp;", "Lcom/talabat/app/App;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "featureMap", "", "Ljava/lang/Class;", "Ljavax/inject/Provider;", "Lcom/talabat/core/di/Api;", "getFeature", "T", "key", "(Ljava/lang/Class;)Ljava/lang/Object;", "setFeature", "", "clazz", "api", "setFeatures", "features", "", "setFeaturesDirect", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TestApp extends App {
    @NotNull
    private final Map<Class<?>, Provider<Api>> featureMap = new LinkedHashMap();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TestApp(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
    }

    /* access modifiers changed from: private */
    /* renamed from: setFeaturesDirect$lambda-2$lambda-1  reason: not valid java name */
    public static final Api m9493setFeaturesDirect$lambda2$lambda1(Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "$it");
        return (Api) entry.getValue();
    }

    public <T> T getFeature(@NotNull Class<T> cls) {
        T t11;
        Intrinsics.checkNotNullParameter(cls, "key");
        Provider provider = this.featureMap.get(cls);
        if (provider != null) {
            t11 = (Api) provider.get();
        } else {
            t11 = null;
        }
        if (t11 == null) {
            return super.getFeature(cls);
        }
        return t11;
    }

    public final void setFeature(@NotNull Class<?> cls, @NotNull Provider<Api> provider) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(provider, "api");
        this.featureMap.put(cls, provider);
    }

    public final void setFeatures(@NotNull Map<Class<?>, ? extends Provider<Api>> map) {
        Intrinsics.checkNotNullParameter(map, "features");
        for (Map.Entry next : map.entrySet()) {
            this.featureMap.put(next.getKey(), next.getValue());
        }
    }

    public final void setFeaturesDirect(@NotNull Map<Class<?>, ? extends Api> map) {
        Intrinsics.checkNotNullParameter(map, "features");
        for (Map.Entry next : map.entrySet()) {
            this.featureMap.put(next.getKey(), new ke(next));
        }
    }
}
