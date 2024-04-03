package com.uxcam.internals;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import java.util.ArrayList;
import java.util.List;

public class fd implements fc {
    public fd() {
        new Rect();
    }

    public List a(Activity activity) {
        Object obj;
        Object[] objArr;
        PopupWindow popupWindow;
        Window window;
        ArrayList arrayList = new ArrayList();
        try {
            ex.a("mWindowManager", (Class) activity.getWindowManager().getClass());
            obj = ex.a("mWindowManager", (Object) activity.getWindowManager());
        } catch (NoSuchFieldException unused) {
            obj = ex.a("mGlobal", (Object) activity.getWindowManager());
        }
        Object a11 = ex.a("mRoots", obj);
        Object a12 = ex.a("mParams", obj);
        Object[] array = ((List) a11).toArray();
        List list = (List) a12;
        WindowManager.LayoutParams[] layoutParamsArr = (WindowManager.LayoutParams[]) list.toArray(new WindowManager.LayoutParams[list.size()]);
        char c11 = 0;
        int i11 = 0;
        while (i11 < array.length) {
            View view = (View) ex.a("mView", array[i11]);
            int[] iArr = new int[2];
            if (view != null) {
                view.getLocationOnScreen(iArr);
                int i12 = iArr[c11];
                objArr = array;
                Rect rect = new Rect(i12, iArr[1], view.getWidth() + i12, view.getHeight() + iArr[1]);
                if (view.isShown()) {
                    arrayList.add(new io(view, rect, layoutParamsArr[i11]));
                    fl a13 = fl.a();
                    if (!a13.f13357b) {
                        a13.f13357b = true;
                        a13.a(rect);
                    }
                }
                if (!(view.getContext() instanceof Activity)) {
                    it itVar = (it) fs.a().f13403f;
                    itVar.getClass();
                    try {
                        if (Build.VERSION.SDK_INT >= 24) {
                            window = (Window) ex.a("mWindow", (Object) view);
                        } else {
                            window = (Window) ex.a("this$0", (Object) view);
                        }
                        if (window != null) {
                            Window.Callback callback = window.getCallback();
                            if (!(callback instanceof hw) && callback != null) {
                                window.setCallback(new hw(callback));
                            }
                        }
                    } catch (ClassCastException e11) {
                        fx fxVar = new fx();
                        fxVar.a("EXCEPTION");
                        fxVar.a("site_of_error", "ScreenshotTaker::findWindowAndAttachListener()");
                        fxVar.a("reason", e11.getMessage());
                        fxVar.a(2);
                        try {
                            if (Build.VERSION.SDK_INT >= 24) {
                                popupWindow = (PopupWindow) ex.a("mWindow", (Object) view);
                            } else {
                                popupWindow = (PopupWindow) ex.a("this$0", (Object) view);
                            }
                            if (popupWindow != null) {
                                popupWindow.setTouchInterceptor(new is(itVar));
                            }
                        } catch (Exception e12) {
                            fx fxVar2 = new fx();
                            fxVar2.a("EXCEPTION");
                            fxVar2.a("site_of_error", "ScreenshotTaker::findWindowAndAttachListener()");
                            fxVar2.a("reason", e12.getMessage());
                            fxVar2.a(2);
                        }
                    } catch (Exception e13) {
                        fx fxVar3 = new fx();
                        fxVar3.a("EXCEPTION");
                        fxVar3.a("site_of_error", "ScreenshotTaker::findWindowAndAttachListener()");
                        fxVar3.a("reason", e13.getMessage());
                        fxVar3.a(2);
                    }
                }
            } else {
                objArr = array;
            }
            i11++;
            array = objArr;
            c11 = 0;
        }
        return arrayList;
    }
}
