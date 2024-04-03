package com.checkout.frames.di.module;

import androidx.compose.ui.Modifier;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.component.cardscheme.CardSchemeComponentState;
import com.checkout.frames.mapper.CardSchemeComponentStyleToStateMapper;
import com.checkout.frames.mapper.CardSchemeComponentStyleToViewStyleMapper;
import com.checkout.frames.style.component.CardSchemeComponentStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.view.CardSchemeComponentViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.view.TextLabelState;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/checkout/frames/di/module/CardSchemeModule;", "", "()V", "Companion", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Module
public final class CardSchemeModule {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0004H\u0007J<\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u0004H\u0007¨\u0006\u0011"}, d2 = {"Lcom/checkout/frames/di/module/CardSchemeModule$Companion;", "", "()V", "provideCardSchemeComponentStateMapper", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/CardSchemeComponentStyle;", "Lcom/checkout/frames/component/cardscheme/CardSchemeComponentState;", "textLabelMapper", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "Lcom/checkout/frames/view/TextLabelState;", "provideCardSchemeComponentStyleMapper", "Lcom/checkout/frames/style/view/CardSchemeComponentViewStyle;", "textLabelStyleMapper", "Lcom/checkout/frames/style/view/TextLabelViewStyle;", "containerMapper", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "Landroidx/compose/ui/Modifier;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        @Provides
        public final Mapper<CardSchemeComponentStyle, CardSchemeComponentState> provideCardSchemeComponentStateMapper(@NotNull Mapper<TextLabelStyle, TextLabelState> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "textLabelMapper");
            return new CardSchemeComponentStyleToStateMapper(mapper);
        }

        @NotNull
        @Provides
        public final Mapper<CardSchemeComponentStyle, CardSchemeComponentViewStyle> provideCardSchemeComponentStyleMapper(@NotNull Mapper<TextLabelStyle, TextLabelViewStyle> mapper, @NotNull Mapper<ContainerStyle, Modifier> mapper2) {
            Intrinsics.checkNotNullParameter(mapper, "textLabelStyleMapper");
            Intrinsics.checkNotNullParameter(mapper2, "containerMapper");
            return new CardSchemeComponentStyleToViewStyleMapper(mapper, mapper2);
        }
    }
}
