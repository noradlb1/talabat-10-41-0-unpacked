package com.talabat.darkstores.feature.model.mapper;

import com.talabat.darkstores.feature.model.PreSearchItem;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0002¨\u0006\b"}, d2 = {"Lcom/talabat/darkstores/feature/model/mapper/PreSearchSwimlaneToListItemsMapperImpl;", "Lcom/talabat/darkstores/feature/model/mapper/PreSearchSwimlaneToListItemsMapper;", "()V", "invoke", "", "Lcom/talabat/darkstores/feature/model/PreSearchItem;", "models", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PreSearchSwimlaneToListItemsMapperImpl implements PreSearchSwimlaneToListItemsMapper {
    @NotNull
    public List<PreSearchItem> invoke(@NotNull List<Product> list) {
        Intrinsics.checkNotNullParameter(list, "models");
        if (list.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return CollectionsKt__CollectionsJVMKt.listOf(new PreSearchItem.Swimlane(list));
    }
}
