package com.talabat.gem.adapters.presentation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0019\u0010\n\u001a\u00020\u00052\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0004R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/talabat/gem/adapters/presentation/GemBasketCallbacks;", "Lcom/talabat/gem/adapters/presentation/GemVisibilityCallbacks;", "()V", "onViewBasket", "Lkotlin/Function0;", "", "getOnViewBasket$com_talabat_Components_gem_gem", "()Lkotlin/jvm/functions/Function0;", "setOnViewBasket$com_talabat_Components_gem_gem", "(Lkotlin/jvm/functions/Function0;)V", "viewBasket", "action", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemBasketCallbacks extends GemVisibilityCallbacks {
    @Nullable
    private Function0<Unit> onViewBasket;

    @Nullable
    public final Function0<Unit> getOnViewBasket$com_talabat_Components_gem_gem() {
        return this.onViewBasket;
    }

    public final void setOnViewBasket$com_talabat_Components_gem_gem(@Nullable Function0<Unit> function0) {
        this.onViewBasket = function0;
    }

    @GemViewsDsl
    public final void viewBasket(@Nullable Function0<Unit> function0) {
        this.onViewBasket = function0;
    }
}
