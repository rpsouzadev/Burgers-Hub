package com.example.burgershub.presenter.burgers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.burgershub.data.model.Exceptions.ErrorResponse
import com.example.burgershub.domain.useCase.GetBurgerByNameUseCase
import com.example.burgershub.domain.useCase.GetBurgersUseCase
import com.example.burgershub.util.StateView
import com.example.burgershub.util.getErrorResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class BurgerViewModel @Inject constructor(
  private val getBurgersUseCase: GetBurgersUseCase,
  private val getBurgerByNameUseCase: GetBurgerByNameUseCase,
) : ViewModel() {

  fun getBurgers() = liveData(Dispatchers.IO) {
    try {
      emit(StateView.Loading())

      val burgers = getBurgersUseCase()

      emit(StateView.Success(data = burgers))
    } catch (ex: HttpException) {
      ex.printStackTrace()
      val error = ex.getErrorResponse<ErrorResponse>()

      emit(StateView.Error(message = error?.message))
    } catch (ex: Exception) {
      ex.printStackTrace()
      emit(StateView.Error(message = ex.message))
    }
  }

  fun getBurgerByName(burgerName: String) = liveData(Dispatchers.IO) {
    try {
      emit(StateView.Loading())

      val burgers = getBurgerByNameUseCase(burgerName)

      emit(StateView.Success(data = burgers))
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