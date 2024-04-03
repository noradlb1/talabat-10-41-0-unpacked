package com.checkout.frames.mapper;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.style.component.base.ImageStyle;
import com.checkout.frames.style.component.base.InputFieldStyle;
import com.checkout.frames.view.InputFieldState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B(\u0012!\u0010\u0004\u001a\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\b\b0\u0001¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R)\u0010\u0004\u001a\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\b\b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/checkout/frames/mapper/InputFieldStyleToInputFieldStateMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/base/InputFieldStyle;", "Lcom/checkout/frames/view/InputFieldState;", "imageMapper", "Lcom/checkout/frames/style/component/base/ImageStyle;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Lcom/checkout/base/mapper/Mapper;)V", "map", "from", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InputFieldStyleToInputFieldStateMapper implements Mapper<InputFieldStyle, InputFieldState> {
    @NotNull
    private final Mapper<ImageStyle, Function2<Composer, Integer, Unit>> imageMapper;

    public InputFieldStyleToInputFieldStateMapper(@NotNull Mapper<ImageStyle, Function2<Composer, Integer, Unit>> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "imageMapper");
        this.imageMapper = mapper;
    }

    @NotNull
    public InputFieldState map(@NotNull InputFieldStyle inputFieldStyle) {
        Intrinsics.checkNotNullParameter(inputFieldStyle, "from");
        return new InputFieldState((MutableState) null, SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(inputFieldStyle.getTextStyle().getMaxLength(), (SnapshotMutationPolicy) null, 2, (Object) null), SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(this.imageMapper.map(inputFieldStyle.getLeadingIconStyle()), (SnapshotMutationPolicy) null, 2, (Object) null), SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(this.imageMapper.map(inputFieldStyle.getTrailingIconStyle()), (SnapshotMutationPolicy) null, 2, (Object) null), (MutableState) null, 17, (DefaultConstructorMarker) null);
    }
}
