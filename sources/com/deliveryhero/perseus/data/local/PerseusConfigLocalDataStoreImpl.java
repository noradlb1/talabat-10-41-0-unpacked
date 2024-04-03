package com.deliveryhero.perseus.data.local;

import com.deliveryhero.perseus.PerseusParamsConfig;
import com.deliveryhero.persistence.cache.LocalStorage;
import com.deliveryhero.persistence.cache.MemoryCache;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/perseus/data/local/PerseusConfigLocalDataStoreImpl;", "Lcom/deliveryhero/perseus/data/local/PerseusConfigLocalDataStore;", "memoryCache", "Lcom/deliveryhero/persistence/cache/MemoryCache;", "localStorage", "Lcom/deliveryhero/persistence/cache/LocalStorage;", "(Lcom/deliveryhero/persistence/cache/MemoryCache;Lcom/deliveryhero/persistence/cache/LocalStorage;)V", "getBatchDispatchHitsDelay", "", "getConfig", "Lcom/deliveryhero/perseus/PerseusParamsConfig;", "putBatchDispatchHitsDelay", "", "batchDispatchHitsDelay", "putConfig", "config", "Companion", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerseusConfigLocalDataStoreImpl implements PerseusConfigLocalDataStore {
    @NotNull
    private static final String BATCH_DISPATCH_HITS_DELAY_KEY = "batch_dispatch_hits_delay";
    @NotNull
    private static final String CONFIG_KEY = "config";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final LocalStorage localStorage;
    @NotNull
    private final MemoryCache memoryCache;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/perseus/data/local/PerseusConfigLocalDataStoreImpl$Companion;", "", "()V", "BATCH_DISPATCH_HITS_DELAY_KEY", "", "CONFIG_KEY", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PerseusConfigLocalDataStoreImpl(@NotNull MemoryCache memoryCache2, @NotNull LocalStorage localStorage2) {
        Intrinsics.checkNotNullParameter(memoryCache2, "memoryCache");
        Intrinsics.checkNotNullParameter(localStorage2, "localStorage");
        this.memoryCache = memoryCache2;
        this.localStorage = localStorage2;
    }

    public long getBatchDispatchHitsDelay() {
        Long l11 = (Long) this.memoryCache.get(BATCH_DISPATCH_HITS_DELAY_KEY);
        if (l11 == null) {
            l11 = Long.valueOf(this.localStorage.getLong(BATCH_DISPATCH_HITS_DELAY_KEY, 5));
            this.memoryCache.put(BATCH_DISPATCH_HITS_DELAY_KEY, l11);
        }
        return l11.longValue();
    }

    @Nullable
    public PerseusParamsConfig getConfig() {
        Object obj = this.memoryCache.get("config");
        if (obj == null) {
            obj = GsonInstrumentation.fromJson(new Gson(), this.localStorage.getString("config"), PerseusParamsConfig.class);
            if (((PerseusParamsConfig) obj) != null) {
                this.memoryCache.put("config", obj);
            }
        }
        return (PerseusParamsConfig) obj;
    }

    public void putBatchDispatchHitsDelay(long j11) {
        this.memoryCache.put(BATCH_DISPATCH_HITS_DELAY_KEY, Long.valueOf(j11));
        this.localStorage.putLong(BATCH_DISPATCH_HITS_DELAY_KEY, j11);
    }

    public void putConfig(@NotNull PerseusParamsConfig perseusParamsConfig) {
        Intrinsics.checkNotNullParameter(perseusParamsConfig, "config");
        this.memoryCache.put("config", perseusParamsConfig);
        LocalStorage localStorage2 = this.localStorage;
        String json = GsonInstrumentation.toJson(new Gson(), (Object) perseusParamsConfig);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(config)");
        localStorage2.putString("config", json);
    }
}
