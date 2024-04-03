package com.checkout.frames.di.module;

import androidx.compose.ui.Modifier;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.component.addresssummary.AddressSummaryComponentState;
import com.checkout.frames.mapper.DividerStyleToViewStyleMapper;
import com.checkout.frames.mapper.addresssummary.AddressSummaryComponentStyleToStateMapper;
import com.checkout.frames.mapper.addresssummary.AddressSummaryComponentStyleToViewStyleMapper;
import com.checkout.frames.mapper.addresssummary.AddressSummarySectionStyleToViewStyleMapper;
import com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle;
import com.checkout.frames.style.component.addresssummary.AddressSummarySectionStyle;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.DividerStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.view.DividerViewStyle;
import com.checkout.frames.style.view.InternalButtonViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.style.view.addresssummary.AddressSummaryComponentViewStyle;
import com.checkout.frames.style.view.addresssummary.AddressSummarySectionViewStyle;
import com.checkout.frames.view.InternalButtonState;
import com.checkout.frames.view.TextLabelState;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/checkout/frames/di/module/AddressSummaryModule;", "", "()V", "Companion", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Module
public final class AddressSummaryModule {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0004H\u0007Jd\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00042\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0004H\u0007Jd\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\u00042\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u00042\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0004H\u0007J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u0004H\u0007¨\u0006\u001e"}, d2 = {"Lcom/checkout/frames/di/module/AddressSummaryModule$Companion;", "", "()V", "provideAddressSummaryComponentStateMapper", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;", "Lcom/checkout/frames/component/addresssummary/AddressSummaryComponentState;", "textLabelStateMapper", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "Lcom/checkout/frames/view/TextLabelState;", "internalButtonStateMapper", "Lcom/checkout/frames/style/component/base/ButtonStyle;", "Lcom/checkout/frames/view/InternalButtonState;", "provideAddressSummaryComponentStyleMapper", "Lcom/checkout/frames/style/view/addresssummary/AddressSummaryComponentViewStyle;", "textLabelMapper", "Lcom/checkout/frames/style/view/TextLabelViewStyle;", "buttonMapper", "Lcom/checkout/frames/style/view/InternalButtonViewStyle;", "summarySectionMapper", "Lcom/checkout/frames/style/component/addresssummary/AddressSummarySectionStyle;", "Lcom/checkout/frames/style/view/addresssummary/AddressSummarySectionViewStyle;", "containerMapper", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "Landroidx/compose/ui/Modifier;", "provideAddressSummarySectionStyleMapper", "dividerMapper", "Lcom/checkout/frames/style/component/base/DividerStyle;", "Lcom/checkout/frames/style/view/DividerViewStyle;", "provideDividerMapper", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        @Provides
        public final Mapper<AddressSummaryComponentStyle, AddressSummaryComponentState> provideAddressSummaryComponentStateMapper(@NotNull Mapper<TextLabelStyle, TextLabelState> mapper, @NotNull Mapper<ButtonStyle, InternalButtonState> mapper2) {
            Intrinsics.checkNotNullParameter(mapper, "textLabelStateMapper");
            Intrinsics.checkNotNullParameter(mapper2, "internalButtonStateMapper");
            return new AddressSummaryComponentStyleToStateMapper(mapper, mapper2);
        }

        @NotNull
        @Provides
        public final Mapper<AddressSummaryComponentStyle, AddressSummaryComponentViewStyle> provideAddressSummaryComponentStyleMapper(@NotNull Mapper<TextLabelStyle, TextLabelViewStyle> mapper, @NotNull Mapper<ButtonStyle, InternalButtonViewStyle> mapper2, @NotNull Mapper<AddressSummarySectionStyle, AddressSummarySectionViewStyle> mapper3, @NotNull Mapper<ContainerStyle, Modifier> mapper4) {
            Intrinsics.checkNotNullParameter(mapper, "textLabelMapper");
            Intrinsics.checkNotNullParameter(mapper2, "buttonMapper");
            Intrinsics.checkNotNullParameter(mapper3, "summarySectionMapper");
            Intrinsics.checkNotNullParameter(mapper4, "containerMapper");
            return new AddressSummaryComponentStyleToViewStyleMapper(mapper, mapper2, mapper3, mapper4);
        }

        @NotNull
        @Provides
        public final Mapper<AddressSummarySectionStyle, AddressSummarySectionViewStyle> provideAddressSummarySectionStyleMapper(@NotNull Mapper<TextLabelStyle, TextLabelViewStyle> mapper, @NotNull Mapper<DividerStyle, DividerViewStyle> mapper2, @NotNull Mapper<ButtonStyle, InternalButtonViewStyle> mapper3, @NotNull Mapper<ContainerStyle, Modifier> mapper4) {
            Intrinsics.checkNotNullParameter(mapper, "textLabelMapper");
            Intrinsics.checkNotNullParameter(mapper2, "dividerMapper");
            Intrinsics.checkNotNullParameter(mapper3, "buttonMapper");
            Intrinsics.checkNotNullParameter(mapper4, "containerMapper");
            return new AddressSummarySectionStyleToViewStyleMapper(mapper, mapper2, mapper3, mapper4);
        }

        @NotNull
        @Provides
        public final Mapper<DividerStyle, DividerViewStyle> provideDividerMapper() {
            return new DividerStyleToViewStyleMapper();
        }
    }
}
