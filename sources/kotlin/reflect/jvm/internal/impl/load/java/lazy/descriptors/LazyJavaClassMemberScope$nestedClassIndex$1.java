package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaClassMemberScope$nestedClassIndex$1 extends Lambda implements Function0<Set<? extends Name>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaClassMemberScope f24616g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$nestedClassIndex$1(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(0);
        this.f24616g = lazyJavaClassMemberScope;
    }

    @NotNull
    public final Set<Name> invoke() {
        return CollectionsKt___CollectionsKt.toSet(this.f24616g.jClass.getInnerClassNames());
    }
}
