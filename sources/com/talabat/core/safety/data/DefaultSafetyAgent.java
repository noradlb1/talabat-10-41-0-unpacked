package com.talabat.core.safety.data;

import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.safety.data.datasource.api.SafetyApi;
import com.talabat.core.safety.data.datasource.availability.AvailabilityCheck;
import com.talabat.core.safety.data.repository.protection.ProtectionRepository;
import com.talabat.core.safety.data.repository.shield.ShieldRepository;
import com.talabat.core.safety.domain.SafetyAgent;
import com.talabat.core.safety.domain.SafetyEventType;
import com.talabat.core.safety.domain.entities.SafetyAppData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/core/safety/data/DefaultSafetyAgent;", "Lcom/talabat/core/safety/domain/SafetyAgent;", "safetyApi", "Lcom/talabat/core/safety/data/datasource/api/SafetyApi;", "availabilityCheck", "Lcom/talabat/core/safety/data/datasource/availability/AvailabilityCheck;", "shieldRepository", "Lcom/talabat/core/safety/data/repository/shield/ShieldRepository;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "protectionRepository", "Lcom/talabat/core/safety/data/repository/protection/ProtectionRepository;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "secretProvider", "Lcom/talabat/authentication/aaa/secrets/SecretProvider;", "(Lcom/talabat/core/safety/data/datasource/api/SafetyApi;Lcom/talabat/core/safety/data/datasource/availability/AvailabilityCheck;Lcom/talabat/core/safety/data/repository/shield/ShieldRepository;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Lcom/talabat/core/safety/data/repository/protection/ProtectionRepository;Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;Lcom/talabat/authentication/aaa/secrets/SecretProvider;)V", "sendSafetyInformation", "", "customerId", "", "safetyEventType", "Lcom/talabat/core/safety/domain/SafetyEventType;", "safetyAppData", "Lcom/talabat/core/safety/domain/entities/SafetyAppData;", "com_talabat_core_safety_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultSafetyAgent implements SafetyAgent {
    /* access modifiers changed from: private */
    @NotNull
    public final AvailabilityCheck availabilityCheck;
    @NotNull
    private final CoroutineDispatchersFactory coroutineDispatchersFactory;
    /* access modifiers changed from: private */
    @NotNull
    public final IObservabilityManager observabilityManager;
    /* access modifiers changed from: private */
    @NotNull
    public final ProtectionRepository protectionRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final SafetyApi safetyApi;
    /* access modifiers changed from: private */
    @NotNull
    public final SecretProvider secretProvider;
    /* access modifiers changed from: private */
    @NotNull
    public final ShieldRepository shieldRepository;

    @Inject
    public DefaultSafetyAgent(@NotNull SafetyApi safetyApi2, @NotNull AvailabilityCheck availabilityCheck2, @NotNull ShieldRepository shieldRepository2, @NotNull IObservabilityManager iObservabilityManager, @NotNull ProtectionRepository protectionRepository2, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory2, @NotNull SecretProvider secretProvider2) {
        Intrinsics.checkNotNullParameter(safetyApi2, "safetyApi");
        Intrinsics.checkNotNullParameter(availabilityCheck2, "availabilityCheck");
        Intrinsics.checkNotNullParameter(shieldRepository2, "shieldRepository");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(protectionRepository2, "protectionRepository");
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory2, "coroutineDispatchersFactory");
        Intrinsics.checkNotNullParameter(secretProvider2, "secretProvider");
        this.safetyApi = safetyApi2;
        this.availabilityCheck = availabilityCheck2;
        this.shieldRepository = shieldRepository2;
        this.observabilityManager = iObservabilityManager;
        this.protectionRepository = protectionRepository2;
        this.coroutineDispatchersFactory = coroutineDispatchersFactory2;
        this.secretProvider = secretProvider2;
    }

    public void sendSafetyInformation(@NotNull String str, @NotNull SafetyEventType safetyEventType, @NotNull SafetyAppData safetyAppData) {
        Intrinsics.checkNotNullParameter(str, "customerId");
        Intrinsics.checkNotNullParameter(safetyEventType, "safetyEventType");
        Intrinsics.checkNotNullParameter(safetyAppData, "safetyAppData");
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.coroutineDispatchersFactory.io()), (CoroutineContext) null, (CoroutineStart) null, new DefaultSafetyAgent$sendSafetyInformation$1(this, str, safetyEventType, safetyAppData, (Continuation<? super DefaultSafetyAgent$sendSafetyInformation$1>) null), 3, (Object) null);
    }
}
