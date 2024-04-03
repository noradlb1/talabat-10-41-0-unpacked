package com.huawei.hms.dtm.core;

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

public class ae implements Window.Callback {

    /* renamed from: a  reason: collision with root package name */
    private Window.Callback f48450a;

    public ae(Window.Callback callback) {
        this.f48450a = callback;
    }

    private void b() {
        C0402m.b().e();
        C0372g.a();
    }

    public Window.Callback a() {
        return this.f48450a;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        Window.Callback callback = this.f48450a;
        if (callback != null) {
            return callback.dispatchGenericMotionEvent(motionEvent);
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            C0392k.c().a();
            b();
        }
        Window.Callback callback = this.f48450a;
        if (callback != null) {
            return callback.dispatchKeyEvent(keyEvent);
        }
        return false;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        Window.Callback callback = this.f48450a;
        if (callback != null) {
            return callback.dispatchKeyShortcutEvent(keyEvent);
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Window.Callback callback = this.f48450a;
        if (callback != null) {
            return callback.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        C0392k.c().a();
        if (motionEvent.getAction() == 1) {
            b();
        }
        Window.Callback callback = this.f48450a;
        if (callback != null) {
            return callback.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        Window.Callback callback = this.f48450a;
        if (callback != null) {
            return callback.dispatchTrackballEvent(motionEvent);
        }
        return false;
    }

    public void onActionModeFinished(ActionMode actionMode) {
        Window.Callback callback = this.f48450a;
        if (callback != null) {
            callback.onActionModeFinished(actionMode);
        }
    }

    public void onActionModeStarted(ActionMode actionMode) {
        Window.Callback callback = this.f48450a;
        if (callback != null) {
            callback.onActionModeStarted(actionMode);
        }
    }

    public void onAttachedToWindow() {
        Window.Callback callback = this.f48450a;
        if (callback != null) {
            callback.onAttachedToWindow();
        }
    }

    public void onContentChanged() {
        Window.Callback callback = this.f48450a;
        if (callback != null) {
            callback.onContentChanged();
        }
    }

    public boolean onCreatePanelMenu(int i11, Menu menu) {
        Window.Callback callback = this.f48450a;
        if (callback != null) {
            return callback.onCreatePanelMenu(i11, menu);
        }
        return false;
    }

    public View onCreatePanelView(int i11) {
        Window.Callback callback = this.f48450a;
        if (callback != null) {
            return callback.onCreatePanelView(i11);
        }
        return null;
    }

    public void onDetachedFromWindow() {
        Window.Callback callback = this.f48450a;
        if (callback != null) {
            callback.onDetachedFromWindow();
        }
    }

    public boolean onMenuItemSelected(int i11, MenuItem menuItem) {
        Window.Callback callback = this.f48450a;
        if (callback != null) {
            return callback.onMenuItemSelected(i11, menuItem);
        }
        return false;
    }

    public boolean onMenuOpened(int i11, Menu menu) {
        Window.Callback callback = this.f48450a;
        if (callback != null) {
            return callback.onMenuOpened(i11, menu);
        }
        return false;
    }

    public void onPanelClosed(int i11, Menu menu) {
        Window.Callback callback = this.f48450a;
        if (callback != null) {
            callback.onPanelClosed(i11, menu);
        }
    }

    public boolean onPreparePanel(int i11, View view, Menu menu) {
        Window.Callback callback = this.f48450a;
        if (callback != null) {
            return callback.onPreparePanel(i11, view, menu);
        }
        return false;
    }

    public boolean onSearchRequested() {
        Window.Callback callback = this.f48450a;
        if (callback != null) {
            return callback.onSearchRequested();
        }
        return false;
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        Window.Callback callback = this.f48450a;
        if (callback != null) {
            return callback.onSearchRequested(searchEvent);
        }
        return false;
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        Window.Callback callback = this.f48450a;
        if (callback != null) {
            callback.onWindowAttributesChanged(layoutParams);
        }
    }

    public void onWindowFocusChanged(boolean z11) {
        Window.Callback callback = this.f48450a;
        if (callback != null) {
            callback.onWindowFocusChanged(z11);
        }
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        Window.Callback callback2 = this.f48450a;
        if (callback2 != null) {
            return callback2.onWindowStartingActionMode(callback);
        }
        return null;
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i11) {
        Window.Callback callback2 = this.f48450a;
        if (callback2 != null) {
            return callback2.onWindowStartingActionMode(callback, i11);
        }
        return null;
    }
}
