package com.squareup.picasso;

import android.content.Context;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import okio.Okio;

class ContentStreamRequestHandler extends RequestHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Context f53395a;

    public ContentStreamRequestHandler(Context context) {
        this.f53395a = context;
    }

    public boolean canHandleRequest(Request request) {
        return "content".equals(request.uri.getScheme());
    }

    public InputStream getInputStream(Request request) throws FileNotFoundException {
        return this.f53395a.getContentResolver().openInputStream(request.uri);
    }

    public RequestHandler.Result load(Request request, int i11) throws IOException {
        return new RequestHandler.Result(Okio.source(getInputStream(request)), Picasso.LoadedFrom.DISK);
    }
}
