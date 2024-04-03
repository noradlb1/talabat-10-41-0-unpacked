package com.instabug.library.map;

public interface Mapper<FROM, TO> {
    TO map(FROM from);
}
