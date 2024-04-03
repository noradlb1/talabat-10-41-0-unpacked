package com.talabat.fluid;

import com.deliveryhero.fluid.Host;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/talabat/fluid/TalabatFluidHost;", "Lcom/deliveryhero/fluid/Host;", "context", "Landroid/content/Context;", "interactionListeners", "Lcom/deliveryhero/fluid/actions/listeners/InteractionListeners;", "tag", "", "logger", "Lcom/deliveryhero/fluid/telemetry/log/Logger;", "profiler", "Lcom/deliveryhero/fluid/telemetry/profile/Profiler;", "uiConfig", "Lcom/deliveryhero/fluid/UiConfig;", "widgetFactories", "Lcom/deliveryhero/fluid/widgets/CoreWidgetFactories;", "imageLoader", "Lcom/deliveryhero/fluid/widgets/image/ImageLoader;", "(Landroid/content/Context;Lcom/deliveryhero/fluid/actions/listeners/InteractionListeners;Ljava/lang/String;Lcom/deliveryhero/fluid/telemetry/log/Logger;Lcom/deliveryhero/fluid/telemetry/profile/Profiler;Lcom/deliveryhero/fluid/UiConfig;Lcom/deliveryhero/fluid/widgets/CoreWidgetFactories;Lcom/deliveryhero/fluid/widgets/image/ImageLoader;)V", "com_talabat_ThirdPartyLibs_Fluid_Fluid"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class TalabatFluidHost extends Host {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TalabatFluidHost(android.content.Context r15, com.deliveryhero.fluid.actions.listeners.InteractionListeners r16, java.lang.String r17, com.deliveryhero.fluid.telemetry.log.Logger r18, com.deliveryhero.fluid.telemetry.profile.Profiler r19, com.deliveryhero.fluid.UiConfig r20, com.deliveryhero.fluid.widgets.CoreWidgetFactories r21, com.deliveryhero.fluid.widgets.image.ImageLoader r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r14 = this;
            r0 = r23
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0009
            java.lang.String r1 = "TalabatFluidHost"
            goto L_0x000b
        L_0x0009:
            r1 = r17
        L_0x000b:
            r2 = r0 & 8
            if (r2 == 0) goto L_0x001e
            com.talabat.fluid.LoggerDecorator r9 = new com.talabat.fluid.LoggerDecorator
            com.deliveryhero.fluid.telemetry.log.LogLevel r4 = com.deliveryhero.fluid.telemetry.log.LogLevel.DEBUG
            r5 = 0
            r6 = 0
            r7 = 4
            r8 = 0
            r2 = r9
            r3 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r6 = r9
            goto L_0x0020
        L_0x001e:
            r6 = r18
        L_0x0020:
            r2 = r0 & 16
            if (r2 == 0) goto L_0x002b
            com.deliveryhero.fluid.telemetry.profile.NoOpsProfiler r2 = new com.deliveryhero.fluid.telemetry.profile.NoOpsProfiler
            r2.<init>()
            r7 = r2
            goto L_0x002d
        L_0x002b:
            r7 = r19
        L_0x002d:
            r2 = r0 & 32
            if (r2 == 0) goto L_0x003d
            com.deliveryhero.fluid.UiConfig r2 = new com.deliveryhero.fluid.UiConfig
            r10 = 0
            r11 = 0
            r12 = 6
            r13 = 0
            r8 = r2
            r9 = r15
            r8.<init>(r9, r10, r11, r12, r13)
            goto L_0x003f
        L_0x003d:
            r8 = r20
        L_0x003f:
            r2 = r0 & 64
            if (r2 == 0) goto L_0x004b
            com.deliveryhero.fluid.widgets.CoreWidgetFactories r2 = new com.deliveryhero.fluid.widgets.CoreWidgetFactories
            r3 = r15
            r2.<init>(r15)
            r9 = r2
            goto L_0x004e
        L_0x004b:
            r3 = r15
            r9 = r21
        L_0x004e:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0063
            com.talabat.fluid.image.TalabatImageLoader r0 = new com.talabat.fluid.image.TalabatImageLoader
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with((android.content.Context) r15)
            java.lang.String r4 = "with(context)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            r0.<init>(r2)
            r10 = r0
            goto L_0x0065
        L_0x0063:
            r10 = r22
        L_0x0065:
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.TalabatFluidHost.<init>(android.content.Context, com.deliveryhero.fluid.actions.listeners.InteractionListeners, java.lang.String, com.deliveryhero.fluid.telemetry.log.Logger, com.deliveryhero.fluid.telemetry.profile.Profiler, com.deliveryhero.fluid.UiConfig, com.deliveryhero.fluid.widgets.CoreWidgetFactories, com.deliveryhero.fluid.widgets.image.ImageLoader, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TalabatFluidHost(@org.jetbrains.annotations.NotNull android.content.Context r10, @org.jetbrains.annotations.NotNull com.deliveryhero.fluid.actions.listeners.InteractionListeners r11, @org.jetbrains.annotations.NotNull java.lang.String r12, @org.jetbrains.annotations.NotNull com.deliveryhero.fluid.telemetry.log.Logger r13, @org.jetbrains.annotations.NotNull com.deliveryhero.fluid.telemetry.profile.Profiler r14, @org.jetbrains.annotations.NotNull com.deliveryhero.fluid.UiConfig r15, @org.jetbrains.annotations.NotNull com.deliveryhero.fluid.widgets.CoreWidgetFactories r16, @org.jetbrains.annotations.NotNull com.deliveryhero.fluid.widgets.image.ImageLoader r17) {
        /*
            r9 = this;
            java.lang.String r0 = "context"
            r2 = r10
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "interactionListeners"
            r5 = r11
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "tag"
            r1 = r12
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "logger"
            r3 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "profiler"
            r4 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "uiConfig"
            r8 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "widgetFactories"
            r7 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "imageLoader"
            r6 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.TalabatFluidHost.<init>(android.content.Context, com.deliveryhero.fluid.actions.listeners.InteractionListeners, java.lang.String, com.deliveryhero.fluid.telemetry.log.Logger, com.deliveryhero.fluid.telemetry.profile.Profiler, com.deliveryhero.fluid.UiConfig, com.deliveryhero.fluid.widgets.CoreWidgetFactories, com.deliveryhero.fluid.widgets.image.ImageLoader):void");
    }
}
