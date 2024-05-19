package com.example.burgershub.presenter.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.burgershub.data.model.Exceptions.ErrorResponse
import com.example.burgershub.domain.useCase.GetBurgerByIdUseCase
import com.example.burgershub.util.StateView
import com.example.burgershub.util.getErrorResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
  private val getBurgerByIdUseCase: GetBurgerByIdUseCase
) : ViewModel() {

  fun getBurgerById(burgerId: Int) = liveData(Dispatchers.IO) {
    try {
      emit(StateView.Loading())

      val burger = getBurgerByIdUseCase(burgerId)

      emit(StateView.Success(data = burger))
    } catch (ex: HttpException) {
      ex.printStackTrace()
      val error = ex.getErrorResponse<ErrorResponse>()

      emit(StateView.Error(message = error?.message))
    } catch (ex: Exception) {
      ex.printStackTrace()
      emit(StateView.Error(message = ex.message))
    }
  }
}