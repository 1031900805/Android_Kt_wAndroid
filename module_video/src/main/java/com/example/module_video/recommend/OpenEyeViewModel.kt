package com.example.module_video.recommend

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.common_base.base.data.BaseResult
import com.example.common_base.base.data.viewmodel.BaseViewModel
import com.example.common_base.base.data.viewmodel.ErrorState
import com.example.common_base.base.data.viewmodel.SuccessState
import com.example.module_video.data.OpenEyeRepository
import com.example.module_video.data.OpenRecBean
import kotlinx.coroutines.launch

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

    //处理异常
    fun getRecommendData() {
        launch(tryBlock = {
            repository.getRecommend().let {
                if (it is BaseResult.Success) {
                    recommentData.value = it.data
                    mStateLiveData.value = SuccessState
                }
            }
        })
    }
}