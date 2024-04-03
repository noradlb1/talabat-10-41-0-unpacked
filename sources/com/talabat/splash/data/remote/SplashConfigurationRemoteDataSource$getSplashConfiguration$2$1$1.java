package com.talabat.splash.data.remote;

import com.talabat.splash.data.model.SplashConfiguration;
import com.talabat.splash.data.remote.dto.SplashConfigurationDto;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/splash/data/remote/dto/SplashConfigurationDto;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SplashConfigurationRemoteDataSource$getSplashConfiguration$2$1$1 extends Lambda implements Function1<SplashConfigurationDto, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Continuation<SplashConfiguration> f61445g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SplashConfigurationRemoteDataSource f61446h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplashConfigurationRemoteDataSource$getSplashConfiguration$2$1$1(Continuation<? super SplashConfiguration> continuation, SplashConfigurationRemoteDataSource splashConfigurationRemoteDataSource) {
        super(1);
        this.f61445g = continuation;
        this.f61446h = splashConfigurationRemoteDataSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SplashConfigurationDto) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SplashConfigurationDto splashConfigurationDto) {
        Intrinsics.checkNotNullParameter(splashConfigurationDto, "it");
        Continuation<SplashConfiguration> continuation = this.f61445g;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m6329constructorimpl(this.f61446h.toSplashConfiguration(splashConfigurationDto)));
    }
}
