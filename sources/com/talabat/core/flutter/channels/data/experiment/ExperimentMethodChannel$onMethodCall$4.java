package com.talabat.core.flutter.channels.data.experiment;

import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "experimentName", "", "projectName", "defaultValue", "strategy", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExperimentMethodChannel$onMethodCall$4 extends Lambda implements Function4<String, String, String, String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ExperimentMethodChannel f55887g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f55888h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExperimentMethodChannel$onMethodCall$4(ExperimentMethodChannel experimentMethodChannel, MethodChannel.Result result) {
        super(4);
        this.f55887g = experimentMethodChannel;
        this.f55888h = result;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((String) obj, (String) obj2, (String) obj3, (String) obj4);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "experimentName");
        Intrinsics.checkNotNullParameter(str3, "defaultValue");
        this.f55888h.success(this.f55887g.callback.getStringVariant(str, str2, str3, str4));
    }
}
