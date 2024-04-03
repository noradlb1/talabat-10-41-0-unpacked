package com.talabat.gem.adapters.presentation;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/talabat/gem/adapters/presentation/GemMenuFooterConfigurations;", "", "()V", "on", "Lcom/talabat/gem/adapters/presentation/GemBasketCallbacks;", "getOn$annotations", "getOn", "()Lcom/talabat/gem/adapters/presentation/GemBasketCallbacks;", "with", "Lcom/talabat/gem/adapters/presentation/GemSubTotalData;", "getWith$annotations", "getWith", "()Lcom/talabat/gem/adapters/presentation/GemSubTotalData;", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemMenuFooterConfigurations {
    @NotNull

    /* renamed from: on  reason: collision with root package name */
    private final GemBasketCallbacks f59892on = new GemBasketCallbacks();
    @NotNull
    private final GemSubTotalData with = new GemSubTotalData();

    @GemViewsDsl
    public static /* synthetic */ void getOn$annotations() {
    }

    @GemViewsDsl
    public static /* synthetic */ void getWith$annotations() {
    }

    @NotNull
    public final GemBasketCallbacks getOn() {
        return this.f59892on;
    }

    @NotNull
    public final GemSubTotalData getWith() {
        return this.with;
    }
}
