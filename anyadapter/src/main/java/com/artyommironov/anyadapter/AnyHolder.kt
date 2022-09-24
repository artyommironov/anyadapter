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

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class AnyHolder<T : Any>(view: View) : RecyclerView.ViewHolder(view) {
  protected val context: Context = view.context
  protected lateinit var currentItem: T
    private set

  constructor(
    parent: ViewGroup,
    @LayoutRes layoutId: Int
  ) : this(LayoutInflater.from(parent.context).inflate(layoutId, parent, false))

  fun onBindViewHolder(item: Any) {
    @Suppress("UNCHECKED_CAST")
    currentItem = item as T
    onBind(item)
  }

  abstract fun onBind(item: T)
  open fun onViewRecycled() {}
}
