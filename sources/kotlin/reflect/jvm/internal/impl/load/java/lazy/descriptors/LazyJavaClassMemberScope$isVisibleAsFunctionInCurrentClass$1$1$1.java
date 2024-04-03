package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1 extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SimpleFunctionDescriptor f24614g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LazyJavaClassMemberScope f24615h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1(SimpleFunctionDescriptor simpleFunctionDescriptor, LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(1);
        this.f24614g = simpleFunctionDescriptor;
        this.f24615h = lazyJavaClassMemberScope;
    }

    @NotNull
    public final Collection<SimpleFunctionDescriptor> invoke(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "accessorName");
        if (Intrinsics.areEqual((Object) this.f24614g.getName(), (Object) name2)) {
            return CollectionsKt__CollectionsJVMKt.listOf(this.f24614g);
        }
        return CollectionsKt___CollectionsKt.plus(this.f24615h.searchMethodsByNameWithoutBuiltinMagic(name2), this.f24615h.searchMethodsInSupertypesWithoutBuiltinMagic(name2));
    }
}
