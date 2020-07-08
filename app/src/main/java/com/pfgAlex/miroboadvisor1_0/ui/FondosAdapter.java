package com.pfgAlex.miroboadvisor1_0.ui;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.pfgAlex.miroboadvisor1_0.Carteras;
import com.pfgAlex.miroboadvisor1_0.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;
import lecho.lib.hellocharts.model.Viewport;

public class FondosAdapter extends RecyclerView.Adapter<FondosAdapter.FondoViewHolder> {

    final List<Carteras> datos;

    FondosAdapter(List<Carteras> carteras) {
        datos = carteras;
    }

    @NonNull
    @Override
    public FondosAdapter.FondoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.activity_cv_fondos, parent, false);
        return new FondosAdapter.FondoViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull FondosAdapter.FondoViewHolder holder, int position) {
        Carteras dato = datos.get(position);
        holder.bind(dato);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    static class FondoViewHolder extends RecyclerView.ViewHolder {
        View miItem;
        public FondoViewHolder(@NonNull View itemView) {
            super(itemView);
            miItem = itemView;
        }
        public void bind(Carteras dato){
            TextView cv1 = miItem.findViewById(R.id.cv_fondo_1);
            cv1.setText(dato.getNom_fondo().getNombre());

            LineChartView lineChartView = miItem.findViewById(R.id.lineChart);

            int[] axisData = {1,3,5};
            Float[] yAxisData = {dato.getNom_fondo().getAno5(), dato.getNom_fondo().getAno3(), dato.getNom_fondo().getAno1()};

            List yAxisValues = new ArrayList();
            List axisValues = new ArrayList();

            Line line = new Line(yAxisValues).setColor(Color.parseColor("#9C27B0"));;

            for(int i = 0; i < axisData.length; i++){
                axisValues.add(i, new AxisValue(i).setLabel(String.valueOf(axisData[i])));
            }

            for (int i = 0; i < yAxisData.length; i++){
                yAxisValues.add(new PointValue(i, yAxisData[i]));
            }

            List lines = new ArrayList();
            lines.add(line);

            LineChartData dataG = new LineChartData();
            dataG.setLines(lines);

            Axis axis = new Axis();
            axis.setValues(axisValues);
            axis.setName("Años");
            axis.setTextSize(10);
            axis.setTextColor(Color.parseColor("#03A9F4"));
            dataG.setAxisXBottom(axis);

            Axis yAxis = new Axis();
            yAxis.setName("Rentabilidad");
            yAxis.setTextColor(Color.parseColor("#03A9F4"));
            yAxis.setTextSize(10);
            dataG.setAxisYLeft(yAxis);

            lineChartView.setLineChartData(dataG);
        }
    }
}
