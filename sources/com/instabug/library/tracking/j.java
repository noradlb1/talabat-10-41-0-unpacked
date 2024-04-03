package com.instabug.library.tracking;

import android.view.MotionEvent;
import com.instabug.library.Instabug;
import com.instabug.library.invocation.InstabugInvocationEvent;
import com.instabug.library.invocation.InvocationManager;

public abstract class j {
    public static void a(MotionEvent motionEvent) {
        if (Instabug.isEnabled()) {
            if (a()) {
                InvocationManager.getInstance().handle(motionEvent);
            }
            if (motionEvent != null) {
                InstabugInternalTrackingDelegate.getInstance().o(motionEvent);
            }
        }
    }

    private static boolean a() {
        InstabugInvocationEvent[] currentInstabugInvocationEvents = InvocationManager.getInstance().getCurrentInstabugInvocationEvents();
        if (currentInstabugInvocationEvents != null) {
            for (InstabugInvocationEvent instabugInvocationEvent : currentInstabugInvocationEvents) {
                if (instabugInvocationEvent == InstabugInvocationEvent.TWO_FINGER_SWIPE_LEFT) {
                    return true;
                }
            }
        }
        return false;
    }
}
