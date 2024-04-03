package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.apptimize.c;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final LazyJavaResolverContext f24651c;
    @NotNull
    private final JavaTypeParameter javaTypeParameter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaTypeParameterDescriptor(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull JavaTypeParameter javaTypeParameter2, int i11, @NotNull DeclarationDescriptor declarationDescriptor) {
        super(lazyJavaResolverContext.getStorageManager(), declarationDescriptor, new LazyJavaAnnotations(lazyJavaResolverContext, javaTypeParameter2, false, 4, (DefaultConstructorMarker) null), javaTypeParameter2.getName(), Variance.INVARIANT, false, i11, SourceElement.NO_SOURCE, lazyJavaResolverContext.getComponents().getSupertypeLoopChecker());
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, c.f41585a);
        Intrinsics.checkNotNullParameter(javaTypeParameter2, "javaTypeParameter");
        Intrinsics.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        this.f24651c = lazyJavaResolverContext;
        this.javaTypeParameter = javaTypeParameter2;
    }

    private final List<KotlinType> computeNotEnhancedBounds() {
        Collection<JavaClassifierType> upperBounds = this.javaTypeParameter.getUpperBounds();
        if (upperBounds.isEmpty()) {
            SimpleType anyType = this.f24651c.getModule().getBuiltIns().getAnyType();
            Intrinsics.checkNotNullExpressionValue(anyType, "c.module.builtIns.anyType");
            SimpleType nullableAnyType = this.f24651c.getModule().getBuiltIns().getNullableAnyType();
            Intrinsics.checkNotNullExpressionValue(nullableAnyType, "c.module.builtIns.nullableAnyType");
            return CollectionsKt__CollectionsJVMKt.listOf(KotlinTypeFactory.flexibleType(anyType, nullableAnyType));
        }
        Iterable<JavaClassifierType> iterable = upperBounds;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (JavaClassifierType transformJavaType : iterable) {
            arrayList.add(this.f24651c.getTypeResolver().transformJavaType(transformJavaType, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, this, 1, (Object) null)));
        }
        return arrayList;
    }

    @NotNull
    public List<KotlinType> a(@NotNull List<? extends KotlinType> list) {
        Intrinsics.checkNotNullParameter(list, Param.BOUNDS);
        return this.f24651c.getComponents().getSignatureEnhancement().enhanceTypeParameterBounds(this, list, this.f24651c);
    }

    @NotNull
    public List<KotlinType> b() {
        return computeNotEnhancedBounds();
    }

    public void reportSupertypeLoopError(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
    }
}
