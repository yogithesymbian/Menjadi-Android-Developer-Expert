package id.scode.exercise04ReyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import id.scode.scholarshipexpertscodeidev.R;

import java.util.ArrayList;

/**
 * Created by Dani on 12/23/2018.
 * Yogi Arif Widodo
 */

public class AdapterGridPresident extends RecyclerView.Adapter<AdapterGridPresident.GridViewHolder>
{

    private Context context;

    private ArrayList<Presiden> getListPresident()
    {
        return listPresident;
    }

    void setListPresident(ArrayList<Presiden> listPresident)
    {
        this.listPresident = listPresident;
    }

    private ArrayList<Presiden> listPresident;

    AdapterGridPresident(Context context)
    {
        this.context = context;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_president, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder gridViewHolder, int position) {
        Glide.with(context)
                .load(getListPresident().get(position).getPhotos())
                .apply(new RequestOptions().override(350, 550))
                .into(gridViewHolder.imgPhoto);

    }

    @Override
    public int getItemCount() {
        return getListPresident().size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPhoto;

        GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.item_photo_grid);
        }
    }
}
