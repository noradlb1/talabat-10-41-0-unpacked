package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.designsystem.ds_theme.DSTheme;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.e;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class SelectableListItemComposablesKt$SelectionListItem$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Integer f32317g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Integer f32318h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f32319i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableState<Boolean> f32320j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f32321k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f32322l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f32323m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ String f32324n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ String f32325o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ float f32326p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ String f32327q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ String f32328r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ String f32329s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Integer f32330t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ Function3<Boolean, Composer, Integer, Unit> f32331u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectableListItemComposablesKt$SelectionListItem$1(Integer num, Integer num2, boolean z11, MutableState<Boolean> mutableState, boolean z12, int i11, int i12, String str, String str2, float f11, String str3, String str4, String str5, Integer num3, Function3<? super Boolean, ? super Composer, ? super Integer, Unit> function3) {
        super(3);
        this.f32317g = num;
        this.f32318h = num2;
        this.f32319i = z11;
        this.f32320j = mutableState;
        this.f32321k = z12;
        this.f32322l = i11;
        this.f32323m = i12;
        this.f32324n = str;
        this.f32325o = str2;
        this.f32326p = f11;
        this.f32327q = str3;
        this.f32328r = str4;
        this.f32329s = str5;
        this.f32330t = num3;
        this.f32331u = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull RowScope rowScope, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$ListItemSelectableSurface");
        if (((i11 & 81) ^ 16) != 0 || !composer.getSkipping()) {
            CollectionsKt__CollectionsKt.listOfNotNull((T[]) new Integer[]{this.f32317g, this.f32318h}).size();
            final boolean z11 = this.f32319i;
            final MutableState<Boolean> mutableState = this.f32320j;
            final boolean z12 = this.f32321k;
            final int i12 = this.f32322l;
            final Integer num = this.f32317g;
            final Integer num2 = this.f32318h;
            final int i13 = this.f32323m;
            final String str = this.f32324n;
            String str2 = this.f32325o;
            float f11 = this.f32326p;
            String str3 = this.f32327q;
            String str4 = this.f32328r;
            String str5 = this.f32329s;
            final Integer num3 = this.f32330t;
            final float f12 = f11;
            final String str6 = str2;
            final String str7 = str3;
            final String str8 = str4;
            final String str9 = str5;
            final Function3<Boolean, Composer, Integer, Unit> function3 = this.f32331u;
            BoxWithConstraintsKt.BoxWithConstraints((Modifier) null, (Alignment) null, false, ComposableLambdaKt.composableLambda(composer, -819893249, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@NotNull BoxWithConstraintsScope boxWithConstraintsScope, @Nullable Composer composer, int i11) {
                    int i12;
                    BoxWithConstraintsScope boxWithConstraintsScope2 = boxWithConstraintsScope;
                    Composer composer2 = composer;
                    Intrinsics.checkNotNullParameter(boxWithConstraintsScope2, "$this$BoxWithConstraints");
                    if ((i11 & 14) == 0) {
                        i12 = i11 | (composer2.changed((Object) boxWithConstraintsScope2) ? 4 : 2);
                    } else {
                        i12 = i11;
                    }
                    if (((i12 & 91) ^ 18) != 0 || !composer.getSkipping()) {
                        if (z11) {
                            composer2.startReplaceableGroup(1253057491);
                            SelectableListItemComposablesKt.SelectionIndicator(boxWithConstraintsScope2.matchParentSize(Modifier.Companion), mutableState.getValue().booleanValue(), z12, composer, (i12 << 6) & 896, 0);
                            composer.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(1253057684);
                            composer.endReplaceableGroup();
                        }
                        Modifier.Companion companion = Modifier.Companion;
                        Modifier r22 = PaddingKt.m486padding3ABfNKs(companion, DSTheme.INSTANCE.getDimens(composer2, 0).m8842getDsSD9Ej5fM());
                        Alignment.Companion companion2 = Alignment.Companion;
                        Alignment.Vertical centerVertically = companion2.getCenterVertically();
                        Integer num = num;
                        Integer num2 = num2;
                        int i13 = i13;
                        String str = str;
                        String str2 = str6;
                        boolean z11 = z12;
                        int i14 = i12;
                        float f11 = f12;
                        String str3 = str;
                        String str4 = str7;
                        String str5 = str8;
                        String str6 = str9;
                        Integer num3 = num3;
                        Function3<Boolean, Composer, Integer, Unit> function3 = function3;
                        MutableState<Boolean> mutableState = mutableState;
                        composer2.startReplaceableGroup(-1989997546);
                        Arrangement arrangement = Arrangement.INSTANCE;
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composer2, 0);
                        composer2.startReplaceableGroup(1376089335);
                        Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
                        Function0<ComposeUiNode> constructor = companion3.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r22);
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
                        Composer r02 = Updater.m2536constructorimpl(composer);
                        Updater.m2543setimpl(r02, rowMeasurePolicy, companion3.getSetMeasurePolicy());
                        Updater.m2543setimpl(r02, density, companion3.getSetDensity());
                        Updater.m2543setimpl(r02, layoutDirection, companion3.getSetLayoutDirection());
                        composer.enableReusing();
                        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(-326682743);
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        float f12 = f11;
                        int i15 = i14;
                        boolean z12 = z11;
                        String str7 = str2;
                        String str8 = str4;
                        String str9 = str5;
                        String str10 = str6;
                        Integer num4 = num3;
                        Function3<Boolean, Composer, Integer, Unit> function32 = function3;
                        MutableState<Boolean> mutableState2 = mutableState;
                        String str11 = str3;
                        Modifier weight$default = e.a(rowScopeInstance, companion, 1.0f, false, 2, (Object) null);
                        composer2.startReplaceableGroup(-1989997546);
                        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer2, 0);
                        composer2.startReplaceableGroup(1376089335);
                        Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(weight$default);
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
                        Composer r62 = Updater.m2536constructorimpl(composer);
                        Updater.m2543setimpl(r62, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
                        Updater.m2543setimpl(r62, density2, companion3.getSetDensity());
                        Updater.m2543setimpl(r62, layoutDirection2, companion3.getSetLayoutDirection());
                        composer.enableReusing();
                        materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(-326682743);
                        int i16 = i13 >> 18;
                        int i17 = i15;
                        boolean z13 = z12;
                        boolean z14 = z13;
                        int i18 = i17;
                        int i19 = i13;
                        CommonListItemComposablesKt.m8488ListItemLeadingWidgethGBTI10(rowScopeInstance.align(companion, companion2.getTop()), num, num2, f12, z13, composer, (i16 & 7168) | (i16 & 112) | (i16 & 896) | ((i17 << 12) & 57344), 0);
                        Modifier align = rowScopeInstance.align(companion, companion2.getCenterVertically());
                        composer2.startReplaceableGroup(-1113031299);
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer2, 0);
                        composer2.startReplaceableGroup(1376089335);
                        Density density3 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection3 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(align);
                        if (!(composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            composer2.createNode(constructor3);
                        } else {
                            composer.useNode();
                        }
                        composer.disableReusing();
                        Composer r52 = Updater.m2536constructorimpl(composer);
                        Updater.m2543setimpl(r52, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                        Updater.m2543setimpl(r52, density3, companion3.getSetDensity());
                        Updater.m2543setimpl(r52, layoutDirection3, companion3.getSetLayoutDirection());
                        composer.enableReusing();
                        materializerOf3.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(276693241);
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i21 = i19 >> 12;
                        int i22 = i18;
                        int i23 = (i22 << 6) & 896;
                        CommonListItemComposablesKt.ListItemTopText(str8, str9, z14, composer2, (i19 & 14) | (i21 & 112) | i23);
                        CommonListItemComposablesKt.ListItemBottomText(str10, num4, z14, composer2, (i21 & 14) | ((i19 >> 15) & 112) | i23);
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
                        int i24 = i19 >> 18;
                        int i25 = i22 >> 3;
                        SelectableListItemComposablesKt.m8491ListItemSelectableTrailingContainerTN_CM5M(str11, str7, CommonListItemComposablesKt.m8489calculateTrailingContainerMaxWidthKz89ssw(boxWithConstraintsScope.m436getMaxWidthD9Ej5fM(), num, num2, composer, (i24 & 112) | (i24 & 896), 0), z14, ComposableLambdaKt.composableLambda(composer2, -819890808, true, new SelectableListItemComposablesKt$SelectionListItem$1$2$1$2(function32, mutableState2, i22)), composer, (i25 & 112) | (i25 & 14) | CpioConstants.C_ISBLK | ((i22 << 9) & 7168), 0);
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        composer.endNode();
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, KfsConstant.KFS_RSA_KEY_LEN_3072, 7);
            return;
        }
        composer.skipToGroupEnd();
    }
}
