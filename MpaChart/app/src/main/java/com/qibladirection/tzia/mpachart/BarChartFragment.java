package com.qibladirection.tzia.mpachart;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BarChartFragment extends Fragment {

    BarChart barChart;
    boolean init=false;

    public BarChartFragment() {

        if(init && barChart!=null) {
            ArrayList<BarEntry> entries = new ArrayList<>();
            entries.add(new BarEntry(4f, 0));
            entries.add(new BarEntry(8f, 1));
            entries.add(new BarEntry(6f, 2));
            entries.add(new BarEntry(12f, 3));
            entries.add(new BarEntry(18f, 4));
            entries.add(new BarEntry(9f, 5));
            entries.add(new BarEntry(3f, 6));

            BarDataSet barDataSet = new BarDataSet(entries, "Daily Sunnah Acheivements");
            barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);


            ArrayList<String> labels = new ArrayList<String>();
            labels.add("Monday");
            labels.add("Tuesday");
            labels.add("Wednesday");
            labels.add("Thursday");
            labels.add("Friday");
            labels.add("Saturday");
            labels.add("Sunday");


            BarData barData = new BarData(labels, barDataSet);


            barChart.setData(barData);
            barChart.setBackgroundColor(Color.WHITE);

            barChart.animateY(3000);
            barChart.invalidate();
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bar_chart, container, false);
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(4f, 0));
        entries.add(new BarEntry(8f, 1));
        entries.add(new BarEntry(6f, 2));
        entries.add(new BarEntry(12f, 3));
        entries.add(new BarEntry(18f, 4));
        entries.add(new BarEntry(9f, 5));
        entries.add(new BarEntry(3f, 6));

        BarDataSet barDataSet=new BarDataSet(entries,"Daily Sunnah Acheivements");
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);


        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Monday");
        labels.add("Tuesday");
        labels.add("Wednesday");
        labels.add("Thursday");
        labels.add("Friday");
        labels.add("Saturday");
        labels.add("Sunday");

        barChart=(BarChart) view.findViewById(R.id.chart);

        BarData barData=new BarData(labels, barDataSet);



        barChart.setData(barData);
        barChart.setBackgroundColor(Color.WHITE);

        barChart.animateY(3000);

        init=true;

        // Inflate the layout for this fragment
        return view;
    }

}
