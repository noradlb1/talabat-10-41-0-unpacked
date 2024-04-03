package androidx.test.platform.ui;

import android.view.KeyEvent;
import android.view.MotionEvent;

public interface UiController {
    boolean injectKeyEvent(KeyEvent keyEvent) throws InjectEventSecurityException;

    boolean injectMotionEvent(MotionEvent motionEvent) throws InjectEventSecurityException;

    boolean injectString(String str) throws InjectEventSecurityException;

    void loopMainThreadForAtLeast(long j11);

    void loopMainThreadUntilIdle();
}
