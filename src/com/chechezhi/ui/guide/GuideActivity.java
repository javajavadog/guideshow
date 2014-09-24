package com.chechezhi.ui.guide;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class GuideActivity extends FragmentActivity {
    private FrameLayout mContainer;
    private ViewPager mPager;
    private GuideView mGuideView;
    private ImageView mNavigationDotView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // prepare the information for our guide
        List<SinglePage> guideContent = new ArrayList<SinglePage>();

        SinglePage page01 = new SinglePage();
        page01.mBackground = getResources().getDrawable(R.drawable.bg_page_01);
        guideContent.add(page01);

        SinglePage page02 = new SinglePage();
        page02.mBackground = getResources().getDrawable(R.drawable.bg_page_02);
        guideContent.add(page02);

        SinglePage page03 = new SinglePage();
        page03.mBackground = getResources().getDrawable(R.drawable.bg_page_03);
        guideContent.add(page03);

        SinglePage page04 = new SinglePage();
        page04.mBackground = getResources().getDrawable(R.drawable.bg_page_04);
        guideContent.add(page04);

        SinglePage page05 = new SinglePage();
        page05.mBackground = getResources().getDrawable(R.drawable.bg_page_05);
        guideContent.add(page05);

        // prepare views
        setContentView(R.layout.guide_container);
        mContainer = (FrameLayout) findViewById(R.id.guide_container);
        mPager = (ViewPager) findViewById(R.id.guide_pager);
        mNavigationDotView = (ImageView) findViewById(R.id.navigation_dot);

        FragmentPagerAdapter adapter = new FragmentTabAdapter(this, guideContent);
        mPager.setAdapter(adapter);
        
        mGuideView = new GuideView(this);
        mPager.setOnPageChangeListener(mGuideView);
    }
}
