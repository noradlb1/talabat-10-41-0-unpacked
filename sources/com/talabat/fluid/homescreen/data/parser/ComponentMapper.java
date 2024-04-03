package com.talabat.fluid.homescreen.data.parser;

import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.template.Template;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataBuilder;
import com.deliveryhero.fluid.widgets.collections.RawCell;
import com.deliveryhero.fluid.widgets.collections.list.ListCell;
import com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse;
import com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0002J,\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0016\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u0018j\u0002`\u0019\u0012\u0004\u0012\u00020\u001a0\u0017J\u0016\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J \u0010\u001e\u001a\u00020\u001c2\n\u0010\u001f\u001a\u00060\u0018j\u0002`\u00192\n\u0010 \u001a\u00060\u0018j\u0002`!H\u0002J*\u0010\"\u001a\u0004\u0018\u00010\u001a2\u0016\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u0018j\u0002`\u0019\u0012\u0004\u0012\u00020\u001a0\u00172\u0006\u0010#\u001a\u00020\u0010H\u0002J,\u0010$\u001a\u00020%*\u00020\t2\u0006\u0010#\u001a\u00020\u00102\u0016\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u0018j\u0002`\u0019\u0012\u0004\u0012\u00020\u001a0\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\u00020\b*\u00020\t8Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\b*\u00020\t8Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006'"}, d2 = {"Lcom/talabat/fluid/homescreen/data/parser/ComponentMapper;", "", "logger", "Lcom/deliveryhero/fluid/telemetry/log/Logger;", "homeScreenPerformanceObservability", "Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;", "(Lcom/deliveryhero/fluid/telemetry/log/Logger;Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;)V", "height", "", "Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse$Item;", "getHeight", "(Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse$Item;)F", "width", "getWidth", "filterOutInvalidComponents", "", "Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse$Component;", "components", "map", "Lcom/deliveryhero/fluid/widgets/collections/list/ListCell;", "content", "Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse;", "templates", "", "", "Lcom/deliveryhero/fluid/template/TemplateId;", "Lcom/deliveryhero/fluid/template/Template;", "observeInvalidComponents", "", "invalidComponents", "observeNonExistingTemplates", "templateId", "templateHash", "Lcom/deliveryhero/fluid/template/sources/TemplateHash;", "retrieveTemplateIfExists", "component", "toCell", "Lcom/deliveryhero/fluid/widgets/collections/RawCell;", "Companion", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ComponentMapper {
    @NotNull
    public static final String CELLS = "cells";
    @NotNull
    public static final String COMPONENT_ID = "component_id";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String ITEM_ID = "item_id";
    @NotNull
    private static final String PARAM_HEIGHT = "height";
    @NotNull
    private static final String PARAM_WIDTH = "width";
    @NotNull
    private final HomeScreenPerformanceObservability homeScreenPerformanceObservability;
    @NotNull
    private final Logger logger;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/fluid/homescreen/data/parser/ComponentMapper$Companion;", "", "()V", "CELLS", "", "COMPONENT_ID", "ITEM_ID", "PARAM_HEIGHT", "PARAM_WIDTH", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ComponentMapper(@NotNull Logger logger2, @NotNull HomeScreenPerformanceObservability homeScreenPerformanceObservability2) {
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(homeScreenPerformanceObservability2, "homeScreenPerformanceObservability");
        this.logger = logger2;
        this.homeScreenPerformanceObservability = homeScreenPerformanceObservability2;
    }

    private final List<ContentApiResponse.Component> filterOutInvalidComponents(List<ContentApiResponse.Component> list) {
        boolean z11;
        boolean z12;
        if (list == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object next : list) {
            ContentApiResponse.Component component = (ContentApiResponse.Component) next;
            boolean z13 = true;
            if (component.getTemplateId().length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                if (component.getTemplateHash().length() == 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z12) {
                    z13 = false;
                }
            }
            if (z13) {
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List<ContentApiResponse.Component> list2 = (List) pair.component2();
        observeInvalidComponents((List) pair.component1());
        return list2;
    }

    private final float getHeight(ContentApiResponse.Item item) {
        Float floatOrNull;
        Map<String, String> properties = item.getProperties();
        if (properties == null) {
            properties = MapsKt__MapsKt.emptyMap();
        }
        String str = properties.get("height");
        if (str == null || (floatOrNull = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str)) == null) {
            return 0.0f;
        }
        return floatOrNull.floatValue();
    }

    private final float getWidth(ContentApiResponse.Item item) {
        Float floatOrNull;
        Map<String, String> properties = item.getProperties();
        if (properties == null) {
            properties = MapsKt__MapsKt.emptyMap();
        }
        String str = properties.get("width");
        if (str == null || (floatOrNull = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str)) == null) {
            return 0.0f;
        }
        return floatOrNull.floatValue();
    }

    private final void observeInvalidComponents(List<ContentApiResponse.Component> list) {
        Collection collection = list;
        if (!collection.isEmpty()) {
            this.homeScreenPerformanceObservability.traceEvent(HomeScreenPerformanceObservability.Level.ERROR, "componentMapper.map.invalidComponents", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("numberOfComponents", String.valueOf(collection.size()))));
        }
    }

    private final void observeNonExistingTemplates(String str, String str2) {
        this.homeScreenPerformanceObservability.traceEvent(HomeScreenPerformanceObservability.Level.ERROR, "componentMapper.map.nonExistingTemplate", MapsKt__MapsKt.mapOf(TuplesKt.to("templateId", str), TuplesKt.to("templateHash", str2)));
    }

    private final Template retrieveTemplateIfExists(Map<String, Template> map, ContentApiResponse.Component component) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl((Template) MapsKt__MapsKt.getValue(map, component.getTemplateId()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6332exceptionOrNullimpl(obj) != null) {
            observeNonExistingTemplates(component.getTemplateId(), component.getTemplateHash());
            obj = null;
        }
        return (Template) obj;
    }

    private final RawCell toCell(ContentApiResponse.Item item, ContentApiResponse.Component component, Map<String, Template> map) {
        float f11;
        Float floatOrNull;
        Float floatOrNull2;
        Template template = (Template) MapsKt__MapsKt.getValue(map, item.getTemplateId());
        Map<String, String> properties = item.getProperties();
        if (properties == null) {
            properties = MapsKt__MapsKt.emptyMap();
        }
        Map<String, String> metadata = item.getMetadata();
        if (metadata == null) {
            metadata = MapsKt__MapsKt.emptyMap();
        }
        TemplateUiData build = new TemplateUiDataBuilder(item.getId(), properties, MapsKt__MapsKt.emptyMap(), MapsKt__MapsKt.plus(metadata, (Map<String, String>) MapsKt__MapsKt.mapOf(TuplesKt.to("item_id", item.getId()), TuplesKt.to(COMPONENT_ID, component.getId())))).build(template.getDataDecoder().getValueDecoders(), this.logger);
        Map<String, String> properties2 = item.getProperties();
        if (properties2 == null) {
            properties2 = MapsKt__MapsKt.emptyMap();
        }
        String str = properties2.get("width");
        float f12 = 0.0f;
        if (str == null || (floatOrNull2 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str)) == null) {
            f11 = 0.0f;
        } else {
            f11 = floatOrNull2.floatValue();
        }
        Float valueOf = Float.valueOf(f11);
        Map<String, String> properties3 = item.getProperties();
        if (properties3 == null) {
            properties3 = MapsKt__MapsKt.emptyMap();
        }
        String str2 = properties3.get("height");
        if (!(str2 == null || (floatOrNull = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str2)) == null)) {
            f12 = floatOrNull.floatValue();
        }
        return new RawCell(template, build, valueOf, Float.valueOf(f12));
    }

    @NotNull
    public final List<ListCell> map(@NotNull ContentApiResponse contentApiResponse, @NotNull Map<String, Template> map) {
        List<ContentApiResponse.Component> list;
        ListCell listCell;
        Intrinsics.checkNotNullParameter(contentApiResponse, "content");
        Intrinsics.checkNotNullParameter(map, "templates");
        HomeScreenPerformanceObservability.DefaultImpls.traceStart$default(this.homeScreenPerformanceObservability, HomeScreenPerformanceObservability.Level.INFO, "componentMapper.map", (Map) null, 4, (Object) null);
        ContentApiResponse.Data data = contentApiResponse.getData();
        if (data != null) {
            list = data.getComponents();
        } else {
            list = null;
        }
        ArrayList arrayList = new ArrayList();
        for (ContentApiResponse.Component component : filterOutInvalidComponents(list)) {
            Template retrieveTemplateIfExists = retrieveTemplateIfExists(map, component);
            if (retrieveTemplateIfExists == null) {
                listCell = null;
            } else {
                List<ContentApiResponse.Item> items = component.getItems();
                if (items == null) {
                    items = CollectionsKt__CollectionsKt.emptyList();
                }
                Iterable<ContentApiResponse.Item> iterable = items;
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
                for (ContentApiResponse.Item cell : iterable) {
                    arrayList2.add(toCell(cell, component, map));
                }
                Map mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(CELLS, arrayList2));
                Map<String, String> metadata = component.getMetadata();
                if (metadata == null) {
                    metadata = MapsKt__MapsKt.emptyMap();
                }
                Map plus = MapsKt__MapsKt.plus(metadata, (Map<String, String>) MapsKt__MapsJVMKt.mapOf(TuplesKt.to(COMPONENT_ID, component.getId())));
                String id2 = component.getId();
                Map<String, String> properties = component.getProperties();
                if (properties == null) {
                    properties = MapsKt__MapsKt.emptyMap();
                }
                listCell = new ListCell(retrieveTemplateIfExists, new TemplateUiDataBuilder(id2, properties, mapOf, plus).build(retrieveTemplateIfExists.getDataDecoder().getValueDecoders(), this.logger));
            }
            if (listCell != null) {
                arrayList.add(listCell);
            }
        }
        HomeScreenPerformanceObservability.DefaultImpls.traceEnd$default(this.homeScreenPerformanceObservability, HomeScreenPerformanceObservability.Level.INFO, "componentMapper.map", (Map) null, 4, (Object) null);
        return arrayList;
    }
}
