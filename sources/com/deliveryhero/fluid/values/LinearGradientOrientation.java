package com.deliveryhero.fluid.values;

import com.deliveryhero.fluid.versioning.CoreContract;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0001\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0002\u0014\u0015B\u0017\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0016"}, d2 = {"Lcom/deliveryhero/fluid/values/LinearGradientOrientation;", "", "Lcom/deliveryhero/fluid/values/Enumeration;", "id", "", "angle", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getAngle", "()I", "getId", "()Ljava/lang/String;", "LEFT_RIGHT", "BOTTOM_LEFT_TOP_RIGHT", "BOTTOM_TOP", "BOTTOM_RIGHT_TOP_LEFT", "RIGHT_LEFT", "TOP_RIGHT_BOTTOM_LEFT", "TOP_BOTTOM", "TOP_LEFT_BOTTOM_RIGHT", "$serializer", "Companion", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
public enum LinearGradientOrientation implements Enumeration {
    LEFT_RIGHT("left_right", 0),
    BOTTOM_LEFT_TOP_RIGHT("bottom_left_top_right", 45),
    BOTTOM_TOP("bottom_top", 90),
    BOTTOM_RIGHT_TOP_LEFT("bottom_right_top_left", 135),
    RIGHT_LEFT("right_left", 180),
    TOP_RIGHT_BOTTOM_LEFT("top_right_bottom_left", 225),
    TOP_BOTTOM("top_bottom", 270),
    TOP_LEFT_BOTTOM_RIGHT("top_left_bottom_right", 315);
    
    @NotNull
    public static final Companion Companion = null;
    private final int angle;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f30235id;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/fluid/values/LinearGradientOrientation$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/fluid/values/LinearGradientOrientation;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final KSerializer<LinearGradientOrientation> serializer() {
            return LinearGradientOrientation$$serializer.INSTANCE;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private LinearGradientOrientation(String str, int i11) {
        this.f30235id = str;
        this.angle = i11;
    }

    public final int getAngle() {
        return this.angle;
    }

    @NotNull
    public String getId() {
        return this.f30235id;
    }
}
