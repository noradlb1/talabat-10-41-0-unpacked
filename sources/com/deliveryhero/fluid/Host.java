package com.deliveryhero.fluid;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.fluid.actions.listeners.InteractionListeners;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.telemetry.profile.Profiler;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolders;
import com.deliveryhero.fluid.widgets.CoreWidgetFactories;
import com.deliveryhero.fluid.widgets.WidgetFactories;
import com.deliveryhero.fluid.widgets.collections.CollectionState;
import com.deliveryhero.fluid.widgets.image.ImageLoader;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 *2\u00020\u0001:\u0001*B=\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eBC\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/deliveryhero/fluid/Host;", "", "parseConfig", "Lcom/deliveryhero/fluid/ParseConfig;", "interactionListeners", "Lcom/deliveryhero/fluid/actions/listeners/InteractionListeners;", "imageLoader", "Lcom/deliveryhero/fluid/widgets/image/ImageLoader;", "context", "Landroid/content/Context;", "widgetFactories", "Lcom/deliveryhero/fluid/widgets/WidgetFactories;", "uiConfig", "Lcom/deliveryhero/fluid/UiConfig;", "(Lcom/deliveryhero/fluid/ParseConfig;Lcom/deliveryhero/fluid/actions/listeners/InteractionListeners;Lcom/deliveryhero/fluid/widgets/image/ImageLoader;Landroid/content/Context;Lcom/deliveryhero/fluid/widgets/WidgetFactories;Lcom/deliveryhero/fluid/UiConfig;)V", "logger", "Lcom/deliveryhero/fluid/telemetry/log/Logger;", "profiler", "Lcom/deliveryhero/fluid/telemetry/profile/Profiler;", "(Landroid/content/Context;Lcom/deliveryhero/fluid/telemetry/log/Logger;Lcom/deliveryhero/fluid/telemetry/profile/Profiler;Lcom/deliveryhero/fluid/actions/listeners/InteractionListeners;Lcom/deliveryhero/fluid/widgets/image/ImageLoader;Lcom/deliveryhero/fluid/widgets/WidgetFactories;Lcom/deliveryhero/fluid/UiConfig;)V", "collectionState", "Lcom/deliveryhero/fluid/widgets/collections/CollectionState;", "getCollectionState", "()Lcom/deliveryhero/fluid/widgets/collections/CollectionState;", "getContext", "()Landroid/content/Context;", "getImageLoader", "()Lcom/deliveryhero/fluid/widgets/image/ImageLoader;", "getInteractionListeners", "()Lcom/deliveryhero/fluid/actions/listeners/InteractionListeners;", "getLogger", "()Lcom/deliveryhero/fluid/telemetry/log/Logger;", "getProfiler", "()Lcom/deliveryhero/fluid/telemetry/profile/Profiler;", "templateDataHolders", "Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolders;", "getTemplateDataHolders", "()Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolders;", "getUiConfig", "()Lcom/deliveryhero/fluid/UiConfig;", "getWidgetFactories", "()Lcom/deliveryhero/fluid/widgets/WidgetFactories;", "Companion", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class Host {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final CollectionState collectionState;
    @NotNull
    private final Context context;
    @NotNull
    private final ImageLoader imageLoader;
    @NotNull
    private final InteractionListeners interactionListeners;
    @NotNull
    private final Logger logger;
    @NotNull
    private final Profiler profiler;
    @NotNull
    private final TemplateUiDataHolders templateDataHolders;
    @NotNull
    private final UiConfig uiConfig;
    @NotNull
    private final WidgetFactories widgetFactories;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/fluid/Host$Companion;", "", "()V", "createDefaultWidgetFactories", "Lcom/deliveryhero/fluid/widgets/CoreWidgetFactories;", "context", "Landroid/content/Context;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final CoreWidgetFactories createDefaultWidgetFactories(Context context) {
            return new CoreWidgetFactories(context);
        }
    }

    public Host(@NotNull Context context2, @NotNull Logger logger2, @NotNull Profiler profiler2, @NotNull InteractionListeners interactionListeners2, @NotNull ImageLoader imageLoader2, @NotNull WidgetFactories widgetFactories2, @NotNull UiConfig uiConfig2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(profiler2, "profiler");
        Intrinsics.checkNotNullParameter(interactionListeners2, "interactionListeners");
        Intrinsics.checkNotNullParameter(imageLoader2, "imageLoader");
        Intrinsics.checkNotNullParameter(widgetFactories2, "widgetFactories");
        Intrinsics.checkNotNullParameter(uiConfig2, "uiConfig");
        this.context = context2;
        this.logger = logger2;
        this.profiler = profiler2;
        this.interactionListeners = interactionListeners2;
        this.imageLoader = imageLoader2;
        this.widgetFactories = widgetFactories2;
        this.uiConfig = uiConfig2;
        this.templateDataHolders = new TemplateUiDataHolders();
        this.collectionState = new CollectionState((RecyclerView.RecycledViewPool) null, (Map) null, 3, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final CollectionState getCollectionState() {
        return this.collectionState;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final ImageLoader getImageLoader() {
        return this.imageLoader;
    }

    @NotNull
    public final InteractionListeners getInteractionListeners() {
        return this.interactionListeners;
    }

    @NotNull
    public final Logger getLogger() {
        return this.logger;
    }

    @NotNull
    public final Profiler getProfiler() {
        return this.profiler;
    }

    @NotNull
    public final TemplateUiDataHolders getTemplateDataHolders() {
        return this.templateDataHolders;
    }

    @NotNull
    public final UiConfig getUiConfig() {
        return this.uiConfig;
    }

    @NotNull
    public final WidgetFactories getWidgetFactories() {
        return this.widgetFactories;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Host(android.content.Context r9, com.deliveryhero.fluid.telemetry.log.Logger r10, com.deliveryhero.fluid.telemetry.profile.Profiler r11, com.deliveryhero.fluid.actions.listeners.InteractionListeners r12, com.deliveryhero.fluid.widgets.image.ImageLoader r13, com.deliveryhero.fluid.widgets.WidgetFactories r14, com.deliveryhero.fluid.UiConfig r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r8 = this;
            r1 = r9
            r0 = r16 & 4
            if (r0 == 0) goto L_0x000e
            com.deliveryhero.fluid.telemetry.profile.Profiler$Companion r0 = com.deliveryhero.fluid.telemetry.profile.Profiler.Companion
            r2 = r10
            com.deliveryhero.fluid.telemetry.profile.SimpleClockProfiler r0 = r0.createDefault(r10)
            r3 = r0
            goto L_0x0010
        L_0x000e:
            r2 = r10
            r3 = r11
        L_0x0010:
            r0 = r16 & 32
            if (r0 == 0) goto L_0x001c
            com.deliveryhero.fluid.Host$Companion r0 = Companion
            com.deliveryhero.fluid.widgets.CoreWidgetFactories r0 = r0.createDefaultWidgetFactories(r9)
            r6 = r0
            goto L_0x001d
        L_0x001c:
            r6 = r14
        L_0x001d:
            r0 = r16 & 64
            if (r0 == 0) goto L_0x0029
            com.deliveryhero.fluid.UiConfig$Companion r0 = com.deliveryhero.fluid.UiConfig.Companion
            com.deliveryhero.fluid.UiConfig r0 = r0.createDefault(r9)
            r7 = r0
            goto L_0x002a
        L_0x0029:
            r7 = r15
        L_0x002a:
            r0 = r8
            r1 = r9
            r2 = r10
            r4 = r12
            r5 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.fluid.Host.<init>(android.content.Context, com.deliveryhero.fluid.telemetry.log.Logger, com.deliveryhero.fluid.telemetry.profile.Profiler, com.deliveryhero.fluid.actions.listeners.InteractionListeners, com.deliveryhero.fluid.widgets.image.ImageLoader, com.deliveryhero.fluid.widgets.WidgetFactories, com.deliveryhero.fluid.UiConfig, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Host(com.deliveryhero.fluid.ParseConfig r8, com.deliveryhero.fluid.actions.listeners.InteractionListeners r9, com.deliveryhero.fluid.widgets.image.ImageLoader r10, android.content.Context r11, com.deliveryhero.fluid.widgets.WidgetFactories r12, com.deliveryhero.fluid.UiConfig r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r15 = r14 & 8
            if (r15 == 0) goto L_0x0008
            android.content.Context r11 = r8.getContext()
        L_0x0008:
            r4 = r11
            r11 = r14 & 16
            if (r11 == 0) goto L_0x0013
            com.deliveryhero.fluid.Host$Companion r11 = Companion
            com.deliveryhero.fluid.widgets.CoreWidgetFactories r12 = r11.createDefaultWidgetFactories(r4)
        L_0x0013:
            r5 = r12
            r11 = r14 & 32
            if (r11 == 0) goto L_0x001e
            com.deliveryhero.fluid.UiConfig$Companion r11 = com.deliveryhero.fluid.UiConfig.Companion
            com.deliveryhero.fluid.UiConfig r13 = r11.createDefault(r4)
        L_0x001e:
            r6 = r13
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.fluid.Host.<init>(com.deliveryhero.fluid.ParseConfig, com.deliveryhero.fluid.actions.listeners.InteractionListeners, com.deliveryhero.fluid.widgets.image.ImageLoader, android.content.Context, com.deliveryhero.fluid.widgets.WidgetFactories, com.deliveryhero.fluid.UiConfig, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Host(@NotNull ParseConfig parseConfig, @NotNull InteractionListeners interactionListeners2, @NotNull ImageLoader imageLoader2, @NotNull Context context2, @NotNull WidgetFactories widgetFactories2, @NotNull UiConfig uiConfig2) {
        this(context2, parseConfig.getLogger(), parseConfig.getProfiler(), interactionListeners2, imageLoader2, widgetFactories2, uiConfig2);
        Intrinsics.checkNotNullParameter(parseConfig, "parseConfig");
        Intrinsics.checkNotNullParameter(interactionListeners2, "interactionListeners");
        Intrinsics.checkNotNullParameter(imageLoader2, "imageLoader");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(widgetFactories2, "widgetFactories");
        Intrinsics.checkNotNullParameter(uiConfig2, "uiConfig");
    }
}
