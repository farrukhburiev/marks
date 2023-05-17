package com.example.marks.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.marks.R
import com.example.marks.entity.Student

class AdapterStudent(val list: List<Student>, var listener: AdapterStudent.ItemClick): RecyclerView.Adapter<AdapterStudent.MyHolder>() {

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var cardView = itemView.findViewById<CardView>(R.id.cardView)
        //        var img = itemView.findViewById<ImageView>(R.id.subject_img)

        var name = itemView.findViewById<TextView>(R.id.student_name)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var itemView = MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false))
        return itemView
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var item = list.get(position)
        holder.name.text = item.name_student


        holder.cardView.setOnClickListener {
            listener.OnItemClick(position)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface ItemClick {
        fun OnItemClick(
            position: Int
        )
    }
}
