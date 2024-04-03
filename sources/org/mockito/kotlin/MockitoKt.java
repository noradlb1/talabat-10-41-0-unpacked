package org.mockito.kotlin;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.mockito.MockingDetails;
import org.mockito.Mockito;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a%\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00060\b\"\u0002H\u0006¢\u0006\u0002\u0010\t\u001a\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"mockingDetails", "Lorg/mockito/MockingDetails;", "toInspect", "", "reset", "", "T", "mocks", "", "([Ljava/lang/Object;)V", "validateMockitoUsage", "mockito-kotlin"}, k = 2, mv = {1, 1, 15})
public final class MockitoKt {
    @NotNull
    public static final MockingDetails mockingDetails(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "toInspect");
        MockingDetails mockingDetails = Mockito.mockingDetails(obj);
        if (mockingDetails == null) {
            Intrinsics.throwNpe();
        }
        return mockingDetails;
    }

    public static final <T> void reset(@NotNull T... tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "mocks");
        Mockito.reset(Arrays.copyOf(tArr, tArr.length));
    }

    public static final void validateMockitoUsage() {
        Mockito.validateMockitoUsage();
    }
}
