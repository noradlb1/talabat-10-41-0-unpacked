package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.e;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ListItemComposablesKt$ListItem$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32187g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32188h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f32189i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f32190j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f32191k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f32192l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Integer f32193m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Integer f32194n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function3<Boolean, Composer, Integer, Unit> f32195o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f32196p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ String f32197q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ String f32198r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ String f32199s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Integer f32200t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListItemComposablesKt$ListItem$1(Modifier modifier, Function0<Unit> function0, MutableInteractionSource mutableInteractionSource, boolean z11, int i11, int i12, Integer num, Integer num2, Function3<? super Boolean, ? super Composer, ? super Integer, Unit> function3, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32, String str, String str2, String str3, Integer num3) {
        super(2);
        this.f32187g = modifier;
        this.f32188h = function0;
        this.f32189i = mutableInteractionSource;
        this.f32190j = z11;
        this.f32191k = i11;
        this.f32192l = i12;
        this.f32193m = num;
        this.f32194n = num2;
        this.f32195o = function3;
        this.f32196p = function32;
        this.f32197q = str;
        this.f32198r = str2;
        this.f32199s = str3;
        this.f32200t = num3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier modifier = this.f32187g;
            Function0<Unit> function0 = this.f32188h;
            MutableInteractionSource mutableInteractionSource = this.f32189i;
            boolean z11 = this.f32190j;
            final Integer num = this.f32193m;
            final Integer num2 = this.f32194n;
            final int i12 = this.f32191k;
            final Function3<Boolean, Composer, Integer, Unit> function3 = this.f32195o;
            final Function3<RowScope, Composer, Integer, Unit> function32 = this.f32196p;
            final String str = this.f32197q;
            final String str2 = this.f32198r;
            final int i13 = this.f32192l;
            String str3 = this.f32199s;
            final Integer num3 = this.f32200t;
            String str4 = str3;
            final boolean z12 = z11;
            boolean z13 = z11;
            AnonymousClass1 r12 = r5;
            final String str5 = str4;
            AnonymousClass1 r52 = new Function3<RowScope, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@NotNull RowScope rowScope, @Nullable Composer composer, int i11) {
                    Intrinsics.checkNotNullParameter(rowScope, "$this$ListItemSurface");
                    if (((i11 & 81) ^ 16) != 0 || !composer.getSkipping()) {
                        CollectionsKt__CollectionsKt.listOfNotNull((T[]) new Integer[]{num, num2}).size();
                        final Integer num = num;
                        final Integer num2 = num2;
                        final int i12 = i12;
                        final Function3<Boolean, Composer, Integer, Unit> function3 = function3;
                        final Function3<RowScope, Composer, Integer, Unit> function32 = function32;
                        final String str = str;
                        final String str2 = str2;
                        final boolean z11 = z12;
                        int i13 = i13;
                        final String str3 = str5;
                        final int i14 = i13;
                        final Integer num3 = num3;
                        AnonymousClass2 r72 = new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() {
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
                                    Integer num = num;
                                    Integer num2 = num2;
                                    int i13 = i12;
                                    Function3<Boolean, Composer, Integer, Unit> function3 = function3;
                                    Function3<RowScope, Composer, Integer, Unit> function32 = function32;
                                    String str = str;
                                    String str2 = str2;
                                    boolean z11 = z11;
                                    int i14 = i14;
                                    String str3 = str3;
                                    Integer num3 = num3;
                                    composer2.startReplaceableGroup(-1989997546);
                                    Modifier.Companion companion = Modifier.Companion;
                                    Arrangement arrangement = Arrangement.INSTANCE;
                                    Arrangement.Horizontal start = arrangement.getStart();
                                    Alignment.Companion companion2 = Alignment.Companion;
                                    Function3<Boolean, Composer, Integer, Unit> function33 = function3;
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion2.getTop(), composer2, 0);
                                    composer2.startReplaceableGroup(1376089335);
                                    Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
                                    Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                    Integer num4 = num2;
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(companion);
                                    Modifier.Companion companion4 = companion;
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
                                    Composer r12 = Updater.m2536constructorimpl(composer);
                                    Updater.m2543setimpl(r12, rowMeasurePolicy, companion3.getSetMeasurePolicy());
                                    Updater.m2543setimpl(r12, density, companion3.getSetDensity());
                                    Updater.m2543setimpl(r12, layoutDirection, companion3.getSetLayoutDirection());
                                    composer.enableReusing();
                                    materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    composer2.startReplaceableGroup(-326682743);
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    Modifier.Companion companion5 = companion4;
                                    Modifier weight$default = e.a(rowScopeInstance, companion4, 1.0f, false, 2, (Object) null);
                                    composer2.startReplaceableGroup(-1989997546);
                                    MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer2, 0);
                                    composer2.startReplaceableGroup(1376089335);
                                    Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    Integer num5 = num;
                                    Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(weight$default);
                                    String str4 = str3;
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
                                    Composer r22 = Updater.m2536constructorimpl(composer);
                                    Updater.m2543setimpl(r22, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
                                    Updater.m2543setimpl(r22, density2, companion3.getSetDensity());
                                    Updater.m2543setimpl(r22, layoutDirection2, companion3.getSetLayoutDirection());
                                    composer.enableReusing();
                                    materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    composer2.startReplaceableGroup(-326682743);
                                    if (function32 == null) {
                                        composer2.startReplaceableGroup(-863406568);
                                        composer.endReplaceableGroup();
                                    } else {
                                        composer2.startReplaceableGroup(1911810825);
                                        function32.invoke(rowScopeInstance, composer2, Integer.valueOf(((i13 >> 24) & 112) | 6));
                                        composer.endReplaceableGroup();
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    Modifier align = rowScopeInstance.align(companion5, companion2.getCenterVertically());
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
                                    Composer r122 = Updater.m2536constructorimpl(composer);
                                    Updater.m2543setimpl(r122, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                                    Updater.m2543setimpl(r122, density3, companion3.getSetDensity());
                                    Updater.m2543setimpl(r122, layoutDirection3, companion3.getSetLayoutDirection());
                                    composer.enableReusing();
                                    materializerOf3.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    composer2.startReplaceableGroup(276693241);
                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                    int i15 = (i14 << 3) & 896;
                                    CommonListItemComposablesKt.ListItemTopText(str, str2, z11, composer2, (i13 & 14) | ((i13 >> 3) & 112) | i15);
                                    int i16 = i13 >> 9;
                                    CommonListItemComposablesKt.ListItemBottomText(str4, num3, z11, composer2, (i16 & 112) | (i16 & 14) | i15);
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
                                    int i17 = i13 >> 15;
                                    float r13 = CommonListItemComposablesKt.m8489calculateTrailingContainerMaxWidthKz89ssw(boxWithConstraintsScope.m436getMaxWidthD9Ej5fM(), num5, num4, composer, (i17 & 112) | (i17 & 896), 0);
                                    if (function33 == null) {
                                        composer2.startReplaceableGroup(-2141664993);
                                    } else {
                                        composer2.startReplaceableGroup(1593482018);
                                        Modifier r14 = SizeKt.m565widthInVpY3zN4$default(rowScopeInstance.align(companion5, companion2.getCenterVertically()), 0.0f, r13, 1, (Object) null);
                                        composer2.startReplaceableGroup(-1990474327);
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer2, 0);
                                        composer2.startReplaceableGroup(1376089335);
                                        Density density4 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                                        LayoutDirection layoutDirection4 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                        Function0<ComposeUiNode> constructor4 = companion3.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf4 = LayoutKt.materializerOf(r14);
                                        if (!(composer.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer.startReusableNode();
                                        if (composer.getInserting()) {
                                            composer2.createNode(constructor4);
                                        } else {
                                            composer.useNode();
                                        }
                                        composer.disableReusing();
                                        Composer r62 = Updater.m2536constructorimpl(composer);
                                        Updater.m2543setimpl(r62, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                                        Updater.m2543setimpl(r62, density4, companion3.getSetDensity());
                                        Updater.m2543setimpl(r62, layoutDirection4, companion3.getSetLayoutDirection());
                                        composer.enableReusing();
                                        materializerOf4.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                                        composer2.startReplaceableGroup(2058660585);
                                        composer2.startReplaceableGroup(-1253629305);
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ListItemComposablesKt.ListItemTrailingContainer(ComposableLambdaKt.composableLambda(composer2, -819893367, true, new ListItemComposablesKt$ListItem$1$1$2$1$2$1$1(function33, z11, i14)), composer2, 6, 0);
                                        composer.endReplaceableGroup();
                                        composer.endReplaceableGroup();
                                        composer.endNode();
                                        composer.endReplaceableGroup();
                                        composer.endReplaceableGroup();
                                        Unit unit2 = Unit.INSTANCE;
                                    }
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
                        };
                        Composer composer2 = composer;
                        BoxWithConstraintsKt.BoxWithConstraints((Modifier) null, (Alignment) null, false, ComposableLambdaKt.composableLambda(composer2, -819892270, true, r72), composer2, KfsConstant.KFS_RSA_KEY_LEN_3072, 7);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            };
            Composer composer2 = composer;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, -819892714, true, r12);
            int i14 = this.f32191k;
            ListItemComposablesKt.ListItemSurface(modifier, function0, mutableInteractionSource, z13, composableLambda, composer2, ((i14 >> 12) & 112) | ((i14 >> 3) & 14) | 24960 | ((this.f32192l << 6) & 7168), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
