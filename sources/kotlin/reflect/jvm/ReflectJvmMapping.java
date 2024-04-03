package kotlin.reflect.jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010%\u001a\u0004\u0018\u00010&*\u00020'H\u0002\"/\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038F¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u001b\u0010\b\u001a\u0004\u0018\u00010\t*\u0006\u0012\u0002\b\u00030\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\n8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u0018\u001a\u00020\u0019*\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"-\u0010\u001d\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001e*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u001b\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003*\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!\"\u001b\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n*\u00020\t8F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"javaConstructor", "Ljava/lang/reflect/Constructor;", "T", "Lkotlin/reflect/KFunction;", "getJavaConstructor$annotations", "(Lkotlin/reflect/KFunction;)V", "getJavaConstructor", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Constructor;", "javaField", "Ljava/lang/reflect/Field;", "Lkotlin/reflect/KProperty;", "getJavaField", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Field;", "javaGetter", "Ljava/lang/reflect/Method;", "getJavaGetter", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Method;", "javaMethod", "getJavaMethod", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Method;", "javaSetter", "Lkotlin/reflect/KMutableProperty;", "getJavaSetter", "(Lkotlin/reflect/KMutableProperty;)Ljava/lang/reflect/Method;", "javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "kotlinFunction", "", "getKotlinFunction", "(Ljava/lang/reflect/Constructor;)Lkotlin/reflect/KFunction;", "(Ljava/lang/reflect/Method;)Lkotlin/reflect/KFunction;", "kotlinProperty", "getKotlinProperty", "(Ljava/lang/reflect/Field;)Lkotlin/reflect/KProperty;", "getKPackage", "Lkotlin/reflect/KDeclarationContainer;", "Ljava/lang/reflect/Member;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "ReflectJvmMapping")
public final class ReflectJvmMapping {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
            iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
            iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Nullable
    public static final <T> Constructor<T> getJavaConstructor(@NotNull KFunction<? extends T> kFunction) {
        Object obj;
        Caller<?> caller;
        Intrinsics.checkNotNullParameter(kFunction, "<this>");
        KCallableImpl<?> asKCallableImpl = UtilKt.asKCallableImpl(kFunction);
        if (asKCallableImpl == null || (caller = asKCallableImpl.getCaller()) == null) {
            obj = null;
        } else {
            obj = caller.getMember();
        }
        if (obj instanceof Constructor) {
            return (Constructor) obj;
        }
        return null;
    }

    public static /* synthetic */ void getJavaConstructor$annotations(KFunction kFunction) {
    }

