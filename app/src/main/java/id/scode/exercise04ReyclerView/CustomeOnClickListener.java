package id.scode.exercise04ReyclerView;

import android.view.View;

/**
 * Created by Dani on 12/23/2018.
 * Yogi Arif Widodo
 */

public class CustomeOnClickListener implements View.OnClickListener
{
    private int position;
    private OnItemClickCallBack onItemClickCallBack;

    public CustomeOnClickListener(int position, OnItemClickCallBack onItemClickCallBack)
    {
        this.position = position;
        this.onItemClickCallBack = onItemClickCallBack;
    }


    @Override
    public void onClick(View view)
    {
        onItemClickCallBack.onItemClicked(view, position);
    }

    public interface OnItemClickCallBack
    {
        void onItemClicked(View view, int postition);
    }
}
