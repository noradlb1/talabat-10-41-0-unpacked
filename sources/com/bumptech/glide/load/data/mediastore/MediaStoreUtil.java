package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;

public final class MediaStoreUtil {
    private static final int MINI_THUMB_HEIGHT = 384;
    private static final int MINI_THUMB_WIDTH = 512;

    private MediaStoreUtil() {
    }

    public static boolean isMediaStoreImageUri(Uri uri) {
        return isMediaStoreUri(uri) && !isVideoUri(uri);
    }

    public static boolean isMediaStoreUri(Uri uri) {
        if (uri == null || !"content".equals(uri.getScheme()) || !ShareConstants.WEB_DIALOG_PARAM_MEDIA.equals(uri.getAuthority())) {
            return false;
        }
        return true;
    }

    public static boolean isMediaStoreVideoUri(Uri uri) {
        return isMediaStoreUri(uri) && isVideoUri(uri);
    }

    public static boolean isThumbnailSize(int i11, int i12) {
        return i11 != Integer.MIN_VALUE && i12 != Integer.MIN_VALUE && i11 <= 512 && i12 <= 384;
    }

    private static boolean isVideoUri(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
