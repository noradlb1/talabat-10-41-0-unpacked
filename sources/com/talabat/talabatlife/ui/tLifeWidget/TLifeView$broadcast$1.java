package com.talabat.talabatlife.ui.tLifeWidget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.RelativeLayout;
import com.talabat.talabatlife.R;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/talabat/talabatlife/ui/tLifeWidget/TLifeView$broadcast$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifeView$broadcast$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TLifeView f12083a;

    public TLifeView$broadcast$1(TLifeView tLifeView) {
        this.f12083a = tLifeView;
    }

    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        ((RelativeLayout) this.f12083a._$_findCachedViewById(R.id.tLifeWidgetRestaurantsRelativeLayout)).performClick();
    }
}
