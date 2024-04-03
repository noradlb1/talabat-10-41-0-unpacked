package com.deliveryhero.customerchat.di;

import android.app.Application;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.koin.android.ext.koin.KoinExtKt;
import org.koin.core.KoinApplication;
import org.koin.core.module.Module;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lorg/koin/core/KoinApplication;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class MyKoinContext$init$1 extends Lambda implements Function1<KoinApplication, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Application f29827g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<Module> f29828h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MyKoinContext$init$1(Application application, List<Module> list) {
        super(1);
        this.f29827g = application;
        this.f29828h = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KoinApplication) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull KoinApplication koinApplication) {
        Intrinsics.checkNotNullParameter(koinApplication, "$this$koinApplication");
        KoinExtKt.androidContext(koinApplication, this.f29827g);
        koinApplication.modules(this.f29828h);
    }
}
