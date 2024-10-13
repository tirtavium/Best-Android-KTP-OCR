package com.example.bestandroidktpocr

import OCRforEKTPLibrary
import android.graphics.BitmapFactory
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.bestandroidktpocr", appContext.packageName)
    }

    @Test
    fun testKTP(){
        val ktpScanner = OCRforEKTPLibrary()
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val bitmap = BitmapFactory.decodeResource(appContext.resources,R.drawable.ktp_sample)
        var result = ktpScanner.scanEKTP(bitmap)

        print(result.toJson())
        assertEquals("3171234567890123", result.nik)
        assertEquals("MIRA SETIAWAN", result.nama)

        assertEquals("PEREMPUAN", result.jenisKelamin)
        assertEquals("DKI JAKARTA", result.provinsi)


        assertEquals("WNI", result.kewarganegaraan)
        assertEquals("ISLAM", result.agama)
        assertEquals("KAWIN", result.statusPerkawinan)
        assertEquals("KALIDERES", result.kecamatan)
        assertEquals("PEGADUNGAN", result.kelurahan)
        assertEquals("JAKARTA BARAT", result.kabKot)
        assertEquals("PEGAWAI SWASTA", result.pekerjaan)

        assertEquals("007/008", result.rtrw)
        assertEquals("JAKARTA", result.tempatLahir)
        assertEquals("18-02-1986", result.tglLahir)
    }
}