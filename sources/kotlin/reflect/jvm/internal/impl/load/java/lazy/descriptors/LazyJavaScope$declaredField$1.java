package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaScope$declaredField$1 extends Lambda implements Function1<Name, PropertyDescriptor> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaScope f24634g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaScope$declaredField$1(LazyJavaScope lazyJavaScope) {
        super(1);
        this.f24634g = lazyJavaScope;
    }

    @Nullable
    public final PropertyDescriptor invoke(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "name");
        if (this.f24634g.l() != null) {
            return (PropertyDescriptor) this.f24634g.l().declaredField.invoke(name2);
        }
        JavaField findFieldByName = ((DeclaredMemberIndex) this.f24634g.j().invoke()).findFieldByName(name2);
        if (findFieldByName == null || findFieldByName.isEnumEntry()) {
            return null;
        }
        return this.f24634g.resolveProperty(findFieldByName);
    }
}
