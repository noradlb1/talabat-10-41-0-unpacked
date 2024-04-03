package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import org.jetbrains.annotations.NotNull;

public final class GivenFunctionsMemberScope$createFakeOverrides$4 extends NonReportingOverrideStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArrayList<DeclarationDescriptor> f24815a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GivenFunctionsMemberScope f24816b;

    public GivenFunctionsMemberScope$createFakeOverrides$4(ArrayList<DeclarationDescriptor> arrayList, GivenFunctionsMemberScope givenFunctionsMemberScope) {
        this.f24815a = arrayList;
        this.f24816b = givenFunctionsMemberScope;
    }

    public void addFakeOverride(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "fakeOverride");
        OverridingUtil.resolveUnknownVisibilityForMember(callableMemberDescriptor, (Function1<CallableMemberDescriptor, Unit>) null);
        this.f24815a.add(callableMemberDescriptor);
    }

    public void conflict(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "fromSuper");
        Intrinsics.checkNotNullParameter(callableMemberDescriptor2, "fromCurrent");
        throw new IllegalStateException(("Conflict in scope of " + this.f24816b.b() + ": " + callableMemberDescriptor + " vs " + callableMemberDescriptor2).toString());
    }
}
