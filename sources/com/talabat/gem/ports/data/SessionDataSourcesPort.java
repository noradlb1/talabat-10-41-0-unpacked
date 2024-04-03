package com.talabat.gem.ports.data;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/talabat/gem/ports/data/SessionDataSourcesPort;", "", "clearGemOffer", "", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SessionDataSourcesPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void clearGemOffer(@NotNull SessionDataSourcesPort sessionDataSourcesPort) {
        }
    }

    void clearGemOffer();
}
