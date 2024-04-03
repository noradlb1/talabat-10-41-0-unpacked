package com.checkout.frames.view;

import android.annotation.SuppressLint;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.checkout.frames.mapper.ImageStyleToComposableImageMapper;
import com.checkout.frames.model.Padding;
import com.checkout.frames.style.component.base.ImageStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.e;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"TextLabel", "", "style", "Lcom/checkout/frames/style/view/TextLabelViewStyle;", "state", "Lcom/checkout/frames/view/TextLabelState;", "(Lcom/checkout/frames/style/view/TextLabelViewStyle;Lcom/checkout/frames/view/TextLabelState;Landroidx/compose/runtime/Composer;I)V", "TextLabelPreview", "(Landroidx/compose/runtime/Composer;I)V", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TextLabelKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TextLabel(@NotNull TextLabelViewStyle textLabelViewStyle, @NotNull TextLabelState textLabelState, @Nullable Composer composer, int i11) {
        String str;
        Modifier modifier;
        TextLabelViewStyle textLabelViewStyle2 = textLabelViewStyle;
        TextLabelState textLabelState2 = textLabelState;
        Intrinsics.checkNotNullParameter(textLabelViewStyle2, "style");
        Intrinsics.checkNotNullParameter(textLabelState2, "state");
        Composer startRestartGroup = composer.startRestartGroup(1391298345);
        Modifier modifier2 = textLabelViewStyle.getModifier();
        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
        startRestartGroup.startReplaceableGroup(693286680);
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
        startRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier2);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r92 = Updater.m2536constructorimpl(startRestartGroup);
        Updater.m2543setimpl(r92, rowMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m2543setimpl(r92, density, companion.getSetDensity());
        Updater.m2543setimpl(r92, layoutDirection, companion.getSetLayoutDirection());
        Updater.m2543setimpl(r92, viewConfiguration, companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-678309503);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        Integer value = textLabelState.getTextId().getValue();
        startRestartGroup.startReplaceableGroup(1317117086);
        if (value == null) {
            str = null;
        } else {
            str = StringResources_androidKt.stringResource(value.intValue(), startRestartGroup, 0);
        }
        startRestartGroup.endReplaceableGroup();
        if (str == null) {
            str = textLabelState.getText().getValue();
        }
        Function2 value2 = textLabelState.getLeadingIcon().getValue();
        startRestartGroup.startReplaceableGroup(1317117189);
        if (value2 != null) {
            value2.invoke(startRestartGroup, 0);
        }
        startRestartGroup.endReplaceableGroup();
        if (textLabelViewStyle.getTextMaxWidth()) {
            modifier = e.a(rowScopeInstance, Modifier.Companion, 1.0f, false, 2, (Object) null);
        } else {
            modifier = Modifier.Companion;
        }
        long r52 = textLabelViewStyle.m9309getColor0d7_KjU();
        long r72 = textLabelViewStyle.m9310getFontSizeXSAIIZE();
        FontStyle r93 = textLabelViewStyle.m9311getFontStyle4Lr2A7w();
        FontWeight fontWeight = textLabelViewStyle.getFontWeight();
        FontFamily fontFamily = textLabelViewStyle.getFontFamily();
        long r12 = textLabelViewStyle.m9312getLetterSpacingXSAIIZE();
        TextDecoration textDecoration = textLabelViewStyle.getTextDecoration();
        TextAlign r16 = textLabelViewStyle.m9315getTextAlignbuA522U();
        long r17 = textLabelViewStyle.m9313getLineHeightXSAIIZE();
        int r19 = textLabelViewStyle.m9314getOverflowgIe3tQ8();
        boolean softWrap = textLabelViewStyle.getSoftWrap();
        int maxLines = textLabelViewStyle.getMaxLines();
        Function1<TextLayoutResult, Unit> onTextLayout = textLabelViewStyle.getOnTextLayout();
        TextStyle style = textLabelViewStyle.getStyle();
        startRestartGroup.startReplaceableGroup(1317117617);
        if (style == null) {
            style = (TextStyle) startRestartGroup.consume(TextKt.getLocalTextStyle());
        }
        startRestartGroup.endReplaceableGroup();
        TextKt.m1938TextfLXpl1I(str, modifier, r52, r72, r93, fontWeight, fontFamily, r12, textDecoration, r16, r17, r19, softWrap, maxLines, onTextLayout, style, startRestartGroup, 0, 0, 0);
        Function2 value3 = textLabelState.getTrailingIcon().getValue();
        if (value3 != null) {
            value3.invoke(startRestartGroup, 0);
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextLabelKt$TextLabel$2(textLabelViewStyle2, textLabelState2, i11));
        }
    }

    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @SuppressLint({"UnrememberedMutableState", "MagicNumber"})
    @Composable
    public static final void TextLabelPreview(Composer composer, int i11) {
        int i12 = i11;
        Composer startRestartGroup = composer.startRestartGroup(1220411392);
        if (i12 != 0 || !startRestartGroup.getSkipping()) {
            ImageStyleToComposableImageMapper imageStyleToComposableImageMapper = new ImageStyleToComposableImageMapper();
            ImageStyle imageStyle = new ImageStyle(17301546, 4294902015L, 48, 48, new Padding(0, 0, 8, 8, 3, (DefaultConstructorMarker) null));
            TextStyle textStyle = r37;
            TextStyle textStyle2 = new TextStyle(Color.Companion.m2949getGray0d7_KjU(), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262142, (DefaultConstructorMarker) null);
            TextLabel(new TextLabelViewStyle((Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1) null, textStyle, false, 49151, (DefaultConstructorMarker) null), new TextLabelState(SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("Test label text", (SnapshotMutationPolicy) null, 2, (Object) null), (MutableState) null, SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(imageStyleToComposableImageMapper.map(imageStyle), (SnapshotMutationPolicy) null, 2, (Object) null), SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(imageStyleToComposableImageMapper.map(imageStyle), (SnapshotMutationPolicy) null, 2, (Object) null), (MutableState) null, 18, (DefaultConstructorMarker) null), startRestartGroup, 8);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextLabelKt$TextLabelPreview$1(i12));
        }
    }
}
