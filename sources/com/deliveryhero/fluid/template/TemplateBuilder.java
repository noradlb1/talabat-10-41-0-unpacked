package com.deliveryhero.fluid.template;

import com.deliveryhero.fluid.ParseConfig;
import com.deliveryhero.fluid.expression.ExpressionBuilder;
import com.deliveryhero.fluid.template.data.DataDecoder;
import com.deliveryhero.fluid.template.data.TemplateUiDataBuilder;
import com.deliveryhero.fluid.widgets.WidgetModelBuilder;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B/\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\r\u0010\u0017\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\r\u0010\u0018\u001a\u00060\u0003j\u0002`\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J9\u0010\u001b\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\f\b\u0002\u0010\u0005\u001a\u00060\u0003j\u0002`\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0003H\u0016R\u0015\u0010\u0005\u001a\u00060\u0003j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006#"}, d2 = {"Lcom/deliveryhero/fluid/template/TemplateBuilder;", "", "id", "", "Lcom/deliveryhero/fluid/template/TemplateId;", "hash", "Lcom/deliveryhero/fluid/template/sources/TemplateHash;", "widget", "Lcom/deliveryhero/fluid/widgets/WidgetModelBuilder;", "preview", "Lcom/deliveryhero/fluid/template/data/TemplateUiDataBuilder;", "(Ljava/lang/String;Ljava/lang/String;Lcom/deliveryhero/fluid/widgets/WidgetModelBuilder;Lcom/deliveryhero/fluid/template/data/TemplateUiDataBuilder;)V", "getHash", "()Ljava/lang/String;", "getId", "getPreview", "()Lcom/deliveryhero/fluid/template/data/TemplateUiDataBuilder;", "getWidget", "()Lcom/deliveryhero/fluid/widgets/WidgetModelBuilder;", "build", "Lcom/deliveryhero/fluid/template/Template;", "config", "Lcom/deliveryhero/fluid/ParseConfig;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable(with = TemplateBuilderSerializer.class)
public final class TemplateBuilder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final String hash;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f30210id;
    @NotNull
    private final TemplateUiDataBuilder preview;
    @NotNull
    private final WidgetModelBuilder widget;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/fluid/template/TemplateBuilder$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/fluid/template/TemplateBuilder;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final KSerializer<TemplateBuilder> serializer() {
            return new TemplateBuilderSerializer();
        }
    }

    public TemplateBuilder(@NotNull String str, @NotNull String str2, @NotNull WidgetModelBuilder widgetModelBuilder, @NotNull TemplateUiDataBuilder templateUiDataBuilder) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "hash");
        Intrinsics.checkNotNullParameter(widgetModelBuilder, "widget");
        Intrinsics.checkNotNullParameter(templateUiDataBuilder, "preview");
        this.f30210id = str;
        this.hash = str2;
        this.widget = widgetModelBuilder;
        this.preview = templateUiDataBuilder;
        widgetModelBuilder.setId$core_release(str);
        widgetModelBuilder.setHash$core_release(str2);
    }

    public static /* synthetic */ TemplateBuilder copy$default(TemplateBuilder templateBuilder, String str, String str2, WidgetModelBuilder widgetModelBuilder, TemplateUiDataBuilder templateUiDataBuilder, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = templateBuilder.f30210id;
        }
        if ((i11 & 2) != 0) {
            str2 = templateBuilder.hash;
        }
        if ((i11 & 4) != 0) {
            widgetModelBuilder = templateBuilder.widget;
        }
        if ((i11 & 8) != 0) {
            templateUiDataBuilder = templateBuilder.preview;
        }
        return templateBuilder.copy(str, str2, widgetModelBuilder, templateUiDataBuilder);
    }

    @NotNull
    public final Template build(@NotNull ParseConfig parseConfig) {
        Intrinsics.checkNotNullParameter(parseConfig, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        ExpressionBuilder.Args args = new ExpressionBuilder.Args(new DataDecoder(), parseConfig.getValueProviders(), parseConfig.getLogger());
        return new Template(this.f30210id, this.hash, this.widget.build(args), args.getDataDecoder(), parseConfig.getLogger());
    }

    @NotNull
    public final String component1() {
        return this.f30210id;
    }

    @NotNull
    public final String component2() {
        return this.hash;
    }

    @NotNull
    public final WidgetModelBuilder component3() {
        return this.widget;
    }

    @NotNull
    public final TemplateUiDataBuilder component4() {
        return this.preview;
    }

    @NotNull
    public final TemplateBuilder copy(@NotNull String str, @NotNull String str2, @NotNull WidgetModelBuilder widgetModelBuilder, @NotNull TemplateUiDataBuilder templateUiDataBuilder) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "hash");
        Intrinsics.checkNotNullParameter(widgetModelBuilder, "widget");
        Intrinsics.checkNotNullParameter(templateUiDataBuilder, "preview");
        return new TemplateBuilder(str, str2, widgetModelBuilder, templateUiDataBuilder);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof TemplateBuilder) {
            TemplateBuilder templateBuilder = (TemplateBuilder) obj;
            if (!Intrinsics.areEqual((Object) templateBuilder.f30210id, (Object) this.f30210id) || !Intrinsics.areEqual((Object) templateBuilder.hash, (Object) this.hash)) {
                return false;
            }
            return true;
        }
        return false;
    }

    @NotNull
    public final String getHash() {
        return this.hash;
    }

    @NotNull
    public final String getId() {
        return this.f30210id;
    }

    @NotNull
    public final TemplateUiDataBuilder getPreview() {
        return this.preview;
    }

    @NotNull
    public final WidgetModelBuilder getWidget() {
        return this.widget;
    }

    public int hashCode() {
        return (this.f30210id.hashCode() * 31) + this.hash.hashCode();
    }

    @NotNull
    public String toString() {
        return "{ \"id\": \"" + this.f30210id + "\", \"hash\": \"" + this.hash + "\" }";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TemplateBuilder(java.lang.String r8, java.lang.String r9, com.deliveryhero.fluid.widgets.WidgetModelBuilder r10, com.deliveryhero.fluid.template.data.TemplateUiDataBuilder r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r7 = this;
            r12 = r12 & 8
            if (r12 == 0) goto L_0x0014
            com.deliveryhero.fluid.template.data.TemplateUiDataBuilder r11 = new com.deliveryhero.fluid.template.data.TemplateUiDataBuilder
            java.util.Map r2 = kotlin.collections.MapsKt__MapsKt.emptyMap()
            r3 = 0
            r4 = 0
            r5 = 12
            r6 = 0
            r0 = r11
            r1 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
        L_0x0014:
            r7.<init>(r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.fluid.template.TemplateBuilder.<init>(java.lang.String, java.lang.String, com.deliveryhero.fluid.widgets.WidgetModelBuilder, com.deliveryhero.fluid.template.data.TemplateUiDataBuilder, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
