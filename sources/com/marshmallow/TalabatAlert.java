package com.marshmallow;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.talabat.marshmallow.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002R$\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00118F@FX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0017@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/marshmallow/TalabatAlert;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "alertIcon", "getAlertIcon", "()I", "setAlertIcon", "(I)V", "", "alertMessage", "getAlertMessage", "()Ljava/lang/String;", "setAlertMessage", "(Ljava/lang/String;)V", "Lcom/marshmallow/AlertType;", "alertType", "getAlertType", "()Lcom/marshmallow/AlertType;", "setAlertType", "(Lcom/marshmallow/AlertType;)V", "initAlertView", "", "updateUi", "com_talabat_NewArchi_Marshmallow_Marshmallow"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatAlert extends FrameLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private int alertIcon;
    @NotNull
    private AlertType alertType;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AlertType.values().length];
            iArr[AlertType.NOTIFICATION.ordinal()] = 1;
            iArr[AlertType.WARNING.ordinal()] = 2;
            iArr[AlertType.ERROR.ordinal()] = 3;
            iArr[AlertType.SUCCESS.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatAlert(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.alertType = AlertType.NOTIFICATION;
        initAlertView((AttributeSet) null);
    }

    private final void initAlertView(AttributeSet attributeSet) {
        View.inflate(getContext(), R.layout.view_talabat_alert, this);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TalabatAlert);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…R.styleable.TalabatAlert)");
        String string = obtainStyledAttributes.getString(R.styleable.TalabatAlert_alert_message);
        if (string != null) {
            setAlertMessage(string);
        }
        setAlertIcon(obtainStyledAttributes.getResourceId(R.styleable.TalabatAlert_alert_icon, 0));
        AlertType alertType2 = AlertType.Companion.getAlertType(obtainStyledAttributes.getInteger(R.styleable.TalabatAlert_alert_type, 0));
        if (alertType2 == null) {
            alertType2 = AlertType.NOTIFICATION;
        }
        setAlertType(alertType2);
        obtainStyledAttributes.recycle();
    }

    private final void updateUi() {
        invalidate();
        requestLayout();
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

    public final int getAlertIcon() {
        return this.alertIcon;
    }

    @NotNull
    public final String getAlertMessage() {
        return ((TextView) _$_findCachedViewById(R.id.alertMessageTextView)).getText().toString();
    }

    @NotNull
    public final AlertType getAlertType() {
        return this.alertType;
    }

    public final void setAlertIcon(int i11) {
        ((ImageView) _$_findCachedViewById(R.id.alertIconImageView)).setImageResource(i11);
        updateUi();
        this.alertIcon = i11;
    }

    public final void setAlertMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        ((TextView) _$_findCachedViewById(R.id.alertMessageTextView)).setText(str);
        updateUi();
    }

    public final void setAlertType(@NotNull AlertType alertType2) {
        Intrinsics.checkNotNullParameter(alertType2, "value");
        int i11 = WhenMappings.$EnumSwitchMapping$0[alertType2.ordinal()];
        if (i11 == 1) {
            ((LinearLayout) _$_findCachedViewById(R.id.alertContainer)).setBackgroundResource(com.example.talabatresources.R.drawable.bg_alert_notification);
        } else if (i11 == 2) {
            ((LinearLayout) _$_findCachedViewById(R.id.alertContainer)).setBackgroundResource(com.example.talabatresources.R.drawable.bg_alert_warning);
        } else if (i11 == 3) {
            ((LinearLayout) _$_findCachedViewById(R.id.alertContainer)).setBackgroundResource(com.example.talabatresources.R.drawable.bg_alert_error);
        } else if (i11 == 4) {
            ((LinearLayout) _$_findCachedViewById(R.id.alertContainer)).setBackgroundResource(com.example.talabatresources.R.drawable.bg_alert_success);
        }
        updateUi();
        this.alertType = alertType2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatAlert(@NotNull Context context, @Nullable @androidx.annotation.Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.alertType = AlertType.NOTIFICATION;
        initAlertView(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatAlert(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.alertType = AlertType.NOTIFICATION;
        initAlertView(attributeSet);
    }
}
