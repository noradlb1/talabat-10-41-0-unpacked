package androidx.test.internal.platform.os;

import android.view.View;

public interface ControlledLooper {
    public static final ControlledLooper NO_OP_CONTROLLED_LOOPER = new ControlledLooper() {
        public void drainMainThreadUntilIdle() {
        }

        public void simulateWindowFocus(View view) {
        }
    };

    void drainMainThreadUntilIdle();

    void simulateWindowFocus(View view);
}
