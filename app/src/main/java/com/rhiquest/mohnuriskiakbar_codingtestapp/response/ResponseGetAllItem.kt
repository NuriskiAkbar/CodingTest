package com.rhiquest.mohnuriskiakbar_codingtestapp.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class ResponseGetAllItem(

	@field:SerializedName("ResponseGetAllItem")
	val responseGetAllItem: List<ResponseGetAllItemItem?>? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(parcel.createTypedArrayList(ResponseGetAllItemItem.CREATOR)) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeTypedList(responseGetAllItem)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<ResponseGetAllItem> {
		override fun createFromParcel(parcel: Parcel): ResponseGetAllItem {
			return ResponseGetAllItem(parcel)
		}

		override fun newArray(size: Int): Array<ResponseGetAllItem?> {
			return arrayOfNulls(size)
		}
	}
}

data class ResponseGetAllItemItem(

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

	companion object CREATOR : Parcelable.Creator<ResponseGetAllItemItem> {
		override fun createFromParcel(parcel: Parcel): ResponseGetAllItemItem {
			return ResponseGetAllItemItem(parcel)
		}

		override fun newArray(size: Int): Array<ResponseGetAllItemItem?> {
			return arrayOfNulls(size)
		}
	}
}
