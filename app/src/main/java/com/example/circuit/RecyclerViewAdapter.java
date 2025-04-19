package com.example.circuit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {

    private Context mContext;
    private List<Circuits> mData;
    private List<Circuits> mDataFull;
    TextView noMatchText;

    public RecyclerViewAdapter(Context mContext, List<Circuits> mData, TextView noMatchText) {
        this.mContext = mContext;
        this.mData = mData;
        this.mDataFull = new ArrayList<>(mData);
        this.noMatchText = noMatchText;

        SharedPreferences prefs = mContext.getSharedPreferences("favorites", Context.MODE_PRIVATE);
        for (Circuits circuit : this.mData) {
            boolean isFavorite = prefs.getBoolean(circuit.getCircuitName(), false);
            circuit.setFavorite(isFavorite);
        }
    }
    public Filter getFilter() {
        return circuitFilter;
    }

    private Filter circuitFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Circuits> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mDataFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Circuits item : mDataFull) {
                    if (item.getCircuitName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mData.clear();
            mData.addAll((List<Circuits>) results.values);
            notifyDataSetChanged();

            // Show or hide "No match found"
            if (noMatchText != null) {
                if (mData.isEmpty()) {
                    noMatchText.setVisibility(View.VISIBLE);
                } else {
                    noMatchText.setVisibility(View.GONE);
                }
            }
        }
    };

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_circuit,viewGroup,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        myHolder.circuitTitle.setText(mData.get(i).getCircuitName());
        myHolder.img_circuit_thumbnail.setImageResource(mData.get(i).getThumbnail());
        myHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = myHolder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Intent intent = new Intent(mContext, CircuitActivity.class);
                    intent.putExtra("CircuitName", mData.get(position).getCircuitName());
                    intent.putExtra("CircuitComponents", mData.get(position).getCircuitComponents());
                    intent.putExtra("CircuitMethodTitle", mData.get(position).getCircuitMethodTitle());
                    intent.putExtra("Circuit", mData.get(position).getCircuit());

                    mContext.startActivity(intent);
                }
            }
        });

        myHolder.circuitTitle.setText(mData.get(i).getCircuitName());
        myHolder.img_circuit_thumbnail.setImageResource(mData.get(i).getThumbnail());

// Set heart icon based on favorite status
        if (mData.get(i).isFavorite()) {
            myHolder.favoriteIcon.setImageResource(R.drawable.ic_favorite); // filled heart
        } else {
            myHolder.favoriteIcon.setImageResource(R.drawable.ic_favorite_border); // empty heart
        }

// Handle favorite toggle
        myHolder.favoriteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = myHolder.getAdapterPosition();
                Circuits recipe = mData.get(position);
                recipe.setFavorite(!recipe.isFavorite()); // toggle state

                // Update icon
                if (recipe.isFavorite()) {
                    myHolder.favoriteIcon.setImageResource(R.drawable.ic_favorite);
                } else {
                    myHolder.favoriteIcon.setImageResource(R.drawable.ic_favorite_border);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView circuitTitle;
        CardView cardView;
        ImageView img_circuit_thumbnail;
        ImageView favoriteIcon;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            circuitTitle = (TextView) itemView.findViewById(R.id.text_circuit);
            img_circuit_thumbnail = (ImageView)itemView.findViewById(R.id.circuit_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardView_id);
            favoriteIcon = itemView.findViewById(R.id.favorite_icon);
        }
    }
}
