package com.deliveryhero.customerchat.voip;

import com.deliveryhero.contract.ChatLogger;
import com.deliveryhero.contract.configuration.ChatConfiguration;
import com.deliveryhero.contract.configuration.ChatFeatureCallbacks;
import com.deliveryhero.contract.model.ClientConfig;
import com.deliveryhero.contract.model.UserInfo;
import com.deliveryhero.contract.model.UserType;
import com.deliveryhero.customerchat.commons.ExtensionsUtilsKt;
import com.deliveryhero.customerchat.configuration.ChatConfigProvider;
import com.deliveryhero.customerchat.eventTracking.data.CallMetadata;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.tracker.CallEventsTracker;
import com.deliveryhero.customerchat.eventTracking.utils.TrackingDataUtilsKt;
import com.deliveryhero.customerchat.fwf.FeatureFlagProvider;
import com.deliveryhero.customerchat.telephony.domain.voipAnalytics.CallRegistrationStatus;
import com.deliveryhero.customerchat.telephony.domain.voipAnalytics.TokuCallEvents;
import com.deliveryhero.customerchat.telephony.survey.VoipSurveyData;
import com.deliveryhero.customerchat.telephony.survey.VoipSurveyHandler;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0011\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J/\u0010\u0014\u001a\u00020\u00152\u001c\u0010\u0016\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ/\u0010\u001b\u001a\u00020\u00152\u001c\u0010\u0016\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ \u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0016J(\u0010!\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001eH\u0016J(\u0010#\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001eH\u0016J(\u0010%\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u001eH\u0016J(\u0010'\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u001eH\u0016J(\u0010)\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u001eH\u0016J \u0010*\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0016J(\u0010+\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u001eH\u0016J \u0010-\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0016J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020\u001eH\u0002J\u0010\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020\u00152\u0006\u00103\u001a\u000204H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"Lcom/deliveryhero/customerchat/voip/VOIPEventsImpl;", "Lcom/deliveryhero/customerchat/telephony/domain/voipAnalytics/TokuCallEvents;", "callEventsTracker", "Lcom/deliveryhero/customerchat/eventTracking/tracker/CallEventsTracker;", "chatConfigProvider", "Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;", "featureFlagProvider", "Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "chatFeatureCallbacks", "Lcom/deliveryhero/contract/configuration/ChatFeatureCallbacks;", "voipSurveyHandler", "Lcom/deliveryhero/customerchat/telephony/survey/VoipSurveyHandler;", "(Lcom/deliveryhero/customerchat/eventTracking/tracker/CallEventsTracker;Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;Lkotlinx/coroutines/CoroutineScope;Lcom/deliveryhero/contract/configuration/ChatFeatureCallbacks;Lcom/deliveryhero/customerchat/telephony/survey/VoipSurveyHandler;)V", "eventMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "getFeatureFlags", "Lcom/deliveryhero/customerchat/fwf/UserFeatureFlags;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ifTrackingEnabled", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ifVOIPSurveyEnabled", "inAppCallCancelled", "callID", "", "duration", "remoteUsername", "inAppCallEnded", "endCallReason", "inAppCallErrorCaused", "errorMessage", "inAppCallMuteButtonClicked", "buttonState", "inAppCallPickedUp", "source", "inAppCallRejected", "inAppCallRingStarted", "inAppCallSpeakerButtonClicked", "buttonToggleState", "inAppCallTimedOut", "inAppCallUserRegistered", "result", "Lcom/deliveryhero/customerchat/telephony/domain/voipAnalytics/CallRegistrationStatus;", "receiverType", "triggerSurvey", "callMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/CallMetadata;", "triggerSurveyDisplayedEvent", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VOIPEventsImpl implements TokuCallEvents {
    /* access modifiers changed from: private */
    @NotNull
    public final CallEventsTracker callEventsTracker;
    @NotNull
    private final ChatConfigProvider chatConfigProvider;
    @NotNull
    private final ChatFeatureCallbacks chatFeatureCallbacks;
    @NotNull
    private final CoroutineScope coroutineScope;
    @NotNull
    private final FeatureFlagProvider featureFlagProvider;
    @Nullable
    private final VoipSurveyHandler voipSurveyHandler;

    public VOIPEventsImpl(@NotNull CallEventsTracker callEventsTracker2, @NotNull ChatConfigProvider chatConfigProvider2, @NotNull FeatureFlagProvider featureFlagProvider2, @NotNull CoroutineScope coroutineScope2, @NotNull ChatFeatureCallbacks chatFeatureCallbacks2, @Nullable VoipSurveyHandler voipSurveyHandler2) {
        Intrinsics.checkNotNullParameter(callEventsTracker2, "callEventsTracker");
        Intrinsics.checkNotNullParameter(chatConfigProvider2, "chatConfigProvider");
        Intrinsics.checkNotNullParameter(featureFlagProvider2, "featureFlagProvider");
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        Intrinsics.checkNotNullParameter(chatFeatureCallbacks2, "chatFeatureCallbacks");
        this.callEventsTracker = callEventsTracker2;
        this.chatConfigProvider = chatConfigProvider2;
        this.featureFlagProvider = featureFlagProvider2;
        this.coroutineScope = coroutineScope2;
        this.chatFeatureCallbacks = chatFeatureCallbacks2;
        this.voipSurveyHandler = voipSurveyHandler2;
    }

    /* access modifiers changed from: private */
    public final EventMetadata eventMetadata() {
        String str;
        String str2;
        String str3;
        UserInfo userInfoOrNull;
        ClientConfig clientConfigOrNull;
        ChatConfiguration chatConfiguration = this.chatConfigProvider.getChatConfiguration();
        String str4 = null;
        if (chatConfiguration == null || (clientConfigOrNull = chatConfiguration.getClientConfigOrNull()) == null) {
            str = null;
        } else {
            str = clientConfigOrNull.getGlobalEntityID();
        }
        String valueOf = String.valueOf(str);
        if (chatConfiguration != null) {
            str2 = chatConfiguration.getChannelIDOrNull();
        } else {
            str2 = null;
        }
        String valueOf2 = String.valueOf(ExtensionsUtilsKt.getOrderIDFromChannelID(str2));
        if (chatConfiguration != null) {
            str3 = chatConfiguration.getChannelIDOrNull();
        } else {
            str3 = null;
        }
        String valueOf3 = String.valueOf(str3);
        if (!(chatConfiguration == null || (userInfoOrNull = chatConfiguration.getUserInfoOrNull()) == null)) {
            str4 = userInfoOrNull.getId();
        }
        return new EventMetadata(valueOf, valueOf2, valueOf3, String.valueOf(str4));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0076 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getFeatureFlags(kotlin.coroutines.Continuation<? super com.deliveryhero.customerchat.fwf.UserFeatureFlags> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.deliveryhero.customerchat.voip.VOIPEventsImpl$getFeatureFlags$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.deliveryhero.customerchat.voip.VOIPEventsImpl$getFeatureFlags$1 r0 = (com.deliveryhero.customerchat.voip.VOIPEventsImpl$getFeatureFlags$1) r0
            int r1 = r0.f30061k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f30061k = r1
            goto L_0x0018
        L_0x0013:
            com.deliveryhero.customerchat.voip.VOIPEventsImpl$getFeatureFlags$1 r0 = new com.deliveryhero.customerchat.voip.VOIPEventsImpl$getFeatureFlags$1
            r0.<init>(r11, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f30059i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f30061k
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 == r5) goto L_0x003f
            if (r2 == r4) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0077
        L_0x002f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0037:
            java.lang.Object r2 = r0.f30058h
            com.deliveryhero.customerchat.voip.VOIPEventsImpl r2 = (com.deliveryhero.customerchat.voip.VOIPEventsImpl) r2
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0069
        L_0x003f:
            java.lang.Object r2 = r0.f30058h
            com.deliveryhero.customerchat.voip.VOIPEventsImpl r2 = (com.deliveryhero.customerchat.voip.VOIPEventsImpl) r2
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0058
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r12)
            com.deliveryhero.customerchat.fwf.FeatureFlagProvider r12 = r11.featureFlagProvider
            r0.f30058h = r11
            r0.f30061k = r5
            java.lang.Object r12 = r12.getUserFeatureFlags(r0)
            if (r12 != r1) goto L_0x0057
            return r1
        L_0x0057:
            r2 = r11
        L_0x0058:
            com.deliveryhero.customerchat.fwf.UserFeatureFlags r12 = (com.deliveryhero.customerchat.fwf.UserFeatureFlags) r12
            if (r12 != 0) goto L_0x008c
            com.deliveryhero.customerchat.fwf.FeatureFlagProvider r12 = r2.featureFlagProvider
            r0.f30058h = r2
            r0.f30061k = r4
            java.lang.Object r12 = r12.determineUserFeatures(r0)
            if (r12 != r1) goto L_0x0069
            return r1
        L_0x0069:
            com.deliveryhero.customerchat.fwf.FeatureFlagProvider r12 = r2.featureFlagProvider
            r2 = 0
            r0.f30058h = r2
            r0.f30061k = r3
            java.lang.Object r12 = r12.getUserFeatureFlags(r0)
            if (r12 != r1) goto L_0x0077
            return r1
        L_0x0077:
            com.deliveryhero.customerchat.fwf.UserFeatureFlags r12 = (com.deliveryhero.customerchat.fwf.UserFeatureFlags) r12
            if (r12 != 0) goto L_0x008c
            com.deliveryhero.customerchat.fwf.UserFeatureFlags r12 = new com.deliveryhero.customerchat.fwf.UserFeatureFlags
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 255(0xff, float:3.57E-43)
            r10 = 0
            r0 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
        L_0x008c:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.voip.VOIPEventsImpl.getFeatureFlags(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object ifTrackingEnabled(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.deliveryhero.customerchat.voip.VOIPEventsImpl$ifTrackingEnabled$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.deliveryhero.customerchat.voip.VOIPEventsImpl$ifTrackingEnabled$1 r0 = (com.deliveryhero.customerchat.voip.VOIPEventsImpl$ifTrackingEnabled$1) r0
            int r1 = r0.f30066l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f30066l = r1
            goto L_0x0018
        L_0x0013:
            com.deliveryhero.customerchat.voip.VOIPEventsImpl$ifTrackingEnabled$1 r0 = new com.deliveryhero.customerchat.voip.VOIPEventsImpl$ifTrackingEnabled$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f30064j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f30066l
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0077
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.f30063i
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            java.lang.Object r2 = r0.f30062h
            com.deliveryhero.customerchat.voip.VOIPEventsImpl r2 = (com.deliveryhero.customerchat.voip.VOIPEventsImpl) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0051
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.f30062h = r5
            r0.f30063i = r6
            r0.f30066l = r4
            java.lang.Object r7 = r5.getFeatureFlags(r0)
            if (r7 != r1) goto L_0x0050
            return r1
        L_0x0050:
            r2 = r5
        L_0x0051:
            com.deliveryhero.customerchat.fwf.UserFeatureFlags r7 = (com.deliveryhero.customerchat.fwf.UserFeatureFlags) r7
            boolean r7 = r7.isTrackingEnabled()
            if (r7 == 0) goto L_0x007a
            com.deliveryhero.customerchat.configuration.ChatConfigProvider r7 = r2.chatConfigProvider
            com.deliveryhero.contract.configuration.ChatConfiguration r7 = r7.getChatConfiguration()
            r2 = 0
            if (r7 == 0) goto L_0x0067
            com.deliveryhero.contract.model.ClientConfig r7 = r7.getClientConfigOrNull()
            goto L_0x0068
        L_0x0067:
            r7 = r2
        L_0x0068:
            if (r7 == 0) goto L_0x007a
            r0.f30062h = r2
            r0.f30063i = r2
            r0.f30066l = r3
            java.lang.Object r6 = r6.invoke(r0)
            if (r6 != r1) goto L_0x0077
            return r1
        L_0x0077:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x007a:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.voip.VOIPEventsImpl.ifTrackingEnabled(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object ifVOIPSurveyEnabled(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.deliveryhero.customerchat.voip.VOIPEventsImpl$ifVOIPSurveyEnabled$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.deliveryhero.customerchat.voip.VOIPEventsImpl$ifVOIPSurveyEnabled$1 r0 = (com.deliveryhero.customerchat.voip.VOIPEventsImpl$ifVOIPSurveyEnabled$1) r0
            int r1 = r0.f30071l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f30071l = r1
            goto L_0x0018
        L_0x0013:
            com.deliveryhero.customerchat.voip.VOIPEventsImpl$ifVOIPSurveyEnabled$1 r0 = new com.deliveryhero.customerchat.voip.VOIPEventsImpl$ifVOIPSurveyEnabled$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f30069j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f30071l
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x006b
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.f30068i
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            java.lang.Object r2 = r0.f30067h
            com.deliveryhero.customerchat.voip.VOIPEventsImpl r2 = (com.deliveryhero.customerchat.voip.VOIPEventsImpl) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0051
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.f30067h = r5
            r0.f30068i = r6
            r0.f30071l = r4
            java.lang.Object r7 = r5.getFeatureFlags(r0)
            if (r7 != r1) goto L_0x0050
            return r1
        L_0x0050:
            r2 = r5
        L_0x0051:
            com.deliveryhero.customerchat.fwf.UserFeatureFlags r7 = (com.deliveryhero.customerchat.fwf.UserFeatureFlags) r7
            boolean r7 = r7.isVOIPSurveyEnabled()
            if (r7 == 0) goto L_0x006e
            com.deliveryhero.customerchat.telephony.survey.VoipSurveyHandler r7 = r2.voipSurveyHandler
            if (r7 == 0) goto L_0x006e
            r7 = 0
            r0.f30067h = r7
            r0.f30068i = r7
            r0.f30071l = r3
            java.lang.Object r6 = r6.invoke(r0)
            if (r6 != r1) goto L_0x006b
            return r1
        L_0x006b:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x006e:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.voip.VOIPEventsImpl.ifVOIPSurveyEnabled(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final String receiverType() {
        String receiverType;
        ChatConfiguration chatConfiguration = this.chatConfigProvider.getChatConfiguration();
        if (chatConfiguration == null || (receiverType = TrackingDataUtilsKt.getReceiverType(chatConfiguration)) == null) {
            return "";
        }
        return receiverType;
    }

    /* access modifiers changed from: private */
    public final void triggerSurvey(CallMetadata callMetadata) {
        String str;
        String str2;
        String str3;
        UserType userType;
        boolean z11;
        boolean z12;
        boolean z13;
        UserType userType2;
        String name2;
        ChatConfiguration chatConfiguration = this.chatConfigProvider.getChatConfiguration();
        if (chatConfiguration != null) {
            ClientConfig clientConfigOrNull = chatConfiguration.getClientConfigOrNull();
            String str4 = null;
            if (clientConfigOrNull == null || (userType2 = clientConfigOrNull.getUserType()) == null || (name2 = userType2.name()) == null) {
                str = null;
            } else {
                String lowerCase = name2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                str = lowerCase;
            }
            ClientConfig clientConfigOrNull2 = chatConfiguration.getClientConfigOrNull();
            if (clientConfigOrNull2 != null) {
                str2 = clientConfigOrNull2.getGlobalEntityID();
            } else {
                str2 = null;
            }
            String orderIDFromChannelID = ExtensionsUtilsKt.getOrderIDFromChannelID(chatConfiguration.getChannelIDOrNull());
            ClientConfig clientConfigOrNull3 = chatConfiguration.getClientConfigOrNull();
            if (clientConfigOrNull3 != null) {
                str3 = clientConfigOrNull3.getCountry();
            } else {
                str3 = null;
            }
            String preferredLanguage = chatConfiguration.getTranslations().preferredLanguage();
            ClientConfig clientConfigOrNull4 = chatConfiguration.getClientConfigOrNull();
            if (clientConfigOrNull4 != null) {
                userType = clientConfigOrNull4.getUserType();
            } else {
                userType = null;
            }
            boolean z14 = false;
            if (userType == UserType.CUSTOMER) {
                if (str2 == null || !StringsKt__StringsKt.contains((CharSequence) str2, (CharSequence) "FP_", true)) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                if (z13) {
                    str4 = "foodpanda";
                }
            }
            String str5 = str4;
            String callID = callMetadata.getCallID();
            if (callID == null || StringsKt__StringsJVMKt.isBlank(callID)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z12) {
                    if (str2 == null || StringsKt__StringsJVMKt.isBlank(str2)) {
                        z14 = true;
                    }
                    if (!z14) {
                        String callID2 = callMetadata.getCallID();
                        Intrinsics.checkNotNull(callID2);
                        Intrinsics.checkNotNull(str);
                        Intrinsics.checkNotNull(str2);
                        VoipSurveyData voipSurveyData = new VoipSurveyData(callID2, str, str2, orderIDFromChannelID, str3, preferredLanguage, str5);
                        VoipSurveyHandler voipSurveyHandler2 = this.voipSurveyHandler;
                        if (voipSurveyHandler2 != null) {
                            voipSurveyHandler2.showVOIPSurvey(voipSurveyData);
                        }
                        triggerSurveyDisplayedEvent(callMetadata);
                        return;
                    }
                }
            }
            ChatLogger chatLogger = this.chatFeatureCallbacks.getChatLogger();
            if (chatLogger != null) {
                chatLogger.log("GCC_CHAT_CALL_SURVEY_OPEN_ERROR", MapsKt__MapsKt.emptyMap());
            }
        }
    }

    private final void triggerSurveyDisplayedEvent(CallMetadata callMetadata) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VOIPEventsImpl$triggerSurveyDisplayedEvent$1(this, callMetadata, (Continuation<? super VOIPEventsImpl$triggerSurveyDisplayedEvent$1>) null), 3, (Object) null);
    }

    public void inAppCallCancelled(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "callID");
        Intrinsics.checkNotNullParameter(str2, "duration");
        Intrinsics.checkNotNullParameter(str3, "remoteUsername");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VOIPEventsImpl$inAppCallCancelled$1(this, str, str2, str3, (Continuation<? super VOIPEventsImpl$inAppCallCancelled$1>) null), 3, (Object) null);
    }

    public void inAppCallEnded(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "callID");
        Intrinsics.checkNotNullParameter(str2, "duration");
        Intrinsics.checkNotNullParameter(str3, "remoteUsername");
        Intrinsics.checkNotNullParameter(str4, "endCallReason");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VOIPEventsImpl$inAppCallEnded$1(this, str, str2, str3, str4, (Continuation<? super VOIPEventsImpl$inAppCallEnded$1>) null), 3, (Object) null);
    }

    public void inAppCallErrorCaused(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "callID");
        Intrinsics.checkNotNullParameter(str2, "duration");
        Intrinsics.checkNotNullParameter(str3, "remoteUsername");
        Intrinsics.checkNotNullParameter(str4, "errorMessage");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VOIPEventsImpl$inAppCallErrorCaused$1(this, str, str2, str3, str4, (Continuation<? super VOIPEventsImpl$inAppCallErrorCaused$1>) null), 3, (Object) null);
    }

    public void inAppCallMuteButtonClicked(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "callID");
        Intrinsics.checkNotNullParameter(str2, "duration");
        Intrinsics.checkNotNullParameter(str3, "remoteUsername");
        Intrinsics.checkNotNullParameter(str4, "buttonState");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VOIPEventsImpl$inAppCallMuteButtonClicked$1(this, str, str2, str3, str4, (Continuation<? super VOIPEventsImpl$inAppCallMuteButtonClicked$1>) null), 3, (Object) null);
    }

    public void inAppCallPickedUp(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "callID");
        Intrinsics.checkNotNullParameter(str2, "duration");
        Intrinsics.checkNotNullParameter(str3, "remoteUsername");
        Intrinsics.checkNotNullParameter(str4, "source");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VOIPEventsImpl$inAppCallPickedUp$1(this, str, str2, str3, str4, (Continuation<? super VOIPEventsImpl$inAppCallPickedUp$1>) null), 3, (Object) null);
    }

    public void inAppCallRejected(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "callID");
        Intrinsics.checkNotNullParameter(str2, "duration");
        Intrinsics.checkNotNullParameter(str3, "remoteUsername");
        Intrinsics.checkNotNullParameter(str4, "source");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VOIPEventsImpl$inAppCallRejected$1(this, str, str2, str3, str4, (Continuation<? super VOIPEventsImpl$inAppCallRejected$1>) null), 3, (Object) null);
    }

    public void inAppCallRingStarted(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "callID");
        Intrinsics.checkNotNullParameter(str2, "duration");
        Intrinsics.checkNotNullParameter(str3, "remoteUsername");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VOIPEventsImpl$inAppCallRingStarted$1(this, str, str2, str3, (Continuation<? super VOIPEventsImpl$inAppCallRingStarted$1>) null), 3, (Object) null);
    }

    public void inAppCallSpeakerButtonClicked(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "callID");
        Intrinsics.checkNotNullParameter(str2, "duration");
        Intrinsics.checkNotNullParameter(str3, "remoteUsername");
        Intrinsics.checkNotNullParameter(str4, "buttonToggleState");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VOIPEventsImpl$inAppCallSpeakerButtonClicked$1(this, str, str2, str3, str4, (Continuation<? super VOIPEventsImpl$inAppCallSpeakerButtonClicked$1>) null), 3, (Object) null);
    }

    public void inAppCallTimedOut(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "callID");
        Intrinsics.checkNotNullParameter(str2, "duration");
        Intrinsics.checkNotNullParameter(str3, "remoteUsername");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VOIPEventsImpl$inAppCallTimedOut$1(this, str, str2, str3, (Continuation<? super VOIPEventsImpl$inAppCallTimedOut$1>) null), 3, (Object) null);
    }

    public void inAppCallUserRegistered(@NotNull CallRegistrationStatus callRegistrationStatus) {
        Intrinsics.checkNotNullParameter(callRegistrationStatus, "result");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new VOIPEventsImpl$inAppCallUserRegistered$1(this, callRegistrationStatus, (Continuation<? super VOIPEventsImpl$inAppCallUserRegistered$1>) null), 3, (Object) null);
    }
}
