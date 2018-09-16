/*
 * Copyright 2018 Manuel Wrage
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ivianuu.rxjavaktx

import io.reactivex.Maybe
import io.reactivex.MaybeEmitter
import java.util.concurrent.Callable
import java.util.concurrent.Future

fun <T> maybe(block: (MaybeEmitter<T>) -> Unit): Maybe<T> = Maybe.create(block)

fun <T> deferredMaybe(block: () -> Maybe<T>): Maybe<T> = Maybe.defer(block)

fun <T : Any> emptyMaybe(): Maybe<T> = Maybe.empty()

fun <T> maybeOf(item: T?): Maybe<T> = item.toMaybe()

fun <T> maybeFrom(block: () -> T): Maybe<T> = Maybe.fromCallable(block)

fun <T> T?.toMaybe(): Maybe<T> = if (this != null) {
    Maybe.just(this)
} else {
    Maybe.empty<T>()
}

fun <T : Any> Future<T>.toMaybe(): Maybe<T> = Maybe.fromFuture(this)
fun <T : Any> Callable<T>.toMaybe(): Maybe<T> = Maybe.fromCallable(this)
fun <T : Any> (() -> T).toMaybe(): Maybe<T> = Maybe.fromCallable(this)
fun <T> Throwable.toMaybe(): Maybe<T> = Maybe.error(this)
@JvmName("toMaybeFromThrowable")
fun <T> (() -> Throwable).toMaybe(): Maybe<T> = Maybe.error(this)