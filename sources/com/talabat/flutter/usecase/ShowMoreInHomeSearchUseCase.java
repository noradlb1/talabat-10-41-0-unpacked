package com.talabat.flutter.usecase;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.fluid.homescreen.presentation.mapper.VerticalItemViewEntityMapperKt;
import com.talabat.fluttercore.domain.entities.FlutterVertical;
import com.talabat.homescreen.adapter.model.vetrical.VerticalItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/talabat/flutter/usecase/ShowMoreInHomeSearchUseCase;", "", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setTalabatFeatureFlag", "invoke", "Lcom/talabat/fluttercore/domain/entities/FlutterVertical;", "verticalItem", "Lcom/talabat/homescreen/adapter/model/vetrical/VerticalItem;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShowMoreInHomeSearchUseCase {
    @NotNull
    private ITalabatFeatureFlag talabatFeatureFlag;

    public ShowMoreInHomeSearchUseCase(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    @NotNull
    public final ITalabatFeatureFlag getTalabatFeatureFlag() {
        return this.talabatFeatureFlag;
    }

    @Nullable
    public final FlutterVertical invoke(@NotNull VerticalItem verticalItem) {
        Intrinsics.checkNotNullParameter(verticalItem, VerticalItemViewEntityMapperKt.VERTICAL_ITEM_KEY);
        if (ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.talabatFeatureFlag, TalabatFeatureFlagConstants.SHOULD_SEND_MORE_IN_SEARCH, false, 2, (Object) null)) {
            return new FlutterVertical(String.valueOf(verticalItem.getId()), verticalItem.getTitle(), verticalItem.getVerticalIds());
        }
        return null;
    }

    public final void setTalabatFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }
}
