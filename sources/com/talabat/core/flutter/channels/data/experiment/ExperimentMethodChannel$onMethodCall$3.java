package com.talabat.core.flutter.channels.data.experiment;

import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "experimentName", "", "projectName", "defaultValue", "", "strategy", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExperimentMethodChannel$onMethodCall$3 extends Lambda implements Function4<String, String, Double, String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ExperimentMethodChannel f55885g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f55886h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExperimentMethodChannel$onMethodCall$3(ExperimentMethodChannel experimentMethodChannel, MethodChannel.Result result) {
        super(4);
        this.f55885g = experimentMethodChannel;
        this.f55886h = result;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((String) obj, (String) obj2, ((Number) obj3).doubleValue(), (String) obj4);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str, @Nullable String str2, double d11, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "experimentName");
        this.f55886h.success(Double.valueOf(this.f55885g.callback.getDoubleVariant(str, str2, d11, str3)));
    }
}
