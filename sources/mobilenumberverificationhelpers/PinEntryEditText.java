package mobilenumberverificationhelpers;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import com.talabat.R;

public class PinEntryEditText extends EditText {
    public static final String XML_NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";

    /* renamed from: b  reason: collision with root package name */
    public int[][] f26885b = {new int[]{16842913}, new int[]{16842908}, new int[]{-16842908}};

    /* renamed from: c  reason: collision with root package name */
    public int[] f26886c = {-16711936, ViewCompat.MEASURED_STATE_MASK, -7829368};

    /* renamed from: d  reason: collision with root package name */
    public ColorStateList f26887d = new ColorStateList(this.f26885b, this.f26886c);
    private float mCharSize;
    /* access modifiers changed from: private */
    public View.OnClickListener mClickListener;
    private float mLineSpacing = 8.0f;
    private float mLineStroke = 1.0f;
    private float mLineStrokeSelected = 2.0f;
    private Paint mLinesPaint;
    private int mMaxLength = 4;
    private float mNumChars = 4.0f;
    private float mSpace = 8.0f;

    public PinEntryEditText(Context context) {
        super(context);
    }

    private int getColorForState(int... iArr) {
        return this.f26887d.getColorForState(iArr, getResources().getColor(R.color.talabat_green));
    }

    private void init(Context context, AttributeSet attributeSet) {
        float f11 = context.getResources().getDisplayMetrics().density;
        this.mLineStroke *= f11;
        this.mLineStrokeSelected *= f11;
        Paint paint = new Paint(getPaint());
        this.mLinesPaint = paint;
        paint.setStrokeWidth(this.mLineStroke);
        if (!isInEditMode()) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorControlActivated, typedValue, true);
            this.f26886c[0] = typedValue.data;
            context.getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue, true);
            this.f26886c[1] = typedValue.data;
            context.getTheme().resolveAttribute(R.attr.colorControlHighlight, typedValue, true);
            this.f26886c[2] = typedValue.data;
        }
        setBackgroundResource(0);
        this.mSpace *= f11;
        this.mLineSpacing = f11 * this.mLineSpacing;
        int attributeIntValue = attributeSet.getAttributeIntValue(XML_NAMESPACE_ANDROID, "maxLength", 4);
        this.mMaxLength = attributeIntValue;
        this.mNumChars = (float) attributeIntValue;
        super.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            public void onDestroyActionMode(ActionMode actionMode) {
            }

            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        super.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PinEntryEditText pinEntryEditText = PinEntryEditText.this;
                pinEntryEditText.setSelection(pinEntryEditText.getText().length());
                if (PinEntryEditText.this.mClickListener != null) {
                    PinEntryEditText.this.mClickListener.onClick(view);
                }
            }
        });
    }

    private void updateColorForLines(boolean z11) {
        if (isFocused()) {
            this.mLinesPaint.setStrokeWidth(this.mLineStrokeSelected);
            this.mLinesPaint.setColor(getResources().getColor(R.color.colorSecondary));
            if (z11) {
                this.mLinesPaint.setColor(getResources().getColor(R.color.colorSecondary));
                return;
            }
            return;
        }
        this.mLinesPaint.setStrokeWidth(this.mLineStroke);
        this.mLinesPaint.setColor(getResources().getColor(R.color.colorSecondary));
    }

    public void onDraw(Canvas canvas) {
        boolean z11;
        int i11;
        float f11;
        int width = (getWidth() - getPaddingRight()) - getPaddingLeft();
        float f12 = this.mSpace;
        if (f12 < 0.0f) {
            this.mCharSize = ((float) width) / ((this.mNumChars * 2.0f) - 1.0f);
        } else {
            float f13 = this.mNumChars;
            this.mCharSize = (((float) width) - (f12 * (f13 - 1.0f))) / f13;
        }
        int paddingLeft = getPaddingLeft();
        int height = getHeight() - getPaddingBottom();
        Editable text = getText();
        int length = text.length();
        float[] fArr = new float[length];
        getPaint().getTextWidths(getText(), 0, length, fArr);
        int i12 = 0;
        while (((float) i12) < this.mNumChars) {
            if (i12 == length) {
                z11 = true;
            } else {
                z11 = false;
            }
            updateColorForLines(z11);
            float f14 = (float) paddingLeft;
            float f15 = (float) height;
            canvas.drawLine(f14, f15, f14 + this.mCharSize, f15, this.mLinesPaint);
            if (getText().length() > i12) {
                i11 = i12;
                canvas.drawText(text, i12, i12 + 1, ((this.mCharSize / 2.0f) + f14) - (fArr[0] / 2.0f), f15 - this.mLineSpacing, getPaint());
            } else {
                i11 = i12;
            }
            float f16 = this.mSpace;
            if (f16 < 0.0f) {
                f11 = f14 + (this.mCharSize * 2.0f);
            } else {
                f11 = f14 + this.mCharSize + f16;
            }
            paddingLeft = (int) f11;
            i12 = i11 + 1;
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        throw new RuntimeException("setCustomSelectionActionModeCallback() not supported.");
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public PinEntryEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public PinEntryEditText(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }

    @TargetApi(21)
    public PinEntryEditText(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        init(context, attributeSet);
    }
}
