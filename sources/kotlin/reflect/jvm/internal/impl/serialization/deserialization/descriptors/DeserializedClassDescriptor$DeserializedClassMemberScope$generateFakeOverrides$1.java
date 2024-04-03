package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeserializedDeclarationsFromSupertypeConflictDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import org.jetbrains.annotations.NotNull;

public final class DeserializedClassDescriptor$DeserializedClassMemberScope$generateFakeOverrides$1 extends NonReportingOverrideStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List<D> f24869a;

    public DeserializedClassDescriptor$DeserializedClassMemberScope$generateFakeOverrides$1(List<D> list) {
        this.f24869a = list;
    }

    public void addFakeOverride(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "fakeOverride");
        OverridingUtil.resolveUnknownVisibilityForMember(callableMemberDescriptor, (Function1<CallableMemberDescriptor, Unit>) null);
        this.f24869a.add(callableMemberDescriptor);
    }

    public void conflict(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "fromSuper");
        Intrinsics.checkNotNullParameter(callableMemberDescriptor2, "fromCurrent");
        if (callableMemberDescriptor2 instanceof FunctionDescriptorImpl) {
            ((FunctionDescriptorImpl) callableMemberDescriptor2).putInUserDataMap(DeserializedDeclarationsFromSupertypeConflictDataKey.INSTANCE, callableMemberDescriptor);
        }
    }
}
