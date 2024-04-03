package com.talabat.core.safety.data.repository.shield.remote;

import com.talabat.core.safety.domain.SafetyEventType;
import com.talabat.core.safety.domain.entities.SafetyAppData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.core.safety.data.repository.shield.remote.RemoteShieldRepository", f = "RemoteShieldRepository.kt", i = {0}, l = {32}, m = "sendSafetyResult", n = {"this"}, s = {"L$0"})
public final class RemoteShieldRepository$sendSafetyResult$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55967h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f55968i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ RemoteShieldRepository f55969j;

    /* renamed from: k  reason: collision with root package name */
    public int f55970k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RemoteShieldRepository$sendSafetyResult$1(RemoteShieldRepository remoteShieldRepository, Continuation<? super RemoteShieldRepository$sendSafetyResult$1> continuation) {
        super(continuation);
        this.f55969j = remoteShieldRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55968i = obj;
        this.f55970k |= Integer.MIN_VALUE;
        return this.f55969j.sendSafetyResult((String) null, (SafetyEventType) null, (String) null, (SafetyAppData) null, this);
    }
}
