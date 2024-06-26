package ru.practicum.android.diploma.data.converters.db.logo

import androidx.room.TypeConverter
import com.google.gson.Gson
import ru.practicum.android.diploma.domain.models.LogoUrls

object LogoUrlsDbConverter {

    @TypeConverter
    fun toLogoUrlsEntity(logoUrls: LogoUrls?): String {
        return Gson().toJson(logoUrls)
    }

    @TypeConverter
    fun fromLogoUrlsEntity(data: String?): LogoUrls? {
        return Gson().fromJson(data, LogoUrls::class.java)
    }
}
