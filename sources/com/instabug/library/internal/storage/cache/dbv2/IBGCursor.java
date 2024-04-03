package com.instabug.library.internal.storage.cache.dbv2;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import com.instabug.library.encryption.EncryptionManager;

public class IBGCursor implements Cursor {
    private final Cursor cursor;

    public IBGCursor(Cursor cursor2) {
        this.cursor = cursor2;
    }

    public void close() {
        this.cursor.close();
    }

    public void copyStringToBuffer(int i11, CharArrayBuffer charArrayBuffer) {
        this.cursor.copyStringToBuffer(i11, charArrayBuffer);
    }

    public void deactivate() {
        this.cursor.deactivate();
    }

    public byte[] getBlob(int i11) {
        return this.cursor.getBlob(i11);
    }

    public int getColumnCount() {
        return this.cursor.getColumnCount();
    }

    public int getColumnIndex(String str) {
        return this.cursor.getColumnIndex(str);
    }

    public int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
        return this.cursor.getColumnIndexOrThrow(str);
    }

    public String getColumnName(int i11) {
        return this.cursor.getColumnName(i11);
    }

    public String[] getColumnNames() {
        return this.cursor.getColumnNames();
    }

    public int getCount() {
        return this.cursor.getCount();
    }

    public double getDouble(int i11) {
        String decrypt = EncryptionManager.decrypt(this.cursor.getString(i11), 2);
        if (decrypt == null) {
            return 0.0d;
        }
        try {
            return Double.parseDouble(decrypt);
        } catch (NumberFormatException unused) {
            return 0.0d;
        }
    }

    public Bundle getExtras() {
        return this.cursor.getExtras();
    }

    public float getFloat(int i11) {
        String decrypt = EncryptionManager.decrypt(this.cursor.getString(i11), 2);
        if (decrypt == null) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(decrypt);
        } catch (NumberFormatException unused) {
            return 0.0f;
        }
    }

    public int getInt(int i11) {
        String decrypt = EncryptionManager.decrypt(this.cursor.getString(i11), 2);
        if (decrypt == null) {
            return 0;
        }
        try {
            return Integer.parseInt(decrypt);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public long getLong(int i11) {
        String decrypt = EncryptionManager.decrypt(this.cursor.getString(i11), 2);
        if (decrypt == null) {
            return 0;
        }
        try {
            return Long.parseLong(decrypt);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    @RequiresApi(api = 19)
    public Uri getNotificationUri() {
        return this.cursor.getNotificationUri();
    }

    public int getPosition() {
        return this.cursor.getPosition();
    }

    public short getShort(int i11) {
        String decrypt = EncryptionManager.decrypt(this.cursor.getString(i11), 2);
        if (decrypt == null) {
            return 0;
        }
        try {
            return Short.parseShort(decrypt);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public String getString(int i11) {
        return EncryptionManager.decrypt(this.cursor.getString(i11), 2);
    }

    public int getType(int i11) {
        return this.cursor.getType(i11);
    }

    public boolean getWantsAllOnMoveCalls() {
        return this.cursor.getWantsAllOnMoveCalls();
    }

    public boolean isAfterLast() {
        return this.cursor.isAfterLast();
    }

    public boolean isBeforeFirst() {
        return this.cursor.isBeforeFirst();
    }

    public boolean isClosed() {
        return this.cursor.isClosed();
    }

    public boolean isFirst() {
        return this.cursor.isFirst();
    }

    public boolean isLast() {
        return this.cursor.isLast();
    }

    public boolean isNull(int i11) {
        return this.cursor.isNull(i11);
    }

    public boolean move(int i11) {
        return this.cursor.move(i11);
    }

    public boolean moveToFirst() {
        return this.cursor.moveToFirst();
    }

    public boolean moveToLast() {
        return this.cursor.moveToLast();
    }

    public boolean moveToNext() {
        return this.cursor.moveToNext();
    }

    public boolean moveToPosition(int i11) {
        return this.cursor.moveToPosition(i11);
    }

    public boolean moveToPrevious() {
        return this.cursor.moveToPrevious();
    }

    public void registerContentObserver(ContentObserver contentObserver) {
        this.cursor.registerContentObserver(contentObserver);
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.cursor.registerDataSetObserver(dataSetObserver);
    }

    public boolean requery() {
        return this.cursor.requery();
    }

    public Bundle respond(Bundle bundle) {
        return this.cursor.respond(bundle);
    }

    @RequiresApi(api = 23)
    public void setExtras(Bundle bundle) {
        this.cursor.setExtras(bundle);
    }

    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        this.cursor.setNotificationUri(contentResolver, uri);
    }

    public void unregisterContentObserver(ContentObserver contentObserver) {
        this.cursor.unregisterContentObserver(contentObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.cursor.unregisterDataSetObserver(dataSetObserver);
    }
}
