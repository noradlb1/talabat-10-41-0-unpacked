package com.deliveryhero.fluid.template;

import android.view.View;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.telemetry.log.LogLevel;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.telemetry.profile.ProfilerTags;
import com.deliveryhero.fluid.template.data.DataDecoder;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataBuilder;
import com.deliveryhero.fluid.widgets.WidgetModel;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import com.talabat.fluid.homescreen.data.parser.ComponentMapper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\"\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\r\u0010 \u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\r\u0010!\u001a\u00060\u0003j\u0002`\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003JC\u0010%\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\f\b\u0002\u0010\u0005\u001a\u00060\u0003j\u0002`\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001JP\u0010&\u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010(2\u0018\b\u0002\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010(j\u0002`+J\u0012\u0010,\u001a\u00060\u001cj\u0002`\u001d2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u00100\u001a\u000201H\u0016J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0005\u001a\u00060\u0003j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u00063"}, d2 = {"Lcom/deliveryhero/fluid/template/Template;", "", "id", "", "Lcom/deliveryhero/fluid/template/TemplateId;", "hash", "Lcom/deliveryhero/fluid/template/sources/TemplateHash;", "widget", "Lcom/deliveryhero/fluid/widgets/WidgetModel;", "dataDecoder", "Lcom/deliveryhero/fluid/template/data/DataDecoder;", "logger", "Lcom/deliveryhero/fluid/telemetry/log/Logger;", "(Ljava/lang/String;Ljava/lang/String;Lcom/deliveryhero/fluid/widgets/WidgetModel;Lcom/deliveryhero/fluid/template/data/DataDecoder;Lcom/deliveryhero/fluid/telemetry/log/Logger;)V", "getDataDecoder", "()Lcom/deliveryhero/fluid/template/data/DataDecoder;", "getHash", "()Ljava/lang/String;", "getId", "getLogger", "()Lcom/deliveryhero/fluid/telemetry/log/Logger;", "getWidget", "()Lcom/deliveryhero/fluid/widgets/WidgetModel;", "bindData", "", "host", "Lcom/deliveryhero/fluid/Host;", "ui", "Landroid/view/View;", "Lcom/deliveryhero/fluid/widgets/Widget;", "data", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "component1", "component2", "component3", "component4", "component5", "copy", "createData", "values", "", "cells", "metadata", "Lcom/deliveryhero/fluid/template/data/TemplateMetadata;", "createUi", "equals", "", "other", "hashCode", "", "toString", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Template {
    @NotNull
    private final DataDecoder dataDecoder;
    @NotNull
    private final String hash;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f30204id;
    @NotNull
    private final Logger logger;
    @NotNull
    private final WidgetModel widget;

    public Template(@NotNull String str, @NotNull String str2, @NotNull WidgetModel widgetModel, @NotNull DataDecoder dataDecoder2, @NotNull Logger logger2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "hash");
        Intrinsics.checkNotNullParameter(widgetModel, "widget");
        Intrinsics.checkNotNullParameter(dataDecoder2, "dataDecoder");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        this.f30204id = str;
        this.hash = str2;
        this.widget = widgetModel;
        this.dataDecoder = dataDecoder2;
        this.logger = logger2;
    }

    public static /* synthetic */ Template copy$default(Template template, String str, String str2, WidgetModel widgetModel, DataDecoder dataDecoder2, Logger logger2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = template.f30204id;
        }
        if ((i11 & 2) != 0) {
            str2 = template.hash;
        }
        String str3 = str2;
        if ((i11 & 4) != 0) {
            widgetModel = template.widget;
        }
        WidgetModel widgetModel2 = widgetModel;
        if ((i11 & 8) != 0) {
            dataDecoder2 = template.dataDecoder;
        }
        DataDecoder dataDecoder3 = dataDecoder2;
        if ((i11 & 16) != 0) {
            logger2 = template.logger;
        }
        return template.copy(str, str3, widgetModel2, dataDecoder3, logger2);
    }

    public static /* synthetic */ TemplateUiData createData$default(Template template, String str, Map map, Map map2, Map map3, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            map3 = MapsKt__MapsKt.emptyMap();
        }
        return template.createData(str, map, map2, map3);
    }

    public final void bindData(@NotNull Host host, @NotNull View view, @NotNull TemplateUiData templateUiData) {
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Intrinsics.checkNotNullParameter(view, "ui");
        Intrinsics.checkNotNullParameter(templateUiData, "data");
        Logger logger2 = host.getLogger();
        LogLevel logLevel = LogLevel.DEBUG;
        if (logLevel.compareTo(logger2.getMinimumLevel()) >= 0) {
            String tag = logger2.getTag();
            Logger.log$default(logger2, tag, logLevel, "Binding a UI of `" + this.f30204id + "` template to data: `" + templateUiData + '`', (Throwable) null, (Pair[]) null, 24, (Object) null);
        }
        host.getProfiler().trace(ProfilerTags.BIND_TEMPLATE_UI_DATA, new Template$bindData$2(host, view, templateUiData));
    }

    @NotNull
    public final String component1() {
        return this.f30204id;
    }

    @NotNull
    public final String component2() {
        return this.hash;
    }

    @NotNull
    public final WidgetModel component3() {
        return this.widget;
    }

    @NotNull
    public final DataDecoder component4() {
        return this.dataDecoder;
    }

    @NotNull
    public final Logger component5() {
        return this.logger;
    }

    @NotNull
    public final Template copy(@NotNull String str, @NotNull String str2, @NotNull WidgetModel widgetModel, @NotNull DataDecoder dataDecoder2, @NotNull Logger logger2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "hash");
        Intrinsics.checkNotNullParameter(widgetModel, "widget");
        Intrinsics.checkNotNullParameter(dataDecoder2, "dataDecoder");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        return new Template(str, str2, widgetModel, dataDecoder2, logger2);
    }

    @NotNull
    public final TemplateUiData createData(@NotNull String str, @NotNull Map<String, String> map, @NotNull Map<String, ? extends Object> map2, @NotNull Map<String, ? extends Object> map3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(map, "values");
        Intrinsics.checkNotNullParameter(map2, ComponentMapper.CELLS);
        Intrinsics.checkNotNullParameter(map3, TtmlNode.TAG_METADATA);
        return new TemplateUiDataBuilder(str, map, map2, map3).build(this.dataDecoder.getValueDecoders(), this.logger);
    }

    @NotNull
    public final View createUi(@NotNull Host host) {
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Logger logger2 = host.getLogger();
        LogLevel logLevel = LogLevel.DEBUG;
        if (logLevel.compareTo(logger2.getMinimumLevel()) >= 0) {
            String tag = logger2.getTag();
            Logger.log$default(logger2, tag, logLevel, "Creating a UI of `" + this.f30204id + "` template", (Throwable) null, (Pair[]) null, 24, (Object) null);
        }
        return (View) host.getProfiler().trace(ProfilerTags.CREATE_TEMPLATE_UI, new Template$createUi$2(host, this));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Template) {
            Template template = (Template) obj;
            if (!Intrinsics.areEqual((Object) template.f30204id, (Object) this.f30204id) || !Intrinsics.areEqual((Object) template.hash, (Object) this.hash)) {
                return false;
            }
            return true;
        }
        return false;
    }

    @NotNull
    public final DataDecoder getDataDecoder() {
        return this.dataDecoder;
    }

    @NotNull
    public final String getHash() {
        return this.hash;
    }

    @NotNull
    public final String getId() {
        return this.f30204id;
    }

    @NotNull
    public final Logger getLogger() {
        return this.logger;
    }

    @NotNull
    public final WidgetModel getWidget() {
        return this.widget;
    }

    public int hashCode() {
        return (this.f30204id.hashCode() * 31) + this.hash.hashCode();
    }

    @NotNull
    public String toString() {
        return "Template(id=" + this.f30204id + ", hash=" + this.hash + ", widget=" + this.widget + ", dataDecoder=" + this.dataDecoder + ", logger=" + this.logger + ')';
    }
}
