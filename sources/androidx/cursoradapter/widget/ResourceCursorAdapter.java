package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class ResourceCursorAdapter extends CursorAdapter {
    private int mDropDownLayout;
    private LayoutInflater mInflater;
    private int mLayout;

    @Deprecated
    public ResourceCursorAdapter(Context context, int i11, Cursor cursor) {
        super(context, cursor);
        this.mDropDownLayout = i11;
        this.mLayout = i11;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.mDropDownLayout, viewGroup, false);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.mLayout, viewGroup, false);
    }

    public void setDropDownViewResource(int i11) {
        this.mDropDownLayout = i11;
    }

    public void setViewResource(int i11) {
        this.mLayout = i11;
    }

    @Deprecated
    public ResourceCursorAdapter(Context context, int i11, Cursor cursor, boolean z11) {
        super(context, cursor, z11);
        this.mDropDownLayout = i11;
        this.mLayout = i11;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context context, int i11, Cursor cursor, int i12) {
        super(context, cursor, i12);
        this.mDropDownLayout = i11;
        this.mLayout = i11;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
