package com.uxcam.internals;

import android.annotation.SuppressLint;
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
import java.util.List;

public class hw implements Window.Callback {

    /* renamed from: a  reason: collision with root package name */
    public Window.Callback f13609a;

    public hw(Window.Callback callback) {
        this.f13609a = callback;
    }

    @SuppressLint({"NewApi"})
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f13609a.dispatchGenericMotionEvent(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        com.uxcam.internals.gu.a("UXWindowCallback").getClass();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        com.uxcam.internals.gu.a("UXWindowCallback").getClass();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(android.view.KeyEvent r4) {
        /*
            r3 = this;
            java.lang.String r0 = "UXWindowCallback"
            int r1 = r4.getAction()     // Catch:{ Exception -> 0x000d }
            r2 = 1
            if (r1 != r2) goto L_0x0014
            r4.getKeyCode()     // Catch:{ Exception -> 0x000d }
            goto L_0x0014
        L_0x000d:
            com.uxcam.internals.gu$ab r1 = com.uxcam.internals.gu.a(r0)     // Catch:{ Exception -> 0x001d }
            r1.getClass()     // Catch:{ Exception -> 0x001d }
        L_0x0014:
            android.view.Window$Callback r1 = r3.f13609a     // Catch:{ Exception -> 0x001d }
            if (r1 == 0) goto L_0x0024
            boolean r4 = r1.dispatchKeyEvent(r4)     // Catch:{ Exception -> 0x001d }
            return r4
        L_0x001d:
            com.uxcam.internals.gu$ab r4 = com.uxcam.internals.gu.a(r0)
            r4.getClass()
        L_0x0024:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.hw.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @SuppressLint({"NewApi"})
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f13609a.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f13609a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z11;
        try {
            hk hkVar = hm.f13568k;
            if (hkVar != null) {
                hkVar.a(motionEvent);
            }
        } catch (Exception unused) {
            gu.a("UXWindowCallback").getClass();
        }
        try {
            z11 = this.f13609a.dispatchTouchEvent(motionEvent);
        } catch (Exception unused2) {
            gu.a("UXWindowCallback").getClass();
            z11 = false;
        }
        String str = ib.f13620d;
        return z11;
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f13609a.dispatchTrackballEvent(motionEvent);
    }

    @SuppressLint({"NewApi"})
    public void onActionModeFinished(ActionMode actionMode) {
        this.f13609a.onActionModeFinished(actionMode);
    }

    @SuppressLint({"NewApi"})
    public void onActionModeStarted(ActionMode actionMode) {
        this.f13609a.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.f13609a.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.f13609a.onContentChanged();
    }

    public boolean onCreatePanelMenu(int i11, Menu menu) {
        return this.f13609a.onCreatePanelMenu(i11, menu);
    }

    public View onCreatePanelView(int i11) {
        return this.f13609a.onCreatePanelView(i11);
    }

    public void onDetachedFromWindow() {
        this.f13609a.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int i11, MenuItem menuItem) {
        try {
            return this.f13609a.onMenuItemSelected(i11, menuItem);
        } catch (Exception e11) {
            fx fxVar = new fx();
            fxVar.a("EXCEPTION");
            fxVar.a("site_of_error", "UXWindowCallback::onMenuItemSelected()");
            fxVar.a("reason", e11.getMessage());
            fxVar.a(2);
            return false;
        }
    }

    public boolean onMenuOpened(int i11, Menu menu) {
        return this.f13609a.onMenuOpened(i11, menu);
    }

    public void onPanelClosed(int i11, Menu menu) {
        this.f13609a.onPanelClosed(i11, menu);
    }

    public void onPointerCaptureChanged(boolean z11) {
    }

    public boolean onPreparePanel(int i11, View view, Menu menu) {
        return this.f13609a.onPreparePanel(i11, view, menu);
    }

    public void onProvideKeyboardShortcuts(List list, @Nullable Menu menu, int i11) {
    }

    public boolean onSearchRequested() {
        return this.f13609a.onSearchRequested();
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return false;
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f13609a.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z11) {
        this.f13609a.onWindowFocusChanged(z11);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f13609a.onWindowStartingActionMode(callback);
    }

    @Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i11) {
        return null;
    }
}
