package com.talabat.talabatcommon.extension;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ViewKt$get$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f46876g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Boolean f46877h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f46878i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewKt$get$1(View view, Boolean bool, int i11) {
        super(0);
        this.f46876g = view;
        this.f46877h = bool;
        this.f46878i = i11;
    }

    public final void invoke() {
        this.f46876g.setVisibility(Intrinsics.areEqual((Object) this.f46877h, (Object) Boolean.TRUE) ? 0 : this.f46878i);
    }
}
