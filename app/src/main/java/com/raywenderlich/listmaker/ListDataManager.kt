package com.raywenderlich.listmaker

import android.content.Context
import android.preference.PreferenceManager

class ListDataManager(private val context: Context) {


    fun readLists(): ArrayList<TaskList> {
        // 1
        val sharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)
        // 2
        val sharedPreferenceContents = sharedPreferences.all
        // 3
        val taskLists = ArrayList<TaskList>()
        // 4
        for (taskList in sharedPreferenceContents) {
            val itemsHashSet = ArrayList(taskList.value as HashSet<String>)
            val list = TaskList(taskList.key, itemsHashSet)
            // 5
            taskLists.add(list)
        }
        // 6
        return taskLists
    }

    fun saveList(list: TaskList) {
        // Allow writing key values pairs to SharedPreferences
        val sharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context).edit()
        // Write TaskList to SharedPreferences
        sharedPreferences.putStringSet(list.name,
            list.tasks.toHashSet())
        // Instruct to apply changes- write changes to Listmakers SharedPreferences file
        sharedPreferences.apply()
    }
}