package com.instabug.library.annotation;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.instabug.library.R;
import com.instabug.library.annotation.AnnotationView;
import com.instabug.library.annotation.ShapeSuggestionsLayout;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.library.util.AttrResolver;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.BitmapWorkerTask;
import com.instabug.library.util.DrawableUtils;
import com.instabug.library.view.IconView;
import com.instabug.library.view.ViewUtils;

public class AnnotationLayout extends LinearLayout implements View.OnClickListener {
    private static final String ANNOTATION_LAYOUT = "instabug_annotation_layout";
    private static final String DRAWING_MODE = "drawingMode";
    @Nullable
    private LinearLayout annotationActionsContainer;
    /* access modifiers changed from: private */
    @Nullable
    public AnnotationView annotationView;
    @Nullable
    private View border;
    @Nullable
    private View brushIndicator;
    @Nullable
    private ColorPickerPopUpView colorPicker;
    @Nullable
    private ImageView iconBlur;
    @Nullable
    private ImageView iconBrush;
    @Nullable
    private RelativeLayout iconBrushLayout;
    @Nullable
    private ImageView iconMagnify;
    @Nullable
    private ImageView iconUndo;
    @Nullable
    private ShapeSuggestionsLayout shapeSuggestionsLayout;
    /* access modifiers changed from: private */
    public int tintingColor;

    public class a implements ShapeSuggestionsLayout.e {
        public a() {
        }

        public void a(int i11) {
            if (i11 == 1 && AnnotationLayout.this.annotationView != null) {
                AnnotationLayout.this.annotationView.j();
            }
        }
    }

    public class b extends AccessibilityDelegateCompat {
        public b(AnnotationLayout annotationLayout) {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setRoleDescription("Button");
        }
    }

    public class c implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageView f34037b;

