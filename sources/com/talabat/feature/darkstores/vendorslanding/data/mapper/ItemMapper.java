package com.talabat.feature.darkstores.vendorslanding.data.mapper;

import com.talabat.feature.darkstores.vendorlanding.domain.model.Item;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LayoutType;
import com.talabat.feature.darkstores.vendorlanding.domain.model.SwimlaneProduct;
import com.talabat.feature.darkstores.vendorlanding.domain.model.Tracking;
import com.talabat.feature.darkstores.vendorslanding.data.model.ItemResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.SwimlaneProductResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.TrackingResponse;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u001d\b\u0007\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/mapper/ItemMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/ItemResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Item;", "swimlaneProductMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/SwimlaneProductResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/SwimlaneProduct;", "(Lcom/talabat/mapper/ModelMapper;)V", "apply", "source", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ItemMapper implements ModelMapper<ItemResponse, Item> {
    @NotNull
    private final ModelMapper<SwimlaneProductResponse, SwimlaneProduct> swimlaneProductMapper;

    @Inject
    public ItemMapper(@NotNull ModelMapper<SwimlaneProductResponse, SwimlaneProduct> modelMapper) {
        Intrinsics.checkNotNullParameter(modelMapper, "swimlaneProductMapper");
        this.swimlaneProductMapper = modelMapper;
    }

    @Nullable
    public Item apply(@NotNull ItemResponse itemResponse) {
        LayoutType layoutType;
        String trackingId;
        Intrinsics.checkNotNullParameter(itemResponse, "source");
        String id2 = itemResponse.getId();
        boolean z11 = false;
        Tracking tracking2 = null;
        if (id2 == null || StringsKt__StringsJVMKt.isBlank(id2)) {
            return null;
        }
        Collection products = itemResponse.getProducts();
        if (products == null || products.isEmpty()) {
            return null;
        }
        String name2 = itemResponse.getName();
        if (name2 == null || StringsKt__StringsJVMKt.isBlank(name2)) {
            z11 = true;
        }
        if (z11) {
            return null;
        }
        String id3 = itemResponse.getId();
        String name3 = itemResponse.getName();
        ArrayList arrayList = new ArrayList();
        for (SwimlaneProductResponse apply : itemResponse.getProducts()) {
            SwimlaneProduct apply2 = this.swimlaneProductMapper.apply(apply);
            if (apply2 != null) {
                arrayList.add(apply2);
            }
        }
        TrackingResponse tracking3 = itemResponse.getTracking();
        if (!(tracking3 == null || (trackingId = tracking3.getTrackingId()) == null)) {
            tracking2 = new Tracking(trackingId);
        }
        Tracking tracking4 = tracking2;
        String layoutType2 = itemResponse.getLayoutType();
        if (layoutType2 == null) {
            layoutType = LayoutType.FULL;
        } else if (Intrinsics.areEqual((Object) layoutType2, (Object) "small_no_info")) {
            layoutType = LayoutType.COMPACT;
        } else {
            layoutType = LayoutType.COMPACT_WITH_TEXT;
        }
        return new Item(id3, name3, arrayList, tracking4, layoutType);
    }
}
