package com.designsystem.ds_input_field;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.d;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class InputFieldCommonComposablesKt$TextFieldDecorationBox$1$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31679g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f31680h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ColumnScope f31681i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31682j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f31683k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f31684l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f31685m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Dp f31686n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31687o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31688p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ long f31689q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ TextStyle f31690r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ boolean f31691s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f31692t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ String f31693u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldCommonComposablesKt$TextFieldDecorationBox$1$1(Function2<? super Composer, ? super Integer, Unit> function2, int i11, ColumnScope columnScope, Function2<? super Composer, ? super Integer, Unit> function22, boolean z11, String str, boolean z12, Dp dp2, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, long j11, TextStyle textStyle, boolean z13, int i12, String str2) {
        super(3);
        this.f31679g = function2;
        this.f31680h = i11;
        this.f31681i = columnScope;
        this.f31682j = function22;
        this.f31683k = z11;
        this.f31684l = str;
        this.f31685m = z12;
        this.f31686n = dp2;
        this.f31687o = function23;
        this.f31688p = function24;
        this.f31689q = j11;
        this.f31690r = textStyle;
        this.f31691s = z13;
        this.f31692t = i12;
        this.f31693u = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull RowScope rowScope, @Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(rowScope, "it");
        if (((i11 & 81) ^ 16) != 0 || !composer.getSkipping()) {
            Function2<Composer, Integer, Unit> function2 = this.f31679g;
            if (function2 == null) {
                composer2.startReplaceableGroup(321356809);
            } else {
                composer2.startReplaceableGroup(-682370312);
                function2.invoke(composer2, Integer.valueOf((this.f31680h >> 24) & 14));
            }
            composer.endReplaceableGroup();
            Modifier weight$default = d.a(this.f31681i, Modifier.Companion, 1.0f, false, 2, (Object) null);
            boolean z11 = this.f31683k;
            String str = this.f31684l;
            boolean z12 = this.f31685m;
            Dp dp2 = this.f31686n;
            Function2<Composer, Integer, Unit> function22 = this.f31687o;
            Function2<Composer, Integer, Unit> function23 = this.f31688p;
            long j11 = this.f31689q;
            TextStyle textStyle = this.f31690r;
            boolean z13 = this.f31691s;
            int i12 = this.f31680h;
            int i13 = this.f31692t;
            String str2 = this.f31693u;
            composer2.startReplaceableGroup(-1990474327);
            String str3 = str2;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(1376089335);
            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            boolean z14 = z13;
            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            TextStyle textStyle2 = textStyle;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(weight$default);
            long j12 = j11;
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
            Composer r82 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r82, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r82, density, companion.getSetDensity());
            Updater.m2543setimpl(r82, layoutDirection, companion.getSetLayoutDirection());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-1253629305);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (z11) {
                composer2.startReplaceableGroup(-2122285316);
                int i14 = i13 << 3;
                int i15 = i12 << 9;
                int i16 = 29360128 & i15;
                InputFieldCommonComposablesKt.m8427TextInputWithAnimatedHintfD77gVg(boxScopeInstance, str, z12, dp2, function22, function23, j12, textStyle2, z14, composer, i16 | ((i12 >> 12) & 112) | 6 | (i14 & 896) | (i14 & 7168) | (57344 & (i12 >> 9)) | (458752 & i15) | (3670016 & i15) | (234881024 & i13));
                composer.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(-2122284904);
                int i17 = i13 << 6;
                InputFieldCommonComposablesKt.m8428TextInputWithHintUcWoP3I(boxScopeInstance, str3, str, z12, dp2, function22, function23, z14, composer, ((i12 << 3) & 112) | 6 | ((i12 >> 9) & 896) | (i17 & 7168) | (57344 & i17) | (458752 & (i12 >> 6)) | (3670016 & (i12 << 12)) | (29360128 & (i13 >> 3)));
                composer.endReplaceableGroup();
            }
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            Function2<Composer, Integer, Unit> function24 = this.f31682j;
            if (function24 == null) {
                composer2.startReplaceableGroup(321385081);
            } else {
                composer2.startReplaceableGroup(-682369400);
                function24.invoke(composer2, Integer.valueOf((this.f31680h >> 18) & 14));
            }
            composer.endReplaceableGroup();
            return;
        }
        composer.skipToGroupEnd();
    }
}
