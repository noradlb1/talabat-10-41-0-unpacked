package com.talabat.gem.adapters.presentation;

import com.facebook.internal.NativeProtocol;
import com.talabat.gem.domain.entities.GemOfferAcceptance;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0013\u001a\u00020\u00062\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0004J\u001d\u0010\u0015\u001a\u00020\u00062\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u0004H\u0004J\u001f\u0010\u0016\u001a\u00020\u00062\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0004R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/talabat/gem/adapters/presentation/GemApprovalCallbacks;", "", "()V", "onError", "Lkotlin/Function1;", "", "", "getOnError$com_talabat_Components_gem_gem", "()Lkotlin/jvm/functions/Function1;", "setOnError$com_talabat_Components_gem_gem", "(Lkotlin/jvm/functions/Function1;)V", "onProcessed", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance;", "getOnProcessed$com_talabat_Components_gem_gem", "setOnProcessed$com_talabat_Components_gem_gem", "onProcessing", "", "getOnProcessing$com_talabat_Components_gem_gem", "setOnProcessing$com_talabat_Components_gem_gem", "error", "action", "processed", "processing", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemApprovalCallbacks {
    @Nullable
    private Function1<? super Throwable, Unit> onError;
    @Nullable
    private Function1<? super GemOfferAcceptance, Unit> onProcessed;
    @Nullable
    private Function1<? super Boolean, Unit> onProcessing;

    @GemViewsDsl
    public final void error(@Nullable Function1<? super Throwable, Unit> function1) {
        this.onError = function1;
    }

    @Nullable
    public final Function1<Throwable, Unit> getOnError$com_talabat_Components_gem_gem() {
        return this.onError;
    }

    @Nullable
    public final Function1<GemOfferAcceptance, Unit> getOnProcessed$com_talabat_Components_gem_gem() {
        return this.onProcessed;
    }

    @Nullable
    public final Function1<Boolean, Unit> getOnProcessing$com_talabat_Components_gem_gem() {
        return this.onProcessing;
    }

    @GemViewsDsl
    public final void processed(@NotNull Function1<? super GemOfferAcceptance, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, NativeProtocol.WEB_DIALOG_ACTION);
        this.onProcessed = function1;
    }

    @GemViewsDsl
    public final void processing(@Nullable Function1<? super Boolean, Unit> function1) {
        this.onProcessing = function1;
    }

    public final void setOnError$com_talabat_Components_gem_gem(@Nullable Function1<? super Throwable, Unit> function1) {
        this.onError = function1;
    }

    public final void setOnProcessed$com_talabat_Components_gem_gem(@Nullable Function1<? super GemOfferAcceptance, Unit> function1) {
        this.onProcessed = function1;
    }

    public final void setOnProcessing$com_talabat_Components_gem_gem(@Nullable Function1<? super Boolean, Unit> function1) {
        this.onProcessing = function1;
    }
}
