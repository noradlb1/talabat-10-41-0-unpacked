package splitties.bundle;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u000b0\n\"\b\b\u0000\u0010\u000b*\u00020\f*\u00020\u0007\u001a(\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u000b0\n\"\b\b\u0000\u0010\u000b*\u00020\f*\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e\u001a-\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u000b0\n\"\b\b\u0000\u0010\u000b*\u00020\f*\u00020\u00072\u0006\u0010\u0010\u001a\u0002H\u000b¢\u0006\u0002\u0010\u0011\u001a.\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u000b0\n\"\b\b\u0000\u0010\u000b*\u00020\f*\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0013\u001a\u001e\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u000b0\n\"\u0004\b\u0000\u0010\u000b*\u00020\u0007\u001a&\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u000b0\n\"\u0004\b\u0000\u0010\u000b*\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e\u001a\u001e\u0010\u0015\u001a\u00020\u0016*\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0002\"\u001d\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00018Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"currentThread", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "getCurrentThread", "()Ljava/lang/Thread;", "bundle", "Landroid/os/Bundle;", "Lsplitties/bundle/BundleSpec;", "getBundle", "(Lsplitties/bundle/BundleSpec;)Landroid/os/Bundle;", "Lkotlin/properties/ReadWriteProperty;", "T", "", "key", "", "bundleOrDefault", "defaultValue", "(Lsplitties/bundle/BundleSpec;Ljava/lang/Object;)Lkotlin/properties/ReadWriteProperty;", "bundleOrElse", "Lkotlin/Function0;", "bundleOrNull", "put", "", "value", "splitties-bundle_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class BundleDelegatesKt {
    @NotNull
    public static final <T> ReadWriteProperty<BundleSpec, T> bundle(@NotNull BundleSpec bundleSpec) {
        Intrinsics.checkNotNullParameter(bundleSpec, "<this>");
        return BundleDelegate.INSTANCE;
    }

    @NotNull
    public static final <T> ReadWriteProperty<BundleSpec, T> bundleOrDefault(@NotNull BundleSpec bundleSpec, @NotNull T t11) {
        Intrinsics.checkNotNullParameter(bundleSpec, "<this>");
        Intrinsics.checkNotNullParameter(t11, "defaultValue");
        return new BundleOrDefaultDelegate(t11);
    }

    @NotNull
    public static final <T> ReadWriteProperty<BundleSpec, T> bundleOrElse(@NotNull BundleSpec bundleSpec, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(bundleSpec, "<this>");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        return new BundleOrElseDelegate(function0);
    }

    @NotNull
    public static final <T> ReadWriteProperty<BundleSpec, T> bundleOrNull(@NotNull BundleSpec bundleSpec) {
        Intrinsics.checkNotNullParameter(bundleSpec, "<this>");
        return BundleOrNullDelegate.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Bundle getBundle(BundleSpec bundleSpec) {
        Bundle currentBundle = bundleSpec.getCurrentBundle();
        if (currentBundle != null) {
            return currentBundle;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("Bundle property accessed outside with() function! Thread: ", Thread.currentThread()).toString());
    }

    private static final Thread getCurrentThread() {
        return Thread.currentThread();
    }

    /* access modifiers changed from: private */
    public static final void put(BundleSpec bundleSpec, String str, Object obj) {
        if (!bundleSpec.isReadOnly()) {
            BundleKt.put(getBundle(bundleSpec), str, obj);
            return;
        }
        throw new IllegalStateException("The BundleSpec is in read only mode! If you're trying to mutate extras of an Activity, use putExtras instead of withExtras.".toString());
    }

    @NotNull
    public static final <T> ReadWriteProperty<BundleSpec, T> bundle(@NotNull BundleSpec bundleSpec, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bundleSpec, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        return new ExplicitBundleDelegate(str, true);
    }

    @NotNull
    public static final <T> ReadWriteProperty<BundleSpec, T> bundleOrNull(@NotNull BundleSpec bundleSpec, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bundleSpec, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        return new ExplicitBundleDelegate(str, false);
    }
}
