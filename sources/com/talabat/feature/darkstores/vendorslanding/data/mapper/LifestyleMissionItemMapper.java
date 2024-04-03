package com.talabat.feature.darkstores.vendorslanding.data.mapper;

import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMissionItem;
import com.talabat.feature.darkstores.vendorslanding.data.model.LifestyleMissionItemResponse;
import com.talabat.mapper.ModelMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/mapper/LifestyleMissionItemMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/LifestyleMissionItemResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMissionItem;", "()V", "apply", "source", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifestyleMissionItemMapper implements ModelMapper<LifestyleMissionItemResponse, LifestyleMissionItem> {
    @Nullable
    public LifestyleMissionItem apply(@NotNull LifestyleMissionItemResponse lifestyleMissionItemResponse) {
        Intrinsics.checkNotNullParameter(lifestyleMissionItemResponse, "source");
        String bgColor = lifestyleMissionItemResponse.getBgColor();
        boolean z11 = false;
        if (!(bgColor == null || StringsKt__StringsJVMKt.isBlank(bgColor))) {
            String id2 = lifestyleMissionItemResponse.getId();
            if (!(id2 == null || StringsKt__StringsJVMKt.isBlank(id2))) {
                String imageUrl = lifestyleMissionItemResponse.getImageUrl();
                if (!(imageUrl == null || StringsKt__StringsJVMKt.isBlank(imageUrl))) {
                    String name2 = lifestyleMissionItemResponse.getName();
                    if (name2 == null || StringsKt__StringsJVMKt.isBlank(name2)) {
                        z11 = true;
                    }
                    if (!z11) {
                        String bgColor2 = lifestyleMissionItemResponse.getBgColor();
                        String id3 = lifestyleMissionItemResponse.getId();
                        String imageUrl2 = lifestyleMissionItemResponse.getImageUrl();
                        String name3 = lifestyleMissionItemResponse.getName();
                        String text = lifestyleMissionItemResponse.getText();
                        if (text == null) {
                            text = "";
                        }
                        return new LifestyleMissionItem(bgColor2, id3, imageUrl2, name3, text);
                    }
                }
            }
        }
        return null;
    }
}
