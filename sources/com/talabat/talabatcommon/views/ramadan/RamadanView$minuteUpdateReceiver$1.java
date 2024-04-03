package com.talabat.talabatcommon.views.ramadan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.talabat.talabatcommon.views.ramadan.viewModel.RamadanViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/talabat/talabatcommon/views/ramadan/RamadanView$minuteUpdateReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RamadanView$minuteUpdateReceiver$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RamadanView f11732a;

    public RamadanView$minuteUpdateReceiver$1(RamadanView ramadanView) {
        this.f11732a = ramadanView;
    }

    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        ((RamadanViewModel) this.f11732a.getViewModel()).showClock();
    }
}
