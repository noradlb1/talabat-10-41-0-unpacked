package com.deliveryhero.perseus.data.local;

import com.deliveryhero.perseus.utils.Provider;
import com.deliveryhero.persistence.cache.LocalStorage;
import com.deliveryhero.persistence.cache.MemoryCache;
import com.visa.checkout.Profile;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/deliveryhero/perseus/data/local/PerseusUserLocalDataStoreImpl;", "Lcom/deliveryhero/perseus/data/local/PerseusUserLocalDataStore;", "memoryCache", "Lcom/deliveryhero/persistence/cache/MemoryCache;", "localStorage", "Lcom/deliveryhero/persistence/cache/LocalStorage;", "clock", "Lcom/deliveryhero/perseus/utils/Provider;", "Ljava/util/Calendar;", "(Lcom/deliveryhero/persistence/cache/MemoryCache;Lcom/deliveryhero/persistence/cache/LocalStorage;Lcom/deliveryhero/perseus/utils/Provider;)V", "getClientId", "", "getSessionId", "getSessionOffset", "", "putClientId", "", "clientId", "putSessionId", "sessionId", "putSessionOffset", "sessionOffset", "refreshSessionTimeStamp", "Companion", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerseusUserLocalDataStoreImpl implements PerseusUserLocalDataStore {
    @NotNull
    private static final String CLIENT_ID_KEY = "client_id";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int SECONDS_IN_MINUTE = 60;
    @NotNull
    private static final String SESSION_ID_KEY = "session_id";
    @NotNull
    private static final String SESSION_OFFSET = "session_offset";
    private static final long SESSION_TIMEOUT_DURATION = 30;
    @NotNull
    private static final String SESSION_TIMESTAMP_KEY = "session_timestamp";
    @NotNull
    private final Provider<Calendar> clock;
    @NotNull
    private final LocalStorage localStorage;
    @NotNull
    private final MemoryCache memoryCache;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/deliveryhero/perseus/data/local/PerseusUserLocalDataStoreImpl$Companion;", "", "()V", "CLIENT_ID_KEY", "", "SECONDS_IN_MINUTE", "", "SESSION_ID_KEY", "SESSION_OFFSET", "SESSION_TIMEOUT_DURATION", "", "SESSION_TIMESTAMP_KEY", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PerseusUserLocalDataStoreImpl(@NotNull MemoryCache memoryCache2, @NotNull LocalStorage localStorage2, @NotNull Provider<Calendar> provider) {
        Intrinsics.checkNotNullParameter(memoryCache2, "memoryCache");
        Intrinsics.checkNotNullParameter(localStorage2, "localStorage");
        Intrinsics.checkNotNullParameter(provider, "clock");
        this.memoryCache = memoryCache2;
        this.localStorage = localStorage2;
        this.clock = provider;
    }

    @Nullable
    public String getClientId() {
        Object obj = this.memoryCache.get("client_id");
        if (obj == null && (obj = this.localStorage.getString("client_id")) != null) {
            this.memoryCache.put("client_id", obj);
        }
        return (String) obj;
    }

    @Nullable
    public String getSessionId() {
        boolean z11;
        String str = (String) this.memoryCache.get("session_id");
        if (str != null) {
            return str;
        }
        long timeInMillis = this.clock.get().getTimeInMillis();
        long j11 = this.localStorage.getLong(SESSION_TIMESTAMP_KEY, 0);
        String string = this.localStorage.getString("session_id");
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (timeUnit.toMinutes(timeInMillis) - timeUnit.toMinutes(j11) <= SESSION_TIMEOUT_DURATION) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (j11 == 0 || !z11) {
            return str;
        }
        this.memoryCache.put("session_id", string, 1800);
        return string;
    }

    public synchronized long getSessionOffset() {
        return this.localStorage.getLong(SESSION_OFFSET, 1);
    }

    public void putClientId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Profile.CLIENT_ID);
        this.memoryCache.put("client_id", str);
        this.localStorage.putString("client_id", str);
    }

    public void putSessionId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        long timeInMillis = this.clock.get().getTimeInMillis();
        this.memoryCache.put("session_id", str, 1800);
        this.localStorage.putString("session_id", str);
        this.localStorage.putLong(SESSION_TIMESTAMP_KEY, timeInMillis);
    }

    public synchronized void putSessionOffset(long j11) {
        this.localStorage.putLong(SESSION_OFFSET, j11);
    }

    public void refreshSessionTimeStamp() {
        this.localStorage.putLong(SESSION_TIMESTAMP_KEY, this.clock.get().getTimeInMillis());
    }
}
