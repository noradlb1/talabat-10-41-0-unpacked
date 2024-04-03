package com.talabat.feature.darkstores.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/darkstores/domain/model/DarkstoreNavigationType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "NONE", "PRODUCT", "CAMPAIGN", "CART", "CATEGORY", "PRODUCT_SKU", "CART_LEGACY", "LIFESTYLE_MISSION", "LIFESTYLE_MISSION_V2_LEGACY", "PRIMARY_MISSION", "Companion", "com_talabat_feature_darkstores_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum DarkstoreNavigationType {
    NONE(-1),
    PRODUCT(1),
    CAMPAIGN(2),
    CART(3),
    CATEGORY(4),
    PRODUCT_SKU(5),
    CART_LEGACY(6),
    LIFESTYLE_MISSION(7),
    LIFESTYLE_MISSION_V2_LEGACY(8),
    PRIMARY_MISSION(9);
    
    @NotNull
    public static final Companion Companion = null;
    private final int type;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/darkstores/domain/model/DarkstoreNavigationType$Companion;", "", "()V", "fromInt", "Lcom/talabat/feature/darkstores/domain/model/DarkstoreNavigationType;", "type", "", "com_talabat_feature_darkstores_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DarkstoreNavigationType fromInt(int i11) {
            DarkstoreNavigationType darkstoreNavigationType;
            boolean z11;
            DarkstoreNavigationType[] values = DarkstoreNavigationType.values();
            int length = values.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    darkstoreNavigationType = null;
                    break;
                }
                darkstoreNavigationType = values[i12];
                if (darkstoreNavigationType.getType() == i11) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    break;
                }
                i12++;
            }
            if (darkstoreNavigationType == null) {
                return DarkstoreNavigationType.NONE;
            }
            return darkstoreNavigationType;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private DarkstoreNavigationType(int i11) {
        this.type = i11;
    }

    public final int getType() {
        return this.type;
    }
}
