package com.instabug.bug.screenshot.viewhierarchy;

import android.app.Activity;
import com.instabug.bug.screenshot.f;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static f f45740a;

    public static synchronized void a(Activity activity) {
        synchronized (a.class) {
            f fVar = f45740a;
            if (fVar != null) {
                fVar.a(activity.getApplicationContext());
            }
            f fVar2 = new f();
            f45740a = fVar2;
            fVar2.b(activity);
        }
    }
}
