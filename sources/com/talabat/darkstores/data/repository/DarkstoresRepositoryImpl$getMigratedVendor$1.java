package com.talabat.darkstores.data.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl", f = "DarkstoresRepositoryImpl.kt", i = {}, l = {116}, m = "getMigratedVendor", n = {}, s = {})
public final class DarkstoresRepositoryImpl$getMigratedVendor$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f56205h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepositoryImpl f56206i;

    /* renamed from: j  reason: collision with root package name */
    public int f56207j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DarkstoresRepositoryImpl$getMigratedVendor$1(DarkstoresRepositoryImpl darkstoresRepositoryImpl, Continuation<? super DarkstoresRepositoryImpl$getMigratedVendor$1> continuation) {
        super(continuation);
        this.f56206i = darkstoresRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f56205h = obj;
        this.f56207j |= Integer.MIN_VALUE;
        return this.f56206i.getMigratedVendor((String) null, this);
    }
}
