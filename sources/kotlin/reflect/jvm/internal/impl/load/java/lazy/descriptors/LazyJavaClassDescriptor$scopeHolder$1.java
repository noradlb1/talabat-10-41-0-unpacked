package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaClassDescriptor$scopeHolder$1 extends Lambda implements Function1<KotlinTypeRefiner, LazyJavaClassMemberScope> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaClassDescriptor f24608g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaClassDescriptor$scopeHolder$1(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        super(1);
        this.f24608g = lazyJavaClassDescriptor;
    }

    @NotNull
    public final LazyJavaClassMemberScope invoke(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "it");
        LazyJavaResolverContext access$getC$p = this.f24608g.f24603c;
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.f24608g;
        return new LazyJavaClassMemberScope(access$getC$p, lazyJavaClassDescriptor, lazyJavaClassDescriptor.getJClass(), this.f24608g.additionalSupertypeClassDescriptor != null, this.f24608g.unsubstitutedMemberScope);
    }
}
