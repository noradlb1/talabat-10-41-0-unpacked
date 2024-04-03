package androidx.compose.ui.platform;

import android.view.MotionEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"androidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1", "Ljava/lang/Runnable;", "run", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidComposeView$resendMotionEventRunnable$1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AndroidComposeView f9985b;

    public AndroidComposeView$resendMotionEventRunnable$1(AndroidComposeView androidComposeView) {
        this.f9985b = androidComposeView;
    }

    public void run() {
        boolean z11;
        this.f9985b.removeCallbacks(this);
        MotionEvent access$getPreviousMotionEvent$p = this.f9985b.previousMotionEvent;
        if (access$getPreviousMotionEvent$p != null) {
            boolean z12 = false;
            if (access$getPreviousMotionEvent$p.getToolType(0) == 3) {
                z11 = true;
            } else {
                z11 = false;
            }
            int actionMasked = access$getPreviousMotionEvent$p.getActionMasked();
            if (!z11 ? actionMasked != 1 : !(actionMasked == 10 || actionMasked == 1)) {
                z12 = true;
            }
            if (z12) {
                int i11 = 7;
                if (!(actionMasked == 7 || actionMasked == 9)) {
                    i11 = 2;
                }
                AndroidComposeView androidComposeView = this.f9985b;
                androidComposeView.sendSimulatedEvent(access$getPreviousMotionEvent$p, i11, androidComposeView.relayoutTime, false);
            }
        }
    }
}
