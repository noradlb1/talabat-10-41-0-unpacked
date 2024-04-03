package com.talabat.designhelpers;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.R;

@Instrumented
public class CircularProgressBar extends ProgressBar {
    private static final int STROKE_WIDTH = 20;
    private static final String TAG = "CircularProgressBar";
    private int emptyStar;
    private int[] emptyStarArray = {R.drawable.icon_star_empty_s, R.drawable.icon_star_empty_s, R.drawable.icon_star_empty_s, R.drawable.icon_star_empty_s, R.drawable.icon_star_empty_s};
    private int fullStar;
    private int[] fullStarArray = {R.drawable.icon_star_filled_s, R.drawable.icon_star_filled_s, R.drawable.icon_star_filled_s, R.drawable.icon_star_filled_s, R.drawable.icon_star_filled_s};
    private int halfStar;
    private int[] halfStarArray = {R.drawable.icon_star_halffilled_s, R.drawable.icon_star_halffilled_s, R.drawable.icon_star_halffilled_s, R.drawable.icon_star_halffilled_s, R.drawable.icon_star_halffilled_s};
    private final Paint mBackgroundColorPaint = new Paint();
    private final RectF mCircleBounds = new RectF();
    private boolean mHasShadow = true;
    private final Paint mProgressColorPaint = new Paint();
    private int mShadowColor = ViewCompat.MEASURED_STATE_MASK;
    private int mStrokeWidth = 20;
    private String mSubTitle = "";
    private final Paint mSubtitlePaint = new Paint();
    private String mTitle = "";
    private final Paint mTitlePaint = new Paint();
    private String percentage = "%";
    private final Paint percentagePaint = new Paint();
    private float rating = 0.0f;
    private boolean setRating = false;

    public CircularProgressBar(Context context) {
        super(context);
        init((AttributeSet) null, 0);
    }

    private int getNumStars() {
        return 5;
    }

    private synchronized float getRating() {
        return this.rating;
    }

    public synchronized String getTitle() {
        return this.mTitle;
    }

