package com.instabug.library.tracking;

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
import androidx.annotation.Nullable;

public class o implements Window.Callback {

    /* renamed from: a  reason: collision with root package name */
    private Window.Callback f51943a;

    public o(Window.Callback callback) {
        this.f51943a = callback;
    }

    @Nullable
    public Window.Callback a() {
        return this.f51943a;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        try {
            return this.f51943a.dispatchGenericMotionEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        try {
            return this.f51943a.dispatchKeyEvent(keyEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        try {
            return this.f51943a.dispatchKeyShortcutEvent(keyEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        try {
            return this.f51943a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            Window.Callback callback = this.f51943a;
            if (callback != null) {
                boolean dispatchTouchEvent = callback.dispatchTouchEvent(motionEvent);
                j.a(motionEvent);
                return dispatchTouchEvent;
            }
            j.a(motionEvent);
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        try {
            return this.f51943a.dispatchTrackballEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public void onActionModeFinished(ActionMode actionMode) {
        try {
            this.f51943a.onActionModeFinished(actionMode);
        } catch (Exception unused) {
        }
    }

    public void onActionModeStarted(ActionMode actionMode) {
        try {
            this.f51943a.onActionModeStarted(actionMode);
        } catch (Exception unused) {
        }
    }

    public void onAttachedToWindow() {
        try {
            this.f51943a.onAttachedToWindow();
        } catch (Exception unused) {
        }
    }

    public void onContentChanged() {
        try {
            this.f51943a.onContentChanged();
        } catch (Exception unused) {
        }
    }

    public boolean onCreatePanelMenu(int i11, Menu menu) {
        try {
            return this.f51943a.onCreatePanelMenu(i11, menu);
        } catch (Exception unused) {
            return false;
        }
    }

    @Nullable
    public View onCreatePanelView(int i11) {
        try {
            return this.f51943a.onCreatePanelView(i11);
        } catch (Exception unused) {
            return null;
        }
    }

    public void onDetachedFromWindow() {
        try {
            this.f51943a.onDetachedFromWindow();
        } catch (Exception unused) {
        }
    }

    public boolean onMenuItemSelected(int i11, MenuItem menuItem) {
        try {
            return this.f51943a.onMenuItemSelected(i11, menuItem);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean onMenuOpened(int i11, Menu menu) {
        try {
            return this.f51943a.onMenuOpened(i11, menu);
        } catch (Exception unused) {
            return false;
        }
    }

    public void onPanelClosed(int i11, Menu menu) {
        try {
            this.f51943a.onPanelClosed(i11, menu);
        } catch (Exception unused) {
        }
    }

    public boolean onPreparePanel(int i11, @Nullable View view, Menu menu) {
        try {
            return this.f51943a.onPreparePanel(i11, view, menu);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean onSearchRequested() {
        try {
            return this.f51943a.onSearchRequested();
        } catch (Exception unused) {
            return false;
        }
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        try {
            this.f51943a.onWindowAttributesChanged(layoutParams);
        } catch (Exception unused) {
        }
    }

    public void onWindowFocusChanged(boolean z11) {
        try {
            this.f51943a.onWindowFocusChanged(z11);
        } catch (Exception unused) {
        }
    }

    @Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        try {
            return this.f51943a.onWindowStartingActionMode(callback);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        try {
            this.f51943a.onSearchRequested(searchEvent);
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i11) {
        try {
            return this.f51943a.onWindowStartingActionMode(callback, i11);
        } catch (Exception unused) {
            return null;
        }
    }
}
