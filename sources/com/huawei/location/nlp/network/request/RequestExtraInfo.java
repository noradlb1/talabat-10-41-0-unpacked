package com.huawei.location.nlp.network.request;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class RequestExtraInfo {
    int arStatus;
    List<CacheLocationOnline> cacheLocationList;
    List<IndoorLocation> indoorGlobalLocation;
    List<IndoorLocation> indoorLocalLocation;
    int isFilter;
    NLPLocationOnLine nlpLastLocation;

    public int getArStatus() {
        return this.arStatus;
    }

    public List<CacheLocationOnline> getCacheLocationList() {
        return this.cacheLocationList;
    }

    public List<IndoorLocation> getIndoorGlobalLocation() {
        return this.indoorGlobalLocation;
    }

    public List<IndoorLocation> getIndoorLocalLocation() {
        return this.indoorLocalLocation;
    }

    public int getIsFilter() {
        return this.isFilter;
    }

    public NLPLocationOnLine getNlpLastLocation() {
        return this.nlpLastLocation;
    }

    public void setArStatus(int i11) {
        this.arStatus = i11;
    }

    public void setCacheLocationList(List<CacheLocationOnline> list) {
        this.cacheLocationList = list;
    }

    public void setIndoorGlobalLocation(List<IndoorLocation> list) {
        this.indoorGlobalLocation = list;
    }

    public void setIndoorLocalLocation(List<IndoorLocation> list) {
        this.indoorLocalLocation = list;
    }

    public void setIsFilter(int i11) {
        this.isFilter = i11;
    }

    public void setNlpLastLocation(NLPLocationOnLine nLPLocationOnLine) {
        this.nlpLastLocation = nLPLocationOnLine;
    }

    public String toString() {
        return "RequestExtraInfo{nlpLastLocation=" + this.nlpLastLocation + ", cacheLocationList=" + this.cacheLocationList + ", indoorGlobalLocation=" + this.indoorGlobalLocation + ", indoorLocalLocation=" + this.indoorLocalLocation + ", arStatus=" + this.arStatus + ", isFilter=" + this.isFilter + AbstractJsonLexerKt.END_OBJ;
    }
}
