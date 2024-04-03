package splitties.bundle;

import android.os.Bundle;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.PublishedApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import splitties.mainthread.MainThreadKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R.\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048@@@X\u000e¢\u0006\u0012\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR#\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00128@@@X\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\f8BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u0018\u0010\u000eR\u000e\u0010\u001a\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lsplitties/bundle/BundleSpec;", "", "()V", "value", "Landroid/os/Bundle;", "currentBundle", "getCurrentBundle$annotations", "getCurrentBundle", "()Landroid/os/Bundle;", "setCurrentBundle", "(Landroid/os/Bundle;)V", "currentBundleByThread", "Ljava/lang/ThreadLocal;", "getCurrentBundleByThread", "()Ljava/lang/ThreadLocal;", "currentBundleByThread$delegate", "Lkotlin/Lazy;", "currentBundleMainThread", "", "isReadOnly", "isReadOnly$annotations", "()Z", "setReadOnly", "(Z)V", "isReadOnlyByThread", "isReadOnlyByThread$delegate", "isReadOnlyMainThread", "splitties-bundle_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class BundleSpec {
    @NotNull
    private final Lazy currentBundleByThread$delegate = LazyKt__LazyJVMKt.lazy(BundleSpec$currentBundleByThread$2.INSTANCE);
    @Nullable
    private Bundle currentBundleMainThread;
    @NotNull
    private final Lazy isReadOnlyByThread$delegate = LazyKt__LazyJVMKt.lazy(BundleSpec$isReadOnlyByThread$2.INSTANCE);
    private boolean isReadOnlyMainThread;

    @PublishedApi
    public static /* synthetic */ void getCurrentBundle$annotations() {
    }

    private final ThreadLocal<Bundle> getCurrentBundleByThread() {
        return (ThreadLocal) this.currentBundleByThread$delegate.getValue();
    }

    @PublishedApi
    public static /* synthetic */ void isReadOnly$annotations() {
    }

    private final ThreadLocal<Boolean> isReadOnlyByThread() {
        return (ThreadLocal) this.isReadOnlyByThread$delegate.getValue();
    }

    @Nullable
    public final Bundle getCurrentBundle() {
        boolean z11;
        if (MainThreadKt.mainThread == Thread.currentThread()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return this.currentBundleMainThread;
        }
        return getCurrentBundleByThread().get();
    }

    public final boolean isReadOnly() {
        boolean z11;
        if (MainThreadKt.mainThread == Thread.currentThread()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return this.isReadOnlyMainThread;
        }
        Boolean bool = isReadOnlyByThread().get();
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final void setCurrentBundle(@Nullable Bundle bundle) {
        boolean z11;
        if (MainThreadKt.mainThread == Thread.currentThread()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.currentBundleMainThread = bundle;
        } else {
            getCurrentBundleByThread().set(bundle);
        }
    }

    public final void setReadOnly(boolean z11) {
        boolean z12;
        if (MainThreadKt.mainThread == Thread.currentThread()) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            this.isReadOnlyMainThread = z11;
        } else {
            isReadOnlyByThread().set(Boolean.valueOf(z11));
        }
    }
}
