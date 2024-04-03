package com.talabat.gem.adapters.presentation;

import com.talabat.gem.domain.entities.GemRestaurant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/gem/adapters/presentation/GemEntryViewConfigurations;", "", "()V", "on", "Lcom/talabat/gem/adapters/presentation/GemSelectionCallbacks;", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "getOn$annotations", "getOn", "()Lcom/talabat/gem/adapters/presentation/GemSelectionCallbacks;", "with", "Lcom/talabat/gem/adapters/presentation/GemEntryViewData;", "getWith$annotations", "getWith", "()Lcom/talabat/gem/adapters/presentation/GemEntryViewData;", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemEntryViewConfigurations {
    @NotNull

    /* renamed from: on  reason: collision with root package name */
    private final GemSelectionCallbacks<GemRestaurant> f59888on = new GemSelectionCallbacks<>();
    @NotNull
    private final GemEntryViewData with = new GemEntryViewData();

    @GemViewsDsl
    public static /* synthetic */ void getOn$annotations() {
    }

    @GemViewsDsl
    public static /* synthetic */ void getWith$annotations() {
    }

    @NotNull
    public final GemSelectionCallbacks<GemRestaurant> getOn() {
        return this.f59888on;
    }

    @NotNull
    public final GemEntryViewData getWith() {
        return this.with;
    }
}
