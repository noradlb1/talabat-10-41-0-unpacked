package com.talabat.darkstores.data.tracking;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/talabat/darkstores/data/tracking/EventOrigin;", "", "trackingName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTrackingName", "()Ljava/lang/String;", "LIFESTYLE_CATEGORY", "ALL_CATEGORIES", "CATEGORY_SECTION_VLP", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum EventOrigin {
    LIFESTYLE_CATEGORY("lifestyle_category"),
    ALL_CATEGORIES("all_categories"),
    CATEGORY_SECTION_VLP("category_section_vlp");
    
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final String trackingName;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/data/tracking/EventOrigin$Companion;", "", "()V", "fromTrackingName", "Lcom/talabat/darkstores/data/tracking/EventOrigin;", "name", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final EventOrigin fromTrackingName(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            for (EventOrigin eventOrigin : EventOrigin.values()) {
                if (Intrinsics.areEqual((Object) eventOrigin.getTrackingName(), (Object) str)) {
                    return eventOrigin;
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private EventOrigin(String str) {
        this.trackingName = str;
    }

    @NotNull
    public final String getTrackingName() {
        return this.trackingName;
    }
}
