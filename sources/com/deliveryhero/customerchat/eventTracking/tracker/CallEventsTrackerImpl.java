package com.deliveryhero.customerchat.eventTracking.tracker;

import com.deliveryhero.customerchat.eventTracking.Analytics;
import com.deliveryhero.customerchat.eventTracking.data.CallMetadata;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.factory.CallEventsFactory;
import com.deliveryhero.customerchat.fwf.FeatureFlagProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ/\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J!\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J!\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J!\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J!\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J!\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J!\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J!\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J!\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J!\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J!\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J!\u0010 \u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J!\u0010!\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J!\u0010\"\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J!\u0010#\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/tracker/CallEventsTrackerImpl;", "Lcom/deliveryhero/customerchat/eventTracking/tracker/CallEventsTracker;", "analytics", "Lcom/deliveryhero/customerchat/eventTracking/Analytics;", "factory", "Lcom/deliveryhero/customerchat/eventTracking/factory/CallEventsFactory;", "featureFlagProvider", "Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;", "(Lcom/deliveryhero/customerchat/eventTracking/Analytics;Lcom/deliveryhero/customerchat/eventTracking/factory/CallEventsFactory;Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;)V", "ifTrackingEnabled", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackInAppCallButtonClicked", "eventMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "callMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/CallMetadata;", "(Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;Lcom/deliveryhero/customerchat/eventTracking/data/CallMetadata;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackInAppCallButtonShown", "trackInAppCallCancelled", "trackInAppCallEnded", "trackInAppCallErrorCaused", "trackInAppCallMuteButtonClicked", "trackInAppCallPickedUp", "trackInAppCallRejected", "trackInAppCallRingStarted", "trackInAppCallSpeakerButtonClicked", "trackInAppCallSurveyDisplayed", "trackInAppCallSurveySubmitted", "trackInAppCallTimedOut", "trackInAppCallUserRegistered", "trackTraditionalCallButtonClicked", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CallEventsTrackerImpl implements CallEventsTracker {
    /* access modifiers changed from: private */
    @NotNull
    public final Analytics analytics;
    /* access modifiers changed from: private */
    @NotNull
    public final CallEventsFactory factory;
    @NotNull
    private final FeatureFlagProvider featureFlagProvider;

    public CallEventsTrackerImpl(@NotNull Analytics analytics2, @NotNull CallEventsFactory callEventsFactory, @NotNull FeatureFlagProvider featureFlagProvider2) {
        Intrinsics.checkNotNullParameter(analytics2, "analytics");
        Intrinsics.checkNotNullParameter(callEventsFactory, "factory");
        Intrinsics.checkNotNullParameter(featureFlagProvider2, "featureFlagProvider");
        this.analytics = analytics2;
        this.factory = callEventsFactory;
        this.featureFlagProvider = featureFlagProvider2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object ifTrackingEnabled(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            boolean r2 = r1 instanceof com.deliveryhero.customerchat.eventTracking.tracker.CallEventsTrackerImpl$ifTrackingEnabled$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.deliveryhero.customerchat.eventTracking.tracker.CallEventsTrackerImpl$ifTrackingEnabled$1 r2 = (com.deliveryhero.customerchat.eventTracking.tracker.CallEventsTrackerImpl$ifTrackingEnabled$1) r2
            int r3 = r2.f29841k
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f29841k = r3
            goto L_0x001c
        L_0x0017:
            com.deliveryhero.customerchat.eventTracking.tracker.CallEventsTrackerImpl$ifTrackingEnabled$1 r2 = new com.deliveryhero.customerchat.eventTracking.tracker.CallEventsTrackerImpl$ifTrackingEnabled$1
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f29839i
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.f29841k
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L_0x0040
            if (r4 == r6) goto L_0x0038
            if (r4 != r5) goto L_0x0030
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x007a
        L_0x0030:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0038:
            java.lang.Object r4 = r2.f29838h
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0052
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r1)
            com.deliveryhero.customerchat.fwf.FeatureFlagProvider r1 = r0.featureFlagProvider
            r4 = r18
            r2.f29838h = r4
            r2.f29841k = r6
            java.lang.Object r1 = r1.getUserFeatureFlags(r2)
            if (r1 != r3) goto L_0x0052
            return r3
        L_0x0052:
            com.deliveryhero.customerchat.fwf.UserFeatureFlags r1 = (com.deliveryhero.customerchat.fwf.UserFeatureFlags) r1
            if (r1 != 0) goto L_0x0068
            com.deliveryhero.customerchat.fwf.UserFeatureFlags r1 = new com.deliveryhero.customerchat.fwf.UserFeatureFlags
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 255(0xff, float:3.57E-43)
            r16 = 0
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
        L_0x0068:
            boolean r1 = r1.isTrackingEnabled()
            if (r1 == 0) goto L_0x007d
            r1 = 0
            r2.f29838h = r1
            r2.f29841k = r5
            java.lang.Object r1 = r4.invoke(r2)
            if (r1 != r3) goto L_0x007a
            return r3
        L_0x007a:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x007d:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.eventTracking.tracker.CallEventsTrackerImpl.ifTrackingEnabled(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public Object trackInAppCallButtonClicked(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation) {
        Object ifTrackingEnabled = ifTrackingEnabled(new CallEventsTrackerImpl$trackInAppCallButtonClicked$2(this, eventMetadata, callMetadata, (Continuation<? super CallEventsTrackerImpl$trackInAppCallButtonClicked$2>) null), continuation);
        return ifTrackingEnabled == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ifTrackingEnabled : Unit.INSTANCE;
    }

    @Nullable
    public Object trackInAppCallButtonShown(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation) {
        Object ifTrackingEnabled = ifTrackingEnabled(new CallEventsTrackerImpl$trackInAppCallButtonShown$2(this, eventMetadata, callMetadata, (Continuation<? super CallEventsTrackerImpl$trackInAppCallButtonShown$2>) null), continuation);
        return ifTrackingEnabled == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ifTrackingEnabled : Unit.INSTANCE;
    }

    @Nullable
    public Object trackInAppCallCancelled(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation) {
        Object ifTrackingEnabled = ifTrackingEnabled(new CallEventsTrackerImpl$trackInAppCallCancelled$2(this, eventMetadata, callMetadata, (Continuation<? super CallEventsTrackerImpl$trackInAppCallCancelled$2>) null), continuation);
        return ifTrackingEnabled == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ifTrackingEnabled : Unit.INSTANCE;
    }

    @Nullable
    public Object trackInAppCallEnded(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation) {
        Object ifTrackingEnabled = ifTrackingEnabled(new CallEventsTrackerImpl$trackInAppCallEnded$2(this, eventMetadata, callMetadata, (Continuation<? super CallEventsTrackerImpl$trackInAppCallEnded$2>) null), continuation);
        return ifTrackingEnabled == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ifTrackingEnabled : Unit.INSTANCE;
    }

    @Nullable
    public Object trackInAppCallErrorCaused(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation) {
        Object ifTrackingEnabled = ifTrackingEnabled(new CallEventsTrackerImpl$trackInAppCallErrorCaused$2(this, eventMetadata, callMetadata, (Continuation<? super CallEventsTrackerImpl$trackInAppCallErrorCaused$2>) null), continuation);
        return ifTrackingEnabled == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ifTrackingEnabled : Unit.INSTANCE;
    }

    @Nullable
    public Object trackInAppCallMuteButtonClicked(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation) {
        Object ifTrackingEnabled = ifTrackingEnabled(new CallEventsTrackerImpl$trackInAppCallMuteButtonClicked$2(this, eventMetadata, callMetadata, (Continuation<? super CallEventsTrackerImpl$trackInAppCallMuteButtonClicked$2>) null), continuation);
        return ifTrackingEnabled == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ifTrackingEnabled : Unit.INSTANCE;
    }

    @Nullable
    public Object trackInAppCallPickedUp(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation) {
        Object ifTrackingEnabled = ifTrackingEnabled(new CallEventsTrackerImpl$trackInAppCallPickedUp$2(this, eventMetadata, callMetadata, (Continuation<? super CallEventsTrackerImpl$trackInAppCallPickedUp$2>) null), continuation);
        return ifTrackingEnabled == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ifTrackingEnabled : Unit.INSTANCE;
    }

    @Nullable
    public Object trackInAppCallRejected(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation) {
        Object ifTrackingEnabled = ifTrackingEnabled(new CallEventsTrackerImpl$trackInAppCallRejected$2(this, eventMetadata, callMetadata, (Continuation<? super CallEventsTrackerImpl$trackInAppCallRejected$2>) null), continuation);
        return ifTrackingEnabled == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ifTrackingEnabled : Unit.INSTANCE;
    }

    @Nullable
    public Object trackInAppCallRingStarted(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation) {
        Object ifTrackingEnabled = ifTrackingEnabled(new CallEventsTrackerImpl$trackInAppCallRingStarted$2(this, eventMetadata, callMetadata, (Continuation<? super CallEventsTrackerImpl$trackInAppCallRingStarted$2>) null), continuation);
        return ifTrackingEnabled == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ifTrackingEnabled : Unit.INSTANCE;
    }

    @Nullable
    public Object trackInAppCallSpeakerButtonClicked(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation) {
        Object ifTrackingEnabled = ifTrackingEnabled(new CallEventsTrackerImpl$trackInAppCallSpeakerButtonClicked$2(this, eventMetadata, callMetadata, (Continuation<? super CallEventsTrackerImpl$trackInAppCallSpeakerButtonClicked$2>) null), continuation);
        return ifTrackingEnabled == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ifTrackingEnabled : Unit.INSTANCE;
    }

    @Nullable
    public Object trackInAppCallSurveyDisplayed(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation) {
        Object ifTrackingEnabled = ifTrackingEnabled(new CallEventsTrackerImpl$trackInAppCallSurveyDisplayed$2(this, eventMetadata, callMetadata, (Continuation<? super CallEventsTrackerImpl$trackInAppCallSurveyDisplayed$2>) null), continuation);
        return ifTrackingEnabled == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ifTrackingEnabled : Unit.INSTANCE;
    }

    @Nullable
    public Object trackInAppCallSurveySubmitted(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation) {
        Object ifTrackingEnabled = ifTrackingEnabled(new CallEventsTrackerImpl$trackInAppCallSurveySubmitted$2(this, eventMetadata, callMetadata, (Continuation<? super CallEventsTrackerImpl$trackInAppCallSurveySubmitted$2>) null), continuation);
        return ifTrackingEnabled == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ifTrackingEnabled : Unit.INSTANCE;
    }

    @Nullable
    public Object trackInAppCallTimedOut(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation) {
        Object ifTrackingEnabled = ifTrackingEnabled(new CallEventsTrackerImpl$trackInAppCallTimedOut$2(this, eventMetadata, callMetadata, (Continuation<? super CallEventsTrackerImpl$trackInAppCallTimedOut$2>) null), continuation);
        return ifTrackingEnabled == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ifTrackingEnabled : Unit.INSTANCE;
    }

    @Nullable
    public Object trackInAppCallUserRegistered(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation) {
        Object ifTrackingEnabled = ifTrackingEnabled(new CallEventsTrackerImpl$trackInAppCallUserRegistered$2(this, eventMetadata, callMetadata, (Continuation<? super CallEventsTrackerImpl$trackInAppCallUserRegistered$2>) null), continuation);
        return ifTrackingEnabled == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ifTrackingEnabled : Unit.INSTANCE;
    }

    @Nullable
    public Object trackTraditionalCallButtonClicked(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation) {
        Object ifTrackingEnabled = ifTrackingEnabled(new CallEventsTrackerImpl$trackTraditionalCallButtonClicked$2(this, eventMetadata, callMetadata, (Continuation<? super CallEventsTrackerImpl$trackTraditionalCallButtonClicked$2>) null), continuation);
        return ifTrackingEnabled == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ifTrackingEnabled : Unit.INSTANCE;
    }
}
