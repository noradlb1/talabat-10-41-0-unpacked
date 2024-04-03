package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Comparator;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

public final class LazyJavaClassDescriptor$getSealedSubclasses$$inlined$sortedBy$1<T> implements Comparator {
    public final int compare(T t11, T t12) {
        return ComparisonsKt__ComparisonsKt.compareValues(DescriptorUtilsKt.getFqNameSafe((ClassDescriptor) t11).asString(), DescriptorUtilsKt.getFqNameSafe((ClassDescriptor) t12).asString());
    }
}
