package com.chechezhi.ui.guide;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentTabAdapter extends FragmentPagerAdapter {

    private List<SinglePage> mGuideContent;
    private Context mCtx;

    public FragmentTabAdapter(FragmentActivity a, List<SinglePage> guideContent) {
        super(a.getSupportFragmentManager());
        mCtx = a;
        mGuideContent = guideContent;
    }

    @Override
    public Fragment getItem(int position) {
        PageFragment pageFragment = (PageFragment) Fragment.instantiate(mCtx, PageFragment.class.getName());
        pageFragment.setBg(mGuideContent.get(position).mBackground);
        return pageFragment;
    }

    @Override
    public int getCount() {
        return mGuideContent.size();
    }

    public static final class PageFragment extends Fragment {

        private Drawable mBg;

        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                @Nullable Bundle savedInstanceState) {
            ImageView iv = new ImageView(getActivity());
            iv.setBackground(mBg);
            return iv;
        }

        public void setBg(Drawable mBackground) {
            mBg = mBackground;
        }

    }
}
