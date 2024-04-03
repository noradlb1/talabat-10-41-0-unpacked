package com.talabat.wallet.bnplmanager.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/entity/DeliveryProvider;", "", "provider", "", "description", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getProvider", "()I", "TMP", "TGO", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum DeliveryProvider {
    TMP(100, "VendorDelivery"),
    TGO(200, "OwnDelivery");
    
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final String description;
    private final int provider;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/entity/DeliveryProvider$Companion;", "", "()V", "getDeliveryProvider", "Lcom/talabat/wallet/bnplmanager/domain/entity/DeliveryProvider;", "isTGO", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DeliveryProvider getDeliveryProvider(boolean z11) {
            if (z11) {
                return DeliveryProvider.TGO;
            }
            return DeliveryProvider.TMP;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private DeliveryProvider(int i11, String str) {
        this.provider = i11;
        this.description = str;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final int getProvider() {
        return this.provider;
    }
}
