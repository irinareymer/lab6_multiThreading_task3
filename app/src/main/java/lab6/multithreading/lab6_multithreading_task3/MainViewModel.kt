package lab6.multithreading.lab6_multithreading_task3

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class MainViewModel: ViewModel() {
    val bitmap = MutableLiveData<Bitmap>()

    fun downloadImage(URL: URL) {
        viewModelScope.launch(Dispatchers.IO) {
            val mIconVal = BitmapFactory.decodeStream(URL.openConnection().getInputStream())
            bitmap.postValue(mIconVal)
        }
    }
}