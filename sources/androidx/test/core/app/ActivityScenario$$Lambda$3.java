package androidx.test.core.app;

import androidx.test.internal.platform.ServiceLoaderWrapper;
import androidx.test.internal.platform.os.ControlledLooper;

final /* synthetic */ class ActivityScenario$$Lambda$3 implements ServiceLoaderWrapper.Factory {

    /* renamed from: a  reason: collision with root package name */
    public static final ServiceLoaderWrapper.Factory f37672a = new ActivityScenario$$Lambda$3();

    private ActivityScenario$$Lambda$3() {
    }

    public Object create() {
        return ControlledLooper.NO_OP_CONTROLLED_LOOPER;
    }
}
