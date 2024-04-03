package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;

public final class TypeTable {
    @NotNull
    private final List<ProtoBuf.Type> types;

    public TypeTable(@NotNull ProtoBuf.TypeTable typeTable) {
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        List<ProtoBuf.Type> typeList = typeTable.getTypeList();
        if (typeTable.hasFirstNullable()) {
            int firstNullable = typeTable.getFirstNullable();
            List<ProtoBuf.Type> typeList2 = typeTable.getTypeList();
            Intrinsics.checkNotNullExpressionValue(typeList2, "typeTable.typeList");
            Iterable iterable = typeList2;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            int i11 = 0;
            for (Object next : iterable) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                ProtoBuf.Type type = (ProtoBuf.Type) next;
                if (i11 >= firstNullable) {
                    type = type.toBuilder().setNullable(true).build();
                }
                arrayList.add(type);
                i11 = i12;
            }
            typeList = arrayList;
        }
        Intrinsics.checkNotNullExpressionValue(typeList, "run {\n        val origin… else originalTypes\n    }");
        this.types = typeList;
    }

    @NotNull
    public final ProtoBuf.Type get(int i11) {
        return this.types.get(i11);
    }
}
