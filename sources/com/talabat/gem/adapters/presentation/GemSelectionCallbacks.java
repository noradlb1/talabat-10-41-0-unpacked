package com.talabat.gem.adapters.presentation;

import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\b\u0000¢\u0006\u0002\u0010\u0003J\u0017\u0010\u0014\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0004J\u0017\u0010\u0016\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0004J\u001d\u0010\u0017\u001a\u00020\u00062\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u000fH\u0004R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/talabat/gem/adapters/presentation/GemSelectionCallbacks;", "T", "Lcom/talabat/gem/adapters/presentation/GemVisibilityCallbacks;", "()V", "onCancelled", "Lkotlin/Function0;", "", "getOnCancelled$com_talabat_Components_gem_gem", "()Lkotlin/jvm/functions/Function0;", "setOnCancelled$com_talabat_Components_gem_gem", "(Lkotlin/jvm/functions/Function0;)V", "onOpenCollection", "getOnOpenCollection$com_talabat_Components_gem_gem", "setOnOpenCollection$com_talabat_Components_gem_gem", "onSelected", "Lkotlin/Function1;", "getOnSelected$com_talabat_Components_gem_gem", "()Lkotlin/jvm/functions/Function1;", "setOnSelected$com_talabat_Components_gem_gem", "(Lkotlin/jvm/functions/Function1;)V", "cancelled", "action", "openCollection", "selected", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemSelectionCallbacks<T> extends GemVisibilityCallbacks {
    @Nullable
    private Function0<Unit> onCancelled;
    @Nullable
    private Function0<Unit> onOpenCollection;
    @Nullable
    private Function1<? super T, Unit> onSelected;

    @GemViewsDsl
    public final void cancelled(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, NativeProtocol.WEB_DIALOG_ACTION);
        this.onCancelled = function0;
    }

    @Nullable
    public final Function0<Unit> getOnCancelled$com_talabat_Components_gem_gem() {
        return this.onCancelled;
    }

    @Nullable
    public final Function0<Unit> getOnOpenCollection$com_talabat_Components_gem_gem() {
        return this.onOpenCollection;
    }

    @Nullable
    public final Function1<T, Unit> getOnSelected$com_talabat_Components_gem_gem() {
        return this.onSelected;
    }

    @GemViewsDsl
    public final void openCollection(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, NativeProtocol.WEB_DIALOG_ACTION);
        this.onOpenCollection = function0;
    }

    @GemViewsDsl
    public final void selected(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, NativeProtocol.WEB_DIALOG_ACTION);
        this.onSelected = function1;
    }

    public final void setOnCancelled$com_talabat_Components_gem_gem(@Nullable Function0<Unit> function0) {
        this.onCancelled = function0;
    }

    public final void setOnOpenCollection$com_talabat_Components_gem_gem(@Nullable Function0<Unit> function0) {
        this.onOpenCollection = function0;
    }

    public final void setOnSelected$com_talabat_Components_gem_gem(@Nullable Function1<? super T, Unit> function1) {
        this.onSelected = function1;
    }
}
