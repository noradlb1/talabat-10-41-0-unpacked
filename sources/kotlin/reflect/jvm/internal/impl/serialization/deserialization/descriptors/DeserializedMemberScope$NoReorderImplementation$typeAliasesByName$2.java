package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import org.jetbrains.annotations.NotNull;

public final class DeserializedMemberScope$NoReorderImplementation$typeAliasesByName$2 extends Lambda implements Function0<Map<Name, ? extends TypeAliasDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeserializedMemberScope.NoReorderImplementation f24898g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$NoReorderImplementation$typeAliasesByName$2(DeserializedMemberScope.NoReorderImplementation noReorderImplementation) {
        super(0);
        this.f24898g = noReorderImplementation;
    }

    @NotNull
    public final Map<Name, TypeAliasDescriptor> invoke() {
        Iterable access$getAllTypeAliases = this.f24898g.getAllTypeAliases();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(access$getAllTypeAliases, 10)), 16));
        for (Object next : access$getAllTypeAliases) {
            Name name2 = ((TypeAliasDescriptor) next).getName();
            Intrinsics.checkNotNullExpressionValue(name2, "it.name");
            linkedHashMap.put(name2, next);
        }
        return linkedHashMap;
    }
}
