package com.talabat.userandlocation.compliance.status.data.impl;

import com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.userandlocation.compliance.status.data.impl.UserStatusRepositoryImpl", f = "UserStatusRepositoryImpl.kt", i = {0}, l = {31}, m = "getStatusOfUser", n = {"this"}, s = {"L$0"})
public final class UserStatusRepositoryImpl$getStatusOfUser$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12272h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12273i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ UserStatusRepositoryImpl f12274j;

    /* renamed from: k  reason: collision with root package name */
    public int f12275k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserStatusRepositoryImpl$getStatusOfUser$1(UserStatusRepositoryImpl userStatusRepositoryImpl, Continuation<? super UserStatusRepositoryImpl$getStatusOfUser$1> continuation) {
        super(continuation);
        this.f12274j = userStatusRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12273i = obj;
        this.f12275k |= Integer.MIN_VALUE;
        return this.f12274j.getStatusOfUser(0, 0, (String) null, (String) null, (String) null, (UserStatusRepository.Type) null, false, (String) null, this);
    }
}
