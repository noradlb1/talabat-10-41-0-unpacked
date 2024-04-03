package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectionTypes {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f24459a;
    @NotNull
    private final ClassLookup kClass$delegate = new ClassLookup(1);
    @NotNull
    private final ClassLookup kMutableProperty0$delegate = new ClassLookup(1);
    @NotNull
    private final ClassLookup kMutableProperty1$delegate = new ClassLookup(2);
    @NotNull
    private final ClassLookup kMutableProperty2$delegate = new ClassLookup(3);
    @NotNull
    private final ClassLookup kProperty$delegate = new ClassLookup(1);
    @NotNull
    private final ClassLookup kProperty0$delegate = new ClassLookup(1);
    @NotNull
    private final ClassLookup kProperty1$delegate = new ClassLookup(2);
    @NotNull
    private final ClassLookup kProperty2$delegate = new ClassLookup(3);
    @NotNull
    private final Lazy kotlinReflectScope$delegate;
    @NotNull
    private final NotFoundClasses notFoundClasses;

    public static final class ClassLookup {
        private final int numberOfTypeParameters;

        public ClassLookup(int i11) {
            this.numberOfTypeParameters = i11;
        }

        @NotNull
        public final ClassDescriptor getValue(@NotNull ReflectionTypes reflectionTypes, @NotNull KProperty<?> kProperty) {
            Intrinsics.checkNotNullParameter(reflectionTypes, "types");
            Intrinsics.checkNotNullParameter(kProperty, "property");
            return reflectionTypes.find(CapitalizeDecapitalizeKt.capitalizeAsciiOnly(kProperty.getName()), this.numberOfTypeParameters);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final KotlinType createKPropertyStarType(@NotNull ModuleDescriptor moduleDescriptor) {
            Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
            ClassDescriptor findClassAcrossModuleDependencies = FindClassInModuleKt.findClassAcrossModuleDependencies(moduleDescriptor, StandardNames.FqNames.kProperty);
            if (findClassAcrossModuleDependencies == null) {
                return null;
            }
            TypeAttributes empty = TypeAttributes.Companion.getEmpty();
            List<TypeParameterDescriptor> parameters = findClassAcrossModuleDependencies.getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "kPropertyClass.typeConstructor.parameters");
            Object single = CollectionsKt___CollectionsKt.single(parameters);
            Intrinsics.checkNotNullExpressionValue(single, "kPropertyClass.typeConstructor.parameters.single()");
            return KotlinTypeFactory.simpleNotNullType(empty, findClassAcrossModuleDependencies, CollectionsKt__CollectionsJVMKt.listOf(new StarProjectionImpl((TypeParameterDescriptor) single)));
        }
    }

    static {
        Class<ReflectionTypes> cls = ReflectionTypes.class;
        f24459a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"))};
    }

    public ReflectionTypes(@NotNull ModuleDescriptor moduleDescriptor, @NotNull NotFoundClasses notFoundClasses2) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        Intrinsics.checkNotNullParameter(notFoundClasses2, "notFoundClasses");
        this.notFoundClasses = notFoundClasses2;
        this.kotlinReflectScope$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new ReflectionTypes$kotlinReflectScope$2(moduleDescriptor));
    }

    /* access modifiers changed from: private */
    public final ClassDescriptor find(String str, int i11) {
        ClassDescriptor classDescriptor;
        Name identifier = Name.identifier(str);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(className)");
        ClassifierDescriptor contributedClassifier = getKotlinReflectScope().getContributedClassifier(identifier, NoLookupLocation.FROM_REFLECTION);
        if (contributedClassifier instanceof ClassDescriptor) {
            classDescriptor = (ClassDescriptor) contributedClassifier;
        } else {
            classDescriptor = null;
        }
        if (classDescriptor == null) {
            return this.notFoundClasses.getClass(new ClassId(StandardNames.KOTLIN_REFLECT_FQ_NAME, identifier), CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(i11)));
        }
        return classDescriptor;
    }

    private final MemberScope getKotlinReflectScope() {
        return (MemberScope) this.kotlinReflectScope$delegate.getValue();
    }

    @NotNull
    public final ClassDescriptor getKClass() {
        return this.kClass$delegate.getValue(this, f24459a[0]);
    }
}
