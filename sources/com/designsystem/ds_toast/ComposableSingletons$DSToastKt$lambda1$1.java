package com.designsystem.ds_toast;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import com.designsystem.ds_toast.DSToastHostState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u000b"}, d2 = {"Lcom/designsystem/ds_toast/DSToastHostState$ToastData;", "toastData", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* renamed from: com.designsystem.ds_toast.ComposableSingletons$DSToastKt$lambda-1$1  reason: invalid class name */
public final class ComposableSingletons$DSToastKt$lambda1$1 extends Lambda implements Function3<DSToastHostState.ToastData, Composer, Integer, Unit> {
    public static final ComposableSingletons$DSToastKt$lambda1$1 INSTANCE = new ComposableSingletons$DSToastKt$lambda1$1();

    public ComposableSingletons$DSToastKt$lambda1$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((DSToastHostState.ToastData) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull DSToastHostState.ToastData toastData, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(toastData, "toastData");
        if ((i11 & 14) == 0) {
            i11 |= composer.changed((Object) toastData) ? 4 : 2;
        }
        if (((i11 & 91) ^ 18) != 0 || !composer.getSkipping()) {
            DSToastModel model = toastData.getModel();
            model.getLabel().length();
            if (model.getOnActionTap$marshmallow_release() != null) {
                composer.startReplaceableGroup(-911136280);
                ToastComposablesKt.ToastWithActionButton(model.getLabel(), model.getLeadingIcon(), model.getOnActionTap$marshmallow_release(), model.getOnActionLabel$marshmallow_release(), composer, 0, 0);
                composer.endReplaceableGroup();
            } else if (model.getOnTrailingIconTap$marshmallow_release() != null) {
                composer.startReplaceableGroup(-911135828);
                ToastComposablesKt.ToastWithIconButton(model.getLabel(), model.getLeadingIcon(), model.getOnTrailingIconTap$marshmallow_release(), model.getTrailingIcon$marshmallow_release(), composer, 0, 0);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-911135395);
                ToastComposablesKt.BaseToast(model.getLabel(), model.getLeadingIcon(), composer, 0, 0);
                composer.endReplaceableGroup();
            }
        } else {
            composer.skipToGroupEnd();
        }
    }
}
