package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaClassDescriptor$declaredParameters$1 extends Lambda implements Function0<List<? extends TypeParameterDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaClassDescriptor f24606g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaClassDescriptor$declaredParameters$1(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        super(0);
        this.f24606g = lazyJavaClassDescriptor;
    }

    @NotNull
    public final List<TypeParameterDescriptor> invoke() {
        Iterable<JavaTypeParameter> typeParameters = this.f24606g.getJClass().getTypeParameters();
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.f24606g;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(typeParameters, 10));
        for (JavaTypeParameter javaTypeParameter : typeParameters) {
            TypeParameterDescriptor resolveTypeParameter = lazyJavaClassDescriptor.f24603c.getTypeParameterResolver().resolveTypeParameter(javaTypeParameter);
            if (resolveTypeParameter != null) {
                arrayList.add(resolveTypeParameter);
            } else {
                throw new AssertionError("Parameter " + javaTypeParameter + " surely belongs to class " + lazyJavaClassDescriptor.getJClass() + ", so it must be resolved");
            }
        }
        return arrayList;
    }
}
