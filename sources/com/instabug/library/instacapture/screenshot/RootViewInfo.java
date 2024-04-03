package com.instabug.library.instacapture.screenshot;

import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;

public class RootViewInfo {
    private final WindowManager.LayoutParams layoutParams;
    private final int left;
    private final Rect rect;
    private final int top;
    private final View view;

    public RootViewInfo(View view2, Rect rect2, WindowManager.LayoutParams layoutParams2) {
        this.view = view2;
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        this.left = iArr[0];
        this.top = iArr[1];
        this.rect = rect2;
        this.layoutParams = layoutParams2;
    }

    public WindowManager.LayoutParams getLayoutParams() {
        return this.layoutParams;
    }

    public int getLeft() {
        return this.left;
    }

    public Rect getRect() {
        return this.rect;
    }

    public int getTop() {
        return this.top;
    }

    public View getView() {
        return this.view;
    }

    public boolean isDialog() {
        return this.layoutParams.type == 2;
    }
}
