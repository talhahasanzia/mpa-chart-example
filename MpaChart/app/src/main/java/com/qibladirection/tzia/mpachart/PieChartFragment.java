package com.qibladirection.tzia.mpachart;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PieChartFragment extends Fragment implements OnChartValueSelectedListener {
    boolean init=false;
    static  com.github.mikephil.charting.charts.PieChart mChart;

    public static void Redraw()
    {
        mChart.invalidate();

    }
    public PieChartFragment() {

        if(init && mChart!=null) {
            mChart.setUsePercentValues(true);
            mChart.setDescription("");
            mChart.setExtraOffsets(5, 10, 5, 5);

            mChart.setDragDecelerationFrictionCoef(0.95f);

            mChart.setCenterText(generateCenterSpannableText());

            mChart.setDrawHoleEnabled(true);
            mChart.setHoleColor(Color.WHITE);

            mChart.setTransparentCircleColor(Color.WHITE);
            mChart.setTransparentCircleAlpha(110);

            mChart.setHoleRadius(58f);
            mChart.setTransparentCircleRadius(61f);

            mChart.setDrawCenterText(true);

            mChart.setRotationAngle(0);
            // enable rotation of the chart by touch
            mChart.setRotationEnabled(true);
            mChart.setHighlightPerTapEnabled(true);

            // mChart.setUnit(" €");
            // mChart.setDrawUnitsInChart(true);

            // add a selection listener
            mChart.setOnChartValueSelectedListener(this);

            ArrayList<Entry> yVals1 = new ArrayList<Entry>();
            yVals1.add(new Entry(30, 0));
            yVals1.add(new Entry(45, 1));
            yVals1.add(new Entry(25, 2));

            ArrayList<Integer> colors = new ArrayList<Integer>();

            for (int c : ColorTemplate.JOYFUL_COLORS)
                colors.add(c);


            PieDataSet dataSet = new PieDataSet(yVals1, "Election Results");
            dataSet.setSliceSpace(3f);
            dataSet.setSelectionShift(5f);
            dataSet.setColors(colors);

            ArrayList<String> xVals = new ArrayList<String>();
            xVals.add("Good");
            xVals.add("Bad");
            xVals.add("Nothing");

            PieData data = new PieData(xVals, dataSet);
            data.setValueFormatter(new PercentFormatter());
            data.setValueTextSize(11f);
            data.setValueTextColor(Color.WHITE);

            mChart.setData(data);

            // undo all highlights
            mChart.highlightValues(null);

            mChart.invalidate();

            mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
            // mChart.spin(2000, 0, 360);

            Legend l = mChart.getLegend();
            l.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
            l.setXEntrySpace(7f);
            l.setYEntrySpace(0f);
            l.setYOffset(0f);

            mChart.invalidate();
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_pie_chart, container, false);

        mChart=(com.github.mikephil.charting.charts.PieChart) view.findViewById(R.id.chart);


        mChart.setUsePercentValues(true);
        mChart.setDescription("");
        mChart.setExtraOffsets(5, 10, 5, 5);

        mChart.setDragDecelerationFrictionCoef(0.95f);

         mChart.setCenterText(generateCenterSpannableText());

        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColor(Color.WHITE);

        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(110);

        mChart.setHoleRadius(58f);
        mChart.setTransparentCircleRadius(61f);

        mChart.setDrawCenterText(true);

        mChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        mChart.setRotationEnabled(true);
        mChart.setHighlightPerTapEnabled(true);

        // mChart.setUnit(" €");
        // mChart.setDrawUnitsInChart(true);

        // add a selection listener
        mChart.setOnChartValueSelectedListener(this);

        ArrayList<Entry> yVals1 = new ArrayList<Entry>();
        yVals1.add(new Entry(30,0));
        yVals1.add(new Entry(45,1));
        yVals1.add(new Entry(25,2));

        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);



        PieDataSet dataSet = new PieDataSet(yVals1, "Election Results");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(colors);

        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("Good");
        xVals.add("Bad");
        xVals.add("Nothing");

        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);

        mChart.setData(data);

        // undo all highlights
        mChart.highlightValues(null);

        mChart.invalidate();

        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // mChart.spin(2000, 0, 360);

        Legend l = mChart.getLegend();
        l.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        init=true;

        return view;
    }

    @Override
    public void onValueSelected(Entry entry, int i, Highlight highlight) {

    }

    @Override
    public void onNothingSelected() {

    }



    private SpannableString generateCenterSpannableText() {

        SpannableString s = new SpannableString("Weekly Deed Report");

        s.setSpan(new StyleSpan(Typeface.ITALIC), 0, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), 0, s.length(), 0);
        return s;
    }

}
