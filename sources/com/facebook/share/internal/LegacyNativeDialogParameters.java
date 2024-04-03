package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.internal.Utility;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import com.huawei.hms.api.FailedBinderCallBack;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002J*\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0007J \u0010\u0013\u001a\u00020\u00042\u000e\u0010\u0014\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u0015"}, d2 = {"Lcom/facebook/share/internal/LegacyNativeDialogParameters;", "", "()V", "create", "Landroid/os/Bundle;", "linkContent", "Lcom/facebook/share/model/ShareLinkContent;", "dataErrorsFatal", "", "photoContent", "Lcom/facebook/share/model/SharePhotoContent;", "imageUrls", "", "", "callId", "Ljava/util/UUID;", "shareContent", "Lcom/facebook/share/model/ShareContent;", "shouldFailOnDataError", "createBaseParameters", "content", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LegacyNativeDialogParameters {
    @NotNull
    public static final LegacyNativeDialogParameters INSTANCE = new LegacyNativeDialogParameters();

    private LegacyNativeDialogParameters() {
    }

    @JvmStatic
    @Nullable
    public static final Bundle create(@NotNull UUID uuid, @NotNull ShareContent<?, ?> shareContent, boolean z11) {
        Intrinsics.checkNotNullParameter(uuid, FailedBinderCallBack.CALLER_ID);
        Intrinsics.checkNotNullParameter(shareContent, "shareContent");
        if (shareContent instanceof ShareLinkContent) {
            return INSTANCE.create((ShareLinkContent) shareContent, z11);
        }
        if (shareContent instanceof SharePhotoContent) {
            ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            List<String> photoUrls = ShareInternalUtility.getPhotoUrls(sharePhotoContent, uuid);
            if (photoUrls == null) {
                photoUrls = CollectionsKt__CollectionsKt.emptyList();
            }
            return INSTANCE.create(sharePhotoContent, photoUrls, z11);
        }
        boolean z12 = shareContent instanceof ShareVideoContent;
        return null;
    }

    private final Bundle createBaseParameters(ShareContent<?, ?> shareContent, boolean z11) {
        boolean z12;
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        Utility.putUri(bundle, ShareConstants.LEGACY_LINK, shareContent.getContentUrl());
        Utility.putNonEmptyString(bundle, ShareConstants.LEGACY_PLACE_TAG, shareContent.getPlaceId());
        Utility.putNonEmptyString(bundle, ShareConstants.LEGACY_REF, shareContent.getRef());
        bundle.putBoolean(ShareConstants.LEGACY_DATA_FAILURES_FATAL, z11);
        Collection peopleIds = shareContent.getPeopleIds();
        if (peopleIds == null || peopleIds.isEmpty()) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            bundle.putStringArrayList(ShareConstants.LEGACY_FRIEND_TAGS, new ArrayList(peopleIds));
        }
        return bundle;
    }

    private final Bundle create(ShareLinkContent shareLinkContent, boolean z11) {
        return createBaseParameters(shareLinkContent, z11);
    }

    private final Bundle create(SharePhotoContent sharePhotoContent, List<String> list, boolean z11) {
        Bundle createBaseParameters = createBaseParameters(sharePhotoContent, z11);
        createBaseParameters.putStringArrayList(ShareConstants.LEGACY_PHOTOS, new ArrayList(list));
        return createBaseParameters;
    }
}
