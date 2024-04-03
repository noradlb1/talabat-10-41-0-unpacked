package androidx.recyclerview.widget;

import androidx.recyclerview.widget.TileList;

interface ThreadUtil<T> {

    public interface BackgroundCallback<T> {
        void loadTile(int i11, int i12);

        void recycleTile(TileList.Tile<T> tile);

        void refresh(int i11);

        void updateRange(int i11, int i12, int i13, int i14, int i15);
    }

    public interface MainThreadCallback<T> {
        void addTile(int i11, TileList.Tile<T> tile);

        void removeTile(int i11, int i12);

        void updateItemCount(int i11, int i12);
    }

    BackgroundCallback<T> getBackgroundProxy(BackgroundCallback<T> backgroundCallback);

    MainThreadCallback<T> getMainThreadProxy(MainThreadCallback<T> mainThreadCallback);
}
