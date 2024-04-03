package com.deliveryhero.chatui.view.util;

import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.deliveryhero.chatui.view.chatroom.navigator.ImageSelectionType;
import com.deliveryhero.customerchat.commons.ChatPreferences;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fJ#\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010\u001e\u001a\u00020\u0006*\u00020\u00182\u0006\u0010\u001f\u001a\u00020\rH\u0002R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068B@BX\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/deliveryhero/chatui/view/util/PermissionModule;", "", "preferences", "Lcom/deliveryhero/customerchat/commons/ChatPreferences;", "(Lcom/deliveryhero/customerchat/commons/ChatPreferences;)V", "value", "", "isDeniedJustNow", "()Z", "setDeniedJustNow", "(Z)V", "getRequiredPermissions", "", "", "type", "Lcom/deliveryhero/chatui/view/chatroom/navigator/ImageSelectionType;", "(Lcom/deliveryhero/chatui/view/chatroom/navigator/ImageSelectionType;)[Ljava/lang/String;", "grantPermission", "", "fragment", "Landroidx/fragment/app/Fragment;", "isPermissionsGrantRequired", "readPermissionsRequired", "context", "Landroid/content/Context;", "permissions", "(Landroid/content/Context;[Ljava/lang/String;)Z", "shouldShowSettingsIfPermanentlyDenied", "requestCode", "", "hasPermissionDeclared", "permission", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PermissionModule {
    @NotNull
    private static final String[] CAMERA_PERMISSIONS = {"android.permission.CAMERA"};
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int GRANT_PERMISSION_OPEN_CAMERA_REQUEST_CODE = 25661;
    @NotNull
    private final ChatPreferences preferences;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/deliveryhero/chatui/view/util/PermissionModule$Companion;", "", "()V", "CAMERA_PERMISSIONS", "", "", "[Ljava/lang/String;", "GRANT_PERMISSION_OPEN_CAMERA_REQUEST_CODE", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PermissionModule(@NotNull ChatPreferences chatPreferences) {
        Intrinsics.checkNotNullParameter(chatPreferences, "preferences");
        this.preferences = chatPreferences;
    }

    private final String[] getRequiredPermissions(ImageSelectionType imageSelectionType) {
        if (imageSelectionType instanceof ImageSelectionType.CAMERA) {
            return CAMERA_PERMISSIONS;
        }
        if (imageSelectionType instanceof ImageSelectionType.GALLERY) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final boolean hasPermissionDeclared(Context context, String str) {
        String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
        Intrinsics.checkNotNullExpressionValue(strArr, "packageManager\n        .…    .requestedPermissions");
        return ArraysKt___ArraysKt.contains((T[]) strArr, str);
    }

    private final boolean isDeniedJustNow() {
        return this.preferences.getPermissionDeniedJustNow();
    }

    private final boolean readPermissionsRequired(Context context, String[] strArr) {
        for (String checkSelfPermission : strArr) {
            if (ContextCompat.checkSelfPermission(context, checkSelfPermission) != 0) {
                return true;
            }
        }
        return false;
    }

    private final void setDeniedJustNow(boolean z11) {
        this.preferences.setPermissionDeniedJustNow(z11);
    }

    public final void grantPermission(@NotNull Fragment fragment, @NotNull ImageSelectionType imageSelectionType) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(imageSelectionType, "type");
        String[] requiredPermissions = getRequiredPermissions(imageSelectionType);
        if (requiredPermissions != null) {
            fragment.requestPermissions(requiredPermissions, GRANT_PERMISSION_OPEN_CAMERA_REQUEST_CODE);
        }
    }

    public final boolean isPermissionsGrantRequired(@NotNull Fragment fragment, @NotNull ImageSelectionType imageSelectionType) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(imageSelectionType, "type");
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
        String[] requiredPermissions = getRequiredPermissions(imageSelectionType);
        if (requiredPermissions == null) {
            return false;
        }
        return readPermissionsRequired(requireContext, requiredPermissions);
    }

    public final boolean shouldShowSettingsIfPermanentlyDenied(@NotNull Fragment fragment, int i11) {
        String[] strArr;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (i11 == 25661) {
            String[] strArr2 = CAMERA_PERMISSIONS;
            ArrayList arrayList = new ArrayList();
            for (String str : strArr2) {
                Context requireContext = fragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
                if (hasPermissionDeclared(requireContext, str)) {
                    arrayList.add(str);
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            strArr = (String[]) array;
        } else {
            strArr = new String[0];
        }
        for (String shouldShowRequestPermissionRationale : strArr) {
            if (!fragment.shouldShowRequestPermissionRationale(shouldShowRequestPermissionRationale)) {
                if (!isDeniedJustNow()) {
                    return true;
                }
                setDeniedJustNow(false);
            }
        }
        return false;
    }
}
