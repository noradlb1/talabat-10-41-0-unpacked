package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;

class CursorFilter extends Filter {

    /* renamed from: a  reason: collision with root package name */
    public CursorFilterClient f11560a;

    public interface CursorFilterClient {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    public CursorFilter(CursorFilterClient cursorFilterClient) {
        this.f11560a = cursorFilterClient;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f11560a.convertToString((Cursor) obj);
    }

    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor runQueryOnBackgroundThread = this.f11560a.runQueryOnBackgroundThread(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (runQueryOnBackgroundThread != null) {
            filterResults.count = runQueryOnBackgroundThread.getCount();
            filterResults.values = runQueryOnBackgroundThread;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursor = this.f11560a.getCursor();
        Object obj = filterResults.values;
        if (obj != null && obj != cursor) {
            this.f11560a.changeCursor((Cursor) obj);
        }
    }
}
