package com.talabat.core.safety.data.datasource.availability.play;

import com.talabat.core.gms.base.domain.IsGmsAvailable;
import com.talabat.core.safety.data.datasource.availability.AvailabilityCheck;
import com.talabat.core.safety.data.di.DebugValue;
import javax.inject.Inject;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/core/safety/data/datasource/availability/play/GooglePlayAvailabilityCheck;", "Lcom/talabat/core/safety/data/datasource/availability/AvailabilityCheck;", "isDebug", "", "isGmsAvailable", "(ZZ)V", "isSafetyCheckAvailable", "()Z", "com_talabat_core_safety_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GooglePlayAvailabilityCheck implements AvailabilityCheck {
    private final boolean isDebug;
    private final boolean isGmsAvailable;

    @Inject
    public GooglePlayAvailabilityCheck(@DebugValue boolean z11, @IsGmsAvailable boolean z12) {
        this.isDebug = z11;
        this.isGmsAvailable = z12;
    }

    public boolean isSafetyCheckAvailable() {
        return !this.isDebug && this.isGmsAvailable;
    }
}
