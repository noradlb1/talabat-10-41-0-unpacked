package com.deliveryhero.chatui.domain.call.usecase;

import androidx.core.app.NotificationCompat;
import com.deliveryhero.chatui.domain.call.CallStatus;
import com.deliveryhero.contract.configuration.ChatConfiguration;
import com.deliveryhero.contract.model.ConfigMessage;
import com.deliveryhero.contract.model.DeliveryInfo;
import com.deliveryhero.contract.model.PhoneCallType;
import com.deliveryhero.customerchat.configuration.ChatConfigProvider;
import com.deliveryhero.customerchat.fwf.FeatureFlagProvider;
import com.deliveryhero.customerchat.telephony.util.dispatcher.Dispatcher;
import com.deliveryhero.repository.gccchat.ConfigRelay;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ_\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u001023\u0010\u0012\u001a/\b\u0001\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0018J(\u0010\u0019\u001a\u0004\u0018\u00010\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011H\u0002J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\b\u0010\u001f\u001a\u00020\rH\u0002J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/deliveryhero/chatui/domain/call/usecase/CallStatusUseCase;", "", "configRelay", "Lcom/deliveryhero/repository/gccchat/ConfigRelay;", "dispatcher", "Lcom/deliveryhero/customerchat/telephony/util/dispatcher/Dispatcher;", "featureFlagProvider", "Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;", "chatConfigProvider", "Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;", "(Lcom/deliveryhero/repository/gccchat/ConfigRelay;Lcom/deliveryhero/customerchat/telephony/util/dispatcher/Dispatcher;Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;)V", "getCallStatus", "Lkotlinx/coroutines/flow/Flow;", "Lcom/deliveryhero/chatui/domain/call/CallStatus;", "getConfigStatus", "config", "Lkotlin/Pair;", "", "mapper", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "number", "Lkotlin/coroutines/Continuation;", "(Lkotlin/Pair;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "getNumber", "configs", "", "Lcom/deliveryhero/contract/model/ConfigMessage$Config;", "key", "mapMaskedToStatus", "mapNormalStatus", "mapTokuStatus", "phoneCallingType", "Lcom/deliveryhero/contract/model/PhoneCallType$Toku;", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CallStatusUseCase {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final Pair<String, String> MASKED_CONFIG = new Pair<>(NotificationCompat.CATEGORY_CALL, "phone");
    @NotNull
    private static final Pair<String, String> TOKU_CONFIG = new Pair<>(CallStatus.VoipActive.TOKU_PROVIDER, "username");
    @NotNull
    private final ChatConfigProvider chatConfigProvider;
    @NotNull
    private final ConfigRelay configRelay;
    @NotNull
    private final Dispatcher dispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final FeatureFlagProvider featureFlagProvider;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/chatui/domain/call/usecase/CallStatusUseCase$Companion;", "", "()V", "MASKED_CONFIG", "Lkotlin/Pair;", "", "TOKU_CONFIG", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CallStatusUseCase(@NotNull ConfigRelay configRelay2, @NotNull Dispatcher dispatcher2, @NotNull FeatureFlagProvider featureFlagProvider2, @NotNull ChatConfigProvider chatConfigProvider2) {
        Intrinsics.checkNotNullParameter(configRelay2, "configRelay");
        Intrinsics.checkNotNullParameter(dispatcher2, "dispatcher");
        Intrinsics.checkNotNullParameter(featureFlagProvider2, "featureFlagProvider");
        Intrinsics.checkNotNullParameter(chatConfigProvider2, "chatConfigProvider");
        this.configRelay = configRelay2;
        this.dispatcher = dispatcher2;
        this.featureFlagProvider = featureFlagProvider2;
        this.chatConfigProvider = chatConfigProvider2;
    }

    private final Flow<CallStatus> getConfigStatus(Pair<String, String> pair, Function2<? super String, ? super Continuation<? super CallStatus>, ? extends Object> function2) {
        return FlowKt.flowOn(FlowKt.m7822catch(new CallStatusUseCase$getConfigStatus$$inlined$map$1(this.configRelay.configStream(), function2, this, pair), new CallStatusUseCase$getConfigStatus$2((Continuation<? super CallStatusUseCase$getConfigStatus$2>) null)), this.dispatcher.io());
    }

    /* access modifiers changed from: private */
    public final String getNumber(List<ConfigMessage.Config> list, String str, String str2) {
        Object obj;
        Map<String, String> data;
        boolean z11;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ConfigMessage.Config config = (ConfigMessage.Config) obj;
            boolean z12 = false;
            if (Intrinsics.areEqual((Object) config.getName(), (Object) str)) {
                String str3 = config.getData().get(str2);
                if (str3 == null || !(!StringsKt__StringsJVMKt.isBlank(str3))) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (z11) {
                    z12 = true;
                    continue;
                } else {
                    continue;
                }
            }
            if (z12) {
                break;
            }
        }
        ConfigMessage.Config config2 = (ConfigMessage.Config) obj;
        if (config2 == null || (data = config2.getData()) == null) {
            return null;
        }
        return data.get(str2);
    }

    /* access modifiers changed from: private */
    public final Flow<CallStatus> mapMaskedToStatus() {
        return getConfigStatus(MASKED_CONFIG, new CallStatusUseCase$mapMaskedToStatus$1((Continuation<? super CallStatusUseCase$mapMaskedToStatus$1>) null));
    }

    /* access modifiers changed from: private */
    public final CallStatus mapNormalStatus() {
        DeliveryInfo deliveryInfo;
        String phoneNumber;
        ChatConfiguration chatConfiguration = this.chatConfigProvider.getChatConfiguration();
        if (!(chatConfiguration == null || (deliveryInfo = chatConfiguration.getDeliveryInfo()) == null || (phoneNumber = deliveryInfo.getPhoneNumber()) == null)) {
            if (!(!StringsKt__StringsJVMKt.isBlank(phoneNumber))) {
                phoneNumber = null;
            }
            if (phoneNumber != null) {
                return new CallStatus.Active(phoneNumber);
            }
        }
        return CallStatus.Pending.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Flow<CallStatus> mapTokuStatus(PhoneCallType.Toku toku) {
        return FlowKt.onStart(getConfigStatus(TOKU_CONFIG, new CallStatusUseCase$mapTokuStatus$1(toku, (Continuation<? super CallStatusUseCase$mapTokuStatus$1>) null)), new CallStatusUseCase$mapTokuStatus$2((Continuation<? super CallStatusUseCase$mapTokuStatus$2>) null));
    }

    @NotNull
    public final Flow<CallStatus> getCallStatus() {
        return FlowKt.flow(new CallStatusUseCase$getCallStatus$1(this, (Continuation<? super CallStatusUseCase$getCallStatus$1>) null));
    }
}
