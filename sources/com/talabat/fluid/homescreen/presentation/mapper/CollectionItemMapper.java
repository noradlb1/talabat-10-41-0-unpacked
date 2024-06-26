package com.talabat.fluid.homescreen.presentation.mapper;

import com.talabat.fluid.homescreen.presentation.displaymodel.CollectionItem;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b¨\u0006\t"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/mapper/CollectionItemMapper;", "", "()V", "toCollectionItem", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/CollectionItem;", "url", "", "metadata", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionItemMapper {
    @NotNull
    public final CollectionItem toCollectionItem(@NotNull String str, @NotNull Map<String, String> map) {
        int i11;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(map, TtmlNode.TAG_METADATA);
        String str2 = map.get("verticalId");
        if (str2 == null || (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str2)) == null) {
            i11 = 0;
        } else {
            i11 = intOrNull.intValue();
        }
        return new CollectionItem(str, i11);
    }
}
