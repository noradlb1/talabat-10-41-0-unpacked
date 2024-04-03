package com.talabat.talabatcommon.views.statusViews;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.views.talabarSnackBar.TalabatNotifySnackBarContentView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0015R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/talabatcommon/views/statusViews/StatusNotifyView;", "Lcom/talabat/talabatcommon/views/talabarSnackBar/TalabatNotifySnackBarContentView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "status", "Lcom/talabat/talabatcommon/views/statusViews/ActionStatus;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/talabat/talabatcommon/views/statusViews/ActionStatus;)V", "animationDuration", "", "animateContentIn", "", "delay", "duration", "animateContentOut", "initializeViews", "setMessage", "message", "", "setTitle", "title", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StatusNotifyView extends TalabatNotifySnackBarContentView {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    private final long animationDuration;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StatusNotifyView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, (ActionStatus) null, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StatusNotifyView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, (ActionStatus) null, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StatusNotifyView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, (ActionStatus) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StatusNotifyView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11, @NotNull ActionStatus actionStatus) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionStatus, "status");
        this._$_findViewCache = new LinkedHashMap();
        this.animationDuration = 750;
        View.inflate(context, R.layout.view_error_notify, this);
        initializeViews(actionStatus);
        setClipToPadding(false);
    }

    private final void initializeViews(ActionStatus actionStatus) {
        if (actionStatus == ActionStatus.FAILURE) {
            ((ImageView) _$_findCachedViewById(R.id.statusNotifyImageView)).setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_exclaimation_sign));
            ((LinearLayout) _$_findCachedViewById(R.id.container)).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_error_notify));
            return;
        }
        ((ImageView) _$_findCachedViewById(R.id.statusNotifyImageView)).setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_success_sign));
        ((LinearLayout) _$_findCachedViewById(R.id.container)).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_success_notify));
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void animateContentIn(int i11, int i12) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new OvershootInterpolator());
        animatorSet.setDuration(this.animationDuration);
        int i13 = R.id.statusNotifyImageView;
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat((ImageView) _$_findCachedViewById(i13), View.SCALE_X, new float[]{0.0f, 0.8f}), ObjectAnimator.ofFloat((ImageView) _$_findCachedViewById(i13), View.SCALE_Y, new float[]{0.0f, 0.8f})});
        animatorSet.start();
    }

    public void animateContentOut(int i11, int i12) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new OvershootInterpolator());
        animatorSet.setDuration(this.animationDuration);
        int i13 = R.id.statusNotifyImageView;
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat((ImageView) _$_findCachedViewById(i13), View.SCALE_X, new float[]{0.8f, 0.0f}), ObjectAnimator.ofFloat((ImageView) _$_findCachedViewById(i13), View.SCALE_Y, new float[]{0.8f, 0.0f})});
        animatorSet.start();
    }

    public final void setMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        ((TextView) _$_findCachedViewById(R.id.statusNotifyMessageTextView)).setText(str);
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        int i11 = R.id.statusNotifyTitleTextView;
        ((TextView) _$_findCachedViewById(i11)).setVisibility(0);
        ((TextView) _$_findCachedViewById(i11)).setText(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StatusNotifyView(Context context, AttributeSet attributeSet, int i11, ActionStatus actionStatus, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11, (i12 & 8) != 0 ? ActionStatus.FAILURE : actionStatus);
    }
}
