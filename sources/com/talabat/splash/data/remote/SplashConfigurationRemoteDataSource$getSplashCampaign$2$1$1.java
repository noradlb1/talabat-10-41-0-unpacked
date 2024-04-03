package com.talabat.splash.data.remote;

import com.talabat.splash.data.model.SplashCampaign;
import com.talabat.splash.data.remote.dto.SplashCampaignDto;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/splash/data/remote/dto/SplashCampaignDto;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SplashConfigurationRemoteDataSource$getSplashCampaign$2$1$1 extends Lambda implements Function1<SplashCampaignDto, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Continuation<SplashCampaign> f61444g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplashConfigurationRemoteDataSource$getSplashCampaign$2$1$1(Continuation<? super SplashCampaign> continuation) {
        super(1);
        this.f61444g = continuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SplashCampaignDto) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SplashCampaignDto splashCampaignDto) {
        Intrinsics.checkNotNullParameter(splashCampaignDto, "it");
        Continuation<SplashCampaign> continuation = this.f61444g;
        Result.Companion companion = Result.Companion;
        String title = splashCampaignDto.getTitle();
        String str = "";
        if (title == null) {
            title = str;
        }
        String imagePath = splashCampaignDto.getImagePath();
        if (imagePath == null) {
            imagePath = str;
        }
        String imageWidth = splashCampaignDto.getImageWidth();
        if (imageWidth == null) {
            imageWidth = str;
        }
        String imageHeight = splashCampaignDto.getImageHeight();
        if (imageHeight != null) {
            str = imageHeight;
        }
        continuation.resumeWith(Result.m6329constructorimpl(new SplashCampaign(title, imagePath, imageWidth, str)));
    }
}
