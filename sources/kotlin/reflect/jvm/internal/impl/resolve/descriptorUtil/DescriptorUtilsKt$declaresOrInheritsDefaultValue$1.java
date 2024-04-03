package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import org.jetbrains.annotations.NotNull;

public final class DescriptorUtilsKt$declaresOrInheritsDefaultValue$1<N> implements DFS.Neighbors {
    public static final DescriptorUtilsKt$declaresOrInheritsDefaultValue$1<N> INSTANCE = new DescriptorUtilsKt$declaresOrInheritsDefaultValue$1<>();

    @NotNull
    public final Iterable<ValueParameterDescriptor> getNeighbors(ValueParameterDescriptor valueParameterDescriptor) {
        Iterable<ValueParameterDescriptor> overriddenDescriptors = valueParameterDescriptor.getOverriddenDescriptors();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(overriddenDescriptors, 10));
        for (ValueParameterDescriptor original : overriddenDescriptors) {
            arrayList.add(original.getOriginal());
        }
        return arrayList;
    }
}
