package id.scode.exercise04ReyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
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

public class AdapterListPresident extends RecyclerView.Adapter<AdapterListPresident.CategoryViewHolder>
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

    AdapterListPresident(Context context)
    {
        this.context = context;
    }

    @NonNull
    @Override
//    <!-- viewGroup = parent -->
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_president, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
//    categoryViewHolder = holder
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position)
    {
        categoryViewHolder.tvName.setText(getListPresident().get(position).getName());
        categoryViewHolder.tvRemarks.setText(getListPresident().get(position).getRemarks());

        Glide.with(context)
                .load(getListPresident().get(position).getPhotos())
                .apply(new RequestOptions().override(55,55))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListPresident().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;

        CategoryViewHolder(@NonNull View itemView)
        {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.item_photo);
        }
    }
}
