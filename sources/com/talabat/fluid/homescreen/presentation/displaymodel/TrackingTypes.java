package com.talabat.fluid.homescreen.presentation.displaymodel;

import com.talabat.wallet.bnplmanager.domain.tracking.event.BnplFakeTestSubmissionEventKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/displaymodel/TrackingTypes;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "VERTICAL", "SHOP", "Companion", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum TrackingTypes {
    VERTICAL(BnplFakeTestSubmissionEventKt.ATTRIBUTE_KEY_VERTICAL),
    SHOP("shop");
    
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/displaymodel/TrackingTypes$Companion;", "", "()V", "from", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/TrackingTypes;", "value", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final TrackingTypes from(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            for (TrackingTypes trackingTypes : TrackingTypes.values()) {
                if (Intrinsics.areEqual((Object) trackingTypes.getValue(), (Object) str)) {
                    return trackingTypes;
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private TrackingTypes(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
