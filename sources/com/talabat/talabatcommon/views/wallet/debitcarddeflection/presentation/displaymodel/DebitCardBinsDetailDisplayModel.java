package com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.displaymodel;

import com.talabat.talabatcommon.feature.TalabatCommonUrlConstantsKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/debitcarddeflection/presentation/displaymodel/DebitCardBinsDetailDisplayModel;", "", "()V", "ShowDebitCardBinsInfo", "Lcom/talabat/talabatcommon/views/wallet/debitcarddeflection/presentation/displaymodel/DebitCardBinsDetailDisplayModel$ShowDebitCardBinsInfo;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class DebitCardBinsDetailDisplayModel {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/debitcarddeflection/presentation/displaymodel/DebitCardBinsDetailDisplayModel$ShowDebitCardBinsInfo;", "Lcom/talabat/talabatcommon/views/wallet/debitcarddeflection/presentation/displaymodel/DebitCardBinsDetailDisplayModel;", "bins", "", "", "(Ljava/util/Set;)V", "getBins", "()Ljava/util/Set;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowDebitCardBinsInfo extends DebitCardBinsDetailDisplayModel {
        @NotNull
        private final Set<String> bins;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowDebitCardBinsInfo(@NotNull Set<String> set) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(set, TalabatCommonUrlConstantsKt.BIN_NUMBER_PATH);
            this.bins = set;
        }

        @NotNull
        public final Set<String> getBins() {
            return this.bins;
        }
    }

    private DebitCardBinsDetailDisplayModel() {
    }

    public /* synthetic */ DebitCardBinsDetailDisplayModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
