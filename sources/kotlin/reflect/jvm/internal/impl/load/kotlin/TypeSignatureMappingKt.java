package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.instabug.library.model.session.config.SessionsConfigParameter;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementUtilsKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeSignatureMappingKt {
    @NotNull
    public static final <T> T boxTypeIfNeeded(@NotNull JvmTypeFactory<T> jvmTypeFactory, @NotNull T t11, boolean z11) {
        Intrinsics.checkNotNullParameter(jvmTypeFactory, "<this>");
        Intrinsics.checkNotNullParameter(t11, "possiblyPrimitiveType");
        if (z11) {
            return jvmTypeFactory.boxType(t11);
        }
        return t11;
    }

    @Nullable
    public static final <T> T mapBuiltInType(@NotNull TypeSystemCommonBackendContext typeSystemCommonBackendContext, @NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull JvmTypeFactory<T> jvmTypeFactory, @NotNull TypeMappingMode typeMappingMode) {
        ClassId classId;
        Intrinsics.checkNotNullParameter(typeSystemCommonBackendContext, "<this>");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
        Intrinsics.checkNotNullParameter(jvmTypeFactory, "typeFactory");
        Intrinsics.checkNotNullParameter(typeMappingMode, SessionsConfigParameter.SYNC_MODE);
        TypeConstructorMarker typeConstructor = typeSystemCommonBackendContext.typeConstructor(kotlinTypeMarker);
        if (!typeSystemCommonBackendContext.isClassTypeConstructor(typeConstructor)) {
            return null;
        }
        PrimitiveType primitiveType = typeSystemCommonBackendContext.getPrimitiveType(typeConstructor);
        boolean z11 = true;
        if (primitiveType != null) {
            T createPrimitiveType = jvmTypeFactory.createPrimitiveType(primitiveType);
            if (!typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker) && !TypeEnhancementUtilsKt.hasEnhancedNullability(typeSystemCommonBackendContext, kotlinTypeMarker)) {
                z11 = false;
            }
            return boxTypeIfNeeded(jvmTypeFactory, createPrimitiveType, z11);
        }
        PrimitiveType primitiveArrayType = typeSystemCommonBackendContext.getPrimitiveArrayType(typeConstructor);
        if (primitiveArrayType != null) {
            return jvmTypeFactory.createFromString('[' + JvmPrimitiveType.get(primitiveArrayType).getDesc());
        }
        if (typeSystemCommonBackendContext.isUnderKotlinPackage(typeConstructor)) {
            FqNameUnsafe classFqNameUnsafe = typeSystemCommonBackendContext.getClassFqNameUnsafe(typeConstructor);
            if (classFqNameUnsafe != null) {
                classId = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(classFqNameUnsafe);
            } else {
                classId = null;
            }
            if (classId != null) {
                if (!typeMappingMode.getKotlinCollectionsToJavaCollections()) {
                    Iterable mutabilityMappings = JavaToKotlinClassMap.INSTANCE.getMutabilityMappings();
                    if (!(mutabilityMappings instanceof Collection) || !((Collection) mutabilityMappings).isEmpty()) {
                        Iterator it = mutabilityMappings.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (Intrinsics.areEqual((Object) ((JavaToKotlinClassMap.PlatformMutabilityMapping) it.next()).getJavaClass(), (Object) classId)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    z11 = false;
                    if (z11) {
                        return null;
                    }
                }
                String internalName = JvmClassName.byClassId(classId).getInternalName();
                Intrinsics.checkNotNullExpressionValue(internalName, "byClassId(classId).internalName");
                return jvmTypeFactory.createObjectType(internalName);
            }
        }
        return null;
    }
}
