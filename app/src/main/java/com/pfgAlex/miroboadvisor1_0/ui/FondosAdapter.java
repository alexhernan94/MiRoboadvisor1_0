package com.pfgAlex.miroboadvisor1_0.ui;

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


            LineChart lineChart = miItem.findViewById(R.id.lineChart);
            LineDataSet lineDataSet = new LineDataSet(lineChartDataSet(), dato.getNom_fondo().toString());
            ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
            iLineDataSets.add(lineDataSet);

            LineData lineData = new LineData();
            lineChart.setData(lineData);
            lineChart.invalidate();
        }

        public ArrayList<Entry> lineChartDataSet(){
            Carteras dato = new Carteras();
            ArrayList<Entry> dataSet = new ArrayList<>();

            Double valor1 = -0.3449000120162964;
            //Double valor2 = dato.getNom_fondo().getAno1();

            /*System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(valor1);
            System.out.println("-----------------------------------------------");
            System.out.println(valor2.floatValue());*/


            //System.out.println(dato.getNom_fondo().getAno3().toString());
            //System.out.println(dato.getNom_fondo().getAno5().toString());

            /*dataSet.add(new Entry(Float.parseFloat(String.valueOf(-0.3449000120162964)),Float.parseFloat(String.valueOf(-0.3449000120162964))));
            dataSet.add(new Entry(Float.parseFloat(String.valueOf(-0.1339000016450882)),Float.parseFloat(String.valueOf(-0.1339000016450882))));
            dataSet.add(new Entry(Float.parseFloat(String.valueOf(0.0)),Float.parseFloat(String.valueOf(0.0))));*/

            /*dataSet.add(new Entry(dato.getNom_fondo().getAno1(), dato.getNom_fondo().getAno1()));
            dataSet.add(new Entry(dato.getNom_fondo().getAno3(), dato.getNom_fondo().getAno3()));
            dataSet.add(new Entry(dato.getNom_fondo().getAno5(), dato.getNom_fondo().getAno5()));*/

            return dataSet;
        }
    }
}
