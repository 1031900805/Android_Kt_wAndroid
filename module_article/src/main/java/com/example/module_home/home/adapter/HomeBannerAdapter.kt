package com.example.module_home.home.adapter

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.common_base.widget.GlideRoundTransform
import com.example.module_home.R
import com.example.module_home.home.bean.BannerBean
import com.youth.banner.adapter.BannerAdapter

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/2
 *  description :
 */
class HomeBannerAdapter(val context: Context, data: MutableList<BannerBean>?) :
    BannerAdapter<BannerBean, HomeBannerAdapter.ViewHolder>(data) {

    class ViewHolder(@param:NonNull var imageView: ImageView) :
        RecyclerView.ViewHolder(imageView)

    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val imageView = ImageView(parent!!.context)
        imageView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP;
        return ViewHolder(imageView)
    }

    override fun onBindView(holder: ViewHolder?, data: BannerBean?, position: Int, size: Int) {
        Glide.with(holder!!.itemView)
            .load(data!!.imagePath)
            .placeholder(R.drawable.img_def)
            .transform(GlideRoundTransform(context))
            .into(holder.imageView)
    }
}