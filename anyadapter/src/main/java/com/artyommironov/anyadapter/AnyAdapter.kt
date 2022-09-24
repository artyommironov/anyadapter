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

package com.artyommironov.anyadapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class AnyAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
  private val bindings = mutableListOf<Pair<Class<*>, (ViewGroup) -> AnyHolder<*>>>()
  private var differ: AsyncListDiffer<Any>? = null
  private var currentList: List<Any> = emptyList()

  private val items get() = differ?.currentList ?: currentList

  constructor(asyncDifferConfig: AsyncDifferConfig<Any>) : this() {
    differ = AsyncListDiffer(AdapterListUpdateCallback(this), asyncDifferConfig)
  }

  constructor(itemCallback: DiffUtil.ItemCallback<Any>) : this(AsyncDifferConfig.Builder(itemCallback).build())

  fun <T : Any> map(cls: Class<T>, holderCreator: (ViewGroup) -> AnyHolder<T>): AnyAdapter = apply {
    bindings.add(cls to holderCreator)
  }

  inline fun <reified T : Any> map(noinline holderCreator: (ViewGroup) -> AnyHolder<T>): AnyAdapter {
    return map(T::class.java, holderCreator)
  }

  @SuppressLint("NotifyDataSetChanged")
  fun submitList(list: List<Any>) {
    currentList = list
    differ?.submitList(list) ?: notifyDataSetChanged()
  }

  fun getItem(position: Int): Any? = items.getOrNull(position)

  override fun getItemCount(): Int = items.size

  override fun getItemViewType(position: Int): Int {
    val item = items[position]
    return bindings.indexOfFirst { (cls, _) -> cls.isInstance(item) }
  }

  override fun onCreateViewHolder(parent: ViewGroup, type: Int): RecyclerView.ViewHolder {
    return bindings[type].second(parent)
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    (holder as AnyHolder<*>).onBindViewHolder(items[position])
  }

  override fun onViewRecycled(holder: RecyclerView.ViewHolder) = (holder as AnyHolder<*>).onViewRecycled()
}
