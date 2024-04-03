package com.deliveryhero.customerchat.fwf;

import android.os.Build;
import com.deliveryhero.contract.ChatLogger;
import com.deliveryhero.contract.configuration.ChatConfiguration;
import com.deliveryhero.contract.model.Events;
import com.deliveryhero.customerchat.configuration.ChatConfigProvider;
import com.deliveryhero.customerchat.eventTracking.utils.DeviceUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0011\u0010\u001b\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ!\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010 J!\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010 J\n\u0010#\u001a\u0004\u0018\u00010\u001fH\u0002J\u0011\u0010$\u001a\u00020%H@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0013\u0010&\u001a\u0004\u0018\u00010\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u001cR\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider;", "", "configProvider", "Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;", "fwfService", "Lcom/deliveryhero/customerchat/fwf/FWFService;", "deviceUtils", "Lcom/deliveryhero/customerchat/eventTracking/utils/DeviceUtils;", "isVoipSDKEnabled", "", "chatLogger", "Lcom/deliveryhero/contract/ChatLogger;", "(Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;Lcom/deliveryhero/customerchat/fwf/FWFService;Lcom/deliveryhero/customerchat/eventTracking/utils/DeviceUtils;ZLcom/deliveryhero/contract/ChatLogger;)V", "channelFeatureFlags", "Lkotlinx/coroutines/Deferred;", "Lcom/deliveryhero/customerchat/fwf/ChannelFeatureFlags;", "chatConfig", "Lcom/deliveryhero/contract/configuration/ChatConfiguration;", "getChatConfig", "()Lcom/deliveryhero/contract/configuration/ChatConfiguration;", "userFeatureFlags", "Lcom/deliveryhero/customerchat/fwf/UserFeatureFlags;", "determineChannelFeatures", "", "channelId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "determineUserFeatures", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchChannelFeatureFlags", "customAttributes", "Lcom/deliveryhero/customerchat/fwf/Custom;", "(Ljava/lang/String;Lcom/deliveryhero/customerchat/fwf/Custom;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchUserFeatureFlags", "userId", "getCustomAttributes", "getPhoneCallingType", "Lcom/deliveryhero/contract/model/PhoneCallType;", "getUserFeatureFlags", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeatureFlagProvider {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String DISABLE_CHAT_ON_CHANNEL_FROZEN = "disable-chat-on-channel-frozen";
    @NotNull
    public static final String EVENT_TRACKING_FEATURE_KEY = "ets-tracking";
    @NotNull
    public static final String HIDE_ADMIN_MESSAGES_FEATURE_KEY = "hide-admin-messages";
    @NotNull
    public static final String IMAGE_SHARING_FEATURE_FLAG = "image-sharing";
    @NotNull
    public static final String LOCATION_SHARING_FEATURE_KEY = "location-sharing";
    @NotNull
    private static final String PLATFORM_NAME_ANDROID = "Android";
    @NotNull
    public static final String SHOW_SENDER_NAME_FEATURE_KEY = "show-sender-name-key";
    @NotNull
    public static final String VOIP_CALLING_FEATURE_KEY = "voip-calling";
    @NotNull
    public static final String VOIP_CALL_SURVEY_ENABLED = "voip-call-survey";
    @NotNull
    public static final String VOIP_SDK_CACHE_CLEARING_ENABLED = "voip-sdk-cache-clearing-enabled";
    /* access modifiers changed from: private */
    @Nullable
    public Deferred<ChannelFeatureFlags> channelFeatureFlags;
    /* access modifiers changed from: private */
    @Nullable
    public final ChatLogger chatLogger;
    @NotNull
    private final ChatConfigProvider configProvider;
    @NotNull
    private final DeviceUtils deviceUtils;
    @NotNull
    private final FWFService fwfService;
    /* access modifiers changed from: private */
    public final boolean isVoipSDKEnabled;
    /* access modifiers changed from: private */
    @Nullable
    public Deferred<UserFeatureFlags> userFeatureFlags;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/customerchat/fwf/FeatureFlagProvider$Companion;", "", "()V", "DISABLE_CHAT_ON_CHANNEL_FROZEN", "", "EVENT_TRACKING_FEATURE_KEY", "HIDE_ADMIN_MESSAGES_FEATURE_KEY", "IMAGE_SHARING_FEATURE_FLAG", "LOCATION_SHARING_FEATURE_KEY", "PLATFORM_NAME_ANDROID", "SHOW_SENDER_NAME_FEATURE_KEY", "VOIP_CALLING_FEATURE_KEY", "VOIP_CALL_SURVEY_ENABLED", "VOIP_SDK_CACHE_CLEARING_ENABLED", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FeatureFlagProvider(@NotNull ChatConfigProvider chatConfigProvider, @NotNull FWFService fWFService, @NotNull DeviceUtils deviceUtils2, boolean z11, @Nullable ChatLogger chatLogger2) {
        Intrinsics.checkNotNullParameter(chatConfigProvider, "configProvider");
        Intrinsics.checkNotNullParameter(fWFService, "fwfService");
        Intrinsics.checkNotNullParameter(deviceUtils2, "deviceUtils");
        this.configProvider = chatConfigProvider;
        this.fwfService = fWFService;
        this.deviceUtils = deviceUtils2;
        this.isVoipSDKEnabled = z11;
        this.chatLogger = chatLogger2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058 A[Catch:{ IOException -> 0x0068, HttpException -> 0x0062 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d A[Catch:{ IOException -> 0x0068, HttpException -> 0x0062 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetchChannelFeatureFlags(java.lang.String r9, com.deliveryhero.customerchat.fwf.Custom r10, kotlin.coroutines.Continuation<? super com.deliveryhero.customerchat.fwf.ChannelFeatureFlags> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.deliveryhero.customerchat.fwf.FeatureFlagProvider$fetchChannelFeatureFlags$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.deliveryhero.customerchat.fwf.FeatureFlagProvider$fetchChannelFeatureFlags$1 r0 = (com.deliveryhero.customerchat.fwf.FeatureFlagProvider$fetchChannelFeatureFlags$1) r0
            int r1 = r0.f29997j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f29997j = r1
            goto L_0x0018
        L_0x0013:
            com.deliveryhero.customerchat.fwf.FeatureFlagProvider$fetchChannelFeatureFlags$1 r0 = new com.deliveryhero.customerchat.fwf.FeatureFlagProvider$fetchChannelFeatureFlags$1
            r0.<init>(r8, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f29995h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f29997j
            java.lang.String r3 = "voip-calling"
            r4 = 0
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r6) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ IOException -> 0x0068, HttpException -> 0x0062 }
            goto L_0x004c
        L_0x002d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r11)
            com.deliveryhero.customerchat.fwf.FWFService r11 = r8.fwfService     // Catch:{ IOException -> 0x0068, HttpException -> 0x0062 }
            com.deliveryhero.customerchat.fwf.FWFRequest r2 = new com.deliveryhero.customerchat.fwf.FWFRequest     // Catch:{ IOException -> 0x0068, HttpException -> 0x0062 }
            java.util.List r7 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r3)     // Catch:{ IOException -> 0x0068, HttpException -> 0x0062 }
            r2.<init>(r10, r7, r9)     // Catch:{ IOException -> 0x0068, HttpException -> 0x0062 }
            r0.f29997j = r6     // Catch:{ IOException -> 0x0068, HttpException -> 0x0062 }
            java.lang.Object r11 = r11.getFeatureFlags(r2, r0)     // Catch:{ IOException -> 0x0068, HttpException -> 0x0062 }
            if (r11 != r1) goto L_0x004c
            return r1
        L_0x004c:
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ IOException -> 0x0068, HttpException -> 0x0062 }
            com.deliveryhero.customerchat.fwf.ChannelFeatureFlags r9 = new com.deliveryhero.customerchat.fwf.ChannelFeatureFlags     // Catch:{ IOException -> 0x0068, HttpException -> 0x0062 }
            java.lang.Object r10 = r11.get(r3)     // Catch:{ IOException -> 0x0068, HttpException -> 0x0062 }
            com.deliveryhero.customerchat.fwf.FeatureInfo r10 = (com.deliveryhero.customerchat.fwf.FeatureInfo) r10     // Catch:{ IOException -> 0x0068, HttpException -> 0x0062 }
            if (r10 == 0) goto L_0x005d
            boolean r10 = r10.getVariation()     // Catch:{ IOException -> 0x0068, HttpException -> 0x0062 }
            goto L_0x005e
        L_0x005d:
            r10 = r5
        L_0x005e:
            r9.<init>(r10)     // Catch:{ IOException -> 0x0068, HttpException -> 0x0062 }
            goto L_0x006d
        L_0x0062:
            com.deliveryhero.customerchat.fwf.ChannelFeatureFlags r9 = new com.deliveryhero.customerchat.fwf.ChannelFeatureFlags
            r9.<init>(r5, r6, r4)
            goto L_0x006d
        L_0x0068:
            com.deliveryhero.customerchat.fwf.ChannelFeatureFlags r9 = new com.deliveryhero.customerchat.fwf.ChannelFeatureFlags
            r9.<init>(r5, r6, r4)
        L_0x006d:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.fwf.FeatureFlagProvider.fetchChannelFeatureFlags(java.lang.String, com.deliveryhero.customerchat.fwf.Custom, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0073 A[Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0079 A[Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0084 A[Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008a A[Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0095 A[Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009b A[Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a6 A[Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ac A[Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b7 A[Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bd A[Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c8 A[Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ce A[Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d9 A[Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00df A[Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ea A[Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ef A[Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetchUserFeatureFlags(java.lang.String r35, com.deliveryhero.customerchat.fwf.Custom r36, kotlin.coroutines.Continuation<? super com.deliveryhero.customerchat.fwf.UserFeatureFlags> r37) {
        /*
            r34 = this;
            r0 = r34
            r1 = r37
            boolean r2 = r1 instanceof com.deliveryhero.customerchat.fwf.FeatureFlagProvider$fetchUserFeatureFlags$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.deliveryhero.customerchat.fwf.FeatureFlagProvider$fetchUserFeatureFlags$1 r2 = (com.deliveryhero.customerchat.fwf.FeatureFlagProvider$fetchUserFeatureFlags$1) r2
            int r3 = r2.f30000j
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f30000j = r3
            goto L_0x001c
        L_0x0017:
            com.deliveryhero.customerchat.fwf.FeatureFlagProvider$fetchUserFeatureFlags$1 r2 = new com.deliveryhero.customerchat.fwf.FeatureFlagProvider$fetchUserFeatureFlags$1
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f29998h
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.f30000j
            r5 = 1
            if (r4 == 0) goto L_0x0035
            if (r4 != r5) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r1)     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            goto L_0x0064
        L_0x002d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r1)
            com.deliveryhero.customerchat.fwf.FWFService r1 = r0.fwfService     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            com.deliveryhero.customerchat.fwf.FWFRequest r4 = new com.deliveryhero.customerchat.fwf.FWFRequest     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            java.lang.String r6 = "image-sharing"
            java.lang.String r7 = "location-sharing"
            java.lang.String r8 = "ets-tracking"
            java.lang.String r9 = "voip-sdk-cache-clearing-enabled"
            java.lang.String r10 = "voip-call-survey"
            java.lang.String r11 = "show-sender-name-key"
            java.lang.String r12 = "hide-admin-messages"
            java.lang.String r13 = "disable-chat-on-channel-frozen"
            java.lang.String[] r6 = new java.lang.String[]{r6, r7, r8, r9, r10, r11, r12, r13}     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            java.util.List r6 = kotlin.collections.CollectionsKt__CollectionsKt.listOf(r6)     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            r7 = r35
            r8 = r36
            r4.<init>(r8, r6, r7)     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            r2.f30000j = r5     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            java.lang.Object r1 = r1.getFeatureFlags(r4, r2)     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            if (r1 != r3) goto L_0x0064
            return r3
        L_0x0064:
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            com.deliveryhero.customerchat.fwf.UserFeatureFlags r11 = new com.deliveryhero.customerchat.fwf.UserFeatureFlags     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            java.lang.String r2 = "image-sharing"
            java.lang.Object r2 = r1.get(r2)     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            com.deliveryhero.customerchat.fwf.FeatureInfo r2 = (com.deliveryhero.customerchat.fwf.FeatureInfo) r2     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            r3 = 0
            if (r2 == 0) goto L_0x0079
            boolean r2 = r2.getVariation()     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            r4 = r2
            goto L_0x007a
        L_0x0079:
            r4 = r3
        L_0x007a:
            java.lang.String r2 = "location-sharing"
            java.lang.Object r2 = r1.get(r2)     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            com.deliveryhero.customerchat.fwf.FeatureInfo r2 = (com.deliveryhero.customerchat.fwf.FeatureInfo) r2     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            if (r2 == 0) goto L_0x008a
            boolean r2 = r2.getVariation()     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            r5 = r2
            goto L_0x008b
        L_0x008a:
            r5 = r3
        L_0x008b:
            java.lang.String r2 = "ets-tracking"
            java.lang.Object r2 = r1.get(r2)     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            com.deliveryhero.customerchat.fwf.FeatureInfo r2 = (com.deliveryhero.customerchat.fwf.FeatureInfo) r2     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            if (r2 == 0) goto L_0x009b
            boolean r2 = r2.getVariation()     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            r6 = r2
            goto L_0x009c
        L_0x009b:
            r6 = r3
        L_0x009c:
            java.lang.String r2 = "voip-sdk-cache-clearing-enabled"
            java.lang.Object r2 = r1.get(r2)     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            com.deliveryhero.customerchat.fwf.FeatureInfo r2 = (com.deliveryhero.customerchat.fwf.FeatureInfo) r2     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            if (r2 == 0) goto L_0x00ac
            boolean r2 = r2.getVariation()     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            r7 = r2
            goto L_0x00ad
        L_0x00ac:
            r7 = r3
        L_0x00ad:
            java.lang.String r2 = "voip-call-survey"
            java.lang.Object r2 = r1.get(r2)     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            com.deliveryhero.customerchat.fwf.FeatureInfo r2 = (com.deliveryhero.customerchat.fwf.FeatureInfo) r2     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            if (r2 == 0) goto L_0x00bd
            boolean r2 = r2.getVariation()     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            r8 = r2
            goto L_0x00be
        L_0x00bd:
            r8 = r3
        L_0x00be:
            java.lang.String r2 = "show-sender-name-key"
            java.lang.Object r2 = r1.get(r2)     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            com.deliveryhero.customerchat.fwf.FeatureInfo r2 = (com.deliveryhero.customerchat.fwf.FeatureInfo) r2     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            if (r2 == 0) goto L_0x00ce
            boolean r2 = r2.getVariation()     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            r9 = r2
            goto L_0x00cf
        L_0x00ce:
            r9 = r3
        L_0x00cf:
            java.lang.String r2 = "hide-admin-messages"
            java.lang.Object r2 = r1.get(r2)     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            com.deliveryhero.customerchat.fwf.FeatureInfo r2 = (com.deliveryhero.customerchat.fwf.FeatureInfo) r2     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            if (r2 == 0) goto L_0x00df
            boolean r2 = r2.getVariation()     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            r10 = r2
            goto L_0x00e0
        L_0x00df:
            r10 = r3
        L_0x00e0:
            java.lang.String r2 = "disable-chat-on-channel-frozen"
            java.lang.Object r1 = r1.get(r2)     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            com.deliveryhero.customerchat.fwf.FeatureInfo r1 = (com.deliveryhero.customerchat.fwf.FeatureInfo) r1     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            if (r1 == 0) goto L_0x00ef
            boolean r1 = r1.getVariation()     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            goto L_0x00f0
        L_0x00ef:
            r1 = r3
        L_0x00f0:
            r2 = r11
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ IOException -> 0x0115, HttpException -> 0x00fd }
            goto L_0x0130
        L_0x00fd:
            com.deliveryhero.customerchat.fwf.UserFeatureFlags r11 = new com.deliveryhero.customerchat.fwf.UserFeatureFlags
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 255(0xff, float:3.57E-43)
            r22 = 0
            r12 = r11
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            goto L_0x0130
        L_0x0115:
            com.deliveryhero.customerchat.fwf.UserFeatureFlags r11 = new com.deliveryhero.customerchat.fwf.UserFeatureFlags
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 255(0xff, float:3.57E-43)
            r33 = 0
            r23 = r11
            r23.<init>(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
        L_0x0130:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.fwf.FeatureFlagProvider.fetchUserFeatureFlags(java.lang.String, com.deliveryhero.customerchat.fwf.Custom, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final ChatConfiguration getChatConfig() {
        return this.configProvider.getChatConfiguration();
    }

    /* access modifiers changed from: private */
    public final Custom getCustomAttributes() {
        ChatConfiguration chatConfig = getChatConfig();
        if (chatConfig == null) {
            ChatLogger chatLogger2 = this.chatLogger;
            if (chatLogger2 == null) {
                return null;
            }
            chatLogger2.log(Events.GCC_FWF_NOT_READY, MapsKt__MapsJVMKt.mapOf(TuplesKt.to("EVENT", Events.GCC_CHAT_CONFIGURATION_NOT_READY)));
            return null;
        }
        String id2 = chatConfig.getUserInfo().getId();
        String valueOf = String.valueOf(Build.VERSION.SDK_INT);
        String name2 = chatConfig.getClientConfig().getUserType().name();
        Locale locale = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
        String lowerCase = name2.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return new Custom(id2, chatConfig.getClientConfig().getGlobalEntityID(), chatConfig.getClientConfig().getCountry(), lowerCase, valueOf, "Android", this.deviceUtils.getHostAppVersion(), this.deviceUtils.getHostAppIdentifier());
    }

    @Nullable
    public final Object determineChannelFeatures(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new FeatureFlagProvider$determineChannelFeatures$2(this, str, (Continuation<? super FeatureFlagProvider$determineChannelFeatures$2>) null), continuation);
        return coroutineScope == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    @Nullable
    public final Object determineUserFeatures(@NotNull Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new FeatureFlagProvider$determineUserFeatures$2(this, (Continuation<? super FeatureFlagProvider$determineUserFeatures$2>) null), continuation);
        return coroutineScope == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0051 A[Catch:{ CancellationException -> 0x0058 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getPhoneCallingType(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.deliveryhero.contract.model.PhoneCallType> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.deliveryhero.customerchat.fwf.FeatureFlagProvider$getPhoneCallingType$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.deliveryhero.customerchat.fwf.FeatureFlagProvider$getPhoneCallingType$1 r0 = (com.deliveryhero.customerchat.fwf.FeatureFlagProvider$getPhoneCallingType$1) r0
            int r1 = r0.f30004k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f30004k = r1
            goto L_0x0018
        L_0x0013:
            com.deliveryhero.customerchat.fwf.FeatureFlagProvider$getPhoneCallingType$1 r0 = new com.deliveryhero.customerchat.fwf.FeatureFlagProvider$getPhoneCallingType$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f30002i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f30004k
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.f30001h
            com.deliveryhero.customerchat.fwf.FeatureFlagProvider r0 = (com.deliveryhero.customerchat.fwf.FeatureFlagProvider) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ CancellationException -> 0x0058 }
            goto L_0x004d
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5.isVoipSDKEnabled     // Catch:{ CancellationException -> 0x0057 }
            if (r6 == 0) goto L_0x0057
            kotlinx.coroutines.Deferred<com.deliveryhero.customerchat.fwf.ChannelFeatureFlags> r6 = r5.channelFeatureFlags     // Catch:{ CancellationException -> 0x0057 }
            if (r6 == 0) goto L_0x0057
            r0.f30001h = r5     // Catch:{ CancellationException -> 0x0057 }
            r0.f30004k = r3     // Catch:{ CancellationException -> 0x0057 }
            java.lang.Object r6 = r6.await(r0)     // Catch:{ CancellationException -> 0x0057 }
            if (r6 != r1) goto L_0x004c
            return r1
        L_0x004c:
            r0 = r5
        L_0x004d:
            com.deliveryhero.customerchat.fwf.ChannelFeatureFlags r6 = (com.deliveryhero.customerchat.fwf.ChannelFeatureFlags) r6     // Catch:{ CancellationException -> 0x0058 }
            if (r6 == 0) goto L_0x0058
            boolean r6 = r6.isVoipEnabled()     // Catch:{ CancellationException -> 0x0058 }
            r4 = r6
            goto L_0x0058
        L_0x0057:
            r0 = r5
        L_0x0058:
            com.deliveryhero.contract.configuration.ChatConfiguration r6 = r0.getChatConfig()
            if (r6 != 0) goto L_0x0061
            com.deliveryhero.contract.model.PhoneCallType$None r6 = com.deliveryhero.contract.model.PhoneCallType.None.INSTANCE
            return r6
        L_0x0061:
            com.deliveryhero.contract.model.PhoneCallType r0 = r6.getPhoneCallingType()
            boolean r0 = r0 instanceof com.deliveryhero.contract.model.PhoneCallType.Toku
            if (r0 == 0) goto L_0x006e
            if (r4 != 0) goto L_0x006e
            com.deliveryhero.contract.model.PhoneCallType$None r6 = com.deliveryhero.contract.model.PhoneCallType.None.INSTANCE
            goto L_0x0072
        L_0x006e:
            com.deliveryhero.contract.model.PhoneCallType r6 = r6.getPhoneCallingType()
        L_0x0072:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.fwf.FeatureFlagProvider.getPhoneCallingType(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getUserFeatureFlags(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.deliveryhero.customerchat.fwf.UserFeatureFlags> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.deliveryhero.customerchat.fwf.FeatureFlagProvider$getUserFeatureFlags$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.deliveryhero.customerchat.fwf.FeatureFlagProvider$getUserFeatureFlags$1 r0 = (com.deliveryhero.customerchat.fwf.FeatureFlagProvider$getUserFeatureFlags$1) r0
            int r1 = r0.f30007j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f30007j = r1
            goto L_0x0018
        L_0x0013:
            com.deliveryhero.customerchat.fwf.FeatureFlagProvider$getUserFeatureFlags$1 r0 = new com.deliveryhero.customerchat.fwf.FeatureFlagProvider$getUserFeatureFlags$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f30005h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f30007j
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r4) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ CancellationException -> 0x0045 }
            goto L_0x0042
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.Deferred<com.deliveryhero.customerchat.fwf.UserFeatureFlags> r6 = r5.userFeatureFlags     // Catch:{ CancellationException -> 0x0045 }
            if (r6 == 0) goto L_0x0045
            r0.f30007j = r4     // Catch:{ CancellationException -> 0x0045 }
            java.lang.Object r6 = r6.await(r0)     // Catch:{ CancellationException -> 0x0045 }
            if (r6 != r1) goto L_0x0042
            return r1
        L_0x0042:
            com.deliveryhero.customerchat.fwf.UserFeatureFlags r6 = (com.deliveryhero.customerchat.fwf.UserFeatureFlags) r6     // Catch:{ CancellationException -> 0x0045 }
            r3 = r6
        L_0x0045:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.fwf.FeatureFlagProvider.getUserFeatureFlags(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
