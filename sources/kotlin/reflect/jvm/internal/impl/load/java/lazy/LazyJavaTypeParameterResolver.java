package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import com.apptimize.c;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaTypeParameterResolver implements TypeParameterResolver {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final LazyJavaResolverContext f24592c;
    /* access modifiers changed from: private */
    @NotNull
    public final DeclarationDescriptor containingDeclaration;
    @NotNull
    private final MemoizedFunctionToNullable<JavaTypeParameter, LazyJavaTypeParameterDescriptor> resolve;
    /* access modifiers changed from: private */
    @NotNull
    public final Map<JavaTypeParameter, Integer> typeParameters;
    /* access modifiers changed from: private */
    public final int typeParametersIndexOffset;

    public LazyJavaTypeParameterResolver(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull JavaTypeParameterListOwner javaTypeParameterListOwner, int i11) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, c.f41585a);
        Intrinsics.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics.checkNotNullParameter(javaTypeParameterListOwner, "typeParameterOwner");
        this.f24592c = lazyJavaResolverContext;
        this.containingDeclaration = declarationDescriptor;
        this.typeParametersIndexOffset = i11;
        this.typeParameters = CollectionsKt.mapToIndex(javaTypeParameterListOwner.getTypeParameters());
        this.resolve = lazyJavaResolverContext.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaTypeParameterResolver$resolve$1(this));
    }

    @Nullable
    public TypeParameterDescriptor resolveTypeParameter(@NotNull JavaTypeParameter javaTypeParameter) {
        Intrinsics.checkNotNullParameter(javaTypeParameter, "javaTypeParameter");
        LazyJavaTypeParameterDescriptor invoke = this.resolve.invoke(javaTypeParameter);
        if (invoke != null) {
            return invoke;
        }
        return this.f24592c.getTypeParameterResolver().resolveTypeParameter(javaTypeParameter);
    }
}
