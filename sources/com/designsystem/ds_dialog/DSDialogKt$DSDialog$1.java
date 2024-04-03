package com.designsystem.ds_dialog;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import com.google.android.exoplayer2.RendererCapabilities;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSDialogKt$DSDialog$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31068g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DialogProperties f31069h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f31070i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Modifier f31071j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f31072k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f31073l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ DSDialogSecondaryAction f31074m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ DSDialogPrimaryAction f31075n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSDialogKt$DSDialog$1(Function0<Unit> function0, DialogProperties dialogProperties, int i11, Modifier modifier, String str, String str2, DSDialogSecondaryAction dSDialogSecondaryAction, DSDialogPrimaryAction dSDialogPrimaryAction) {
        super(2);
        this.f31068g = function0;
        this.f31069h = dialogProperties;
        this.f31070i = i11;
        this.f31071j = modifier;
        this.f31072k = str;
        this.f31073l = str2;
        this.f31074m = dSDialogSecondaryAction;
        this.f31075n = dSDialogPrimaryAction;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Function0<Unit> function0 = this.f31068g;
            DialogProperties dialogProperties = this.f31069h;
            final Modifier modifier = this.f31071j;
            final String str = this.f31072k;
            final String str2 = this.f31073l;
            final int i12 = this.f31070i;
            final DSDialogSecondaryAction dSDialogSecondaryAction = this.f31074m;
            final DSDialogPrimaryAction dSDialogPrimaryAction = this.f31075n;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -819892696, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
                        Modifier modifier = modifier;
                        String str = str;
                        String str2 = str2;
                        final DSDialogSecondaryAction dSDialogSecondaryAction = dSDialogSecondaryAction;
                        final DSDialogPrimaryAction dSDialogPrimaryAction = dSDialogPrimaryAction;
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -819892275, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            @Composable
                            public final void invoke(@Nullable Composer composer, int i11) {
                                if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
                                    DSDialogSecondaryAction dSDialogSecondaryAction = dSDialogSecondaryAction;
                                    if (dSDialogSecondaryAction == null) {
                                        composer.startReplaceableGroup(1836870709);
                                    } else {
                                        composer.startReplaceableGroup(-1880408756);
                                        DialogComposablesKt.DialogSecondaryButton(dSDialogSecondaryAction.getTitle(), dSDialogSecondaryAction.getOnTap(), composer, 0);
                                    }
                                    composer.endReplaceableGroup();
                                    if (dSDialogPrimaryAction.getType() == DSDialogPrimaryActionType.NORMAL) {
                                        composer.startReplaceableGroup(-1880408582);
                                        DialogComposablesKt.DialogPrimaryButton(dSDialogPrimaryAction.getTitle(), dSDialogPrimaryAction.getOnTap(), composer, 0);
                                        composer.endReplaceableGroup();
                                        return;
                                    }
                                    composer.startReplaceableGroup(-1880408467);
                                    DialogComposablesKt.DialogDestructiveButton(dSDialogPrimaryAction.getTitle(), dSDialogPrimaryAction.getOnTap(), composer, 0);
                                    composer.endReplaceableGroup();
                                    return;
                                }
                                composer.skipToGroupEnd();
                            }
                        });
                        int i12 = i12;
                        DialogComposablesKt.DialogLayout(modifier, str, str2, composableLambda, composer, ((i12 >> 6) & 14) | KfsConstant.KFS_RSA_KEY_LEN_3072 | ((i12 >> 6) & 112) | ((i12 >> 6) & 896));
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            });
            int i13 = this.f31070i;
            AndroidDialog_androidKt.Dialog(function0, dialogProperties, composableLambda, composer, (i13 & 14) | RendererCapabilities.MODE_SUPPORT_MASK | ((i13 >> 15) & 112), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
