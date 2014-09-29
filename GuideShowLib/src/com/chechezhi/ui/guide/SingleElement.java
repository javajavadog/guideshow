package com.chechezhi.ui.guide;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;

public class SingleElement {
    public float xStart;
    public float xEnd;
    public float yStart;
    public float yEnd;

    public float alphaStart = 1.0f;
    public float alphaEnd = 1.0f;

    public Bitmap contentBitmap;
    public Matrix m = new Matrix();
    public Paint p = new Paint();

    public SingleElement(float xs, float ys, float xe, float ye, float as, float ae, Bitmap content) {
        xStart = xs;
        xEnd = xe;
        yStart = ys;
        yEnd = ye;
        alphaStart = as;
        alphaEnd = ae;
        contentBitmap = content;
    }
}
