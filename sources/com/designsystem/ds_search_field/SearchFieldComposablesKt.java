package com.designsystem.ds_search_field;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.designsystem.ds_theme.DSTheme;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0011\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0001¢\u0006\u0002\u0010\t\u001a\u0015\u0010\n\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\r\u001a\u001b\u0010\u000e\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0003¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"SearchFieldDecorationBox", "", "value", "", "hint", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "onClearButtonTap", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SearchFieldHintText", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "SearchFieldLeadingIcon", "(Landroidx/compose/runtime/Composer;I)V", "SearchFieldTrailingIcon", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class SearchFieldComposablesKt {
    @Composable
    public static final void SearchFieldDecorationBox(@NotNull String str, @Nullable String str2, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @NotNull Function0<Unit> function0, @Nullable Composer composer, int i11) {
        int i12;
        Composer composer2;
        int i13;
        int i14;
        int i15;
        int i16;
        String str3 = str;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        Function0<Unit> function02 = function0;
        int i17 = i11;
        Intrinsics.checkNotNullParameter(str3, "value");
        Intrinsics.checkNotNullParameter(function22, "innerTextField");
        Intrinsics.checkNotNullParameter(function02, "onClearButtonTap");
        Composer startRestartGroup = composer.startRestartGroup(-1966501291);
        if ((i17 & 14) == 0) {
            if (startRestartGroup.changed((Object) str3)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i12 = i16 | i17;
        } else {
            i12 = i17;
        }
        String str4 = str2;
        if ((i17 & 112) == 0) {
            if (startRestartGroup.changed((Object) str4)) {
                i15 = 32;
            } else {
                i15 = 16;
            }
            i12 |= i15;
        }
        if ((i17 & 896) == 0) {
            if (startRestartGroup.changed((Object) function22)) {
                i14 = 256;
            } else {
                i14 = 128;
            }
            i12 |= i14;
        }
        if ((i17 & 7168) == 0) {
            if (startRestartGroup.changed((Object) function02)) {
                i13 = 2048;
            } else {
                i13 = 1024;
            }
            i12 |= i13;
        }
        int i18 = i12;
        if (((i18 & 5851) ^ 1170) != 0 || !startRestartGroup.getSkipping()) {
            DSTheme dSTheme = DSTheme.INSTANCE;
            long r12 = dSTheme.getColors(startRestartGroup, 0).m8774getDsNeutralWhite0d7_KjU();
            BorderStroke r16 = BorderStrokeKt.m191BorderStrokecXLIe8U(SearchField.INSTANCE.m8565getSearchFieldBorderStrokeD9Ej5fM(), dSTheme.getColors(startRestartGroup, 0).m8759getDsNeutral100d7_KjU());
            RoundedCornerShape r11 = RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(dSTheme.getDimens(startRestartGroup, 0).m8846getDsXxsD9Ej5fM());
            SearchFieldComposablesKt$SearchFieldDecorationBox$1 searchFieldComposablesKt$SearchFieldDecorationBox$1 = r0;
            SearchFieldComposablesKt$SearchFieldDecorationBox$1 searchFieldComposablesKt$SearchFieldDecorationBox$12 = new SearchFieldComposablesKt$SearchFieldDecorationBox$1(str, function0, i18, function2, str2);
            composer2 = startRestartGroup;
            SurfaceKt.m1384SurfaceFjzlyU((Modifier) null, r11, r12, 0, r16, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -819896004, true, searchFieldComposablesKt$SearchFieldDecorationBox$1), composer2, 1572864, 41);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SearchFieldComposablesKt$SearchFieldDecorationBox$2(str, str2, function2, function0, i11));
        }
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void SearchFieldHintText(String str, Composer composer, int i11) {
        int i12;
        Composer composer2;
        int i13;
        String str2 = str;
        int i14 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-315382903);
        if ((i14 & 14) == 0) {
            if (startRestartGroup.changed((Object) str2)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i14;
        } else {
            i12 = i14;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            DSTheme dSTheme = DSTheme.INSTANCE;
            composer2 = startRestartGroup;
            TextKt.m1461TextfLXpl1I(str, (Modifier) null, dSTheme.getColors(startRestartGroup, 0).m8769getDsNeutral550d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, TextOverflow.Companion.m5403getEllipsisgIe3tQ8(), false, 1, (Function1<? super TextLayoutResult, Unit>) null, dSTheme.getTypography(startRestartGroup, 0).getDsBody0(), composer2, i12 & 14, 3136, 22522);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SearchFieldComposablesKt$SearchFieldHintText$1(str, i11));
        }
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void SearchFieldLeadingIcon(Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(-924614037);
        if (i11 != 0 || !startRestartGroup.getSkipping()) {
            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.ds_search, startRestartGroup, 0);
            DSTheme dSTheme = DSTheme.INSTANCE;
            Painter painter = painterResource;
            IconKt.m1278Iconww6aTOc(painter, "", SemanticsModifierKt.semantics$default(SizeKt.m558size3ABfNKs(PaddingKt.m489paddingqDBjuR0(Modifier.Companion, dSTheme.getDimens(startRestartGroup, 0).m8844getDsXsD9Ej5fM(), dSTheme.getDimens(startRestartGroup, 0).m8844getDsXsD9Ej5fM(), dSTheme.getDimens(startRestartGroup, 0).m8846getDsXxsD9Ej5fM(), dSTheme.getDimens(startRestartGroup, 0).m8844getDsXsD9Ej5fM()), dSTheme.getDimens(startRestartGroup, 0).m8841getDsMD9Ej5fM()), false, SearchFieldComposablesKt$SearchFieldLeadingIcon$1.INSTANCE, 1, (Object) null), dSTheme.getColors(startRestartGroup, 0).m8769getDsNeutral550d7_KjU(), startRestartGroup, 56, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SearchFieldComposablesKt$SearchFieldLeadingIcon$2(i11));
        }
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void SearchFieldTrailingIcon(Function0<Unit> function0, Composer composer, int i11) {
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(1250460611);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) function0)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i11;
        } else {
            i12 = i11;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            Modifier.Companion companion = Modifier.Companion;
            Modifier r12 = ClickableKt.m194clickableO2vRcR0$default(SizeKt.wrapContentSize$default(companion, (Alignment) null, false, 3, (Object) null), InteractionSourceKt.MutableInteractionSource(), (Indication) null, false, (String) null, (Role) null, function0, 28, (Object) null);
            startRestartGroup.startReplaceableGroup(-1990474327);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1376089335);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r12);
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
            Composer r82 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r82, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r82, density, companion2.getSetDensity());
            Updater.m2543setimpl(r82, layoutDirection, companion2.getSetLayoutDirection());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1253629305);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.ds_close_circle, startRestartGroup, 0);
            DSTheme dSTheme = DSTheme.INSTANCE;
            IconKt.m1278Iconww6aTOc(painterResource, "", SemanticsModifierKt.semantics$default(SizeKt.m558size3ABfNKs(PaddingKt.m486padding3ABfNKs(companion, dSTheme.getDimens(startRestartGroup, 0).m8844getDsXsD9Ej5fM()), dSTheme.getDimens(startRestartGroup, 0).m8840getDsLD9Ej5fM()), false, SearchFieldComposablesKt$SearchFieldTrailingIcon$1$1.INSTANCE, 1, (Object) null), dSTheme.getColors(startRestartGroup, 0).m8771getDsNeutral700d7_KjU(), startRestartGroup, 56, 0);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SearchFieldComposablesKt$SearchFieldTrailingIcon$2(function0, i11));
        }
    }
}
