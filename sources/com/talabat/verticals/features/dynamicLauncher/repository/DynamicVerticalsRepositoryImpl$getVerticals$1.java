package com.talabat.verticals.features.dynamicLauncher.repository;

import com.talabat.verticals.features.dynamicLauncher.model.response.VerticalsResponse;
import com.talabat.verticals.ui.customViewLCAware.model.VerticalsDisplayModel;
import com.talabat.verticals.ui.customViewLCAware.model.VerticalsResponseMapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/verticals/ui/customViewLCAware/model/VerticalsDisplayModel;", "it", "Lcom/talabat/verticals/features/dynamicLauncher/model/response/VerticalsResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DynamicVerticalsRepositoryImpl$getVerticals$1 extends Lambda implements Function1<VerticalsResponse, VerticalsDisplayModel> {
    public static final DynamicVerticalsRepositoryImpl$getVerticals$1 INSTANCE = new DynamicVerticalsRepositoryImpl$getVerticals$1();

    public DynamicVerticalsRepositoryImpl$getVerticals$1() {
        super(1);
    }

    @NotNull
    public final VerticalsDisplayModel invoke(@NotNull VerticalsResponse verticalsResponse) {
        Intrinsics.checkNotNullParameter(verticalsResponse, "it");
        return VerticalsResponseMapper.Companion.map(verticalsResponse.getResult());
    }
}
