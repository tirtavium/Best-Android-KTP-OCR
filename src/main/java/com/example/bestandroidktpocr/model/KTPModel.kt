
import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize
import org.json.JSONObject

@Parcelize
public data class KTPModel(
    var nik: String? = null,
    var nama: String? = null,
    var tempatLahir: String? = null,
    var golDarah: String? = null,
    var tglLahir: String? = null,
    var jenisKelamin: String? = null,
    var alamat: String? = null,
    var rtrw: String? = null,
    var kelurahan: String? = null,
    var kecamatan: String? = null,
    var agama: String? = null,
    var statusPerkawinan: String? = null,
    var pekerjaan: String? = null,
    var kewarganegaraan: String? = null,
    var berlakuHingga: String? = null,
    var provinsi: String? = null,
    var kabKot: String? = null,
    var confidence: Int = 0,
    var bitmap: Bitmap? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readParcelable(Bitmap::class.java.classLoader)
    ) {
    }

    fun toJson(): String {
        val mutableMap = mutableMapOf<String, Any?>()
        mutableMap["nik"] = nik
        mutableMap["nama"] = nama
        mutableMap["tempatLahir"] = tempatLahir
        mutableMap["golDarah"] = golDarah
        mutableMap["tglLahir"] = tglLahir
        mutableMap["jenisKelamin"] = jenisKelamin
        mutableMap["alamat"] = alamat
        mutableMap["rtrw"] = rtrw
        mutableMap["kelurahan"] = kelurahan
        mutableMap["kecamatan"] = kecamatan
        mutableMap["agama"] = agama
        mutableMap["statusPerkawinan"] = statusPerkawinan
        mutableMap["pekerjaan"] = pekerjaan
        mutableMap["kewarganegaraan"] = kewarganegaraan
        mutableMap["berlakuHingga"] = berlakuHingga
        mutableMap["provinsi"] = provinsi
        mutableMap["kabKot"] = kabKot
        mutableMap["confidence"] = confidence

        val json = JSONObject(mutableMap)
        return json.toString()
    }

    companion object : Parceler<KTPModel> {

        override fun KTPModel.write(parcel: Parcel, flags: Int) {
            parcel.writeString(nik)
            parcel.writeString(nama)
            parcel.writeString(tempatLahir)
            parcel.writeString(golDarah)
            parcel.writeString(tglLahir)
            parcel.writeString(jenisKelamin)
            parcel.writeString(alamat)
            parcel.writeString(rtrw)
            parcel.writeString(kelurahan)
            parcel.writeString(kecamatan)
            parcel.writeString(agama)
            parcel.writeString(statusPerkawinan)
            parcel.writeString(pekerjaan)
            parcel.writeString(kewarganegaraan)
            parcel.writeString(berlakuHingga)
            parcel.writeString(provinsi)
            parcel.writeString(kabKot)
            parcel.writeInt(confidence)
            parcel.writeParcelable(bitmap, flags)
        }

        override fun create(parcel: Parcel): KTPModel {
            return KTPModel(parcel)
        }
    }
}
