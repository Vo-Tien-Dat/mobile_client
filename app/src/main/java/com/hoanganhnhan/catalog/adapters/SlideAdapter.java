package com.hoanganhnhan.catalog.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.hoanganhnhan.catalog.R;
import com.hoanganhnhan.catalog.models.Slider;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SlideAdapter extends RecyclerView.Adapter<SlideAdapter.SliderViewHolder>{
    private List<Slider> sliders;
    private ViewPager2 viewPager2;

    public SlideAdapter(List<Slider> sliders, ViewPager2 viewPager2) {
        this.sliders = sliders;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.view_holder_slide,parent,false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setImage(sliders.get(position));
        if(position == sliders.size()-2){
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return sliders.size();
    }

    public class SliderViewHolder extends RecyclerView.ViewHolder{
        private RoundedImageView imageView;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageSlide);
        }
        void setImage(Slider slide){
            imageView.setImageResource(slide.getResourseId());
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            sliders.addAll(sliders);
            notifyDataSetChanged();
        }
    };
}