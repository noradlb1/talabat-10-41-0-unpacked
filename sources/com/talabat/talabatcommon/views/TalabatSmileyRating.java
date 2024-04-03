package com.talabat.talabatcommon.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.internal.NativeProtocol;
import com.talabat.talabatcommon.R;
import hv.c;
import hv.d;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0002J\u0006\u0010\u000e\u001a\u00020\tJ\b\u0010\u000f\u001a\u00020\fH\u0014J\u001a\u0010\u0010\u001a\u00020\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u0012J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\t¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatcommon/views/TalabatSmileyRating;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "applyRadioAnimation", "", "id", "getRating", "onAttachedToWindow", "setOnRatingChangedListener", "action", "Lkotlin/Function1;", "setRating", "rating", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatSmileyRating extends ConstraintLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatSmileyRating(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.view_talabat_smiley_rating, this);
    }

    private final void applyRadioAnimation(int i11) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300);
        scaleAnimation.setFillAfter(true);
        ((RadioButton) findViewById(i11)).startAnimation(scaleAnimation);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachedToWindow$lambda-0  reason: not valid java name */
    public static final void m5744onAttachedToWindow$lambda0(TalabatSmileyRating talabatSmileyRating, RadioGroup radioGroup, int i11) {
        Intrinsics.checkNotNullParameter(talabatSmileyRating, "this$0");
        talabatSmileyRating.applyRadioAnimation(i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnRatingChangedListener$lambda-1  reason: not valid java name */
    public static final void m5745setOnRatingChangedListener$lambda1(TalabatSmileyRating talabatSmileyRating, Function1 function1, RadioGroup radioGroup, int i11) {
        Intrinsics.checkNotNullParameter(talabatSmileyRating, "this$0");
        Intrinsics.checkNotNullParameter(function1, "$action");
        talabatSmileyRating.applyRadioAnimation(i11);
        if (i11 == R.id.radio_1) {
            function1.invoke(1);
        } else if (i11 == R.id.radio_2) {
            function1.invoke(2);
        } else if (i11 == R.id.radio_3) {
            function1.invoke(3);
        } else if (i11 == R.id.radio_4) {
            function1.invoke(4);
        } else if (i11 == R.id.radio_5) {
            function1.invoke(5);
        } else {
            function1.invoke(5);
        }
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

    public final int getRating() {
        int checkedRadioButtonId = ((RadioGroup) _$_findCachedViewById(R.id.rating_radio_group)).getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.radio_1) {
            return 1;
        }
        if (checkedRadioButtonId == R.id.radio_2) {
            return 2;
        }
        if (checkedRadioButtonId == R.id.radio_3) {
            return 3;
        }
        if (checkedRadioButtonId == R.id.radio_4) {
            return 4;
        }
        if (checkedRadioButtonId == R.id.radio_5) {
            return 5;
        }
        return 0;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((RadioGroup) _$_findCachedViewById(R.id.rating_radio_group)).setOnCheckedChangeListener(new c(this));
    }

    public final void setOnRatingChangedListener(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, NativeProtocol.WEB_DIALOG_ACTION);
        ((RadioGroup) _$_findCachedViewById(R.id.rating_radio_group)).setOnCheckedChangeListener(new d(this, function1));
    }

    public final void setRating(int i11) {
        if (i11 == 1) {
            ((RadioGroup) _$_findCachedViewById(R.id.rating_radio_group)).check(R.id.radio_1);
        } else if (i11 == 2) {
            ((RadioGroup) _$_findCachedViewById(R.id.rating_radio_group)).check(R.id.radio_2);
        } else if (i11 == 3) {
            ((RadioGroup) _$_findCachedViewById(R.id.rating_radio_group)).check(R.id.radio_3);
        } else if (i11 == 4) {
            ((RadioGroup) _$_findCachedViewById(R.id.rating_radio_group)).check(R.id.radio_4);
        } else if (i11 == 5) {
            ((RadioGroup) _$_findCachedViewById(R.id.rating_radio_group)).check(R.id.radio_5);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatSmileyRating(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.view_talabat_smiley_rating, this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatSmileyRating(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.view_talabat_smiley_rating, this);
    }
}
