package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.ArrayList;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

public final class CapturedTypeConstructorKt {
    /* access modifiers changed from: private */
    public static final TypeProjection createCapturedIfNeeded(TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor == null || typeProjection.getProjectionKind() == Variance.INVARIANT) {
            return typeProjection;
        }
        if (typeParameterDescriptor.getVariance() != typeProjection.getProjectionKind()) {
            return new TypeProjectionImpl(createCapturedType(typeProjection));
        }
        if (!typeProjection.isStarProjection()) {
            return new TypeProjectionImpl(typeProjection.getType());
        }
        StorageManager storageManager = LockBasedStorageManager.NO_LOCKS;
        Intrinsics.checkNotNullExpressionValue(storageManager, "NO_LOCKS");
        return new TypeProjectionImpl(new LazyWrappedType(storageManager, new CapturedTypeConstructorKt$createCapturedIfNeeded$1(typeProjection)));
    }

    @NotNull
    public static final KotlinType createCapturedType(@NotNull TypeProjection typeProjection) {
        Intrinsics.checkNotNullParameter(typeProjection, "typeProjection");
        return new CapturedType(typeProjection, (CapturedTypeConstructor) null, false, (TypeAttributes) null, 14, (DefaultConstructorMarker) null);
    }

    public static final boolean isCaptured(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return kotlinType.getConstructor() instanceof CapturedTypeConstructor;
    }

    @NotNull
    public static final TypeSubstitution wrapWithCapturingSubstitution(@NotNull TypeSubstitution typeSubstitution, boolean z11) {
        Intrinsics.checkNotNullParameter(typeSubstitution, "<this>");
        if (!(typeSubstitution instanceof IndexedParametersSubstitution)) {
            return new CapturedTypeConstructorKt$wrapWithCapturingSubstitution$2(typeSubstitution, z11);
        }
        IndexedParametersSubstitution indexedParametersSubstitution = (IndexedParametersSubstitution) typeSubstitution;
        TypeParameterDescriptor[] parameters = indexedParametersSubstitution.getParameters();
        Iterable<Pair> zip = ArraysKt___ArraysKt.zip((T[]) indexedParametersSubstitution.getArguments(), (R[]) indexedParametersSubstitution.getParameters());
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(zip, 10));
        for (Pair pair : zip) {
            arrayList.add(createCapturedIfNeeded((TypeProjection) pair.getFirst(), (TypeParameterDescriptor) pair.getSecond()));
        }
        Object[] array = arrayList.toArray(new TypeProjection[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return new IndexedParametersSubstitution(parameters, (TypeProjection[]) array, z11);
    }

    public static /* synthetic */ TypeSubstitution wrapWithCapturingSubstitution$default(TypeSubstitution typeSubstitution, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        return wrapWithCapturingSubstitution(typeSubstitution, z11);
    }
}
