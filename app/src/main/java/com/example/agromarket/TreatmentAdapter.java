package com.example.agromarket;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agromarket.network.dto.model.TreatmentDto;

import java.util.ArrayList;

public class TreatmentAdapter extends RecyclerView.Adapter<TreatmentAdapter.ViewHolder>{

    private ArrayList<TreatmentDto> localDataSet;
    private Fragment fragment;
    private String instruction;



    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        Context context;
        TextView treatmentId;
        TextView treatmentName;
        Button btnInstruccions;
        Fragment fragment;
        String instructions;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            context = view.getContext();
            treatmentId = (TextView) view.findViewById(R.id.treatmentId);
            treatmentName = (TextView) view.findViewById(R.id.treatmentName);
            btnInstruccions = (Button) view.findViewById(R.id.btn_instruccions);
        }
        void setOnClickListeners(Fragment fragmentt,String instruction){
            fragment= fragmentt;
            instructions = instruction;
            btnInstruccions.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Bundle bundle = new Bundle();
            bundle.putString("instructions",instructions);
            NavHostFragment.findNavController(fragment).navigate(R.id.action_thirdFragment_to_fourFragment,bundle);
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public TreatmentAdapter(ArrayList<TreatmentDto> dataSet, Fragment fragmentt) {
        fragment = fragmentt;
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.treatments, viewGroup, false);

        return new ViewHolder(view);
    }



    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.treatmentId.setText(localDataSet.get(position).getId());
        viewHolder.treatmentName.setText(localDataSet.get(position).getName());
        instruction = localDataSet.get(position).getInstructions();
        viewHolder.setOnClickListeners(fragment,localDataSet.get(position).getInstructions());
    }



    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
