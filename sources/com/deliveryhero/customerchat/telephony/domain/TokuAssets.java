package com.deliveryhero.customerchat.telephony.domain;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/customerchat/telephony/domain/TokuAssets;", "", "avatar", "Landroid/graphics/drawable/Drawable;", "getAvatar", "()Landroid/graphics/drawable/Drawable;", "avatarBackgroundColor", "", "getAvatarBackgroundColor", "()I", "displayName", "", "getDisplayName", "()Ljava/lang/String;", "pushNotificationTitle", "getPushNotificationTitle", "telephony_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TokuAssets {
    @Nullable
    Drawable getAvatar();

    int getAvatarBackgroundColor();

    @NotNull
    String getDisplayName();

    @NotNull
    String getPushNotificationTitle();
}
