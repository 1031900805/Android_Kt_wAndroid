package com.example.module_video.recommend

import androidx.lifecycle.MutableLiveData
import com.example.common_base.base.data.BaseResult
import com.example.common_base.base.viewmodel.BaseViewModel
import com.example.common_base.base.viewmodel.SuccessState
import com.example.module_video.data.OpenEyeRepository
import com.example.module_video.recommend.bean.OpenRecBean

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/15
 *  description :
 */
class OpenEyeViewModel(
    private val repository: OpenEyeRepository
) : BaseViewModel() {

    /**
     * 推荐数据
     */
    val recommentData: MutableLiveData<MutableList<OpenRecBean>> by lazy {
        MutableLiveData<MutableList<OpenRecBean>>()
    }

    val recommentMoreDatas: MutableLiveData<MutableList<OpenRecBean>> by lazy {
        MutableLiveData<MutableList<OpenRecBean>>()
    }

    val recommentListData = mutableListOf<OpenRecBean>()
    val recommentMoreListDatas = mutableListOf<OpenRecBean>()

    fun getRecommendData(isRefresh: Boolean = false) {
        if(isRefresh){
            recommentListData.clear()
            recommentMoreListDatas.clear()
        }
        launch(tryBlock = {
            repository.getRecommend(isRefresh).let {
                if (it is BaseResult.Success) {
                    it.data.let { list ->
                        list?.let {
                            if(!isRefresh){
                                recommentMoreListDatas.addAll(list)
                                recommentMoreDatas.value = recommentMoreListDatas
                            }else{
                                recommentListData.addAll(list)
                                recommentData.value = recommentListData
                            }
                        }
                    }
                    mStateLiveData.value = SuccessState
                }
            }
        })
    }
}