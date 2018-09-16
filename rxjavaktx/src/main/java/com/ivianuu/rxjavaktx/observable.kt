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

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.ObservableEmitter

fun <T> observable(block: (ObservableEmitter<T>) -> Unit): Observable<T> = Observable.create(block)

fun <T> deferredObservable(block: () -> Observable<T>): Observable<T> = Observable.defer(block)

fun <T> emptyObservable(): Observable<T> = Observable.empty()

fun <T> observableOf(item: T): Observable<T> = Observable.just(item)
fun <T> observableOf(vararg items: T): Observable<T> = Observable.fromIterable(items.toList())
fun <T> observableOf(items: Iterable<T>): Observable<T> = Observable.fromIterable(items)

fun <T> observableFrom(block: () -> T): Observable<T> = Observable.fromCallable(block)

fun <T> T.toObservable(): Observable<T> = Observable.just(this)
fun <T> Throwable.toObservable(): Observable<T> = Observable.error(this)
fun <T> (() -> Throwable).toObservable(): Observable<T> = Observable.error(this)