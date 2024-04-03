package com.talabat.core.di;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\b¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"getFeature", "T", "Lcom/talabat/core/di/ApiContainer;", "(Lcom/talabat/core/di/ApiContainer;)Ljava/lang/Object;", "com_talabat_core_di_di"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ApiContainerKt {
    public static final /* synthetic */ <T> T getFeature(ApiContainer apiContainer) {
        Intrinsics.checkNotNullParameter(apiContainer, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        return apiContainer.getFeature(Object.class);
    }
}
