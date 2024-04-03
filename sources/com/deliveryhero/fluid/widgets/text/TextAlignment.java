package com.deliveryhero.fluid.widgets.text;

import com.deliveryhero.fluid.values.Enumeration;
import com.deliveryhero.fluid.versioning.CoreContract;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/fluid/widgets/text/TextAlignment;", "", "Lcom/deliveryhero/fluid/values/Enumeration;", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "TOP_LEADING", "TOP_CENTER", "TOP_TRAILING", "LEADING_CENTER", "CENTER", "TRAILING_CENTER", "BOTTOM_LEADING", "BOTTOM_CENTER", "BOTTOM_TRAILING", "JUSTIFIED", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
public enum TextAlignment implements Enumeration {
    TOP_LEADING("top_leading"),
    TOP_CENTER("top_center"),
    TOP_TRAILING("top_trailing"),
    LEADING_CENTER("leading_center"),
    CENTER("center"),
    TRAILING_CENTER("trailing_center"),
    BOTTOM_LEADING("bottom_leading"),
    BOTTOM_CENTER("bottom_center"),
    BOTTOM_TRAILING("bottom_trailing"),
    JUSTIFIED("justified");
    
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f30283id;

    private TextAlignment(String str) {
        this.f30283id = str;
    }

    @NotNull
    public String getId() {
        return this.f30283id;
    }
}
