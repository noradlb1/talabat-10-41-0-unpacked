package com.talabat.talabatcore.permissions.impl;

import android.content.Context;
import com.talabat.talabatcore.permissions.Permissions;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/talabatcore/permissions/impl/TalabatPermissions;", "Lcom/talabat/talabatcore/permissions/Permissions;", "()V", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatPermissions implements Permissions {
    @NotNull
    public String[] getPermissionArray(@NotNull Context context, @NotNull String[] strArr) {
        return Permissions.DefaultImpls.getPermissionArray(this, context, strArr);
    }

    public boolean isPermissionGranted(@NotNull Context context, @NotNull String str) {
        return Permissions.DefaultImpls.isPermissionGranted(this, context, str);
    }
}
