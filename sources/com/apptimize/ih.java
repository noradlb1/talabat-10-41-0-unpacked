package com.apptimize;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.net.URI;
import java.net.URISyntaxException;

public interface ih {
    Resources a();

    Drawable a(URI uri);

    URI a(Drawable drawable) throws URISyntaxException;

    void b(Drawable drawable);
}
