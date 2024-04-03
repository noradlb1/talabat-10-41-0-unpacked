package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$2 extends DFS.AbstractNodeHandler<ClassDescriptor, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassDescriptor f24648a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Set<R> f24649b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1<MemberScope, Collection<R>> f24650c;

    public LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$2(ClassDescriptor classDescriptor, Set<R> set, Function1<? super MemberScope, ? extends Collection<? extends R>> function1) {
        this.f24648a = classDescriptor;
        this.f24649b = set;
        this.f24650c = function1;
    }

    public void result() {
    }

    public boolean beforeChildren(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "current");
        if (classDescriptor == this.f24648a) {
            return true;
        }
        MemberScope staticScope = classDescriptor.getStaticScope();
        Intrinsics.checkNotNullExpressionValue(staticScope, "current.staticScope");
        if (!(staticScope instanceof LazyJavaStaticScope)) {
            return true;
        }
        this.f24649b.addAll(this.f24650c.invoke(staticScope));
        return false;
    }
}