        public c(ImageView imageView) {
            this.f34037b = imageView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                DrawableUtils.setDrawableTintColor(this.f34037b, InstabugCore.getPrimaryColor());
                return false;
            } else if (motionEvent.getAction() != 1) {
                return false;
            } else {
                DrawableUtils.setDrawableTintColor(this.f34037b, AnnotationLayout.this.tintingColor);
                return false;
            }
        }
    }

    public class d implements BitmapWorkerTask.OnImageLoadedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f34039a;

        public d(Runnable runnable) {
            this.f34039a = runnable;
        }

        public void onImageLoaded() {
            AnnotationLayout.this.enableButtons();
            AnnotationLayout.this.setBorder();
            Runnable runnable = this.f34039a;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public AnnotationLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public void enableButtons() {
        ImageView imageView = this.iconBrush;
        if (imageView != null) {
            imageView.setEnabled(true);
        }
        ImageView imageView2 = this.iconMagnify;
        if (imageView2 != null) {
            imageView2.setEnabled(true);
        }
        ImageView imageView3 = this.iconBlur;
        if (imageView3 != null) {
            imageView3.setEnabled(true);
        }
        ImageView imageView4 = this.iconUndo;
        if (imageView4 != null) {
            imageView4.setEnabled(true);
        }
    }

    private void hideColorPicker() {
        ColorPickerPopUpView colorPickerPopUpView = this.colorPicker;
        if (colorPickerPopUpView != null && colorPickerPopUpView.getVisibility() == 0) {
            this.colorPicker.setVisibility(8);
        }
    }

    private void initViews() {
        View.inflate(getContext(), R.layout.instabug_annotation_view, this);
        this.annotationActionsContainer = (LinearLayout) findViewById(R.id.instabug_annotation_actions_container);
        ShapeSuggestionsLayout shapeSuggestionsLayout2 = (ShapeSuggestionsLayout) findViewById(R.id.shapeSuggestionsLayout);
        this.shapeSuggestionsLayout = shapeSuggestionsLayout2;
        if (shapeSuggestionsLayout2 != null) {
            shapeSuggestionsLayout2.setOnShapeSelectedListener(new a());
        }
        this.iconBrushLayout = (RelativeLayout) findViewById(R.id.icon_brush_layout);
        this.iconBrush = (ImageView) findViewById(R.id.icon_brush);
        this.iconMagnify = (ImageView) findViewById(R.id.icon_magnify);
        this.iconBlur = (ImageView) findViewById(R.id.icon_blur);
        this.iconUndo = (ImageView) findViewById(R.id.icon_undo);
        ImageView imageView = this.iconBrush;
        if (imageView != null) {
            imageView.setEnabled(false);
            if (AccessibilityUtils.isAccessibilityServiceEnabled()) {
                ViewCompat.setAccessibilityDelegate(this.iconBrush, new b(this));
            }
        }
        ImageView imageView2 = this.iconMagnify;
        if (imageView2 != null) {
            imageView2.setEnabled(false);
        }
        ImageView imageView3 = this.iconBlur;
        if (imageView3 != null) {
            imageView3.setEnabled(false);
        }
        ImageView imageView4 = this.iconUndo;
        if (imageView4 != null) {
            imageView4.setEnabled(false);
        }
        this.border = findViewById(R.id.instabug_annotation_image_border);
        this.annotationView = (AnnotationView) findViewById(R.id.instabug_annotation_image);
        this.colorPicker = (ColorPickerPopUpView) findViewById(R.id.instabug_color_picker);
        this.brushIndicator = findViewById(R.id.brush_indicator);
        AnnotationView annotationView2 = this.annotationView;
        if (annotationView2 != null) {
            annotationView2.setDrawingMode(AnnotationView.c.DRAW_PATH);
            ImageView imageView5 = this.iconBrush;
            if (imageView5 != null) {
                DrawableUtils.setDrawableTintColor(imageView5, InstabugCore.getPrimaryColor());
            }
            ColorPickerPopUpView colorPickerPopUpView = this.colorPicker;
            if (colorPickerPopUpView != null) {
                annotationView2.setDrawingColor(colorPickerPopUpView.getSelectedColor());
            }
            annotationView2.setOnActionDownListener(new rc.a(this));
            annotationView2.setOnPathRecognizedListener(new rc.b(this));
            annotationView2.m9022setOnNewMagnifierAddingAbilityChangedListener(new rc.c(this));
            ColorPickerPopUpView colorPickerPopUpView2 = this.colorPicker;
            if (colorPickerPopUpView2 != null) {
                colorPickerPopUpView2.setOnColorSelectionListener(new rc.d(this, annotationView2));
            }
        }
        ColorPickerPopUpView colorPickerPopUpView3 = this.colorPicker;
        if (colorPickerPopUpView3 != null) {
            colorPickerPopUpView3.setPopUpBackgroundColor(AttrResolver.resolveAttributeColor(getContext(), R.attr.ib_annotation_color_picker_bg_color));
        }
        RelativeLayout relativeLayout = this.iconBrushLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(this);
        }
        ImageView imageView6 = this.iconMagnify;
        if (imageView6 != null) {
            imageView6.setOnClickListener(this);
        }
        ImageView imageView7 = this.iconBlur;
        if (imageView7 != null) {
            imageView7.setOnClickListener(this);
        }
        ImageView imageView8 = this.iconUndo;
        if (imageView8 != null) {
            imageView8.setOnClickListener(this);
        }
        setViewSelector(this.iconMagnify);
        setViewSelector(this.iconUndo);
        this.tintingColor = ContextCompat.getColor(getContext(), R.color.ib_core_annotation_tinting_color);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$0() {
        ColorPickerPopUpView colorPickerPopUpView = this.colorPicker;
        if (colorPickerPopUpView != null && colorPickerPopUpView.getVisibility() == 0) {
            this.colorPicker.setVisibility(8);
        }
        ShapeSuggestionsLayout shapeSuggestionsLayout2 = this.shapeSuggestionsLayout;
        if (shapeSuggestionsLayout2 != null) {
            shapeSuggestionsLayout2.c();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$2(boolean z11) {
        ImageView imageView = this.iconMagnify;
        if (imageView != null) {
            imageView.setEnabled(z11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$3(AnnotationView annotationView2, int i11, int i12) {
        annotationView2.setDrawingColor(i11);
        ColorPickerPopUpView colorPickerPopUpView = this.colorPicker;
        if (colorPickerPopUpView != null) {
            colorPickerPopUpView.setVisibility(8);
        }
        View view = this.brushIndicator;
        if (view != null) {
            view.setBackgroundColor(i11);
        }
    }

    private void resetColorSelection() {
        LinearLayout linearLayout = this.annotationActionsContainer;
        if (linearLayout != null) {
            int childCount = linearLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                if (this.annotationActionsContainer.getChildAt(i11) instanceof IconView) {
                    ((TextView) this.annotationActionsContainer.getChildAt(i11)).setTextColor(this.tintingColor);
                }
            }
        }
        DrawableUtils.setDrawableTintColor(this.iconBrush, this.tintingColor);
        DrawableUtils.setDrawableTintColor(this.iconBlur, this.tintingColor);
    }

    /* access modifiers changed from: private */
    public void setBorder() {
        int convertDpToPx = ViewUtils.convertDpToPx(getContext(), 4.0f);
        int convertDpToPx2 = ViewUtils.convertDpToPx(getContext(), 2.0f);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RectShape());
        shapeDrawable.getPaint().setColor(InstabugCore.getPrimaryColor());
        shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
        shapeDrawable.getPaint().setStrokeWidth((float) convertDpToPx);
        View view = this.border;
        if (view != null) {
            view.setPadding(convertDpToPx2, convertDpToPx2, convertDpToPx2, convertDpToPx2);
            this.border.setBackground(shapeDrawable);
        }
    }

    private void setViewSelector(@Nullable ImageView imageView) {
        if (imageView != null) {
            imageView.setOnTouchListener(new c(imageView));
        }
    }

    /* access modifiers changed from: private */
    public void showShapeSuggestions(Path... pathArr) {
        int i11;
        ShapeSuggestionsLayout shapeSuggestionsLayout2 = this.shapeSuggestionsLayout;
        if (shapeSuggestionsLayout2 != null) {
            shapeSuggestionsLayout2.removeAllViews();
            for (int i12 = 0; i12 < pathArr.length; i12++) {
                ShapeSuggestionsLayout shapeSuggestionsLayout3 = this.shapeSuggestionsLayout;
                if (i12 == 0) {
                    i11 = R.string.ibg_bug_annotation_original_shape_content_description;
                } else {
                    i11 = R.string.ibg_bug_annotation_recognized_shape_content_description;
                }
                shapeSuggestionsLayout3.a(i11, pathArr[i12]);
            }
            this.shapeSuggestionsLayout.b();
        }
    }

    private void switchColorPickerVisibility() {
        int i11;
        ColorPickerPopUpView colorPickerPopUpView = this.colorPicker;
        if (colorPickerPopUpView != null) {
            if (colorPickerPopUpView.getVisibility() == 0) {
                i11 = 8;
            } else {
                i11 = 0;
            }
            colorPickerPopUpView.setVisibility(i11);
        }
    }

    @Nullable
    public Bitmap getAnnotatedBitmap() {
        AnnotationView annotationView2 = this.annotationView;
        if (annotationView2 != null) {
            return annotationView2.f();
        }
        return null;
    }

    public void onClick(View view) {
        ShapeSuggestionsLayout shapeSuggestionsLayout2 = this.shapeSuggestionsLayout;
        if (shapeSuggestionsLayout2 != null) {
            shapeSuggestionsLayout2.c();
        }
        int id2 = view.getId();
        if (id2 == R.id.icon_brush_layout) {
            switchColorPickerVisibility();
            AnnotationView annotationView2 = this.annotationView;
            if (annotationView2 != null) {
                annotationView2.setDrawingMode(AnnotationView.c.DRAW_PATH);
            }
            resetColorSelection();
            DrawableUtils.setDrawableTintColor(this.iconBrush, InstabugCore.getPrimaryColor());
        } else if (id2 == R.id.icon_magnify) {
            AnnotationView annotationView3 = this.annotationView;
            if (annotationView3 != null) {
                annotationView3.b();
            }
            hideColorPicker();
        } else if (id2 == R.id.icon_blur) {
            AnnotationView annotationView4 = this.annotationView;
            if (annotationView4 != null) {
                annotationView4.setDrawingMode(AnnotationView.c.DRAW_BLUR);
            }
            resetColorSelection();
            DrawableUtils.setDrawableTintColor(this.iconBlur, InstabugCore.getPrimaryColor());
            hideColorPicker();
        } else if (id2 == R.id.icon_undo) {
            AnnotationView annotationView5 = this.annotationView;
            if (annotationView5 != null) {
                annotationView5.h();
            }
            hideColorPicker();
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        ColorPickerPopUpView colorPickerPopUpView;
        AnnotationView annotationView2 = this.annotationView;
        if (annotationView2 != null && (colorPickerPopUpView = this.colorPicker) != null) {
            annotationView2.setDrawingColor(colorPickerPopUpView.getSelectedColor());
            if (parcelable instanceof Bundle) {
                Bundle bundle = (Bundle) parcelable;
                AnnotationView.c cVar = (AnnotationView.c) bundle.getSerializable(DRAWING_MODE);
                resetColorSelection();
                if (cVar == AnnotationView.c.DRAW_BLUR) {
                    DrawableUtils.setDrawableTintColor(this.iconBlur, InstabugCore.getPrimaryColor());
                } else {
                    DrawableUtils.setDrawableTintColor(this.iconBrush, InstabugCore.getPrimaryColor());
                }
                parcelable = bundle.getParcelable(ANNOTATION_LAYOUT);
            }
            if (parcelable != null) {
                super.onRestoreInstanceState(parcelable);
            }
        }
    }

    @Nullable
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(ANNOTATION_LAYOUT, super.onSaveInstanceState());
        AnnotationView annotationView2 = this.annotationView;
        if (annotationView2 != null) {
            bundle.putSerializable(DRAWING_MODE, annotationView2.getDrawingMode());
        }
        return bundle;
    }

    public void setBaseImage(@NonNull Uri uri, @Nullable Runnable runnable) {
        if (uri.getPath() != null && this.annotationView != null) {
            BitmapUtils.loadBitmap(uri.getPath(), this.annotationView, new d(runnable));
        }
    }

    public void setBitmap(Bitmap bitmap) {
        AnnotationView annotationView2 = this.annotationView;
        if (annotationView2 != null) {
            annotationView2.setImageBitmap(bitmap);
        }
        enableButtons();
        setBorder();
    }

    public AnnotationLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public AnnotationLayout(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initViews();
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @TargetApi(21)
    public AnnotationLayout(Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        initViews();
    }
}
