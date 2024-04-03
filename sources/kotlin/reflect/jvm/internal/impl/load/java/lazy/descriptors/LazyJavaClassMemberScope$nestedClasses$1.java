package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaClassMemberScope$nestedClasses$1 extends Lambda implements Function1<Name, ClassDescriptorBase> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaClassMemberScope f24617g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LazyJavaResolverContext f24618h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$nestedClasses$1(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext) {
        super(1);
        this.f24617g = lazyJavaClassMemberScope;
        this.f24618h = lazyJavaResolverContext;
    }

    @Nullable
    public final ClassDescriptorBase invoke(@NotNull Name name2) {
        Name name3 = name2;
        Intrinsics.checkNotNullParameter(name3, "name");
        if (!((Set) this.f24617g.nestedClassIndex.invoke()).contains(name3)) {
            JavaField javaField = (JavaField) ((Map) this.f24617g.enumEntryIndex.invoke()).get(name3);
            if (javaField == null) {
                return null;
            }
            NotNullLazyValue createLazyValue = this.f24618h.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1(this.f24617g));
            return EnumEntrySyntheticClassDescriptor.create(this.f24618h.getStorageManager(), this.f24617g.getOwnerDescriptor(), name2, createLazyValue, LazyJavaAnnotationsKt.resolveAnnotations(this.f24618h, javaField), this.f24618h.getComponents().getSourceElementFactory().source(javaField));
        }
        JavaClassFinder finder = this.f24618h.getComponents().getFinder();
        ClassId classId = DescriptorUtilsKt.getClassId(this.f24617g.getOwnerDescriptor());
        Intrinsics.checkNotNull(classId);
        ClassId createNestedClassId = classId.createNestedClassId(name3);
        Intrinsics.checkNotNullExpressionValue(createNestedClassId, "ownerDescriptor.classId!…createNestedClassId(name)");
        JavaClass findClass = finder.findClass(new JavaClassFinder.Request(createNestedClassId, (byte[]) null, this.f24617g.jClass, 2, (DefaultConstructorMarker) null));
        if (findClass == null) {
            return null;
        }
        LazyJavaResolverContext lazyJavaResolverContext = this.f24618h;
        LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(lazyJavaResolverContext, this.f24617g.getOwnerDescriptor(), findClass, (ClassDescriptor) null, 8, (DefaultConstructorMarker) null);
        lazyJavaResolverContext.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor);
        return lazyJavaClassDescriptor;
    }
}
