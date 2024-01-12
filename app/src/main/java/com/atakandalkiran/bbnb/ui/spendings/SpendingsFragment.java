package com.atakandalkiran.bbnb.ui.spendings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian3d;
import com.anychart.charts.Pie;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;
import com.atakandalkiran.bbnb.R;
import com.atakandalkiran.bbnb.data.base.BaseFragment;
import com.atakandalkiran.bbnb.databinding.FragmentSpendingsBinding;

import java.util.ArrayList;
import java.util.List;

public class SpendingsFragment extends BaseFragment {

    String[] renkler = {"#86C8CD", "#6DB2C8", "#40698E", "#415771", "#B4A0AC", "#619ba1", "#5499a4"};
    public SpendingsFragment() {
        // Required empty public constructor
    }
    FragmentSpendingsBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setBackground();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spendings, container, false);

        AnyChartView anyChartView = view.findViewById(R.id.anyChartView);

        setupPieChart(anyChartView);

        return view;
    }

    private void setupPieChart(AnyChartView anyChartView) {
        Pie pie = AnyChart.pie();

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Akaryakıt", 20));
        data.add(new ValueDataEntry("Eğitim", 15));
        data.add(new ValueDataEntry("Giyim", 10));
        data.add(new ValueDataEntry("Market", 25));
        data.add(new ValueDataEntry("Sağlık", 5));
        data.add(new ValueDataEntry("Yemek", 15));
        data.add(new ValueDataEntry("Diğer", 10));

        pie.data(data);
        pie.palette(renkler);
        pie.sort("asc");

        pie.legend()
                .itemsLayout(LegendLayout.VERTICAL);

        anyChartView.setChart(pie);
    }


    @Override
    protected void setupUI() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_spendings;
    }
}