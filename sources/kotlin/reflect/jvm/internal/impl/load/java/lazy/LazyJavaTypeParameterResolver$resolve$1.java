package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaTypeParameterResolver$resolve$1 extends Lambda implements Function1<JavaTypeParameter, LazyJavaTypeParameterDescriptor> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaTypeParameterResolver f24593g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaTypeParameterResolver$resolve$1(LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver) {
        super(1);
        this.f24593g = lazyJavaTypeParameterResolver;
    }

    @Nullable
    public final LazyJavaTypeParameterDescriptor invoke(@NotNull JavaTypeParameter javaTypeParameter) {
        Intrinsics.checkNotNullParameter(javaTypeParameter, "typeParameter");
        Integer num = (Integer) this.f24593g.typeParameters.get(javaTypeParameter);
        if (num == null) {
            return null;
        }
        LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver = this.f24593g;
        return new LazyJavaTypeParameterDescriptor(ContextKt.copyWithNewDefaultTypeQualifiers(ContextKt.child(lazyJavaTypeParameterResolver.f24592c, lazyJavaTypeParameterResolver), lazyJavaTypeParameterResolver.containingDeclaration.getAnnotations()), javaTypeParameter, lazyJavaTypeParameterResolver.typeParametersIndexOffset + num.intValue(), lazyJavaTypeParameterResolver.containingDeclaration);
    }
}
