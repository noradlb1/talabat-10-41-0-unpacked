package com.talabat.userandlocation.compliance.status.data.remote.impl;

import com.talabat.userandlocation.compliance.status.data.remote.UserStatusRemoteDataSource;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.userandlocation.compliance.status.data.remote.impl.UserStatusRemoteDataSourceImpl", f = "UserStatusRemoteDataSourceImpl.kt", i = {0}, l = {15}, m = "getStatusOfUser", n = {"this"}, s = {"L$0"})
public final class UserStatusRemoteDataSourceImpl$getStatusOfUser$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12276h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12277i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ UserStatusRemoteDataSourceImpl f12278j;

    /* renamed from: k  reason: collision with root package name */
    public int f12279k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserStatusRemoteDataSourceImpl$getStatusOfUser$1(UserStatusRemoteDataSourceImpl userStatusRemoteDataSourceImpl, Continuation<? super UserStatusRemoteDataSourceImpl$getStatusOfUser$1> continuation) {
        super(continuation);
        this.f12278j = userStatusRemoteDataSourceImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12277i = obj;
        this.f12279k |= Integer.MIN_VALUE;
        return this.f12278j.getStatusOfUser((UserStatusRemoteDataSource.Parameters) null, this);
    }
}
