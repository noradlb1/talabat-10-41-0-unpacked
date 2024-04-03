package com.instabug.chat.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

public class c implements Comparator, Serializable {
    /* renamed from: a */
    public int compare(d dVar, d dVar2) {
        return new Date(dVar.c()).compareTo(new Date(dVar2.c()));
    }
}
