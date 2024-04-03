package cn;

import android.view.View;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMissionItem;
import com.talabat.feature.mission.control.presentation.adapter.LifestyleMissionViewHolder;
import kotlin.jvm.functions.Function3;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function3 f58217b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LifestyleMissionItem f58218c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f58219d;

    public /* synthetic */ a(Function3 function3, LifestyleMissionItem lifestyleMissionItem, int i11) {
        this.f58217b = function3;
        this.f58218c = lifestyleMissionItem;
        this.f58219d = i11;
    }

    public final void onClick(View view) {
        LifestyleMissionViewHolder.m10228bind$lambda0(this.f58217b, this.f58218c, this.f58219d, view);
    }
}
