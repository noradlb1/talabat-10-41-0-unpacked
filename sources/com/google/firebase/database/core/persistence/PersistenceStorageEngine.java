package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.UserWriteRecord;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import java.util.List;
import java.util.Set;

public interface PersistenceStorageEngine {
    void beginTransaction();

    void close();

    void deleteTrackedQuery(long j11);

    void endTransaction();

    List<TrackedQuery> loadTrackedQueries();

    Set<ChildKey> loadTrackedQueryKeys(long j11);

    Set<ChildKey> loadTrackedQueryKeys(Set<Long> set);

    List<UserWriteRecord> loadUserWrites();

    void mergeIntoServerCache(Path path, CompoundWrite compoundWrite);

    void mergeIntoServerCache(Path path, Node node);

    void overwriteServerCache(Path path, Node node);

    void pruneCache(Path path, PruneForest pruneForest);

    void removeAllUserWrites();

    void removeUserWrite(long j11);

    void resetPreviouslyActiveTrackedQueries(long j11);

    void saveTrackedQuery(TrackedQuery trackedQuery);

    void saveTrackedQueryKeys(long j11, Set<ChildKey> set);

    void saveUserMerge(Path path, CompoundWrite compoundWrite, long j11);

    void saveUserOverwrite(Path path, Node node, long j11);

    Node serverCache(Path path);

    long serverCacheEstimatedSizeInBytes();

    void setTransactionSuccessful();

    void updateTrackedQueryKeys(long j11, Set<ChildKey> set, Set<ChildKey> set2);
}
