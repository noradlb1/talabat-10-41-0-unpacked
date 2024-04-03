package com.checkout.frames.screen.countrypicker;

import androidx.compose.runtime.Composer;
import com.checkout.frames.style.view.InputFieldViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.view.InputFieldState;
import com.checkout.frames.view.TextLabelState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CountryPickerScreenKt$HeaderComponent$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function1<Boolean, Unit> $onSearchFocusChange;
    final /* synthetic */ Function1<String, Unit> $onSearchValueChange;
    final /* synthetic */ TextLabelState $screenTitleState;
    final /* synthetic */ TextLabelViewStyle $screenTitleStyle;
    final /* synthetic */ InputFieldState $searchFieldState;
    final /* synthetic */ InputFieldViewStyle $searchFieldStyle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountryPickerScreenKt$HeaderComponent$2(TextLabelViewStyle textLabelViewStyle, TextLabelState textLabelState, InputFieldViewStyle inputFieldViewStyle, InputFieldState inputFieldState, Function1<? super Boolean, Unit> function1, Function1<? super String, Unit> function12, int i11) {
        super(2);
        this.$screenTitleStyle = textLabelViewStyle;
        this.$screenTitleState = textLabelState;
        this.$searchFieldStyle = inputFieldViewStyle;
        this.$searchFieldState = inputFieldState;
        this.$onSearchFocusChange = function1;
        this.$onSearchValueChange = function12;
        this.$$changed = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CountryPickerScreenKt.HeaderComponent(this.$screenTitleStyle, this.$screenTitleState, this.$searchFieldStyle, this.$searchFieldState, this.$onSearchFocusChange, this.$onSearchValueChange, composer, this.$$changed | 1);
    }
}
