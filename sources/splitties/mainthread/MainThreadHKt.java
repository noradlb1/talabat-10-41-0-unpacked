package splitties.mainthread;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\t\u0010\u0000\u001a\u00020\u0001H\b\u001a\t\u0010\u0002\u001a\u00020\u0001H\b¨\u0006\u0003"}, d2 = {"checkMainThread", "", "checkNotMainThread", "splitties-mainthread_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class MainThreadHKt {
    public static final void checkMainThread() {
        boolean z11;
        if (MainThreadKt.mainThread == Thread.currentThread()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalStateException(Intrinsics.stringPlus("This should ONLY be called on the main thread! Current: ", Thread.currentThread()).toString());
        }
    }

    public static final void checkNotMainThread() {
        boolean z11;
        if (MainThreadKt.mainThread == Thread.currentThread()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!(!z11)) {
            throw new IllegalStateException(Intrinsics.stringPlus("This should NEVER be called on the main thread! Current: ", Thread.currentThread()).toString());
        }
    }
}
