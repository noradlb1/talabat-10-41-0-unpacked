package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class KotlinTypeRefinerKt {
    @NotNull
    private static final ModuleCapability<Ref<TypeRefinementSupport>> REFINER_CAPABILITY = new ModuleCapability<>("KotlinTypeRefiner");

    @NotNull
    public static final ModuleCapability<Ref<TypeRefinementSupport>> getREFINER_CAPABILITY() {
        return REFINER_CAPABILITY;
    }

    @NotNull
    public static final List<KotlinType> refineTypes(@NotNull KotlinTypeRefiner kotlinTypeRefiner, @NotNull Iterable<? extends KotlinType> iterable) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "types");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (KotlinType refineType : iterable) {
            arrayList.add(kotlinTypeRefiner.refineType(refineType));
        }
        return arrayList;
    }
}
