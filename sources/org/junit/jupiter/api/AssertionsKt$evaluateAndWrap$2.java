package org.junit.jupiter.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.function.ThrowingSupplier;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "R", "get"}, k = 3, mv = {1, 1, 18}, xi = 128)
public final class AssertionsKt$evaluateAndWrap$2<T> implements ThrowingSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f57100a;

    public AssertionsKt$evaluateAndWrap$2(Throwable th2) {
        this.f57100a = th2;
    }

    @NotNull
    public final Void get() {
        throw this.f57100a;
    }
}
