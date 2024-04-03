package com.talabat.talabatcommon.extentions;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BroadcastsKt$receiver$1$onReceive$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<Intent, Unit> f46883g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Intent f46884h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BroadcastsKt$receiver$1$onReceive$1(Function1<? super Intent, Unit> function1, Intent intent) {
        super(0);
        this.f46883g = function1;
        this.f46884h = intent;
    }

    public final void invoke() {
        this.f46883g.invoke(this.f46884h);
    }
}
