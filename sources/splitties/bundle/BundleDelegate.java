package splitties.bundle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J%\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002¨\u0006\f"}, d2 = {"Lsplitties/bundle/BundleDelegate;", "Lkotlin/properties/ReadWriteProperty;", "Lsplitties/bundle/BundleSpec;", "", "()V", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "value", "splitties-bundle_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class BundleDelegate implements ReadWriteProperty<BundleSpec, Object> {
    @NotNull
    public static final BundleDelegate INSTANCE = new BundleDelegate();

    private BundleDelegate() {
    }

    @NotNull
    public Object getValue(@NotNull BundleSpec bundleSpec, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(bundleSpec, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        String name2 = kProperty.getName();
        Object obj = BundleDelegatesKt.getBundle(bundleSpec).get(name2);
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException(("Property " + name2 + " could not be read").toString());
    }

    public void setValue(@NotNull BundleSpec bundleSpec, @NotNull KProperty<?> kProperty, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(bundleSpec, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Intrinsics.checkNotNullParameter(obj, "value");
        BundleDelegatesKt.put(bundleSpec, kProperty.getName(), obj);
    }
}
