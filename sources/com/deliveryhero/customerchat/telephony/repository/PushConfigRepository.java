package com.deliveryhero.customerchat.telephony.repository;

import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u0005R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/deliveryhero/customerchat/telephony/repository/PushConfigRepository;", "", "()V", "_tokenState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isTokenRegistered", "", "()Z", "setTokenRegistered", "(Z)V", "token", "getToken", "()Ljava/lang/String;", "userId", "getUserId", "setUserId", "(Ljava/lang/String;)V", "awaitTokenFlow", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", "", "hasCache", "setToken", "update", "telephony_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PushConfigRepository {
    @NotNull
    private final MutableStateFlow<String> _tokenState = StateFlowKt.MutableStateFlow(null);
    private boolean isTokenRegistered;
    @Nullable
    private String userId;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object awaitTokenFlow(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<java.lang.String>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.deliveryhero.customerchat.telephony.repository.PushConfigRepository$awaitTokenFlow$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.deliveryhero.customerchat.telephony.repository.PushConfigRepository$awaitTokenFlow$1 r0 = (com.deliveryhero.customerchat.telephony.repository.PushConfigRepository$awaitTokenFlow$1) r0
            int r1 = r0.f30055k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f30055k = r1
            goto L_0x0018
        L_0x0013:
            com.deliveryhero.customerchat.telephony.repository.PushConfigRepository$awaitTokenFlow$1 r0 = new com.deliveryhero.customerchat.telephony.repository.PushConfigRepository$awaitTokenFlow$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f30053i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f30055k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f30052h
            com.deliveryhero.customerchat.telephony.repository.PushConfigRepository r0 = (com.deliveryhero.customerchat.telephony.repository.PushConfigRepository) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x004a
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> r5 = r4._tokenState
            kotlinx.coroutines.flow.Flow r5 = kotlinx.coroutines.flow.FlowKt.filterNotNull(r5)
            r0.f30052h = r4
            r0.f30055k = r3
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.first(r5, r0)
            if (r5 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r0 = r4
        L_0x004a:
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> r5 = r0._tokenState
            kotlinx.coroutines.flow.Flow r5 = kotlinx.coroutines.flow.FlowKt.filterNotNull(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.telephony.repository.PushConfigRepository.awaitTokenFlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void clear() {
        this.isTokenRegistered = false;
        this._tokenState.setValue(null);
        this.userId = null;
    }

    @Nullable
    public final String getToken() {
        return this._tokenState.getValue();
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    public final boolean hasCache(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(str2, LegacyTokenLocalDataSourceImpl.KEY);
        if (!this.isTokenRegistered || !Intrinsics.areEqual((Object) getToken(), (Object) str2) || !Intrinsics.areEqual((Object) this.userId, (Object) str)) {
            return false;
        }
        return true;
    }

    public final boolean isTokenRegistered() {
        return this.isTokenRegistered;
    }

    public final void setToken(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
        this._tokenState.setValue(str);
    }

    public final void setTokenRegistered(boolean z11) {
        this.isTokenRegistered = z11;
    }

    public final void setUserId(@Nullable String str) {
        this.userId = str;
    }

    public final void update(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        this.isTokenRegistered = true;
        this.userId = str;
    }
}
