package com.checkout.frames.mapper;

import androidx.compose.runtime.Composer;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.style.component.base.ImageStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.view.TextLabelState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B(\u0012!\u0010\u0004\u001a\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\b\b0\u0001¢\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016R)\u0010\u0004\u001a\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\b\b0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/checkout/frames/mapper/TextLabelStyleToStateMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "Lcom/checkout/frames/view/TextLabelState;", "imageMapper", "Lcom/checkout/frames/style/component/base/ImageStyle;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Lcom/checkout/base/mapper/Mapper;)V", "map", "from", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextLabelStyleToStateMapper implements Mapper<TextLabelStyle, TextLabelState> {
    @NotNull
    private final Mapper<ImageStyle, Function2<Composer, Integer, Unit>> imageMapper;

    public TextLabelStyleToStateMapper(@NotNull Mapper<ImageStyle, Function2<Composer, Integer, Unit>> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "imageMapper");
        this.imageMapper = mapper;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0060, code lost:
        if ((r11 != null ? r11.getTextId() : null) != null) goto L_0x0062;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.checkout.frames.view.TextLabelState map(@org.jetbrains.annotations.Nullable com.checkout.frames.style.component.base.TextLabelStyle r11) {
        /*
            r10 = this;
            com.checkout.frames.view.TextLabelState r6 = new com.checkout.frames.view.TextLabelState
            if (r11 == 0) goto L_0x000a
            java.lang.String r0 = r11.getText()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            java.lang.String r0 = ""
        L_0x000c:
            r1 = 0
            r2 = 2
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r1, r2, r1)
            if (r11 == 0) goto L_0x0019
            java.lang.Integer r0 = r11.getTextId()
            goto L_0x001a
        L_0x0019:
            r0 = r1
        L_0x001a:
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r1, r2, r1)
            com.checkout.base.mapper.Mapper<com.checkout.frames.style.component.base.ImageStyle, kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>> r0 = r10.imageMapper
            if (r11 == 0) goto L_0x0027
            com.checkout.frames.style.component.base.ImageStyle r5 = r11.getLeadingIconStyle()
            goto L_0x0028
        L_0x0027:
            r5 = r1
        L_0x0028:
            java.lang.Object r0 = r0.map(r5)
            androidx.compose.runtime.MutableState r5 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r1, r2, r1)
            com.checkout.base.mapper.Mapper<com.checkout.frames.style.component.base.ImageStyle, kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>> r0 = r10.imageMapper
            if (r11 == 0) goto L_0x0039
            com.checkout.frames.style.component.base.ImageStyle r7 = r11.getTrailingIconStyle()
            goto L_0x003a
        L_0x0039:
            r7 = r1
        L_0x003a:
            java.lang.Object r0 = r0.map(r7)
            androidx.compose.runtime.MutableState r7 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r1, r2, r1)
            r0 = 0
            r8 = 1
            if (r11 == 0) goto L_0x0055
            java.lang.String r9 = r11.getText()
            if (r9 == 0) goto L_0x0055
            boolean r9 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r9)
            r9 = r9 ^ r8
            if (r9 != r8) goto L_0x0055
            r9 = r8
            goto L_0x0056
        L_0x0055:
            r9 = r0
        L_0x0056:
            if (r9 != 0) goto L_0x0062
            if (r11 == 0) goto L_0x005f
            java.lang.Integer r11 = r11.getTextId()
            goto L_0x0060
        L_0x005f:
            r11 = r1
        L_0x0060:
            if (r11 == 0) goto L_0x0063
        L_0x0062:
            r0 = r8
        L_0x0063:
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r0)
            androidx.compose.runtime.MutableState r11 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r11, r1, r2, r1)
            r0 = r6
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r7
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.mapper.TextLabelStyleToStateMapper.map(com.checkout.frames.style.component.base.TextLabelStyle):com.checkout.frames.view.TextLabelState");
    }
}
