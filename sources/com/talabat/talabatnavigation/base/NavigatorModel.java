package com.talabat.talabatnavigation.base;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B6\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0019\b\u0002\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/talabat/talabatnavigation/base/NavigatorModel;", "", "action", "", "options", "Landroid/os/Bundle;", "init", "Lkotlin/Function1;", "Landroid/content/Intent;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Landroid/os/Bundle;Lkotlin/jvm/functions/Function1;)V", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "getInit", "()Lkotlin/jvm/functions/Function1;", "setInit", "(Lkotlin/jvm/functions/Function1;)V", "getOptions", "()Landroid/os/Bundle;", "setOptions", "(Landroid/os/Bundle;)V", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class NavigatorModel {
    @NotNull
    private String action;
    @NotNull
    private Function1<? super Intent, Unit> init;
    @NotNull
    private Bundle options;

    @JvmOverloads
    public NavigatorModel() {
        this((String) null, (Bundle) null, (Function1) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NavigatorModel(@NotNull String str) {
        this(str, (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NavigatorModel(@NotNull String str, @NotNull Bundle bundle) {
        this(str, bundle, (Function1) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
        Intrinsics.checkNotNullParameter(bundle, "options");
    }

    @JvmOverloads
    public NavigatorModel(@NotNull String str, @NotNull Bundle bundle, @NotNull Function1<? super Intent, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
        Intrinsics.checkNotNullParameter(bundle, "options");
        Intrinsics.checkNotNullParameter(function1, "init");
        this.action = str;
        this.options = bundle;
        this.init = function1;
    }

    @NotNull
    public final String getAction() {
        return this.action;
    }

    @NotNull
    public final Function1<Intent, Unit> getInit() {
        return this.init;
    }

    @NotNull
    public final Bundle getOptions() {
        return this.options;
    }

    public final void setAction(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.action = str;
    }

    public final void setInit(@NotNull Function1<? super Intent, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.init = function1;
    }

    public final void setOptions(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<set-?>");
        this.options = bundle;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavigatorModel(String str, Bundle bundle, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? new Bundle() : bundle, (i11 & 4) != 0 ? AnonymousClass1.INSTANCE : function1);
    }
}
