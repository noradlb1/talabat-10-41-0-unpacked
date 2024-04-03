package com.talabat.feature.ridertips.presentation.view.terms;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.res.PainterResources_androidKt;
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
import com.designsystem.ds_theme.DSTheme;
import com.talabat.feature.ridertips.presentation.displaymodel.TermDisplayModel;
import com.talabat.feature.ridertips.presentation.displaymodel.TermsDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TermsViewKt$TermsView$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TermsDisplayModel f58883g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TermsViewKt$TermsView$1$1(TermsDisplayModel termsDisplayModel) {
        super(2);
        this.f58883g = termsDisplayModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            Modifier.Companion companion = Modifier.Companion;
            DSTheme dSTheme = DSTheme.INSTANCE;
            Modifier r02 = PaddingKt.m486padding3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m177backgroundbw27NRU$default(companion, dSTheme.getColors(composer2, 8).m8774getDsNeutralWhite0d7_KjU(), (Shape) null, 2, (Object) null), 0.0f, 1, (Object) null), dSTheme.getDimens(composer2, 8).m8842getDsSD9Ej5fM());
            TermsDisplayModel termsDisplayModel = this.f58883g;
            composer2.startReplaceableGroup(733328855);
            Alignment.Companion companion2 = Alignment.Companion;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r02);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer r72 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r72, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r72, density, companion3.getSetDensity());
            Updater.m2543setimpl(r72, layoutDirection, companion3.getSetLayoutDirection());
            Updater.m2543setimpl(r72, viewConfiguration, companion3.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composer2.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion2.getStart(), composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(companion);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer r42 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r42, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r42, density2, companion3.getSetDensity());
            Updater.m2543setimpl(r42, layoutDirection2, companion3.getSetLayoutDirection());
            Updater.m2543setimpl(r42, viewConfiguration2, companion3.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-1163856341);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            TermsDisplayModel termsDisplayModel2 = termsDisplayModel;
            Modifier.Companion companion4 = companion;
            DSTheme dSTheme2 = dSTheme;
            Composer composer3 = composer2;
            Composer composer4 = composer;
            TextKt.m1461TextfLXpl1I(termsDisplayModel.getTitle(), (Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m5046copyHL5avdY$default(dSTheme2.getTypography(composer3, 8).getDsHeading1(), dSTheme2.getColors(composer3, 8).m8760getDsNeutral1000d7_KjU(), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262142, (Object) null), composer4, 0, 0, 32766);
            Composer composer5 = composer;
            DSTheme dSTheme3 = dSTheme2;
            Modifier.Companion companion5 = companion4;
            SpacerKt.Spacer(SizeKt.m544height3ABfNKs(companion5, dSTheme3.getDimens(composer5, 8).m8846getDsXxsD9Ej5fM()), composer5, 0);
            DSTheme dSTheme4 = dSTheme3;
            Composer composer6 = composer5;
            TextKt.m1461TextfLXpl1I(termsDisplayModel2.getDescription(), (Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m5046copyHL5avdY$default(dSTheme4.getTypography(composer6, 8).getDsBody1(), dSTheme4.getColors(composer6, 8).m8760getDsNeutral1000d7_KjU(), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262142, (Object) null), composer4, 0, 0, 32766);
            Composer composer7 = composer;
            int i12 = 8;
            int i13 = 0;
            SpacerKt.Spacer(SizeKt.m544height3ABfNKs(companion5, dSTheme4.getDimens(composer7, 8).m8840getDsLD9Ej5fM()), composer7, 0);
            for (TermDisplayModel termDisplayModel : termsDisplayModel2.getContents()) {
                composer7.startReplaceableGroup(693286680);
                Modifier.Companion companion6 = Modifier.Companion;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer7, i13);
                composer7.startReplaceableGroup(-1323940314);
                Density density3 = (Density) composer7.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection3 = (LayoutDirection) composer7.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer7.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion7 = ComposeUiNode.Companion;
                Function0<ComposeUiNode> constructor3 = companion7.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(companion6);
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer7.createNode(constructor3);
                } else {
                    composer.useNode();
                }
                composer.disableReusing();
                Composer r52 = Updater.m2536constructorimpl(composer);
                Updater.m2543setimpl(r52, rowMeasurePolicy, companion7.getSetMeasurePolicy());
                Updater.m2543setimpl(r52, density3, companion7.getSetDensity());
                Updater.m2543setimpl(r52, layoutDirection3, companion7.getSetLayoutDirection());
                Updater.m2543setimpl(r52, viewConfiguration3, companion7.getSetViewConfiguration());
                composer.enableReusing();
                materializerOf3.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer7, Integer.valueOf(i13));
                composer7.startReplaceableGroup(2058660585);
                composer7.startReplaceableGroup(-678309503);
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ImageKt.Image(PainterResources_androidKt.painterResource(termDisplayModel.getIconResId(), composer7, i13), (String) null, (Modifier) null, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, 56, 124);
                DSTheme dSTheme5 = DSTheme.INSTANCE;
                SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion6, dSTheme5.getDimens(composer7, i12).m8846getDsXxsD9Ej5fM()), composer7, i13);
                DSTheme dSTheme6 = dSTheme5;
                int i14 = i12;
                Composer composer8 = composer7;
                TextKt.m1461TextfLXpl1I(termDisplayModel.getText(), (Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m5046copyHL5avdY$default(dSTheme6.getTypography(composer8, i14).getDsBody1(), dSTheme6.getColors(composer8, i14).m8760getDsNeutral1000d7_KjU(), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262142, (Object) null), composer, 0, 0, 32766);
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                Composer composer9 = composer;
                SpacerKt.Spacer(SizeKt.m544height3ABfNKs(companion6, dSTheme6.getDimens(composer9, 8).m8842getDsSD9Ej5fM()), composer9, 0);
                composer7 = composer9;
                i12 = 8;
                i13 = 0;
            }
            Composer composer10 = composer7;
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            return;
        }
        composer.skipToGroupEnd();
    }
}
