/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.gallery3d.filtershow.filters;

import com.android.gallery3d.R;

import android.graphics.Bitmap;

public class ImageFilterVibrance extends SimpleImageFilter {

    public ImageFilterVibrance() {
        mName = "Vibrance";
    }

    public FilterRepresentation getDefaultRepresentation() {
        FilterRepresentation representation = super.getDefaultRepresentation();
        representation.setName("Vibrance");
        representation.setFilterClass(ImageFilterVibrance.class);
        return representation;
    }

    @Override
    public int getButtonId() {
        return R.id.vibranceButton;
    }

    @Override
    public int getTextId() {
        return R.string.vibrance;
    }

    native protected void nativeApplyFilter(Bitmap bitmap, int w, int h, float bright);

    @Override
    public Bitmap apply(Bitmap bitmap, float scaleFactor, boolean highQuality) {
        if (getParameters() == null) {
            return bitmap;
        }
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        float value = getParameters().getValue();
        nativeApplyFilter(bitmap, w, h, value);

        return bitmap;
    }
}
