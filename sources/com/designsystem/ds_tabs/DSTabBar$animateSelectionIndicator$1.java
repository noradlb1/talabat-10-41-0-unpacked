package com.designsystem.ds_tabs;

import com.designsystem.ds_selection_indicator.DSSelectionIndicator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class DSTabBar$animateSelectionIndicator$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSSelectionIndicator f33039g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f33040h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSTabBar$animateSelectionIndicator$1(DSSelectionIndicator dSSelectionIndicator, boolean z11) {
        super(0);
        this.f33039g = dSSelectionIndicator;
        this.f33040h = z11;
    }

    public final void invoke() {
        DSSelectionIndicator dSSelectionIndicator = this.f33039g;
        if (dSSelectionIndicator != null) {
            dSSelectionIndicator.setVisibility(this.f33040h ? 0 : 8);
        }
    }
}
