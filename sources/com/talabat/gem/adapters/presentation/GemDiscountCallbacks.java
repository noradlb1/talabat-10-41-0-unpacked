package com.talabat.gem.adapters.presentation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u001f\u0010\u000b\u001a\u00020\u00062\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0004R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/talabat/gem/adapters/presentation/GemDiscountCallbacks;", "Lcom/talabat/gem/adapters/presentation/GemVisibilityCallbacks;", "()V", "onDiscount", "Lkotlin/Function1;", "", "", "getOnDiscount$com_talabat_Components_gem_gem", "()Lkotlin/jvm/functions/Function1;", "setOnDiscount$com_talabat_Components_gem_gem", "(Lkotlin/jvm/functions/Function1;)V", "discount", "action", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemDiscountCallbacks extends GemVisibilityCallbacks {
    @Nullable
    private Function1<? super Double, Unit> onDiscount;

    @GemViewsDsl
    public final void discount(@Nullable Function1<? super Double, Unit> function1) {
        this.onDiscount = function1;
    }

    @Nullable
    public final Function1<Double, Unit> getOnDiscount$com_talabat_Components_gem_gem() {
        return this.onDiscount;
    }

    public final void setOnDiscount$com_talabat_Components_gem_gem(@Nullable Function1<? super Double, Unit> function1) {
        this.onDiscount = function1;
    }
}
