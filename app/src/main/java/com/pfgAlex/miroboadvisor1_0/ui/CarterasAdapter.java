package com.pfgAlex.miroboadvisor1_0.ui;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.pfgAlex.miroboadvisor1_0.Carteras;
import com.pfgAlex.miroboadvisor1_0.R;

import java.util.List;

public class CarterasAdapter extends RecyclerView.Adapter<CarterasAdapter.CarteraViewHolder> {

    final List<Carteras> datos;

    CarterasAdapter(List<Carteras> carteras) {
        datos = carteras;
    }

    @NonNull
    @Override
    public CarteraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.activity_cardview, parent, false);
        return new CarteraViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CarteraViewHolder holder, int position) {
        Carteras dato = datos.get(position);
        holder.bind(dato);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    static class CarteraViewHolder extends ViewHolder{
        View miItem;
        public CarteraViewHolder(@NonNull View itemView) {
            super(itemView);
            miItem = itemView;
        }

        public void bind(Carteras dato){
            TextView cv1 = miItem.findViewById(R.id.cv_1);
            cv1.setText(dato.getNom_cartera());
            TextView cv2 = miItem.findViewById(R.id.cv_2);
            cv2.setText(dato.getNom_fondo().getNombre());
            TextView cv3 = miItem.findViewById(R.id.cv_3);
            cv3.setText(dato.getNom_fondo().getCategoria());
            TextView cv4 = miItem.findViewById(R.id.cv_4);
            cv4.setText("Riesgo: " + dato.getNom_fondo().getRiesgo());
            TextView cv5 = miItem.findViewById(R.id.cv_5);
            cv5.setText("IMI: " + dato.getNom_fondo().getIMI().toString() + "€");
        }
    }
}
