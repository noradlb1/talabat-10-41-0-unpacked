package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaScope$allDescriptors$1 extends Lambda implements Function0<Collection<? extends DeclarationDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaScope f24632g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaScope$allDescriptors$1(LazyJavaScope lazyJavaScope) {
        super(0);
        this.f24632g = lazyJavaScope;
    }

    @NotNull
    public final Collection<DeclarationDescriptor> invoke() {
        return this.f24632g.b(DescriptorKindFilter.ALL, MemberScope.Companion.getALL_NAME_FILTER());
    }
}
