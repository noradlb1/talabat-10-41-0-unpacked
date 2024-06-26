package org.greenrobot.greendao.internal;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

public final class FastCursor implements Cursor {
    private final int count;
    private int position;
    private final CursorWindow window;

    public FastCursor(CursorWindow cursorWindow) {
        this.window = cursorWindow;
        this.count = cursorWindow.getNumRows();
    }

    public void close() {
        throw new UnsupportedOperationException();
    }

    public void copyStringToBuffer(int i11, CharArrayBuffer charArrayBuffer) {
        throw new UnsupportedOperationException();
    }

    public void deactivate() {
        throw new UnsupportedOperationException();
    }

    public byte[] getBlob(int i11) {
        return this.window.getBlob(this.position, i11);
    }

    public int getColumnCount() {
        throw new UnsupportedOperationException();
    }

    public int getColumnIndex(String str) {
        throw new UnsupportedOperationException();
    }

    public int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    public String getColumnName(int i11) {
        throw new UnsupportedOperationException();
    }

    public String[] getColumnNames() {
        throw new UnsupportedOperationException();
    }

    public int getCount() {
        return this.window.getNumRows();
    }

    public double getDouble(int i11) {
        return this.window.getDouble(this.position, i11);
    }

    public Bundle getExtras() {
        throw new UnsupportedOperationException();
    }

    public float getFloat(int i11) {
        return this.window.getFloat(this.position, i11);
    }

    public int getInt(int i11) {
        return this.window.getInt(this.position, i11);
    }

    public long getLong(int i11) {
        return this.window.getLong(this.position, i11);
    }

    public Uri getNotificationUri() {
        return null;
    }

    public int getPosition() {
        return this.position;
    }

    public short getShort(int i11) {
        return this.window.getShort(this.position, i11);
    }

    public String getString(int i11) {
        return this.window.getString(this.position, i11);
    }

    public int getType(int i11) {
        throw new UnsupportedOperationException();
    }

    public boolean getWantsAllOnMoveCalls() {
        throw new UnsupportedOperationException();
    }

    public boolean isAfterLast() {
        throw new UnsupportedOperationException();
    }

    public boolean isBeforeFirst() {
        throw new UnsupportedOperationException();
    }

    public boolean isClosed() {
        throw new UnsupportedOperationException();
    }

    public boolean isFirst() {
        return this.position == 0;
    }

    public boolean isLast() {
        return this.position == this.count - 1;
    }

    public boolean isNull(int i11) {
        return this.window.isNull(this.position, i11);
    }

    public boolean move(int i11) {
        return moveToPosition(this.position + i11);
    }

    public boolean moveToFirst() {
        this.position = 0;
        if (this.count > 0) {
            return true;
        }
        return false;
    }

    public boolean moveToLast() {
        int i11 = this.count;
        if (i11 <= 0) {
            return false;
        }
        this.position = i11 - 1;
        return true;
    }

    public boolean moveToNext() {
        int i11 = this.position;
        if (i11 >= this.count - 1) {
            return false;
        }
        this.position = i11 + 1;
        return true;
    }

    public boolean moveToPosition(int i11) {
        if (i11 < 0 || i11 >= this.count) {
            return false;
        }
        this.position = i11;
        return true;
    }

    public boolean moveToPrevious() {
        int i11 = this.position;
        if (i11 <= 0) {
            return false;
        }
        this.position = i11 - 1;
        return true;
    }

    public void registerContentObserver(ContentObserver contentObserver) {
        throw new UnsupportedOperationException();
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        throw new UnsupportedOperationException();
    }

    public boolean requery() {
        throw new UnsupportedOperationException();
    }

    public Bundle respond(Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        throw new UnsupportedOperationException();
    }

    public void unregisterContentObserver(ContentObserver contentObserver) {
        throw new UnsupportedOperationException();
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        throw new UnsupportedOperationException();
    }
}
