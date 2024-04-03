package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import org.jetbrains.annotations.NotNull;

public final class DescriptorUtilsKt$firstOverridden$1<N> implements DFS.Neighbors {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f24807a;

    public DescriptorUtilsKt$firstOverridden$1(boolean z11) {
        this.f24807a = z11;
    }

    @NotNull
    public final Iterable<CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor callableMemberDescriptor) {
        Collection<? extends CallableMemberDescriptor> collection = null;
        if (this.f24807a) {
            callableMemberDescriptor = callableMemberDescriptor != null ? callableMemberDescriptor.getOriginal() : null;
        }
        if (callableMemberDescriptor != null) {
            collection = callableMemberDescriptor.getOverriddenDescriptors();
        }
        return collection == null ? CollectionsKt__CollectionsKt.emptyList() : collection;
    }
}
