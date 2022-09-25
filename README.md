[![License](https://img.shields.io/badge/License-Apache%202.0-orange.svg)](https://opensource.org/licenses/Apache-2.0)
[![](https://jitpack.io/v/artyommironov/anyadapter.svg)](https://jitpack.io/#artyommironov/anyadapter)

# AnyAdapter
Forget about writing RecyclerView adapters!

## Install
[How to install](https://jitpack.io/#artyommironov/anyadapter/1.0.1)

## Usage
Suppose you want to show multiple types of items in a RecyclerView, for example posts with headers and ads

### 1. Create classes extending AnyHolder for each item type
```kotlin
class PostHolder(
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

data class Post(val message: String)
```

### 2. Create AnyAdapter instance and attach holders to it
```kotlin
val adapter = AnyAdapter()
    .map { PostHolder(it, ::onPostClick) }
    .map { HeaderHolder(it) }
    .map { AdHolder(it) }

recyclerView.adapter = adapter
```

### 3. Put items inside the adapter. Done!
```kotlin
adapter.submitList(listOf("Header", Post("Hello!"), Post("Bye!"), Ad()))
```

## License
```txt
Copyright 2022 Artyom Mironov

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
