package androidx.compose.ui.window;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B9\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u001c\u0010\t\u001a\u00020\u00038GX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/window/DialogProperties;", "", "dismissOnBackPress", "", "dismissOnClickOutside", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "(ZZLandroidx/compose/ui/window/SecureFlagPolicy;)V", "usePlatformDefaultWidth", "decorFitsSystemWindows", "(ZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "getDecorFitsSystemWindows$annotations", "()V", "getDecorFitsSystemWindows", "()Z", "getDismissOnBackPress", "getDismissOnClickOutside", "getSecurePolicy", "()Landroidx/compose/ui/window/SecureFlagPolicy;", "getUsePlatformDefaultWidth", "equals", "other", "hashCode", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DialogProperties {
    private final boolean decorFitsSystemWindows;
    private final boolean dismissOnBackPress;
    private final boolean dismissOnClickOutside;
    @NotNull
    private final SecureFlagPolicy securePolicy;
    private final boolean usePlatformDefaultWidth;

    @ExperimentalComposeUiApi
    public DialogProperties() {
        this(false, false, (SecureFlagPolicy) null, false, false, 31, (DefaultConstructorMarker) null);
    }

    @ExperimentalComposeUiApi
    public DialogProperties(boolean z11, boolean z12, @NotNull SecureFlagPolicy secureFlagPolicy, boolean z13, boolean z14) {
        Intrinsics.checkNotNullParameter(secureFlagPolicy, "securePolicy");
        this.dismissOnBackPress = z11;
        this.dismissOnClickOutside = z12;
        this.securePolicy = secureFlagPolicy;
        this.usePlatformDefaultWidth = z13;
        this.decorFitsSystemWindows = z14;
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getDecorFitsSystemWindows$annotations() {
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DialogProperties)) {
            return false;
        }
        DialogProperties dialogProperties = (DialogProperties) obj;
        if (this.dismissOnBackPress == dialogProperties.dismissOnBackPress && this.dismissOnClickOutside == dialogProperties.dismissOnClickOutside && this.securePolicy == dialogProperties.securePolicy && this.usePlatformDefaultWidth == dialogProperties.usePlatformDefaultWidth && this.decorFitsSystemWindows == dialogProperties.decorFitsSystemWindows) {
            return true;
        }
        return false;
    }

    @ExperimentalComposeUiApi
    public final boolean getDecorFitsSystemWindows() {
        return this.decorFitsSystemWindows;
    }

    public final boolean getDismissOnBackPress() {
        return this.dismissOnBackPress;
    }

    public final boolean getDismissOnClickOutside() {
        return this.dismissOnClickOutside;
    }

    @NotNull
    public final SecureFlagPolicy getSecurePolicy() {
        return this.securePolicy;
    }

    public final boolean getUsePlatformDefaultWidth() {
        return this.usePlatformDefaultWidth;
    }

    public int hashCode() {
        return (((((((e.a(this.dismissOnBackPress) * 31) + e.a(this.dismissOnClickOutside)) * 31) + this.securePolicy.hashCode()) * 31) + e.a(this.usePlatformDefaultWidth)) * 31) + e.a(this.decorFitsSystemWindows);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DialogProperties(boolean r5, boolean r6, androidx.compose.ui.window.SecureFlagPolicy r7, boolean r8, boolean r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 1
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            androidx.compose.ui.window.SecureFlagPolicy r7 = androidx.compose.ui.window.SecureFlagPolicy.Inherit
        L_0x0015:
            r2 = r7
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>((boolean) r6, (boolean) r7, (androidx.compose.ui.window.SecureFlagPolicy) r8, (boolean) r9, (boolean) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.DialogProperties.<init>(boolean, boolean, androidx.compose.ui.window.SecureFlagPolicy, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DialogProperties(boolean z11, boolean z12, SecureFlagPolicy secureFlagPolicy, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? true : z11, (i11 & 2) != 0 ? true : z12, (i11 & 4) != 0 ? SecureFlagPolicy.Inherit : secureFlagPolicy);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DialogProperties(boolean z11, boolean z12, @NotNull SecureFlagPolicy secureFlagPolicy) {
        this(z11, z12, secureFlagPolicy, true, true);
        Intrinsics.checkNotNullParameter(secureFlagPolicy, "securePolicy");
    }
}
