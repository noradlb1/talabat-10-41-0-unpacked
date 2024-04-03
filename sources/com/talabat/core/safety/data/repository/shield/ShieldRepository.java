package com.talabat.core.safety.data.repository.shield;

import com.talabat.core.safety.domain.SafetyEventType;
import com.talabat.core.safety.domain.entities.SafetyAppData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J1\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/core/safety/data/repository/shield/ShieldRepository;", "", "sendSafetyResult", "", "customerId", "", "safetyEventType", "Lcom/talabat/core/safety/domain/SafetyEventType;", "playIntegrityResponse", "safetyAppData", "Lcom/talabat/core/safety/domain/entities/SafetyAppData;", "(Ljava/lang/String;Lcom/talabat/core/safety/domain/SafetyEventType;Ljava/lang/String;Lcom/talabat/core/safety/domain/entities/SafetyAppData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_core_safety_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ShieldRepository {
    @Nullable
    Object sendSafetyResult(@NotNull String str, @NotNull SafetyEventType safetyEventType, @NotNull String str2, @NotNull SafetyAppData safetyAppData, @NotNull Continuation<? super Unit> continuation);
}
