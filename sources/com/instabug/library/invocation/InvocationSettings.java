package com.instabug.library.invocation;

import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.invocation.invoker.FloatingButtonInvoker;
import com.instabug.library.invocation.invoker.a;
import com.instabug.library.invocation.invoker.v;
import com.instabug.library.invocation.util.InstabugFloatingButtonEdge;
import com.instabug.library.invocation.util.InstabugVideoRecordingButtonPosition;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class InvocationSettings {
    private static final Object LOCK = new Object();
    public static final int SHAKE_DEFAULT_THRESHOLD = 650;
    private FloatingButtonInvoker.g floatingButtonParams = new FloatingButtonInvoker.g();
    private AtomicInteger shakeThreshold = new AtomicInteger(650);
    private InstabugVideoRecordingButtonPosition videoRecordingButtonPosition = InstabugVideoRecordingButtonPosition.BOTTOM_RIGHT;

    private void refreshButton() {
        List<a> a11 = InvocationManager.getInstance().a();
        if (a11 != null) {
            synchronized (LOCK) {
                Iterator<a> it = a11.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next instanceof FloatingButtonInvoker) {
                        ((FloatingButtonInvoker) next).updateButtonLocation();
                        break;
                    }
                }
            }
        }
    }

    public int a() {
        return this.shakeThreshold.get();
    }

    public FloatingButtonInvoker.g getFloatingButtonParams() {
        return this.floatingButtonParams;
    }

    public InstabugVideoRecordingButtonPosition getVideoRecordingButtonPosition() {
        return this.videoRecordingButtonPosition;
    }

    public void setFloatingButtonEdge(InstabugFloatingButtonEdge instabugFloatingButtonEdge) {
        if (Instabug.isEnabled()) {
            this.floatingButtonParams.f51334a = instabugFloatingButtonEdge;
            if (!InstabugCore.isForegroundBusy()) {
                refreshButton();
            }
        }
    }

    public void setFloatingButtonOffsetFromTop(int i11) {
        this.floatingButtonParams.f51335b = i11;
        refreshButton();
    }

    public void setShakingThreshold(int i11) {
        List<a> a11;
        if (i11 > 0 && (a11 = InvocationManager.getInstance().a()) != null) {
            synchronized (LOCK) {
                this.shakeThreshold.set(i11);
                for (a next : a11) {
                    if (next instanceof v) {
                        ((v) next).a(i11);
                    }
                }
            }
        }
    }

    public void setVideoRecordingButtonPosition(InstabugVideoRecordingButtonPosition instabugVideoRecordingButtonPosition) {
        this.videoRecordingButtonPosition = instabugVideoRecordingButtonPosition;
    }
}
