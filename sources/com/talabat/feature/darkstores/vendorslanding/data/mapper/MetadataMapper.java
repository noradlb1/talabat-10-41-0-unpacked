package com.talabat.feature.darkstores.vendorslanding.data.mapper;

import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMetadata;
import com.talabat.feature.darkstores.vendorlanding.domain.model.MetadataError;
import com.talabat.feature.darkstores.vendorslanding.data.model.MetadataErrorResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.MetadataResponse;
import com.talabat.mapper.ModelMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u001d\b\u0007\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/mapper/MetadataMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/MetadataResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMetadata;", "metadataErrorMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/MetadataErrorResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/MetadataError;", "(Lcom/talabat/mapper/ModelMapper;)V", "apply", "source", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MetadataMapper implements ModelMapper<MetadataResponse, LifestyleMetadata> {
    @NotNull
    private final ModelMapper<MetadataErrorResponse, MetadataError> metadataErrorMapper;

    @Inject
    public MetadataMapper(@NotNull ModelMapper<MetadataErrorResponse, MetadataError> modelMapper) {
        Intrinsics.checkNotNullParameter(modelMapper, "metadataErrorMapper");
        this.metadataErrorMapper = modelMapper;
    }

    @Nullable
    public LifestyleMetadata apply(@NotNull MetadataResponse metadataResponse) {
        MetadataError apply;
        Intrinsics.checkNotNullParameter(metadataResponse, "source");
        if (metadataResponse.getError() == null || metadataResponse.isError() == null || (apply = this.metadataErrorMapper.apply(metadataResponse.getError())) == null) {
            return null;
        }
        return new LifestyleMetadata(apply, metadataResponse.isError().booleanValue());
    }
}
