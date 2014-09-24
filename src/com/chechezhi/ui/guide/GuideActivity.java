package com.chechezhi.ui.guide;

import java.util.List;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public abstract class GuideActivity extends FragmentActivity {
    private ViewPager mPager;
    private GuideView mGuideView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<SinglePage> guideContent = buildGuideContent();

        // prepare views
        setContentView(R.layout.guide_container);
        mPager = (ViewPager) findViewById(R.id.guide_pager);

        FragmentPagerAdapter adapter = new FragmentTabAdapter(this, guideContent);
        mPager.setAdapter(adapter);

        mGuideView = new GuideView(this, guideContent, drawDot(), dotDefault(), dotSelected());
        mPager.setOnPageChangeListener(mGuideView);

        FrameLayout container = (FrameLayout) findViewById(R.id.guide_container);
        container.addView(mGuideView, new LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT));
    }

    abstract List<SinglePage> buildGuideContent();
    
    abstract boolean drawDot();
    
    abstract Bitmap dotDefault();
    
    abstract Bitmap dotSelected();
}
