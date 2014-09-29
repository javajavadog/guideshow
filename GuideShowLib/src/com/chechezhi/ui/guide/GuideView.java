package com.chechezhi.ui.guide;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.View;

public class GuideView extends View implements OnPageChangeListener {
    private static final int DOT_SPACE_DIVIDE = 3;
    private static final float DOT_Y_POSITION = 0.8f;

    private List<SinglePage> mGuideContent;

    private int mPosition;
    private float mOffset;

    private boolean mDrawDot;

    private List<SingleElement> mDotList;
    private int mDotXStart;
    private int mDotXPlus;
    private int mDotY;
    private SingleElement mSelectedDot;

    /**
     * This class could not instantiation from XML
     * 
     * @param context
     * @param guideContent
     * @param dotSelected
     * @param dotDefault
     */
    public GuideView(Activity activity, List<SinglePage> guideContent, boolean drawDot, Bitmap dotDefault, Bitmap dotSelected) {
        super(activity);
        mGuideContent = guideContent;
        mDrawDot = drawDot;

        // Prepare dot element, if we have only one page, do not show dot
        if (guideContent != null && guideContent.size() > 1 && drawDot) {
            mDotList = new ArrayList<SingleElement>();

            // Just get a rough screen width/height
            DisplayMetrics dm = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
            Rect frame = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
            int statusBarHeight = frame.top;
            int mScreenWidth = dm.widthPixels;
            int mScreenHeight = dm.heightPixels - statusBarHeight;

            mDotXStart = mScreenWidth / DOT_SPACE_DIVIDE - dotDefault.getWidth() / 2;
            mDotXPlus = mScreenWidth / DOT_SPACE_DIVIDE / (guideContent.size() - 1);

            mDotY = (int) (mScreenHeight * DOT_Y_POSITION);

            for (int i = 0; i < guideContent.size(); i++) {
                SingleElement e = new SingleElement(mDotXStart + mDotXPlus * i, mDotY, mDotXStart + mDotXPlus * i, mDotY, 1.0f, 1.0f,
                        dotDefault);
                mDotList.add(e);
            }
            mSelectedDot = new SingleElement(mDotXStart + mDotXPlus * mPosition, mDotY, mDotXStart + mDotXPlus * mPosition, mDotY, 1.0f,
                    1.0f, dotSelected);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // Draw dot
        if (mDrawDot) {

            // Draw default dot
            for (int i = 0; i < mDotList.size(); i++) {
                SingleElement e = mDotList.get(i);
                drawElement(canvas, e);
            }

            // Draw selected dot
            int x = mDotXStart + mDotXPlus * mPosition;
            mSelectedDot.xStart = x;
            mSelectedDot.xEnd = x;
            drawElement(canvas, mSelectedDot);
        }

        SinglePage singlePage = mGuideContent.get(mPosition);
        if (singlePage.mElementsList == null) {
            // No stuff
            super.onDraw(canvas);
            return;
        }

        // Draw custom stuff
        for (int i = 0; i < singlePage.mElementsList.size(); i++) {
            SingleElement e = singlePage.mElementsList.get(i);
            drawElement(canvas, e);
        }
        super.onDraw(canvas);
    }

    private void drawElement(Canvas canvas, SingleElement e) {
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
