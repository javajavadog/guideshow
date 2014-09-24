package com.chechezhi.ui.guide;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;

public class GuideView extends View implements OnPageChangeListener {

    private List<SinglePage> mGuideContent;

    private int mPosition;
    private float mOffset;

    private boolean mDrawDot;

    /**
     * This class could not instantiation from XML
     * 
     * @param context
     * @param guideContent
     */
    public GuideView(Context context, List<SinglePage> guideContent, boolean drawDot) {
        super(context);
        mGuideContent = guideContent;
        mDrawDot = drawDot;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        SinglePage singlePage = mGuideContent.get(mPosition);
        if (singlePage.mElementsList == null) {
            // Draw nothing
            super.onDraw(canvas);
            return;
        }

        // Draw custom stuff
        for (int i = 0; i < singlePage.mElementsList.size(); i++) {
            SingleElement e = singlePage.mElementsList.get(i);
            Bitmap bitmap = e.contentBitmap;
            Matrix m = e.m;
            Paint p = e.p;

            float dx = e.xStart + (e.xEnd - e.xStart) * mOffset;
            float dy = e.yStart + (e.yEnd - e.yStart) * mOffset;
            float alpha = e.alphaStart + (e.alphaEnd - e.alphaStart) * mOffset;

            m.setTranslate(dx, dy);
            p.setAlpha((int) (0xFF * alpha));

            canvas.drawBitmap(bitmap, m, p);
        }
        
        // Draw dot
        if (mDrawDot) {
            
        }
        super.onDraw(canvas);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageScrolled(int index, float offset, int offsetPixel) {
        mPosition = index;
        mOffset = offset;
        invalidate();
    }

    @Override
    public void onPageSelected(int index) {
        // TODO Auto-generated method stub

    }

}
