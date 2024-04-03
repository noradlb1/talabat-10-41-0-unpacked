package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.pool.TypePool;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u0000 =2\u00020\u0001:\u0003=>?B\u0007¢\u0006\u0004\b;\u0010<JG\u0010\u000b\u001a\u0004\u0018\u00010\n*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00052\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ?\u0010\r\u001a\u0004\u0018\u00010\n*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00052\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ(\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u0006\u0012\u0002\b\u00030\u00022\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u000fH\u0002J*\u0010\u0017\u001a\u00020\u00162\u0010\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\bH\u0002J\u001a\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J$\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0002J\u0014\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0004\u001a\u00020\u001eH&J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u001f2\u0006\u0010\u0004\u001a\u00020\u001eH&J\u0012\u0010%\u001a\u0004\u0018\u00010 2\u0006\u0010$\u001a\u00020\u0019H&J\"\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030*0\u001f2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(H\u0004J\u0016\u0010-\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0003J\u0016\u0010.\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0003J\u0018\u0010/\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003J \u00101\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u00100\u001a\u00020\bJ\u0014\u00102\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u0003J\u0014\u00103\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u0003R\u0018\u00106\u001a\u0006\u0012\u0002\b\u00030\u00028TX\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u0002070\u001f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006@"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "Ljava/lang/Class;", "", "name", "", "parameterTypes", "returnType", "", "isStaticDefault", "Ljava/lang/reflect/Method;", "lookupMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "tryGetMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "", "Ljava/lang/reflect/Constructor;", "tryGetConstructor", "", "result", "desc", "isConstructor", "", "addParametersAndMasks", "loadParameterTypes", "", "begin", "end", "parseType", "loadReturnType", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getProperties", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getFunctions", "index", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "scope", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "belonginess", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "a", "signature", "findPropertyDescriptor", "findFunctionDescriptor", "findMethodBySignature", "isMember", "findDefaultMethod", "findConstructorBySignature", "findDefaultConstructor", "b", "()Ljava/lang/Class;", "methodOwner", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructorDescriptors", "<init>", "()V", "Companion", "Data", "MemberBelonginess", "kotlin-reflection"}, k = 1, mv = {1, 7, 1})
public abstract class KDeclarationContainerImpl implements ClassBasedDeclarationContainer {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Class<?> DEFAULT_CONSTRUCTOR_MARKER = DefaultConstructorMarker.class;
    /* access modifiers changed from: private */
    @NotNull
    public static final Regex LOCAL_PROPERTY_SIGNATURE = new Regex("<v#(\\d+)>");

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", "", "()V", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection", "()Lkotlin/text/Regex;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Regex getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection() {
            return KDeclarationContainerImpl.LOCAL_PROPERTY_SIGNATURE;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b¦\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public abstract class Data {

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ KProperty<Object>[] f24393b = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};
        @NotNull
        private final ReflectProperties.LazySoftVal moduleData$delegate;

        public Data() {
            this.moduleData$delegate = ReflectProperties.lazySoft(new KDeclarationContainerImpl$Data$moduleData$2(KDeclarationContainerImpl.this));
        }

        @NotNull
        public final RuntimeModuleData getModuleData() {
            Object value = this.moduleData$delegate.getValue(this, f24393b[0]);
            Intrinsics.checkNotNullExpressionValue(value, "<get-moduleData>(...)");
            return (RuntimeModuleData) value;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "(Ljava/lang/String;I)V", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "DECLARED", "INHERITED", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum MemberBelonginess {
        DECLARED,
        INHERITED;

        public final boolean accept(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
            boolean z11;
            Intrinsics.checkNotNullParameter(callableMemberDescriptor, "member");
            boolean isReal = callableMemberDescriptor.getKind().isReal();
            if (this == DECLARED) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (isReal == z11) {
                return true;
            }
            return false;
        }
    }

    private final void addParametersAndMasks(List<Class<?>> list, String str, boolean z11) {
        List<Class<?>> loadParameterTypes = loadParameterTypes(str);
        list.addAll(loadParameterTypes);
        int size = ((loadParameterTypes.size() + 32) - 1) / 32;
        for (int i11 = 0; i11 < size; i11++) {
            Class cls = Integer.TYPE;
            Intrinsics.checkNotNullExpressionValue(cls, "TYPE");
            list.add(cls);
        }
        if (z11) {
            Class<?> cls2 = DEFAULT_CONSTRUCTOR_MARKER;
            list.remove(cls2);
            Intrinsics.checkNotNullExpressionValue(cls2, "DEFAULT_CONSTRUCTOR_MARKER");
            list.add(cls2);
            return;
        }
        list.add(Object.class);
    }

    private final List<Class<?>> loadParameterTypes(String str) {
        int i11;
        ArrayList arrayList = new ArrayList();
        int i12 = 1;
        while (str.charAt(i12) != ')') {
            int i13 = i12;
            while (str.charAt(i13) == '[') {
                i13++;
            }
            char charAt = str.charAt(i13);
            if (StringsKt__StringsKt.contains$default((CharSequence) "VZCBSIFJD", charAt, false, 2, (Object) null)) {
                i11 = i13 + 1;
            } else if (charAt == 'L') {
                i11 = StringsKt__StringsKt.indexOf$default((CharSequence) str, (char) TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER, i12, false, 4, (Object) null) + 1;
            } else {
                throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + str);
            }
            arrayList.add(parseType(str, i12, i11));
            i12 = i11;
        }
        return arrayList;
    }

    private final Class<?> loadReturnType(String str) {
        return parseType(str, StringsKt__StringsKt.indexOf$default((CharSequence) str, ')', 0, false, 6, (Object) null) + 1, str.length());
    }

    private final Method lookupMethod(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z11) {
        Method lookupMethod;
        if (z11) {
            clsArr[0] = cls;
        }
        Method tryGetMethod = tryGetMethod(cls, str, clsArr, cls2);
        if (tryGetMethod != null) {
            return tryGetMethod;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && (lookupMethod = lookupMethod(superclass, str, clsArr, cls2, z11)) != null) {
            return lookupMethod;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        Intrinsics.checkNotNullExpressionValue(interfaces, "interfaces");
        for (Class<?> cls3 : interfaces) {
            Intrinsics.checkNotNullExpressionValue(cls3, "superInterface");
            Method lookupMethod2 = lookupMethod(cls3, str, clsArr, cls2, z11);
            if (lookupMethod2 != null) {
                return lookupMethod2;
            }
            if (z11) {
                Class<?> tryLoadClass = ReflectJavaClassFinderKt.tryLoadClass(ReflectClassUtilKt.getSafeClassLoader(cls3), cls3.getName() + "$DefaultImpls");
                if (tryLoadClass != null) {
                    clsArr[0] = cls3;
                    Method tryGetMethod2 = tryGetMethod(tryLoadClass, str, clsArr, cls2);
                    if (tryGetMethod2 != null) {
                        return tryGetMethod2;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    private final Class<?> parseType(String str, int i11, int i12) {
        char charAt = str.charAt(i11);
        if (charAt == 'L') {
            ClassLoader safeClassLoader = ReflectClassUtilKt.getSafeClassLoader(getJClass());
            String substring = str.substring(i11 + 1, i12 - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            Class<?> loadClass = safeClassLoader.loadClass(StringsKt__StringsJVMKt.replace$default(substring, '/', '.', false, 4, (Object) null));
            Intrinsics.checkNotNullExpressionValue(loadClass, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
            return loadClass;
        } else if (charAt == '[') {
            return UtilKt.createArrayType(parseType(str, i11 + 1, i12));
        } else {
            if (charAt == 'V') {
                Class<?> cls = Void.TYPE;
                Intrinsics.checkNotNullExpressionValue(cls, "TYPE");
                return cls;
            } else if (charAt == 'Z') {
                return Boolean.TYPE;
            } else {
                if (charAt == 'C') {
                    return Character.TYPE;
                }
                if (charAt == 'B') {
                    return Byte.TYPE;
                }
                if (charAt == 'S') {
                    return Short.TYPE;
                }
                if (charAt == 'I') {
                    return Integer.TYPE;
                }
                if (charAt == 'F') {
                    return Float.TYPE;
                }
                if (charAt == 'J') {
                    return Long.TYPE;
                }
                if (charAt == 'D') {
                    return Double.TYPE;
                }
                throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + str);
            }
        }
    }

    private final Constructor<?> tryGetConstructor(Class<?> cls, List<? extends Class<?>> list) {
        try {
            Object[] array = list.toArray(new Class[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            Class[] clsArr = (Class[]) array;
            return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final Method tryGetMethod(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2) {
        boolean z11;
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            if (Intrinsics.areEqual((Object) declaredMethod.getReturnType(), (Object) cls2)) {
                return declaredMethod;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "declaredMethods");
            for (Method method : declaredMethods) {
                if (!Intrinsics.areEqual((Object) method.getName(), (Object) str) || !Intrinsics.areEqual((Object) method.getReturnType(), (Object) cls2) || !Arrays.equals(method.getParameterTypes(), clsArr)) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (z11) {
                    return method;
                }
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0020 A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> a(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r8, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.KDeclarationContainerImpl.MemberBelonginess r9) {
        /*
            r7 = this;
            java.lang.String r0 = "scope"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "belonginess"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl$getMembers$visitor$1 r0 = new kotlin.reflect.jvm.internal.KDeclarationContainerImpl$getMembers$visitor$1
            r0.<init>(r7)
            r1 = 3
            r2 = 0
            java.util.Collection r8 = kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope.DefaultImpls.getContributedDescriptors$default(r8, r2, r2, r1, r2)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r8 = r8.iterator()
        L_0x0020:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L_0x0055
            java.lang.Object r3 = r8.next()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r3
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
            if (r4 == 0) goto L_0x004e
            r4 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r4
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r5 = r4.getVisibility()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r6 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INVISIBLE_FAKE
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 != 0) goto L_0x004e
            boolean r4 = r9.accept(r4)
            if (r4 == 0) goto L_0x004e
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            java.lang.Object r3 = r3.accept(r0, r4)
            kotlin.reflect.jvm.internal.KCallableImpl r3 = (kotlin.reflect.jvm.internal.KCallableImpl) r3
            goto L_0x004f
        L_0x004e:
            r3 = r2
        L_0x004f:
            if (r3 == 0) goto L_0x0020
            r1.add(r3)
            goto L_0x0020
        L_0x0055:
            java.util.List r8 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r1)
            java.util.Collection r8 = (java.util.Collection) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.KDeclarationContainerImpl$MemberBelonginess):java.util.Collection");
    }

    @NotNull
    public Class<?> b() {
        Class<?> wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        return wrapperByPrimitive == null ? getJClass() : wrapperByPrimitive;
    }

    @Nullable
    public final Constructor<?> findConstructorBySignature(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "desc");
        return tryGetConstructor(getJClass(), loadParameterTypes(str));
    }

    @Nullable
    public final Constructor<?> findDefaultConstructor(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "desc");
        Class<?> jClass = getJClass();
        ArrayList arrayList = new ArrayList();
        addParametersAndMasks(arrayList, str, true);
        Unit unit = Unit.INSTANCE;
        return tryGetConstructor(jClass, arrayList);
    }

    @Nullable
    public final Method findDefaultMethod(@NotNull String str, @NotNull String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "desc");
        if (Intrinsics.areEqual((Object) str, (Object) MethodDescription.CONSTRUCTOR_INTERNAL_NAME)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z11) {
            arrayList.add(getJClass());
        }
        addParametersAndMasks(arrayList, str2, false);
        Class<?> b11 = b();
        String str3 = str + "$default";
        Object[] array = arrayList.toArray(new Class[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return lookupMethod(b11, str3, (Class[]) array, loadReturnType(str2), z11);
    }

    @NotNull
    public final FunctionDescriptor findFunctionDescriptor(@NotNull String str, @NotNull String str2) {
        Collection<FunctionDescriptor> collection;
        String str3;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "signature");
        if (Intrinsics.areEqual((Object) str, (Object) MethodDescription.CONSTRUCTOR_INTERNAL_NAME)) {
            collection = CollectionsKt___CollectionsKt.toList(getConstructorDescriptors());
        } else {
            Name identifier = Name.identifier(str);
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(name)");
            collection = getFunctions(identifier);
        }
        Iterable iterable = collection;
        ArrayList arrayList = new ArrayList();
        for (Object next : iterable) {
            if (Intrinsics.areEqual((Object) RuntimeTypeMapper.INSTANCE.mapSignature((FunctionDescriptor) next).asString(), (Object) str2)) {
                arrayList.add(next);
            }
        }
        boolean z11 = true;
        if (arrayList.size() == 1) {
            return (FunctionDescriptor) CollectionsKt___CollectionsKt.single(arrayList);
        }
        String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(iterable, StringUtils.LF, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1.INSTANCE, 30, (Object) null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Function '");
        sb2.append(str);
        sb2.append("' (JVM signature: ");
        sb2.append(str2);
        sb2.append(") not resolved in ");
        sb2.append(this);
        sb2.append(AbstractJsonLexerKt.COLON);
        if (joinToString$default.length() != 0) {
            z11 = false;
        }
        if (z11) {
            str3 = " no members found";
        } else {
            str3 = 10 + joinToString$default;
        }
        sb2.append(str3);
        throw new KotlinReflectionInternalError(sb2.toString());
    }

    @Nullable
    public final Method findMethodBySignature(@NotNull String str, @NotNull String str2) {
        Method lookupMethod;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "desc");
        if (Intrinsics.areEqual((Object) str, (Object) MethodDescription.CONSTRUCTOR_INTERNAL_NAME)) {
            return null;
        }
        Object[] array = loadParameterTypes(str2).toArray(new Class[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Class[] clsArr = (Class[]) array;
        Class<?> loadReturnType = loadReturnType(str2);
        Method lookupMethod2 = lookupMethod(b(), str, clsArr, loadReturnType, false);
        if (lookupMethod2 != null) {
            return lookupMethod2;
        }
        if (!b().isInterface() || (lookupMethod = lookupMethod(Object.class, str, clsArr, loadReturnType, false)) == null) {
            return null;
        }
        return lookupMethod;
    }

    @NotNull
    public final PropertyDescriptor findPropertyDescriptor(@NotNull String str, @NotNull String str2) {
        String str3;
        String str4 = str;
        String str5 = str2;
        Intrinsics.checkNotNullParameter(str4, "name");
        Intrinsics.checkNotNullParameter(str5, "signature");
        MatchResult matchEntire = LOCAL_PROPERTY_SIGNATURE.matchEntire(str5);
        boolean z11 = true;
        if (matchEntire != null) {
            String str6 = matchEntire.getDestructured().getMatch().getGroupValues().get(1);
            PropertyDescriptor localProperty = getLocalProperty(Integer.parseInt(str6));
            if (localProperty != null) {
                return localProperty;
            }
            throw new KotlinReflectionInternalError("Local property #" + str6 + " not found in " + getJClass());
        }
        Name identifier = Name.identifier(str);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(name)");
        ArrayList arrayList = new ArrayList();
        for (Object next : getProperties(identifier)) {
            if (Intrinsics.areEqual((Object) RuntimeTypeMapper.INSTANCE.mapPropertySignature((PropertyDescriptor) next).asString(), (Object) str5)) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            throw new KotlinReflectionInternalError("Property '" + str4 + "' (JVM signature: " + str5 + ") not resolved in " + this);
        } else if (arrayList.size() == 1) {
            return (PropertyDescriptor) CollectionsKt___CollectionsKt.single(arrayList);
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object next2 : arrayList) {
                DescriptorVisibility visibility = ((PropertyDescriptor) next2).getVisibility();
                Object obj = linkedHashMap.get(visibility);
                if (obj == null) {
                    obj = new ArrayList();
                    linkedHashMap.put(visibility, obj);
                }
                ((List) obj).add(next2);
            }
            Collection values = MapsKt__MapsJVMKt.toSortedMap(linkedHashMap, KDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2.INSTANCE).values();
            Intrinsics.checkNotNullExpressionValue(values, "properties\n             …\n                }.values");
            List list = (List) CollectionsKt___CollectionsKt.last(values);
            if (list.size() == 1) {
                Intrinsics.checkNotNullExpressionValue(list, "mostVisibleProperties");
                return (PropertyDescriptor) CollectionsKt___CollectionsKt.first(list);
            }
            Name identifier2 = Name.identifier(str);
            Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(name)");
            String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(getProperties(identifier2), StringUtils.LF, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1.INSTANCE, 30, (Object) null);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Property '");
            sb2.append(str4);
            sb2.append("' (JVM signature: ");
            sb2.append(str5);
            sb2.append(") not resolved in ");
            sb2.append(this);
            sb2.append(AbstractJsonLexerKt.COLON);
            if (joinToString$default.length() != 0) {
                z11 = false;
            }
            if (z11) {
                str3 = " no members found";
            } else {
                str3 = 10 + joinToString$default;
            }
            sb2.append(str3);
            throw new KotlinReflectionInternalError(sb2.toString());
        }
    }

    @NotNull
    public abstract Collection<ConstructorDescriptor> getConstructorDescriptors();

    @NotNull
    public abstract Collection<FunctionDescriptor> getFunctions(@NotNull Name name2);

    @Nullable
    public abstract PropertyDescriptor getLocalProperty(int i11);

    @NotNull
    public abstract Collection<PropertyDescriptor> getProperties(@NotNull Name name2);
}
