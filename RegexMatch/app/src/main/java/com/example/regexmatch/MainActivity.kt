package com.example.regexmatch

import android.app.Activity
import android.os.Bundle
import android.util.Log


import android.widget.Toast
import com.lorentzos.flingswipe.SwipeFlingAdapterView
import java.util.*

class MainActivity : Activity() {
    private var al: ArrayList<String>? = null

    private var i = 0
    private lateinit var flingContainer: SwipeFlingAdapterView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        al = ArrayList()
        al!!.add("php")
        al!!.add("c")
        al!!.add("python")
        al!!.add("java")
        al!!.add("html")
        al!!.add("c++")
        al!!.add("css")
        al!!.add("javascript")

        val cardList = listOf(
            cards("1", "https://www.nationalgeographic.com.es/medio/2022/12/12/rana-1_66a9a5c8_221212161515_1280x720.jpg", "Card 1"),
            cards("2", "https://scontent.fntr10-2.fna.fbcdn.net/v/t39.30808-6/305026074_1718759068510007_6690447974065848822_n.jpg?_nc_cat=1&ccb=1-7&_nc_sid=8bfeb9&_nc_eui2=AeEbyjSJi-NVBB3NjYjYR6J1dy7EqyA29yx3LsSrIDb3LJkVL2sDRCieGgjhvmaos5qkdt56L529qLVjjhf6-81U&_nc_ohc=QV6yjkQ2K94AX-m3gq0&_nc_ht=scontent.fntr10-2.fna&oh=00_AfDA-e3ILwOillzWbnEzPq0S-m3SVN5bQ6DDwfAjWRUFcA&oe=64113BED", "Card 2"),
            cards("3", "https://www.nationalgeographic.com.es/medio/2022/12/12/rana-1_66a9a5c8_221212161515_1280x720.jpg", "Card 3"),
            cards("4", "https://www.nationalgeographic.com.es/medio/2022/12/12/rana-1_66a9a5c8_221212161515_1280x720.jpg", "Card 4")
        ).toMutableList()


        val adapter = cardsAdapter(this, cardList)


//        arrayAdapter = ArrayAdapter(this, R.layout.item, R.id.activity_main, al!!)

        flingContainer = findViewById<SwipeFlingAdapterView>(R.id.frame)

        flingContainer.adapter = adapter
        flingContainer.setFlingListener(object : SwipeFlingAdapterView.onFlingListener {
            override fun removeFirstObjectInAdapter() {
                Log.d("LIST", "removed object!")
                cardList.removeAt(0)
                adapter.notifyDataSetChanged()
            }

            override fun onLeftCardExit(dataObject: Any) {
                Toast.makeText(this@MainActivity, "Left", Toast.LENGTH_SHORT).show()
            }

            override fun onRightCardExit(dataObject: Any) {
                Toast.makeText(this@MainActivity, "Right", Toast.LENGTH_SHORT).show()
            }

            override fun onAdapterAboutToEmpty(itemsInAdapter: Int) {
//                al!!.add("XML ".plus(i))
//                adapter!!.notifyDataSetChanged()
//                Log.d("LIST", "notified")
//                i++
            }

            override fun onScroll(scrollProgressPercent: Float) {
//                val view: View = flingContainer.getSelectedView()
//                view.findViewById<View>(R.id.item_swipe_right_indicator).alpha =
//                    if (scrollProgressPercent < 0) -scrollProgressPercent else 0f
//                view.findViewById<View>(R.id.item_swipe_left_indicator).alpha =
//                    if (scrollProgressPercent > 0) scrollProgressPercent else 0f
            }
        })

        flingContainer.setOnItemClickListener(object :
            SwipeFlingAdapterView.OnItemClickListener {
            override fun onItemClicked(itemPosition: Int, dataObject: Any) {
                Toast.makeText(this@MainActivity, "Clicked", Toast.LENGTH_SHORT).show()
            }
        })
    }
}