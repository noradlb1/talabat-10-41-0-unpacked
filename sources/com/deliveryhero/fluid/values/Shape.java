package com.deliveryhero.fluid.values;

import com.deliveryhero.fluid.versioning.CoreContract;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0002\u000b\fB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\r"}, d2 = {"Lcom/deliveryhero/fluid/values/Shape;", "", "Lcom/deliveryhero/fluid/values/Enumeration;", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "RECT", "RECT_ROUNDED", "OVAL", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
public enum Shape implements Enumeration {
    RECT("rect"),
    RECT_ROUNDED("corner_rounded"),
    OVAL("oval");
    
    @NotNull
    public static final Companion Companion = null;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f30236id;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/fluid/values/Shape$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/fluid/values/Shape;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final KSerializer<Shape> serializer() {
            return Shape$$serializer.INSTANCE;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private Shape(String str) {
        this.f30236id = str;
    }

    @NotNull
    public String getId() {
        return this.f30236id;
    }
}
