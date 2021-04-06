package com.raywenderlich.listmaker

import android.os.Parcel
import android.os.Parcelable

class TaskList constructor(val name: String, val tasks:
ArrayList<String> = ArrayList()) : Parcelable {

        // Create a constructor to read from parcel
        constructor(source: Parcel) : this(
                source.readString()!!,
                source.createStringArrayList()!!
        )
        override fun describeContents() = 0
        // Method for writing to parcel- use write functions
        override fun writeToParcel(dest: Parcel, flags: Int) {
                dest.writeString(name)
                dest.writeStringList(tasks)
        }
        // Static interface requirements
        companion object CREATOR: Parcelable.Creator<TaskList> {
                // Call constructor
                override fun createFromParcel(source: Parcel): TaskList =
                        TaskList(source)
                override fun newArray(size: Int): Array<TaskList?> =
                        arrayOfNulls(size)
        }

}