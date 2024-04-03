package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.adjust.sdk.Constants;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.TuplesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import net.bytebuddy.pool.TypePool;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectClassUtilKt {
    @NotNull
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES;
    @NotNull
    private static final List<KClass<? extends Object>> PRIMITIVE_CLASSES;
    @NotNull
    private static final Map<Class<? extends Object>, Class<? extends Object>> PRIMITIVE_TO_WRAPPER;
    @NotNull
    private static final Map<Class<? extends Object>, Class<? extends Object>> WRAPPER_TO_PRIMITIVE;

    static {
        int i11 = 0;
        List<KClass<? extends Object>> listOf = CollectionsKt__CollectionsKt.listOf(Reflection.getOrCreateKotlinClass(Boolean.TYPE), Reflection.getOrCreateKotlinClass(Byte.TYPE), Reflection.getOrCreateKotlinClass(Character.TYPE), Reflection.getOrCreateKotlinClass(Double.TYPE), Reflection.getOrCreateKotlinClass(Float.TYPE), Reflection.getOrCreateKotlinClass(Integer.TYPE), Reflection.getOrCreateKotlinClass(Long.TYPE), Reflection.getOrCreateKotlinClass(Short.TYPE));
        PRIMITIVE_CLASSES = listOf;
        Iterable<KClass> iterable = listOf;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (KClass kClass : iterable) {
            arrayList.add(TuplesKt.to(JvmClassMappingKt.getJavaObjectType(kClass), JvmClassMappingKt.getJavaPrimitiveType(kClass)));
        }
        WRAPPER_TO_PRIMITIVE = MapsKt__MapsKt.toMap(arrayList);
        Iterable<KClass> iterable2 = PRIMITIVE_CLASSES;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
        for (KClass kClass2 : iterable2) {
            arrayList2.add(TuplesKt.to(JvmClassMappingKt.getJavaPrimitiveType(kClass2), JvmClassMappingKt.getJavaObjectType(kClass2)));
        }
        PRIMITIVE_TO_WRAPPER = MapsKt__MapsKt.toMap(arrayList2);
        Iterable listOf2 = CollectionsKt__CollectionsKt.listOf(Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class);
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listOf2, 10));
        for (Object next : listOf2) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList3.add(TuplesKt.to((Class) next, Integer.valueOf(i11)));
            i11 = i12;
        }
        FUNCTION_CLASSES = MapsKt__MapsKt.toMap(arrayList3);
    }

    @NotNull
    public static final ClassId getClassId(@NotNull Class<?> cls) {
        boolean z11;
        ClassId classId;
        ClassId classId2;
        Intrinsics.checkNotNullParameter(cls, "<this>");
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException("Can't compute ClassId for primitive type: " + cls);
        } else if (!cls.isArray()) {
            if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
                String simpleName = cls.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "simpleName");
                if (simpleName.length() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    Class<?> declaringClass = cls.getDeclaringClass();
                    if (declaringClass == null || (classId2 = getClassId(declaringClass)) == null || (classId = classId2.createNestedClassId(Name.identifier(cls.getSimpleName()))) == null) {
                        classId = ClassId.topLevel(new FqName(cls.getName()));
                    }
                    Intrinsics.checkNotNullExpressionValue(classId, "declaringClass?.classId?…Id.topLevel(FqName(name))");
                    return classId;
                }
            }
            FqName fqName = new FqName(cls.getName());
            return new ClassId(fqName.parent(), FqName.topLevel(fqName.shortName()), true);
        } else {
            throw new IllegalArgumentException("Can't compute ClassId for array type: " + cls);
        }
    }

    @NotNull
    public static final String getDesc(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        if (cls.isPrimitive()) {
            String name2 = cls.getName();
            switch (name2.hashCode()) {
                case -1325958191:
                    if (name2.equals("double")) {
                        return "D";
                    }
                    break;
                case 104431:
                    if (name2.equals("int")) {
                        return "I";
                    }
                    break;
                case 3039496:
                    if (name2.equals("byte")) {
                        return "B";
                    }
                    break;
                case 3052374:
                    if (name2.equals("char")) {
                        return "C";
                    }
                    break;
                case 3327612:
                    if (name2.equals(Constants.LONG)) {
                        return "J";
                    }
                    break;
                case 3625364:
                    if (name2.equals("void")) {
                        return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
                    }
                    break;
                case 64711720:
                    if (name2.equals(TypedValues.Custom.S_BOOLEAN)) {
                        return "Z";
                    }
                    break;
                case 97526364:
                    if (name2.equals(TypedValues.Custom.S_FLOAT)) {
                        return "F";
                    }
                    break;
                case 109413500:
                    if (name2.equals("short")) {
                        return ExifInterface.LATITUDE_SOUTH;
                    }
                    break;
            }
            throw new IllegalArgumentException("Unsupported primitive type: " + cls);
        } else if (cls.isArray()) {
            String name3 = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "name");
            return StringsKt__StringsJVMKt.replace$default(name3, '.', '/', false, 4, (Object) null);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('L');
            String name4 = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name4, "name");
            sb2.append(StringsKt__StringsJVMKt.replace$default(name4, '.', '/', false, 4, (Object) null));
            sb2.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
            return sb2.toString();
        }
    }

    @Nullable
    public static final Integer getFunctionClassArity(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return FUNCTION_CLASSES.get(cls);
    }

    @NotNull
    public static final List<Type> getParameterizedTypeArguments(@NotNull Type type) {
        Intrinsics.checkNotNullParameter(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() != null) {
            return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.flatMap(SequencesKt__SequencesKt.generateSequence(type, ReflectClassUtilKt$parameterizedTypeArguments$1.INSTANCE), ReflectClassUtilKt$parameterizedTypeArguments$2.INSTANCE));
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "actualTypeArguments");
        return ArraysKt___ArraysKt.toList((T[]) actualTypeArguments);
    }

    @Nullable
    public static final Class<?> getPrimitiveByWrapper(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return WRAPPER_TO_PRIMITIVE.get(cls);
    }

    @NotNull
    public static final ClassLoader getSafeClassLoader(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Intrinsics.checkNotNullExpressionValue(systemClassLoader, "getSystemClassLoader()");
        return systemClassLoader;
    }

    @Nullable
    public static final Class<?> getWrapperByPrimitive(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return PRIMITIVE_TO_WRAPPER.get(cls);
    }

    public static final boolean isEnumClassOrSpecializedEnumEntryClass(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }
}
