package com.talabat.talabatcore.permissions;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.huawei.hms.push.AttributionReporter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcore/permissions/Permissions;", "", "getPermissionArray", "", "", "context", "Landroid/content/Context;", "permissions", "(Landroid/content/Context;[Ljava/lang/String;)[Ljava/lang/String;", "isPermissionGranted", "", "permission", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Permissions {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static String[] getPermissionArray(@NotNull Permissions permissions, @NotNull Context context, @NotNull String[] strArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(strArr, "permissions");
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (ContextCompat.checkSelfPermission(context, str) != 0) {
                    arrayList.add(str);
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        public static boolean isPermissionGranted(@NotNull Permissions permissions, @NotNull Context context, @NotNull String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, AttributionReporter.SYSTEM_PERMISSION);
            if (ContextCompat.checkSelfPermission(context, str) == 0) {
                return true;
            }
            return false;
        }
    }

    @NotNull
    String[] getPermissionArray(@NotNull Context context, @NotNull String[] strArr);

    boolean isPermissionGranted(@NotNull Context context, @NotNull String str);
}
