package com.deliveryhero.fluid.content.utils;

import com.deliveryhero.fluid.content.ContentBuilder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0016\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0011J \u0010\u0016\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u00102\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u00110\u001aJ$\u0010\u001b\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00112\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u001c\u0010\u001e\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0011H\u0002J\u001c\u0010\u001f\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0011H\u0002J\u001c\u0010 \u001a\u00020\u0017\"\u0004\b\u0000\u0010\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0011H\u0002J\u001c\u0010!\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0011H\u0002J\u001c\u0010\"\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0011H\u0002J\u001c\u0010#\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R'\u0010\u000f\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00118Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R'\u0010\u0014\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00118Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013¨\u0006$"}, d2 = {"Lcom/deliveryhero/fluid/content/utils/LegacySizeTransformer;", "", "()V", "DEFAULT_ITEM_SPACING", "", "LAYOUT_TYPE_PAGER", "", "LAYOUT_TYPE_SCROLLABLE_LIST", "LAYOUT_TYPE_VERTICAL_GRID", "MINIMUM_ROWS", "", "PARAM_HEIGHT", "PARAM_ITEM_SPACING", "PARAM_ROWS", "PARAM_WIDTH", "heightInScalarValues", "TrackingModelT", "Lcom/deliveryhero/fluid/content/ContentBuilder;", "getHeightInScalarValues", "(Lcom/deliveryhero/fluid/content/ContentBuilder;)Ljava/lang/Float;", "widthInScalarValues", "getWidthInScalarValues", "transform", "", "builder", "builders", "", "transformHorizontalGridCell", "cell", "rows", "transformNonCollection", "transformPager", "transformPagerCell", "transformScrollableList", "transformVerticalGrid", "transformVerticalGridCell", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LegacySizeTransformer {
    private static final float DEFAULT_ITEM_SPACING = 16.0f;
    @NotNull
    public static final LegacySizeTransformer INSTANCE = new LegacySizeTransformer();
    @NotNull
    private static final String LAYOUT_TYPE_PAGER = "pager";
    @NotNull
    private static final String LAYOUT_TYPE_SCROLLABLE_LIST = "scrollable-list";
    @NotNull
    private static final String LAYOUT_TYPE_VERTICAL_GRID = "grid";
    private static final int MINIMUM_ROWS = 1;
    @NotNull
    private static final String PARAM_HEIGHT = "height";
    @NotNull
    private static final String PARAM_ITEM_SPACING = "item_spacing";
    @NotNull
    private static final String PARAM_ROWS = "rows";
    @NotNull
    private static final String PARAM_WIDTH = "width";

    private LegacySizeTransformer() {
    }

    private final <TrackingModelT> Float getHeightInScalarValues(ContentBuilder<TrackingModelT> contentBuilder) {
        String str = contentBuilder.getScalarValues().get("height");
        if (str != null) {
            return StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str);
        }
        return null;
    }

    private final <TrackingModelT> Float getWidthInScalarValues(ContentBuilder<TrackingModelT> contentBuilder) {
        String str = contentBuilder.getScalarValues().get("width");
        if (str != null) {
            return StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str);
        }
        return null;
    }

    private final <TrackingModelT> void transformHorizontalGridCell(ContentBuilder<TrackingModelT> contentBuilder, int i11) {
        Float f11;
        String str = contentBuilder.getScalarValues().get("width");
        if (str != null) {
            f11 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str);
        } else {
            f11 = null;
        }
        contentBuilder.setWidth(f11);
        contentBuilder.setHeight(Float.valueOf(1.0f / ((float) i11)));
    }

    private final <TrackingModelT> void transformNonCollection(ContentBuilder<TrackingModelT> contentBuilder) {
        Float f11;
        String str = contentBuilder.getScalarValues().get("width");
        Float f12 = null;
        if (str != null) {
            f11 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str);
        } else {
            f11 = null;
        }
        contentBuilder.setWidth(f11);
        String str2 = contentBuilder.getScalarValues().get("height");
        if (str2 != null) {
            f12 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str2);
        }
        contentBuilder.setHeight(f12);
        for (ContentBuilder transform : contentBuilder.getCells()) {
            INSTANCE.transform(transform);
        }
    }

    private final <TrackingModelT> void transformPager(ContentBuilder<TrackingModelT> contentBuilder) {
        Float f11;
        Float f12;
        float f13;
        Float f14;
        float f15;
        String str = contentBuilder.getScalarValues().get("width");
        if (str != null) {
            f11 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str);
        } else {
            f11 = null;
        }
        contentBuilder.setWidth(f11);
        Iterator it = contentBuilder.getCells().iterator();
        if (it.hasNext()) {
            String str2 = ((ContentBuilder) it.next()).getScalarValues().get("height");
            if (str2 != null) {
                f12 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str2);
            } else {
                f12 = null;
            }
            if (f12 != null) {
                f13 = f12.floatValue();
            } else {
                f13 = 0.0f;
            }
            while (it.hasNext()) {
                String str3 = ((ContentBuilder) it.next()).getScalarValues().get("height");
                if (str3 != null) {
                    f14 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str3);
                } else {
                    f14 = null;
                }
                if (f14 != null) {
                    f15 = f14.floatValue();
                } else {
                    f15 = 0.0f;
                }
                f13 = Math.max(f13, f15);
            }
            contentBuilder.setHeight(Float.valueOf(f13));
            for (ContentBuilder contentBuilder2 : contentBuilder.getCells()) {
                LegacySizeTransformer legacySizeTransformer = INSTANCE;
                legacySizeTransformer.transform(contentBuilder2);
                legacySizeTransformer.transformPagerCell(contentBuilder2);
            }
            return;
        }
        throw new NoSuchElementException();
    }

    private final <TrackingModelT> void transformPagerCell(ContentBuilder<TrackingModelT> contentBuilder) {
        Float f11;
        String str = contentBuilder.getScalarValues().get("width");
        Float f12 = null;
        if (str != null) {
            f11 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str);
        } else {
            f11 = null;
        }
        contentBuilder.setWidth(f11);
        String str2 = contentBuilder.getScalarValues().get("height");
        if (str2 != null) {
            f12 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str2);
        }
        contentBuilder.setHeight(f12);
    }

    private final <TrackingModelT> void transformScrollableList(ContentBuilder<TrackingModelT> contentBuilder) {
        int i11;
        float f11;
        Float f12;
        float f13;
        Map<String, String> map;
        Float f14;
        float f15;
        Float floatOrNull;
        Integer intOrNull;
        String str = contentBuilder.getScalarValues().get(PARAM_ROWS);
        if (str == null || (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str)) == null) {
            i11 = 1;
        } else {
            i11 = RangesKt___RangesKt.coerceAtLeast(intOrNull.intValue(), 1);
        }
        int min = Math.min(i11, contentBuilder.getCells().size());
        String str2 = contentBuilder.getScalarValues().get(PARAM_ITEM_SPACING);
        if (str2 == null || (floatOrNull = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str2)) == null) {
            f11 = DEFAULT_ITEM_SPACING;
        } else {
            f11 = floatOrNull.floatValue();
        }
        Iterator it = contentBuilder.getCells().iterator();
        if (it.hasNext()) {
            String str3 = ((ContentBuilder) it.next()).getScalarValues().get("height");
            Float f16 = null;
            if (str3 != null) {
                f12 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str3);
            } else {
                f12 = null;
            }
            if (f12 != null) {
                f13 = f12.floatValue();
            } else {
                f13 = 0.0f;
            }
            while (it.hasNext()) {
                String str4 = ((ContentBuilder) it.next()).getScalarValues().get("height");
                if (str4 != null) {
                    f14 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str4);
                } else {
                    f14 = null;
                }
                if (f14 != null) {
                    f15 = f14.floatValue();
                } else {
                    f15 = 0.0f;
                }
                f13 = Math.max(f13, f15);
            }
            float f17 = (((float) min) * f13) + (((float) (min - 1)) * f11);
            if (contentBuilder.getScalarValues().containsKey("height")) {
                map = contentBuilder.getScalarValues();
            } else {
                map = MapsKt__MapsKt.plus(contentBuilder.getScalarValues(), TuplesKt.to("height", String.valueOf(f17)));
            }
            String str5 = contentBuilder.getScalarValues().get("width");
            if (str5 != null) {
                f16 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str5);
            }
            contentBuilder.setWidth(f16);
            contentBuilder.setHeight(Float.valueOf(f17));
            contentBuilder.setScalarValues(map);
            for (ContentBuilder contentBuilder2 : contentBuilder.getCells()) {
                LegacySizeTransformer legacySizeTransformer = INSTANCE;
                legacySizeTransformer.transform(contentBuilder2);
                legacySizeTransformer.transformHorizontalGridCell(contentBuilder2, i11);
            }
            return;
        }
        throw new NoSuchElementException();
    }

    private final <TrackingModelT> void transformVerticalGrid(ContentBuilder<TrackingModelT> contentBuilder) {
        Float f11;
        String str = contentBuilder.getScalarValues().get("width");
        Float f12 = null;
        if (str != null) {
            f11 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str);
        } else {
            f11 = null;
        }
        contentBuilder.setWidth(f11);
        String str2 = contentBuilder.getScalarValues().get("height");
        if (str2 != null) {
            f12 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str2);
        }
        contentBuilder.setHeight(f12);
        for (ContentBuilder contentBuilder2 : contentBuilder.getCells()) {
            LegacySizeTransformer legacySizeTransformer = INSTANCE;
            legacySizeTransformer.transform(contentBuilder2);
            legacySizeTransformer.transformVerticalGridCell(contentBuilder2);
        }
    }

    private final <TrackingModelT> void transformVerticalGridCell(ContentBuilder<TrackingModelT> contentBuilder) {
        Float f11;
        String str = contentBuilder.getScalarValues().get("width");
        Float f12 = null;
        if (str != null) {
            f11 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str);
        } else {
            f11 = null;
        }
        contentBuilder.setWidth(f11);
        String str2 = contentBuilder.getScalarValues().get("height");
        if (str2 != null) {
            f12 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str2);
        }
        contentBuilder.setHeight(f12);
    }

    public final <TrackingModelT> void transform(@NotNull List<? extends ContentBuilder<TrackingModelT>> list) {
        Intrinsics.checkNotNullParameter(list, "builders");
        for (ContentBuilder contentBuilder : list) {
            String layoutType = contentBuilder.getLayoutType();
            if (layoutType != null) {
                int hashCode = layoutType.hashCode();
                if (hashCode != 3181382) {
                    if (hashCode != 106426307) {
                        if (hashCode == 343209220 && layoutType.equals(LAYOUT_TYPE_SCROLLABLE_LIST)) {
                            INSTANCE.transformScrollableList(contentBuilder);
                        }
                    } else if (layoutType.equals(LAYOUT_TYPE_PAGER)) {
                        INSTANCE.transformPager(contentBuilder);
                    }
                } else if (layoutType.equals(LAYOUT_TYPE_VERTICAL_GRID)) {
                    INSTANCE.transformVerticalGrid(contentBuilder);
                }
            }
            INSTANCE.transformNonCollection(contentBuilder);
        }
    }

    public final <TrackingModelT> void transform(@NotNull ContentBuilder<TrackingModelT> contentBuilder) {
        Intrinsics.checkNotNullParameter(contentBuilder, "builder");
        transform(CollectionsKt__CollectionsJVMKt.listOf(contentBuilder));
    }
}
