package com.deliveryhero.customerchat.eventTracking.data;

import com.deliveryhero.customerchat.eventTracking.constants.FeatureFlagPropertyKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001$BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003Jm\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006%"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/data/FeatureFlagProperties;", "", "stackFromEnd", "", "isReplyingMandatory", "isPhotoSharingEnabled", "hideAdminMessages", "showSenderName", "isLocationSharingEnabled", "isPhoneCallingEnabled", "isVOIPCallingEnabled", "translations", "isRemoteConfigurationEnabled", "(ZZZZZZZZZZ)V", "getHideAdminMessages", "()Z", "getShowSenderName", "getStackFromEnd", "getTranslations", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeatureFlagProperties {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean hideAdminMessages;
    private final boolean isLocationSharingEnabled;
    private final boolean isPhoneCallingEnabled;
    private final boolean isPhotoSharingEnabled;
    private final boolean isRemoteConfigurationEnabled;
    private final boolean isReplyingMandatory;
    private final boolean isVOIPCallingEnabled;
    private final boolean showSenderName;
    private final boolean stackFromEnd;
    private final boolean translations;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004*\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/data/FeatureFlagProperties$Companion;", "", "()V", "toMap", "", "", "Lcom/deliveryhero/customerchat/eventTracking/data/FeatureFlagProperties;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Map<String, String> toMap(@NotNull FeatureFlagProperties featureFlagProperties) {
            Intrinsics.checkNotNullParameter(featureFlagProperties, "<this>");
            Map createMapBuilder = MapsKt__MapsJVMKt.createMapBuilder();
            createMapBuilder.put(FeatureFlagPropertyKeys.STACK_MESSAGES_FROM_END, String.valueOf(featureFlagProperties.getStackFromEnd()));
            createMapBuilder.put(FeatureFlagPropertyKeys.IS_REPLYING_MANDATORY, String.valueOf(featureFlagProperties.isReplyingMandatory()));
            createMapBuilder.put(FeatureFlagPropertyKeys.IS_PHOTO_SHARING_ENABLED, String.valueOf(featureFlagProperties.isPhotoSharingEnabled()));
            createMapBuilder.put(FeatureFlagPropertyKeys.HIDE_ADMIN_MESSAGES, String.valueOf(featureFlagProperties.getHideAdminMessages()));
            createMapBuilder.put(FeatureFlagPropertyKeys.SHOW_SENDER_NAME, String.valueOf(featureFlagProperties.getShowSenderName()));
            createMapBuilder.put("location_sharing", String.valueOf(featureFlagProperties.isLocationSharingEnabled()));
            createMapBuilder.put(FeatureFlagPropertyKeys.PHONE_CALLING_ENABLED, String.valueOf(featureFlagProperties.isPhoneCallingEnabled()));
            createMapBuilder.put(FeatureFlagPropertyKeys.VOIP_CALLING_ENABLED, String.valueOf(featureFlagProperties.isVOIPCallingEnabled()));
            createMapBuilder.put(FeatureFlagPropertyKeys.IS_TRANSLATION_ENABLED, String.valueOf(featureFlagProperties.getTranslations()));
            createMapBuilder.put(FeatureFlagPropertyKeys.REMOTE_CONFIGURATION_ENABLED, String.valueOf(featureFlagProperties.isRemoteConfigurationEnabled()));
            return MapsKt__MapsJVMKt.build(createMapBuilder);
        }
    }

    public FeatureFlagProperties(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, boolean z21) {
        this.stackFromEnd = z11;
        this.isReplyingMandatory = z12;
        this.isPhotoSharingEnabled = z13;
        this.hideAdminMessages = z14;
        this.showSenderName = z15;
        this.isLocationSharingEnabled = z16;
        this.isPhoneCallingEnabled = z17;
        this.isVOIPCallingEnabled = z18;
        this.translations = z19;
        this.isRemoteConfigurationEnabled = z21;
    }

    public static /* synthetic */ FeatureFlagProperties copy$default(FeatureFlagProperties featureFlagProperties, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, boolean z21, int i11, Object obj) {
        FeatureFlagProperties featureFlagProperties2 = featureFlagProperties;
        int i12 = i11;
        return featureFlagProperties.copy((i12 & 1) != 0 ? featureFlagProperties2.stackFromEnd : z11, (i12 & 2) != 0 ? featureFlagProperties2.isReplyingMandatory : z12, (i12 & 4) != 0 ? featureFlagProperties2.isPhotoSharingEnabled : z13, (i12 & 8) != 0 ? featureFlagProperties2.hideAdminMessages : z14, (i12 & 16) != 0 ? featureFlagProperties2.showSenderName : z15, (i12 & 32) != 0 ? featureFlagProperties2.isLocationSharingEnabled : z16, (i12 & 64) != 0 ? featureFlagProperties2.isPhoneCallingEnabled : z17, (i12 & 128) != 0 ? featureFlagProperties2.isVOIPCallingEnabled : z18, (i12 & 256) != 0 ? featureFlagProperties2.translations : z19, (i12 & 512) != 0 ? featureFlagProperties2.isRemoteConfigurationEnabled : z21);
    }

    public final boolean component1() {
        return this.stackFromEnd;
    }

    public final boolean component10() {
        return this.isRemoteConfigurationEnabled;
    }

    public final boolean component2() {
        return this.isReplyingMandatory;
    }

    public final boolean component3() {
        return this.isPhotoSharingEnabled;
    }

    public final boolean component4() {
        return this.hideAdminMessages;
    }

    public final boolean component5() {
        return this.showSenderName;
    }

    public final boolean component6() {
        return this.isLocationSharingEnabled;
    }

    public final boolean component7() {
        return this.isPhoneCallingEnabled;
    }

    public final boolean component8() {
        return this.isVOIPCallingEnabled;
    }

    public final boolean component9() {
        return this.translations;
    }

    @NotNull
    public final FeatureFlagProperties copy(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, boolean z21) {
        return new FeatureFlagProperties(z11, z12, z13, z14, z15, z16, z17, z18, z19, z21);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeatureFlagProperties)) {
            return false;
        }
        FeatureFlagProperties featureFlagProperties = (FeatureFlagProperties) obj;
        return this.stackFromEnd == featureFlagProperties.stackFromEnd && this.isReplyingMandatory == featureFlagProperties.isReplyingMandatory && this.isPhotoSharingEnabled == featureFlagProperties.isPhotoSharingEnabled && this.hideAdminMessages == featureFlagProperties.hideAdminMessages && this.showSenderName == featureFlagProperties.showSenderName && this.isLocationSharingEnabled == featureFlagProperties.isLocationSharingEnabled && this.isPhoneCallingEnabled == featureFlagProperties.isPhoneCallingEnabled && this.isVOIPCallingEnabled == featureFlagProperties.isVOIPCallingEnabled && this.translations == featureFlagProperties.translations && this.isRemoteConfigurationEnabled == featureFlagProperties.isRemoteConfigurationEnabled;
    }

    public final boolean getHideAdminMessages() {
        return this.hideAdminMessages;
    }

    public final boolean getShowSenderName() {
        return this.showSenderName;
    }

    public final boolean getStackFromEnd() {
        return this.stackFromEnd;
    }

    public final boolean getTranslations() {
        return this.translations;
    }

    public int hashCode() {
        boolean z11 = this.stackFromEnd;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (z11 ? 1 : 0) * true;
        boolean z13 = this.isReplyingMandatory;
        if (z13) {
            z13 = true;
        }
        int i12 = (i11 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.isPhotoSharingEnabled;
        if (z14) {
            z14 = true;
        }
        int i13 = (i12 + (z14 ? 1 : 0)) * 31;
        boolean z15 = this.hideAdminMessages;
        if (z15) {
            z15 = true;
        }
        int i14 = (i13 + (z15 ? 1 : 0)) * 31;
        boolean z16 = this.showSenderName;
        if (z16) {
            z16 = true;
        }
        int i15 = (i14 + (z16 ? 1 : 0)) * 31;
        boolean z17 = this.isLocationSharingEnabled;
        if (z17) {
            z17 = true;
        }
        int i16 = (i15 + (z17 ? 1 : 0)) * 31;
        boolean z18 = this.isPhoneCallingEnabled;
        if (z18) {
            z18 = true;
        }
        int i17 = (i16 + (z18 ? 1 : 0)) * 31;
        boolean z19 = this.isVOIPCallingEnabled;
        if (z19) {
            z19 = true;
        }
        int i18 = (i17 + (z19 ? 1 : 0)) * 31;
        boolean z21 = this.translations;
        if (z21) {
            z21 = true;
        }
        int i19 = (i18 + (z21 ? 1 : 0)) * 31;
        boolean z22 = this.isRemoteConfigurationEnabled;
        if (!z22) {
            z12 = z22;
        }
        return i19 + (z12 ? 1 : 0);
    }

    public final boolean isLocationSharingEnabled() {
        return this.isLocationSharingEnabled;
    }

    public final boolean isPhoneCallingEnabled() {
        return this.isPhoneCallingEnabled;
    }

    public final boolean isPhotoSharingEnabled() {
        return this.isPhotoSharingEnabled;
    }

    public final boolean isRemoteConfigurationEnabled() {
        return this.isRemoteConfigurationEnabled;
    }

    public final boolean isReplyingMandatory() {
        return this.isReplyingMandatory;
    }

    public final boolean isVOIPCallingEnabled() {
        return this.isVOIPCallingEnabled;
    }

    @NotNull
    public String toString() {
        return "FeatureFlagProperties(stackFromEnd=" + this.stackFromEnd + ", isReplyingMandatory=" + this.isReplyingMandatory + ", isPhotoSharingEnabled=" + this.isPhotoSharingEnabled + ", hideAdminMessages=" + this.hideAdminMessages + ", showSenderName=" + this.showSenderName + ", isLocationSharingEnabled=" + this.isLocationSharingEnabled + ", isPhoneCallingEnabled=" + this.isPhoneCallingEnabled + ", isVOIPCallingEnabled=" + this.isVOIPCallingEnabled + ", translations=" + this.translations + ", isRemoteConfigurationEnabled=" + this.isRemoteConfigurationEnabled + ')';
    }
}
