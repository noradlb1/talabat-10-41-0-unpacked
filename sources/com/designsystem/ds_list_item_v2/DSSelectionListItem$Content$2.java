package com.designsystem.ds_list_item_v2;

import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSSelectionListItem$Content$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSSelectionListItem f32077g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSelectionListItem$Content$2(DSSelectionListItem dSSelectionListItem) {
        super(2);
        this.f32077g = dSSelectionListItem;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        float f11;
        Composer composer2 = composer;
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            String label = this.f32077g.getLabel();
            if (label == null) {
                label = "";
            }
            boolean isListItemSelected = this.f32077g.isListItemSelected();
            Function1<Boolean, Unit> onChanged = this.f32077g.getOnChanged();
            String descriptor = this.f32077g.getDescriptor();
            String secondaryLabel = this.f32077g.getSecondaryLabel();
            Integer descriptorColor = this.f32077g.getDescriptorColor();
            Integer leadingIcon = this.f32077g.getLeadingIcon();
            Integer leadingImage = this.f32077g.getLeadingImage();
            Dp r102 = this.f32077g.m8483getImageCornerRadiuslTKBWiU();
            if (r102 == null) {
                composer2.startReplaceableGroup(-278937171);
                f11 = DSTheme.INSTANCE.getDimens(composer2, 0).m8841getDsMD9Ej5fM();
                composer.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(-278937207);
                composer.endReplaceableGroup();
                f11 = r102.m5492unboximpl();
            }
            Boolean isEnabled = this.f32077g.isEnabled();
            boolean booleanValue = isEnabled == null ? true : isEnabled.booleanValue();
            String price = this.f32077g.getPrice();
            String oldPrice = this.f32077g.getOldPrice();
            boolean showSelectionIndicator = this.f32077g.getShowSelectionIndicator();
            final DSSelectionListItem dSSelectionListItem = this.f32077g;
            DSSelectionListItemKt.m8485DSSelectionListItem_zuBKE(label, isListItemSelected, onChanged, (Modifier) null, descriptor, secondaryLabel, descriptorColor, leadingIcon, leadingImage, f11, booleanValue, price, oldPrice, showSelectionIndicator, ComposableLambdaKt.composableLambda(composer2, -819903026, true, new Function3<Boolean, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke(((Boolean) obj).booleanValue(), (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(boolean z11, @Nullable Composer composer, int i11) {
                    if (((i11 & 81) ^ 16) != 0 || !composer.getSkipping()) {
                        View access$getTrailingView = dSSelectionListItem.getTrailingView();
                        if (access$getTrailingView == null) {
                            composer.startReplaceableGroup(1750562381);
                        } else {
                            composer.startReplaceableGroup(1996132404);
                            AndroidView_androidKt.AndroidView(new DSSelectionListItem$Content$2$1$1$1(access$getTrailingView), (Modifier) null, (Function1) null, composer, 0, 6);
                        }
                        composer.endReplaceableGroup();
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 0, CpioConstants.C_ISBLK, 8);
            return;
        }
        composer.skipToGroupEnd();
    }
}
