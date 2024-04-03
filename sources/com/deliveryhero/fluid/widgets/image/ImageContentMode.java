package com.deliveryhero.fluid.widgets.image;

import com.deliveryhero.fluid.values.Enumeration;
import com.deliveryhero.fluid.versioning.CoreContract;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/deliveryhero/fluid/widgets/image/ImageContentMode;", "", "Lcom/deliveryhero/fluid/values/Enumeration;", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "SCALE_ASPECT_FILL", "SCALE_ASPECT_FIT", "SCALE_TO_FILL", "CENTER", "LEFT", "TOP", "BOTTOM", "RIGHT", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_LEFT", "BOTTOM_RIGHT", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
public enum ImageContentMode implements Enumeration {
    SCALE_ASPECT_FILL("aspect_fill"),
    SCALE_ASPECT_FIT("aspect_fit"),
    SCALE_TO_FILL("scale_to_fill"),
    CENTER("center"),
    LEFT("left"),
    TOP(ViewHierarchyConstants.DIMENSION_TOP_KEY),
    BOTTOM("bottom"),
    RIGHT(TtmlNode.RIGHT),
    TOP_LEFT("left_top"),
    TOP_RIGHT("right_top"),
    BOTTOM_LEFT("left_bottom"),
    BOTTOM_RIGHT("right_bottom");
    
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f30272id;

    private ImageContentMode(String str) {
        this.f30272id = str;
    }

    @NotNull
    public String getId() {
        return this.f30272id;
    }
}
