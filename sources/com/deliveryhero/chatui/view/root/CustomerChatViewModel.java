package com.deliveryhero.chatui.view.root;

import androidx.annotation.RestrictTo;
import androidx.autofill.HintConstants;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.deliveryhero.chatui.domain.call.CallStatus;
import com.deliveryhero.chatui.domain.call.usecase.CallStatusUseCase;
import com.deliveryhero.chatui.domain.call.usecase.CallUseCase;
import com.deliveryhero.contract.configuration.ChatConfiguration;
import com.deliveryhero.contract.model.ClientConfig;
import com.deliveryhero.contract.model.DeliveryInfo;
import com.deliveryhero.contract.model.Translations;
import com.deliveryhero.contract.model.UserInfo;
import com.deliveryhero.customerchat.commons.ExtensionsUtilsKt;
import com.deliveryhero.customerchat.eventTracking.data.CallMetadata;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.tracker.CallEventsTracker;
import com.deliveryhero.customerchat.eventTracking.utils.TrackingDataUtilsKt;
import com.deliveryhero.customerchat.fwf.FeatureFlagProvider;
import com.deliveryhero.customerchat.telephony.domain.voipAnalytics.CallRegistrationStatus;
import com.deliveryhero.repository.gccchat.ConfigRelay;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.00J\u0006\u00101\u001a\u00020,J\r\u00102\u001a\u00020,H\u0000¢\u0006\u0002\b3J\b\u00104\u001a\u00020\u0010H\u0002J\u0010\u00105\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\u0019\u00106\u001a\u00020,2\u0006\u00107\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u00108J\b\u00109\u001a\u00020,H\u0017J\u0011\u0010:\u001a\u00020,H@ø\u0001\u0000¢\u0006\u0002\u0010;R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u001a@BX.¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001a8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100!X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u001a@BX.¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR \u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u0002\u0004\n\u0002\b\u0019¨\u0006<"}, d2 = {"Lcom/deliveryhero/chatui/view/root/CustomerChatViewModel;", "Landroidx/lifecycle/ViewModel;", "configRelay", "Lcom/deliveryhero/repository/gccchat/ConfigRelay;", "callStatusUseCase", "Lcom/deliveryhero/chatui/domain/call/usecase/CallStatusUseCase;", "callUseCase", "Lcom/deliveryhero/chatui/domain/call/usecase/CallUseCase;", "chatConfiguration", "Lcom/deliveryhero/contract/configuration/ChatConfiguration;", "featureFlagProvider", "Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;", "callEventsTracker", "Lcom/deliveryhero/customerchat/eventTracking/tracker/CallEventsTracker;", "(Lcom/deliveryhero/repository/gccchat/ConfigRelay;Lcom/deliveryhero/chatui/domain/call/usecase/CallStatusUseCase;Lcom/deliveryhero/chatui/domain/call/usecase/CallUseCase;Lcom/deliveryhero/contract/configuration/ChatConfiguration;Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;Lcom/deliveryhero/customerchat/eventTracking/tracker/CallEventsTracker;)V", "<set-?>", "", "canTranslate", "getCanTranslate$customerchat_basicRelease", "()Z", "getChatConfiguration", "()Lcom/deliveryhero/contract/configuration/ChatConfiguration;", "eventMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "getEventMetadata", "()Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "", "phoneNumber", "getPhoneNumber$customerchat_basicRelease", "()Ljava/lang/String;", "receiverType", "getReceiverType", "shouldHideCallButton", "Lkotlinx/coroutines/flow/MutableStateFlow;", "title", "getTitle$customerchat_basicRelease", "typingLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getTypingLiveData$customerchat_basicRelease", "()Landroidx/lifecycle/MutableLiveData;", "setTypingLiveData$customerchat_basicRelease", "(Landroidx/lifecycle/MutableLiveData;)V", "call", "", "callStatus", "Lcom/deliveryhero/chatui/domain/call/CallStatus;", "getCallStatus", "Lkotlinx/coroutines/flow/Flow;", "hideCallButton", "init", "init$customerchat_basicRelease", "isTranslationEnabled", "logCallButtonClickedEvent", "logCallButtonShownEvent", "buttonState", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "reFetchChannelFeatureFlags", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomerChatViewModel extends ViewModel {
    /* access modifiers changed from: private */
    @NotNull
    public final CallEventsTracker callEventsTracker;
    @NotNull
    private final CallStatusUseCase callStatusUseCase;
    @NotNull
    private final CallUseCase callUseCase;
    private boolean canTranslate;
    @NotNull
    private final ChatConfiguration chatConfiguration;
    @NotNull
    private final ConfigRelay configRelay;
    @NotNull
    private final EventMetadata eventMetadata;
    /* access modifiers changed from: private */
    @NotNull
    public final FeatureFlagProvider featureFlagProvider;
    private String phoneNumber;
    @NotNull
    private MutableStateFlow<Boolean> shouldHideCallButton = StateFlowKt.MutableStateFlow(Boolean.FALSE);
    private String title;
    @NotNull
    private MutableLiveData<Integer> typingLiveData = new MutableLiveData<>();

    public CustomerChatViewModel(@NotNull ConfigRelay configRelay2, @NotNull CallStatusUseCase callStatusUseCase2, @NotNull CallUseCase callUseCase2, @NotNull ChatConfiguration chatConfiguration2, @NotNull FeatureFlagProvider featureFlagProvider2, @NotNull CallEventsTracker callEventsTracker2) {
        String str;
        Intrinsics.checkNotNullParameter(configRelay2, "configRelay");
        Intrinsics.checkNotNullParameter(callStatusUseCase2, "callStatusUseCase");
        Intrinsics.checkNotNullParameter(callUseCase2, "callUseCase");
        Intrinsics.checkNotNullParameter(chatConfiguration2, "chatConfiguration");
        Intrinsics.checkNotNullParameter(featureFlagProvider2, "featureFlagProvider");
        Intrinsics.checkNotNullParameter(callEventsTracker2, "callEventsTracker");
        this.configRelay = configRelay2;
        this.callStatusUseCase = callStatusUseCase2;
        this.callUseCase = callUseCase2;
        this.chatConfiguration = chatConfiguration2;
        this.featureFlagProvider = featureFlagProvider2;
        this.callEventsTracker = callEventsTracker2;
        ClientConfig clientConfigOrNull = chatConfiguration2.getClientConfigOrNull();
        String str2 = null;
        if (clientConfigOrNull != null) {
            str = clientConfigOrNull.getGlobalEntityID();
        } else {
            str = null;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(ExtensionsUtilsKt.getOrderIDFromChannelID(chatConfiguration2.getChannelIDOrNull()));
        String valueOf3 = String.valueOf(chatConfiguration2.getChannelIDOrNull());
        UserInfo userInfoOrNull = chatConfiguration2.getUserInfoOrNull();
        this.eventMetadata = new EventMetadata(valueOf, valueOf2, valueOf3, String.valueOf(userInfoOrNull != null ? userInfoOrNull.getId() : str2));
    }

    /* access modifiers changed from: private */
    public final String getReceiverType() {
        return TrackingDataUtilsKt.getReceiverType(this.chatConfiguration);
    }

    private final boolean isTranslationEnabled() {
        Translations translations = this.chatConfiguration.getTranslations();
        if (translations instanceof Translations.DISABLED) {
            return false;
        }
        if (translations instanceof Translations.ENABLED) {
            Translations.ENABLED enabled = (Translations.ENABLED) translations;
            if (!(!enabled.getSupportedTranslations().isEmpty()) || !(!StringsKt__StringsJVMKt.isBlank(enabled.getPreferredLanguage()))) {
                return false;
            }
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void logCallButtonClickedEvent(CallStatus callStatus) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new CustomerChatViewModel$logCallButtonClickedEvent$1(this, callStatus, (Continuation<? super CustomerChatViewModel$logCallButtonClickedEvent$1>) null), 3, (Object) null);
    }

    public final void call(@NotNull CallStatus callStatus) {
        Intrinsics.checkNotNullParameter(callStatus, "callStatus");
        logCallButtonClickedEvent(callStatus);
        this.callUseCase.execute(callStatus);
    }

    @NotNull
    public final Flow<CallStatus> getCallStatus() {
        Flow<R> combine = FlowKt.combine(this.shouldHideCallButton, this.callStatusUseCase.getCallStatus(), new CustomerChatViewModel$getCallStatus$1((Continuation<? super CustomerChatViewModel$getCallStatus$1>) null));
        Duration.Companion companion = Duration.Companion;
        return FlowKt.distinctUntilChanged(FlowKt.m7823debounceHG0u8IE(combine, DurationKt.toDuration(1, DurationUnit.SECONDS)));
    }

    public final boolean getCanTranslate$customerchat_basicRelease() {
        return this.canTranslate;
    }

    @NotNull
    public final ChatConfiguration getChatConfiguration() {
        return this.chatConfiguration;
    }

    @NotNull
    public final EventMetadata getEventMetadata() {
        return this.eventMetadata;
    }

    @NotNull
    public final String getPhoneNumber$customerchat_basicRelease() {
        String str = this.phoneNumber;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException(HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        return null;
    }

    @NotNull
    public final String getTitle$customerchat_basicRelease() {
        String str = this.title;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("title");
        return null;
    }

    @NotNull
    public final MutableLiveData<Integer> getTypingLiveData$customerchat_basicRelease() {
        return this.typingLiveData;
    }

    public final void hideCallButton() {
        this.shouldHideCallButton.setValue(Boolean.TRUE);
    }

    public final void init$customerchat_basicRelease() {
        String str;
        DeliveryInfo deliveryInfo = this.chatConfiguration.getDeliveryInfo();
        if (deliveryInfo == null || (str = deliveryInfo.getCustomer()) == null) {
            str = "";
        }
        this.title = str;
        this.canTranslate = isTranslationEnabled();
    }

    @Nullable
    public final Object logCallButtonShownEvent(boolean z11, @NotNull Continuation<? super Unit> continuation) {
        CallEventsTracker callEventsTracker2 = this.callEventsTracker;
        EventMetadata eventMetadata2 = this.eventMetadata;
        CallMetadata callMetadata = r3;
        CallMetadata callMetadata2 = new CallMetadata((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (CallRegistrationStatus) null, Boxing.boxBoolean(z11), (String) null, 1535, (DefaultConstructorMarker) null);
        Object trackInAppCallButtonShown = callEventsTracker2.trackInAppCallButtonShown(eventMetadata2, callMetadata, continuation);
        if (trackInAppCallButtonShown == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return trackInAppCallButtonShown;
        }
        return Unit.INSTANCE;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public void onCleared() {
        super.onCleared();
        this.configRelay.clearCache();
    }

    @Nullable
    public final Object reFetchChannelFeatureFlags(@NotNull Continuation<? super Unit> continuation) {
        Object determineChannelFeatures = this.featureFlagProvider.determineChannelFeatures(this.chatConfiguration.getChannelId(), continuation);
        if (determineChannelFeatures == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return determineChannelFeatures;
        }
        return Unit.INSTANCE;
    }

    public final void setTypingLiveData$customerchat_basicRelease(@NotNull MutableLiveData<Integer> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.typingLiveData = mutableLiveData;
    }
}
