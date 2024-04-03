package com.deliveryhero.fluid.telemetry.log;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/deliveryhero/fluid/telemetry/log/ErrorTypes;", "", "code", "", "message", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "TEMPLATE_FETCH", "TEMPLATE_BUILD", "TEMPLATE_STORE", "REFERENCE", "PLACEHOLDER", "BINDING", "COLLECTION_SCROLL", "OBJECT_INITIALIZE", "LITERAL", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum ErrorTypes {
    TEMPLATE_FETCH(1, "Could not fetch templates"),
    TEMPLATE_BUILD(2, "Could not build the template"),
    TEMPLATE_STORE(3, "Could not store Templates"),
    REFERENCE(5, "Could not find a value for reference"),
    PLACEHOLDER(6, "Could not find a value for placeholder"),
    BINDING(8, "Binding error"),
    COLLECTION_SCROLL(9, "Collection scroll could not be handled"),
    OBJECT_INITIALIZE(10, "Object could not be initialized"),
    LITERAL(11, "Literals are only supported for scalar values");
    
    private final int code;
    @NotNull
    private final String message;

    private ErrorTypes(int i11, String str) {
        this.code = i11;
        this.message = str;
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }
}
