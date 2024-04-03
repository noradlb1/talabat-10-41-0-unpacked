package com.talabat.fluid.homescreen.ui.fragment;

import android.content.Context;
import com.deliveryhero.fluid.UiConfig;
import com.deliveryhero.fluid.actions.listeners.InteractionListeners;
import com.deliveryhero.fluid.actions.listeners.OnClickListener;
import com.deliveryhero.fluid.telemetry.log.LogLevel;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.telemetry.profile.SimpleClockProfiler;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.widgets.collections.OnCollectionScrollListener;
import com.deliveryhero.fluid.widgets.image.ImageLoader;
import com.talabat.core.observabilityNew.domain.squads.home.HomeScreenPerformanceParams;
import com.talabat.fluid.TalabatFluidHost;
import com.talabat.fluid.homescreen.data.impl.FluidPerformanceLogger;
import com.talabat.fluid.homescreen.ui.widget.HomeScreenWidgetFactories;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import yp.m;
import yp.n;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/fluid/TalabatFluidHost;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FluidHomeScreenFragment$talabatFluidHost$2 extends Lambda implements Function0<TalabatFluidHost> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenFragment f59749g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FluidHomeScreenFragment$talabatFluidHost$2(FluidHomeScreenFragment fluidHomeScreenFragment) {
        super(0);
        this.f59749g = fluidHomeScreenFragment;
    }

    @NotNull
    public final TalabatFluidHost invoke() {
        Context requireContext = this.f59749g.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new TalabatFluidHost(requireContext, new InteractionListeners(this.f59749g) {
            @NotNull
            private final OnClickListener click;
            @NotNull
            private final OnCollectionScrollListener collectionScroll;

            {
                this.click = new m(r2);
                this.collectionScroll = new n(r2);
            }

            /* access modifiers changed from: private */
            /* renamed from: click$lambda-0  reason: not valid java name */
            public static final void m10461click$lambda0(FluidHomeScreenFragment fluidHomeScreenFragment, String str, TemplateUiData templateUiData) {
                Intrinsics.checkNotNullParameter(fluidHomeScreenFragment, "this$0");
                Intrinsics.checkNotNullParameter(str, "url");
                if (templateUiData != null) {
                    fluidHomeScreenFragment.getViewModel().onClick(str, templateUiData);
                }
            }

            /* access modifiers changed from: private */
            /* renamed from: collectionScroll$lambda-1  reason: not valid java name */
            public static final void m10462collectionScroll$lambda1(FluidHomeScreenFragment fluidHomeScreenFragment, int i11, List list, TemplateUiData templateUiData) {
                Intrinsics.checkNotNullParameter(fluidHomeScreenFragment, "this$0");
                Intrinsics.checkNotNullParameter(list, "<anonymous parameter 1>");
                Intrinsics.checkNotNullParameter(templateUiData, "collectionData");
                fluidHomeScreenFragment.getViewModel().onComponentSwiped(i11, templateUiData);
            }

            @NotNull
            public OnClickListener getClick() {
                return this.click;
            }

            @NotNull
            public OnCollectionScrollListener getCollectionScroll() {
                return this.collectionScroll;
            }
        }, (String) null, (Logger) null, new SimpleClockProfiler(new FluidPerformanceLogger(HomeScreenPerformanceParams.SCREEN_NAME, LogLevel.INFO, this.f59749g.getHomeScreenPerformanceObservability())), (UiConfig) null, new HomeScreenWidgetFactories(requireContext, this.f59749g.getGson()), (ImageLoader) null, 172, (DefaultConstructorMarker) null);
    }
}
