package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaScope$declaredMemberIndex$1 extends Lambda implements Function0<DeclaredMemberIndex> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaScope f24636g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaScope$declaredMemberIndex$1(LazyJavaScope lazyJavaScope) {
        super(0);
        this.f24636g = lazyJavaScope;
    }

    @NotNull
    public final DeclaredMemberIndex invoke() {
        return this.f24636g.computeMemberIndex();
    }
}
