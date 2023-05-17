package com.example.marks.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.marks.R
import com.example.marks.entity.Subject
import com.example.marks.entity.TeacherSubject

class AdapterSubject(val list: List<Subject>, var listener: AdapterSubject.ItemClick): RecyclerView.Adapter<AdapterSubject.MyHolder>() {

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var cardView = itemView.findViewById<CardView>(R.id.cardView)
        //        var img = itemView.findViewById<ImageView>(R.id.subject_img)
        var teacher = itemView.findViewById<TextView>(R.id.teacher_name)
        var name = itemView.findViewById<TextView>(R.id.subject_name)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var itemView = MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.subject_item, parent, false))
        return itemView
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var item = list.get(position)
        holder.name.text = item.subject_name




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
