package com.talabat.feature.ridertips.data.convert;

import com.talabat.feature.ridertips.data.remote.dto.RiderTipDto;
import com.talabat.feature.ridertips.domain.model.RiderTip;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/ridertips/data/convert/IRiderTipResponseToRiderTipMapper;", "", "map", "Lcom/talabat/feature/ridertips/domain/model/RiderTip;", "source", "Lcom/talabat/feature/ridertips/data/remote/dto/RiderTipDto;", "com_talabat_feature_ridertips_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IRiderTipResponseToRiderTipMapper {
    @NotNull
    RiderTip map(@NotNull RiderTipDto riderTipDto);
}
