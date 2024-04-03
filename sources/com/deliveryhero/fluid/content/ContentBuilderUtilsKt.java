package com.deliveryhero.fluid.content;

import com.deliveryhero.fluid.ParseConfig;
import com.deliveryhero.fluid.telemetry.log.ErrorTypes;
import com.deliveryhero.fluid.telemetry.log.LoggerKt;
import com.deliveryhero.fluid.template.Template;
import com.deliveryhero.fluid.widgets.collections.RawCell;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.fluid.homescreen.data.parser.ComponentMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\n0\u0007H\u0000\u001aJ\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\n0\u0007H\u0002¨\u0006\u000e"}, d2 = {"buildInternal", "Lcom/deliveryhero/fluid/content/Content;", "TrackingModelT", "Lcom/deliveryhero/fluid/content/ContentBuilder;", "config", "Lcom/deliveryhero/fluid/ParseConfig;", "templates", "", "", "Lcom/deliveryhero/fluid/template/TemplateId;", "Lcom/deliveryhero/fluid/template/Template;", "getRawCells", "", "Lcom/deliveryhero/fluid/widgets/collections/RawCell;", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ContentBuilderUtilsKt {
    @NotNull
    public static final <TrackingModelT> Content buildInternal(@NotNull ContentBuilder<TrackingModelT> contentBuilder, @NotNull ParseConfig parseConfig, @NotNull Map<String, Template> map) {
        Intrinsics.checkNotNullParameter(contentBuilder, "<this>");
        Intrinsics.checkNotNullParameter(parseConfig, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        Intrinsics.checkNotNullParameter(map, "templates");
        Template template = (Template) MapsKt__MapsKt.getValue(map, contentBuilder.getTemplateId());
        return new BasicContent(template, template.createData(contentBuilder.getId(), contentBuilder.getScalarValues(), getRawCells(contentBuilder, parseConfig, map), contentBuilder.getMetadata()));
    }

    private static final <TrackingModelT> Map<String, List<RawCell>> getRawCells(ContentBuilder<TrackingModelT> contentBuilder, ParseConfig parseConfig, Map<String, Template> map) {
        RawCell rawCell;
        ArrayList arrayList = new ArrayList();
        for (ContentBuilder contentBuilder2 : contentBuilder.getCells()) {
            try {
                Template template = (Template) MapsKt__MapsKt.getValue(map, contentBuilder2.getTemplateId());
                rawCell = new RawCell(template, template.createData(contentBuilder2.getId(), contentBuilder2.getScalarValues(), getRawCells(contentBuilder2, parseConfig, map), contentBuilder2.getMetadata()), contentBuilder2.getWidth(), contentBuilder2.getHeight());
            } catch (Throwable th2) {
                LoggerKt.error(parseConfig.getLogger(), th2, ErrorTypes.OBJECT_INITIALIZE, MapsKt__MapsKt.mapOf(TuplesKt.to("cell", contentBuilder2), TuplesKt.to("templates", map)));
                rawCell = null;
            }
            if (rawCell != null) {
                arrayList.add(rawCell);
            }
        }
        return MapsKt__MapsJVMKt.mapOf(TuplesKt.to(ComponentMapper.CELLS, arrayList));
    }
}
