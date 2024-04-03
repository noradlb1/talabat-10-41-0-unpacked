package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.IdRes;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/navigation/NavAction;", "", "destinationId", "", "navOptions", "Landroidx/navigation/NavOptions;", "defaultArguments", "Landroid/os/Bundle;", "(ILandroidx/navigation/NavOptions;Landroid/os/Bundle;)V", "getDefaultArguments", "()Landroid/os/Bundle;", "setDefaultArguments", "(Landroid/os/Bundle;)V", "getDestinationId", "()I", "getNavOptions", "()Landroidx/navigation/NavOptions;", "setNavOptions", "(Landroidx/navigation/NavOptions;)V", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavAction {
    @Nullable
    private Bundle defaultArguments;
    @IdRes
    private final int destinationId;
    @Nullable
    private NavOptions navOptions;

    @JvmOverloads
    public NavAction(@IdRes int i11) {
        this(i11, (NavOptions) null, (Bundle) null, 6, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public NavAction(@IdRes int i11, @Nullable NavOptions navOptions2) {
        this(i11, navOptions2, (Bundle) null, 4, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public NavAction(@IdRes int i11, @Nullable NavOptions navOptions2, @Nullable Bundle bundle) {
        this.destinationId = i11;
        this.navOptions = navOptions2;
        this.defaultArguments = bundle;
    }

    @Nullable
    public final Bundle getDefaultArguments() {
        return this.defaultArguments;
    }

    public final int getDestinationId() {
        return this.destinationId;
    }

    @Nullable
    public final NavOptions getNavOptions() {
        return this.navOptions;
    }

    public final void setDefaultArguments(@Nullable Bundle bundle) {
        this.defaultArguments = bundle;
    }

    public final void setNavOptions(@Nullable NavOptions navOptions2) {
        this.navOptions = navOptions2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavAction(int i11, NavOptions navOptions2, Bundle bundle, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i12 & 2) != 0 ? null : navOptions2, (i12 & 4) != 0 ? null : bundle);
    }
}
