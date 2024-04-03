package com.deliveryhero.customerchat.voip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.deliveryhero.customerchat.R;
import com.deliveryhero.customerchat.telephony.domain.TokuAssets;
import com.deliveryhero.customerchat.view.util.AttributeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/deliveryhero/customerchat/voip/TokuAssetsImpl;", "Lcom/deliveryhero/customerchat/telephony/domain/TokuAssets;", "context", "Landroid/content/Context;", "attributeUtils", "Lcom/deliveryhero/customerchat/view/util/AttributeUtils;", "(Landroid/content/Context;Lcom/deliveryhero/customerchat/view/util/AttributeUtils;)V", "avatar", "Landroid/graphics/drawable/Drawable;", "getAvatar", "()Landroid/graphics/drawable/Drawable;", "avatarBackgroundColor", "", "getAvatarBackgroundColor", "()I", "displayName", "", "getDisplayName", "()Ljava/lang/String;", "pushNotificationTitle", "getPushNotificationTitle", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokuAssetsImpl implements TokuAssets {
    @NotNull
    private final AttributeUtils attributeUtils;
    @NotNull
    private final Context context;

    public TokuAssetsImpl(@NotNull Context context2, @NotNull AttributeUtils attributeUtils2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(attributeUtils2, "attributeUtils");
        this.context = context2;
        this.attributeUtils = attributeUtils2;
    }

    @Nullable
    public Drawable getAvatar() {
        return this.attributeUtils.getIconDrawable(this.context, R.attr.customerChatCallScreenAvatar);
    }

    public int getAvatarBackgroundColor() {
        return this.attributeUtils.getColorInt(this.context, R.attr.customerChatCallScreenAvatarBackgroundColor);
    }

    @NotNull
    public String getDisplayName() {
        return this.attributeUtils.getStringAttribute(this.context, R.attr.customerChatCallScreenDisplayName);
    }

    @NotNull
    public String getPushNotificationTitle() {
        return this.attributeUtils.getStringAttribute(this.context, R.attr.customerChatCallNotificationTitle);
    }
}
