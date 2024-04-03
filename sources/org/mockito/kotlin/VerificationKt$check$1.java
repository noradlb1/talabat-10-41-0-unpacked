package org.mockito.kotlin;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;
import org.mockito.ArgumentMatcher;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "", "arg", "matches", "(Ljava/lang/Object;)Z"}, k = 3, mv = {1, 1, 15})
public final class VerificationKt$check$1<T> implements ArgumentMatcher<T> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f63287b;

    public VerificationKt$check$1(Function1 function1) {
        this.f63287b = function1;
    }

    public final boolean matches(@Nullable T t11) {
        if (t11 != null) {
            try {
                this.f63287b.invoke(t11);
                return true;
            } catch (Error e11) {
                e11.printStackTrace();
                return false;
            }
        } else {
            throw new IllegalStateException("The argument passed to the predicate was null.\n\nIf you are trying to verify an argument to be null, use `isNull()`.\nIf you are using `check` as part of a stubbing, use `argThat` or `argForWhich` instead.".toString());
        }
    }
}
