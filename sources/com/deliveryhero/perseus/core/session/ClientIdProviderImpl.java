package com.deliveryhero.perseus.core.session;

import com.deliveryhero.perseus.data.local.PerseusUserLocalDataStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/perseus/core/session/ClientIdProviderImpl;", "Lcom/deliveryhero/perseus/core/session/ClientIdProvider;", "userLocalDataStore", "Lcom/deliveryhero/perseus/data/local/PerseusUserLocalDataStore;", "(Lcom/deliveryhero/perseus/data/local/PerseusUserLocalDataStore;)V", "getClientId", "", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ClientIdProviderImpl implements ClientIdProvider {
    @NotNull
    private final PerseusUserLocalDataStore userLocalDataStore;

    public ClientIdProviderImpl(@NotNull PerseusUserLocalDataStore perseusUserLocalDataStore) {
        Intrinsics.checkNotNullParameter(perseusUserLocalDataStore, "userLocalDataStore");
        this.userLocalDataStore = perseusUserLocalDataStore;
    }

    @NotNull
    public String getClientId() {
        String clientId = this.userLocalDataStore.getClientId();
        if (clientId != null) {
            return clientId;
        }
        String createUniqueIdentifier = PerseusRandomIdGenerator.createUniqueIdentifier();
        this.userLocalDataStore.putClientId(createUniqueIdentifier);
        return createUniqueIdentifier;
    }
}
