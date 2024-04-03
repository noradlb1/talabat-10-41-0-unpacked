package com.appboy.models.push;

import android.content.Context;
import android.os.Bundle;
import androidx.core.app.Person;
import androidx.core.view.GravityCompat;
import com.braze.Constants;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.support.BrazeLogger;
import com.braze.support.BundleUtils;
import com.braze.support.JsonUtils;
import com.talabat.feature.rewards.presentation.mission.details.MissionDetailsDialogFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u0000 £\u00012\u00020\u0001:\n¢\u0001£\u0001¤\u0001¥\u0001¦\u0001B5\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u0016\u0010\u0001\u001a\u00030\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017J\u0010\u0010\u0001\u001a\u00030\u00012\u0006\u0010Y\u001a\u00020UJ\u0018\u0010 \u0001\u001a\u00030\u00012\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u0017J\t\u0010¡\u0001\u001a\u00020\u0019H\u0016R \u0010\n\u001a\u0004\u0018\u00010\u000b8GX\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001c\u0010!\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001b\"\u0004\b.\u0010\u001dR\u001c\u0010/\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001b\"\u0004\b1\u0010\u001dR\u001c\u00102\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001b\"\u0004\b4\u0010\u001dR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00128F¢\u0006\u0006\u001a\u0004\b;\u0010\u0015R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020:0\u0017X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010=\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020?0>8F¢\u0006\u0006\u001a\u0004\b@\u0010AR\u001c\u0010B\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020?0CX\u0004¢\u0006\u0002\n\u0000R\"\u0010E\u001a\u0004\u0018\u00010\u00192\b\u0010D\u001a\u0004\u0018\u00010\u0019@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u001bR\u001c\u0010G\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u001b\"\u0004\bI\u0010\u001dR\u001e\u0010J\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\bK\u0010\r\"\u0004\bL\u0010\u000fR\u001c\u0010M\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u001b\"\u0004\bO\u0010\u001dR&\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010A\"\u0004\bR\u0010SR\u001a\u0010T\u001a\u00020UX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010V\"\u0004\bW\u0010XR\u001a\u0010Y\u001a\u00020UX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010V\"\u0004\bZ\u0010XR\u001a\u0010[\u001a\u00020UX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010V\"\u0004\b\\\u0010XR\u001a\u0010]\u001a\u00020UX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010V\"\u0004\b^\u0010XR\u001a\u0010_\u001a\u00020UX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010V\"\u0004\b`\u0010XR\u001c\u0010a\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u001b\"\u0004\bc\u0010\u001dR\u001e\u0010d\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\be\u0010\r\"\u0004\bf\u0010\u000fR\u001c\u0010g\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u001b\"\u0004\bi\u0010\u001dR\u001c\u0010j\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u001b\"\u0004\bl\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bm\u0010%R\u001e\u0010n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\bo\u0010\r\"\u0004\bp\u0010\u000fR\u001e\u0010q\u001a\u0004\u0018\u00010rX\u000e¢\u0006\u0010\n\u0002\u0010w\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u001c\u0010x\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u001b\"\u0004\bz\u0010\u001dR\u001e\u0010{\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b|\u0010\r\"\u0004\b}\u0010\u000fR\u001d\u0010~\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u0010\u001b\"\u0005\b\u0001\u0010\u001dR!\u0010\u0001\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0012\n\u0002\u0010\u0010\u001a\u0005\b\u0001\u0010\r\"\u0005\b\u0001\u0010\u000fR\u001f\u0010\u0001\u001a\u00020\u000bX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u00128F¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u0015R\u0016\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0001\u001a\u00020UX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010V\"\u0005\b\u0001\u0010XR\u001d\u0010\u0001\u001a\u00020UX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010V\"\u0005\b\u0001\u0010XR\u001d\u0010\u0001\u001a\u00020UX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010V\"\u0005\b\u0001\u0010XR\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001b\"\u0005\b\u0001\u0010\u001dR\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001b\"\u0005\b\u0001\u0010\u001d¨\u0006§\u0001"}, d2 = {"Lcom/appboy/models/push/BrazeNotificationPayload;", "", "notificationExtras", "Landroid/os/Bundle;", "brazeExtras", "context", "Landroid/content/Context;", "configurationProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "(Landroid/os/Bundle;Landroid/os/Bundle;Landroid/content/Context;Lcom/braze/configuration/BrazeConfigurationProvider;)V", "accentColor", "", "getAccentColor", "()Ljava/lang/Integer;", "setAccentColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "actionButtons", "", "Lcom/appboy/models/push/BrazeNotificationPayload$ActionButton;", "getActionButtons", "()Ljava/util/List;", "actionButtonsInternal", "", "bigImageUrl", "", "getBigImageUrl", "()Ljava/lang/String;", "setBigImageUrl", "(Ljava/lang/String;)V", "bigSummaryText", "getBigSummaryText", "setBigSummaryText", "bigTitleText", "getBigTitleText", "setBigTitleText", "getBrazeExtras", "()Landroid/os/Bundle;", "setBrazeExtras", "(Landroid/os/Bundle;)V", "getConfigurationProvider", "()Lcom/braze/configuration/BrazeConfigurationProvider;", "setConfigurationProvider", "(Lcom/braze/configuration/BrazeConfigurationProvider;)V", "contentCardSyncData", "getContentCardSyncData", "setContentCardSyncData", "contentCardSyncUserId", "getContentCardSyncUserId", "setContentCardSyncUserId", "contentText", "getContentText", "setContentText", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "conversationMessages", "Lcom/appboy/models/push/BrazeNotificationPayload$ConversationMessage;", "getConversationMessages", "conversationMessagesInternal", "conversationPersonMap", "", "Lcom/appboy/models/push/BrazeNotificationPayload$ConversationPerson;", "getConversationPersonMap", "()Ljava/util/Map;", "conversationPersonMapInternal", "", "<set-?>", "conversationReplyPersonId", "getConversationReplyPersonId", "conversationShortcutId", "getConversationShortcutId", "setConversationShortcutId", "customNotificationId", "getCustomNotificationId", "setCustomNotificationId", "deeplink", "getDeeplink", "setDeeplink", "extras", "getExtras", "setExtras", "(Ljava/util/Map;)V", "isConversationalPush", "", "()Z", "setConversationalPush", "(Z)V", "isInlineImagePush", "setInlineImagePush", "isNewlyReceivedPushStory", "setNewlyReceivedPushStory", "isPushStory", "setPushStory", "isUninstallTrackingPush", "setUninstallTrackingPush", "largeIcon", "getLargeIcon", "setLargeIcon", "notificationBadgeNumber", "getNotificationBadgeNumber", "setNotificationBadgeNumber", "notificationCategory", "getNotificationCategory", "setNotificationCategory", "notificationChannelId", "getNotificationChannelId", "setNotificationChannelId", "getNotificationExtras", "notificationPriorityInt", "getNotificationPriorityInt", "setNotificationPriorityInt", "notificationReceivedTimestampMillis", "", "getNotificationReceivedTimestampMillis", "()Ljava/lang/Long;", "setNotificationReceivedTimestampMillis", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "notificationSound", "getNotificationSound", "setNotificationSound", "notificationVisibility", "getNotificationVisibility", "setNotificationVisibility", "publicNotificationExtras", "getPublicNotificationExtras", "setPublicNotificationExtras", "pushDuration", "getPushDuration", "setPushDuration", "pushStoryPageIndex", "getPushStoryPageIndex", "()I", "setPushStoryPageIndex", "(I)V", "pushStoryPages", "Lcom/appboy/models/push/BrazeNotificationPayload$PushStoryPage;", "getPushStoryPages", "pushStoryPagesInternal", "shouldFetchTestTriggers", "getShouldFetchTestTriggers", "setShouldFetchTestTriggers", "shouldRefreshFeatureFlags", "getShouldRefreshFeatureFlags", "setShouldRefreshFeatureFlags", "shouldSyncGeofences", "getShouldSyncGeofences", "setShouldSyncGeofences", "summaryText", "getSummaryText", "setSummaryText", "titleText", "getTitleText", "setTitleText", "parsePayloadFieldsFromBundle", "", "setActionButtons", "setIsInlineImagePush", "setPushStoryPages", "toString", "ActionButton", "Companion", "ConversationMessage", "ConversationPerson", "PushStoryPage", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BrazeNotificationPayload {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Integer accentColor;
    private List<ActionButton> actionButtonsInternal;
    private String bigImageUrl;
    private String bigSummaryText;
    private String bigTitleText;
    private Bundle brazeExtras;
    private BrazeConfigurationProvider configurationProvider;
    private String contentCardSyncData;
    private String contentCardSyncUserId;
    private String contentText;
    private Context context;
    private final List<ConversationMessage> conversationMessagesInternal;
    private final Map<String, ConversationPerson> conversationPersonMapInternal;
    private String conversationReplyPersonId;
    private String conversationShortcutId;
    private Integer customNotificationId;
    private String deeplink;
    private Map<String, String> extras;
    private boolean isConversationalPush;
    private boolean isInlineImagePush;
    private boolean isNewlyReceivedPushStory;
    private boolean isPushStory;
    private boolean isUninstallTrackingPush;
    private String largeIcon;
    private Integer notificationBadgeNumber;
    private String notificationCategory;
    private String notificationChannelId;
    private final Bundle notificationExtras;
    private Integer notificationPriorityInt;
    private Long notificationReceivedTimestampMillis;
    private String notificationSound;
    private Integer notificationVisibility;
    private String publicNotificationExtras;
    private Integer pushDuration;
    private int pushStoryPageIndex;
    private List<PushStoryPage> pushStoryPagesInternal;
    private boolean shouldFetchTestTriggers;
    private boolean shouldRefreshFeatureFlags;
    private boolean shouldSyncGeofences;
    private String summaryText;
    private String titleText;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003J\b\u0010 \u001a\u00020\bH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\n\"\u0004\b\u0019\u0010\fR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\f¨\u0006!"}, d2 = {"Lcom/appboy/models/push/BrazeNotificationPayload$ActionButton;", "", "notificationExtras", "Landroid/os/Bundle;", "actionIndex", "", "(Landroid/os/Bundle;I)V", "actionId", "", "getActionId", "()Ljava/lang/String;", "setActionId", "(Ljava/lang/String;)V", "getActionIndex", "()I", "setActionIndex", "(I)V", "text", "getText", "setText", "type", "getType", "setType", "uri", "getUri", "setUri", "useWebview", "getUseWebview", "setUseWebview", "putIntoBundle", "", "destination", "toString", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ActionButton {
        private String actionId;
        private int actionIndex;
        private String text;
        private String type;
        private String uri;
        private String useWebview;

        public ActionButton(Bundle bundle, int i11) {
            Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
            this.actionIndex = i11;
            Companion companion = BrazeNotificationPayload.Companion;
            this.type = companion.getTemplateFieldAtIndex(i11, bundle, "ab_a*_a");
            this.actionId = companion.getTemplateFieldAtIndex(this.actionIndex, bundle, "ab_a*_id");
            this.uri = companion.getTemplateFieldAtIndex(this.actionIndex, bundle, "ab_a*_uri");
            this.useWebview = companion.getTemplateFieldAtIndex(this.actionIndex, bundle, "ab_a*_use_webview");
            this.text = companion.getTemplateFieldAtIndex(this.actionIndex, bundle, "ab_a*_t");
        }

        public final String getActionId() {
            return this.actionId;
        }

        public final int getActionIndex() {
            return this.actionIndex;
        }

        public final String getText() {
            return this.text;
        }

        public final String getType() {
            return this.type;
        }

        public final String getUri() {
            return this.uri;
        }

        public final String getUseWebview() {
            return this.useWebview;
        }

        public final void putIntoBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "destination");
            bundle.putInt("appboy_action_index", this.actionIndex);
            bundle.putString("appboy_action_type", this.type);
            bundle.putString("appboy_action_id", this.actionId);
            bundle.putString("appboy_action_uri", this.uri);
            bundle.putString("appboy_action_use_webview", this.useWebview);
        }

        public final void setActionId(String str) {
            this.actionId = str;
        }

        public final void setActionIndex(int i11) {
            this.actionIndex = i11;
        }

        public final void setText(String str) {
            this.text = str;
        }

        public final void setType(String str) {
            this.type = str;
        }

        public final void setUri(String str) {
            this.uri = str;
        }

        public final void setUseWebview(String str) {
            this.useWebview = str;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            Companion companion = BrazeNotificationPayload.Companion;
            sb2.append(companion.stringAndKey("ActionIndex", Integer.valueOf(this.actionIndex)));
            sb2.append(companion.stringAndKey("Type", this.type));
            sb2.append(companion.stringAndKey("Id", this.actionId));
            sb2.append(companion.stringAndKey("Uri", this.uri));
            sb2.append(companion.stringAndKey("UseWebview", this.useWebview));
            sb2.append(companion.stringAndKey(MissionDetailsDialogFragment.Section.Text.TYPE, this.text));
            return sb2.toString();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J(\u0010\f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J(\u0010\f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J,\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0007J\u001f\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0014J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH\u0007J \u0010\u0016\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0007J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH\u0007J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH\u0007J\u001f\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u001aJ\u001f\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u001aJ\u001f\u0010\u001c\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0014J\u001a\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0002¨\u0006 "}, d2 = {"Lcom/appboy/models/push/BrazeNotificationPayload$Companion;", "", "()V", "getAttachedAppboyExtras", "Landroid/os/Bundle;", "notificationExtras", "getAttachedBrazeExtras", "getPushStoryGravityAtIndex", "", "actionIndex", "actionFieldKeyTemplate", "", "getTemplateFieldAtIndex", "index", "", "defaultValue", "", "parseLong", "bundle", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Long;", "parseNonBlankString", "parseObjectAsInteger", "parseString", "parseStringAsBoolean", "parseStringAsColorInt", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Integer;", "parseStringAsInteger", "parseStringAsLong", "stringAndKey", "prefix", "value", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f40749b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to parse action field boolean. Returning default.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class b extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final b f40750b = new b();

            public b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to parse action field long. Returning default.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class c extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f40751b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Bundle f40752c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(String str, Bundle bundle) {
                super(0);
                this.f40751b = str;
                this.f40752c = bundle;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to parse long with key " + this.f40751b + " and bundle: " + this.f40752c;
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class d extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f40753b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Bundle f40754c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(String str, Bundle bundle) {
                super(0);
                this.f40753b = str;
                this.f40754c = bundle;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to parse non blank string with key " + this.f40753b + " and bundle: " + this.f40754c;
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class e extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f40755b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Bundle f40756c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public e(String str, Bundle bundle) {
                super(0);
                this.f40755b = str;
                this.f40756c = bundle;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to parse string as int with key " + this.f40755b + " and bundle: " + this.f40756c;
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class f extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f40757b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Bundle f40758c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public f(String str, Bundle bundle) {
                super(0);
                this.f40757b = str;
                this.f40758c = bundle;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to parse string with key " + this.f40757b + " and bundle: " + this.f40758c;
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class g extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f40759b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Bundle f40760c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public g(String str, Bundle bundle) {
                super(0);
                this.f40759b = str;
                this.f40760c = bundle;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to parse string as boolean with key " + this.f40759b + " and bundle: " + this.f40760c;
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class h extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f40761b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Bundle f40762c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public h(String str, Bundle bundle) {
                super(0);
                this.f40761b = str;
                this.f40762c = bundle;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to parse string as color int with key " + this.f40761b + " and bundle: " + this.f40762c;
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class i extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f40763b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Bundle f40764c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public i(String str, Bundle bundle) {
                super(0);
                this.f40763b = str;
                this.f40764c = bundle;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to parse string as int with key " + this.f40763b + " and bundle: " + this.f40764c;
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class j extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f40765b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Bundle f40766c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public j(String str, Bundle bundle) {
                super(0);
                this.f40765b = str;
                this.f40766c = bundle;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to parse string as long with key " + this.f40765b + " and bundle: " + this.f40766c;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final String stringAndKey(String str, Object obj) {
            if (obj == null) {
                return "";
            }
            return 10 + str + " = " + obj;
        }

        @JvmStatic
        @Deprecated(message = "Use getAttachedBrazeExtras", replaceWith = @ReplaceWith(expression = "getAttachedBrazeExtras(notificationExtras)", imports = {}))
        public final Bundle getAttachedAppboyExtras(Bundle bundle) {
            return getAttachedBrazeExtras(bundle);
        }

        @JvmStatic
        public final Bundle getAttachedBrazeExtras(Bundle bundle) {
            if (bundle == null) {
                return new Bundle();
            }
            if (bundle.containsKey("appboy_story_newly_received") && !bundle.getBoolean("appboy_story_newly_received")) {
                Bundle bundle2 = bundle.getBundle("extra");
                if (bundle2 == null) {
                    return new Bundle();
                }
                return bundle2;
            } else if (Constants.isAmazonDevice()) {
                return new Bundle(bundle);
            } else {
                Object obj = bundle.get("extra");
                if (obj instanceof String) {
                    return JsonUtils.parseJsonObjectIntoBundle((String) obj);
                }
                if (obj instanceof Bundle) {
                    return (Bundle) obj;
                }
                return new Bundle();
            }
        }

        @JvmStatic
        public final int getPushStoryGravityAtIndex(int i11, Bundle bundle, String str) {
            boolean z11;
            Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
            Intrinsics.checkNotNullParameter(str, "actionFieldKeyTemplate");
            String string = bundle.getString(StringsKt__StringsJVMKt.replace$default(str, "*", String.valueOf(i11), false, 4, (Object) null));
            if (string == null || StringsKt__StringsJVMKt.isBlank(string)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                int hashCode = string.hashCode();
                if (hashCode == -1364013995) {
                    string.equals("center");
                } else if (hashCode != 100571) {
                    if (hashCode == 109757538 && string.equals("start")) {
                        return GravityCompat.START;
                    }
                } else if (!string.equals(TtmlNode.END)) {
                    return 17;
                } else {
                    return GravityCompat.END;
                }
            }
            return 17;
        }

        @JvmStatic
        public final String getTemplateFieldAtIndex(int i11, Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
            Intrinsics.checkNotNullParameter(str, "actionFieldKeyTemplate");
            return getTemplateFieldAtIndex(i11, bundle, str, "");
        }

        @JvmStatic
        public final Long parseLong(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            try {
                if (bundle.containsKey(str)) {
                    return Long.valueOf(bundle.getLong(str));
                }
                return null;
            } catch (Exception unused) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new c(str, bundle), 7, (Object) null);
                return null;
            }
        }

        @JvmStatic
        public final String parseNonBlankString(Bundle bundle, String str) {
            boolean z11;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            try {
                String parseString = parseString(bundle, str);
                if (parseString == null || StringsKt__StringsJVMKt.isBlank(parseString)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    return parseString;
                }
                return null;
            } catch (Exception unused) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new d(str, bundle), 7, (Object) null);
                return null;
            }
        }

        @JvmStatic
        public final int parseObjectAsInteger(Bundle bundle, String str, int i11) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            try {
                if (bundle.containsKey(str)) {
                    Object obj = bundle.get(str);
                    if (obj != null) {
                        return Integer.parseInt(obj.toString());
                    }
                }
            } catch (Exception unused) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new e(str, bundle), 7, (Object) null);
            }
            return i11;
        }

        @JvmStatic
        public final String parseString(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            try {
                if (bundle.containsKey(str)) {
                    return bundle.getString(str);
                }
                return null;
            } catch (Exception unused) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new f(str, bundle), 7, (Object) null);
                return null;
            }
        }

        @JvmStatic
        public final boolean parseStringAsBoolean(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            try {
                if (!bundle.containsKey(str)) {
                    return false;
                }
                String string = bundle.getString(str);
                if (string == null) {
                    return false;
                }
                return Boolean.parseBoolean(string);
            } catch (Exception unused) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new g(str, bundle), 7, (Object) null);
                return false;
            }
        }

        @JvmStatic
        public final Integer parseStringAsColorInt(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            try {
                if (!bundle.containsKey(str)) {
                    return null;
                }
                String string = bundle.getString(str);
                if (string == null) {
                    return null;
                }
                return Integer.valueOf((int) Long.parseLong(string));
            } catch (Exception unused) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new h(str, bundle), 7, (Object) null);
                return null;
            }
        }

        @JvmStatic
        public final Integer parseStringAsInteger(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            try {
                if (!bundle.containsKey(str)) {
                    return null;
                }
                String string = bundle.getString(str);
                if (string == null) {
                    return null;
                }
                return Integer.valueOf(Integer.parseInt(string));
            } catch (Exception unused) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new i(str, bundle), 7, (Object) null);
                return null;
            }
        }

        @JvmStatic
        public final Long parseStringAsLong(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            try {
                if (!bundle.containsKey(str)) {
                    return null;
                }
                String string = bundle.getString(str);
                if (string == null) {
                    return null;
                }
                return Long.valueOf(Long.parseLong(string));
            } catch (Exception unused) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new j(str, bundle), 7, (Object) null);
                return null;
            }
        }

        @JvmStatic
        public final String getTemplateFieldAtIndex(int i11, Bundle bundle, String str, String str2) {
            Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
            Intrinsics.checkNotNullParameter(str, "actionFieldKeyTemplate");
            String string = bundle.getString(StringsKt__StringsJVMKt.replace$default(str, "*", String.valueOf(i11), false, 4, (Object) null));
            return string == null ? str2 : string;
        }

        @JvmStatic
        public final boolean getTemplateFieldAtIndex(int i11, Bundle bundle, String str, boolean z11) {
            Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
            Intrinsics.checkNotNullParameter(str, "actionFieldKeyTemplate");
            String string = bundle.getString(StringsKt__StringsJVMKt.replace$default(str, "*", String.valueOf(i11), false, 4, (Object) null));
            if (string == null) {
                return z11;
            }
            try {
                return Boolean.parseBoolean(string);
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) a.f40749b, 4, (Object) null);
                return z11;
            }
        }

        @JvmStatic
        public final long getTemplateFieldAtIndex(int i11, Bundle bundle, String str, long j11) {
            Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
            Intrinsics.checkNotNullParameter(str, "actionFieldKeyTemplate");
            String string = bundle.getString(StringsKt__StringsJVMKt.replace$default(str, "*", String.valueOf(i11), false, 4, (Object) null));
            if (string == null) {
                return j11;
            }
            try {
                return Long.parseLong(string);
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) b.f40750b, 4, (Object) null);
                return j11;
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\bH\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/appboy/models/push/BrazeNotificationPayload$ConversationMessage;", "", "notificationExtras", "Landroid/os/Bundle;", "index", "", "(Landroid/os/Bundle;I)V", "message", "", "getMessage", "()Ljava/lang/String;", "personId", "getPersonId", "timestamp", "", "getTimestamp", "()J", "toString", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ConversationMessage {
        private final String message;
        private final String personId;
        private final long timestamp;

        public ConversationMessage(Bundle bundle, int i11) {
            Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
            Companion companion = BrazeNotificationPayload.Companion;
            this.message = companion.getTemplateFieldAtIndex(i11, bundle, "ab_c_mt*");
            this.timestamp = companion.getTemplateFieldAtIndex(i11, bundle, "ab_c_mw*", 0);
            this.personId = companion.getTemplateFieldAtIndex(i11, bundle, "ab_c_mp*");
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getPersonId() {
            return this.personId;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            Companion companion = BrazeNotificationPayload.Companion;
            sb2.append(companion.stringAndKey("Message", this.message));
            sb2.append(companion.stringAndKey("Timestamp", Long.valueOf(this.timestamp)));
            sb2.append(companion.stringAndKey("PersonId", this.personId));
            return sb2.toString();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\fH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/appboy/models/push/BrazeNotificationPayload$ConversationPerson;", "", "notificationExtras", "Landroid/os/Bundle;", "index", "", "(Landroid/os/Bundle;I)V", "isBot", "", "()Z", "isImportant", "name", "", "getName", "()Ljava/lang/String;", "person", "Landroidx/core/app/Person;", "getPerson", "()Landroidx/core/app/Person;", "personId", "getPersonId", "uri", "getUri", "toString", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ConversationPerson {
        private final boolean isBot;
        private final boolean isImportant;

        /* renamed from: name  reason: collision with root package name */
        private final String f40767name;
        private final String personId;
        private final String uri;

        public ConversationPerson(Bundle bundle, int i11) {
            Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
            Companion companion = BrazeNotificationPayload.Companion;
            this.personId = companion.getTemplateFieldAtIndex(i11, bundle, "ab_c_pi*");
            this.f40767name = companion.getTemplateFieldAtIndex(i11, bundle, "ab_c_pn*");
            this.uri = companion.getTemplateFieldAtIndex(i11, bundle, "ab_c_pu*", (String) null);
            this.isImportant = companion.getTemplateFieldAtIndex(i11, bundle, "ab_c_pt*", false);
            this.isBot = companion.getTemplateFieldAtIndex(i11, bundle, "ab_c_pb*", false);
        }

        public final String getName() {
            return this.f40767name;
        }

        public final Person getPerson() {
            Person build = new Person.Builder().setKey(this.personId).setName(this.f40767name).setUri(this.uri).setBot(this.isBot).setImportant(this.isImportant).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …\n                .build()");
            return build;
        }

        public final String getPersonId() {
            return this.personId;
        }

        public final String getUri() {
            return this.uri;
        }

        public final boolean isBot() {
            return this.isBot;
        }

        public final boolean isImportant() {
            return this.isImportant;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            Companion companion = BrazeNotificationPayload.Companion;
            sb2.append(companion.stringAndKey("PersonId", this.personId));
            sb2.append(companion.stringAndKey("Name", this.f40767name));
            sb2.append(companion.stringAndKey("Uri", this.uri));
            sb2.append(companion.stringAndKey("IsImportant", Boolean.valueOf(this.isImportant)));
            sb2.append(companion.stringAndKey("IsBot", Boolean.valueOf(this.isBot)));
            return sb2.toString();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001d\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010(\u001a\u00020\fH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\u001a\u0010\u001c\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\nR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010R\u001a\u0010\"\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\b\"\u0004\b$\u0010\nR\u001c\u0010%\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u000e\"\u0004\b'\u0010\u0010¨\u0006)"}, d2 = {"Lcom/appboy/models/push/BrazeNotificationPayload$PushStoryPage;", "", "notificationExtras", "Landroid/os/Bundle;", "actionIndex", "", "(Landroid/os/Bundle;I)V", "getActionIndex", "()I", "setActionIndex", "(I)V", "bitmapUrl", "", "getBitmapUrl", "()Ljava/lang/String;", "setBitmapUrl", "(Ljava/lang/String;)V", "campaignId", "getCampaignId", "deeplink", "getDeeplink", "setDeeplink", "storyPageId", "getStoryPageId", "setStoryPageId", "subtitle", "getSubtitle", "setSubtitle", "subtitleGravity", "getSubtitleGravity", "setSubtitleGravity", "title", "getTitle", "setTitle", "titleGravity", "getTitleGravity", "setTitleGravity", "useWebview", "getUseWebview", "setUseWebview", "toString", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PushStoryPage {
        private int actionIndex;
        private String bitmapUrl;
        private final String campaignId;
        private String deeplink;
        private String storyPageId;
        private String subtitle;
        private int subtitleGravity;
        private String title;
        private int titleGravity;
        private String useWebview;

        public PushStoryPage(Bundle bundle, int i11) {
            Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
            this.actionIndex = i11;
            Companion companion = BrazeNotificationPayload.Companion;
            this.campaignId = companion.parseString(bundle, "cid");
            this.title = companion.getTemplateFieldAtIndex(this.actionIndex, bundle, "ab_c*_t");
            this.titleGravity = companion.getPushStoryGravityAtIndex(this.actionIndex, bundle, "ab_c*_t_j");
            this.subtitle = companion.getTemplateFieldAtIndex(this.actionIndex, bundle, "ab_c*_st");
            this.subtitleGravity = companion.getPushStoryGravityAtIndex(this.actionIndex, bundle, "ab_c*_st_j");
            this.bitmapUrl = companion.getTemplateFieldAtIndex(this.actionIndex, bundle, "ab_c*_i");
            this.storyPageId = companion.getTemplateFieldAtIndex(this.actionIndex, bundle, "ab_c*_id", "");
            this.deeplink = companion.getTemplateFieldAtIndex(this.actionIndex, bundle, "ab_c*_uri");
            this.useWebview = companion.getTemplateFieldAtIndex(this.actionIndex, bundle, "ab_c*_use_webview");
        }

        public final int getActionIndex() {
            return this.actionIndex;
        }

        public final String getBitmapUrl() {
            return this.bitmapUrl;
        }

        public final String getCampaignId() {
            return this.campaignId;
        }

        public final String getDeeplink() {
            return this.deeplink;
        }

        public final String getStoryPageId() {
            return this.storyPageId;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final int getSubtitleGravity() {
            return this.subtitleGravity;
        }

        public final String getTitle() {
            return this.title;
        }

        public final int getTitleGravity() {
            return this.titleGravity;
        }

        public final String getUseWebview() {
            return this.useWebview;
        }

        public final void setActionIndex(int i11) {
            this.actionIndex = i11;
        }

        public final void setBitmapUrl(String str) {
            this.bitmapUrl = str;
        }

        public final void setDeeplink(String str) {
            this.deeplink = str;
        }

        public final void setStoryPageId(String str) {
            this.storyPageId = str;
        }

        public final void setSubtitle(String str) {
            this.subtitle = str;
        }

        public final void setSubtitleGravity(int i11) {
            this.subtitleGravity = i11;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final void setTitleGravity(int i11) {
            this.titleGravity = i11;
        }

        public final void setUseWebview(String str) {
            this.useWebview = str;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            Companion companion = BrazeNotificationPayload.Companion;
            sb2.append(companion.stringAndKey("ActionIndex", Integer.valueOf(this.actionIndex)));
            sb2.append(companion.stringAndKey("CampaignId", this.campaignId));
            sb2.append(companion.stringAndKey("Title", this.title));
            sb2.append(companion.stringAndKey("TitleGravity", Integer.valueOf(this.titleGravity)));
            sb2.append(companion.stringAndKey("Subtitle", this.subtitle));
            sb2.append(companion.stringAndKey("SubtitleGravity=", Integer.valueOf(this.subtitleGravity)));
            sb2.append(companion.stringAndKey("BitmapUrl", this.bitmapUrl));
            sb2.append(companion.stringAndKey("StoryPageId", this.storyPageId));
            sb2.append(companion.stringAndKey("Deeplink", this.deeplink));
            sb2.append(companion.stringAndKey("UseWebview", this.useWebview));
            return sb2.toString();
        }
    }

    public BrazeNotificationPayload(Bundle bundle) {
        this(bundle, (Bundle) null, (Context) null, (BrazeConfigurationProvider) null, 14, (DefaultConstructorMarker) null);
    }

    public BrazeNotificationPayload(Bundle bundle, Bundle bundle2) {
        this(bundle, bundle2, (Context) null, (BrazeConfigurationProvider) null, 12, (DefaultConstructorMarker) null);
    }

    public BrazeNotificationPayload(Bundle bundle, Bundle bundle2, Context context2) {
        this(bundle, bundle2, context2, (BrazeConfigurationProvider) null, 8, (DefaultConstructorMarker) null);
    }

    public BrazeNotificationPayload(Bundle bundle, Bundle bundle2, Context context2, BrazeConfigurationProvider brazeConfigurationProvider) {
        Context context3;
        this.configurationProvider = brazeConfigurationProvider;
        this.notificationExtras = bundle == null ? new Bundle() : bundle;
        this.brazeExtras = bundle2 == null ? new Bundle() : bundle2;
        this.extras = BundleUtils.toStringMap(bundle2);
        if (context2 == null) {
            context3 = null;
        } else {
            context3 = context2.getApplicationContext();
        }
        this.context = context3;
        this.actionButtonsInternal = new ArrayList();
        this.pushStoryPagesInternal = new ArrayList();
        this.conversationMessagesInternal = new ArrayList();
        this.conversationPersonMapInternal = new HashMap();
        parsePayloadFieldsFromBundle();
    }

    @JvmStatic
    @Deprecated(message = "Use getAttachedBrazeExtras", replaceWith = @ReplaceWith(expression = "getAttachedBrazeExtras(notificationExtras)", imports = {}))
    public static final Bundle getAttachedAppboyExtras(Bundle bundle) {
        return Companion.getAttachedAppboyExtras(bundle);
    }

    @JvmStatic
    public static final Bundle getAttachedBrazeExtras(Bundle bundle) {
        return Companion.getAttachedBrazeExtras(bundle);
    }

    @JvmStatic
    public static final int getPushStoryGravityAtIndex(int i11, Bundle bundle, String str) {
        return Companion.getPushStoryGravityAtIndex(i11, bundle, str);
    }

    @JvmStatic
    public static final long getTemplateFieldAtIndex(int i11, Bundle bundle, String str, long j11) {
        return Companion.getTemplateFieldAtIndex(i11, bundle, str, j11);
    }

    @JvmStatic
    public static final String getTemplateFieldAtIndex(int i11, Bundle bundle, String str) {
        return Companion.getTemplateFieldAtIndex(i11, bundle, str);
    }

    @JvmStatic
    public static final String getTemplateFieldAtIndex(int i11, Bundle bundle, String str, String str2) {
        return Companion.getTemplateFieldAtIndex(i11, bundle, str, str2);
    }

    @JvmStatic
    public static final boolean getTemplateFieldAtIndex(int i11, Bundle bundle, String str, boolean z11) {
        return Companion.getTemplateFieldAtIndex(i11, bundle, str, z11);
    }

    @JvmStatic
    public static final Long parseLong(Bundle bundle, String str) {
        return Companion.parseLong(bundle, str);
    }

    @JvmStatic
    public static final String parseNonBlankString(Bundle bundle, String str) {
        return Companion.parseNonBlankString(bundle, str);
    }

    @JvmStatic
    public static final int parseObjectAsInteger(Bundle bundle, String str, int i11) {
        return Companion.parseObjectAsInteger(bundle, str, i11);
    }

    private final void parsePayloadFieldsFromBundle() {
        parsePayloadFieldsFromBundle$parseNotificationMetadata(this);
        parsePayloadFieldsFromBundle$parseContentCardData(this);
        parsePayloadFieldsFromBundle$parseVisibleContent(this);
        parsePayloadFieldsFromBundle$parseBigTextStyle(this);
        parsePayloadFieldsFromBundle$parseBigImageStyle(this);
        parsePayloadFieldsFromBundle$parseActionButtons(this);
        parsePayloadFieldsFromBundle$parsePushStoryData(this);
        parsePayloadFieldsFromBundle$parseConversationPushData(this);
    }

    private static final void parsePayloadFieldsFromBundle$parseActionButtons(BrazeNotificationPayload brazeNotificationPayload) {
        boolean z11;
        brazeNotificationPayload.actionButtonsInternal.clear();
        int i11 = 0;
        while (true) {
            String templateFieldAtIndex = Companion.getTemplateFieldAtIndex(i11, brazeNotificationPayload.notificationExtras, "ab_a*_a");
            if (templateFieldAtIndex == null || StringsKt__StringsJVMKt.isBlank(templateFieldAtIndex)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                brazeNotificationPayload.actionButtonsInternal.add(new ActionButton(brazeNotificationPayload.notificationExtras, i11));
                i11++;
            } else {
                return;
            }
        }
    }

    private static final void parsePayloadFieldsFromBundle$parseBigImageStyle(BrazeNotificationPayload brazeNotificationPayload) {
        boolean z11;
        String parseNonBlankString = Companion.parseNonBlankString(brazeNotificationPayload.notificationExtras, "ab_iu");
        brazeNotificationPayload.bigImageUrl = parseNonBlankString;
        boolean z12 = false;
        if (parseNonBlankString == null || StringsKt__StringsJVMKt.isBlank(parseNonBlankString)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            String str = brazeNotificationPayload.extras.get("appboy_image_url");
            if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
                z12 = true;
            }
            if (!z12) {
                brazeNotificationPayload.bigImageUrl = str;
            }
        }
    }

    private static final void parsePayloadFieldsFromBundle$parseBigTextStyle(BrazeNotificationPayload brazeNotificationPayload) {
        Companion companion = Companion;
        brazeNotificationPayload.bigSummaryText = companion.parseString(brazeNotificationPayload.notificationExtras, "ab_bs");
        brazeNotificationPayload.bigTitleText = companion.parseString(brazeNotificationPayload.notificationExtras, "ab_bt");
    }

    private static final void parsePayloadFieldsFromBundle$parseContentCardData(BrazeNotificationPayload brazeNotificationPayload) {
        Companion companion = Companion;
        brazeNotificationPayload.contentCardSyncData = companion.parseString(brazeNotificationPayload.notificationExtras, "ab_cd");
        brazeNotificationPayload.contentCardSyncUserId = companion.parseString(brazeNotificationPayload.notificationExtras, "ab_cd_uid");
    }

    private static final void parsePayloadFieldsFromBundle$parseConversationPushData(BrazeNotificationPayload brazeNotificationPayload) {
        boolean z11;
        boolean z12;
        Companion companion = Companion;
        brazeNotificationPayload.conversationShortcutId = companion.parseString(brazeNotificationPayload.notificationExtras, "ab_c_si");
        brazeNotificationPayload.conversationReplyPersonId = companion.parseString(brazeNotificationPayload.notificationExtras, "ab_c_rpi");
        brazeNotificationPayload.conversationMessagesInternal.clear();
        brazeNotificationPayload.conversationPersonMapInternal.clear();
        int i11 = 0;
        while (true) {
            String templateFieldAtIndex = Companion.getTemplateFieldAtIndex(i11, brazeNotificationPayload.notificationExtras, "ab_c_mt*");
            if (templateFieldAtIndex == null || StringsKt__StringsJVMKt.isBlank(templateFieldAtIndex)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                break;
            }
            brazeNotificationPayload.conversationMessagesInternal.add(new ConversationMessage(brazeNotificationPayload.notificationExtras, i11));
            i11++;
        }
        int i12 = 0;
        while (true) {
            String templateFieldAtIndex2 = Companion.getTemplateFieldAtIndex(i12, brazeNotificationPayload.notificationExtras, "ab_c_pi*");
            if (templateFieldAtIndex2 == null || StringsKt__StringsJVMKt.isBlank(templateFieldAtIndex2)) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                ConversationPerson conversationPerson = new ConversationPerson(brazeNotificationPayload.notificationExtras, i12);
                brazeNotificationPayload.conversationPersonMapInternal.put(conversationPerson.getPersonId(), conversationPerson);
                i12++;
            } else {
                return;
            }
        }
    }

    private static final void parsePayloadFieldsFromBundle$parseNotificationMetadata(BrazeNotificationPayload brazeNotificationPayload) {
        boolean z11;
        Companion companion = Companion;
        brazeNotificationPayload.pushDuration = companion.parseStringAsInteger(brazeNotificationPayload.notificationExtras, "nd");
        brazeNotificationPayload.isPushStory = brazeNotificationPayload.notificationExtras.containsKey("ab_c");
        brazeNotificationPayload.notificationCategory = companion.parseString(brazeNotificationPayload.notificationExtras, "ab_ct");
        brazeNotificationPayload.notificationVisibility = companion.parseStringAsInteger(brazeNotificationPayload.notificationExtras, "ab_vs");
        brazeNotificationPayload.notificationBadgeNumber = companion.parseStringAsInteger(brazeNotificationPayload.notificationExtras, "ab_bc");
        brazeNotificationPayload.publicNotificationExtras = companion.parseString(brazeNotificationPayload.notificationExtras, "ab_pn");
        brazeNotificationPayload.customNotificationId = companion.parseStringAsInteger(brazeNotificationPayload.notificationExtras, "n");
        brazeNotificationPayload.notificationReceivedTimestampMillis = companion.parseLong(brazeNotificationPayload.notificationExtras, "appboy_push_received_timestamp");
        brazeNotificationPayload.isInlineImagePush = brazeNotificationPayload.notificationExtras.containsKey("ab_iip");
        brazeNotificationPayload.isConversationalPush = brazeNotificationPayload.notificationExtras.containsKey("ab_cp");
        brazeNotificationPayload.notificationPriorityInt = companion.parseStringAsInteger(brazeNotificationPayload.notificationExtras, "p");
        brazeNotificationPayload.shouldFetchTestTriggers = companion.parseStringAsBoolean(brazeNotificationPayload.notificationExtras, "ab_push_fetch_test_triggers_key");
        brazeNotificationPayload.shouldSyncGeofences = companion.parseStringAsBoolean(brazeNotificationPayload.notificationExtras, "ab_sync_geos");
        brazeNotificationPayload.shouldRefreshFeatureFlags = companion.parseStringAsBoolean(brazeNotificationPayload.notificationExtras, Constants.BRAZE_PUSH_REFRESH_FEATURE_FLAGS);
        if (brazeNotificationPayload.notificationExtras.containsKey("appboy_uninstall_tracking") || brazeNotificationPayload.brazeExtras.containsKey("appboy_uninstall_tracking")) {
            z11 = true;
        } else {
            z11 = false;
        }
        brazeNotificationPayload.isUninstallTrackingPush = z11;
        brazeNotificationPayload.deeplink = companion.parseString(brazeNotificationPayload.notificationExtras, "uri");
    }

    private static final void parsePayloadFieldsFromBundle$parsePushStoryData(BrazeNotificationPayload brazeNotificationPayload) {
        boolean z11;
        brazeNotificationPayload.pushStoryPageIndex = Companion.parseObjectAsInteger(brazeNotificationPayload.notificationExtras, "appboy_story_index", 0);
        int i11 = 0;
        while (true) {
            String templateFieldAtIndex = Companion.getTemplateFieldAtIndex(i11, brazeNotificationPayload.notificationExtras, "ab_c*_i");
            if (templateFieldAtIndex == null || StringsKt__StringsJVMKt.isBlank(templateFieldAtIndex)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                brazeNotificationPayload.pushStoryPagesInternal.add(new PushStoryPage(brazeNotificationPayload.notificationExtras, i11));
                i11++;
            } else {
                brazeNotificationPayload.isNewlyReceivedPushStory = brazeNotificationPayload.notificationExtras.getBoolean("appboy_story_newly_received", false);
                return;
            }
        }
    }

    private static final void parsePayloadFieldsFromBundle$parseVisibleContent(BrazeNotificationPayload brazeNotificationPayload) {
        Companion companion = Companion;
        brazeNotificationPayload.notificationChannelId = companion.parseNonBlankString(brazeNotificationPayload.notificationExtras, "ab_nc");
        brazeNotificationPayload.titleText = companion.parseString(brazeNotificationPayload.notificationExtras, "t");
        brazeNotificationPayload.contentText = companion.parseString(brazeNotificationPayload.notificationExtras, "a");
        brazeNotificationPayload.largeIcon = companion.parseString(brazeNotificationPayload.notificationExtras, "ab_li");
        brazeNotificationPayload.notificationSound = companion.parseString(brazeNotificationPayload.notificationExtras, "sd");
        brazeNotificationPayload.summaryText = companion.parseString(brazeNotificationPayload.notificationExtras, "s");
        brazeNotificationPayload.accentColor = companion.parseStringAsColorInt(brazeNotificationPayload.notificationExtras, "ac");
    }

    @JvmStatic
    public static final String parseString(Bundle bundle, String str) {
        return Companion.parseString(bundle, str);
    }

    @JvmStatic
    public static final boolean parseStringAsBoolean(Bundle bundle, String str) {
        return Companion.parseStringAsBoolean(bundle, str);
    }

    @JvmStatic
    public static final Integer parseStringAsColorInt(Bundle bundle, String str) {
        return Companion.parseStringAsColorInt(bundle, str);
    }

    @JvmStatic
    public static final Integer parseStringAsInteger(Bundle bundle, String str) {
        return Companion.parseStringAsInteger(bundle, str);
    }

    @JvmStatic
    public static final Long parseStringAsLong(Bundle bundle, String str) {
        return Companion.parseStringAsLong(bundle, str);
    }

    public final Integer getAccentColor() {
        return this.accentColor;
    }

    public final List<ActionButton> getActionButtons() {
        return this.actionButtonsInternal;
    }

    public final String getBigImageUrl() {
        return this.bigImageUrl;
    }

    public final String getBigSummaryText() {
        return this.bigSummaryText;
    }

    public final String getBigTitleText() {
        return this.bigTitleText;
    }

    public final Bundle getBrazeExtras() {
        return this.brazeExtras;
    }

    public final BrazeConfigurationProvider getConfigurationProvider() {
        return this.configurationProvider;
    }

    public final String getContentCardSyncData() {
        return this.contentCardSyncData;
    }

    public final String getContentCardSyncUserId() {
        return this.contentCardSyncUserId;
    }

    public final String getContentText() {
        return this.contentText;
    }

    public final Context getContext() {
        return this.context;
    }

    public final List<ConversationMessage> getConversationMessages() {
        return this.conversationMessagesInternal;
    }

    public final Map<String, ConversationPerson> getConversationPersonMap() {
        return this.conversationPersonMapInternal;
    }

    public final String getConversationReplyPersonId() {
        return this.conversationReplyPersonId;
    }

    public final String getConversationShortcutId() {
        return this.conversationShortcutId;
    }

    public final Integer getCustomNotificationId() {
        return this.customNotificationId;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final Map<String, String> getExtras() {
        return this.extras;
    }

    public final String getLargeIcon() {
        return this.largeIcon;
    }

    public final Integer getNotificationBadgeNumber() {
        return this.notificationBadgeNumber;
    }

    public final String getNotificationCategory() {
        return this.notificationCategory;
    }

    public final String getNotificationChannelId() {
        return this.notificationChannelId;
    }

    public final Bundle getNotificationExtras() {
        return this.notificationExtras;
    }

    public final Integer getNotificationPriorityInt() {
        return this.notificationPriorityInt;
    }

    public final Long getNotificationReceivedTimestampMillis() {
        return this.notificationReceivedTimestampMillis;
    }

    public final String getNotificationSound() {
        return this.notificationSound;
    }

    public final Integer getNotificationVisibility() {
        return this.notificationVisibility;
    }

    public final String getPublicNotificationExtras() {
        return this.publicNotificationExtras;
    }

    public final Integer getPushDuration() {
        return this.pushDuration;
    }

    public final int getPushStoryPageIndex() {
        return this.pushStoryPageIndex;
    }

    public final List<PushStoryPage> getPushStoryPages() {
        return this.pushStoryPagesInternal;
    }

    public final boolean getShouldFetchTestTriggers() {
        return this.shouldFetchTestTriggers;
    }

    public final boolean getShouldRefreshFeatureFlags() {
        return this.shouldRefreshFeatureFlags;
    }

    public final boolean getShouldSyncGeofences() {
        return this.shouldSyncGeofences;
    }

    public final String getSummaryText() {
        return this.summaryText;
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public final boolean isConversationalPush() {
        return this.isConversationalPush;
    }

    public final boolean isInlineImagePush() {
        return this.isInlineImagePush;
    }

    public final boolean isNewlyReceivedPushStory() {
        return this.isNewlyReceivedPushStory;
    }

    public final boolean isPushStory() {
        return this.isPushStory;
    }

    public final boolean isUninstallTrackingPush() {
        return this.isUninstallTrackingPush;
    }

    public final void setAccentColor(Integer num) {
        this.accentColor = num;
    }

    public final void setActionButtons(List<ActionButton> list) {
        Intrinsics.checkNotNullParameter(list, "actionButtons");
        this.actionButtonsInternal = list;
    }

    public final void setBigImageUrl(String str) {
        this.bigImageUrl = str;
    }

    public final void setBigSummaryText(String str) {
        this.bigSummaryText = str;
    }

    public final void setBigTitleText(String str) {
        this.bigTitleText = str;
    }

    public final void setBrazeExtras(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<set-?>");
        this.brazeExtras = bundle;
    }

    public final void setConfigurationProvider(BrazeConfigurationProvider brazeConfigurationProvider) {
        this.configurationProvider = brazeConfigurationProvider;
    }

    public final void setContentCardSyncData(String str) {
        this.contentCardSyncData = str;
    }

    public final void setContentCardSyncUserId(String str) {
        this.contentCardSyncUserId = str;
    }

    public final void setContentText(String str) {
        this.contentText = str;
    }

    public final void setContext(Context context2) {
        this.context = context2;
    }

    public final void setConversationShortcutId(String str) {
        this.conversationShortcutId = str;
    }

    public final void setConversationalPush(boolean z11) {
        this.isConversationalPush = z11;
    }

    public final void setCustomNotificationId(Integer num) {
        this.customNotificationId = num;
    }

    public final void setDeeplink(String str) {
        this.deeplink = str;
    }

    public final void setExtras(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.extras = map;
    }

    public final void setInlineImagePush(boolean z11) {
        this.isInlineImagePush = z11;
    }

    public final void setIsInlineImagePush(boolean z11) {
        this.isInlineImagePush = z11;
    }

    public final void setLargeIcon(String str) {
        this.largeIcon = str;
    }

    public final void setNewlyReceivedPushStory(boolean z11) {
        this.isNewlyReceivedPushStory = z11;
    }

    public final void setNotificationBadgeNumber(Integer num) {
        this.notificationBadgeNumber = num;
    }

    public final void setNotificationCategory(String str) {
        this.notificationCategory = str;
    }

    public final void setNotificationChannelId(String str) {
        this.notificationChannelId = str;
    }

    public final void setNotificationPriorityInt(Integer num) {
        this.notificationPriorityInt = num;
    }

    public final void setNotificationReceivedTimestampMillis(Long l11) {
        this.notificationReceivedTimestampMillis = l11;
    }

    public final void setNotificationSound(String str) {
        this.notificationSound = str;
    }

    public final void setNotificationVisibility(Integer num) {
        this.notificationVisibility = num;
    }

    public final void setPublicNotificationExtras(String str) {
        this.publicNotificationExtras = str;
    }

    public final void setPushDuration(Integer num) {
        this.pushDuration = num;
    }

    public final void setPushStory(boolean z11) {
        this.isPushStory = z11;
    }

    public final void setPushStoryPageIndex(int i11) {
        this.pushStoryPageIndex = i11;
    }

    public final void setPushStoryPages(List<PushStoryPage> list) {
        Intrinsics.checkNotNullParameter(list, "pushStoryPages");
        this.pushStoryPagesInternal = list;
    }

    public final void setShouldFetchTestTriggers(boolean z11) {
        this.shouldFetchTestTriggers = z11;
    }

    public final void setShouldRefreshFeatureFlags(boolean z11) {
        this.shouldRefreshFeatureFlags = z11;
    }

    public final void setShouldSyncGeofences(boolean z11) {
        this.shouldSyncGeofences = z11;
    }

    public final void setSummaryText(String str) {
        this.summaryText = str;
    }

    public final void setTitleText(String str) {
        this.titleText = str;
    }

    public final void setUninstallTrackingPush(boolean z11) {
        this.isUninstallTrackingPush = z11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        Companion companion = Companion;
        sb2.append(companion.stringAndKey("PushDuration", this.pushDuration));
        sb2.append(companion.stringAndKey("IsPushStory", Boolean.valueOf(this.isPushStory)));
        sb2.append(companion.stringAndKey("IsInlineImagePush", Boolean.valueOf(this.isInlineImagePush)));
        sb2.append(companion.stringAndKey("IsConversationalPush", Boolean.valueOf(this.isConversationalPush)));
        sb2.append(companion.stringAndKey("PublicNotificationExtras", this.publicNotificationExtras));
        sb2.append(companion.stringAndKey("NotificationChannelId", this.notificationChannelId));
        sb2.append(companion.stringAndKey("NotificationCategory", this.notificationCategory));
        sb2.append(companion.stringAndKey("NotificationVisibility", this.notificationVisibility));
        sb2.append(companion.stringAndKey("NotificationBadgeNumber", this.notificationBadgeNumber));
        sb2.append(companion.stringAndKey("CustomNotificationId", this.customNotificationId));
        sb2.append(companion.stringAndKey("NotificationReceivedTimestampMillis", this.notificationReceivedTimestampMillis));
        sb2.append(companion.stringAndKey("ContentCardSyncData", this.contentCardSyncData));
        sb2.append(companion.stringAndKey("ContentCardSyncUserId", this.contentCardSyncUserId));
        sb2.append(companion.stringAndKey("TitleText", this.titleText));
        sb2.append(companion.stringAndKey("ContentText", this.contentText));
        sb2.append(companion.stringAndKey("LargeIcon", this.largeIcon));
        sb2.append(companion.stringAndKey("NotificationSound", this.notificationSound));
        sb2.append(companion.stringAndKey("SummaryText", this.summaryText));
        sb2.append(companion.stringAndKey("AccentColor", this.accentColor));
        sb2.append(companion.stringAndKey("BigSummaryText", this.bigSummaryText));
        sb2.append(companion.stringAndKey("BigTitleText", this.bigTitleText));
        sb2.append(companion.stringAndKey("BigImageUrl", this.bigImageUrl));
        sb2.append(companion.stringAndKey("ActionButtons", getActionButtons()));
        sb2.append(companion.stringAndKey("PushStoryPageIndex", Integer.valueOf(this.pushStoryPageIndex)));
        sb2.append(companion.stringAndKey("PushStoryPages", this.pushStoryPagesInternal));
        sb2.append(companion.stringAndKey("ConversationMessages", this.conversationMessagesInternal));
        sb2.append(companion.stringAndKey("ConversationPersonMap", this.conversationPersonMapInternal));
        sb2.append(companion.stringAndKey("ConversationShortcutId", this.conversationShortcutId));
        return sb2.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BrazeNotificationPayload(Bundle bundle, Bundle bundle2, Context context2, BrazeConfigurationProvider brazeConfigurationProvider, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(bundle, (i11 & 2) != 0 ? Companion.getAttachedBrazeExtras(bundle) : bundle2, (i11 & 4) != 0 ? null : context2, (i11 & 8) != 0 ? null : brazeConfigurationProvider);
    }
}
