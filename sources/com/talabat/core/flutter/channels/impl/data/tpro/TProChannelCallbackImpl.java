package com.talabat.core.flutter.channels.impl.data.tpro;

import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.country.Country;
import com.talabat.core.flutter.channels.domain.tpro.TProChannelCallback;
import com.talabat.core.flutter.channels.impl.data.tpro.dto.UpdateProStatusArguments;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.model.CountryParams;
import com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import com.talabat.talabatcommon.extentions.GsonKt;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ)\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/tpro/TProChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/tpro/TProChannelCallback;", "getProMovUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetTProVendorMovUseCase;", "subscriptionStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "tProPlanMov", "", "proCentralizationStatusWrapper", "Lcom/talabat/feature/subscriptions/domain/wrapper/ProCentralizationStatusWrapper;", "(Lcom/talabat/feature/subscriptions/domain/usecase/GetTProVendorMovUseCase;Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;FLcom/talabat/feature/subscriptions/domain/wrapper/ProCentralizationStatusWrapper;)V", "getTProConfig", "", "", "", "arguments", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateProStatus", "", "CompanionObject", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProChannelCallbackImpl implements TProChannelCallback {
    @NotNull
    public static final CompanionObject CompanionObject = new CompanionObject((DefaultConstructorMarker) null);
    @NotNull
    public static final String IS_PRO_ENABLED_VALUE_KEY = "isTProEnabled";
    @NotNull
    public static final String MINIMUM_ORDER_VALUE_KEY = "minimumOrderValue";
    @NotNull
    public static final String USER_IS_TPRO_RESULT_KEY = "userIsTpro";
    @NotNull
    private final GetTProVendorMovUseCase getProMovUseCase;
    @NotNull
    private final ProCentralizationStatusWrapper proCentralizationStatusWrapper;
    @NotNull
    private final ISubscriptionStatusRepository subscriptionStatusRepository;
    private final float tProPlanMov;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/tpro/TProChannelCallbackImpl$CompanionObject;", "", "()V", "IS_PRO_ENABLED_VALUE_KEY", "", "MINIMUM_ORDER_VALUE_KEY", "USER_IS_TPRO_RESULT_KEY", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CompanionObject {
        private CompanionObject() {
        }

        public /* synthetic */ CompanionObject(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public TProChannelCallbackImpl(@NotNull GetTProVendorMovUseCase getTProVendorMovUseCase, @NotNull ISubscriptionStatusRepository iSubscriptionStatusRepository, @Named("TProPlanMOV") float f11, @NotNull ProCentralizationStatusWrapper proCentralizationStatusWrapper2) {
        Intrinsics.checkNotNullParameter(getTProVendorMovUseCase, "getProMovUseCase");
        Intrinsics.checkNotNullParameter(iSubscriptionStatusRepository, "subscriptionStatusRepository");
        Intrinsics.checkNotNullParameter(proCentralizationStatusWrapper2, "proCentralizationStatusWrapper");
        this.getProMovUseCase = getTProVendorMovUseCase;
        this.subscriptionStatusRepository = iSubscriptionStatusRepository;
        this.tProPlanMov = f11;
        this.proCentralizationStatusWrapper = proCentralizationStatusWrapper2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getTProConfig(@org.jetbrains.annotations.Nullable java.lang.Object r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.talabat.core.flutter.channels.impl.data.tpro.TProChannelCallbackImpl$getTProConfig$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.talabat.core.flutter.channels.impl.data.tpro.TProChannelCallbackImpl$getTProConfig$1 r0 = (com.talabat.core.flutter.channels.impl.data.tpro.TProChannelCallbackImpl$getTProConfig$1) r0
            int r1 = r0.f55930k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55930k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.core.flutter.channels.impl.data.tpro.TProChannelCallbackImpl$getTProConfig$1 r0 = new com.talabat.core.flutter.channels.impl.data.tpro.TProChannelCallbackImpl$getTProConfig$1
            r0.<init>(r12, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f55928i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55930k
            r3 = 0
            java.lang.String r4 = "isTProEnabled"
            r5 = 2
            java.lang.String r6 = "minimumOrderValue"
            java.lang.String r7 = "userIsTpro"
            r8 = 3
            r9 = 1
            r10 = 0
            if (r2 == 0) goto L_0x0040
            if (r2 != r9) goto L_0x0038
            java.lang.Object r13 = r0.f55927h
            com.talabat.core.flutter.channels.impl.data.tpro.TProChannelCallbackImpl r13 = (com.talabat.core.flutter.channels.impl.data.tpro.TProChannelCallbackImpl) r13
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x00c5 }
            goto L_0x0095
        L_0x0038:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r14)
            com.google.gson.Gson r14 = com.talabat.talabatcommon.extentions.GsonKt.getGson()
            r2 = 0
            java.lang.String r13 = com.talabat.talabatcommon.extentions.GsonKt.toJson$default(r13, r2, r9, r2)
            boolean r2 = r14 instanceof com.google.gson.Gson
            java.lang.Class<com.talabat.core.flutter.channels.impl.data.tpro.dto.TproArguments> r11 = com.talabat.core.flutter.channels.impl.data.tpro.dto.TproArguments.class
            if (r2 != 0) goto L_0x0057
            java.lang.Object r13 = r14.fromJson((java.lang.String) r13, r11)
            goto L_0x005b
        L_0x0057:
            java.lang.Object r13 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r14, (java.lang.String) r13, r11)
        L_0x005b:
            com.talabat.core.flutter.channels.impl.data.tpro.dto.TproArguments r13 = (com.talabat.core.flutter.channels.impl.data.tpro.dto.TproArguments) r13
            java.lang.Integer r14 = r13.getBranchId()
            java.lang.Boolean r13 = r13.isProVendor()
            if (r13 == 0) goto L_0x006c
            boolean r13 = r13.booleanValue()
            goto L_0x006d
        L_0x006c:
            r13 = r10
        L_0x006d:
            com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository r2 = r12.subscriptionStatusRepository
            boolean r2 = r2.isTProUser()
            if (r13 == 0) goto L_0x0145
            if (r2 != 0) goto L_0x0079
            goto L_0x0145
        L_0x0079:
            if (r14 == 0) goto L_0x0120
            r14.intValue()
            com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase r13 = r12.getProMovUseCase     // Catch:{ all -> 0x00c4 }
            com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase$Params r2 = new com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase$Params     // Catch:{ all -> 0x00c4 }
            int r14 = r14.intValue()     // Catch:{ all -> 0x00c4 }
            r2.<init>(r14)     // Catch:{ all -> 0x00c4 }
            r0.f55927h = r12     // Catch:{ all -> 0x00c4 }
            r0.f55930k = r9     // Catch:{ all -> 0x00c4 }
            java.lang.Object r14 = r13.invoke(r2, r0)     // Catch:{ all -> 0x00c4 }
            if (r14 != r1) goto L_0x0094
            return r1
        L_0x0094:
            r13 = r12
        L_0x0095:
            com.talabat.feature.subscriptions.domain.model.ProVendorMov r14 = (com.talabat.feature.subscriptions.domain.model.ProVendorMov) r14     // Catch:{ all -> 0x00c5 }
            kotlin.Pair[] r0 = new kotlin.Pair[r8]     // Catch:{ all -> 0x00c5 }
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)     // Catch:{ all -> 0x00c5 }
            kotlin.Pair r1 = kotlin.TuplesKt.to(r7, r1)     // Catch:{ all -> 0x00c5 }
            r0[r10] = r1     // Catch:{ all -> 0x00c5 }
            java.lang.Float r14 = r14.getMov()     // Catch:{ all -> 0x00c5 }
            kotlin.Pair r14 = kotlin.TuplesKt.to(r6, r14)     // Catch:{ all -> 0x00c5 }
            r0[r9] = r14     // Catch:{ all -> 0x00c5 }
            buisnessmodels.Customer r14 = buisnessmodels.Customer.getInstance()     // Catch:{ all -> 0x00c5 }
            boolean r14 = r14.isShowPro()     // Catch:{ all -> 0x00c5 }
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r14)     // Catch:{ all -> 0x00c5 }
            kotlin.Pair r14 = kotlin.TuplesKt.to(r4, r14)     // Catch:{ all -> 0x00c5 }
            r0[r5] = r14     // Catch:{ all -> 0x00c5 }
            java.util.Map r13 = kotlin.collections.MapsKt__MapsKt.mapOf(r0)     // Catch:{ all -> 0x00c5 }
            goto L_0x011e
        L_0x00c4:
            r13 = r12
        L_0x00c5:
            float r14 = r13.tProPlanMov
            int r14 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r14 <= 0) goto L_0x00fa
            kotlin.Pair[] r14 = new kotlin.Pair[r8]
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
            kotlin.Pair r0 = kotlin.TuplesKt.to(r7, r0)
            r14[r10] = r0
            float r13 = r13.tProPlanMov
            java.lang.Float r13 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r13)
            kotlin.Pair r13 = kotlin.TuplesKt.to(r6, r13)
            r14[r9] = r13
            buisnessmodels.Customer r13 = buisnessmodels.Customer.getInstance()
            boolean r13 = r13.isShowPro()
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r13)
            kotlin.Pair r13 = kotlin.TuplesKt.to(r4, r13)
            r14[r5] = r13
            java.util.Map r13 = kotlin.collections.MapsKt__MapsKt.mapOf(r14)
            goto L_0x011e
        L_0x00fa:
            kotlin.Pair[] r13 = new kotlin.Pair[r8]
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
            kotlin.Pair r14 = kotlin.TuplesKt.to(r7, r14)
            r13[r10] = r14
            java.lang.Float r14 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r3)
            kotlin.Pair r14 = kotlin.TuplesKt.to(r6, r14)
            r13[r9] = r14
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
            kotlin.Pair r14 = kotlin.TuplesKt.to(r4, r14)
            r13[r5] = r14
            java.util.Map r13 = kotlin.collections.MapsKt__MapsKt.mapOf(r13)
        L_0x011e:
            if (r13 != 0) goto L_0x0144
        L_0x0120:
            kotlin.Pair[] r13 = new kotlin.Pair[r8]
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
            kotlin.Pair r14 = kotlin.TuplesKt.to(r7, r14)
            r13[r10] = r14
            java.lang.Float r14 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r3)
            kotlin.Pair r14 = kotlin.TuplesKt.to(r6, r14)
            r13[r9] = r14
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
            kotlin.Pair r14 = kotlin.TuplesKt.to(r4, r14)
            r13[r5] = r14
            java.util.Map r13 = kotlin.collections.MapsKt__MapsKt.mapOf(r13)
        L_0x0144:
            return r13
        L_0x0145:
            kotlin.Pair[] r13 = new kotlin.Pair[r8]
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
            kotlin.Pair r14 = kotlin.TuplesKt.to(r7, r14)
            r13[r10] = r14
            java.lang.Float r14 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r3)
            kotlin.Pair r14 = kotlin.TuplesKt.to(r6, r14)
            r13[r9] = r14
            buisnessmodels.Customer r14 = buisnessmodels.Customer.getInstance()
            boolean r14 = r14.isShowPro()
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r14)
            kotlin.Pair r14 = kotlin.TuplesKt.to(r4, r14)
            r13[r5] = r14
            java.util.Map r13 = kotlin.collections.MapsKt__MapsKt.mapOf(r13)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.channels.impl.data.tpro.TProChannelCallbackImpl.getTProConfig(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public Object updateProStatus(@Nullable Object obj, @NotNull Continuation<? super Unit> continuation) {
        Object obj2;
        Gson gson = GsonKt.getGson();
        String json$default = GsonKt.toJson$default(obj, (Gson) null, 1, (Object) null);
        Class cls = UpdateProStatusArguments.class;
        if (!(gson instanceof Gson)) {
            obj2 = gson.fromJson(json$default, cls);
        } else {
            obj2 = GsonInstrumentation.fromJson(gson, json$default, cls);
        }
        Object single = this.proCentralizationStatusWrapper.single(new CountryParams(Country.Companion.from(((UpdateProStatusArguments) obj2).getCountryId())), continuation);
        if (single == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return single;
        }
        return Unit.INSTANCE;
    }
}
