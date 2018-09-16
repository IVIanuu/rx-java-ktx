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

import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.CompletableSubject
import io.reactivex.subjects.MaybeSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject
import io.reactivex.subjects.SingleSubject
import io.reactivex.subjects.UnicastSubject

fun <T> AsyncSubject(): AsyncSubject<T> = AsyncSubject.create()
fun <T> BehaviorSubject(): BehaviorSubject<T> = BehaviorSubject.create()
fun <T> BehaviorSubject(default : T): BehaviorSubject<T> = BehaviorSubject.createDefault(default)
fun CompletableSubject(): CompletableSubject = CompletableSubject.create()
fun <T> MaybeSubject(): MaybeSubject<T> = MaybeSubject.create()
fun <T> PublishSubject(): PublishSubject<T> = PublishSubject.create()
fun <T> ReplaySubject(): ReplaySubject<T> = ReplaySubject.create()
fun <T> SingleSubject(): SingleSubject<T> = SingleSubject.create()
fun <T> UnicastSubject(): UnicastSubject<T> = UnicastSubject.create()