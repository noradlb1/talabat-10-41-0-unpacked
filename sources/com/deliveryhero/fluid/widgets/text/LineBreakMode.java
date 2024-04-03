package com.deliveryhero.fluid.widgets.text;

import com.deliveryhero.fluid.values.Enumeration;
import com.deliveryhero.fluid.versioning.CoreContract;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/deliveryhero/fluid/widgets/text/LineBreakMode;", "", "Lcom/deliveryhero/fluid/values/Enumeration;", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "TRUNCATE_LEADING", "TRUNCATE_MIDDLE", "TRUNCATE_TRAILING", "CLIP", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
public enum LineBreakMode implements Enumeration {
    TRUNCATE_LEADING("truncating_head"),
    TRUNCATE_MIDDLE("truncating_middle"),
    TRUNCATE_TRAILING("truncating_tail"),
    CLIP("clip");
    
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f30281id;

    private LineBreakMode(String str) {
        this.f30281id = str;
    }

    @NotNull
    public String getId() {
        return this.f30281id;
    }
}
