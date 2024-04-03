package com.talabat.core.safety.domain;

import com.talabat.core.safety.domain.entities.SafetyAppData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/talabat/core/safety/domain/SafetyAgent;", "", "sendSafetyInformation", "", "customerId", "", "safetyEventType", "Lcom/talabat/core/safety/domain/SafetyEventType;", "safetyAppData", "Lcom/talabat/core/safety/domain/entities/SafetyAppData;", "com_talabat_core_safety_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SafetyAgent {
    void sendSafetyInformation(@NotNull String str, @NotNull SafetyEventType safetyEventType, @NotNull SafetyAppData safetyAppData);
}
