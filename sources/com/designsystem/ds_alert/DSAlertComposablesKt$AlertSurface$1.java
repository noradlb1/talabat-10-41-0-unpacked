package com.designsystem.ds_alert;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
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
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import p.e;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSAlertComposablesKt$AlertSurface$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f30511g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AlertTypeModel f30512h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Boolean f30513i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f30514j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f30515k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f30516l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ DSAlertActionButtonModel f30517m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ DSIconButtonModel f30518n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSAlertComposablesKt$AlertSurface$1(Modifier modifier, AlertTypeModel alertTypeModel, Boolean bool, int i11, String str, String str2, DSAlertActionButtonModel dSAlertActionButtonModel, DSIconButtonModel dSIconButtonModel) {
        super(2);
        this.f30511g = modifier;
        this.f30512h = alertTypeModel;
        this.f30513i = bool;
        this.f30514j = i11;
        this.f30515k = str;
        this.f30516l = str2;
        this.f30517m = dSAlertActionButtonModel;
        this.f30518n = dSIconButtonModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier modifier = this.f30511g;
            AlertTypeModel alertTypeModel = this.f30512h;
            Boolean bool = this.f30513i;
            final String str = this.f30515k;
            final String str2 = this.f30516l;
            final DSAlertActionButtonModel dSAlertActionButtonModel = this.f30517m;
            final int i12 = this.f30514j;
            final DSIconButtonModel dSIconButtonModel = this.f30518n;
            final Boolean bool2 = bool;
            final AlertTypeModel alertTypeModel2 = alertTypeModel;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -819895864, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    int i12;
                    Composer composer2 = composer;
                    if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
                        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                        Boolean bool = bool2;
                        AlertTypeModel alertTypeModel = alertTypeModel2;
                        String str = str;
                        String str2 = str2;
                        DSAlertActionButtonModel dSAlertActionButtonModel = dSAlertActionButtonModel;
                        int i13 = i12;
                        DSIconButtonModel dSIconButtonModel = dSIconButtonModel;
                        composer2.startReplaceableGroup(-1989997546);
                        Modifier.Companion companion = Modifier.Companion;
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 0);
                        composer2.startReplaceableGroup(1376089335);
                        Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(companion);
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
                        Updater.m2543setimpl(r02, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m2543setimpl(r02, density, companion2.getSetDensity());
                        Updater.m2543setimpl(r02, layoutDirection, companion2.getSetLayoutDirection());
                        composer.enableReusing();
                        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(-326682743);
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        if (Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
                            composer2.startReplaceableGroup(-1655331206);
                            i12 = 0;
                            DSAlertComposablesKt.AlertIcon(alertTypeModel, composer2, 0);
                            composer.endReplaceableGroup();
                        } else {
                            i12 = 0;
                            composer2.startReplaceableGroup(-1655331077);
                            composer.endReplaceableGroup();
                        }
                        int i14 = i13 >> 3;
                        DSAlertComposablesKt.AlertContent(e.a(rowScopeInstance, companion, 1.0f, false, 2, (Object) null), str, str2, dSAlertActionButtonModel, composer, (i13 & 112) | (i14 & 896) | (i14 & 7168), 0);
                        DSAlertComposablesKt.AlertIconButton(dSIconButtonModel, composer2, (i13 >> 15) & 14, i12);
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        composer.endNode();
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            });
            int i13 = this.f30514j;
            DSAlertComposablesKt.AlertBackground(modifier, alertTypeModel, bool, composableLambda, composer, (i13 & 14) | KfsConstant.KFS_RSA_KEY_LEN_3072 | ((i13 >> 12) & 896), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
