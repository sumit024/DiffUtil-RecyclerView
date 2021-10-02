package com.app_devs.diffutil

import androidx.recyclerview.widget.DiffUtil

class StudentDiffUtil(private val oldList:ArrayList<Student>, private val newList:ArrayList<Student>):DiffUtil.Callback() {
    override fun getOldListSize(): Int =oldList.size

    override fun getNewListSize(): Int =newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (oldList[oldItemPosition].id == newList[newItemPosition].id)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].id != newList[newItemPosition].id->false
            oldList[oldItemPosition].name != newList[newItemPosition].name->false
            oldList[oldItemPosition].age != newList[newItemPosition].age->false
            else->true
        }
    }
}