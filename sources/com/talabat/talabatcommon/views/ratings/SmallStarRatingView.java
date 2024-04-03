package com.talabat.talabatcommon.views.ratings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import com.designsystem.marshmallow.R;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u00103\u001a\u000201H\u0002R0\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0015@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R0\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u001d0\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R$\u0010#\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\u000e\u0010&\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R$\u0010'\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R$\u0010*\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R$\u0010-\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u0010\u0014¨\u00064"}, d2 = {"Lcom/talabat/talabatcommon/views/ratings/SmallStarRatingView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "colors", "getColors", "()Ljava/util/List;", "setColors", "(Ljava/util/List;)V", "notRatedTextColor", "getNotRatedTextColor", "()I", "setNotRatedTextColor", "(I)V", "", "rating", "getRating", "()F", "setRating", "(F)V", "ratingImage", "Landroid/widget/ImageView;", "Lcom/talabat/talabatcommon/views/ratings/RatingRange;", "ratingRanges", "getRatingRanges", "setRatingRanges", "ratingText", "Landroid/widget/TextView;", "ratingTextColor", "getRatingTextColor", "setRatingTextColor", "reviewText", "reviewTextColor", "getReviewTextColor", "setReviewTextColor", "reviewsAmount", "getReviewsAmount", "setReviewsAmount", "textStyle", "getTextStyle", "setTextStyle", "init", "", "attr", "updateView", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SmallStarRatingView extends LinearLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private List<Integer> colors;
    private int notRatedTextColor;
    private float rating;
    @NotNull
    private final ImageView ratingImage;
    @NotNull
    private List<RatingRange> ratingRanges;
    @NotNull
    private final TextView ratingText;
    private int ratingTextColor;
    @NotNull
    private final TextView reviewText;
    private int reviewTextColor;
    private int reviewsAmount;
    private int textStyle;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SmallStarRatingView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SmallStarRatingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SmallStarRatingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.reviewsAmount = 1;
        this.ratingRanges = SmallStarRatingUseCaseKt.getDefaultRatings();
        this.colors = CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(ContextCompat.getColor(context, R.color.ds_alert_100)));
        this.ratingTextColor = ContextCompat.getColor(context, R.color.ds_neutral_100);
        int i12 = R.color.ds_neutral_55;
        this.notRatedTextColor = ContextCompat.getColor(context, i12);
        this.reviewTextColor = ContextCompat.getColor(context, i12);
        this.textStyle = R.style.DSTextAppearance_Body1;
        setOrientation(0);
        setGravity(17);
        View inflate = View.inflate(context, com.talabat.talabatcommon.R.layout.view_ratings_small, this);
        View findViewById = inflate.findViewById(com.talabat.talabatcommon.R.id.ratingImage);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.ratingImage)");
        this.ratingImage = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(com.talabat.talabatcommon.R.id.ratingText);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.ratingText)");
        this.ratingText = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(com.talabat.talabatcommon.R.id.reviewsAmount);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.reviewsAmount)");
        this.reviewText = (TextView) findViewById3;
        init(attributeSet);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:1|2|3|4|5|6|(1:8)|15|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0083 */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x00a2 A[Catch:{ all -> 0x00c4 }, LOOP:0: B:7:0x00a0->B:8:0x00a2, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void init(android.util.AttributeSet r7) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int[] r1 = com.talabat.talabatcommon.R.styleable.SmallStarRatingView
            android.content.res.TypedArray r7 = r0.obtainStyledAttributes(r7, r1)
            java.lang.String r0 = "context.obtainStyledAttr…able.SmallStarRatingView)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            int r0 = com.talabat.talabatcommon.R.styleable.SmallStarRatingView_ratingValue     // Catch:{ all -> 0x00c4 }
            r1 = 0
            float r0 = r7.getFloat(r0, r1)     // Catch:{ all -> 0x00c4 }
            r6.setRating(r0)     // Catch:{ all -> 0x00c4 }
            int r0 = com.talabat.talabatcommon.R.styleable.SmallStarRatingView_reviewsAmount     // Catch:{ all -> 0x00c4 }
            r1 = 0
            int r0 = r7.getInt(r0, r1)     // Catch:{ all -> 0x00c4 }
            r6.setReviewsAmount(r0)     // Catch:{ all -> 0x00c4 }
            int r0 = com.talabat.talabatcommon.R.styleable.SmallStarRatingView_reviewTextColor     // Catch:{ all -> 0x00c4 }
            android.content.Context r2 = r6.getContext()     // Catch:{ all -> 0x00c4 }
            int r3 = com.designsystem.marshmallow.R.color.ds_neutral_35     // Catch:{ all -> 0x00c4 }
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)     // Catch:{ all -> 0x00c4 }
            int r0 = r7.getColor(r0, r2)     // Catch:{ all -> 0x00c4 }
            r6.setReviewTextColor(r0)     // Catch:{ all -> 0x00c4 }
            int r0 = com.talabat.talabatcommon.R.styleable.SmallStarRatingView_ratingTextColor     // Catch:{ all -> 0x00c4 }
            android.content.Context r2 = r6.getContext()     // Catch:{ all -> 0x00c4 }
            int r3 = com.designsystem.marshmallow.R.color.ds_neutral_100     // Catch:{ all -> 0x00c4 }
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)     // Catch:{ all -> 0x00c4 }
            int r0 = r7.getColor(r0, r2)     // Catch:{ all -> 0x00c4 }
            r6.setRatingTextColor(r0)     // Catch:{ all -> 0x00c4 }
            int r0 = com.talabat.talabatcommon.R.styleable.SmallStarRatingView_notRatedTextColor     // Catch:{ all -> 0x00c4 }
            android.content.Context r2 = r6.getContext()     // Catch:{ all -> 0x00c4 }
            int r3 = com.designsystem.marshmallow.R.color.ds_neutral_55     // Catch:{ all -> 0x00c4 }
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)     // Catch:{ all -> 0x00c4 }
            int r0 = r7.getColor(r0, r2)     // Catch:{ all -> 0x00c4 }
            r6.setNotRatedTextColor(r0)     // Catch:{ all -> 0x00c4 }
            int r0 = com.talabat.talabatcommon.R.styleable.SmallStarRatingView_textStyle     // Catch:{ all -> 0x00c4 }
            int r2 = com.designsystem.marshmallow.R.style.DSTextAppearance_Body1     // Catch:{ all -> 0x00c4 }
            int r0 = r7.getResourceId(r0, r2)     // Catch:{ all -> 0x00c4 }
            r6.setTextStyle(r0)     // Catch:{ all -> 0x00c4 }
            int r0 = com.talabat.talabatcommon.R.styleable.SmallStarRatingView_colorRange     // Catch:{ UnsupportedOperationException -> 0x0083 }
            android.content.Context r2 = r6.getContext()     // Catch:{ UnsupportedOperationException -> 0x0083 }
            int r3 = com.designsystem.marshmallow.R.color.ds_alert_100     // Catch:{ UnsupportedOperationException -> 0x0083 }
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)     // Catch:{ UnsupportedOperationException -> 0x0083 }
            int r0 = r7.getColor(r0, r2)     // Catch:{ UnsupportedOperationException -> 0x0083 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ UnsupportedOperationException -> 0x0083 }
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r0)     // Catch:{ UnsupportedOperationException -> 0x0083 }
            r6.setColors(r0)     // Catch:{ UnsupportedOperationException -> 0x0083 }
            goto L_0x00c0
        L_0x0083:
            android.content.res.Resources r0 = r6.getResources()     // Catch:{ all -> 0x00c4 }
            int r2 = com.talabat.talabatcommon.R.styleable.SmallStarRatingView_colorRange     // Catch:{ all -> 0x00c4 }
            r3 = -1
            int r2 = r7.getResourceId(r2, r3)     // Catch:{ all -> 0x00c4 }
            android.content.res.TypedArray r0 = r0.obtainTypedArray(r2)     // Catch:{ all -> 0x00c4 }
            java.lang.String r2 = "resources.obtainTypedArr…ge, -1)\n                )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ all -> 0x00c4 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00c4 }
            r2.<init>()     // Catch:{ all -> 0x00c4 }
            int r3 = r0.length()     // Catch:{ all -> 0x00c4 }
        L_0x00a0:
            if (r1 >= r3) goto L_0x00ba
            android.content.Context r4 = r6.getContext()     // Catch:{ all -> 0x00c4 }
            int r5 = com.designsystem.marshmallow.R.color.ds_alert_100     // Catch:{ all -> 0x00c4 }
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)     // Catch:{ all -> 0x00c4 }
            int r4 = r0.getColor(r1, r4)     // Catch:{ all -> 0x00c4 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00c4 }
            r2.add(r4)     // Catch:{ all -> 0x00c4 }
            int r1 = r1 + 1
            goto L_0x00a0
        L_0x00ba:
            r6.setColors(r2)     // Catch:{ all -> 0x00c4 }
            r0.recycle()     // Catch:{ all -> 0x00c4 }
        L_0x00c0:
            r7.recycle()
            return
        L_0x00c4:
            r0 = move-exception
            r7.recycle()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.ratings.SmallStarRatingView.init(android.util.AttributeSet):void");
    }

    private final void updateView() {
        TextViewCompat.setTextAppearance(this.reviewText, this.textStyle);
        TextViewCompat.setTextAppearance(this.ratingText, this.textStyle);
        if (this.reviewsAmount <= 0) {
            this.ratingText.setVisibility(8);
            this.reviewText.setVisibility(0);
            this.reviewText.setText(getContext().getText(com.talabat.localization.R.string.not_rated));
            this.reviewText.setTextColor(this.notRatedTextColor);
            this.ratingImage.setColorFilter(ContextCompat.getColor(getContext(), R.color.ds_neutral_35));
            return;
        }
        this.reviewText.setTextColor(this.reviewTextColor);
        this.ratingText.setTextColor(this.ratingTextColor);
        this.ratingText.setVisibility(0);
        this.ratingText.setText(SmallStarRatingUseCaseKt.formatRating(this.rating));
        this.reviewText.setText(SmallStarRatingUseCaseKt.formatReviews(this.reviewsAmount));
        this.ratingImage.setColorFilter(SmallStarRatingUseCaseKt.getColorFromRating(this.rating, this.ratingRanges, this.colors));
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

    @NotNull
    public final List<Integer> getColors() {
        return this.colors;
    }

    public final int getNotRatedTextColor() {
        return this.notRatedTextColor;
    }

    public final float getRating() {
        return this.rating;
    }

    @NotNull
    public final List<RatingRange> getRatingRanges() {
        return this.ratingRanges;
    }

    public final int getRatingTextColor() {
        return this.ratingTextColor;
    }

    public final int getReviewTextColor() {
        return this.reviewTextColor;
    }

    public final int getReviewsAmount() {
        return this.reviewsAmount;
    }

    public final int getTextStyle() {
        return this.textStyle;
    }

    public final void setColors(@NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.colors = list;
        updateView();
    }

    public final void setNotRatedTextColor(int i11) {
        this.notRatedTextColor = i11;
        updateView();
    }

    public final void setRating(float f11) {
        this.rating = f11;
        updateView();
    }

    public final void setRatingRanges(@NotNull List<RatingRange> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.ratingRanges = list;
        updateView();
    }

    public final void setRatingTextColor(int i11) {
        this.ratingTextColor = i11;
        updateView();
    }

    public final void setReviewTextColor(int i11) {
        this.reviewTextColor = i11;
        updateView();
    }

    public final void setReviewsAmount(int i11) {
        this.reviewsAmount = i11;
        updateView();
    }

    public final void setTextStyle(int i11) {
        this.textStyle = i11;
        updateView();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SmallStarRatingView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
