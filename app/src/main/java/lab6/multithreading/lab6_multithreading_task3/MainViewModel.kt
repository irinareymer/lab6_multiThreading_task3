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
    private val bitmap = MutableLiveData<Bitmap>()

    fun downloadImage(URL: URL): MutableLiveData<Bitmap> {
        viewModelScope.launch(Dispatchers.IO) {
            val mIconVal = BitmapFactory.decodeStream(URL.openConnection().getInputStream())
            viewModelScope.launch(Dispatchers.Main) {
                bitmap.value = mIconVal
            }
        }
        return bitmap
    }
}