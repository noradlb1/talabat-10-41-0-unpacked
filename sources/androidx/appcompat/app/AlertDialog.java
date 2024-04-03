package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.ArrayRes;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController;

public class AlertDialog extends AppCompatDialog implements DialogInterface {

    /* renamed from: b  reason: collision with root package name */
    public final AlertController f539b = new AlertController(getContext(), this, getWindow());

    public static class Builder {
        private final AlertController.AlertParams P;
        private final int mTheme;

        public Builder(@NonNull Context context) {
            this(context, AlertDialog.b(context, 0));
        }

        @NonNull
        public AlertDialog create() {
            AlertDialog alertDialog = new AlertDialog(this.P.mContext, this.mTheme);
            this.P.apply(alertDialog.f539b);
            alertDialog.setCancelable(this.P.mCancelable);
            if (this.P.mCancelable) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.P.mOnCancelListener);
            alertDialog.setOnDismissListener(this.P.mOnDismissListener);
            DialogInterface.OnKeyListener onKeyListener = this.P.mOnKeyListener;
            if (onKeyListener != null) {
                alertDialog.setOnKeyListener(onKeyListener);
            }
            return alertDialog;
        }

        @NonNull
        public Context getContext() {
            return this.P.mContext;
        }

        public Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mAdapter = listAdapter;
            alertParams.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCancelable(boolean z11) {
            this.P.mCancelable = z11;
            return this;
        }

        public Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mCursor = cursor;
            alertParams.mLabelColumn = str;
            alertParams.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCustomTitle(@Nullable View view) {
            this.P.mCustomTitleView = view;
            return this;
        }

        public Builder setIcon(@DrawableRes int i11) {
            this.P.mIconId = i11;
            return this;
        }

        public Builder setIconAttribute(@AttrRes int i11) {
            TypedValue typedValue = new TypedValue();
            this.P.mContext.getTheme().resolveAttribute(i11, typedValue, true);
            this.P.mIconId = typedValue.resourceId;
            return this;
        }

        @Deprecated
        public Builder setInverseBackgroundForced(boolean z11) {
            this.P.mForceInverseBackground = z11;
            return this;
        }

