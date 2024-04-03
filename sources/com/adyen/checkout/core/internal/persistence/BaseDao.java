package com.adyen.checkout.core.internal.persistence;

import androidx.annotation.NonNull;
import androidx.room.Insert;
import androidx.room.Update;

interface BaseDao<T> {
    @Insert(onConflict = 4)
    void insert(@NonNull T t11);

    @Update
    void update(@NonNull T t11);
}
