package com.talabat.darkstores.data.discovery.mappers;

import com.talabat.darkstores.data.discovery.model.NetworkSortOption;
import com.talabat.darkstores.data.discovery.model.SortOption;
import com.talabat.mapper.ModelMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/data/discovery/mappers/SortOptionMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/darkstores/data/discovery/model/NetworkSortOption;", "Lcom/talabat/darkstores/data/discovery/model/SortOption;", "()V", "apply", "source", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SortOptionMapper implements ModelMapper<NetworkSortOption, SortOption> {
    @Nullable
    public SortOption apply(@NotNull NetworkSortOption networkSortOption) {
        Intrinsics.checkNotNullParameter(networkSortOption, "source");
        String displayName = networkSortOption.getDisplayName();
        String key = networkSortOption.getKey();
        boolean z11 = true;
        boolean z12 = false;
        if (!(displayName == null || displayName.length() == 0)) {
            if (!(key == null || key.length() == 0)) {
                z11 = false;
            }
            if (!z11) {
                Boolean isApplied = networkSortOption.isApplied();
                if (isApplied != null) {
                    z12 = isApplied.booleanValue();
                }
                return new SortOption(displayName, z12, networkSortOption.getKey());
            }
        }
        return null;
    }
}
