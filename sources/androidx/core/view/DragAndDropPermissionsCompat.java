package androidx.core.view;

import android.app.Activity;
import android.os.Build;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

public final class DragAndDropPermissionsCompat {
    private final DragAndDropPermissions mDragAndDropPermissions;

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static void a(DragAndDropPermissions dragAndDropPermissions) {
            dragAndDropPermissions.release();
        }

        @DoNotInline
        public static DragAndDropPermissions b(Activity activity, DragEvent dragEvent) {
            return activity.requestDragAndDropPermissions(dragEvent);
        }
    }

    private DragAndDropPermissionsCompat(DragAndDropPermissions dragAndDropPermissions) {
        this.mDragAndDropPermissions = dragAndDropPermissions;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static DragAndDropPermissionsCompat request(@NonNull Activity activity, @NonNull DragEvent dragEvent) {
        DragAndDropPermissions b11;
        if (Build.VERSION.SDK_INT < 24 || (b11 = Api24Impl.b(activity, dragEvent)) == null) {
            return null;
        }
        return new DragAndDropPermissionsCompat(b11);
    }

    public void release() {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.a(this.mDragAndDropPermissions);
        }
    }
}
