package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaStaticClassScope$computeNonDeclaredProperties$propertiesFromSupertypes$1 extends Lambda implements Function1<MemberScope, Collection<? extends PropertyDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Name f24647g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaStaticClassScope$computeNonDeclaredProperties$propertiesFromSupertypes$1(Name name2) {
        super(1);
        this.f24647g = name2;
    }

    @NotNull
    public final Collection<? extends PropertyDescriptor> invoke(@NotNull MemberScope memberScope) {
        Intrinsics.checkNotNullParameter(memberScope, "it");
        return memberScope.getContributedVariables(this.f24647g, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
    }
}
