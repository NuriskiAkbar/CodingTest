package com.rhiquest.mohnuriskiakbar_codingtestapp.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class ResponseGetItemDetail(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("completed")
	val completed: Boolean? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("userId")
	val userId: Int? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as? Int
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeValue(id)
		parcel.writeValue(completed)
		parcel.writeString(title)
		parcel.writeValue(userId)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<ResponseGetItemDetail> {
		override fun createFromParcel(parcel: Parcel): ResponseGetItemDetail {
			return ResponseGetItemDetail(parcel)
		}

		override fun newArray(size: Int): Array<ResponseGetItemDetail?> {
			return arrayOfNulls(size)
		}
	}
}
