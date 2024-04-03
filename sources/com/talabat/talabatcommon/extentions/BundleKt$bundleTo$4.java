package com.talabat.talabatcommon.extentions;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/os/Bundle;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BundleKt$bundleTo$4 extends Lambda implements Function1<Bundle, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f46966g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f46967h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BundleKt$bundleTo$4(String str, int i11) {
        super(1);
        this.f46966g = str;
        this.f46967h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Bundle) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "it");
        BundleKt.set(bundle, this.f46966g, this.f46967h);
    }
}
