//
//    NameMatcherFactory.java is part of SyncMyPix
//
//    Authors:
//        Neil Loknath <neil.loknath@gmail.com>
//
//    Copyright (c) 2009 Neil Loknath
//
//    SyncMyPix is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    SyncMyPix is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with SyncMyPix.  If not, see <http://www.gnu.org/licenses/>.
//
package com.nloko.android.syncmypix.namematcher;

import java.io.InputStream;

import com.nloko.android.Log;
import com.nloko.android.Utils;

import android.content.Context;

public class NameMatcherFactory {
	private static String TAG = "NameMatcherFactory";
	public static NameMatcher create(Context context, InputStream diminutives) throws Exception {
		return create(context, diminutives, false);
	}
	public static NameMatcher create(Context context, InputStream diminutives, boolean withPhone) throws Exception {
		if (Utils.determineOsVersion() >= 5) {
			Log.d(TAG, "New version found...loading version 2");
			return new NameMatcher2(context, diminutives, withPhone);
		}
		
		return new NameMatcher(context, diminutives, withPhone);
	}
}
