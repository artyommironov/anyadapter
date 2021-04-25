/*
 * Copyright 2021 Artyom Mironov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.artyommironov.anyadaptersample

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.artyommironov.anyadapter.AnyAdapter
import com.artyommironov.anyadapter.AnyHolder

class MainActivity : Activity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val myAdapter = AnyAdapter()
      .map { PostHolder(it, ::onPostClick) }
      .map { HeaderHolder(it) }
      .map { AdHolder(it) }
    val recyclerView = RecyclerView(this).apply {
      setBackgroundColor(Color.GRAY)
      layoutManager = LinearLayoutManager(context)
      adapter = myAdapter
    }
    setContentView(recyclerView)

    myAdapter.submitList(
      listOf("Header") + (0..100).map { Post("Post $it") }.chunked(5).flatMap { it + Ad } + "Footer"
    )
  }

  private fun onPostClick(item: Post) {
    Toast.makeText(this, "Clicked $item", Toast.LENGTH_SHORT).show()
  }

  private class HeaderHolder(parent: ViewGroup) : AnyHolder<String>(parent, R.layout.item) {
    private val textTitle = itemView.findViewById<TextView>(R.id.textTitle)

    init {
      textTitle.setBackgroundColor(Color.LTGRAY)
    }

    override fun onBind(item: String) {
      textTitle.text = item
    }
  }

  private class PostHolder(
    parent: ViewGroup,
    onClick: (Post) -> Unit
  ) : AnyHolder<Post>(parent, R.layout.item) {
    private val textTitle = itemView.findViewById<TextView>(R.id.textTitle)

    init {
      textTitle.setOnClickListener { onClick(currentItem) }
    }

    override fun onBind(item: Post) {
      textTitle.text = item.message
    }
  }

  private class AdHolder(parent: ViewGroup) : AnyHolder<Ad>(parent, R.layout.ad) {
    private val textAd = itemView.findViewById<TextView>(R.id.textAd)

    override fun onBind(item: Ad) {
      textAd.text = "Ad"
    }
  }

  data class Post(val message: String)
  object Ad
}
