package com.apptimize;

import android.view.View;
import com.apptimize.bq;

public class hb {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42908a = "hb";

    public hb(au auVar) {
        a(auVar);
    }

    private static void a(au auVar) {
        try {
            Class.forName("android.support.v7.widget.RecyclerView");
            bo.a(f42908a, "Found RecyclerView class");
        } catch (ClassNotFoundException unused) {
            auVar.a().a(bq.b.CouldNotFindRecyclerView);
        }
    }

    public static boolean a(View view) {
        return fn.a((Object) view, "android.support.v7.widget.RecyclerView");
    }
}
