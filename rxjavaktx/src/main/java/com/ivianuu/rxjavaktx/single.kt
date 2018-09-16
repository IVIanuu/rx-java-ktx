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

import io.reactivex.Single
import io.reactivex.SingleEmitter
import java.util.concurrent.Callable
import java.util.concurrent.Future

fun <T> single(block: (SingleEmitter<T>) -> Unit): Single<T> = Single.create(block)

fun <T> deferredSingle(block: () -> Single<T>): Single<T> = Single.defer(block)

fun <T> singleOf(item: T) = item.toSingle()

fun <T> singleFrom(block: () -> T): Single<T> = Single.fromCallable(block)

fun <T> T.toSingle(): Single<T> = Single.just(this)

fun <T : Any> Future<T>.toSingle(): Single<T> = Single.fromFuture(this)
fun <T : Any> Callable<T>.toSingle(): Single<T> = Single.fromCallable(this)
fun <T : Any> (() -> T).toSingle(): Single<T> = Single.fromCallable(this)
fun <T> Throwable.toSingle(): Single<T> = Single.error(this)
@JvmName("toSingleFromThrowable")
fun <T> (() -> Throwable).toSingle(): Single<T> = Single.error(this)