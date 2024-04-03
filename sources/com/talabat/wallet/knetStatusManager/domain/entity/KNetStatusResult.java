package com.talabat.wallet.knetStatusManager.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/wallet/knetStatusManager/domain/entity/KNetStatusResult;", "", "()V", "KNetIsAvailable", "KNetIsUnAvailable", "UnAvailableKNetCheck", "Lcom/talabat/wallet/knetStatusManager/domain/entity/KNetStatusResult$UnAvailableKNetCheck;", "Lcom/talabat/wallet/knetStatusManager/domain/entity/KNetStatusResult$KNetIsAvailable;", "Lcom/talabat/wallet/knetStatusManager/domain/entity/KNetStatusResult$KNetIsUnAvailable;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class KNetStatusResult {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/knetStatusManager/domain/entity/KNetStatusResult$KNetIsAvailable;", "Lcom/talabat/wallet/knetStatusManager/domain/entity/KNetStatusResult;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class KNetIsAvailable extends KNetStatusResult {
        @NotNull
        public static final KNetIsAvailable INSTANCE = new KNetIsAvailable();

        private KNetIsAvailable() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/knetStatusManager/domain/entity/KNetStatusResult$KNetIsUnAvailable;", "Lcom/talabat/wallet/knetStatusManager/domain/entity/KNetStatusResult;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class KNetIsUnAvailable extends KNetStatusResult {
        @NotNull
        public static final KNetIsUnAvailable INSTANCE = new KNetIsUnAvailable();

        private KNetIsUnAvailable() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/knetStatusManager/domain/entity/KNetStatusResult$UnAvailableKNetCheck;", "Lcom/talabat/wallet/knetStatusManager/domain/entity/KNetStatusResult;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UnAvailableKNetCheck extends KNetStatusResult {
        @NotNull
        public static final UnAvailableKNetCheck INSTANCE = new UnAvailableKNetCheck();

        private UnAvailableKNetCheck() {
            super((DefaultConstructorMarker) null);
        }
    }

    private KNetStatusResult() {
    }

    public /* synthetic */ KNetStatusResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
