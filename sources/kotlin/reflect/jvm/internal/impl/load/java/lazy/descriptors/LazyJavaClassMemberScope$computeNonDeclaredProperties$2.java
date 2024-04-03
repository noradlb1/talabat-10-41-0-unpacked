package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaClassMemberScope$computeNonDeclaredProperties$2 extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaClassMemberScope f24610g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$computeNonDeclaredProperties$2(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(1);
        this.f24610g = lazyJavaClassMemberScope;
    }

    @NotNull
    public final Collection<SimpleFunctionDescriptor> invoke(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "it");
        return this.f24610g.searchMethodsInSupertypesWithoutBuiltinMagic(name2);
    }
}
