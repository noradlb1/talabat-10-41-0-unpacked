package com.talabat.gem.adapters.data;

import com.talabat.gem.ports.data.SessionDataSourcesPort;
import com.talabat.talabatcommon.extentions.Nullable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/talabat/gem/adapters/data/SessionDataSources;", "Lcom/talabat/gem/ports/data/SessionDataSourcesPort;", "()V", "clearGemOffer", "", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SessionDataSources implements SessionDataSourcesPort {
    public void clearGemOffer() {
        CacheKt.getCachedOffer().onNext(new Nullable((Object) null, 1, (DefaultConstructorMarker) null));
    }
}
