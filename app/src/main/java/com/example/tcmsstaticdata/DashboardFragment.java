package com.example.tcmsstaticdata;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.util.ArrayList;

public class DashboardFragment extends Fragment implements RecyclerViewAdapter.ItemListener {

    Context context;
    private ViewPager viewPager;
    RecyclerView recyclerView, recyclerView1;
    ArrayList<DataModel> arrayList;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public static DashboardFragment newInstance() {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        viewPager = view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(context));

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView1 = (RecyclerView) view.findViewById(R.id.recyclerView1);
        arrayList = new ArrayList<>();

        arrayList.add(new DataModel("Batches", R.mipmap.icon_metis_batches, "#13A9FF"));

        arrayList.add(new DataModel("Students", R.mipmap.icon_metis_students, "#19A9FF"));

        arrayList.add(new DataModel("Attendance", R.mipmap.icon_metis, "#13A9FF"));

        arrayList.add(new DataModel("Tuition fees", R.mipmap.icon_metis_fee, "#1429FF"));


        arrayList.add(new DataModel("Expenses", R.mipmap.icon_metis_expenses, "#1429FF"));

        arrayList.add(new DataModel("Student Performence", R.mipmap.icon_metis_studentperf, "#13A9FF"));
        arrayList.add(new DataModel("Enquiry manager", R.mipmap.icon_metis_1, "#13A9FF"));

        arrayList.add(new DataModel("Staff manager", R.mipmap.icon_metis_2, "#13A9FF"));

        arrayList.add(new DataModel("Online sms", R.mipmap.icon_metis_3, "#13A9FF"));

        arrayList.add(new DataModel("Giant Reports", R.mipmap.icon_metis_4, "#13A9FF"));

        arrayList.add(new DataModel("Task Manager", R.mipmap.icon_metis, "#13A9FF"));

        arrayList.add(new DataModel("Web View", R.mipmap.icon_metis_3, "#13A9FF"));


        RecyclerViewAdapter adapter = new RecyclerViewAdapter(context, arrayList, DashboardFragment.this);
        recyclerView.setAdapter(adapter);
        /**
         Simple GridLayoutManager that spans two columns
         **/
        GridLayoutManager manager = new GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        RecyclerViewAdapter1 adapter1 = new RecyclerViewAdapter1(context);
        recyclerView1.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerView1.setAdapter(adapter1);


        return view;
    }

    @Override
    public void onItemClick(DataModel item) {

        Toast.makeText(context, item.text + " is clicked", Toast.LENGTH_SHORT).show();

    }
}