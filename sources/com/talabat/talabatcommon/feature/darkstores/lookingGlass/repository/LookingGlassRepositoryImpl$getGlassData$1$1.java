package com.talabat.talabatcommon.feature.darkstores.lookingGlass.repository;

import com.talabat.configuration.location.Country;
import com.talabat.configuration.location.LocationExtensionsKt;
import com.talabat.talabatcommon.feature.darkstores.lookingGlass.model.response.LookingGlassResponse;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.model.LookingGlassDisplayModel;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.model.LookingGlassResponseMapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/LookingGlassDisplayModel;", "it", "Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/LookingGlassResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LookingGlassRepositoryImpl$getGlassData$1$1 extends Lambda implements Function1<LookingGlassResponse, LookingGlassDisplayModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Country f61553g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LookingGlassRepositoryImpl$getGlassData$1$1(Country country) {
        super(1);
        this.f61553g = country;
    }

    @NotNull
    public final LookingGlassDisplayModel invoke(@NotNull LookingGlassResponse lookingGlassResponse) {
        Intrinsics.checkNotNullParameter(lookingGlassResponse, "it");
        return new LookingGlassResponseMapper(this.f61553g.getCurrencyCode(), this.f61553g.getNumberOfDecimalPlaces(), LocationExtensionsKt.decimalPattern(this.f61553g)).map(lookingGlassResponse);
    }
}
