import android.annotation.SuppressLint
import android.graphics.Bitmap
import com.google.android.gms.tasks.Tasks
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions


class OCRforEKTPLibrary {

    private val textRecognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

    @SuppressLint("UnsafeOptInUsageError")
    fun scanEKTP(image: Bitmap): KTPModel {
        val imageSource = image.let {
            InputImage.fromBitmap(it, 0)
        }
        val task = textRecognizer.process(imageSource)
        val result = Tasks.await(task)
        val ktpResult = result.extractEktp()
        return ktpResult
    }

}