    @Nullable
    public static final Field getJavaField(@NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "<this>");
        KPropertyImpl<?> asKPropertyImpl = UtilKt.asKPropertyImpl(kProperty);
        if (asKPropertyImpl != null) {
            return asKPropertyImpl.getJavaField();
        }
        return null;
    }

    @Nullable
    public static final Method getJavaGetter(@NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "<this>");
        return getJavaMethod(kProperty.getGetter());
    }

    @Nullable
    public static final Method getJavaMethod(@NotNull KFunction<?> kFunction) {
        Object obj;
        Caller<?> caller;
        Intrinsics.checkNotNullParameter(kFunction, "<this>");
        KCallableImpl<?> asKCallableImpl = UtilKt.asKCallableImpl(kFunction);
        if (asKCallableImpl == null || (caller = asKCallableImpl.getCaller()) == null) {
            obj = null;
        } else {
            obj = caller.getMember();
        }
        if (obj instanceof Method) {
            return (Method) obj;
        }
        return null;
    }

    @Nullable
    public static final Method getJavaSetter(@NotNull KMutableProperty<?> kMutableProperty) {
        Intrinsics.checkNotNullParameter(kMutableProperty, "<this>");
        return getJavaMethod(kMutableProperty.getSetter());
    }

    @NotNull
    public static final Type getJavaType(@NotNull KType kType) {
        Intrinsics.checkNotNullParameter(kType, "<this>");
        Type javaType = ((KTypeImpl) kType).getJavaType();
        if (javaType == null) {
            return TypesJVMKt.getJavaType(kType);
        }
        return javaType;
    }

    private static final KDeclarationContainer getKPackage(Member member) {
        KotlinClassHeader.Kind kind;
        int i11;
        KotlinClassHeader classHeader;
        ReflectKotlinClass.Factory factory = ReflectKotlinClass.Factory;
        Class<?> declaringClass = member.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "declaringClass");
        ReflectKotlinClass create = factory.create(declaringClass);
        if (create == null || (classHeader = create.getClassHeader()) == null) {
            kind = null;
        } else {
            kind = classHeader.getKind();
        }
        if (kind == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
        }
        if (i11 != 1 && i11 != 2 && i11 != 3) {
            return null;
        }
        Class<?> declaringClass2 = member.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass2, "declaringClass");
        return new KPackageImpl(declaringClass2, (String) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: kotlin.reflect.KFunction<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: kotlin.reflect.KFunction<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: kotlin.reflect.KFunction} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: kotlin.reflect.KFunction<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: kotlin.reflect.KFunction<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: kotlin.reflect.KFunction} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: kotlin.reflect.KFunction<?>} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.KFunction<?> getKotlinFunction(@org.jetbrains.annotations.NotNull java.lang.reflect.Method r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            int r0 = r7.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
            java.lang.String r1 = "declaringClass"
            r2 = 0
            if (r0 == 0) goto L_0x00bc
            kotlin.reflect.KDeclarationContainer r0 = getKPackage(r7)
            if (r0 == 0) goto L_0x0058
            java.util.Collection r0 = r0.getMembers()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0027:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0039
            java.lang.Object r3 = r0.next()
            boolean r4 = r3 instanceof kotlin.reflect.KFunction
            if (r4 == 0) goto L_0x0027
            r1.add(r3)
            goto L_0x0027
        L_0x0039:
            java.util.Iterator r0 = r1.iterator()
        L_0x003d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0055
            java.lang.Object r1 = r0.next()
            r3 = r1
            kotlin.reflect.KFunction r3 = (kotlin.reflect.KFunction) r3
            java.lang.reflect.Method r3 = getJavaMethod(r3)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r7)
            if (r3 == 0) goto L_0x003d
            r2 = r1
        L_0x0055:
            kotlin.reflect.KFunction r2 = (kotlin.reflect.KFunction) r2
            return r2
        L_0x0058:
            java.lang.Class r0 = r7.getDeclaringClass()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            kotlin.reflect.KClass r0 = kotlin.jvm.JvmClassMappingKt.getKotlinClass(r0)
            kotlin.reflect.KClass r0 = kotlin.reflect.full.KClasses.getCompanionObject(r0)
            if (r0 == 0) goto L_0x00bc
            java.util.Collection r0 = kotlin.reflect.full.KClasses.getFunctions(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0073:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00b6
            java.lang.Object r3 = r0.next()
            r4 = r3
            kotlin.reflect.KFunction r4 = (kotlin.reflect.KFunction) r4
            java.lang.reflect.Method r4 = getJavaMethod(r4)
            if (r4 == 0) goto L_0x00b2
            java.lang.String r5 = r4.getName()
            java.lang.String r6 = r7.getName()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x00b2
            java.lang.Class[] r5 = r4.getParameterTypes()
            java.lang.Class[] r6 = r7.getParameterTypes()
            boolean r5 = java.util.Arrays.equals(r5, r6)
            if (r5 == 0) goto L_0x00b2
            java.lang.Class r4 = r4.getReturnType()
            java.lang.Class r5 = r7.getReturnType()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x00b2
            r4 = 1
            goto L_0x00b3
        L_0x00b2:
            r4 = 0
        L_0x00b3:
            if (r4 == 0) goto L_0x0073
            goto L_0x00b7
        L_0x00b6:
            r3 = r2
        L_0x00b7:
            kotlin.reflect.KFunction r3 = (kotlin.reflect.KFunction) r3
            if (r3 == 0) goto L_0x00bc
            return r3
        L_0x00bc:
            java.lang.Class r0 = r7.getDeclaringClass()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            kotlin.reflect.KClass r0 = kotlin.jvm.JvmClassMappingKt.getKotlinClass(r0)
            java.util.Collection r0 = kotlin.reflect.full.KClasses.getFunctions(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x00d1:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00e9
            java.lang.Object r1 = r0.next()
            r3 = r1
            kotlin.reflect.KFunction r3 = (kotlin.reflect.KFunction) r3
            java.lang.reflect.Method r3 = getJavaMethod(r3)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r7)
            if (r3 == 0) goto L_0x00d1
            r2 = r1
        L_0x00e9:
            kotlin.reflect.KFunction r2 = (kotlin.reflect.KFunction) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.ReflectJvmMapping.getKotlinFunction(java.lang.reflect.Method):kotlin.reflect.KFunction");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: kotlin.reflect.KProperty<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: kotlin.reflect.KProperty<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: kotlin.reflect.KProperty1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: kotlin.reflect.KProperty<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlin.reflect.KProperty<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: kotlin.reflect.KProperty} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: kotlin.reflect.KProperty<?>} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.KProperty<?> getKotlinProperty(@org.jetbrains.annotations.NotNull java.lang.reflect.Field r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            boolean r0 = r5.isSynthetic()
            r1 = 0
            if (r0 == 0) goto L_0x000d
            return r1
        L_0x000d:
            kotlin.reflect.KDeclarationContainer r0 = getKPackage(r5)
            if (r0 == 0) goto L_0x0053
            java.util.Collection r0 = r0.getMembers()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0022:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0034
            java.lang.Object r3 = r0.next()
            boolean r4 = r3 instanceof kotlin.reflect.KProperty
            if (r4 == 0) goto L_0x0022
            r2.add(r3)
            goto L_0x0022
        L_0x0034:
            java.util.Iterator r0 = r2.iterator()
        L_0x0038:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0050
            java.lang.Object r2 = r0.next()
            r3 = r2
            kotlin.reflect.KProperty r3 = (kotlin.reflect.KProperty) r3
            java.lang.reflect.Field r3 = getJavaField(r3)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x0038
            r1 = r2
        L_0x0050:
            kotlin.reflect.KProperty r1 = (kotlin.reflect.KProperty) r1
            return r1
        L_0x0053:
            java.lang.Class r0 = r5.getDeclaringClass()
            java.lang.String r2 = "declaringClass"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            kotlin.reflect.KClass r0 = kotlin.jvm.JvmClassMappingKt.getKotlinClass(r0)
            java.util.Collection r0 = kotlin.reflect.full.KClasses.getMemberProperties(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x006a:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0082
            java.lang.Object r2 = r0.next()
            r3 = r2
            kotlin.reflect.KProperty1 r3 = (kotlin.reflect.KProperty1) r3
            java.lang.reflect.Field r3 = getJavaField(r3)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x006a
            r1 = r2
        L_0x0082:
            kotlin.reflect.KProperty r1 = (kotlin.reflect.KProperty) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.ReflectJvmMapping.getKotlinProperty(java.lang.reflect.Field):kotlin.reflect.KProperty");
    }

    @Nullable
    public static final <T> KFunction<T> getKotlinFunction(@NotNull Constructor<T> constructor) {
        Object obj;
        Intrinsics.checkNotNullParameter(constructor, "<this>");
        Class<T> declaringClass = constructor.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "declaringClass");
        Iterator it = JvmClassMappingKt.getKotlinClass(declaringClass).getConstructors().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) getJavaConstructor((KFunction) obj), (Object) constructor)) {
                break;
            }
        }
        return (KFunction) obj;
    }
}
