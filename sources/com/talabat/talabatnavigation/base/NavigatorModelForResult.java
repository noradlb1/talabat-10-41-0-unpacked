package com.talabat.talabatnavigation.base;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B>\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0019\b\u0002\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatnavigation/base/NavigatorModelForResult;", "Lcom/talabat/talabatnavigation/base/NavigatorModel;", "action", "", "options", "Landroid/os/Bundle;", "init", "Lkotlin/Function1;", "Landroid/content/Intent;", "", "Lkotlin/ExtensionFunctionType;", "requestCode", "", "(Ljava/lang/String;Landroid/os/Bundle;Lkotlin/jvm/functions/Function1;I)V", "getRequestCode", "()I", "setRequestCode", "(I)V", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavigatorModelForResult extends NavigatorModel {
    private int requestCode;

    public NavigatorModelForResult() {
        this((String) null, (Bundle) null, (Function1) null, 0, 15, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavigatorModelForResult(String str, Bundle bundle, Function1 function1, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? "" : str, (i12 & 2) != 0 ? new Bundle() : bundle, (i12 & 4) != 0 ? AnonymousClass1.INSTANCE : function1, (i12 & 8) != 0 ? -1 : i11);
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final void setRequestCode(int i11) {
        this.requestCode = i11;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigatorModelForResult(@NotNull String str, @NotNull Bundle bundle, @NotNull Function1<? super Intent, Unit> function1, int i11) {
        super(str, bundle, function1);
        Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
        Intrinsics.checkNotNullParameter(bundle, "options");
        Intrinsics.checkNotNullParameter(function1, "init");
        this.requestCode = i11;
    }
}
