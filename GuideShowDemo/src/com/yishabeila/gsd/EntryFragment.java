package com.yishabeila.gsd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class EntryFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_entry, null);
        v.findViewById(R.id.btn_entry).setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                ExampleGuideActivity activity = (ExampleGuideActivity) getActivity();
                activity.entryApp();
            }
        });
        return v;
    }
}
