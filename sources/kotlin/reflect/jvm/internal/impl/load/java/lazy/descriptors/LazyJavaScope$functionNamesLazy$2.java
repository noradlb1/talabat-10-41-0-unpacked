package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaScope$functionNamesLazy$2 extends Lambda implements Function0<Set<? extends Name>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaScope f24637g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaScope$functionNamesLazy$2(LazyJavaScope lazyJavaScope) {
        super(0);
        this.f24637g = lazyJavaScope;
    }

    @NotNull
    public final Set<Name> invoke() {
        return this.f24637g.computeFunctionNames(DescriptorKindFilter.FUNCTIONS, (Function1<? super Name, Boolean>) null);
    }
}
