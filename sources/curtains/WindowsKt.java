package curtains;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewSpyInternalKt;
import android.view.Window;
import android.view.WindowManager;
import curtains.internal.HandlersKt;
import curtains.internal.WindowCallbackWrapper;
import curtains.internal.WindowListeners;
import curtains.internal.WindowSpy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u001f\u001a\u00020 *\u00020\u00032\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020 0!\u001a\u0018\u0010\"\u001a\u00020 *\u00020\u00032\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0#\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005\"\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005\"\u0017\u0010\f\u001a\u0004\u0018\u00010\u0003*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u001b\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0005\"\u0015\u0010\u0013\u001a\u00020\u0014*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0015\u0010\u0017\u001a\u00020\u0018*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001c*\u0004\u0018\u00010\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"keyEventInterceptors", "", "Lcurtains/KeyEventInterceptor;", "Landroid/view/Window;", "getKeyEventInterceptors", "(Landroid/view/Window;)Ljava/util/List;", "onContentChangedListeners", "Lcurtains/OnContentChangedListener;", "getOnContentChangedListeners", "onWindowFocusChangedListeners", "Lcurtains/OnWindowFocusChangedListener;", "getOnWindowFocusChangedListeners", "phoneWindow", "Landroid/view/View;", "getPhoneWindow", "(Landroid/view/View;)Landroid/view/Window;", "touchEventInterceptors", "Lcurtains/TouchEventInterceptor;", "getTouchEventInterceptors", "windowAttachCount", "", "getWindowAttachCount", "(Landroid/view/View;)I", "windowType", "Lcurtains/WindowType;", "getWindowType", "(Landroid/view/View;)Lcurtains/WindowType;", "wrappedCallback", "Landroid/view/Window$Callback;", "getWrappedCallback", "(Landroid/view/Window$Callback;)Landroid/view/Window$Callback;", "onDecorViewReady", "", "Lkotlin/Function1;", "onNextDraw", "Lkotlin/Function0;", "curtains_release"}, k = 2, mv = {1, 4, 1})
public final class WindowsKt {
    @NotNull
    public static final List<KeyEventInterceptor> getKeyEventInterceptors(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "$this$keyEventInterceptors");
        HandlersKt.checkMainThread();
        return WindowCallbackWrapper.Companion.getListeners(window).getKeyEventInterceptors();
    }

    @NotNull
    public static final List<OnContentChangedListener> getOnContentChangedListeners(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "$this$onContentChangedListeners");
        HandlersKt.checkMainThread();
        return WindowCallbackWrapper.Companion.getListeners(window).getOnContentChangedListeners();
    }

    @NotNull
    public static final List<OnWindowFocusChangedListener> getOnWindowFocusChangedListeners(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "$this$onWindowFocusChangedListeners");
        HandlersKt.checkMainThread();
        return WindowCallbackWrapper.Companion.getListeners(window).getOnWindowFocusChangedListeners();
    }

    @Nullable
    public static final Window getPhoneWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$phoneWindow");
        HandlersKt.checkMainThread();
        WindowSpy windowSpy = WindowSpy.INSTANCE;
        View rootView = view.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return windowSpy.pullWindow(rootView);
    }

    @NotNull
    public static final List<TouchEventInterceptor> getTouchEventInterceptors(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "$this$touchEventInterceptors");
        HandlersKt.checkMainThread();
        return WindowCallbackWrapper.Companion.getListeners(window).getTouchEventInterceptors();
    }

    public static final int getWindowAttachCount(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$windowAttachCount");
        HandlersKt.checkMainThread();
        return ViewSpyInternalKt.windowAttachCount(view);
    }

    @NotNull
    public static final WindowType getWindowType(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$windowType");
        HandlersKt.checkMainThread();
        View rootView = view.getRootView();
        WindowSpy windowSpy = WindowSpy.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        if (windowSpy.attachedToPhoneWindow(rootView)) {
            return WindowType.PHONE_WINDOW;
        }
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if (!(layoutParams instanceof WindowManager.LayoutParams)) {
            layoutParams = null;
        }
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) layoutParams;
        if (layoutParams2 == null) {
            return WindowType.UNKNOWN;
        }
        CharSequence title = layoutParams2.getTitle();
        if (Intrinsics.areEqual((Object) title, (Object) "Toast")) {
            return WindowType.TOAST;
        }
        if (Intrinsics.areEqual((Object) title, (Object) "Tooltip")) {
            return WindowType.TOOLTIP;
        }
        Intrinsics.checkNotNullExpressionValue(title, "title");
        if (StringsKt__StringsKt.startsWith$default(title, (CharSequence) "PopupWindow:", false, 2, (Object) null)) {
            return WindowType.POPUP_WINDOW;
        }
        return WindowType.UNKNOWN;
    }

    @Nullable
    public static final Window.Callback getWrappedCallback(@Nullable Window.Callback callback) {
        HandlersKt.checkMainThread();
        return WindowCallbackWrapper.Companion.unwrap(callback);
    }

    public static final void onDecorViewReady(@NotNull Window window, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(window, "$this$onDecorViewReady");
        Intrinsics.checkNotNullParameter(function1, "onDecorViewReady");
        HandlersKt.checkMainThread();
        View peekDecorView = window.peekDecorView();
        if (peekDecorView != null) {
            function1.invoke(peekDecorView);
            return;
        }
        WindowListeners listeners = WindowCallbackWrapper.Companion.getListeners(window);
        listeners.getOnContentChangedListeners().add(new WindowsKt$onDecorViewReady$$inlined$run$lambda$1(listeners, window, function1));
    }

    public static final void onNextDraw(@NotNull Window window, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(window, "$this$onNextDraw");
        Intrinsics.checkNotNullParameter(function0, "onNextDraw");
        onDecorViewReady(window, new WindowsKt$onNextDraw$1(function0));
    }
}
