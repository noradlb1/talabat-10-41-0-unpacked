package com.talabat.gem.adapters.presentation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0019\u0010\r\u001a\u00020\u00052\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0004J\u0019\u0010\u000f\u001a\u00020\u00052\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0004R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/talabat/gem/adapters/presentation/GemVisibilityCallbacks;", "", "()V", "onDisabled", "Lkotlin/Function0;", "", "getOnDisabled$com_talabat_Components_gem_gem", "()Lkotlin/jvm/functions/Function0;", "setOnDisabled$com_talabat_Components_gem_gem", "(Lkotlin/jvm/functions/Function0;)V", "onEnabled", "getOnEnabled$com_talabat_Components_gem_gem", "setOnEnabled$com_talabat_Components_gem_gem", "disabled", "action", "enabled", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class GemVisibilityCallbacks {
    @Nullable
    private Function0<Unit> onDisabled;
    @Nullable
    private Function0<Unit> onEnabled;

    @GemViewsDsl
    public final void disabled(@Nullable Function0<Unit> function0) {
        this.onDisabled = function0;
    }

    @GemViewsDsl
    public final void enabled(@Nullable Function0<Unit> function0) {
        this.onEnabled = function0;
    }

    @Nullable
    public final Function0<Unit> getOnDisabled$com_talabat_Components_gem_gem() {
        return this.onDisabled;
    }

    @Nullable
    public final Function0<Unit> getOnEnabled$com_talabat_Components_gem_gem() {
        return this.onEnabled;
    }

    public final void setOnDisabled$com_talabat_Components_gem_gem(@Nullable Function0<Unit> function0) {
        this.onDisabled = function0;
    }

    public final void setOnEnabled$com_talabat_Components_gem_gem(@Nullable Function0<Unit> function0) {
        this.onEnabled = function0;
    }
}
