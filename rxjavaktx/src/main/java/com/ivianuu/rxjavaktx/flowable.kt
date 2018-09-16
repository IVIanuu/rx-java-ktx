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

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter

fun <T> flowable(
    backpressureStrategy: BackpressureStrategy = BackpressureStrategy.LATEST,
    block: (FlowableEmitter<T>) -> Unit
): Flowable<T> = Flowable.create(block, backpressureStrategy)

fun <T> deferredFlowable(block: () -> Flowable<T>): Flowable<T> = Flowable.defer(block)

fun <T> emptyFlowable(): Flowable<T> = Flowable.empty()

fun <T> flowableOf(item: T): Flowable<T> = Flowable.just(item)
fun <T> flowableOf(vararg items: T): Flowable<T> = Flowable.fromIterable(items.toList())
fun <T> flowableOf(items: Iterable<T>): Flowable<T> = Flowable.fromIterable(items)

fun <T> flowableFrom(block: () -> T): Flowable<T> = Flowable.fromCallable(block)

fun <T> T.toFlowable(): Flowable<T> = Flowable.just(this)
fun <T> Throwable.toFlowable(): Flowable<T> = Flowable.error(this)
fun <T> (() -> Throwable).toFlowable(): Flowable<T> = Flowable.error(this)