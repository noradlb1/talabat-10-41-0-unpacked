package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DescriptorUtilsKt$firstOverridden$2 extends DFS.AbstractNodeHandler<CallableMemberDescriptor, CallableMemberDescriptor> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<CallableMemberDescriptor> f24808a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1<CallableMemberDescriptor, Boolean> f24809b;

    public DescriptorUtilsKt$firstOverridden$2(Ref.ObjectRef<CallableMemberDescriptor> objectRef, Function1<? super CallableMemberDescriptor, Boolean> function1) {
        this.f24808a = objectRef;
        this.f24809b = function1;
    }

    public void afterChildren(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "current");
        if (this.f24808a.element == null && this.f24809b.invoke(callableMemberDescriptor).booleanValue()) {
            this.f24808a.element = callableMemberDescriptor;
        }
    }

    public boolean beforeChildren(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "current");
        return this.f24808a.element == null;
    }

    @Nullable
    public CallableMemberDescriptor result() {
        return (CallableMemberDescriptor) this.f24808a.element;
    }
}
