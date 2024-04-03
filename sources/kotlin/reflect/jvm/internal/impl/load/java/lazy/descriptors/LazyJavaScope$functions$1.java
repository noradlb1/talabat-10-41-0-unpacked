package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaScope$functions$1 extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaScope f24638g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaScope$functions$1(LazyJavaScope lazyJavaScope) {
        super(1);
        this.f24638g = lazyJavaScope;
    }

    @NotNull
    public final Collection<SimpleFunctionDescriptor> invoke(@NotNull Name name2) {
        Intrinsics.checkNotNullParameter(name2, "name");
        LinkedHashSet linkedHashSet = new LinkedHashSet((Collection) this.f24638g.declaredFunctions.invoke(name2));
        this.f24638g.retainMostSpecificMethods(linkedHashSet);
        this.f24638g.e(linkedHashSet, name2);
        return CollectionsKt___CollectionsKt.toList(this.f24638g.i().getComponents().getSignatureEnhancement().enhanceSignatures(this.f24638g.i(), linkedHashSet));
    }
}
