package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.annotation.RestrictTo;
import androidx.cursoradapter.widget.CursorFilter;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;

public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.CursorFilterClient {
    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})

    /* renamed from: b  reason: collision with root package name */
    public boolean f11549b;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})

    /* renamed from: c  reason: collision with root package name */
    public boolean f11550c;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})

    /* renamed from: d  reason: collision with root package name */
    public Cursor f11551d;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})

    /* renamed from: e  reason: collision with root package name */
    public Context f11552e;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})

    /* renamed from: f  reason: collision with root package name */
    public int f11553f;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})

    /* renamed from: g  reason: collision with root package name */
    public ChangeObserver f11554g;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})

    /* renamed from: h  reason: collision with root package name */
    public DataSetObserver f11555h;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})

    /* renamed from: i  reason: collision with root package name */
    public CursorFilter f11556i;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})

    /* renamed from: j  reason: collision with root package name */
    public FilterQueryProvider f11557j;

    public class ChangeObserver extends ContentObserver {
        public ChangeObserver() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z11) {
            CursorAdapter.this.b();
        }
    }

    public class MyDataSetObserver extends DataSetObserver {
        public MyDataSetObserver() {
        }

        public void onChanged() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.f11549b = true;
            cursorAdapter.notifyDataSetChanged();
        }

        public void onInvalidated() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.f11549b = false;
            cursorAdapter.notifyDataSetInvalidated();
        }
    }

    @Deprecated
    public CursorAdapter(Context context, Cursor cursor) {
        a(context, cursor, 1);
    }

    public void a(Context context, Cursor cursor, int i11) {
        int i12;
        boolean z11 = false;
        if ((i11 & 1) == 1) {
            i11 |= 2;
            this.f11550c = true;
        } else {
            this.f11550c = false;
        }
        if (cursor != null) {
            z11 = true;
        }
        this.f11551d = cursor;
        this.f11549b = z11;
        this.f11552e = context;
        if (z11) {
            i12 = cursor.getColumnIndexOrThrow(InstabugDbContract.FeatureRequestEntry.COLUMN_ID);
        } else {
            i12 = -1;
        }
        this.f11553f = i12;
        if ((i11 & 2) == 2) {
            this.f11554g = new ChangeObserver();
            this.f11555h = new MyDataSetObserver();
        } else {
            this.f11554g = null;
            this.f11555h = null;
        }
        if (z11) {
            ChangeObserver changeObserver = this.f11554g;
            if (changeObserver != null) {
                cursor.registerContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.f11555h;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public void b() {
        Cursor cursor;
        if (this.f11550c && (cursor = this.f11551d) != null && !cursor.isClosed()) {
            this.f11549b = this.f11551d.requery();
        }
    }

    public abstract void bindView(View view, Context context, Cursor cursor);

    public void changeCursor(Cursor cursor) {
        Cursor swapCursor = swapCursor(cursor);
        if (swapCursor != null) {
            swapCursor.close();
        }
    }

    public CharSequence convertToString(Cursor cursor) {
        if (cursor == null) {
            return "";
        }
        return cursor.toString();
    }

    public int getCount() {
        Cursor cursor;
        if (!this.f11549b || (cursor = this.f11551d) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public Cursor getCursor() {
        return this.f11551d;
    }

    public View getDropDownView(int i11, View view, ViewGroup viewGroup) {
        if (!this.f11549b) {
            return null;
        }
        this.f11551d.moveToPosition(i11);
        if (view == null) {
            view = newDropDownView(this.f11552e, this.f11551d, viewGroup);
        }
        bindView(view, this.f11552e, this.f11551d);
        return view;
    }

    public Filter getFilter() {
        if (this.f11556i == null) {
            this.f11556i = new CursorFilter(this);
        }
        return this.f11556i;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        return this.f11557j;
    }

    public Object getItem(int i11) {
        Cursor cursor;
        if (!this.f11549b || (cursor = this.f11551d) == null) {
            return null;
        }
        cursor.moveToPosition(i11);
        return this.f11551d;
    }

    public long getItemId(int i11) {
        Cursor cursor;
        if (!this.f11549b || (cursor = this.f11551d) == null || !cursor.moveToPosition(i11)) {
            return 0;
        }
        return this.f11551d.getLong(this.f11553f);
    }

    public View getView(int i11, View view, ViewGroup viewGroup) {
        if (!this.f11549b) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f11551d.moveToPosition(i11)) {
            if (view == null) {
                view = newView(this.f11552e, this.f11551d, viewGroup);
            }
            bindView(view, this.f11552e, this.f11551d);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i11);
        }
    }

    public boolean hasStableIds() {
        return true;
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return newView(context, cursor, viewGroup);
    }

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.f11557j;
        if (filterQueryProvider != null) {
            return filterQueryProvider.runQuery(charSequence);
        }
        return this.f11551d;
    }

    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        this.f11557j = filterQueryProvider;
    }

    public Cursor swapCursor(Cursor cursor) {
        Cursor cursor2 = this.f11551d;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            ChangeObserver changeObserver = this.f11554g;
            if (changeObserver != null) {
                cursor2.unregisterContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.f11555h;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f11551d = cursor;
        if (cursor != null) {
            ChangeObserver changeObserver2 = this.f11554g;
            if (changeObserver2 != null) {
                cursor.registerContentObserver(changeObserver2);
            }
            DataSetObserver dataSetObserver2 = this.f11555h;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f11553f = cursor.getColumnIndexOrThrow(InstabugDbContract.FeatureRequestEntry.COLUMN_ID);
            this.f11549b = true;
            notifyDataSetChanged();
        } else {
            this.f11553f = -1;
            this.f11549b = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    public CursorAdapter(Context context, Cursor cursor, boolean z11) {
        a(context, cursor, z11 ? 1 : 2);
    }

    public CursorAdapter(Context context, Cursor cursor, int i11) {
        a(context, cursor, i11);
    }
}
