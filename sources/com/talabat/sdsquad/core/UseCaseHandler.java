package com.talabat.sdsquad.core;

import com.talabat.sdsquad.core.UseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J7\u0010\u0003\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0005*\u00020\u0006\"\u0004\b\u0001\u0010\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00040\b2\u0006\u0010\t\u001a\u0002H\u0005¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/sdsquad/core/UseCaseHandler;", "", "()V", "execute", "R", "T", "Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "useCase", "Lcom/talabat/sdsquad/core/UseCase;", "values", "(Lcom/talabat/sdsquad/core/UseCase;Lcom/talabat/sdsquad/core/UseCase$RequestValues;)Ljava/lang/Object;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UseCaseHandler {
    public final <T extends UseCase.RequestValues, R> R execute(@NotNull UseCase<T, R> useCase, @NotNull T t11) {
        Intrinsics.checkNotNullParameter(useCase, "useCase");
        Intrinsics.checkNotNullParameter(t11, "values");
        useCase.setRequestValues(t11);
        return useCase.run$com_talabat_NewArchi_sdsquad_sdsquad();
    }
}
