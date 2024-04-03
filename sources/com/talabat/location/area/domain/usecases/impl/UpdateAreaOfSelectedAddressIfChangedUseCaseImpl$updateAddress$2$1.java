package com.talabat.location.area.domain.usecases.impl;

import com.talabat.observability.ObservabilityManager;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.TuplesKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UpdateAreaOfSelectedAddressIfChangedUseCaseImpl$updateAddress$2$1<T> implements Consumer {
    public static final UpdateAreaOfSelectedAddressIfChangedUseCaseImpl$updateAddress$2$1<T> INSTANCE = new UpdateAreaOfSelectedAddressIfChangedUseCaseImpl$updateAddress$2$1<>();

    public final void accept(Throwable th2) {
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        ObservabilityManager.trackUnExpectedScenario("UpdateAreaOfSelectedAddressIfChangedUseCaseImplErrors", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", message)));
    }
}
