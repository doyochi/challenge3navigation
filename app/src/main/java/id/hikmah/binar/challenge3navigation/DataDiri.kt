package id.hikmah.binar.challenge3navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataDiri(
    val usia: Int?,
    val alamat: String?,
    val pekerjaan: String?
): Parcelable
