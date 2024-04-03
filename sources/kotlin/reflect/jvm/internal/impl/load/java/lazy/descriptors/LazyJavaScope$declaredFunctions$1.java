package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaScope$declaredFunctions$1 extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaScope f24635g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaScope$declaredFunctions$1(LazyJavaScope lazyJavaScope) {
        super(1);
        this.f24635g = lazyJavaScope;
    }

    @NotNull
    public final Collection<SimpleFunctionDescriptor> invoke(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "name");
        if (this.f24635g.l() != null) {
            return (Collection) this.f24635g.l().declaredFunctions.invoke(name2);
        }
        ArrayList arrayList = new ArrayList();
        for (JavaMethod next : ((DeclaredMemberIndex) this.f24635g.j().invoke()).findMethodsByName(name2)) {
            JavaMethodDescriptor o11 = this.f24635g.o(next);
            if (this.f24635g.m(o11)) {
                this.f24635g.i().getComponents().getJavaResolverCache().recordMethod(next, o11);
                arrayList.add(o11);
            }
        }
        this.f24635g.c(arrayList, name2);
        return arrayList;
    }
}
