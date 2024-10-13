

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.json.JSONObject


@Parcelize
data class OCRResultModel(
    val isSuccess: Boolean,
    val errorMessage: String?,
    val imagePath: String? = null,
    val ktp: KTPModel
) : Parcelable {


    fun toJson(): String {
        val mutableMap = mutableMapOf<String, Any?>()
        mutableMap["isSuccess"] = isSuccess
        mutableMap["errorMessage"] = errorMessage
        mutableMap["imagePath"] = imagePath
        mutableMap["ktp"] = JSONObject(ktp.toJson())

        val json = JSONObject(mutableMap)

        return json.toString()
    }
}