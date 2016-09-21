package com.example.shekhar.locationalert.ui.fragment.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import com.example.shekhar.locationalert.Revisitor;
import com.example.shekhar.locationalert.entity.LocationPlace;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shekhar Timsina on 9/01/2016.
 */
public class PreviousPlacesAdapter extends ArrayAdapter<LocationPlace> {

    private List<LocationPlace> places;
    private Context mContext;

    public PreviousPlacesAdapter(Context context) {
        super(context, android.R.layout.simple_list_item_1);
        this.places = Revisitor.getInstance(context).getAllPlaces();
        this.mContext = context.getApplicationContext();
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }


    final private Filter mFilter = new Filter() {

        @Override
        public String convertResultToString(Object resultValue) {
            return resultValue.toString();
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null) {
                ArrayList<LocationPlace> suggestions = new ArrayList<LocationPlace>();
                for (LocationPlace customer : places) {
                    // Note: change the "contains" to "startsWith" if you only want starting matches
                    if (customer.toString().toLowerCase().startsWith(
                            constraint.toString().toLowerCase())) {
                        suggestions.add(customer);
                    }
                }

                results.values = suggestions;
                results.count = suggestions.size();
            }

            return results;
        }


        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clear();
            if (results != null && results.count > 0) {
                // we have filtered results
                addAll((ArrayList<LocationPlace>) results.values);
            }
            notifyDataSetChanged();
        }
    };

    /**
     * Refreshes the places from the {@linkplain com.example.shekhar.locationalert.Revisitor}
     */
    public void refreshPlaces() {
        clear();
        this.places = Revisitor.getInstance(mContext).getAllPlaces();
    }
}
