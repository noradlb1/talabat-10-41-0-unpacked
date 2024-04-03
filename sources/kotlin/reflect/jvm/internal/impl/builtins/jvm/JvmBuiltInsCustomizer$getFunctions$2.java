package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

public final class JvmBuiltInsCustomizer$getFunctions$2 extends Lambda implements Function1<MemberScope, Collection<? extends SimpleFunctionDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Name f24477g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JvmBuiltInsCustomizer$getFunctions$2(Name name2) {
        super(1);
        this.f24477g = name2;
    }

    @NotNull
    public final Collection<SimpleFunctionDescriptor> invoke(@NotNull MemberScope memberScope) {
        Intrinsics.checkNotNullParameter(memberScope, "it");
        return memberScope.getContributedFunctions(this.f24477g, NoLookupLocation.FROM_BUILTINS);
    }
}
