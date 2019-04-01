package vladus177.ru.placesexample.places.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import vladus177.ru.placesexample.R;
import vladus177.ru.placesexample.places.view.listener.ItemClickListener;
import vladus177.ru.placesexample.places.view.listener.OnLoadPlacesListener;
import vladus177.ru.placesexample.places.view.viewmodel.PlacesResultView;

public class PlaceListAdapter extends RecyclerView.Adapter<PlaceListAdapter.ViewHolder> {
    private OnLoadPlacesListener listener;
    private ItemClickListener itemClickListener;
    private boolean isLoading;
    private boolean stopLoad;
    private int totalItemCount;
    private int lastVisibleItem;
    private final static int VISIBLE_THRESHOLD = 2;

    private List<PlacesResultView> placesList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView placeName, placeDistance, placeRating, placeType, placeAddress, placeDescription;
        ImageView placeIcon;
        public View layout;

        ViewHolder(View v) {
            super(v);
            layout = v;
            placeName = v.findViewById(R.id.textview_title);
            placeDistance = v.findViewById(R.id.textview_distance);
            placeRating = v.findViewById(R.id.textview_rating);
            placeType = v.findViewById(R.id.textview_type);
            placeAddress = v.findViewById(R.id.textview_address);
            placeDescription = v.findViewById(R.id.textview_desription);
            placeIcon = v.findViewById(R.id.imageview_icon);
        }
    }

    @Inject
    public PlaceListAdapter() {
        initAdapter();
    }

    private void initAdapter() {
        placesList = new ArrayList<>();
        isLoading = true;
        stopLoad = false;
        lastVisibleItem = 0;
        totalItemCount = 0;
    }

    @NonNull
    @Override
    public PlaceListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                          int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.view_place_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final PlacesResultView place = placesList.get(position);
        holder.placeName.setText(place.name);
        holder.placeAddress.setText(place.vicinity);
        holder.placeDescription.setText("Description");
        holder.placeDistance.setText("set distance");
        holder.placeRating.setText(place.rating);
        holder.placeType.setText(place.ratingTotal);
    }

    @Override
    public int getItemCount() {
        return placesList.size();
    }

    public void onNewDataReceived(List<PlacesResultView> placesResultViews) {
        if (placesResultViews != null && placesResultViews.size() > 0) {
            placesList.addAll(placesResultViews);
            isLoading = false;
            notifyDataSetChanged();
        }
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (!stopLoad && !isLoading && totalItemCount <= (lastVisibleItem + VISIBLE_THRESHOLD)) {
                    if (listener != null) {
                        listener.onLoadMorePlacess();
                    }
                }
            }
        });
    }

    public void setOnLoadMorePlacesListener(OnLoadPlacesListener listener) {
        this.listener = listener;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void noNoreItemsRemain() {
        stopLoad = true;
        notifyDataSetChanged();
    }

}