package com.marshmallow;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/marshmallow/AlertType;", "", "alertTypeValue", "", "(Ljava/lang/String;II)V", "getAlertTypeValue", "()I", "NOTIFICATION", "WARNING", "ERROR", "SUCCESS", "Companion", "com_talabat_NewArchi_Marshmallow_Marshmallow"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum AlertType {
    NOTIFICATION(0),
    WARNING(1),
    ERROR(2),
    SUCCESS(3);
    
    @NotNull
    public static final Companion Companion = null;
    private final int alertTypeValue;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/marshmallow/AlertType$Companion;", "", "()V", "getAlertType", "Lcom/marshmallow/AlertType;", "alertTypeValue", "", "com_talabat_NewArchi_Marshmallow_Marshmallow"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final AlertType getAlertType(int i11) {
            boolean z11;
            for (AlertType alertType : AlertType.values()) {
                if (alertType.getAlertTypeValue() == i11) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    return alertType;
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private AlertType(int i11) {
        this.alertTypeValue = i11;
    }

    public final int getAlertTypeValue() {
        return this.alertTypeValue;
    }
}
