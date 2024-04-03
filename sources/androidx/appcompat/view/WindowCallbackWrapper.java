package androidx.appcompat.view;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class WindowCallbackWrapper implements Window.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final Window.Callback f687b;

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static boolean a(Window.Callback callback, SearchEvent searchEvent) {
            return callback.onSearchRequested(searchEvent);
        }

        @DoNotInline
        public static ActionMode b(Window.Callback callback, ActionMode.Callback callback2, int i11) {
            return callback.onWindowStartingActionMode(callback2, i11);
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static void a(Window.Callback callback, List<KeyboardShortcutGroup> list, Menu menu, int i11) {
            callback.onProvideKeyboardShortcuts(list, menu, i11);
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static void a(Window.Callback callback, boolean z11) {
            callback.onPointerCaptureChanged(z11);
        }
    }

    public WindowCallbackWrapper(Window.Callback callback) {
        if (callback != null) {
            this.f687b = callback;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f687b.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f687b.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f687b.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f687b.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f687b.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f687b.dispatchTrackballEvent(motionEvent);
    }

    public final Window.Callback getWrapped() {
        return this.f687b;
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f687b.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f687b.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.f687b.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.f687b.onContentChanged();
    }

    public boolean onCreatePanelMenu(int i11, Menu menu) {
        return this.f687b.onCreatePanelMenu(i11, menu);
    }

    public View onCreatePanelView(int i11) {
        return this.f687b.onCreatePanelView(i11);
    }

    public void onDetachedFromWindow() {
        this.f687b.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int i11, MenuItem menuItem) {
        return this.f687b.onMenuItemSelected(i11, menuItem);
    }

    public boolean onMenuOpened(int i11, Menu menu) {
        return this.f687b.onMenuOpened(i11, menu);
    }

    public void onPanelClosed(int i11, Menu menu) {
        this.f687b.onPanelClosed(i11, menu);
    }

    @RequiresApi(26)
    public void onPointerCaptureChanged(boolean z11) {
        Api26Impl.a(this.f687b, z11);
    }

    public boolean onPreparePanel(int i11, View view, Menu menu) {
        return this.f687b.onPreparePanel(i11, view, menu);
    }

    @RequiresApi(24)
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i11) {
        Api24Impl.a(this.f687b, list, menu, i11);
    }

    @RequiresApi(23)
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return Api23Impl.a(this.f687b, searchEvent);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f687b.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z11) {
        this.f687b.onWindowFocusChanged(z11);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f687b.onWindowStartingActionMode(callback);
    }

    public boolean onSearchRequested() {
        return this.f687b.onSearchRequested();
    }

    @RequiresApi(23)
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i11) {
        return Api23Impl.b(this.f687b, callback, i11);
    }
}
