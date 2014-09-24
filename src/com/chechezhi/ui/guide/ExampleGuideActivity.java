package com.chechezhi.ui.guide;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ExampleGuideActivity extends GuideActivity{
    
    @Override
    List<SinglePage> buildGuideContent() {
        // prepare the information for our guide
        List<SinglePage> guideContent = new ArrayList<SinglePage>();

        SinglePage page01 = new SinglePage();
        page01.mBackground = getResources().getDrawable(R.drawable.bg_page_01);
        SingleElement e01 = new SingleElement(200, 200, 400, 400, 0.0f, 1.0f, BitmapFactory.decodeResource(getResources(), R.drawable.ic_stuff));
        SingleElement e02 = new SingleElement(700, 800, 700, 100, 0.0f, 1.0f, BitmapFactory.decodeResource(getResources(), R.drawable.ic_stuff));
        page01.mElementsList.add(e01);
        page01.mElementsList.add(e02);
        guideContent.add(page01);
        
        SinglePage page02 = new SinglePage();
        page02.mBackground = getResources().getDrawable(R.drawable.bg_page_02);    
        SingleElement e03 = new SingleElement(400, 400, -100, -100, 1.0f, 0.0f, BitmapFactory.decodeResource(getResources(), R.drawable.ic_stuff));
        SingleElement e04 = new SingleElement(700, 100, 700, -200, 1.0f, 0.0f, BitmapFactory.decodeResource(getResources(), R.drawable.ic_stuff));
        page02.mElementsList.add(e03);
        page02.mElementsList.add(e04);
        guideContent.add(page02);

        SinglePage page03 = new SinglePage();
        page03.mBackground = getResources().getDrawable(R.drawable.bg_page_03);
        guideContent.add(page03);

        SinglePage page04 = new SinglePage();
        page04.mBackground = getResources().getDrawable(R.drawable.bg_page_04);
        guideContent.add(page04);

        SinglePage page05 = new SinglePage();
        page05.mCustomFragment = new EntryFragment();
        guideContent.add(page05);
        return guideContent;
    }

    @Override
    Bitmap dotDefault() {
        return BitmapFactory.decodeResource(getResources(), R.drawable.ic_dot_default);
    }

    @Override
    Bitmap dotSelected() {
        return BitmapFactory.decodeResource(getResources(), R.drawable.ic_dot_selected);
    }

    @Override
    boolean drawDot() {
        return true;
    }
}
