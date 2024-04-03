package splitties.bundle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\"\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u00042\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002¢\u0006\u0002\u0010\fJ*\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00042\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0010R\u0010\u0010\u0005\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0011"}, d2 = {"Lsplitties/bundle/BundleOrDefaultDelegate;", "T", "", "Lkotlin/properties/ReadWriteProperty;", "Lsplitties/bundle/BundleSpec;", "defaultValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Lsplitties/bundle/BundleSpec;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Lsplitties/bundle/BundleSpec;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "splitties-bundle_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class BundleOrDefaultDelegate<T> implements ReadWriteProperty<BundleSpec, T> {
    @NotNull
    private final T defaultValue;

    public BundleOrDefaultDelegate(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "defaultValue");
        this.defaultValue = t11;
    }

    @NotNull
    public T getValue(@NotNull BundleSpec bundleSpec, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(bundleSpec, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        T t11 = BundleDelegatesKt.getBundle(bundleSpec).get(kProperty.getName());
        return t11 == null ? this.defaultValue : t11;
    }

    public void setValue(@NotNull BundleSpec bundleSpec, @NotNull KProperty<?> kProperty, @NotNull T t11) {
        Intrinsics.checkNotNullParameter(bundleSpec, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Intrinsics.checkNotNullParameter(t11, "value");
        BundleDelegatesKt.put(bundleSpec, kProperty.getName(), t11);
    }
}
