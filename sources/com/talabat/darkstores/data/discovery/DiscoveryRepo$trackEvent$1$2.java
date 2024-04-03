package com.talabat.darkstores.data.discovery;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class DiscoveryRepo$trackEvent$1$2 extends MutablePropertyReference0Impl {
    public DiscoveryRepo$trackEvent$1$2(Object obj) {
        super(obj, DiscoveryRepo.class, "lastSearchRequestId", "getLastSearchRequestId()Ljava/lang/String;", 0);
    }

    @Nullable
    public Object get() {
        return ((DiscoveryRepo) this.receiver).getLastSearchRequestId();
    }

    public void set(@Nullable Object obj) {
        ((DiscoveryRepo) this.receiver).lastSearchRequestId = (String) obj;
    }
}
