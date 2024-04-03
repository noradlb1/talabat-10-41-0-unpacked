package curtains.internal;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RequiresApi(16)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0001\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u000fB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0006\u0010\u000e\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcurtains/internal/NextDrawListener;", "Landroid/view/ViewTreeObserver$OnDrawListener;", "Landroid/view/View$OnAttachStateChangeListener;", "view", "Landroid/view/View;", "onDrawCallback", "Lkotlin/Function0;", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "invoked", "", "onDraw", "onViewAttachedToWindow", "onViewDetachedFromWindow", "safelyRegisterForNextDraw", "Companion", "curtains_release"}, k = 1, mv = {1, 4, 1})
public final class NextDrawListener implements ViewTreeObserver.OnDrawListener, View.OnAttachStateChangeListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private boolean invoked;
    private final Function0<Unit> onDrawCallback;
    /* access modifiers changed from: private */
    public final View view;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¨\u0006\b"}, d2 = {"Lcurtains/internal/NextDrawListener$Companion;", "", "()V", "onNextDraw", "", "Landroid/view/View;", "onDrawCallback", "Lkotlin/Function0;", "curtains_release"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void onNextDraw(@NotNull View view, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(view, "$this$onNextDraw");
            Intrinsics.checkNotNullParameter(function0, "onDrawCallback");
            new NextDrawListener(view, function0).safelyRegisterForNextDraw();
        }
    }

    public NextDrawListener(@NotNull View view2, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(function0, "onDrawCallback");
        this.view = view2;
        this.onDrawCallback = function0;
    }

    public void onDraw() {
        if (!this.invoked) {
            this.invoked = true;
            this.view.removeOnAttachStateChangeListener(this);
            HandlersKt.getMainHandler().post(new NextDrawListener$onDraw$1(this));
            this.onDrawCallback.invoke();
        }
    }

    public void onViewAttachedToWindow(@NotNull View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        view2.getViewTreeObserver().addOnDrawListener(this);
        view2.removeOnAttachStateChangeListener(this);
    }

    public void onViewDetachedFromWindow(@NotNull View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        view2.getViewTreeObserver().removeOnDrawListener(this);
        view2.removeOnAttachStateChangeListener(this);
    }

    public final void safelyRegisterForNextDraw() {
        if (Build.VERSION.SDK_INT < 26) {
            ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
            Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "view.viewTreeObserver");
            if (!viewTreeObserver.isAlive() || !NextDrawListenerKt.isAttachedToWindowCompat(this.view)) {
                this.view.addOnAttachStateChangeListener(this);
                return;
            }
        }
        this.view.getViewTreeObserver().addOnDrawListener(this);
    }
}
