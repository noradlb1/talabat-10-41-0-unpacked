package com.deliveryhero.customerchat.eventTracking.tracker;

import com.deliveryhero.customerchat.eventTracking.Analytics;
import com.deliveryhero.customerchat.eventTracking.data.ErrorMessageMetadata;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.data.MessageMetadata;
import com.deliveryhero.customerchat.eventTracking.data.TranslationMetadata;
import com.deliveryhero.customerchat.eventTracking.factory.MessageEventsFactory;
import com.deliveryhero.customerchat.fwf.FeatureFlagProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ/\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J!\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J!\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J!\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J!\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ!\u0010 \u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/tracker/MessageEventsTrackerImpl;", "Lcom/deliveryhero/customerchat/eventTracking/tracker/MessageEventsTracker;", "analytics", "Lcom/deliveryhero/customerchat/eventTracking/Analytics;", "factory", "Lcom/deliveryhero/customerchat/eventTracking/factory/MessageEventsFactory;", "featureFlagProvider", "Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;", "(Lcom/deliveryhero/customerchat/eventTracking/Analytics;Lcom/deliveryhero/customerchat/eventTracking/factory/MessageEventsFactory;Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;)V", "ifTrackingEnabled", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackErrorSendingMessageEvent", "eventMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "errorMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/ErrorMessageMetadata;", "(Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;Lcom/deliveryhero/customerchat/eventTracking/data/ErrorMessageMetadata;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackMessageDeliveredEvent", "messageMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/MessageMetadata;", "(Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;Lcom/deliveryhero/customerchat/eventTracking/data/MessageMetadata;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackMessageQuickResponseSelectedEvent", "trackMessageSentEvent", "trackTranslationActivatedEvent", "translationMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/TranslationMetadata;", "(Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;Lcom/deliveryhero/customerchat/eventTracking/data/TranslationMetadata;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackTranslationDeactivatedEvent", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MessageEventsTrackerImpl implements MessageEventsTracker {
    /* access modifiers changed from: private */
    @NotNull
    public final Analytics analytics;
    /* access modifiers changed from: private */
    @NotNull
    public final MessageEventsFactory factory;
    @NotNull
    private final FeatureFlagProvider featureFlagProvider;

    public MessageEventsTrackerImpl(@NotNull Analytics analytics2, @NotNull MessageEventsFactory messageEventsFactory, @NotNull FeatureFlagProvider featureFlagProvider2) {
        Intrinsics.checkNotNullParameter(analytics2, "analytics");
        Intrinsics.checkNotNullParameter(messageEventsFactory, "factory");
        Intrinsics.checkNotNullParameter(featureFlagProvider2, "featureFlagProvider");
        this.analytics = analytics2;
        this.factory = messageEventsFactory;
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
            boolean r2 = r1 instanceof com.deliveryhero.customerchat.eventTracking.tracker.MessageEventsTrackerImpl$ifTrackingEnabled$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.deliveryhero.customerchat.eventTracking.tracker.MessageEventsTrackerImpl$ifTrackingEnabled$1 r2 = (com.deliveryhero.customerchat.eventTracking.tracker.MessageEventsTrackerImpl$ifTrackingEnabled$1) r2
            int r3 = r2.f29957k
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f29957k = r3
            goto L_0x001c
        L_0x0017:
            com.deliveryhero.customerchat.eventTracking.tracker.MessageEventsTrackerImpl$ifTrackingEnabled$1 r2 = new com.deliveryhero.customerchat.eventTracking.tracker.MessageEventsTrackerImpl$ifTrackingEnabled$1
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f29955i
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.f29957k
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
            java.lang.Object r4 = r2.f29954h
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0052
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r1)
            com.deliveryhero.customerchat.fwf.FeatureFlagProvider r1 = r0.featureFlagProvider
            r4 = r18
            r2.f29954h = r4
            r2.f29957k = r6
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
            r2.f29954h = r1
            r2.f29957k = r5
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
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.eventTracking.tracker.MessageEventsTrackerImpl.ifTrackingEnabled(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public Object trackErrorSendingMessageEvent(@NotNull EventMetadata eventMetadata, @NotNull ErrorMessageMetadata errorMessageMetadata, @NotNull Continuation<? super Unit> continuation) {
        Object ifTrackingEnabled = ifTrackingEnabled(new MessageEventsTrackerImpl$trackErrorSendingMessageEvent$2(this, eventMetadata, errorMessageMetadata, (Continuation<? super MessageEventsTrackerImpl$trackErrorSendingMessageEvent$2>) null), continuation);
        return ifTrackingEnabled == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ifTrackingEnabled : Unit.INSTANCE;
    }

    @Nullable
    public Object trackMessageDeliveredEvent(@NotNull EventMetadata eventMetadata, @NotNull MessageMetadata messageMetadata, @NotNull Continuation<? super Unit> continuation) {
        Object ifTrackingEnabled = ifTrackingEnabled(new MessageEventsTrackerImpl$trackMessageDeliveredEvent$2(this, eventMetadata, messageMetadata, (Continuation<? super MessageEventsTrackerImpl$trackMessageDeliveredEvent$2>) null), continuation);
        return ifTrackingEnabled == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ifTrackingEnabled : Unit.INSTANCE;
    }

    @Nullable
    public Object trackMessageQuickResponseSelectedEvent(@NotNull EventMetadata eventMetadata, @NotNull MessageMetadata messageMetadata, @NotNull Continuation<? super Unit> continuation) {
        Object ifTrackingEnabled = ifTrackingEnabled(new MessageEventsTrackerImpl$trackMessageQuickResponseSelectedEvent$2(this, eventMetadata, messageMetadata, (Continuation<? super MessageEventsTrackerImpl$trackMessageQuickResponseSelectedEvent$2>) null), continuation);
        return ifTrackingEnabled == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ifTrackingEnabled : Unit.INSTANCE;
    }

    @Nullable
    public Object trackMessageSentEvent(@NotNull EventMetadata eventMetadata, @NotNull MessageMetadata messageMetadata, @NotNull Continuation<? super Unit> continuation) {
        Object ifTrackingEnabled = ifTrackingEnabled(new MessageEventsTrackerImpl$trackMessageSentEvent$2(this, eventMetadata, messageMetadata, (Continuation<? super MessageEventsTrackerImpl$trackMessageSentEvent$2>) null), continuation);
        return ifTrackingEnabled == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ifTrackingEnabled : Unit.INSTANCE;
    }

    @Nullable
    public Object trackTranslationActivatedEvent(@NotNull EventMetadata eventMetadata, @NotNull TranslationMetadata translationMetadata, @NotNull Continuation<? super Unit> continuation) {
        Object ifTrackingEnabled = ifTrackingEnabled(new MessageEventsTrackerImpl$trackTranslationActivatedEvent$2(this, eventMetadata, translationMetadata, (Continuation<? super MessageEventsTrackerImpl$trackTranslationActivatedEvent$2>) null), continuation);
        return ifTrackingEnabled == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ifTrackingEnabled : Unit.INSTANCE;
    }

    @Nullable
    public Object trackTranslationDeactivatedEvent(@NotNull EventMetadata eventMetadata, @NotNull TranslationMetadata translationMetadata, @NotNull Continuation<? super Unit> continuation) {
        Object ifTrackingEnabled = ifTrackingEnabled(new MessageEventsTrackerImpl$trackTranslationDeactivatedEvent$2(this, eventMetadata, translationMetadata, (Continuation<? super MessageEventsTrackerImpl$trackTranslationDeactivatedEvent$2>) null), continuation);
        return ifTrackingEnabled == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ifTrackingEnabled : Unit.INSTANCE;
    }
}
