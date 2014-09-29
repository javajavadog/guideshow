package com.chechezhi.ui.guide;

import java.util.List;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public abstract class AbsGuideActivity extends FragmentActivity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<SinglePage> guideContent = buildGuideContent();

        if (guideContent == null) {
            // nothing to show
            return;
        }

        // prepare views
        FrameLayout container = new FrameLayout(this);
        ViewPager pager = new ViewPager(this);
        pager.setId(getPagerId());

        container.addView(pager, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        setContentView(container);

        FragmentPagerAdapter adapter = new FragmentTabAdapter(this, guideContent);
        pager.setAdapter(adapter);

        GuideView guideView = new GuideView(this, guideContent, drawDot(), dotDefault(), dotSelected());
        pager.setOnPageChangeListener(guideView);

        container.addView(guideView, new LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT));
    }

    abstract public List<SinglePage> buildGuideContent();

    abstract public boolean drawDot();

    abstract public Bitmap dotDefault();

    abstract public Bitmap dotSelected();

    abstract public int getPagerId();
}
