package com.talabat.darkstores.common;

import com.talabat.darkstores.common.view.ErrorView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u001c\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u0010\u0013\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\rR(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/common/ErrorViewDispatcher;", "", "()V", "value", "Lcom/talabat/darkstores/common/view/ErrorView;", "errorView", "getErrorView", "()Lcom/talabat/darkstores/common/view/ErrorView;", "setErrorView", "(Lcom/talabat/darkstores/common/view/ErrorView;)V", "retryCallbacks", "", "Lkotlin/Function0;", "", "addCallback", "callback", "dispatch", "error", "", "dispose", "isErrorViewVisible", "", "retryAll", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ErrorViewDispatcher {
    @Nullable
    private ErrorView errorView;
    @NotNull
    private final List<Function0<Unit>> retryCallbacks = new ArrayList();

    public final void addCallback(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        this.retryCallbacks.add(function0);
    }

    public final void dispatch(@NotNull Throwable th2, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(th2, "error");
        Intrinsics.checkNotNullParameter(function0, "callback");
        this.retryCallbacks.add(function0);
        ErrorView errorView2 = this.errorView;
        if (errorView2 != null) {
            errorView2.show(th2);
        }
    }

    public final void dispose(@NotNull Function0<Unit> function0) {
        ErrorView errorView2;
        Intrinsics.checkNotNullParameter(function0, "callback");
        this.retryCallbacks.remove(function0);
        if (this.retryCallbacks.isEmpty() && (errorView2 = this.errorView) != null) {
            errorView2.hide();
        }
    }

    @Nullable
    public final ErrorView getErrorView() {
        return this.errorView;
    }

    public final boolean isErrorViewVisible() {
        ErrorView errorView2 = this.errorView;
        if (errorView2 != null) {
            return errorView2.isVisible();
        }
        return false;
    }

    public final void retryAll() {
        for (Function0 invoke : CollectionsKt___CollectionsKt.toList(this.retryCallbacks)) {
            invoke.invoke();
        }
    }

    public final void setErrorView(@Nullable ErrorView errorView2) {
        this.errorView = errorView2;
        if (errorView2 != null) {
            errorView2.setOnReloadClicked(new ErrorViewDispatcher$errorView$1(this));
        }
    }
}
