package androidx.compose.material3;

import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidAlertDialog_androidKt$AlertDialog$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f6304g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6305h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6306i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6307j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Shape f6308k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f6309l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f6310m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f6311n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ long f6312o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ long f6313p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f6314q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f6315r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6316s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6317t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidAlertDialog_androidKt$AlertDialog$1(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, long j11, float f11, long j12, long j13, long j14, int i11, int i12, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25) {
        super(2);
        this.f6304g = modifier;
        this.f6305h = function2;
        this.f6306i = function22;
        this.f6307j = function23;
        this.f6308k = shape;
        this.f6309l = j11;
        this.f6310m = f11;
        this.f6311n = j12;
        this.f6312o = j13;
        this.f6313p = j14;
        this.f6314q = i11;
        this.f6315r = i12;
        this.f6316s = function24;
        this.f6317t = function25;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        int i12 = i11;
        if ((i12 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1218806937, i12, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:92)");
            }
            String r22 = Strings_androidKt.m1849getStringNWtq28(Strings.Companion.m1842getDialogadMyvUU(), composer2, 6);
            final Function2<Composer, Integer, Unit> function2 = this.f6316s;
            final int i13 = this.f6314q;
            final Function2<Composer, Integer, Unit> function22 = this.f6317t;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, 2094788745, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2094788745, i11, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:95)");
                        }
                        float access$getButtonsMainAxisSpacing$p = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                        float access$getButtonsCrossAxisSpacing$p = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                        final Function2<Composer, Integer, Unit> function2 = function2;
                        final int i12 = i13;
                        final Function2<Composer, Integer, Unit> function22 = function22;
                        AlertDialogKt.m1494AlertDialogFlowRowixp7dh8(access$getButtonsMainAxisSpacing$p, access$getButtonsCrossAxisSpacing$p, ComposableLambdaKt.composableLambda(composer, -1243689536, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer, int i11) {
                                if ((i11 & 11) != 2 || !composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1243689536, i11, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:99)");
                                    }
                                    Function2<Composer, Integer, Unit> function2 = function2;
                                    composer.startReplaceableGroup(-1969500760);
                                    if (function2 != null) {
                                        function2.invoke(composer, Integer.valueOf((i12 >> 9) & 14));
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    composer.endReplaceableGroup();
                                    function22.invoke(composer, Integer.valueOf((i12 >> 3) & 14));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer.skipToGroupEnd();
                            }
                        }), composer, 438);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            });
            Modifier modifier = this.f6304g;
            Modifier.Companion companion = Modifier.Companion;
            composer2.startReplaceableGroup(1157296644);
            boolean changed = composer2.changed((Object) r22);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new AndroidAlertDialog_androidKt$AlertDialog$1$2$1(r22);
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            Modifier then = modifier.then(SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, (Object) null));
            Function2<Composer, Integer, Unit> function23 = this.f6305h;
            Function2<Composer, Integer, Unit> function24 = this.f6306i;
            Function2<Composer, Integer, Unit> function25 = this.f6307j;
            Shape shape = this.f6308k;
            long j11 = this.f6309l;
            float f11 = this.f6310m;
            long color = ColorSchemeKt.toColor(DialogTokens.INSTANCE.getActionLabelTextColor(), composer2, 6);
            long j12 = this.f6311n;
            long j13 = this.f6312o;
            Modifier modifier2 = then;
            long j14 = this.f6313p;
            int i14 = this.f6314q;
            Function2<Composer, Integer, Unit> function26 = function23;
            int i15 = ((i14 >> 6) & 896) | 6 | ((i14 >> 6) & 7168) | ((i14 >> 6) & 57344) | ((i14 >> 6) & Opcodes.ASM7) | ((i14 >> 6) & 3670016);
            int i16 = this.f6315r;
            int i17 = i15 | ((i16 << 15) & 29360128) | (i14 & 1879048192);
            int i18 = (i16 & 14) | (i16 & 112);
            AlertDialogKt.m1493AlertDialogContent4hvqGtA(composableLambda, modifier2, function26, function24, function25, shape, j11, f11, color, j12, j13, j14, composer, i17, i18, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
