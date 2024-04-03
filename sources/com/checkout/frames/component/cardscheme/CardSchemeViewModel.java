package com.checkout.frames.component.cardscheme;

import androidx.compose.runtime.Composer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.checkout.base.mapper.Mapper;
import com.checkout.base.model.CardScheme;
import com.checkout.frames.di.base.InjectionClient;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.di.component.CardSchemeViewModelSubComponent;
import com.checkout.frames.mapper.ImageStyleToComposableImageMapper;
import com.checkout.frames.model.Padding;
import com.checkout.frames.screen.manager.PaymentStateManager;
import com.checkout.frames.style.component.CardSchemeComponentStyle;
import com.checkout.frames.style.component.base.ImageStyle;
import com.checkout.frames.style.view.CardSchemeComponentViewStyle;
import d2.h;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\"BG\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0002\u0010\rJ\u001b\u0010\u001b\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016¢\u0006\u0002\b\u00180\u0015H\u0002J%\u0010\u001c\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016¢\u0006\u0002\b\u00180\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0006H\u0002R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016¢\u0006\u0002\b\u00180\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/checkout/frames/component/cardscheme/CardSchemeViewModel;", "Landroidx/lifecycle/ViewModel;", "paymentStateManager", "Lcom/checkout/frames/screen/manager/PaymentStateManager;", "cardSchemeComponentStyleMapper", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/CardSchemeComponentStyle;", "Lcom/checkout/frames/style/view/CardSchemeComponentViewStyle;", "cardSchemeComponentStateMapper", "Lcom/checkout/frames/component/cardscheme/CardSchemeComponentState;", "imageMapper", "Lcom/checkout/frames/mapper/ImageStyleToComposableImageMapper;", "style", "(Lcom/checkout/frames/screen/manager/PaymentStateManager;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/frames/mapper/ImageStyleToComposableImageMapper;Lcom/checkout/frames/style/component/CardSchemeComponentStyle;)V", "componentState", "getComponentState", "()Lcom/checkout/frames/component/cardscheme/CardSchemeComponentState;", "componentStyle", "getComponentStyle", "()Lcom/checkout/frames/style/view/CardSchemeComponentViewStyle;", "componentSupportedCardSchemeIcons", "", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getComponentSupportedCardSchemeIcons", "()Ljava/util/List;", "provideCardSchemes", "provideComposableCardSchemeImages", "imageStyle", "Lcom/checkout/frames/style/component/base/ImageStyle;", "provideViewState", "provideViewStyle", "inputStyle", "Factory", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardSchemeViewModel extends ViewModel {
    @NotNull
    private final Mapper<CardSchemeComponentStyle, CardSchemeComponentState> cardSchemeComponentStateMapper;
    @NotNull
    private final Mapper<CardSchemeComponentStyle, CardSchemeComponentViewStyle> cardSchemeComponentStyleMapper;
    @NotNull
    private final CardSchemeComponentState componentState;
    @NotNull
    private final CardSchemeComponentViewStyle componentStyle;
    @NotNull
    private final List<Function2<Composer, Integer, Unit>> componentSupportedCardSchemeIcons = provideCardSchemes();
    @NotNull
    private final ImageStyleToComposableImageMapper imageMapper;
    @NotNull
    private final PaymentStateManager paymentStateManager;
    @NotNull
    private final CardSchemeComponentStyle style;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/checkout/frames/component/cardscheme/CardSchemeViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/checkout/frames/di/base/InjectionClient;", "injector", "Lcom/checkout/frames/di/base/Injector;", "style", "Lcom/checkout/frames/style/component/CardSchemeComponentStyle;", "(Lcom/checkout/frames/di/base/Injector;Lcom/checkout/frames/style/component/CardSchemeComponentStyle;)V", "subComponentProvider", "Ljavax/inject/Provider;", "Lcom/checkout/frames/di/component/CardSchemeViewModelSubComponent$Builder;", "getSubComponentProvider", "()Ljavax/inject/Provider;", "setSubComponentProvider", "(Ljavax/inject/Provider;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Factory implements ViewModelProvider.Factory, InjectionClient {
        @NotNull
        private final Injector injector;
        @NotNull
        private final CardSchemeComponentStyle style;
        @Inject
        public Provider<CardSchemeViewModelSubComponent.Builder> subComponentProvider;

        public Factory(@NotNull Injector injector2, @NotNull CardSchemeComponentStyle cardSchemeComponentStyle) {
            Intrinsics.checkNotNullParameter(injector2, "injector");
            Intrinsics.checkNotNullParameter(cardSchemeComponentStyle, "style");
            this.injector = injector2;
            this.style = cardSchemeComponentStyle;
        }

        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            this.injector.inject(this);
            T cardSchemeViewModel = getSubComponentProvider().get().style(this.style).build().getCardSchemeViewModel();
            Intrinsics.checkNotNull(cardSchemeViewModel, "null cannot be cast to non-null type T of com.checkout.frames.component.cardscheme.CardSchemeViewModel.Factory.create");
            return cardSchemeViewModel;
        }

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return h.b(this, cls, creationExtras);
        }

        @NotNull
        public final Provider<CardSchemeViewModelSubComponent.Builder> getSubComponentProvider() {
            Provider<CardSchemeViewModelSubComponent.Builder> provider = this.subComponentProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("subComponentProvider");
            return null;
        }

        public final void setSubComponentProvider(@NotNull Provider<CardSchemeViewModelSubComponent.Builder> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.subComponentProvider = provider;
        }
    }

    @Inject
    public CardSchemeViewModel(@NotNull PaymentStateManager paymentStateManager2, @NotNull Mapper<CardSchemeComponentStyle, CardSchemeComponentViewStyle> mapper, @NotNull Mapper<CardSchemeComponentStyle, CardSchemeComponentState> mapper2, @NotNull ImageStyleToComposableImageMapper imageStyleToComposableImageMapper, @NotNull CardSchemeComponentStyle cardSchemeComponentStyle) {
        Intrinsics.checkNotNullParameter(paymentStateManager2, "paymentStateManager");
        Intrinsics.checkNotNullParameter(mapper, "cardSchemeComponentStyleMapper");
        Intrinsics.checkNotNullParameter(mapper2, "cardSchemeComponentStateMapper");
        Intrinsics.checkNotNullParameter(imageStyleToComposableImageMapper, "imageMapper");
        Intrinsics.checkNotNullParameter(cardSchemeComponentStyle, "style");
        this.paymentStateManager = paymentStateManager2;
        this.cardSchemeComponentStyleMapper = mapper;
        this.cardSchemeComponentStateMapper = mapper2;
        this.imageMapper = imageStyleToComposableImageMapper;
        this.style = cardSchemeComponentStyle;
        this.componentState = provideViewState(cardSchemeComponentStyle);
        this.componentStyle = provideViewStyle(cardSchemeComponentStyle);
    }

    private final List<Function2<Composer, Integer, Unit>> provideCardSchemes() {
        return provideComposableCardSchemeImages(this.style.getImageStyle());
    }

    private final List<Function2<Composer, Integer, Unit>> provideComposableCardSchemeImages(ImageStyle imageStyle) {
        ImageStyle imageStyle2;
        ArrayList arrayList = new ArrayList();
        for (CardScheme cardScheme : this.paymentStateManager.getSupportedCardSchemeList()) {
            ImageStyleToComposableImageMapper imageStyleToComposableImageMapper = this.imageMapper;
            if (imageStyle != null) {
                imageStyle2 = ImageStyle.copy$default(imageStyle, Integer.valueOf(cardScheme.getImageId()), (Long) null, (Integer) null, (Integer) null, (Padding) null, 30, (Object) null);
            } else {
                imageStyle2 = null;
            }
            arrayList.add(imageStyleToComposableImageMapper.map(imageStyle2));
        }
        return arrayList;
    }

    private final CardSchemeComponentState provideViewState(CardSchemeComponentStyle cardSchemeComponentStyle) {
        return this.cardSchemeComponentStateMapper.map(cardSchemeComponentStyle);
    }

    private final CardSchemeComponentViewStyle provideViewStyle(CardSchemeComponentStyle cardSchemeComponentStyle) {
        return this.cardSchemeComponentStyleMapper.map(cardSchemeComponentStyle);
    }

    @NotNull
    public final CardSchemeComponentState getComponentState() {
        return this.componentState;
    }

    @NotNull
    public final CardSchemeComponentViewStyle getComponentStyle() {
        return this.componentStyle;
    }

    @NotNull
    public final List<Function2<Composer, Integer, Unit>> getComponentSupportedCardSchemeIcons() {
        return this.componentSupportedCardSchemeIcons;
    }
}
