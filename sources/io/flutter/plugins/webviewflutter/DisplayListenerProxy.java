package io.flutter.plugins.webviewflutter;

import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

class DisplayListenerProxy {
    private static final String TAG = "DisplayListenerProxy";
    private ArrayList<DisplayManager.DisplayListener> listenersBeforeWebView;

    private static ArrayList<DisplayManager.DisplayListener> yoinkDisplayListeners(DisplayManager displayManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new ArrayList<>();
        }
        try {
            Field declaredField = DisplayManager.class.getDeclaredField("mGlobal");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(displayManager);
            Field declaredField2 = obj.getClass().getDeclaredField("mDisplayListeners");
            declaredField2.setAccessible(true);
            ArrayList<DisplayManager.DisplayListener> arrayList = new ArrayList<>();
            Iterator it = ((ArrayList) declaredField2.get(obj)).iterator();
            Field field = null;
            while (it.hasNext()) {
                Object next = it.next();
                if (field == null) {
                    field = next.getClass().getField("mListener");
                    field.setAccessible(true);
                }
                arrayList.add((DisplayManager.DisplayListener) field.get(next));
            }
            return arrayList;
        } catch (IllegalAccessException | NoSuchFieldException e11) {
            Log.w(TAG, "Could not extract WebView's display listeners. " + e11);
            return new ArrayList<>();
        }
    }

    public void a(final DisplayManager displayManager) {
        final ArrayList<DisplayManager.DisplayListener> yoinkDisplayListeners = yoinkDisplayListeners(displayManager);
        yoinkDisplayListeners.removeAll(this.listenersBeforeWebView);
        if (!yoinkDisplayListeners.isEmpty()) {
            Iterator<DisplayManager.DisplayListener> it = yoinkDisplayListeners.iterator();
            while (it.hasNext()) {
                displayManager.unregisterDisplayListener(it.next());
                displayManager.registerDisplayListener(new DisplayManager.DisplayListener() {
                    public void onDisplayAdded(int i11) {
                        Iterator it = yoinkDisplayListeners.iterator();
                        while (it.hasNext()) {
                            ((DisplayManager.DisplayListener) it.next()).onDisplayAdded(i11);
                        }
                    }

                    public void onDisplayChanged(int i11) {
                        if (displayManager.getDisplay(i11) != null) {
                            Iterator it = yoinkDisplayListeners.iterator();
                            while (it.hasNext()) {
                                ((DisplayManager.DisplayListener) it.next()).onDisplayChanged(i11);
                            }
                        }
                    }

                    public void onDisplayRemoved(int i11) {
                        Iterator it = yoinkDisplayListeners.iterator();
                        while (it.hasNext()) {
                            ((DisplayManager.DisplayListener) it.next()).onDisplayRemoved(i11);
                        }
                    }
                }, (Handler) null);
            }
        }
    }

    public void b(DisplayManager displayManager) {
        this.listenersBeforeWebView = yoinkDisplayListeners(displayManager);
    }
}
