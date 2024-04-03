package com.deliveryhero.customerchat.fwf;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003JY\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/deliveryhero/customerchat/fwf/UserFeatureFlags;", "", "isPhotoSharingEnabled", "", "isLocationSharingEnabled", "isTrackingEnabled", "isVOIPCacheClearingEnabled", "isVOIPSurveyEnabled", "isShowSenderNameEnabled", "isHideAdminMessagesEnabled", "isDisableChatOnChannelFrozenEnabled", "(ZZZZZZZZ)V", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserFeatureFlags {
    private final boolean isDisableChatOnChannelFrozenEnabled;
    private final boolean isHideAdminMessagesEnabled;
    private final boolean isLocationSharingEnabled;
    private final boolean isPhotoSharingEnabled;
    private final boolean isShowSenderNameEnabled;
    private final boolean isTrackingEnabled;
    private final boolean isVOIPCacheClearingEnabled;
    private final boolean isVOIPSurveyEnabled;

    public UserFeatureFlags() {
        this(false, false, false, false, false, false, false, false, 255, (DefaultConstructorMarker) null);
    }

    public UserFeatureFlags(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18) {
        this.isPhotoSharingEnabled = z11;
        this.isLocationSharingEnabled = z12;
        this.isTrackingEnabled = z13;
        this.isVOIPCacheClearingEnabled = z14;
        this.isVOIPSurveyEnabled = z15;
        this.isShowSenderNameEnabled = z16;
        this.isHideAdminMessagesEnabled = z17;
        this.isDisableChatOnChannelFrozenEnabled = z18;
    }

    public static /* synthetic */ UserFeatureFlags copy$default(UserFeatureFlags userFeatureFlags, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, int i11, Object obj) {
        UserFeatureFlags userFeatureFlags2 = userFeatureFlags;
        int i12 = i11;
        return userFeatureFlags.copy((i12 & 1) != 0 ? userFeatureFlags2.isPhotoSharingEnabled : z11, (i12 & 2) != 0 ? userFeatureFlags2.isLocationSharingEnabled : z12, (i12 & 4) != 0 ? userFeatureFlags2.isTrackingEnabled : z13, (i12 & 8) != 0 ? userFeatureFlags2.isVOIPCacheClearingEnabled : z14, (i12 & 16) != 0 ? userFeatureFlags2.isVOIPSurveyEnabled : z15, (i12 & 32) != 0 ? userFeatureFlags2.isShowSenderNameEnabled : z16, (i12 & 64) != 0 ? userFeatureFlags2.isHideAdminMessagesEnabled : z17, (i12 & 128) != 0 ? userFeatureFlags2.isDisableChatOnChannelFrozenEnabled : z18);
    }

    public final boolean component1() {
        return this.isPhotoSharingEnabled;
    }

    public final boolean component2() {
        return this.isLocationSharingEnabled;
    }

    public final boolean component3() {
        return this.isTrackingEnabled;
    }

    public final boolean component4() {
        return this.isVOIPCacheClearingEnabled;
    }

    public final boolean component5() {
        return this.isVOIPSurveyEnabled;
    }

    public final boolean component6() {
        return this.isShowSenderNameEnabled;
    }

    public final boolean component7() {
        return this.isHideAdminMessagesEnabled;
    }

    public final boolean component8() {
        return this.isDisableChatOnChannelFrozenEnabled;
    }

    @NotNull
    public final UserFeatureFlags copy(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18) {
        return new UserFeatureFlags(z11, z12, z13, z14, z15, z16, z17, z18);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserFeatureFlags)) {
            return false;
        }
        UserFeatureFlags userFeatureFlags = (UserFeatureFlags) obj;
        return this.isPhotoSharingEnabled == userFeatureFlags.isPhotoSharingEnabled && this.isLocationSharingEnabled == userFeatureFlags.isLocationSharingEnabled && this.isTrackingEnabled == userFeatureFlags.isTrackingEnabled && this.isVOIPCacheClearingEnabled == userFeatureFlags.isVOIPCacheClearingEnabled && this.isVOIPSurveyEnabled == userFeatureFlags.isVOIPSurveyEnabled && this.isShowSenderNameEnabled == userFeatureFlags.isShowSenderNameEnabled && this.isHideAdminMessagesEnabled == userFeatureFlags.isHideAdminMessagesEnabled && this.isDisableChatOnChannelFrozenEnabled == userFeatureFlags.isDisableChatOnChannelFrozenEnabled;
    }

    public int hashCode() {
        boolean z11 = this.isPhotoSharingEnabled;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (z11 ? 1 : 0) * true;
        boolean z13 = this.isLocationSharingEnabled;
        if (z13) {
            z13 = true;
        }
        int i12 = (i11 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.isTrackingEnabled;
        if (z14) {
            z14 = true;
        }
        int i13 = (i12 + (z14 ? 1 : 0)) * 31;
        boolean z15 = this.isVOIPCacheClearingEnabled;
        if (z15) {
            z15 = true;
        }
        int i14 = (i13 + (z15 ? 1 : 0)) * 31;
        boolean z16 = this.isVOIPSurveyEnabled;
        if (z16) {
            z16 = true;
        }
        int i15 = (i14 + (z16 ? 1 : 0)) * 31;
        boolean z17 = this.isShowSenderNameEnabled;
        if (z17) {
            z17 = true;
        }
        int i16 = (i15 + (z17 ? 1 : 0)) * 31;
        boolean z18 = this.isHideAdminMessagesEnabled;
        if (z18) {
            z18 = true;
        }
        int i17 = (i16 + (z18 ? 1 : 0)) * 31;
        boolean z19 = this.isDisableChatOnChannelFrozenEnabled;
        if (!z19) {
            z12 = z19;
        }
        return i17 + (z12 ? 1 : 0);
    }

    public final boolean isDisableChatOnChannelFrozenEnabled() {
        return this.isDisableChatOnChannelFrozenEnabled;
    }

    public final boolean isHideAdminMessagesEnabled() {
        return this.isHideAdminMessagesEnabled;
    }

    public final boolean isLocationSharingEnabled() {
        return this.isLocationSharingEnabled;
    }

    public final boolean isPhotoSharingEnabled() {
        return this.isPhotoSharingEnabled;
    }

    public final boolean isShowSenderNameEnabled() {
        return this.isShowSenderNameEnabled;
    }

    public final boolean isTrackingEnabled() {
        return this.isTrackingEnabled;
    }

    public final boolean isVOIPCacheClearingEnabled() {
        return this.isVOIPCacheClearingEnabled;
    }

    public final boolean isVOIPSurveyEnabled() {
        return this.isVOIPSurveyEnabled;
    }

    @NotNull
    public String toString() {
        return "UserFeatureFlags(isPhotoSharingEnabled=" + this.isPhotoSharingEnabled + ", isLocationSharingEnabled=" + this.isLocationSharingEnabled + ", isTrackingEnabled=" + this.isTrackingEnabled + ", isVOIPCacheClearingEnabled=" + this.isVOIPCacheClearingEnabled + ", isVOIPSurveyEnabled=" + this.isVOIPSurveyEnabled + ", isShowSenderNameEnabled=" + this.isShowSenderNameEnabled + ", isHideAdminMessagesEnabled=" + this.isHideAdminMessagesEnabled + ", isDisableChatOnChannelFrozenEnabled=" + this.isDisableChatOnChannelFrozenEnabled + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UserFeatureFlags(boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0033
            r8 = r2
            goto L_0x0035
        L_0x0033:
            r8 = r16
        L_0x0035:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r2 = r17
        L_0x003c:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.fwf.UserFeatureFlags.<init>(boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
