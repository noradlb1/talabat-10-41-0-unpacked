package splitties.bundle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\"\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002¢\u0006\u0002\u0010\rJ*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lsplitties/bundle/ExplicitBundleDelegate;", "T", "Lkotlin/properties/ReadWriteProperty;", "Lsplitties/bundle/BundleSpec;", "key", "", "noNull", "", "(Ljava/lang/String;Z)V", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Lsplitties/bundle/BundleSpec;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Lsplitties/bundle/BundleSpec;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "splitties-bundle_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class ExplicitBundleDelegate<T> implements ReadWriteProperty<BundleSpec, T> {
    @NotNull
    private final String key;
    private final boolean noNull;

    public ExplicitBundleDelegate(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.key = str;
        this.noNull = z11;
    }

    public T getValue(@NotNull BundleSpec bundleSpec, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(bundleSpec, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        T t11 = BundleDelegatesKt.getBundle(bundleSpec).get(this.key);
        if (!this.noNull || t11 != null) {
            return t11;
        }
        throw new IllegalStateException(("Property " + this.key + " could not be read").toString());
    }

    public void setValue(@NotNull BundleSpec bundleSpec, @NotNull KProperty<?> kProperty, T t11) {
        Intrinsics.checkNotNullParameter(bundleSpec, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        BundleDelegatesKt.put(bundleSpec, this.key, t11);
    }
}
