package com.phocohanoi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.phocohanoi.R;

public class HomeFragment extends Fragment {

    private Button btnMap, btnList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btnMap = (Button) view.findViewById(R.id.btnMap);
        btnList = (Button) view.findViewById(R.id.btnList);

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new ListViewFragment(), false, "one");
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new MapFragment(), false, "one");
            }
        });

        addFragment(new MapFragment(), false, "one");

        return view;


    }

    private void addFragment(Fragment fragment, boolean addToBackStack, String tag) {
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        if (addToBackStack) {
            ft.addToBackStack(tag);
        }
        ft.replace(R.id.container_frame, fragment, tag);
        ft.commitAllowingStateLoss();
    }
}