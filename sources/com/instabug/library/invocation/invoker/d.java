package com.instabug.library.invocation.invoker;

import com.instabug.library.internal.media.AudioPlayer;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.library.util.TimeUtils;

class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f51339b;

    public d(p pVar) {
        this.f51339b = pVar;
    }

    public void run() {
        int millisToSeconds;
        if (this.f51339b.f51372k) {
            long currentTimeMillis = System.currentTimeMillis() - this.f51339b.f51385x;
            if (this.f51339b.A != null) {
                this.f51339b.A.a(AudioPlayer.getFormattedDurationText(currentTimeMillis), true);
                if (AccessibilityUtils.isAccessibilityServiceEnabled() && (millisToSeconds = TimeUtils.millisToSeconds(currentTimeMillis)) != 0 && millisToSeconds % 10 == 0) {
                    this.f51339b.a();
                }
            }
            if (currentTimeMillis > 30000) {
                this.f51339b.B.stop(this.f51339b.d());
            }
            this.f51339b.f51384w.postDelayed(this, 1000);
        }
    }
}
