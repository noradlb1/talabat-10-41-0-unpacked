package com.deliveryhero.fluid.values;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!¨\u0006\""}, d2 = {"Lcom/deliveryhero/fluid/values/ValueType;", "", "typeName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeName", "()Ljava/lang/String;", "BOOLEAN", "FLOAT", "INTEGER", "STRING", "COLOR", "SIZE", "SHAPE", "TAG", "SMALL_TAG", "LARGE_TAG", "TEXT_ALIGNMENT", "TEXT_STYLE", "LOGICAL_PIXEL", "IMAGE_LOCATOR", "IMAGE_CONTENT_MODE", "LOCAL_IMAGE_LOCATOR", "SCALABLE_LOGICAL_PIXEL", "LINE_BREAK_MODE", "LINE_GRADIENT_ORIENTATION", "REPEAT_COUNT", "HORIZONTAL_ALIGNMENT", "VERTICAL_ALIGNMENT", "PAGER_CELL", "VERTICAL_GRID_CELL", "LIST_CELLS", "HORIZONTAL_GRID_CELL", "NATIVE_HORIZONTAL_GRID_CELL", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum ValueType {
    BOOLEAN(TypedValues.Custom.S_BOOLEAN),
    FLOAT(TypedValues.Custom.S_FLOAT),
    INTEGER(TypedValues.Custom.S_INT),
    STRING(TypedValues.Custom.S_STRING),
    COLOR("color"),
    SIZE(BindingAdaptersKt.QUERY_SIZE),
    SHAPE("shape"),
    TAG("tag_type"),
    SMALL_TAG("small_tag_type"),
    LARGE_TAG("large_tag_type"),
    TEXT_ALIGNMENT("text_alignment"),
    TEXT_STYLE(ViewHierarchyConstants.TEXT_STYLE),
    LOGICAL_PIXEL("logical_pixel"),
    IMAGE_LOCATOR("image_locator"),
    IMAGE_CONTENT_MODE("image_content_mode"),
    LOCAL_IMAGE_LOCATOR("local_image_locator"),
    SCALABLE_LOGICAL_PIXEL("scalable_logical_pixel"),
    LINE_BREAK_MODE("line_break_mode"),
    LINE_GRADIENT_ORIENTATION("line_gradient_orientation"),
    REPEAT_COUNT("lottie_repeat_count"),
    HORIZONTAL_ALIGNMENT(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT),
    VERTICAL_ALIGNMENT("vertical_alignment"),
    PAGER_CELL("pager_cells"),
    VERTICAL_GRID_CELL("vertical_grid_cells"),
    LIST_CELLS("list_cells"),
    HORIZONTAL_GRID_CELL("horizontal_grid_cells"),
    NATIVE_HORIZONTAL_GRID_CELL("native_horizontal_grid_cells");
    
    @NotNull
    private final String typeName;

    private ValueType(String str) {
        this.typeName = str;
    }

    @NotNull
    public final String getTypeName() {
        return this.typeName;
    }
}
