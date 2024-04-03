package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Util;
import com.huawei.hms.flutter.map.constants.Param;

class AttributeStrategy implements LruPoolStrategy {
    private final GroupedLinkedMap<Key, Bitmap> groupedMap = new GroupedLinkedMap<>();
    private final KeyPool keyPool = new KeyPool();

    @VisibleForTesting
    public static class Key implements Poolable {
        private Bitmap.Config config;
        private int height;
        private final KeyPool pool;
        private int width;

        public Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (this.width == key.width && this.height == key.height && this.config == key.config) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i11;
            int i12 = ((this.width * 31) + this.height) * 31;
            Bitmap.Config config2 = this.config;
            if (config2 != null) {
                i11 = config2.hashCode();
            } else {
                i11 = 0;
            }
            return i12 + i11;
        }

        public void init(int i11, int i12, Bitmap.Config config2) {
            this.width = i11;
            this.height = i12;
            this.config = config2;
        }

        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return AttributeStrategy.getBitmapString(this.width, this.height, this.config);
        }
    }

    @VisibleForTesting
    public static class KeyPool extends BaseKeyPool<Key> {
        public Key get(int i11, int i12, Bitmap.Config config) {
            Key key = (Key) get();
            key.init(i11, i12, config);
            return key;
        }

        public Key create() {
            return new Key(this);
        }
    }

    private static String getBitmapString(Bitmap bitmap) {
        return getBitmapString(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    public Bitmap get(int i11, int i12, Bitmap.Config config) {
        return this.groupedMap.get(this.keyPool.get(i11, i12, config));
    }

    public int getSize(Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }

    public String logBitmap(Bitmap bitmap) {
        return getBitmapString(bitmap);
    }

    public void put(Bitmap bitmap) {
        this.groupedMap.put(this.keyPool.get(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public Bitmap removeLast() {
        return this.groupedMap.removeLast();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.groupedMap;
    }

    public static String getBitmapString(int i11, int i12, Bitmap.Config config) {
        return "[" + i11 + Param.X + i12 + "], " + config;
    }

    public String logBitmap(int i11, int i12, Bitmap.Config config) {
        return getBitmapString(i11, i12, config);
    }
}
