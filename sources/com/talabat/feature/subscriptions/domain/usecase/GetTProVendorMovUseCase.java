package com.talabat.feature.subscriptions.domain.usecase;

import androidx.annotation.VisibleForTesting;
import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.feature.subscriptions.domain.model.ProVendorMov;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/usecase/GetTProVendorMovUseCase;", "", "repository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;)V", "invoke", "Lcom/talabat/feature/subscriptions/domain/model/ProVendorMov;", "params", "Lcom/talabat/feature/subscriptions/domain/usecase/GetTProVendorMovUseCase$Params;", "(Lcom/talabat/feature/subscriptions/domain/usecase/GetTProVendorMovUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Params", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetTProVendorMovUseCase {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final HashMap<Integer, ProVendorMov> movCache = new HashMap<>();
    @NotNull
    private final ISubscriptionsRepository repository;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R8\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00078\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/usecase/GetTProVendorMovUseCase$Companion;", "", "()V", "movCache", "Ljava/util/HashMap;", "", "Lcom/talabat/feature/subscriptions/domain/model/ProVendorMov;", "Lkotlin/collections/HashMap;", "getMovCache$annotations", "getMovCache", "()Ljava/util/HashMap;", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getMovCache$annotations() {
        }

        @NotNull
        public final HashMap<Integer, ProVendorMov> getMovCache() {
            return GetTProVendorMovUseCase.movCache;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/usecase/GetTProVendorMovUseCase$Params;", "", "branchId", "", "(I)V", "getBranchId", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Params {
        private final int branchId;

        public Params(int i11) {
            this.branchId = i11;
        }

        public static /* synthetic */ Params copy$default(Params params, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = params.branchId;
            }
            return params.copy(i11);
        }

        public final int component1() {
            return this.branchId;
        }

        @NotNull
        public final Params copy(int i11) {
            return new Params(i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Params) && this.branchId == ((Params) obj).branchId;
        }

        public final int getBranchId() {
            return this.branchId;
        }

        public int hashCode() {
            return this.branchId;
        }

        @NotNull
        public String toString() {
            int i11 = this.branchId;
            return "Params(branchId=" + i11 + ")";
        }
    }

    @Inject
    public GetTProVendorMovUseCase(@NotNull ISubscriptionsRepository iSubscriptionsRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsRepository, "repository");
        this.repository = iSubscriptionsRepository;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase.Params r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.subscriptions.domain.model.ProVendorMov> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase$invoke$1 r0 = (com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase$invoke$1) r0
            int r1 = r0.f58994k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58994k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase$invoke$1 r0 = new com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase$invoke$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f58992i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58994k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.f58991h
            com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase$Params r5 = (com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase.Params) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x005f
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.HashMap<java.lang.Integer, com.talabat.feature.subscriptions.domain.model.ProVendorMov> r6 = movCache
            int r2 = r5.getBranchId()
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            java.lang.Object r6 = r6.get(r2)
            com.talabat.feature.subscriptions.domain.model.ProVendorMov r6 = (com.talabat.feature.subscriptions.domain.model.ProVendorMov) r6
            if (r6 == 0) goto L_0x004b
            goto L_0x004c
        L_0x004b:
            r6 = 0
        L_0x004c:
            if (r6 != 0) goto L_0x007f
            com.talabat.feature.subscriptions.domain.ISubscriptionsRepository r6 = r4.repository
            int r2 = r5.getBranchId()
            r0.f58991h = r5
            r0.f58994k = r3
            java.lang.Object r6 = r6.getProVendorMov(r2, r0)
            if (r6 != r1) goto L_0x005f
            return r1
        L_0x005f:
            com.talabat.feature.subscriptions.domain.model.ProVendorMov r6 = (com.talabat.feature.subscriptions.domain.model.ProVendorMov) r6
            java.lang.Float r0 = r6.getMov()
            if (r0 == 0) goto L_0x007f
            java.lang.Float r0 = r6.getMov()
            r1 = 0
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Float) r0, (float) r1)
            if (r0 != 0) goto L_0x007f
            java.util.HashMap<java.lang.Integer, com.talabat.feature.subscriptions.domain.model.ProVendorMov> r0 = movCache
            int r5 = r5.getBranchId()
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            r0.put(r5, r6)
        L_0x007f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase.invoke(com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
