package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.lang.reflect.Array;

class TileList<T> {
    Tile<T> mLastAccessedTile;
    final int mTileSize;
    private final SparseArray<Tile<T>> mTiles = new SparseArray<>(10);

    public static class Tile<T> {
        public int mItemCount;
        public final T[] mItems;
        Tile<T> mNext;
        public int mStartPosition;

        public Tile(Class<T> cls, int i11) {
            this.mItems = (Object[]) Array.newInstance(cls, i11);
        }

        public boolean containsPosition(int i11) {
            int i12 = this.mStartPosition;
            return i12 <= i11 && i11 < i12 + this.mItemCount;
        }

        public T getByPosition(int i11) {
            return this.mItems[i11 - this.mStartPosition];
        }
    }

    public TileList(int i11) {
        this.mTileSize = i11;
    }

    public Tile<T> addOrReplace(Tile<T> tile) {
        int indexOfKey = this.mTiles.indexOfKey(tile.mStartPosition);
        if (indexOfKey < 0) {
            this.mTiles.put(tile.mStartPosition, tile);
            return null;
        }
        Tile<T> valueAt = this.mTiles.valueAt(indexOfKey);
        this.mTiles.setValueAt(indexOfKey, tile);
        if (this.mLastAccessedTile == valueAt) {
            this.mLastAccessedTile = tile;
        }
        return valueAt;
    }

    public void clear() {
        this.mTiles.clear();
    }

    public Tile<T> getAtIndex(int i11) {
        if (i11 < 0 || i11 >= this.mTiles.size()) {
            return null;
        }
        return this.mTiles.valueAt(i11);
    }

    public T getItemAt(int i11) {
        Tile<T> tile = this.mLastAccessedTile;
        if (tile == null || !tile.containsPosition(i11)) {
            int indexOfKey = this.mTiles.indexOfKey(i11 - (i11 % this.mTileSize));
            if (indexOfKey < 0) {
                return null;
            }
            this.mLastAccessedTile = this.mTiles.valueAt(indexOfKey);
        }
        return this.mLastAccessedTile.getByPosition(i11);
    }

    public Tile<T> removeAtPos(int i11) {
        Tile<T> tile = this.mTiles.get(i11);
        if (this.mLastAccessedTile == tile) {
            this.mLastAccessedTile = null;
        }
        this.mTiles.delete(i11);
        return tile;
    }

    public int size() {
        return this.mTiles.size();
    }
}
