package ir.avarsaji.crypto.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.*
import javax.inject.Inject

import ir.avarsaji.crypto.application.ApplicationCore


@HiltViewModel
class ActivityMainViewModel @Inject constructor(
    private val app: ApplicationCore
) : AndroidViewModel(app) {
    private val errorMessage: MutableLiveData<String> = MutableLiveData()
    private val usaText: MutableLiveData<String> = MutableLiveData()
    private val canadaText: MutableLiveData<String> = MutableLiveData()
    private val emiratesText: MutableLiveData<String> = MutableLiveData()
    private val englandText: MutableLiveData<String> = MutableLiveData()


    fun getErrorMessageObserver(): MutableLiveData<String> {
        return errorMessage
    }

    private fun setErrorMessage(errorText: String) {
        errorMessage.postValue(errorText)
    }

    fun getUsaTextObserver(): MutableLiveData<String> {
        return usaText
    }

    fun setUsaText(errorText: String) {
        usaText.postValue(errorText)
    }

    fun getCanadaTextObserver(): MutableLiveData<String> {
        return canadaText
    }

    fun setCanadaText(errorText: String) {
        canadaText.postValue(errorText)
    }

    fun getEnglandTextObserver(): MutableLiveData<String> {
        return englandText
    }

    fun setEnglandText(errorText: String) {
        englandText.postValue(errorText)
    }

    fun getEmiratesTextObserver(): MutableLiveData<String> {
        return emiratesText
    }

    fun setEmiratesText(errorText: String) {
        emiratesText.postValue(errorText)
    }
}
