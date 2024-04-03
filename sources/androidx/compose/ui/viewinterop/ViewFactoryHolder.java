package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m0.d2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B#\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR@\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R<\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\r2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\r@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u0014\u0010\u001d\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0015¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/viewinterop/ViewFactoryHolder;", "T", "Landroid/view/View;", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "context", "Landroid/content/Context;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroid/content/Context;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "value", "Lkotlin/Function1;", "factory", "getFactory", "()Lkotlin/jvm/functions/Function1;", "setFactory", "(Lkotlin/jvm/functions/Function1;)V", "typedView", "getTypedView$ui_release", "()Landroid/view/View;", "setTypedView$ui_release", "(Landroid/view/View;)V", "Landroid/view/View;", "", "updateBlock", "getUpdateBlock", "setUpdateBlock", "viewRoot", "getViewRoot", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ViewFactoryHolder<T extends View> extends AndroidViewHolder implements ViewRootForInspector {
    @Nullable
    private Function1<? super Context, ? extends T> factory;
    @Nullable
    private T typedView;
    @NotNull
    private Function1<? super T, Unit> updateBlock;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewFactoryHolder(Context context, CompositionContext compositionContext, NestedScrollDispatcher nestedScrollDispatcher, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : compositionContext, (i11 & 4) != 0 ? new NestedScrollDispatcher() : nestedScrollDispatcher);
    }

    @Nullable
    public final Function1<Context, T> getFactory() {
        return this.factory;
    }

    public /* synthetic */ AbstractComposeView getSubCompositionView() {
        return d2.a(this);
    }

    @Nullable
    public final T getTypedView$ui_release() {
        return this.typedView;
    }

    @NotNull
    public final Function1<T, Unit> getUpdateBlock() {
        return this.updateBlock;
    }

    @NotNull
    public View getViewRoot() {
        return this;
    }

    public final void setFactory(@Nullable Function1<? super Context, ? extends T> function1) {
        this.factory = function1;
        if (function1 != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            T t11 = (View) function1.invoke(context);
            this.typedView = t11;
            setView$ui_release(t11);
        }
    }

    public final void setTypedView$ui_release(@Nullable T t11) {
        this.typedView = t11;
    }

    public final void setUpdateBlock(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "value");
        this.updateBlock = function1;
        setUpdate(new ViewFactoryHolder$updateBlock$1(this));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewFactoryHolder(@NotNull Context context, @Nullable CompositionContext compositionContext, @NotNull NestedScrollDispatcher nestedScrollDispatcher) {
        super(context, compositionContext, nestedScrollDispatcher);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nestedScrollDispatcher, "dispatcher");
        setClipChildren(false);
        this.updateBlock = AndroidView_androidKt.getNoOpUpdate();
    }
}
