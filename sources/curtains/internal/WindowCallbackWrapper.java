package curtains.internal;

import android.annotation.NonNull;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import curtains.DispatchState;
import curtains.KeyEventInterceptor;
import curtains.OnContentChangedListener;
import curtains.OnWindowFocusChangedListener;
import curtains.TouchEventInterceptor;
import java.lang.reflect.Field;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.implementation.MethodDelegation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 /2\u00020\u0001:\u0001/B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0019\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0001J\u0012\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0019\u0010\u000f\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\u000e0\u000eH\u0001J\u0019\u0010\u0010\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\u00110\u0011H\u0001J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\u0019\u0010\u0013\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\u00160\u0016H\u0001J\u0019\u0010\u0017\u001a\u00020\u00152\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\u00160\u0016H\u0001J\t\u0010\u0018\u001a\u00020\u0015H\u0001J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u001b\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\u001dH\u0001J\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\t\u001a\u00020\u001bH\u0001J\t\u0010 \u001a\u00020\u0015H\u0001J\u001b\u0010!\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\"H\u0001J\u001b\u0010#\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\u001dH\u0001J\u001b\u0010$\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\u001dH\u0001J'\u0010%\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u001b2\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u001f2\b\b\u0001\u0010&\u001a\u00020\u001dH\u0001J\t\u0010'\u001a\u00020\bH\u0001J\u0019\u0010'\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010(0(H\u0001J\u0019\u0010)\u001a\u00020\u00152\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010*0*H\u0001J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\bH\u0016J\u001b\u0010-\u001a\u0004\u0018\u00010\u00162\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010.0.H\u0001J#\u0010-\u001a\u0004\u0018\u00010\u00162\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010.0.2\u0006\u0010\u001c\u001a\u00020\u001bH\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\b\u0006¨\u00060"}, d2 = {"Lcurtains/internal/WindowCallbackWrapper;", "Landroid/view/Window$Callback;", "delegate", "listeners", "Lcurtains/internal/WindowListeners;", "(Landroid/view/Window$Callback;Lcurtains/internal/WindowListeners;)V", "listeners$1", "dispatchGenericMotionEvent", "", "p0", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "dispatchKeyShortcutEvent", "dispatchPopulateAccessibilityEvent", "Landroid/view/accessibility/AccessibilityEvent;", "dispatchTouchEvent", "dispatchTrackballEvent", "onActionModeFinished", "", "Landroid/view/ActionMode;", "onActionModeStarted", "onAttachedToWindow", "onContentChanged", "onCreatePanelMenu", "", "p1", "Landroid/view/Menu;", "onCreatePanelView", "Landroid/view/View;", "onDetachedFromWindow", "onMenuItemSelected", "Landroid/view/MenuItem;", "onMenuOpened", "onPanelClosed", "onPreparePanel", "p2", "onSearchRequested", "Landroid/view/SearchEvent;", "onWindowAttributesChanged", "Landroid/view/WindowManager$LayoutParams;", "onWindowFocusChanged", "hasFocus", "onWindowStartingActionMode", "Landroid/view/ActionMode$Callback;", "Companion", "curtains_release"}, k = 1, mv = {1, 4, 1})
public final class WindowCallbackWrapper implements Window.Callback {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy jetpackWrappedField$delegate;
    /* access modifiers changed from: private */
    public static final Lazy jetpackWrapperClass$delegate;
    /* access modifiers changed from: private */
    public final Window.Callback delegate;
    /* access modifiers changed from: private */
    public final WindowListeners listeners$1;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0013\u001a\u00020\u0014*\u00020\u0015H\u0002J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0015*\u0004\u0018\u00010\u0015H\u0010R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R%\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u000e\u001a\u00020\u000f*\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcurtains/internal/WindowCallbackWrapper$Companion;", "", "()V", "jetpackWrappedField", "Ljava/lang/reflect/Field;", "getJetpackWrappedField", "()Ljava/lang/reflect/Field;", "jetpackWrappedField$delegate", "Lkotlin/Lazy;", "jetpackWrapperClass", "Ljava/lang/Class;", "getJetpackWrapperClass", "()Ljava/lang/Class;", "jetpackWrapperClass$delegate", "listeners", "Lcurtains/internal/WindowListeners;", "Landroid/view/Window;", "getListeners", "(Landroid/view/Window;)Lcurtains/internal/WindowListeners;", "canUnwrapFromJetpack", "", "Landroid/view/Window$Callback;", "unwrap", "curtains_release"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean canUnwrapFromJetpack(Window.Callback callback) {
            if (getJetpackWrappedField() != null) {
                Class<? extends Object> jetpackWrapperClass = getJetpackWrapperClass();
                Intrinsics.checkNotNull(jetpackWrapperClass);
                if (jetpackWrapperClass.isInstance(callback)) {
                    return true;
                }
            }
            return false;
        }

        private final Field getJetpackWrappedField() {
            return (Field) WindowCallbackWrapper.jetpackWrappedField$delegate.getValue();
        }

        /* access modifiers changed from: private */
        public final Class<? extends Object> getJetpackWrapperClass() {
            return (Class) WindowCallbackWrapper.jetpackWrapperClass$delegate.getValue();
        }

        @NotNull
        public final WindowListeners getListeners(@NotNull Window window) {
            Intrinsics.checkNotNullParameter(window, "$this$listeners");
            Window.Callback callback = window.getCallback();
            if (callback == null) {
                return new WindowListeners();
            }
            if (callback instanceof WindowCallbackWrapper) {
                return ((WindowCallbackWrapper) callback).listeners$1;
            }
            WindowListeners windowListeners = new WindowListeners();
            window.setCallback(new WindowCallbackWrapper(callback, windowListeners));
            return windowListeners;
        }

        @Nullable
        public final Window.Callback unwrap(@Nullable Window.Callback callback) {
            while (callback != null) {
                if (callback instanceof WindowCallbackWrapper) {
                    callback = ((WindowCallbackWrapper) callback).delegate;
                } else if (!canUnwrapFromJetpack(callback)) {
                    return callback;
                } else {
                    Field jetpackWrappedField = getJetpackWrappedField();
                    Intrinsics.checkNotNull(jetpackWrappedField);
                    callback = (Window.Callback) jetpackWrappedField.get(callback);
                }
            }
            return null;
        }
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        jetpackWrapperClass$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, WindowCallbackWrapper$Companion$jetpackWrapperClass$2.INSTANCE);
        jetpackWrappedField$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, WindowCallbackWrapper$Companion$jetpackWrappedField$2.INSTANCE);
    }

    public WindowCallbackWrapper(@NotNull Window.Callback callback, @NotNull WindowListeners windowListeners) {
        Intrinsics.checkNotNullParameter(callback, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        Intrinsics.checkNotNullParameter(windowListeners, "listeners");
        this.delegate = callback;
        this.listeners$1 = windowListeners;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.delegate.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(@Nullable KeyEvent keyEvent) {
        DispatchState dispatchState;
        if (keyEvent == null) {
            return this.delegate.dispatchKeyEvent(keyEvent);
        }
        Iterator<KeyEventInterceptor> it = this.listeners$1.getKeyEventInterceptors().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "listeners.keyEventInterceptors.iterator()");
        WindowCallbackWrapper$dispatchKeyEvent$dispatch$1 windowCallbackWrapper$dispatchKeyEvent$dispatch$1 = new WindowCallbackWrapper$dispatchKeyEvent$dispatch$1(this, it);
        if (it.hasNext()) {
            dispatchState = it.next().intercept(keyEvent, windowCallbackWrapper$dispatchKeyEvent$dispatch$1);
        } else {
            dispatchState = DispatchState.Companion.from$curtains_release(this.delegate.dispatchKeyEvent(keyEvent));
        }
        return dispatchState instanceof DispatchState.Consumed;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.delegate.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.delegate.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(@Nullable MotionEvent motionEvent) {
        DispatchState dispatchState;
        if (motionEvent == null) {
            return this.delegate.dispatchTouchEvent(motionEvent);
        }
        Iterator<TouchEventInterceptor> it = this.listeners$1.getTouchEventInterceptors().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "listeners.touchEventInterceptors.iterator()");
        WindowCallbackWrapper$dispatchTouchEvent$dispatch$1 windowCallbackWrapper$dispatchTouchEvent$dispatch$1 = new WindowCallbackWrapper$dispatchTouchEvent$dispatch$1(this, it);
        if (it.hasNext()) {
            dispatchState = it.next().intercept(motionEvent, windowCallbackWrapper$dispatchTouchEvent$dispatch$1);
        } else {
            dispatchState = DispatchState.Companion.from$curtains_release(this.delegate.dispatchTouchEvent(motionEvent));
        }
        return dispatchState instanceof DispatchState.Consumed;
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.delegate.dispatchTrackballEvent(motionEvent);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.delegate.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.delegate.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.delegate.onAttachedToWindow();
    }

    public void onContentChanged() {
        for (OnContentChangedListener onContentChanged : this.listeners$1.getOnContentChangedListeners()) {
            onContentChanged.onContentChanged();
        }
        this.delegate.onContentChanged();
    }

    public boolean onCreatePanelMenu(int i11, @NonNull @NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "p1");
        return this.delegate.onCreatePanelMenu(i11, menu);
    }

    @Nullable
    @android.annotation.Nullable
    public View onCreatePanelView(int i11) {
        return this.delegate.onCreatePanelView(i11);
    }

    public void onDetachedFromWindow() {
        this.delegate.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int i11, @NonNull @NotNull MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "p1");
        return this.delegate.onMenuItemSelected(i11, menuItem);
    }

    public boolean onMenuOpened(int i11, @NonNull @NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "p1");
        return this.delegate.onMenuOpened(i11, menu);
    }

    public void onPanelClosed(int i11, @NonNull @NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "p1");
        this.delegate.onPanelClosed(i11, menu);
    }

    public boolean onPreparePanel(int i11, @Nullable @android.annotation.Nullable View view, @NonNull @NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "p2");
        return this.delegate.onPreparePanel(i11, view, menu);
    }

    public boolean onSearchRequested() {
        return this.delegate.onSearchRequested();
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.delegate.onSearchRequested(searchEvent);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.delegate.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z11) {
        for (OnWindowFocusChangedListener onWindowFocusChanged : this.listeners$1.getOnWindowFocusChangedListeners()) {
            onWindowFocusChanged.onWindowFocusChanged(z11);
        }
        this.delegate.onWindowFocusChanged(z11);
    }

    @Nullable
    @android.annotation.Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.delegate.onWindowStartingActionMode(callback);
    }

    @Nullable
    @android.annotation.Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i11) {
        return this.delegate.onWindowStartingActionMode(callback, i11);
    }
}
