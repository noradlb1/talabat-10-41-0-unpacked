package com.talabat.talabatcommon.extentions;

import io.reactivex.Scheduler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/reactivex/Scheduler;", "T", "O", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ObserverCallbacks$scheduler$2 extends Lambda implements Function0<Scheduler> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Scheduler f47067g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ObserverCallbacks$scheduler$2(Scheduler scheduler) {
        super(0);
        this.f47067g = scheduler;
    }

    @NotNull
    public final Scheduler invoke() {
        return this.f47067g;
    }
}
