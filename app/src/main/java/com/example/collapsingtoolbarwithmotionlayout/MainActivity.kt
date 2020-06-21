package com.example.collapsingtoolbarwithmotionlayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.my_text_view.view.*

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val adapter = MyAdapter(
      arrayOf(
        "1 day",
        "2 day",
        "3 day",
        "4 day",
        "5 day",
        "6 day",
        "7 day",
        "8 day",
        "9 day",
        "10 day",
        "11 day",
        "12 day"
      )
    )
    recyclerview.apply {
      layoutManager = LinearLayoutManager(this@MainActivity)
      this.adapter = adapter
      setHasFixedSize(true)
    }
  }
}

class MyAdapter(private val data: Array<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    val view =
      LayoutInflater.from(parent.context).inflate(R.layout.my_text_view, parent, false)
    return MyViewHolder(view)
  }

  override fun getItemCount(): Int {
    return data.size
  }

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    holder.view.textView.text = data[position]
  }

  class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}