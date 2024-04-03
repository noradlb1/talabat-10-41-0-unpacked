package com.checkout.frames.mapper;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.ImageStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.component.base.TextStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.view.TextLabelKt;
import com.checkout.frames.view.TextLabelState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class InputFieldStyleToViewStyleMapper$providePlaceholder$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ TextStyle $placeholderStyle;
    final /* synthetic */ String $placeholderText;
    final /* synthetic */ Integer $placeholderTextId;
    final /* synthetic */ InputFieldStyleToViewStyleMapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldStyleToViewStyleMapper$providePlaceholder$1(InputFieldStyleToViewStyleMapper inputFieldStyleToViewStyleMapper, String str, Integer num, TextStyle textStyle) {
        super(2);
        this.this$0 = inputFieldStyleToViewStyleMapper;
        this.$placeholderText = str;
        this.$placeholderTextId = num;
        this.$placeholderStyle = textStyle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            TextLabelKt.TextLabel((TextLabelViewStyle) this.this$0.textLabelStyleMapper.map(new TextLabelStyle(this.$placeholderText, this.$placeholderTextId, this.$placeholderStyle, (ImageStyle) null, (ImageStyle) null, (ContainerStyle) null, 56, (DefaultConstructorMarker) null)), new TextLabelState(SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(this.$placeholderText, (SnapshotMutationPolicy) null, 2, (Object) null), SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(this.$placeholderTextId, (SnapshotMutationPolicy) null, 2, (Object) null), (MutableState) null, (MutableState) null, SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null), 12, (DefaultConstructorMarker) null), composer, 8);
            return;
        }
        composer.skipToGroupEnd();
    }
}
