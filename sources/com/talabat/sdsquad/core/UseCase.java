package com.talabat.sdsquad.core;

import com.talabat.sdsquad.core.UseCase.RequestValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004:\u0002\u0013\u0014B\u0005¢\u0006\u0002\u0010\u0005J\u0017\u0010\b\u001a\u00028\u00012\b\u0010\t\u001a\u0004\u0018\u00018\u0000H$¢\u0006\u0002\u0010\nJ\r\u0010\u000b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\fJ\u000f\u0010\r\u001a\u00028\u0001H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012R\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/talabat/sdsquad/core/UseCase;", "Q", "Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "P", "", "()V", "mRequestValues", "Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "executeUseCase", "requestValues", "(Lcom/talabat/sdsquad/core/UseCase$RequestValues;)Ljava/lang/Object;", "getRequestValues", "()Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "run", "run$com_talabat_NewArchi_sdsquad_sdsquad", "()Ljava/lang/Object;", "setRequestValues", "", "(Lcom/talabat/sdsquad/core/UseCase$RequestValues;)V", "RequestValues", "ResponseValue", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class UseCase<Q extends RequestValues, P> {
    @Nullable
    private Q mRequestValues;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface RequestValues {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/talabat/sdsquad/core/UseCase$ResponseValue;", "", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ResponseValue {
    }

    public abstract P executeUseCase(@Nullable Q q11);

    @Nullable
    public final Q getRequestValues() {
        return this.mRequestValues;
    }

    public final P run$com_talabat_NewArchi_sdsquad_sdsquad() {
        return executeUseCase(this.mRequestValues);
    }

    public final void setRequestValues(@NotNull Q q11) {
        Intrinsics.checkNotNullParameter(q11, "requestValues");
        this.mRequestValues = q11;
    }
}
