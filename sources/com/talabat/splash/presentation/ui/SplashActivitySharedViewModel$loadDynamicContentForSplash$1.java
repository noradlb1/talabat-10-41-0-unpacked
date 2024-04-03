package com.talabat.splash.presentation.ui;

import com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase;
import com.talabat.splash.presentation.ui.displaymodel.Campaign;
import com.talabat.splash.presentation.ui.displaymodel.Content;
import com.talabat.splash.presentation.ui.displaymodel.SplashContentDisplayModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.splash.presentation.ui.SplashActivitySharedViewModel$loadDynamicContentForSplash$1", f = "SplashActivitySharedViewModel.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
public final class SplashActivitySharedViewModel$loadDynamicContentForSplash$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61535h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SplashActivitySharedViewModel f61536i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<SplashContentDisplayModel, Unit> f61537j;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[GetDynamicSplashContentUseCase.DynamicSplashContent.Configuration.Dynamic.ScaleType.values().length];
            iArr[GetDynamicSplashContentUseCase.DynamicSplashContent.Configuration.Dynamic.ScaleType.SCALE_FILL.ordinal()] = 1;
            iArr[GetDynamicSplashContentUseCase.DynamicSplashContent.Configuration.Dynamic.ScaleType.CENTER.ordinal()] = 2;
            iArr[GetDynamicSplashContentUseCase.DynamicSplashContent.Configuration.Dynamic.ScaleType.ASPECT_FIT.ordinal()] = 3;
            iArr[GetDynamicSplashContentUseCase.DynamicSplashContent.Configuration.Dynamic.ScaleType.ASPECT_FILL.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[GetDynamicSplashContentUseCase.DynamicSplashContent.Configuration.Dynamic.ResourceType.values().length];
            iArr2[GetDynamicSplashContentUseCase.DynamicSplashContent.Configuration.Dynamic.ResourceType.IMAGE.ordinal()] = 1;
            iArr2[GetDynamicSplashContentUseCase.DynamicSplashContent.Configuration.Dynamic.ResourceType.VIDEO.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplashActivitySharedViewModel$loadDynamicContentForSplash$1(SplashActivitySharedViewModel splashActivitySharedViewModel, Function1<? super SplashContentDisplayModel, Unit> function1, Continuation<? super SplashActivitySharedViewModel$loadDynamicContentForSplash$1> continuation) {
        super(2, continuation);
        this.f61536i = splashActivitySharedViewModel;
        this.f61537j = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SplashActivitySharedViewModel$loadDynamicContentForSplash$1(this.f61536i, this.f61537j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SplashActivitySharedViewModel$loadDynamicContentForSplash$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Content content;
        Campaign.Available available;
        Content.Dynamic.ScaleType scaleType;
        Content.Dynamic.ResourceType resourceType;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61535h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            GetDynamicSplashContentUseCase access$getGetDynamicSplashContentUseCase$p = this.f61536i.getDynamicSplashContentUseCase;
            this.f61535h = 1;
            obj = access$getGetDynamicSplashContentUseCase$p.getDynamicSplashContent(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        GetDynamicSplashContentUseCase.DynamicSplashContent dynamicSplashContent = (GetDynamicSplashContentUseCase.DynamicSplashContent) obj;
        GetDynamicSplashContentUseCase.DynamicSplashContent.Configuration component1 = dynamicSplashContent.component1();
        GetDynamicSplashContentUseCase.DynamicSplashContent.Campaign component2 = dynamicSplashContent.component2();
        if (component1 instanceof GetDynamicSplashContentUseCase.DynamicSplashContent.Configuration.Dynamic) {
            GetDynamicSplashContentUseCase.DynamicSplashContent.Configuration.Dynamic dynamic = (GetDynamicSplashContentUseCase.DynamicSplashContent.Configuration.Dynamic) component1;
            String backgroundColor = dynamic.getBackgroundColor();
            int i12 = WhenMappings.$EnumSwitchMapping$0[dynamic.getScaleType().ordinal()];
            if (i12 == 1) {
                scaleType = Content.Dynamic.ScaleType.SCALE_FILL;
            } else if (i12 == 2) {
                scaleType = Content.Dynamic.ScaleType.CENTER;
            } else if (i12 == 3) {
                scaleType = Content.Dynamic.ScaleType.ASPECT_FIT;
            } else if (i12 == 4) {
                scaleType = Content.Dynamic.ScaleType.ASPECT_FILL;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            int i13 = WhenMappings.$EnumSwitchMapping$1[dynamic.getResourceType().ordinal()];
            if (i13 == 1) {
                resourceType = Content.Dynamic.ResourceType.IMAGE;
            } else if (i13 == 2) {
                resourceType = Content.Dynamic.ResourceType.VIDEO;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            content = new Content.Dynamic(backgroundColor, scaleType, resourceType, dynamic.getLocalResourcePath());
        } else {
            content = Content.Bundled.INSTANCE;
        }
        Content content2 = content;
        if (component2 != null) {
            available = new Campaign.Available(component2.getTitle(), component2.getLocalImagePath(), component2.getImageWidth(), component2.getImageHeight());
        } else {
            available = Campaign.Unavailable.INSTANCE;
        }
        this.f61537j.invoke(new SplashContentDisplayModel(content2, available, (SplashPhaseOneViewEntity) null, 4, (DefaultConstructorMarker) null));
        return Unit.INSTANCE;
    }
}
