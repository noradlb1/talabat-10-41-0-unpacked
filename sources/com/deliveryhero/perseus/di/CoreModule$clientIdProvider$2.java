package com.deliveryhero.perseus.di;

import com.deliveryhero.perseus.core.session.ClientIdProviderImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/deliveryhero/perseus/core/session/ClientIdProviderImpl;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class CoreModule$clientIdProvider$2 extends Lambda implements Function0<ClientIdProviderImpl> {
    public static final CoreModule$clientIdProvider$2 INSTANCE = new CoreModule$clientIdProvider$2();

    public CoreModule$clientIdProvider$2() {
        super(0);
    }

    @NotNull
    public final ClientIdProviderImpl invoke() {
        return new ClientIdProviderImpl(DataModule.INSTANCE.getPerseusUserLocalDataStore());
    }
}
