package com.instabug.apm.attributes.listeners;

import androidx.annotation.Nullable;
import com.instabug.apm.attributes.predicates.UrlPredicate;
import com.instabug.apm.model.NetworkTrace;
import java.util.Map;

public abstract class OnNetworkTraceListener {
    @Nullable
    private final UrlPredicate predicate;

    public OnNetworkTraceListener(@Nullable UrlPredicate urlPredicate) {
        this.predicate = urlPredicate;
    }

    public abstract Map<String, String> addAttributesOnFinish(NetworkTrace networkTrace);

    @Nullable
    public UrlPredicate getPredicate() {
        return this.predicate;
    }
}
