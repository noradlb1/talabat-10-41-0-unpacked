package com.designsystem.ds_progressive_offer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AbstractComposeView;
import com.designsystem.extensions.TypedArrayExtensionsKt;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010+\u001a\u00020,H\u0017¢\u0006\u0002\u0010-R/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR/\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R/\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR9\u0010\u001e\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\u001d2\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\u001d8F@FX\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0011\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R/\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\t\u001a\u0004\u0018\u00010$8F@FX\u0002¢\u0006\u0012\n\u0004\b*\u0010\u0011\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006."}, d2 = {"Lcom/designsystem/ds_progressive_offer/DSTieredProgressiveOffer;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "descriptor", "getDescriptor", "()Ljava/lang/String;", "setDescriptor", "(Ljava/lang/String;)V", "descriptor$delegate", "Landroidx/compose/runtime/MutableState;", "", "expirationTimestamp", "getExpirationTimestamp", "()Ljava/lang/Long;", "setExpirationTimestamp", "(Ljava/lang/Long;)V", "expirationTimestamp$delegate", "headline", "getHeadline", "setHeadline", "headline$delegate", "Landroidx/annotation/DrawableRes;", "headlineIcon", "getHeadlineIcon", "()Ljava/lang/Integer;", "setHeadlineIcon", "(Ljava/lang/Integer;)V", "headlineIcon$delegate", "", "progress", "getProgress", "()Ljava/lang/Float;", "setProgress", "(Ljava/lang/Float;)V", "progress$delegate", "Content", "", "(Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSTieredProgressiveOffer extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    private final MutableState descriptor$delegate;
    @NotNull
    private final MutableState expirationTimestamp$delegate;
    @NotNull
    private final MutableState headline$delegate;
    @NotNull
    private final MutableState headlineIcon$delegate;
    @NotNull
    private final MutableState progress$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSTieredProgressiveOffer(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSTieredProgressiveOffer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSTieredProgressiveOffer(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        float f11;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-856115676);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) this)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i11;
        } else {
            i12 = i11;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            getProgress();
            getHeadline();
            String headline = getHeadline();
            if (headline == null) {
                headline = "";
            }
            String str = headline;
            String descriptor = getDescriptor();
            Float progress = getProgress();
            if (progress == null) {
                f11 = 0.0f;
            } else {
                f11 = progress.floatValue();
            }
            DSTieredProgressiveOfferKt.DSTieredProgressiveOffer(str, f11, (Modifier) null, descriptor, getHeadlineIcon(), getExpirationTimestamp(), startRestartGroup, 0, 4);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSTieredProgressiveOffer$Content$3(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final String getDescriptor() {
        return (String) this.descriptor$delegate.getValue();
    }

    @Nullable
    public final Long getExpirationTimestamp() {
        return (Long) this.expirationTimestamp$delegate.getValue();
    }

    @Nullable
    public final String getHeadline() {
        return (String) this.headline$delegate.getValue();
    }

    @Nullable
    public final Integer getHeadlineIcon() {
        return (Integer) this.headlineIcon$delegate.getValue();
    }

    @Nullable
    public final Float getProgress() {
        return (Float) this.progress$delegate.getValue();
    }

    public final void setDescriptor(@Nullable String str) {
        this.descriptor$delegate.setValue(str);
    }

    public final void setExpirationTimestamp(@Nullable Long l11) {
        this.expirationTimestamp$delegate.setValue(l11);
    }

    public final void setHeadline(@Nullable String str) {
        this.headline$delegate.setValue(str);
    }

    public final void setHeadlineIcon(@Nullable Integer num) {
        this.headlineIcon$delegate.setValue(num);
    }

    public final void setProgress(@Nullable Float f11) {
        this.progress$delegate.setValue(f11);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSTieredProgressiveOffer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.headline$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.descriptor$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.progress$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.headlineIcon$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.expirationTimestamp$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSTieredProgressiveOffer, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…edProgressiveOffer, 0, 0)");
            setHeadline(obtainStyledAttributes.getString(R.styleable.DSTieredProgressiveOffer_tpo_headline));
            setDescriptor(obtainStyledAttributes.getString(R.styleable.DSTieredProgressiveOffer_tpo_descriptor));
            setProgress(TypedArrayExtensionsKt.getFloatOrNull(obtainStyledAttributes, R.styleable.DSTieredProgressiveOffer_tpo_progress));
            setHeadlineIcon(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSTieredProgressiveOffer_tpo_headline_icon));
            obtainStyledAttributes.recycle();
        }
    }
}