    public void init(AttributeSet attributeSet, int i11) {
        setLayerType(1, (Paint) null);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.talabat.talabatcommon.R.styleable.CircularProgressBar, i11, 0);
        Resources resources = getResources();
        this.mHasShadow = obtainStyledAttributes.getBoolean(1, true);
        int dimension = (int) obtainStyledAttributes.getDimension(11, (float) ((int) getResources().getDimension(R.dimen.title_text_size)));
        int dimension2 = (int) obtainStyledAttributes.getDimension(6, (float) ((int) getResources().getDimension(R.dimen.sub_title_text_size)));
        String string = obtainStyledAttributes.getString(2);
        if (string == null) {
            this.mProgressColorPaint.setColor(resources.getColor(R.color.circular_progress_default_progress));
        } else {
            this.mProgressColorPaint.setColor(Color.parseColor(string));
        }
        String string2 = obtainStyledAttributes.getString(0);
        if (string2 == null) {
            this.mBackgroundColorPaint.setColor(resources.getColor(R.color.circular_progress_default_background));
        } else {
            this.mBackgroundColorPaint.setColor(Color.parseColor(string2));
        }
        String string3 = obtainStyledAttributes.getString(10);
        if (string3 == null) {
            this.mTitlePaint.setColor(resources.getColor(R.color.circular_progress_default_title));
        } else {
            this.mTitlePaint.setColor(Color.parseColor(string3));
        }
        String string4 = obtainStyledAttributes.getString(8);
        if (string4 == null) {
            this.mSubtitlePaint.setColor(resources.getColor(R.color.circular_progress_default_subtitle));
        } else {
            this.mSubtitlePaint.setColor(Color.parseColor(string4));
        }
        String string5 = obtainStyledAttributes.getString(9);
        if (string5 != null) {
            this.mTitle = string5;
        }
        String string6 = obtainStyledAttributes.getString(7);
        if (string6 != null) {
            this.mSubTitle = string6;
        }
        this.mStrokeWidth = obtainStyledAttributes.getInt(5, 20);
        obtainStyledAttributes.recycle();
        Typeface font = ResourcesCompat.getFont(getContext(), R.font.dm_sans_medium);
        this.mProgressColorPaint.setAntiAlias(true);
        this.mProgressColorPaint.setStyle(Paint.Style.STROKE);
        this.mProgressColorPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mProgressColorPaint.setStrokeWidth((float) this.mStrokeWidth);
        this.mBackgroundColorPaint.setAntiAlias(true);
        this.mBackgroundColorPaint.setStyle(Paint.Style.STROKE);
        this.mBackgroundColorPaint.setStrokeWidth((float) this.mStrokeWidth);
        this.mTitlePaint.setTextSize((float) dimension);
        this.mTitlePaint.setStyle(Paint.Style.FILL);
        this.mTitlePaint.setAntiAlias(true);
        this.mTitlePaint.setTypeface(font);
        this.mTitlePaint.setShadowLayer(0.1f, 0.0f, 1.0f, -7829368);
        this.percentagePaint.setTextSize((float) ((int) getResources().getDimension(R.dimen.percentage_text_size)));
        this.percentagePaint.setStyle(Paint.Style.FILL);
        this.percentagePaint.setAntiAlias(true);
        this.percentagePaint.setColor(getResources().getColor(R.color.circular_progress_percentage));
        this.percentagePaint.setTypeface(font);
        this.percentagePaint.setShadowLayer(0.1f, 0.0f, 1.0f, R.color.circular_progress_percentage);
        this.mSubtitlePaint.setTextSize((float) dimension2);
        this.mSubtitlePaint.setStyle(Paint.Style.FILL);
        this.mSubtitlePaint.setAntiAlias(true);
        this.mSubtitlePaint.setTypeface(font);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onDraw(android.graphics.Canvas r15) {
        /*
            r14 = this;
            monitor-enter(r14)
            android.graphics.RectF r1 = r14.mCircleBounds     // Catch:{ all -> 0x0205 }
            r2 = 0
            r3 = 1135869952(0x43b40000, float:360.0)
            r4 = 0
            android.graphics.Paint r5 = r14.mBackgroundColorPaint     // Catch:{ all -> 0x0205 }
            r0 = r15
            r0.drawArc(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0205 }
            int r0 = r14.getProgress()     // Catch:{ all -> 0x0205 }
            int r1 = r14.getMax()     // Catch:{ all -> 0x0205 }
            r2 = 0
            if (r1 <= 0) goto L_0x0024
            float r0 = (float) r0     // Catch:{ all -> 0x0205 }
            int r1 = r14.getMax()     // Catch:{ all -> 0x0205 }
            float r1 = (float) r1     // Catch:{ all -> 0x0205 }
            float r0 = r0 / r1
            r1 = 1135869952(0x43b40000, float:360.0)
            float r0 = r0 * r1
            r3 = r0
            goto L_0x0025
        L_0x0024:
            r3 = r2
        L_0x0025:
            boolean r0 = r14.mHasShadow     // Catch:{ all -> 0x0205 }
            r6 = 1065353216(0x3f800000, float:1.0)
            r7 = 1077936128(0x40400000, float:3.0)
            if (r0 == 0) goto L_0x0034
            android.graphics.Paint r0 = r14.mProgressColorPaint     // Catch:{ all -> 0x0205 }
            int r1 = r14.mShadowColor     // Catch:{ all -> 0x0205 }
            r0.setShadowLayer(r7, r2, r6, r1)     // Catch:{ all -> 0x0205 }
        L_0x0034:
            android.graphics.RectF r1 = r14.mCircleBounds     // Catch:{ all -> 0x0205 }
            r2 = 1132920832(0x43870000, float:270.0)
            r4 = 0
            android.graphics.Paint r5 = r14.mProgressColorPaint     // Catch:{ all -> 0x0205 }
            r0 = r15
            r0.drawArc(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0205 }
            java.lang.String r0 = r14.mTitle     // Catch:{ all -> 0x0205 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0205 }
            if (r0 != 0) goto L_0x0200
            int r0 = r14.getMeasuredWidth()     // Catch:{ all -> 0x0205 }
            int r0 = r0 / 2
            float r0 = (float) r0     // Catch:{ all -> 0x0205 }
            android.graphics.Paint r1 = r14.mTitlePaint     // Catch:{ all -> 0x0205 }
            java.lang.String r2 = r14.mTitle     // Catch:{ all -> 0x0205 }
            float r1 = r1.measureText(r2)     // Catch:{ all -> 0x0205 }
            android.graphics.Paint r2 = r14.percentagePaint     // Catch:{ all -> 0x0205 }
            java.lang.String r3 = r14.percentage     // Catch:{ all -> 0x0205 }
            float r2 = r2.measureText(r3)     // Catch:{ all -> 0x0205 }
            float r1 = r1 + r2
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            float r0 = r0 - r1
            int r0 = (int) r0     // Catch:{ all -> 0x0205 }
            int r1 = r14.getMeasuredHeight()     // Catch:{ all -> 0x0205 }
            int r1 = r1 / 2
            android.graphics.Paint r3 = r14.mTitlePaint     // Catch:{ all -> 0x0205 }
            float r3 = r3.descent()     // Catch:{ all -> 0x0205 }
            android.graphics.Paint r4 = r14.mTitlePaint     // Catch:{ all -> 0x0205 }
            float r4 = r4.ascent()     // Catch:{ all -> 0x0205 }
            float r3 = r3 + r4
            float r3 = java.lang.Math.abs(r3)     // Catch:{ all -> 0x0205 }
            boolean r4 = r14.setRating     // Catch:{ all -> 0x0205 }
            if (r4 != 0) goto L_0x0093
            java.lang.String r4 = r14.mSubTitle     // Catch:{ all -> 0x0205 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0205 }
            if (r4 != 0) goto L_0x0088
            goto L_0x0093
        L_0x0088:
            java.lang.String r4 = r14.mSubTitle     // Catch:{ all -> 0x0205 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0205 }
            if (r4 == 0) goto L_0x0097
            float r1 = (float) r1     // Catch:{ all -> 0x0205 }
            float r3 = r3 / r2
            goto L_0x0095
        L_0x0093:
            float r1 = (float) r1     // Catch:{ all -> 0x0205 }
            float r3 = r3 / r7
        L_0x0095:
            float r1 = r1 + r3
            int r1 = (int) r1     // Catch:{ all -> 0x0205 }
        L_0x0097:
            java.lang.String r3 = r14.mTitle     // Catch:{ all -> 0x0205 }
            float r0 = (float) r0     // Catch:{ all -> 0x0205 }
            float r4 = (float) r1     // Catch:{ all -> 0x0205 }
            android.graphics.Paint r5 = r14.mTitlePaint     // Catch:{ all -> 0x0205 }
            r15.drawText(r3, r0, r4, r5)     // Catch:{ all -> 0x0205 }
            boolean r3 = r14.setRating     // Catch:{ all -> 0x0205 }
            if (r3 == 0) goto L_0x00b9
            android.graphics.Paint r3 = r14.mTitlePaint     // Catch:{ all -> 0x0205 }
            java.lang.String r5 = r14.mTitle     // Catch:{ all -> 0x0205 }
            float r3 = r3.measureText(r5)     // Catch:{ all -> 0x0205 }
            float r0 = r0 + r3
            r3 = 1092616192(0x41200000, float:10.0)
            float r0 = r0 + r3
            int r0 = (int) r0     // Catch:{ all -> 0x0205 }
            java.lang.String r3 = r14.percentage     // Catch:{ all -> 0x0205 }
            float r0 = (float) r0     // Catch:{ all -> 0x0205 }
            android.graphics.Paint r5 = r14.percentagePaint     // Catch:{ all -> 0x0205 }
            r15.drawText(r3, r0, r4, r5)     // Catch:{ all -> 0x0205 }
        L_0x00b9:
            android.content.res.Resources r0 = r14.getResources()     // Catch:{ all -> 0x0205 }
            r3 = 2131168356(0x7f070c64, float:1.7951012E38)
            r0.getDimension(r3)     // Catch:{ all -> 0x0205 }
            android.content.res.Resources r0 = r14.getResources()     // Catch:{ all -> 0x0205 }
            r3 = 2131492934(0x7f0c0046, float:1.8609334E38)
            int r0 = r0.getInteger(r3)     // Catch:{ all -> 0x0205 }
            int r3 = r14.getMeasuredWidth()     // Catch:{ all -> 0x0205 }
            int r3 = r3 / 2
            float r3 = (float) r3     // Catch:{ all -> 0x0205 }
            android.graphics.Paint r5 = r14.mSubtitlePaint     // Catch:{ all -> 0x0205 }
            java.lang.String r7 = r14.mSubTitle     // Catch:{ all -> 0x0205 }
            float r5 = r5.measureText(r7)     // Catch:{ all -> 0x0205 }
            float r5 = r5 / r2
            float r3 = r3 - r5
            int r2 = (int) r3     // Catch:{ all -> 0x0205 }
            boolean r3 = r14.setRating     // Catch:{ all -> 0x0205 }
            if (r3 == 0) goto L_0x01f6
            android.content.res.Resources r0 = r14.getResources()     // Catch:{ all -> 0x0205 }
            r1 = 2131168349(0x7f070c5d, float:1.7950997E38)
            float r0 = r0.getDimension(r1)     // Catch:{ all -> 0x0205 }
            int r0 = (int) r0     // Catch:{ all -> 0x0205 }
            int r1 = r14.getMeasuredWidth()     // Catch:{ all -> 0x0205 }
            int r1 = r1 / r0
            android.content.res.Resources r0 = r14.getResources()     // Catch:{ all -> 0x0205 }
            r2 = 2131168120(0x7f070b78, float:1.7950533E38)
            float r0 = r0.getDimension(r2)     // Catch:{ all -> 0x0205 }
            int r0 = (int) r0     // Catch:{ all -> 0x0205 }
            int r2 = r14.getNumStars()     // Catch:{ all -> 0x0205 }
            float r3 = r14.getRating()     // Catch:{ all -> 0x0205 }
            android.content.res.Resources r5 = r14.getResources()     // Catch:{ all -> 0x0205 }
            android.graphics.Paint r7 = new android.graphics.Paint     // Catch:{ all -> 0x0205 }
            r7.<init>()     // Catch:{ all -> 0x0205 }
            float r7 = (float) r2     // Catch:{ all -> 0x0205 }
            int r8 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            r9 = 0
            if (r8 <= 0) goto L_0x01db
            float r6 = r3 % r6
            double r10 = (double) r6     // Catch:{ all -> 0x0205 }
            r12 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r6 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            r8 = 5
            if (r6 != 0) goto L_0x018f
            r6 = 1
            r14.halfStar = r6     // Catch:{ all -> 0x0205 }
            float r7 = r7 - r3
            int r6 = (int) r7     // Catch:{ all -> 0x0205 }
            r14.emptyStar = r6     // Catch:{ all -> 0x0205 }
            r6 = r9
            r7 = r6
        L_0x012b:
            if (r6 >= r2) goto L_0x0200
            r10 = r9
        L_0x012e:
            int r11 = (int) r3     // Catch:{ all -> 0x0205 }
            if (r10 >= r11) goto L_0x014c
            if (r7 >= r8) goto L_0x0149
            int[] r11 = r14.fullStarArray     // Catch:{ all -> 0x0205 }
            r11 = r11[r10]     // Catch:{ all -> 0x0205 }
            android.graphics.Bitmap r11 = com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation.decodeResource(r5, r11)     // Catch:{ all -> 0x0205 }
            int r12 = r0 * r7
            int r12 = r12 + r1
            float r12 = (float) r12     // Catch:{ all -> 0x0205 }
            android.graphics.Paint r13 = r14.mTitlePaint     // Catch:{ all -> 0x0205 }
            r15.drawBitmap(r11, r12, r4, r13)     // Catch:{ all -> 0x0205 }
            r15.save()     // Catch:{ all -> 0x0205 }
            int r7 = r7 + 1
        L_0x0149:
            int r10 = r10 + 1
            goto L_0x012e
        L_0x014c:
            r10 = r9
        L_0x014d:
            int r11 = r14.halfStar     // Catch:{ all -> 0x0205 }
            if (r10 >= r11) goto L_0x016c
            if (r7 >= r8) goto L_0x0169
            int[] r11 = r14.halfStarArray     // Catch:{ all -> 0x0205 }
            r11 = r11[r10]     // Catch:{ all -> 0x0205 }
            android.graphics.Bitmap r11 = com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation.decodeResource(r5, r11)     // Catch:{ all -> 0x0205 }
            int r12 = r0 * r7
            int r12 = r12 + r1
            float r12 = (float) r12     // Catch:{ all -> 0x0205 }
            android.graphics.Paint r13 = r14.mTitlePaint     // Catch:{ all -> 0x0205 }
            r15.drawBitmap(r11, r12, r4, r13)     // Catch:{ all -> 0x0205 }
            r15.save()     // Catch:{ all -> 0x0205 }
            int r7 = r7 + 1
        L_0x0169:
            int r10 = r10 + 1
            goto L_0x014d
        L_0x016c:
            r10 = r9
        L_0x016d:
            int r11 = r14.emptyStar     // Catch:{ all -> 0x0205 }
            if (r10 >= r11) goto L_0x018c
            if (r7 >= r8) goto L_0x0189
            int[] r11 = r14.emptyStarArray     // Catch:{ all -> 0x0205 }
            r11 = r11[r10]     // Catch:{ all -> 0x0205 }
            android.graphics.Bitmap r11 = com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation.decodeResource(r5, r11)     // Catch:{ all -> 0x0205 }
            int r12 = r0 * r7
            int r12 = r12 + r1
            float r12 = (float) r12     // Catch:{ all -> 0x0205 }
            android.graphics.Paint r13 = r14.mTitlePaint     // Catch:{ all -> 0x0205 }
            r15.drawBitmap(r11, r12, r4, r13)     // Catch:{ all -> 0x0205 }
            r15.save()     // Catch:{ all -> 0x0205 }
            int r7 = r7 + 1
        L_0x0189:
            int r10 = r10 + 1
            goto L_0x016d
        L_0x018c:
            int r6 = r6 + 1
            goto L_0x012b
        L_0x018f:
            float r7 = r7 - r3
            int r6 = (int) r7     // Catch:{ all -> 0x0205 }
            r14.emptyStar = r6     // Catch:{ all -> 0x0205 }
            r6 = r9
            r7 = r6
        L_0x0195:
            if (r6 >= r2) goto L_0x0200
            r10 = r9
        L_0x0198:
            float r11 = (float) r10     // Catch:{ all -> 0x0205 }
            int r11 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r11 >= 0) goto L_0x01b8
            if (r7 >= r8) goto L_0x01b5
            int[] r11 = r14.fullStarArray     // Catch:{ all -> 0x0205 }
            r11 = r11[r10]     // Catch:{ all -> 0x0205 }
            android.graphics.Bitmap r11 = com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation.decodeResource(r5, r11)     // Catch:{ all -> 0x0205 }
            int r12 = r0 * r7
            int r12 = r12 + r1
            float r12 = (float) r12     // Catch:{ all -> 0x0205 }
            android.graphics.Paint r13 = r14.mTitlePaint     // Catch:{ all -> 0x0205 }
            r15.drawBitmap(r11, r12, r4, r13)     // Catch:{ all -> 0x0205 }
            r15.save()     // Catch:{ all -> 0x0205 }
            int r7 = r7 + 1
        L_0x01b5:
            int r10 = r10 + 1
            goto L_0x0198
        L_0x01b8:
            r10 = r9
        L_0x01b9:
            int r11 = r14.emptyStar     // Catch:{ all -> 0x0205 }
            if (r10 >= r11) goto L_0x01d8
            if (r7 >= r8) goto L_0x01d5
            int[] r11 = r14.emptyStarArray     // Catch:{ all -> 0x0205 }
            r11 = r11[r10]     // Catch:{ all -> 0x0205 }
            android.graphics.Bitmap r11 = com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation.decodeResource(r5, r11)     // Catch:{ all -> 0x0205 }
            int r12 = r0 * r7
            int r12 = r12 + r1
            float r12 = (float) r12     // Catch:{ all -> 0x0205 }
            android.graphics.Paint r13 = r14.mTitlePaint     // Catch:{ all -> 0x0205 }
            r15.drawBitmap(r11, r12, r4, r13)     // Catch:{ all -> 0x0205 }
            r15.save()     // Catch:{ all -> 0x0205 }
            int r7 = r7 + 1
        L_0x01d5:
            int r10 = r10 + 1
            goto L_0x01b9
        L_0x01d8:
            int r6 = r6 + 1
            goto L_0x0195
        L_0x01db:
            if (r8 != 0) goto L_0x0200
        L_0x01dd:
            if (r9 >= r2) goto L_0x0200
            int[] r3 = r14.fullStarArray     // Catch:{ all -> 0x0205 }
            r3 = r3[r9]     // Catch:{ all -> 0x0205 }
            android.graphics.Bitmap r3 = com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation.decodeResource(r5, r3)     // Catch:{ all -> 0x0205 }
            int r6 = r0 * r9
            int r6 = r6 + r1
            float r6 = (float) r6     // Catch:{ all -> 0x0205 }
            android.graphics.Paint r7 = r14.mTitlePaint     // Catch:{ all -> 0x0205 }
            r15.drawBitmap(r3, r6, r4, r7)     // Catch:{ all -> 0x0205 }
            r15.save()     // Catch:{ all -> 0x0205 }
            int r9 = r9 + 1
            goto L_0x01dd
        L_0x01f6:
            java.lang.String r3 = r14.mSubTitle     // Catch:{ all -> 0x0205 }
            float r2 = (float) r2     // Catch:{ all -> 0x0205 }
            int r1 = r1 + r0
            float r0 = (float) r1     // Catch:{ all -> 0x0205 }
            android.graphics.Paint r1 = r14.mSubtitlePaint     // Catch:{ all -> 0x0205 }
            r15.drawText(r3, r2, r0, r1)     // Catch:{ all -> 0x0205 }
        L_0x0200:
            super.onDraw(r15)     // Catch:{ all -> 0x0205 }
            monitor-exit(r14)
            return
        L_0x0205:
            r15 = move-exception
            monitor-exit(r14)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.designhelpers.CircularProgressBar.onDraw(android.graphics.Canvas):void");
    }

    public synchronized void onMeasure(int i11, int i12) {
        int min = Math.min(View.getDefaultSize(getSuggestedMinimumWidth(), i11), View.getDefaultSize(getSuggestedMinimumHeight(), i12));
        int i13 = min + 40;
        setMeasuredDimension(i13, i13);
        float f11 = (float) (min + 20);
        this.mCircleBounds.set(20.0f, 20.0f, f11, f11);
    }

    public synchronized void setProgress(int i11) {
        super.setProgress(i11);
        invalidate();
    }

    public synchronized void setRating(boolean z11) {
        this.setRating = z11;
        invalidate();
    }

    public synchronized void setSubTitle(String str) {
        this.mSubTitle = str;
        invalidate();
    }

    public synchronized void setTitle(String str) {
        this.mTitle = str;
        invalidate();
    }

    public synchronized void setTitleColor(int i11) {
        this.mTitlePaint.setColor(i11);
        invalidate();
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0);
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(attributeSet, i11);
    }
}
