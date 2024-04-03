package com.designsystem.ds_simple_card;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.res.ColorResources_androidKt;
import com.designsystem.extensions.TypedArrayExtensionsKt;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001?B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010=\u001a\u00020/H\u0017¢\u0006\u0002\u0010>R/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0012\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R9\u0010\u0019\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\u00182\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\u00188F@FX\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR/\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\t\u001a\u0004\u0018\u00010\u001f8F@FX\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0011\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R+\u0010&\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0002¢\u0006\u0012\n\u0004\b)\u0010\u0011\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000fR+\u0010*\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b-\u0010\u0011\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u0016R;\u00100\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.8F@FX\u0002¢\u0006\u0012\n\u0004\b5\u0010\u0011\u001a\u0004\b1\u00102\"\u0004\b3\u00104R/\u00107\u001a\u0004\u0018\u0001062\b\u0010\t\u001a\u0004\u0018\u0001068F@FX\u0002¢\u0006\u0012\n\u0004\b<\u0010\u0011\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006@"}, d2 = {"Lcom/designsystem/ds_simple_card/DSSimpleCard;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "descriptor", "getDescriptor", "()Ljava/lang/String;", "setDescriptor", "(Ljava/lang/String;)V", "descriptor$delegate", "Landroidx/compose/runtime/MutableState;", "descriptorColor", "getDescriptorColor", "()I", "setDescriptorColor", "(I)V", "descriptorColor$delegate", "Landroidx/annotation/DrawableRes;", "icon", "getIcon", "()Ljava/lang/Integer;", "setIcon", "(Ljava/lang/Integer;)V", "icon$delegate", "Lcom/designsystem/ds_simple_card/DSSimpleCardImageModel;", "image", "getImage", "()Lcom/designsystem/ds_simple_card/DSSimpleCardImageModel;", "setImage", "(Lcom/designsystem/ds_simple_card/DSSimpleCardImageModel;)V", "image$delegate", "label", "getLabel", "setLabel", "label$delegate", "labelColor", "getLabelColor", "setLabelColor", "labelColor$delegate", "Lkotlin/Function0;", "", "onTap", "getOnTap", "()Lkotlin/jvm/functions/Function0;", "setOnTap", "(Lkotlin/jvm/functions/Function0;)V", "onTap$delegate", "Landroid/view/View;", "trailingView", "getTrailingView", "()Landroid/view/View;", "setTrailingView", "(Landroid/view/View;)V", "trailingView$delegate", "Content", "(Landroidx/compose/runtime/Composer;I)V", "Companion", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSSimpleCard extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String IconTag = "IconTag";
    @NotNull
    public static final String ImageTag = "ImageTag";
    @NotNull
    public static final String TrailingViewTag = "TrailingViewTag";
    @NotNull
    private final MutableState descriptor$delegate;
    @NotNull
    private final MutableState descriptorColor$delegate;
    @NotNull
    private final MutableState icon$delegate;
    @NotNull
    private final MutableState image$delegate;
    @NotNull
    private final MutableState label$delegate;
    @NotNull
    private final MutableState labelColor$delegate;
    @NotNull
    private final MutableState onTap$delegate;
    @NotNull
    private final MutableState trailingView$delegate;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/designsystem/ds_simple_card/DSSimpleCard$Companion;", "", "()V", "IconTag", "", "ImageTag", "TrailingViewTag", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSSimpleCard(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSSimpleCard(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSSimpleCard(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        ComposableLambda composableLambda;
        int i13;
        int i14 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-1418955998);
        if ((i14 & 14) == 0) {
            if (startRestartGroup.changed((Object) this)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i14;
        } else {
            i12 = i14;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            String label = getLabel();
            long colorResource = ColorResources_androidKt.colorResource(getLabelColor(), startRestartGroup, 0);
            String descriptor = getDescriptor();
            long colorResource2 = ColorResources_androidKt.colorResource(getDescriptorColor(), startRestartGroup, 0);
            Integer icon = getIcon();
            DSSimpleCardImageModel image = getImage();
            Function0<Unit> onTap = getOnTap();
            View trailingView = getTrailingView();
            if (trailingView == null) {
                composableLambda = null;
            } else {
                composableLambda = ComposableLambdaKt.composableLambdaInstance(-985546176, true, new DSSimpleCard$Content$1$1(trailingView));
            }
            DSSimpleCardKt.m8571DSSimpleCardbaIBcDA(label, (Modifier) null, colorResource, descriptor, colorResource2, icon, image, onTap, composableLambda, startRestartGroup, 0, 2);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSSimpleCard$Content$2(this, i14));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final String getDescriptor() {
        return (String) this.descriptor$delegate.getValue();
    }

    public final int getDescriptorColor() {
        return ((Number) this.descriptorColor$delegate.getValue()).intValue();
    }

    @Nullable
    public final Integer getIcon() {
        return (Integer) this.icon$delegate.getValue();
    }

    @Nullable
    public final DSSimpleCardImageModel getImage() {
        return (DSSimpleCardImageModel) this.image$delegate.getValue();
    }

    @NotNull
    public final String getLabel() {
        return (String) this.label$delegate.getValue();
    }

    public final int getLabelColor() {
        return ((Number) this.labelColor$delegate.getValue()).intValue();
    }

    @Nullable
    public final Function0<Unit> getOnTap() {
        return (Function0) this.onTap$delegate.getValue();
    }

    @Nullable
    public final View getTrailingView() {
        return (View) this.trailingView$delegate.getValue();
    }

    public final void setDescriptor(@Nullable String str) {
        this.descriptor$delegate.setValue(str);
    }

    public final void setDescriptorColor(int i11) {
        this.descriptorColor$delegate.setValue(Integer.valueOf(i11));
    }

    public final void setIcon(@Nullable Integer num) {
        this.icon$delegate.setValue(num);
    }

    public final void setImage(@Nullable DSSimpleCardImageModel dSSimpleCardImageModel) {
        this.image$delegate.setValue(dSSimpleCardImageModel);
    }

    public final void setLabel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.label$delegate.setValue(str);
    }

    public final void setLabelColor(int i11) {
        this.labelColor$delegate.setValue(Integer.valueOf(i11));
    }

    public final void setOnTap(@Nullable Function0<Unit> function0) {
        this.onTap$delegate.setValue(function0);
    }

    public final void setTrailingView(@Nullable View view) {
        this.trailingView$delegate.setValue(view);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSSimpleCard(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        String str = "";
        this.label$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, (SnapshotMutationPolicy) null, 2, (Object) null);
        int i12 = R.color.ds_neutral_100;
        this.labelColor$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i12), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.descriptor$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        int i13 = R.color.ds_neutral_70;
        this.descriptorColor$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i13), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.icon$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.image$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onTap$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.trailingView$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSSimpleCard, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…eable.DSSimpleCard, 0, 0)");
            String string = obtainStyledAttributes.getString(R.styleable.DSSimpleCard_sc_label);
            setLabel(string != null ? string : str);
            Integer resourceIdOrNull = TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSSimpleCard_sc_label_color);
            setLabelColor(resourceIdOrNull != null ? resourceIdOrNull.intValue() : i12);
            setDescriptor(obtainStyledAttributes.getString(R.styleable.DSSimpleCard_sc_descriptor));
            Integer resourceIdOrNull2 = TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSSimpleCard_sc_descriptor_color);
            setDescriptorColor(resourceIdOrNull2 != null ? resourceIdOrNull2.intValue() : i13);
            setIcon(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSSimpleCard_sc_icon));
            obtainStyledAttributes.recycle();
        }
    }
}