        public Builder setItems(@ArrayRes int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i11);
            this.P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setMessage(@StringRes int i11) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mMessage = alertParams.mContext.getText(i11);
            return this;
        }

        public Builder setMultiChoiceItems(@ArrayRes int i11, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i11);
            AlertController.AlertParams alertParams2 = this.P;
            alertParams2.mOnCheckboxClickListener = onMultiChoiceClickListener;
            alertParams2.mCheckedItems = zArr;
            alertParams2.mIsMultiChoice = true;
            return this;
        }

        public Builder setNegativeButton(@StringRes int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mNegativeButtonText = alertParams.mContext.getText(i11);
            this.P.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButtonIcon(Drawable drawable) {
            this.P.mNegativeButtonIcon = drawable;
            return this;
        }

        public Builder setNeutralButton(@StringRes int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mNeutralButtonText = alertParams.mContext.getText(i11);
            this.P.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButtonIcon(Drawable drawable) {
            this.P.mNeutralButtonIcon = drawable;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.P.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.P.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.P.mOnItemSelectedListener = onItemSelectedListener;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.P.mOnKeyListener = onKeyListener;
            return this;
        }

        public Builder setPositiveButton(@StringRes int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mPositiveButtonText = alertParams.mContext.getText(i11);
            this.P.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButtonIcon(Drawable drawable) {
            this.P.mPositiveButtonIcon = drawable;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder setRecycleOnMeasureEnabled(boolean z11) {
            this.P.mRecycleOnMeasure = z11;
            return this;
        }

        public Builder setSingleChoiceItems(@ArrayRes int i11, int i12, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i11);
            AlertController.AlertParams alertParams2 = this.P;
            alertParams2.mOnClickListener = onClickListener;
            alertParams2.mCheckedItem = i12;
            alertParams2.mIsSingleChoice = true;
            return this;
        }

        public Builder setTitle(@StringRes int i11) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mTitle = alertParams.mContext.getText(i11);
            return this;
        }

        public Builder setView(int i11) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mView = null;
            alertParams.mViewLayoutResId = i11;
            alertParams.mViewSpacingSpecified = false;
            return this;
        }

        public AlertDialog show() {
            AlertDialog create = create();
            create.show();
            return create;
        }

        public Builder(@NonNull Context context, @StyleRes int i11) {
            this.P = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.b(context, i11)));
            this.mTheme = i11;
        }

        public Builder setIcon(@Nullable Drawable drawable) {
            this.P.mIcon = drawable;
            return this;
        }

        public Builder setMessage(@Nullable CharSequence charSequence) {
            this.P.mMessage = charSequence;
            return this;
        }

        public Builder setTitle(@Nullable CharSequence charSequence) {
            this.P.mTitle = charSequence;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mItems = charSequenceArr;
            alertParams.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mNegativeButtonText = charSequence;
            alertParams.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mNeutralButtonText = charSequence;
            alertParams.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mPositiveButtonText = charSequence;
            alertParams.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setView(View view) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mView = view;
            alertParams.mViewLayoutResId = 0;
            alertParams.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mItems = charSequenceArr;
            alertParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
            alertParams.mCheckedItems = zArr;
            alertParams.mIsMultiChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int i11, String str, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mCursor = cursor;
            alertParams.mOnClickListener = onClickListener;
            alertParams.mCheckedItem = i11;
            alertParams.mLabelColumn = str;
            alertParams.mIsSingleChoice = true;
            return this;
        }

        @Deprecated
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder setView(View view, int i11, int i12, int i13, int i14) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mView = view;
            alertParams.mViewLayoutResId = 0;
            alertParams.mViewSpacingSpecified = true;
            alertParams.mViewSpacingLeft = i11;
            alertParams.mViewSpacingTop = i12;
            alertParams.mViewSpacingRight = i13;
            alertParams.mViewSpacingBottom = i14;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mCursor = cursor;
            alertParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
            alertParams.mIsCheckedColumn = str;
            alertParams.mLabelColumn = str2;
            alertParams.mIsMultiChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mItems = charSequenceArr;
            alertParams.mOnClickListener = onClickListener;
            alertParams.mCheckedItem = i11;
            alertParams.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.mAdapter = listAdapter;
            alertParams.mOnClickListener = onClickListener;
            alertParams.mCheckedItem = i11;
            alertParams.mIsSingleChoice = true;
            return this;
        }
    }

    public AlertDialog(@NonNull Context context, @StyleRes int i11) {
        super(context, b(context, i11));
    }

    public static int b(@NonNull Context context, @StyleRes int i11) {
        if (((i11 >>> 24) & 255) >= 1) {
            return i11;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button getButton(int i11) {
        return this.f539b.getButton(i11);
    }

    public ListView getListView() {
        return this.f539b.getListView();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f539b.installContent();
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (this.f539b.onKeyDown(i11, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i11, keyEvent);
    }

    public boolean onKeyUp(int i11, KeyEvent keyEvent) {
        if (this.f539b.onKeyUp(i11, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i11, keyEvent);
    }

    public void setButton(int i11, CharSequence charSequence, Message message) {
        this.f539b.setButton(i11, charSequence, (DialogInterface.OnClickListener) null, message, (Drawable) null);
    }

    public void setCustomTitle(View view) {
        this.f539b.setCustomTitle(view);
    }

    public void setIcon(int i11) {
        this.f539b.setIcon(i11);
    }

    public void setIconAttribute(int i11) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i11, typedValue, true);
        this.f539b.setIcon(typedValue.resourceId);
    }

    public void setMessage(CharSequence charSequence) {
        this.f539b.setMessage(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f539b.setTitle(charSequence);
    }

    public void setView(View view) {
        this.f539b.setView(view);
    }

    public void setButton(int i11, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f539b.setButton(i11, charSequence, onClickListener, (Message) null, (Drawable) null);
    }

    public void setIcon(Drawable drawable) {
        this.f539b.setIcon(drawable);
    }

    public void setView(View view, int i11, int i12, int i13, int i14) {
        this.f539b.setView(view, i11, i12, i13, i14);
    }

    public void setButton(int i11, CharSequence charSequence, Drawable drawable, DialogInterface.OnClickListener onClickListener) {
        this.f539b.setButton(i11, charSequence, onClickListener, (Message) null, drawable);
    }
}
