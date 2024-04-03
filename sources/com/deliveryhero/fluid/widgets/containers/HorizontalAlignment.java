package com.deliveryhero.fluid.widgets.containers;

import com.deliveryhero.fluid.values.Enumeration;
import com.deliveryhero.fluid.versioning.CoreContract;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/fluid/widgets/containers/HorizontalAlignment;", "", "Lcom/deliveryhero/fluid/values/Enumeration;", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "LEADING", "CENTER", "TRAILING", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
public enum HorizontalAlignment implements Enumeration {
    LEADING("leading"),
    CENTER("center"),
    TRAILING("trailing");
    
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f30267id;

    private HorizontalAlignment(String str) {
        this.f30267id = str;
    }

    @NotNull
    public String getId() {
        return this.f30267id;
    }
}
