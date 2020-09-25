package com.example.tcmsstaticdata;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter1 extends RecyclerView.Adapter<RecyclerViewAdapter1.ViewHolder> {

    ArrayList<DataModel1> mValues;
    Context mContext;
    protected ItemListener mListener;

    public RecyclerViewAdapter1(Context context) {
        mContext = context;
        setDataModel1();

    }
    //we are working in admin

    private void setDataModel1(){
        mValues = new ArrayList<>();
        mValues.add(new DataModel1("Students", 4, 5,String.valueOf(R.color.black)));
        mValues.add(new DataModel1("Staff", 14, 8,String.valueOf(R.color.red)));
        mValues.add(new DataModel1("Teachers", 4, 15,String.valueOf(R.color.white)));

    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textView, active, inactive;
        public RelativeLayout relativeLayout;
        DataModel1 item;
        public ViewHolder(View v) {

            super(v);

            v.setOnClickListener(this);
            textView = (TextView) v.findViewById(R.id.textView);
            active = (TextView) v.findViewById(R.id.active);
            inactive = (TextView) v.findViewById(R.id.inactive);
            relativeLayout = (RelativeLayout) v.findViewById(R.id.relativeLayout);

        }

        public void setData(DataModel1 item) {
            this.item= item;
            textView.setText(item.text);
            active.setText(item.text);
            inactive.setText(item.text);
            relativeLayout.setBackgroundColor(Integer.parseInt(item.color));
            //provide color from color.xml as i done
        }


        @Override
        public void onClick(View view) {
//            if (mListener != null) {
//                mListener.onItemClick(item);
//            }
        }
    }

    @Override
    public RecyclerViewAdapter1.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item1, parent, false);

        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder Vholder, int position) {
        Vholder.setData(mValues.get(position));

    }


    @Override
    public int getItemCount() {

        return mValues.size();
    }

    public interface ItemListener {
        void onItemClick(DataModel item);
    }
}