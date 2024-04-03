package com.talabat.vendormenu.presentation.flutter.channels;

import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatProMethodChannel$onMethodCall$1 extends Lambda implements Function1<Map<String, ? extends Object>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f12444g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatProMethodChannel$onMethodCall$1(MethodChannel.Result result) {
        super(1);
        this.f12444g = result;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Map<String, ? extends Object>) (Map) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "it");
        this.f12444g.success(map);
    }
}
