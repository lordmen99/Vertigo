/*
 * Copyright 2016 Matthew Tamlin
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

package com.matthewtamlin.vertigo.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.Adapter;
import android.widget.AdapterView;

import static com.matthewtamlin.java_utilities.checkers.NullChecker.checkNotNull;
import static com.matthewtamlin.vertigo.library.VertigoView.State.ACTIVE;

/**
 * An AdapterView which implements the VertigoView interface.
 *
 * @param <T>
 * 		the type of adapter
 */
public abstract class VertigoAdapterView<T extends Adapter> extends AdapterView<T> implements
		VertigoView {
	/**
	 * The current Vertigo state of this view.
	 */
	private State state = ACTIVE;

	/**
	 * Constructs a new VertigoAdapterView.
	 *
	 * @param context
	 * 		the context the view is operating in
	 */
	public VertigoAdapterView(final Context context) {
		super(context);
	}

	/**
	 * Constructs a new VertigoAdapterView.
	 *
	 * @param context
	 * 		the context the view is operating in
	 * @param attrs
	 * 		configuration attributes, null allowed
	 */
	public VertigoAdapterView(final Context context, final AttributeSet attrs) {
		super(context, attrs);
	}

	/**
	 * Constructs a new VertigoAdapterView.
	 *
	 * @param context
	 * 		the context the view is operating in
	 * @param attrs
	 * 		configuration attributes, null allowed
	 * @param defStyleAttr
	 * 		an attribute in the current theme which supplies default attributes, pass 0	to ignore
	 */
	public VertigoAdapterView(final Context context, final AttributeSet attrs, final int
			defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	/**
	 * Constructs a new VertigoAdapterView.
	 *
	 * @param context
	 * 		the context the view is operating in
	 * @param attrs
	 * 		configuration attributes, null allowed
	 * @param defStyleAttr
	 * 		an attribute in the current theme which supplies default attributes, pass 0	to ignore
	 * @param defStyleRes
	 * 		a resource which supplies default attributes, only used if {@code defStyleAttr}	is 0, pass
	 * 		0 to ignore
	 */
	@RequiresApi(21) // For caller
	@TargetApi(21) // For lint
	public VertigoAdapterView(final Context context, final AttributeSet attrs, final int
			defStyleAttr, final int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}

	@Override
	public State getCurrentState() {
		return state;
	}

	@Override
	public void onStateChanged(final State state) {
		this.state = checkNotNull(state, "state cannot be null.");
	}
}