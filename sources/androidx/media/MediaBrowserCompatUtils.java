package androidx.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MediaBrowserCompatUtils {
    private MediaBrowserCompatUtils() {
    }

    public static boolean areSameOptions(Bundle bundle, Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        if (bundle == null) {
            if (bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1) {
                return true;
            }
            return false;
        } else if (bundle2 == null) {
            if (bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1) {
                return true;
            }
            return false;
        } else if (bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) && bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean hasDuplicatedItems(Bundle bundle, Bundle bundle2) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        if (bundle == null) {
            i11 = -1;
        } else {
            i11 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        }
        if (bundle2 == null) {
            i12 = -1;
        } else {
            i12 = bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        }
        if (bundle == null) {
            i13 = -1;
        } else {
            i13 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        }
        if (bundle2 == null) {
            i14 = -1;
        } else {
            i14 = bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        }
        int i18 = Integer.MAX_VALUE;
        if (i11 == -1 || i13 == -1) {
            i15 = Integer.MAX_VALUE;
            i16 = 0;
        } else {
            i16 = i11 * i13;
            i15 = (i13 + i16) - 1;
        }
        if (i12 == -1 || i14 == -1) {
            i17 = 0;
        } else {
            i17 = i12 * i14;
            i18 = (i14 + i17) - 1;
        }
        if (i15 < i17 || i18 < i16) {
            return false;
        }
        return true;
    }
}
