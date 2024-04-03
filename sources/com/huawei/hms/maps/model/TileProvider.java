package com.huawei.hms.maps.model;

public interface TileProvider {
    public static final int DEFAULT_HEIGHT = -1;
    public static final int DEFAULT_WIDTH = -1;
    public static final Tile NO_TILE = new Tile(-1, -1, (byte[]) null);

    Tile getTile(int i11, int i12, int i13);
}
