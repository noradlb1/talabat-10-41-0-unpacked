package curtains;

import android.view.KeyEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcurtains/OnKeyEventListener;", "Lcurtains/KeyEventInterceptor;", "intercept", "Lcurtains/DispatchState;", "keyEvent", "Landroid/view/KeyEvent;", "dispatch", "Lkotlin/Function1;", "onKeyEvent", "", "curtains_release"}, k = 1, mv = {1, 4, 1})
public interface OnKeyEventListener extends KeyEventInterceptor {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static final class DefaultImpls {
        @NotNull
        public static DispatchState intercept(@NotNull OnKeyEventListener onKeyEventListener, @NotNull KeyEvent keyEvent, @NotNull Function1<? super KeyEvent, ? extends DispatchState> function1) {
            Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
            Intrinsics.checkNotNullParameter(function1, "dispatch");
            onKeyEventListener.onKeyEvent(keyEvent);
            return (DispatchState) function1.invoke(keyEvent);
        }
    }

    @NotNull
    DispatchState intercept(@NotNull KeyEvent keyEvent, @NotNull Function1<? super KeyEvent, ? extends DispatchState> function1);

    void onKeyEvent(@NotNull KeyEvent keyEvent);
}
