package com.talabat.fluid.homescreen.ui.fragment;

import android.content.Context;
import com.deliveryhero.fluid.expression.reference.providers.ValueProviders;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.telemetry.profile.Profiler;
import com.talabat.fluid.TalabatParserConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.SerialFormat;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/fluid/TalabatParserConfig;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FluidHomeScreenFragment$parseConfig$2 extends Lambda implements Function0<TalabatParserConfig> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenFragment f59748g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FluidHomeScreenFragment$parseConfig$2(FluidHomeScreenFragment fluidHomeScreenFragment) {
        super(0);
        this.f59748g = fluidHomeScreenFragment;
    }

    @NotNull
    public final TalabatParserConfig invoke() {
        Context requireContext = this.f59748g.requireContext();
        Logger logger = this.f59748g.getTalabatFluidHost().getLogger();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new TalabatParserConfig(requireContext, logger, (Profiler) null, (ValueProviders) null, AnonymousClass1.INSTANCE, (SerialFormat) null, 44, (DefaultConstructorMarker) null);
    }
}
