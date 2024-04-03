package com.talabat.feature.darkstores.vendorslanding.data.mapper;

import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMetadata;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMission;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMissionItem;
import com.talabat.feature.darkstores.vendorlanding.domain.model.PageInfo;
import com.talabat.feature.darkstores.vendorslanding.data.model.LifestyleMissionItemResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.LifestyleMissionResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.MetadataResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.PageInfoResponse;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001BI\b\u0007\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0001¢\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/mapper/LifestyleMissionMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/LifestyleMissionResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMission;", "lifestyleMissionItemMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/LifestyleMissionItemResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMissionItem;", "metadataMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/MetadataResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMetadata;", "pageInfoMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/PageInfoResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/PageInfo;", "(Lcom/talabat/mapper/ModelMapper;Lcom/talabat/mapper/ModelMapper;Lcom/talabat/mapper/ModelMapper;)V", "apply", "source", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifestyleMissionMapper implements ModelMapper<LifestyleMissionResponse, LifestyleMission> {
    @NotNull
    private final ModelMapper<LifestyleMissionItemResponse, LifestyleMissionItem> lifestyleMissionItemMapper;
    @NotNull
    private final ModelMapper<MetadataResponse, LifestyleMetadata> metadataMapper;
    @NotNull
    private final ModelMapper<PageInfoResponse, PageInfo> pageInfoMapper;

    @Inject
    public LifestyleMissionMapper(@NotNull ModelMapper<LifestyleMissionItemResponse, LifestyleMissionItem> modelMapper, @NotNull ModelMapper<MetadataResponse, LifestyleMetadata> modelMapper2, @NotNull ModelMapper<PageInfoResponse, PageInfo> modelMapper3) {
        Intrinsics.checkNotNullParameter(modelMapper, "lifestyleMissionItemMapper");
        Intrinsics.checkNotNullParameter(modelMapper2, "metadataMapper");
        Intrinsics.checkNotNullParameter(modelMapper3, "pageInfoMapper");
        this.lifestyleMissionItemMapper = modelMapper;
        this.metadataMapper = modelMapper2;
        this.pageInfoMapper = modelMapper3;
    }

    @Nullable
    public LifestyleMission apply(@NotNull LifestyleMissionResponse lifestyleMissionResponse) {
        Intrinsics.checkNotNullParameter(lifestyleMissionResponse, "source");
        if (lifestyleMissionResponse.getItems() == null || lifestyleMissionResponse.getPageInfo() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (LifestyleMissionItemResponse apply : lifestyleMissionResponse.getItems()) {
            LifestyleMissionItem apply2 = this.lifestyleMissionItemMapper.apply(apply);
            if (apply2 != null) {
                arrayList.add(apply2);
            }
        }
        MetadataResponse metadata = lifestyleMissionResponse.getMetadata();
        LifestyleMetadata apply3 = metadata != null ? this.metadataMapper.apply(metadata) : null;
        PageInfo apply4 = this.pageInfoMapper.apply(lifestyleMissionResponse.getPageInfo());
        if (apply4 != null) {
            return new LifestyleMission(arrayList, apply3, apply4);
        }
        return null;
    }
}
