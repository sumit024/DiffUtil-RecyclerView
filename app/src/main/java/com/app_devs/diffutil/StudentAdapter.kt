package com.app_devs.diffutil

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app_devs.diffutil.databinding.ItemRowBinding

class StudentAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var oldList=ArrayList<Student>()
    class MyViewHolder(val binding: ItemRowBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
      if(holder is MyViewHolder)
      {
          val model=oldList[position]
          holder.binding.tvAge.text=model.age.toString()
          holder.binding.tvName.text=model.name
      }
    }

    override fun getItemCount(): Int {
       return oldList.size
    }

    var count=0;
    fun setData(newStudentList:ArrayList<Student>)
    {
        val diffUtil=StudentDiffUtil(oldList,newStudentList)
        val diffResult=DiffUtil.calculateDiff(diffUtil)
        Log.d("SUMIT old",oldList.toString())
        Log.d("SUMIT new",newStudentList.toString())
        oldList.clear()
        oldList.addAll(newStudentList)
        Log.d("SUMIT old",oldList.toString())
        diffResult.dispatchUpdatesTo(this)
        count++;
        Log.d("SUMIT","setData executed $count times")
    }
}