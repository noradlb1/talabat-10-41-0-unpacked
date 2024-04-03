package org.mockito.kotlin;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J&\u0010\b\u001a\u00020\t*\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\rH\nR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lorg/mockito/kotlin/VerifyScope;", "T", "", "mock", "(Ljava/lang/Object;)V", "getMock", "()Ljava/lang/Object;", "Ljava/lang/Object;", "times", "", "", "call", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "mockito-kotlin"}, k = 1, mv = {1, 1, 15})
public final class VerifyScope<T> {
    private final T mock;

    public VerifyScope(T t11) {
        this.mock = t11;
    }

    public final T getMock() {
        return this.mock;
    }

    public final void times(int i11, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, NotificationCompat.CATEGORY_CALL);
        function1.invoke(VerificationKt.verify(getMock(), VerificationKt.times(i11)));
    }
}
