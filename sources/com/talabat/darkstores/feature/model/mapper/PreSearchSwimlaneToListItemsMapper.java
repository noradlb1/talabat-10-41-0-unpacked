package com.talabat.darkstores.feature.model.mapper;

import com.talabat.darkstores.feature.model.PreSearchItem;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H¦\u0002¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/feature/model/mapper/PreSearchSwimlaneToListItemsMapper;", "", "invoke", "", "Lcom/talabat/darkstores/feature/model/PreSearchItem;", "models", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PreSearchSwimlaneToListItemsMapper {
    @NotNull
    List<PreSearchItem> invoke(@NotNull List<Product> list);
}
