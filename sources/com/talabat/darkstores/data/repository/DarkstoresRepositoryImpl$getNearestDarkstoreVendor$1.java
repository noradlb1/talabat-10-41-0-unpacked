package com.talabat.darkstores.data.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl", f = "DarkstoresRepositoryImpl.kt", i = {}, l = {105}, m = "getNearestDarkstoreVendor", n = {}, s = {})
public final class DarkstoresRepositoryImpl$getNearestDarkstoreVendor$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f56211h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepositoryImpl f56212i;

    /* renamed from: j  reason: collision with root package name */
    public int f56213j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DarkstoresRepositoryImpl$getNearestDarkstoreVendor$1(DarkstoresRepositoryImpl darkstoresRepositoryImpl, Continuation<? super DarkstoresRepositoryImpl$getNearestDarkstoreVendor$1> continuation) {
        super(continuation);
        this.f56212i = darkstoresRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f56211h = obj;
        this.f56213j |= Integer.MIN_VALUE;
        return this.f56212i.getNearestDarkstoreVendor(this);
    }
}
