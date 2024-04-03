package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RestrictTo;

public class SimpleCursorAdapter extends ResourceCursorAdapter {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})

    /* renamed from: k  reason: collision with root package name */
    public int[] f11561k;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})

    /* renamed from: l  reason: collision with root package name */
    public int[] f11562l;

    /* renamed from: m  reason: collision with root package name */
    public String[] f11563m;
    private CursorToStringConverter mCursorToStringConverter;
    private int mStringConversionColumn = -1;
    private ViewBinder mViewBinder;

    public interface CursorToStringConverter {
        CharSequence convertToString(Cursor cursor);
    }

    public interface ViewBinder {
        boolean setViewValue(View view, Cursor cursor, int i11);
    }

    @Deprecated
    public SimpleCursorAdapter(Context context, int i11, Cursor cursor, String[] strArr, int[] iArr) {
        super(context, i11, cursor);
        this.f11562l = iArr;
        this.f11563m = strArr;
        findColumns(cursor, strArr);
    }

    private void findColumns(Cursor cursor, String[] strArr) {
        if (cursor != null) {
            int length = strArr.length;
            int[] iArr = this.f11561k;
            if (iArr == null || iArr.length != length) {
                this.f11561k = new int[length];
            }
            for (int i11 = 0; i11 < length; i11++) {
                this.f11561k[i11] = cursor.getColumnIndexOrThrow(strArr[i11]);
            }
            return;
        }
        this.f11561k = null;
    }

    public void bindView(View view, Context context, Cursor cursor) {
        boolean z11;
        ViewBinder viewBinder = this.mViewBinder;
        int[] iArr = this.f11562l;
        int length = iArr.length;
        int[] iArr2 = this.f11561k;
        for (int i11 = 0; i11 < length; i11++) {
            View findViewById = view.findViewById(iArr[i11]);
            if (findViewById != null) {
                if (viewBinder != null) {
                    z11 = viewBinder.setViewValue(findViewById, cursor, iArr2[i11]);
                } else {
                    z11 = false;
                }
                if (z11) {
                    continue;
                } else {
                    String string = cursor.getString(iArr2[i11]);
                    if (string == null) {
                        string = "";
                    }
                    if (findViewById instanceof TextView) {
                        setViewText((TextView) findViewById, string);
                    } else if (findViewById instanceof ImageView) {
                        setViewImage((ImageView) findViewById, string);
                    } else {
                        throw new IllegalStateException(findViewById.getClass().getName() + " is not a " + " view that can be bounds by this SimpleCursorAdapter");
                    }
                }
            }
        }
    }

    public void changeCursorAndColumns(Cursor cursor, String[] strArr, int[] iArr) {
        this.f11563m = strArr;
        this.f11562l = iArr;
        findColumns(cursor, strArr);
        super.changeCursor(cursor);
    }

    public CharSequence convertToString(Cursor cursor) {
        CursorToStringConverter cursorToStringConverter = this.mCursorToStringConverter;
        if (cursorToStringConverter != null) {
            return cursorToStringConverter.convertToString(cursor);
        }
        int i11 = this.mStringConversionColumn;
        if (i11 > -1) {
            return cursor.getString(i11);
        }
        return super.convertToString(cursor);
    }

    public CursorToStringConverter getCursorToStringConverter() {
        return this.mCursorToStringConverter;
    }

    public int getStringConversionColumn() {
        return this.mStringConversionColumn;
    }

    public ViewBinder getViewBinder() {
        return this.mViewBinder;
    }

    public void setCursorToStringConverter(CursorToStringConverter cursorToStringConverter) {
        this.mCursorToStringConverter = cursorToStringConverter;
    }

    public void setStringConversionColumn(int i11) {
        this.mStringConversionColumn = i11;
    }

    public void setViewBinder(ViewBinder viewBinder) {
        this.mViewBinder = viewBinder;
    }

    public void setViewImage(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    public void setViewText(TextView textView, String str) {
        textView.setText(str);
    }

    public Cursor swapCursor(Cursor cursor) {
        findColumns(cursor, this.f11563m);
        return super.swapCursor(cursor);
    }

    public SimpleCursorAdapter(Context context, int i11, Cursor cursor, String[] strArr, int[] iArr, int i12) {
        super(context, i11, cursor, i12);
        this.f11562l = iArr;
        this.f11563m = strArr;
        findColumns(cursor, strArr);
    }
}
