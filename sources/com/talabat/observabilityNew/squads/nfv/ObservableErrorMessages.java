package com.talabat.observabilityNew.squads.nfv;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/observabilityNew/squads/nfv/ObservableErrorMessages;", "", "()V", "OUT_OF_STOCK", "", "com_talabat_core_observability_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ObservableErrorMessages {
    @NotNull
    public static final ObservableErrorMessages INSTANCE = new ObservableErrorMessages();
    @NotNull
    public static final String OUT_OF_STOCK = "Product is out of stock.";

    private ObservableErrorMessages() {
    }
}
