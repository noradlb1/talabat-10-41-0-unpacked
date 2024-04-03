package com.deliveryhero.perseus.core.session;

import com.deliveryhero.perseus.data.local.PerseusUserLocalDataStore;
import com.deliveryhero.perseus.utils.Provider;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/deliveryhero/perseus/core/session/AppSessionManagerImpl;", "Lcom/deliveryhero/perseus/core/session/AppSessionManager;", "userLocalDataStore", "Lcom/deliveryhero/perseus/data/local/PerseusUserLocalDataStore;", "listenersProvider", "Lcom/deliveryhero/perseus/utils/Provider;", "", "Lcom/deliveryhero/perseus/core/session/OnSessionChangedListener;", "(Lcom/deliveryhero/perseus/data/local/PerseusUserLocalDataStore;Lcom/deliveryhero/perseus/utils/Provider;)V", "listeners", "getListeners", "()Ljava/util/List;", "getAndIncrementSessionOffset", "", "getUserSessionId", "", "notifySessionChanged", "", "sessionId", "refreshSessionTimeStamp", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AppSessionManagerImpl implements AppSessionManager {
    @NotNull
    private final Provider<List<OnSessionChangedListener>> listenersProvider;
    @NotNull
    private final PerseusUserLocalDataStore userLocalDataStore;

    public AppSessionManagerImpl(@NotNull PerseusUserLocalDataStore perseusUserLocalDataStore, @NotNull Provider<List<OnSessionChangedListener>> provider) {
        Intrinsics.checkNotNullParameter(perseusUserLocalDataStore, "userLocalDataStore");
        Intrinsics.checkNotNullParameter(provider, "listenersProvider");
        this.userLocalDataStore = perseusUserLocalDataStore;
        this.listenersProvider = provider;
    }

    private final List<OnSessionChangedListener> getListeners() {
        return this.listenersProvider.get();
    }

    private final void notifySessionChanged(String str) {
        for (OnSessionChangedListener onSessionChanged : getListeners()) {
            onSessionChanged.onSessionChanged(str);
        }
    }

    public synchronized long getAndIncrementSessionOffset() {
        long sessionOffset;
        sessionOffset = this.userLocalDataStore.getSessionOffset();
        this.userLocalDataStore.putSessionOffset(1 + sessionOffset);
        return sessionOffset;
    }

    @NotNull
    public String getUserSessionId() {
        String sessionId = this.userLocalDataStore.getSessionId();
        if (sessionId != null) {
            return sessionId;
        }
        String createUniqueIdentifier = PerseusRandomIdGenerator.createUniqueIdentifier();
        this.userLocalDataStore.putSessionId(createUniqueIdentifier);
        this.userLocalDataStore.putSessionOffset(1);
        notifySessionChanged(createUniqueIdentifier);
        return createUniqueIdentifier;
    }

    public void refreshSessionTimeStamp() {
        this.userLocalDataStore.refreshSessionTimeStamp();
    }
}
