package com.talabat.fluid.homescreen.data.local.impl;

import com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse;
import com.talabat.homescreen.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FluidHomeComponentLocalDataSourceImpl$arabicComponents$2 extends Lambda implements Function0<ContentApiResponse> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FluidHomeComponentLocalDataSourceImpl f59694g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FluidHomeComponentLocalDataSourceImpl$arabicComponents$2(FluidHomeComponentLocalDataSourceImpl fluidHomeComponentLocalDataSourceImpl) {
        super(0);
        this.f59694g = fluidHomeComponentLocalDataSourceImpl;
    }

    @NotNull
    public final ContentApiResponse invoke() {
        return this.f59694g.readRawResourceAsJson(R.raw.fluid_component_fallback_arabic);
    }
}
