package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.apptimize.c;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class LazyJavaStaticScope extends LazyJavaScope {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaStaticScope(@NotNull LazyJavaResolverContext lazyJavaResolverContext) {
        super(lazyJavaResolverContext, (LazyJavaScope) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, c.f41585a);
    }

    public void f(@NotNull Name name2, @NotNull Collection<PropertyDescriptor> collection) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(collection, "result");
    }

    @Nullable
    public ReceiverParameterDescriptor k() {
        return null;
    }

    @NotNull
    public LazyJavaScope.MethodSignatureData n(@NotNull JavaMethod javaMethod, @NotNull List<? extends TypeParameterDescriptor> list, @NotNull KotlinType kotlinType, @NotNull List<? extends ValueParameterDescriptor> list2) {
        Intrinsics.checkNotNullParameter(javaMethod, "method");
        Intrinsics.checkNotNullParameter(list, "methodTypeParameters");
        Intrinsics.checkNotNullParameter(kotlinType, "returnType");
        Intrinsics.checkNotNullParameter(list2, "valueParameters");
        return new LazyJavaScope.MethodSignatureData(kotlinType, (KotlinType) null, list2, list, false, CollectionsKt__CollectionsKt.emptyList());
    }
}
