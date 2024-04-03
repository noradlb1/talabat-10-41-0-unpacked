package kotlin.reflect.jvm.internal.impl.name;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class StandardClassIdsKt {
    @NotNull
    private static final FqName JAVA_LANG_ANNOTATION_PACKAGE;
    @NotNull
    private static final FqName JAVA_LANG_PACKAGE;

    static {
        FqName fqName = new FqName("java.lang");
        JAVA_LANG_PACKAGE = fqName;
        FqName child = fqName.child(Name.identifier("annotation"));
        Intrinsics.checkNotNullExpressionValue(child, "JAVA_LANG_PACKAGE.child(…identifier(\"annotation\"))");
        JAVA_LANG_ANNOTATION_PACKAGE = child;
    }

    /* access modifiers changed from: private */
    public static final ClassId annotationId(String str) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_ANNOTATION_PACKAGE(), Name.identifier(str));
    }

    /* access modifiers changed from: private */
    public static final ClassId baseId(String str) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_KOTLIN_PACKAGE(), Name.identifier(str));
    }

    /* access modifiers changed from: private */
    public static final ClassId collectionsId(String str) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_COLLECTIONS_PACKAGE(), Name.identifier(str));
    }

    /* access modifiers changed from: private */
    public static final ClassId coroutinesId(String str) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_COROUTINES_PACKAGE(), Name.identifier(str));
    }

    /* access modifiers changed from: private */
    public static final <K, V> Map<V, K> inverseMap(Map<K, ? extends V> map) {
        Set<Map.Entry<K, ? extends V>> entrySet = map.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(entrySet, 10)), 16));
        for (Map.Entry entry : entrySet) {
            Pair pair = TuplesKt.to(entry.getValue(), entry.getKey());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: private */
    public static final ClassId primitiveArrayId(Name name2) {
        StandardClassIds standardClassIds = StandardClassIds.INSTANCE;
        FqName packageFqName = standardClassIds.getArray().getPackageFqName();
        return new ClassId(packageFqName, Name.identifier(name2.getIdentifier() + standardClassIds.getArray().getShortClassName().getIdentifier()));
    }

    /* access modifiers changed from: private */
    public static final ClassId rangesId(String str) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_RANGES_PACKAGE(), Name.identifier(str));
    }

    /* access modifiers changed from: private */
    public static final ClassId reflectId(String str) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_REFLECT_PACKAGE(), Name.identifier(str));
    }

    /* access modifiers changed from: private */
    public static final ClassId unsignedId(ClassId classId) {
        FqName base_kotlin_package = StandardClassIds.INSTANCE.getBASE_KOTLIN_PACKAGE();
        return new ClassId(base_kotlin_package, Name.identifier('U' + classId.getShortClassName().getIdentifier()));
    }
}
