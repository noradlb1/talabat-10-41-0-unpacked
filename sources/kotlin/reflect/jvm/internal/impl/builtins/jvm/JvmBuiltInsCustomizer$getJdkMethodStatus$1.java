package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import org.jetbrains.annotations.NotNull;

public final class JvmBuiltInsCustomizer$getJdkMethodStatus$1<N> implements DFS.Neighbors {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JvmBuiltInsCustomizer f24478a;

    public JvmBuiltInsCustomizer$getJdkMethodStatus$1(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        this.f24478a = jvmBuiltInsCustomizer;
    }

    @NotNull
    public final Iterable<ClassDescriptor> getNeighbors(ClassDescriptor classDescriptor) {
        Collection<KotlinType> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes, "it.typeConstructor.supertypes");
        JvmBuiltInsCustomizer jvmBuiltInsCustomizer = this.f24478a;
        ArrayList arrayList = new ArrayList();
        for (KotlinType constructor : supertypes) {
            ClassifierDescriptor declarationDescriptor = constructor.getConstructor().getDeclarationDescriptor();
            LazyJavaClassDescriptor lazyJavaClassDescriptor = null;
            ClassifierDescriptor original = declarationDescriptor != null ? declarationDescriptor.getOriginal() : null;
            ClassDescriptor classDescriptor2 = original instanceof ClassDescriptor ? (ClassDescriptor) original : null;
            if (classDescriptor2 != null) {
                lazyJavaClassDescriptor = jvmBuiltInsCustomizer.getJavaAnalogue(classDescriptor2);
            }
            if (lazyJavaClassDescriptor != null) {
                arrayList.add(lazyJavaClassDescriptor);
            }
        }
        return arrayList;
    }
}
