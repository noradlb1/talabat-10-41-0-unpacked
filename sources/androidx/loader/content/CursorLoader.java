package androidx.loader.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContentResolverCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.OperationCanceledException;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class CursorLoader extends AsyncTaskLoader<Cursor> {

    /* renamed from: a  reason: collision with root package name */
    public final Loader<Cursor>.ForceLoadContentObserver f36150a = new Loader.ForceLoadContentObserver();

    /* renamed from: b  reason: collision with root package name */
    public Uri f36151b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f36152c;

    /* renamed from: d  reason: collision with root package name */
    public String f36153d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f36154e;

    /* renamed from: f  reason: collision with root package name */
    public String f36155f;

    /* renamed from: g  reason: collision with root package name */
    public Cursor f36156g;

    /* renamed from: h  reason: collision with root package name */
    public CancellationSignal f36157h;

    public CursorLoader(@NonNull Context context) {
        super(context);
    }

    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        synchronized (this) {
            CancellationSignal cancellationSignal = this.f36157h;
            if (cancellationSignal != null) {
                cancellationSignal.cancel();
            }
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f36151b);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.f36152c));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.f36153d);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.f36154e));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.f36155f);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.f36156g);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.mContentChanged);
    }

    @Nullable
    public String[] getProjection() {
        return this.f36152c;
    }

    @Nullable
    public String getSelection() {
        return this.f36153d;
    }

    @Nullable
    public String[] getSelectionArgs() {
        return this.f36154e;
    }

    @Nullable
    public String getSortOrder() {
        return this.f36155f;
    }

    @NonNull
    public Uri getUri() {
        return this.f36151b;
    }

    public void onReset() {
        super.onReset();
        onStopLoading();
        Cursor cursor = this.f36156g;
        if (cursor != null && !cursor.isClosed()) {
            this.f36156g.close();
        }
        this.f36156g = null;
    }

    public void onStartLoading() {
        Cursor cursor = this.f36156g;
        if (cursor != null) {
            deliverResult(cursor);
        }
        if (takeContentChanged() || this.f36156g == null) {
            forceLoad();
        }
    }

    public void onStopLoading() {
        cancelLoad();
    }

    public void setProjection(@Nullable String[] strArr) {
        this.f36152c = strArr;
    }

    public void setSelection(@Nullable String str) {
        this.f36153d = str;
    }

    public void setSelectionArgs(@Nullable String[] strArr) {
        this.f36154e = strArr;
    }

    public void setSortOrder(@Nullable String str) {
        this.f36155f = str;
    }

    public void setUri(@NonNull Uri uri) {
        this.f36151b = uri;
    }

    public void deliverResult(Cursor cursor) {
        if (!isReset()) {
            Cursor cursor2 = this.f36156g;
            this.f36156g = cursor;
            if (isStarted()) {
                super.deliverResult(cursor);
            }
            if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
                cursor2.close();
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    public Cursor loadInBackground() {
        Cursor query;
        synchronized (this) {
            if (!isLoadInBackgroundCanceled()) {
                this.f36157h = new CancellationSignal();
            } else {
                throw new OperationCanceledException();
            }
        }
        try {
            query = ContentResolverCompat.query(getContext().getContentResolver(), this.f36151b, this.f36152c, this.f36153d, this.f36154e, this.f36155f, this.f36157h);
            if (query != null) {
                query.getCount();
                query.registerContentObserver(this.f36150a);
            }
            synchronized (this) {
                this.f36157h = null;
            }
            return query;
        } catch (RuntimeException e11) {
            query.close();
            throw e11;
        } catch (Throwable th2) {
            synchronized (this) {
                this.f36157h = null;
                throw th2;
            }
        }
    }

    public void onCanceled(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    public CursorLoader(@NonNull Context context, @NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        super(context);
        this.f36151b = uri;
        this.f36152c = strArr;
        this.f36153d = str;
        this.f36154e = strArr2;
        this.f36155f = str2;
    }
}
