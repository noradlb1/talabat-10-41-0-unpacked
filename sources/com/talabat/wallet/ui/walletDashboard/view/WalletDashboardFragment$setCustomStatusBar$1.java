package com.talabat.wallet.ui.walletDashboard.view;

import android.content.Context;
import android.view.Window;
import androidx.core.content.ContextCompat;
import com.talabat.talabatcommon.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "window", "Landroid/view/Window;", "context", "Landroid/content/Context;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WalletDashboardFragment$setCustomStatusBar$1 extends Lambda implements Function2<Window, Context, Unit> {
    public static final WalletDashboardFragment$setCustomStatusBar$1 INSTANCE = new WalletDashboardFragment$setCustomStatusBar$1();

    public WalletDashboardFragment$setCustomStatusBar$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Window) obj, (Context) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Window window, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(context, "context");
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(ContextCompat.getColor(context, R.color.sec_blue_10));
    }
}
