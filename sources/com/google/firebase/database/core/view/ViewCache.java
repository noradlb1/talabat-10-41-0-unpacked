package com.google.firebase.database.core.view;

import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;

public class ViewCache {
    private final CacheNode eventSnap;
    private final CacheNode serverSnap;

    public ViewCache(CacheNode cacheNode, CacheNode cacheNode2) {
        this.eventSnap = cacheNode;
        this.serverSnap = cacheNode2;
    }

    public Node getCompleteEventSnap() {
        if (this.eventSnap.isFullyInitialized()) {
            return this.eventSnap.getNode();
        }
        return null;
    }

    public Node getCompleteServerSnap() {
        if (this.serverSnap.isFullyInitialized()) {
            return this.serverSnap.getNode();
        }
        return null;
    }

    public CacheNode getEventCache() {
        return this.eventSnap;
    }

    public CacheNode getServerCache() {
        return this.serverSnap;
    }

    public ViewCache updateEventSnap(IndexedNode indexedNode, boolean z11, boolean z12) {
        return new ViewCache(new CacheNode(indexedNode, z11, z12), this.serverSnap);
    }

    public ViewCache updateServerSnap(IndexedNode indexedNode, boolean z11, boolean z12) {
        return new ViewCache(this.eventSnap, new CacheNode(indexedNode, z11, z12));
    }
}
