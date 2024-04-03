package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaClass extends ReflectJavaElement implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaClass {
    @NotNull
    private final Class<?> klass;

    public ReflectJavaClass(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "klass");
        this.klass = cls;
    }

    /* access modifiers changed from: private */
    public final boolean isEnumValuesOrValueOf(Method method) {
        String name2 = method.getName();
        if (Intrinsics.areEqual((Object) name2, (Object) "values")) {
            Class[] parameterTypes = method.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(parameterTypes, "method.parameterTypes");
            if (parameterTypes.length == 0) {
                return true;
            }
        } else if (Intrinsics.areEqual((Object) name2, (Object) "valueOf")) {
            return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ReflectJavaClass) && Intrinsics.areEqual((Object) this.klass, (Object) ((ReflectJavaClass) obj).klass);
    }

    @Nullable
    public ReflectJavaAnnotation findAnnotation(@NotNull FqName fqName) {
        return ReflectJavaAnnotationOwner.DefaultImpls.findAnnotation(this, fqName);
    }

    @NotNull
    public FqName getFqName() {
        FqName asSingleFqName = ReflectClassUtilKt.getClassId(this.klass).asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(asSingleFqName, "klass.classId.asSingleFqName()");
        return asSingleFqName;
    }

    @Nullable
    public LightClassOriginKind getLightClassOriginKind() {
        return null;
    }

    public int getModifiers() {
        return this.klass.getModifiers();
    }

    @NotNull
    public Name getName() {
        Name identifier = Name.identifier(this.klass.getSimpleName());
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(klass.simpleName)");
        return identifier;
    }

    @NotNull
    public Collection<JavaClassifierType> getPermittedTypes() {
        Class[] loadGetPermittedSubclasses = Java16SealedRecordLoader.INSTANCE.loadGetPermittedSubclasses(this.klass);
        if (loadGetPermittedSubclasses == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(loadGetPermittedSubclasses.length);
        for (Class reflectJavaClassifierType : loadGetPermittedSubclasses) {
            arrayList.add(new ReflectJavaClassifierType(reflectJavaClassifierType));
        }
        return arrayList;
    }

    @NotNull
    public Collection<JavaRecordComponent> getRecordComponents() {
        Object[] loadGetRecordComponents = Java16SealedRecordLoader.INSTANCE.loadGetRecordComponents(this.klass);
        if (loadGetRecordComponents == null) {
            loadGetRecordComponents = new Object[0];
        }
        ArrayList arrayList = new ArrayList(loadGetRecordComponents.length);
        for (Object reflectJavaRecordComponent : loadGetRecordComponents) {
            arrayList.add(new ReflectJavaRecordComponent(reflectJavaRecordComponent));
        }
        return arrayList;
    }

    @NotNull
    public Collection<JavaClassifierType> getSupertypes() {
        Type type = Object.class;
        if (Intrinsics.areEqual((Object) this.klass, (Object) type)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        Type genericSuperclass = this.klass.getGenericSuperclass();
        if (genericSuperclass != null) {
            type = genericSuperclass;
        }
        spreadBuilder.add(type);
        Type[] genericInterfaces = this.klass.getGenericInterfaces();
        Intrinsics.checkNotNullExpressionValue(genericInterfaces, "klass.genericInterfaces");
        spreadBuilder.addSpread(genericInterfaces);
        Iterable<Type> listOf = CollectionsKt__CollectionsKt.listOf(spreadBuilder.toArray(new Type[spreadBuilder.size()]));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listOf, 10));
        for (Type reflectJavaClassifierType : listOf) {
            arrayList.add(new ReflectJavaClassifierType(reflectJavaClassifierType));
        }
        return arrayList;
    }

    @NotNull
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable[] typeParameters = this.klass.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "klass.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable reflectJavaTypeParameter : typeParameters) {
            arrayList.add(new ReflectJavaTypeParameter(reflectJavaTypeParameter));
        }
        return arrayList;
    }

    @NotNull
    public Visibility getVisibility() {
        return ReflectJavaModifierListOwner.DefaultImpls.getVisibility(this);
    }

    public boolean hasDefaultConstructor() {
        return false;
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    public boolean isAbstract() {
        return ReflectJavaModifierListOwner.DefaultImpls.isAbstract(this);
    }

    public boolean isAnnotationType() {
        return this.klass.isAnnotation();
    }

    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.DefaultImpls.isDeprecatedInJavaDoc(this);
    }

    public boolean isEnum() {
        return this.klass.isEnum();
    }

    public boolean isFinal() {
        return ReflectJavaModifierListOwner.DefaultImpls.isFinal(this);
    }

    public boolean isInterface() {
        return this.klass.isInterface();
    }

    public boolean isRecord() {
        Boolean loadIsRecord = Java16SealedRecordLoader.INSTANCE.loadIsRecord(this.klass);
        if (loadIsRecord != null) {
            return loadIsRecord.booleanValue();
        }
        return false;
    }

    public boolean isSealed() {
        Boolean loadIsSealed = Java16SealedRecordLoader.INSTANCE.loadIsSealed(this.klass);
        if (loadIsSealed != null) {
            return loadIsSealed.booleanValue();
        }
        return false;
    }

    public boolean isStatic() {
        return ReflectJavaModifierListOwner.DefaultImpls.isStatic(this);
    }

    @NotNull
    public String toString() {
        return ReflectJavaClass.class.getName() + ": " + this.klass;
    }

    @NotNull
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner.DefaultImpls.getAnnotations(this);
    }

    @NotNull
    public List<ReflectJavaConstructor> getConstructors() {
        Constructor[] declaredConstructors = this.klass.getDeclaredConstructors();
        Intrinsics.checkNotNullExpressionValue(declaredConstructors, "klass.declaredConstructors");
        return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filterNot(ArraysKt___ArraysKt.asSequence((T[]) declaredConstructors), ReflectJavaClass$constructors$1.INSTANCE), ReflectJavaClass$constructors$2.INSTANCE));
    }

    @NotNull
    public Class<?> getElement() {
        return this.klass;
    }

    @NotNull
    public List<ReflectJavaField> getFields() {
        Field[] declaredFields = this.klass.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "klass.declaredFields");
        return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filterNot(ArraysKt___ArraysKt.asSequence((T[]) declaredFields), ReflectJavaClass$fields$1.INSTANCE), ReflectJavaClass$fields$2.INSTANCE));
    }

    @NotNull
    public List<Name> getInnerClassNames() {
        Class[] declaredClasses = this.klass.getDeclaredClasses();
        Intrinsics.checkNotNullExpressionValue(declaredClasses, "klass.declaredClasses");
        return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.mapNotNull(SequencesKt___SequencesKt.filterNot(ArraysKt___ArraysKt.asSequence((T[]) declaredClasses), ReflectJavaClass$innerClassNames$1.INSTANCE), ReflectJavaClass$innerClassNames$2.INSTANCE));
    }

    @NotNull
    public List<ReflectJavaMethod> getMethods() {
        Method[] declaredMethods = this.klass.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "klass.declaredMethods");
        return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(ArraysKt___ArraysKt.asSequence((T[]) declaredMethods), new ReflectJavaClass$methods$1(this)), ReflectJavaClass$methods$2.INSTANCE));
    }

    @Nullable
    public ReflectJavaClass getOuterClass() {
        Class<?> declaringClass = this.klass.getDeclaringClass();
        if (declaringClass != null) {
            return new ReflectJavaClass(declaringClass);
        }
        return null;
    }
}
