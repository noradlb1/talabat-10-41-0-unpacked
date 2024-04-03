package com.talabat.talabatcommon.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.facebook.internal.NativeProtocol;
import com.talabat.talabatcommon.R;
import hv.e;
import hv.f;
import hv.g;
import hv.h;
import hv.i;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0006\u0010\u000f\u001a\u00020\tJ\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001a\u0010\u0015\u001a\u00020\r2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0\u0017J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\tJ\b\u0010\u001a\u001a\u00020\rH\u0002J\b\u0010\u001b\u001a\u00020\rH\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/talabat/talabatcommon/views/TalabatStarRating;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "selectedRating", "fiveStarRating", "", "fourStarRating", "getRating", "initialState", "oneStarRating", "selectStar", "star", "Landroid/widget/ImageView;", "setOnRatingChangedListener", "action", "Lkotlin/Function1;", "setRating", "rating", "threeStarRating", "twoStarRating", "unSelectStar", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatStarRating extends ConstraintLayout {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int FIVE_STAR_RATING = 5;
    public static final int FOUR_STAR_RATING = 4;
    public static final int ONE_STAR_RATING = 1;
    public static final int THREE_STAR_RATING = 3;
    public static final int TWO_STAR_RATING = 2;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private int selectedRating;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/TalabatStarRating$Companion;", "", "()V", "FIVE_STAR_RATING", "", "FOUR_STAR_RATING", "ONE_STAR_RATING", "THREE_STAR_RATING", "TWO_STAR_RATING", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatStarRating(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.view_talabat_star_rating, this);
        initialState();
    }

    private final void fiveStarRating() {
        this.selectedRating = 5;
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.star_1);
        Intrinsics.checkNotNullExpressionValue(imageView, "star_1");
        selectStar(imageView);
        ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.star_2);
        Intrinsics.checkNotNullExpressionValue(imageView2, "star_2");
        selectStar(imageView2);
        ImageView imageView3 = (ImageView) _$_findCachedViewById(R.id.star_3);
        Intrinsics.checkNotNullExpressionValue(imageView3, "star_3");
        selectStar(imageView3);
        ImageView imageView4 = (ImageView) _$_findCachedViewById(R.id.star_4);
        Intrinsics.checkNotNullExpressionValue(imageView4, "star_4");
        selectStar(imageView4);
        ImageView imageView5 = (ImageView) _$_findCachedViewById(R.id.star_5);
        Intrinsics.checkNotNullExpressionValue(imageView5, "star_5");
        selectStar(imageView5);
    }

    private final void fourStarRating() {
        this.selectedRating = 4;
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.star_1);
        Intrinsics.checkNotNullExpressionValue(imageView, "star_1");
        selectStar(imageView);
        ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.star_2);
        Intrinsics.checkNotNullExpressionValue(imageView2, "star_2");
        selectStar(imageView2);
        ImageView imageView3 = (ImageView) _$_findCachedViewById(R.id.star_3);
        Intrinsics.checkNotNullExpressionValue(imageView3, "star_3");
        selectStar(imageView3);
        ImageView imageView4 = (ImageView) _$_findCachedViewById(R.id.star_4);
        Intrinsics.checkNotNullExpressionValue(imageView4, "star_4");
        selectStar(imageView4);
        ImageView imageView5 = (ImageView) _$_findCachedViewById(R.id.star_5);
        Intrinsics.checkNotNullExpressionValue(imageView5, "star_5");
        unSelectStar(imageView5);
    }

    private final void initialState() {
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.star_1);
        Intrinsics.checkNotNullExpressionValue(imageView, "star_1");
        unSelectStar(imageView);
        ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.star_2);
        Intrinsics.checkNotNullExpressionValue(imageView2, "star_2");
        unSelectStar(imageView2);
        ImageView imageView3 = (ImageView) _$_findCachedViewById(R.id.star_3);
        Intrinsics.checkNotNullExpressionValue(imageView3, "star_3");
        unSelectStar(imageView3);
        ImageView imageView4 = (ImageView) _$_findCachedViewById(R.id.star_4);
        Intrinsics.checkNotNullExpressionValue(imageView4, "star_4");
        unSelectStar(imageView4);
        ImageView imageView5 = (ImageView) _$_findCachedViewById(R.id.star_5);
        Intrinsics.checkNotNullExpressionValue(imageView5, "star_5");
        unSelectStar(imageView5);
    }

    private final void oneStarRating() {
        this.selectedRating = 1;
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.star_1);
        Intrinsics.checkNotNullExpressionValue(imageView, "star_1");
        selectStar(imageView);
        ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.star_2);
        Intrinsics.checkNotNullExpressionValue(imageView2, "star_2");
        unSelectStar(imageView2);
        ImageView imageView3 = (ImageView) _$_findCachedViewById(R.id.star_3);
        Intrinsics.checkNotNullExpressionValue(imageView3, "star_3");
        unSelectStar(imageView3);
        ImageView imageView4 = (ImageView) _$_findCachedViewById(R.id.star_4);
        Intrinsics.checkNotNullExpressionValue(imageView4, "star_4");
        unSelectStar(imageView4);
        ImageView imageView5 = (ImageView) _$_findCachedViewById(R.id.star_5);
        Intrinsics.checkNotNullExpressionValue(imageView5, "star_5");
        unSelectStar(imageView5);
    }

    private final void selectStar(ImageView imageView) {
        imageView.setImageResource(com.designsystem.marshmallow.R.drawable.ds_star_filled);
        imageView.setColorFilter(ContextCompat.getColor(getContext(), com.designsystem.marshmallow.R.color.ds_alert_100));
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnRatingChangedListener$lambda-0  reason: not valid java name */
    public static final void m5746setOnRatingChangedListener$lambda0(TalabatStarRating talabatStarRating, Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(talabatStarRating, "this$0");
        Intrinsics.checkNotNullParameter(function1, "$action");
        talabatStarRating.oneStarRating();
        function1.invoke(1);
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnRatingChangedListener$lambda-1  reason: not valid java name */
    public static final void m5747setOnRatingChangedListener$lambda1(TalabatStarRating talabatStarRating, Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(talabatStarRating, "this$0");
        Intrinsics.checkNotNullParameter(function1, "$action");
        talabatStarRating.twoStarRating();
        function1.invoke(2);
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnRatingChangedListener$lambda-2  reason: not valid java name */
    public static final void m5748setOnRatingChangedListener$lambda2(TalabatStarRating talabatStarRating, Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(talabatStarRating, "this$0");
        Intrinsics.checkNotNullParameter(function1, "$action");
        talabatStarRating.threeStarRating();
        function1.invoke(3);
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnRatingChangedListener$lambda-3  reason: not valid java name */
    public static final void m5749setOnRatingChangedListener$lambda3(TalabatStarRating talabatStarRating, Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(talabatStarRating, "this$0");
        Intrinsics.checkNotNullParameter(function1, "$action");
        talabatStarRating.fourStarRating();
        function1.invoke(4);
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnRatingChangedListener$lambda-4  reason: not valid java name */
    public static final void m5750setOnRatingChangedListener$lambda4(TalabatStarRating talabatStarRating, Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(talabatStarRating, "this$0");
        Intrinsics.checkNotNullParameter(function1, "$action");
        talabatStarRating.fiveStarRating();
        function1.invoke(5);
    }

    private final void threeStarRating() {
        this.selectedRating = 3;
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.star_1);
        Intrinsics.checkNotNullExpressionValue(imageView, "star_1");
        selectStar(imageView);
        ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.star_2);
        Intrinsics.checkNotNullExpressionValue(imageView2, "star_2");
        selectStar(imageView2);
        ImageView imageView3 = (ImageView) _$_findCachedViewById(R.id.star_3);
        Intrinsics.checkNotNullExpressionValue(imageView3, "star_3");
        selectStar(imageView3);
        ImageView imageView4 = (ImageView) _$_findCachedViewById(R.id.star_4);
        Intrinsics.checkNotNullExpressionValue(imageView4, "star_4");
        unSelectStar(imageView4);
        ImageView imageView5 = (ImageView) _$_findCachedViewById(R.id.star_5);
        Intrinsics.checkNotNullExpressionValue(imageView5, "star_5");
        unSelectStar(imageView5);
    }

    private final void twoStarRating() {
        this.selectedRating = 2;
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.star_1);
        Intrinsics.checkNotNullExpressionValue(imageView, "star_1");
        selectStar(imageView);
        ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.star_2);
        Intrinsics.checkNotNullExpressionValue(imageView2, "star_2");
        selectStar(imageView2);
        ImageView imageView3 = (ImageView) _$_findCachedViewById(R.id.star_3);
        Intrinsics.checkNotNullExpressionValue(imageView3, "star_3");
        unSelectStar(imageView3);
        ImageView imageView4 = (ImageView) _$_findCachedViewById(R.id.star_4);
        Intrinsics.checkNotNullExpressionValue(imageView4, "star_4");
        unSelectStar(imageView4);
        ImageView imageView5 = (ImageView) _$_findCachedViewById(R.id.star_5);
        Intrinsics.checkNotNullExpressionValue(imageView5, "star_5");
        unSelectStar(imageView5);
    }

    private final void unSelectStar(ImageView imageView) {
        imageView.setImageResource(com.designsystem.marshmallow.R.drawable.ds_star_filled);
        imageView.setColorFilter(ContextCompat.getColor(getContext(), com.designsystem.marshmallow.R.color.ds_neutral_10));
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
        return this.selectedRating;
    }

    public final void setOnRatingChangedListener(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, NativeProtocol.WEB_DIALOG_ACTION);
        ((ImageView) _$_findCachedViewById(R.id.star_1)).setOnClickListener(new e(this, function1));
        ((ImageView) _$_findCachedViewById(R.id.star_2)).setOnClickListener(new f(this, function1));
        ((ImageView) _$_findCachedViewById(R.id.star_3)).setOnClickListener(new g(this, function1));
        ((ImageView) _$_findCachedViewById(R.id.star_4)).setOnClickListener(new h(this, function1));
        ((ImageView) _$_findCachedViewById(R.id.star_5)).setOnClickListener(new i(this, function1));
    }

    public final void setRating(int i11) {
        if (i11 == 1) {
            ((ImageView) _$_findCachedViewById(R.id.star_1)).performClick();
            invalidate();
        } else if (i11 == 2) {
            ((ImageView) _$_findCachedViewById(R.id.star_2)).performClick();
            invalidate();
        } else if (i11 == 3) {
            ((ImageView) _$_findCachedViewById(R.id.star_3)).performClick();
            invalidate();
        } else if (i11 == 4) {
            ((ImageView) _$_findCachedViewById(R.id.star_4)).performClick();
            invalidate();
        } else if (i11 == 5) {
            ((ImageView) _$_findCachedViewById(R.id.star_5)).performClick();
            invalidate();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatStarRating(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.view_talabat_star_rating, this);
        initialState();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatStarRating(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.view_talabat_star_rating, this);
        initialState();
    }
}
